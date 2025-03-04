package vn.edu.NguyenKhang;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class doPOST
 */
@WebServlet("/doPOST")
public class doPOST extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doPOST() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        String value1 = request.getParameter("fname");
        String value2 = request.getParameter("lname");
        PrintWriter traVe = response.getWriter();
        traVe.append("Bạn vừa gửi Yêu cầu dạng POST, đây là đáp ứng của tôi");
        traVe.append("Giá trị tham số fname = ").append(value1).append("\n");
        traVe.append("Giá trị tham số lname = ").append(value2);
	}

}
