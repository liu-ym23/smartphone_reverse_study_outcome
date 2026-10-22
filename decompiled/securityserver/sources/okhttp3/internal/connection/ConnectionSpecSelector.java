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
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ConnectionSpecSelector {
    private final List<ConnectionSpec> connectionSpecs;
    private boolean isFallback;
    private boolean isFallbackPossible;
    private int nextModeIndex;

    public ConnectionSpecSelector(@NotNull List<ConnectionSpec> r2) {
        Intrinsics.f(r2, "connectionSpecs");
        this.connectionSpecs = r2;
    }

    private final boolean isFallbackPossible(SSLSocket r4) {
        int r0 = this.nextModeIndex;
        int r1 = this.connectionSpecs.size();
    L3:
        if (r0 >= r1) goto L9;
        if (this.connectionSpecs.get(r0).isCompatible(r4) == true) goto L6;
        r0 = r0 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    @NotNull
    public final ConnectionSpec configureSecureSocket(@NotNull SSLSocket r5) {
        Intrinsics.f(r5, "sslSocket");
        int r0 = this.nextModeIndex;
        int r1 = this.connectionSpecs.size();
    L3:
        if (r0 >= r1) goto L8;
        ConnectionSpec r2 = this.connectionSpecs.get(r0);
        if (r2.isCompatible(r5) == true) goto L6;
        r0 = r0 + 1;
        goto L3
    L6:
        this.nextModeIndex = r0 + 1;
    L9:
        if (r2 == null) goto L12;
        this.isFallbackPossible = isFallbackPossible(r5);
        r2.apply$okhttp(r5, this.isFallback);
        return r2;
    L12:
        StringBuilder r3 = new StringBuilder("Unable to find acceptable protocols. isFallback=");
        r3.append(this.isFallback);
        r3.append(", modes=");
        r3.append(this.connectionSpecs);
        r3.append(", supported protocols=");
        String[] r4 = r5.getEnabledProtocols();
        Intrinsics.c(r4);
        String r6 = Arrays.toString(r4);
        Intrinsics.e(r6, "java.util.Arrays.toString(this)");
        r3.append(r6);
        throw new UnknownServiceException(r3.toString());
    L8:
        r2 = null;
        goto L9
    }

    public final boolean connectionFailed(@NotNull IOException r3) {
        Intrinsics.f(r3, "e");
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
}
