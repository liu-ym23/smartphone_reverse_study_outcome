package d.b.b.e.a.k;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.lifecycle.CoroutineLiveDataKt;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SharedPreferences f12640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f12641b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private File f12642c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ConcurrentHashMap<String, c> f12643d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f12644e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile boolean f12645f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ArrayList<String> f12646g;

    /* JADX INFO: renamed from: d.b.b.e.a.k.a$a, reason: collision with other inner class name */
    class C0329a implements Comparator<String> {
        C0329a(a r1) {
        }

        public int a(String r1, String r2) {
            return String.CASE_INSENSITIVE_ORDER.compare(r1, r2);
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(String r1, String r2) {
            return a(r1, r2);
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static a f12647a;

        static {
            f12647a = new a(null);
        }

        static /* synthetic */ a a() {
            return f12647a;
        }
    }

    static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f12648a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f12649b;

        public c(int r1, long r2) {
            this.f12648a = r1;
            this.f12649b = r2;
        }

        static /* synthetic */ int a(c r0) {
            return r0.f12648a;
        }

        static /* synthetic */ long b(c r2) {
            return r2.f12649b;
        }

        public static c e(String r4) {
            String[] r5 = r4.split("_");     // Catch: Exception -> L4
            return new c(Integer.parseInt(r5[0]), Long.parseLong(r5[1]));
        L4:
            return null;
        }

        public int c() {
            return this.f12648a;
        }

        public String d() {
            return this.f12648a + "_" + this.f12649b;
        }

        void f(int r1, long r2) {
            this.f12648a = r1;
            this.f12649b = r2;
        }
    }

    private a() {
        this.f12643d = new ConcurrentHashMap();
        this.f12644e = 0;
        this.f12645f = false;
        this.f12646g = new ArrayList();
    }

    /* synthetic */ a(C0329a r1) {
        this();
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.ALL, value = "android.content.Context")
    public static SharedPreferences a(Application r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    private void b(String r5) {
        if (this.f12646g.size() <= CoroutineLiveDataKt.DEFAULT_TIMEOUT) goto L6;
        this.f12644e++;
        return;
    L6:
        this.f12646g.add(r5);
    }

    private synchronized void d() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.f12641b == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        File r0 = new File(d.b.b.e.a.b.f(), "log");     // Catch: Throwable -> L13
        if (r0.exists() == true) goto L10;
        r0.mkdirs();     // Catch: Throwable -> L13
    L10:
        this.f12642c = r0;     // Catch: Throwable -> L13
        this.f12640a = a(d.b.b.o.a.b(), "log_report_message", 0);     // Catch: Throwable -> L13
        this.f12641b = true;     // Catch: Throwable -> L13
        monitor-exit(this);
    }

    static long e(File r4) {
        String[] r5 = r4.getName().split("_");     // Catch: Throwable -> L8
        if (r5.length == 2) goto L6;
        return -1;
    L6:
        return Long.parseLong(r5[0]);
    L11:
        return -1;
    }

    static a g() {
        return b.a();
    }

    private synchronized void j() {
        monitor-enter(this);
        int r1 = 0;
        if (this.f12645f == true) goto L13;
        String[] r0 = g().f().list();     // Catch: Throwable -> L25
        int r2 = r0.length;     // Catch: Throwable -> L25
    L6:
        if (r1 >= r2) goto L11;
        String r3 = r0[r1];     // Catch: Throwable -> L25
        if (this.f12646g.contains(r3) == true) goto L10;
        b(r3);     // Catch: Throwable -> L25
    L10:
        r1 = r1 + 1;     // Catch: Throwable -> L25
        goto L6
    L11:
        this.f12645f = true;     // Catch: Throwable -> L25
    L23:
        monitor-exit(this);
        return;
    L13:
        if (this.f12644e <= 0) goto L23;
        if (this.f12646g.size() != 0) goto L23;
        String[] r4 = g().f().list();     // Catch: Throwable -> L25
        int r5 = r4.length;     // Catch: Throwable -> L25
    L17:
        if (r1 >= r5) goto L22;
        String r6 = r4[r1];     // Catch: Throwable -> L25
        if (this.f12646g.contains(r6) == true) goto L21;
        b(r6);     // Catch: Throwable -> L25
    L21:
        r1 = r1 + 1;     // Catch: Throwable -> L25
        goto L17
    L22:
        this.f12644e -= (long) this.f12646g.size();     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    }

    @SuppressLint({"ApplySharedPref"})
    synchronized void c(File r3) {
        monitor-enter(this);
        if (r3 != null) goto L12;
        monitor-exit(this);
        return;
    L12:
        this.f12646g.remove(r3.getName());     // Catch: Throwable -> L9
        d();     // Catch: Throwable -> L9
        d.b.b.o.c.a(r3);     // Catch: Throwable -> L9
        this.f12643d.remove(r3.getName());     // Catch: Throwable -> L9
        SharedPreferences.Editor r0 = this.f12640a.edit();     // Catch: Throwable -> L9
        r0.remove(r3.getName());     // Catch: Throwable -> L9
        r0.commit();     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    File f() {
        d();
        return this.f12642c;
    }

    c h(File r4) {
        c r0 = null;
        if (r4 != null) goto L5;
        return null;
    L5:
        d();
        String r5 = r4.getName();
        if (this.f12643d.containsKey(r5) == false) goto L10;
        return this.f12643d.get(r5);
    L10:
        if (this.f12640a.contains(r5) == false) goto L16;
        String r1 = this.f12640a.getString(r5, "");
        if (TextUtils.isEmpty(r1) == true) goto L14;
        r0 = c.e(r1);
    L14:
        if (r0 == null) goto L16;
        this.f12643d.put(r5, r0);
    L16:
        return r0;
    }

    synchronized File i(String r9) {
        monitor-enter(this);
        String r10 = "." + r9;     // Catch: Throwable -> L43
        j();     // Catch: Throwable -> L43
        if (d.b.b.o.a.c() == false) goto L7;
        d.b.b.o.m.b.a(d.b.b.e.a.a.f12571a, "failedFiles:" + this.f12646g + " " + r10);     // Catch: Throwable -> L43
    L7:
        File r1 = null;
        if (this.f12646g.size() != 0) goto L11;
        monitor-exit(this);
        return null;
    L11:
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L43
        Iterator<String> r2 = this.f12646g.iterator();     // Catch: Throwable -> L43
    L13:
        if (r2.hasNext() == false) goto L18;
        String r3 = r2.next();     // Catch: Throwable -> L43
        if (r3.endsWith(r10) == false) goto L13;
        r0.add(r3);     // Catch: Throwable -> L43
        goto L13
    L18:
        if (d.b.b.o.f.b(r0) == false) goto L21;
        monitor-exit(this);
        return null;
    L21:
        Collections.sort(r0, new C0329a(this));     // Catch: Throwable -> L43
        Iterator r11 = r0.iterator();     // Catch: Throwable -> L43
        c r4 = null;
    L22:
        if (r11.hasNext() == false) goto L41;
        File r5 = new File(g().f(), (String) r11.next());     // Catch: Throwable -> L43
        c r6 = h(r5);     // Catch: Throwable -> L43
        if (r6 == null) goto L40;
        if (d.b.b.o.a.c() == false) goto L31;
        d.b.b.o.m.b.a(d.b.b.e.a.a.f12571a, "list send file:" + r5.getName() + " " + c.a(r6) + " " + c.b(r6) + " " + System.currentTimeMillis());     // Catch: Throwable -> L43
    L31:
        if (c.a(r6) == 0) goto L40;
        if (c.b(r6) < System.currentTimeMillis()) goto L40;
        if (r4 == null) goto L39;
        if (c.b(r4) <= c.b(r6)) goto L22;
    L39:
        r4 = r6;
        r1 = r5;
    L40:
        r1 = r5;
    L41:
        monitor-exit(this);
        return r1;
    L43:
        th = move-exception;
        throw th;
    }

    File[] k() {
        d();
        File r0 = this.f12642c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.listFiles();
    }

    synchronized boolean l(byte[] r7, String r8, int r9, long r10) {
        monitor-enter(this);
        d();     // Catch: Throwable -> L27
        if (this.f12642c != null) goto L8;
        monitor-exit(this);
        return false;
    L8:
        String r11 = String.format("%d%s%s%s%s", new Object[]{Long.valueOf(System.currentTimeMillis()), "_", UUID.randomUUID().toString(), ".", r8});     // Catch: Throwable -> L27
        File r0 = new File(this.f12642c, r11);     // Catch: Throwable -> L27
        FileChannel r2 = null;
        m(r0, r9, r10);     // Catch: Throwable -> L19
        r2 = new FileOutputStream(r0).getChannel();     // Catch: Throwable -> L19
        r2.write(ByteBuffer.wrap(r7));     // Catch: Throwable -> L19
        if (this.f12646g.contains(r11) == true) goto L14;
        b(r11);     // Catch: Throwable -> L19
    L14:
        if (d.b.b.o.a.c() == false) goto L16;
        d.b.b.o.m.b.a(d.b.b.e.a.a.f12571a, "saveFile:" + r0.getName());     // Catch: Throwable -> L19
    L16:
        d.b.b.o.d.a(r2);     // Catch: Throwable -> L27
        monitor-exit(this);
        return true;
    L19:
        th = move-exception;
        d.b.b.o.m.b.c(d.b.b.e.a.a.f12571a, "saveFile", th);     // Catch: Throwable -> L24
        d.b.b.o.d.a(r2);     // Catch: Throwable -> L27
        return false;
    L24:
        th = move-exception;
        d.b.b.o.d.a(r2);     // Catch: Throwable -> L27
        throw th;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;
    }

    @SuppressLint({"ApplySharedPref"})
    void m(File r3, int r4, long r5) {
        if (r3 != null) goto L13;
        return;
    L13:
        d();     // Catch: Throwable -> L10
        SharedPreferences.Editor r0 = this.f12640a.edit();     // Catch: Throwable -> L10
        String r6 = r3.getName();     // Catch: Throwable -> L10
        if (this.f12643d.containsKey(r6) == false) goto L7;
        c r2 = this.f12643d.get(r6);     // Catch: Throwable -> L10
    L8:
        r2.f(r4, r5);     // Catch: Throwable -> L10
        r0.putString(r6, r2.d());     // Catch: Throwable -> L10
        r0.commit();     // Catch: Throwable -> L10
        return;
    L7:
        c r1 = new c(r4, r5);     // Catch: Throwable -> L10
        this.f12643d.put(r6, r1);     // Catch: Throwable -> L10
        r2 = r1;
    L10:
        th = move-exception;
        d.b.b.o.m.b.c(d.b.b.e.a.a.f12571a, "updateRetryMessage", th);
    }
}
