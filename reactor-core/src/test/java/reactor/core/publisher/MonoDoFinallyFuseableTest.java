package reactor.core.publisher;


import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import reactor.core.Scannable;

import java.util.function.Consumer;

public class MonoDoFinallyFuseableTest implements Consumer<SignalType> {

    volatile SignalType signalType;
    volatile int calls;

    @Before
    public void before() {
        signalType = null;
        calls = 0;
    }

    @Override
    public void accept(SignalType signalType) {
        this.signalType = signalType;
        this.calls++;
    }

    @Test
    public void scanOperator(){
        MonoDoFinallyFuseable<String> test = new MonoDoFinallyFuseable<>(Mono.just("foo"), this);

        Assertions.assertThat(test.scanUnsafe(Scannable.Attr.RUN_STYLE)).isEqualTo(Scannable.Attr.RunStyle.SYNC);
    }
}