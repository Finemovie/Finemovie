package com.green.Finemovie.domain.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MyRole {
	USER("USER"),
	ADMIN("ADMIN");
	private final String roleName;
}

