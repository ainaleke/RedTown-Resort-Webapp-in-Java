package web_red_town;

import java.io.IOException;
import java.sql.SQLException;
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
 * Servlet implementation class homepageServlet
 */
@WebServlet("/confirmpage")
public class ConfirmPageServlet extends HttpServlet {
	//ReservationFormServlet reservationservlet=new ReservationFormServlet();
	private static final long serialVersionUID = 1L;
	java.util.Date checkin=null;
	java.util.Date checkout=null;
       
	public void init() throws ServletException{
    	
		ReservationDataModel.initializeJdbc(); //initialize database connection
	}
    public ConfirmPageServlet() {
        super();
    
    }
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		
		if(action.equals("confirmpage")){
			try 
			{
				checkin = new SimpleDateFormat("yyyy-MM-dd").parse(ReservationFormServlet.checkindate);
				System.out.println("Check in Date: " +checkin);
				checkout = new SimpleDateFormat("yyyy-MM-dd").parse(ReservationFormServlet.checkoutdate);
				System.out.println("Check out Date: " +checkout);
				ReservationDataModel.storeRecords(ReservationFormServlet.firstname,ReservationFormServlet.lastname,ReservationFormServlet.phonenumber,
						ReservationFormServlet.email, ReservationFormServlet.roomtype, checkin,checkout, ReservationFormServlet.comments);
				request.setAttribute("firstnameconfirmview", ReservationFormServlet.firstname);
				request.setAttribute("lastnameconfirmview", ReservationFormServlet.lastname);
				RequestDispatcher views= request.getRequestDispatcher("/WEB-INF/confirmresults.jsp");	
				views.forward(request, response);
			} 
			catch(SQLException sql)
			{
				sql.printStackTrace();
			}

			catch (ParseException e1) {

				e1.printStackTrace();
			}

			catch(Exception e2)
			{
				e2.printStackTrace();
			}
			finally
			{

			}
		}//end if
		else if(action.equals("confirmpage"))
		{
			response.sendRedirect("/reservations.html");
		
		}
		
	}

}
