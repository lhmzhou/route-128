package com.grpc.payment;

import io.grpc.stub.StreamObserver;

public class PaymentServiceImpl extends PaymentServiceGrpc.PaymentServiceImplBase {

  @Override
  public void makePayment(Payment request, StreamObserver<PaymentResponse> responseObserver) {
    responseObserver.onNext(PaymentResponse.newBuilder()
      .setId(request.getId())
      .setMessage("Payment Received")
      .build());

    responseObserver.onCompleted();
  }

  @Override
  public void recieveNotification(Account request, StreamObserver<Notification> responseObserver) {

    for (int i = 1; i <6 ; i++) {
      responseObserver.onNext(Notification.newBuilder()
        .setAccount(request)
        .setAmount(1000 * i)
        .setMessage("Payment Posted! Time for happy hour.")
        .build());
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    responseObserver.onCompleted();

  }
}
