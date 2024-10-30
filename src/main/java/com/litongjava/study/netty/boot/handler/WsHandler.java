package com.litongjava.study.netty.boot.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.handler.codec.http.websocketx.CloseWebSocketFrame;
import io.netty.handler.codec.http.websocketx.PingWebSocketFrame;
import io.netty.handler.codec.http.websocketx.PongWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WsHandler extends SimpleChannelInboundHandler<WebSocketFrame> {

  @Override
  protected void channelRead0(ChannelHandlerContext ctx, WebSocketFrame frame) throws Exception {
    if (frame instanceof TextWebSocketFrame) {
      String requestText = ((TextWebSocketFrame) frame).text();
      // 返回相同的消息
      ctx.channel().writeAndFlush(new TextWebSocketFrame("Server received: " + requestText));

    } else if (frame instanceof BinaryWebSocketFrame) {

    } else if (frame instanceof CloseWebSocketFrame) {
      ctx.channel().close();

    } else if (frame instanceof PingWebSocketFrame) {
      ctx.channel().writeAndFlush(new PongWebSocketFrame(frame.content().retain()));

    } else {
      throw new UnsupportedOperationException("不支持的帧类型: " + frame.getClass().getName());
    }
  }

  @Override
  public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
    log.info("ctx:{}", ctx);
  }

  @Override
  public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
    log.info("ctx:{}", ctx);
  }
}
