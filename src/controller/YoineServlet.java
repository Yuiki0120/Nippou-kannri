package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Yoine;
import models.YoineLogic;

/**
 * Servlet implementation class YoineServlet
 */
@WebServlet("/YoineServlet")
public class YoineServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public YoineServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext sc = this.getServletContext();
        Yoine y = (Yoine) sc.getAttribute("yoine");

        if(y == null) {
            y = new Yoine();
            sc.setAttribute("yoine", y);
        }

            request.setCharacterEncoding("UTF-8");
            String yoine = request.getParameter("action");

        if (yoine != null) {

            YoineLogic yl = new YoineLogic();
            yl.yoinePlus(y);

            sc.setAttribute("yoine", y);
        }

        RequestDispatcher rd = request.getRequestDispatcher("/yoineView.jsp");
        rd.forward(request, response);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}