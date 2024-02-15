/*
  Author: <Ömer Kolsuz>
  Id: <>
  Study program: <DT>
*/

package partyModel;

import java.lang.reflect.Constructor;

public class Address {
    /* Declare instance variables for street, city, zip code as String-objects
       and country by using the enum Countries
     */
    String street;
    String city;
    String zipCode;
    Countries country;

    /* Write a default constructor (with no parameters) that gives default values for instance variables.
         Set default values for instance variables by calling the other constructor
         below using the this reserved word and:
         - Alternative 1: with arguments that are default values
           of your choice that will inform a user that this value isn't really set.
         - Alternative 2: Use null for all arguments and call the constructor below and handle that there.
       */
    public Address(){
        street = "unknown street";
        city = "unknown city";
        zipCode = "unknown zip code";
        country = Countries.Unknown;
    }


    /* Write a constructor with parameters for all instance variables
       given above. Set instance variables to values from parameters.

       Check that the values for the parameters street, zipCode and city
       isn't empty strings or null before assigning the values to the
       corresponding instance variables.

       If any value is empty or null assign a default value of your choice
       that will inform a user that this value isn't really set.

       If the parameter country is null set this to Countries.Unknown
     */
    public Address(String street, String city, String zipCode, Countries country) {
        // if sats kontrollerar om det är tom eller inte
        if (street == "unknown street") {
            this.street = "unknown street";
        } else {
            this.street = street;
        }
        if (city == "unknown city"){
            this.city = "unknown city";
        }
        else{
            this.city = city;
        }
        if(zipCode == "unknown zip code") {
            this.zipCode = "unknown zip code";
        }
        else{
            this.zipCode = zipCode;
        }
        if (country == Countries.Unknown){
            this.country = Countries.Unknown;
        }
        else {
            this.country = country;
        }

    }

    /* Implement get- and set-methods for all instance variables.
       Remember to check parameters in set-methods with the same
       rules as in the constructor above.
     */
    public String getStreet(){
        return street;
    }
    public void setStreet(String street){
        this.street = street;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getZipCode() {
        return zipCode;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    public Countries getCountry() {
        return country;
    }
    public void setCountries(Countries country) {
        this.country = country;
    }


    /* Write a toString method to return a String-object made of the address details,
     formatted as one line (this will be shown in the window under "Guest Register" ).
   */
    public String toString(){
        return street +" "+ city + " " + zipCode + " " + country;
    }
}

