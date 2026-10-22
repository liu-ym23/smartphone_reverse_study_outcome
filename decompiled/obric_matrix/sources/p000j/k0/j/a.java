package p000j.k0.j;

import android.annotation.SuppressLint;
import android.net.ssl.SSLSockets;
import java.io.IOException;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import p000j.b0;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"NewApi"})
class a extends b {
    a(Class<?> r7) {
        super(r7, null, null, null, null);
    }

    private void C(SSLSocket r1) {
        if (SSLSockets.isSupportedSocket(r1) == false) goto L6;
        SSLSockets.setUseSessionTickets(r1, true);
        return;
    }

    public static g z() {
        if (g.q() == true) goto L11;
        return null;
    L11:
        if (b.A() < 29) goto L9;
        return new a(Class.forName("com.android.org.conscrypt.SSLParametersImpl"));
    L9:
        return null;
    }

    @Override // p000j.k0.j.b, p000j.k0.j.g
    @SuppressLint({"NewApi"})
    @IgnoreJRERequirement
    public void h(SSLSocket r1, String r2, List<b0> r3) {
        C(r1);     // Catch: IllegalArgumentException -> L4
        SSLParameters r0 = r1.getSSLParameters();     // Catch: IllegalArgumentException -> L4
        r0.setApplicationProtocols((String[]) g.b(r3).toArray(new String[0]));     // Catch: IllegalArgumentException -> L4
        r1.setSSLParameters(r0);     // Catch: IllegalArgumentException -> L4
        return;
    L4:
        e = move-exception;
        throw new IOException("Android internal error", e);
    }

    @Override // p000j.k0.j.b, p000j.k0.j.g
    @IgnoreJRERequirement
    public String o(SSLSocket r1) {
        String r0 = r1.getApplicationProtocol();
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.isEmpty() == true) goto L10;
        return r0;
    L10:
        return null;
    }
}
