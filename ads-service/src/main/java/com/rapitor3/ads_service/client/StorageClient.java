package com.rapitor3.ads_service.client;


import com.rapitor3.ads_service.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.List;

public class StorageClient {


    private final ManagedChannel channel;

    private final AdvertisementsStorageGrpc.AdvertisementsStorageBlockingStub client;


    public StorageClient(String addr) {

        this.channel = ManagedChannelBuilder.forTarget(addr).usePlaintext().build();
        this.client = AdvertisementsStorageGrpc.newBlockingStub(channel);

    }

    public long createAd(String title, String description, double price, String currency, long category_id, long user_id) {

        CreateAdvertisementRequest request = CreateAdvertisementRequest.newBuilder()
                .setTitle(title)
                .setPrice(price)
                .setCurrency(currency)
                .setCategoryId(category_id)
                .setUserId(user_id)
                .build();


        return client.createAdvertisement(request).getId();
    }

    public Advertisement getById(long id) {
        return client.getAdvertisementById(
                GetAdvertisementByIdRequest.newBuilder().setId(id).build()
        ).getAdvertisement();
    }

    public List<Advertisement> getAll() {
        return client.getAllAdvertisements(
                GetAllAdvertisementsRequest.newBuilder().build()
        ).getAdvertisementsList();
    }

    public Advertisement update(long id, String title, String desc, double price, String currency, long categoryId) {
        return client.updateAdvertisementById(
                UpdateAdvertisementByIdRequest.newBuilder()
                        .setId(id)
                        .setTitle(title)
                        .setDescription(desc)
                        .setPrice(price)
                        .setCurrency(currency)
                        .setCategoryId(categoryId)
                        .build()
        ).getAdvertisement();
    }

    public void delete(long id) {
        client.deleteAdvertisementByID(
                DeleteAdvertisementByIDRequest.newBuilder().setId(id).build()
        );
    }

    public List<Advertisement> search(String title) {
        return client.searchAdvertisementByTitle(
                SearchAdvertisementByTitleRequest.newBuilder().setTitle(title).build()
        ).getAdvertisementList();
    }

    public void close() {
        channel.shutdown();
    }

}
