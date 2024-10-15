package LibraryApplication;

import java.io.Serializable;
import java.util.Objects;

public class BookKey implements Serializable {
    
    private final String title;
    private final String authorName;
    
    public BookKey(String title, String authorName) {
        this.title = title;
        this.authorName = authorName;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthorName() {
        return authorName;
    }

    @Override
    public int hashCode(){

        int readyHash = Objects.hash(title, authorName);

        return readyHash;
    }

    @Override
    public boolean equals(Object obj){

        if(obj == null){

            return false;
        }

        if(this == obj){
            
            return true;
        }

        if(this.getClass() != obj.getClass()){

            return false;
        }

        BookKey other = (BookKey) obj;

        return Objects.equals(other.authorName, authorName) && Objects.equals(other.title, title);
    }
}
