package androidx.navigation.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.annotation.CallSuper;
import androidx.annotation.NavigationRes;
import androidx.annotation.RestrictTo;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelStore;
import androidx.navigation.NavController;
import androidx.navigation.NavHost;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigation;
import androidx.navigation.Navigator;
import androidx.navigation.NavigatorProvider;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.d.g;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 02\u00020\u00012\u00020\u0002:\u00010B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00170\u0016H\u0015J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0017J\u0012\u0010\u001c\u001a\u00020\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0017J\u0010\u0010\u001f\u001a\u00020\u00192\u0006\u0010\r\u001a\u00020\u000eH\u0015J\u0010\u0010 \u001a\u00020\u00192\u0006\u0010\u0011\u001a\u00020\u0012H\u0015J&\u0010!\u001a\u0004\u0018\u00010\u00142\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010&\u001a\u00020\u0019H\u0016J\"\u0010'\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020)2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0017J\u0010\u0010*\u001a\u00020\u00192\u0006\u0010+\u001a\u00020\tH\u0017J\u0010\u0010,\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\u001eH\u0017J\u001a\u0010.\u001a\u00020\u00192\u0006\u0010/\u001a\u00020\u00142\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016R\u0014\u0010\u0004\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\fR\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Landroidx/navigation/fragment/NavHostFragment;", "Landroidx/fragment/app/Fragment;", "Landroidx/navigation/NavHost;", "()V", "containerId", "", "getContainerId", "()I", "defaultNavHost", "", "graphId", "isPrimaryBeforeOnCreate", "Ljava/lang/Boolean;", "navController", "Landroidx/navigation/NavController;", "getNavController", "()Landroidx/navigation/NavController;", "navHostController", "Landroidx/navigation/NavHostController;", "viewParent", "Landroid/view/View;", "createFragmentNavigator", "Landroidx/navigation/Navigator;", "Landroidx/navigation/fragment/FragmentNavigator$Destination;", "onAttach", "", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateNavController", "onCreateNavHostController", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onInflate", "attrs", "Landroid/util/AttributeSet;", "onPrimaryNavigationFragmentChanged", "isPrimaryNavigationFragment", "onSaveInstanceState", "outState", "onViewCreated", "view", "Companion", "navigation-fragment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class NavHostFragment extends Fragment implements NavHost {
    public static final Companion Companion = null;
    private static final String KEY_DEFAULT_NAV_HOST = "android-support-nav:fragment:defaultHost";

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String KEY_GRAPH_ID = "android-support-nav:fragment:graphId";
    private static final String KEY_NAV_CONTROLLER_STATE = "android-support-nav:fragment:navControllerState";

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String KEY_START_DESTINATION_ARGS = "android-support-nav:fragment:startDestinationArgs";
    private boolean defaultNavHost;
    private int graphId;
    private Boolean isPrimaryBeforeOnCreate;
    private NavHostController navHostController;
    private View viewParent;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00048\u0006X\u0087T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/navigation/fragment/NavHostFragment$Companion;", "", "()V", "KEY_DEFAULT_NAV_HOST", "", "KEY_GRAPH_ID", "KEY_NAV_CONTROLLER_STATE", "KEY_START_DESTINATION_ARGS", "create", "Landroidx/navigation/fragment/NavHostFragment;", "graphResId", "", "startDestinationArgs", "Landroid/os/Bundle;", "findNavController", "Landroidx/navigation/NavController;", "fragment", "Landroidx/fragment/app/Fragment;", "navigation-fragment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g r1) {
            this();
        }

        public static /* synthetic */ NavHostFragment create$default(Companion r0, int r1, Bundle r2, int r3, Object r4) {
            if ((r3 & 2) == 0) goto L6;
            r2 = null;
        L6:
            return r0.create(r1, r2);
        }

        public final NavHostFragment create(@NavigationRes int r3) {
            return create$default(this, r3, null, 2, null);
        }

        public final NavHostFragment create(@NavigationRes int r2, Bundle r3) {
            if (r2 == 0) goto L4;
            Bundle r1 = new Bundle();
            r1.putInt(NavHostFragment.KEY_GRAPH_ID, r2);
        L5:
            if (r3 == null) goto L9;
            if (r1 != null) goto L8;
            r1 = new Bundle();
        L8:
            r1.putBundle(NavHostFragment.KEY_START_DESTINATION_ARGS, r3);
        L9:
            NavHostFragment r4 = new NavHostFragment();
            if (r1 == null) goto L12;
            r4.setArguments(r1);
        L12:
            return r4;
        L4:
            r1 = null;
            goto L5
        }

        public final NavController findNavController(Fragment r4) {
            o.f(r4, "fragment");
            Fragment r3 = r4;
        L3:
            if (r3 == null) goto L13;
            if ((r3 instanceof NavHostFragment) == true) goto L6;
            Fragment r0 = r3.getParentFragmentManager().getPrimaryNavigationFragment();
            if ((r0 instanceof NavHostFragment) == true) goto L10;
            r3 = r3.getParentFragment();
            goto L3
        L10:
            NavHostController r5 = NavHostFragment.access$getNavHostController$p((NavHostFragment) r0);
            Objects.requireNonNull(r5, "null cannot be cast to non-null type androidx.navigation.NavController");
            return r5;
        L6:
            NavHostController r6 = NavHostFragment.access$getNavHostController$p((NavHostFragment) r3);
            Objects.requireNonNull(r6, "null cannot be cast to non-null type androidx.navigation.NavController");
            return r6;
        L13:
            View r7 = r4.getView();
            if (r7 != null) goto L16;
            View r1 = null;
            if ((r4 instanceof DialogFragment) == false) goto L20;
            DialogFragment r8 = (DialogFragment) r4;
        L21:
            if (r8 == null) goto L27;
            Dialog r9 = r8.getDialog();
            if (r9 == null) goto L27;
            Window r10 = r9.getWindow();
            if (r10 == null) goto L27;
            r1 = r10.getDecorView();
        L27:
            if (r1 == null) goto L31;
            return Navigation.findNavController(r1);
        L31:
            throw new IllegalStateException("Fragment " + r4 + " does not have a NavController set");
        L20:
            r8 = null;
            goto L21
        L16:
            return Navigation.findNavController(r7);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public NavHostFragment() {
    }

    public static final /* synthetic */ NavHostController access$getNavHostController$p(NavHostFragment r0) {
        return r0.navHostController;
    }

    public static final NavHostFragment create(@NavigationRes int r1) {
        return Companion.create(r1);
    }

    public static final NavHostFragment create(@NavigationRes int r1, Bundle r2) {
        return Companion.create(r1, r2);
    }

    public static final NavController findNavController(Fragment r1) {
        return Companion.findNavController(r1);
    }

    private final int getContainerId() {
        int r1 = getId();
        if (r1 == 0) goto L8;
        if (r1 == (-1)) goto L8;
        return r1;
    L8:
        return R.id.nav_host_fragment_container;
    }

    protected Navigator<? extends FragmentNavigator.Destination> createFragmentNavigator() {
        Context r1 = requireContext();
        o.e(r1, "requireContext()");
        FragmentManager r2 = getChildFragmentManager();
        o.e(r2, "childFragmentManager");
        return new FragmentNavigator(r1, r2, getContainerId());
    }

    @Override // androidx.navigation.NavHost
    public final NavController getNavController() {
        NavHostController r1 = this.navHostController;
        if (r1 == null) goto L7;
        Objects.requireNonNull(r1, "null cannot be cast to non-null type androidx.navigation.NavHostController");
        return r1;
    L7:
        throw new IllegalStateException("NavController is not available before onCreate()".toString());
    }

    @Override // androidx.fragment.app.Fragment
    @CallSuper
    public void onAttach(Context r2) {
        o.f(r2, "context");
        super.onAttach(r2);
        if (this.defaultNavHost == false) goto L6;
        getParentFragmentManager().beginTransaction().setPrimaryNavigationFragment(this).commit();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    @CallSuper
    public void onCreate(Bundle r7) {
        Context r0 = requireContext();
        o.e(r0, "requireContext()");
        NavHostController r1 = new NavHostController(r0);
        this.navHostController = r1;
        o.c(r1);
        r1.setLifecycleOwner(this);
        Object r2 = r0;
    L4:
        if ((r2 instanceof ContextWrapper) == false) goto L9;
        if ((r2 instanceof OnBackPressedDispatcherOwner) == true) goto L7;
        Context r3 = ((ContextWrapper) r2).getBaseContext();
        o.e(r3, "context.baseContext");
        r2 = r3;
        goto L4
    L7:
        NavHostController r4 = this.navHostController;
        o.c(r4);
        OnBackPressedDispatcher r5 = ((OnBackPressedDispatcherOwner) r2).getOnBackPressedDispatcher();
        o.e(r5, "context as OnBackPressed…).onBackPressedDispatcher");
        r4.setOnBackPressedDispatcher(r5);
    L9:
        NavHostController r6 = this.navHostController;
        o.c(r6);
        Boolean r8 = this.isPrimaryBeforeOnCreate;
        int r9 = 0;
        if (r8 == null) goto L14;
        Objects.requireNonNull(r8, "null cannot be cast to non-null type kotlin.Boolean");
        if (r8.booleanValue() == false) goto L14;
        boolean r10 = true;
    L15:
        r6.enableOnBackPressed(r10);
        Bundle r11 = null;
        this.isPrimaryBeforeOnCreate = null;
        NavHostController r12 = this.navHostController;
        o.c(r12);
        ViewModelStore r13 = getViewModelStore();
        o.e(r13, "viewModelStore");
        r12.setViewModelStore(r13);
        NavHostController r14 = this.navHostController;
        o.c(r14);
        onCreateNavHostController(r14);
        if (r7 == null) goto L21;
        Bundle r15 = r7.getBundle(KEY_NAV_CONTROLLER_STATE);
        if (r7.getBoolean(KEY_DEFAULT_NAV_HOST, false) == false) goto L20;
        this.defaultNavHost = true;
        getParentFragmentManager().beginTransaction().setPrimaryNavigationFragment(this).commit();
    L20:
        this.graphId = r7.getInt(KEY_GRAPH_ID);
    L22:
        if (r15 == null) goto L25;
        NavHostController r16 = this.navHostController;
        o.c(r16);
        r16.restoreState(r15);
    L25:
        if (this.graphId == 0) goto L27;
        NavHostController r17 = this.navHostController;
        o.c(r17);
        r17.setGraph(this.graphId);
    L34:
        super.onCreate(r7);
        return;
    L27:
        Bundle r18 = getArguments();
        if (r18 == null) goto L30;
        r9 = r18.getInt(KEY_GRAPH_ID);
    L30:
        if (r18 == null) goto L32;
        r11 = r18.getBundle(KEY_START_DESTINATION_ARGS);
    L32:
        if (r9 == 0) goto L34;
        NavHostController r19 = this.navHostController;
        o.c(r19);
        r19.setGraph(r9, r11);
        goto L34
    L21:
        r15 = null;
    L14:
        r10 = false;
        goto L15
    }

    @CallSuper
    protected void onCreateNavController(NavController r6) {
        o.f(r6, "navController");
        NavigatorProvider r0 = r6.getNavigatorProvider();
        Context r2 = requireContext();
        o.e(r2, "requireContext()");
        FragmentManager r3 = getChildFragmentManager();
        o.e(r3, "childFragmentManager");
        r0.addNavigator(new DialogFragmentNavigator(r2, r3));
        r6.getNavigatorProvider().addNavigator(createFragmentNavigator());
    }

    @CallSuper
    protected void onCreateNavHostController(NavHostController r2) {
        o.f(r2, "navHostController");
        onCreateNavController(r2);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        o.f(r1, "inflater");
        Context r4 = r1.getContext();
        o.e(r4, "inflater.context");
        FragmentContainerView r5 = new FragmentContainerView(r4);
        r5.setId(getContainerId());
        return r5;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        View r0 = this.viewParent;
        if (r0 != null) goto L5;
    L7:
        this.viewParent = null;
        return;
    L5:
        if (Navigation.findNavController(r0) != this.navHostController) goto L7;
        Navigation.setViewNavController(r0, null);
        goto L7
    }

    @Override // androidx.fragment.app.Fragment
    @CallSuper
    public void onInflate(Context r3, AttributeSet r4, Bundle r5) {
        o.f(r3, "context");
        o.f(r4, "attrs");
        super.onInflate(r3, r4, r5);
        TypedArray r6 = r3.obtainStyledAttributes(r4, androidx.navigation.R.styleable.NavHost);
        o.e(r6, "context.obtainStyledAttr…yleable.NavHost\n        )");
        int r0 = r6.getResourceId(androidx.navigation.R.styleable.NavHost_navGraph, 0);
        if (r0 == 0) goto L5;
        this.graphId = r0;
    L5:
        f0 r1 = f0.f18324a;
        r6.recycle();
        TypedArray r7 = r3.obtainStyledAttributes(r4, R.styleable.NavHostFragment);
        o.e(r7, "context.obtainStyledAttr…tyleable.NavHostFragment)");
        if (r7.getBoolean(R.styleable.NavHostFragment_defaultNavHost, false) == false) goto L8;
        this.defaultNavHost = true;
    L8:
        r7.recycle();
    }

    @Override // androidx.fragment.app.Fragment
    @CallSuper
    public void onPrimaryNavigationFragmentChanged(boolean r2) {
        NavHostController r0 = this.navHostController;
        if (r0 == null) goto L6;
        if (r0 == null) goto L8;
        r0.enableOnBackPressed(r2);
        return;
    L8:
        return;
    L6:
        this.isPrimaryBeforeOnCreate = Boolean.valueOf(r2);
    }

    @Override // androidx.fragment.app.Fragment
    @CallSuper
    public void onSaveInstanceState(Bundle r3) {
        o.f(r3, "outState");
        super.onSaveInstanceState(r3);
        NavHostController r0 = this.navHostController;
        o.c(r0);
        Bundle r1 = r0.saveState();
        if (r1 == null) goto L6;
        r3.putBundle(KEY_NAV_CONTROLLER_STATE, r1);
    L6:
        if (this.defaultNavHost == false) goto L8;
        r3.putBoolean(KEY_DEFAULT_NAV_HOST, true);
    L8:
        int r2 = this.graphId;
        if (r2 == 0) goto L12;
        r3.putInt(KEY_GRAPH_ID, r2);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r2, Bundle r3) {
        o.f(r2, "view");
        super.onViewCreated(r2, r3);
        if ((r2 instanceof ViewGroup) == false) goto L11;
        Navigation.setViewNavController(r2, this.navHostController);
        if (r2.getParent() == null) goto L12;
        Object r4 = r2.getParent();
        Objects.requireNonNull(r4, "null cannot be cast to non-null type android.view.View");
        View r5 = (View) r4;
        this.viewParent = r5;
        o.c(r5);
        if (r5.getId() != getId()) goto L13;
        View r6 = this.viewParent;
        o.c(r6);
        Navigation.setViewNavController(r6, this.navHostController);
        return;
    L13:
        return;
    L12:
        return;
    L11:
        throw new IllegalStateException(("created host view " + r2 + " is not a ViewGroup").toString());
    }
}
