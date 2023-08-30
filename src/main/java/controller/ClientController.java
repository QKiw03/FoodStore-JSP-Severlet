package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ClientDAO;
import model.Client;
import util.Encode;

/**
 * Servlet implementation class Client
 */
@WebServlet("/client")
public class ClientController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("login")) {
			dangNhap(request, response);
		}else if(action.equals("register")){
			dangKy(request, response);
		}else if(action.equals("logout")) {
			dangXuat(request, response);
		}else if(action.equals("change-password")) {
			doiMatKhau(request, response);
		}else if(action.equals("change-account")) {
			thayDoiThongTin(request, response);
		}
	}

	private void dangNhap(HttpServletRequest request, HttpServletResponse response) {
		try {
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			
			password = Encode.toSHA1(password);
			
			Client cl = new Client();
			cl.setUserName(userName);
			cl.setPassword(password);
			
			ClientDAO clientDAO = new ClientDAO();
			Client client = clientDAO.selectByIdAndPassword(cl);
			
			String url = "";
			if(client!=null) {
				HttpSession session = request.getSession();
				session.setAttribute("client", client);
				url = "/index.jsp";
			}else {
				request.setAttribute("error", "Tên đăng nhập/ mật khẩu chưa chính xác!");
				url = "/login.jsp";
			}
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void dangKy(HttpServletRequest request, HttpServletResponse response) {
		 try {
			 String userName = request.getParameter("userName");
				String password = request.getParameter("password");
				String passwordAgain = request.getParameter("passwordAgain");
				String fullName = request.getParameter("fullName");
				String sex = request.getParameter("sex");
				String dob = request.getParameter("dob");
				String clientAdress = request.getParameter("clientAdress");
				String shoppingAdress = request.getParameter("shoppingAdress");
				String deliveryAdress = request.getParameter("deliveryAdress");
				String phoneNumber = request.getParameter("phoneNumber");
				String email = request.getParameter("email");
				String allowLaw = request.getParameter("allowLaw");
				request.setAttribute("userName", userName);		
				request.setAttribute("fullName", fullName);
				request.setAttribute("sex", sex);
				request.setAttribute("dob", dob);
				request.setAttribute("clientAdress", clientAdress);
				request.setAttribute("shoppingAdress", shoppingAdress);
				request.setAttribute("deliveryAdress", deliveryAdress);
				request.setAttribute("phoneNumber", phoneNumber);
				request.setAttribute("email", email);
				request.setAttribute("allowLaw", allowLaw);
				
				String url = "";
				
				String error = "";
				ClientDAO clientDAO = new ClientDAO();

				if(clientDAO.checkUserName(userName)) {
					error +="Tên đăng nhập đã tồn tại, vui lòng chọn tên đăng nhập khác.<br/>";
				}
				
				if(!password.equals(passwordAgain)) {
					error +="Mẫu khẩu không khớp.<br/>";
				}else {
					password = Encode.toSHA1(password);
				}
				
				request.setAttribute("error", error);
				
				
				if(error.length()>0) {
					url = "/index.jsp";
				}else {
					Random rd = new Random();
					String idClient = System.currentTimeMillis() + rd.nextInt(1000) +"";
					Client client = new Client(idClient, userName, password, fullName, sex, clientAdress,shoppingAdress, deliveryAdress, 
							Date.valueOf(dob), phoneNumber, email, allowLaw!=null);
					clientDAO.insert(client);
					url = "/success.jsp";
				}
				RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
				rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void dangXuat(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			// Canner session
			session.invalidate();
			response.sendRedirect("index.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void doiMatKhau(HttpServletRequest request, HttpServletResponse response) {
		try {
			String passCurrent = request.getParameter("passCurrent")+"";
			String passNew = request.getParameter("passNew")+"";
			String passNewVerify = request.getParameter("passNewVerify")+"";
			
			String passCurrent_SHA1 = Encode.toSHA1(passCurrent); // Encode mật khẩu nhập vào
			
			String error = "";
			String url = "/changepassword.jsp";
			
			// Kiểm tra với pass trong Database
			HttpSession session = request.getSession();
			Object obj = session.getAttribute("client");
			Client client = null;
			if (obj != null) {
				client = (Client)obj;  
			}
			
			if(client==null) {
				 error = "Bạn chưa đăng nhập vào hệ thống!";
			}else { // nếu đăng nhập thành công
				if(!passCurrent_SHA1.equals(client.getPassword())) {
					System.out.println(passCurrent_SHA1);
					error = "Mật khẩu hiện tại chưa chính xác";
				}else {
					if(passNew.equals(passCurrent)) {
						error = "Mật khẩu mới phải khác mật khẩu cũ!";
					}else {
						if(!passNew.equals(passNewVerify)) {
							error = "Mật khẩu nhập lại chưa chính xác";
						}else {
							String newPass_Sha1 = Encode.toSHA1(passNew);
							client.setPassword(newPass_Sha1);
							ClientDAO clientDAO = new ClientDAO();
							if(clientDAO.changePassword(client)) {
								error = "Mật khẩu đã thay đổi thành công";
								url = "/success2.jsp";
							}else {
								error = "Quá trình thay đổi mật khẩu không thành công";
							}
						}
					}
				}
			}
			request.setAttribute("error", error);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void thayDoiThongTin(HttpServletRequest request, HttpServletResponse response) {
		try {
			String fullName = request.getParameter("fullName");
			String sex = request.getParameter("sex");
			String dob = request.getParameter("dob");
			String clientAdress = request.getParameter("clientAdress");
			String shoppingAdress = request.getParameter("shoppingAdress");
			String deliveryAdress = request.getParameter("deliveryAdress");
			String phoneNumber = request.getParameter("phoneNumber");
			String email = request.getParameter("email");

			request.setAttribute("fullName", fullName);
			request.setAttribute("sex", sex);
			request.setAttribute("dob", dob);
			request.setAttribute("clientAdress", clientAdress);
			request.setAttribute("shoppingAdress", shoppingAdress);
			request.setAttribute("deliveryAdress", deliveryAdress);
			request.setAttribute("phoneNumber", phoneNumber);
			request.setAttribute("email", email);

			String error = "";
			String url = "/changeaccount.jsp";

			HttpSession session = request.getSession();
			Object obj = session.getAttribute("client");
			Client client = null;
			if (obj != null) {
				client = (Client) obj;
			}

			if (client == null) {
				error = "Bạn chưa đăng nhập vào hệ thống!";
			} else {

			}
			if (error.length() > 0) {
				System.out.println("Error here");
				url = "/register.jsp";
			} else {
				if (client != null) {
					client.setFullName(fullName);
					client.setSex(sex);
					client.setAddress(clientAdress);
					client.setDeliveryAddress(deliveryAdress);
					client.setShoppingAdress(shoppingAdress);
					client.setDob(Date.valueOf(dob));
					client.setPhoneNumber(phoneNumber);
					client.setEmail(email);
					ClientDAO clientDAO = new ClientDAO();
					if (clientDAO.updateInfomation(client)) {
						error = "Mật khẩu đã thay đổi thành công";
						url = "/success2.jsp";
					}else {
						error = "Quá trình thay đổi thôn tin không thành công";
					}

					url = "/success2.jsp";
				}
			}
			request.setAttribute("error", error);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
