package reactor.core.publisher;

import org.junit.Test;
import reactor.core.Scannable;

import java.util.logging.Level;

import static org.assertj.core.api.Assertions.assertThat;

public class MonoLogTest {

    @Test
    public void scanOperator(){
        Mono<Integer> source = Mono.just(1);
        MonoLog<Integer> test = new MonoLog(source,
                new SignalLogger<>(source, "category", Level.INFO, false, SignalType.ON_COMPLETE));

        assertThat(test.scanUnsafe(Scannable.Attr.RUN_STYLE)).isEqualTo(Scannable.Attr.RunStyle.SYNC);
    }

}