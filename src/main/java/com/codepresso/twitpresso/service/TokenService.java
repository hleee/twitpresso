package com.codepresso.twitpresso.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.codepresso.twitpresso.domain.ResponseVo;
import com.codepresso.twitpresso.domain.TokenVo;
import com.codepresso.twitpresso.domain.UserVo;
import com.codepresso.twitpresso.repository.TokenDao;
import com.codepresso.twitpresso.repository.UserDao;
import com.codepresso.twitpresso.util.TokenMaker;

@Service
public class TokenService {

	static Logger logger = LoggerFactory.getLogger(TokenService.class);

	@Autowired
	public TokenDao tokenDao;

	@Autowired
	public TokenVo tokenVo;

	@Autowired
	public UserDao userDao;

	@Autowired
	public ResponseVo responseVo;

	@Autowired
	public UserVo userVo;

	// 토큰 발급 및 저장
	public ResponseVo insertOneToken(UserVo userVo) throws Exception {
		userVo = userDao.selectOneUserByUsernameAndPassword(userVo);
		long id = userVo.getId();
		String token = TokenMaker.makeToken();
		tokenVo.setToken(token);
		tokenVo.setUserId(id);
		tokenDao.insertOneToken(tokenVo);
		tokenVo = tokenDao.selectOneTokenRowByToken(token);
		responseVo.setCode(HttpStatus.OK.value());
		responseVo.setMessage("Success");
		responseVo.setData(tokenVo);
		return responseVo;
	}

	// 토큰으로 토큰 테이블의 열 정보 조회
	public TokenVo selectOneTokenRowByToken(String token) {
		return tokenDao.selectOneTokenRowByToken(token);
	}

}
