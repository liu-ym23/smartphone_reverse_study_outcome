package com.loc;

import android.content.Context;
import android.net.SSLSessionCache;
import android.os.Build;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSessionContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes2.dex */
public final class s0 extends SSLSocketFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SSLSocketFactory f7749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f7750b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private SSLContext f7751c;

    public s0(Context r6, SSLContext r7) {
        int r0 = Build.VERSION.SDK_INT;
        if (r6 != null) goto L53;
    L5:
        this.f7751c = r7;     // Catch: Throwable -> L22
        if (r7 == null) goto L65;
        this.f7749a = r7.getSocketFactory();     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        v.m(th, "myssl", "<init>");     // Catch: Throwable -> L38
    L29:
        th = move-exception;
        v.m(th, "myssl", "<init2>");
    L57:
    L35:
        th = move-exception;
        v.m(th, "myssl", "<init3>");
        return;
    L32:
        if (this.f7749a != null) goto L70;
        this.f7749a = (SSLSocketFactory) SSLSocketFactory.getDefault();     // Catch: Throwable -> L35
        return;
    L70:
        return;
    L25:
        if (this.f7751c != null) goto L57;
        if (r0 < 9) goto L57;
        this.f7751c = SSLContext.getDefault();     // Catch: Throwable -> L29
    L38:
        th = move-exception;
    L44:
        th = move-exception;
        v.m(th, "myssl", "<init2>");
    L61:
    L50:
        th = move-exception;
        v.m(th, "myssl", "<init3>");
        throw th;
    L47:
        if (this.f7749a != null) goto L71;
        this.f7749a = (SSLSocketFactory) SSLSocketFactory.getDefault();     // Catch: Throwable -> L50
        throw th;
    L71:
        throw th;
    L40:
        if (this.f7751c != null) goto L61;
        if (r0 < 9) goto L61;
        this.f7751c = SSLContext.getDefault();     // Catch: Throwable -> L44
    L65:
    L13:
        th = move-exception;
        v.m(th, "myssl", "<init2>");
    L67:
    L19:
        th = move-exception;
        v.m(th, "myssl", "<init3>");
        return;
    L16:
        if (this.f7749a != null) goto L69;
        this.f7749a = (SSLSocketFactory) SSLSocketFactory.getDefault();     // Catch: Throwable -> L19
        return;
    L69:
        return;
    L9:
        if (this.f7751c != null) goto L67;
        if (r0 < 9) goto L67;
        this.f7751c = SSLContext.getDefault();     // Catch: Throwable -> L13
        goto L67
    L53:
        this.f7750b = r6.getApplicationContext();     // Catch: Throwable -> L22
        goto L5
    }

    private static Socket a(Socket r3) {
    L11:
        th = move-exception;
        v.m(th, "myssl", "stlv2");
    L13:
        return r3;
    L3:
        if (Build.VERSION.SDK_INT >= 21) goto L6;
        return r3;
    L6:
        if (j5.g.f7454b == false) goto L13;
        if ((r3 instanceof SSLSocket) == false) goto L13;
        ((SSLSocket) r3).setEnabledProtocols(new String[]{"TLSv1.2"});     // Catch: Throwable -> L11
        goto L13
    }

    private void c(SSLSessionCache r9) {
        SSLContext r8 = this.f7751c;
        if (r8 != null) goto L16;
        return;
    L16:
        SSLSessionContext r10 = r8.getClientSessionContext();     // Catch: Throwable -> L13
        Field r0 = r9.getClass().getDeclaredField(u5.u("UbVNlc3Npb25DYWNoZQ"));     // Catch: Throwable -> L13
        r0.setAccessible(true);     // Catch: Throwable -> L13
        Object r11 = r0.get(r9);     // Catch: Throwable -> L13
        Method[] r1 = r10.getClass().getMethods();     // Catch: Throwable -> L13
        String r2 = u5.u("Yc2V0UGVyc2lzdGVudENhY2hl");     // Catch: Throwable -> L13
        int r3 = r1.length;     // Catch: Throwable -> L13
        int r5 = 0;
    L6:
        if (r5 >= r3) goto L12;
        Method r6 = r1[r5];     // Catch: Throwable -> L13
        if (r6.getName().equals(r2) == true) goto L9;
        r5 = r5 + 1;
        goto L6
    L9:
        r6.invoke(r10, new Object[]{r11});     // Catch: Throwable -> L13
        return;
    L12:
        return;
    L13:
        th = move-exception;
        v.m(th, "myssl", "isc2");
    }

    private static void d(Socket r6) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 >= 17) goto L6;
        return;
    L6:
        if (j5.g.f7455c == true) goto L8;
        return;
    L8:
        if (j5.g.f7457e == true) goto L11;
        return;
    L11:
        if ((r6 instanceof SSLSocket) == true) goto L13;
        return;
    L13:
        int r2 = j5.g.f7458f;
        int r3 = j5.g.f7456d;
        if (r2 > r3) goto L17;
        r3 = j5.g.f7458f;
    L17:
        if (r3 <= 17) goto L20;
        if (r0 <= r3) goto L20;
        return;
    L20:
        Class<?> r1 = r6.getClass();
        r1.getMethod(u5.u("Cc2V0VXNlU2Vzc2lvblRpY2tldHM"), new Class[]{Boolean.TYPE}).invoke(r6, new Object[]{Boolean.TRUE});     // Catch: Throwable -> L23
        return;
    L23:
        th = move-exception;
        v.m(th, "myssl", "sust");
    }

    public final void b() {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 >= 17) goto L6;
        return;
    L6:
        if (j5.g.f7455c == true) goto L9;
        return;
    L9:
        if (this.f7750b != null) goto L11;
        return;
    L11:
        if (this.f7751c == null) goto L31;
        int r2 = j5.g.f7456d;
        if (r2 <= 17) goto L17;
        if (r0 <= r2) goto L17;
        return;
    L17:
        SSLSessionCache r1 = new SSLSessionCache(this.f7750b);
        if (r0 > 20) goto L20;
    L26:
        c(r1);
        return;
    L20:
        if (r0 >= 28) goto L26;
        r1.getClass().getMethod(u5.u("MaW5zdGFsbA"), new Class[]{SSLSessionCache.class, SSLContext.class}).invoke(r1, new Object[]{r1, this.f7751c});     // Catch: Throwable -> L23
        return;
    L23:
        th = move-exception;
        v.m(th, "myssl", "isc1");
        c(r1);
        return;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket() {
        SSLSocketFactory r2 = this.f7749a;     // Catch: Throwable -> L6
        if (r2 == null) goto L9;
        Socket r3 = r2.createSocket();     // Catch: Throwable -> L6
        a(r3);     // Catch: Throwable -> L6
        d(r3);     // Catch: Throwable -> L6
        return r3;
    L9:
        return null;
    L6:
        th = move-exception;
        v.m(th, "myssl", "cs1");
        if ((th instanceof IOException) == true) goto L12;
        return null;
    L12:
        throw th;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String r1, int r2) {
        SSLSocketFactory r0 = this.f7749a;     // Catch: Throwable -> L6
        if (r0 == null) goto L11;
        Socket r3 = r0.createSocket(r1, r2);     // Catch: Throwable -> L6
        a(r3);     // Catch: Throwable -> L6
        d(r3);     // Catch: Throwable -> L6
        return r3;
    L11:
        return null;
    L6:
        th = move-exception;
        v.m(th, "myssl", "cs3");
        if ((th instanceof UnknownHostException) == true) goto L16;
        if ((th instanceof IOException) == true) goto L14;
        return null;
    L14:
        throw th;
    L16:
        throw th;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String r1, int r2, InetAddress r3, int r4) {
        SSLSocketFactory r0 = this.f7749a;     // Catch: Throwable -> L6
        if (r0 == null) goto L11;
        Socket r5 = r0.createSocket(r1, r2, r3, r4);     // Catch: Throwable -> L6
        a(r5);     // Catch: Throwable -> L6
        d(r5);     // Catch: Throwable -> L6
        return r5;
    L11:
        return null;
    L6:
        th = move-exception;
        v.m(th, "myssl", "cs4");
        if ((th instanceof UnknownHostException) == true) goto L16;
        if ((th instanceof IOException) == true) goto L14;
        return null;
    L14:
        throw th;
    L16:
        throw th;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress r1, int r2) {
        SSLSocketFactory r0 = this.f7749a;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        Socket r3 = r0.createSocket(r1, r2);     // Catch: Throwable -> L6
        a(r3);     // Catch: Throwable -> L6
        d(r3);     // Catch: Throwable -> L6
        return r3;
    L9:
        return null;
    L6:
        th = move-exception;
        v.m(th, "myssl", "cs5");
        if ((th instanceof IOException) == true) goto L12;
        return null;
    L12:
        throw th;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress r1, int r2, InetAddress r3, int r4) {
        SSLSocketFactory r0 = this.f7749a;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        Socket r5 = r0.createSocket(r1, r2, r3, r4);     // Catch: Throwable -> L6
        a(r5);     // Catch: Throwable -> L6
        d(r5);     // Catch: Throwable -> L6
        return r5;
    L9:
        return null;
    L6:
        th = move-exception;
        v.m(th, "myssl", "cs6");
        if ((th instanceof IOException) == true) goto L12;
        return null;
    L12:
        throw th;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final Socket createSocket(Socket r1, String r2, int r3, boolean r4) {
        SSLSocketFactory r0 = this.f7749a;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        Socket r5 = r0.createSocket(r1, r2, r3, r4);     // Catch: Throwable -> L6
        a(r5);     // Catch: Throwable -> L6
        d(r5);     // Catch: Throwable -> L6
        return r5;
    L9:
        return null;
    L6:
        th = move-exception;
        v.m(th, "myssl", "cs2");
        if ((th instanceof IOException) == true) goto L12;
        return null;
    L12:
        throw th;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getDefaultCipherSuites() {
        SSLSocketFactory r2 = this.f7749a;     // Catch: Throwable -> L6
        if (r2 == null) goto L9;
        return r2.getDefaultCipherSuites();
    L9:
        return new String[0];
    L6:
        th = move-exception;
        v.m(th, "myssl", "gdcs");
        goto L9
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getSupportedCipherSuites() {
        SSLSocketFactory r2 = this.f7749a;     // Catch: Throwable -> L6
        if (r2 == null) goto L9;
        return r2.getSupportedCipherSuites();
    L9:
        return new String[0];
    L6:
        th = move-exception;
        v.m(th, "myssl", "gscs");
        goto L9
    }
}
