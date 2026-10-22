package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.expandable.ExpandableWidget;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public abstract class ExpandableBehavior extends CoordinatorLayout.Behavior<View> {
    private static final int STATE_COLLAPSED = 2;
    private static final int STATE_EXPANDED = 1;
    private static final int STATE_UNINITIALIZED = 0;
    private int currentState;

    public ExpandableBehavior() {
        this.currentState = 0;
    }

    public ExpandableBehavior(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.currentState = 0;
    }

    static /* synthetic */ int access$000(ExpandableBehavior r0) {
        return r0.currentState;
    }

    private boolean didStateChange(boolean r3) {
        int r2 = this.currentState;
        if (r3 == false) goto L9;
        if (r2 == 0) goto L8;
        if (r2 == 2) goto L8;
        return false;
    L8:
        return true;
    L9:
        if (r2 == 1) goto L11;
        return false;
    L11:
        return true;
    }

    @Nullable
    public static <T extends ExpandableBehavior> T from(@NonNull View r1, @NonNull Class<T> r2) {
        ViewGroup.LayoutParams r3 = r1.getLayoutParams();
        if ((r3 instanceof CoordinatorLayout.LayoutParams) == false) goto L11;
        CoordinatorLayout.Behavior r4 = ((CoordinatorLayout.LayoutParams) r3).getBehavior();
        if ((r4 instanceof ExpandableBehavior) == false) goto L9;
        return r2.cast(r4);
    L9:
        throw new IllegalArgumentException("The view is not associated with ExpandableBehavior");
    L11:
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    protected ExpandableWidget findExpandableWidget(@NonNull CoordinatorLayout r6, @NonNull View r7) {
        List<View> r0 = r6.getDependencies(r7);
        int r1 = r0.size();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        View r3 = r0.get(r2);
        if (layoutDependsOn(r6, r7, r3) == true) goto L7;
        r2 = r2 + 1;
        goto L3
    L7:
        return (ExpandableWidget) r3;
    L9:
        return null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public abstract boolean layoutDependsOn(CoordinatorLayout r1, View r2, View r3);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @CallSuper
    public boolean onDependentViewChanged(CoordinatorLayout r2, View r3, View r4) {
        ExpandableWidget r5 = (ExpandableWidget) r4;
        if (didStateChange(r5.isExpanded()) == true) goto L5;
        return false;
    L5:
        if (r5.isExpanded() == false) goto L7;
        int r6 = 1;
    L8:
        this.currentState = r6;
        return onExpandedStateChange((View) r5, r3, r5.isExpanded(), true);
    L7:
        r6 = 2;
        goto L8
    }

    protected abstract boolean onExpandedStateChange(View r1, View r2, boolean r3, boolean r4);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @CallSuper
    public boolean onLayoutChild(@NonNull CoordinatorLayout r3, @NonNull final View r4, int r5) {
        if (ViewCompat.isLaidOut(r4) == true) goto L15;
        final ExpandableWidget r6 = findExpandableWidget(r3, r4);
        if (r6 != null) goto L7;
        return false;
    L7:
        if (didStateChange(r6.isExpanded()) == true) goto L9;
        return false;
    L9:
        if (r6.isExpanded() == false) goto L11;
        final int r7 = 1;
    L12:
        this.currentState = r7;
        r4.getViewTreeObserver().addOnPreDrawListener(new AnonymousClass1(this, r4, r7, r6));
        return false;
    L11:
        r7 = 2;
        goto L12
    L15:
        return false;
    }
}
