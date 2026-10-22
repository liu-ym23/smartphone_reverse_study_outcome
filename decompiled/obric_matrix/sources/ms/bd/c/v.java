package ms.bd.c;

import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes2.dex */
class v extends SSLSocketFactory {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f22522b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final SSLSocketFactory f22523a;

    static {
        f22522b = new String[]{(String) m.a(16777217, 0, 0, "8759bb", new byte[]{29, 25, 117, 91, 12, 59, 105})};
    }

    public v(SSLSocketFactory r1) {
        this.f22523a = r1;
    }

    private Socket a(Socket r2) {
        if ((r2 instanceof SSLSocket) == false) goto L5;
        ((SSLSocket) r2).setEnabledProtocols(f22522b);
    L5:
        return r2;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String r2, int r3) {
        Socket r4 = this.f22523a.createSocket(r2, r3);
        a(r4);
        return r4;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String r2, int r3, InetAddress r4, int r5) {
        Socket r6 = this.f22523a.createSocket(r2, r3, r4, r5);
        a(r6);
        return r6;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress r2, int r3) {
        Socket r4 = this.f22523a.createSocket(r2, r3);
        a(r4);
        return r4;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress r2, int r3, InetAddress r4, int r5) {
        Socket r6 = this.f22523a.createSocket(r2, r3, r4, r5);
        a(r6);
        return r6;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket r2, String r3, int r4, boolean r5) {
        Socket r6 = this.f22523a.createSocket(r2, r3, r4, r5);
        a(r6);
        return r6;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.f22523a.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return this.f22523a.getSupportedCipherSuites();
    }
}
