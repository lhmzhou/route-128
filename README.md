# route-128

`route-128` gets you started with gRPC in Java with a simple working example where you can run a gRPC server to make a payment via a gPRC client. 

### Prerequisites
```
JDK v7 (or higher)
gRPC 1.16
Maven 3.5
``` 

### Run the gRPC application

Run server
```
$ mvn exec:java-Dexec.mainClass=com.grpc.payment.PaymentServer
```

Run client 
```
$ mvn exec:java-Dexec.mainClass=com.grpc.payment.PaymentClient
```