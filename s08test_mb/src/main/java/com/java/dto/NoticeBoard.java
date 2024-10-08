package com.java.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.java.dto.Usermember;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoticeBoard {
	private int nbno;
	private int uno;
	private String nbtitle;
	private String nbcontent;
	
	Usermember user;
}
