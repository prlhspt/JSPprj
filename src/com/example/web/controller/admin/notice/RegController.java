package com.example.web.controller.admin.notice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.example.web.entity.Notice;
import com.example.web.service.NoticeService;

@MultipartConfig(
		fileSizeThreshold=1024*1024, // 파일 디스크에 저장할 임계점(낮으면 메모리에), 1024byte*1024byte = 1mb
		maxFileSize=1024*1024*50, // 파일 하나의 최대크기, 50mb
		maxRequestSize=1024*1024*50*5 // 한번에 보낼 수 있는 전체 파일의 최대크기, 250mb
)
@WebServlet("/admin/board/notice/reg")
public class RegController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request
		.getRequestDispatcher("/WEB-INF/view/admin/board/notice/reg.jsp")
		.forward(request, response);	
		
	}
	
	@Override 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType	("text/html; charset=UTF-8");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String isOpen = request.getParameter("open");
		
		System.out.print("title : ");
		System.out.println(title);
		
		Collection<Part> parts = request.getParts();
		StringBuilder builder = new StringBuilder();
		
		for(Part p : parts) {
			if(!p.getName().equals("file")) continue;
			if(p.getSize() == 0) continue;
			
			Part filePart = p;
			String fileName = filePart.getSubmittedFileName();
			builder.append(fileName);
			builder.append(",");
			
			InputStream fis = filePart.getInputStream();
			
			String realPath = request.getServletContext().getRealPath("/member/upload");
			System.out.println(realPath);
			
			File path = new File(realPath);
			if(!path.exists());
				path.mkdirs();
			
			
			// 파일 이름 중복일시 ..(1).jpg, ..(2).jpg 식으로 저장되게 하기 만들기 위치	
			String filePath = realPath + File.separator + fileName;
			FileOutputStream fos = new FileOutputStream(filePath);
			
			byte[] buf = new byte[1042];
			int size = 0;
			while((size=fis.read(buf)) != -1) 
				fos.write(buf, 0, size);
			
			fos.close();
			fis.close();
	}
		
		// 파일 없이도 업로드 되게 하기 만들어야할 위치
		// builder.length-1	부터 builder.length까지 문자 삭제(쉼표)
		builder.delete(builder.length()-1, builder.length());
		
		boolean pub = false;
		if(isOpen != null)
			pub = true;
			
		Notice notice = new Notice();
		notice.setTitle(title);
		notice.setContent(content);
		notice.setPub(pub);  
		notice.setWriterId("newlec");
		notice.setFiles(builder.toString());
		
		NoticeService service = new NoticeService();
		int result = service.insertNotice(notice);
		
		PrintWriter out = response.getWriter();
		out.printf("title : %s<br>", title);
		out.printf("content : %s<br>", content);
		out.printf("open : %s<br>", isOpen);
		
		response.sendRedirect("list");
	}
}