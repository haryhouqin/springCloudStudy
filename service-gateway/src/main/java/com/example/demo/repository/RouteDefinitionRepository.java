package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.config.GatewayProperties;
import org.springframework.cloud.gateway.route.*;
import org.springframework.cloud.gateway.support.NotFoundException;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author changyandong@e6yun.com
 * @Created Date: 2018/7/13 9:50
 * @ClassName RouteDefinitionRepository
 * @Version: 1.0
 */
@Component
public class RouteDefinitionRepository extends InMemoryRouteDefinitionRepository {
    private final Map<String, RouteDefinition> routes = Collections.synchronizedMap(new LinkedHashMap());

    @Override
    public Mono<Void> save(Mono<RouteDefinition> route) {
        return route.flatMap((r) -> {
            this.routes.put(r.getId(), r);
            return Mono.empty();
        });
    }

    public Mono<Void> delete(String routeId) {
        if (this.routes.containsKey(routeId)) {
            this.routes.remove(routeId);
            return Mono.empty();
        }
        return Mono.empty();
    }
    @Override
    public Mono<Void> delete(Mono<String> routeId) {
        routeId.flatMap((id) -> {
        delete(id);
        return Mono.empty();
        }).subscribe();
        return Mono.empty();
    }
    @Override
    public Flux<RouteDefinition> getRouteDefinitions() {
        return Flux.fromIterable(this.routes.values());
    }
}
