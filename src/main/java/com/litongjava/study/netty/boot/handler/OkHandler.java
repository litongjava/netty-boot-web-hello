package com.litongjava.study.netty.boot.handler;

import com.litongjava.model.body.RespBodyVo;
import com.litongjava.netty.boot.utils.HttpRequestUtils;
import com.litongjava.netty.boot.utils.HttpResponseUtils;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;

public class OkHandler {

  public FullHttpResponse txt(ChannelHandlerContext ctx, FullHttpRequest httpRequest) throws Exception {
    String responseContent = "Hello, this is the HTTP response!";
    return HttpResponseUtils.txt(responseContent);
  }

  public FullHttpResponse json(ChannelHandlerContext ctx, FullHttpRequest httpRequest) throws Exception {
    RespBodyVo ok = RespBodyVo.ok();
    return HttpResponseUtils.json(ok);
  }

  public FullHttpResponse echo(ChannelHandlerContext ctx, FullHttpRequest httpRequest) {
    String fullHttpRequestString = HttpRequestUtils.getFullHttpRequestAsString(httpRequest);
    return HttpResponseUtils.txt(fullHttpRequestString);
  }
}
