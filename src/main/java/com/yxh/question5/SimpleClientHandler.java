package com.yxh.question5;

import java.nio.charset.Charset;
import java.util.Scanner;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.AttributeKey;
import io.netty.util.CharsetUtil;

/**
 * @author yxh
 * @description
 * @time 2022/7/8 20:57
 */
public class SimpleClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof ByteBuf) {
            String value = ((ByteBuf) msg).toString(Charset.defaultCharset());
            System.out.println("服务器端返回的数据:" + value);
        }

        AttributeKey<String> key = AttributeKey.valueOf("ServerData");
        ctx.channel().attr(key).set("客户端处理完毕");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入网址: ");
        String url=sc.nextLine();
        url=url+"\r\n";
        ctx.writeAndFlush(Unpooled.copiedBuffer(url, CharsetUtil.UTF_8));
    }
}