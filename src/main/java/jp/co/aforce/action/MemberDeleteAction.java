package jp.co.aforce.action;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jp.co.aforce.bean.MemberBean;
import jp.co.aforce.dao.LoginDAO;
import jp.co.aforce.dao.MemberDAO;

public class MemberDeleteAction extends Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		if(request.getParameter("delete_buttom") != null ) {
			HttpSession session = request.getSession();
			
			MemberBean member=(MemberBean)session.getAttribute("member");
			String login_id= member.getLogin_id();
			System.out.println(login_id);
			
			MemberDAO member_dao = new MemberDAO();
			member_dao.delete(login_id);
			LoginDAO login_dao = new LoginDAO();
			login_dao.delete(login_id);
			
			session.invalidate();
			request.setAttribute("member_deltet_success", "success");
			return "/views/login.jsp";
		}else {
			return "/views/login-welcome.jsp";
		}
	}

}
