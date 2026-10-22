package androidx.navigation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.IdRes;
import androidx.core.app.ActivityCompat;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.n0.c.l;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.t0.k;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u001e\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH\u0007J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\bH\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\fH\u0007¨\u0006\u0017"}, d2 = {"Landroidx/navigation/Navigation;", "", "()V", "createNavigateOnClickListener", "Landroid/view/View$OnClickListener;", "directions", "Landroidx/navigation/NavDirections;", "resId", "", "args", "Landroid/os/Bundle;", "findNavController", "Landroidx/navigation/NavController;", "activity", "Landroid/app/Activity;", "viewId", "view", "Landroid/view/View;", "findViewNavController", "getViewNavController", "setViewNavController", "", "controller", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Navigation {
    public static final Navigation INSTANCE = null;

    /* JADX INFO: renamed from: androidx.navigation.Navigation$findViewNavController$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/view/View;", "it", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class AnonymousClass1 extends q implements l<View, View> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        AnonymousClass1() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final View invoke2(View r1) {
            o.f(r1, "it");
            Object r0 = r1.getParent();
            if ((r0 instanceof View) == true) goto L7;
            return null;
        L7:
            return (View) r0;
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ View invoke(View r1) {
            return invoke2(r1);
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.Navigation$findViewNavController$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/navigation/NavController;", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class AnonymousClass2 extends q implements l<View, NavController> {
        public static final AnonymousClass2 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass2();
        }

        AnonymousClass2() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final NavController invoke2(View r1) {
            o.f(r1, "it");
            return Navigation.access$getViewNavController(Navigation.INSTANCE, r1);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ NavController invoke(View r1) {
            return invoke2(r1);
        }
    }

    static {
        INSTANCE = new Navigation();
    }

    private Navigation() {
    }

    public static /* synthetic */ void a(NavDirections r0, View r1) {
        m33createNavigateOnClickListener$lambda1(r0, r1);
    }

    public static final /* synthetic */ NavController access$getViewNavController(Navigation r0, View r1) {
        return r0.getViewNavController(r1);
    }

    public static /* synthetic */ void b(int r0, Bundle r1, View r2) {
        m32createNavigateOnClickListener$lambda0(r0, r1, r2);
    }

    public static final View.OnClickListener createNavigateOnClickListener(@IdRes int r2) {
        return createNavigateOnClickListener$default(r2, null, 2, null);
    }

    public static final View.OnClickListener createNavigateOnClickListener(@IdRes final int r1, final Bundle r2) {
        return new c(r1, r2);
    }

    public static final View.OnClickListener createNavigateOnClickListener(final NavDirections r1) {
        o.f(r1, "directions");
        return new b(r1);
    }

    public static /* synthetic */ View.OnClickListener createNavigateOnClickListener$default(int r0, Bundle r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L6;
        r1 = null;
    L6:
        return createNavigateOnClickListener(r0, r1);
    }

    /* JADX INFO: renamed from: createNavigateOnClickListener$lambda-0, reason: not valid java name */
    private static final void m32createNavigateOnClickListener$lambda0(int r1, Bundle r2, View r3) {
        o.e(r3, "view");
        findNavController(r3).navigate(r1, r2);
    }

    /* JADX INFO: renamed from: createNavigateOnClickListener$lambda-1, reason: not valid java name */
    private static final void m33createNavigateOnClickListener$lambda1(NavDirections r1, View r2) {
        o.f(r1, "$directions");
        o.e(r2, "view");
        findNavController(r2).navigate(r1);
    }

    public static final NavController findNavController(Activity r3, @IdRes int r4) {
        o.f(r3, "activity");
        View r0 = ActivityCompat.requireViewById(r3, r4);
        o.e(r0, "requireViewById<View>(activity, viewId)");
        NavController r1 = INSTANCE.findViewNavController(r0);
        if (r1 == null) goto L6;
        return r1;
    L6:
        throw new IllegalStateException("Activity " + r3 + " does not have a NavController set on " + r4);
    }

    public static final NavController findNavController(View r3) {
        o.f(r3, "view");
        NavController r0 = INSTANCE.findViewNavController(r3);
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("View " + r3 + " does not have a NavController set");
    }

    private final NavController findViewNavController(View r1) {
        return (NavController) k.q(k.u(k.h(r1, AnonymousClass1.INSTANCE), AnonymousClass2.INSTANCE));
    }

    private final NavController getViewNavController(View r1) {
        Object r0 = r1.getTag(R.id.nav_controller_view_tag);
        if ((r0 instanceof WeakReference) == false) goto L7;
        r0 = ((WeakReference) r0).get();
    L11:
        return (NavController) r0;
    L7:
        if ((r0 instanceof NavController) == true) goto L11;
        return null;
    }

    public static final void setViewNavController(View r1, NavController r2) {
        o.f(r1, "view");
        r1.setTag(R.id.nav_controller_view_tag, r2);
    }
}
