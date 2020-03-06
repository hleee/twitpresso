package com.codepresso.twitpresso.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.codepresso.twitpresso.domain.FollowVo;
import com.codepresso.twitpresso.domain.ResponseVo;
import com.codepresso.twitpresso.domain.TokenVo;
import com.codepresso.twitpresso.domain.UserVo;
import com.codepresso.twitpresso.repository.FollowDao;
import com.codepresso.twitpresso.repository.TokenDao;
import com.codepresso.twitpresso.repository.UserDao;

@Service
public class FollowService {

	static Logger logger = LoggerFactory.getLogger(FollowService.class);

	@Autowired
	public FollowVo followVo;

	@Autowired
	public FollowDao followDao;

	@Autowired
	public ResponseVo responseVo;

	@Autowired
	public TokenDao tokenDao;

	@Autowired
	public UserDao userDao;

	@Autowired
	public TokenVo tokenVo;

	// 팔로워-팔로이 한 쌍 삽입
	public ResponseVo insertOneFollow(FollowVo followVo, String token) {
		TokenVo tokenVo = tokenDao.selectOneTokenRowByToken(token);
		Long userId = tokenVo.getUserId();
		UserVo userVo = userDao.selectOneUserById(userId);
		Long followerId = userVo.getId();
		followVo.setFollowerId(followerId);
		int IntegerOneIfInserted = followDao.insertOneFollow(followVo);
		if (IntegerOneIfInserted == 1) {
			responseVo.setCode(HttpStatus.OK.value());
			responseVo.setMessage("OK");
			responseVo.setData("Success");
		} else {
			responseVo.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			responseVo.setMessage("Error");
			responseVo.setData("Failure");
		}
		return responseVo;
	}

	// 팔로워-팔로이 한 쌍 삭제
	public ResponseVo deleteOneFollow(FollowVo followVo, String token) {
		TokenVo tokenVo = tokenDao.selectOneTokenRowByToken(token);
		Long userId = tokenVo.getUserId();
		UserVo userVo = userDao.selectOneUserById(userId);
		Long followerId = userVo.getId();
		followVo.setFollowerId(followerId);
		int IntegerOneIfDeleted = followDao.deleteOneFollow(followVo);
		if (IntegerOneIfDeleted == 1) {
			responseVo.setCode(HttpStatus.OK.value());
			responseVo.setMessage("OK");
			responseVo.setData("Success");
		} else {
			responseVo.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			responseVo.setMessage("Error");
			responseVo.setData("Failure");
		}
		return responseVo;
	}
}
