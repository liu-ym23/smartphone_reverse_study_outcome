package com.obric.oui.toast;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import androidx.core.content.res.ResourcesCompat;
import com.obric.common.oui.R;
import com.obric.oui.color.OPalette;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.material.MaterialConfig;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.OMaterialExtBaseKt;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.utils.ViewUtilKt;
import com.obric.oui.utils.log.L;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: compiled from: ToastBackgroundView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 #2\u00020\u0001:\u0001#B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0015\u001a\u00020\u0007J\u0006\u0010\u0016\u001a\u00020\u0010J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0014J\u0017\u0010\u001b\u001a\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010\u001dJ\u000e\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u0007J \u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00102\b\u0010!\u001a\u0004\u0018\u00010\"R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/obric/oui/toast/ToastBackgroundView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bgColor", "bgPaint", "Landroid/graphics/Paint;", "borderColor", "borderWidth", "cornerRadius", "drawSelf", "", "enableMaterial", "rectF", "Landroid/graphics/RectF;", "strokePaint", "getCornerRadius", "isDarkTheme", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "resolveColors", "originBgColor", "(Ljava/lang/Integer;)V", "setupBackground", MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "materialFromWindow", "materialBackdropTarget", "Landroid/view/View;", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ToastBackgroundView extends FrameLayout {
    public static final Companion Companion = null;
    public static final float DEFAULT_CORNER_RADIUS = 24.0f;
    public static final String TAG = "ToastBackgroundView";
    private int bgColor;
    private final Paint bgPaint;
    private int borderColor;
    private int borderWidth;
    private int cornerRadius;
    private boolean drawSelf;
    private boolean enableMaterial;
    private final RectF rectF;
    private final Paint strokePaint;

    /* JADX INFO: compiled from: ToastBackgroundView.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/toast/ToastBackgroundView$Companion;", "", "()V", "DEFAULT_CORNER_RADIUS", "", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ToastBackgroundView(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public ToastBackgroundView(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ ToastBackgroundView(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public ToastBackgroundView(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        ToastBackgroundView r6 = this;
        this.cornerRadius = OUnitExtensionKt.vdp(r6, 24.0f);
        this.rectF = new RectF();
        boolean r0 = true;
        Paint r7 = new Paint(1);
        r7.setStyle(Paint.Style.FILL);
        this.bgPaint = r7;
        Paint r8 = new Paint(1);
        r8.setStyle(Paint.Style.STROKE);
        this.strokePaint = r8;
        if (OMaterialExtBaseKt.isMaterialEffectEnabled(r3) == true) goto L5;
    L7:
        r0 = false;
    L8:
        this.enableMaterial = r0;
        Integer r9 = ViewUtilKt.parseBgColor(r6);
        setBackgroundColor(0);
        resolveColors(r9);
        return;
    L5:
        if (OMaterialHelper.isWidgetMaterialEffectEnabled() == false) goto L7;
        goto L7
    }

    private final void resolveColors(Integer r5) {
        if (r5 != null) goto L5;
        int r6 = ResourcesCompat.getColor(getResources(), R.color.oui_toast_background, getContext().getTheme());
        if (this.bgPaint.getColor() == r6) goto L13;
        this.bgPaint.setColor(r6);
        this.bgColor = r6;
        L.d(TAG, Intrinsics.stringPlus("resolveColors: bg=", Integer.valueOf(r6)));
        return;
    L13:
        return;
    L5:
        if (this.bgPaint.getColor() == r5.intValue()) goto L12;
        this.bgPaint.setColor(r5.intValue());
        this.bgColor = r5.intValue();
        L.d(TAG, "resolveColors: bg=" + r5 + " from originBgColor");
        return;
    }

    public final void setupBackground(int r3) {
        setupBackground(r3, true, null);
    }

    public final void setupBackground(int r8, boolean r9, View r10) {
        if (this.enableMaterial == false) goto L10;
        this.drawSelf = false;
        GradientDrawable r11 = new GradientDrawable();
        r11.setShape(0);
        r11.setCornerRadius(this.cornerRadius);
        r11.setColor(0);
        setBackground(r11);
        setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        MaterialConfig[] r1 = MaterialToken.OUI_Bg_Popup.invoke(Boolean.valueOf(!isDarkTheme()));
        if (r9 == false) goto L7;
        OMaterialExtBaseKt.materialsFromWindow$default(this, r1, false, null, 6, null);
        return;
    L7:
        ToastBackgroundView r7 = this;
        OMaterialExtBaseKt.materials$default(r7, r1, false, 0, null, 14, null);
        OMaterialExtBaseKt.setMaterialBackdropTarget(r7, r10);
        return;
    L10:
        if (r8 != (this.cornerRadius * 2)) goto L12;
        setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.o_toast_background_capsule_form, getContext().getTheme()));
        this.drawSelf = false;
    L13:
        L.d(TAG, "setupBackground: drawSelf = " + this.drawSelf + ", height = " + r8);
        invalidate();
        return;
    L12:
        this.drawSelf = true;
        goto L13
    }

    public final int getCornerRadius() {
        return this.cornerRadius;
    }

    @Override // android.view.View
    protected void onDraw(Canvas r8) {
        Intrinsics.checkNotNullParameter(r8, "canvas");
        float r0 = this.cornerRadius * 1.0f;
        this.rectF.set(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        if (this.drawSelf == false) goto L5;
        r8.drawRoundRect(this.rectF, r0, r0, this.bgPaint);
    L5:
        int r1 = this.borderWidth;
        if (r1 <= 0) goto L8;
        this.strokePaint.setStrokeWidth(r1);
        this.strokePaint.setColor(this.borderColor);
        r8.drawRoundRect(this.rectF, r0, r0, this.strokePaint);
    L8:
        super.onDraw(r8);
    }

    public final boolean isDarkTheme() {
        int r0 = this.bgColor;
        if (r0 != 0) goto L7;
        return ViewUtilKt.isDarkMode(this);
    L7:
        return OPalette.isDarkColor(r0);
    }
}
