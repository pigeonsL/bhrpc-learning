/**
 * Copyright 2020-9999 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.binghe.rpc.test.spi;

import io.binghe.rpc.spi.loader.ExtensionLoader;
import io.binghe.rpc.test.spi.service.SPIService;
import org.junit.Test;

/**
 * @author binghe(公众号 ： 冰河技术)
 * @version 1.0.0
 * @description SPI测试类
 */
public class SPITest {
    @Test
    public void testSpiLoader(){
        SPIService spiService = ExtensionLoader.getExtension(SPIService.class, "spiService");
        String result = spiService.hello("binghe");
        System.out.println(result);
    }
}
