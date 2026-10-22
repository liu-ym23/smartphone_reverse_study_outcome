package d.b.b.i.d;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.common.utility.i;
import com.bytedance.common.wschannel.WsConstants;
import d.b.b.o.d;
import d.b.b.o.e;
import d.b.b.o.k;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static AtomicInteger f12965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f12966b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f12967c;

    static class a extends d.b.b.o.o.a {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f12968i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ String f12969j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ Throwable f12970k;

        a(String r1, String r2, Throwable r3) {
            this.f12968i = r1;
            this.f12969j = r2;
            this.f12970k = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.a(this.f12968i, this.f12969j, this.f12970k);
        }
    }

    static {
        f12965a = new AtomicInteger(0);
        f12966b = true;
    }

    static /* synthetic */ void a(String r0, String r1, Throwable r2) {
        e(r0, r1, r2);
    }

    private static byte[] b(byte[] r3) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream(8192);
        GZIPOutputStream r1 = null;
        GZIPOutputStream r2 = new GZIPOutputStream(r0);     // Catch: Throwable -> L9
        r2.write(r3);     // Catch: Throwable -> L7
        d.a(r2);
        return r0.toByteArray();
    L7:
        th = th;
        r1 = r2;
    L10:
        d.a(r1);
        throw th;
    L9:
        th = th;
        goto L10
    }

    private static d.b.b.n.f.a c(String r4, byte[] r5) {
        HashMap r0 = new HashMap();
        if (r5.length <= 128) goto L7;
        byte[] r1 = b(r5);     // Catch: IOException -> L8
        r0.put("Content-Encoding", "gzip");     // Catch: IOException -> L8
        r5 = r1;
    L7:
        return new d.b.b.n.f.a(k.a(r4, d.b.b.i.c.a.w()), r0, r5);
    }

    private static String d(Throwable r2) {
        StringWriter r0 = new StringWriter();
        PrintWriter r1 = new PrintWriter(r0);
        r2.printStackTrace(r1);
        Throwable r3 = r2.getCause();
        if (r3 == null) goto L7;
        r3.printStackTrace(r1);
        Throwable r4 = r3.getCause();
        if (r4 == null) goto L7;
        r4.printStackTrace(r1);
    L7:
        String r5 = r0.toString();
        r1.close();
        return r5;
    }

    private static void e(String r5, String r6, Throwable r7) {
        d.b.b.i.d.a r1 = new d.b.b.i.d.a("tag=" + r5 + " message=" + r6, r7);
        JSONObject r8 = new JSONObject();     // Catch: Throwable -> L11
        r8.put("event_type", "exception");     // Catch: Throwable -> L11
        r8.put("timestamp", System.currentTimeMillis());     // Catch: Throwable -> L11
        r8.put("stack", d(r1));     // Catch: Throwable -> L11
        r8.put("exception_type", 1);     // Catch: Throwable -> L11
        r8.put("message", r5 + "_" + r6);     // Catch: Throwable -> L11
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L11
        r2.put("apm_sdk", "apm6_error");     // Catch: Throwable -> L11
        r2.put("host_aid", String.valueOf(d.b.b.i.c.a.h()));     // Catch: Throwable -> L11
        r8.put("filters", r2);     // Catch: Throwable -> L11
        JSONObject r3 = new JSONObject();     // Catch: Throwable -> L11
        JSONArray r4 = new JSONArray();     // Catch: Throwable -> L11
        r4.put(r8);     // Catch: Throwable -> L11
        r3.put("data", r4);     // Catch: Throwable -> L11
        JSONObject r9 = new JSONObject();     // Catch: Throwable -> L11
        e.a(r9, d.b.b.i.c.a.t());     // Catch: Throwable -> L11
        d.b.b.i.c.b r10 = d.b.b.i.c.a.i();     // Catch: Throwable -> L11
        if (r10 == null) goto L6;
        e.a(r9, r10.e());     // Catch: Throwable -> L11
    L6:
        r9.put("os", LocationInfoConst.SYSTEM);     // Catch: Throwable -> L11
        r9.put(WsConstants.KEY_APP_ID, 2085);     // Catch: Throwable -> L11
        r9.put(WsConstants.KEY_DEVICE_ID, d.b.b.i.c.a.n());     // Catch: Throwable -> L11
        r9.put("channel", d.b.b.i.c.a.k());     // Catch: Throwable -> L11
        r9.put("version_code", d.b.b.i.c.a.y());     // Catch: Throwable -> L11
        r9.put("update_version_code", d.b.b.i.c.a.v());     // Catch: Throwable -> L11
        r9.put(WsConstants.KEY_DEVICE_ID, d.b.b.i.c.a.n());     // Catch: Throwable -> L11
        r9.put("uid", d.b.b.i.c.a.x());     // Catch: Throwable -> L11
        r9.put("process_name", d.b.b.i.c.a.m());     // Catch: Throwable -> L11
        r3.put("header", r9);     // Catch: Throwable -> L11
        if (d.b.b.o.a.c() == false) goto L9;
        Log.e("APM-CustomException", "tag:" + r5 + " message:" + r6, r1);     // Catch: Throwable -> L11
    L9:
        g(f12967c, r3.toString().getBytes());     // Catch: Throwable -> L11
        return;
    }

    static void f(String r2, String r3, Throwable r4) {
        com.bytedance.apm.x.a.a(r2, r3);
        if (f12966b == true) goto L5;
        return;
    L5:
        if (f12965a.get() >= 3) goto L10;
        f12965a.incrementAndGet();
        d.b.b.o.o.b.a(d.b.b.o.o.c.f13066f).c(new a(r2, r3, r4));
        return;
    }

    private static void g(String r2, byte[] r3) {
        if (i.o(d.b.b.o.a.b()) == false) goto L5;
        if (r3 != null) goto L10;
        return;
    L10:
        if (r3.length == 0) goto L27;
        d.b.b.n.f.a r4 = c(r2, r3);     // Catch: Throwable -> L17
        if (d.b.b.o.a.c() == false) goto L15;
        d.b.b.o.m.b.a("APM-CustomException", "http request:url:" + r4.f13039a + " headers:" + r4.f13040b);     // Catch: Throwable -> L17
    L15:
        d.b.b.i.c.a.g(r4.f13039a, r4.f13040b, r4.f13041c);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        if (d.b.b.o.a.c() == false) goto L26;
        th.printStackTrace();
        return;
    L26:
        return;
    L27:
        return;
    L5:
        if (d.b.b.o.a.c() == false) goto L24;
        d.b.b.o.m.b.a("APM-CustomException", "network unreachable");
        return;
    }

    public static void h(boolean r0) {
        f12966b = r0;
    }

    public static void i(String r1) {
        if (TextUtils.isEmpty(r1) == true) goto L6;
        f12967c = r1;
        return;
    }
}
