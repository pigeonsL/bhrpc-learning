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
package io.binghe.rpc.loadbalancer.robin.weight;

import io.binghe.rpc.loadbalancer.api.ServiceLoadBalancer;
import io.binghe.rpc.spi.annotation.SPIClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author binghe(公众号：冰河技术)
 * @version 1.0.0
 * @description 加权轮询负载均衡
 */
@SPIClass
public class RobinWeightServiceLoadBalancer<T> implements ServiceLoadBalancer<T> {
    private final Logger logger = LoggerFactory.getLogger(RobinWeightServiceLoadBalancer.class);
    private volatile AtomicInteger atomicInteger = new AtomicInteger(0);
    @Override
    public T select(List<T> servers, int hashCode, String sourceIp) {
        logger.info("基于加权轮询算法的负载均衡策略...");
        if (servers == null || servers.isEmpty()){
            return null;
        }
        hashCode = Math.abs(hashCode);
        int count = hashCode % servers.size();
        if (count <= 0){
            count = servers.size();
        }
        int index = atomicInteger.incrementAndGet();
        if (index >= Integer.MAX_VALUE - 10000){
            atomicInteger.set(0);
        }
        return servers.get(index % count);
    }
}
