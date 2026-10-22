package com.loc;

import android.util.Base64;
import com.obric.matrix.common_api.INetworkApi;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes2.dex */
public final class e2 {
    public static boolean a(byte[] r7) {
        if (r7 == null) goto L28;
        byte[] r1 = null;
        m3 r2 = new m3();     // Catch: Exception -> L23
        r2.f7555b.put(INetworkApi.CONTENT_TYPE, "application/octet-stream");     // Catch: Exception -> L23
        r2.f7555b.put("aps_c_src", Base64.encodeToString(m3.a().getBytes(), 2));     // Catch: Exception -> L23
        r2.f7555b.put("aps_c_key", Base64.encodeToString(m3.b().getBytes(), 2));     // Catch: Exception -> L23
        r2.f7556c = r7;     // Catch: Exception -> L23
        if (u1.f7862a == false) goto L10;
        String r8 = "http://cgicol.amap.com/collection/collectData?src=baseCol&ver=v74&";
    L8:
        r2.f7554a = r8;     // Catch: Exception -> L23
        n3 r9 = z2.c().a(r2);     // Catch: Exception -> L23
        if (r9 != null) goto L17;
    L19:
        if (r1 == null) goto L29;
        if ("true".equals(new String(r1, StandardCharsets.UTF_8)) == true) goto L31;
        return false;
    L31:
        return true;
    L29:
        return false;
    L17:
        if (r9.f7565a != 200) goto L19;
        r1 = r9.f7567c;     // Catch: Exception -> L23
        goto L19
    L10:
        if (u1.f7863b == false) goto L12;
        String r10 = "https://";
    L13:
        r8 = r10 + "cgicol.amap.com/collection/collectData?src=baseCol&ver=v74&";     // Catch: Exception -> L23
        goto L8
    L12:
        r10 = "http://";
    L23:
        e = move-exception;
        l3.a(e);
        return false;
    L28:
        return false;
    }
}
