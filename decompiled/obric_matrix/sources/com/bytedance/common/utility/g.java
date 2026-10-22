package com.bytedance.common.utility;

import android.util.Pair;
import com.obric.matrix.common_api.INetworkApi;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static g f3273a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f3274a;

        public a() {
        }
    }

    static {
        f3273a = new d();
    }

    public g() {
    }

    public static byte[] d(byte[] r3) {
        GZIPOutputStream r0 = null;
        ByteArrayOutputStream r1 = new ByteArrayOutputStream(8192);     // Catch: Throwable -> L9
        GZIPOutputStream r2 = new GZIPOutputStream(r1);     // Catch: Throwable -> L9
        r2.write(r3);     // Catch: Throwable -> L7
        r2.close();     // Catch: Throwable -> L7
        return r1.toByteArray();
    L7:
        th = th;
        r0 = r2;
    L10:
        if (r0 == null) goto L12;
        r0.close();
    L12:
        throw th;
    L9:
        th = th;
        goto L10
    }

    public static g f() {
        return f3273a;
    }

    public static void j(g r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (r1 == f3273a) goto L8;
        f3273a = r1;
        return;
    }

    public abstract String e(String r1, Map<String, String> r2, a r3);

    public abstract String g(String r1, List<Pair<String, String>> r2, Map<String, String> r3, a r4);

    public abstract String h(String r1, byte[] r2, Map<String, String> r3, a r4);

    public String i(String r3, byte[] r4, boolean r5, String r6, boolean r7) {
        HashMap r0 = new HashMap();
        if (r5 == false) goto L10;
        r4 = d(r4);     // Catch: Exception -> L6
        r0.put("Content-Encoding", "gzip");     // Catch: Exception -> L6
    L6:
        e = move-exception;
        throw new com.bytedance.common.utility.a(0, e.getMessage());
    L10:
        if (k.c(r6) == true) goto L12;
        r0.put(INetworkApi.CONTENT_TYPE, r6);
    L12:
        a r8 = new a();
        r8.f3274a = r7;
        return h(r3, r4, r0, r8);
    }
}
