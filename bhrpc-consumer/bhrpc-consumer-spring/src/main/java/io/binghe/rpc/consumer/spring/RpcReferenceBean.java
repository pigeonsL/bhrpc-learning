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
package io.binghe.rpc.consumer.spring;

import io.binghe.rpc.consumer.RpcClient;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author binghe(公众号：冰河技术)
 * @version 1.0.0
 * @description RpcReferenceBean
 */
public class RpcReferenceBean implements FactoryBean<Object> {
    /**
     * 接口类型
     */
    private Class<?> interfaceClass;
    /**
     * 版本号
     */
    private String version;
    /**
     * 注册中心类型：zookeeper/nacos/apoll/etcd/eureka等
     */
    private String registryType;

    /**
     * 负载均衡类型：zkconsistenthash
     */
    private String loadBalanceType;

    /**
     * 序列化类型：fst/kryo/protostuff/jdk/hessian2/json
     */
    private String serializationType;

    /**
     * 注册中心地址
     */
    private String registryAddress;
    /**
     * 超时时间
     */
    private long timeout;

    /**
     * 服务分组
     */
    private String group;
    /**
     * 是否异步
     */
    private boolean async;

    /**
     * 是否单向调用
     */
    private boolean oneway;
    /**
     * 代理方式
     */
    private String proxy;
    /**
     * 生成的代理对象
     */
    private Object object;

    /**
     * 扫描空闲连接时间，默认60秒
     */
    private int scanNotActiveChannelInterval;

    /**
     * 心跳检测时间
     */
    private int heartbeatInterval;

    //重试间隔时间
    private int retryInterval = 1000;

    //重试次数
    private int retryTimes = 3;

    private RpcClient rpcClient;

    @Override
    public Object getObject() throws Exception {
        return object;
    }

    @Override
    public Class<?> getObjectType() {
       return interfaceClass;
    }

    @SuppressWarnings("unchecked")
    public void init(){
        rpcClient = new RpcClient(registryAddress, registryType, loadBalanceType, proxy, version, group, serializationType, timeout, async, oneway, heartbeatInterval, scanNotActiveChannelInterval, retryInterval, retryTimes);
        this.object = rpcClient.create(interfaceClass);
    }

    public void setInterfaceClass(Class<?> interfaceClass) {
        this.interfaceClass = interfaceClass;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setRegistryType(String registryType) {
        this.registryType = registryType;
    }

    public void setRegistryAddress(String registryAddress) {
        this.registryAddress = registryAddress;
    }

    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }

    public void setAsync(boolean async) {
        this.async = async;
    }

    public void setProxy(String proxy) {
        this.proxy = proxy;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setLoadBalanceType(String loadBalanceType) {
        this.loadBalanceType = loadBalanceType;
    }

    public void setSerializationType(String serializationType) {
        this.serializationType = serializationType;
    }

    public void setOneway(boolean oneway){
        this.oneway = oneway;
    }

    public void setHeartbeatInterval(int heartbeatInterval) {
        this.heartbeatInterval = heartbeatInterval;
    }

    public void setRetryInterval(int retryInterval) {
        this.retryInterval = retryInterval;
    }

    public void setRetryTimes(int retryTimes) {
        this.retryTimes = retryTimes;
    }

    public void setScanNotActiveChannelInterval(int scanNotActiveChannelInterval) {
        this.scanNotActiveChannelInterval = scanNotActiveChannelInterval;
    }

    public String getVersion() {
        return version;
    }

    public String getRegistryType() {
        return registryType;
    }

    public String getLoadBalanceType() {
        return loadBalanceType;
    }

    public String getSerializationType() {
        return serializationType;
    }

    public String getRegistryAddress() {
        return registryAddress;
    }

    public long getTimeout() {
        return timeout;
    }

    public String getGroup() {
        return group;
    }

    public boolean isAsync() {
        return async;
    }

    public boolean isOneway() {
        return oneway;
    }

    public String getProxy() {
        return proxy;
    }

    public int getScanNotActiveChannelInterval() {
        return scanNotActiveChannelInterval;
    }

    public int getHeartbeatInterval() {
        return heartbeatInterval;
    }

    public int getRetryInterval() {
        return retryInterval;
    }

    public int getRetryTimes() {
        return retryTimes;
    }

    public RpcClient getRpcClient() {
        return rpcClient;
    }
}
