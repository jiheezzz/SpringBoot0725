package com.rubypaper.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	StudentDao dao;
	
	StudentServiceImpl(){
		System.out.println("StudentServiceImpl 생성자");
	}
	@Override
	public List<StudentVO> select(StudentVO vo) {
		// TODO Auto-generated method stub
		return dao.select(vo);
	}

}
