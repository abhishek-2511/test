package StreamApi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class tester {
    
    public static void main(String[] args) {
        
        List<Apple> list = new ArrayList<>();
        list.add(new Apple("Red", 20, "Sweet"));
        list.add(new Apple("Green", 10, "Bitter"));
        list.add(new Apple("Red", 5, "Sweet"));
        list.add(new Apple("Green", 26, "Sweet"));
        list.add(new Apple("Blue", 15, "Sweet"));
        list.add(new Apple("Blue", 30, "Bitter"));

        //Filter
        Stream<Apple> stream = list.stream();
        //stream.filter((a) -> a.colour.equals("Blue") || a.getColour().equals("Red"))
        //.forEach(System.out::println);

        //Using colect to make a set
        /*Set<Apple> set = stream.collect(Collectors.toSet());
        for(Apple ap : set){
            System.out.println(ap);
        }*/

        Map<String, List<Apple>> groupMap = stream.collect(Collectors.groupingBy(Apple :: getColour));

        groupMap.forEach((colour, apples) -> {

            System.out.println("Colou : " + colour);
            apples.forEach(apple -> System.out.println(" Apple : " + apple));
        });

        Set<Apple> streamSet = stream.collect(Collectors.toSet());
        
    }
}
