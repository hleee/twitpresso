package com.codepresso.twitpresso.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codepresso.twitpresso.domain.ResponseVo;
import com.codepresso.twitpresso.domain.TokenVo;
import com.codepresso.twitpresso.domain.UserVo;
import com.codepresso.twitpresso.service.TokenService;

@RestController
@RequestMapping("/*")
public class TokenController {

	static Logger logger = LoggerFactory.getLogger(TokenController.class);

	@Autowired
	public TokenVo tokenVo;

	@Autowired
	public ResponseVo responseVo;

	@Autowired
	public TokenService tokenService;

	// 토큰 등록
	@RequestMapping(value = "/auth", method = RequestMethod.POST)
	public ResponseVo insertOneToken(@RequestBody UserVo userVo) throws Exception {
		return tokenService.insertOneToken(userVo);
	}
}
