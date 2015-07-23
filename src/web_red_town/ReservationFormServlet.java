package web_red_town;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ReservationDataModel;

/**
 * Servlet implementation class SubmitFormServlet
 */
@WebServlet("/submitform")
public class ReservationFormServlet extends HttpServlet {

	//public String phonenumber=null;
	private static final long serialVersionUID = 1L;
	static String firstname; 
	static String lastname;
	static String phonenumber;
	static String email;
	static String roomtype;
	static String checkindate;
	static String checkoutdate; 
	static String comments;

    public ReservationFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
    public void init() throws ServletException{
    	
		ReservationDataModel.initializeJdbc(); //initialize database connection
	}
	**/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		//java.util.Date checkout=null;
		//java.util.Date checkin = null;
		PrintWriter out=response.getWriter();
		firstname=request.getParameter("firstname");
		lastname=request.getParameter("lastname");
		phonenumber=request.getParameter("phonenumber");
		roomtype=request.getParameter("roomtype");
		checkindate=request.getParameter("checkindate");
		checkoutdate=request.getParameter("checkoutdate");
		comments=request.getParameter("commentbox");
		email=request.getParameter("email");
		System.out.println(checkindate);
		try //add a try catch block to catch any exceptions
		{
			request.setAttribute("firstnameview", firstname);
			request.setAttribute("lastnameview", lastname);
			request.setAttribute("roomtypeview", roomtype);
			request.setAttribute("phoneview",phonenumber);
			request.setAttribute("checkindateview",checkindate);
			request.setAttribute("checkoutdateview", checkoutdate);
			request.setAttribute("commentview",comments);
			request.setAttribute("emailview", email);
			RequestDispatcher view= request.getRequestDispatcher("/WEB-INF/bookingresults.jsp");
			view.forward(request, response);
		}
		catch(NullPointerException nullpointer)
		{
			nullpointer.printStackTrace();
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
		}
		
		/**
		try {
			//Update and store the records in the database
			ReservationDataModel.storeRecords(firstname, lastname,phonenumber, email, roomtype, checkin,  checkout, comments);	
		} 
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		catch(Exception ex){}
		**/
		/**
		try //add a try catch block to catch any exceptions
		{
			if(roomtype.equals("Attic Room"))
			{
				response.getWriter().println("The price for an Attic Room is: $100");
			}
			else if(roomtype.equals("Standard Room"))
			{
				response.getWriter().println("The price for an Attic Room is: $100");
			}
			else
			{
				response.getWriter().println("You must choose a Room Type");
			}
		}
		catch(NullPointerException nulllpointer)
		{
			
		}
		catch(Exception exp)
		{
			
		}
		
		finally{}
		**/

	}
	
	
	
}
