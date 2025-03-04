package vn.edu.NguyenKhang;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class AboutMe
 */
@WebServlet("/AboutMe")
public class AboutMe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AboutMe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");

        String htmlResponse = """
            <!DOCTYPE html>
            <html lang="vi">
            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>About Me</title>
                <style>
                    body {
                        font-family: Arial, sans-serif;
                        text-align: center;
                        background: linear-gradient(to right, #f7cac9, #92a8d1);
                        padding: 50px;
                    }
                    .card {
                        background: white;
                        border-radius: 10px;
                        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
                        padding: 20px;
                        max-width: 600px;
                        margin: auto;
                    }
                    h1 {
                        color: #444;
                    }
                    p {
                        color: #666;
                        line-height: 1.6;
                    }
                    .avatar {
                        border-radius: 50%;
                        width: 150px;
                        height: 150px;
                        object-fit: cover;
                        margin-bottom: 20px;
                    }
                </style>
            </head>
            <body>
                <div class="card">
                    <img src="images/avatar.jpg" alt="Avatar" class="avatar">
                    <h1>Nguyễn Phúc  </h1>
                    <p><strong>Tuổi:</strong> 21</p>
                    <p><strong>Sở thích:</strong> Poker </p>
                    <p><strong>Email:</strong> khang912k4@gmail.com</p>
                </div>
            </body>
            </html>
        """;

        response.getWriter().write(htmlResponse);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
