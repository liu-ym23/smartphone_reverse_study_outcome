package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes3.dex */
public class Tls12SocketFactory extends SSLSocketFactory {
    private static final String[] TLS_V12_ONLY = null;
    final SSLSocketFactory delegate;

    static {
        TLS_V12_ONLY = new String[]{"TLSv1.2"};
    }

    public Tls12SocketFactory(SSLSocketFactory r1) {
        this.delegate = r1;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.delegate.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return this.delegate.getSupportedCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket r2, String r3, int r4, boolean r5) throws IOException {
        return patch(this.delegate.createSocket(r2, r3, r4, r5));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String r2, int r3) throws IOException {
        return patch(this.delegate.createSocket(r2, r3));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String r2, int r3, InetAddress r4, int r5) throws IOException {
        return patch(this.delegate.createSocket(r2, r3, r4, r5));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress r2, int r3) throws IOException {
        return patch(this.delegate.createSocket(r2, r3));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress r2, int r3, InetAddress r4, int r5) throws IOException {
        return patch(this.delegate.createSocket(r2, r3, r4, r5));
    }

    private Socket patch(Socket r2) {
        if ((r2 instanceof SSLSocket) == false) goto L5;
        ((SSLSocket) r2).setEnabledProtocols(TLS_V12_ONLY);
    L5:
        return r2;
    }
}
