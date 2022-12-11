package behavior_patterns.visitor;

import org.junit.jupiter.api.Test;

import java.util.UUID;

public class VisitorTest {
    @Test
    void testVisitor() {
        Visitor v = new ElementVisitor();

        Document d = new Document(generateUuid());
        d.elements.add(new JsonElement(generateUuid()));
        d.elements.add(new JsonElement(generateUuid()));
        d.elements.add(new XmlElement(generateUuid()));

        d.accept(v);
    }

    private static String generateUuid() {
        return UUID.randomUUID()
                .toString();
    }
}
