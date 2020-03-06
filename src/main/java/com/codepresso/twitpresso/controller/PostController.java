package com.codepresso.twitpresso.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codepresso.twitpresso.domain.PostVo;
import com.codepresso.twitpresso.domain.PostVoWithUser;
import com.codepresso.twitpresso.domain.ResponseVo;
import com.codepresso.twitpresso.domain.UserVo;
import com.codepresso.twitpresso.service.PostService;
import com.codepresso.twitpresso.service.TokenService;
import com.codepresso.twitpresso.service.UserService;

@RestController
@RequestMapping("/*")
public class PostController {

	static Logger logger = LoggerFactory.getLogger(PostController.class);

	@Autowired
	public PostService postService;

	@Autowired
	public PostVo postVo;

	@Autowired
	public UserVo userVo;

	@Autowired
	public ResponseVo responseVo;

	@Autowired
	public TokenService tokenService;

	@Autowired
	public UserService userService;

	@Autowired
	public PostVoWithUser postVoWithUser;

	// 글 저장
	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public ResponseVo insertOnePost(@RequestBody PostVo postVo, @CookieValue("accesstoken") String token)
			throws Exception {
		return postService.insertOnePost(postVo, token);
	}

	// 전체 글 조회
	@RequestMapping(value = "/post", method = RequestMethod.GET)
	public ResponseVo selectAllPosts(@CookieValue(value = "accesstoken", required = false) String token) {
		return postService.selectAllPosts(token);
	}

	// 내 글 조회
	@RequestMapping(value = "/post/my", method = RequestMethod.GET)
	public ResponseVo selectMyPosts(@CookieValue("accesstoken") String token) throws Exception {
		return postService.selectMyPosts(token);
	}

	// 글 상세 조회
	@RequestMapping(value = "/post/{postId}", method = RequestMethod.GET)
	public ResponseVo selectOnePostDetailedView(@PathVariable("postId") long postId) {
		return postService.selectOnePostById(postId);
	}

	// 글 삭제
	@RequestMapping(value = "/post/{postId}", method = RequestMethod.DELETE)
	public ResponseVo deleteOnePost(@PathVariable("postId") long postId) {
		return postService.deleteOnePost(postId);
	}

	// 내 글과 내가 팔로우하는 사람의 글 조회 (피드 기능)
	@RequestMapping(value = "/post/feed", method = RequestMethod.GET)
	public ResponseVo selectFolloweesPostsAndMyPosts(@CookieValue("accesstoken") String token) {
		return postService.selectFolloweesPostsAndMyPosts(token);
	}

	// 글 수정
	@RequestMapping(value = "/post", method = RequestMethod.PUT)
	public ResponseVo updateOnePost(@RequestBody PostVo postVo) {
		return postService.updateOnePost(postVo);
	}

}
