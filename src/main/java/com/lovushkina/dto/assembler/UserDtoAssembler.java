package com.lovushkina.dto.assembler;
import com.lovushkina.controller.UserController;
import com.lovushkina.domain.User;
import com.lovushkina.domain.User;
import com.lovushkina.dto.AppCategoryDto;
import com.lovushkina.dto.UserDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class UserDtoAssembler implements RepresentationModelAssembler<User, UserDto> {
    @Override
    public UserDto toModel(User entity) {
        UserDto userDto = UserDto.builder()
                .id(entity.getId())
                .passwordHash(entity.getPasswordHash())
                .fullName(entity.getFullName())
                .country(entity.getCountry())
                .email(entity.getEmail())
                .build();
        Link selfLink = linkTo(methodOn(UserController.class).getUser(userDto.getId())).withSelfRel();
        userDto.add(selfLink);
        return userDto;
    }

    @Override
    public CollectionModel<UserDto> toCollectionModel(Iterable<? extends User> entities) {
        CollectionModel<UserDto> userDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(UserController.class).getAllUsers()).withSelfRel();
        userDtos.add(selfLink);
        return userDtos;
    }
}

