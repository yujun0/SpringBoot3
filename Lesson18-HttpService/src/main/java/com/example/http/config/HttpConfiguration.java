package com.example.http.config;

import com.example.http.service.AlbumService;
import com.example.http.service.TodoService;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

@Configuration(proxyBeanMethods = false)
public class HttpConfiguration {

    // 創建服務介面的代理物件，基於 WebClient
    @Bean
    public TodoService requestService() {
        WebClient webClient = WebClient.builder().baseUrl("https://jsonplaceholder.typicode.com").build();
        // 創建代理工廠
        HttpServiceProxyFactory proxyFactory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(webClient)).build();
        // 創建某個介面的代理服務
        return proxyFactory.createClient(TodoService.class);
    }

//    // 創建代理
//    @Bean
//    public AlbumService albumService() {
//        WebClient webClient = WebClient.create();
//        HttpServiceProxyFactory proxyFactory = HttpServiceProxyFactory
//                .builder(WebClientAdapter.forClient(webClient)).build();
//
//        return proxyFactory.createClient(AlbumService.class);
//    }

    // 訂製 Http 服務
    @Bean
    public AlbumService albumService() {
        // 超時
        HttpClient httpClient = HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 3000) // 連接時間
                .doOnConnected(connection -> {
                    connection.addHandlerLast(new ReadTimeoutHandler(10)); // 讀超時
                    connection.addHandlerLast(new WriteTimeoutHandler(10)); // 寫超時
                });
        // 設置異常
        WebClient webClient = WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .defaultStatusHandler(HttpStatusCode::isError, clientResponse -> {
                    System.out.println("*********WebClient請求異常*********");
                    return Mono.error(new RuntimeException("請求異常： " + clientResponse.statusCode().value()));
                }).build();

        HttpServiceProxyFactory proxyFactory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(webClient)).build();

        return proxyFactory.createClient(AlbumService.class);
    }

}

