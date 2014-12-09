package server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequirementsHandlerServlet extends HttpServlet {
        private static final long serialVersionUID = 1L;

        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
               RequirementReader reqReader = new RequirementReader();
               //resp.setContentType("text/plain");
               PrintWriter out = resp.getWriter();
               reqReader.readFile();
                
                //out.println ("OSGI vous salue Android !");
        }

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			
			 //resp.setContentType("text/plain");
			Requirement newRequirement = new Requirement(req.getParameter("description"));
			RequirementsWriter reqSaver = new RequirementsWriter();
			reqSaver.saveRequirement(newRequirement);
			
            PrintWriter out = resp.getWriter();
            out.println (newRequirement.getId());
		}
}
