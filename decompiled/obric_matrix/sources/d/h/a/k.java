package d.h.a;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static Class f17026a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Object f17027b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Field f17028c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Class f17029d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f17030e = false;

    static {
    }

    static String a(View r6) {
        ViewGroup.LayoutParams r0 = r6.getLayoutParams();
        if ((r0 instanceof WindowManager.LayoutParams) == false) goto L21;
        int r1 = ((WindowManager.LayoutParams) r0).type;
        if (r1 != 1) goto L8;
        return "/MainWindow";
    L8:
        if (r1 >= 99) goto L14;
        if (r6.getClass() != f17029d) goto L14;
        return "/DialogWindow";
    L14:
        if (r1 >= 1999) goto L19;
        if (r6.getClass() != f17026a) goto L19;
        return "/PopupWindow";
    L19:
        if (r1 >= 2999) goto L21;
        return "/CustomWindow";
    L21:
        Class<?> r7 = r6.getClass();
        if (r7 != f17029d) goto L25;
        return "/MainWindow";
    L25:
        if (r7 != f17026a) goto L28;
        return "/PopupWindow";
    L28:
        return "/CustomWindow";
    }

    public static void b() {
        int r0 = Build.VERSION.SDK_INT;
        if (f17030e == false) goto L5;
        return;
    L5:
        if (r0 < 17) goto L7;
        String r2 = "android.view.WindowManagerGlobal";
    L45:
        Class<?> r3 = Class.forName(r2);     // Catch: Throwable -> L37
        if (r0 < 17) goto L13;
        String r1 = "sDefaultWindowManager";
    L16:
        f17028c = r3.getDeclaredField("mViews");     // Catch: Throwable -> L37
        Field r4 = r3.getDeclaredField(r1);     // Catch: Throwable -> L37
        f17028c.setAccessible(true);     // Catch: Throwable -> L37
        if (f17028c.getType() == ArrayList.class) goto L20;
        f17028c.getType();     // Catch: Throwable -> L37
    L20:
        r4.setAccessible(true);     // Catch: Throwable -> L37
        f17027b = r4.get(null);     // Catch: Throwable -> L37
        goto L41
    L13:
        if (r0 < 13) goto L15;
        r1 = "sWindowManager";
        goto L16
    L15:
        r1 = "mWindowManager";
    L41:
        Class.forName("com.android.internal.view.menu.ListMenuItemView");     // Catch: Throwable -> L38
        Class.forName("com.android.internal.view.menu.MenuView$ItemView").getDeclaredMethod("getItemData", new Class[0]);     // Catch: Throwable -> L38
    L23:
        if (r0 >= 23) goto L43;
        String r5 = "com.android.internal.policy.impl.PhoneWindow$DecorView";
    L49:
        f17029d = Class.forName(r5);     // Catch: ClassNotFoundException -> L39
    L30:
        if (r0 < 23) goto L33;
        String r6 = "android.widget.PopupWindow$PopupDecorView";
    L47:
        f17026a = Class.forName(r6);     // Catch: ClassNotFoundException -> L40
    L35:
        f17030e = true;
        return;
    L33:
        r6 = "android.widget.PopupWindow$PopupViewContainer";
        goto L47
    L43:
        f17029d = Class.forName("com.android.internal.policy.PhoneWindow$DecorView");     // Catch: ClassNotFoundException -> L26
    L26:
        r5 = "com.android.internal.policy.DecorView";
        goto L49
    L7:
        r2 = "android.view.WindowManagerImpl";
        goto L45
    }

    static boolean c(View r1) {
        if (f17030e == true) goto L5;
        b();
    L5:
        Class<?> r2 = r1.getClass();
        if (r2 != f17029d) goto L8;
    L11:
        return true;
    L8:
        if (r2 == f17026a) goto L11;
        return false;
    }
}
