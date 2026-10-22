package com.bytedance.common.wschannel.channel.c.a;

import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes.dex */
public class b extends SSLSocketFactory {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f3380b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final SSLSocketFactory f3381a;

    static {
        f3380b = new String[]{"TLSv1.2"};
    }

    public b(SSLSocketFactory r1) {
        this.f3381a = r1;
    }

    private Socket a(Socket r2) {
        if ((r2 instanceof SSLSocket) == false) goto L5;
        ((SSLSocket) r2).setEnabledProtocols(f3380b);
    L5:
        return r2;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String r2, int r3) {
        Socket r4 = this.f3381a.createSocket(r2, r3);
        a(r4);
        return r4;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String r2, int r3, InetAddress r4, int r5) {
        Socket r6 = this.f3381a.createSocket(r2, r3, r4, r5);
        a(r6);
        return r6;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress r2, int r3) {
        Socket r4 = this.f3381a.createSocket(r2, r3);
        a(r4);
        return r4;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress r2, int r3, InetAddress r4, int r5) {
        Socket r6 = this.f3381a.createSocket(r2, r3, r4, r5);
        a(r6);
        return r6;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket r2, String r3, int r4, boolean r5) {
        Socket r6 = this.f3381a.createSocket(r2, r3, r4, r5);
        a(r6);
        return r6;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.f3381a.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return this.f3381a.getSupportedCipherSuites();
    }
}
