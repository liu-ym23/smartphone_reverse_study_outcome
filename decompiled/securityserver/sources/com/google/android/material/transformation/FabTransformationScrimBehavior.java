package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.MotionTiming;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class FabTransformationScrimBehavior extends ExpandableTransformationBehavior {
    public static final long COLLAPSE_DELAY = 0;
    public static final long COLLAPSE_DURATION = 150;
    public static final long EXPAND_DELAY = 75;
    public static final long EXPAND_DURATION = 150;
    private final MotionTiming collapseTiming;
    private final MotionTiming expandTiming;

    public FabTransformationScrimBehavior() {
        this.expandTiming = new MotionTiming(75, 150);
        this.collapseTiming = new MotionTiming(0, 150);
    }

    private void createScrimAnimation(@NonNull View r3, boolean r4, boolean r5, @NonNull List<Animator> r6, List<Animator.AnimatorListener> r7) {
        if (r4 == false) goto L5;
        MotionTiming r2 = this.expandTiming;
    L7:
        if (r4 == false) goto L11;
        if (r5 == true) goto L10;
        r3.setAlpha(0.0f);
    L10:
        ObjectAnimator r8 = ObjectAnimator.ofFloat(r3, View.ALPHA, new float[]{1.0f});
    L12:
        r2.apply(r8);
        r6.add(r8);
        return;
    L11:
        r8 = ObjectAnimator.ofFloat(r3, View.ALPHA, new float[]{0.0f});
        goto L12
    L5:
        r2 = this.collapseTiming;
        goto L7
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean layoutDependsOn(CoordinatorLayout r1, View r2, View r3) {
        return r3 instanceof FloatingActionButton;
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    @NonNull
    public AnimatorSet onCreateExpandedStateChangeAnimation(@NonNull View r7, @NonNull final View r8, final boolean r9, boolean r10) {
        ArrayList r11 = new ArrayList();
        createScrimAnimation(r8, r9, r10, r11, new ArrayList());
        AnimatorSet r12 = new AnimatorSet();
        AnimatorSetCompat.playTogether(r12, r11);
        r12.addListener(new AnonymousClass1(this, r9, r8));
        return r12;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(@NonNull CoordinatorLayout r1, @NonNull View r2, @NonNull MotionEvent r3) {
        return super.onTouchEvent(r1, r2, r3);
    }

    public FabTransformationScrimBehavior(Context r5, AttributeSet r6) {
        super(r5, r6);
        this.expandTiming = new MotionTiming(75, 150);
        this.collapseTiming = new MotionTiming(0, 150);
    }
}
