package test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sos24horas.tcc.gcm.GCMBroadcast;


@WebServlet("/ServletTest")
public class ServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String collapseKey = "";
        String userMessage = "";
         
        try {
            userMessage = request.getParameter("Message");
            collapseKey = request.getParameter("CollapseKey");
            
            GCMBroadcast gcm = new GCMBroadcast();
            gcm.addIdAndroid("APA91bG-p080flK7vRR_HPpig_xJ7mnLiz8VPOf9hOK3OyuvBfwGCNRLaJCbzj4VvSIxL3LHM2jpJkQjCKa5Gt8lQ5PqXlqwCtnzMORLnrhOsl2VYGqyvXvipTXYQZXc0s2SfXhj-FfFcj1sWqlK31YutC0gl1smqA");
            gcm.setCollapKey(collapseKey);
            gcm.setMessage(userMessage);
            gcm.send();
            
            
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        
        
        
        request.setAttribute("CollapseKey", collapseKey);
        request.setAttribute("Message", userMessage);
         
        request.getRequestDispatcher("index.jsp").forward(request, response);
		
		
		
		
	}

}
