/**
 * @Title APIServlet.java 
 * @Package com.hsnet.pz.api 
 * @Description 
 * @author miyb  
 * @date 2015-3-24 下午4:23:53 
 * @version V1.0   
 */
package com.std.account;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.std.account.proxy.DispatcherImpl;
import com.std.account.proxy.IDispatcher;

/** 
 * @author: miyb 
 * @since: 2015-3-24 下午4:23:53 
 * @history:
 */
public class APIServlet extends HttpServlet {
    static Logger logger = Logger.getLogger(APIServlet.class);

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 6175432226630152841L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        logger.info("Successful Deployment");
        PrintWriter writer = response.getWriter();
        writer.append("Version:3.3.1 \n");
        writer.append("Description:1_1st \n");

        writer.append("\n history ******************** \n");
        writer.append("Version:3.3.0 \n");
        writer.append("Description:4th \n");
        writer.append("Version:3.1.2 \n");
        writer.append("Description:1st \n");
        writer.append("Version:3.1.1 \n");
        writer.append("Description:2_1nd \n");
        writer.append("Version:3.1.0 \n");
        writer.append("Description:2nd \n");
        writer.append("Version:2.0.0 \n");
        writer.append("Description:10th \n");
        writer.flush();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        String json = request.getParameter("json");
        IDispatcher dispatcher = new DispatcherImpl();
        String result = dispatcher.doDispatcher(code, json);
        PrintWriter writer = response.getWriter();
        writer.append(result);
        writer.flush();
    }
}
