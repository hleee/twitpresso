package com.codepresso.twitpresso.domain;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Component
@Getter
@Setter
@ToString
public class FollowVo {

	private Long followeeId;
	private Long followerId;
	private String createdAt;

}
