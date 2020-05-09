package functional;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static junit.framework.Assert.assertEquals;

public class MapVsFlatMap {
    public static void main(String[] args) {
        Optional<String> s = Optional.of("test");
        assertEquals(Optional.of("TEST"), s.map(String::toUpperCase));

        assertEquals(Optional.of("STRING"), Optional
                .of("string")
                .flatMap(x -> Optional.of("STRING")));

        List<String> myList = Stream.of("a", "b")
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        assertEquals(asList("A", "B"), myList);

        List<List<String>> list = Arrays.asList(
                Arrays.asList("a"),
                Arrays.asList("b"));
        System.out.println(list);

//        This snippet prints a list of lists [[a], [b]].
//        Now, let's use a flatMap():

        System.out.println(list
                .stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList()));

//        Converts List<List<String>> to List<String>
//        flatMap() method first flattens the input Stream of Streams to a Stream of Strings
    }

}
