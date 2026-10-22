package d.b.b.e.a;

import java.io.File;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static File f12573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static File f12574b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static File f12575c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static File f12576d;

    public static String a() {
        return System.currentTimeMillis() + "_" + UUID.randomUUID().toString() + ".log";
    }

    public static synchronized File b() {
        monitor-enter(b.class);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (f12574b != null) goto L12;
        File r1 = new File(f(), "flush");     // Catch: Throwable -> L15
        if (r1.exists() == true) goto L9;
        r1.mkdirs();     // Catch: Throwable -> L15
    L9:
        f12574b = r1;     // Catch: Throwable -> L15
        if (d.b.b.o.a.c() == false) goto L12;
        d.b.b.o.m.b.a(a.f12571a, "prepare FlushDirectory success. name=" + f12574b);     // Catch: Throwable -> L15
    L12:
        File r2 = f12574b;     // Catch: Throwable -> L15
        monitor-exit(b.class);
        return r2;
    }

    public static synchronized File c() {
        monitor-enter(b.class);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (f12575c == null) goto L7;
    L16:
        File r1 = f12575c;     // Catch: Throwable -> L19
        monitor-exit(b.class);
        return r1;
    L7:
        if (d.b.b.i.c.a.A() == false) goto L9;
        File r2 = new File(f(), "persistent");     // Catch: Throwable -> L19
    L11:
        if (r2.exists() == true) goto L13;
        r2.mkdirs();     // Catch: Throwable -> L19
    L13:
        f12575c = r2;     // Catch: Throwable -> L19
        if (d.b.b.o.a.c() == false) goto L16;
        d.b.b.o.m.b.a(a.f12571a, "prepare PersistentDirectory success. name=" + f12575c);     // Catch: Throwable -> L19
        goto L16
    L9:
        r2 = new File(f(), "child_process_persistent");     // Catch: Throwable -> L19
        goto L11
    }

    public static synchronized File d() {
        monitor-enter(b.class);
    L21:
        th = move-exception;
        throw th;
    L5:
        if (f12573a == null) goto L24;
    L18:
        File r1 = f12573a;     // Catch: Throwable -> L21
        monitor-exit(b.class);
        return r1;
    L24:
        String r2 = d.b.b.i.c.a.m().replace(".", "_").replace(":", "-") + ".bin";     // Catch: Exception -> L16 Throwable -> L21
        if (d.b.b.i.c.a.A() == true) goto L9;
        r2 = d.b.b.i.c.a.o() + "_" + r2;     // Catch: Exception -> L16 Throwable -> L21
    L9:
        File r3 = new File(c(), r2);     // Catch: Exception -> L16 Throwable -> L21
        if (r3.exists() == true) goto L12;
        r3.createNewFile();     // Catch: Exception -> L16 Throwable -> L21
    L12:
        f12573a = r3;     // Catch: Exception -> L16 Throwable -> L21
        if (d.b.b.o.a.c() == false) goto L18;
        d.b.b.o.m.b.a(a.f12571a, "prepare PersistentFile success. fileName=" + f12573a);     // Catch: Exception -> L16 Throwable -> L21
    L16:
        e = move-exception;
        d.b.b.o.m.b.c(a.f12571a, "prepare PersistentFile fail.", e);     // Catch: Throwable -> L21
        goto L18
    }

    public static File e() {
        return new File(f(), "child_process_persistent");
    }

    public static synchronized File f() {
        monitor-enter(b.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (f12576d != null) goto L9;
        File r1 = new File(d.b.b.o.a.b().getFilesDir(), "apm6");     // Catch: Throwable -> L12
        f12576d = r1;     // Catch: Throwable -> L12
        if (r1.exists() == true) goto L9;
        f12576d.mkdirs();     // Catch: Throwable -> L12
    L9:
        File r2 = f12576d;     // Catch: Throwable -> L12
        monitor-exit(b.class);
        return r2;
    }
}
