package com.android.settings.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes.dex */
public class InnerExpandableLayout extends LinearLayout {
    private static final String TAG = "InnerExpandableLayout";
    private boolean mAnimating;
    private CollapseAnimationListener mCollapseAnimationListener;
    private ExpandAnimationListener mExpandAnimationListener;
    private ExpandCollapseListener mListener;
    private int mMeasureSpec;
    private State mState;

    /* JADX INFO: renamed from: com.android.settings.widget.InnerExpandableLayout$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class CollapseAnimation extends Animation {
        int initHeight;
        private View targetView;
        final /* synthetic */ InnerExpandableLayout this$0;

        CollapseAnimation(InnerExpandableLayout r1, View r2, int r3) {
            this.this$0 = r1;
            this.targetView = r2;
            this.initHeight = r3;
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float r3, Transformation r4) {
            if (r3 == 1.0f) goto L5;
            ViewGroup.LayoutParams r5 = this.targetView.getLayoutParams();
            int r0 = this.initHeight;
            r5.height = r0 - ((int) (r0 * r3));
            this.targetView.requestLayout();
            return;
        L5:
            this.targetView.setVisibility(8);
        }
    }

    private class CollapseAnimationListener implements Animation.AnimationListener {
        final /* synthetic */ InnerExpandableLayout this$0;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation r1) {
        }

        private CollapseAnimationListener(InnerExpandableLayout r1) {
            this.this$0 = r1;
        }

        /* synthetic */ CollapseAnimationListener(InnerExpandableLayout r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation r2) {
            InnerExpandableLayout.access$202(this.this$0, true);
            if (InnerExpandableLayout.access$300(this.this$0) == null) goto L6;
            InnerExpandableLayout.access$300(this.this$0).onCollapsing();
            return;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation r2) {
            InnerExpandableLayout.access$202(this.this$0, false);
            InnerExpandableLayout.access$402(this.this$0, State.STATE_COLLAPSE);
            if (InnerExpandableLayout.access$300(this.this$0) == null) goto L6;
            InnerExpandableLayout.access$300(this.this$0).onCollapsed();
            return;
        }
    }

    private class ExpandAnimation extends Animation {
        int targetHeight;
        private View targetView;
        final /* synthetic */ InnerExpandableLayout this$0;

        ExpandAnimation(InnerExpandableLayout r1, View r2, int r3) {
            this.this$0 = r1;
            this.targetView = r2;
            this.targetHeight = r3;
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float r2, Transformation r3) {
            if (r2 == 1.0f) goto L6;
            this.targetView.getLayoutParams().height = (int) (this.targetHeight * r2);
            this.targetView.requestLayout();
            return;
        }
    }

    private class ExpandAnimationListener implements Animation.AnimationListener {
        final /* synthetic */ InnerExpandableLayout this$0;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation r1) {
        }

        private ExpandAnimationListener(InnerExpandableLayout r1) {
            this.this$0 = r1;
        }

        /* synthetic */ ExpandAnimationListener(InnerExpandableLayout r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation r2) {
            InnerExpandableLayout.access$202(this.this$0, true);
            if (InnerExpandableLayout.access$300(this.this$0) == null) goto L6;
            InnerExpandableLayout.access$300(this.this$0).onExpanding();
            return;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation r2) {
            InnerExpandableLayout.access$202(this.this$0, false);
            InnerExpandableLayout.access$402(this.this$0, State.STATE_EXPAND);
            if (InnerExpandableLayout.access$300(this.this$0) == null) goto L6;
            InnerExpandableLayout.access$300(this.this$0).onExpanded();
            return;
        }
    }

    interface ExpandCollapseListener {
        void onCollapsed();

        void onCollapsing();

        void onExpanded();

        void onExpanding();
    }

    public static final enum State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State STATE_COLLAPSE = null;
        public static final State STATE_EXPAND = null;

        private static /* synthetic */ State[] $values() {
            return new State[]{STATE_COLLAPSE, STATE_EXPAND};
        }

        private State(String r1, int r2) {
            super(r1, r2);
        }

        public static State valueOf(String r1) {
            return (State) Enum.valueOf(State.class, r1);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }

        static {
            STATE_COLLAPSE = new State("STATE_COLLAPSE", 0);
            STATE_EXPAND = new State("STATE_EXPAND", 1);
            $VALUES = $values();
        }
    }

    static /* synthetic */ boolean access$202(InnerExpandableLayout r0, boolean r1) {
        r0.mAnimating = r1;
        return r1;
    }

    static /* synthetic */ ExpandCollapseListener access$300(InnerExpandableLayout r0) {
        return r0.mListener;
    }

    static /* synthetic */ State access$402(InnerExpandableLayout r0, State r1) {
        r0.mState = r1;
        return r1;
    }

    public InnerExpandableLayout(Context r2) {
        this(r2, null);
    }

    public InnerExpandableLayout(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public InnerExpandableLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        AnonymousClass1 r4 = null;
        this.mCollapseAnimationListener = new CollapseAnimationListener(this, r4);
        this.mExpandAnimationListener = new ExpandAnimationListener(this, r4);
        setGravity(48);
        this.mMeasureSpec = View.MeasureSpec.makeMeasureSpec(-1, Integer.MIN_VALUE);
        OLog.d(TAG, "InnerExpandableLayout: mMeasureSpec:" + this.mMeasureSpec);
    }

    public boolean isAnimating() {
        return this.mAnimating;
    }

    public void setListener(ExpandCollapseListener r1) {
        this.mListener = r1;
    }

    public void doCollapse() {
        assertChildrenHeight();
        int r0 = getMeasuredHeight();
        OLog.d(TAG, "collapse: measureHeight:" + r0);
        CollapseAnimation r1 = new CollapseAnimation(this, this, r0);
        r1.setAnimationListener(this.mCollapseAnimationListener);
        r1.setInterpolator(new DecelerateInterpolator(1.5f));
        r1.setDuration(300);
        startAnimation(r1);
    }

    public void doExpand() {
        assertChildrenHeight();
        int r0 = this.mMeasureSpec;
        measure(r0, r0);
        int r1 = getMeasuredHeight();
        getLayoutParams().height = 0;
        setVisibility(0);
        ExpandAnimation r2 = new ExpandAnimation(this, this, r1);
        r2.setAnimationListener(this.mExpandAnimationListener);
        r2.setInterpolator(new DecelerateInterpolator(1.5f));
        r2.setDuration(300);
        startAnimation(r2);
    }

    public void update() {
        if (isAnimating() == false) goto L6;
        OLog.i(TAG, "update when animating");
        return;
    L6:
        assertChildrenHeight();
        int r0 = this.mMeasureSpec;
        measure(r0, r0);
        ViewGroup.LayoutParams r1 = getLayoutParams();
        if (isExpand() == false) goto L9;
        r1.height = getMeasuredHeight();
    L10:
        setLayoutParams(r1);
        return;
    L9:
        r1.height = 0;
        goto L10
    }

    public boolean isExpand() {
        if (this.mState != State.STATE_EXPAND) goto L5;
        return true;
    L5:
        return false;
    }

    private void assertChildrenHeight() {
        int r0 = getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        View r2 = getChildAt(r1);
        int r3 = this.mMeasureSpec;
        r2.measure(r3, r3);
        r2.getLayoutParams().height = r2.getMeasuredHeight();
        r2.requestLayout();
        r1 = r1 + 1;
        goto L3
    }
}
