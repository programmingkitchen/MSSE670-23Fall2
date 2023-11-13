package com.fleetrental.view.registercustomerjframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.fleetrental.model.business.manager.FleetRentalManager;
import com.fleetrental.model.domain.Customer;
import com.fleetrental.model.domain.RentalComposite;
import com.fleetrental.view.MessageDialog;
import com.fleetrental.view.Utils;


/**
 * RegisterCustomerJFrameController.java
 *
 * Listens and handles actions generated from RegisterCustomerJFrame.java
 * 
 * @author Mike.Prasad
 */

public class RegisterCustomerJFrameController 
        implements ActionListener 
{

	private RegisterCustomerJFrame registerCustomerJFrame;
	
    /** Creates a new instance of ItineraryJFrameController */
    public RegisterCustomerJFrameController() {
    }
     

  /*
   * Copy constructor
   */
    
  public RegisterCustomerJFrameController (RegisterCustomerJFrame registerCustomerJFrame)
  {
    this.registerCustomerJFrame = registerCustomerJFrame;

    //add all the action listeners here
    registerCustomerJFrame.getOkButton().addActionListener(this);
    registerCustomerJFrame.getCancelButton().addActionListener(this);
       
    // center the frame
    Utils.centerWindow(registerCustomerJFrame);
    registerCustomerJFrame.setVisible(true);
  }

  /*
   *  (non-Javadoc)
   * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
   */
  public void actionPerformed(ActionEvent event) 
  {

    System.out.println ("Inside RegisterCustomerJFrameController::actionPerformed");
    
    if (event.getSource().equals(registerCustomerJFrame.getOkButton()))
     ok_actionPerformed(event);
    else if (event.getSource().equals(registerCustomerJFrame.getCancelButton()))
      cancel_actionPerformed(event);
  }

  /**
   * Processes File Menu | Data | Open from File action
   *
   * @param actionEvent ActionEvent
   */
  void menuFileOpen_actionPerformed(ActionEvent actionEvent) 
  {
   
	/*
	 * In reality, one would call the controller - FleetRentalController to
	 *  exercise the appropriate service. See getAvailableRentals_actionPerformed
	 *  for example.
	 */  
    MessageDialog dlg = new MessageDialog( "File Open", " Read comments in callback code");    
    Utils.centerWindow(dlg);
    dlg.setModal(true);
    dlg.show();

      return;  
  } //end menuFileOpen_actionPerformed


  /**
   * Processes File Menu | Data | Open from Database menu click action
   *
   * @param actionEvent ActionEvent
   */
  void menuReadDB_actionPerformed (ActionEvent actionEvent) 
  {
   
	/*
	 * In reality, one would call the controller - FleetRentalController to
	 *  exercise the appropriate service. See getAvailableRentals_actionPerformed
	 *  for example.
	 */  
    MessageDialog dlg = new MessageDialog( "File Open", " Read comments in callback code");    
    Utils.centerWindow(dlg);
    dlg.setModal(true);
    dlg.show();

      return;  
  } //end menuReadDB_actionPerformed
  
  

 private void cancel_actionPerformed(ActionEvent event) {
  registerCustomerJFrame.setVisible(false);
  registerCustomerJFrame.dispose();
 }


 private void ok_actionPerformed(ActionEvent event) {
  Customer customer = registerCustomerJFrame.getSelectedData();
    
     RentalComposite rentalComposite = new RentalComposite();
     rentalComposite.setCustomer(customer);
     
 	 FleetRentalManager fleetRentalManager = FleetRentalManager.getInstance();
 	 if (fleetRentalManager != null)
 	 {	 
	 	 boolean action =  fleetRentalManager.performAction("RegisterCustomer", rentalComposite);
	     
	
	     if (action)
	     {	 
	       MessageDialog dlg = new MessageDialog( "Registration Confirmation" , "You are successfully registered!");    
	       Utils.centerWindow(dlg);
	       dlg.setModal(true);
	       dlg.show();
	       
	       // tear down registration dialog
	       registerCustomerJFrame.setVisible(false);
	       registerCustomerJFrame.dispose();
	
	     } 
	     else
	     {
	         MessageDialog dlg = new MessageDialog( "Registration Confirmation" , "Registration Failed. Please try back later!");    
	         Utils.centerWindow(dlg);
	         dlg.setModal(true);
	         dlg.show();
	    	 
	     }
 	 }
     else
     {
         MessageDialog dlg = new MessageDialog( "Internal Error" , "Registration Failed. Please try back later!");    
         Utils.centerWindow(dlg);
         dlg.setModal(true);
         dlg.show();
    	 
     }
 	 
 }

  
} //end class   