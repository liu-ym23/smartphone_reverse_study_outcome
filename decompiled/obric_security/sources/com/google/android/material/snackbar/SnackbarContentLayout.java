package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;

/* JADX INFO: loaded from: classes2.dex */
public class SnackbarContentLayout extends LinearLayout implements ContentViewCallback {
    private Button actionView;
    private int maxInlineActionWidth;
    private int maxWidth;
    private TextView messageView;

    public SnackbarContentLayout(Context r2) {
        this(r2, null);
    }

    public SnackbarContentLayout(Context r2, AttributeSet r3) {
        super(r2, r3);
        TypedArray r4 = r2.obtainStyledAttributes(r3, R.styleable.SnackbarLayout);
        this.maxWidth = r4.getDimensionPixelSize(R.styleable.SnackbarLayout_android_maxWidth, -1);
        this.maxInlineActionWidth = r4.getDimensionPixelSize(R.styleable.SnackbarLayout_maxActionInlineWidth, -1);
        r4.recycle();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.messageView = (TextView) findViewById(R.id.snackbar_text);
        this.actionView = (Button) findViewById(R.id.snackbar_action);
    }

    public TextView getMessageView() {
        return this.messageView;
    }

    public Button getActionView() {
        return this.actionView;
    }

    void updateActionTextColorAlphaIfNeeded(float r3) {
        if (r3 == 1.0f) goto L6;
        int r0 = this.actionView.getCurrentTextColor();
        int r4 = MaterialColors.layer(MaterialColors.getColor(this, R.attr.colorSurface), r0, r3);
        this.actionView.setTextColor(r4);
        return;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int r8, int r9) {
        super.onMeasure(r8, r9);
        if (this.maxWidth <= 0) goto L7;
        int r0 = getMeasuredWidth();
        int r1 = this.maxWidth;
        if (r0 <= r1) goto L7;
        r8 = View.MeasureSpec.makeMeasureSpec(r1, 1073741824);
        super.onMeasure(r8, r9);
    L7:
        int r2 = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical_2lines);
        int r3 = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical);
        boolean r4 = false;
        if (this.messageView.getLayout().getLineCount() <= 1) goto L10;
        boolean r5 = true;
    L11:
        if (r5 == true) goto L13;
    L19:
        if (r5 == true) goto L23;
        r2 = r3;
    L23:
        if (updateViewsWithinLayout(0, r2, r2) == false) goto L25;
    L24:
        r4 = true;
    L25:
        if (r4 == false) goto L28;
        super.onMeasure(r8, r9);
        return;
    L28:
        return;
    L13:
        if (this.maxInlineActionWidth <= 0) goto L19;
        if (this.actionView.getMeasuredWidth() <= this.maxInlineActionWidth) goto L19;
        if (updateViewsWithinLayout(1, r2, r2 - r3) == false) goto L25;
    L10:
        r5 = false;
        goto L11
    }

    private boolean updateViewsWithinLayout(int r3, int r4, int r5) {
        if (r3 == getOrientation()) goto L5;
        setOrientation(r3);
        boolean r6 = true;
    L7:
        if (this.messageView.getPaddingTop() == r4) goto L9;
    L12:
        updateTopBottomPadding(this.messageView, r4, r5);
        return true;
    L9:
        if (this.messageView.getPaddingBottom() != r5) goto L12;
        return r6;
    L5:
        r6 = false;
        goto L7
    }

    private static void updateTopBottomPadding(View r2, int r3, int r4) {
        if (ViewCompat.isPaddingRelative(r2) == false) goto L5;
        ViewCompat.setPaddingRelative(r2, ViewCompat.getPaddingStart(r2), r3, ViewCompat.getPaddingEnd(r2), r4);
        return;
    L5:
        r2.setPadding(r2.getPaddingLeft(), r3, r2.getPaddingRight(), r4);
    }

    @Override // com.google.android.material.snackbar.ContentViewCallback
    public void animateContentIn(int r8, int r9) {
        this.messageView.setAlpha(0.0f);
        long r3 = r9;
        long r5 = r8;
        this.messageView.animate().alpha(1.0f).setDuration(r3).setStartDelay(r5).start();
        if (this.actionView.getVisibility() != 0) goto L6;
        this.actionView.setAlpha(0.0f);
        this.actionView.animate().alpha(1.0f).setDuration(r3).setStartDelay(r5).start();
        return;
    }

    @Override // com.google.android.material.snackbar.ContentViewCallback
    public void animateContentOut(int r8, int r9) {
        this.messageView.setAlpha(1.0f);
        long r3 = r9;
        long r5 = r8;
        this.messageView.animate().alpha(0.0f).setDuration(r3).setStartDelay(r5).start();
        if (this.actionView.getVisibility() != 0) goto L6;
        this.actionView.setAlpha(1.0f);
        this.actionView.animate().alpha(0.0f).setDuration(r3).setStartDelay(r5).start();
        return;
    }

    public void setMaxInlineActionWidth(int r1) {
        this.maxInlineActionWidth = r1;
    }
}
