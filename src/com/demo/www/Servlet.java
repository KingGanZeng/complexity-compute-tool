package com.demo.www;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;
import com.demo.antlr4.app.Main;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setStatus(200);
        response.setHeader("Access-Control-Allow-Origin", "*");
        //数据获取
        String codeData = request.getParameter("code");
        //写入到前台
        Main result = new Main();
        String a;
        JSONObject jsonObject = new JSONObject();
        try {
            a = result.main(codeData);
            System.out.println(a);
            JSONObject newA = JSONObject.fromObject(a);
            jsonObject.put("data", newA);
            response.getWriter().write(jsonObject.toString());
        } catch (Exception e) {
            jsonObject.put("error", e);
            response.getWriter().write(jsonObject.toString());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
