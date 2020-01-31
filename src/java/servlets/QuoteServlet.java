/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lpeters
 */
public class QuoteServlet extends HttpServlet {

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
        System.out.println("GET Request:");
        HttpSession session = request.getSession();
        request.setAttribute("quote", request.getParameter("frmQuote"));
        getServletContext().getRequestDispatcher("/WEB-INF/quotepage.jsp").forward(request, response);
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
        System.out.println("POST Request:");
        HttpSession session = request.getSession();
        String frmName = request.getParameter("frmName");
        String frmQuote = request.getParameter("frmQuote");
        String frmNumber = request.getParameter("frmNumber");
        
        if (frmName != null) {
            session.setAttribute("firstname", frmName);
        }
        if (frmQuote != null) {
            request.setAttribute("quote", frmQuote);
        }
        
        ArrayList<Integer> numbers = (ArrayList<Integer>)session.getAttribute("numbers");
        if (numbers == null) {
            numbers = new ArrayList<Integer>();
        }
        if (frmNumber != null) {
            try {
                int inputNum = Integer.parseInt(frmNumber);
                request.setAttribute("inputnum", inputNum);
                numbers.add(inputNum);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        session.setAttribute("numbers", numbers);
        float average = 0;
        if (numbers.size() > 0) {
            int totalNum = 0;
            for (Integer n : numbers) {
                totalNum += n;
            }
            average = totalNum / numbers.size();
        }
        request.setAttribute("average", average);
        getServletContext().getRequestDispatcher("/WEB-INF/quotepage.jsp").forward(request, response);
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
