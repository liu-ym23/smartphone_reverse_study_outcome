package d.b.p.a.e.i;

import android.os.Build;
import android.view.WindowManager;
import d.b.p.a.d.h;

/* JADX INFO: loaded from: classes.dex */
public class b extends d.b.p.a.g.e {
    public b() {
    }

    private boolean h(Throwable r7) {
        if ((r7 instanceof WindowManager.BadTokenException) == false) goto L13;
        StackTraceElement[] r8 = r7.getStackTrace();
        int r0 = r8.length;
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L13;
        StackTraceElement r3 = r8[r2];
        if ("android.webkit.JsDialogHelper".equals(r3.getClassName()) == false) goto L12;
        if ("showDialog".equals(r3.getMethodName()) == false) goto L12;
        h.c(b(), "Hint JsDialogBadToken case ,fix it.");
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
        return "JsDialogBadTokenPlugin";
    }

    @Override // d.b.p.a.g.e
    public boolean g() {
        int r1 = Build.VERSION.SDK_INT;
        if (r1 != 24) goto L5;
        return true;
    L5:
        if (r1 != 25) goto L7;
        return true;
    L7:
        if (r1 != 26) goto L9;
        return true;
    L9:
        if (r1 == 27) goto L17;
        return false;
    L17:
        return true;
    }
}
