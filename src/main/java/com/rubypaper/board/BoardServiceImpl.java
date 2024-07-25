package com.rubypaper.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	BoardDao dao;
	
	BoardServiceImpl(){
		System.out.println("BoardServiceImpl 생성자");
	}

	@Override
	public void insert(BoardVO vo) {
		dao.insert(vo);
	}

	@Override
	public List<BoardVO> select(BoardVO vo) {
		return dao.select(vo);
	}

	@Override
	public BoardVO edit(BoardVO vo) {
		return dao.edit(vo);
	}

	@Override
	public void delete(BoardVO vo) {
		dao.delete(vo);
	}

	@Override
	public void update(BoardVO vo) {
		dao.update(vo);
	}

	@Override
	public int tc(BoardVO vo) {
		// TODO Auto-generated method stub
		return dao.tc(vo);
	}
}
