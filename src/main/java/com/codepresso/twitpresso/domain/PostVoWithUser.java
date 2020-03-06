package com.codepresso.twitpresso.domain;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Component
@Getter
@Setter
@ToString
public class PostVoWithUser {

	private Long id;
	private Long userId;
	private String title;
	private String content;
	private String createdAt;
	private Object user;

}
