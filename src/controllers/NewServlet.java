package controllers;

import java.io.IOException;
import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Task;
import utils.DBUtil;

/**
 * Servlet implementation class NewServlet
 */
@WebServlet("/new")
public class NewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = DBUtil.createEntityManager();
		em.getTransaction().begin();

		//taskのインスタンス
		Task t = new Task();

		//データ代入
		String content = "todo";
		t.setContent(content);

		Timestamp currentTime = new Timestamp (System.currentTimeMillis());
		t.setCreated_at(currentTime);

		t.setUpdated_at(currentTime);

		//データベース保存
		em.persist(t);
		em.getTransaction().commit();

		//自動裁判されたID番号
		response.getWriter().append(Integer.valueOf(t.getId()).toString());

		em.close();
	}

}
