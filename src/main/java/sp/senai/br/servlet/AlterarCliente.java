package sp.senai.br.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sp.senai.br.dao.ClientesDao;
import sp.senai.br.model.Cliente;

@WebServlet("/alterarcliente")
public class AlterarCliente extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("txtId"));
		String nome = request.getParameter("txtNome");
		String telefone = request.getParameter("txtTelefone");
		String endereco = request.getParameter("txtEndereco");
		
		Cliente c = new Cliente();
		c.setIdCliente(id);
		c.setNomeCliente(nome);
		c.setTelefoneCliente(telefone);
		c.setEnderecoCliente(endereco);
		
		ClientesDao clientesDao = new ClientesDao();
		if (clientesDao.alterarCliente(c)) {
			response.sendRedirect("/ClientesJSP-FINAL/listaclientes");
		} else {
			System.out.print(c.getIdCliente());
			response.sendRedirect("/ClientesJSP-FINAL/detalhacliente?txtId=" + id);
		}
	}

}
