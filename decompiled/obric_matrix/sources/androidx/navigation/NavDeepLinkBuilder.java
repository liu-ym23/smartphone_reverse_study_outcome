package androidx.navigation;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.IdRes;
import androidx.annotation.NavigationRes;
import androidx.core.app.TaskStackBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.i0.h;
import kotlin.i0.r;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0002,-B\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001e\u0010\u0011\u001a\u00020\u00002\b\b\u0001\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\fH\u0007J\u001c\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\fH\u0007J\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u001aJ\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\b\u0001\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u001f\u001a\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\fJ\u000e\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"J\u0018\u0010 \u001a\u00020\u00002\u0010\u0010#\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010%0$J\u001e\u0010&\u001a\u00020\u00002\b\b\u0001\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\fH\u0007J\u001c\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u00162\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\fH\u0007J\u000e\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\u000eJ\u0010\u0010(\u001a\u00020\u00002\b\b\u0001\u0010*\u001a\u00020\u0013J\b\u0010+\u001a\u00020\u001cH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Landroidx/navigation/NavDeepLinkBuilder;", "", "navController", "Landroidx/navigation/NavController;", "(Landroidx/navigation/NavController;)V", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "destinations", "", "Landroidx/navigation/NavDeepLinkBuilder$DeepLinkDestination;", "globalArgs", "Landroid/os/Bundle;", "graph", "Landroidx/navigation/NavGraph;", "intent", "Landroid/content/Intent;", "addDestination", "destId", "", "args", "route", "", "createPendingIntent", "Landroid/app/PendingIntent;", "createTaskStackBuilder", "Landroidx/core/app/TaskStackBuilder;", "fillInIntent", "", "findDestination", "Landroidx/navigation/NavDestination;", "setArguments", "setComponentName", "componentName", "Landroid/content/ComponentName;", "activityClass", "Ljava/lang/Class;", "Landroid/app/Activity;", "setDestination", "destRoute", "setGraph", "navGraph", "navGraphId", "verifyAllDestinations", "DeepLinkDestination", "PermissiveNavigatorProvider", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NavDeepLinkBuilder {
    private final Context context;
    private final List<DeepLinkDestination> destinations;
    private Bundle globalArgs;
    private NavGraph graph;
    private final Intent intent;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/navigation/NavDeepLinkBuilder$DeepLinkDestination;", "", "destinationId", "", "arguments", "Landroid/os/Bundle;", "(ILandroid/os/Bundle;)V", "getArguments", "()Landroid/os/Bundle;", "getDestinationId", "()I", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class DeepLinkDestination {
        private final Bundle arguments;
        private final int destinationId;

        public DeepLinkDestination(int r1, Bundle r2) {
            this.destinationId = r1;
            this.arguments = r2;
        }

        public final Bundle getArguments() {
            return this.arguments;
        }

        public final int getDestinationId() {
            return this.destinationId;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J'\u0010\u0006\u001a\u0002H\u0007\"\u0010\b\u0000\u0010\u0007*\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\nR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Landroidx/navigation/NavDeepLinkBuilder$PermissiveNavigatorProvider;", "Landroidx/navigation/NavigatorProvider;", "()V", "mDestNavigator", "Landroidx/navigation/Navigator;", "Landroidx/navigation/NavDestination;", "getNavigator", "T", "name", "", "(Ljava/lang/String;)Landroidx/navigation/Navigator;", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class PermissiveNavigatorProvider extends NavigatorProvider {
        private final Navigator<NavDestination> mDestNavigator;

        public PermissiveNavigatorProvider() {
            this.mDestNavigator = new NavDeepLinkBuilder$PermissiveNavigatorProvider$mDestNavigator$1();
            addNavigator(new NavGraphNavigator(this));
        }

        @Override // androidx.navigation.NavigatorProvider
        public <T extends Navigator<? extends NavDestination>> T getNavigator(String r2) {
            o.f(r2, "name");
            return (T) super.getNavigator(r2);
        L6:
            return this.mDestNavigator;
        }
    }

    public NavDeepLinkBuilder(Context r3) {
        o.f(r3, "context");
        this.context = r3;
        if ((r3 instanceof Activity) == false) goto L5;
        Intent r0 = new Intent(r3, r3.getClass());
    L8:
        r0.addFlags(268468224);
        this.intent = r0;
        this.destinations = new ArrayList();
        return;
    L5:
        r0 = r3.getPackageManager().getLaunchIntentForPackage(r3.getPackageName());
        if (r0 != null) goto L8;
        r0 = new Intent();
        goto L8
    }

    public NavDeepLinkBuilder(NavController r2) {
        o.f(r2, "navController");
        this(r2.getContext());
        this.graph = r2.getGraph();
    }

    public static /* synthetic */ NavDeepLinkBuilder addDestination$default(NavDeepLinkBuilder r0, int r1, Bundle r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.addDestination(r1, r2);
    }

    public static /* synthetic */ NavDeepLinkBuilder addDestination$default(NavDeepLinkBuilder r0, String r1, Bundle r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.addDestination(r1, r2);
    }

    private final void fillInIntent() {
        ArrayList r0 = new ArrayList();
        ArrayList<? extends Parcelable> r1 = new ArrayList();
        Iterator<DeepLinkDestination> r2 = this.destinations.iterator();
        NavDestination r3 = null;
    L4:
        if (r2.hasNext() == false) goto L13;
        DeepLinkDestination r4 = r2.next();
        int r5 = r4.getDestinationId();
        Bundle r6 = r4.getArguments();
        NavDestination r7 = findDestination(r5);
        if (r7 == null) goto L12;
        int[] r8 = r7.buildDeepLinkIds(r3);
        int r9 = 0;
        int r10 = r8.length;
    L8:
        if (r9 >= r10) goto L10;
        r0.add(Integer.valueOf(r8[r9]));
        r1.add(r6);
        r9 = r9 + 1;
        goto L8
    L10:
        r3 = r7;
        goto L4
    L12:
        throw new IllegalArgumentException("Navigation destination " + NavDestination.Companion.getDisplayName(this.context, r5) + " cannot be found in the navigation graph " + this.graph);
    L13:
        this.intent.putExtra(NavController.KEY_DEEP_LINK_IDS, r.y0(r0));
        this.intent.putParcelableArrayListExtra(NavController.KEY_DEEP_LINK_ARGS, r1);
    }

    private final NavDestination findDestination(@IdRes int r3) {
        h r0 = new h();
        NavGraph r2 = this.graph;
        o.c(r2);
        r0.add(r2);
    L4:
        if (r0.isEmpty() == true) goto L14;
        NavDestination r4 = (NavDestination) r0.removeFirst();
        if (r4.getId() == r3) goto L7;
        if ((r4 instanceof NavGraph) == false) goto L4;
        Iterator<NavDestination> r5 = ((NavGraph) r4).iterator();
    L12:
        if (r5.hasNext() == false) goto L4;
        r0.add(r5.next());
        goto L12
    L7:
        return r4;
    L14:
        return null;
    }

    public static /* synthetic */ NavDeepLinkBuilder setDestination$default(NavDeepLinkBuilder r0, int r1, Bundle r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.setDestination(r1, r2);
    }

    public static /* synthetic */ NavDeepLinkBuilder setDestination$default(NavDeepLinkBuilder r0, String r1, Bundle r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.setDestination(r1, r2);
    }

    private final void verifyAllDestinations() {
        Iterator<DeepLinkDestination> r0 = this.destinations.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        int r1 = r0.next().getDestinationId();
        if (findDestination(r1) != null) goto L4;
        throw new IllegalArgumentException("Navigation destination " + NavDestination.Companion.getDisplayName(this.context, r1) + " cannot be found in the navigation graph " + this.graph);
    }

    public final NavDeepLinkBuilder addDestination(@IdRes int r3) {
        return addDestination$default(this, r3, null, 2, null);
    }

    public final NavDeepLinkBuilder addDestination(@IdRes int r3, Bundle r4) {
        this.destinations.add(new DeepLinkDestination(r3, r4));
        if (this.graph == null) goto L5;
        verifyAllDestinations();
    L5:
        return this;
    }

    public final NavDeepLinkBuilder addDestination(String r3) {
        o.f(r3, "route");
        return addDestination$default(this, r3, null, 2, null);
    }

    public final NavDeepLinkBuilder addDestination(String r4, Bundle r5) {
        o.f(r4, "route");
        this.destinations.add(new DeepLinkDestination(NavDestination.Companion.createRoute(r4).hashCode(), r5));
        if (this.graph == null) goto L5;
        verifyAllDestinations();
    L5:
        return this;
    }

    public final PendingIntent createPendingIntent() {
        Bundle r0 = this.globalArgs;
        if (r0 == null) goto L12;
        Iterator<String> r2 = r0.keySet().iterator();
        int r3 = 0;
    L6:
        if (r2.hasNext() == false) goto L13;
        Object r4 = r0.get(r2.next());
        int r5 = r3 * 31;
        if (r4 == null) goto L10;
        int r6 = r4.hashCode();
    L11:
        r3 = r5 + r6;
        goto L6
    L10:
        r6 = 0;
    L13:
        Iterator<DeepLinkDestination> r1 = this.destinations.iterator();
    L15:
        if (r1.hasNext() == false) goto L26;
        DeepLinkDestination r7 = r1.next();
        r3 = (r3 * 31) + r7.getDestinationId();
        Bundle r8 = r7.getArguments();
        if (r8 == null) goto L15;
        Iterator<String> r9 = r8.keySet().iterator();
    L20:
        if (r9.hasNext() == false) goto L15;
        Object r10 = r8.get(r9.next());
        int r11 = r3 * 31;
        if (r10 == null) goto L24;
        int r12 = r10.hashCode();
    L25:
        r3 = r11 + r12;
        goto L20
    L24:
        r12 = 0;
        goto L25
    L26:
        PendingIntent r13 = createTaskStackBuilder().getPendingIntent(r3, 201326592);
        o.c(r13);
        return r13;
    L12:
        r3 = 0;
        goto L13
    }

    public final TaskStackBuilder createTaskStackBuilder() {
        if (this.graph == null) goto L16;
        if ((!this.destinations.isEmpty()) == false) goto L14;
        fillInIntent();
        TaskStackBuilder r0 = TaskStackBuilder.create(this.context).addNextIntentWithParentStack(new Intent(this.intent));
        o.e(r0, "create(context)\n        …rentStack(Intent(intent))");
        int r1 = 0;
        int r2 = r0.getIntentCount();
    L7:
        if (r1 >= r2) goto L12;
        Intent r3 = r0.editIntentAt(r1);
        if (r3 == null) goto L11;
        r3.putExtra(NavController.KEY_DEEP_LINK_INTENT, this.intent);
    L11:
        r1 = r1 + 1;
        goto L7
    L12:
        return r0;
    L14:
        throw new IllegalStateException("You must call setDestination() or addDestination() before constructing the deep link".toString());
    L16:
        throw new IllegalStateException("You must call setGraph() before constructing the deep link".toString());
    }

    public final NavDeepLinkBuilder setArguments(Bundle r3) {
        this.globalArgs = r3;
        this.intent.putExtra(NavController.KEY_DEEP_LINK_EXTRAS, r3);
        return this;
    }

    public final NavDeepLinkBuilder setComponentName(ComponentName r2) {
        o.f(r2, "componentName");
        this.intent.setComponent(r2);
        return this;
    }

    public final NavDeepLinkBuilder setComponentName(Class<? extends Activity> r3) {
        o.f(r3, "activityClass");
        return setComponentName(new ComponentName(this.context, r3));
    }

    public final NavDeepLinkBuilder setDestination(@IdRes int r3) {
        return setDestination$default(this, r3, null, 2, null);
    }

    public final NavDeepLinkBuilder setDestination(@IdRes int r3, Bundle r4) {
        this.destinations.clear();
        this.destinations.add(new DeepLinkDestination(r3, r4));
        if (this.graph == null) goto L5;
        verifyAllDestinations();
    L5:
        return this;
    }

    public final NavDeepLinkBuilder setDestination(String r3) {
        o.f(r3, "destRoute");
        return setDestination$default(this, r3, null, 2, null);
    }

    public final NavDeepLinkBuilder setDestination(String r4, Bundle r5) {
        o.f(r4, "destRoute");
        this.destinations.clear();
        this.destinations.add(new DeepLinkDestination(NavDestination.Companion.createRoute(r4).hashCode(), r5));
        if (this.graph == null) goto L5;
        verifyAllDestinations();
    L5:
        return this;
    }

    public final NavDeepLinkBuilder setGraph(@NavigationRes int r4) {
        return setGraph(new NavInflater(this.context, new PermissiveNavigatorProvider()).inflate(r4));
    }

    public final NavDeepLinkBuilder setGraph(NavGraph r2) {
        o.f(r2, "navGraph");
        this.graph = r2;
        verifyAllDestinations();
        return this;
    }
}
