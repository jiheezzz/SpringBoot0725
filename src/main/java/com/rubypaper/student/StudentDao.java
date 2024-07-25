package com.rubypaper.student;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentDao {
	List<StudentVO> select(StudentVO vo);
}
