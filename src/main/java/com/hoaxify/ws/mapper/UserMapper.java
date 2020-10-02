package com.hoaxify.ws.mapper;

import com.hoaxify.ws.user.User;
import com.hoaxify.ws.viewModel.UserVM;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserVM mapToVM(User user);

    User mapToEntity(UserVM userVM);

}
