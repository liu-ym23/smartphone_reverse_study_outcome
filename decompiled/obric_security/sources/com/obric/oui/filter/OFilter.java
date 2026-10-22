package com.obric.oui.filter;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.obric.common.oui.R;
import com.obric.oui.common.style.SmoothCornerH;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.material.MaterialConfigFormatNames;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OFilter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0016\u0018\u0000 E2\u00020\u0001:\u0002EFB/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\tJ\u0010\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020&H\u0002J\u0006\u0010'\u001a\u00020\tJ\u0006\u0010(\u001a\u00020\u0007J\b\u0010)\u001a\u00020\"H\u0002J\u0012\u0010*\u001a\u00020\"2\b\u0010+\u001a\u0004\u0018\u00010,H\u0014J\u0010\u0010-\u001a\u00020\"2\u0006\u0010%\u001a\u00020&H\u0014J0\u0010.\u001a\u00020\"2\u0006\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0007H\u0014J\u0018\u00104\u001a\u00020\"2\u0006\u00105\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u0007H\u0014J\b\u00107\u001a\u00020\"H\u0002J\u0006\u00108\u001a\u00020\"J\u000e\u00109\u001a\u00020\"2\u0006\u0010\u0013\u001a\u00020\tJ\u0010\u0010:\u001a\u00020\"2\u0006\u0010;\u001a\u00020\tH\u0016J\u0016\u0010<\u001a\u00020\"2\u0006\u0010=\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u0007J\u000e\u0010?\u001a\u00020\"2\u0006\u0010@\u001a\u00020\u0018J\u0010\u0010A\u001a\u00020\"2\u0006\u0010B\u001a\u00020\tH\u0016J\u0018\u0010C\u001a\u00020\"2\u0006\u0010\u001d\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\tJ\u0016\u0010D\u001a\u00020\"2\u0006\u0010=\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u0007R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lcom/obric/oui/filter/OFilter;", "Lcom/obric/oui/filter/DrawableCenterButton;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "isAlwaysLightByCode", "", "(Landroid/content/Context;Landroid/util/AttributeSet;IZ)V", "bgPaint", "Landroid/graphics/Paint;", "bgRect", "Landroid/graphics/RectF;", "drawable", "Landroid/graphics/drawable/Drawable;", "highlightCornerRadiusPx", "", "isAlwaysLight", "normalCornerRadiusPx", "normalPaddingHorizontal", "normalPaddingVertical", "onFilterSelectChangeListener", "Lcom/obric/oui/filter/OFilter$OnFilterSelectChangeListener;", "paintStrokeWidth", "showIcon", "strokePaint", "strokeRect", "style", "tintAndTextColor", "withIconPaddingHorizontal", "withIconPaddingVertical", "changeIconVisibility", "", "visible", "drawCustomBackground", "canvas", "Landroid/graphics/Canvas;", "getIsAlwaysLight", "getStyle", "internalSetDrawable", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDraw", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "refreshDimensionCache", "refreshStyle", "setAlwaysLight", "setEnabled", "enabled", "setNormalPadding", "horizontalPadding", "verticalPadding", "setSelectChangeListener", "listener", "setSelected", MaterialConfigFormatNames.SELECTED, "setStyle", "setWithIconPadding", "Companion", "OnFilterSelectChangeListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OFilter extends DrawableCenterButton {
    public static final Companion Companion = null;
    public static final int FILTER_STYLE_HIGHLIGHT = 1;
    public static final int FILTER_STYLE_NORMAL = 0;
    public static final int NORMAL_PADDING_HORIZONTAL = 12;
    public static final int NORMAL_PADDING_VERTICAL = 5;
    public static final int WITH_ICON_PADDING_HORIZONTAL = 16;
    public static final int WITH_ICON_PADDING_VERTICAL = 7;
    private final Paint bgPaint;
    private final RectF bgRect;
    private Drawable drawable;
    private float highlightCornerRadiusPx;
    private boolean isAlwaysLight;
    private float normalCornerRadiusPx;
    private int normalPaddingHorizontal;
    private int normalPaddingVertical;
    private OnFilterSelectChangeListener onFilterSelectChangeListener;
    private final float paintStrokeWidth;
    private boolean showIcon;
    private final Paint strokePaint;
    private final RectF strokeRect;
    private int style;
    private int tintAndTextColor;
    private int withIconPaddingHorizontal;
    private int withIconPaddingVertical;

    /* JADX INFO: compiled from: OFilter.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/oui/filter/OFilter$Companion;", "", "()V", "FILTER_STYLE_HIGHLIGHT", "", "FILTER_STYLE_NORMAL", "NORMAL_PADDING_HORIZONTAL", "NORMAL_PADDING_VERTICAL", "WITH_ICON_PADDING_HORIZONTAL", "WITH_ICON_PADDING_VERTICAL", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: OFilter.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/obric/oui/filter/OFilter$OnFilterSelectChangeListener;", "", "onFilterSelectedChange", "", "filter", "Lcom/obric/oui/filter/OFilter;", MaterialConfigFormatNames.SELECTED, "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnFilterSelectChangeListener {
        void onFilterSelectedChange(OFilter r1, boolean r2);
    }

    static {
        Companion = new Companion(null);
    }

    public OFilter(Context r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, null, 0, false, 14, null);
    }

    public OFilter(Context r9, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, r10, 0, false, 12, null);
    }

    public OFilter(Context r9, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, r10, r11, false, 8, null);
    }

    public /* synthetic */ OFilter(Context r2, AttributeSet r3, int r4, boolean r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = 0;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = false;
    L11:
        this(r2, r3, r4, r5);
    }

    public OFilter(Context r5, AttributeSet r6, int r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        OFilter r0 = this;
        this.normalPaddingHorizontal = OUnitExtensionKt.vdp(r0, 12);
        this.normalPaddingVertical = OUnitExtensionKt.vdp(r0, 5);
        this.withIconPaddingHorizontal = OUnitExtensionKt.vdp(r0, 16);
        this.withIconPaddingVertical = OUnitExtensionKt.vdp(r0, 7);
        float r1 = OUnitExtensionKt.vdp(r0, 0.5d);
        this.paintStrokeWidth = r1;
        Paint r2 = new Paint(1);
        r2.setStyle(Paint.Style.FILL);
        this.bgPaint = r2;
        Paint r3 = new Paint(1);
        r3.setStyle(Paint.Style.STROKE);
        r3.setStrokeWidth(r1);
        this.strokePaint = r3;
        this.bgRect = new RectF();
        this.strokeRect = new RectF();
        refreshDimensionCache();
        TypedArray r9 = r5.getTheme().obtainStyledAttributes(r6, R.styleable.OFilter, r7, 0);
        this.style = r9.getInt(R.styleable.OFilter_oui_filterStyle, 0);     // Catch: Throwable -> L6
        this.showIcon = r9.getBoolean(R.styleable.OFilter_showIcon, false);     // Catch: Throwable -> L6
        this.isAlwaysLight = r9.getBoolean(R.styleable.OFilter_oui_isAlwaysLight, r8);     // Catch: Throwable -> L6
        r9.recycle();
        setSingleLine();
        setTextSize(0, r5.getResources().getDimension(R.dimen.oui_filter_text_size));
        setCompoundDrawablePadding(r5.getResources().getDimensionPixelSize(R.dimen.oui_filter_drawable_padding));
        setGravity(17);
        refreshStyle();
        return;
    L6:
        th = move-exception;
        r9.recycle();
        throw th;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        refreshDimensionCache();
        invalidate();
    }

    private final void refreshDimensionCache() {
        OFilter r0 = this;
        this.normalCornerRadiusPx = OUnitExtensionKt.vdp(r0, 4);
        this.highlightCornerRadiusPx = OUnitExtensionKt.vdp(r0, 8);
    }

    public final void changeIconVisibility(boolean r4) {
        this.showIcon = r4;
        if (r4 == false) goto L5;
        setStyle$default(this, 1, false, 2, null);
        return;
    L5:
        internalSetDrawable();
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean r2) {
        super.setSelected(r2);
        refreshStyle();
        OnFilterSelectChangeListener r0 = this.onFilterSelectChangeListener;
        if (r0 == null) goto L7;
        r0.onFilterSelectedChange(this, r2);
        return;
    }

    public static /* synthetic */ void setStyle$default(OFilter r0, int r1, boolean r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        r0.setStyle(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setStyle");
    }

    public final void setStyle(int r1, boolean r2) {
        this.style = r1;
        this.isAlwaysLight = r2;
        refreshStyle();
    }

    public final int getStyle() {
        return this.style;
    }

    public final void refreshStyle() {
        if (isEnabled() == true) goto L6;
        return;
    L6:
        if (this.style != 1) goto L8;
        setMinHeight(OUnitExtensionKt.vdp(this, 36));
    L10:
        if (isSelected() == false) goto L19;
        if (this.isAlwaysLight == false) goto L15;
        int r0 = R.color.primary;
        int r3 = R.color.BGBrand;
        this.tintAndTextColor = R.color.primary;
        setTypeface(null, 1);
    L26:
        this.bgPaint.setColor(ContextCompat.getColor(getContext(), r3));
        this.strokePaint.setColor(ContextCompat.getColor(getContext(), r0));
        setTextColor(ContextCompat.getColor(getContext(), this.tintAndTextColor));
        internalSetDrawable();
        return;
    L15:
        if (this.style != 1) goto L17;
        r0 = R.color.primary;
        this.tintAndTextColor = R.color.primary;
        r3 = R.color.Transparent;
        setTypeface(null, 1);
        goto L26
    L17:
        r0 = R.color.BGInput;
        this.tintAndTextColor = R.color.TextPrimary;
        r3 = R.color.BGInput;
        setTypeface(null, 1);
        goto L26
    L19:
        if (this.isAlwaysLight == false) goto L23;
        r0 = R.color.LineReverse2;
        this.tintAndTextColor = R.color.TextReverse;
        int r1 = R.color.Transparent;
        setTypeface(null, 0);
    L21:
        r3 = r1;
        goto L26
    L23:
        if (this.style != 1) goto L25;
        r0 = R.color.oui_basic_text_2;
        this.tintAndTextColor = R.color.oui_basic_text_2;
        r1 = R.color.Transparent;
        setTypeface(null, 0);
        goto L21
    L25:
        r0 = R.color.oui_basic_text_2;
        this.tintAndTextColor = R.color.oui_basic_text_2;
        r1 = R.color.oui_basic_text_4;
        setTypeface(null, 0);
        goto L21
    L8:
        setMinHeight(-1);
        goto L10
    }

    private final void internalSetDrawable() {
        if (this.showIcon == true) goto L5;
        setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        int r0 = this.normalPaddingHorizontal;
        int r1 = this.normalPaddingVertical;
        setPadding(r0, r1, r0, r1);
        setGravity(17);
        return;
    L5:
        if (this.drawable != null) goto L11;
        Drawable r2 = ContextCompat.getDrawable(getContext(), R.drawable.o_arrow_forward_filter);
        if (r2 != null) goto L9;
        Drawable r3 = null;
    L10:
        this.drawable = r3;
        goto L11
    L9:
        r3 = r2.mutate();
    L11:
        Drawable r4 = this.drawable;
        Intrinsics.checkNotNull(r4);
        Drawable r5 = DrawableCompat.wrap(r4);
        DrawableCompat.setTintMode(r5, PorterDuff.Mode.SRC_IN);
        DrawableCompat.setTint(r5, ContextCompat.getColor(getContext(), this.tintAndTextColor));
        r5.setBounds(0, 0, r5.getIntrinsicWidth(), r5.getIntrinsicHeight());
        setGravity(8388629);
        setCompoundDrawablesWithIntrinsicBounds(null, null, r5, null);
        int r6 = this.withIconPaddingHorizontal;
        int r7 = this.withIconPaddingVertical;
        setPadding(r6, r7, r6, r7);
    }

    public final void setWithIconPadding(int r1, int r2) {
        this.withIconPaddingHorizontal = r1;
        this.withIconPaddingVertical = r2;
    }

    public final void setNormalPadding(int r1, int r2) {
        this.normalPaddingHorizontal = r1;
        this.normalPaddingVertical = r2;
    }

    public final void setAlwaysLight(boolean r1) {
        this.isAlwaysLight = r1;
        refreshStyle();
    }

    public final boolean getIsAlwaysLight() {
        return this.isAlwaysLight;
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean r1) {
        super.setEnabled(r1);
        if (r1 == false) goto L5;
        setAlpha(1.0f);
        refreshStyle();
        return;
    L5:
        setAlpha(0.5f);
    }

    public final void setSelectChangeListener(OnFilterSelectChangeListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.onFilterSelectChangeListener = r2;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // com.obric.oui.filter.DrawableCenterButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        drawCustomBackground(r2);
        super.onDraw(r2);
    }

    private final void drawCustomBackground(Canvas r6) {
        r6.save();
        r6.translate(getScrollX() * 1.0f, getScrollY() * 1.0f);
        if (this.style != 0) goto L5;
        float r0 = this.normalCornerRadiusPx;
    L6:
        this.bgRect.set(0.0f, 0.0f, getWidth(), getHeight());
        SmoothCornerH.drawRoundRect(r6, this.bgRect, r0, this.bgPaint);
        if (this.style != 1) goto L9;
        float r1 = this.paintStrokeWidth * 0.5f;
        this.strokeRect.set(r1, r1, getWidth() - r1, getHeight() - r1);
        SmoothCornerH.drawRoundRect(r6, this.strokeRect, r0, this.strokePaint);
    L9:
        r6.restore();
        return;
    L5:
        r0 = this.highlightCornerRadiusPx;
        goto L6
    }
}
