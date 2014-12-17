package server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequirementsHandlerServlet extends HttpServlet {
        private static final long serialVersionUID = 1L;

        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
               RequirementReader reqReader = new RequirementReader();
               resp.setContentType("text/plain");
               
               String reqList = reqReader.getAllRequirements();   
            
               PrintWriter out = resp.getWriter();
               out.println (reqList);
        }
        

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			
			Requirement newRequirement = new Requirement(req.getParameter("description"));
			
			RequirementsWriter reqSaver = new RequirementsWriter();
			reqSaver.saveRequirement(newRequirement);
			
            PrintWriter out = resp.getWriter();
            out.println (newRequirement.getId());
		}
}
