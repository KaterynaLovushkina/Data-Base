package com.lovushkina.dto.assembler;

import com.lovushkina.controller.AppCategoryController;
import com.lovushkina.domain.AppCategory;
import com.lovushkina.dto.AppCategoryDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class AppCategoryDtoAssembler implements RepresentationModelAssembler<AppCategory, AppCategoryDto> {
    @Override
    public AppCategoryDto toModel(AppCategory entity) {
        AppCategoryDto appCategoryDto = AppCategoryDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .build();
        Link selfLink = linkTo(methodOn(AppCategoryController.class).getAppCategory(appCategoryDto.getId())).withSelfRel();
        appCategoryDto.add(selfLink);
        return appCategoryDto;
    }

    @Override
    public CollectionModel<AppCategoryDto> toCollectionModel(Iterable<? extends AppCategory> entities) {
        CollectionModel<AppCategoryDto> appCategoryDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(AppCategoryController.class).getAllAppCategories()).withSelfRel();
        appCategoryDtos.add(selfLink);
        return appCategoryDtos;
    }
}
