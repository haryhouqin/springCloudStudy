package com.example.demo.config;

/**
 * @Author liupengfei@e6yun.com
 * @Date 2018/7/13 11:09
 * @Description
 **/
import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigChangeListener;
import com.ctrip.framework.apollo.ConfigFile;
import com.ctrip.framework.apollo.ConfigService;
import com.ctrip.framework.apollo.model.ConfigChange;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.example.demo.service.TestGatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableApolloConfig
@RefreshScope
public class AppConfig {

    @Autowired
    private TestGatewayService testGatewayService;

    @Bean
    public JavaApolloConfigBean javaConfigBean() {

        return new JavaApolloConfigBean();
    }



    @ApolloConfigChangeListener
    public void configChangeListener(ConfigChangeEvent changeEvent){
        System.out.println("发生变化11,namespace:" + changeEvent.getNamespace());
        Config config = ConfigService.getAppConfig();
        for (String key : changeEvent.changedKeys()) {
            ConfigChange change = changeEvent.getChange(key);
            if(key.indexOf("spring.cloud.gateway.routes")!=-1){
                String[] split = key.split("\\.");
                String keys = split[0]+"."+split[1]+"."+split[2]+"."+split[3];//spring.cloud.gateway.routes[0]
                String uri = keys+".uri";
                String id = keys+".id";
                String name = keys + ".predicates[0].name";
                String pattern = keys + ".predicates[0].args[\"pattern\"]";
                uri = config.getProperty(uri, change.getNewValue());
                id = config.getProperty(id, change.getNewValue());
                name = config.getProperty(name, change.getNewValue());
                pattern = config.getProperty(pattern, change.getNewValue());
                getAll(uri,id,name,pattern);
            }
            System.out.println(String.format("发现变化111 - key: %s, oldValue: %s, newValue: %s, changeType: %s", change.getPropertyName(), change.getOldValue(), change.getNewValue(), change.getChangeType()));
        }
    }


    class JavaApolloConfigBean {
    }

    public RouteDefinition getAll(String uri,String id,String name,String pattern){
        RouteDefinition definition = new RouteDefinition();
        definition.setUri(UriComponentsBuilder.fromHttpUrl(uri).build().toUri());
        definition.setId(id);
        PredicateDefinition predicate = new PredicateDefinition();
        Map<String, String> predicateParams = new HashMap<>(8);
        predicateParams.put("pattern",pattern);
        predicateParams.put("pathPattern",pattern);
        predicate.setArgs(predicateParams);
        predicate.setName(name);
        definition.setPredicates(Arrays.asList(predicate));
        testGatewayService.delete(definition);
        testGatewayService.save(definition);
        return definition;
    }
}