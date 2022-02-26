package KJcompany.KSAS.service;

import KJcompany.KSAS.domain.Board;
import KJcompany.KSAS.vo.PageRequestVO;
import org.springframework.data.domain.Page;

public interface BoardService {

	public void register(Board board) throws Exception;

	public Board read(Long boardNo) throws Exception;
	
	public void modify(Board board) throws Exception;
	
	public void remove(Long boardNo) throws Exception;
	
	public Page<Board> list(PageRequestVO pageRequestVO) throws Exception;


}
