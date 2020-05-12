/*
 * Copyright (c) 2011-2017 Pivotal Software Inc, All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package reactor.core.publisher;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Assert;
import org.junit.Test;
import reactor.core.Scannable;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static reactor.core.Scannable.from;

public class MonoDeferTest {

	@Test
	public void deferMono(){
		AtomicInteger i = new AtomicInteger();

		Mono<Integer> source =
				Mono.defer(() -> Mono.just(i.incrementAndGet()));

		Assert.assertEquals(source.block().intValue(), 1);
		Assert.assertEquals(source.block().intValue(), 2);
		Assert.assertEquals(source.block().intValue(), 3);
	}

	@Test
	public void scanMonoDefer() {
		AtomicInteger i = new AtomicInteger();

		Mono<Integer> test =
				Mono.defer(() -> Mono.just(i.incrementAndGet()));

		assertThat(from(test).scan(Scannable.Attr.RUN_STYLE)).isEqualTo(Scannable.Attr.RunStyle.SYNC);
		assertThat(from(test).scan(Scannable.Attr.ACTUAL)).isNull();
	}
}