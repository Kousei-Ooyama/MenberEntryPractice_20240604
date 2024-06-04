package jp.co.aforce.action;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jp.co.aforce.bean.MemberBean;
import jp.co.aforce.dao.MemberDAO;

public class MemberUpdateAction extends Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		HttpSession session = request.getSession();
		
		MemberBean member = (MemberBean)session.getAttribute("member");
		String login_id = member.getLogin_id();
		
		request.setCharacterEncoding("utf-8");
		String last_name = request.getParameter("last_name");
		String first_name = request.getParameter("first_name");
		String gender = request.getParameter("gender");
		String job = request.getParameter("job");
		String phone_number = request.getParameter("phone_number");
		String mail_address = request.getParameter("mail_address");
		try {
			int birth_year = Integer.parseInt(request.getParameter("birth_year"));
			int birth_month = Integer.parseInt(request.getParameter("birth_month"));
			int birth_day = Integer.parseInt(request.getParameter("birth_day"));
			
			if(request.getParameter("update_buttom") != null) {
				if(!(phone_number.matches("[0-9]+"))) {
					//数値以外が入ってる
					request.setAttribute("update_result", "phone_number-noint-error");
				}else if(!(mail_address.contains("@"))) {
					//@が入っていない
					request.setAttribute("update_result", "mail_address-no@-error");
				}else {
					MemberDAO member_dao = new MemberDAO();
					member_dao.update
						(last_name, first_name, gender, birth_year, birth_month, birth_day, 
						job, phone_number, mail_address, login_id);
					member_dao.search(member);
					
					//更新した情報をセッションに入れ直す
					session.setAttribute("member", member);
					request.setAttribute("update_result", "success");
				}
				return "/views/member_update.jsp";
			}else {
			return "/views/login-welcome.jsp";
			}
		}catch(Exception e) {
			request.setAttribute("update_result", "format-int-error");
			e.printStackTrace();
			return "/views/member_update.jsp";
		}
		
	}

}
