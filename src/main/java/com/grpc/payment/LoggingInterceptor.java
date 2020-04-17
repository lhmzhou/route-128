package com.grpc.payment;

import io.grpc.ForwardingServerCall;
import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.Status;
import java.time.LocalDateTime;

public class LoggingInterceptor implements ServerInterceptor {
  @Override
  public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> serverCall, Metadata metadata,
                                                               ServerCallHandler<ReqT, RespT> serverCallHandler) {

    System.out.println("Request recieved from client" + LocalDateTime.now());
    return serverCallHandler.startCall(new ForwardingServerCall.SimpleForwardingServerCall<ReqT, RespT>(serverCall) {
      @Override
      public void close(Status status, Metadata trailers) {
        super.close(status, trailers);
        System.out.println("Response completed for client" + LocalDateTime.now());
      }
    }, metadata);
  }
}
