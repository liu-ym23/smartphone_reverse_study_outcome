package tmsdkobf;

import android.os.Handler;
import android.os.Message;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes5.dex */
public class mi implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler.Callback f354a;
    public final pj b;
    public final String c;

    public mi(Handler.Callback r1, pj r2, String r3) {
        this.f354a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final boolean a(Message r8) {
        Object r7 = r8.obj;
        if (r7 != null) goto L5;
        return false;
    L5:
        Object r9 = sf.a(r7.getClass(), "argi3", r8.obj);
        if ((r9 instanceof Integer) == true) goto L8;
        return false;
    L8:
        Object r10 = sf.a(r8.obj.getClass(), "arg1", r8.obj);
        if (r10 != null) goto L11;
        return false;
    L11:
        Class<?> r1 = r10.getClass();
        Class[] r4 = {Boolean.TYPE, Integer.TYPE};
        Object[] r3 = {Boolean.FALSE, r9};
        Method r11 = sf.a(r1, "setPerformAccessibilityActionResult", r4);     // Catch: Throwable -> L17
        if (r11 == null) goto L19;
        r11.invoke(r10, r3);     // Catch: Throwable -> L17
    L19:
        return true;
    L17:
        th = move-exception;
        th.printStackTrace();
        goto L19
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r6) {
        if (r6.what != 1) goto L14;
        pj r1 = this.b;     // Catch: Throwable -> L19
        String r3 = this.c;     // Catch: Throwable -> L19
        wk.a r2 = (wk.a) r1;     // Catch: Throwable -> L19
        if (r2.f607a.get() == true) goto L10;
        r2.b.obtainMessage(1, r3).sendToTarget();     // Catch: Throwable -> L19
    L10:
        if (qh.f454a.get() == false) goto L14;
        if (a(r6) == false) goto L14;
        return true;
    L14:
        Handler.Callback r5 = this.f354a;     // Catch: Throwable -> L19
        if (r5 == null) goto L18;
        return r5.handleMessage(r6);
    L18:
        return false;
    }
}
