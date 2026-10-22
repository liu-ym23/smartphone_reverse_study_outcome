package androidx.navigation;

import kotlin.Metadata;
import kotlin.n0.c.l;
import kotlin.n0.d.o;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/navigation/NavDestination;", "it", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class NavDestination$Companion$hierarchy$1 extends q implements l<NavDestination, NavDestination> {
    public static final NavDestination$Companion$hierarchy$1 INSTANCE = null;

    static {
        INSTANCE = new NavDestination$Companion$hierarchy$1();
    }

    NavDestination$Companion$hierarchy$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final NavDestination invoke2(NavDestination r1) {
        o.f(r1, "it");
        return r1.getParent();
    }

    @Override // kotlin.n0.c.l
    public /* bridge */ /* synthetic */ NavDestination invoke(NavDestination r1) {
        return invoke2(r1);
    }
}
