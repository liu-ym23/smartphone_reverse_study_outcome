package androidx.recyclerview.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class DividerItemDecoration extends RecyclerView.ItemDecoration {
    private static final int[] ATTRS = null;
    public static final int HORIZONTAL = 0;
    private static final String TAG = "DividerItem";
    public static final int VERTICAL = 1;
    private final Rect mBounds;
    private Drawable mDivider;
    private int mOrientation;

    static {
        ATTRS = new int[]{R.attr.listDivider};
    }

    public DividerItemDecoration(Context r3, int r4) {
        this.mBounds = new Rect();
        TypedArray r5 = r3.obtainStyledAttributes(ATTRS);
        Drawable r0 = r5.getDrawable(0);
        this.mDivider = r0;
        if (r0 != null) goto L5;
        Log.w(TAG, "@android:attr/listDivider was not set in the theme used for this DividerItemDecoration. Please set that attribute all call setDrawable()");
    L5:
        r5.recycle();
        setOrientation(r4);
    }

    public void setOrientation(int r2) {
        if (r2 != 0) goto L4;
    L8:
        this.mOrientation = r2;
        return;
    L4:
        if (r2 == 1) goto L8;
        throw new IllegalArgumentException("Invalid orientation. It should be either HORIZONTAL or VERTICAL");
    }

    public void setDrawable(Drawable r1) {
        if (r1 == null) goto L6;
        this.mDivider = r1;
        return;
    L6:
        throw new IllegalArgumentException("Drawable cannot be null.");
    }

    public Drawable getDrawable() {
        return this.mDivider;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas r2, RecyclerView r3, RecyclerView.State r4) {
        if (r3.getLayoutManager() != null) goto L5;
        return;
    L5:
        if (this.mDivider != null) goto L8;
        return;
    L8:
        if (this.mOrientation != 1) goto L10;
        drawVertical(r2, r3);
        return;
    L10:
        drawHorizontal(r2, r3);
    }

    private void drawVertical(Canvas r8, RecyclerView r9) {
        r8.save();
        int r1 = 0;
        if (r9.getClipToPadding() == false) goto L5;
        int r0 = r9.getPaddingLeft();
        int r2 = r9.getWidth() - r9.getPaddingRight();
        r8.clipRect(r0, r9.getPaddingTop(), r2, r9.getHeight() - r9.getPaddingBottom());
    L6:
        int r3 = r9.getChildCount();
    L7:
        if (r1 >= r3) goto L9;
        View r4 = r9.getChildAt(r1);
        r9.getDecoratedBoundsWithMargins(r4, this.mBounds);
        int r5 = this.mBounds.bottom + Math.round(r4.getTranslationY());
        this.mDivider.setBounds(r0, r5 - this.mDivider.getIntrinsicHeight(), r2, r5);
        this.mDivider.draw(r8);
        r1 = r1 + 1;
        goto L7
    L9:
        r8.restore();
        return;
    L5:
        r2 = r9.getWidth();
        r0 = 0;
        goto L6
    }

    private void drawHorizontal(Canvas r8, RecyclerView r9) {
        r8.save();
        int r1 = 0;
        if (r9.getClipToPadding() == false) goto L5;
        int r0 = r9.getPaddingTop();
        int r2 = r9.getHeight() - r9.getPaddingBottom();
        r8.clipRect(r9.getPaddingLeft(), r0, r9.getWidth() - r9.getPaddingRight(), r2);
    L6:
        int r3 = r9.getChildCount();
    L7:
        if (r1 >= r3) goto L9;
        View r4 = r9.getChildAt(r1);
        r9.getLayoutManager().getDecoratedBoundsWithMargins(r4, this.mBounds);
        int r5 = this.mBounds.right + Math.round(r4.getTranslationX());
        this.mDivider.setBounds(r5 - this.mDivider.getIntrinsicWidth(), r0, r5, r2);
        this.mDivider.draw(r8);
        r1 = r1 + 1;
        goto L7
    L9:
        r8.restore();
        return;
    L5:
        r2 = r9.getHeight();
        r0 = 0;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect r1, View r2, RecyclerView r3, RecyclerView.State r4) {
        Drawable r5 = this.mDivider;
        if (r5 != null) goto L7;
        r1.set(0, 0, 0, 0);
        return;
    L7:
        if (this.mOrientation != 1) goto L9;
        r1.set(0, 0, 0, r5.getIntrinsicHeight());
        return;
    L9:
        r1.set(0, 0, r5.getIntrinsicWidth(), 0);
    }
}
