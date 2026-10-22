package d.g.f.c;

import android.net.Uri;
import android.util.Pair;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    @Deprecated
    public static Pair<String, String> a(String r9, Map<String, String> r10) {
        if (d.g.f.b.a.a(r9) == true) goto L29;
        Uri r11 = Uri.parse(r9);     // Catch: Throwable -> L25
        StringBuilder r0 = new StringBuilder();     // Catch: Throwable -> L25
        String r1 = r11.getScheme();     // Catch: Throwable -> L25
        String r2 = r11.getHost();     // Catch: Throwable -> L25
        int r3 = r11.getPort();     // Catch: Throwable -> L25
        if (r2 == null) goto L11;
        if (r1 == null) goto L8;
        r0.append(r1);     // Catch: Throwable -> L25
        r0.append("://");     // Catch: Throwable -> L25
    L8:
        r0.append(r2);     // Catch: Throwable -> L25
        if (r3 <= 0) goto L11;
        r0.append(':');     // Catch: Throwable -> L25
        r0.append(r3);     // Catch: Throwable -> L25
    L11:
        String r4 = r0.toString();     // Catch: Throwable -> L25
        String r5 = r11.getEncodedPath();     // Catch: Throwable -> L25
        if (r10 == null) goto L23;
        String r12 = r11.getEncodedQuery();     // Catch: Throwable -> L25
        if (r12 == null) goto L23;
        String[] r13 = r12.split("&");     // Catch: Throwable -> L25
        int r6 = r13.length;     // Catch: Throwable -> L25
        int r7 = 0;
    L16:
        if (r7 >= r6) goto L23;
        String r8 = r13[r7];     // Catch: Throwable -> L25
        int r14 = r8.indexOf("=");     // Catch: Throwable -> L25
        if (r14 < 0) goto L21;
        r10.put(URLDecoder.decode(r8.substring(0, r14), "UTF-8"), URLDecoder.decode(r8.substring(r14 + 1), "UTF-8"));     // Catch: Throwable -> L25
    L22:
        r7 = r7 + 1;     // Catch: Throwable -> L25
        goto L16
    L21:
        r10.put(URLDecoder.decode(r8, "UTF-8"), "");     // Catch: Throwable -> L25
    L23:
        return new Pair(r4, r5);
    L25:
        th = move-exception;
        th.printStackTrace();
        throw new IOException("parseUrl url is fail !!!");
    L29:
        throw new IOException("parseUrl url is null !!!");
    }
}
