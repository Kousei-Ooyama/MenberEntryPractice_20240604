package jp.co.aforce.action;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LogoutAction extends Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		HttpSession session = request.getSession();
		
		if(session.getAttribute("member") != null) {
			session.invalidate();
			return "/views/logout-bye.jsp";
		}
		
		return "/views/logout-error.jsp";
	}

}
