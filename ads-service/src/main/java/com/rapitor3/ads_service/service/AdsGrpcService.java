package com.rapitor3.ads_service.service;

import com.rapitor3.ads_service.*;
import com.rapitor3.ads_service.client.StorageClient;
import io.grpc.stub.StreamObserver;

public class AdsGrpcService extends AdvertisementsStorageGrpc.AdvertisementsStorageImplBase {

    private final StorageClient storage;


    public AdsGrpcService(StorageClient storage) {
        this.storage = storage;
    }

    @Override
    public void createAdvertisement(CreateAdvertisementRequest req,
                                    StreamObserver<CreateAdvertisementResponse> response) {
        long id = storage.createAd(
                req.getTitle(), req.getDescription(), req.getPrice(), req.getCurrency(), req.getCategoryId(), req.getUserId()
        );
        response.onNext(CreateAdvertisementResponse.newBuilder().setId(id).build());
        response.onCompleted();
    }

    @Override
    public void getAdvertisementById(GetAdvertisementByIdRequest req,
                                     StreamObserver<GetAdvertisementByIdResponse> response) {
        response.onNext(GetAdvertisementByIdResponse.newBuilder()
                .setAdvertisement(storage.getById(req.getId()))
                .build());
        response.onCompleted();
    }

    @Override
    public void getAllAdvertisements(GetAllAdvertisementsRequest req,
                                     StreamObserver<GetAllAdvertisementsResponse> response) {
        response.onNext(GetAllAdvertisementsResponse.newBuilder()
                .addAllAdvertisements(storage.getAll())
                .build());
        response.onCompleted();
    }

    @Override
    public void updateAdvertisementById(UpdateAdvertisementByIdRequest req,
                                        StreamObserver<UpdateAdvertisementByIdResponse> response) {
        response.onNext(UpdateAdvertisementByIdResponse.newBuilder()
                .setAdvertisement(storage.update(req.getId(), req.getTitle(), req.getDescription(), req.getPrice(), req.getCurrency(), req.getCategoryId()))
                .build());
        response.onCompleted();
    }

    @Override
    public void deleteAdvertisementByID(DeleteAdvertisementByIDRequest req,
                                        StreamObserver<DeleteAdvertisementByIDResponse> response) {
        storage.delete(req.getId());
        response.onNext(DeleteAdvertisementByIDResponse.newBuilder().build());
        response.onCompleted();
    }

    @Override
    public void searchAdvertisementByTitle(SearchAdvertisementByTitleRequest req,
                                           StreamObserver<SearchAdvertisementByTitleResponse> response) {
        response.onNext(SearchAdvertisementByTitleResponse.newBuilder()
                .addAllAdvertisement(storage.search(req.getTitle()))
                .build());
        response.onCompleted();
    }
}
