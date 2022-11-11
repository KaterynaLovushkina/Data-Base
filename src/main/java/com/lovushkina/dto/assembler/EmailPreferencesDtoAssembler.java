package com.lovushkina.dto.assembler;

import com.lovushkina.controller.AppCategoryController;
import com.lovushkina.controller.EmailPreferencesController;
import com.lovushkina.domain.AppCategory;
import com.lovushkina.domain.EmailPreferences;
import com.lovushkina.dto.AppCategoryDto;
import com.lovushkina.dto.EmailPreferencesDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
@Component
public class EmailPreferencesDtoAssembler implements RepresentationModelAssembler<EmailPreferences, EmailPreferencesDto> {
    @Override
    public EmailPreferencesDto toModel(EmailPreferences entity) {
        EmailPreferencesDto emailPreferencesDto = EmailPreferencesDto.builder()
                .email(entity.getEmail())
                .keepWithUpToDateNews(entity.getKeepWithUpToDateNews())
                .receiveReplyNotification(entity.getReceiveReplyNotification())
                .userId(entity.getUserId())
                .build();
        Link selfLink = linkTo(methodOn(EmailPreferencesController.class).getEmailPreferences(emailPreferencesDto.getEmail())).withSelfRel();
        emailPreferencesDto.add(selfLink);
        return emailPreferencesDto;
    }

    @Override
    public CollectionModel<EmailPreferencesDto> toCollectionModel(Iterable<? extends EmailPreferences> entities) {
        CollectionModel<EmailPreferencesDto> appCategoryDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(AppCategoryController.class).getAllAppCategories()).withSelfRel();
        appCategoryDtos.add(selfLink);
        return appCategoryDtos;
    }
}
