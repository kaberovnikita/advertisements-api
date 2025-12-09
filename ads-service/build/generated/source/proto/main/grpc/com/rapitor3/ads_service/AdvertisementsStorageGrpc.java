package com.rapitor3.ads_service;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.62.2)",
    comments = "Source: advertisements_storage.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AdvertisementsStorageGrpc {

  private AdvertisementsStorageGrpc() {}

  public static final java.lang.String SERVICE_NAME = "advertisements_storage.AdvertisementsStorage";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.rapitor3.ads_service.CreateAdvertisementRequest,
      com.rapitor3.ads_service.CreateAdvertisementResponse> getCreateAdvertisementMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAdvertisement",
      requestType = com.rapitor3.ads_service.CreateAdvertisementRequest.class,
      responseType = com.rapitor3.ads_service.CreateAdvertisementResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.rapitor3.ads_service.CreateAdvertisementRequest,
      com.rapitor3.ads_service.CreateAdvertisementResponse> getCreateAdvertisementMethod() {
    io.grpc.MethodDescriptor<com.rapitor3.ads_service.CreateAdvertisementRequest, com.rapitor3.ads_service.CreateAdvertisementResponse> getCreateAdvertisementMethod;
    if ((getCreateAdvertisementMethod = AdvertisementsStorageGrpc.getCreateAdvertisementMethod) == null) {
      synchronized (AdvertisementsStorageGrpc.class) {
        if ((getCreateAdvertisementMethod = AdvertisementsStorageGrpc.getCreateAdvertisementMethod) == null) {
          AdvertisementsStorageGrpc.getCreateAdvertisementMethod = getCreateAdvertisementMethod =
              io.grpc.MethodDescriptor.<com.rapitor3.ads_service.CreateAdvertisementRequest, com.rapitor3.ads_service.CreateAdvertisementResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateAdvertisement"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rapitor3.ads_service.CreateAdvertisementRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rapitor3.ads_service.CreateAdvertisementResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AdvertisementsStorageMethodDescriptorSupplier("CreateAdvertisement"))
              .build();
        }
      }
    }
    return getCreateAdvertisementMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.rapitor3.ads_service.GetAdvertisementByIdRequest,
      com.rapitor3.ads_service.GetAdvertisementByIdResponse> getGetAdvertisementByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAdvertisementById",
      requestType = com.rapitor3.ads_service.GetAdvertisementByIdRequest.class,
      responseType = com.rapitor3.ads_service.GetAdvertisementByIdResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.rapitor3.ads_service.GetAdvertisementByIdRequest,
      com.rapitor3.ads_service.GetAdvertisementByIdResponse> getGetAdvertisementByIdMethod() {
    io.grpc.MethodDescriptor<com.rapitor3.ads_service.GetAdvertisementByIdRequest, com.rapitor3.ads_service.GetAdvertisementByIdResponse> getGetAdvertisementByIdMethod;
    if ((getGetAdvertisementByIdMethod = AdvertisementsStorageGrpc.getGetAdvertisementByIdMethod) == null) {
      synchronized (AdvertisementsStorageGrpc.class) {
        if ((getGetAdvertisementByIdMethod = AdvertisementsStorageGrpc.getGetAdvertisementByIdMethod) == null) {
          AdvertisementsStorageGrpc.getGetAdvertisementByIdMethod = getGetAdvertisementByIdMethod =
              io.grpc.MethodDescriptor.<com.rapitor3.ads_service.GetAdvertisementByIdRequest, com.rapitor3.ads_service.GetAdvertisementByIdResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAdvertisementById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rapitor3.ads_service.GetAdvertisementByIdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rapitor3.ads_service.GetAdvertisementByIdResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AdvertisementsStorageMethodDescriptorSupplier("GetAdvertisementById"))
              .build();
        }
      }
    }
    return getGetAdvertisementByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.rapitor3.ads_service.GetAllAdvertisementsRequest,
      com.rapitor3.ads_service.GetAllAdvertisementsResponse> getGetAllAdvertisementsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAllAdvertisements",
      requestType = com.rapitor3.ads_service.GetAllAdvertisementsRequest.class,
      responseType = com.rapitor3.ads_service.GetAllAdvertisementsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.rapitor3.ads_service.GetAllAdvertisementsRequest,
      com.rapitor3.ads_service.GetAllAdvertisementsResponse> getGetAllAdvertisementsMethod() {
    io.grpc.MethodDescriptor<com.rapitor3.ads_service.GetAllAdvertisementsRequest, com.rapitor3.ads_service.GetAllAdvertisementsResponse> getGetAllAdvertisementsMethod;
    if ((getGetAllAdvertisementsMethod = AdvertisementsStorageGrpc.getGetAllAdvertisementsMethod) == null) {
      synchronized (AdvertisementsStorageGrpc.class) {
        if ((getGetAllAdvertisementsMethod = AdvertisementsStorageGrpc.getGetAllAdvertisementsMethod) == null) {
          AdvertisementsStorageGrpc.getGetAllAdvertisementsMethod = getGetAllAdvertisementsMethod =
              io.grpc.MethodDescriptor.<com.rapitor3.ads_service.GetAllAdvertisementsRequest, com.rapitor3.ads_service.GetAllAdvertisementsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAllAdvertisements"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rapitor3.ads_service.GetAllAdvertisementsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rapitor3.ads_service.GetAllAdvertisementsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AdvertisementsStorageMethodDescriptorSupplier("GetAllAdvertisements"))
              .build();
        }
      }
    }
    return getGetAllAdvertisementsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.rapitor3.ads_service.UpdateAdvertisementByIdRequest,
      com.rapitor3.ads_service.UpdateAdvertisementByIdResponse> getUpdateAdvertisementByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAdvertisementById",
      requestType = com.rapitor3.ads_service.UpdateAdvertisementByIdRequest.class,
      responseType = com.rapitor3.ads_service.UpdateAdvertisementByIdResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.rapitor3.ads_service.UpdateAdvertisementByIdRequest,
      com.rapitor3.ads_service.UpdateAdvertisementByIdResponse> getUpdateAdvertisementByIdMethod() {
    io.grpc.MethodDescriptor<com.rapitor3.ads_service.UpdateAdvertisementByIdRequest, com.rapitor3.ads_service.UpdateAdvertisementByIdResponse> getUpdateAdvertisementByIdMethod;
    if ((getUpdateAdvertisementByIdMethod = AdvertisementsStorageGrpc.getUpdateAdvertisementByIdMethod) == null) {
      synchronized (AdvertisementsStorageGrpc.class) {
        if ((getUpdateAdvertisementByIdMethod = AdvertisementsStorageGrpc.getUpdateAdvertisementByIdMethod) == null) {
          AdvertisementsStorageGrpc.getUpdateAdvertisementByIdMethod = getUpdateAdvertisementByIdMethod =
              io.grpc.MethodDescriptor.<com.rapitor3.ads_service.UpdateAdvertisementByIdRequest, com.rapitor3.ads_service.UpdateAdvertisementByIdResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateAdvertisementById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rapitor3.ads_service.UpdateAdvertisementByIdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rapitor3.ads_service.UpdateAdvertisementByIdResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AdvertisementsStorageMethodDescriptorSupplier("UpdateAdvertisementById"))
              .build();
        }
      }
    }
    return getUpdateAdvertisementByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.rapitor3.ads_service.DeleteAdvertisementByIDRequest,
      com.rapitor3.ads_service.DeleteAdvertisementByIDResponse> getDeleteAdvertisementByIDMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAdvertisementByID",
      requestType = com.rapitor3.ads_service.DeleteAdvertisementByIDRequest.class,
      responseType = com.rapitor3.ads_service.DeleteAdvertisementByIDResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.rapitor3.ads_service.DeleteAdvertisementByIDRequest,
      com.rapitor3.ads_service.DeleteAdvertisementByIDResponse> getDeleteAdvertisementByIDMethod() {
    io.grpc.MethodDescriptor<com.rapitor3.ads_service.DeleteAdvertisementByIDRequest, com.rapitor3.ads_service.DeleteAdvertisementByIDResponse> getDeleteAdvertisementByIDMethod;
    if ((getDeleteAdvertisementByIDMethod = AdvertisementsStorageGrpc.getDeleteAdvertisementByIDMethod) == null) {
      synchronized (AdvertisementsStorageGrpc.class) {
        if ((getDeleteAdvertisementByIDMethod = AdvertisementsStorageGrpc.getDeleteAdvertisementByIDMethod) == null) {
          AdvertisementsStorageGrpc.getDeleteAdvertisementByIDMethod = getDeleteAdvertisementByIDMethod =
              io.grpc.MethodDescriptor.<com.rapitor3.ads_service.DeleteAdvertisementByIDRequest, com.rapitor3.ads_service.DeleteAdvertisementByIDResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteAdvertisementByID"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rapitor3.ads_service.DeleteAdvertisementByIDRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rapitor3.ads_service.DeleteAdvertisementByIDResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AdvertisementsStorageMethodDescriptorSupplier("DeleteAdvertisementByID"))
              .build();
        }
      }
    }
    return getDeleteAdvertisementByIDMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.rapitor3.ads_service.CreateCategoryRequest,
      com.rapitor3.ads_service.CreateCategoryResponse> getCreateCategoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCategory",
      requestType = com.rapitor3.ads_service.CreateCategoryRequest.class,
      responseType = com.rapitor3.ads_service.CreateCategoryResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.rapitor3.ads_service.CreateCategoryRequest,
      com.rapitor3.ads_service.CreateCategoryResponse> getCreateCategoryMethod() {
    io.grpc.MethodDescriptor<com.rapitor3.ads_service.CreateCategoryRequest, com.rapitor3.ads_service.CreateCategoryResponse> getCreateCategoryMethod;
    if ((getCreateCategoryMethod = AdvertisementsStorageGrpc.getCreateCategoryMethod) == null) {
      synchronized (AdvertisementsStorageGrpc.class) {
        if ((getCreateCategoryMethod = AdvertisementsStorageGrpc.getCreateCategoryMethod) == null) {
          AdvertisementsStorageGrpc.getCreateCategoryMethod = getCreateCategoryMethod =
              io.grpc.MethodDescriptor.<com.rapitor3.ads_service.CreateCategoryRequest, com.rapitor3.ads_service.CreateCategoryResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateCategory"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rapitor3.ads_service.CreateCategoryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rapitor3.ads_service.CreateCategoryResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AdvertisementsStorageMethodDescriptorSupplier("CreateCategory"))
              .build();
        }
      }
    }
    return getCreateCategoryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.rapitor3.ads_service.GetCategoryByIdRequest,
      com.rapitor3.ads_service.GetCategoryByIdResponse> getGetCategoryByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCategoryById",
      requestType = com.rapitor3.ads_service.GetCategoryByIdRequest.class,
      responseType = com.rapitor3.ads_service.GetCategoryByIdResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.rapitor3.ads_service.GetCategoryByIdRequest,
      com.rapitor3.ads_service.GetCategoryByIdResponse> getGetCategoryByIdMethod() {
    io.grpc.MethodDescriptor<com.rapitor3.ads_service.GetCategoryByIdRequest, com.rapitor3.ads_service.GetCategoryByIdResponse> getGetCategoryByIdMethod;
    if ((getGetCategoryByIdMethod = AdvertisementsStorageGrpc.getGetCategoryByIdMethod) == null) {
      synchronized (AdvertisementsStorageGrpc.class) {
        if ((getGetCategoryByIdMethod = AdvertisementsStorageGrpc.getGetCategoryByIdMethod) == null) {
          AdvertisementsStorageGrpc.getGetCategoryByIdMethod = getGetCategoryByIdMethod =
              io.grpc.MethodDescriptor.<com.rapitor3.ads_service.GetCategoryByIdRequest, com.rapitor3.ads_service.GetCategoryByIdResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCategoryById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rapitor3.ads_service.GetCategoryByIdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rapitor3.ads_service.GetCategoryByIdResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AdvertisementsStorageMethodDescriptorSupplier("GetCategoryById"))
              .build();
        }
      }
    }
    return getGetCategoryByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.rapitor3.ads_service.GetCategoryByAliasRequest,
      com.rapitor3.ads_service.GetCategoryByAliasResponse> getGetCategoryByAliasMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCategoryByAlias",
      requestType = com.rapitor3.ads_service.GetCategoryByAliasRequest.class,
      responseType = com.rapitor3.ads_service.GetCategoryByAliasResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.rapitor3.ads_service.GetCategoryByAliasRequest,
      com.rapitor3.ads_service.GetCategoryByAliasResponse> getGetCategoryByAliasMethod() {
    io.grpc.MethodDescriptor<com.rapitor3.ads_service.GetCategoryByAliasRequest, com.rapitor3.ads_service.GetCategoryByAliasResponse> getGetCategoryByAliasMethod;
    if ((getGetCategoryByAliasMethod = AdvertisementsStorageGrpc.getGetCategoryByAliasMethod) == null) {
      synchronized (AdvertisementsStorageGrpc.class) {
        if ((getGetCategoryByAliasMethod = AdvertisementsStorageGrpc.getGetCategoryByAliasMethod) == null) {
          AdvertisementsStorageGrpc.getGetCategoryByAliasMethod = getGetCategoryByAliasMethod =
              io.grpc.MethodDescriptor.<com.rapitor3.ads_service.GetCategoryByAliasRequest, com.rapitor3.ads_service.GetCategoryByAliasResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCategoryByAlias"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rapitor3.ads_service.GetCategoryByAliasRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rapitor3.ads_service.GetCategoryByAliasResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AdvertisementsStorageMethodDescriptorSupplier("GetCategoryByAlias"))
              .build();
        }
      }
    }
    return getGetCategoryByAliasMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.rapitor3.ads_service.GetAllCategoriesRequest,
      com.rapitor3.ads_service.GetAllCategoriesResponse> getGetAllCategoriesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAllCategories",
      requestType = com.rapitor3.ads_service.GetAllCategoriesRequest.class,
      responseType = com.rapitor3.ads_service.GetAllCategoriesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.rapitor3.ads_service.GetAllCategoriesRequest,
      com.rapitor3.ads_service.GetAllCategoriesResponse> getGetAllCategoriesMethod() {
    io.grpc.MethodDescriptor<com.rapitor3.ads_service.GetAllCategoriesRequest, com.rapitor3.ads_service.GetAllCategoriesResponse> getGetAllCategoriesMethod;
    if ((getGetAllCategoriesMethod = AdvertisementsStorageGrpc.getGetAllCategoriesMethod) == null) {
      synchronized (AdvertisementsStorageGrpc.class) {
        if ((getGetAllCategoriesMethod = AdvertisementsStorageGrpc.getGetAllCategoriesMethod) == null) {
          AdvertisementsStorageGrpc.getGetAllCategoriesMethod = getGetAllCategoriesMethod =
              io.grpc.MethodDescriptor.<com.rapitor3.ads_service.GetAllCategoriesRequest, com.rapitor3.ads_service.GetAllCategoriesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAllCategories"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rapitor3.ads_service.GetAllCategoriesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rapitor3.ads_service.GetAllCategoriesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AdvertisementsStorageMethodDescriptorSupplier("GetAllCategories"))
              .build();
        }
      }
    }
    return getGetAllCategoriesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.rapitor3.ads_service.UpdateCategoryByIdRequest,
      com.rapitor3.ads_service.UpdateCategoryByIdResponse> getUpdateCategoryByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCategoryById",
      requestType = com.rapitor3.ads_service.UpdateCategoryByIdRequest.class,
      responseType = com.rapitor3.ads_service.UpdateCategoryByIdResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.rapitor3.ads_service.UpdateCategoryByIdRequest,
      com.rapitor3.ads_service.UpdateCategoryByIdResponse> getUpdateCategoryByIdMethod() {
    io.grpc.MethodDescriptor<com.rapitor3.ads_service.UpdateCategoryByIdRequest, com.rapitor3.ads_service.UpdateCategoryByIdResponse> getUpdateCategoryByIdMethod;
    if ((getUpdateCategoryByIdMethod = AdvertisementsStorageGrpc.getUpdateCategoryByIdMethod) == null) {
      synchronized (AdvertisementsStorageGrpc.class) {
        if ((getUpdateCategoryByIdMethod = AdvertisementsStorageGrpc.getUpdateCategoryByIdMethod) == null) {
          AdvertisementsStorageGrpc.getUpdateCategoryByIdMethod = getUpdateCategoryByIdMethod =
              io.grpc.MethodDescriptor.<com.rapitor3.ads_service.UpdateCategoryByIdRequest, com.rapitor3.ads_service.UpdateCategoryByIdResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateCategoryById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rapitor3.ads_service.UpdateCategoryByIdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rapitor3.ads_service.UpdateCategoryByIdResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AdvertisementsStorageMethodDescriptorSupplier("UpdateCategoryById"))
              .build();
        }
      }
    }
    return getUpdateCategoryByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.rapitor3.ads_service.DeleteCategoryByIDRequest,
      com.rapitor3.ads_service.DeleteCategoryByIDResponse> getDeleteCategoryByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteCategoryById",
      requestType = com.rapitor3.ads_service.DeleteCategoryByIDRequest.class,
      responseType = com.rapitor3.ads_service.DeleteCategoryByIDResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.rapitor3.ads_service.DeleteCategoryByIDRequest,
      com.rapitor3.ads_service.DeleteCategoryByIDResponse> getDeleteCategoryByIdMethod() {
    io.grpc.MethodDescriptor<com.rapitor3.ads_service.DeleteCategoryByIDRequest, com.rapitor3.ads_service.DeleteCategoryByIDResponse> getDeleteCategoryByIdMethod;
    if ((getDeleteCategoryByIdMethod = AdvertisementsStorageGrpc.getDeleteCategoryByIdMethod) == null) {
      synchronized (AdvertisementsStorageGrpc.class) {
        if ((getDeleteCategoryByIdMethod = AdvertisementsStorageGrpc.getDeleteCategoryByIdMethod) == null) {
          AdvertisementsStorageGrpc.getDeleteCategoryByIdMethod = getDeleteCategoryByIdMethod =
              io.grpc.MethodDescriptor.<com.rapitor3.ads_service.DeleteCategoryByIDRequest, com.rapitor3.ads_service.DeleteCategoryByIDResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteCategoryById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rapitor3.ads_service.DeleteCategoryByIDRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rapitor3.ads_service.DeleteCategoryByIDResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AdvertisementsStorageMethodDescriptorSupplier("DeleteCategoryById"))
              .build();
        }
      }
    }
    return getDeleteCategoryByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.rapitor3.ads_service.RegisterUserRequest,
      com.rapitor3.ads_service.RegisterUserResponse> getRegisterUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RegisterUser",
      requestType = com.rapitor3.ads_service.RegisterUserRequest.class,
      responseType = com.rapitor3.ads_service.RegisterUserResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.rapitor3.ads_service.RegisterUserRequest,
      com.rapitor3.ads_service.RegisterUserResponse> getRegisterUserMethod() {
    io.grpc.MethodDescriptor<com.rapitor3.ads_service.RegisterUserRequest, com.rapitor3.ads_service.RegisterUserResponse> getRegisterUserMethod;
    if ((getRegisterUserMethod = AdvertisementsStorageGrpc.getRegisterUserMethod) == null) {
      synchronized (AdvertisementsStorageGrpc.class) {
        if ((getRegisterUserMethod = AdvertisementsStorageGrpc.getRegisterUserMethod) == null) {
          AdvertisementsStorageGrpc.getRegisterUserMethod = getRegisterUserMethod =
              io.grpc.MethodDescriptor.<com.rapitor3.ads_service.RegisterUserRequest, com.rapitor3.ads_service.RegisterUserResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RegisterUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rapitor3.ads_service.RegisterUserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rapitor3.ads_service.RegisterUserResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AdvertisementsStorageMethodDescriptorSupplier("RegisterUser"))
              .build();
        }
      }
    }
    return getRegisterUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.rapitor3.ads_service.LoginUserRequest,
      com.rapitor3.ads_service.LoginUserResponse> getLoginUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LoginUser",
      requestType = com.rapitor3.ads_service.LoginUserRequest.class,
      responseType = com.rapitor3.ads_service.LoginUserResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.rapitor3.ads_service.LoginUserRequest,
      com.rapitor3.ads_service.LoginUserResponse> getLoginUserMethod() {
    io.grpc.MethodDescriptor<com.rapitor3.ads_service.LoginUserRequest, com.rapitor3.ads_service.LoginUserResponse> getLoginUserMethod;
    if ((getLoginUserMethod = AdvertisementsStorageGrpc.getLoginUserMethod) == null) {
      synchronized (AdvertisementsStorageGrpc.class) {
        if ((getLoginUserMethod = AdvertisementsStorageGrpc.getLoginUserMethod) == null) {
          AdvertisementsStorageGrpc.getLoginUserMethod = getLoginUserMethod =
              io.grpc.MethodDescriptor.<com.rapitor3.ads_service.LoginUserRequest, com.rapitor3.ads_service.LoginUserResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LoginUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rapitor3.ads_service.LoginUserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rapitor3.ads_service.LoginUserResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AdvertisementsStorageMethodDescriptorSupplier("LoginUser"))
              .build();
        }
      }
    }
    return getLoginUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.rapitor3.ads_service.GetAllUsersRequest,
      com.rapitor3.ads_service.GetAllUsersResponse> getGetAllUsersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAllUsers",
      requestType = com.rapitor3.ads_service.GetAllUsersRequest.class,
      responseType = com.rapitor3.ads_service.GetAllUsersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.rapitor3.ads_service.GetAllUsersRequest,
      com.rapitor3.ads_service.GetAllUsersResponse> getGetAllUsersMethod() {
    io.grpc.MethodDescriptor<com.rapitor3.ads_service.GetAllUsersRequest, com.rapitor3.ads_service.GetAllUsersResponse> getGetAllUsersMethod;
    if ((getGetAllUsersMethod = AdvertisementsStorageGrpc.getGetAllUsersMethod) == null) {
      synchronized (AdvertisementsStorageGrpc.class) {
        if ((getGetAllUsersMethod = AdvertisementsStorageGrpc.getGetAllUsersMethod) == null) {
          AdvertisementsStorageGrpc.getGetAllUsersMethod = getGetAllUsersMethod =
              io.grpc.MethodDescriptor.<com.rapitor3.ads_service.GetAllUsersRequest, com.rapitor3.ads_service.GetAllUsersResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAllUsers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rapitor3.ads_service.GetAllUsersRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rapitor3.ads_service.GetAllUsersResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AdvertisementsStorageMethodDescriptorSupplier("GetAllUsers"))
              .build();
        }
      }
    }
    return getGetAllUsersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.rapitor3.ads_service.GetUserByIDRequest,
      com.rapitor3.ads_service.GetUserByIdResponse> getGetUserByIDMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetUserByID",
      requestType = com.rapitor3.ads_service.GetUserByIDRequest.class,
      responseType = com.rapitor3.ads_service.GetUserByIdResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.rapitor3.ads_service.GetUserByIDRequest,
      com.rapitor3.ads_service.GetUserByIdResponse> getGetUserByIDMethod() {
    io.grpc.MethodDescriptor<com.rapitor3.ads_service.GetUserByIDRequest, com.rapitor3.ads_service.GetUserByIdResponse> getGetUserByIDMethod;
    if ((getGetUserByIDMethod = AdvertisementsStorageGrpc.getGetUserByIDMethod) == null) {
      synchronized (AdvertisementsStorageGrpc.class) {
        if ((getGetUserByIDMethod = AdvertisementsStorageGrpc.getGetUserByIDMethod) == null) {
          AdvertisementsStorageGrpc.getGetUserByIDMethod = getGetUserByIDMethod =
              io.grpc.MethodDescriptor.<com.rapitor3.ads_service.GetUserByIDRequest, com.rapitor3.ads_service.GetUserByIdResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetUserByID"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rapitor3.ads_service.GetUserByIDRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rapitor3.ads_service.GetUserByIdResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AdvertisementsStorageMethodDescriptorSupplier("GetUserByID"))
              .build();
        }
      }
    }
    return getGetUserByIDMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.rapitor3.ads_service.GetUserByEmailRequest,
      com.rapitor3.ads_service.GetUserByEmailResponse> getGetUserByEmailMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetUserByEmail",
      requestType = com.rapitor3.ads_service.GetUserByEmailRequest.class,
      responseType = com.rapitor3.ads_service.GetUserByEmailResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.rapitor3.ads_service.GetUserByEmailRequest,
      com.rapitor3.ads_service.GetUserByEmailResponse> getGetUserByEmailMethod() {
    io.grpc.MethodDescriptor<com.rapitor3.ads_service.GetUserByEmailRequest, com.rapitor3.ads_service.GetUserByEmailResponse> getGetUserByEmailMethod;
    if ((getGetUserByEmailMethod = AdvertisementsStorageGrpc.getGetUserByEmailMethod) == null) {
      synchronized (AdvertisementsStorageGrpc.class) {
        if ((getGetUserByEmailMethod = AdvertisementsStorageGrpc.getGetUserByEmailMethod) == null) {
          AdvertisementsStorageGrpc.getGetUserByEmailMethod = getGetUserByEmailMethod =
              io.grpc.MethodDescriptor.<com.rapitor3.ads_service.GetUserByEmailRequest, com.rapitor3.ads_service.GetUserByEmailResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetUserByEmail"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rapitor3.ads_service.GetUserByEmailRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rapitor3.ads_service.GetUserByEmailResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AdvertisementsStorageMethodDescriptorSupplier("GetUserByEmail"))
              .build();
        }
      }
    }
    return getGetUserByEmailMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.rapitor3.ads_service.UpdateUserByIdRequest,
      com.rapitor3.ads_service.UpdateUserByIdResponse> getUpdateUserByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateUserById",
      requestType = com.rapitor3.ads_service.UpdateUserByIdRequest.class,
      responseType = com.rapitor3.ads_service.UpdateUserByIdResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.rapitor3.ads_service.UpdateUserByIdRequest,
      com.rapitor3.ads_service.UpdateUserByIdResponse> getUpdateUserByIdMethod() {
    io.grpc.MethodDescriptor<com.rapitor3.ads_service.UpdateUserByIdRequest, com.rapitor3.ads_service.UpdateUserByIdResponse> getUpdateUserByIdMethod;
    if ((getUpdateUserByIdMethod = AdvertisementsStorageGrpc.getUpdateUserByIdMethod) == null) {
      synchronized (AdvertisementsStorageGrpc.class) {
        if ((getUpdateUserByIdMethod = AdvertisementsStorageGrpc.getUpdateUserByIdMethod) == null) {
          AdvertisementsStorageGrpc.getUpdateUserByIdMethod = getUpdateUserByIdMethod =
              io.grpc.MethodDescriptor.<com.rapitor3.ads_service.UpdateUserByIdRequest, com.rapitor3.ads_service.UpdateUserByIdResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateUserById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rapitor3.ads_service.UpdateUserByIdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rapitor3.ads_service.UpdateUserByIdResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AdvertisementsStorageMethodDescriptorSupplier("UpdateUserById"))
              .build();
        }
      }
    }
    return getUpdateUserByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.rapitor3.ads_service.DeleteUserByIdRequest,
      com.rapitor3.ads_service.DeleteUserByIdResponse> getDeleteUserByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteUserById",
      requestType = com.rapitor3.ads_service.DeleteUserByIdRequest.class,
      responseType = com.rapitor3.ads_service.DeleteUserByIdResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.rapitor3.ads_service.DeleteUserByIdRequest,
      com.rapitor3.ads_service.DeleteUserByIdResponse> getDeleteUserByIdMethod() {
    io.grpc.MethodDescriptor<com.rapitor3.ads_service.DeleteUserByIdRequest, com.rapitor3.ads_service.DeleteUserByIdResponse> getDeleteUserByIdMethod;
    if ((getDeleteUserByIdMethod = AdvertisementsStorageGrpc.getDeleteUserByIdMethod) == null) {
      synchronized (AdvertisementsStorageGrpc.class) {
        if ((getDeleteUserByIdMethod = AdvertisementsStorageGrpc.getDeleteUserByIdMethod) == null) {
          AdvertisementsStorageGrpc.getDeleteUserByIdMethod = getDeleteUserByIdMethod =
              io.grpc.MethodDescriptor.<com.rapitor3.ads_service.DeleteUserByIdRequest, com.rapitor3.ads_service.DeleteUserByIdResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteUserById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rapitor3.ads_service.DeleteUserByIdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rapitor3.ads_service.DeleteUserByIdResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AdvertisementsStorageMethodDescriptorSupplier("DeleteUserById"))
              .build();
        }
      }
    }
    return getDeleteUserByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.rapitor3.ads_service.SearchAdvertisementByTitleRequest,
      com.rapitor3.ads_service.SearchAdvertisementByTitleResponse> getSearchAdvertisementByTitleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchAdvertisementByTitle",
      requestType = com.rapitor3.ads_service.SearchAdvertisementByTitleRequest.class,
      responseType = com.rapitor3.ads_service.SearchAdvertisementByTitleResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.rapitor3.ads_service.SearchAdvertisementByTitleRequest,
      com.rapitor3.ads_service.SearchAdvertisementByTitleResponse> getSearchAdvertisementByTitleMethod() {
    io.grpc.MethodDescriptor<com.rapitor3.ads_service.SearchAdvertisementByTitleRequest, com.rapitor3.ads_service.SearchAdvertisementByTitleResponse> getSearchAdvertisementByTitleMethod;
    if ((getSearchAdvertisementByTitleMethod = AdvertisementsStorageGrpc.getSearchAdvertisementByTitleMethod) == null) {
      synchronized (AdvertisementsStorageGrpc.class) {
        if ((getSearchAdvertisementByTitleMethod = AdvertisementsStorageGrpc.getSearchAdvertisementByTitleMethod) == null) {
          AdvertisementsStorageGrpc.getSearchAdvertisementByTitleMethod = getSearchAdvertisementByTitleMethod =
              io.grpc.MethodDescriptor.<com.rapitor3.ads_service.SearchAdvertisementByTitleRequest, com.rapitor3.ads_service.SearchAdvertisementByTitleResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SearchAdvertisementByTitle"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rapitor3.ads_service.SearchAdvertisementByTitleRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rapitor3.ads_service.SearchAdvertisementByTitleResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AdvertisementsStorageMethodDescriptorSupplier("SearchAdvertisementByTitle"))
              .build();
        }
      }
    }
    return getSearchAdvertisementByTitleMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AdvertisementsStorageStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AdvertisementsStorageStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AdvertisementsStorageStub>() {
        @java.lang.Override
        public AdvertisementsStorageStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AdvertisementsStorageStub(channel, callOptions);
        }
      };
    return AdvertisementsStorageStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AdvertisementsStorageBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AdvertisementsStorageBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AdvertisementsStorageBlockingStub>() {
        @java.lang.Override
        public AdvertisementsStorageBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AdvertisementsStorageBlockingStub(channel, callOptions);
        }
      };
    return AdvertisementsStorageBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AdvertisementsStorageFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AdvertisementsStorageFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AdvertisementsStorageFutureStub>() {
        @java.lang.Override
        public AdvertisementsStorageFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AdvertisementsStorageFutureStub(channel, callOptions);
        }
      };
    return AdvertisementsStorageFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void createAdvertisement(com.rapitor3.ads_service.CreateAdvertisementRequest request,
        io.grpc.stub.StreamObserver<com.rapitor3.ads_service.CreateAdvertisementResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateAdvertisementMethod(), responseObserver);
    }

    /**
     */
    default void getAdvertisementById(com.rapitor3.ads_service.GetAdvertisementByIdRequest request,
        io.grpc.stub.StreamObserver<com.rapitor3.ads_service.GetAdvertisementByIdResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAdvertisementByIdMethod(), responseObserver);
    }

    /**
     */
    default void getAllAdvertisements(com.rapitor3.ads_service.GetAllAdvertisementsRequest request,
        io.grpc.stub.StreamObserver<com.rapitor3.ads_service.GetAllAdvertisementsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllAdvertisementsMethod(), responseObserver);
    }

    /**
     */
    default void updateAdvertisementById(com.rapitor3.ads_service.UpdateAdvertisementByIdRequest request,
        io.grpc.stub.StreamObserver<com.rapitor3.ads_service.UpdateAdvertisementByIdResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateAdvertisementByIdMethod(), responseObserver);
    }

    /**
     */
    default void deleteAdvertisementByID(com.rapitor3.ads_service.DeleteAdvertisementByIDRequest request,
        io.grpc.stub.StreamObserver<com.rapitor3.ads_service.DeleteAdvertisementByIDResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteAdvertisementByIDMethod(), responseObserver);
    }

    /**
     */
    default void createCategory(com.rapitor3.ads_service.CreateCategoryRequest request,
        io.grpc.stub.StreamObserver<com.rapitor3.ads_service.CreateCategoryResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateCategoryMethod(), responseObserver);
    }

    /**
     */
    default void getCategoryById(com.rapitor3.ads_service.GetCategoryByIdRequest request,
        io.grpc.stub.StreamObserver<com.rapitor3.ads_service.GetCategoryByIdResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCategoryByIdMethod(), responseObserver);
    }

    /**
     */
    default void getCategoryByAlias(com.rapitor3.ads_service.GetCategoryByAliasRequest request,
        io.grpc.stub.StreamObserver<com.rapitor3.ads_service.GetCategoryByAliasResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCategoryByAliasMethod(), responseObserver);
    }

    /**
     */
    default void getAllCategories(com.rapitor3.ads_service.GetAllCategoriesRequest request,
        io.grpc.stub.StreamObserver<com.rapitor3.ads_service.GetAllCategoriesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllCategoriesMethod(), responseObserver);
    }

    /**
     */
    default void updateCategoryById(com.rapitor3.ads_service.UpdateCategoryByIdRequest request,
        io.grpc.stub.StreamObserver<com.rapitor3.ads_service.UpdateCategoryByIdResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateCategoryByIdMethod(), responseObserver);
    }

    /**
     */
    default void deleteCategoryById(com.rapitor3.ads_service.DeleteCategoryByIDRequest request,
        io.grpc.stub.StreamObserver<com.rapitor3.ads_service.DeleteCategoryByIDResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteCategoryByIdMethod(), responseObserver);
    }

    /**
     */
    default void registerUser(com.rapitor3.ads_service.RegisterUserRequest request,
        io.grpc.stub.StreamObserver<com.rapitor3.ads_service.RegisterUserResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRegisterUserMethod(), responseObserver);
    }

    /**
     */
    default void loginUser(com.rapitor3.ads_service.LoginUserRequest request,
        io.grpc.stub.StreamObserver<com.rapitor3.ads_service.LoginUserResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLoginUserMethod(), responseObserver);
    }

    /**
     */
    default void getAllUsers(com.rapitor3.ads_service.GetAllUsersRequest request,
        io.grpc.stub.StreamObserver<com.rapitor3.ads_service.GetAllUsersResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllUsersMethod(), responseObserver);
    }

    /**
     */
    default void getUserByID(com.rapitor3.ads_service.GetUserByIDRequest request,
        io.grpc.stub.StreamObserver<com.rapitor3.ads_service.GetUserByIdResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetUserByIDMethod(), responseObserver);
    }

    /**
     */
    default void getUserByEmail(com.rapitor3.ads_service.GetUserByEmailRequest request,
        io.grpc.stub.StreamObserver<com.rapitor3.ads_service.GetUserByEmailResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetUserByEmailMethod(), responseObserver);
    }

    /**
     */
    default void updateUserById(com.rapitor3.ads_service.UpdateUserByIdRequest request,
        io.grpc.stub.StreamObserver<com.rapitor3.ads_service.UpdateUserByIdResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateUserByIdMethod(), responseObserver);
    }

    /**
     */
    default void deleteUserById(com.rapitor3.ads_service.DeleteUserByIdRequest request,
        io.grpc.stub.StreamObserver<com.rapitor3.ads_service.DeleteUserByIdResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteUserByIdMethod(), responseObserver);
    }

    /**
     */
    default void searchAdvertisementByTitle(com.rapitor3.ads_service.SearchAdvertisementByTitleRequest request,
        io.grpc.stub.StreamObserver<com.rapitor3.ads_service.SearchAdvertisementByTitleResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSearchAdvertisementByTitleMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AdvertisementsStorage.
   */
  public static abstract class AdvertisementsStorageImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return AdvertisementsStorageGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service AdvertisementsStorage.
   */
  public static final class AdvertisementsStorageStub
      extends io.grpc.stub.AbstractAsyncStub<AdvertisementsStorageStub> {
    private AdvertisementsStorageStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AdvertisementsStorageStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AdvertisementsStorageStub(channel, callOptions);
    }

    /**
     */
    public void createAdvertisement(com.rapitor3.ads_service.CreateAdvertisementRequest request,
        io.grpc.stub.StreamObserver<com.rapitor3.ads_service.CreateAdvertisementResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAdvertisementMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAdvertisementById(com.rapitor3.ads_service.GetAdvertisementByIdRequest request,
        io.grpc.stub.StreamObserver<com.rapitor3.ads_service.GetAdvertisementByIdResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAdvertisementByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllAdvertisements(com.rapitor3.ads_service.GetAllAdvertisementsRequest request,
        io.grpc.stub.StreamObserver<com.rapitor3.ads_service.GetAllAdvertisementsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAllAdvertisementsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateAdvertisementById(com.rapitor3.ads_service.UpdateAdvertisementByIdRequest request,
        io.grpc.stub.StreamObserver<com.rapitor3.ads_service.UpdateAdvertisementByIdResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateAdvertisementByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteAdvertisementByID(com.rapitor3.ads_service.DeleteAdvertisementByIDRequest request,
        io.grpc.stub.StreamObserver<com.rapitor3.ads_service.DeleteAdvertisementByIDResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAdvertisementByIDMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void createCategory(com.rapitor3.ads_service.CreateCategoryRequest request,
        io.grpc.stub.StreamObserver<com.rapitor3.ads_service.CreateCategoryResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateCategoryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getCategoryById(com.rapitor3.ads_service.GetCategoryByIdRequest request,
        io.grpc.stub.StreamObserver<com.rapitor3.ads_service.GetCategoryByIdResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCategoryByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getCategoryByAlias(com.rapitor3.ads_service.GetCategoryByAliasRequest request,
        io.grpc.stub.StreamObserver<com.rapitor3.ads_service.GetCategoryByAliasResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCategoryByAliasMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllCategories(com.rapitor3.ads_service.GetAllCategoriesRequest request,
        io.grpc.stub.StreamObserver<com.rapitor3.ads_service.GetAllCategoriesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAllCategoriesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateCategoryById(com.rapitor3.ads_service.UpdateCategoryByIdRequest request,
        io.grpc.stub.StreamObserver<com.rapitor3.ads_service.UpdateCategoryByIdResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateCategoryByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteCategoryById(com.rapitor3.ads_service.DeleteCategoryByIDRequest request,
        io.grpc.stub.StreamObserver<com.rapitor3.ads_service.DeleteCategoryByIDResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteCategoryByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void registerUser(com.rapitor3.ads_service.RegisterUserRequest request,
        io.grpc.stub.StreamObserver<com.rapitor3.ads_service.RegisterUserResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRegisterUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void loginUser(com.rapitor3.ads_service.LoginUserRequest request,
        io.grpc.stub.StreamObserver<com.rapitor3.ads_service.LoginUserResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLoginUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllUsers(com.rapitor3.ads_service.GetAllUsersRequest request,
        io.grpc.stub.StreamObserver<com.rapitor3.ads_service.GetAllUsersResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAllUsersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getUserByID(com.rapitor3.ads_service.GetUserByIDRequest request,
        io.grpc.stub.StreamObserver<com.rapitor3.ads_service.GetUserByIdResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetUserByIDMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getUserByEmail(com.rapitor3.ads_service.GetUserByEmailRequest request,
        io.grpc.stub.StreamObserver<com.rapitor3.ads_service.GetUserByEmailResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetUserByEmailMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateUserById(com.rapitor3.ads_service.UpdateUserByIdRequest request,
        io.grpc.stub.StreamObserver<com.rapitor3.ads_service.UpdateUserByIdResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateUserByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteUserById(com.rapitor3.ads_service.DeleteUserByIdRequest request,
        io.grpc.stub.StreamObserver<com.rapitor3.ads_service.DeleteUserByIdResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteUserByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void searchAdvertisementByTitle(com.rapitor3.ads_service.SearchAdvertisementByTitleRequest request,
        io.grpc.stub.StreamObserver<com.rapitor3.ads_service.SearchAdvertisementByTitleResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchAdvertisementByTitleMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AdvertisementsStorage.
   */
  public static final class AdvertisementsStorageBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AdvertisementsStorageBlockingStub> {
    private AdvertisementsStorageBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AdvertisementsStorageBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AdvertisementsStorageBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.rapitor3.ads_service.CreateAdvertisementResponse createAdvertisement(com.rapitor3.ads_service.CreateAdvertisementRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAdvertisementMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.rapitor3.ads_service.GetAdvertisementByIdResponse getAdvertisementById(com.rapitor3.ads_service.GetAdvertisementByIdRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAdvertisementByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.rapitor3.ads_service.GetAllAdvertisementsResponse getAllAdvertisements(com.rapitor3.ads_service.GetAllAdvertisementsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAllAdvertisementsMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.rapitor3.ads_service.UpdateAdvertisementByIdResponse updateAdvertisementById(com.rapitor3.ads_service.UpdateAdvertisementByIdRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAdvertisementByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.rapitor3.ads_service.DeleteAdvertisementByIDResponse deleteAdvertisementByID(com.rapitor3.ads_service.DeleteAdvertisementByIDRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAdvertisementByIDMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.rapitor3.ads_service.CreateCategoryResponse createCategory(com.rapitor3.ads_service.CreateCategoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateCategoryMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.rapitor3.ads_service.GetCategoryByIdResponse getCategoryById(com.rapitor3.ads_service.GetCategoryByIdRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCategoryByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.rapitor3.ads_service.GetCategoryByAliasResponse getCategoryByAlias(com.rapitor3.ads_service.GetCategoryByAliasRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCategoryByAliasMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.rapitor3.ads_service.GetAllCategoriesResponse getAllCategories(com.rapitor3.ads_service.GetAllCategoriesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAllCategoriesMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.rapitor3.ads_service.UpdateCategoryByIdResponse updateCategoryById(com.rapitor3.ads_service.UpdateCategoryByIdRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCategoryByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.rapitor3.ads_service.DeleteCategoryByIDResponse deleteCategoryById(com.rapitor3.ads_service.DeleteCategoryByIDRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteCategoryByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.rapitor3.ads_service.RegisterUserResponse registerUser(com.rapitor3.ads_service.RegisterUserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRegisterUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.rapitor3.ads_service.LoginUserResponse loginUser(com.rapitor3.ads_service.LoginUserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLoginUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.rapitor3.ads_service.GetAllUsersResponse getAllUsers(com.rapitor3.ads_service.GetAllUsersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAllUsersMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.rapitor3.ads_service.GetUserByIdResponse getUserByID(com.rapitor3.ads_service.GetUserByIDRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetUserByIDMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.rapitor3.ads_service.GetUserByEmailResponse getUserByEmail(com.rapitor3.ads_service.GetUserByEmailRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetUserByEmailMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.rapitor3.ads_service.UpdateUserByIdResponse updateUserById(com.rapitor3.ads_service.UpdateUserByIdRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateUserByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.rapitor3.ads_service.DeleteUserByIdResponse deleteUserById(com.rapitor3.ads_service.DeleteUserByIdRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteUserByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.rapitor3.ads_service.SearchAdvertisementByTitleResponse searchAdvertisementByTitle(com.rapitor3.ads_service.SearchAdvertisementByTitleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchAdvertisementByTitleMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service AdvertisementsStorage.
   */
  public static final class AdvertisementsStorageFutureStub
      extends io.grpc.stub.AbstractFutureStub<AdvertisementsStorageFutureStub> {
    private AdvertisementsStorageFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AdvertisementsStorageFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AdvertisementsStorageFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rapitor3.ads_service.CreateAdvertisementResponse> createAdvertisement(
        com.rapitor3.ads_service.CreateAdvertisementRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAdvertisementMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rapitor3.ads_service.GetAdvertisementByIdResponse> getAdvertisementById(
        com.rapitor3.ads_service.GetAdvertisementByIdRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAdvertisementByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rapitor3.ads_service.GetAllAdvertisementsResponse> getAllAdvertisements(
        com.rapitor3.ads_service.GetAllAdvertisementsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAllAdvertisementsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rapitor3.ads_service.UpdateAdvertisementByIdResponse> updateAdvertisementById(
        com.rapitor3.ads_service.UpdateAdvertisementByIdRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateAdvertisementByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rapitor3.ads_service.DeleteAdvertisementByIDResponse> deleteAdvertisementByID(
        com.rapitor3.ads_service.DeleteAdvertisementByIDRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAdvertisementByIDMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rapitor3.ads_service.CreateCategoryResponse> createCategory(
        com.rapitor3.ads_service.CreateCategoryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateCategoryMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rapitor3.ads_service.GetCategoryByIdResponse> getCategoryById(
        com.rapitor3.ads_service.GetCategoryByIdRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCategoryByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rapitor3.ads_service.GetCategoryByAliasResponse> getCategoryByAlias(
        com.rapitor3.ads_service.GetCategoryByAliasRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCategoryByAliasMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rapitor3.ads_service.GetAllCategoriesResponse> getAllCategories(
        com.rapitor3.ads_service.GetAllCategoriesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAllCategoriesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rapitor3.ads_service.UpdateCategoryByIdResponse> updateCategoryById(
        com.rapitor3.ads_service.UpdateCategoryByIdRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCategoryByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rapitor3.ads_service.DeleteCategoryByIDResponse> deleteCategoryById(
        com.rapitor3.ads_service.DeleteCategoryByIDRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteCategoryByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rapitor3.ads_service.RegisterUserResponse> registerUser(
        com.rapitor3.ads_service.RegisterUserRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRegisterUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rapitor3.ads_service.LoginUserResponse> loginUser(
        com.rapitor3.ads_service.LoginUserRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLoginUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rapitor3.ads_service.GetAllUsersResponse> getAllUsers(
        com.rapitor3.ads_service.GetAllUsersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAllUsersMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rapitor3.ads_service.GetUserByIdResponse> getUserByID(
        com.rapitor3.ads_service.GetUserByIDRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetUserByIDMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rapitor3.ads_service.GetUserByEmailResponse> getUserByEmail(
        com.rapitor3.ads_service.GetUserByEmailRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetUserByEmailMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rapitor3.ads_service.UpdateUserByIdResponse> updateUserById(
        com.rapitor3.ads_service.UpdateUserByIdRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateUserByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rapitor3.ads_service.DeleteUserByIdResponse> deleteUserById(
        com.rapitor3.ads_service.DeleteUserByIdRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteUserByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rapitor3.ads_service.SearchAdvertisementByTitleResponse> searchAdvertisementByTitle(
        com.rapitor3.ads_service.SearchAdvertisementByTitleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchAdvertisementByTitleMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_ADVERTISEMENT = 0;
  private static final int METHODID_GET_ADVERTISEMENT_BY_ID = 1;
  private static final int METHODID_GET_ALL_ADVERTISEMENTS = 2;
  private static final int METHODID_UPDATE_ADVERTISEMENT_BY_ID = 3;
  private static final int METHODID_DELETE_ADVERTISEMENT_BY_ID = 4;
  private static final int METHODID_CREATE_CATEGORY = 5;
  private static final int METHODID_GET_CATEGORY_BY_ID = 6;
  private static final int METHODID_GET_CATEGORY_BY_ALIAS = 7;
  private static final int METHODID_GET_ALL_CATEGORIES = 8;
  private static final int METHODID_UPDATE_CATEGORY_BY_ID = 9;
  private static final int METHODID_DELETE_CATEGORY_BY_ID = 10;
  private static final int METHODID_REGISTER_USER = 11;
  private static final int METHODID_LOGIN_USER = 12;
  private static final int METHODID_GET_ALL_USERS = 13;
  private static final int METHODID_GET_USER_BY_ID = 14;
  private static final int METHODID_GET_USER_BY_EMAIL = 15;
  private static final int METHODID_UPDATE_USER_BY_ID = 16;
  private static final int METHODID_DELETE_USER_BY_ID = 17;
  private static final int METHODID_SEARCH_ADVERTISEMENT_BY_TITLE = 18;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_ADVERTISEMENT:
          serviceImpl.createAdvertisement((com.rapitor3.ads_service.CreateAdvertisementRequest) request,
              (io.grpc.stub.StreamObserver<com.rapitor3.ads_service.CreateAdvertisementResponse>) responseObserver);
          break;
        case METHODID_GET_ADVERTISEMENT_BY_ID:
          serviceImpl.getAdvertisementById((com.rapitor3.ads_service.GetAdvertisementByIdRequest) request,
              (io.grpc.stub.StreamObserver<com.rapitor3.ads_service.GetAdvertisementByIdResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_ADVERTISEMENTS:
          serviceImpl.getAllAdvertisements((com.rapitor3.ads_service.GetAllAdvertisementsRequest) request,
              (io.grpc.stub.StreamObserver<com.rapitor3.ads_service.GetAllAdvertisementsResponse>) responseObserver);
          break;
        case METHODID_UPDATE_ADVERTISEMENT_BY_ID:
          serviceImpl.updateAdvertisementById((com.rapitor3.ads_service.UpdateAdvertisementByIdRequest) request,
              (io.grpc.stub.StreamObserver<com.rapitor3.ads_service.UpdateAdvertisementByIdResponse>) responseObserver);
          break;
        case METHODID_DELETE_ADVERTISEMENT_BY_ID:
          serviceImpl.deleteAdvertisementByID((com.rapitor3.ads_service.DeleteAdvertisementByIDRequest) request,
              (io.grpc.stub.StreamObserver<com.rapitor3.ads_service.DeleteAdvertisementByIDResponse>) responseObserver);
          break;
        case METHODID_CREATE_CATEGORY:
          serviceImpl.createCategory((com.rapitor3.ads_service.CreateCategoryRequest) request,
              (io.grpc.stub.StreamObserver<com.rapitor3.ads_service.CreateCategoryResponse>) responseObserver);
          break;
        case METHODID_GET_CATEGORY_BY_ID:
          serviceImpl.getCategoryById((com.rapitor3.ads_service.GetCategoryByIdRequest) request,
              (io.grpc.stub.StreamObserver<com.rapitor3.ads_service.GetCategoryByIdResponse>) responseObserver);
          break;
        case METHODID_GET_CATEGORY_BY_ALIAS:
          serviceImpl.getCategoryByAlias((com.rapitor3.ads_service.GetCategoryByAliasRequest) request,
              (io.grpc.stub.StreamObserver<com.rapitor3.ads_service.GetCategoryByAliasResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_CATEGORIES:
          serviceImpl.getAllCategories((com.rapitor3.ads_service.GetAllCategoriesRequest) request,
              (io.grpc.stub.StreamObserver<com.rapitor3.ads_service.GetAllCategoriesResponse>) responseObserver);
          break;
        case METHODID_UPDATE_CATEGORY_BY_ID:
          serviceImpl.updateCategoryById((com.rapitor3.ads_service.UpdateCategoryByIdRequest) request,
              (io.grpc.stub.StreamObserver<com.rapitor3.ads_service.UpdateCategoryByIdResponse>) responseObserver);
          break;
        case METHODID_DELETE_CATEGORY_BY_ID:
          serviceImpl.deleteCategoryById((com.rapitor3.ads_service.DeleteCategoryByIDRequest) request,
              (io.grpc.stub.StreamObserver<com.rapitor3.ads_service.DeleteCategoryByIDResponse>) responseObserver);
          break;
        case METHODID_REGISTER_USER:
          serviceImpl.registerUser((com.rapitor3.ads_service.RegisterUserRequest) request,
              (io.grpc.stub.StreamObserver<com.rapitor3.ads_service.RegisterUserResponse>) responseObserver);
          break;
        case METHODID_LOGIN_USER:
          serviceImpl.loginUser((com.rapitor3.ads_service.LoginUserRequest) request,
              (io.grpc.stub.StreamObserver<com.rapitor3.ads_service.LoginUserResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_USERS:
          serviceImpl.getAllUsers((com.rapitor3.ads_service.GetAllUsersRequest) request,
              (io.grpc.stub.StreamObserver<com.rapitor3.ads_service.GetAllUsersResponse>) responseObserver);
          break;
        case METHODID_GET_USER_BY_ID:
          serviceImpl.getUserByID((com.rapitor3.ads_service.GetUserByIDRequest) request,
              (io.grpc.stub.StreamObserver<com.rapitor3.ads_service.GetUserByIdResponse>) responseObserver);
          break;
        case METHODID_GET_USER_BY_EMAIL:
          serviceImpl.getUserByEmail((com.rapitor3.ads_service.GetUserByEmailRequest) request,
              (io.grpc.stub.StreamObserver<com.rapitor3.ads_service.GetUserByEmailResponse>) responseObserver);
          break;
        case METHODID_UPDATE_USER_BY_ID:
          serviceImpl.updateUserById((com.rapitor3.ads_service.UpdateUserByIdRequest) request,
              (io.grpc.stub.StreamObserver<com.rapitor3.ads_service.UpdateUserByIdResponse>) responseObserver);
          break;
        case METHODID_DELETE_USER_BY_ID:
          serviceImpl.deleteUserById((com.rapitor3.ads_service.DeleteUserByIdRequest) request,
              (io.grpc.stub.StreamObserver<com.rapitor3.ads_service.DeleteUserByIdResponse>) responseObserver);
          break;
        case METHODID_SEARCH_ADVERTISEMENT_BY_TITLE:
          serviceImpl.searchAdvertisementByTitle((com.rapitor3.ads_service.SearchAdvertisementByTitleRequest) request,
              (io.grpc.stub.StreamObserver<com.rapitor3.ads_service.SearchAdvertisementByTitleResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getCreateAdvertisementMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.rapitor3.ads_service.CreateAdvertisementRequest,
              com.rapitor3.ads_service.CreateAdvertisementResponse>(
                service, METHODID_CREATE_ADVERTISEMENT)))
        .addMethod(
          getGetAdvertisementByIdMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.rapitor3.ads_service.GetAdvertisementByIdRequest,
              com.rapitor3.ads_service.GetAdvertisementByIdResponse>(
                service, METHODID_GET_ADVERTISEMENT_BY_ID)))
        .addMethod(
          getGetAllAdvertisementsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.rapitor3.ads_service.GetAllAdvertisementsRequest,
              com.rapitor3.ads_service.GetAllAdvertisementsResponse>(
                service, METHODID_GET_ALL_ADVERTISEMENTS)))
        .addMethod(
          getUpdateAdvertisementByIdMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.rapitor3.ads_service.UpdateAdvertisementByIdRequest,
              com.rapitor3.ads_service.UpdateAdvertisementByIdResponse>(
                service, METHODID_UPDATE_ADVERTISEMENT_BY_ID)))
        .addMethod(
          getDeleteAdvertisementByIDMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.rapitor3.ads_service.DeleteAdvertisementByIDRequest,
              com.rapitor3.ads_service.DeleteAdvertisementByIDResponse>(
                service, METHODID_DELETE_ADVERTISEMENT_BY_ID)))
        .addMethod(
          getCreateCategoryMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.rapitor3.ads_service.CreateCategoryRequest,
              com.rapitor3.ads_service.CreateCategoryResponse>(
                service, METHODID_CREATE_CATEGORY)))
        .addMethod(
          getGetCategoryByIdMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.rapitor3.ads_service.GetCategoryByIdRequest,
              com.rapitor3.ads_service.GetCategoryByIdResponse>(
                service, METHODID_GET_CATEGORY_BY_ID)))
        .addMethod(
          getGetCategoryByAliasMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.rapitor3.ads_service.GetCategoryByAliasRequest,
              com.rapitor3.ads_service.GetCategoryByAliasResponse>(
                service, METHODID_GET_CATEGORY_BY_ALIAS)))
        .addMethod(
          getGetAllCategoriesMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.rapitor3.ads_service.GetAllCategoriesRequest,
              com.rapitor3.ads_service.GetAllCategoriesResponse>(
                service, METHODID_GET_ALL_CATEGORIES)))
        .addMethod(
          getUpdateCategoryByIdMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.rapitor3.ads_service.UpdateCategoryByIdRequest,
              com.rapitor3.ads_service.UpdateCategoryByIdResponse>(
                service, METHODID_UPDATE_CATEGORY_BY_ID)))
        .addMethod(
          getDeleteCategoryByIdMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.rapitor3.ads_service.DeleteCategoryByIDRequest,
              com.rapitor3.ads_service.DeleteCategoryByIDResponse>(
                service, METHODID_DELETE_CATEGORY_BY_ID)))
        .addMethod(
          getRegisterUserMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.rapitor3.ads_service.RegisterUserRequest,
              com.rapitor3.ads_service.RegisterUserResponse>(
                service, METHODID_REGISTER_USER)))
        .addMethod(
          getLoginUserMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.rapitor3.ads_service.LoginUserRequest,
              com.rapitor3.ads_service.LoginUserResponse>(
                service, METHODID_LOGIN_USER)))
        .addMethod(
          getGetAllUsersMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.rapitor3.ads_service.GetAllUsersRequest,
              com.rapitor3.ads_service.GetAllUsersResponse>(
                service, METHODID_GET_ALL_USERS)))
        .addMethod(
          getGetUserByIDMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.rapitor3.ads_service.GetUserByIDRequest,
              com.rapitor3.ads_service.GetUserByIdResponse>(
                service, METHODID_GET_USER_BY_ID)))
        .addMethod(
          getGetUserByEmailMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.rapitor3.ads_service.GetUserByEmailRequest,
              com.rapitor3.ads_service.GetUserByEmailResponse>(
                service, METHODID_GET_USER_BY_EMAIL)))
        .addMethod(
          getUpdateUserByIdMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.rapitor3.ads_service.UpdateUserByIdRequest,
              com.rapitor3.ads_service.UpdateUserByIdResponse>(
                service, METHODID_UPDATE_USER_BY_ID)))
        .addMethod(
          getDeleteUserByIdMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.rapitor3.ads_service.DeleteUserByIdRequest,
              com.rapitor3.ads_service.DeleteUserByIdResponse>(
                service, METHODID_DELETE_USER_BY_ID)))
        .addMethod(
          getSearchAdvertisementByTitleMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.rapitor3.ads_service.SearchAdvertisementByTitleRequest,
              com.rapitor3.ads_service.SearchAdvertisementByTitleResponse>(
                service, METHODID_SEARCH_ADVERTISEMENT_BY_TITLE)))
        .build();
  }

  private static abstract class AdvertisementsStorageBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AdvertisementsStorageBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.rapitor3.ads_service.AdvertisementsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AdvertisementsStorage");
    }
  }

  private static final class AdvertisementsStorageFileDescriptorSupplier
      extends AdvertisementsStorageBaseDescriptorSupplier {
    AdvertisementsStorageFileDescriptorSupplier() {}
  }

  private static final class AdvertisementsStorageMethodDescriptorSupplier
      extends AdvertisementsStorageBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    AdvertisementsStorageMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (AdvertisementsStorageGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AdvertisementsStorageFileDescriptorSupplier())
              .addMethod(getCreateAdvertisementMethod())
              .addMethod(getGetAdvertisementByIdMethod())
              .addMethod(getGetAllAdvertisementsMethod())
              .addMethod(getUpdateAdvertisementByIdMethod())
              .addMethod(getDeleteAdvertisementByIDMethod())
              .addMethod(getCreateCategoryMethod())
              .addMethod(getGetCategoryByIdMethod())
              .addMethod(getGetCategoryByAliasMethod())
              .addMethod(getGetAllCategoriesMethod())
              .addMethod(getUpdateCategoryByIdMethod())
              .addMethod(getDeleteCategoryByIdMethod())
              .addMethod(getRegisterUserMethod())
              .addMethod(getLoginUserMethod())
              .addMethod(getGetAllUsersMethod())
              .addMethod(getGetUserByIDMethod())
              .addMethod(getGetUserByEmailMethod())
              .addMethod(getUpdateUserByIdMethod())
              .addMethod(getDeleteUserByIdMethod())
              .addMethod(getSearchAdvertisementByTitleMethod())
              .build();
        }
      }
    }
    return result;
  }
}
