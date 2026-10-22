package androidx.navigation;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.IdRes;
import androidx.annotation.RestrictTo;
import androidx.collection.SparseArrayCompat;
import androidx.collection.SparseArrayKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.i0.r;
import kotlin.n0.d.g;
import kotlin.n0.d.o;
import kotlin.t0.k;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 >2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00010\u0002:\u0001>B\u0015\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0000J\u000e\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u0001J\u001f\u0010\"\u001a\u00020\u001e2\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010#\"\u00020\u0001¢\u0006\u0002\u0010$J\u0016\u0010\"\u001a\u00020\u001e2\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010%J\u0006\u0010&\u001a\u00020\u001eJ\u0013\u0010'\u001a\u00020(2\b\u0010\u001f\u001a\u0004\u0018\u00010)H\u0096\u0002J\u0012\u0010*\u001a\u0004\u0018\u00010\u00012\b\b\u0001\u0010+\u001a\u00020\u0011J\u001c\u0010*\u001a\u0004\u0018\u00010\u00012\b\b\u0001\u0010+\u001a\u00020\u00112\u0006\u0010,\u001a\u00020(H\u0007J\u001a\u0010*\u001a\u0004\u0018\u00010\u00012\u0006\u0010-\u001a\u00020\u00072\u0006\u0010,\u001a\u00020(H\u0007J\u0012\u0010*\u001a\u0004\u0018\u00010\u00012\b\u0010-\u001a\u0004\u0018\u00010\u0007J\b\u0010.\u001a\u00020\u0011H\u0007J\b\u0010/\u001a\u00020\u0011H\u0016J\u000f\u00100\u001a\b\u0012\u0004\u0012\u00020\u000101H\u0086\u0002J\u0012\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u000205H\u0017J\u0018\u00106\u001a\u00020\u001e2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0016J\u000e\u0010;\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u0001J\u000e\u0010<\u001a\u00020\u001e2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010<\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u0007J\b\u0010=\u001a\u00020\u0007H\u0016R\u0014\u0010\u0006\u001a\u00020\u00078WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b8G¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u00078G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\tR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00118G@BX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R(\u0010\u0019\u001a\u0004\u0018\u00010\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0007@BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\t\"\u0004\b\u001b\u0010\u001c¨\u0006?"}, d2 = {"Landroidx/navigation/NavGraph;", "Landroidx/navigation/NavDestination;", "", "navGraphNavigator", "Landroidx/navigation/Navigator;", "(Landroidx/navigation/Navigator;)V", "displayName", "", "getDisplayName", "()Ljava/lang/String;", "nodes", "Landroidx/collection/SparseArrayCompat;", "getNodes", "()Landroidx/collection/SparseArrayCompat;", "startDestDisplayName", "getStartDestDisplayName", "startDestId", "", "startDestIdName", "startDestinationId", "getStartDestinationId", "()I", "setStartDestinationId", "(I)V", "startDestRoute", "startDestinationRoute", "getStartDestinationRoute", "setStartDestinationRoute", "(Ljava/lang/String;)V", "addAll", "", "other", "addDestination", "node", "addDestinations", "", "([Landroidx/navigation/NavDestination;)V", "", "clear", "equals", "", "", "findNode", "resId", "searchParents", "route", "getStartDestination", "hashCode", "iterator", "", "matchDeepLink", "Landroidx/navigation/NavDestination$DeepLinkMatch;", "navDeepLinkRequest", "Landroidx/navigation/NavDeepLinkRequest;", "onInflate", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "remove", "setStartDestination", "toString", "Companion", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class NavGraph extends NavDestination implements Iterable<NavDestination>, kotlin.n0.d.l0.a {
    public static final Companion Companion = null;
    private final SparseArrayCompat<NavDestination> nodes;
    private int startDestId;
    private String startDestIdName;
    private String startDestinationRoute;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Landroidx/navigation/NavGraph$Companion;", "", "()V", "findStartDestination", "Landroidx/navigation/NavDestination;", "Landroidx/navigation/NavGraph;", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g r1) {
            this();
        }

        public final NavDestination findStartDestination(NavGraph r1) {
            o.f(r1, "<this>");
            return (NavDestination) k.s(k.h(r1.findNode(r1.getStartDestinationId()), NavGraph$Companion$findStartDestination$1.INSTANCE));
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.NavGraph$iterator$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u0096\u0002J\t\u0010\b\u001a\u00020\u0002H\u0096\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"androidx/navigation/NavGraph$iterator$1", "", "Landroidx/navigation/NavDestination;", "index", "", "wentToNext", "", "hasNext", "next", "remove", "", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class AnonymousClass1 implements Iterator<NavDestination>, Object {
        private int index;
        final /* synthetic */ NavGraph this$0;
        private boolean wentToNext;

        AnonymousClass1(NavGraph r1) {
            this.this$0 = r1;
            this.index = -1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if ((this.index + 1) < this.this$0.getNodes().size()) goto L7;
            return false;
        L7:
            return true;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public NavDestination next() {
            if (hasNext() == false) goto L7;
            this.wentToNext = true;
            SparseArrayCompat<NavDestination> r1 = this.this$0.getNodes();
            int r2 = this.index + 1;
            this.index = r2;
            NavDestination r3 = r1.valueAt(r2);
            o.e(r3, "nodes.valueAt(++index)");
            return r3;
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ NavDestination next() {
            return next();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.wentToNext == false) goto L7;
            SparseArrayCompat<NavDestination> r0 = this.this$0.getNodes();
            r0.valueAt(this.index).setParent(null);
            r0.removeAt(this.index);
            this.index--;
            this.wentToNext = false;
            return;
        L7:
            throw new IllegalStateException("You must call next() before you can remove an element".toString());
        }
    }

    static {
        Companion = new Companion(null);
    }

    public NavGraph(Navigator<? extends NavGraph> r2) {
        o.f(r2, "navGraphNavigator");
        super(r2);
        this.nodes = new SparseArrayCompat();
    }

    public static final NavDestination findStartDestination(NavGraph r1) {
        return Companion.findStartDestination(r1);
    }

    private final void setStartDestinationId(int r3) {
        if (r3 == getId()) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L13;
        if (this.startDestinationRoute == null) goto L10;
        setStartDestinationRoute(null);
    L10:
        this.startDestId = r3;
        this.startDestIdName = null;
        return;
    L13:
        throw new IllegalArgumentException(("Start destination " + r3 + " cannot use the same id as the graph " + this).toString());
    L5:
        r0 = false;
        goto L6
    }

    private final void setStartDestinationRoute(String r3) {
        if (r3 != null) goto L5;
        int r0 = 0;
    L9:
        this.startDestId = r0;
        this.startDestinationRoute = r3;
        return;
    L5:
        if ((!o.a(r3, getRoute())) == false) goto L14;
        if ((!kotlin.u0.k.q(r3)) == false) goto L12;
        r0 = NavDestination.Companion.createRoute(r3).hashCode();
        goto L9
    L12:
        throw new IllegalArgumentException("Cannot have an empty start destination route".toString());
    L14:
        throw new IllegalArgumentException(("Start destination " + r3 + " cannot use the same route as the graph " + this).toString());
    }

    public final void addAll(NavGraph r2) {
        o.f(r2, "other");
        Iterator<NavDestination> r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        NavDestination r0 = r3.next();
        r3.remove();
        addDestination(r0);
        goto L4
    }

    public final void addDestination(NavDestination r7) {
        o.f(r7, "node");
        int r0 = r7.getId();
        String r1 = r7.getRoute();
        boolean r2 = false;
        if (r0 != 0) goto L7;
        if (r1 != null) goto L7;
        boolean r4 = false;
    L8:
        if (r4 == false) goto L37;
        if (getRoute() == null) goto L17;
        if ((!o.a(r1, getRoute())) == true) goto L17;
        throw new IllegalArgumentException(("Destination " + r7 + " cannot have the same route as graph " + this).toString());
    L17:
        if (r0 == getId()) goto L19;
        boolean r3 = true;
    L20:
        if (r3 == false) goto L35;
        NavDestination r5 = this.nodes.get(r0);
        if (r5 != r7) goto L25;
        return;
    L25:
        if (r7.getParent() != null) goto L27;
        r2 = true;
    L27:
        if (r2 == false) goto L33;
        if (r5 == null) goto L30;
        r5.setParent(null);
    L30:
        r7.setParent(this);
        this.nodes.put(r7.getId(), r7);
        return;
    L33:
        throw new IllegalStateException("Destination already has a parent set. Call NavGraph.remove() to remove the previous parent.".toString());
    L35:
        throw new IllegalArgumentException(("Destination " + r7 + " cannot have the same id as graph " + this).toString());
    L19:
        r3 = false;
        goto L20
    L37:
        throw new IllegalArgumentException("Destinations must have an id or route. Call setId(), setRoute(), or include an android:id or app:route in your navigation XML.".toString());
    L7:
        r4 = true;
        goto L8
    }

    public final void addDestinations(Collection<? extends NavDestination> r2) {
        o.f(r2, "nodes");
        Iterator<? extends NavDestination> r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        NavDestination r0 = r3.next();
        if (r0 == null) goto L4;
        addDestination(r0);
        goto L4
    }

    public final void addDestinations(NavDestination... r4) {
        o.f(r4, "nodes");
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        addDestination(r4[r1]);
        r1 = r1 + 1;
        goto L3
    }

    public final void clear() {
        Iterator<NavDestination> r1 = iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next();
        r1.remove();
        goto L4
    }

    @Override // androidx.navigation.NavDestination
    public boolean equals(Object r6) {
        if (r6 != null) goto L5;
        return false;
    L5:
        if ((r6 instanceof NavGraph) == false) goto L27;
        List r1 = k.A(k.c(SparseArrayKt.valueIterator(this.nodes)));
        NavGraph r2 = (NavGraph) r6;
        Iterator r3 = SparseArrayKt.valueIterator(r2.nodes);
    L9:
        if (r3.hasNext() == false) goto L12;
        r1.remove((NavDestination) r3.next());
        goto L9
    L12:
        if (super.equals(r6) == true) goto L14;
        return false;
    L14:
        if (this.nodes.size() == r2.nodes.size()) goto L16;
        return false;
    L16:
        if (getStartDestinationId() == r2.getStartDestinationId()) goto L18;
        return false;
    L18:
        if (r1.isEmpty() == false) goto L26;
        return true;
    L26:
        return false;
    L27:
        return false;
    }

    public final NavDestination findNode(@IdRes int r2) {
        return findNode(r2, true);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final NavDestination findNode(@IdRes int r2, boolean r3) {
        NavDestination r0 = this.nodes.get(r2);
        if (r0 != null) goto L10;
        if (r3 == true) goto L6;
    L8:
        return null;
    L6:
        if (getParent() == null) goto L8;
        NavGraph r1 = getParent();
        o.c(r1);
        return r1.findNode(r2);
    L10:
        return r0;
    }

    public final NavDestination findNode(String r3) {
        if (r3 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L13;
        return null;
    L13:
        return findNode(r3, true);
    L5:
        if (kotlin.u0.k.q(r3) == true) goto L8;
        r1 = false;
        goto L9
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final NavDestination findNode(String r3, boolean r4) {
        o.f(r3, "route");
        int r0 = NavDestination.Companion.createRoute(r3).hashCode();
        NavDestination r1 = this.nodes.get(r0);
        if (r1 != null) goto L10;
        if (r4 == true) goto L6;
    L8:
        return null;
    L6:
        if (getParent() == null) goto L8;
        NavGraph r2 = getParent();
        o.c(r2);
        return r2.findNode(r3);
    L10:
        return r1;
    }

    @Override // androidx.navigation.NavDestination
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public String getDisplayName() {
        if (getId() != 0) goto L7;
        return "the root navigation";
    L7:
        return super.getDisplayName();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final SparseArrayCompat<NavDestination> getNodes() {
        return this.nodes;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final String getStartDestDisplayName() {
        if (this.startDestIdName != null) goto L8;
        String r0 = this.startDestinationRoute;
        if (r0 != null) goto L7;
        r0 = String.valueOf(this.startDestId);
    L7:
        this.startDestIdName = r0;
    L8:
        String r1 = this.startDestIdName;
        o.c(r1);
        return r1;
    }

    @IdRes
    public final int getStartDestination() {
        return getStartDestinationId();
    }

    @IdRes
    public final int getStartDestinationId() {
        return this.startDestId;
    }

    public final String getStartDestinationRoute() {
        return this.startDestinationRoute;
    }

    @Override // androidx.navigation.NavDestination
    public int hashCode() {
        int r0 = getStartDestinationId();
        SparseArrayCompat<NavDestination> r5 = this.nodes;
        int r1 = r5.size();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        int r3 = r5.keyAt(r2);
        r0 = (((r0 * 31) + r3) * 31) + r5.valueAt(r2).hashCode();
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }

    @Override // java.lang.Iterable
    public final Iterator<NavDestination> iterator() {
        return new AnonymousClass1(this);
    }

    @Override // androidx.navigation.NavDestination
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public NavDestination.DeepLinkMatch matchDeepLink(NavDeepLinkRequest r4) {
        o.f(r4, "navDeepLinkRequest");
        NavDestination.DeepLinkMatch r0 = super.matchDeepLink(r4);
        ArrayList r1 = new ArrayList();
        Iterator<NavDestination> r3 = iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        NavDestination.DeepLinkMatch r2 = r3.next().matchDeepLink(r4);
        if (r2 == null) goto L4;
        r1.add(r2);
        goto L4
    L9:
        return (NavDestination.DeepLinkMatch) r.f0(r.l(new NavDestination.DeepLinkMatch[]{r0, (NavDestination.DeepLinkMatch) r.f0(r1)}));
    }

    @Override // androidx.navigation.NavDestination
    public void onInflate(Context r3, AttributeSet r4) {
        o.f(r3, "context");
        o.f(r4, "attrs");
        super.onInflate(r3, r4);
        TypedArray r5 = r3.getResources().obtainAttributes(r4, androidx.navigation.common.R.styleable.NavGraphNavigator);
        o.e(r5, "context.resources.obtain…vGraphNavigator\n        )");
        setStartDestinationId(r5.getResourceId(androidx.navigation.common.R.styleable.NavGraphNavigator_startDestination, 0));
        this.startDestIdName = NavDestination.Companion.getDisplayName(r3, this.startDestId);
        f0 r2 = f0.f18324a;
        r5.recycle();
    }

    public final void remove(NavDestination r3) {
        o.f(r3, "node");
        int r4 = this.nodes.indexOfKey(r3.getId());
        if (r4 < 0) goto L6;
        this.nodes.valueAt(r4).setParent(null);
        this.nodes.removeAt(r4);
        return;
    }

    public final void setStartDestination(int r1) {
        setStartDestinationId(r1);
    }

    public final void setStartDestination(String r2) {
        o.f(r2, "startDestRoute");
        setStartDestinationRoute(r2);
    }

    @Override // androidx.navigation.NavDestination
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append(super.toString());
        NavDestination r1 = findNode(this.startDestinationRoute);
        if (r1 != null) goto L5;
        r1 = findNode(getStartDestinationId());
    L5:
        r0.append(" startDestination=");
        if (r1 != null) goto L14;
        String r2 = this.startDestinationRoute;
        if (r2 == null) goto L10;
    L9:
        r0.append(r2);
    L16:
        String r3 = r0.toString();
        o.e(r3, "sb.toString()");
        return r3;
    L10:
        r2 = this.startDestIdName;
        if (r2 != null) goto L9;
        String r4 = "0x" + Integer.toHexString(this.startDestId);
    L15:
        r0.append(r4);
        goto L16
    L14:
        r0.append("{");
        r0.append(r1.toString());
        r4 = "}";
        goto L15
    }
}
