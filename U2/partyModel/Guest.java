/*
  Author: <Ömer Kolsuz>
  Id: <>
  Study program: <DT>
*/

package partyModel;

public class Guest {
    /* Declare instance variables for first name and last name as String-objects and
       address as an Address-object.
     */
    String firstName;
    String lastName;
    Address adres;


    /* Write a default constructor (no parameters) that gives default values for
       instance variables and creates the Address-object using
       the default constructor for class Address.
       Use default values for first name and last name of your choice
       that will inform a user that this value isn't really set.
       You can handle this in this constructor or call
       the constructor below with null for all values and handle that there.
     */
    public Guest(){
        firstName = "unknown firstname";
        lastName = "unknown lastname";
        Address adres = new Address();
    }

    /* Write a constructor with parameters for all instance variables
       given above where the address is a reference to an Address-object
       and first name and last name are of type String.
       Check that the values for the parameters for first name and last name
       isn't empty strings or null before assigning the values to the corresponding
       instance variables. If any value is empty or null assign a default value of your choice
       that will inform a user that this value isn't really set.
       If the parameter for the Address-object is null create an Address-object
       by using the default constructor for class Address.
     */
    public Guest(String firstName, String lastName, Address adres){
        if (firstName == "unknown firstname") {
            this.firstName = "unknown firstname";
        } else {
            this.firstName = firstName;
        }
        if (lastName == "unknown lastname"){
            this.lastName = "unknown lastname";
        }
        else{
            this.lastName = lastName;
        }
        if(adres.toString() == null){
            this.adres = null;
        }
        else{
            this.adres = adres;
        }
    }

    /* Write a constructor with parameters for all instance variables
       given above and all instance variables for the address.
       Create the Address-object with the values given in the parameters.
       Let the Address class take care of assigning default values if any
       parameters for this object is an empty string or null.
   */

    /* Implement get- and set-methods for all instance variables,
       including variables matching the instance variables of
       the Address-object (those call getters and setters in the Address-object).

       Remember to check parameters in set-methods with the same
       rules as in the constructor above.
     */
    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAdres() {
        return adres;
    }

    public void setAdres(Address adres) {
        this.adres = adres;
    }

    /* Write a toString method to return a String made of first name and
           family name and the address (by calling the toString method of the Address-object)
           formatted in one line (this will be shown in the window under "Guest Register" ).
         */
    public String toString(){
        return firstName+" "+lastName+" "+adres;
    }
}

