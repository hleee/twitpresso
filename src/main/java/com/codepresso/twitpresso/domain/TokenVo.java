package com.codepresso.twitpresso.domain;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Component
@Getter
@Setter
@ToString
public class TokenVo {

	private String token;
	private long userId;
	private String createdAt;

}
