package d.b.p.a.e.i;

import android.os.Build;
import d.b.p.a.d.h;
import d.b.p.a.h.i;

/* JADX INFO: loaded from: classes.dex */
public class c extends d.b.p.a.g.e {
    public c() {
    }

    private boolean h(Throwable r7) {
        if ((r7 instanceof NullPointerException) == false) goto L13;
        StackTraceElement[] r8 = r7.getStackTrace();
        int r0 = r8.length;
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L13;
        StackTraceElement r3 = r8[r2];
        if ("android.os.Message".equals(r3.getClassName()) == false) goto L12;
        if ("toString".equals(r3.getMethodName()) == false) goto L12;
        h.c(b(), "Hint OppoMessageNPE case ,fix it.");
        return true;
    L12:
        r2 = r2 + 1;
    L13:
        return false;
    }

    @Override // d.b.p.a.d.i
    public boolean a(Thread r1, Throwable r2) {
        return h(r2);
    }

    @Override // d.b.p.a.g.a
    public String b() {
        return "OppoMessageNPEPlugin";
    }

    @Override // d.b.p.a.g.e
    public boolean g() {
        int r1 = Build.VERSION.SDK_INT;
        if (r1 != 22) goto L5;
    L14:
        if (i.b() == false) goto L17;
        return true;
    L17:
        return false;
    L10:
        th = move-exception;
        th.printStackTrace();
        return false;
    L5:
        if (r1 == 21) goto L14;
        return false;
    }
}
