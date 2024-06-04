package jp.co.aforce.action;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jp.co.aforce.bean.MemberBean;
import jp.co.aforce.dao.LoginDAO;
import jp.co.aforce.dao.MemberDAO;

public class LoginAction extends Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		HttpSession session=request.getSession();
		
		request.setCharacterEncoding("utf-8");
		String login_name=request.getParameter("login_name");
		String password = request.getParameter("password");
		
		LoginDAO login_dao = new LoginDAO();
		MemberBean member=login_dao.search(login_name, password);

		
		//データベースに存在しない場合
		if(member == null) {
			request.setAttribute("login_name", login_name);
			return "/views/login.jsp";
		}else {		
			MemberDAO member_dao = new MemberDAO();
			member_dao.search(member);
			session.setAttribute("member", member);
			return "/views/login-welcome.jsp";	
		}
		
		
	}

}
