package com.bytedance.bdinstall.c1;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.bdinstall.d1.o;
import com.bytedance.bdinstall.q;
import com.bytedance.bdinstall.t;
import com.bytedance.bdinstall.v0;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class h extends d {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static volatile Pair<byte[], String> f2703i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static volatile Pair<String, byte[]> f2704j;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f2705b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f2706c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f2707d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f2708e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f2709f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile Map<String, String> f2710g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private AtomicBoolean f2711h;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ h f2712f;

        a(h r1) {
            this.f2712f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            t.f(new b(this.f2712f, null));
        }
    }

    private class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ h f2713f;

        private b(h r1) {
            this.f2713f = r1;
        }

        /* synthetic */ b(h r1, a r2) {
            this(r1);
        }

        @Override // java.lang.Runnable
        public void run() {
            h.n(this.f2713f).set(false);
            String r0 = "";
            if (h.o(this.f2713f) == null) goto L6;
            h r1 = this.f2713f;     // Catch: Throwable -> L8
            r0 = h.p(r1, h.o(r1));     // Catch: Throwable -> L8
        L6:
            h.q(this.f2713f, r0);
        }
    }

    h(Context r2, boolean r3, String r4, String r5, String r6) {
        this.f2711h = new AtomicBoolean(false);
        this.f2705b = Environment.getExternalStorageState();
        this.f2709f = r4;
        this.f2706c = r3;
        this.f2707d = r5;
        this.f2708e = r6;
    }

    static /* synthetic */ AtomicBoolean n(h r0) {
        return r0.f2711h;
    }

    static /* synthetic */ Map o(h r0) {
        return r0.f2710g;
    }

    static /* synthetic */ String p(h r0, Map r1) {
        return r0.w(r1);
    }

    static /* synthetic */ void q(h r0, String r1) {
        r0.y(r1);
    }

    private String r(byte[] r2) {
        if (f2703i == null) goto L10;
        if (Arrays.equals(r2, (byte[]) f2703i.first) == false) goto L10;
        Object r1 = f2703i.second;
    L8:
        return (String) r1;
    L10:
        if (f2704j != null) goto L12;
    L14:
        String r0 = null;
        r0 = o.b(r2, this.f2708e);     // Catch: Throwable -> L19
    L16:
        if (r0 == null) goto L18;
        f2703i = new Pair(r2, r0);
    L18:
        return r0;
    L12:
        if (Arrays.equals(r2, (byte[]) f2704j.second) == false) goto L14;
        r1 = f2704j.first;
        goto L8
    }

    private byte[] s(String r2) {
        if (f2704j == null) goto L10;
        if (v0.d(r2, (String) f2704j.first) == false) goto L10;
        Object r1 = f2704j.second;
    L8:
        return (byte[]) r1;
    L10:
        if (f2703i != null) goto L12;
    L14:
        byte[] r0 = null;
        r0 = o.c(r2, this.f2708e);     // Catch: Throwable -> L19
    L16:
        if (r0 == null) goto L18;
        f2704j = new Pair(r2, r0);
    L18:
        return r0;
    L12:
        if (v0.d(r2, (String) f2703i.second) == false) goto L14;
        r1 = f2703i.first;
        goto L8
    }

    private String t() {
        return this.f2709f + "/" + this.f2707d;
    }

    private String u(String r9) {
        if (TextUtils.isEmpty(r9) == true) goto L11;
        if (this.f2710g == null) goto L11;
        String r0 = this.f2710g.get(r9);
        if (q.b() == false) goto L9;
        q.g("get key = " + r9 + " value = " + r0 + " way = memory dir = " + t());
    L9:
        return r0;
    L11:
        if ("mounted".equals(this.f2705b) == true) goto L103;
        return null;
    L103:
    L56:
        th = th;
        RandomAccessFile r4 = null;
        FileLock r5 = null;
    L87:
        boolean r10 = th instanceof IOException;     // Catch: Throwable -> L67
        if (this.f2710g != null) goto L62;
        this.f2710g = new ConcurrentHashMap();
    L62:
        if (r5 != null) goto L93;
    L64:
        if (r4 != null) goto L85;
    L66:
        return null;
    L85:
        r4.close();     // Catch: Exception -> L81
        goto L66
    L93:
        r5.release();     // Catch: Exception -> L82
    L67:
        th = move-exception;
        if (this.f2710g != null) goto L71;
        this.f2710g = new ConcurrentHashMap();
    L71:
        if (r5 != null) goto L109;
    L73:
        if (r4 == null) goto L111;
        r4.close();     // Catch: Exception -> L84
        throw th;
    L112:
        throw th;
    L111:
        throw th;
    L109:
        r5.release();     // Catch: Exception -> L83
        goto L73
    L14:
        if (new File(this.f2709f).exists() == false) goto L16;
        File r1 = new File(t());     // Catch: Throwable -> L56
        r4 = new RandomAccessFile(r1, "rwd");     // Catch: Throwable -> L56
        r5 = r4.getChannel().lock();     // Catch: Throwable -> L54
    L52:
        th = th;
        goto L87
    L22:
        if (r1.isFile() == false) goto L46;
        byte[] r6 = new byte[2049];     // Catch: Throwable -> L52
        int r7 = r4.read(r6, 0, 2049);     // Catch: Throwable -> L52
        if (r7 <= 0) goto L46;
        if (r7 >= 2049) goto L46;
        this.f2710g = v(r(Arrays.copyOf(r6, r7)));     // Catch: Throwable -> L52
        if (TextUtils.isEmpty(r9) == true) goto L29;
        String r2 = this.f2710g.get(r9);     // Catch: Throwable -> L52
        if (q.b() == false) goto L39;
        q.g("get key = " + r9 + " value = " + r2 + " way = file dir = " + t());     // Catch: Throwable -> L52
    L39:
        if (this.f2710g != null) goto L41;
        this.f2710g = new ConcurrentHashMap();
    L41:
        if (r5 != null) goto L97;
    L91:
        r4.close();     // Catch: Exception -> L79
    L44:
        return r2;
    L97:
        r5.release();     // Catch: Exception -> L78
        goto L91
    L29:
        if (this.f2710g != null) goto L31;
        this.f2710g = new ConcurrentHashMap();
    L31:
        if (r5 != null) goto L107;
    L101:
        r4.close();     // Catch: Exception -> L77
    L34:
        return null;
    L107:
        r5.release();     // Catch: Exception -> L76
    L46:
        if (this.f2710g != null) goto L48;
        this.f2710g = new ConcurrentHashMap();
    L48:
        if (r5 == null) goto L85;
        r5.release();     // Catch: Exception -> L80
    L54:
        th = th;
        r5 = null;
        goto L87
    L16:
        if (this.f2710g != null) goto L18;
        this.f2710g = new ConcurrentHashMap();
    L18:
        return null;
    }

    private Map<String, String> v(String r4) {
        if (TextUtils.isEmpty(r4) == true) goto L5;
        JSONObject r3 = new JSONObject(r4);
        Iterator<String> r5 = r3.keys();
        ConcurrentHashMap r0 = new ConcurrentHashMap();
    L8:
        if (r5.hasNext() == false) goto L10;
        String r1 = r5.next();
        r0.put(r1, (String) r3.get(r1));
        goto L8
    L10:
        return r0;
    L5:
        return new ConcurrentHashMap();
    }

    private String w(Map<String, String> r3) {
        if (r3 != null) goto L5;
        return "";
    L5:
        JSONObject r2 = new JSONObject();
        Iterator<Map.Entry<String, String>> r4 = r3.entrySet().iterator();
    L7:
        if (r4.hasNext() == false) goto L10;
        Map.Entry<String, String> r0 = r4.next();
        r2.put(r0.getKey(), r0.getValue());
        goto L7
    L10:
        return r2.toString();
    }

    private void x(String r3, String r4) {
        if (this.f2710g != null) goto L8;
        u(null);
        if (this.f2710g != null) goto L8;
        this.f2710g = new ConcurrentHashMap();
    L8:
        if (v0.d(this.f2710g.get(r3), r4) == false) goto L11;
        return;
    L11:
        if (TextUtils.isEmpty(r4) == false) goto L16;
        if (this.f2710g.containsKey(r3) == false) goto L16;
        this.f2710g.remove(r3);
    L19:
        if (this.f2706c == true) goto L21;
        return;
    L21:
        if (this.f2711h.compareAndSet(false, true) == false) goto L25;
        t.a().postDelayed(new a(this), 1000);
        return;
    L25:
        return;
    L16:
        if (TextUtils.isEmpty(r4) == true) goto L19;
        this.f2710g.put(r3, r4);
        goto L19
    }

    private void y(String r6) {
        if ("mounted".equals(this.f2705b) == true) goto L5;
        return;
    L5:
        FileLock r0 = null;
        File r1 = new File(this.f2709f);     // Catch: Throwable -> L19
        if (r1.exists() == false) goto L9;
    L11:
        RandomAccessFile r2 = new RandomAccessFile(new File(t()), "rwd");     // Catch: Throwable -> L19
        r0 = r2.getChannel().lock();     // Catch: Throwable -> L17
        byte[] r5 = s(r6);     // Catch: Throwable -> L17
        r2.setLength(0);     // Catch: Throwable -> L17
        r2.write(r5);     // Catch: Throwable -> L17
        if (r0 != null) goto L40;
    L38:
        r2.close();     // Catch: Exception -> L34
        return;
    L55:
        return;
    L40:
        r0.release();     // Catch: Exception -> L33
    L17:
        th = th;
    L46:
        boolean r7 = th instanceof IOException;     // Catch: Throwable -> L27
        if (r0 != null) goto L42;
    L24:
        if (r2 != null) goto L38;
        return;
    L42:
        r0.release();     // Catch: Exception -> L35
    L27:
        th = move-exception;
        if (r0 != null) goto L50;
    L30:
        if (r2 == null) goto L56;
        r2.close();     // Catch: Exception -> L37
        throw th;
    L57:
        throw th;
    L56:
        throw th;
    L50:
        r0.release();     // Catch: Exception -> L36
        goto L30
    L9:
        if (r1.mkdirs() == true) goto L11;
        return;
    L19:
        th = th;
        r2 = null;
        goto L46
    }

    @Override // com.bytedance.bdinstall.c1.d, com.bytedance.bdinstall.c1.i
    public void a(String r1, String r2) {
        x(r1, r2);
    }

    @Override // com.bytedance.bdinstall.c1.d, com.bytedance.bdinstall.c1.i
    public String b(String r1) {
        return u(r1);
    }

    @Override // com.bytedance.bdinstall.c1.d
    protected void d(String r2, String[] r3) {
        if (r2 == null) goto L7;
        if (r3 == null) goto L8;
        a(r2, TextUtils.join("\n", r3));
        return;
    L8:
        return;
    }

    @Override // com.bytedance.bdinstall.c1.d
    protected String[] e(String r1) {
        String r0 = u(r1);
        if (TextUtils.isEmpty(r0) == false) goto L7;
        return null;
    L7:
        return r0.split("\n");
    }
}
