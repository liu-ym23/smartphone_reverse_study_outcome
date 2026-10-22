package d.b.p.a.e.h.b.c;

/* JADX INFO: loaded from: classes.dex */
public class b implements d.b.p.a.e.h.a.b.a {
    public b() {
    }

    @Override // d.b.p.a.e.h.a.b.a
    public boolean a() {
        return true;
    }

    @Override // d.b.p.a.e.h.a.b.a
    public boolean b(Object r4, Throwable r5) {
        StackTraceElement[] r3 = Thread.currentThread().getStackTrace();
        if ((r5 instanceof ClassNotFoundException) == false) goto L11;
        int r6 = r3.length;
        int r0 = 0;
    L5:
        if (r0 >= r6) goto L11;
        if (r3[r0].getMethodName().contains("installProvider") == true) goto L8;
        r0 = r0 + 1;
        goto L5
    L8:
        return true;
    L11:
        return false;
    }
}
