package com.google.android.material.snackbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SnackbarContentLayout extends LinearLayout implements ContentViewCallback {
    private Button actionView;
    private int maxInlineActionWidth;
    private TextView messageView;

    public SnackbarContentLayout(@NonNull Context r2) {
        this(r2, null);
    }

    public SnackbarContentLayout(@NonNull Context r1, @Nullable AttributeSet r2) {
        super(r1, r2);
    }

    private static void updateTopBottomPadding(@NonNull View r2, int r3, int r4) {
        if (ViewCompat.isPaddingRelative(r2) == false) goto L5;
        ViewCompat.setPaddingRelative(r2, ViewCompat.getPaddingStart(r2), r3, ViewCompat.getPaddingEnd(r2), r4);
        return;
    L5:
        r2.setPadding(r2.getPaddingLeft(), r3, r2.getPaddingRight(), r4);
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

    public Button getActionView() {
        return this.actionView;
    }

    public TextView getMessageView() {
        return this.messageView;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.messageView = (TextView) findViewById(R.id.snackbar_text);
        this.actionView = (Button) findViewById(R.id.snackbar_action);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int r8, int r9) {
        super.onMeasure(r8, r9);
        int r0 = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical_2lines);
        int r1 = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical);
        boolean r3 = false;
        if (this.messageView.getLayout().getLineCount() <= 1) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == true) goto L8;
    L14:
        if (r2 == true) goto L18;
        r0 = r1;
    L18:
        if (updateViewsWithinLayout(0, r0, r0) == false) goto L20;
    L19:
        r3 = true;
    L20:
        if (r3 == false) goto L23;
        super.onMeasure(r8, r9);
        return;
    L23:
        return;
    L8:
        if (this.maxInlineActionWidth <= 0) goto L14;
        if (this.actionView.getMeasuredWidth() <= this.maxInlineActionWidth) goto L14;
        if (updateViewsWithinLayout(1, r0, r0 - r1) == false) goto L20;
    L5:
        r2 = false;
        goto L6
    }

    public void setMaxInlineActionWidth(int r1) {
        this.maxInlineActionWidth = r1;
    }

    void updateActionTextColorAlphaIfNeeded(float r3) {
        if (r3 == 1.0f) goto L6;
        int r0 = this.actionView.getCurrentTextColor();
        int r4 = MaterialColors.layer(MaterialColors.getColor(this, R.attr.colorSurface), r0, r3);
        this.actionView.setTextColor(r4);
        return;
    }
}
