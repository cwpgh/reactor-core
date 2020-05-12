package reactor.core.publisher;

import org.junit.Test;
import reactor.core.Scannable.Attr;

import static org.assertj.core.api.Assertions.assertThat;

public class MonoFilterFuseableTest {

    @Test
    public void scanUnsafe() {
        MonoFilterFuseable<Integer> test = new MonoFilterFuseable<>(Mono.just(1), (v -> v % 2 != 0));

        assertThat(test.scanUnsafe(Attr.RUN_STYLE)).isEqualTo(Attr.RunStyle.SYNC);
    }
}