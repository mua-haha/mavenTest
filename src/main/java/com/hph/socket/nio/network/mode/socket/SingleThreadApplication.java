package com.hph.socket.nio.network.mode.socket;

import com.hph.socket.nio.network.constant.HttpConstant;

/**
 * Created by jason-geng on 8/16/17.
 */
public class SingleThreadApplication {

    public static void main(String[] args) {

        for (final String host: HttpConstant.HOSTS) {

            new SocketHttpClient().start(host, HttpConstant.PORT);

        }

    }
}
