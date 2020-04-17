package com.grpc.payment;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class NotificationClient {
  public static boolean run = true;

  public static void main(String[] args) throws InterruptedException {

    ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
      .usePlaintext(true)
      .build();

    PaymentServiceGrpc.PaymentServiceStub client = PaymentServiceGrpc.newStub(channel);
   
    // generate protobuf messages to exchange with server
    client.recieveNotification(Account.newBuilder()
      .setAccount(123)
      .build(), new StreamObserver<Notification>() {
      @Override
      public void onNext(Notification notification) {
        System.out.println(notification);
      }

      @Override
      public void onError(Throwable throwable) {
        System.out.println(throwable);
      }

      @Override
      public void onCompleted() {
        System.out.println("All notifications received");
        run = false;
      }
    });

    while(run){
      Thread.sleep(500);
    }

  }
}
