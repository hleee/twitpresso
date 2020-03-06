package com.codepresso.twitpresso.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codepresso.twitpresso.domain.ResponseVo;
import com.codepresso.twitpresso.domain.UserVo;
import com.codepresso.twitpresso.service.UserService;

@RestController
@RequestMapping("/*")
public class UserController {

	static Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	public ResponseVo responseVo;

	@Autowired
	public UserService userService;

	@Autowired
	public UserVo userVo;

	// 단일 회원 삽입
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ResponseVo insertOneUser(@RequestBody UserVo userVo) throws Exception {
		return userService.insertOneUser(userVo);
	}

	// 전체 회원 조회
	@RequestMapping(value = "/user/all", method = RequestMethod.GET)
	public ResponseVo selectAllUsers() throws Exception {
		return userService.selectAllUsers();
	}

	// ID로 단일 회원 조회
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ResponseVo selectOneUserById(@RequestParam("id") Long id) throws Exception {
		return userService.selectOneUserById(id);
	}

}
