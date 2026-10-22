package d.b.p.a.e.i;

import android.os.Build;
import d.b.p.a.d.h;
import d.b.p.a.h.i;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class d extends d.b.p.a.g.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Set<Integer> f14271a;

    static {
        HashSet r0 = new HashSet();
        f14271a = r0;
        r0.add(23);
        f14271a.add(24);
        f14271a.add(25);
    }

    public d() {
    }

    @Override // d.b.p.a.d.i
    public boolean a(Thread r3, Throwable r4) {
        if ((r4 instanceof NullPointerException) == false) goto L12;
        StackTraceElement[] r5 = r4.getStackTrace();
        if (r5.length <= 0) goto L12;
        StackTraceElement r6 = r5[0];
        if ("android.app.ActivityThread".equals(r6.getClassName()) == false) goto L12;
        if ("handleStopActivity".equals(r6.getMethodName()) == false) goto L12;
        h.c(b(), "Hint StopActivityNPE case ,fix it.");
        return true;
    L12:
        return false;
    }

    @Override // d.b.p.a.g.a
    public String b() {
        return "StopActivityNPEPlugin";
    }

    @Override // d.b.p.a.g.e
    public boolean g() {
        if (f14271a.contains(Integer.valueOf(Build.VERSION.SDK_INT)) == true) goto L5;
        return false;
    L5:
        String r3 = Build.MODEL;
        if (r3.startsWith("GIONEE") == false) goto L9;
        return true;
    L9:
        if (r3.startsWith("Funtouch") == false) goto L12;
        return true;
    L12:
        if (r3.startsWith("coloros_V3.0") == false) goto L15;
        return true;
    L15:
        if (i.a() == false) goto L17;
        return true;
    L17:
        return false;
    }
}
