package d.g.d.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.WindowInsetsController;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f16942a = null;

    static {
        f16942a = new a();
    }

    private a() {
    }

    @RequiresApi(30)
    @SuppressLint({"BlockedPrivateApi", "PrivateApi"})
    public final int a(View r8) {
        o.f(r8, "rootView");
        WindowInsetsController r9 = r8.getWindowInsetsController();     // Catch: Exception -> L33
        if (r9 == null) goto L38;
        o.e(r9, "rootView.windowInsetsController ?: return 0");     // Catch: Exception -> L33
        Method r0 = r9.getClass().getDeclaredMethod("getState", new Class[0]);     // Catch: Exception -> L33
        o.e(r0, "getStateMethod");     // Catch: Exception -> L33
        r0.setAccessible(true);     // Catch: Exception -> L33
        Object r10 = r0.invoke(r9, new Object[0]);     // Catch: Exception -> L33
        int r1 = Build.VERSION.SDK_INT;     // Catch: Exception -> L33
        if (r1 < 35) goto L9;
        String r3 = "android.view.InsetsSource";
    L8:
        Class<?> r4 = Class.forName(r3);     // Catch: Exception -> L33
        if (r1 < 35) goto L13;
        String r2 = "ID_IME";
    L12:
        Field r5 = r4.getDeclaredField(r2);     // Catch: Exception -> L33
        o.e(r5, "insetField");     // Catch: Exception -> L33
        r5.setAccessible(true);     // Catch: Exception -> L33
        Object r6 = null;
        int r7 = r5.getInt(null);     // Catch: Exception -> L33
        Method r11 = r10.getClass().getDeclaredMethod("peekSource", new Class[]{Integer.TYPE});     // Catch: Exception -> L33
        o.e(r11, "peekSourceMethod");     // Catch: Exception -> L33
        r11.setAccessible(true);     // Catch: Exception -> L33
        Object r12 = r11.invoke(r10, new Object[]{Integer.valueOf(r7)});     // Catch: Exception -> L33
        if ((r12 instanceof Object) == true) goto L17;
        r12 = null;
    L17:
        if (r12 == null) goto L39;
        Method r13 = r12.getClass().getDeclaredMethod("isVisible", new Class[0]);     // Catch: Exception -> L33
        o.e(r13, "isVisibleMethod");     // Catch: Exception -> L33
        r13.setAccessible(true);     // Catch: Exception -> L33
        Object r14 = r13.invoke(r12, new Object[0]);     // Catch: Exception -> L33
        if ((r14 instanceof Boolean) == true) goto L21;
        r14 = null;
    L21:
        Boolean r15 = (Boolean) r14;     // Catch: Exception -> L33
        if (r15 != null) goto L24;
        return 0;
    L24:
        if (r15.booleanValue() == false) goto L35;
        Method r16 = r12.getClass().getDeclaredMethod("getFrame", new Class[0]);     // Catch: Exception -> L33
        o.e(r16, "getFrameMethod");     // Catch: Exception -> L33
        r16.setAccessible(true);     // Catch: Exception -> L33
        Object r17 = r16.invoke(r12, new Object[0]);     // Catch: Exception -> L33
        if ((r17 instanceof Rect) == false) goto L29;
        r6 = r17;
    L29:
        Rect r18 = (Rect) r6;     // Catch: Exception -> L33
        if (r18 == null) goto L41;
        return r18.height();
    L41:
        return 0;
    L35:
        return 0;
    L39:
        return 0;
    L13:
        r2 = "ITYPE_IME";
        goto L12
    L9:
        r3 = "android.view.InsetsState";
        goto L8
    L38:
        return 0;
    L33:
        e = move-exception;
        e.printStackTrace();
        goto L35
    }

    public final int b(Context r5) {
        if (r5 != null) goto L5;
        return 0;
    L5:
        int r0 = r5.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (r0 > 0) goto L8;
        Class<?> r1 = Class.forName("com.android.internal.R$dimen");     // Catch: Exception -> L11
        Object r2 = r1.newInstance();     // Catch: Exception -> L11
        int r3 = Integer.parseInt(r1.getField("navigation_bar_height").get(r2).toString());     // Catch: Exception -> L11
        return r5.getResources().getDimensionPixelSize(r3);
    L14:
        return 0;
    L8:
        return r5.getResources().getDimensionPixelSize(r0);
    }
}
