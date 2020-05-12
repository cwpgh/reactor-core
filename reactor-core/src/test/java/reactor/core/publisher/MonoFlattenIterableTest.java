package reactor.core.publisher;

import org.junit.Test;
import reactor.core.Scannable;
import reactor.util.concurrent.Queues;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


public class MonoFlattenIterableTest {

    @Test
    public void scanOperator(){
        MonoFlattenIterable<Integer, ArrayList<Integer>> test = new MonoFlattenIterable(Mono.just(1), i -> Arrays.asList(i), Integer
                .MAX_VALUE, Queues.one());

        assertThat(Scannable.from(test).scanUnsafe(Scannable.Attr.RUN_STYLE)).isEqualTo(Scannable.Attr.RunStyle.SYNC);
    }

}