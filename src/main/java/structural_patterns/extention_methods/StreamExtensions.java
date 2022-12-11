package structural_patterns.extention_methods;

import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@UtilityClass
public class StreamExtensions {
    public static <T> List<T> toList(Stream<T> stream) {
        return stream.collect(Collectors.toList());
    }
}
