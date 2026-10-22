package com.bytedance.badger.f;

import java.io.IOException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import l.b.a.k;
import l.b.a.p;
import l.b.a.t;
import l.b.a.u;
import l.b.a.y0;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static u a(k r4) {
        t r5 = r4.C();
        if ((r5 instanceof p) == false) goto L21;
        k r0 = new k(((p) r5).y());
        t r6 = r0.C();     // Catch: Throwable -> L12
        if ((r6 instanceof u) == false) goto L11;
        u r7 = (u) r6;     // Catch: Throwable -> L12
        r0.close();
        return r7;
    L11:
        throw new CertificateParsingException("Expected sequence, found " + r6.getClass().getName());     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        r0.close();     // Catch: Throwable -> L17
    L19:
        throw th;
    L17:
        th = move-exception;
        th.addSuppressed(th);
        goto L19
    L21:
        throw new CertificateParsingException("Expected octet stream, found " + r5.getClass().getName());
    }

    public static byte[] b(X509Certificate r2) {
        byte[] r3 = r2.getExtensionValue("1.3.6.1.4.1.11129.2.1.17");
        if (r3 == null) goto L29;
        if (r3.length == 0) goto L29;
        k r0 = new k(r3);     // Catch: IOException -> L25
        u r4 = a(r0);     // Catch: Throwable -> L17
        r0.close();     // Catch: IOException -> L25
        l.b.a.e r5 = r4.y(4);
        if (r5 == null) goto L16;
        if ((r5 instanceof y0) == false) goto L16;
        return ((p) r5).y();
    L16:
        throw new CertificateParsingException("Expected DEROctetString");
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        r0.close();     // Catch: Throwable -> L22
    L24:
        throw th;     // Catch: IOException -> L25
    L22:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L25
    L25:
        e = move-exception;
        throw new CertificateParsingException("Failed to parse SEQUENCE", e);
    L29:
        throw new CertificateParsingException("Did not find extension with OID 1.3.6.1.4.1.11129.2.1.17");
    }
}
