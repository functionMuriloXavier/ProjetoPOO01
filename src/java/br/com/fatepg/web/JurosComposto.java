/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatepg.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
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
            out.println("<title>Calculo Juros Composto</title>");
            out.println("<meta charset='UTF-8' name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("<link rel='stylesheet' type='text/css' href='content/css/style.css'/>");
            out.println("</head>");
            out.println("<body>");
            out.println("<section>");
            out.println("<header>");
            out.println("<h1>Calculando Juros Composto</h1>");
            out.println("</header>");
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
            out.println("<article>");
            out.println("<a href='home.php'>Voltar a página inicial</a>");
            out.println("<div class='calculos'>");    
            out.println("<form>");
            out.println("Digite o seu capital:");
            out.println("<br/><input type='number' step='0.01' required name='p'/><br/><br/>");

            out.println("Digite a sua taxa de juros(% a.m.):");
            out.println("<br/><input type='number' step='0.01' required name='i' min='0' max='100'/><br/><br/>");

            out.println("Digite o número de parcelas/mês:");
            out.println("<br/><input type='number' required step='1' name='n'/><br/>");
            out.println("<input type='submit' value='CALCULAR'/><br/>");            
            out.println("</form><br/>");
            out.println("<table border='1'>");

            out.println("<tr>");
            out.println("<th>CAPITAL  </th>");
            out.println("<th>JUROS</th>");
            out.println("</tr><br/>");
            out.println("<tr>");
            String capital = new DecimalFormat("0.00").format(p);
            String juros = new DecimalFormat("0.00").format((p * Math.pow(1 + (i / 100), n)-p));
            out.println("<td>R$ " +capital+ "</td>");
            out.println("<td>R$ " +juros+ "</td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("<br/>");
            out.println("<table border='1'>");
            out.println("<tr>");
            out.println("<th>VALOR MENSAL</th>");
            out.println("<th>CAPITAL</th>");
            out.println("<th>JUROS AO MÊS</th>");
            out.println("<th>TOTAL</th>");
            aux = p;
            for (int j = 1; j <= n; j++) {
                jc = (aux * (i / 100));
                m = aux + jc;
                out.println("<tr>");
                out.println("<td>Mês: " + j + " = </td>");
                out.println("<td>R$ " + new DecimalFormat("0.00").format(aux) + "</td>");
                out.println("<td>R$ " + new DecimalFormat("0.00").format(jc) + "</td>");
                out.println("<td>R$ " + new DecimalFormat("0.00").format(m) + "</td>");
                out.println("</tr>");
                aux = m;
            }
            out.println("</td>");
            out.println("</tr>");
            out.println("</table>                                                                       <br/><br/><br/><br/>");
            out.println("</div>");
            out.println("</article>");
            out.println("</section>");
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
