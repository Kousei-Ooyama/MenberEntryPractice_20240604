package jp.co.aforce.action;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jp.co.aforce.bean.MemberBean;
import jp.co.aforce.dao.LoginDAO;
import jp.co.aforce.dao.MemberDAO;

public class MemberEntryAction extends Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		request.setCharacterEncoding("utf-8");
		String login_name=request.getParameter("login_name");
		String password =request.getParameter("password");
		String password_again = request.getParameter("password_again");
		String last_name = request.getParameter("last_name");
		String first_name = request.getParameter("first_name");
		String gender = request.getParameter("gender");
		String phone_number = request.getParameter("phone_number");
		String mail_address = request.getParameter("mail_address");
		String job = request.getParameter("job");
		//生年月日が数字じゃなかった場合は例外処理で登録フォーム画面に
		try {
			int birth_year = Integer.parseInt(request.getParameter("birth_year"));
			int birth_month = Integer.parseInt(request.getParameter("birth_month"));
			int birth_day = Integer.parseInt(request.getParameter("birth_day"));
			
			//どのボタンが押されたかの条件分岐
			if(request.getParameter("entry_button") != null) {
				
				//登録ボタンが押されたとき
				if (password.equals(password_again)) {
					LoginDAO login_dao = new LoginDAO();
					//ログインテーブル内に該当のログイン名がなかった場合のみinsert処理
					if (login_dao.search(login_name) == null) {
						
						//phone_numberに数値以外が含まれている
						//またmail_addressに@がない場合
						if(!(phone_number.matches("[0-9]+"))) {
							//数値以外が入ってる
							request.setAttribute("entry_result", "phone_number-noint-error");
						}else if(!(mail_address.contains("@"))) {
							//@が入っていない
							request.setAttribute("entry_result", "mail_address-no@-error");
						}else {
							login_dao.insert(login_name, password);
							MemberBean member = login_dao.search(login_name);
						
							MemberDAO member_dao = new MemberDAO();
							member_dao.insert
							(member, last_name, first_name, gender, birth_year, birth_month, 
									birth_day, phone_number, mail_address, job);
							return "/views/member-entry-success.jsp";
						}
						
					} else {
						request.setAttribute("entry_result", "login_name-error");
					}
				}else {
					//パスワードのどちらかが異なるのでもう一度
					request.setAttribute("entry_result", "password-error");
				}
				
				return "/views/member-entry.jsp";
				
			}else if(request.getParameter("return_button") != null) {
				
				//戻るボタンが押されたとき
				return "/views/login.jsp";
			}else{
				
				//こちらはリセットボタンが押されたとき
				return "/views/member-entry.jsp";
			}
		}catch(Exception e){
			request.setAttribute("entry_result", "format-int-error");
			return "/views/member-entry.jsp";
		}
		
	}

}
