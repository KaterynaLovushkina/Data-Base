package com.lovushkina.controller;

import com.lovushkina.domain.AppCategory;
import com.lovushkina.domain.AppCategory;
import com.lovushkina.dto.AppCategoryDto;
import com.lovushkina.dto.AppDto;
import com.lovushkina.dto.assembler.AppCategoryDtoAssembler;
import com.lovushkina.service.AppCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "appCategories")
public class AppCategoryController {
    @Autowired
    private AppCategoryService appCategoryService;
    @Autowired
    private AppCategoryDtoAssembler appCategoryDtoAssembler;

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<AppCategoryDto>> getAllAppCategories() {
        List<AppCategory> apps = appCategoryService.findAll();
        CollectionModel<AppCategoryDto> appDtos = appCategoryDtoAssembler.toCollectionModel(apps);
        return new ResponseEntity<>(appDtos, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AppCategoryDto> getAppCategory(@PathVariable Integer id) {
        AppCategory appCategory = appCategoryService.findById(id);
        AppCategoryDto appCategoryDto = appCategoryDtoAssembler.toModel(appCategory);
        return new ResponseEntity<>(appCategoryDto, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<AppCategoryDto> addAppCategory(@RequestBody AppCategory appCategory) {
        AppCategory newAppCategory = appCategoryService.create(appCategory);
        AppCategoryDto appCategoryDto = appCategoryDtoAssembler.toModel(newAppCategory);
        return new ResponseEntity<>(appCategoryDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateAppCategory(@RequestBody AppCategory appCategory, @PathVariable Integer id){
        appCategoryService.update(id, appCategory);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteAppCategory(@PathVariable Integer id) {
        appCategoryService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

