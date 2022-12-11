package behavior_patterns.COR;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import behavior_patterns.COR.impl.CorChain;
import behavior_patterns.COR.impl.CorWorker;
import behavior_patterns.utils.CorStatuses;
import behavior_patterns.utils.TestContext;

import java.util.Arrays;

class CorChainTest {
    @Test
    @DisplayName("create and run chain")
    void testCreateAndRunChain() {
        CorChain<TestContext> chain = new CorChain<>(
                "my first chain",
                Arrays.asList(
                        new CorWorker<>(
                                "w1",
                                (t) -> t.getStatus() == CorStatuses.NONE,
                                (t) -> {
                                    t.setStatus(CorStatuses.RUNNING);
                                    t.setHistory(t.getHistory() + "w1; ");
                                }
                        ),
                        new CorChain<>(
                                "inner chain",
                                Arrays.asList(
                                        someComplexWorker(),
                                        new CorWorker<>(
                                                "w3",
                                                (t) -> t.getStatus() == CorStatuses.ERROR,
                                                (t) -> {
                                                    t.setHistory(t.getHistory() + "w3; ");
                                                }
                                        )
                                )
                        )
                )
        );

        TestContext ctx = new TestContext();
        chain.exec(ctx);
        System.out.println(ctx);
    }

    private CorWorker<TestContext> someComplexWorker() {
        return new CorWorker<>(
                "w2",
                (t) -> {
                    t.setHistory(t.getHistory() + "w2; ");
                }
        );
    }


}
