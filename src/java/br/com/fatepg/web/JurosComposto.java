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
 * @author diogo
 */
@WebServlet(name = "JurosComposto", urlPatterns = {"/juros-composto.php"})
public class JurosComposto extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");           
            out.println("<title>Calculo Juros CompostoSevlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("</br><h1>Cálculo Juros Composto</h1></br></div>");
            float p = 0;
            float i = 0;
            int n = 0;
            float m = 0;
            float jc = 0;
            float aux = 0;
            try {
                p = Float.parseFloat(request.getParameter("p"));
            } catch (Exception ex) {
                out.println();
            }
            try {
                i = Float.parseFloat(request.getParameter("i"));
            } catch (Exception ex) {
                out.println();
            }
            try {
                n = Integer.parseInt(request.getParameter("n"));
            } catch (Exception ex) {
                out.println();
            }
            out.println("<div class='calculos'>");    
            out.println("<form>");
            out.println("Digite o seu capital:");
            out.println("<br/><input type='text' name='p' value='" + p + "'/> <br/><br/>");

            out.println("Digite a sua taxa de juros(% a.m.):");
            out.println("<br/><input type='text' name='i' value='" + i + "'/><br/><br/>");

            out.println("Digite o número de parcelas/mês):");
            out.println("<br/><input type='text' name='n' value='" + n + "'/><br/>");
            out.println("<input type='submit' value='CALCULAR'/>");

            out.println("</form><br/>");
            out.println("<table>");

            out.println("<tr>");
            out.println("<td>CAPITAL  </td>");
            out.println("<td>JUROS</td>");
            out.println("</tr><br/>");
            out.println("<tr>");
            out.println("<td>" +(p)+ "</td>");
            out.println("<td>" +((p * Math.pow(1 + (i / 100), n))-p) + "</td>");
            out.println("</tr>");
            out.println("<br/>");
            out.println("<tr>");
            out.println("<td>VALOR MENSAL</td>");
            out.println("<td>CAPITAL</td>");
            out.println("<td>JUROS AO MÊS</td>");
            out.println("<td>TOTAL</td>");
            aux = p;
            for (int j = 1; j <= n; j++) {
                jc = (aux * (i / 100));
                m = aux + jc;
                out.println("<tr>");
                out.println("<td>Mês: " + j + " = </td>");
                out.println("<td>" + aux + "</td>");
                out.println("<td>" + jc + "</td>");
                out.println("<td>" + m + "</td>");
                out.println("</tr>");
                aux = m;
            }
            out.println("</td>");
            out.println("</tr>");
            out.println("</table>                                                                       <br/><br/><br/><br/>");
            out.println("</div>");      
            out.println("<a href='home.php'>Voltar a página inicial</a>");
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
