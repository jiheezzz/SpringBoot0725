package com.rubypaper.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardDao {
	void insert(BoardVO vo);
	List<BoardVO> select(BoardVO vo);
	BoardVO edit(BoardVO vo);
	void delete(BoardVO vo);
	void update(BoardVO vo);
	int tc(BoardVO vo);
}
