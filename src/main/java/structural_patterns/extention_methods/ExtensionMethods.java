package structural_patterns.extention_methods;

import lombok.experimental.ExtensionMethod;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.capitalize;

//@ExtensionMethod(StringUtils.class)
public class ExtensionMethods {
    public static void main(String[] args) {
        String str = "test";
        //String capitalized = str.capitalize();
        String capitalized = capitalize(str);
        // "Test"
        System.out.println(capitalized);

        String nullStr = null;
        // "isEmpty=true"
        //System.out.println("isEmpty=" + nullStr.trimToEmpty().isEmpty());

        List<Integer> list = Arrays.asList(1, 2, 3);
//        // toArray(IntFunction<T[]>) добавлен только в Java 11
//        Integer[] array = list.toArray(Integer[]::new);
//        // "[1, 2, 3]"
//        System.out.println(Arrays.toString(array));

//        List<Integer> sorted = list.stream()
//                .sorted()
//                .toList();
//
//        // "[1, 2, 3]"
//        System.out.println(sorted);
    }
}
