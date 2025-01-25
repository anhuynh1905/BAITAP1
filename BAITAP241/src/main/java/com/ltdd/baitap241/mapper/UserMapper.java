package com.ltdd.baitap241.mapper;

import com.ltdd.baitap241.dto.request.UserRegister;
import com.ltdd.baitap241.dto.response.UserResponse;
import com.ltdd.baitap241.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity toUserEntity(UserRegister UserRegister);
    UserResponse toUserResponse(UserEntity UserEntity);
}
