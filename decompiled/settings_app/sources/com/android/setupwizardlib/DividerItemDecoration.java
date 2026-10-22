package com.android.setupwizardlib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public class DividerItemDecoration extends RecyclerView.ItemDecoration {
    public static final int DIVIDER_CONDITION_BOTH = 1;
    public static final int DIVIDER_CONDITION_EITHER = 0;
    private Drawable divider;
    private int dividerCondition;
    private int dividerHeight;
    private int dividerIntrinsicHeight;

    public interface DividedViewHolder {
        boolean isDividerAllowedAbove();

        boolean isDividerAllowedBelow();
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface DividerCondition {
    }

    @Deprecated
    public static DividerItemDecoration getDefault(Context r1) {
        return new DividerItemDecoration(r1);
    }

    public DividerItemDecoration() {
    }

    public DividerItemDecoration(Context r5) {
        TypedArray r6 = r5.obtainStyledAttributes(R.styleable.SuwDividerItemDecoration);
        Drawable r0 = r6.getDrawable(R.styleable.SuwDividerItemDecoration_android_listDivider);
        int r1 = r6.getDimensionPixelSize(R.styleable.SuwDividerItemDecoration_android_dividerHeight, 0);
        int r2 = r6.getInt(R.styleable.SuwDividerItemDecoration_suwDividerCondition, 0);
        r6.recycle();
        setDivider(r0);
        setDividerHeight(r1);
        setDividerCondition(r2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas r8, RecyclerView r9, RecyclerView.State r10) {
        if (this.divider != null) goto L5;
        return;
    L5:
        int r11 = r9.getChildCount();
        int r0 = r9.getWidth();
        int r1 = this.dividerHeight;
        if (r1 != 0) goto L9;
        r1 = this.dividerIntrinsicHeight;
    L9:
        int r3 = 0;
    L10:
        if (r3 >= r11) goto L15;
        View r4 = r9.getChildAt(r3);
        if (shouldDrawDividerBelow(r4, r9) == false) goto L14;
        int r5 = ((int) ViewCompat.getY(r4)) + r4.getHeight();
        this.divider.setBounds(0, r5, r0, r5 + r1);
        this.divider.draw(r8);
    L14:
        r3 = r3 + 1;
        goto L10
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect r1, View r2, RecyclerView r3, RecyclerView.State r4) {
        if (shouldDrawDividerBelow(r2, r3) == false) goto L10;
        int r5 = this.dividerHeight;
        if (r5 != 0) goto L8;
        r5 = this.dividerIntrinsicHeight;
    L8:
        r1.bottom = r5;
        return;
    }

    private boolean shouldDrawDividerBelow(View r5, RecyclerView r6) {
        RecyclerView.ViewHolder r7 = r6.getChildViewHolder(r5);
        int r0 = r7.getLayoutPosition();
        int r1 = r6.getAdapter().getItemCount() - 1;
        if (isDividerAllowedBelow(r7) == false) goto L8;
        if (this.dividerCondition != 0) goto L11;
        return true;
    L11:
        if (r0 < r1) goto L13;
    L15:
        return true;
    L13:
        if (isDividerAllowedAbove(r6.findViewHolderForLayoutPosition(r0 + 1)) == true) goto L15;
        return false;
    L8:
        if (this.dividerCondition == 1) goto L16;
        if (r0 != r1) goto L11;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected boolean isDividerAllowedAbove(RecyclerView.ViewHolder r1) {
        if ((r1 instanceof DividedViewHolder) == true) goto L5;
    L8:
        return true;
    L5:
        if (((DividedViewHolder) r1).isDividerAllowedAbove() == true) goto L8;
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected boolean isDividerAllowedBelow(RecyclerView.ViewHolder r1) {
        if ((r1 instanceof DividedViewHolder) == true) goto L5;
    L8:
        return true;
    L5:
        if (((DividedViewHolder) r1).isDividerAllowedBelow() == true) goto L8;
        return false;
    }

    public void setDivider(Drawable r2) {
        if (r2 == null) goto L4;
        this.dividerIntrinsicHeight = r2.getIntrinsicHeight();
    L5:
        this.divider = r2;
        return;
    L4:
        this.dividerIntrinsicHeight = 0;
        goto L5
    }

    public Drawable getDivider() {
        return this.divider;
    }

    public void setDividerHeight(int r1) {
        this.dividerHeight = r1;
    }

    public int getDividerHeight() {
        return this.dividerHeight;
    }

    public void setDividerCondition(int r1) {
        this.dividerCondition = r1;
    }

    public int getDividerCondition() {
        return this.dividerCondition;
    }
}
