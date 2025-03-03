package com.litongjava.study.netty.boot.config;

import java.util.function.Supplier;

import com.litongjava.annotation.AConfiguration;
import com.litongjava.annotation.Initialization;
import com.litongjava.jfinal.aop.Aop;
import com.litongjava.netty.boot.http.HttpRequestRouter;
import com.litongjava.netty.boot.server.NettyBootServer;
import com.litongjava.netty.boot.websocket.WebsocketRouter;
import com.litongjava.study.netty.boot.handler.OkHandler;
import com.litongjava.study.netty.boot.handler.Ws2Handler;
import com.litongjava.study.netty.boot.handler.WsHandler;

import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;

@AConfiguration
public class WebConfig {

  @Initialization
  public void config() {
    // 设置 HTTP 路由
    HttpRequestRouter httpRouter = NettyBootServer.me().getHttpRequestRouter();
    OkHandler okHandler = Aop.get(OkHandler.class);
    httpRouter.add("/txt", okHandler::txt);
    httpRouter.add("/ok", okHandler::json);
    httpRouter.add("/echo", okHandler::echo);

    // 设置 WebSocket 路由
    WebsocketRouter websocketRouter = NettyBootServer.me().getWebsocketRouter();
    Supplier<SimpleChannelInboundHandler<WebSocketFrame>> wsHandlerSupplier = WsHandler::new;
    websocketRouter.add("/ws", wsHandlerSupplier);
    websocketRouter.add("/ws2", Ws2Handler::new);
  }
}
