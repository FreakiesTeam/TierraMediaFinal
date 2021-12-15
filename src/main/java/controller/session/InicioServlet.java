package controller.session;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.InicioService;

@WebServlet("/inicio")
public class InicioServlet extends HttpServlet{
	
	private static final long serialVersionUID = -4203867857578511865L;
	private InicioService inicioService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.inicioService = new InicioService();
	}
	
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setAttribute("frase", inicioService.getFrase());
			req.setAttribute("autor", inicioService.getAutor());
		} catch (IOException | InterruptedException e1) {
			e1.printStackTrace();
		}
		
		RequestDispatcher dispatcher = getServletContext()
  		      .getRequestDispatcher("/index.jsp");
  		    dispatcher.forward(req, resp); 	
    }
	
}