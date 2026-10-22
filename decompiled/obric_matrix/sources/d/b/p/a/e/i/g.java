package d.b.p.a.e.i;

import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public class g extends d.b.p.a.g.e {
    public g() {
    }

    private boolean h(Thread r6, Throwable r7) {
        if ((r7 instanceof IllegalStateException) == false) goto L17;
        StackTraceElement[] r5 = r7.getStackTrace();
        int r0 = r5.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L17;
        StackTraceElement r2 = r5[r1];
        if (r2 == null) goto L16;
        if ("android.app.ActivityThread".equals(r2.getClassName()) == false) goto L16;
        if ("handleTopResumedActivityChanged".equals(r2.getMethodName()) == false) goto L16;
        if ("Activity top position already set to onTop=false".equals(r7.getMessage()) == false) goto L16;
        return true;
    L16:
        r1 = r1 + 1;
    L17:
        return false;
    }

    @Override // d.b.p.a.d.i
    public boolean a(Thread r1, Throwable r2) {
        return h(r1, r2);
    }

    @Override // d.b.p.a.g.a
    public String b() {
        return "TopResumedActivityPlugin";
    }

    @Override // d.b.p.a.g.e
    public boolean g() {
        if (Build.VERSION.SDK_INT != 29) goto L5;
        return true;
    L5:
        return false;
    }
}
