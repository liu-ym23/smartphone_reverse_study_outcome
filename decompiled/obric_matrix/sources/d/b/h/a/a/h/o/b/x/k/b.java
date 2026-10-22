package d.b.h.a.a.h.o.b.x.k;

import com.bytedance.common.utility.Logger;
import d.b.h.a.a.h.o.b.s;
import d.b.r.y;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {
    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v9 */
    public static String a(String r11, String r12) {
        Logger.debug();
        long r0 = System.currentTimeMillis();
        ?? r2 = new StringBuilder();
        int r3 = 0;
        d.b.r.h0.e r4 = null;
        String r5 = null;
        BufferedReader r6 = null;
        d.b.r.h0.e r7 = null;
        d.b.r.h0.c.a r8 = new d.b.r.h0.c.a();     // Catch: Throwable -> L40 Exception -> L53
        r8.h(r11);     // Catch: Throwable -> L40 Exception -> L53
        d.b.r.h0.c r9 = r8.a();     // Catch: Throwable -> L40 Exception -> L53
        r9.S(new y());     // Catch: Throwable -> L40 Exception -> L53
        d.b.r.h0.e r10 = s.t(d.b.h.a.a.h.o.b.x.e.q().h().getContext()).a(r9);     // Catch: Throwable -> L40 Exception -> L53
    L79:
        d.b.r.h0.d r13 = r10.execute();     // Catch: Throwable -> L35 Exception -> L38
        if (r13 != null) goto L7;
        r2 = 0;
        InputStream r14 = null;
    L25:
        if (r10 == null) goto L27;
        r10.cancel();
    L27:
        if (r6 == null) goto L31;
        r6.close();     // Catch: IOException -> L29
    L31:
        if (r14 == null) goto L60;
        r14.close();     // Catch: IOException -> L29
    L60:
        long r15 = System.currentTimeMillis() - r0;
        ?? r1 = new JSONObject();     // Catch: JSONException -> L68
        r1.put("request_url", r11);     // Catch: JSONException -> L68
        r1.put("httpdns_domain", r12);     // Catch: JSONException -> L68
        if (r2 != 0) goto L65;
        r1.put("result", "");     // Catch: JSONException -> L68
    L66:
        r1.put("response_code", r3);     // Catch: JSONException -> L68
        r1.put("rtt", r15);     // Catch: JSONException -> L68
        Logger.debug();     // Catch: JSONException -> L68
    L70:
        return r2;
    L65:
        r1.put("result", r2);     // Catch: JSONException -> L68
    L68:
        e = move-exception;
        e.printStackTrace();
        goto L70
    L7:
        if (r13.i() == true) goto L9;
    L18:
        r14 = null;
        BufferedReader r16 = null;
    L19:
        r5 = r2.toString();     // Catch: Throwable -> L21 Exception -> L23
        r3 = r13.e();     // Catch: Throwable -> L21 Exception -> L23
        r2 = r5;
        r6 = r16;
        goto L25
    L23:
        String r17 = r5;
    L39:
        r7 = r10;
        r2 = r17;
    L54:
        if (r7 == null) goto L56;
        r7.cancel();
    L56:
        if (r16 == null) goto L58;
        r16.close();     // Catch: IOException -> L29
    L58:
        if (r14 == null) goto L60;
        r14.close();     // Catch: IOException -> L29
    L21:
        th = th;
    L37:
        r4 = r10;
    L42:
        if (r4 == null) goto L44;
        r4.cancel();
    L44:
        if (r16 != null) goto L74;
    L48:
        if (r14 == null) goto L52;
        r14.close();     // Catch: IOException -> L46
    L46:
        e = move-exception;
        e.printStackTrace();
    L52:
        throw th;
    L74:
        r16.close();     // Catch: IOException -> L46
        goto L48
    L9:
        if (r13.a() == null) goto L18;
        r14 = r13.a().d();     // Catch: Throwable -> L35 Exception -> L38
    L81:
        r16 = new BufferedReader(new InputStreamReader(r14, "UTF-8"));     // Catch: Throwable -> L15 Exception -> L17
    L77:
        String r18 = r16.readLine();     // Catch: Throwable -> L21 Exception -> L23
        if (r18 == null) goto L19;
        r2.append(r18);     // Catch: Throwable -> L21 Exception -> L23
        goto L77
    L17:
        r17 = null;
        r16 = null;
    L15:
        th = th;
        r16 = null;
    L38:
        r17 = null;
        r14 = null;
        r16 = null;
    L35:
        th = th;
        r14 = null;
        r16 = null;
    L29:
        e = move-exception;
        e.printStackTrace();
    L53:
        r2 = 0;
        r14 = null;
        r16 = null;
    L40:
        th = th;
        r14 = null;
        r16 = null;
        goto L42
    }
}
