package d.h.a;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static boolean f16977a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Class f16978b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Method f16979c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f16980d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f16981e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f16982f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f16983g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static boolean f16984h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static boolean f16985i;

    static {
        f16980d = a("androidx.recyclerview.widget.RecyclerView");
        f16981e = a("androidx.viewpager.widget.ViewPager");
        f16982f = a("androidx.swiperefreshlayout.widget.SwipeRefreshLayout");
        a("androidx.fragment.app.Fragment");
        a("androidx.fragment.app.FragmentActivity");
        a("androidx.appcompat.app.AlertDialog");
        a("androidx.appcompat.view.menu.ListMenuItemView");
        f16983g = a("androidx.recyclerview.widget.RecyclerView");
        f16984h = a("androidx.viewpager.widget.ViewPager");
        f16985i = a("androidx.swiperefreshlayout.widget.SwipeRefreshLayout");
        a("androidx.fragment.app.Fragment");
        a("androidx.fragment.app.FragmentActivity");
        a("androidx.appcompat.app.AlertDialog");
        a("androidx.appcompat.view.menu.ListMenuItemView");
    }

    private static boolean a(String r0) {
        Class.forName(r0);     // Catch: Throwable -> L5
        return true;
    L5:
        return false;
    }

    static boolean b(Object r1) {
        if (f16983g == true) goto L5;
    L7:
        return false;
    L5:
        if ((r1 instanceof RecyclerView) == false) goto L7;
        return true;
    }

    static boolean c(Object r1) {
        if (f16984h == true) goto L5;
    L7:
        return false;
    L5:
        if ((r1 instanceof ViewPager) == false) goto L7;
        return true;
    }

    static boolean d(Object r1) {
        if (b(r1) == false) goto L5;
    L13:
        return true;
    L5:
        if (e(r1) == true) goto L13;
        if (f16977a == false) goto L12;
        if (r1 == null) goto L12;
        if (f16978b.isAssignableFrom(r1.getClass()) == true) goto L13;
    L12:
        return false;
    }

    static boolean e(Object r1) {
        if (f16980d == true) goto L5;
    L7:
        return false;
    L5:
        if ((r1 instanceof RecyclerView) == false) goto L7;
        return true;
    }

    static boolean f(Object r1) {
        if (f16982f == true) goto L5;
    L7:
        return false;
    L5:
        if ((r1 instanceof SwipeRefreshLayout) == false) goto L7;
        return true;
    }

    static boolean g(Object r1) {
        if (f16981e == true) goto L5;
    L7:
        return false;
    L5:
        if ((r1 instanceof ViewPager) == false) goto L7;
        return true;
    }

    static boolean h(Object r1) {
        if (f16985i == true) goto L5;
    L7:
        return false;
    L5:
        if ((r1 instanceof SwipeRefreshLayout) == false) goto L7;
        return true;
    }

    static int i(View r3, View r4) {
        if (r3.getClass() != f16978b) goto L6;
        return ((Integer) f16979c.invoke(r3, new Object[]{r4})).intValue();
    L6:
        return -1;
    L11:
        return -1;
    }
}
