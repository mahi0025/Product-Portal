package ProductPortal;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;



/**
* Servlet implementation class Dashboard
*/
@WebServlet("/display")
public class display extends HttpServlet {
        private static final long serialVersionUID = 1L;
       
    /**
* @see HttpServlet#HttpServlet()
*/
    public display() {
        super();
        // TODO Auto-generated constructor stub
    }

        /**
         * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            	// TODO Auto-generated method stub
         		HttpSession session=request.getSession(); 
         		PrintWriter out = response.getWriter();
         		String pname=request.getParameter("name");  

        		String p=request.getParameter("price"); 
        		String i=request.getParameter("id");  

        		int price = Integer.parseInt(p);

        		int id = Integer.parseInt(i);

        		Product prod = new Product();
    	
        		prod.setPrice(price);
        		prod.setName(pname);
        		prod.setid(id);
  
            	out.println("<html><body>");
            
            
            	if (pname!=null && id!=0 && price!=0){
            		session.setAttribute("name",pname);
            		session.setAttribute("ID",id);
            		session.setAttribute("rate",price);
            		out.println("done");
            	}
            	RequestDispatcher rd = request.getRequestDispatcher("display.jsp");
    			rd.forward(request, response);
            	out.println("</body></html>");

        	}

        /**
         * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                // TODO Auto-generated method stub
                doGet(request, response);
        }

}
