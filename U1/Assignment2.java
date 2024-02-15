/*
  Author: <Ömer Kolsuz>
  Id: <an3894>
  Study program: <DT>
*/
import java.util.*;
public class Assignment2{
  static Scanner input = new Scanner(System.in);
  // an array to use for testing, replace as needed to test your code
  static String nyNamn, namn, age, newAge;
  static int index, index1, index2, temp, age1;
  static String tio = Integer.toString(10);
  static String[][] guestList = {
                                 {"Vera Kolzhanova", "24"},
                                 {"Ömer Kolsuz", "24"},
                                 {"Mandalina katt", "1"},
                                 {"",""},
                                 {"",""},
                                 {"",""},
                                 {"",""},
                                 {"",""},
                                 {"",""},
                                 {"",""},
                               };



  public static void skrivUtGastListan(){
    System.out.println(" ");
      System.out.println("Gäst Listan");
        System.out.println("------------------------------------");
          for (int i=0; i<guestList.length; i++) {
            if(guestList[i][0] != ""){ //om gästlistan är inte tom visa gästlistan
              System.out.print(  i + ":" + " ");
                System.out.println( guestList[i][0] + " " + guestList[i][1] );
         }
       }
     }

  public static void skrivUtStatistik(){
    System.out.println(" ");
    System.out.println("Statistiken! ");
    System.out.println("------------------------------------");
    // Add your code here
    int antalGaster = 0;
    int antalVuxen = 0;
    int antalBarn = 0;
    int yngstaAr = 100;
    int yngstaIndex = 0;
    int aldstAr = 0;
    int aldstaIndex = 0;
    for (int i=0; i<guestList.length; i++) {
      if(guestList[i][1] != ""){ //om gästlistan inte tom plussa antal gäster
        antalGaster++;
         if(Integer.parseInt(guestList[i][1]) <= 13 ){ //om man är mindre än 13 då blir man barn
          antalBarn++;
      }
          else if(Integer.parseInt(guestList[i][1]) >= 18 ) { // om man är större än 18 då blir man vuxen
            antalVuxen++;
      }
    }
  }
    for (int i=0; i<guestList.length; i++) {
      if(guestList[i][1] != ""){
        if(Integer.parseInt(guestList[i][1]) > aldstAr){
          aldstaIndex = i;
            aldstAr = Integer.parseInt(guestList[i][1]); //här konverterar jag string till int
        }
      }
    }
    for (int j=0; j<guestList.length; j++) {
      if(guestList[j][1] != ""){
        if(Integer.parseInt(guestList[j][1]) < yngstaAr){
          yngstaIndex = j;
            yngstaAr = Integer.parseInt(guestList[j][1]); //här konverterar jag string till int
        }
      }
    }
      System.out.println();
      System.out.println("Antal Gäster:" + antalGaster);
      System.out.println();
      System.out.println("Antal Vuxna: " + antalVuxen);
      System.out.println();
      System.out.println("Antal Barn: " + antalBarn);
      System.out.println();
      System.out.println("Den yngsta är " + guestList[yngstaIndex][0] + " " + guestList[yngstaIndex][1] + " år");
      System.out.println();
      System.out.println("Den äldsta är " + guestList[aldstaIndex][0] + " " + guestList[aldstaIndex][1] + " år");

  }

  public static void laggTillGast(){
      System.out.println(" ");
      System.out.println("Att lägga in nya gäster!");
      System.out.println("------------------------------------");
       Scanner laggTillGast = new Scanner(System.in);
    // jag kontrollerar här om det finns plats så fortsätter koden annars får man fel meddelandet!
    boolean omdetfinnsplats = false;
      for (int i=0; i<guestList.length; i++) {
        if (guestList[i][0] == "") {
          omdetfinnsplats = true;
      }
    }
      if(omdetfinnsplats){
            System.out.print("Ange namn och efternamn: ");
              namn = laggTillGast.nextLine();
                System.out.println("------------------------------");
                  System.out.print("Ange ålder: ");
                    age1 = laggTillGast.nextInt();
                      age = Integer.toString(age1);
                        if(age1 >= 125 || age1 <= 0){
                          System.out.println("Vänligen ange ett rimligt ålder! ");
        }
                      // här lägger jag gäster till arrayen
        else if(age1 <= 124){
         int counter = 0;
          for(int i=0; i<guestList.length; i++){
           for(int j=0; j<guestList[0].length; j++){
            if(guestList[i][j] == ""){ /* här kontrollerar jag om det finns plats i listan
                                om det finns plats då fortsätter koden annars får man felmeddelandet */
             counter = i;
        }
      }
        if(counter != 0){
          System.out.println(" " + "\t" + namn +" "+ age + " läggs till i gäst listan");
            guestList[counter][0] = namn;
             guestList[counter][1] = age;
              break;
              }
            }
          }
        }
        else{
          System.out.println(" Det finns ingen plats! Du kan tyvärr inte lägga mer personer till listan!");
        }
      }

  public static void andraNamnPaGast(){
    System.out.println(" ");
      System.out.println("Ändra namn på gäst!");
        System.out.println("------------------------------------");
        for (int i=0; i<guestList.length; i++) {
          if(guestList[i][0] != ""){ //om gästlistan är inte tom visa gästlistan
            System.out.print(  i + ":" + " ");
               System.out.println( guestList[i][0] + " " + guestList[i][1] );
      }
    }
    boolean omdetfinnsnagon = false; // här kontrollerar jag om det finns någon i listan för att byta namn
     for (int i=0; i<guestList.length; i++) {
      if (guestList[i][0] != "") {
        omdetfinnsnagon = true;
      }
    }
    if(omdetfinnsnagon){
      System.out.println("Skriv numret där du vill ändra namnet, från 0 till 9!");
       System.out.println("------------------------------------");
        index = input.nextInt();
          System.out.println("------------------------------------");
            for (int i=0; i<guestList.length; i++) {
              if(guestList [index][0] == "" || index <= -1){ // om man väljer ett nummer där det finns inte en gäst då år man felmeddelandet
                System.out.println(index + " " + "är ogiltig! Välj ett nummer där numret är inte tom!");
                  break;
     }
              else{ guestList [index][0] = namn; // Jag frågar bara namnet här så skriver jag 0 till andra kolumn.
                System.out.println("Ange det nya namnet och efternamnet! ");
                  Scanner input = new Scanner(System.in);
                    namn = input.nextLine();
                      if(namn != ""){
                        guestList[index][0] = namn;
                         System.out.println("------------------------------------");
                          System.out.println("Nytt namn för nummer " + Integer.toString(index) + " är " + namn);
                            break;
          }
         }
        }
       }
  }

  public static void andraAlderPaGast(){
      System.out.println(" ");
        System.out.println("Ändra ålder på gäst!");
          System.out.println("------------------------------------");
            for (int i=0; i<guestList.length; i++) {
              if(guestList[i][0] != ""){ //om gästlistan är inte tom visa gästlistan
                  System.out.print(  i + ":" + " ");
                    System.out.println( guestList[i][0] + " " + guestList[i][1] );
         }
        }
        boolean omalder = false;
         for (int i=0; i<guestList.length; i++) {
          if (guestList[i][0] != "") {
           omalder = true;
          }
        }
        if(omalder){
         System.out.println("Skriv numret där du vill ändra ålder, från 0 till 9!");
          System.out.println("------------------------------------");
           index = input.nextInt();
            System.out.println("------------------------------------");
            for (int i=0; i<guestList.length; i++) {
             if(guestList[index][0] == "" || index <= -1){
              System.out.println(index + " " + "är ogiltig! Välj ett nummer där det finns personer i listan!");
               break;
          }
              else{guestList [index][1] = age; // Jag frågar bara ålder här så skriver jag 1 till andra kolumn.
               System.out.println("Ange det nya ålder! ");
                 Scanner input = new Scanner(System.in);
                   System.out.println("------------------------------------");
                     age = input.nextLine();
                       if(age != ""){
                        guestList [index][1] = age;
                        System.out.println("Ny ålder för " + guestList [index][0] + " är " + age);
                          break;

                }
              }
            }
          }
        }

  public static void taBortGast(){
    System.out.println(" ");
      System.out.println("Ta bort Gäst!"); //you don't need to keep this line
        System.out.println("------------------------------------");
    // Add your code here
    for (int i=0; i<guestList.length; i++) {
      if(guestList[i][0] != ""){ //om gästlistan är inte tom visa gästlistan
        System.out.print(  i + ":" + " ");
           System.out.println( guestList[i][0] + " " + guestList[i][1] );
      }
   }
   boolean omtabort = false;
    for (int i=0; i<guestList.length; i++) {
     if (guestList[i][0] != "") {
           omtabort = true;
      }
    }
      if(omtabort){
        System.out.println("------------------------------------");
         System.out.println("Ange ett nummer som du vill ta bort gästen!");
          System.out.println("------------------------------------");
            index2 = input.nextInt();
            if(guestList[index2][0] == ""){
                System.out.println("Du försöker ta bort en gäst som inte finns i listan!");
      }
            else{
             System.out.println("Gäst, " + guestList[index2][0] + " " + guestList[index][1] + " togs bort från gästlistan!");
              for(int i=0; i<guestList.length; i++){
               if(index2 == i){
                 guestList[i][0]="";
                   guestList[i][1]="";
                     break;
            }
          }
        }
      }
    }
  public static void bytaPlats(){
    System.out.println(" ");
     System.out.println("Att byta plats på gäster!"); //you don't need to keep this line
      System.out.println("------------------------------------");
    // Add your code here
    for (int i=0; i<guestList.length; i++) {
      if(guestList[i][0] != ""){ //om gästlistan är inte tom visa gästlistan
        System.out.print(  i + ":" + " ");
           System.out.println( guestList[i][0] + " " + guestList[i][1] );
      }
    }
   boolean omfinnsgast = false;
    for (int i=0; i<guestList.length; i++) {
      if (guestList[i][0] != "") {
           omfinnsgast = true;
      }
    }
       if(omfinnsgast){
          System.out.println("Ange första numret på gästen du vill byta plats på!");
            System.out.println("------------------------------------");
              index = input.nextInt();
                //if(guestList[index][0] == ""){
                //  System.out.println("Du försöker byta plats på en gäst vilken är inte finns i listan!");
                System.out.println("------------------------------------");
      //    }
                if(omfinnsgast){
                  System.out.println("Ange den andra numret på gästen som vill du vill byta plats på");
                  System.out.println("------------------------------------");

                  index1 = input.nextInt();
                }  else if(guestList[index1][0] == "" || guestList[index][0] == ""){
                    System.out.println("Du försöker byta plats på en gäst vilken är inte finns i listan!");
          }
                   else{
                     String namnIndex2 = "";
                     String alderIndex2 = "";
                     namnIndex1, alderIndex1;
                             for (int i = 0; i < guestList.length; i++) {
                               if(i == index1){
                                 guestList[i][0] = namnIndex2;
                                 guestList[i][1] = alderIndex2;
                               }

                               if(i == index2){
                                 guestList[i][0] = namnIndex1;
                                 guestList[i][1] = alderIndex1;
                               }
                             }
                              System.out.println(guestList[index][0] + " och " + guestList[index1][0] + "s platser byttes med varandra!");
        }
      }
    }
  public static void skrivUtMeny(){
    System.out.println(" ");
      System.out.println("----------------Program meny--------------"); //you don't need to keep this line
    // Add your code here
      System.out.println("------------------------------------");
        System.out.println("0: För att visa gäst list\n1: För att visa statistik av festen\n2: För att lägga till nya gäster till listan\n3: För att ändra namn på gäster\n4: För att ändra ålder på gäster\n5: För att ta bort gäster\n6: För att byta plats på gäster ");
          System.out.println("-1: För att avsluta programmet");
            System.out.println("------------------------------------");
  }

  public static void main(String[] args) {
     // Add you code here with the main loop that handles the user's menu choices.
      System.out.println(" ");

        System.out.println("Hjärligt vällkommen till födelsedagfesten!");
      while(true){
      // läs in val
        skrivUtMeny();
          int val = input.nextInt();

      if(val <= -2 || val >= 7){
        System.out.println("------------------------------------");
        System.out.println("Ogiltig val, välj ett nummer från -1 till 6!");
      }
       else if(val == 0){
         System.out.println("------------------------------------");
       skrivUtGastListan();
     }
        else if(val == 1){
          System.out.println("------------------------------------");
          skrivUtStatistik();
     }
        else if(val == 2) {
          System.out.println("------------------------------------");
          laggTillGast();
     }
        else if(val == 3){
          System.out.println("------------------------------------");
          andraNamnPaGast();
     }
        else if(val ==4){
          System.out.println("------------------------------------");
          andraAlderPaGast();
     }
        else if(val ==5){
          System.out.println("------------------------------------");
          taBortGast();
     }
        else if(val ==6){
          System.out.println("------------------------------------");
          bytaPlats();
     }
        else if(val == -1){
          System.out.println("------------------------------------");
            System.out.println("Vällkommen tillbaka, hejdå!");
          break;
     }
    }
   }
  }
