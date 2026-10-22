package com.android.setupwizardlib.util;

import android.graphics.Rect;
import android.os.Bundle;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.TextView;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LinkAccessibilityHelper extends AccessibilityDelegateCompat {
    private static final String TAG = "LinkAccessibilityHelper";
    private final AccessibilityDelegateCompat delegate;

    static class PreOLinkAccessibilityHelper extends ExploreByTouchHelper {
        private final Rect tempRect;
        private final TextView view;

        PreOLinkAccessibilityHelper(TextView r2) {
            super(r2);
            this.tempRect = new Rect();
            this.view = r2;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected int getVirtualViewAt(float r3, float r4) {
            CharSequence r0 = this.view.getText();
            if ((r0 instanceof Spanned) == false) goto L8;
            Spanned r1 = (Spanned) r0;
            int r2 = getOffsetForPosition(this.view, r3, r4);
            ClickableSpan[] r5 = (ClickableSpan[]) r1.getSpans(r2, r2, ClickableSpan.class);
            if (r5.length == 1) goto L7;
            return Integer.MIN_VALUE;
        L7:
            return r1.getSpanStart(r5[0]);
        L8:
            return Integer.MIN_VALUE;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void getVisibleVirtualViews(List<Integer> r5) {
            CharSequence r4 = this.view.getText();
            if ((r4 instanceof Spanned) == false) goto L7;
            Spanned r6 = (Spanned) r4;
            int r2 = 0;
            ClickableSpan[] r0 = (ClickableSpan[]) r6.getSpans(0, r6.length(), ClickableSpan.class);
            int r1 = r0.length;
        L5:
            if (r2 >= r1) goto L9;
            r5.add(Integer.valueOf(r6.getSpanStart(r0[r2])));
            r2 = r2 + 1;
            goto L5
        L9:
            return;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void onPopulateEventForVirtualView(int r3, AccessibilityEvent r4) {
            ClickableSpan r0 = getSpanForOffset(r3);
            if (r0 == null) goto L5;
            r4.setContentDescription(getTextForSpan(r0));
            return;
        L5:
            Log.e(LinkAccessibilityHelper.TAG, "LinkSpan is null for offset: " + r3);
            r4.setContentDescription(this.view.getText());
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void onPopulateNodeForVirtualView(int r5, AccessibilityNodeInfoCompat r6) {
            ClickableSpan r0 = getSpanForOffset(r5);
            if (r0 == null) goto L5;
            r6.setContentDescription(getTextForSpan(r0));
        L6:
            r6.setFocusable(true);
            r6.setClickable(true);
            getBoundsForSpan(r0, this.tempRect);
            if (this.tempRect.isEmpty() == false) goto L9;
            Log.e(LinkAccessibilityHelper.TAG, "LinkSpan bounds is empty for: " + r5);
            this.tempRect.set(0, 0, 1, 1);
        L9:
            r6.setBoundsInParent(this.tempRect);
            r6.addAction(16);
            return;
        L5:
            Log.e(LinkAccessibilityHelper.TAG, "LinkSpan is null for offset: " + r5);
            r6.setContentDescription(this.view.getText());
            goto L6
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected boolean onPerformActionForVirtualView(int r1, int r2, Bundle r3) {
            if (r2 != 16) goto L11;
            ClickableSpan r4 = getSpanForOffset(r1);
            if (r4 == null) goto L8;
            r4.onClick(this.view);
            return true;
        L8:
            Log.e(LinkAccessibilityHelper.TAG, "LinkSpan is null for offset: " + r1);
            return false;
        L11:
            return false;
        }

        private ClickableSpan getSpanForOffset(int r2) {
            CharSequence r1 = this.view.getText();
            if ((r1 instanceof Spanned) == false) goto L8;
            ClickableSpan[] r3 = (ClickableSpan[]) ((Spanned) r1).getSpans(r2, r2, ClickableSpan.class);
            if (r3.length == 1) goto L7;
            return null;
        L7:
            return r3[0];
        L8:
            return null;
        }

        private CharSequence getTextForSpan(ClickableSpan r2) {
            CharSequence r1 = this.view.getText();
            if ((r1 instanceof Spanned) == false) goto L6;
            Spanned r3 = (Spanned) r1;
            return r3.subSequence(r3.getSpanStart(r2), r3.getSpanEnd(r2));
        L6:
            return r1;
        }

        private Rect getBoundsForSpan(ClickableSpan r5, Rect r6) {
            CharSequence r0 = this.view.getText();
            r6.setEmpty();
            if ((r0 instanceof Spanned) == false) goto L14;
            Layout r1 = this.view.getLayout();
            if (r1 == null) goto L14;
            Spanned r2 = (Spanned) r0;
            int r3 = r2.getSpanStart(r5);
            int r7 = r2.getSpanEnd(r5);
            float r4 = r1.getPrimaryHorizontal(r3);
            float r8 = r1.getPrimaryHorizontal(r7);
            int r9 = r1.getLineForOffset(r3);
            int r10 = r1.getLineForOffset(r7);
            r1.getLineBounds(r9, r6);
            if (r10 != r9) goto L10;
            r6.left = (int) Math.min(r4, r8);
            r6.right = (int) Math.max(r4, r8);
        L13:
            r6.offset(this.view.getTotalPaddingLeft(), this.view.getTotalPaddingTop());
            goto L14
        L10:
            if (r1.getParagraphDirection(r9) != (-1)) goto L12;
            r6.right = (int) r4;
            goto L13
        L12:
            r6.left = (int) r4;
        L14:
            return r6;
        }

        private static int getOffsetForPosition(TextView r1, float r2, float r3) {
            if (r1.getLayout() != null) goto L7;
            return -1;
        L7:
            return getOffsetAtCoordinate(r1, getLineAtCoordinate(r1, r3), r2);
        }

        private static float convertToLocalHorizontalCoordinate(TextView r2, float r3) {
            return Math.min((r2.getWidth() - r2.getTotalPaddingRight()) - 1, Math.max(0.0f, r3 - r2.getTotalPaddingLeft())) + r2.getScrollX();
        }

        private static int getLineAtCoordinate(TextView r2, float r3) {
            return r2.getLayout().getLineForVertical((int) (Math.min((r2.getHeight() - r2.getTotalPaddingBottom()) - 1, Math.max(0.0f, r3 - r2.getTotalPaddingTop())) + r2.getScrollY()));
        }

        private static int getOffsetAtCoordinate(TextView r0, int r1, float r2) {
            float r3 = convertToLocalHorizontalCoordinate(r0, r2);
            return r0.getLayout().getOffsetForHorizontal(r1, r3);
        }
    }

    public LinkAccessibilityHelper(TextView r1) {
        this(new AccessibilityDelegateCompat());
    }

    LinkAccessibilityHelper(AccessibilityDelegateCompat r1) {
        this.delegate = r1;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void sendAccessibilityEvent(View r1, int r2) {
        this.delegate.sendAccessibilityEvent(r1, r2);
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void sendAccessibilityEventUnchecked(View r1, AccessibilityEvent r2) {
        this.delegate.sendAccessibilityEventUnchecked(r1, r2);
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public boolean dispatchPopulateAccessibilityEvent(View r1, AccessibilityEvent r2) {
        return this.delegate.dispatchPopulateAccessibilityEvent(r1, r2);
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onPopulateAccessibilityEvent(View r1, AccessibilityEvent r2) {
        this.delegate.onPopulateAccessibilityEvent(r1, r2);
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityEvent(View r1, AccessibilityEvent r2) {
        this.delegate.onInitializeAccessibilityEvent(r1, r2);
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View r1, AccessibilityNodeInfoCompat r2) {
        this.delegate.onInitializeAccessibilityNodeInfo(r1, r2);
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public boolean onRequestSendAccessibilityEvent(ViewGroup r1, View r2, AccessibilityEvent r3) {
        return this.delegate.onRequestSendAccessibilityEvent(r1, r2, r3);
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View r1) {
        return this.delegate.getAccessibilityNodeProvider(r1);
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public boolean performAccessibilityAction(View r1, int r2, Bundle r3) {
        return this.delegate.performAccessibilityAction(r1, r2, r3);
    }

    public boolean dispatchHoverEvent(MotionEvent r2) {
        AccessibilityDelegateCompat r1 = this.delegate;
        if ((r1 instanceof ExploreByTouchHelper) == true) goto L5;
    L7:
        return false;
    L5:
        if (((ExploreByTouchHelper) r1).dispatchHoverEvent(r2) == false) goto L7;
        return true;
    }
}
