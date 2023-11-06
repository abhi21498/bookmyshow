package Transformers;

import Models.User;
import RequestDTOs.AddUserRequest;

public class UserTransformer {


    public static User convertAddUserReqToUserEntity(AddUserRequest addUserRequest) {


        User userObj = User.builder()
                .age(addUserRequest.getAge())
                .emailId(addUserRequest.getEmailId())
                .mobNo(addUserRequest.getMobNo())
                .name(addUserRequest.getName())
                .build();


        return userObj;

    }
}