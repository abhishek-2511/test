package LibraryApplication;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class main {
    
    public static void main(String[] args) { 

        Map<BookKey, Book> map = new HashMap<>();

        Scanner sc = new Scanner(System.in);
        int choice = 0;

        do{ 
            System.out.println();
            System.out.println("----------MENU---------");
            System.out.println("1 : Add Book");
            System.out.println("2 : Display Book");
            System.out.println("3 : Allot Book");
            System.out.println("4 : Return Book");
            System.out.println("5 : Remove Book");
            System.out.println("6 : Read from File");
            System.out.println("7 : Exit");
            System.out.println();

            System.out.println("Enter your choice : ");
            choice = sc.nextInt();
            System.out.println();

            switch (choice) {
                
                case 1 : {

                    System.out.println("Enter title");
                    String title = sc.next();

                    BookType type = Validation.enumValidation();

                    System.out.println("Enter price : ");
                    int price = sc.nextInt();

                    LocalDate date = Validation.DateValidation();

                    System.out.println("Enter Author Name : ");
                    String authorName = sc.next();

                    System.out.println("Enter quantity : ");
                    int quantity = sc.nextInt();

                    Book b = new Book(title, type, price, date, authorName, quantity);
                    try{
                        if(map.containsKey(new BookKey(title, authorName))){

                            throw new DublicateBookException("*****Dublicate Book Found*****");
                        }

                        map.put(new BookKey(title, authorName), new Book(title, type, price, date, authorName, quantity));
                        System.out.println("Book Added SuccessFully");
                    }
                    catch(DublicateBookException e){

                        System.out.println(e.getMessage());
                    }

                    
                    //Entering Data into File
                    
                    /*System.out.println("Enter File Name : ");
                    String fileName = sc.next();

                    try(DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)))){

                        dos.writeUTF(title);
                        dos.writeInt(price);
                        dos.writeUTF(authorName);
                        dos.writeUTF(date.toString());
                        dos.writeUTF(type.toString());
                        dos.writeInt(quantity);
                    }
                    catch(IOException e){

                        System.out.println("File Exception");
                    }*/
                }
                break;

                case 2 : {
                    
                    if(map.size() == 0){

                        System.out.println("---No Books Available at the Moment---");
                    }
                    else{
                        System.out.println("------------Details of All Books------------");
                        for(Map.Entry<BookKey, Book> entry : map.entrySet()){

                            System.out.println(entry.getValue());
                        }
                    }
                }
                break;

                case 3 : {

                    System.out.println("Enter title to Get Book : ");
                    String title = sc.next();
                    System.out.println("Enter Author Name : ");
                    String authorName = sc.next();

                    BookKey key = new BookKey(title, authorName);
                    try{

                        if(!map.containsKey(key)){

                            throw new BookNotFoundException("**********Book Not Found***********");
                        }
                        Book b = map.get(key);

                        System.out.println("-> Allotted Book to student : " + b.title);
                        b.setQuantity(b.getQuantity() - 1);
                    }
                    catch(BookNotFoundException e){

                        System.err.println(e.getMessage());
                    }
                }
                break;

                case 4 : {

                    System.out.println("Enter title to Return Book : ");
                    String title = sc.next();
                    System.out.println("Enter Author Name : ");
                    String authorName = sc.next();

                    BookKey key = new BookKey(title, authorName);
                     
                    try{

                        if(!map.containsKey(key)){

                            throw new BookNotFoundException("**********Book Not Found***********");
                        }
                        Book b = map.get(key);
                        b.setQuantity(b.getQuantity() + 1);
                        System.out.println("-> Book Returned SuccessFully");
                        
                    }
                    catch(BookNotFoundException e){

                        System.err.println(e.getMessage());
                    }
                }
                break;

                case 5 : {

                    System.out.println("Enter title to Get Book : ");
                    String title = sc.next();
                    System.out.println("Enter Author Name : ");
                    String authorName = sc.next();

                    BookKey key = new BookKey(title, authorName);

                    try{

                        if(!map.containsKey(key)){

                            throw new BookNotFoundException("**********Book Not Found***********");
                        }
                        Book b = map.get(key);
                        System.out.println("Removed Book : " + b);
                        map.remove(key);
                    }
                    catch(BookNotFoundException e){

                        System.err.println(e.getMessage());
                    }
                }
                break;

                case 6 : {

                    System.out.println("Enter File Name : ");
                    String fileName = sc.next();

                    
                    /*try(DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(fileName)))){
                        
                        System.out.println(dis.readUTF() +  " " + dis.readInt() + " " + dis.readUTF() + 
                        
                        " " + dis.readUTF() + " " + dis.readUTF() + " " + dis.readInt());

                    } catch (IOException e) {
                        System.out.println("Exception in Reading");
                    }*/
                }
                break;

                case 7 : {

                    System.out.println("Exit SuccessFully");
                }
                break;
            
                default : {

                    break;
                }        
            }
        }
        while(choice != 6);
        
        return;
    }
}
