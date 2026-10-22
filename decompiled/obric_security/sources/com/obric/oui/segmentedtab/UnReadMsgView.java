package com.obric.oui.segmentedtab;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedanceos.security.invokeHistory.InvokeHistoryActivity;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.obric.common.oui.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: UnReadMsgView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0018\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0006\u0010\u0015\u001a\u00020\u0007J\u0006\u0010\u0016\u001a\u00020\u0007J\u0006\u0010\u0017\u001a\u00020\u0007J\u0006\u0010\u0018\u001a\u00020\u0007J\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u001a\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J0\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007H\u0014J\u0018\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0007H\u0014J\u0010\u0010$\u001a\u00020\u001a2\u0006\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010%\u001a\u00020\u001aH\u0002J\u0010\u0010&\u001a\u00020\u001a2\u0006\u0010\n\u001a\u00020\u0007H\u0002J \u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\f2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0002J\u000e\u0010*\u001a\u00020\u001a2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010+\u001a\u00020\u001a2\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010,\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u0007J\u0010\u0010-\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\u0007H\u0002J\u000e\u0010.\u001a\u00020\u001a2\u0006\u0010/\u001a\u00020\u0007J\u0010\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u0014H\u0002R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/obric/oui/segmentedtab/UnReadMsgView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backgroundColor", "cornerRadius", "gdBackground", "Landroid/graphics/drawable/GradientDrawable;", "isRadiusHalfHeight", "", "isWidthHeightEqual", "strokeColor", "strokeWidth", "dp2px", "dp", "", "getBackgroundColor", "getCornerRadius", "getStrokeColor", "getStrokeWidth", "obtainAttributes", "", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setBackgroundColor", "setBgSelector", "setCornerRadius", "setDrawable", "gd", "color", "setIsRadiusHalfHeight", "setIsWidthHeightEqual", "setStrokeColor", "setStrokeWidth", InvokeHistoryActivity.PREF_SHOW, PerfConsts.PERF_DISK_FILE_NUM, "sp2px", CloudControlInf.SP, "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UnReadMsgView extends AppCompatTextView {
    private int backgroundColor;
    private int cornerRadius;
    private final GradientDrawable gdBackground;
    private boolean isRadiusHalfHeight;
    private boolean isWidthHeightEqual;
    private int strokeColor;
    private int strokeWidth;

    public UnReadMsgView(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public UnReadMsgView(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ UnReadMsgView(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public UnReadMsgView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.gdBackground = new GradientDrawable();
        obtainAttributes(r2, r3);
    }

    private final void obtainAttributes(Context r2, AttributeSet r3) {
        TypedArray r4 = r2.obtainStyledAttributes(r3, R.styleable.MsgView);
        Intrinsics.checkNotNullExpressionValue(r4, "context.obtainStyledAttr…trs, R.styleable.MsgView)");
        this.backgroundColor = r4.getColor(R.styleable.MsgView_mv_backgroundColor, 0);
        this.cornerRadius = r4.getDimensionPixelSize(R.styleable.MsgView_mv_cornerRadius, 0);
        this.strokeWidth = r4.getDimensionPixelSize(R.styleable.MsgView_mv_strokeWidth, 0);
        this.strokeColor = r4.getColor(R.styleable.MsgView_mv_strokeColor, 0);
        this.isRadiusHalfHeight = r4.getBoolean(R.styleable.MsgView_mv_isRadiusHalfHeight, false);
        this.isWidthHeightEqual = r4.getBoolean(R.styleable.MsgView_mv_isWidthHeightEqual, false);
        r4.recycle();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    protected void onMeasure(int r2, int r3) {
        if (isWidthHeightEqual() == true) goto L5;
    L10:
        super.onMeasure(r2, r3);
        return;
    L5:
        if (getWidth() <= 0) goto L10;
        if (getHeight() <= 0) goto L10;
        int r4 = View.MeasureSpec.makeMeasureSpec(RangesKt.coerceAtLeast(getWidth(), getHeight()), 1073741824);
        super.onMeasure(r4, r4);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        if (isRadiusHalfHeight() == false) goto L5;
        setCornerRadius(getHeight() / 2);
        return;
    L5:
        setBgSelector();
    }

    @Override // android.view.View
    public void setBackgroundColor(int r1) {
        this.backgroundColor = r1;
        setBgSelector();
    }

    private final void setCornerRadius(int r1) {
        this.cornerRadius = dp2px(r1);
        setBgSelector();
    }

    private final void setStrokeWidth(int r1) {
        this.strokeWidth = dp2px(r1);
        setBgSelector();
    }

    public final void setStrokeColor(int r1) {
        this.strokeColor = r1;
        setBgSelector();
    }

    public final void setIsRadiusHalfHeight(boolean r1) {
        this.isRadiusHalfHeight = r1;
        setBgSelector();
    }

    public final void setIsWidthHeightEqual(boolean r1) {
        this.isWidthHeightEqual = r1;
        setBgSelector();
    }

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    public final int getCornerRadius() {
        return this.cornerRadius;
    }

    public final int getStrokeWidth() {
        return this.strokeWidth;
    }

    public final int getStrokeColor() {
        return this.strokeColor;
    }

    private final boolean isRadiusHalfHeight() {
        return this.isRadiusHalfHeight;
    }

    private final boolean isWidthHeightEqual() {
        return this.isWidthHeightEqual;
    }

    private final int dp2px(float r1) {
        return (int) ((r1 * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    private final int sp2px(float r1) {
        return (int) ((r1 * getContext().getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    private final void setDrawable(GradientDrawable r1, int r2, int r3) {
        r1.setColor(r2);
        r1.setCornerRadius(this.cornerRadius);
        r1.setStroke(this.strokeWidth, r3);
    }

    private final void setBgSelector() {
        StateListDrawable r0 = new StateListDrawable();
        setDrawable(this.gdBackground, this.backgroundColor, this.strokeColor);
        r0.addState(new int[]{-16842919}, this.gdBackground);
        setBackground(r0);
    }

    public final void show(int r8) {
        ViewGroup.LayoutParams r0 = getLayoutParams();
        if (r0 == null) goto L26;
        RelativeLayout.LayoutParams r1 = (RelativeLayout.LayoutParams) r0;
        DisplayMetrics r2 = getResources().getDisplayMetrics();
        Intrinsics.checkNotNullExpressionValue(r2, "resources.displayMetrics");
        setVisibility(0);
        if (r8 > 0) goto L7;
        setStrokeWidth(0);
        setText("");
        float r9 = 5;
        r1.width = (int) (r2.density * r9);
        r1.height = (int) (r9 * r2.density);
        setLayoutParams(r1);
        return;
    L7:
        float r3 = 18;
        r1.height = (int) (r2.density * r3);
        boolean r5 = true;
        if (1 > r8) goto L11;
        if (r8 >= 10) goto L11;
        boolean r6 = true;
    L12:
        if (r6 == false) goto L14;
        r1.width = (int) (r3 * r2.density);
        setText(String.valueOf(r8));
    L23:
        setLayoutParams(r1);
        return;
    L14:
        if (10 <= r8) goto L16;
    L18:
        r5 = false;
    L20:
        if (r5 == false) goto L22;
        r1.width = -2;
        float r4 = 6;
        setPadding((int) (r2.density * r4), 0, (int) (r4 * r2.density), 0);
        setText(String.valueOf(r8));
        goto L23
    L22:
        r1.width = -2;
        float r10 = 6;
        setPadding((int) (r2.density * r10), 0, (int) (r10 * r2.density), 0);
        setText("99+");
        goto L23
    L16:
        if (r8 >= 100) goto L18;
    L11:
        r6 = false;
        goto L12
    L26:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    }
}
