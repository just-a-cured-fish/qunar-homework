package com.yxh.question5;

import com.yxh.core.entity.Result;
import com.yxh.core.util.CharacterUtil;
import com.yxh.core.util.HttpClientUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;

/**
 * @author yxh
 * @description
 * @time 2022/7/8 20:51
 */
public class SimpleServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * 读取客户端通道的数据
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println(((ByteBuf) msg).toString(Charset.defaultCharset()));
        String response = HttpClientUtil.doGet(((ByteBuf) msg).toString(Charset.defaultCharset()), Charset.defaultCharset().name());
        response = count(response)+"\r\n";
        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes(response.getBytes());
        ctx.channel().writeAndFlush(buf);

    }

    public String count(String response) {
        char[] charArr = response.toCharArray();
        int charCount = charArr.length;
        int letterCount = 0;
        int chineseCount = 0;
        int markCount = 0;
        for (char character : charArr) {
            if (CharacterUtil.isChinese(character)) {
                chineseCount++;
            }
            if (CharacterUtil.isLetter(character)) {
                letterCount++;
            }
            if (CharacterUtil.isMark(character)) {
                markCount++;
            }
        }
        return new Result(charCount, letterCount, chineseCount, markCount).toString();
    }
}
