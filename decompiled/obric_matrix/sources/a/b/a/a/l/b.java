package a.b.a.a.l;

import android.util.Log;
import com.bytedance.lego.init.InitScheduler;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f72a = null;

    static {
        f72a = new b();
    }

    public b() {
    }

    public static /* synthetic */ void a(b r0, String r1, String r2, int r3) {
        if ((r3 & 1) == 0) goto L5;
        r1 = "";
    L5:
        r0.b(r1, r2);
    }

    public static /* synthetic */ void c(b r0, String r1, String r2, int r3) {
        if ((r3 & 1) == 0) goto L5;
        r1 = "";
    L5:
        r0.d(r1, r2);
    }

    public static /* synthetic */ void e(b r0, String r1, String r2, int r3) {
        if ((r3 & 1) == 0) goto L5;
        r1 = "";
    L5:
        r0.f(r1, r2);
    }

    public final void b(String r10, String r11) {
        o.g(r10, "classname");
        o.g(r11, "message");
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == true) goto L5;
        return;
    L5:
        String r9 = b.a.a.a.a.b(r10, ' ', r11);
        int r12 = r9.length();
        int r13 = 0;
        int r0 = 3072;
        int r8 = 1;
    L6:
        int r1 = r13;
        r13 = r0;
        if (r8 > 100) goto L15;
        if (r12 <= r13) goto L11;
        r0 = b.a.a.a.a.a(r9, r1, r13, "(this as java.lang.Strin…ing(startIndex, endIndex)", b.a.a.a.a.c("#inittask#", r8), r13, 3072);
        r8 = r8 + 1;
        goto L6
    L11:
        b.a.a.a.a.f(r9, r1, r12, "(this as java.lang.Strin…ing(startIndex, endIndex)", b.a.a.a.a.c("#inittask#", r8));
        return;
    }

    public final void d(String r1, String r2) {
        o.g(r1, "classname");
        o.g(r2, "message");
        Log.e("#inittask#", r1 + ' ' + r2);
    }

    public final void f(String r7, String r8) {
        o.g(r7, "classname");
        o.g(r8, "message");
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == true) goto L5;
        return;
    L5:
        String r6 = b.a.a.a.a.b(r7, ' ', r8);
        int r9 = r6.length();
        int r1 = 0;
        int r10 = 3072;
        int r2 = 1;
    L6:
        if (r2 > 100) goto L14;
        if (r9 <= r10) goto L10;
        String r4 = b.a.a.a.a.c("#inittask#", r2);
        String r3 = r6.substring(r1, r10);
        o.b(r3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        Log.v(r4, r3);
        r2 = r2 + 1;
        r1 = r10;
        r10 = r10 + 3072;
        goto L6
    L10:
        String r11 = b.a.a.a.a.c("#inittask#", r2);
        String r12 = r6.substring(r1, r9);
        o.b(r12, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        Log.v(r11, r12);
        return;
    }
}
