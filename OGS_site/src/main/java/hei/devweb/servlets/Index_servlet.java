package hei.devweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import hei.devweb.dao.impl.ConnexionForm;
import hei.devweb.dao.impl.MotDePasseUtils;

@WebServlet("/Index")
public class Index_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

  
    public Index_servlet() {
       
    }
private Map<String, String> utilisateursAutorises;
	
	@Override
    public void init() throws ServletException {
		utilisateursAutorises = new HashMap<>();
		utilisateursAutorises.put("admin", "admin");
		
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		 
		 
		
		
		ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(request.getServletContext());
		templateResolver.setTemplateMode(TemplateMode.HTML);
		templateResolver.setPrefix("/webapp/");
		templateResolver.setSuffix(".html");
		templateResolver.setCharacterEncoding("UTF-8");
		templateResolver.setTemplateMode(TemplateMode.HTML);
		
		TemplateEngine templateEngine = new TemplateEngine();
		templateEngine.setTemplateResolver(templateResolver);
		templateEngine.addDialect(new Java8TimeDialect());
		
		WebContext context = new WebContext(request, response,getServletContext());
		
		templateEngine.process("main", context,response.getWriter());
		
		PrintWriter out = resp.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Connexion</title>");
		out.println("</head>");
		out.println("<body>");
		String identifiantConnecte = (String) req.getSession().getAttribute("utilisateurConnecte");
		if (identifiantConnecte == null || "".equals(identifiantConnecte)) {
			out.println("<h1>Veuillez indiquer votre identifiant :</h1>");
			out.println("<form method=\"post\">");
			out.println("<input type=\"text\" name=\"identifiant\">");
			out.println("<input type=\"password\" name=\"motdepasse\">");
			out.println("<input type=\"submit\" value=\"Se connecter\">");
			out.println("</form>");
		} else {
			out.println(String.format("<h1>Bonjour, %s</h1>", identifiantConnecte));
			out.println("<p><a href=\"deconnexion\">Se déconnecter</a></p>");
		}
		out.println("</body>");
		out.println("</html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String identifiantSaisi = request.getParameter("login");
		String motDePasseSaisi = request.getParameter("password");
		try {
			if(utilisateursAutorises.containsKey(identifiantSaisi) && MotDePasseUtils.validerMotDePasse(motDePasseSaisi, utilisateursAutorises.get(identifiantSaisi))) {
				request.getSession().setAttribute("utilisateurConnecte", identifiantSaisi);
			}
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			e.printStackTrace();
		} 
		response.sendRedirect("connexion");
	}

}