package com.ltdd.baitap241.mapper;

import com.ltdd.baitap241.dto.request.UserRegister;
import com.ltdd.baitap241.dto.response.UserResponse;
import com.ltdd.baitap241.entity.UserEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-25T12:05:34+0700",
    comments = "version: 1.6.3, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserEntity toUserEntity(UserRegister UserRegister) {
        if ( UserRegister == null ) {
            return null;
        }

        UserEntity.UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.username( UserRegister.getUsername() );
        userEntity.password( UserRegister.getPassword() );
        userEntity.email( UserRegister.getEmail() );

        return userEntity.build();
    }

    @Override
    public UserResponse toUserResponse(UserEntity UserEntity) {
        if ( UserEntity == null ) {
            return null;
        }

        UserResponse userResponse = new UserResponse();

        userResponse.setUsername( UserEntity.getUsername() );
        userResponse.setEmail( UserEntity.getEmail() );

        return userResponse;
    }
}
