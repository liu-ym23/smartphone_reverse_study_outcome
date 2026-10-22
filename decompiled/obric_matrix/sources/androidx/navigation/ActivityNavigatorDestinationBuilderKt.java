package androidx.navigation;

import androidx.annotation.IdRes;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.c.l;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a3\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\bH\u0087\bø\u0001\u0000\u001a1\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\bH\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000b"}, d2 = {"activity", "", "Landroidx/navigation/NavGraphBuilder;", "id", "", "builder", "Lkotlin/Function1;", "Landroidx/navigation/ActivityNavigatorDestinationBuilder;", "Lkotlin/ExtensionFunctionType;", "route", "", "navigation-runtime_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ActivityNavigatorDestinationBuilderKt {
    public static final void activity(NavGraphBuilder r3, @IdRes int r4, l<? super ActivityNavigatorDestinationBuilder, f0> r5) {
        o.f(r3, "<this>");
        o.f(r5, "builder");
        ActivityNavigatorDestinationBuilder r0 = new ActivityNavigatorDestinationBuilder((ActivityNavigator) r3.getProvider().getNavigator(ActivityNavigator.class), r4);
        r5.invoke(r0);
        r3.destination(r0);
    }

    public static final void activity(NavGraphBuilder r3, String r4, l<? super ActivityNavigatorDestinationBuilder, f0> r5) {
        o.f(r3, "<this>");
        o.f(r4, "route");
        o.f(r5, "builder");
        ActivityNavigatorDestinationBuilder r0 = new ActivityNavigatorDestinationBuilder((ActivityNavigator) r3.getProvider().getNavigator(ActivityNavigator.class), r4);
        r5.invoke(r0);
        r3.destination(r0);
    }
}
