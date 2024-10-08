package com.java.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto<T> {
	// http 응답으로 사용할 dto 
	private String error;
	private List<T> data;
}
