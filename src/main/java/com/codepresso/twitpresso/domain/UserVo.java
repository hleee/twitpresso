package com.codepresso.twitpresso.domain;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Component
@Getter
@Setter
@ToString
public class UserVo {

	private Long id;
	private String username;
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	private String createdAt;
	private Boolean isFollow;

}