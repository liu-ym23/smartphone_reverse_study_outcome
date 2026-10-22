package d.b.p.a.f.a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import d.b.p.a.d.h;
import d.b.p.a.h.g;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d.b.p.a.f.a.e.b f14280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private d.b.p.a.f.a.e.a f14281b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f14282c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Context f14283d;

    public d(d.b.p.a.f.a.e.b r1, d.b.p.a.f.a.e.a r2, int r3, Context r4) {
        if (r1 == null) goto L9;
        if (r2 == null) goto L9;
        if (r3 <= 0) goto L9;
        this.f14280a = r1;
        this.f14281b = r2;
        this.f14282c = r3;
        this.f14283d = r4;
        return;
    L9:
        throw new IllegalArgumentException("crashPortrait or crashHandler or serialCrashCount is illegal!");
    }

    private boolean a(Throwable r7, Thread r8, int r9) {
        if (r9 >= this.f14282c) goto L5;
        return false;
    L5:
        d.b.p.a.f.a.e.b r10 = this.f14280a;
        int r0 = r10.f14291g;
        if (r0 <= 0) goto L11;
        if (Build.VERSION.SDK_INT == r0) goto L11;
        return false;
    L11:
        if (TextUtils.isEmpty(r10.f14288d) == true) goto L16;
        if (this.f14280a.f14288d.equalsIgnoreCase(r8.getName()) == true) goto L16;
        return false;
    L16:
        if (TextUtils.isEmpty(this.f14280a.f14285a) == true) goto L21;
        if (this.f14280a.f14285a.equalsIgnoreCase(g.b(this.f14283d)) == true) goto L21;
        return false;
    L21:
        if (TextUtils.isEmpty(this.f14280a.f14289e) == true) goto L26;
        if (this.f14280a.f14289e.equalsIgnoreCase(r7.getMessage()) == true) goto L26;
        return false;
    L26:
        if (TextUtils.isEmpty(this.f14280a.f14290f) == true) goto L31;
        if (this.f14280a.f14290f.equalsIgnoreCase(r7.getClass().getName()) == true) goto L31;
        return false;
    L31:
        if (TextUtils.isEmpty(this.f14280a.f14286b) == false) goto L38;
        if (TextUtils.isEmpty(this.f14280a.f14287c) == false) goto L38;
        StringBuilder r11 = new StringBuilder();
        String r12 = "Hint crash,";
    L35:
        r11.append(r12);
        r11.append(this.f14280a);
        h.c("CloudUntExPlugin", r11.toString());
        return true;
    L38:
        if (TextUtils.isEmpty(this.f14280a.f14286b) == false) goto L40;
    L41:
        h.c("CloudUntExPlugin", this.f14280a.f14286b + "." + this.f14280a.f14287c + " does not match.");
    L42:
        StackTraceElement[] r13 = r7.getStackTrace();
        int r14 = r13.length;
        int r2 = 0;
    L43:
        if (r2 >= r14) goto L55;
        StackTraceElement r3 = r13[r2];
        if (TextUtils.isEmpty(this.f14280a.f14286b) == true) goto L50;
        if (this.f14280a.f14286b.equalsIgnoreCase(r3.getClassName()) == true) goto L50;
    L53:
        r2 = r2 + 1;
    L50:
        if (TextUtils.isEmpty(this.f14280a.f14287c) == true) goto L54;
        if (this.f14280a.f14287c.equalsIgnoreCase(r3.getMethodName()) == false) goto L53;
    L54:
        r11 = new StringBuilder();
        r12 = "Hint crash,and allow to fix crash:";
        goto L35
    L55:
        return false;
    L40:
        if (TextUtils.isEmpty(this.f14280a.f14287c) == false) goto L42;
        goto L41
    }

    public boolean b(Throwable r1, Thread r2, int r3) {
        if (a(r1, r2, r3) == false) goto L6;
        this.f14281b.b(this.f14283d);
        return true;
    L6:
        return false;
    }
}
