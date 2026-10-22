package w;

import android.os.StrictMode;
import com.airbnb.lottie.m;
import com.bytedance.ies.bullet.core.j;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import sj.k;

/* JADX INFO: loaded from: classes.dex */
public final class c implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f22657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f22658b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final File f22659c;
    public final File d;
    public final int e;
    public final long f;
    public final int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f22660h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public BufferedWriter f22661i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final LinkedHashMap f22662j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f22663k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f22664l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ThreadPoolExecutor f22665m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final m f22666n;

    public c(long r17, File r19) {
        this.f22660h = 0;
        this.f22662j = new LinkedHashMap(0, 0.75f, true);
        this.f22664l = 0;
        this.f22665m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a());
        this.f22666n = new m(this, 11);
        this.f22657a = r19;
        this.e = 1;
        this.f22658b = new File(r19, "journal");
        this.f22659c = new File(r19, "journal.tmp");
        this.d = new File(r19, "journal.bkp");
        this.g = 1;
        this.f = r17;
    }

    public static void M(File r5, File r10, boolean r11) {
        if (r11 == false) goto L5;
        e(r10);
    L5:
        if (r5.renameTo(r10) == false) goto L8;
        return;
    L8:
        throw new IOException();
    }

    public static void b(c r10, j r11, boolean r12) {
        monitor-enter(r10);
        b r5 = (b) r11.f5320b;     // Catch: Throwable -> L19
        if (r5.f != r11) goto L47;
        int r13 = 0;
        if (r12 == false) goto L25;
        if (r5.e == true) goto L25;
        int r14 = 0;
    L11:
        if (r14 >= r10.g) goto L25;
        if (((boolean[]) r11.f5321c)[r14] == false) goto L22;
        if (r5.d[r14].exists() == false) goto L16;
        r14 = r14 + 1;
        goto L11
    L16:
        r11.a();     // Catch: Throwable -> L19
        monitor-exit(r10);
        return;
    L22:
        r11.a();     // Catch: Throwable -> L19
        throw new IllegalStateException("Newly created entry didn't create value for index " + r14);     // Catch: Throwable -> L19
    L25:
        if (r13 >= r10.g) goto L33;
        File r15 = r5.d[r13];     // Catch: Throwable -> L19
        if (r12 == true) goto L29;
        e(r15);     // Catch: Throwable -> L19
    L32:
        r13 = r13 + 1;     // Catch: Throwable -> L19
        goto L25
    L29:
        if (r15.exists() == false) goto L32;
        File r16 = r5.f22656c[r13];     // Catch: Throwable -> L19
        r15.renameTo(r16);     // Catch: Throwable -> L19
        long r17 = r5.f22655b[r13];     // Catch: Throwable -> L19
        long r18 = r16.length();     // Catch: Throwable -> L19
        r5.f22655b[r13] = r18;     // Catch: Throwable -> L19
        r10.f22660h = (r10.f22660h - r17) + r18;     // Catch: Throwable -> L19
        goto L32
    L33:
        r10.f22663k++;     // Catch: Throwable -> L19
        r5.f = null;     // Catch: Throwable -> L19
        if ((r5.e | r12) == false) goto L38;
        r5.e = true;     // Catch: Throwable -> L19
        r10.f22661i.append("CLEAN");     // Catch: Throwable -> L19
        r10.f22661i.append(' ');     // Catch: Throwable -> L19
        r10.f22661i.append(r5.f22654a);     // Catch: Throwable -> L19
        r10.f22661i.append(r5.a());     // Catch: Throwable -> L19
        r10.f22661i.append('\n');     // Catch: Throwable -> L19
        if (r12 == false) goto L39;
        r10.f22664l++;     // Catch: Throwable -> L19
    L39:
        g(r10.f22661i);     // Catch: Throwable -> L19
        if (r10.f22660h <= r10.f) goto L42;
    L43:
        r10.f22665m.submit(r10.f22666n);     // Catch: Throwable -> L19
    L44:
        monitor-exit(r10);
        return;
    L42:
        if (r10.n() == false) goto L44;
    L38:
        r10.f22662j.remove(r5.f22654a);     // Catch: Throwable -> L19
        r10.f22661i.append("REMOVE");     // Catch: Throwable -> L19
        r10.f22661i.append(' ');     // Catch: Throwable -> L19
        r10.f22661i.append(r5.f22654a);     // Catch: Throwable -> L19
        r10.f22661i.append('\n');     // Catch: Throwable -> L19
        goto L39
    L47:
        throw new IllegalStateException();     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    public static void d(BufferedWriter r5) {
        StrictMode.ThreadPolicy r10 = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(r10).permitUnbufferedIo().build());
        r5.close();     // Catch: Throwable -> L6
        StrictMode.setThreadPolicy(r10);
        return;
    L6:
        th = move-exception;
        StrictMode.setThreadPolicy(r10);
        throw th;
    }

    public static void e(File r5) {
        if (r5.exists() == true) goto L5;
        return;
    L5:
        if (r5.delete() == false) goto L8;
        return;
    L8:
        throw new IOException();
    }

    public static void g(BufferedWriter r5) {
        StrictMode.ThreadPolicy r10 = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(r10).permitUnbufferedIo().build());
        r5.flush();     // Catch: Throwable -> L6
        StrictMode.setThreadPolicy(r10);
        return;
    L6:
        th = move-exception;
        StrictMode.setThreadPolicy(r10);
        throw th;
    }

    public static c p(long r5, File r10) {
        if (r5 <= 0) goto L19;
        File r11 = new File(r10, "journal.bkp");
        if (r11.exists() == false) goto L10;
        File r12 = new File(r10, "journal");
        if (r12.exists() == false) goto L9;
        r11.delete();
        goto L10
    L9:
        M(r11, r12, false);
    L10:
        c r13 = new c(r5, r10);
        if (r13.f22658b.exists() == true) goto L20;
    L16:
        r10.mkdirs();
        c r14 = new c(r5, r10);
        r14.L();
        return r14;
    L20:
        r13.J();     // Catch: IOException -> L14
        r13.q();     // Catch: IOException -> L14
        return r13;
    L14:
        e = move-exception;
        System.out.println("DiskLruCache " + r10 + " is corrupt: " + e.getMessage() + ", removing");
        r13.close();
        e.a(r13.f22657a);
        goto L16
    L19:
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public final void J() {
        File r5 = this.f22658b;
        d r10 = new d(new FileInputStream(r5), e.f22670a);
        String r11 = r10.b();     // Catch: Throwable -> L16
        String r12 = r10.b();     // Catch: Throwable -> L16
        String r13 = r10.b();     // Catch: Throwable -> L16
        String r14 = r10.b();     // Catch: Throwable -> L16
        String r15 = r10.b();     // Catch: Throwable -> L16
        if ("libcore.io.DiskLruCache".equals(r11) == false) goto L27;
        if (IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST.equals(r12) == false) goto L27;
        if (Integer.toString(this.e).equals(r13) == false) goto L27;
        if (Integer.toString(this.g).equals(r14) == false) goto L27;
        if ("".equals(r15) == false) goto L27;
        int r16 = 0;
    L34:
        K(r10.b());     // Catch: Throwable -> L16 EOFException -> L18
        r16 = r16 + 1;
        goto L34
    L18:
        this.f22663k = r16 - this.f22662j.size();     // Catch: Throwable -> L16
        if (r10.e != (-1)) goto L21;
        L();     // Catch: Throwable -> L16
    L37:
        r10.close();     // Catch: Exception -> L32 RuntimeException -> L24
        return;
    L24:
        e = move-exception;
        throw e;
    L41:
        return;
    L21:
        this.f22661i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(r5, true), e.f22670a));     // Catch: Throwable -> L16
    L27:
        throw new IOException("unexpected journal header: [" + r11 + ", " + r12 + ", " + r14 + ", " + r15 + "]");     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        r10.close();     // Catch: Exception -> L33 RuntimeException -> L30
    L30:
        e = move-exception;
        throw e;
    L29:
        throw th;
    }

    public final void K(String r10) {
        int r5 = r10.indexOf(32);
        if (r5 == (-1)) goto L46;
        int r11 = r5 + 1;
        int r12 = r10.indexOf(32, r11);
        LinkedHashMap r13 = this.f22662j;
        if (r12 != (-1)) goto L12;
        String r14 = r10.substring(r11);
        if (r5 == 6) goto L9;
    L13:
        b r15 = (b) r13.get(r14);
        if (r15 != null) goto L17;
        r15 = new b(this, r14);
        r13.put(r14, r15);
    L17:
        if (r12 == (-1)) goto L32;
        if (r5 != 5) goto L32;
        if (r10.startsWith("CLEAN") == false) goto L32;
        String[] r16 = r10.substring(r12 + 1).split(" ");
        r15.e = true;
        r15.f = null;
        if (r16.length != r15.g.g) goto L31;
        int r17 = 0;
    L47:
        if (r17 >= r16.length) goto L51;
        r15.f22655b[r17] = Long.parseLong(r16[r17]);     // Catch: NumberFormatException -> L28
        r17 = r17 + 1;
        goto L47
    L51:
        return;
    L29:
        throw new IOException("unexpected journal line: " + Arrays.toString(r16));
    L31:
        throw new IOException("unexpected journal line: " + Arrays.toString(r16));
    L32:
        if (r12 != (-1)) goto L37;
        if (r5 != 5) goto L37;
        if (r10.startsWith("DIRTY") == false) goto L37;
        r15.f = new j(this, r15);
        return;
    L37:
        if (r12 != (-1)) goto L44;
        if (r5 != 4) goto L44;
        if (r10.startsWith("READ") == false) goto L44;
        return;
    L44:
        throw new IOException("unexpected journal line: ".concat(r10));
    L9:
        if (r10.startsWith("REMOVE") == false) goto L13;
        r13.remove(r14);
        return;
    L12:
        r14 = r10.substring(r11, r12);
        goto L13
    L46:
        throw new IOException("unexpected journal line: ".concat(r10));
    }

    public final synchronized void L() {
        monitor-enter(this);
        BufferedWriter r5 = this.f22661i;     // Catch: Throwable -> L20
        if (r5 == null) goto L6;
        d(r5);     // Catch: Throwable -> L20
    L6:
        BufferedWriter r10 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f22659c), e.f22670a));     // Catch: Throwable -> L20
        r10.write("libcore.io.DiskLruCache");     // Catch: Throwable -> L13
        r10.write("\n");     // Catch: Throwable -> L13
        r10.write(IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);     // Catch: Throwable -> L13
        r10.write("\n");     // Catch: Throwable -> L13
        r10.write(Integer.toString(this.e));     // Catch: Throwable -> L13
        r10.write("\n");     // Catch: Throwable -> L13
        r10.write(Integer.toString(this.g));     // Catch: Throwable -> L13
        r10.write("\n");     // Catch: Throwable -> L13
        r10.write("\n");     // Catch: Throwable -> L13
        Iterator r11 = this.f22662j.values().iterator();     // Catch: Throwable -> L13
    L8:
        if (r11.hasNext() == false) goto L17;
        b r12 = (b) r11.next();     // Catch: Throwable -> L13
        if (r12.f != null) goto L12;
        r10.write("CLEAN " + r12.f22654a + r12.a() + '\n');     // Catch: Throwable -> L13
        goto L8
    L12:
        r10.write("DIRTY " + r12.f22654a + '\n');     // Catch: Throwable -> L13
        goto L8
    L17:
        d(r10);     // Catch: Throwable -> L20
        if (this.f22658b.exists() == false) goto L22;
        M(this.f22658b, this.d, true);     // Catch: Throwable -> L20
    L22:
        M(this.f22659c, this.f22658b, false);     // Catch: Throwable -> L20
        this.d.delete();     // Catch: Throwable -> L20
        this.f22661i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f22658b, true), e.f22670a));     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L13:
        th = move-exception;
        d(r10);     // Catch: Throwable -> L20
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    public final void N() {
    L3:
        if (this.f22660h <= this.f) goto L37;
        String r5 = (String) ((Map.Entry) this.f22662j.entrySet().iterator().next()).getKey();
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L7:
        if (this.f22661i == null) goto L34;
        b r10 = (b) this.f22662j.get(r5);     // Catch: Throwable -> L23
        if (r10 == null) goto L31;
        if (r10.f != null) goto L31;
        int r11 = 0;
    L15:
        if (r11 >= this.g) goto L26;
        File r12 = r10.f22656c[r11];     // Catch: Throwable -> L23
        if (r12.exists() == false) goto L25;
        if (r12.delete() == true) goto L25;
        throw new IOException("failed to delete " + r12);     // Catch: Throwable -> L23
    L25:
        long r13 = this.f22660h;     // Catch: Throwable -> L23
        long[] r14 = r10.f22655b;     // Catch: Throwable -> L23
        this.f22660h = r13 - r14[r11];     // Catch: Throwable -> L23
        r14[r11] = 0;     // Catch: Throwable -> L23
        r11 = r11 + 1;     // Catch: Throwable -> L23
        goto L15
    L26:
        this.f22663k++;     // Catch: Throwable -> L23
        this.f22661i.append("REMOVE");     // Catch: Throwable -> L23
        this.f22661i.append(' ');     // Catch: Throwable -> L23
        this.f22661i.append(r5);     // Catch: Throwable -> L23
        this.f22661i.append('\n');     // Catch: Throwable -> L23
        this.f22662j.remove(r5);     // Catch: Throwable -> L23
        if (n() == false) goto L29;
        this.f22665m.submit(this.f22666n);     // Catch: Throwable -> L23
    L29:
        monitor-exit(this);
    L31:
        monitor-exit(this);
        goto L3
    L34:
        throw new IllegalStateException("cache is closed");     // Catch: Throwable -> L23
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.f22661i != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        Iterator r5 = new ArrayList(this.f22662j.values()).iterator();     // Catch: Throwable -> L13
    L9:
        if (r5.hasNext() == false) goto L15;
        j r10 = ((b) r5.next()).f;     // Catch: Throwable -> L13
        if (r10 == null) goto L9;
        r10.a();     // Catch: Throwable -> L13
        goto L9
    L15:
        N();     // Catch: Throwable -> L13
        d(this.f22661i);     // Catch: Throwable -> L13
        this.f22661i = null;     // Catch: Throwable -> L13
        monitor-exit(this);
    }

    public final j f(String r5) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.f22661i == null) goto L19;
        b r10 = (b) this.f22662j.get(r5);     // Catch: Throwable -> L8
        if (r10 != null) goto L11;
        r10 = new b(this, r5);     // Catch: Throwable -> L8
        this.f22662j.put(r5, r10);     // Catch: Throwable -> L8
    L14:
        j r11 = new j(this, r10);     // Catch: Throwable -> L8
        r10.f = r11;     // Catch: Throwable -> L8
        this.f22661i.append("DIRTY");     // Catch: Throwable -> L8
        this.f22661i.append(' ');     // Catch: Throwable -> L8
        this.f22661i.append(r5);     // Catch: Throwable -> L8
        this.f22661i.append('\n');     // Catch: Throwable -> L8
        g(this.f22661i);     // Catch: Throwable -> L8
        monitor-exit(this);
        return r11;
    L11:
        if (r10.f == null) goto L14;
        monitor-exit(this);
        return null;
    L19:
        throw new IllegalStateException("cache is closed");     // Catch: Throwable -> L8
    }

    public final synchronized k m(String r10) {
        monitor-enter(this);
    L21:
        th = move-exception;
        throw th;
    L4:
        if (this.f22661i == null) goto L30;
        b r5 = (b) this.f22662j.get(r10);     // Catch: Throwable -> L21
        if (r5 != null) goto L11;
        monitor-exit(this);
        return null;
    L11:
        if (r5.e == true) goto L14;
        monitor-exit(this);
        return null;
    L14:
        File[] r11 = r5.f22656c;     // Catch: Throwable -> L21
        int r12 = r11.length;     // Catch: Throwable -> L21
        int r13 = 0;
    L15:
        if (r13 >= r12) goto L23;
        if (r11[r13].exists() == false) goto L18;
        r13 = r13 + 1;
        goto L15
    L18:
        monitor-exit(this);
        return null;
    L23:
        this.f22663k++;     // Catch: Throwable -> L21
        this.f22661i.append("READ");     // Catch: Throwable -> L21
        this.f22661i.append(' ');     // Catch: Throwable -> L21
        this.f22661i.append(r10);     // Catch: Throwable -> L21
        this.f22661i.append('\n');     // Catch: Throwable -> L21
        if (n() == false) goto L26;
        this.f22665m.submit(this.f22666n);     // Catch: Throwable -> L21
    L26:
        k r14 = new k(r5.f22656c, false);     // Catch: Throwable -> L21
        monitor-exit(this);
        return r14;
    L30:
        throw new IllegalStateException("cache is closed");     // Catch: Throwable -> L21
    }

    public final boolean n() {
        int r5 = this.f22663k;
        if (r5 >= 2000) goto L5;
    L7:
        return false;
    L5:
        if (r5 < this.f22662j.size()) goto L7;
        return true;
    }

    public final void q() {
        e(this.f22659c);
        Iterator r5 = this.f22662j.values().iterator();
    L4:
        if (r5.hasNext() == false) goto L13;
        b r10 = (b) r5.next();
        j r11 = r10.f;
        int r12 = this.g;
        int r13 = 0;
        if (r11 == null) goto L7;
        r10.f = null;
    L10:
        if (r13 >= r12) goto L12;
        e(r10.f22656c[r13]);
        e(r10.d[r13]);
        r13 = r13 + 1;
        goto L10
    L12:
        r5.remove();
    L7:
        if (r13 >= r12) goto L4;
        this.f22660h += r10.f22655b[r13];
        r13 = r13 + 1;
        goto L7
    }
}
