package okhttp3.internal.connection;

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
import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ConnectionSpec;

/* JADX INFO: compiled from: ConnectionSpecSelector.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\rH\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lokhttp3/internal/connection/ConnectionSpecSelector;", "", "connectionSpecs", "", "Lokhttp3/ConnectionSpec;", "(Ljava/util/List;)V", "isFallback", "", "isFallbackPossible", "nextModeIndex", "", "configureSecureSocket", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "connectionFailed", "e", "Ljava/io/IOException;", "socket", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ConnectionSpecSelector {
    private final List<ConnectionSpec> connectionSpecs;
    private boolean isFallback;
    private boolean isFallbackPossible;
    private int nextModeIndex;

    public ConnectionSpecSelector(List<ConnectionSpec> r2) {
        Intrinsics.checkNotNullParameter(r2, "connectionSpecs");
        this.connectionSpecs = r2;
    }

    public final ConnectionSpec configureSecureSocket(SSLSocket r5) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "sslSocket");
        int r0 = this.nextModeIndex;
        int r1 = this.connectionSpecs.size();
    L3:
        if (r0 >= r1) goto L8;
        int r2 = r0 + 1;
        ConnectionSpec r3 = this.connectionSpecs.get(r0);
        if (r3.isCompatible(r5) == true) goto L6;
        r0 = r2;
        goto L3
    L6:
        this.nextModeIndex = r2;
    L9:
        if (r3 == null) goto L12;
        this.isFallbackPossible = isFallbackPossible(r5);
        r3.apply$okhttp(r5, this.isFallback);
        return r3;
    L12:
        StringBuilder r4 = new StringBuilder("Unable to find acceptable protocols. isFallback=").append(this.isFallback).append(", modes=").append(this.connectionSpecs).append(", supported protocols=");
        String[] r6 = r5.getEnabledProtocols();
        Intrinsics.checkNotNull(r6);
        String r7 = Arrays.toString(r6);
        Intrinsics.checkNotNullExpressionValue(r7, "toString(this)");
        throw new UnknownServiceException(r4.append(r7).toString());
    L8:
        r3 = null;
        goto L9
    }

    public final boolean connectionFailed(IOException r3) {
        Intrinsics.checkNotNullParameter(r3, "e");
        this.isFallback = true;
        if (this.isFallbackPossible == true) goto L6;
    L21:
        return false;
    L6:
        if ((r3 instanceof ProtocolException) == true) goto L21;
        if ((r3 instanceof InterruptedIOException) == true) goto L21;
        if ((r3 instanceof SSLHandshakeException) == false) goto L17;
        if ((r3.getCause() instanceof CertificateException) == true) goto L21;
    L17:
        if ((r3 instanceof SSLPeerUnverifiedException) == true) goto L21;
        if ((r3 instanceof SSLException) == false) goto L21;
        return true;
    }

    private final boolean isFallbackPossible(SSLSocket r5) {
        int r0 = this.nextModeIndex;
        int r1 = this.connectionSpecs.size();
    L3:
        if (r0 >= r1) goto L9;
        int r2 = r0 + 1;
        if (this.connectionSpecs.get(r0).isCompatible(r5) == true) goto L6;
        r0 = r2;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }
}
