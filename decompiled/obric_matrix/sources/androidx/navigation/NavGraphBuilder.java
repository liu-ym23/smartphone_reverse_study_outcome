package androidx.navigation;

import androidx.annotation.IdRes;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@NavDestinationDsl
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000eJ\b\u0010\u0016\u001a\u00020\u0002H\u0016J\u001e\u0010\u0015\u001a\u00020\u0014\"\b\b\u0000\u0010\u0017*\u00020\u000e2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u0001J\r\u0010\u0019\u001a\u00020\u0014*\u00020\u000eH\u0086\u0002R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Landroidx/navigation/NavGraphBuilder;", "Landroidx/navigation/NavDestinationBuilder;", "Landroidx/navigation/NavGraph;", "provider", "Landroidx/navigation/NavigatorProvider;", "id", "", "startDestination", "(Landroidx/navigation/NavigatorProvider;II)V", "", "route", "(Landroidx/navigation/NavigatorProvider;Ljava/lang/String;Ljava/lang/String;)V", "destinations", "", "Landroidx/navigation/NavDestination;", "getProvider", "()Landroidx/navigation/NavigatorProvider;", "startDestinationId", "startDestinationRoute", "addDestination", "", "destination", "build", "D", "navDestination", "unaryPlus", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class NavGraphBuilder extends NavDestinationBuilder<NavGraph> {
    private final List<NavDestination> destinations;
    private final NavigatorProvider provider;

    @IdRes
    private int startDestinationId;
    private String startDestinationRoute;

    public NavGraphBuilder(NavigatorProvider r2, @IdRes int r3, @IdRes int r4) {
        o.f(r2, "provider");
        super(r2.getNavigator(NavGraphNavigator.class), r3);
        this.destinations = new ArrayList();
        this.provider = r2;
        this.startDestinationId = r4;
    }

    public NavGraphBuilder(NavigatorProvider r2, String r3, String r4) {
        o.f(r2, "provider");
        o.f(r3, "startDestination");
        super(r2.getNavigator(NavGraphNavigator.class), r4);
        this.destinations = new ArrayList();
        this.provider = r2;
        this.startDestinationRoute = r3;
    }

    public final void addDestination(NavDestination r2) {
        o.f(r2, "destination");
        this.destinations.add(r2);
    }

    @Override // androidx.navigation.NavDestinationBuilder
    public /* bridge */ /* synthetic */ NavDestination build() {
        return build();
    }

    @Override // androidx.navigation.NavDestinationBuilder
    public NavGraph build() {
        NavGraph r0 = (NavGraph) super.build();
        r0.addDestinations(this.destinations);
        int r1 = this.startDestinationId;
        if (r1 == 0) goto L5;
    L12:
        String r3 = this.startDestinationRoute;
        if (r3 == null) goto L15;
        o.c(r3);
        r0.setStartDestination(r3);
    L16:
        return r0;
    L15:
        r0.setStartDestination(r1);
        goto L16
    L5:
        if (this.startDestinationRoute != null) goto L12;
        if (getRoute() == null) goto L11;
        throw new IllegalStateException("You must set a start destination route");
    L11:
        throw new IllegalStateException("You must set a start destination id");
    }

    public final <D extends NavDestination> void destination(NavDestinationBuilder<? extends D> r2) {
        o.f(r2, "navDestination");
        this.destinations.add(r2.build());
    }

    public final NavigatorProvider getProvider() {
        return this.provider;
    }

    public final void unaryPlus(NavDestination r2) {
        o.f(r2, "<this>");
        addDestination(r2);
    }
}
