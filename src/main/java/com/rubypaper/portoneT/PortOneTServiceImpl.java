package com.rubypaper.portoneT;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PortOneTServiceImpl implements PortOneTService{
	@Autowired
	PortOneTDao dao;
	
	PortOneTServiceImpl(){
		System.out.println("PortOneTServiceImpl 생성자");
	}
	

	@Override
	public String insert(PortOneTVO vo) {
		System.out.println("===> insert");
		try {
			dao.insert(vo);
			return "/PortOneT/result?mpaynum="+vo.getMpaynum();
		} catch (Exception e) {
			return "/PortOneT/fail";
		}
	}


	@Override
	public List<PortOneTVO> select(PortOneTVO vo) {
		// TODO Auto-generated method stub
		return dao.select(vo);
	}


	@Override
	public PortOneTVO edit(PortOneTVO vo) {
		// TODO Auto-generated method stub
		return dao.edit(vo);
	}

}
