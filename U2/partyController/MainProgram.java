/*
  Author: <Ömer Kolsuz>
  Id: <>
  Study program: <DT>
*/
package partyController;

import javax.swing.*;

public class MainProgram
{
    public static void main(String[] args)
    {
        int maxNbrOfGuests = 10; // Change this line later. Only using 10 as a default value to make compilations possible.
        /* Write code to read max number of guests from the user by using one of
         - JOptionPane
         - Scanner and prompt
        */
        String numberOfGuests = JOptionPane.showInputDialog("How Many guests are expected");
        maxNbrOfGuests = Integer.parseInt(numberOfGuests);
        Controller controller = new Controller(maxNbrOfGuests);
    }
}
