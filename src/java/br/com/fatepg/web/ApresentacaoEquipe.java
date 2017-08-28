/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatepg.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Muca
 */
@WebServlet(name = "ApresentacaoEquipe", urlPatterns = {"/home.php"})
public class ApresentacaoEquipe extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Apresentação da Equipe</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Apresentação da Equipe:</h1>");
            out.println("<ul>");
            out.println("<li>Diogo Atila Rodrigues de Carvalho</li>");
            out.println("<li>Murilo Xavier Lucio</li>");
            out.println("<li>Raul Gomes Pires Guedes da Silva (foragido)</li>");
            out.println("<li>Tiago Aniceto do Carmo (foragido)</li>");
            out.println("</ul>");
            out.println("<h1>Sobre a aplicação:</h1>");
            out.println("<p>Esta aplicação consiste em apresentar a equipe, e disponibilizar "
                    + "dois links para páginas distintas, uma efetuando o cálculo de juros "
                    + "simples, e outra calculando juros composto.</p>");
            out.println("<p> Os links estão disponíveis abaixo:</p>");
            out.println("<a href='juros-simples.php'>Juros Simples</a><br/>");
            out.println("<a href='juros-composto.php'>Juros Composto</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
