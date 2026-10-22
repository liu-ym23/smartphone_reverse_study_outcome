package androidx.navigation;

import androidx.annotation.IdRes;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004H\u0086\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0086\u0002\u001a\u0017\u0010\u0007\u001a\u00020\b*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004H\u0086\n\u001a\u0015\u0010\u0007\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0086\n\u001a\u0015\u0010\t\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\bH\u0086\n\u001a\u0015\u0010\f\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\bH\u0086\n\u001a\u0015\u0010\f\u001a\u00020\n*\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0086\n¨\u0006\u000e"}, d2 = {"contains", "", "Landroidx/navigation/NavGraph;", "id", "", "route", "", "get", "Landroidx/navigation/NavDestination;", "minusAssign", "", "node", "plusAssign", "other", "navigation-common_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class NavGraphKt {
    public static final boolean contains(NavGraph r1, @IdRes int r2) {
        o.f(r1, "<this>");
        if (r1.findNode(r2) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean contains(NavGraph r1, String r2) {
        o.f(r1, "<this>");
        o.f(r2, "route");
        if (r1.findNode(r2) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static final NavDestination get(NavGraph r3, @IdRes int r4) {
        o.f(r3, "<this>");
        NavDestination r0 = r3.findNode(r4);
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalArgumentException("No destination for " + r4 + " was found in " + r3);
    }

    public static final NavDestination get(NavGraph r3, String r4) {
        o.f(r3, "<this>");
        o.f(r4, "route");
        NavDestination r0 = r3.findNode(r4);
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalArgumentException("No destination for " + r4 + " was found in " + r3);
    }

    public static final void minusAssign(NavGraph r1, NavDestination r2) {
        o.f(r1, "<this>");
        o.f(r2, "node");
        r1.remove(r2);
    }

    public static final void plusAssign(NavGraph r1, NavDestination r2) {
        o.f(r1, "<this>");
        o.f(r2, "node");
        r1.addDestination(r2);
    }

    public static final void plusAssign(NavGraph r1, NavGraph r2) {
        o.f(r1, "<this>");
        o.f(r2, "other");
        r1.addAll(r2);
    }
}
