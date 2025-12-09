package com.rapitor3.ads_service.config;

import com.rapitor3.ads_service.AdvertisementsStorageGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.rapitor3.ads_service.client.StorageClient;

@Configuration
public class StorageClientConfig {

    @Value("${storage.host}")
    private String storageAddr;

    @Bean
    public ManagedChannel grpcChannel() {
        return ManagedChannelBuilder
                .forTarget(storageAddr)
                .usePlaintext()
                .build();
    }

    @Bean
    public StorageClient storageClient(ManagedChannel channel) {
        return new StorageClient(
                AdvertisementsStorageGrpc.newBlockingStub(channel).toString()
        );
    }
}

