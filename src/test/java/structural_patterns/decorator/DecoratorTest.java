package structural_patterns.decorator;

import structural_patterns.decorator.BubbleLights;
import structural_patterns.decorator.ChristmasTree;
import structural_patterns.decorator.ChristmasTreeImpl;
import structural_patterns.decorator.Garland;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DecoratorTest {
    @Test
    public void whenDecoratorsInjectedAtRuntime_thenConfigSuccess() {
        ChristmasTree tree1 = new Garland(new ChristmasTreeImpl());
        assertEquals(tree1.decorate(),
                "Christmas tree with Garland");

        ChristmasTree tree2 = new BubbleLights(
                new Garland(new Garland(new ChristmasTreeImpl())));
        assertEquals(tree2.decorate(),
                "Christmas tree with Garland with Garland with Bubble Lights");
    }
}
