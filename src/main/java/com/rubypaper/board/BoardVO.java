package com.rubypaper.board;

import java.sql.Date;

import lombok.Data;

@Data
public class BoardVO {
	private String idx;
	private String name;
	private int age;
	private String etc;
	private String regdate;
	private String searchCondition;
	private String searchKeyword;
	private Date regdate2;

}
