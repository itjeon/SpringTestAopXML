package lejit.test.aopXML.service.impl;

import java.util.List;

import lejit.test.aopXML.service.BoardVO;

public interface BoardDAO {
	List<BoardVO> selectBoardList() throws Exception;
}
