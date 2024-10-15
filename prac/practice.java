import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;

public class practice {
   
    public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);
        LocalDate date = null;  // Declare the date variable
        
        while (date == null) {  // Keep asking until a valid date is entered
            try {
                System.out.println("Enter Publish Date (YYYY-MM-DD): ");
                String str = sc.next();
                date = LocalDate.parse(str);  // Attempt to parse the date
                System.out.println("Valid date entered: " + date);
            } catch (DateTimeParseException e) {
                System.err.println("Invalid date format. Please enter the date in YYYY-MM-DD format.");
            }
        }
        
        System.out.println("Verified : " + date);

        /*System.out.println("Enter Enum Type of Book : ");
        String type = sc.next();
        
        try {
            BookType t = BookType.valueOf(type);
            System.out.println("Got Enum : " + t);

        } catch (IllegalArgumentException e) {

            try {
                throw new CustomException("INVALID ENUM SELECTED");
            } 
            catch (CustomException ce) {
                
                System.err.println(ce.getMessage());
            }
            System.err.print(e.getMessage());
        }*/

        /*try {
            int a = sc.nextInt();

            if(a < 0){
                throw new CustomException("~~~~~Can't be Negative---------");
            }
            System.out.println("SuccessFul : " + a);
            
        } catch (InputMismatchException e) {
            
            System.err.println("Please Enter Input Correctly");
        }
        catch(CustomException e){

            System.err.println(e.getMessage());
        }
        */
    }
}