package StreamApi;

public class Apple {
    
    String colour;
    int weight;
    String taste;
    
    public Apple(String colour, int weight, String taste) {
        this.colour = colour;
        this.weight = weight;
        this.taste = taste;
    }

    public String getColour() {
        return colour;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Apple [colour=" + colour + ", weight=" + weight + ", taste=" + taste + "]";
    }

    public String getTaste() {
        return taste;
    }
}
