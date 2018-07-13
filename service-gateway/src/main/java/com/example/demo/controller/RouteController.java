package com.example.demo.controller;

import com.example.demo.repository.RouteDefinitionRepository;
import com.example.demo.service.TestGatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.MonoSink;

import java.net.URI;
import java.util.*;
import java.util.function.Consumer;

/**
 * @Description
 * @Author changyandong@e6yun.com
 * @Created Date: 2018/7/12 11:24
 * @ClassName RouteController
 * @Version: 1.0
 */
@RestController
public class RouteController {

    @Autowired
    private TestGatewayService testGatewayService;
    @Autowired
    private RouteLocator r;
    @Autowired
    private RouteDefinitionRepository routeDefinitionRepository;

  /*  @Value("${spring.cloud.gateway.routes.id}")
    private String id;
    @Value("${spring.cloud.gateway.routes.predicates}")
    private String predicates;
    @Value("${spring.cloud.gateway.routes.uri}")
    private String uri;*/

   private String h;

   @RequestMapping("/h")
   public String h(){
       return h;
   }
  /*  @Autowired
    private RedisRouteDefinitionRepository redisRouteDefinitionRepository;*/

    @RequestMapping("/route")
    public RouteDefinition route(RouteDefinition definition){
       // Consumer<MonoSink<RouteDefinition>> monoSinkConsumer =
/*        Mono<RouteDefinition> mono = Mono.just(definition.getId());
        redisRouteDefinitionRepository.delete(Mono.just(definition.getId()));
        redisRouteDefinitionRepository.save(mono);*/
      /*  Mono<RouteDefinition> mono =
        redisRouteDefinitionRepository.save();*/
       // URI uri = UriComponentsBuilder.fromHttpUrl(definition.getUri().toString()).build().toUri();
        //definition.setUri(uri);
        routeDefinitionRepository.delete(Mono.just(definition.getId()));
       // testGatewayService.delete(definition);
       // testGatewayService.save(definition);
        return definition;
    }

    @RequestMapping("/route2")
    public RouteDefinition route2(RouteDefinition definition){
        // Consumer<MonoSink<RouteDefinition>> monoSinkConsumer =
/*        Mono<RouteDefinition> mono = Mono.just(definition);
        redisRouteDefinitionRepository.delete(Mono.just(definition.getId()));
        redisRouteDefinitionRepository.save(mono);*/
      /*  Mono<RouteDefinition> mono =
        redisRouteDefinitionRepository.save();*/
        // URI uri = UriComponentsBuilder.fromHttpUrl(definition.getUri().toString()).build().toUri();
        //definition.setUri(uri);
        //testGatewayService.delete(definition);
        testGatewayService.save(definition);
        return definition;
    }

    @RequestMapping("/test")
    public String test(){
        Flux<Route> routes = r.getRoutes();
        Mono<Route> rs = null;
        while((rs = routes.next()) != null ){
            System.out.println(rs);
        }
        routes.next();
        return "suc";
    }

   /* @RequestMapping("/get")*/
   /* public RouteDefinition getAll(){
        RouteDefinition definition = new RouteDefinition();
        definition.setUri(UriComponentsBuilder.fromHttpUrl(uri).build().toUri());
        definition.setId(id);
        PredicateDefinition predicate = new PredicateDefinition();
        Map<String, String> predicateParams = new HashMap<>(8);
        String[] split = predicates.split("=");
        predicateParams.put("pattern",split[1]);
        predicateParams.put("pathPattern",split[1]);
        predicate.setArgs(predicateParams);
        predicate.setName("Path");
        definition.setPredicates(Arrays.asList(predicate));
        testGatewayService.delete(definition);
        testGatewayService.save(definition);
        return definition;
    }*/
}
