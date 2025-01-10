package com.litongjava.study.netty.boot.handler;

import com.litongjava.model.body.RespBodyVo;
import com.litongjava.netty.boot.adapter.HttpRequest;
import com.litongjava.netty.boot.adapter.HttpResponse;
import com.litongjava.netty.boot.utils.HttpRequestUtils;
import com.litongjava.netty.boot.utils.HttpResponseUtils;

import io.netty.channel.ChannelHandlerContext;

public class OkHandler {

  public HttpResponse txt(ChannelHandlerContext ctx, HttpRequest httpRequest) throws Exception {
    String responseContent = "Hello, this is the HTTP response!";
    return HttpResponseUtils.txt(responseContent);
  }

  public HttpResponse json(ChannelHandlerContext ctx, HttpRequest httpRequest) throws Exception {
    RespBodyVo ok = RespBodyVo.ok();
    return HttpResponseUtils.json(ok);
  }

  public HttpResponse echo(ChannelHandlerContext ctx, HttpRequest httpRequest) {
    String fullHttpRequestString = HttpRequestUtils.getHttpRequestAsString(httpRequest);
    return HttpResponseUtils.txt(fullHttpRequestString);
  }
}
