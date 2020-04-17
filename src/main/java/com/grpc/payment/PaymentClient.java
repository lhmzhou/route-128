package com.grpc.payment;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class PaymentClient {
  public static void main(String[] args) {
    ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
      .usePlaintext(true)
      .build();
    PaymentServiceGrpc.PaymentServiceBlockingStub client = PaymentServiceGrpc.newBlockingStub(channel);
    PaymentResponse response = client.makePayment(Payment.newBuilder()
      .setId(123)
      .setAccount(999)
      .setAmount(1000)
      .setMessage("Keep calm and go to happy hour!")
      .build());
    System.out.println(response);
  }
}
