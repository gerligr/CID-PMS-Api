package com.cid.web.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cid.beans.SalesDto;
import com.cid.beans.SalesSearchDto;
import com.cid.beans.UserDto;
import com.cid.service.SalesService;
import com.cid.service.UserService;
import com.cid.utils.BeanMappingUtils;
import com.cid.web.beans.ResponseBean;

@Controller
@CrossOrigin
@RequestMapping("/rest/sales")
public class SalesRestController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private SalesService salesService;

    /*@RequestMapping(value = "/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseBean<UserDto> find(@PathVariable Long id) {
        UserDto userDto = userService.findById(id);
        return new ResponseBean<UserDto>(userDto);
    }*/
   
    @RequestMapping(value = "/search", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes= MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseBean<List<SalesDto>> salesSearch(@RequestBody SalesSearchDto salesSearchDto) {
        List<SalesDto> salesDtos = salesService.searchSales(salesSearchDto)
                .stream()
                .map(BeanMappingUtils::salesModel2Dto)
                .collect(Collectors.toList());
        return new ResponseBean<List<SalesDto>>(salesDtos);
    }   

}
