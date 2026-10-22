package androidx.navigation.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.annotation.CallSuper;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import androidx.slidingpanelayout.widget.SlidingPaneLayout;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001:\u0001&B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0016J$\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H&J$\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0007J\"\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0017J\u001a\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\u0018H\u0017J\u001a\u0010$\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0007J\u0012\u0010%\u001a\u00020\u001b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0017R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006'"}, d2 = {"Landroidx/navigation/fragment/AbstractListDetailFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_detailPaneNavHostFragment", "Landroidx/navigation/fragment/NavHostFragment;", "detailPaneNavHostFragment", "getDetailPaneNavHostFragment", "()Landroidx/navigation/fragment/NavHostFragment;", "graphId", "", "onBackPressedCallback", "Landroidx/activity/OnBackPressedCallback;", "slidingPaneLayout", "Landroidx/slidingpanelayout/widget/SlidingPaneLayout;", "getSlidingPaneLayout", "()Landroidx/slidingpanelayout/widget/SlidingPaneLayout;", "onCreateDetailPaneNavHostFragment", "onCreateListPaneView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "onInflate", "", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "onListPaneViewCreated", "view", "onSaveInstanceState", "outState", "onViewCreated", "onViewStateRestored", "InnerOnBackPressedCallback", "navigation-fragment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbstractListDetailFragment extends Fragment {
    private NavHostFragment _detailPaneNavHostFragment;
    private int graphId;
    private OnBackPressedCallback onBackPressedCallback;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/navigation/fragment/AbstractListDetailFragment$InnerOnBackPressedCallback;", "Landroidx/activity/OnBackPressedCallback;", "Landroidx/slidingpanelayout/widget/SlidingPaneLayout$PanelSlideListener;", "slidingPaneLayout", "Landroidx/slidingpanelayout/widget/SlidingPaneLayout;", "(Landroidx/slidingpanelayout/widget/SlidingPaneLayout;)V", "handleOnBackPressed", "", "onPanelClosed", "panel", "Landroid/view/View;", "onPanelOpened", "onPanelSlide", "slideOffset", "", "navigation-fragment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class InnerOnBackPressedCallback extends OnBackPressedCallback implements SlidingPaneLayout.PanelSlideListener {
        private final SlidingPaneLayout slidingPaneLayout;

        public InnerOnBackPressedCallback(SlidingPaneLayout r2) {
            o.f(r2, "slidingPaneLayout");
            super(true);
            this.slidingPaneLayout = r2;
            r2.addPanelSlideListener(this);
        }

        @Override // androidx.activity.OnBackPressedCallback
        public void handleOnBackPressed() {
            this.slidingPaneLayout.closePane();
        }

        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelClosed(View r2) {
            o.f(r2, "panel");
            setEnabled(false);
        }

        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelOpened(View r2) {
            o.f(r2, "panel");
            setEnabled(true);
        }

        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelSlide(View r1, float r2) {
            o.f(r1, "panel");
        }
    }

    public AbstractListDetailFragment() {
    }

    public static final /* synthetic */ OnBackPressedCallback access$getOnBackPressedCallback$p(AbstractListDetailFragment r0) {
        return r0.onBackPressedCallback;
    }

    public final NavHostFragment getDetailPaneNavHostFragment() {
        NavHostFragment r0 = this._detailPaneNavHostFragment;
        if (r0 == null) goto L7;
        Objects.requireNonNull(r0, "null cannot be cast to non-null type androidx.navigation.fragment.NavHostFragment");
        return r0;
    L7:
        throw new IllegalStateException(("Fragment " + this + " was called before onCreateView().").toString());
    }

    public final SlidingPaneLayout getSlidingPaneLayout() {
        return (SlidingPaneLayout) requireView();
    }

    public NavHostFragment onCreateDetailPaneNavHostFragment() {
        int r3 = this.graphId;
        if (r3 == 0) goto L7;
        return NavHostFragment.Companion.create$default(NavHostFragment.Companion, r3, null, 2, null);
    L7:
        return new NavHostFragment();
    }

    public abstract View onCreateListPaneView(LayoutInflater r1, ViewGroup r2, Bundle r3);

    @Override // androidx.fragment.app.Fragment
    @CallSuper
    public final View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        o.f(r4, "inflater");
        if (r6 == null) goto L5;
        this.graphId = r6.getInt(NavHostFragment.KEY_GRAPH_ID);
    L5:
        final SlidingPaneLayout r7 = new SlidingPaneLayout(r4.getContext());
        r7.setId(R.id.sliding_pane_layout);
        View r8 = onCreateListPaneView(r4, r7, r6);
        if (o.a(r8, r7) == false) goto L8;
    L10:
        Context r0 = r4.getContext();
        o.e(r0, "inflater.context");
        FragmentContainerView r9 = new FragmentContainerView(r0);
        int r1 = R.id.sliding_pane_detail_container;
        r9.setId(r1);
        SlidingPaneLayout.LayoutParams r2 = new SlidingPaneLayout.LayoutParams(r4.getContext().getResources().getDimensionPixelSize(R.dimen.sliding_pane_detail_pane_width), -1);
        r2.weight = 1.0f;
        r7.addView(r9, r2);
        Fragment r10 = getChildFragmentManager().findFragmentById(r1);
        boolean r11 = true;
        if (r10 == null) goto L13;
        NavHostFragment r12 = (NavHostFragment) r10;
    L14:
        this._detailPaneNavHostFragment = r12;
        this.onBackPressedCallback = new InnerOnBackPressedCallback(r7);
        if (ViewCompat.isLaidOut(r7) == true) goto L17;
    L25:
        r7.addOnLayoutChangeListener(new AbstractListDetailFragment$onCreateView$$inlined$doOnLayout$1(this, r7));
    L26:
        OnBackPressedDispatcher r13 = requireActivity().getOnBackPressedDispatcher();
        LifecycleOwner r14 = getViewLifecycleOwner();
        OnBackPressedCallback r3 = this.onBackPressedCallback;
        o.c(r3);
        r13.addCallback(r14, r3);
        return r7;
    L17:
        if (r7.isLayoutRequested() == true) goto L25;
        OnBackPressedCallback r15 = access$getOnBackPressedCallback$p(this);
        o.c(r15);
        if (r7.isSlideable() == true) goto L21;
    L23:
        r11 = false;
    L24:
        r15.setEnabled(r11);
        goto L26
    L21:
        if (r7.isOpen() == false) goto L23;
    L13:
        r12 = onCreateDetailPaneNavHostFragment();
        FragmentManager r16 = getChildFragmentManager();
        o.e(r16, "childFragmentManager");
        FragmentTransaction r17 = r16.beginTransaction();
        o.e(r17, "beginTransaction()");
        r17.setReorderingAllowed(true);
        r17.add(r1, r12);
        r17.commit();
        goto L14
    L8:
        if (o.a(r8.getParent(), r7) == true) goto L10;
        r7.addView(r8);
        goto L10
    }

    @Override // androidx.fragment.app.Fragment
    @CallSuper
    public void onInflate(Context r2, AttributeSet r3, Bundle r4) {
        o.f(r2, "context");
        o.f(r3, "attrs");
        super.onInflate(r2, r3, r4);
        TypedArray r5 = r2.obtainStyledAttributes(r3, androidx.navigation.R.styleable.NavHost);
        o.e(r5, "context.obtainStyledAttr…yleable.NavHost\n        )");
        int r6 = r5.getResourceId(androidx.navigation.R.styleable.NavHost_navGraph, 0);
        if (r6 == 0) goto L5;
        this.graphId = r6;
    L5:
        f0 r1 = f0.f18324a;
        r5.recycle();
    }

    public void onListPaneViewCreated(View r1, Bundle r2) {
        o.f(r1, "view");
    }

    @Override // androidx.fragment.app.Fragment
    @CallSuper
    public void onSaveInstanceState(Bundle r2) {
        o.f(r2, "outState");
        super.onSaveInstanceState(r2);
        int r1 = this.graphId;
        if (r1 == 0) goto L6;
        r2.putInt(NavHostFragment.KEY_GRAPH_ID, r1);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    @CallSuper
    public final void onViewCreated(View r2, Bundle r3) {
        o.f(r2, "view");
        super.onViewCreated(r2, r3);
        View r4 = getSlidingPaneLayout().getChildAt(0);
        o.e(r4, "listPaneView");
        onListPaneViewCreated(r4, r3);
    }

    @Override // androidx.fragment.app.Fragment
    @CallSuper
    public void onViewStateRestored(Bundle r2) {
        super.onViewStateRestored(r2);
        OnBackPressedCallback r3 = this.onBackPressedCallback;
        o.c(r3);
        if (getSlidingPaneLayout().isSlideable() == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        r3.setEnabled(r1);
        return;
    L5:
        if (getSlidingPaneLayout().isOpen() == false) goto L7;
        r1 = true;
        goto L8
    }
}
