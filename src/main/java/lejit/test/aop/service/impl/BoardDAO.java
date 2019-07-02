package lejit.test.aop.service.impl;

import java.util.List;

import lejit.test.aop.service.BoardVO;

public interface BoardDAO {
	List<BoardVO> selectBoardList() throws Exception;
}
