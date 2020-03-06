package com.codepresso.twitpresso.domain;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Component
@Getter
@Setter
@ToString
public class FeedVo {

	private long userId;
	private long followeeId;
	private long postId;
	private String createdAt;

}
