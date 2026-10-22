package androidx.navigation;

import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.i0.r;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Navigator.Name(NotificationCompat.CATEGORY_NAVIGATION)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0002H\u0016J$\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J*\u0010\u0007\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Landroidx/navigation/NavGraphNavigator;", "Landroidx/navigation/Navigator;", "Landroidx/navigation/NavGraph;", "navigatorProvider", "Landroidx/navigation/NavigatorProvider;", "(Landroidx/navigation/NavigatorProvider;)V", "createDestination", "navigate", "", "entry", "Landroidx/navigation/NavBackStackEntry;", "navOptions", "Landroidx/navigation/NavOptions;", "navigatorExtras", "Landroidx/navigation/Navigator$Extras;", "entries", "", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class NavGraphNavigator extends Navigator<NavGraph> {
    private final NavigatorProvider navigatorProvider;

    public NavGraphNavigator(NavigatorProvider r2) {
        o.f(r2, "navigatorProvider");
        this.navigatorProvider = r2;
    }

    private final void navigate(NavBackStackEntry r6, NavOptions r7, Navigator.Extras r8) {
        NavGraph r0 = (NavGraph) r6.getDestination();
        Bundle r9 = r6.getArguments();
        int r1 = r0.getStartDestinationId();
        String r2 = r0.getStartDestinationRoute();
        if (r1 != 0) goto L7;
        if (r2 != null) goto L7;
        boolean r4 = false;
    L8:
        if (r4 == false) goto L18;
        if (r2 == null) goto L11;
        NavDestination r3 = r0.findNode(r2, false);
    L12:
        if (r3 == null) goto L16;
        this.navigatorProvider.getNavigator(r3.getNavigatorName()).navigate(r.d(getState().createBackStackEntry(r3, r3.addInDefaultArgs(r9))), r7, r8);
        return;
    L16:
        throw new IllegalArgumentException("navigation destination " + r0.getStartDestDisplayName() + " is not a direct child of this NavGraph");
    L11:
        r3 = r0.findNode(r1, false);
        goto L12
    L18:
        throw new IllegalStateException(("no start destination defined via app:startDestination for " + r0.getDisplayName()).toString());
    L7:
        r4 = true;
        goto L8
    }

    @Override // androidx.navigation.Navigator
    public /* bridge */ /* synthetic */ NavDestination createDestination() {
        return createDestination();
    }

    @Override // androidx.navigation.Navigator
    public NavGraph createDestination() {
        return new NavGraph(this);
    }

    @Override // androidx.navigation.Navigator
    public void navigate(List<NavBackStackEntry> r2, NavOptions r3, Navigator.Extras r4) {
        o.f(r2, "entries");
        Iterator<NavBackStackEntry> r5 = r2.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        navigate(r5.next(), r3, r4);
        goto L4
    }
}
