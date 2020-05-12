package reactor.core.publisher;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static reactor.core.Scannable.*;


public class MonoDoFirstFuseableTest {

    @Test
    public void scanOperator(){
        MonoDoFirstFuseable<String> test = new MonoDoFirstFuseable<>(Mono.just("foo"), () -> {});

        assertThat(test.scanUnsafe(Attr.RUN_STYLE)).isEqualTo(Attr.RunStyle.SYNC);
    }

}