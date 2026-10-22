package androidx.navigation;

import androidx.annotation.IdRes;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.c.l;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a=\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0003\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00042\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0087\bø\u0001\u0000\u001a=\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\r"}, d2 = {"createGraph", "Landroidx/navigation/NavGraph;", "Landroidx/navigation/NavHost;", "id", "", "startDestination", "builder", "Lkotlin/Function1;", "Landroidx/navigation/NavGraphBuilder;", "", "Lkotlin/ExtensionFunctionType;", "", "route", "navigation-runtime_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class NavHostKt {
    public static final NavGraph createGraph(NavHost r1, @IdRes int r2, @IdRes int r3, l<? super NavGraphBuilder, f0> r4) {
        o.f(r1, "<this>");
        o.f(r4, "builder");
        NavGraphBuilder r0 = new NavGraphBuilder(r1.getNavController().getNavigatorProvider(), r2, r3);
        r4.invoke(r0);
        return r0.build();
    }

    public static final NavGraph createGraph(NavHost r1, String r2, String r3, l<? super NavGraphBuilder, f0> r4) {
        o.f(r1, "<this>");
        o.f(r2, "startDestination");
        o.f(r4, "builder");
        NavGraphBuilder r0 = new NavGraphBuilder(r1.getNavController().getNavigatorProvider(), r2, r3);
        r4.invoke(r0);
        return r0.build();
    }

    public static /* synthetic */ NavGraph createGraph$default(NavHost r0, int r1, int r2, l r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L5;
        r1 = 0;
    L5:
        o.f(r0, "<this>");
        o.f(r3, "builder");
        NavGraphBuilder r6 = new NavGraphBuilder(r0.getNavController().getNavigatorProvider(), r1, r2);
        r3.invoke(r6);
        return r6.build();
    }

    public static /* synthetic */ NavGraph createGraph$default(NavHost r0, String r1, String r2, l r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L5;
        r2 = null;
    L5:
        o.f(r0, "<this>");
        o.f(r1, "startDestination");
        o.f(r3, "builder");
        NavGraphBuilder r6 = new NavGraphBuilder(r0.getNavController().getNavigatorProvider(), r1, r2);
        r3.invoke(r6);
        return r6.build();
    }
}
