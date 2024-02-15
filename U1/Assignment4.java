/*
  Author: <Ömer Kolsuz>
  Id: <computer id from Mau>
  Study program: <Sys/DT/...>
*/
import java.util.*;
public class Assignment4{
  static Scanner input = new Scanner(System.in);
  // an array to use for testing, replace as needed to test your code
  static String nynamn;
  static String namn;
  static String age;
  static int index;
  static int index1;
  static int age1;
  static String newAge;
  static String[][] guestList = {{"Vera Kolzh", "35"},
                                 {"Ömer Kolsuz", "70"},
                                 {"Mehmet Kaan", "12"},
                                 {"",""},
                                 {"",""},
                                 {"",""},
                                 {"",""},
                                 {"",""},
                                 {"",""},
                                 {"",""},
                               };



  public static void printGuestList(){
    System.out.println("Du väljer att visa gäst listan"); //you don't need to keep this line
    // Add your code here
    for (int i=0; i<guestList.length; i++) {
      for (int j=0; j<guestList[0].length; j++){ //guestList[0] vilken är första rad på arrayen här andra for loppen jag loppar genom varje rad i arrayen guestlist
        if(guestList[i][j] != ""){
          System.out.println(guestList[i][j] + " ");
        }
  }  }
  printMenu();
  }

  public static void printStatistics(){
    System.out.println("You chose to print statistics"); //you don't need to keep this line
    // Add your code here
  }

  public static void addGuest(){
    System.out.println("Du väljer att lägga till en gäst"); //you don't need to keep this line
    // Add your code here
    Scanner addguest = new Scanner(System.in);
    System.out.println("------------------------------");
    System.out.print("Ange namnet: ");
    namn = addguest.nextLine();
    //if (namn != ((String)input){ //för att kontrollera om input är string eller inte.
  //  System.out.print("Ange ett giltigt namn, tack!");
    System.out.println("------------------------------");
    System.out.print("Ange ålder: ");
    age1 = addguest.nextInt();
    age = Integer.toString(age1);
// här lägger jag gäster till arrayen
    int counter = 0;
     for(int i=0; i<guestList.length; i++){
       for(int j=0; j<guestList[0].length; j++){
         if(guestList[i][j] == ""){
           counter = i;
           if(counter != 0){
             guestList[counter][0] = namn;
             guestList[counter][1] = age;
           break;
         }
         if(guestList.length == 10){
           System.out.println(" Det finns ingen plats");
         }
       }
     }

     if(counter == 10){
       System.out.println("Man kan inte lägga mer än 10 personer.");
     }
     }
     printMenu();

  }

  public static void changeNameOfGuest(){
    System.out.println("Du väljer att byta namnet på gäst!"); //you don't need to keep this line
    // Add your code here
    System.out.println("Skriv numret där du vill byta namnet 0 till 9!");
    index = input.nextInt();
    if(index > guestList.length || index <= -1){
    System.out.println("Ogiltig input! Välja ett nummer från 0 till 9!"); }
    else{ guestList [index][0] = namn; // Jag frågar bara namnet här så skriver jag 0 till andra kolumn.
  //  System.out.println(" ");
    System.out.println("Ange namnet! ");
    Scanner input = new Scanner(System.in);
    namn = input.nextLine();
    if(namn != ""){
    guestList[index][0] = namn;
    } printMenu();
         }
  }

  public static void changeAgeOfGuest(){
    System.out.println("Du väljer att byta ålder på gäst!"); //you don't need to keep this line
    // Add your code here
    System.out.println("Skriv numret där du vill byta ålder 0 till 9!");
    index1 = input.nextInt();
    if(index1 > guestList.length || index1 <= -1){
    System.out.println("Ogiltig input! Välja ett nummer från 0 till 9!"); }
    else{ guestList [index1][1] = age; // Jag frågar bara namnet här så skriver jag 0 till andra kolumn.
    System.out.println("Ange ålder! ");
    Scanner input = new Scanner(System.in);
    age = input.nextLine();
    if(age != ""){
        guestList [index1][1] = age;
      } printMenu();
         }
  }

  public static void removeGuest(int index){
    System.out.println("You chose to remove a guest"); //you don't need to keep this line
    // Add your code here
  }

  public static void changePlaces(int index1, int index2){
    System.out.println("You chose to switch places between index "+index1+" and "+index2); //you don't need to keep this line
    // Add your code here
  }

  public static void printMenu(){
    System.out.println(" ");
    System.out.println("Program menu"); //you don't need to keep this line
    // Add your code here
    System.out.println("------------------------------");
    System.out.println("0: För att visa gäst list\n1: För att visa statistik av gäst listan\n2: För att lägga nya gäster\n3: För att byta namn på gäster\n4: För att byta ålder på gäster\n5: För att ta bort gäst\n6: För att byta plats på gäst ");
    System.out.println("-1: För att avsluta programmet");
    System.out.println("------------------------------");

    int val = input.nextInt();
    if(val == 0){
     printGuestList();
   }
   if(val == 1){
     printStatistics();
   }
   if(val == 2) {
     addGuest();
   }
   if(val == 3){
     changeNameOfGuest();
   }
   if(val ==4){
     changeAgeOfGuest();
     /*
   }else if(val ==5){
     removeGuest();
   }else if(val ==6){
     changePlaces(); }*/

   }
}
  public static void main(String[] args) {
     // Add you code here with the main loop that handles the user's menu choices.
     printMenu();
     addGuest();
     changeNameOfGuest();
     changeAgeOfGuest();

}
}
