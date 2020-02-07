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

import com.cid.beans.UserDto;
import com.cid.beans.UserSearchDto;
import com.cid.service.UserService;
import com.cid.utils.BeanMappingUtils;
import com.cid.web.beans.ResponseBean;

@Controller
@CrossOrigin
@RequestMapping("/rest/user")
public class UserRestController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/save", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes= MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseBean<String> moduleProcess(@RequestBody UserDto userDto) {
        userService.saveUser(userDto);
        return new ResponseBean<>("User Saved");
    }   

    @RequestMapping(value = "/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseBean<UserDto> find(@PathVariable Long id) {
        UserDto userDto = userService.findById(id);
        return new ResponseBean<UserDto>(userDto);
    }
   
    /*@RequestMapping(value = "/search", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes= MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseBean<List<UserDto>> userSearch(@RequestBody UserSearchDto userSearchDto) {
        List<UserDto> userDtos = userService.searchUsers(userSearchDto)
                .stream()
                .map(BeanMappingUtils::model2Dto)
                .collect(Collectors.toList());
        return new ResponseBean<List<UserDto>>(userDtos);
    }*/
    
    @RequestMapping(value = "/edit", method = RequestMethod.POST,
    		produces = MediaType.APPLICATION_JSON_VALUE,
    		consumes= MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	ResponseBean<UserDto> userEditSubmit(@RequestBody UserDto userDto) {
		userService.saveUser(userDto);
		return new ResponseBean<UserDto>(userDto);
	}

}
