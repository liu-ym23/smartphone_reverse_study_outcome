package com.loc;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class q5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile d f7648a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile f f7649b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile String f7650c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile String f7651d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile long f7652e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile c f7653f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile long f7654g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile String f7655h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static volatile String f7656i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static volatile long f7657j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static volatile long f7658k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static volatile boolean f7659l;
    private static volatile boolean m;

    final class a extends s1 {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Context f7660g;

        a(Context r1) {
            this.f7660g = r1;
        }

        @Override // com.loc.s1
        public final void b() {
            Iterator r0 = q5.d(q5.c(this.f7660g)).iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            File r1 = (File) r0.next();
            q5.g(this.f7660g, r1.getName());
            goto L4
        L6:
            q5.n(this.f7660g);
        }
    }

    final class b extends s1 {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f7661g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ Context f7662h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ long f7663i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ JSONObject f7664j;

        b(boolean r1, Context r2, long r3, JSONObject r5) {
            this.f7661g = r1;
            this.f7662h = r2;
            this.f7663i = r3;
            this.f7664j = r5;
        }

        @Override // com.loc.s1
        public final void b() {
            if (this.f7661g == false) goto L8;
            Iterator r0 = q5.d(q5.c(this.f7662h)).iterator();
        L6:
            if (r0.hasNext() == false) goto L8;
            File r1 = (File) r0.next();
            q5.g(this.f7662h, r1.getName());
        L8:
            q5.q(this.f7662h);
            q5.h(this.f7662h, this.f7664j, this.f7663i);
            boolean r2 = q5.k(this.f7662h, this.f7664j);
            if (r2 != true) goto L12;
            q5.o(this.f7662h, q5.b(this.f7663i));
        L12:
            if (this.f7661g == false) goto L14;
            q5.n(this.f7662h);
        L14:
            if (r2 == true) goto L18;
            q5.g(this.f7662h, q5.b(this.f7663i));
            return;
        }
    }

    public static final enum c extends Enum<c> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final c f7665g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final c f7666h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final c f7667i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final /* synthetic */ c[] f7668j = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f7669f;

        static {
            c r0 = new c("Unknow", 0, -1);
            f7665g = r0;
            c r1 = new c("NotAgree", 1, 0);
            f7666h = r1;
            c r3 = new c("DidAgree", 2, 1);
            f7667i = r3;
            f7668j = new c[]{r0, r1, r3};
        }

        private c(String r1, int r2, int r3) {
            super(r1, r2);
            this.f7669f = r3;
        }

        public static c b(int r2) {
            c r0 = f7666h;
            if (r2 != r0.a()) goto L5;
            return r0;
        L5:
            c r1 = f7667i;
            if (r2 != r1.a()) goto L9;
            return r1;
        L9:
            return f7665g;
        }

        public static c valueOf(String r1) {
            return (c) Enum.valueOf(c.class, r1);
        }

        public static c[] values() {
            return (c[]) f7668j.clone();
        }

        public final int a() {
            return this.f7669f;
        }
    }

    public static final enum d extends Enum<d> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final d f7670g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final d f7671h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final d f7672i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final /* synthetic */ d[] f7673j = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f7674f;

        static {
            d r0 = new d("Unknow", 0, -1);
            f7670g = r0;
            d r1 = new d("NotContain", 1, 0);
            f7671h = r1;
            d r3 = new d("DidContain", 2, 1);
            f7672i = r3;
            f7673j = new d[]{r0, r1, r3};
        }

        private d(String r1, int r2, int r3) {
            super(r1, r2);
            this.f7674f = r3;
        }

        public static d b(int r2) {
            d r0 = f7671h;
            if (r2 != r0.a()) goto L5;
            return r0;
        L5:
            d r1 = f7672i;
            if (r2 != r1.a()) goto L9;
            return r1;
        L9:
            return f7670g;
        }

        public static d valueOf(String r1) {
            return (d) Enum.valueOf(d.class, r1);
        }

        public static d[] values() {
            return (d[]) f7673j.clone();
        }

        public final int a() {
            return this.f7674f;
        }
    }

    public static final enum e extends Enum<e> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final e f7675g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final e f7676h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final e f7677i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final e f7678j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final e f7679k = null;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final e f7680l = null;
        public static final e m = null;
        public static final e n = null;
        public static final e o = null;
        private static final /* synthetic */ e[] p = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f7681f;

        static {
            e r0 = new e("SuccessCode", 0, 0);
            f7675g = r0;
            e r1 = new e("ShowUnknowCode", 1, 555570);
            f7676h = r1;
            e r3 = new e("ShowNoShowCode", 2, 555571);
            f7677i = r3;
            e r5 = new e("InfoUnknowCode", 3, 555572);
            f7678j = r5;
            e r7 = new e("InfoNotContainCode", 4, 555573);
            f7679k = r7;
            e r9 = new e("AgreeUnknowCode", 5, 555574);
            f7680l = r9;
            e r11 = new e("AgreeNotAgreeCode", 6, 555575);
            m = r11;
            e r13 = new e("InvaildUserKeyCode", 7, 10001);
            n = r13;
            e r12 = new e("IllegalArgument", 8, 20001);
            o = r12;
            p = new e[]{r0, r1, r3, r5, r7, r9, r11, r13, r12};
        }

        private e(String r1, int r2, int r3) {
            super(r1, r2);
            this.f7681f = r3;
        }

        public static e valueOf(String r1) {
            return (e) Enum.valueOf(e.class, r1);
        }

        public static e[] values() {
            return (e[]) p.clone();
        }

        public final int a() {
            return this.f7681f;
        }
    }

    public static final enum f extends Enum<f> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final f f7682g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final f f7683h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final f f7684i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final /* synthetic */ f[] f7685j = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f7686f;

        static {
            f r0 = new f("Unknow", 0, -1);
            f7682g = r0;
            f r1 = new f("NotShow", 1, 0);
            f7683h = r1;
            f r3 = new f("DidShow", 2, 1);
            f7684i = r3;
            f7685j = new f[]{r0, r1, r3};
        }

        private f(String r1, int r2, int r3) {
            super(r1, r2);
            this.f7686f = r3;
        }

        public static f b(int r2) {
            f r0 = f7683h;
            if (r2 != r0.a()) goto L5;
            return r0;
        L5:
            f r1 = f7684i;
            if (r2 != r1.a()) goto L9;
            return r1;
        L9:
            return f7682g;
        }

        public static f valueOf(String r1) {
            return (f) Enum.valueOf(f.class, r1);
        }

        public static f[] values() {
            return (f[]) f7685j.clone();
        }

        public final int a() {
            return this.f7686f;
        }
    }

    static {
        f7648a = d.f7670g;
        f7649b = f.f7682g;
        f7650c = "";
        f7651d = "";
        f7652e = -1;
        f7653f = c.f7665g;
        f7654g = -1;
        f7655h = "";
        f7656i = "";
        f7657j = 0;
        f7658k = 0;
        f7659l = false;
        m = true;
    }

    public static synchronized r5 a(Context r13, t5 r14) {
        monitor-enter(q5.class);
        r5 r1 = null;
        if (r13 == null) goto L59;
        if (r14 == null) goto L59;
        if (f7659l == true) goto L12;
        s(r13);     // Catch: Throwable -> L62
        f7659l = true;     // Catch: Throwable -> L62
    L12:
        if (f7649b != f.f7684i) goto L14;
        boolean r2 = true;
    L21:
        if (r2 == true) goto L23;
    L31:
        if (r2 != true) goto L42;
        if (f7653f == c.f7667i) goto L42;
        if (f7653f != c.f7665g) goto L38;
        r1 = new r5(e.f7680l, r14);     // Catch: Throwable -> L62
    L40:
        r2 = false;
        goto L42
    L38:
        if (f7653f != c.f7666h) goto L40;
        r1 = new r5(e.m, r14);     // Catch: Throwable -> L62
    L42:
        if (f7658k == f7657j) goto L47;
        long r9 = f7657j;     // Catch: Throwable -> L62
        f7658k = f7657j;     // Catch: Throwable -> L62
        JSONObject r11 = new JSONObject();     // Catch: Throwable -> L65
        r11.put("privacyInfo", f7648a.a());     // Catch: Throwable -> L65
        r11.put("privacyShow", f7649b.a());     // Catch: Throwable -> L65
        r11.put("showTime", f7652e);     // Catch: Throwable -> L65
        r11.put("show2SDK", f7650c);     // Catch: Throwable -> L65
        r11.put("show2SDKVer", f7651d);     // Catch: Throwable -> L65
        r11.put("privacyAgree", f7653f.a());     // Catch: Throwable -> L65
        r11.put("agreeTime", f7654g);     // Catch: Throwable -> L65
        r11.put("agree2SDK", f7655h);     // Catch: Throwable -> L65
        r11.put("agree2SDKVer", f7656i);     // Catch: Throwable -> L65
        r1.f().d(new b(m, r13, r9, r11));     // Catch: Throwable -> L62
    L49:
        m = false;     // Catch: Throwable -> L62
        String r15 = i5.j(r13);     // Catch: Throwable -> L62
        if (r15 != null) goto L52;
    L53:
        r1 = new r5(e.n, r14);     // Catch: Throwable -> L62
        Log.e(r14.a(), String.format("获取apikey失败：\nerrorCode : %d\n原因：%s", new Object[]{Integer.valueOf(r1.f7743a.a()), r1.f7744b}));     // Catch: Throwable -> L62
    L54:
        if (r2 == false) goto L56;
        r1 = new r5(e.f7675g, r14);     // Catch: Throwable -> L62
    L57:
        monitor-exit(q5.class);
        return r1;
    L56:
        Log.e(r14.a(), String.format("隐私合规校验失败：\nerrorCode : %d\n原因：%s", new Object[]{Integer.valueOf(r1.f7743a.a()), r1.f7744b}));     // Catch: Throwable -> L62
        goto L57
    L52:
        if (r15.length() > 0) goto L54;
    L47:
        if (m == false) goto L49;
        r1.f().d(new a(r13));     // Catch: Throwable -> L62
        goto L49
    L23:
        if (f7648a == d.f7672i) goto L31;
        if (f7648a != d.f7670g) goto L28;
        r1 = new r5(e.f7678j, r14);     // Catch: Throwable -> L62
    L30:
        r2 = false;
        goto L31
    L28:
        if (f7648a != d.f7671h) goto L30;
        r1 = new r5(e.f7679k, r14);     // Catch: Throwable -> L62
        goto L30
    L14:
        if (f7649b != f.f7682g) goto L17;
        r1 = new r5(e.f7676h, r14);     // Catch: Throwable -> L62
    L19:
        r2 = false;
        goto L21
    L17:
        if (f7649b != f.f7683h) goto L19;
        r1 = new r5(e.f7677i, r14);     // Catch: Throwable -> L62
    L59:
        r5 r16 = new r5(e.o, r14);     // Catch: Throwable -> L62
        monitor-exit(q5.class);
        return r16;
    L62:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ String b(long r0) {
        return l(r0);
    }

    static /* synthetic */ String c(Context r0) {
        return t(r0);
    }

    static /* synthetic */ ArrayList d(String r0) {
        return m(r0);
    }

    private static synchronized void e(Context r2, c r3, t5 r4) {
        monitor-enter(q5.class);
        if (r2 == null) goto L18;
        if (r4 == null) goto L18;
    L15:
        th = move-exception;
        throw th;
    L8:
        if (f7659l == true) goto L11;
        s(r2);     // Catch: Throwable -> L15
        f7659l = true;     // Catch: Throwable -> L15
    L11:
        if (r3 == f7653f) goto L13;
        f7653f = r3;     // Catch: Throwable -> L15
        f7655h = r4.a();     // Catch: Throwable -> L15
        f7656i = r4.e();     // Catch: Throwable -> L15
        long r5 = System.currentTimeMillis();     // Catch: Throwable -> L15
        f7654g = r5;     // Catch: Throwable -> L15
        f7657j = r5;     // Catch: Throwable -> L15
        r(r2);     // Catch: Throwable -> L15
    L13:
        monitor-exit(q5.class);
        return;
    L18:
        monitor-exit(q5.class);
    }

    private static synchronized void f(Context r4, f r5, d r6, t5 r7) {
        Boolean r0 = Boolean.TRUE;
        monitor-enter(q5.class);
        if (r4 == null) goto L25;
        if (r7 == null) goto L25;
    L22:
        th = move-exception;
        throw th;
    L8:
        if (f7659l == true) goto L10;
        s(r4);     // Catch: Throwable -> L22
        f7659l = true;     // Catch: Throwable -> L22
    L10:
        Boolean r2 = Boolean.FALSE;     // Catch: Throwable -> L22
        if (r5 == f7649b) goto L14;
        f7649b = r5;     // Catch: Throwable -> L22
        r2 = r0;
    L14:
        if (r6 == f7648a) goto L16;
        f7648a = r6;     // Catch: Throwable -> L22
    L18:
        if (r0.booleanValue() == false) goto L20;
        f7650c = r7.a();     // Catch: Throwable -> L22
        f7651d = r7.e();     // Catch: Throwable -> L22
        long r8 = System.currentTimeMillis();     // Catch: Throwable -> L22
        f7652e = r8;     // Catch: Throwable -> L22
        f7657j = r8;     // Catch: Throwable -> L22
        r(r4);     // Catch: Throwable -> L22
    L20:
        monitor-exit(q5.class);
        return;
    L16:
        r0 = r2;
    L25:
        monitor-exit(q5.class);
    }

    static /* synthetic */ void g(Context r3, String r4) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.length() == 0) goto L21;
        File r2 = new File(t(r3) + "/" + r4);     // Catch: Throwable -> L15
        if (r2.exists() == true) goto L10;
        return;
    L10:
        File r5 = new File(u(r3) + "/" + r4);     // Catch: Throwable -> L15
        if (r5.getParentFile().exists() == true) goto L13;
        r5.getParentFile().mkdirs();     // Catch: Throwable -> L15
    L13:
        r2.renameTo(r5);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    static /* synthetic */ void h(Context r1, JSONObject r2, long r3) {
        FileOutputStream r0 = null;
        byte[] r4 = d0.o(r1, r2.toString().getBytes());     // Catch: Throwable -> L15
        String r5 = l(r3);     // Catch: Throwable -> L15
        File r6 = new File(t(r1) + "/" + r5);     // Catch: Throwable -> L15
        if (r6.getParentFile().exists() == true) goto L6;
        r6.getParentFile().mkdirs();     // Catch: Throwable -> L15
    L6:
        FileOutputStream r7 = new FileOutputStream(r6);     // Catch: Throwable -> L15
        r7.write(r4);     // Catch: Throwable -> L13
        r7.close();     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
        return;
    L13:
        th = move-exception;
        r0 = r7;
        th = th;
    L32:
        th.printStackTrace();     // Catch: Throwable -> L23
        if (r0 == null) goto L42;
        r0.close();     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        th.printStackTrace();
        return;
    L42:
        return;
    L23:
        th = move-exception;
        if (r0 != null) goto L36;
    L29:
        throw th;
    L36:
        r0.close();     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        th.printStackTrace();
    L15:
        th = th;
        goto L32
    }

    public static void i(Context r0, boolean r1, t5 r2) {
        if (r1 == false) goto L4;
        c r3 = c.f7667i;
    L5:
        e(r0, r3, r2);
        return;
    L4:
        r3 = c.f7666h;
        goto L5
    }

    public static void j(Context r0, boolean r1, boolean r2, t5 r3) {
        if (r2 == false) goto L4;
        f r4 = f.f7684i;
    L5:
        if (r1 == false) goto L7;
        d r5 = d.f7672i;
    L8:
        f(r0, r4, r5, r3);
        return;
    L7:
        r5 = d.f7671h;
        goto L8
    L4:
        r4 = f.f7683h;
        goto L5
    }

    static /* synthetic */ boolean k(Context r0, JSONObject r1) {
        return p(r0, r1);
    }

    private static String l(long r1) {
        return String.format("%d-%s", new Object[]{Long.valueOf(r1), "privacy.data"});
    }

    private static ArrayList<File> m(String r4) {
        ArrayList<File> r0 = new ArrayList();
        if (r4 != null) goto L5;
    L17:
        return r0;
    L5:
        if (r4.length() == 0) goto L17;
        File r1 = new File(r4);
        if (r1.exists() == true) goto L10;
        return r0;
    L10:
        File[] r5 = r1.listFiles();
        int r2 = 0;
    L12:
        if (r2 >= r5.length) goto L17;
        File r3 = r5[r2];
        if (r3.isFile() == false) goto L16;
        r0.add(r3);
    L16:
        r2 = r2 + 1;
        goto L12
    }

    static /* synthetic */ void n(Context r6) {
        Iterator<File> r0 = m(u(r6)).iterator();     // Catch: Throwable -> L24
    L3:
        if (r0.hasNext() == false) goto L23;
        File r1 = r0.next();     // Catch: Throwable -> L24
        String r2 = r1.getName();     // Catch: Throwable -> L20
    L7:
        if (r2.endsWith("-privacy.data") == false) goto L8;
        String[] r3 = r2.split("-");     // Catch: Throwable -> L20
        if (r3 != null) goto L15;
        if (r3.length != 2) goto L8;
    L15:
        if (Long.parseLong(r3[0]) <= 0) goto L8;
        FileInputStream r4 = new FileInputStream(r1);     // Catch: Throwable -> L20
        byte[] r5 = new byte[r4.available()];     // Catch: Throwable -> L20
        r4.read(r5);     // Catch: Throwable -> L20
        if (p(r6, new JSONObject(new String(d0.r(r6, r5)))) == false) goto L3;
    L8:
        r1.delete();     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L24
        goto L3
    L23:
        return;
    L24:
        th = move-exception;
        th.printStackTrace();
    }

    static /* synthetic */ void o(Context r1, String r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.length() == 0) goto L17;
        File r3 = new File(t(r1) + "/" + r2);     // Catch: Throwable -> L11
        if (r3.exists() == true) goto L9;
        return;
    L9:
        r3.delete();     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    private static boolean p(Context r3, JSONObject r4) {
        x r2 = new x();     // Catch: Throwable -> L10
        r2.m = r3;     // Catch: Throwable -> L10
        r2.f7949l = r4;     // Catch: Throwable -> L10
        new o0();     // Catch: Throwable -> L10
        u0 r5 = o0.c(r2);     // Catch: Throwable -> L10
        if (r5 == null) goto L15;
        JSONObject r6 = new JSONObject(u5.g(r5.f7856a));     // Catch: Throwable -> L10
        if (r6.has("status") == false) goto L16;
        if (r6.getInt("status") == 1) goto L18;
        return false;
    L18:
        return true;
    L16:
        return false;
    L15:
        return false;
    L10:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    static /* synthetic */ void q(Context r0) {
        r(r0);
    }

    private static synchronized void r(Context r6) {
        monitor-enter(q5.class);
        if (r6 != null) goto L22;
        monitor-exit(q5.class);
        return;
    L22:
    L17:
        th = move-exception;
        throw th;
    L8:
        if (f7659l == true) goto L20;
        s(r6);     // Catch: Throwable -> L17
        f7659l = true;     // Catch: Throwable -> L17
    L20:
        d0.f(r6, "AMap.privacy.data", "AMap.privacy.data", String.format("%d&%d&%d&%s&%s&%d&%d&%s&%s&%d&%d", new Object[]{Integer.valueOf(f7648a.a()), Integer.valueOf(f7649b.a()), Long.valueOf(f7652e), f7650c, f7651d, Integer.valueOf(f7653f.a()), Long.valueOf(f7654g), f7655h, f7656i, Long.valueOf(f7657j), Long.valueOf(f7658k)}));     // Catch: Throwable -> L13
        monitor-exit(q5.class);
        return;
    L13:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L17
    }

    private static void s(Context r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        String r1 = null;
        r1 = d0.e(r2, "AMap.privacy.data", "AMap.privacy.data");     // Catch: Throwable -> L8
    L10:
        if (r1 != null) goto L12;
        return;
    L12:
        String[] r3 = r1.split("&");
        if (r3.length == 11) goto L21;
        return;
    L21:
        f7648a = d.b(Integer.parseInt(r3[0]));     // Catch: Throwable -> L18
        f7649b = f.b(Integer.parseInt(r3[1]));     // Catch: Throwable -> L18
        f7652e = Long.parseLong(r3[2]);     // Catch: Throwable -> L18
        f7651d = r3[3];     // Catch: Throwable -> L18
        f7651d = r3[4];     // Catch: Throwable -> L18
        f7653f = c.b(Integer.parseInt(r3[5]));     // Catch: Throwable -> L18
        f7654g = Long.parseLong(r3[6]);     // Catch: Throwable -> L18
        f7655h = r3[7];     // Catch: Throwable -> L18
        f7656i = r3[8];     // Catch: Throwable -> L18
        f7657j = Long.parseLong(r3[9]);     // Catch: Throwable -> L18
        f7658k = Long.parseLong(r3[10]);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        th.printStackTrace();
        return;
    L8:
        th = move-exception;
        th.printStackTrace();
        goto L10
    }

    private static String t(Context r1) {
        return r1.getFilesDir().getAbsolutePath() + "/AMap/Privacy/Upload";
    }

    private static String u(Context r1) {
        return r1.getFilesDir().getAbsolutePath() + "/AMap/Privacy/Reload";
    }
}
