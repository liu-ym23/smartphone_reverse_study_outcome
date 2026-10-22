package com.loc;

import com.bytedance.bdlocation.client.LocationInfoConst;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class l0 implements Closeable {
    static final Pattern t = null;
    public static final Charset u = null;
    private static final ThreadFactory v = null;
    static ThreadPoolExecutor w;
    private static final OutputStream x = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final File f7487f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final File f7488g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final File f7489h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final File f7490i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f7491j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f7492k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f7493l;
    private long m;
    private Writer n;
    private int o;
    private final LinkedHashMap<String, f> p;
    private int q;
    private long r;
    private final Callable<Void> s;

    final class a implements ThreadFactory {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final AtomicInteger f7494f;

        a() {
            this.f7494f = new AtomicInteger(1);
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r4) {
            return new Thread(r4, "disklrucache#" + this.f7494f.getAndIncrement());
        }
    }

    final class b implements Callable<Void> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ l0 f7495f;

        b(l0 r1) {
            this.f7495f = r1;
        }

        private Void a() {
            l0 r0 = this.f7495f;
            monitor-enter(r0);
        L13:
            th = move-exception;
            throw th;
        L5:
            if (l0.g(this.f7495f) != null) goto L8;
            monitor-exit(r0);     // Catch: Throwable -> L13
            return null;
        L8:
            l0.N(this.f7495f);     // Catch: Throwable -> L13
            if (l0.S(this.f7495f) == false) goto L11;
            l0.d0(this.f7495f);     // Catch: Throwable -> L13
            l0.g0(this.f7495f);     // Catch: Throwable -> L13
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L13
            return null;
        }

        @Override // java.util.concurrent.Callable
        public final /* synthetic */ Void call() {
            return a();
        }
    }

    final class c extends OutputStream {
        c() {
        }

        @Override // java.io.OutputStream
        public final void write(int r1) {
        }
    }

    public final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final f f7496a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean[] f7497b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f7498c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ l0 f7499d;

        private class a extends FilterOutputStream {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ d f7500f;

            private a(d r1, OutputStream r2) {
                this.f7500f = r1;
                super(r2);
            }

            /* synthetic */ a(d r1, OutputStream r2, byte r3) {
                this(r1, r2);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                ((FilterOutputStream) this).out.close();     // Catch: IOException -> L4
                return;
            L4:
                d.f(this.f7500f);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public final void flush() {
                ((FilterOutputStream) this).out.flush();     // Catch: IOException -> L4
                return;
            L4:
                d.f(this.f7500f);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(int r2) {
                ((FilterOutputStream) this).out.write(r2);     // Catch: IOException -> L4
                return;
            L4:
                d.f(this.f7500f);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(byte[] r2, int r3, int r4) {
                ((FilterOutputStream) this).out.write(r2, r3, r4);     // Catch: IOException -> L4
                return;
            L4:
                d.f(this.f7500f);
            }
        }

        private d(l0 r1, f r2) {
            this.f7499d = r1;
            this.f7496a = r2;
            if (f.l(r2) == false) goto L5;
            boolean[] r3 = null;
        L6:
            this.f7497b = r3;
            return;
        L5:
            r3 = new boolean[l0.j0(r1)];
            goto L6
        }

        /* synthetic */ d(l0 r1, f r2, byte r3) {
            this(r1, r2);
        }

        static /* synthetic */ f a(d r0) {
            return r0.f7496a;
        }

        static /* synthetic */ boolean[] d(d r0) {
            return r0.f7497b;
        }

        static /* synthetic */ boolean f(d r1) {
            r1.f7498c = true;
            return true;
        }

        public final OutputStream b() {
            if (l0.j0(this.f7499d) <= 0) goto L28;
            l0 r0 = this.f7499d;
            monitor-enter(r0);
        L24:
            th = move-exception;
            throw th;
        L7:
            if (f.h(this.f7496a) != this) goto L23;
            byte r2 = 0;
            if (f.l(this.f7496a) == true) goto L11;
            this.f7497b[0] = true;     // Catch: Throwable -> L24
        L11:
            File r1 = this.f7496a.i(0);     // Catch: Throwable -> L24
            FileOutputStream r3 = new FileOutputStream(r1);     // Catch: FileNotFoundException -> L14 Throwable -> L24
        L16:
            a r4 = new a(this, r3, r2);     // Catch: Throwable -> L24
            monitor-exit(r0);     // Catch: Throwable -> L24
            return r4;
        L14:
            l0.l0(this.f7499d).mkdirs();     // Catch: Throwable -> L24
            r3 = new FileOutputStream(r1);     // Catch: FileNotFoundException -> L19 Throwable -> L24
        L21:
            return l0.h0();
        L23:
            throw new IllegalStateException();     // Catch: Throwable -> L24
        L28:
            throw new IllegalArgumentException("Expected index 0 to be greater than 0 and less than the maximum value count of " + l0.j0(this.f7499d));
        }

        public final void c() {
            if (this.f7498c == false) goto L5;
            l0.A(this.f7499d, this, false);
            this.f7499d.V(f.k(this.f7496a));
            return;
        L5:
            l0.A(this.f7499d, this, true);
        }

        public final void e() {
            l0.A(this.f7499d, this, false);
        }
    }

    public final class e implements Closeable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final InputStream[] f7501f;

        private e(l0 r1, String r2, long r3, InputStream[] r5, long[] r6) {
            this.f7501f = r5;
        }

        /* synthetic */ e(l0 r1, String r2, long r3, InputStream[] r5, long[] r6, byte r7) {
            this(r1, r2, r3, r5, r6);
        }

        public final InputStream a() {
            return this.f7501f[0];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            InputStream[] r3 = this.f7501f;
            int r0 = r3.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            l0.C(r3[r1]);
            r1 = r1 + 1;
            goto L3
        }
    }

    private final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f7502a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long[] f7503b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f7504c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private d f7505d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f7506e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ l0 f7507f;

        private f(l0 r1, String r2) {
            this.f7507f = r1;
            this.f7502a = r2;
            this.f7503b = new long[l0.j0(r1)];
        }

        /* synthetic */ f(l0 r1, String r2, byte r3) {
            this(r1, r2);
        }

        static /* synthetic */ long a(f r0, long r1) {
            r0.f7506e = r1;
            return r1;
        }

        static /* synthetic */ d b(f r0, d r1) {
            r0.f7505d = r1;
            return r1;
        }

        private static IOException d(String[] r3) {
            throw new IOException("unexpected journal line: " + Arrays.toString(r3));
        }

        static /* synthetic */ void f(f r5, String[] r6) {
            if (r6.length != l0.j0(r5.f7507f)) goto L12;
            int r0 = 0;
        L14:
        L10:
            d(r6);
            throw null;
        L6:
            if (r0 >= r6.length) goto L9;
            r5.f7503b[r0] = Long.parseLong(r6[r0]);     // Catch: NumberFormatException -> L10
            r0 = r0 + 1;
            goto L14
        L9:
            return;
        L12:
            d(r6);
            throw null;
        }

        static /* synthetic */ boolean g(f r1) {
            r1.f7504c = true;
            return true;
        }

        static /* synthetic */ d h(f r0) {
            return r0.f7505d;
        }

        static /* synthetic */ long[] j(f r0) {
            return r0.f7503b;
        }

        static /* synthetic */ String k(f r0) {
            return r0.f7502a;
        }

        static /* synthetic */ boolean l(f r0) {
            return r0.f7504c;
        }

        static /* synthetic */ long m(f r2) {
            return r2.f7506e;
        }

        public final File c(int r4) {
            return new File(l0.l0(this.f7507f), this.f7502a + "." + r4);
        }

        public final String e() {
            StringBuilder r0 = new StringBuilder();
            long[] r6 = this.f7503b;
            int r1 = r6.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L6;
            long r3 = r6[r2];
            r0.append(' ');
            r0.append(r3);
            r2 = r2 + 1;
            goto L3
        L6:
            return r0.toString();
        }

        public final File i(int r4) {
            return new File(l0.l0(this.f7507f), this.f7502a + "." + r4 + ".tmp");
        }
    }

    static {
        t = Pattern.compile("[a-z0-9_-]{1,120}");
        u = Charset.forName("US-ASCII");
        Charset.forName("UTF-8");
        a r8 = new a();
        v = r8;
        w = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), r8);
        x = new c();
    }

    private l0(File r7, long r8) {
        this.m = 0;
        this.o = 1000;
        this.p = new LinkedHashMap(0, 0.75f, true);
        this.r = 0;
        this.s = new b(this);
        this.f7487f = r7;
        this.f7491j = 1;
        this.f7488g = new File(r7, "journal");
        this.f7489h = new File(r7, "journal.tmp");
        this.f7490i = new File(r7, "journal.bkp");
        this.f7493l = 1;
        this.f7492k = r8;
    }

    static /* synthetic */ void A(l0 r0, d r1, boolean r2) {
        r0.x(r1, r2);
    }

    public static void C(Closeable r0) {
        if (r0 != null) goto L9;
        return;
    L9:
        r0.close();     // Catch: RuntimeException -> L5 Exception -> L8
        return;
    L5:
        e = move-exception;
        throw e;
    }

    private static void E(File r1) {
        if (r1.exists() == true) goto L5;
        return;
    L5:
        if (r1.delete() == false) goto L8;
        return;
    L8:
        throw new IOException();
    }

    private static void F(File r0, File r1, boolean r2) {
        if (r2 == false) goto L5;
        E(r1);
    L5:
        if (r0.renameTo(r1) == false) goto L8;
        return;
    L8:
        throw new IOException();
    }

    static /* synthetic */ void N(l0 r0) {
        r0.r0();
    }

    private static void O(File r4) {
        File[] r0 = r4.listFiles();
        if (r0 == null) goto L16;
        int r5 = r0.length;
        int r1 = 0;
    L5:
        if (r1 >= r5) goto L14;
        File r2 = r0[r1];
        if (r2.isDirectory() == false) goto L10;
        O(r2);
    L10:
        if (r2.delete() == false) goto L13;
        r1 = r1 + 1;
        goto L5
    L13:
        throw new IOException("failed to delete file: ".concat(String.valueOf(r2)));
    L14:
        return;
    L16:
        throw new IOException("not a readable directory: ".concat(String.valueOf(r4)));
    }

    static /* synthetic */ boolean S(l0 r0) {
        return r0.p0();
    }

    private synchronized d X(String r5) {
        monitor-enter(this);
        q0();     // Catch: Throwable -> L14
        i0(r5);     // Catch: Throwable -> L14
        f r0 = this.p.get(r5);     // Catch: Throwable -> L14
        byte r1 = 0;
        if (r0 != null) goto L7;
        r0 = new f(this, r5, r1);     // Catch: Throwable -> L14
        this.p.put(r5, r0);     // Catch: Throwable -> L14
    L11:
        d r2 = new d(this, r0, r1);     // Catch: Throwable -> L14
        f.b(r0, r2);     // Catch: Throwable -> L14
        this.n.write("DIRTY " + r5 + '\n');     // Catch: Throwable -> L14
        this.n.flush();     // Catch: Throwable -> L14
        monitor-exit(this);
        return r2;
    L7:
        if (f.h(r0) == null) goto L11;
        monitor-exit(this);
        return null;
    L14:
        th = move-exception;
        throw th;
    }

    public static l0 b(File r6, long r7) {
        if (r7 <= 0) goto L18;
        File r0 = new File(r6, "journal.bkp");
        if (r0.exists() == false) goto L10;
        File r1 = new File(r6, "journal");
        if (r1.exists() == false) goto L9;
        r0.delete();
        goto L10
    L9:
        F(r0, r1, false);
    L10:
        l0 r2 = new l0(r6, r7);
        if (r2.f7488g.exists() == true) goto L19;
    L15:
        r6.mkdirs();
        l0 r3 = new l0(r6, r7);
        r3.o0();
        return r3;
    L19:
        r2.m0();     // Catch: Throwable -> L14
        r2.n0();     // Catch: Throwable -> L14
        r2.n = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(r2.f7488g, true), u));     // Catch: Throwable -> L14
        return r2;
    L14:
        r2.Y();
        goto L15
    L18:
        throw new IllegalArgumentException("maxSize <= 0");
    }

    static /* synthetic */ void d0(l0 r0) {
        r0.o0();
    }

    static /* synthetic */ Writer g(l0 r0) {
        return r0.n;
    }

    static /* synthetic */ int g0(l0 r1) {
        r1.q = 0;
        return 0;
    }

    static /* synthetic */ OutputStream h0() {
        return x;
    }

    private static void i0(String r3) {
        if (t.matcher(r3).matches() == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + r3 + "\"");
    }

    static /* synthetic */ int j0(l0 r0) {
        return r0.f7493l;
    }

    private static ThreadPoolExecutor k0() {
        ThreadPoolExecutor r0 = w;     // Catch: Throwable -> L8
        if (r0 != null) goto L5;
    L6:
        w = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(256), v);     // Catch: Throwable -> L8
    L11:
        return w;
    L5:
        if (r0.isShutdown() == false) goto L11;
    L8:
        th = move-exception;
        th.printStackTrace();
        goto L11
    }

    public static void l() {
        ThreadPoolExecutor r0 = w;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShutdown() == true) goto L9;
        w.shutdown();
        return;
    }

    static /* synthetic */ File l0(l0 r0) {
        return r0.f7487f;
    }

    private void m0() {
        m0 r1 = new m0(new FileInputStream(this.f7488g), u);
        String r2 = r1.a();     // Catch: Throwable -> L55
        String r3 = r1.a();     // Catch: Throwable -> L55
        String r4 = r1.a();     // Catch: Throwable -> L55
        String r5 = r1.a();     // Catch: Throwable -> L55
        String r6 = r1.a();     // Catch: Throwable -> L55
        if ("libcore.io.DiskLruCache".equals(r2) == false) goto L54;
        if (LocationInfoConst.ALLOW_USE_LOCATION.equals(r3) == false) goto L54;
        if (Integer.toString(this.f7491j).equals(r4) == false) goto L54;
        if (Integer.toString(this.f7493l).equals(r5) == false) goto L54;
        if ("".equals(r6) == false) goto L54;
        byte r0 = 0;
        int r7 = 0;
    L58:
        String r8 = r1.a();     // Catch: EOFException -> L50 Throwable -> L55
        int r9 = r8.indexOf(32);     // Catch: EOFException -> L50 Throwable -> L55
        if (r9 == (-1)) goto L49;
        int r10 = r9 + 1;
        int r11 = r8.indexOf(32, r10);     // Catch: EOFException -> L50 Throwable -> L55
        if (r11 != (-1)) goto L25;
        String r12 = r8.substring(r10);     // Catch: EOFException -> L50 Throwable -> L55
        if (r9 == 6) goto L23;
    L26:
        f r13 = this.p.get(r12);     // Catch: EOFException -> L50 Throwable -> L55
        if (r13 != null) goto L30;
        r13 = new f(this, r12, r0);     // Catch: EOFException -> L50 Throwable -> L55
        this.p.put(r12, r13);     // Catch: EOFException -> L50 Throwable -> L55
    L30:
        if (r11 == (-1)) goto L35;
        if (r9 != 5) goto L35;
        if (r8.startsWith("CLEAN") == false) goto L35;
        String[] r14 = r8.substring(r11 + 1).split(" ");     // Catch: EOFException -> L50 Throwable -> L55
        f.g(r13);     // Catch: EOFException -> L50 Throwable -> L55
        f.b(r13, null);     // Catch: EOFException -> L50 Throwable -> L55
        f.f(r13, r14);     // Catch: EOFException -> L50 Throwable -> L55
    L45:
        r7 = r7 + 1;     // Catch: EOFException -> L50 Throwable -> L55
    L35:
        if (r11 != (-1)) goto L40;
        if (r9 != 5) goto L40;
        if (r8.startsWith("DIRTY") == false) goto L40;
        f.b(r13, new d(this, r13, r0));     // Catch: EOFException -> L50 Throwable -> L55
    L40:
        if (r11 != (-1)) goto L47;
        if (r9 != 4) goto L47;
        if (r8.startsWith("READ") == true) goto L45;
    L47:
        throw new IOException("unexpected journal line: ".concat(String.valueOf(r8)));     // Catch: EOFException -> L50 Throwable -> L55
    L23:
        if (r8.startsWith("REMOVE") == false) goto L26;
        this.p.remove(r12);     // Catch: EOFException -> L50 Throwable -> L55
        goto L45
    L25:
        r12 = r8.substring(r10, r11);     // Catch: EOFException -> L50 Throwable -> L55
        goto L26
    L49:
        throw new IOException("unexpected journal line: ".concat(String.valueOf(r8)));     // Catch: EOFException -> L50 Throwable -> L55
    L50:
        this.q = r7 - this.p.size();     // Catch: Throwable -> L55
        C(r1);
        return;
    L54:
        throw new IOException("unexpected journal header: [" + r2 + ", " + r3 + ", " + r5 + ", " + r6 + "]");     // Catch: Throwable -> L55
    L55:
        th = move-exception;
        C(r1);
        throw th;
    }

    private void n0() {
        E(this.f7489h);
        Iterator<f> r0 = this.p.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L15;
        f r1 = r0.next();
        int r3 = 0;
        if (f.h(r1) == null) goto L8;
        f.b(r1, null);
    L12:
        if (r3 >= this.f7493l) goto L14;
        E(r1.c(r3));
        E(r1.i(r3));
        r3 = r3 + 1;
        goto L12
    L14:
        r0.remove();
    L8:
        if (r3 >= this.f7493l) goto L4;
        this.m += f.j(r1)[r3];
        r3 = r3 + 1;
        goto L8
    }

    private synchronized void o0() {
        monitor-enter(this);
        Writer r0 = this.n;     // Catch: Throwable -> L25
        if (r0 == null) goto L6;
        r0.close();     // Catch: Throwable -> L25
    L6:
        BufferedWriter r1 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f7489h), u));     // Catch: Throwable -> L25
        r1.write("libcore.io.DiskLruCache");     // Catch: Throwable -> L22
        r1.write("\n");     // Catch: Throwable -> L22
        r1.write(LocationInfoConst.ALLOW_USE_LOCATION);     // Catch: Throwable -> L22
        r1.write("\n");     // Catch: Throwable -> L22
        r1.write(Integer.toString(this.f7491j));     // Catch: Throwable -> L22
        r1.write("\n");     // Catch: Throwable -> L22
        r1.write(Integer.toString(this.f7493l));     // Catch: Throwable -> L22
        r1.write("\n");     // Catch: Throwable -> L22
        r1.write("\n");     // Catch: Throwable -> L22
        Iterator<f> r2 = this.p.values().iterator();     // Catch: Throwable -> L22
    L8:
        if (r2.hasNext() == false) goto L16;
        f r3 = r2.next();     // Catch: Throwable -> L22
        if (f.h(r3) == null) goto L14;
        String r4 = "DIRTY " + f.k(r3) + '\n';     // Catch: Throwable -> L22
    L13:
        r1.write(r4);     // Catch: Throwable -> L22
        goto L8
    L14:
        r4 = "CLEAN " + f.k(r3) + r3.e() + '\n';     // Catch: Throwable -> L22
        goto L13
    L16:
        r1.close();     // Catch: Throwable -> L25
        if (this.f7488g.exists() == false) goto L19;
        F(this.f7488g, this.f7490i, true);     // Catch: Throwable -> L25
    L19:
        F(this.f7489h, this.f7488g, false);     // Catch: Throwable -> L25
        this.f7490i.delete();     // Catch: Throwable -> L25
        this.n = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f7488g, true), u));     // Catch: Throwable -> L25
        monitor-exit(this);
        return;
    L22:
        th = move-exception;
        r1.close();     // Catch: Throwable -> L25
        throw th;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    }

    private boolean p0() {
        int r0 = this.q;
        if (r0 >= 2000) goto L5;
        return false;
    L5:
        if (r0 < this.p.size()) goto L10;
        return true;
    L10:
        return false;
    }

    private void q0() {
        if (this.n == null) goto L6;
        return;
    L6:
        throw new IllegalStateException("cache is closed");
    }

    private void r0() {
    L3:
        if (this.m > this.f7492k) goto L8;
        if (this.p.size() > this.o) goto L8;
        return;
    L8:
        V(this.p.entrySet().iterator().next().getKey());
        goto L3
    }

    private synchronized void x(d r10, boolean r11) {
        monitor-enter(this);
        f r0 = d.a(r10);     // Catch: Throwable -> L46
        if (f.h(r0) != r10) goto L45;
        int r1 = 0;
        if (r11 == false) goto L23;
        if (f.l(r0) == true) goto L23;
        int r2 = 0;
    L11:
        if (r2 >= this.f7493l) goto L23;
        if (d.d(r10)[r2] == false) goto L20;
        if (r0.i(r2).exists() == false) goto L16;
        r2 = r2 + 1;
        goto L11
    L16:
        r10.e();     // Catch: Throwable -> L46
        monitor-exit(this);
        return;
    L20:
        r10.e();     // Catch: Throwable -> L46
        throw new IllegalStateException("Newly created entry didn't create value for index ".concat(String.valueOf(r2)));     // Catch: Throwable -> L46
    L23:
        if (r1 >= this.f7493l) goto L31;
        File r12 = r0.i(r1);     // Catch: Throwable -> L46
        if (r11 == true) goto L27;
        E(r12);     // Catch: Throwable -> L46
    L30:
        r1 = r1 + 1;     // Catch: Throwable -> L46
        goto L23
    L27:
        if (r12.exists() == false) goto L30;
        File r3 = r0.c(r1);     // Catch: Throwable -> L46
        r12.renameTo(r3);     // Catch: Throwable -> L46
        long r4 = f.j(r0)[r1];     // Catch: Throwable -> L46
        long r5 = r3.length();     // Catch: Throwable -> L46
        f.j(r0)[r1] = r5;     // Catch: Throwable -> L46
        this.m = (this.m - r4) + r5;     // Catch: Throwable -> L46
        goto L30
    L31:
        this.q++;     // Catch: Throwable -> L46
        f.b(r0, null);     // Catch: Throwable -> L46
        if ((f.l(r0) | r11) == false) goto L36;
        f.g(r0);     // Catch: Throwable -> L46
        this.n.write("CLEAN " + f.k(r0) + r0.e() + '\n');     // Catch: Throwable -> L46
        if (r11 == false) goto L37;
        long r13 = this.r;     // Catch: Throwable -> L46
        this.r = 1 + r13;     // Catch: Throwable -> L46
        f.a(r0, r13);     // Catch: Throwable -> L46
    L37:
        this.n.flush();     // Catch: Throwable -> L46
        if (this.m <= this.f7492k) goto L40;
    L41:
        k0().submit(this.s);     // Catch: Throwable -> L46
    L42:
        monitor-exit(this);
        return;
    L40:
        if (p0() == false) goto L42;
    L36:
        this.p.remove(f.k(r0));     // Catch: Throwable -> L46
        this.n.write("REMOVE " + f.k(r0) + '\n');     // Catch: Throwable -> L46
        goto L37
    L45:
        throw new IllegalStateException();     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        throw th;
    }

    public final d L(String r1) {
        return X(r1);
    }

    public final File M() {
        return this.f7487f;
    }

    public final synchronized void Q() {
        monitor-enter(this);
        q0();     // Catch: Throwable -> L6
        r0();     // Catch: Throwable -> L6
        this.n.flush();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean V(String r7) {
        monitor-enter(this);
        q0();     // Catch: Throwable -> L25
        i0(r7);     // Catch: Throwable -> L25
        f r0 = this.p.get(r7);     // Catch: Throwable -> L25
        int r1 = 0;
        if (r0 != null) goto L6;
    L23:
        monitor-exit(this);
        return false;
    L6:
        if (f.h(r0) != null) goto L23;
    L9:
        if (r1 >= this.f7493l) goto L18;
        File r2 = r0.c(r1);     // Catch: Throwable -> L25
        if (r2.exists() == false) goto L17;
        if (r2.delete() == true) goto L17;
        throw new IOException("failed to delete ".concat(String.valueOf(r2)));     // Catch: Throwable -> L25
    L17:
        this.m -= f.j(r0)[r1];     // Catch: Throwable -> L25
        f.j(r0)[r1] = 0;     // Catch: Throwable -> L25
        r1 = r1 + 1;     // Catch: Throwable -> L25
        goto L9
    L18:
        this.q++;     // Catch: Throwable -> L25
        this.n.append("REMOVE " + r7 + '\n');     // Catch: Throwable -> L25
        this.p.remove(r7);     // Catch: Throwable -> L25
        if (p0() == false) goto L21;
        k0().submit(this.s);     // Catch: Throwable -> L25
    L21:
        monitor-exit(this);
        return true;
    L25:
        th = move-exception;
        throw th;
    }

    public final void Y() {
        close();
        O(this.f7487f);
    }

    public final synchronized e a(String r12) {
        monitor-enter(this);
        q0();     // Catch: Throwable -> L32
        i0(r12);     // Catch: Throwable -> L32
        f r0 = this.p.get(r12);     // Catch: Throwable -> L32
        if (r0 != null) goto L9;
        monitor-exit(this);
        return null;
    L9:
        if (f.l(r0) == true) goto L12;
        monitor-exit(this);
        return null;
    L12:
        InputStream[] r8 = new InputStream[this.f7493l];     // Catch: Throwable -> L32
        int r2 = 0;
        int r3 = 0;
    L36:
        if (r3 >= this.f7493l) goto L18;
        r8[r3] = new FileInputStream(r0.c(r3));     // Catch: FileNotFoundException -> L35 Throwable -> L32
        r3 = r3 + 1;
        goto L36
    L18:
        this.q++;     // Catch: Throwable -> L32
        this.n.append("READ " + r12 + '\n');     // Catch: Throwable -> L32
        if (p0() == false) goto L21;
        k0().submit(this.s);     // Catch: Throwable -> L32
    L21:
        e r1 = new e(this, r12, f.m(r0), r8, f.j(r0), 0);     // Catch: Throwable -> L32
        monitor-exit(this);
        return r1;
    L25:
        if (r2 >= this.f7493l) goto L30;
        if (r8[r2] == null) goto L30;
        C(r8[r2]);     // Catch: Throwable -> L32
        r2 = r2 + 1;
    L30:
        monitor-exit(this);
        return null;
    L32:
        th = move-exception;
        throw th;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (this.n != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        Iterator r0 = new ArrayList(this.p.values()).iterator();     // Catch: Throwable -> L16
    L9:
        if (r0.hasNext() == false) goto L13;
        f r1 = (f) r0.next();     // Catch: Throwable -> L16
        if (f.h(r1) == null) goto L9;
        f.h(r1).e();     // Catch: Throwable -> L16
        goto L9
    L13:
        r0();     // Catch: Throwable -> L16
        this.n.close();     // Catch: Throwable -> L16
        this.n = null;     // Catch: Throwable -> L16
        monitor-exit(this);
    }

    public final void s(int r3) {
        if (r3 >= 10) goto L5;
        r3 = 10;
    L7:
        this.o = r3;
        return;
    L5:
        if (r3 <= 10000) goto L7;
        r3 = 10000;
        goto L7
    }
}
