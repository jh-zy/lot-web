
package com.sinodata.lottery.serviceexample.grpcserver;

import com.sinodata.lottery.serviceexample.entity.User;
import com.sinodata.lottery.serviceexample.mapper.UserMapper;
import com.sinodata.lottery.grpc.User.*;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;


@GrpcService
public class UserServer extends UserGrpc.UserImplBase {

    @Autowired
    private UserMapper mapper;

    @Override
    public void getUserByName(UserRequest req, StreamObserver<UserReply> responseObserver) {
        User user = mapper.queryByName(req.getName());
        UserInfo userr = UserInfo.newBuilder().setName(user.getName()).setAddress(user.getAddress()).setPhone(user.getPhone()).build();
        UserReply reply = UserReply.newBuilder().setUser(userr).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void getUserList(UserListRequest request, StreamObserver<UserListReply> responseObserver) {
        UserInfo user = UserInfo.newBuilder().setName("张三").setAddress("beijing").setPhone("16845461235").build();
        UserInfo user1 = UserInfo.newBuilder().setName("李四").setAddress("beijing").setPhone("16845461237").build();
        UserListReply reply = UserListReply.newBuilder().addUser(user).addUser(user1).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

}
