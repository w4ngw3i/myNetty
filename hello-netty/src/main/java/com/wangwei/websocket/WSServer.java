package com.wangwei.websocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @Auther wangwei
 * @Date 2018/12/3 3:10 PM
 */
public class WSServer {
    public static void main(String[] args) throws InterruptedException {

        NioEventLoopGroup mainGroup = new NioEventLoopGroup();
        NioEventLoopGroup subGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap bootstrap = new ServerBootstrap();

            bootstrap.group(mainGroup, subGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new WSServerInitializer());

            ChannelFuture future = bootstrap.bind(8818).sync();

            future.channel().closeFuture().sync();

        }finally {

            mainGroup.shutdownGracefully();
            subGroup.shutdownGracefully();

        }




    }
}
