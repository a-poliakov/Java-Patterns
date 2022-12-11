package behavior_patterns.visitor;

public interface Visitor {

    void visit(XmlElement xe);

    void visit(JsonElement je);
}
