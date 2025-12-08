package com.rapitor3.ads_service.server;

import org.springframework.beans.factory.annotation.Value;
import com.rapitor3.ads_service.client.StorageClient;
import com.rapitor3.ads_service.config.StorageProperties;
import com.rapitor3.ads_service.service.AdsGrpcService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!test")
@RequiredArgsConstructor
public class GrpcServerRunner {

    private final StorageProperties props;

    @Value("${server.port}")
    private int servicePort;

    private Server server;

    @PostConstruct
    public void start() throws Exception {

        StorageClient storageClient = new StorageClient(props.getAddr());

        server = ServerBuilder.forPort(servicePort)
                .addService(new AdsGrpcService(storageClient))
                .build()
                .start();

        System.out.println("Ads-service gRPC started at :" + servicePort);
        System.out.println("Connected to STORAGE → " + props.getAddr());
    }
}