package p000j.k0.f;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;
import p000j.k0.a;
import p000j.l;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<l> f17826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f17827b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f17828c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f17829d;

    public b(List<l> r2) {
        this.f17827b = 0;
        this.f17826a = r2;
    }

    private boolean c(SSLSocket r3) {
        int r0 = this.f17827b;
    L4:
        if (r0 >= this.f17826a.size()) goto L10;
        if (this.f17826a.get(r0).c(r3) == true) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    public l a(SSLSocket r5) {
        int r0 = this.f17827b;
        int r1 = this.f17826a.size();
    L3:
        if (r0 >= r1) goto L7;
        l r2 = this.f17826a.get(r0);
        r0 = r0 + 1;
        if (r2.c(r5) == false) goto L3;
        this.f17827b = r0;
    L8:
        if (r2 == null) goto L12;
        this.f17828c = c(r5);
        a.f17790a.c(r2, r5, this.f17829d);
        return r2;
    L12:
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.f17829d + ", modes=" + this.f17826a + ", supported protocols=" + Arrays.toString(r5.getEnabledProtocols()));
    L7:
        r2 = null;
        goto L8
    }

    public boolean b(IOException r4) {
        this.f17829d = true;
        if (this.f17828c == true) goto L6;
        return false;
    L6:
        if ((r4 instanceof ProtocolException) == false) goto L9;
        return false;
    L9:
        if ((r4 instanceof InterruptedIOException) == false) goto L11;
        return false;
    L11:
        boolean r3 = r4 instanceof SSLHandshakeException;
        if (r3 == false) goto L17;
        if ((r4.getCause() instanceof CertificateException) == false) goto L17;
        return false;
    L17:
        if ((r4 instanceof SSLPeerUnverifiedException) == false) goto L19;
        return false;
    L19:
        if (r3 == false) goto L21;
        return true;
    L21:
        if ((r4 instanceof SSLProtocolException) == false) goto L23;
        return true;
    L23:
        if ((r4 instanceof SSLException) == false) goto L26;
        return true;
    L26:
        return false;
    }
}
