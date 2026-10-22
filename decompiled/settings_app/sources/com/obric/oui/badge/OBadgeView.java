package com.obric.oui.badge;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.android.settings.search.IndexDatabaseHelper;
import com.bytedance.apm.constant.PerfConsts;
import com.obric.common.oui.R;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OBadgeView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\t\u0018\u0000 =2\u00020\u0001:\u0001=B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u000f\u001a\u00020\u0010J\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\u0014J0\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007H\u0014J\u0018\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007H\u0014J(\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0007H\u0014J\u0012\u0010&\u001a\u00020\u00102\b\u0010'\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010(\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u0007H\u0016J\u0012\u0010*\u001a\u00020\u00102\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u000e\u0010-\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\fJ\u000e\u0010/\u001a\u00020\u00102\u0006\u00100\u001a\u00020\u0007J\u0010\u00101\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u0007H\u0016J\u0018\u00102\u001a\u00020\u00102\u0006\u00103\u001a\u00020\u00072\u0006\u00104\u001a\u000205H\u0016J\u0006\u00106\u001a\u00020\u0010J\b\u00107\u001a\u00020\u0010H\u0002J\b\u00108\u001a\u00020\u0010H\u0002J\u0010\u00109\u001a\u00020\u00102\u0006\u0010:\u001a\u000205H\u0002J\u0010\u0010;\u001a\u00020\f2\u0006\u0010<\u001a\u00020\u0014H\u0014R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000e¨\u0006>"}, d2 = {"Lcom/obric/oui/badge/OBadgeView;", "Lcom/obric/oui/text/OTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "badge", "Lcom/obric/oui/badge/OBadgeDrawable;", "enableFontScale", "", "initialBgColor", "Ljava/lang/Integer;", "hide", "", "initFromAttributes", "invalidateDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "setBackground", "background", "setBackgroundColor", "color", "setContentDescription", "contentDescription", "", "setEnableFontScale", IndexDatabaseHelper.IndexColumns.ENABLED, "setMaxNumberInCount", "maxNumber", "setTextColor", "setTextSize", "unit", PerfConsts.PERF_DISK_FILE_SIZE, "", "show", "syncTextViewPropertiesToBadge", "updateBadgeCoordinates", "updateBadgeTextSizeFromPx", "sizePx", "verifyDrawable", "who", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OBadgeView extends OTextView {
    public static final Companion Companion = null;
    private static int MAX_COUNT;
    private OBadgeDrawable badge;
    private boolean enableFontScale;
    private Integer initialBgColor;

    /* JADX INFO: compiled from: OBadgeView.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/obric/oui/badge/OBadgeView$Companion;", "", "()V", "MAX_COUNT", "", "getMAX_COUNT", "()I", "setMAX_COUNT", "(I)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final int getMAX_COUNT() {
            return OBadgeView.access$getMAX_COUNT$cp();
        }

        public final void setMAX_COUNT(int r1) {
            OBadgeView.access$setMAX_COUNT$cp(r1);
        }
    }

    public OBadgeView(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public OBadgeView(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ OBadgeView(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public static final /* synthetic */ OBadgeDrawable access$getBadge$p(OBadgeView r0) {
        return r0.badge;
    }

    public static final /* synthetic */ int access$getMAX_COUNT$cp() {
        return MAX_COUNT;
    }

    public static final /* synthetic */ void access$setMAX_COUNT$cp(int r0) {
        MAX_COUNT = r0;
    }

    public OBadgeView(Context r9, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        super(r9, r10, r11, null, 8, null);
        this.enableFontScale = true;
        OBadgeDrawable r12 = OBadgeDrawable.Companion.create(r9);
        this.badge = r12;
        if (r12 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        r12 = null;
    L5:
        r12.setCallback(this);
        initFromAttributes(r10, r11);
        syncTextViewPropertiesToBadge();
        addTextChangedListener(new AnonymousClass1(this));
    }

    static {
        Companion = new Companion(null);
        MAX_COUNT = 9999;
    }

    private final void initFromAttributes(AttributeSet r6, int r7) {
        OBadgeDrawable r0 = this.badge;
        OBadgeDrawable r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        r0 = null;
    L5:
        r0.setBadgeGravity(OBadgeDrawable.BadgeGravity.CENTER);
        if (r6 != null) goto L13;
        OBadgeDrawable r8 = this.badge;
        if (r8 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
    L11:
        r2.setContentDescription(getContentDescription());
        return;
    L10:
        r2 = r8;
        goto L11
    L13:
        TypedArray r9 = getContext().obtainStyledAttributes(r6, R.styleable.OBadgeView, r7, 0);
        Intrinsics.checkNotNullExpressionValue(r9, "context.obtainStyledAttr…dgeView, defStyleAttr, 0)");
        this.enableFontScale = r9.getBoolean(R.styleable.OBadgeView_oui_widgetEnableFontScale, true);     // Catch: Throwable -> L56
        OBadgeDrawable r10 = this.badge;     // Catch: Throwable -> L56
        if (r10 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("badge");     // Catch: Throwable -> L56
        r10 = null;
    L17:
        r10.setEnableFontScale(this.enableFontScale);     // Catch: Throwable -> L56
        int r11 = R.styleable.OBadgeView_o_maxNumber;     // Catch: Throwable -> L56
        OBadgeDrawable r1 = this.badge;     // Catch: Throwable -> L56
        if (r1 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("badge");     // Catch: Throwable -> L56
        r1 = null;
    L20:
        int r12 = r9.getInt(r11, r1.getMaxNumber());     // Catch: Throwable -> L56
        OBadgeDrawable r3 = this.badge;     // Catch: Throwable -> L56
        if (r3 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("badge");     // Catch: Throwable -> L56
        r3 = null;
    L23:
        r3.setMaxNumber(r12);     // Catch: Throwable -> L56
        int r13 = r9.getColor(R.styleable.OBadgeView_oui_badgeview_ellipsis_color, 0);     // Catch: Throwable -> L56
        OBadgeDrawable r4 = this.badge;     // Catch: Throwable -> L56
        if (r4 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("badge");     // Catch: Throwable -> L56
        r4 = null;
    L26:
        r4.setEllipsisColor(Integer.valueOf(r13));     // Catch: Throwable -> L56
        if (r9.hasValue(R.styleable.OBadgeView_android_text) == false) goto L36;
        CharSequence r14 = r9.getText(R.styleable.OBadgeView_android_text);     // Catch: Throwable -> L56
        OBadgeDrawable r5 = this.badge;     // Catch: Throwable -> L56
        if (r5 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("badge");     // Catch: Throwable -> L56
        r5 = null;
    L31:
        if (r14 != null) goto L33;
        String r15 = null;
    L34:
        r5.setBadgeText(r15);     // Catch: Throwable -> L56
        goto L36
    L33:
        r15 = r14.toString();     // Catch: Throwable -> L56
    L36:
        if (r9.hasValue(R.styleable.OBadgeView_android_textColor) == false) goto L42;
        int r16 = r9.getColor(R.styleable.OBadgeView_android_textColor, getCurrentTextColor());     // Catch: Throwable -> L56
        OBadgeDrawable r17 = this.badge;     // Catch: Throwable -> L56
        if (r17 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("badge");     // Catch: Throwable -> L56
        r17 = null;
    L40:
        r17.setBadgeTextColor(r16);     // Catch: Throwable -> L56
    L42:
        if (r9.hasValue(R.styleable.OBadgeView_android_textSize) == false) goto L45;
        updateBadgeTextSizeFromPx(r9.getDimension(R.styleable.OBadgeView_android_textSize, getTextSize()));     // Catch: Throwable -> L56
    L45:
        if (r9.hasValue(R.styleable.OBadgeView_android_background) == false) goto L50;
        int r18 = r9.getColor(R.styleable.OBadgeView_android_background, ContextCompat.getColor(getContext(), R.color.oui_red_6));     // Catch: Throwable -> L56
        OBadgeDrawable r19 = this.badge;     // Catch: Throwable -> L56
        if (r19 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("badge");     // Catch: Throwable -> L56
        r19 = null;
    L49:
        r19.setBackgroundColor(r18);     // Catch: Throwable -> L56
    L50:
        r9.recycle();
        OBadgeDrawable r20 = this.badge;
        if (r20 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
    L54:
        r2.setContentDescription(getContentDescription());
        return;
    L53:
        r2 = r20;
    L56:
        th = move-exception;
        r9.recycle();
        throw th;
    }

    private final void syncTextViewPropertiesToBadge() {
        OBadgeDrawable r0 = this.badge;
        OBadgeDrawable r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        r0 = null;
    L5:
        CharSequence r3 = getText();
        if (r3 != null) goto L8;
        String r4 = null;
    L9:
        r0.setBadgeText(r4);
        OBadgeDrawable r1 = this.badge;
        if (r1 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        r1 = null;
    L12:
        r1.setBadgeTextColor(getCurrentTextColor());
        OBadgeDrawable r5 = this.badge;
        if (r5 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        r5 = null;
    L15:
        r5.setEnableFontScale(this.enableFontScale);
        updateBadgeTextSizeFromPx(getTextSize());
        Drawable r6 = getBackground();
        if ((r6 instanceof ColorDrawable) == false) goto L23;
        OBadgeDrawable r7 = this.badge;
        if (r7 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
    L21:
        r2.setBackgroundColor(((ColorDrawable) r6).getColor());
        return;
    L20:
        r2 = r7;
        goto L21
    L23:
        if (this.initialBgColor == null) goto L31;
        OBadgeDrawable r8 = this.badge;
        if (r8 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
    L28:
        Integer r9 = this.initialBgColor;
        Intrinsics.checkNotNull(r9);
        r2.setBackgroundColor(r9.intValue());
        return;
    L27:
        r2 = r8;
        goto L28
    L31:
        return;
    L8:
        r4 = r3.toString();
        goto L9
    }

    @Override // com.obric.oui.text.OTextView, android.widget.TextView, android.view.View
    protected void onMeasure(int r5, int r6) {
        OBadgeDrawable r0 = this.badge;
        OBadgeDrawable r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        r0 = null;
    L5:
        r0.updateBadgeCoordinates(this);
        OBadgeDrawable r2 = this.badge;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
    L9:
        Rect r3 = r1.getBounds();
        Intrinsics.checkNotNullExpressionValue(r3, "badge.bounds");
        int r4 = r3.width();
        int r7 = r3.height();
        setMeasuredDimension(TextView.resolveSize(r4 + (getPaddingLeft() + getPaddingRight()), r5), TextView.resolveSize(r7 + (getPaddingTop() + getPaddingBottom()), r6));
        return;
    L8:
        r1 = r2;
        goto L9
    }

    @Override // android.view.View
    protected void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        updateBadgeCoordinates();
    }

    @Override // com.obric.oui.text.OTextView, android.widget.TextView, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        if (r1 == false) goto L6;
        updateBadgeCoordinates();
        return;
    }

    private final void updateBadgeCoordinates() {
        if (getWidth() > 0) goto L5;
        return;
    L5:
        if (getHeight() <= 0) goto L12;
        OBadgeDrawable r0 = this.badge;
        if (r0 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        r0 = null;
    L9:
        r0.updateBadgeCoordinates(this);
        return;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        OBadgeDrawable r1 = this.badge;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        r1 = null;
    L5:
        r1.draw(r2);
    }

    @Override // android.widget.TextView, android.view.View
    protected boolean verifyDrawable(Drawable r2) {
        Intrinsics.checkNotNullParameter(r2, "who");
        if (super.verifyDrawable(r2) == true) goto L11;
        OBadgeDrawable r1 = this.badge;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        r1 = null;
    L8:
        if (Intrinsics.areEqual(r2, r1) == true) goto L11;
        return false;
    L11:
        return true;
    }

    @Override // android.widget.TextView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable r2) {
        Intrinsics.checkNotNullParameter(r2, "drawable");
        OBadgeDrawable r0 = this.badge;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        r0 = null;
    L6:
        if (Intrinsics.areEqual(r2, r0) == false) goto L8;
        invalidate();
        return;
    L8:
        super.invalidateDrawable(r2);
    }

    @Override // android.view.View
    public void setContentDescription(CharSequence r1) {
        super.setContentDescription(r1);
        OBadgeDrawable r0 = this.badge;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        r0 = null;
    L5:
        r0.setContentDescription(r1);
    }

    @Override // android.widget.TextView
    public void setTextColor(int r2) {
        if (this.badge == null) goto L9;
        super.setTextColor(r2);
        OBadgeDrawable r3 = this.badge;
        if (r3 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        r3 = null;
    L7:
        r3.setBadgeTextColor(getCurrentTextColor());
        invalidate();
        return;
    }

    @Override // android.widget.TextView
    public void setTextSize(int r1, float r2) {
        super.setTextSize(r1, r2);
        if (this.badge == null) goto L5;
        updateBadgeTextSizeFromPx(getTextSize());
    L5:
        requestLayout();
        invalidate();
    }

    public final void setEnableFontScale(boolean r2) {
        if (this.enableFontScale != r2) goto L5;
        return;
    L5:
        this.enableFontScale = r2;
        OBadgeDrawable r0 = this.badge;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        r0 = null;
    L8:
        r0.setEnableFontScale(r2);
        syncTextViewPropertiesToBadge();
        requestLayout();
        invalidate();
    }

    private final void updateBadgeTextSizeFromPx(float r2) {
        float r3 = r2 / getResources().getDisplayMetrics().scaledDensity;
        OBadgeDrawable r1 = this.badge;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        r1 = null;
    L5:
        r1.setTextSizeSp(r3);
    }

    @Override // android.view.View
    public void setBackgroundColor(int r2) {
        OBadgeDrawable r0 = this.badge;
        if (r0 == null) goto L8;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        r0 = null;
    L6:
        r0.setBackgroundColor(r2);
        invalidate();
        return;
    }

    @Override // android.view.View
    public void setBackground(Drawable r4) {
        OBadgeDrawable r0 = this.badge;
        if (r0 != null) goto L5;
        return;
    L5:
        if ((r4 instanceof ColorDrawable) == false) goto L7;
        ColorDrawable r5 = (ColorDrawable) r4;
    L8:
        if (r5 == null) goto L15;
        if (r0 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        r0 = null;
    L12:
        r0.setBackgroundColor(r5.getColor());
        invalidate();
        return;
    L15:
        return;
    L7:
        r5 = null;
        goto L8
    }

    public final void setMaxNumberInCount(int r2) {
        OBadgeDrawable r0 = this.badge;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("badge");
        r0 = null;
    L5:
        r0.setMaxNumber(r2);
        requestLayout();
        invalidate();
    }

    public final void show() {
        setVisibility(0);
    }

    public final void hide() {
        setVisibility(8);
    }
}
