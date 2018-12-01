package com.wangwei.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @Auther wangwei
 * @Date 2018/11/30 1:33 PM
 */
public class NettyServer {
    public static void main(String[] args) throws InterruptedException {
        /**
         * 定义一对线程组
         */
        //主线程组，主要用来接受请求
        EventLoopGroup bossGroup = new NioEventLoopGroup();

        //从线程组，主要用来处理请求
        EventLoopGroup workGroup = new NioEventLoopGroup();

        try {
            //创建netty服务器
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workGroup) //设置主从线程组
                    .channel(NioServerSocketChannel.class) //设置nio的双向通道
                    .childHandler(new NettyServerInitializer()); //子处理器，用来处理workGriop

            //启动server并设置端口号为8818
            ChannelFuture channelFuture = bootstrap.bind(8818).sync();

            //监听关闭的channel并设置为同步
            channelFuture.channel().closeFuture().sync();
        }finally {

            bossGroup.shutdownGracefully();
        }


    }
}
