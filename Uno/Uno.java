/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class Uno extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PartThreeServlet</title>");
            out.println("<script type='text/javascript'>");
            out.println("function go()");
            out.println("{");
//            out.println("if(regNumber.test(document.getElementById(\"age\").value))");
//            out.println("{");
//            out.println("alert(\"Age can only be a number!\");");
//            out.println("}");
//            out.println("else");
//            out.println("{");
            out.println("var regNumber=new RegExp(\"[^0-9]\");");
            out.println("var number = document.getElementById('num').value;");
            out.println("document.getElementById('container').remove();");
            out.println("var i;");
            out.println("var foo = document.getElementById('inputCountForm');");
            out.println("var header = document.createElement('h2');");
            out.println("header.innerHTML = 'Please fill the following form'");
            out.println("foo.appendChild(header);");

            out.println("for(i = 1; i <= number; i++)");
            out.println("{");

            out.println("var nameLabel = document.createElement('LABEL'); ");
            out.println("nameLabel.innerHTML = 'Enter the name of child ' + i;");
            out.println("foo.appendChild(nameLabel);");
            out.println("var linebreak = document.createElement('br');");
            out.println("foo.appendChild(linebreak);");

            out.println("var nameInput = document.createElement('INPUT');");
            out.println("nameInput.setAttribute('type','text');");
            out.println("nameInput.setAttribute('name','child');");
            out.println("foo.appendChild(nameInput);");

            out.println("var linebreak = document.createElement('br');");
            out.println("foo.appendChild(linebreak);");
            out.println("var linebreak = document.createElement('br');");
            out.println("foo.appendChild(linebreak);");

            out.println("}");

            out.println("var btn=document.createElement('input');");
            out.println("btn.type = 'submit'");
            out.println("btn.value = 'Enter'");
            out.println("foo.appendChild(btn)");

            out.println("}");
            //out.println("}");

            out.println("function validation()");
            out.println("{");
            out.println("var regNumber=new RegExp(\"[^1-9]\");");

            out.println("if(regNumber.test(document.getElementById(\"num\").value))");
            out.println("{");
            out.println("alert(\"Enter a valid number!\");");
            //out.println("return false;");
            out.println("}");
            out.println("}");

            out.println("</script>");

            out.println("</head>");
            out.println("<body>");
            out.println("<form class='form-horizontal' role='form' id = 'inputCountForm'  method='post'>");
            out.println("<center>");
            out.println("<div id='container'>");

            out.println("<h3>How many children do you have?</h3>");
            out.println("<br/>");
            out.println("<br/>");
            out.println("<br/>");
            out.println("<input type = 'text' class='form-control' onBlur='validation()' id='num' name='number'/>");

            out.println("<input type = 'submit' id='submitBtn' name = 'submitBtn' value='Submit Query' onClick='go();'/>");
            out.println("<center>");
            out.println("</div>");
            out.println("</center>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }

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
        //processRequest(request, response);
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel='stylesheet' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css'/>");
            out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js'></script>");
            out.println("<script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js'></script>");
            out.println("</head>");
            out.println("<body>");
            out.println("<table>");
            String[] childName = request.getParameterValues("child");
            out.println("Names of your children/child are/is");
            for (int i = 0; i < childName.length; i++) {
                out.println("<li>" + childName[i] + "</li>");
            }
            out.close();
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        }

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
