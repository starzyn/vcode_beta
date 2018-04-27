package cn.starzyn.servlet;

import cn.starzyn.vcode.Vcode;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class VCodeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        Object vc = request.getSession().getAttribute("vc");
        System.out.println("hehe");
        if(vc != null) {
            if (vc instanceof Vcode) {
//                System.out.println("yeah");
               if(((Vcode) vc).getCode().equalsIgnoreCase(code)){
                   response.getWriter().print("bingo!");
               }else {
                   response.sendRedirect("/index.jsp");
               }
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Vcode vc = new Vcode();
        BufferedImage img = vc.getImage();
//        System.out.println(vc.getCode());
        request.getSession().setAttribute("vc",vc);
        Vcode.saveImage(img,response.getOutputStream());
    }
}
