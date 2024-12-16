package com.fernando.basic.modules.users.models.mappers;

import com.fernando.basic.modules.users.models.dtos.UserResponse;
import com.fernando.basic.modules.users.models.enttites.User;

public class UserMapper {

    public static UserResponse toUserResponse(User user){
        return new UserResponse(
                user.getId(),
                user.getFullname(),
                user.getEmail(),
                user.getAge()
        );
    }
}
