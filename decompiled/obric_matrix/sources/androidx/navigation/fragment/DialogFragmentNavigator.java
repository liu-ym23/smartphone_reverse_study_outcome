package androidx.navigation.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigation.FloatingWindow;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import androidx.navigation.NavigatorProvider;
import androidx.navigation.NavigatorState;
import com.bytedance.common.wschannel.WsConstants;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.i0.r;
import kotlin.n0.d.g;
import kotlin.n0.d.j0;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Navigator.Name("dialog")
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001f B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\r\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J*\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Landroidx/navigation/fragment/DialogFragmentNavigator;", "Landroidx/navigation/Navigator;", "Landroidx/navigation/fragment/DialogFragmentNavigator$Destination;", "context", "Landroid/content/Context;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "(Landroid/content/Context;Landroidx/fragment/app/FragmentManager;)V", "observer", "Landroidx/lifecycle/LifecycleEventObserver;", "restoredTagsAwaitingAttach", "", "", "createDestination", "navigate", "", "entry", "Landroidx/navigation/NavBackStackEntry;", "entries", "", "navOptions", "Landroidx/navigation/NavOptions;", "navigatorExtras", "Landroidx/navigation/Navigator$Extras;", "onAttach", WsConstants.KEY_CONNECTION_STATE, "Landroidx/navigation/NavigatorState;", "popBackStack", "popUpTo", "savedState", "", "Companion", "Destination", "navigation-fragment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DialogFragmentNavigator extends Navigator<Destination> {
    private static final Companion Companion = null;

    @Deprecated
    private static final String TAG = "DialogFragmentNavigator";
    private final Context context;
    private final FragmentManager fragmentManager;
    private final LifecycleEventObserver observer;
    private final Set<String> restoredTagsAwaitingAttach;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/navigation/fragment/DialogFragmentNavigator$Companion;", "", "()V", "TAG", "", "navigation-fragment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0015\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0007¢\u0006\u0002\u0010\bJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0017J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u001b"}, d2 = {"Landroidx/navigation/fragment/DialogFragmentNavigator$Destination;", "Landroidx/navigation/NavDestination;", "Landroidx/navigation/FloatingWindow;", "navigatorProvider", "Landroidx/navigation/NavigatorProvider;", "(Landroidx/navigation/NavigatorProvider;)V", "fragmentNavigator", "Landroidx/navigation/Navigator;", "(Landroidx/navigation/Navigator;)V", "_className", "", "className", "getClassName", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "onInflate", "", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "setClassName", "navigation-fragment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @NavDestination.ClassType(DialogFragment.class)
    public static class Destination extends NavDestination implements FloatingWindow {
        private String _className;

        public Destination(Navigator<? extends Destination> r2) {
            o.f(r2, "fragmentNavigator");
            super(r2);
        }

        public Destination(NavigatorProvider r2) {
            o.f(r2, "navigatorProvider");
            this(r2.getNavigator(DialogFragmentNavigator.class));
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
            throw new IllegalStateException("DialogFragment class was not set".toString());
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
            TypedArray r4 = r2.getResources().obtainAttributes(r3, R.styleable.DialogFragmentNavigator);
            o.e(r4, "context.resources.obtain…ntNavigator\n            )");
            String r5 = r4.getString(R.styleable.DialogFragmentNavigator_android_name);
            if (r5 == null) goto L5;
            setClassName(r5);
        L5:
            r4.recycle();
        }

        public final Destination setClassName(String r2) {
            o.f(r2, "className");
            this._className = r2;
            return this;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public DialogFragmentNavigator(Context r2, FragmentManager r3) {
        o.f(r2, "context");
        o.f(r3, "fragmentManager");
        this.context = r2;
        this.fragmentManager = r3;
        this.restoredTagsAwaitingAttach = new LinkedHashSet();
        this.observer = new b(this);
    }

    public static /* synthetic */ void a(DialogFragmentNavigator r0, FragmentManager r1, Fragment r2) {
        m35onAttach$lambda5(r0, r1, r2);
    }

    public static /* synthetic */ void b(DialogFragmentNavigator r0, LifecycleOwner r1, Lifecycle.Event r2) {
        m34observer$lambda3(r0, r1, r2);
    }

    private final void navigate(NavBackStackEntry r5) {
        Destination r0 = (Destination) r5.getDestination();
        String r1 = r0.getClassName();
        if (r1.charAt(0) != '.') goto L5;
        r1 = this.context.getPackageName() + r1;
    L5:
        Fragment r2 = this.fragmentManager.getFragmentFactory().instantiate(this.context.getClassLoader(), r1);
        o.e(r2, "fragmentManager.fragment…ader, className\n        )");
        if (DialogFragment.class.isAssignableFrom(r2.getClass()) == false) goto L10;
        DialogFragment r3 = (DialogFragment) r2;
        r3.setArguments(r5.getArguments());
        r3.getLifecycle().addObserver(this.observer);
        r3.show(this.fragmentManager, r5.getId());
        getState().push(r5);
        return;
    L10:
        throw new IllegalArgumentException(("Dialog destination " + r0.getClassName() + " is not an instance of DialogFragment").toString());
    }

    /* JADX INFO: renamed from: observer$lambda-3, reason: not valid java name */
    private static final void m34observer$lambda3(DialogFragmentNavigator r5, LifecycleOwner r6, Lifecycle.Event r7) {
        o.f(r5, "this$0");
        o.f(r6, "source");
        o.f(r7, NotificationCompat.CATEGORY_EVENT);
        boolean r1 = false;
        if (r7 != Lifecycle.Event.ON_CREATE) goto L18;
        DialogFragment r8 = (DialogFragment) r6;
        List<NavBackStackEntry> r9 = r5.getState().getBackStack().getValue();
        if ((r9 instanceof Collection) == true) goto L7;
    L9:
        Iterator<T> r10 = r9.iterator();
    L11:
        if (r10.hasNext() == false) goto L15;
        if (o.a(((NavBackStackEntry) r10.next()).getId(), r8.getTag()) == false) goto L11;
        r1 = true;
    L15:
        if (r1 == true) goto L36;
        r8.dismiss();
        return;
    L36:
        return;
    L7:
        if (r9.isEmpty() == false) goto L9;
    L18:
        if (r7 != Lifecycle.Event.ON_STOP) goto L44;
        DialogFragment r11 = (DialogFragment) r6;
        if (r11.requireDialog().isShowing() == true) goto L45;
        List<NavBackStackEntry> r12 = r5.getState().getBackStack().getValue();
        ListIterator<NavBackStackEntry> r0 = r12.listIterator(r12.size());
    L23:
        if (r0.hasPrevious() == false) goto L27;
        NavBackStackEntry r2 = r0.previous();
        if (o.a(r2.getId(), r11.getTag()) == false) goto L23;
    L29:
        if (r2 == null) goto L35;
        NavBackStackEntry r3 = r2;
        if (o.a(r.d0(r12), r3) == true) goto L33;
        Log.i(TAG, "Dialog " + r11 + " was dismissed while it was not the top of the back stack, popping all dialogs above this dismissed dialog");
    L33:
        r5.popBackStack(r3, false);
        return;
    L35:
        throw new IllegalStateException(("Dialog " + r11 + " has already been popped off of the Navigation back stack").toString());
    L27:
        r2 = null;
        goto L29
    L45:
        return;
    }

    /* JADX INFO: renamed from: onAttach$lambda-5, reason: not valid java name */
    private static final void m35onAttach$lambda5(DialogFragmentNavigator r1, FragmentManager r2, Fragment r3) {
        o.f(r1, "this$0");
        o.f(r2, "<anonymous parameter 0>");
        o.f(r3, "childFragment");
        Set<String> r4 = r1.restoredTagsAwaitingAttach;
        String r0 = r3.getTag();
        if (j0.a(r4).remove(r0) == false) goto L6;
        r3.getLifecycle().addObserver(r1.observer);
        return;
    }

    @Override // androidx.navigation.Navigator
    public /* bridge */ /* synthetic */ NavDestination createDestination() {
        return createDestination();
    }

    @Override // androidx.navigation.Navigator
    public Destination createDestination() {
        return new Destination(this);
    }

    @Override // androidx.navigation.Navigator
    public void navigate(List<NavBackStackEntry> r1, NavOptions r2, Navigator.Extras r3) {
        o.f(r1, "entries");
        if (this.fragmentManager.isStateSaved() == false) goto L6;
        Log.i(TAG, "Ignoring navigate() call: FragmentManager has already saved its state");
        return;
    L6:
        Iterator<NavBackStackEntry> r4 = r1.iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        navigate(r4.next());
        goto L8
    }

    @Override // androidx.navigation.Navigator
    public void onAttach(NavigatorState r4) {
        o.f(r4, WsConstants.KEY_CONNECTION_STATE);
        super.onAttach(r4);
        Iterator<NavBackStackEntry> r5 = r4.getBackStack().getValue().iterator();
    L4:
        if (r5.hasNext() == false) goto L11;
        NavBackStackEntry r0 = r5.next();
        DialogFragment r1 = (DialogFragment) this.fragmentManager.findFragmentByTag(r0.getId());
        if (r1 == null) goto L10;
        Lifecycle r2 = r1.getLifecycle();
        if (r2 == null) goto L10;
        r2.addObserver(this.observer);
    L10:
        this.restoredTagsAwaitingAttach.add(r0.getId());
        goto L4
    L11:
        this.fragmentManager.addFragmentOnAttachListener(new a(this));
    }

    @Override // androidx.navigation.Navigator
    public void popBackStack(NavBackStackEntry r5, boolean r6) {
        o.f(r5, "popUpTo");
        if (this.fragmentManager.isStateSaved() == false) goto L6;
        Log.i(TAG, "Ignoring popBackStack() call: FragmentManager has already saved its state");
        return;
    L6:
        List<NavBackStackEntry> r0 = getState().getBackStack().getValue();
        Iterator r1 = r.m0(r0.subList(r0.indexOf(r5), r0.size())).iterator();
    L8:
        if (r1.hasNext() == false) goto L12;
        NavBackStackEntry r2 = (NavBackStackEntry) r1.next();
        Fragment r3 = this.fragmentManager.findFragmentByTag(r2.getId());
        if (r3 == null) goto L8;
        r3.getLifecycle().removeObserver(this.observer);
        ((DialogFragment) r3).dismiss();
        goto L8
    L12:
        getState().pop(r5, r6);
    }
}
