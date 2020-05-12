package reactor.core.publisher;

import org.junit.Test;
import reactor.core.Scannable;

import java.util.logging.Level;

import static org.assertj.core.api.Assertions.assertThat;

public class MonoLogFuseableTest {

    @Test
    public void scanOperator(){
        Mono<Integer> source = Mono.just(1);
        MonoLogFuseable<Integer> test = new MonoLogFuseable(source,
                new SignalLogger<>(source, "category", Level.INFO, false, SignalType.ON_COMPLETE));

        assertThat(test.scanUnsafe(Scannable.Attr.RUN_STYLE)).isEqualTo(Scannable.Attr.RunStyle.SYNC);
    }

}