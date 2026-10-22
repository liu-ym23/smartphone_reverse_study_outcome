package androidx.navigation;

import android.os.Bundle;
import androidx.annotation.CallSuper;
import androidx.navigation.NavDestination;
import com.bytedance.common.wschannel.WsConstants;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.i0.r;
import kotlin.n0.c.l;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.t0.k;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0002%&B\u0005¢\u0006\u0002\u0010\u0004J\r\u0010\u000e\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u000fJ5\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00028\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0002\u0010\u0018J*\u0010\u0010\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u000b\u001a\u00020\u0006H\u0017J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u001cH\u0016J\u0010\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u0013H\u0016J\n\u0010\"\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010#\u001a\u00020\bH\u0016J\u0018\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\bH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00068DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006'"}, d2 = {"Landroidx/navigation/Navigator;", "D", "Landroidx/navigation/NavDestination;", "", "()V", "_state", "Landroidx/navigation/NavigatorState;", "<set-?>", "", "isAttached", "()Z", WsConstants.KEY_CONNECTION_STATE, "getState", "()Landroidx/navigation/NavigatorState;", "createDestination", "()Landroidx/navigation/NavDestination;", "navigate", "destination", "args", "Landroid/os/Bundle;", "navOptions", "Landroidx/navigation/NavOptions;", "navigatorExtras", "Landroidx/navigation/Navigator$Extras;", "(Landroidx/navigation/NavDestination;Landroid/os/Bundle;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)Landroidx/navigation/NavDestination;", "", "entries", "", "Landroidx/navigation/NavBackStackEntry;", "onAttach", "onLaunchSingleTop", "backStackEntry", "onRestoreState", "savedState", "onSaveState", "popBackStack", "popUpTo", "Extras", "Name", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class Navigator<D extends NavDestination> {
    private NavigatorState _state;
    private boolean isAttached;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Landroidx/navigation/Navigator$Extras;", "", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Extras {
    }

    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\u0002\u0018\u00002\u00020\u0001B\b\u0012\u0006\u0010\u0002\u001a\u00020\u0003R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroidx/navigation/Navigator$Name;", "", "value", "", "()Ljava/lang/String;", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Name {
        String value();
    }

    /* JADX INFO: renamed from: androidx.navigation.Navigator$navigate$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Landroidx/navigation/NavBackStackEntry;", "D", "Landroidx/navigation/NavDestination;", "backStackEntry", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class AnonymousClass1 extends q implements l<NavBackStackEntry, NavBackStackEntry> {
        final /* synthetic */ NavOptions $navOptions;
        final /* synthetic */ Extras $navigatorExtras;
        final /* synthetic */ Navigator<D> this$0;

        AnonymousClass1(Navigator<D> r1, NavOptions r2, Extras r3) {
            this.this$0 = r1;
            this.$navOptions = r2;
            this.$navigatorExtras = r3;
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final NavBackStackEntry invoke2(NavBackStackEntry r7) {
            o.f(r7, "backStackEntry");
            NavDestination r0 = r7.getDestination();
            if ((r0 instanceof NavDestination) == true) goto L6;
            r0 = null;
        L6:
            if (r0 != null) goto L8;
            return null;
        L8:
            NavDestination r1 = this.this$0.navigate(r0, r7.getArguments(), this.$navOptions, this.$navigatorExtras);
            if (r1 != null) goto L12;
            return null;
        L12:
            if (o.a(r1, r0) == false) goto L15;
            return r7;
        L15:
            return this.this$0.getState().createBackStackEntry(r1, r1.addInDefaultArgs(r7.getArguments()));
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ NavBackStackEntry invoke(NavBackStackEntry r1) {
            return invoke2(r1);
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.Navigator$onLaunchSingleTop$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "D", "Landroidx/navigation/NavDestination;", "Landroidx/navigation/NavOptionsBuilder;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class C06361 extends q implements l<NavOptionsBuilder, f0> {
        public static final C06361 INSTANCE = null;

        static {
            INSTANCE = new C06361();
        }

        C06361() {
            super(1);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(NavOptionsBuilder r1) {
            invoke2(r1);
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(NavOptionsBuilder r1) {
            o.f(r1, "$this$navOptions");
            r1.setLaunchSingleTop(true);
        }
    }

    public Navigator() {
    }

    public abstract D createDestination();

    protected final NavigatorState getState() {
        NavigatorState r1 = this._state;
        if (r1 == null) goto L6;
        return r1;
    L6:
        throw new IllegalStateException("You cannot access the Navigator's state until the Navigator is attached".toString());
    }

    public final boolean isAttached() {
        return this.isAttached;
    }

    public NavDestination navigate(D r1, Bundle r2, NavOptions r3, Extras r4) {
        o.f(r1, "destination");
        return r1;
    }

    public void navigate(List<NavBackStackEntry> r2, NavOptions r3, Extras r4) {
        o.f(r2, "entries");
        Iterator r5 = k.p(k.t(r.I(r2), new AnonymousClass1(this, r3, r4))).iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        NavBackStackEntry r6 = (NavBackStackEntry) r5.next();
        getState().push(r6);
        goto L4
    }

    @CallSuper
    public void onAttach(NavigatorState r2) {
        o.f(r2, WsConstants.KEY_CONNECTION_STATE);
        this._state = r2;
        this.isAttached = true;
    }

    public void onLaunchSingleTop(NavBackStackEntry r4) {
        o.f(r4, "backStackEntry");
        NavDestination r0 = r4.getDestination();
        if ((r0 instanceof NavDestination) == true) goto L6;
        r0 = null;
    L6:
        if (r0 != null) goto L8;
        return;
    L8:
        navigate(r0, null, NavOptionsBuilderKt.navOptions(C06361.INSTANCE), null);
        getState().onLaunchSingleTop(r4);
    }

    public void onRestoreState(Bundle r1) {
        o.f(r1, "savedState");
    }

    public Bundle onSaveState() {
        return null;
    }

    public void popBackStack(NavBackStackEntry r4, boolean r5) {
        o.f(r4, "popUpTo");
        List<NavBackStackEntry> r0 = getState().getBackStack().getValue();
        if (r0.contains(r4) == false) goto L14;
        ListIterator<NavBackStackEntry> r1 = r0.listIterator(r0.size());
        NavBackStackEntry r2 = null;
    L6:
        if (popBackStack() == false) goto L10;
        r2 = r1.previous();
        if (o.a(r2, r4) == false) goto L6;
    L10:
        if (r2 == null) goto L18;
        getState().pop(r2, r5);
        return;
    L18:
        return;
    L14:
        throw new IllegalStateException(("popBackStack was called with " + r4 + " which does not exist in back stack " + r0).toString());
    }

    public boolean popBackStack() {
        return true;
    }
}
