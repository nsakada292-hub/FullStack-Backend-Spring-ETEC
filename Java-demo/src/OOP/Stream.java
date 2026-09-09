package OOP;

import java.util.List;

public class Stream {
    static void main(String[] args) {
        List<Integer> num=List.of(1,2,3,4,5);

        num.stream()
                .map(n->n*10)
                .forEach(System.out::println);
    }
}
