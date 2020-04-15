
package com.sinodata.lottery.webexample.service;

import com.sinodata.lottery.grpc.User.UserGrpc.UserBlockingStub;
import com.sinodata.lottery.grpc.User.*;
import com.sinodata.lottery.webexample.core.model.User;
import io.grpc.StatusRuntimeException;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Michael (yidongnan@gmail.com)
 * @since 2016/11/8
 */
@Service
public class UserInfoService {

    @GrpcClient("lottery-service")
    private UserBlockingStub userStub;

    public User getUserByName(final String name) {
        try {
            final UserReply response = this.userStub.getUserByName(UserRequest.newBuilder().setName(name).build());
            UserInfo info = response.getUser();
            return new User(info.getName(),info.getAddress(),info.getPhone());
        } catch (final StatusRuntimeException e) {
            return null;
        }
    }
    public List<User> getUserList() {
        try {
            final UserListReply response = this.userStub.getUserList(UserListRequest.newBuilder().build());
            // fixme response.getUserList can not work

            int count = response.getUserCount();
            List<User> userList = new ArrayList<>();
            for(int i=0;i<count;i++){
                UserInfo u = response.getUser(i);
                userList.add(new User(u.getName(),u.getAddress(),u.getPhone()));
            }
            return userList;

        } catch (final StatusRuntimeException e) {
            return null;
        }
    }
}
