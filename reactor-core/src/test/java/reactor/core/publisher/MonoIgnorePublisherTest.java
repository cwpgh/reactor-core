package reactor.core.publisher;

import org.junit.Test;
import reactor.core.Scannable;
import reactor.test.StepVerifier;

import static org.assertj.core.api.Assertions.assertThat;
import static reactor.core.Scannable.from;

public class MonoIgnorePublisherTest {

    @Test
    public void normal() {
        StepVerifier.create(Mono.ignoreElements(Mono.just("foo")))
                .expectSubscription()
                .verifyComplete();
    }

    @Test
    public void scanOperator(){
        Mono<String> source = Mono.just("foo");
        Mono<String> test = Mono.ignoreElements(source);

        assertThat(from(test).scan(Scannable.Attr.PARENT)).isEqualTo(source);
        assertThat(from(test).scan(Scannable.Attr.RUN_STYLE)).isEqualTo(Scannable.Attr.RunStyle.SYNC);
    }
}