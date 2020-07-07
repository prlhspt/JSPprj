package com.example.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calcpage")
public class CalcPage extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Cookie[] cookies = request.getCookies();

		String exp = "0";
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("exp")) {
					exp = c.getValue();
					break;
				}
			}
		}

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();

		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"UTF-8\">");
		out.write("<title>Insert title here</title>");
		out.write("<style>");
		out.write("input{");
		out.write("width:50px;");
		out.write("height:50px;");
		out.write("}");
		out.write(".output{");
		out.write("height: 50px;");
		out.write("background : #e9e9e9;");
		out.write("font-size:24px;");
		out.write("font_weight:bold;");
		out.write("text-align: right;");
		out.write("padding:0px 5px;");
		out.write("}");
		out.write("</style>");
		out.write("</head>");
		out.write("<body>");
		out.write("<div>");
		out.write("<form action=\"calc3\" method=\"post\">");
		out.write("<table>");
		out.write("<tr>");
		out.write("<td class=output colspan=\"4\">" + exp + "</td>");
		out.write("</tr>");
		out.write("<tr>");
		out.write("<td><input name=\"operator\" type=\"submit\" value=\"CE\" /></td>");
		out.write("<td><input name=\"operator\" type=\"submit\" value=\"C\" /></td>");
		out.write("<td><input name=\"operator\" type=\"submit\" value=\"BS\" /></td>");
		out.write("	<td><input name=\"operator\" type=\"submit\" value=\"/\" /></td>");
		out.write("</tr>");
		out.write("<tr>");
		out.write("	<td><input name=\"value\" type=\"submit\" value=\"7\" /></td>");
		out.write("	<td><input name=\"value\" type=\"submit\" value=\"8\" /></td>");
		out.write("	<td><input name=\"value\" type=\"submit\" value=\"9\" /></td>");
		out.write("	<td><input name=\"operator\" type=\"submit\" value=\"*\" /></td>");
		out.write("	</tr>");
		out.write("	<tr>");
		out.write("		<td><input name=\"value\" type=\"submit\" value=\"4\" /></td>");
		out.write("		<td><input name=\"value\" type=\"submit\" value=\"5\" /></td>");
		out.write("		<td><input name=\"value\" type=\"submit\" value=\"6\" /></td>");
		out.write("	<td><input name=\"operator\" type=\"submit\" value=\"-\" /></td>");
		out.write("	</tr>");
		out.write("	<tr>");
		out.write("	<td><input name=\"value\" type=\"submit\" value=\"1\" /></td>");
		out.write("		<td><input name=\"value\" type=\"submit\" value=\"2\" /></td>");
		out.write("		<td><input name=\"value\" type=\"submit\" value=\"3\" /></td>");
		out.write("		<td><input name=\"operator\" type=\"submit\" value=\"+\" /></td>");
		out.write("</tr>");
		out.write("<tr>");
		out.write("	<td></td>");
		out.write("	<td><input name=\"value\" type=\"submit\" value=\"0\" /></td>");
		out.write("	<td><input name=\"dot\" type=\"submit\" value=\".\" /></td>");
		out.write("	<td><input name=\"operator\" type=\"submit\" value=\"=\" /></td>");
		out.write("</tr>");
		out.write("</table>");
		out.write(" </form>");
		out.write(" </div>");
		out.write("</body>");
		out.write("</html>");

	}

}
