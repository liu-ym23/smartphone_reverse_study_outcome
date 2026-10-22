package d.b.p.a.e.i;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import d.b.p.a.d.h;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class e extends d.b.p.a.g.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f14272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f14273b;

    public interface a {
        String a();

        int b();

        List<d.b.p.a.d.c> c();

        void d(d.b.p.a.d.c r1);
    }

    public e(a r1, Context r2) {
        this.f14272a = r1;
        this.f14273b = r2;
        if (r1 == null) goto L7;
        if (r2 == null) goto L7;
        return;
    L7:
        throw new IllegalArgumentException("mConfigFetcher and mContext can not be null.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1, types: [int] */
    /* JADX WARN: Type inference failed for: r14v3 */
    @Override // d.b.p.a.d.i
    public boolean a(Thread r17, Throwable r18) {
        a r1 = this.f14272a;
        boolean r2 = false;
        if (r1 != null) goto L5;
        return false;
    L5:
        List<d.b.p.a.d.c> r3 = r1.c();
        if (r3 != null) goto L8;
    L71:
        return r2;
    L8:
        if (r3.isEmpty() == true) goto L71;
        String r4 = this.f14272a.a();
        int r5 = this.f14272a.b();
        int r6 = Build.VERSION.SDK_INT;
        String r7 = r17.getName();
        String r8 = d.b.p.a.h.g.b(this.f14273b);
        Iterator<d.b.p.a.d.c> r9 = r3.iterator();
    L12:
        if (r9.hasNext() == false) goto L71;
        d.b.p.a.d.c r10 = r9.next();
        if (TextUtils.isEmpty(r10.f14238e) == true) goto L18;
        if (r10.f14238e.equalsIgnoreCase(r4) == false) goto L12;
    L18:
        int r11 = r10.f14239f;
        if (r11 <= 0) goto L22;
        if (r11 != r5) goto L12;
    L22:
        int r12 = r10.f14242i;
        if (r12 <= 0) goto L27;
        if (r6 != r12) goto L12;
    L27:
        if (TextUtils.isEmpty(r10.f14237d) == true) goto L32;
        if (r10.f14237d.equalsIgnoreCase(r7) == false) goto L12;
    L32:
        if (TextUtils.isEmpty(r10.f14234a) == true) goto L37;
        if (r10.f14234a.equalsIgnoreCase(r8) == false) goto L12;
    L37:
        if (TextUtils.isEmpty(r10.f14240g) == true) goto L42;
        if (r10.f14240g.equalsIgnoreCase(r18.getMessage()) == false) goto L12;
    L42:
        if (TextUtils.isEmpty(r10.f14241h) == true) goto L47;
        if (r10.f14241h.equalsIgnoreCase(r18.getClass().getName()) == false) goto L12;
    L47:
        if (TextUtils.isEmpty(r10.f14235b) == false) goto L53;
        if (TextUtils.isEmpty(r10.f14236c) == false) goto L53;
        h.c("CloudUntExPlugin", "Hint crash," + r10);
        this.f14272a.d(r10);
        return true;
    L53:
        if (TextUtils.isEmpty(r10.f14235b) == false) goto L55;
    L56:
        h.c("CloudUntExPlugin", r10.f14235b + "." + r10.f14236c + " does not match.");
    L57:
        StackTraceElement[] r13 = r18.getStackTrace();
        int r14 = r13.length;
        ?? r15 = r2;
    L58:
        if (r15 >= r14) goto L12;
        StackTraceElement r16 = r13[r15];
        if (TextUtils.isEmpty(r10.f14235b) == true) goto L65;
        if (r10.f14235b.equalsIgnoreCase(r16.getClassName()) == true) goto L65;
    L68:
        r2 = false;
        r15 = r15 + 1;
    L65:
        if (TextUtils.isEmpty(r10.f14236c) == true) goto L69;
        if (r10.f14236c.equalsIgnoreCase(r16.getMethodName()) == false) goto L68;
    L69:
        h.c("CloudUntExPlugin", "Hint crash," + r10);
        this.f14272a.d(r10);
        return true;
    L55:
        if (TextUtils.isEmpty(r10.f14236c) == false) goto L57;
        goto L56
    }

    @Override // d.b.p.a.g.a
    public String b() {
        return "CloudUncaughtExceptionCatcher";
    }

    @Override // d.b.p.a.g.e
    public boolean g() {
        return true;
    }
}
