package com.wangwei.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;


/**
 * 初始化器，channel注册后，会执行里面相应的初始化方法
 * @Auther wangwei
 * @Date 2018/11/30 10:26 PM
 */
public class NettyServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {

        //通过SocketChannel获取对应的管道
        ChannelPipeline pipeline = socketChannel.pipeline();

        /**
         * 通过管道添加Handler
         * HttpServerCodec是netty提供的类，可以理解为拦截器
         * 当请求到达服务端时我们需要做解码，响应到客户端做编码
         */
        pipeline.addLast("HttpServerCodec", new HttpServerCodec());


        //添加自定义的类，返回hello netty
        pipeline.addLast("", new CustomHandler());
    }
}
