package com.android.settings.graph;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.View;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public class UsageGraph extends View {
    private static final int PATH_DELIM = -1;
    private int mAccentColor;
    private final int mCornerRadius;
    private final Drawable mDivider;
    private final int mDividerSize;
    private final Paint mDottedPaint;
    private final Paint mFillPaint;
    private final Paint mLinePaint;
    private final SparseIntArray mLocalPaths;
    private float mMaxX;
    private float mMaxY;
    private float mMiddleDividerLoc;
    private int mMiddleDividerTint;
    private final Path mPath;
    private final SparseIntArray mPaths;
    private boolean mProjectUp;
    private boolean mShowProjection;
    private final Drawable mTintedDivider;
    private int mTopDividerTint;

    private int getColor(int r1, float r2) {
        return ((((int) (r2 * 255.0f)) << 24) | 16777215) & r1;
    }

    public UsageGraph(Context r8, AttributeSet r9) {
        super(r8, r9);
        this.mPath = new Path();
        this.mPaths = new SparseIntArray();
        this.mLocalPaths = new SparseIntArray();
        this.mMaxX = 100.0f;
        this.mMaxY = 100.0f;
        this.mMiddleDividerLoc = 0.5f;
        this.mMiddleDividerTint = -1;
        this.mTopDividerTint = -1;
        Resources r10 = r8.getResources();
        Paint r0 = new Paint();
        this.mLinePaint = r0;
        r0.setStyle(Paint.Style.STROKE);
        r0.setStrokeCap(Paint.Cap.ROUND);
        r0.setStrokeJoin(Paint.Join.ROUND);
        r0.setAntiAlias(true);
        int r2 = r10.getDimensionPixelSize(R.dimen.usage_graph_line_corner_radius);
        this.mCornerRadius = r2;
        r0.setPathEffect(new CornerPathEffect(r2));
        r0.setStrokeWidth(r10.getDimensionPixelSize(R.dimen.usage_graph_line_width));
        Paint r3 = new Paint(r0);
        this.mFillPaint = r3;
        r3.setStyle(Paint.Style.FILL);
        Paint r4 = new Paint(r0);
        this.mDottedPaint = r4;
        r4.setStyle(Paint.Style.STROKE);
        float r1 = r10.getDimensionPixelSize(R.dimen.usage_graph_dot_size);
        float r5 = r10.getDimensionPixelSize(R.dimen.usage_graph_dot_interval);
        r4.setStrokeWidth(3.0f * r1);
        r4.setPathEffect(new DashPathEffect(new float[]{r1, r5}, 0.0f));
        r4.setColor(r8.getColor(R.color.usage_graph_dots));
        TypedValue r6 = new TypedValue();
        r8.getTheme().resolveAttribute(android.R.attr.listDivider, r6, true);
        this.mDivider = r8.getDrawable(r6.resourceId);
        this.mTintedDivider = r8.getDrawable(r6.resourceId);
        this.mDividerSize = r10.getDimensionPixelSize(R.dimen.usage_graph_divider_size);
    }

    void clearPaths() {
        this.mPaths.clear();
    }

    void setMax(int r1, int r2) {
        this.mMaxX = r1;
        this.mMaxY = r2;
    }

    void setDividerLoc(int r2) {
        this.mMiddleDividerLoc = 1.0f - (r2 / this.mMaxY);
    }

    void setDividerColors(int r1, int r2) {
        this.mMiddleDividerTint = r1;
        this.mTopDividerTint = r2;
    }

    public void addPath(SparseIntArray r5) {
        int r0 = 0;
    L4:
        if (r0 >= r5.size()) goto L6;
        this.mPaths.put(r5.keyAt(r0), r5.valueAt(r0));
        r0 = r0 + 1;
        goto L4
    L6:
        this.mPaths.put(r5.keyAt(r5.size() - 1) + 1, -1);
        calculateLocalPaths();
        postInvalidate();
    }

    void setAccentColor(int r2) {
        this.mAccentColor = r2;
        this.mLinePaint.setColor(r2);
        updateGradient();
        postInvalidate();
    }

    void setShowProjection(boolean r1, boolean r2) {
        this.mShowProjection = r1;
        this.mProjectUp = r2;
        postInvalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        updateGradient();
        calculateLocalPaths();
    }

    private void calculateLocalPaths() {
        if (getWidth() != 0) goto L5;
        return;
    L5:
        this.mLocalPaths.clear();
        int r0 = 0;
        int r2 = 0;
        int r3 = -1;
    L7:
        if (r0 >= this.mPaths.size()) goto L26;
        int r4 = this.mPaths.keyAt(r0);
        int r5 = this.mPaths.valueAt(r0);
        if (r5 == (-1)) goto L11;
        r2 = getX(r4);
        int r6 = getY(r5);
        if (this.mLocalPaths.size() <= 0) goto L24;
        SparseIntArray r7 = this.mLocalPaths;
        int r8 = r7.keyAt(r7.size() - 1);
        SparseIntArray r9 = this.mLocalPaths;
        int r10 = r9.valueAt(r9.size() - 1);
        if (r10 == (-1)) goto L24;
        if (hasDiff(r8, r2) == true) goto L24;
        if (hasDiff(r10, r6) == true) goto L24;
        r3 = r6;
    L25:
        r0 = r0 + 1;
    L24:
        this.mLocalPaths.put(r2, r6);
        goto L25
    L11:
        if (r0 != (this.mPaths.size() - 1)) goto L14;
        if (r3 == (-1)) goto L14;
        this.mLocalPaths.put(r2, r3);
    L14:
        this.mLocalPaths.put(r2 + 1, -1);
        r3 = -1;
        goto L25
    }

    private boolean hasDiff(int r1, int r2) {
        if (Math.abs(r2 - r1) < this.mCornerRadius) goto L5;
        return true;
    L5:
        return false;
    }

    private int getX(float r2) {
        return (int) ((r2 / this.mMaxX) * getWidth());
    }

    private int getY(float r2) {
        return (int) (getHeight() * (1.0f - (r2 / this.mMaxY)));
    }

    private void updateGradient() {
        this.mFillPaint.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, getHeight(), getColor(this.mAccentColor, 0.2f), 0, Shader.TileMode.CLAMP));
    }

    @Override // android.view.View
    protected void onDraw(Canvas r3) {
        if (this.mMiddleDividerLoc == 0.0f) goto L5;
        drawDivider(0, r3, this.mTopDividerTint);
    L5:
        drawDivider((int) ((r3.getHeight() - this.mDividerSize) * this.mMiddleDividerLoc), r3, this.mMiddleDividerTint);
        drawDivider(r3.getHeight() - this.mDividerSize, r3, -1);
        if (this.mLocalPaths.size() != 0) goto L9;
        return;
    L9:
        if (this.mShowProjection == false) goto L11;
        drawProjection(r3);
    L11:
        drawFilledPath(r3);
        drawLinePath(r3);
    }

    private void drawProjection(Canvas r4) {
        this.mPath.reset();
        SparseIntArray r0 = this.mLocalPaths;
        int r1 = r0.keyAt(r0.size() - 2);
        SparseIntArray r2 = this.mLocalPaths;
        this.mPath.moveTo(r1, r2.valueAt(r2.size() - 2));
        Path r3 = this.mPath;
        float r5 = r4.getWidth();
        if (this.mProjectUp == false) goto L5;
        float r6 = 0.0f;
    L6:
        r3.lineTo(r5, r6);
        r4.drawPath(this.mPath, this.mDottedPaint);
        return;
    L5:
        r6 = r4.getHeight();
        goto L6
    }

    private void drawLinePath(Canvas r6) {
        this.mPath.reset();
        this.mPath.moveTo(this.mLocalPaths.keyAt(0), this.mLocalPaths.valueAt(0));
        int r1 = 1;
    L4:
        if (r1 >= this.mLocalPaths.size()) goto L12;
        int r2 = this.mLocalPaths.keyAt(r1);
        int r3 = this.mLocalPaths.valueAt(r1);
        if (r3 != (-1)) goto L10;
        r1 = r1 + 1;
        if (r1 >= this.mLocalPaths.size()) goto L11;
        this.mPath.moveTo(this.mLocalPaths.keyAt(r1), this.mLocalPaths.valueAt(r1));
    L11:
        r1 = r1 + 1;
        goto L4
    L10:
        this.mPath.lineTo(r2, r3);
        goto L11
    L12:
        r6.drawPath(this.mPath, this.mLinePaint);
    }

    private void drawFilledPath(Canvas r7) {
        this.mPath.reset();
        float r0 = this.mLocalPaths.keyAt(0);
        this.mPath.moveTo(this.mLocalPaths.keyAt(0), this.mLocalPaths.valueAt(0));
        int r2 = 1;
    L4:
        if (r2 >= this.mLocalPaths.size()) goto L12;
        int r3 = this.mLocalPaths.keyAt(r2);
        int r4 = this.mLocalPaths.valueAt(r2);
        if (r4 != (-1)) goto L10;
        this.mPath.lineTo(this.mLocalPaths.keyAt(r2 - 1), getHeight());
        this.mPath.lineTo(r0, getHeight());
        this.mPath.close();
        r2 = r2 + 1;
        if (r2 >= this.mLocalPaths.size()) goto L11;
        r0 = this.mLocalPaths.keyAt(r2);
        this.mPath.moveTo(this.mLocalPaths.keyAt(r2), this.mLocalPaths.valueAt(r2));
    L11:
        r2 = r2 + 1;
        goto L4
    L10:
        this.mPath.lineTo(r3, r4);
        goto L11
    L12:
        r7.drawPath(this.mPath, this.mFillPaint);
    }

    private void drawDivider(int r3, Canvas r4, int r5) {
        Drawable r0 = this.mDivider;
        if (r5 == (-1)) goto L5;
        this.mTintedDivider.setTint(r5);
        r0 = this.mTintedDivider;
    L5:
        r0.setBounds(0, r3, r4.getWidth(), this.mDividerSize + r3);
        r0.draw(r4);
    }
}
