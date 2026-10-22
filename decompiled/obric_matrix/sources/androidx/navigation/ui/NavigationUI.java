package androidx.navigation.ui;

import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.IdRes;
import androidx.annotation.RestrictTo;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.widget.Openable;
import androidx.navigation.ActivityNavigator;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import androidx.navigation.NavOptions;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\nH\u0007J \u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\bH\u0007J\"\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\"\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007J\"\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\"\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007J*\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J*\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007J\u0018\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\t\u001a\u00020\nH\u0007J \u0010\u0017\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\bH\u0007J\u0018\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020\nH\u0007J \u0010\u0017\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\bH\u0007J\u001b\u0010 \u001a\u00020\b*\u00020!2\b\b\u0001\u0010\"\u001a\u00020#H\u0001¢\u0006\u0002\b$J!\u0010%\u001a\u00020\b*\u00020!2\u000e\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0'H\u0001¢\u0006\u0002\b(¨\u0006)"}, d2 = {"Landroidx/navigation/ui/NavigationUI;", "", "()V", "findBottomSheetBehavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "view", "Landroid/view/View;", "navigateUp", "", "navController", "Landroidx/navigation/NavController;", "openableLayout", "Landroidx/customview/widget/Openable;", "configuration", "Landroidx/navigation/ui/AppBarConfiguration;", "onNavDestinationSelected", "item", "Landroid/view/MenuItem;", "saveState", "setupActionBarWithNavController", "", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "setupWithNavController", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "collapsingToolbarLayout", "Lcom/google/android/material/appbar/CollapsingToolbarLayout;", "navigationBarView", "Lcom/google/android/material/navigation/NavigationBarView;", "navigationView", "Lcom/google/android/material/navigation/NavigationView;", "matchDestination", "Landroidx/navigation/NavDestination;", "destId", "", "matchDestination$navigation_ui_release", "matchDestinations", "destinationIds", "", "matchDestinations$navigation_ui_release", "navigation-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NavigationUI {
    public static final NavigationUI INSTANCE = null;

    static {
        INSTANCE = new NavigationUI();
    }

    private NavigationUI() {
    }

    public static /* synthetic */ void a(NavController r0, AppBarConfiguration r1, View r2) {
        m36setupWithNavController$lambda1(r0, r1, r2);
    }

    public static /* synthetic */ boolean b(NavController r0, NavigationView r1, MenuItem r2) {
        return m38setupWithNavController$lambda3(r0, r1, r2);
    }

    public static /* synthetic */ boolean c(NavController r0, MenuItem r1) {
        return m40setupWithNavController$lambda6(r0, r1);
    }

    public static /* synthetic */ boolean d(NavController r0, boolean r1, MenuItem r2) {
        return m41setupWithNavController$lambda8(r0, r1, r2);
    }

    public static /* synthetic */ boolean e(NavController r0, boolean r1, NavigationView r2, MenuItem r3) {
        return m39setupWithNavController$lambda5(r0, r1, r2, r3);
    }

    public static /* synthetic */ void f(NavController r0, AppBarConfiguration r1, View r2) {
        m37setupWithNavController$lambda2(r0, r1, r2);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final BottomSheetBehavior<?> findBottomSheetBehavior(View r3) {
        o.f(r3, "view");
        ViewGroup.LayoutParams r0 = r3.getLayoutParams();
        if ((r0 instanceof CoordinatorLayout.LayoutParams) == true) goto L8;
        Object r4 = r3.getParent();
        if ((r4 instanceof View) == true) goto L7;
        return null;
    L7:
        return findBottomSheetBehavior((View) r4);
    L8:
        CoordinatorLayout.Behavior r5 = ((CoordinatorLayout.LayoutParams) r0).getBehavior();
        if ((r5 instanceof BottomSheetBehavior) == true) goto L12;
        return null;
    L12:
        return (BottomSheetBehavior) r5;
    }

    public static final boolean matchDestination$navigation_ui_release(NavDestination r3, @IdRes int r4) {
        o.f(r3, "<this>");
        Iterator<NavDestination> r5 = NavDestination.Companion.getHierarchy(r3).iterator();
    L3:
        boolean r2 = false;
        if (r5.hasNext() == false) goto L11;
        if (r5.next().getId() != r4) goto L8;
        r2 = true;
    L8:
        if (r2 == false) goto L3;
        return true;
    L11:
        return false;
    }

    public static final boolean matchDestinations$navigation_ui_release(NavDestination r1, Set<Integer> r2) {
        o.f(r1, "<this>");
        o.f(r2, "destinationIds");
        Iterator<NavDestination> r3 = NavDestination.Companion.getHierarchy(r1).iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        if (r2.contains(Integer.valueOf(r3.next().getId())) == false) goto L4;
        return true;
    L8:
        return false;
    }

    public static final boolean navigateUp(NavController r2, Openable r3) {
        o.f(r2, "navController");
        return navigateUp(r2, new AppBarConfiguration.Builder(r2.getGraph()).setOpenableLayout(r3).build());
    }

    public static final boolean navigateUp(NavController r4, AppBarConfiguration r5) {
        o.f(r4, "navController");
        o.f(r5, "configuration");
        Openable r0 = r5.getOpenableLayout();
        NavDestination r1 = r4.getCurrentDestination();
        Set<Integer> r2 = r5.getTopLevelDestinations();
        if (r0 == null) goto L10;
        if (r1 == null) goto L10;
        if (matchDestinations$navigation_ui_release(r1, r2) == false) goto L10;
        r0.open();
        return true;
    L10:
        if (r4.navigateUp() == true) goto L18;
        AppBarConfiguration.OnNavigateUpListener r6 = r5.getFallbackOnNavigateUpListener();
        if (r6 != null) goto L17;
        return false;
    L17:
        return r6.onNavigateUp();
    L18:
        return true;
    }

    public static final boolean onNavDestinationSelected(MenuItem r5, NavController r6) {
        o.f(r5, "item");
        o.f(r6, "navController");
        boolean r1 = true;
        NavOptions.Builder r0 = new NavOptions.Builder().setLaunchSingleTop(true).setRestoreState(true);
        NavDestination r2 = r6.getCurrentDestination();
        o.c(r2);
        NavGraph r3 = r2.getParent();
        o.c(r3);
        if ((r3.findNode(r5.getItemId()) instanceof ActivityNavigator.Destination) == false) goto L5;
        NavOptions.Builder r4 = r0.setEnterAnim(R.anim.nav_default_enter_anim).setExitAnim(R.anim.nav_default_exit_anim).setPopEnterAnim(R.anim.nav_default_pop_enter_anim);
        int r7 = R.anim.nav_default_pop_exit_anim;
    L6:
        r4.setPopExitAnim(r7);
        if ((r5.getOrder() & 196608) != 0) goto L19;
        r0.setPopUpTo(NavGraph.Companion.findStartDestination(r6.getGraph()).getId(), false, true);
    L19:
        r6.navigate(r5.getItemId(), null, r0.build());     // Catch: IllegalArgumentException -> L18
        NavDestination r8 = r6.getCurrentDestination();     // Catch: IllegalArgumentException -> L18
        if (r8 == null) goto L15;
        if (matchDestination$navigation_ui_release(r8, r5.getItemId()) != true) goto L15;
    L17:
        return r1;
    L15:
        r1 = false;
    L21:
        return false;
    L5:
        r4 = r0.setEnterAnim(R.animator.nav_default_enter_anim).setExitAnim(R.animator.nav_default_exit_anim).setPopEnterAnim(R.animator.nav_default_pop_enter_anim);
        r7 = R.animator.nav_default_pop_exit_anim;
        goto L6
    }

    @NavigationUiSaveStateControl
    public static final boolean onNavDestinationSelected(MenuItem r7, NavController r8, boolean r9) {
        o.f(r7, "item");
        o.f(r8, "navController");
        boolean r0 = true;
        if ((!r9) == false) goto L21;
        NavOptions.Builder r10 = new NavOptions.Builder().setLaunchSingleTop(true);
        NavDestination r1 = r8.getCurrentDestination();
        o.c(r1);
        NavGraph r2 = r1.getParent();
        o.c(r2);
        if ((r2.findNode(r7.getItemId()) instanceof ActivityNavigator.Destination) == false) goto L7;
        NavOptions.Builder r3 = r10.setEnterAnim(R.anim.nav_default_enter_anim).setExitAnim(R.anim.nav_default_exit_anim).setPopEnterAnim(R.anim.nav_default_pop_enter_anim);
        int r4 = R.anim.nav_default_pop_exit_anim;
    L8:
        r3.setPopExitAnim(r4);
        if ((r7.getOrder() & 196608) != 0) goto L23;
        NavOptions.Builder.setPopUpTo$default(r10, NavGraph.Companion.findStartDestination(r8.getGraph()).getId(), false, false, 4, null);
    L23:
        r8.navigate(r7.getItemId(), null, r10.build());     // Catch: IllegalArgumentException -> L22
        NavDestination r11 = r8.getCurrentDestination();     // Catch: IllegalArgumentException -> L22
        if (r11 == null) goto L17;
        if (matchDestination$navigation_ui_release(r11, r7.getItemId()) != true) goto L17;
    L19:
        return r0;
    L17:
        r0 = false;
    L25:
        return false;
    L7:
        r3 = r10.setEnterAnim(R.animator.nav_default_enter_anim).setExitAnim(R.animator.nav_default_exit_anim).setPopEnterAnim(R.animator.nav_default_pop_enter_anim);
        r4 = R.animator.nav_default_pop_exit_anim;
        goto L8
    L21:
        throw new IllegalStateException("Leave the saveState parameter out entirely to use the non-experimental version of this API, which saves the state by default".toString());
    }

    public static final void setupActionBarWithNavController(AppCompatActivity r2, NavController r3) {
        o.f(r2, "activity");
        o.f(r3, "navController");
        setupActionBarWithNavController$default(r2, r3, null, 4, null);
    }

    public static final void setupActionBarWithNavController(AppCompatActivity r2, NavController r3, Openable r4) {
        o.f(r2, "activity");
        o.f(r3, "navController");
        setupActionBarWithNavController(r2, r3, new AppBarConfiguration.Builder(r3.getGraph()).setOpenableLayout(r4).build());
    }

    public static final void setupActionBarWithNavController(AppCompatActivity r1, NavController r2, AppBarConfiguration r3) {
        o.f(r1, "activity");
        o.f(r2, "navController");
        o.f(r3, "configuration");
        r2.addOnDestinationChangedListener(new ActionBarOnDestinationChangedListener(r1, r3));
    }

    public static /* synthetic */ void setupActionBarWithNavController$default(AppCompatActivity r0, NavController r1, AppBarConfiguration r2, int r3, Object r4) {
        if ((r3 & 4) == 0) goto L5;
        r2 = new AppBarConfiguration.Builder(r1.getGraph()).build();
    L5:
        setupActionBarWithNavController(r0, r1, r2);
    }

    public static final void setupWithNavController(Toolbar r2, NavController r3) {
        o.f(r2, "toolbar");
        o.f(r3, "navController");
        setupWithNavController$default(r2, r3, null, 4, null);
    }

    public static final void setupWithNavController(Toolbar r2, NavController r3, Openable r4) {
        o.f(r2, "toolbar");
        o.f(r3, "navController");
        setupWithNavController(r2, r3, new AppBarConfiguration.Builder(r3.getGraph()).setOpenableLayout(r4).build());
    }

    public static final void setupWithNavController(Toolbar r1, final NavController r2, final AppBarConfiguration r3) {
        o.f(r1, "toolbar");
        o.f(r2, "navController");
        o.f(r3, "configuration");
        r2.addOnDestinationChangedListener(new ToolbarOnDestinationChangedListener(r1, r3));
        r1.setNavigationOnClickListener(new a(r2, r3));
    }

    public static final void setupWithNavController(CollapsingToolbarLayout r7, Toolbar r8, NavController r9) {
        o.f(r7, "collapsingToolbarLayout");
        o.f(r8, "toolbar");
        o.f(r9, "navController");
        setupWithNavController$default(r7, r8, r9, null, 8, null);
    }

    public static final void setupWithNavController(CollapsingToolbarLayout r2, Toolbar r3, NavController r4, Openable r5) {
        o.f(r2, "collapsingToolbarLayout");
        o.f(r3, "toolbar");
        o.f(r4, "navController");
        setupWithNavController(r2, r3, r4, new AppBarConfiguration.Builder(r4.getGraph()).setOpenableLayout(r5).build());
    }

    public static final void setupWithNavController(CollapsingToolbarLayout r1, Toolbar r2, final NavController r3, final AppBarConfiguration r4) {
        o.f(r1, "collapsingToolbarLayout");
        o.f(r2, "toolbar");
        o.f(r3, "navController");
        o.f(r4, "configuration");
        r3.addOnDestinationChangedListener(new CollapsingToolbarOnDestinationChangedListener(r1, r2, r4));
        r2.setNavigationOnClickListener(new f(r3, r4));
    }

    public static final void setupWithNavController(NavigationBarView r1, final NavController r2) {
        o.f(r1, "navigationBarView");
        o.f(r2, "navController");
        r1.setOnItemSelectedListener(new c(r2));
        final WeakReference r0 = new WeakReference(r1);
        r2.addOnDestinationChangedListener(new AnonymousClass9(r0, r2));
    }

    @NavigationUiSaveStateControl
    public static final void setupWithNavController(NavigationBarView r1, final NavController r2, final boolean r3) {
        o.f(r1, "navigationBarView");
        o.f(r2, "navController");
        if ((!r3) == false) goto L7;
        r1.setOnItemSelectedListener(new d(r2, r3));
        final WeakReference r4 = new WeakReference(r1);
        r2.addOnDestinationChangedListener(new AnonymousClass12(r4, r2));
        return;
    L7:
        throw new IllegalStateException("Leave the saveState parameter out entirely to use the non-experimental version of this API, which saves the state by default".toString());
    }

    public static final void setupWithNavController(final NavigationView r1, final NavController r2) {
        o.f(r1, "navigationView");
        o.f(r2, "navController");
        r1.setNavigationItemSelectedListener(new b(r2, r1));
        final WeakReference r0 = new WeakReference(r1);
        r2.addOnDestinationChangedListener(new AnonymousClass4(r0, r2));
    }

    @NavigationUiSaveStateControl
    public static final void setupWithNavController(final NavigationView r1, final NavController r2, final boolean r3) {
        o.f(r1, "navigationView");
        o.f(r2, "navController");
        if ((!r3) == false) goto L7;
        r1.setNavigationItemSelectedListener(new e(r2, r3, r1));
        final WeakReference r4 = new WeakReference(r1);
        r2.addOnDestinationChangedListener(new AnonymousClass7(r4, r2));
        return;
    L7:
        throw new IllegalStateException("Leave the saveState parameter out entirely to use the non-experimental version of this API, which saves the state by default".toString());
    }

    public static /* synthetic */ void setupWithNavController$default(Toolbar r0, NavController r1, AppBarConfiguration r2, int r3, Object r4) {
        if ((r3 & 4) == 0) goto L5;
        r2 = new AppBarConfiguration.Builder(r1.getGraph()).build();
    L5:
        setupWithNavController(r0, r1, r2);
    }

    public static /* synthetic */ void setupWithNavController$default(CollapsingToolbarLayout r0, Toolbar r1, NavController r2, AppBarConfiguration r3, int r4, Object r5) {
        if ((r4 & 8) == 0) goto L5;
        r3 = new AppBarConfiguration.Builder(r2.getGraph()).build();
    L5:
        setupWithNavController(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: setupWithNavController$lambda-1, reason: not valid java name */
    private static final void m36setupWithNavController$lambda1(NavController r0, AppBarConfiguration r1, View r2) {
        o.f(r0, "$navController");
        o.f(r1, "$configuration");
        navigateUp(r0, r1);
    }

    /* JADX INFO: renamed from: setupWithNavController$lambda-2, reason: not valid java name */
    private static final void m37setupWithNavController$lambda2(NavController r0, AppBarConfiguration r1, View r2) {
        o.f(r0, "$navController");
        o.f(r1, "$configuration");
        navigateUp(r0, r1);
    }

    /* JADX INFO: renamed from: setupWithNavController$lambda-3, reason: not valid java name */
    private static final boolean m38setupWithNavController$lambda3(NavController r1, NavigationView r2, MenuItem r3) {
        o.f(r1, "$navController");
        o.f(r2, "$navigationView");
        o.f(r3, "item");
        boolean r4 = onNavDestinationSelected(r3, r1);
        if (r4 == false) goto L10;
        ViewParent r5 = r2.getParent();
        if ((r5 instanceof Openable) == false) goto L7;
        ((Openable) r5).close();
        goto L10
    L7:
        BottomSheetBehavior<?> r6 = findBottomSheetBehavior(r2);
        if (r6 == null) goto L10;
        r6.setState(5);
    L10:
        return r4;
    }

    /* JADX INFO: renamed from: setupWithNavController$lambda-5, reason: not valid java name */
    private static final boolean m39setupWithNavController$lambda5(NavController r1, boolean r2, NavigationView r3, MenuItem r4) {
        o.f(r1, "$navController");
        o.f(r3, "$navigationView");
        o.f(r4, "item");
        boolean r5 = onNavDestinationSelected(r4, r1, r2);
        if (r5 == false) goto L10;
        ViewParent r6 = r3.getParent();
        if ((r6 instanceof Openable) == false) goto L7;
        ((Openable) r6).close();
        goto L10
    L7:
        BottomSheetBehavior<?> r7 = findBottomSheetBehavior(r3);
        if (r7 == null) goto L10;
        r7.setState(5);
    L10:
        return r5;
    }

    /* JADX INFO: renamed from: setupWithNavController$lambda-6, reason: not valid java name */
    private static final boolean m40setupWithNavController$lambda6(NavController r1, MenuItem r2) {
        o.f(r1, "$navController");
        o.f(r2, "item");
        return onNavDestinationSelected(r2, r1);
    }

    /* JADX INFO: renamed from: setupWithNavController$lambda-8, reason: not valid java name */
    private static final boolean m41setupWithNavController$lambda8(NavController r1, boolean r2, MenuItem r3) {
        o.f(r1, "$navController");
        o.f(r3, "item");
        return onNavDestinationSelected(r3, r1, r2);
    }
}
