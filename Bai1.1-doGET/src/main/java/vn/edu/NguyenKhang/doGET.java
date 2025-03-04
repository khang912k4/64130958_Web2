package vn.edu.NguyenKhang;

import jakarta.servlet.ServletException;
import java.io.PrintWriter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class doGET
 */
@WebServlet("/doGET")
public class doGET extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doGET() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String value1 = request.getParameter("param1");
        String value2 = request.getParameter("param2");
        PrintWriter traVe = response.getWriter();
        traVe.append("Giá trị tham số param1 = ").append(value1).append("\n");
        traVe.append("Giá trị tham số param2 = ").append(value2);
	}

}
