package com.grpc.payment;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;

public class PaymentServer {

  // start the gRPC server to listen for incoming requests
  public static void main(String[] args) throws IOException, InterruptedException {
    log.info("Starting grpc server on port '{}'...", server.getPort());
    
    Server server = ServerBuilder.forPort(8080)
      .addService(new PaymentServiceImpl())
      .intercept(new LoggingInterceptor())
      .build();
    server.start();
    log.info("grpc (port={}) server started successfully.", server.getPort());
    // System.out.println("gRPC server started at :" + server.getPort());
    server.awaitTermination();
  }
}
