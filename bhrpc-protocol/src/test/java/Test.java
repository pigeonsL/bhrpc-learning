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

import io.binghe.rpc.protocol.RpcProtocol;
import io.binghe.rpc.protocol.enumeration.RpcType;
import io.binghe.rpc.protocol.header.RpcHeader;
import io.binghe.rpc.protocol.header.RpcHeaderFactory;
import io.binghe.rpc.protocol.request.RpcRequest;

/**
 * @author binghe(公众号 ： 冰河技术)
 * @version 1.0.0
 * @description
 */
public class Test {
     public static RpcProtocol<RpcRequest> getRpcProtocol(){
        RpcHeader header = RpcHeaderFactory.getRequestHeader("jdk", RpcType.REQUEST.getType());
        RpcRequest body = new RpcRequest();
        body.setOneway(false);
        body.setAsync(false);
        body.setClassName("io.binghe.rpc.demo.RpcProtocol");
        body.setMethodName("hello");
        body.setGroup("binghe");
        body.setParameters(new Object[]{"binghe"});
        body.setParameterTypes(new Class[]{String.class});
        body.setVersion("1.0.0");
        RpcProtocol<RpcRequest> protocol = new RpcProtocol<>();
        protocol.setBody(body);
        protocol.setHeader(header);
        return protocol;
    }
}
