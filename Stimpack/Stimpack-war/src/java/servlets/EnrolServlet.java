/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import ejb.Student;
import ejb.StudentFacadeLocal;
import ejb.Subject;
import ejb.SubjectFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Josh
 */
public class EnrolServlet extends HttpServlet {

	@EJB
	private StudentFacadeLocal studentFacade;
	@EJB
	private SubjectFacadeLocal subjectFacade;

	/** 
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {

		Student student;
		Subject subject;
		String action = "enrol";

		try {
			Integer subjectId = Integer.parseInt(request.getParameter("subject_id"));
			Integer studentId = Integer.parseInt(request.getParameter("student_id"));
			action = request.getParameter("action");
			student = studentFacade.find(studentId);
			subject = subjectFacade.find(subjectId);
		} catch (Exception e) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("ERROR: some form fields are missing or invalid.<br />");
			out.println(e.getMessage());
			out.close();
			return;
		}

		try {
			Collection<Student> studentCollection = subject.getStudentCollection();
			if (action.equals("enrol")) {
				studentCollection.add(student);
			} else if (action.equals("unenrol")) {
				studentCollection.remove(student);
			}

			subject.setStudentCollection(studentCollection);
			subjectFacade.edit(subject);
		} catch (Exception e) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("ERROR: Could not create student in database.<br />");
			out.println(e.getMessage());
			out.close();
			return;
		}

		response.sendRedirect("subjectList.xhtml");
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
		processRequest(request, response);
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
		processRequest(request, response);
	}

	/** 
	 * Returns a short description of the servlet.
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>
}
