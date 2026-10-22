package d.b.p.a.e.i;

import android.os.Build;
import android.view.WindowManager;
import d.b.p.a.d.h;

/* JADX INFO: loaded from: classes.dex */
public class f extends d.b.p.a.g.e {
    public f() {
    }

    private boolean h(Thread r6, Throwable r7) {
        if ((r7 instanceof WindowManager.BadTokenException) == false) goto L15;
        StackTraceElement[] r8 = r7.getStackTrace();
        int r9 = r8.length;
        int r1 = 0;
    L5:
        if (r1 >= r9) goto L15;
        StackTraceElement r2 = r8[r1];
        if (r2 == null) goto L14;
        if ("android.widget.Toast$TN".equals(r2.getClassName()) == false) goto L14;
        if ("handleShow".equals(r2.getMethodName()) == false) goto L14;
        h.c(b(), "Hint ToastBadToken case ,fix it.");
        return true;
    L14:
        r1 = r1 + 1;
    L15:
        return false;
    }

    @Override // d.b.p.a.d.i
    public boolean a(Thread r1, Throwable r2) {
        return h(r1, r2);
    }

    @Override // d.b.p.a.g.a
    public String b() {
        return "ToastBadTokenPlugin";
    }

    @Override // d.b.p.a.g.e
    public boolean g() {
        int r1 = Build.VERSION.SDK_INT;
        if (r1 != 24) goto L5;
        return true;
    L5:
        if (r1 == 25) goto L11;
        return false;
    L11:
        return true;
    }
}
