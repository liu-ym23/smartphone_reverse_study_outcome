package androidx.navigation;

import androidx.annotation.IdRes;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.c.l;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a=\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00042\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\bH\u0087\bø\u0001\u0000\u001a9\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\bH\u0086\bø\u0001\u0000\u001a=\u0010\u0000\u001a\u00020\u000b*\u00020\f2\b\b\u0003\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00042\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\bH\u0087\bø\u0001\u0000\u001a=\u0010\u0000\u001a\u00020\u000b*\u00020\f2\u0006\u0010\u0005\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\bH\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\r"}, d2 = {NotificationCompat.CATEGORY_NAVIGATION, "", "Landroidx/navigation/NavGraphBuilder;", "id", "", "startDestination", "builder", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "", "route", "Landroidx/navigation/NavGraph;", "Landroidx/navigation/NavigatorProvider;", "navigation-common_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class NavGraphBuilderKt {
    public static final NavGraph navigation(NavigatorProvider r1, @IdRes int r2, @IdRes int r3, l<? super NavGraphBuilder, f0> r4) {
        o.f(r1, "<this>");
        o.f(r4, "builder");
        NavGraphBuilder r0 = new NavGraphBuilder(r1, r2, r3);
        r4.invoke(r0);
        return r0.build();
    }

    public static final NavGraph navigation(NavigatorProvider r1, String r2, String r3, l<? super NavGraphBuilder, f0> r4) {
        o.f(r1, "<this>");
        o.f(r2, "startDestination");
        o.f(r4, "builder");
        NavGraphBuilder r0 = new NavGraphBuilder(r1, r2, r3);
        r4.invoke(r0);
        return r0.build();
    }

    public static final void navigation(NavGraphBuilder r2, @IdRes int r3, @IdRes int r4, l<? super NavGraphBuilder, f0> r5) {
        o.f(r2, "<this>");
        o.f(r5, "builder");
        NavGraphBuilder r0 = new NavGraphBuilder(r2.getProvider(), r3, r4);
        r5.invoke(r0);
        r2.destination(r0);
    }

    public static final void navigation(NavGraphBuilder r2, String r3, String r4, l<? super NavGraphBuilder, f0> r5) {
        o.f(r2, "<this>");
        o.f(r3, "startDestination");
        o.f(r4, "route");
        o.f(r5, "builder");
        NavGraphBuilder r0 = new NavGraphBuilder(r2.getProvider(), r3, r4);
        r5.invoke(r0);
        r2.destination(r0);
    }

    public static /* synthetic */ NavGraph navigation$default(NavigatorProvider r0, int r1, int r2, l r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L5;
        r1 = 0;
    L5:
        o.f(r0, "<this>");
        o.f(r3, "builder");
        NavGraphBuilder r6 = new NavGraphBuilder(r0, r1, r2);
        r3.invoke(r6);
        return r6.build();
    }

    public static /* synthetic */ NavGraph navigation$default(NavigatorProvider r0, String r1, String r2, l r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L5;
        r2 = null;
    L5:
        o.f(r0, "<this>");
        o.f(r1, "startDestination");
        o.f(r3, "builder");
        NavGraphBuilder r6 = new NavGraphBuilder(r0, r1, r2);
        r3.invoke(r6);
        return r6.build();
    }
}
