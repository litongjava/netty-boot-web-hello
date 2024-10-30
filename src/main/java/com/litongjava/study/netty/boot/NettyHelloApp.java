package com.litongjava.study.netty.boot;

import com.litongjava.annotation.AComponentScan;
import com.litongjava.netty.boot.NettyApplication;

@AComponentScan
public class NettyHelloApp {
  public static void main(String[] args) {
    NettyApplication.run(NettyHelloApp.class, args);
  }
}
