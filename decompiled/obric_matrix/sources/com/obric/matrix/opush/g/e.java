package com.obric.matrix.opush.g;

import java.io.ByteArrayInputStream;
import java.util.zip.GZIPInputStream;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¨\u0006\u0006"}, d2 = {"Lcom/obric/matrix/opush/utils/GzipUtils;", "", "()V", "decompressGzip", "", "compressed", "o_push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f9429a = null;

    static {
        f9429a = new e();
    }

    private e() {
    }

    public final byte[] a(byte[] r3) {
        if (r3 != null) goto L5;
    L21:
        if (r3 == null) goto L23;
        return r3;
    L23:
        return new byte[0];
    L5:
        if (r3.length != 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L21;
        GZIPInputStream r2 = new GZIPInputStream(new ByteArrayInputStream(r3));     // Catch: Exception -> L24
        byte[] r1 = kotlin.m0.a.c(r2);     // Catch: Throwable -> L15
        kotlin.m0.b.a(r2, null);     // Catch: Exception -> L24
        return r1;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        kotlin.m0.b.a(r2, th);     // Catch: Exception -> L24
        throw th;     // Catch: Exception -> L24
    L30:
        return r3;
    L7:
        r0 = false;
        goto L8
    }
}
