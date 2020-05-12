package reactor.core.publisher;

import org.junit.Test;
import reactor.util.context.Context;

import static org.assertj.core.api.Assertions.assertThat;
import static reactor.core.Scannable.*;
import static reactor.core.Scannable.from;

public class MonoCurrentContextTest {

    @Test
    public void scanOperator(){
        Mono<Context> test = Mono.subscriberContext();

        assertThat(from(test).scan(Attr.RUN_STYLE)).isEqualTo(Attr.RunStyle.SYNC);
    }

}