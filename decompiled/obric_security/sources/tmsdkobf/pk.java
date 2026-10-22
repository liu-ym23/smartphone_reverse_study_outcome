package tmsdkobf;

import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes5.dex */
public class pk implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Window f423a;
    public final /* synthetic */ pj b;
    public final /* synthetic */ String c;

    public pk(Window r1, pj r2, String r3) {
        this.f423a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        View r1 = this.f423a.getDecorView();     // Catch: Throwable -> L29
        r1.getViewTreeObserver().removeOnPreDrawListener(this);     // Catch: Throwable -> L29
        Object r2 = null;
        Method r3 = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);     // Catch: Throwable -> L7
        r3.setAccessible(true);     // Catch: Throwable -> L7
        Object r4 = r3.invoke(r1, new Object[0]);     // Catch: Throwable -> L7
    L8:
        if (r4 != null) goto L34;
        return true;
    L34:
        Method r5 = sf.a(r4.getClass(), "getAccessibilityInteractionController", null);     // Catch: Throwable -> L16
        if (r5 == null) goto L18;
        r2 = r5.invoke(r4, null);     // Catch: Throwable -> L16
    L18:
        if (r2 != null) goto L20;
        return true;
    L20:
        Object r6 = sf.a(r2.getClass(), "mHandler", r2);     // Catch: Throwable -> L29
        if (r6 != null) goto L23;
        return true;
    L23:
        Field r7 = Handler.class.getDeclaredField("mCallback");     // Catch: Throwable -> L29
        r7.setAccessible(true);     // Catch: Throwable -> L29
        Handler.Callback r8 = (Handler.Callback) r7.get(r6);     // Catch: Throwable -> L29
        if ((r8 instanceof mi) == false) goto L27;
        return true;
    L27:
        r7.set(r6, new mi(r8, this.b, this.c));     // Catch: Throwable -> L29
    L16:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L29
    L7:
        r4 = null;
    L28:
        return true;
    }
}
