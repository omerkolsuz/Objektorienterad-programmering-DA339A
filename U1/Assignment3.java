/*
  Author: <Mehmet Kaan Taspunar>
  Id: <al0803>
  Study program: <MPP/Valbar>
*/
import java.util.*;
public class Assignment3{
  static Scanner input = new Scanner(System.in);
  // an array to use for testing, replace as needed to test your code

  static String[][] guestList = {{"Kristina Allder","28"},
                                 {"Sebastian Wöhrman","28"},
                                 {"Mehmet Kaan Taspunar","25"},
                                 {"",""},
                                 {"",""},
                                 {"",""},
                                 {"",""},
                                 {"",""},
                                 {"",""},
                                 {"",""}
                               };

  public static void printGuestList(){
    System.out.println();
    System.out.println(" The Guests List"); //you don't need to keep this line
    // Add your code here
    for (int i=0; i < guestList.length; i++) {

      if(guestList[i][0] != ""){
        System.out.println();
        System.out.print(" " + i + ":");
      }

      for (int j=0; j<guestList[0].length; j++) {
        if(guestList[i][j] != ""){
          System.out.print(" " + guestList[i][j]);
        }
      }
    }

    System.out.println();
    //printMenu();
  }

  public static void printStatistics(){
    System.out.println();
    System.out.println(" Statistics Of The Wedding"); //you don't need to keep this line
    // Add your code here
    int amountOfGuests = 0;
    int amountOfAdults = 0;
    int amountOfChildren = 0;
    int ageOfOldestGuestAtWedding = 0;
    int ageOfYoungestGuestAtWedding = 0;

    String oldestName = "";
    String youngestName = "";

    //Counts the total amount of guests
    for (int i = 0; i < guestList.length; i++) {
      if(guestList[i][0] != ""){
        //counts the amount of guests
        amountOfGuests++;

        //Counts the Children and Adults
        if(Integer.parseInt(guestList[i][1]) >= 18){
          amountOfAdults++;
        }
        else {
          if(Integer.parseInt(guestList[i][1]) <= 13) {
            amountOfChildren++;
          }
        }

        //Finds the oldest guests name and age
        if(Integer.parseInt(guestList[i][1]) > ageOfOldestGuestAtWedding){
          ageOfOldestGuestAtWedding = Integer.parseInt(guestList[i][1]);
          oldestName = guestList[i][0];
        }
      }
    }

    //To find the youngest guests name and age
    //There has to be a to be able to compare and figure out the youngest
    if(amountOfGuests > 0){
      int [] allAges = new int[guestList.length];

      for (int i = 0; i < guestList.length; i++) {
        if(guestList[i][1] != ""){
          allAges[i] = Integer.parseInt(guestList[i][1]);
        }
      }

      //Loops to find the element that is not equal to 0
      for (int i = 0; i < allAges.length; i++) {
        if(allAges[i] != 0){
          //The defined first age in the list that is not equal to 0
          //Because someone can not be 0 years and
          //be at wedding at the same time :)
          ageOfYoungestGuestAtWedding = allAges[i];
          break;
        }
      }

      //Loop through the allAges to find the youngest age
      for (int i = 0; i < allAges.length; i++) {
        //Compare elements of array with min
        if(allAges[i] < ageOfYoungestGuestAtWedding && allAges[i] != 0){
          ageOfYoungestGuestAtWedding = allAges[i];
        }
      }

      //Loop through the guestList to get the youngest guests name and age
      for (int i = 0; i < guestList.length; i++) {
        if(guestList[i][0] != ""){
          if(Integer.parseInt(guestList[i][1]) == ageOfYoungestGuestAtWedding){
            youngestName = guestList[i][0];
          }
        }
      }

    }

    System.out.println();
    System.out.println(" Guests:   " + amountOfGuests);
    System.out.println();
    System.out.println(" Adults:   " + amountOfAdults);
    System.out.println();
    System.out.println(" Children: " + amountOfChildren);

    //If there are guests
    if(amountOfGuests > 0){
      System.out.println();
      System.out.println(" Oldest:   " + oldestName + " is " + ageOfOldestGuestAtWedding + " years old");
      System.out.println();
      System.out.println(" Youngest: " + youngestName + " is " + ageOfYoungestGuestAtWedding + " years old");
    }

    printMenu();
  }

  public static void addGuest(){
    System.out.println(" Add A New Guest \n"); //you don't need to keep this line
    // Add your code here

    //Checks if there is a place for a new geust
    boolean isTherePlace = false;
    for (int i=0; i<guestList.length; i++) {
      if (guestList[i][0] == "") {
        isTherePlace = true;
      }
    }

    if (isTherePlace) {
      System.out.print(" Please enter your name: ");
      String name = input.nextLine();
      //I had to "tilldela" one more time to get it work
      name = input.nextLine();

      System.out.print(" Please enter your age: ");
      String age = Integer.toString(input.nextInt());

      for (int i=0; i < guestList.length; i++) {
        if((guestList[i][0] == "")){
            guestList[i][0] = name;
            guestList[i][1] = age;

            System.out.println();
            System.out.println(" New guest added to the list!");
            break;
        }
      }
    }else {
      System.out.println(" Sorry! - All the places are taken!");
    }

    printMenu();
  }

  public static void changeNameOfGuest(){
    System.out.println(" Change The Name Of A Guest"); //you don't need to keep this line
    // Add your code here

    //There has to be someone on the list to be able to change age
    boolean listIsNotEmpty = false;
    for (int i=0; i<guestList.length; i++) {
      if (guestList[i][0] != "") {
        listIsNotEmpty = true;
      }
    }

    if(listIsNotEmpty){
      printGuestList();
      System.out.println();
      System.out.print(" Give the number of the Guest you want to change name: ");
      int indexOfGuest = input.nextInt();

      //Controlls if the given index exist int the guestList array
      while((guestList[indexOfGuest][0] == "") || (indexOfGuest < 0)){
        System.out.println(" The guest doest not exist! Try again");
        indexOfGuest = input.nextInt();
      }

      System.out.print(" New name: ");
      //I had to "tilldela" one more time to get it work
      String newName = input.nextLine();
      newName = input.nextLine();

      for (int i = 0; i < guestList.length; i++) {
        if(i == indexOfGuest){
          guestList[i][0] = newName;

          System.out.println();
          System.out.println(" Guest name updated!");
          break;
        }
      }
    }else {
      System.out.println();
      System.out.println(" There is no guest registered in the list!");
    }

    printMenu();
  }

  public static void changeAgeOfGuest(){
    System.out.println(" Change The Age Of A guest"); //you don't need to keep this line
    // Add your code here

    //There has to be someone on the list to be able to change age
    boolean listIsNotEmpty = false;
    for (int i=0; i<guestList.length; i++) {
      if (guestList[i][0] != "") {
        listIsNotEmpty = true;
      }
    }

    if(listIsNotEmpty){
      printGuestList();
      System.out.println();
      System.out.print(" Give the index of the Guest you want to change Age: ");
      int indexOfGuest = input.nextInt();

      //Controlls if the given index exist int the guestList array
      while((guestList[indexOfGuest][0] == "") || (indexOfGuest < 0)){
        System.out.println(" The guest could not found! try again");
        indexOfGuest = input.nextInt();
      }

      System.out.print(" Enter the new Age: ");
      String newAge = Integer.toString(input.nextInt());

      for (int i = 0; i < guestList.length; i++) {
        if(i == indexOfGuest){
          guestList[i][1] = newAge;

          System.out.println();
          System.out.println(" Guest age updated!");
          break;
        }
      }
    }else {
      System.out.println();
      System.out.println(" There is no guest registered in the list!");
    }

    printMenu();
  }

  public static void removeGuest(){
    System.out.println(" Remove A Guest"); //you don't need to keep this line
    // Add your code here

    //There has to be someone on the list to be able to remove
    boolean listIsNotEmpty = false;
    for (int i=0; i<guestList.length; i++) {
      if (guestList[i][0] != "") {
        listIsNotEmpty = true;
      }
    }

    if(listIsNotEmpty){
      printGuestList();
      System.out.println();
      System.out.print(" Enter index of guest you want to remove: ");
      int indexOfGuest = input.nextInt();

      //Controlls if the given index exist int the guestList array
      while((indexOfGuest < 0) || (guestList[indexOfGuest][0] == "")){
        System.out.println(" There is no guest at that index! Try again");
        indexOfGuest = input.nextInt();
      }

      //Finds the geust and erase him from the list
      for(int i = 0; i < guestList.length; i++){
        if(i == indexOfGuest){
          guestList[i][0] = "";
          guestList[i][1] = "";

          System.out.println();
          System.out.println(" Guest removed from the list!");
          continue;
        }
      }
    }else {
      System.out.println();
      System.out.println(" There is no guest registered in the list!");
    }

    printMenu();
  }

  public static void changePlaces(){
    System.out.println(" Switch Places Between Guests"); //you don't need to keep this line
    // Add your code here

    printGuestList();

    System.out.println();
    System.out.println(" Free Places: ");
    System.out.println();
    //Prints the full list of free places
    for (int i=0; i<guestList.length; i++) {
      if(guestList[i][0] == ""){
        System.out.print(" " + i + " ");
      }
    }
    System.out.println();
    System.out.println();

    System.out.print(" Please enter the index of first guest: ");
    int index1 = input.nextInt();
    String nameOfGuestAtIndex1 = "";
    String ageOfGuestAtIndex1 = "";

    System.out.print(" Please enter the index of second guest: ");
    int index2 = input.nextInt();
    String nameOfGuestAtIndex2 = "";
    String ageOfGuestAtIndex2 = "";

    //Controlls if the given index exist int the guestList array
      while((index1 > guestList.length) || (index2 > guestList.length) || (index1 < 0) || (index2 < 0)){
        System.out.println(" The guest could not found! try again");
        System.out.println();
        System.out.print(" Please enter the index of first guest: ");
        index1 = input.nextInt();

        System.out.println();
        System.out.println(" Please enter the index of second guest: ");
        index2 = input.nextInt();
      }

      //Finds the name and age of the guest on the given index
      for (int i = 0; i < guestList.length; i++) {
        if(i == index1){
          nameOfGuestAtIndex1 = guestList[i][0];
          ageOfGuestAtIndex1 = guestList[i][1];
        }

        if(i == index2){
          nameOfGuestAtIndex2 = guestList[i][0];
          ageOfGuestAtIndex2 = guestList[i][1];
        }
      }

      //Changes the places of guests
      for (int i = 0; i < guestList.length; i++) {
        if(i == index1){
          guestList[i][0] = nameOfGuestAtIndex2;
          guestList[i][1] = ageOfGuestAtIndex2;
        }

        if(i == index2){
          guestList[i][0] = nameOfGuestAtIndex1;
          guestList[i][1] = ageOfGuestAtIndex1;
        }
      }

      printMenu();
  }

  public static void printMenu(){
    System.out.println();
    // Add your code here
    System.out.println("-------------------------------------");
    System.out.println(" 0 : To Print The Guest List");
    System.out.println(" 1 : To Print Statistics");
    System.out.println(" 2 : To Add New Guest");
    System.out.println(" 3 : To Change The Name of a Guest");
    System.out.println(" 4 : To Change The Age of a Guest");
    System.out.println(" 5 : To Remove A Guest");
    System.out.println(" 6 : To Change Places between Guests");
    System.out.println("-1 : To Exit The Program");
    System.out.println("-------------------------------------");

    int val = input.nextInt();

      if(val == 0){
        printGuestList();
        printMenu();
      }
      if(val == 1){
        printStatistics();
      }
      if(val == 2){
        addGuest();
      }
      if(val == 3){
        changeNameOfGuest();
      }
      if(val == 4){
        changeAgeOfGuest();
      }
      if(val == 5){
        removeGuest();
      }
      if(val == 6){
        changePlaces();
      }
      if(val > 6 || val < -1){
        System.out.println(" That command doest not exist!");
        System.out.println(" Try 0, 1, 2, 3, 4, 5, 6");
        printMenu();
      }
  }

  public static void main(String[] args) {
     // Add you code here with the main loop that handles the user's menu choices.
     System.out.println("-------------------------------------");
     System.out.println("    WELCOME TO THE WEDDING!");
     printMenu();
  }
}
