package br.unitins.sac.report;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unitins.sac.factory.JPAFactory;

public abstract class ReportServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String nome = request.getServletContext().getRealPath("/WEB-INF/reports/AlunoReport.jasper");
            
            EntityManager em = JPAFactory.getEntityManager();
            em.getTransaction().begin();
   
            Connection connection = em.unwrap(Connection.class);
        
            Map<String, Object> parametros = new HashMap<String, Object>();

            GeradorRelatorio gerador = new GeradorRelatorio(nome, parametros, connection);
            gerador.gerarPDFParaOutputStream(response.getOutputStream());
            
            em.getTransaction().commit();
            if (!connection.isClosed())
            		connection.close();
        } catch (SQLException e) {
            throw new ServletException(e);
        }   
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String nome = request.getServletContext().getRealPath("/WEB-INF/reports/AlunoReport.jasper");
            
            EntityManager em = JPAFactory.getEntityManager();
            em.getTransaction().begin();
   
            Connection connection = em.unwrap(Connection.class);
        
            Map<String, Object> parametros = new HashMap<String, Object>();

            GeradorRelatorio gerador = new GeradorRelatorio(nome, parametros, connection);
            gerador.gerarPDFParaOutputStream(response.getOutputStream());
            
            em.getTransaction().commit();
            if (!connection.isClosed())
            		connection.close();
        } catch (SQLException e) {
            throw new ServletException(e);
        }         
    }
}