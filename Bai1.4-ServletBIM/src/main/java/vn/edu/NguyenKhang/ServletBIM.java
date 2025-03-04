package vn.edu.NguyenKhang;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ServletBIM
 */
@WebServlet("/ServletBIM")
public class ServletBIM extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletBIM() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        
        response.getWriter().println("<html><head><title>BMI Calculator</title></head><body>");
        response.getWriter().println("<h2>Tính chỉ số BMI</h2>");
        response.getWriter().println("<form method='post' action='/BMI'>");
        response.getWriter().println("Chiều cao (m): <input type='text' name='height' required/><br>");
        response.getWriter().println("Cân nặng (kg): <input type='text' name='weight' required/><br>");
        response.getWriter().println("<button type='submit'>Tính BMI</button>");
        response.getWriter().println("</form>");
        response.getWriter().println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		double height = Double.parseDouble(request.getParameter("height"));
        double weight = Double.parseDouble(request.getParameter("weight"));
        double bmi = weight / (height * height);
        String status;

  
        if (bmi < 18.5) {
            status = "Gầy";
        } else if (bmi >= 18.5 && bmi < 24.9) {
            status = "Bình thường";
        } else if (bmi >= 25 && bmi < 29.9) {
            status = "Thừa cân";
        } else {
            status = "Béo phì";
        }

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().println("<html><head><title>Kết quả BMI</title></head><body>");
        response.getWriter().println("<h2>Kết quả BMI của bạn:</h2>");
        response.getWriter().println("<p>Chiều cao: " + height + " m</p>");
        response.getWriter().println("<p>Cân nặng: " + weight + " kg</p>");
        response.getWriter().println("<p>Chỉ số BMI: " + String.format("%.2f", bmi) + "</p>");
        response.getWriter().println("<p>Tình trạng: " + status + "</p>");
        response.getWriter().println("<a href='/BMI'>Tính lại</a>");
        response.getWriter().println("</body></html>");
	}

}
