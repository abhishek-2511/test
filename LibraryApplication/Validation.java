package LibraryApplication;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Validation {
    
    public static LocalDate DateValidation(){

        Scanner sc = new Scanner(System.in);
        LocalDate date = null;

        while(true){
           
            try {
                System.out.println("Enter Date (YYYY-MM-DD) : ");
                String str = sc.next();
                date = LocalDate.parse(str);

                return date;
            } 
            catch (DateTimeParseException e) {   
                System.out.println("Please Enter in Valid Format (YYYY-MM-DD) : ");
            }
        }
    }

    public static BookType enumValidation(){

        while(true){

            try{
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter Book Type (HORROR,FANTASY,ROMANCE,LOVE,SCIFI) : ");

                String str = sc.next().toUpperCase();

                BookType b = BookType.valueOf(str);

                return b;
            }
            catch(IllegalArgumentException e){

                System.err.println("Please enter a Valid Type...");
            }
        }
    }
}
