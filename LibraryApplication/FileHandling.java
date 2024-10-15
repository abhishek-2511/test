package LibraryApplication;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class FileHandling {
    public static void main(String[] args) {
        
        List<Book> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        /*list.add(new Book("The Fantasy World", BookType.FANTASY, 500, LocalDate.of(2022, 5, 10), "J.K. Rowling", 100));
        list.add(new Book("The Mystery Island", BookType.ROMANCE, 300, LocalDate.of(2020, 6, 25), "Agatha Christie", 50));
        list.add(new Book("Science Fiction Story", BookType.SCIFI, 450, LocalDate.of(2023, 1, 15), "Isaac Asimov", 75));
        list.add(new Book("Horror Night", BookType.HORROR, 350, LocalDate.of(2019, 10, 31), "Stephen King", 120));
        list.add(new Book("Alien Invasion", BookType.SCIFI, 400, LocalDate.of(2021, 3, 20), "H.G. Wells", 60));

        
        System.out.println("Enter File Name : ");
        String fileName = sc.next();
        //Sending Objects into File
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))){
            
            for(Book b : list){
                oos.writeObject(b);
            }
        } catch (IOException e) {
            
            System.out.println("Exception while Sending into File");
        }*/
        System.out.println("Enter File Name : ");
        String fileName = sc.next();

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))){

             while (true) {
                try {
                    // Read object and cast it to Book
                    Book b = (Book) ois.readObject();
                    System.out.println(b);
                } catch (EOFException e) {
                    // When EOF is reached, break the loop
                    System.out.println("End of File Reached");
                    break;
                } catch (ClassNotFoundException e) {
                    System.out.println("Class Not Found");
                    break;
                }
            }
        } 
        catch (FileNotFoundException e) {
                System.out.println("File not found: " + fileName);
        } 
        catch (IOException e) {
            System.out.println("Exception while Reading IO: " + e.getMessage());
        }

    }
}
