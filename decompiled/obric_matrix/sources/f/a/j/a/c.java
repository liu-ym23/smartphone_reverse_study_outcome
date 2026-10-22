package f.a.j.a;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final enum c extends Enum<c> implements f.a.g.b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c f17051f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final /* synthetic */ c[] f17052g = null;

    static {
        c r0 = new c("DISPOSED", 0);
        f17051f = r0;
        f17052g = new c[]{r0};
    }

    private c(String r1, int r2) {
        super(r1, r2);
    }

    public static boolean a(AtomicReference<f.a.g.b> r2) {
        f.a.g.b r0 = r2.get();
        c r1 = f17051f;
        if (r0 == r1) goto L10;
        f.a.g.b r3 = r2.getAndSet(r1);
        if (r3 == r1) goto L13;
        if (r3 == null) goto L12;
        r3.dispose();
        return true;
    L12:
        return true;
    L13:
        return false;
    L10:
        return false;
    }

    public static boolean b(f.a.g.b r1) {
        if (r1 != f17051f) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean c(AtomicReference<f.a.g.b> r2, f.a.g.b r3) {
    L2:
        f.a.g.b r0 = r2.get();
        if (r0 == f17051f) goto L4;
        if (r2.compareAndSet(r0, r3) == false) goto L2;
        return true;
    L4:
        if (r3 == null) goto L15;
        r3.dispose();
        return false;
    L15:
        return false;
    }

    public static void g() {
        f.a.k.a.m(new f.a.h.d("Disposable already set!"));
    }

    public static boolean j(AtomicReference<f.a.g.b> r2, f.a.g.b r3) {
    L2:
        f.a.g.b r0 = r2.get();
        if (r0 == f17051f) goto L4;
        if (r2.compareAndSet(r0, r3) == false) goto L2;
        if (r0 == null) goto L18;
        r0.dispose();
        return true;
    L18:
        return true;
    L4:
        if (r3 == null) goto L17;
        r3.dispose();
        return false;
    L17:
        return false;
    }

    public static boolean k(AtomicReference<f.a.g.b> r1, f.a.g.b r2) {
        f.a.j.b.b.c(r2, "d is null");
        if (r1.compareAndSet(null, r2) == true) goto L9;
        r2.dispose();
        if (r1.get() == f17051f) goto L11;
        g();
        return false;
    L11:
        return false;
    L9:
        return true;
    }

    public static boolean l(f.a.g.b r1, f.a.g.b r2) {
        if (r2 != null) goto L6;
        f.a.k.a.m(new NullPointerException("next is null"));
        return false;
    L6:
        if (r1 == null) goto L9;
        r2.dispose();
        g();
        return false;
    L9:
        return true;
    }

    public static c valueOf(String r1) {
        return (c) Enum.valueOf(c.class, r1);
    }

    public static c[] values() {
        return (c[]) f17052g.clone();
    }

    @Override // f.a.g.b
    public void dispose() {
    }
}
