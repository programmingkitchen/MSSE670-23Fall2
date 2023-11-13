package com.fleetrental.view.mainjframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.fleetrental.view.MessageDialog;
import com.fleetrental.view.Utils;
import com.fleetrental.view.registercustomerjframe.RegisterCustomerJFrame;


/**
 * ItineraryJFrameController.java
 *
 * Listens and handles actions generated from ItineraryJFrame.java
 * 
 * @author Mike.Prasad
 */

public class MainJFrameController 
        implements ActionListener 
{

	private MainJFrame itineraryJFrame;
	
    /** Creates a new instance of ItineraryJFrameController */
    public MainJFrameController() {
    }
     

  /*
   * Copy constructor
   */
    
  public MainJFrameController (MainJFrame itineraryJFrame) 
  {
    this.itineraryJFrame = itineraryJFrame;

    //add all the action listeners here
    itineraryJFrame.getFileMenuItem().addActionListener(this);
    itineraryJFrame.getDatabaseMenuItem().addActionListener(this);
    itineraryJFrame.getGetAvailableRentalsButton().addActionListener(this);
    itineraryJFrame.getGetRegisterCustomerButton().addActionListener(this);
       
    // center the frame
    Utils.centerWindow(itineraryJFrame);
    itineraryJFrame.setVisible(true);
  }

  /*
   *  (non-Javadoc)
   * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
   */
  public void actionPerformed(ActionEvent event) 
  {

    System.out.println ("Inside ItineraryJFrameController::actionPerformed");
    
    if (event.getSource().equals(itineraryJFrame.getFileMenuItem()))
      menuFileOpen_actionPerformed(event);
    else if (event.getSource().equals(itineraryJFrame.getDatabaseMenuItem()))
      menuReadDB_actionPerformed(event);
    else if (event.getSource().equals(itineraryJFrame.getGetAvailableRentalsButton()))
      getAvailableRentals_actionPerformed(event);
    else if (event.getSource().equals(itineraryJFrame.getGetRegisterCustomerButton()))
      getRegisterCustomer_actionPerformed(event);
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
  
  
/**
   * Processes Get Available Rentals action
   *
   * @param actionEvent ActionEvent
   */
  void getAvailableRentals_actionPerformed(ActionEvent actionEvent) 
  {
     System.out.println("Inside ItineraryJFrameController");
     MessageDialog dlg = new MessageDialog( "Rental Availability", "Not Implemented Yet!");    
     Utils.centerWindow(dlg);
     dlg.setModal(true);
     dlg.show();
      
      return;  
  } //end menuFileOpen_actionPerformed

 private void getRegisterCustomer_actionPerformed(ActionEvent event) {

  RegisterCustomerJFrame registerCustomerJFrame = new RegisterCustomerJFrame();
  registerCustomerJFrame.show();
 }

  
} //end class   