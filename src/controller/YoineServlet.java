package controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Report;
import utils.DBUtil;

/**
 * Servlet implementation class YoineServlet
 */
@WebServlet("/yoine")
public class YoineServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    /**
     * @see HttpServlet#HttpServlet()
     */
    public YoineServlet() {
        super();
    }

    /**
     * @param yoine
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();
        Report r = em.find(Report.class, Integer.parseInt(request.getParameter("id")));

        int s = r.getYoine();
        s++;
        System.out.println(s);

        request.setAttribute("yoine",s);

        r.setYoine(s);;

        em.getTransaction().begin();
        em.getTransaction().commit();
        em.close();

        response.sendRedirect(request.getContextPath() + "/reports/show?id="+ r.getId());

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String yoine = request.getParameter("yoine");
        if(yoine!= null && yoine.equals(request.getSession().getId())) {
            EntityManager em = DBUtil.createEntityManager();
            Report m = em.find(Report.class,(request.getSession().getAttribute("yoine")));
            String title = request.getParameter("title");
            m.setTitle(title);

            String content = request.getParameter("content");
            m.setContent(content);

            em.getTransaction().begin();
            em.getTransaction().commit();
            em.close();

            response.sendRedirect(request.getContextPath() + "/show");
        }
    }}