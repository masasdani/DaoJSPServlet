/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.masasdani.servlet;

import com.masasdani.dao.impl.DonaturDaoImpl;
import com.masasdani.dao.interf.DonaturDao;
import com.masasdani.entity.Donatur;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author badak
 */
public class DonaturServlet extends HttpServlet {

    private String show = "/WEB-INF/jsp/donatur/list.jsp";
    private String form = "/WEB-INF/jsp/donatur/form.jsp";
    private DonaturDao donaturDao;

    public DonaturServlet() {
        this.donaturDao = new DonaturDaoImpl();
    }

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Donatur> list = donaturDao.getAll();
        request.setAttribute("data", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher(show);
        dispatcher.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            if (action.equalsIgnoreCase("insert")) {
                RequestDispatcher dispatcher = request.getRequestDispatcher(form);
                dispatcher.forward(request, response);
            } else if (action.equalsIgnoreCase("update")) {
                String txtId = request.getParameter("id");
                if (txtId != null) {
                    int id = Integer.parseInt(txtId);
                    Donatur d = donaturDao.getDonatur(id);
                    request.setAttribute("data", d);
                }
                RequestDispatcher dispatcher = request.getRequestDispatcher(form);
                dispatcher.forward(request, response);
            } else if (action.equalsIgnoreCase("delete")) {
                String txtId = request.getParameter("id");
                if (txtId != null) {
                    Donatur d = new Donatur();
                    int id = Integer.parseInt(txtId);
                    d.setId(id);
                    donaturDao.delete(d);
                    processRequest(request, response);
                }
            }
        } else {
            processRequest(request, response);
        }

    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String txtId = request.getParameter("id");
        Donatur d = new Donatur();
        d.setNama(request.getParameter("nama"));
        d.setAlamat(request.getParameter("alamat"));
        if (txtId.isEmpty()) {
            donaturDao.save(d);
        } else {
            d.setId(Integer.parseInt(txtId));
            donaturDao.update(d);
        }
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "ini servlet untuk menangani donatur";
    }// </editor-fold>
}
