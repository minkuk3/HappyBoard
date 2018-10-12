package kr.co.happy;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/boardList")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BoardListServlet() {
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String btype = request.getParameter("btype");
		String page = request.getParameter("page");
		
		//http://localhost:8077/HappyBoard/boardList ? null일때 아무것도 없을때 넣어준다 
		int intBtype = 0;
		if(btype != null) {
			intBtype = Integer.parseInt(btype);
		}
		
		int intPage = 1;
		if(page != null) {			
			intPage = Integer.parseInt(page);
		}
		//DB에서 자료 가져오기
		BoardDAO dao = BoardDAO.getInstance();
		ArrayList<BoardDTO> list = dao.getBoardList(intBtype, intPage);
		
		request.setAttribute("date", list);
		String target = "boardList";
		request.setAttribute("target", target);
		RequestDispatcher rd = request.getRequestDispatcher("template.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
