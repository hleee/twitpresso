package com.codepresso.twitpresso.domain;

import org.springframework.stereotype.Component;

@Component
public class PostVo {

	private Long id;
	private Long userId;
	private String title;
	private String content;
	private String createdAt;

	public PostVo() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		String info = "PostVo: id: " + id + ", userId: " + userId + ", title: " + title + ", content: " + content
				+ ", createdAt: " + createdAt;
		return info;
	}

}
