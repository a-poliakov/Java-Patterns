package behavior_patterns.utils;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class TestContext {
    private CorStatuses status = CorStatuses.NONE;
    private Integer some = 0;
    private String history = "";
}
