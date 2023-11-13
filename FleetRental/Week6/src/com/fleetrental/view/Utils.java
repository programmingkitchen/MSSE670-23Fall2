package com.fleetrental.view;

import java.awt.Toolkit;
import java.awt.Component;
import java.awt.Dimension;

/**
* Ideally this class should in a package under com.fleetrental.view
*
*/
public class Utils {

    /**
     * Centers the window
     * @param comp Component
     */
    public static void centerWindow(Component comp) {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    Dimension frameSize = comp.getSize();
    if (frameSize.height > screenSize.height) {
      frameSize.height = screenSize.height;
    }
    if (frameSize.width > screenSize.width) {
      frameSize.width = screenSize.width;
    }
    comp.setLocation( (screenSize.width - frameSize.width) / 2,
                     (screenSize.height - frameSize.height) / 2);
  }

  /**
    * API to show error message
    * @param e Exception
    */
   public static void showErrorMessage(Exception e) {
     //exception occurred, so do not process further and return now after showing message.
     MessageDialog msgDlg = new MessageDialog("Error",
                                              e.getMessage() != null ?
                                              e.getMessage() : "Error occurred");
     Utils.centerWindow(msgDlg);
     e.printStackTrace();
     msgDlg.setModal(true);
     msgDlg.show();

  }

}
