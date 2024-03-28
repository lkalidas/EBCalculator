package ebFile;

import java.io.IOException;
import java.io.PrintWriter;

//import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CalAmt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String u = request.getParameter("ucon");
		double unit = Double.parseDouble(u);
		double totalamt=0;
		if (unit >= 1 && unit <= 500) {
			double u1to100 = 0.0;
			double u101to200 = 2.25;
			double u201to400 = 4.5;
			double u401to500 = 6.0;
			if (unit <= 100) {
				 totalamt = unit * u1to100;

			} else if (unit <= 200) {
				 totalamt = 100 * u1to100 + (unit - 100) * u101to200;

			} else if (unit <= 400) {
				 totalamt = 100 * u1to100 + 100 * u101to200 + (unit - 200) * u201to400;

			} else if (unit <= 500) {
				 totalamt = 100 * u1to100 + 100 * u101to200 + 100 * u201to400 + (unit - 400) * u401to500;

			}
		} else if (unit >= 501) {
			double u1to100 = 0.0;
			double u101to400 = 4.5;
			double u401to500 = 6.0;
			double u501to600 = 8.0;
			double u601to800 = 9.0;
			double u801to1000 = 10.0;
			double u1000above = 11.0;
			 if (unit <= 600) {
				totalamt = 100 * u1to100 + 300 * u101to400 + 100 * u401to500 + (unit - 500) * u501to600;

			} else if (unit <= 800) {
				totalamt = 100 * u1to100 + 300 * u101to400 + 100 * u401to500 + 100 * u501to600
						+ (unit - 600) * u601to800;

			} else if (unit <= 1000) {
				totalamt = 100 * u1to100 + 300 * u101to400 + 100 * u401to500 + 100 * u501to600 + 100 * u601to800
						+ (unit - 800) * u801to1000;
			} else if (unit >= 1000) {
				totalamt = 100 * u1to100 + 300 * u101to400 + 100 * u401to500 + 100 * u501to600 + 100 * u601to800
						+ 100 * u801to1000 + (unit - 1000) * u1000above;
			}
		}
		request.setAttribute("totalamt", totalamt);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
