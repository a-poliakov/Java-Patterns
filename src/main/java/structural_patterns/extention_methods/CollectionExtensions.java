package structural_patterns.extention_methods;

import lombok.experimental.UtilityClass;

import java.util.Collection;
import java.util.function.IntFunction;

@UtilityClass
public class CollectionExtensions {
    public static <T> T[] toArray(Collection<T> list, IntFunction<T[]> generator) {
        return list.stream().toArray(generator);
    }
}
