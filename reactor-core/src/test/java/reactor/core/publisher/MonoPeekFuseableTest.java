package reactor.core.publisher;

import org.junit.Test;
import reactor.core.Scannable;

import static org.assertj.core.api.Assertions.assertThat;

public class MonoPeekFuseableTest {

    @Test
    public void scanOperator(){
        MonoPeekFuseable test = new MonoPeekFuseable(Mono.just(1), null, null, null, null, null, null);

        assertThat(test.scanUnsafe(Scannable.Attr.RUN_STYLE)).isEqualTo(Scannable.Attr.RunStyle.SYNC);
    }

}