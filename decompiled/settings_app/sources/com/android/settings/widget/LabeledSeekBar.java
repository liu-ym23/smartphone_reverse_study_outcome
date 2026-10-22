package com.android.settings.widget;

import android.R;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityEvent;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LabeledSeekBar extends SeekBar {
    private final ExploreByTouchHelper mAccessHelper;
    private String[] mLabels;
    private SeekBar.OnSeekBarChangeListener mOnSeekBarChangeListener;
    private final SeekBar.OnSeekBarChangeListener mProxySeekBarListener;

    private class LabeledSeekBarExploreByTouchHelper extends ExploreByTouchHelper {
        private boolean mIsLayoutRtl;
        final /* synthetic */ LabeledSeekBar this$0;

        public LabeledSeekBarExploreByTouchHelper(LabeledSeekBar r1, LabeledSeekBar r2) {
            this.this$0 = r1;
            super(r2);
            int r3 = r2.getResources().getConfiguration().getLayoutDirection();
            boolean r4 = true;
            if (r3 == 1) goto L6;
            r4 = false;
        L6:
            this.mIsLayoutRtl = r4;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected int getVirtualViewAt(float r1, float r2) {
            return getVirtualViewIdIndexFromX(r1);
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void getVisibleVirtualViews(List<Integer> r3) {
            int r2 = this.this$0.getMax();
            int r0 = 0;
        L3:
            if (r0 > r2) goto L5;
            r3.add(Integer.valueOf(r0));
            r0 = r0 + 1;
            goto L3
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected boolean onPerformActionForVirtualView(int r2, int r3, Bundle r4) {
            if (r2 != (-1)) goto L6;
            return false;
        L6:
            if (r3 == 16) goto L8;
            return false;
        L8:
            this.this$0.setProgress(r2);
            sendEventForVirtualView(r2, 1);
            return true;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void onPopulateNodeForVirtualView(int r2, AccessibilityNodeInfoCompat r3) {
            r3.setClassName(RadioButton.class.getName());
            r3.setBoundsInParent(getBoundsInParentFromVirtualViewId(r2));
            r3.addAction(16);
            r3.setContentDescription(LabeledSeekBar.access$200(this.this$0)[r2]);
            boolean r0 = true;
            r3.setClickable(true);
            r3.setCheckable(true);
            if (r2 == this.this$0.getProgress()) goto L6;
            r0 = false;
        L6:
            r3.setChecked(r0);
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void onPopulateEventForVirtualView(int r2, AccessibilityEvent r3) {
            r3.setClassName(RadioButton.class.getName());
            r3.setContentDescription(LabeledSeekBar.access$200(this.this$0)[r2]);
            if (r2 != this.this$0.getProgress()) goto L5;
            boolean r1 = true;
        L6:
            r3.setChecked(r1);
            return;
        L5:
            r1 = false;
            goto L6
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void onPopulateNodeForHost(AccessibilityNodeInfoCompat r1) {
            r1.setClassName(RadioGroup.class.getName());
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void onPopulateEventForHost(AccessibilityEvent r1) {
            r1.setClassName(RadioGroup.class.getName());
        }

        private int getHalfVirtualViewWidth() {
            return Math.max(0, ((this.this$0.getWidth() - this.this$0.getPaddingStart()) - this.this$0.getPaddingEnd()) / (this.this$0.getMax() * 2));
        }

        private int getVirtualViewIdIndexFromX(float r2) {
            int r3 = (Math.max(0, (((int) r2) - this.this$0.getPaddingStart()) / getHalfVirtualViewWidth()) + 1) / 2;
            if (this.mIsLayoutRtl == true) goto L5;
            return r3;
        L5:
            return this.this$0.getMax() - r3;
        }

        private Rect getBoundsInParentFromVirtualViewId(int r5) {
            if (this.mIsLayoutRtl == false) goto L5;
            r5 = this.this$0.getMax() - r5;
        L5:
            int r0 = r5 * 2;
            int r1 = ((r0 - 1) * getHalfVirtualViewWidth()) + this.this$0.getPaddingStart();
            int r2 = ((r0 + 1) * getHalfVirtualViewWidth()) + this.this$0.getPaddingStart();
            if (r5 != 0) goto L9;
            r1 = 0;
        L9:
            if (r5 != this.this$0.getMax()) goto L11;
            r2 = this.this$0.getWidth();
        L11:
            Rect r6 = new Rect();
            r6.set(r1, 0, r2, this.this$0.getHeight());
            return r6;
        }
    }

    static /* synthetic */ SeekBar.OnSeekBarChangeListener access$000(LabeledSeekBar r0) {
        return r0.mOnSeekBarChangeListener;
    }

    static /* synthetic */ void access$100(LabeledSeekBar r0, int r1) {
        r0.sendClickEventForAccessibility(r1);
    }

    static /* synthetic */ String[] access$200(LabeledSeekBar r0) {
        return r0.mLabels;
    }

    public LabeledSeekBar(Context r2, AttributeSet r3) {
        this(r2, r3, R.attr.seekBarStyle);
    }

    public LabeledSeekBar(Context r2, AttributeSet r3, int r4) {
        this(r2, r3, r4, 0);
    }

    public LabeledSeekBar(Context r1, AttributeSet r2, int r3, int r4) {
        super(r1, r2, r3, r4);
        SeekBar.OnSeekBarChangeListener r5 = new AnonymousClass1(this);
        this.mProxySeekBarListener = r5;
        LabeledSeekBarExploreByTouchHelper r6 = new LabeledSeekBarExploreByTouchHelper(this, this);
        this.mAccessHelper = r6;
        ViewCompat.setAccessibilityDelegate(this, r6);
        super.setOnSeekBarChangeListener(r5);
    }

    @Override // android.widget.ProgressBar
    public synchronized void setProgress(int r2) {
        monitor-enter(this);
        ExploreByTouchHelper r0 = this.mAccessHelper;     // Catch: Throwable -> L9
        if (r0 == null) goto L6;
        r0.invalidateRoot();     // Catch: Throwable -> L9
    L6:
        super.setProgress(r2);     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void setLabels(String[] r1) {
        this.mLabels = r1;
    }

    @Override // android.widget.SeekBar
    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener r1) {
        this.mOnSeekBarChangeListener = r1;
    }

    @Override // android.view.View
    protected boolean dispatchHoverEvent(MotionEvent r2) {
        if (this.mAccessHelper.dispatchHoverEvent(r2) == false) goto L5;
    L8:
        return true;
    L5:
        if (super.dispatchHoverEvent(r2) == true) goto L8;
        return false;
    }

    private void sendClickEventForAccessibility(int r2) {
        this.mAccessHelper.invalidateRoot();
        this.mAccessHelper.sendEventForVirtualView(r2, 1);
    }
}
