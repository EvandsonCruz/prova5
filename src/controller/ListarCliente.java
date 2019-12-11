package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDao;
import model.Cliente;

@WebServlet("/listarCliente")
public class ListarCliente extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			ClienteDao cdao = new ClienteDao();
			List<Cliente> list = cdao.listarCliente();
			PrintWriter pw = resp.getWriter();
			pw.println("<html><head></head><body><table border=1 cellpadding=5>");
			pw.println("<tr><th>Id</th><th>Nome</th><th>Email</th><th>Ações</th></tr>");
			for(Cliente c: list) {
				pw.println("<tr><td>" + c.getId() + "</td><td>"+ c.getNome() + "</td><td>" + c.getEmail()+ "</td><td>" + "<a href='atualizar.jsp?id="+ c.getId() + "&nome="+ c.getNome() + "&email=" + c.getEmail() + "'>Atualizar</a> &nbsp&nbsp&nbsp <a href='excluirCliente?id=" + c.getId() + "'>Excluir </a> </tr>" );
			}
			pw.println("</table>");
			pw.println("<a href='inserir.jsp'>Novo</a>");
			pw.println("</body></html>");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
