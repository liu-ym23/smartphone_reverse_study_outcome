package androidx.navigation.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import androidx.navigation.NavigatorProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a0;
import kotlin.f0;
import kotlin.i0.m0;
import kotlin.i0.r;
import kotlin.n0.d.g;
import kotlin.n0.d.o;
import kotlin.u;

/* JADX INFO: loaded from: classes.dex */
@Navigator.Name("fragment")
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0017\u0018\u0000 '2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003'()B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\r\u001a\u00020\u0002H\u0016J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J*\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0017J$\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J*\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00110\u001e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u0011H\u0016J\u0010\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u0018H\u0016J\n\u0010#\u001a\u0004\u0018\u00010\u0018H\u0016J\u0018\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020&H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Landroidx/navigation/fragment/FragmentNavigator;", "Landroidx/navigation/Navigator;", "Landroidx/navigation/fragment/FragmentNavigator$Destination;", "context", "Landroid/content/Context;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "containerId", "", "(Landroid/content/Context;Landroidx/fragment/app/FragmentManager;I)V", "savedIds", "", "", "createDestination", "createFragmentTransaction", "Landroidx/fragment/app/FragmentTransaction;", "entry", "Landroidx/navigation/NavBackStackEntry;", "navOptions", "Landroidx/navigation/NavOptions;", "instantiateFragment", "Landroidx/fragment/app/Fragment;", "className", "args", "Landroid/os/Bundle;", "navigate", "", "navigatorExtras", "Landroidx/navigation/Navigator$Extras;", "entries", "", "onLaunchSingleTop", "backStackEntry", "onRestoreState", "savedState", "onSaveState", "popBackStack", "popUpTo", "", "Companion", "Destination", "Extras", "navigation-fragment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class FragmentNavigator extends Navigator<Destination> {
    private static final Companion Companion = null;

    @Deprecated
    private static final String KEY_SAVED_IDS = "androidx-nav-fragment:navigator:savedIds";

    @Deprecated
    private static final String TAG = "FragmentNavigator";
    private final int containerId;
    private final Context context;
    private final FragmentManager fragmentManager;
    private final Set<String> savedIds;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/navigation/fragment/FragmentNavigator$Companion;", "", "()V", "KEY_SAVED_IDS", "", "TAG", "navigation-fragment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0015\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0017J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tJ\b\u0010\u001a\u001a\u00020\tH\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u001b"}, d2 = {"Landroidx/navigation/fragment/FragmentNavigator$Destination;", "Landroidx/navigation/NavDestination;", "navigatorProvider", "Landroidx/navigation/NavigatorProvider;", "(Landroidx/navigation/NavigatorProvider;)V", "fragmentNavigator", "Landroidx/navigation/Navigator;", "(Landroidx/navigation/Navigator;)V", "_className", "", "className", "getClassName", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "onInflate", "", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "setClassName", "toString", "navigation-fragment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @NavDestination.ClassType(Fragment.class)
    public static class Destination extends NavDestination {
        private String _className;

        public Destination(Navigator<? extends Destination> r2) {
            o.f(r2, "fragmentNavigator");
            super(r2);
        }

        public Destination(NavigatorProvider r2) {
            o.f(r2, "navigatorProvider");
            this(r2.getNavigator(FragmentNavigator.class));
        }

        @Override // androidx.navigation.NavDestination
        public boolean equals(Object r3) {
            if (r3 != null) goto L5;
            return false;
        L5:
            if ((r3 instanceof Destination) == true) goto L8;
            return false;
        L8:
            if (super.equals(r3) == true) goto L10;
            return false;
        L10:
            if (o.a(this._className, ((Destination) r3)._className) == false) goto L15;
            return true;
        L15:
            return false;
        }

        public final String getClassName() {
            String r1 = this._className;
            if (r1 == null) goto L7;
            Objects.requireNonNull(r1, "null cannot be cast to non-null type kotlin.String");
            return r1;
        L7:
            throw new IllegalStateException("Fragment class was not set".toString());
        }

        @Override // androidx.navigation.NavDestination
        public int hashCode() {
            int r0 = super.hashCode() * 31;
            String r1 = this._className;
            if (r1 == null) goto L5;
            int r2 = r1.hashCode();
        L7:
            return r0 + r2;
        L5:
            r2 = 0;
            goto L7
        }

        @Override // androidx.navigation.NavDestination
        @CallSuper
        public void onInflate(Context r2, AttributeSet r3) {
            o.f(r2, "context");
            o.f(r3, "attrs");
            super.onInflate(r2, r3);
            TypedArray r4 = r2.getResources().obtainAttributes(r3, R.styleable.FragmentNavigator);
            o.e(r4, "context.resources.obtain…leable.FragmentNavigator)");
            String r5 = r4.getString(R.styleable.FragmentNavigator_android_name);
            if (r5 == null) goto L5;
            setClassName(r5);
        L5:
            f0 r1 = f0.f18324a;
            r4.recycle();
        }

        public final Destination setClassName(String r2) {
            o.f(r2, "className");
            this._className = r2;
            return this;
        }

        @Override // androidx.navigation.NavDestination
        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append(super.toString());
            r0.append(" class=");
            String r2 = this._className;
            if (r2 != null) goto L5;
            r2 = "null";
        L5:
            r0.append(r2);
            String r3 = r0.toString();
            o.e(r3, "sb.toString()");
            return r3;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\fB\u001b\b\u0000\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006R*\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\bj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Landroidx/navigation/fragment/FragmentNavigator$Extras;", "Landroidx/navigation/Navigator$Extras;", "sharedElements", "", "Landroid/view/View;", "", "(Ljava/util/Map;)V", "_sharedElements", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "getSharedElements", "()Ljava/util/Map;", "Builder", "navigation-fragment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Extras implements Navigator.Extras {
        private final LinkedHashMap<View, String> _sharedElements;

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0006J\u001a\u0010\u000b\u001a\u00020\u00002\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\rJ\u0006\u0010\u000e\u001a\u00020\u000fR*\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/navigation/fragment/FragmentNavigator$Extras$Builder;", "", "()V", "_sharedElements", "Ljava/util/LinkedHashMap;", "Landroid/view/View;", "", "Lkotlin/collections/LinkedHashMap;", "addSharedElement", "sharedElement", "name", "addSharedElements", "sharedElements", "", "build", "Landroidx/navigation/fragment/FragmentNavigator$Extras;", "navigation-fragment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Builder {
            private final LinkedHashMap<View, String> _sharedElements;

            public Builder() {
                this._sharedElements = new LinkedHashMap();
            }

            public final Builder addSharedElement(View r2, String r3) {
                o.f(r2, "sharedElement");
                o.f(r3, "name");
                this._sharedElements.put(r2, r3);
                return this;
            }

            public final Builder addSharedElements(Map<View, String> r3) {
                o.f(r3, "sharedElements");
                Iterator<Map.Entry<View, String>> r4 = r3.entrySet().iterator();
            L4:
                if (r4.hasNext() == false) goto L6;
                Map.Entry<View, String> r0 = r4.next();
                addSharedElement(r0.getKey(), r0.getValue());
                goto L4
            L6:
                return this;
            }

            public final Extras build() {
                return new Extras(this._sharedElements);
            }
        }

        public Extras(Map<View, String> r2) {
            o.f(r2, "sharedElements");
            LinkedHashMap<View, String> r0 = new LinkedHashMap();
            this._sharedElements = r0;
            r0.putAll(r2);
        }

        public final Map<View, String> getSharedElements() {
            return m0.s(this._sharedElements);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public FragmentNavigator(Context r2, FragmentManager r3, int r4) {
        o.f(r2, "context");
        o.f(r3, "fragmentManager");
        this.context = r2;
        this.fragmentManager = r3;
        this.containerId = r4;
        this.savedIds = new LinkedHashSet();
    }

    private final FragmentTransaction createFragmentTransaction(NavBackStackEntry r7, NavOptions r8) {
        Destination r0 = (Destination) r7.getDestination();
        Bundle r9 = r7.getArguments();
        String r1 = r0.getClassName();
        int r2 = 0;
        if (r1.charAt(0) != '.') goto L5;
        r1 = this.context.getPackageName() + r1;
    L5:
        Fragment r3 = this.fragmentManager.getFragmentFactory().instantiate(this.context.getClassLoader(), r1);
        o.e(r3, "fragmentManager.fragment…t.classLoader, className)");
        r3.setArguments(r9);
        FragmentTransaction r10 = this.fragmentManager.beginTransaction();
        o.e(r10, "fragmentManager.beginTransaction()");
        if (r8 == null) goto L8;
        int r4 = r8.getEnterAnim();
    L9:
        if (r8 == null) goto L11;
        int r5 = r8.getExitAnim();
    L12:
        if (r8 == null) goto L14;
        int r6 = r8.getPopEnterAnim();
    L15:
        if (r8 == null) goto L17;
        int r11 = r8.getPopExitAnim();
    L18:
        if (r4 != (-1)) goto L22;
        if (r5 != (-1)) goto L22;
        if (r6 != (-1)) goto L22;
        if (r11 != (-1)) goto L22;
    L34:
        r10.replace(this.containerId, r3);
        r10.setPrimaryNavigationFragment(r3);
        r10.setReorderingAllowed(true);
        return r10;
    L22:
        if (r4 != (-1)) goto L25;
        r4 = 0;
    L25:
        if (r5 != (-1)) goto L28;
        r5 = 0;
    L28:
        if (r6 != (-1)) goto L31;
        r6 = 0;
    L31:
        if (r11 == (-1)) goto L33;
        r2 = r11;
    L33:
        r10.setCustomAnimations(r4, r5, r6, r2);
        goto L34
    L17:
        r11 = -1;
        goto L18
    L14:
        r6 = -1;
        goto L15
    L11:
        r5 = -1;
        goto L12
    L8:
        r4 = -1;
        goto L9
    }

    private final void navigate(NavBackStackEntry r4, NavOptions r5, Navigator.Extras r6) {
        boolean r0 = getState().getBackStack().getValue().isEmpty();
        if (r5 == null) goto L10;
        if (r0 == true) goto L10;
        if (r5.shouldRestoreState() == false) goto L10;
        if (this.savedIds.remove(r4.getId()) == false) goto L10;
        boolean r1 = true;
    L11:
        if (r1 == false) goto L15;
        this.fragmentManager.restoreBackStack(r4.getId());
    L13:
        getState().push(r4);
        return;
    L15:
        FragmentTransaction r7 = createFragmentTransaction(r4, r5);
        if (r0 == true) goto L19;
        r7.addToBackStack(r4.getId());
    L19:
        if ((r6 instanceof Extras) == false) goto L24;
        Iterator<Map.Entry<View, String>> r8 = ((Extras) r6).getSharedElements().entrySet().iterator();
    L22:
        if (r8.hasNext() == false) goto L24;
        Map.Entry<View, String> r2 = r8.next();
        r7.addSharedElement(r2.getKey(), r2.getValue());
    L24:
        r7.commit();
    L10:
        r1 = false;
        goto L11
    }

    @Override // androidx.navigation.Navigator
    public /* bridge */ /* synthetic */ NavDestination createDestination() {
        return createDestination();
    }

    @Override // androidx.navigation.Navigator
    public Destination createDestination() {
        return new Destination(this);
    }

    public Fragment instantiateFragment(Context r1, FragmentManager r2, String r3, Bundle r4) {
        o.f(r1, "context");
        o.f(r2, "fragmentManager");
        o.f(r3, "className");
        Fragment r0 = r2.getFragmentFactory().instantiate(r1.getClassLoader(), r3);
        o.e(r0, "fragmentManager.fragment…t.classLoader, className)");
        return r0;
    }

    @Override // androidx.navigation.Navigator
    public void navigate(List<NavBackStackEntry> r2, NavOptions r3, Navigator.Extras r4) {
        o.f(r2, "entries");
        if (this.fragmentManager.isStateSaved() == false) goto L6;
        Log.i(TAG, "Ignoring navigate() call: FragmentManager has already saved its state");
        return;
    L6:
        Iterator<NavBackStackEntry> r5 = r2.iterator();
    L8:
        if (r5.hasNext() == false) goto L10;
        navigate(r5.next(), r3, r4);
        goto L8
    }

    @Override // androidx.navigation.Navigator
    public void onLaunchSingleTop(NavBackStackEntry r5) {
        o.f(r5, "backStackEntry");
        if (this.fragmentManager.isStateSaved() == false) goto L6;
        Log.i(TAG, "Ignoring onLaunchSingleTop() call: FragmentManager has already saved its state");
        return;
    L6:
        FragmentTransaction r0 = createFragmentTransaction(r5, null);
        if (getState().getBackStack().getValue().size() <= 1) goto L9;
        this.fragmentManager.popBackStack(r5.getId(), 1);
        r0.addToBackStack(r5.getId());
    L9:
        r0.commit();
        getState().onLaunchSingleTop(r5);
    }

    @Override // androidx.navigation.Navigator
    public void onRestoreState(Bundle r2) {
        o.f(r2, "savedState");
        ArrayList<String> r3 = r2.getStringArrayList(KEY_SAVED_IDS);
        if (r3 == null) goto L6;
        this.savedIds.clear();
        r.v(this.savedIds, r3);
        return;
    }

    @Override // androidx.navigation.Navigator
    public Bundle onSaveState() {
        if (this.savedIds.isEmpty() == false) goto L7;
        return null;
    L7:
        return BundleKt.bundleOf(new u[]{a0.a(KEY_SAVED_IDS, new ArrayList(this.savedIds))});
    }

    @Override // androidx.navigation.Navigator
    public void popBackStack(NavBackStackEntry r7, boolean r8) {
        o.f(r7, "popUpTo");
        if (this.fragmentManager.isStateSaved() == false) goto L6;
        Log.i(TAG, "Ignoring popBackStack() call: FragmentManager has already saved its state");
        return;
    L6:
        if (r8 == false) goto L14;
        List<NavBackStackEntry> r0 = getState().getBackStack().getValue();
        NavBackStackEntry r2 = (NavBackStackEntry) r.P(r0);
        Iterator r1 = r.m0(r0.subList(r0.indexOf(r7), r0.size())).iterator();
    L9:
        if (r1.hasNext() == false) goto L15;
        NavBackStackEntry r3 = (NavBackStackEntry) r1.next();
        if (o.a(r3, r2) == true) goto L12;
        this.fragmentManager.saveBackStack(r3.getId());
        this.savedIds.add(r3.getId());
        goto L9
    L12:
        Log.i(TAG, "FragmentManager cannot save the state of the initial destination " + r3);
    L15:
        getState().pop(r7, r8);
        return;
    L14:
        this.fragmentManager.popBackStack(r7.getId(), 1);
        goto L15
    }
}
