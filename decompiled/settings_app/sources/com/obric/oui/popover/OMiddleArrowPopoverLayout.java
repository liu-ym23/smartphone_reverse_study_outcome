package com.obric.oui.popover;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.icu.lang.UCharacter;
import android.icu.text.PluralRules;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.material.MaterialConfigFormatNames;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: compiled from: OMiddleArrowPopoverLayout.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 i2\u00020\u0001:\u0002ijB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010H\u001a\u00020\tJ\u0016\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020\u000f2\u0006\u0010L\u001a\u00020\u000fJ\u0006\u0010M\u001a\u00020\tJ\u0006\u0010N\u001a\u00020\u000fJ\u0006\u0010O\u001a\u00020 J\u0006\u0010=\u001a\u00020\tJ\u0006\u0010P\u001a\u00020AJ\u0018\u0010Q\u001a\u00020R2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\b\u0010S\u001a\u00020RH\u0002J\u0016\u0010T\u001a\u00020R2\u0006\u0010U\u001a\u00020+2\u0006\u0010V\u001a\u00020\tJ\u0012\u0010W\u001a\u00020R2\b\u0010X\u001a\u0004\u0018\u00010YH\u0014J\u0010\u0010Z\u001a\u00020R2\u0006\u0010[\u001a\u00020#H\u0015J\u0018\u0010\\\u001a\u00020R2\u0006\u0010]\u001a\u00020\t2\u0006\u0010^\u001a\u00020\tH\u0015J\u000e\u0010_\u001a\u00020R2\u0006\u0010`\u001a\u00020\tJ\u000e\u0010a\u001a\u00020R2\u0006\u0010K\u001a\u00020\tJ\u000e\u0010b\u001a\u00020R2\u0006\u0010c\u001a\u00020\tJ\u0016\u0010d\u001a\u00020R2\u0006\u0010c\u001a\u00020\t2\u0006\u0010e\u001a\u00020\u000fJ\u0010\u0010f\u001a\u00020R2\b\b\u0001\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010g\u001a\u00020R2\u0006\u0010h\u001a\u00020+R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u00020\t8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0014\"\u0004\b\u001b\u0010\u0016R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u00100\u001a\u00020+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010-\"\u0004\b2\u0010/R\u000e\u00103\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082.¢\u0006\u0002\n\u0000R\u001a\u00108\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010'\"\u0004\b:\u0010)R\u000e\u0010;\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010<\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010'\"\u0004\b>\u0010)R\u000e\u0010?\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020AX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010E\u001a\u00020+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010-\"\u0004\bG\u0010/¨\u0006k"}, d2 = {"Lcom/obric/oui/popover/OMiddleArrowPopoverLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "arrowPadding", "borderColor", "borderWidth", "cornerRadius", "", "defaultHeight", "defaultWidth", "mAdjustHeight", "getMAdjustHeight", "()I", "setMAdjustHeight", "(I)V", "mArrowPressedPaint", "Landroid/graphics/Paint;", "mBgColor", "getMBgColor", "setMBgColor", "mBitmap", "Landroid/graphics/Bitmap;", "mBubbleArrowOffset", "mBubbleArrowPath", "Landroid/graphics/Path;", "mBubbleOrientation", "mCanvas", "Landroid/graphics/Canvas;", "mFillPaint", "mHeight", "getMHeight", "()F", "setMHeight", "(F)V", "mNeedArrow", "", "getMNeedArrow", "()Z", "setMNeedArrow", "(Z)V", "mNeedShadow", "getMNeedShadow", "setMNeedShadow", "mPath", "mPopoverGg", "Landroid/graphics/drawable/Drawable;", "mRoundRect", "Landroid/graphics/RectF;", "mWidth", "getMWidth", "setMWidth", "minArrowDistance", "padding", "getPadding", "setPadding", "pressStateColor", "shadowConfig", "Lcom/obric/oui/popover/OMiddleArrowPopoverLayout$ShadowConfig;", "strokePaint", "tempArrowPath", "tempRectPath", "useDefaultView", "getUseDefaultView", "setUseDefaultView", "arrowDirection", "calculateBubbleArrowMatrix", "Landroid/graphics/Matrix;", MaterialConfigFormatNames.WIDTH, MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "getArrowHeight", "getBubbleOffset", "getFullPath", "getShadowConfig", "init", "", "initSimpleBubbleLegPrototype", "notifyPressed", "pressed", "pressedColor", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDraw", "canvas", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setBorderColor", "color", "setBorderWidth", "setBubbleOrientation", "bubbleOrientation", "setBubbleParams", "bubbleArrowOffset", "setCornerRadius", "setTransparentBg", "transparent", "Companion", "ShadowConfig", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OMiddleArrowPopoverLayout extends LinearLayout {
    public static final int BOTTOM = 3;
    public static final Companion Companion = null;
    public static final int LEFT = 1;
    public static final int RIGHT = 2;
    public static final int TOP = 0;
    private static int arrowPaddingDp;
    private static float cornerRadiusDp;
    private static int defaultHeightDp;
    private static int defaultPaddingDp;
    private static int defaultWidthDp;
    private static float minArrowDistanceDp;
    private int arrowPadding;
    private int borderColor;
    private int borderWidth;
    private float cornerRadius;
    private int defaultHeight;
    private int defaultWidth;
    private int mAdjustHeight;
    private Paint mArrowPressedPaint;
    private int mBgColor;
    private Bitmap mBitmap;
    private float mBubbleArrowOffset;
    private Path mBubbleArrowPath;
    private int mBubbleOrientation;
    private Canvas mCanvas;
    private Paint mFillPaint;
    private float mHeight;
    private boolean mNeedArrow;
    private boolean mNeedShadow;
    private Path mPath;
    private Drawable mPopoverGg;
    private RectF mRoundRect;
    private float mWidth;
    private float minArrowDistance;
    private float padding;
    private int pressStateColor;
    private ShadowConfig shadowConfig;
    private Paint strokePaint;
    private final Path tempArrowPath;
    private final Path tempRectPath;
    private boolean useDefaultView;

    /* JADX INFO: compiled from: OMiddleArrowPopoverLayout.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0011\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u001a\u0010\u0016\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\fR\u001a\u0010\u0019\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\n\"\u0004\b\u001b\u0010\fR\u001a\u0010\u001c\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/obric/oui/popover/OMiddleArrowPopoverLayout$Companion;", "", "()V", "BOTTOM", "", "LEFT", "RIGHT", "TOP", "arrowPaddingDp", "getArrowPaddingDp", "()I", "setArrowPaddingDp", "(I)V", "cornerRadiusDp", "", "getCornerRadiusDp", "()F", "setCornerRadiusDp", "(F)V", "defaultHeightDp", "getDefaultHeightDp", "setDefaultHeightDp", "defaultPaddingDp", "getDefaultPaddingDp", "setDefaultPaddingDp", "defaultWidthDp", "getDefaultWidthDp", "setDefaultWidthDp", "minArrowDistanceDp", "getMinArrowDistanceDp", "setMinArrowDistanceDp", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final int getArrowPaddingDp() {
            return OMiddleArrowPopoverLayout.access$getArrowPaddingDp$cp();
        }

        public final void setArrowPaddingDp(int r1) {
            OMiddleArrowPopoverLayout.access$setArrowPaddingDp$cp(r1);
        }

        public final float getMinArrowDistanceDp() {
            return OMiddleArrowPopoverLayout.access$getMinArrowDistanceDp$cp();
        }

        public final void setMinArrowDistanceDp(float r1) {
            OMiddleArrowPopoverLayout.access$setMinArrowDistanceDp$cp(r1);
        }

        public final int getDefaultWidthDp() {
            return OMiddleArrowPopoverLayout.access$getDefaultWidthDp$cp();
        }

        public final void setDefaultWidthDp(int r1) {
            OMiddleArrowPopoverLayout.access$setDefaultWidthDp$cp(r1);
        }

        public final int getDefaultHeightDp() {
            return OMiddleArrowPopoverLayout.access$getDefaultHeightDp$cp();
        }

        public final void setDefaultHeightDp(int r1) {
            OMiddleArrowPopoverLayout.access$setDefaultHeightDp$cp(r1);
        }

        public final float getCornerRadiusDp() {
            return OMiddleArrowPopoverLayout.access$getCornerRadiusDp$cp();
        }

        public final void setCornerRadiusDp(float r1) {
            OMiddleArrowPopoverLayout.access$setCornerRadiusDp$cp(r1);
        }

        public final int getDefaultPaddingDp() {
            return OMiddleArrowPopoverLayout.access$getDefaultPaddingDp$cp();
        }

        public final void setDefaultPaddingDp(int r1) {
            OMiddleArrowPopoverLayout.access$setDefaultPaddingDp$cp(r1);
        }
    }

    /* JADX INFO: compiled from: OMiddleArrowPopoverLayout.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010¨\u0006 "}, d2 = {"Lcom/obric/oui/popover/OMiddleArrowPopoverLayout$ShadowConfig;", "", "radius", "", "dx", "dy", "color", "", "(FFFI)V", "getColor", "()I", "setColor", "(I)V", "getDx", "()F", "setDx", "(F)V", "getDy", "setDy", "getRadius", "setRadius", "component1", "component2", "component3", "component4", "copy", "equals", "", PluralRules.KEYWORD_OTHER, "hashCode", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ShadowConfig {
        private int color;
        private float dx;
        private float dy;
        private float radius;

        public ShadowConfig() {
            this(0.0f, 0.0f, 0.0f, 0, 15, null);
        }

        public static /* synthetic */ ShadowConfig copy$default(ShadowConfig r0, float r1, float r2, float r3, int r4, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = r0.radius;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = r0.dx;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r3 = r0.dy;
        L12:
            if ((r5 & 8) == 0) goto L15;
            r4 = r0.color;
        L15:
            return r0.copy(r1, r2, r3, r4);
        }

        public final float component1() {
            return this.radius;
        }

        public final float component2() {
            return this.dx;
        }

        public final float component3() {
            return this.dy;
        }

        public final int component4() {
            return this.color;
        }

        public final ShadowConfig copy(float r1, float r2, float r3, int r4) {
            return new ShadowConfig(r1, r2, r3, r4);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof ShadowConfig) == true) goto L8;
            return false;
        L8:
            ShadowConfig r6 = (ShadowConfig) r5;
            if (Intrinsics.areEqual(Float.valueOf(this.radius), Float.valueOf(r6.radius)) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(Float.valueOf(this.dx), Float.valueOf(r6.dx)) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(Float.valueOf(this.dy), Float.valueOf(r6.dy)) == true) goto L18;
            return false;
        L18:
            if (this.color == r6.color) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((Float.hashCode(this.radius) * 31) + Float.hashCode(this.dx)) * 31) + Float.hashCode(this.dy)) * 31) + Integer.hashCode(this.color);
        }

        public String toString() {
            return "ShadowConfig(radius=" + this.radius + ", dx=" + this.dx + ", dy=" + this.dy + ", color=" + this.color + ')';
        }

        public ShadowConfig(float r1, float r2, float r3, int r4) {
            this.radius = r1;
            this.dx = r2;
            this.dy = r3;
            this.color = r4;
        }

        public /* synthetic */ ShadowConfig(float r2, float r3, float r4, int r5, int r6, DefaultConstructorMarker r7) {
            if ((r6 & 1) == 0) goto L6;
            r2 = 2.0f;
        L6:
            if ((r6 & 2) == 0) goto L9;
            r3 = 2.0f;
        L9:
            if ((r6 & 4) == 0) goto L12;
            r4 = 5.0f;
        L12:
            if ((r6 & 8) == 0) goto L14;
            r5 = -16777216;
        L14:
            this(r2, r3, r4, r5);
        }

        public final float getRadius() {
            return this.radius;
        }

        public final void setRadius(float r1) {
            this.radius = r1;
        }

        public final float getDx() {
            return this.dx;
        }

        public final void setDx(float r1) {
            this.dx = r1;
        }

        public final float getDy() {
            return this.dy;
        }

        public final void setDy(float r1) {
            this.dy = r1;
        }

        public final int getColor() {
            return this.color;
        }

        public final void setColor(int r1) {
            this.color = r1;
        }
    }

    public static final /* synthetic */ int access$getArrowPaddingDp$cp() {
        return arrowPaddingDp;
    }

    public static final /* synthetic */ float access$getCornerRadiusDp$cp() {
        return cornerRadiusDp;
    }

    public static final /* synthetic */ int access$getDefaultHeightDp$cp() {
        return defaultHeightDp;
    }

    public static final /* synthetic */ int access$getDefaultPaddingDp$cp() {
        return defaultPaddingDp;
    }

    public static final /* synthetic */ int access$getDefaultWidthDp$cp() {
        return defaultWidthDp;
    }

    public static final /* synthetic */ float access$getMinArrowDistanceDp$cp() {
        return minArrowDistanceDp;
    }

    public static final /* synthetic */ void access$setArrowPaddingDp$cp(int r0) {
        arrowPaddingDp = r0;
    }

    public static final /* synthetic */ void access$setCornerRadiusDp$cp(float r0) {
        cornerRadiusDp = r0;
    }

    public static final /* synthetic */ void access$setDefaultHeightDp$cp(int r0) {
        defaultHeightDp = r0;
    }

    public static final /* synthetic */ void access$setDefaultPaddingDp$cp(int r0) {
        defaultPaddingDp = r0;
    }

    public static final /* synthetic */ void access$setDefaultWidthDp$cp(int r0) {
        defaultWidthDp = r0;
    }

    public static final /* synthetic */ void access$setMinArrowDistanceDp$cp(float r0) {
        minArrowDistanceDp = r0;
    }

    static {
        Companion = new Companion(null);
        arrowPaddingDp = 9;
        minArrowDistanceDp = 18.0f;
        defaultWidthDp = 42;
        defaultHeightDp = 42;
        cornerRadiusDp = Integer.min(42, 42) / 2.0f;
        defaultPaddingDp = 12;
    }

    public final float getPadding() {
        return this.padding;
    }

    public final void setPadding(float r1) {
        this.padding = r1;
    }

    public final float getMWidth() {
        return this.mWidth;
    }

    public final void setMWidth(float r1) {
        this.mWidth = r1;
    }

    public final float getMHeight() {
        return this.mHeight;
    }

    public final void setMHeight(float r1) {
        this.mHeight = r1;
    }

    public final void setMBgColor(int r1) {
        this.mBgColor = r1;
    }

    public final int getMBgColor() {
        int r0 = this.pressStateColor;
        if (r0 == 0) goto L6;
        return r0;
    L6:
        return this.mBgColor;
    }

    public final boolean getMNeedShadow() {
        return this.mNeedShadow;
    }

    public final void setMNeedShadow(boolean r1) {
        this.mNeedShadow = r1;
    }

    public final boolean getMNeedArrow() {
        return this.mNeedArrow;
    }

    public final void setMNeedArrow(boolean r1) {
        this.mNeedArrow = r1;
    }

    public final boolean getUseDefaultView() {
        return this.useDefaultView;
    }

    public final void setUseDefaultView(boolean r1) {
        this.useDefaultView = r1;
    }

    public final int getMAdjustHeight() {
        return this.mAdjustHeight;
    }

    public final void setMAdjustHeight(int r1) {
        this.mAdjustHeight = r1;
    }

    public OMiddleArrowPopoverLayout(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public OMiddleArrowPopoverLayout(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    public OMiddleArrowPopoverLayout(Context r9, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        super(r9, r10, r11);
        this.shadowConfig = new ShadowConfig(0.0f, 0.0f, 0.0f, 0, 15, null);
        this.mBubbleArrowOffset = 0.75f;
        this.mBubbleOrientation = 1;
        this.mNeedArrow = true;
        this.useDefaultView = true;
        this.tempRectPath = new Path();
        this.tempArrowPath = new Path();
        init(r9, r10);
    }

    public final void init(Context r5, AttributeSet r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this.arrowPadding = OUnitExtensionKt.cdp(r5, arrowPaddingDp);
        this.minArrowDistance = OUnitExtensionKt.cdpFloat(r5, minArrowDistanceDp);
        this.defaultWidth = OUnitExtensionKt.cdp(r5, defaultWidthDp);
        this.defaultHeight = OUnitExtensionKt.cdp(r5, defaultHeightDp);
        this.cornerRadius = OUnitExtensionKt.cdpFloat(r5, cornerRadiusDp);
        this.padding = OUnitExtensionKt.cdpFloat(r5, defaultPaddingDp);
        this.mFillPaint = new Paint();
        this.mPath = new Path();
        this.mBubbleArrowPath = new Path();
        Paint r7 = this.mFillPaint;
        if (r7 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r7 = null;
    L5:
        r7.setStyle(Paint.Style.FILL);
        Paint r8 = this.mFillPaint;
        if (r8 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r8 = null;
    L8:
        r8.setStrokeCap(Paint.Cap.BUTT);
        Paint r9 = this.mFillPaint;
        if (r9 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r9 = null;
    L11:
        r9.setAntiAlias(true);
        Paint r10 = this.mFillPaint;
        if (r10 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r10 = null;
    L14:
        r10.setStrokeJoin(Paint.Join.MITER);
        if (getMBgColor() != 0) goto L17;
        this.mBgColor = ContextCompat.getColor(r5, R.color.SDPrimary);
    L17:
        Paint r11 = this.mFillPaint;
        if (r11 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r11 = null;
    L20:
        r11.setColor(getMBgColor());
        setLayerType(1, null);
        setBackgroundColor(0);
        setClipChildren(false);
        this.mPopoverGg = r5.getDrawable(R.drawable.o_bg_middle_arrow_popover);
    }

    public final void setCornerRadius(float r1) {
        this.cornerRadius = r1;
    }

    public final void setBorderColor(int r1) {
        this.borderColor = r1;
    }

    public final void setBorderWidth(int r4) {
        if (r4 > 0) goto L4;
        return;
    L4:
        this.borderWidth = r4;
        if (this.strokePaint != null) goto L7;
        this.strokePaint = new Paint();
    L7:
        Paint r5 = this.strokePaint;
        if (r5 == null) goto L11;
        r5.setStyle(Paint.Style.STROKE);
    L11:
        Paint r6 = this.strokePaint;
        if (r6 == null) goto L15;
        r6.setStrokeWidth(this.borderWidth);
    L15:
        Paint r7 = this.strokePaint;
        if (r7 == null) goto L19;
        r7.setStrokeCap(Paint.Cap.BUTT);
    L19:
        Paint r8 = this.strokePaint;
        if (r8 == null) goto L23;
        r8.setStrokeJoin(Paint.Join.MITER);
    L23:
        Paint r9 = this.strokePaint;
        if (r9 == null) goto L27;
        r9.setAntiAlias(true);
    L27:
        Paint r10 = this.strokePaint;
        if (r10 == null) goto L31;
        r10.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
    L31:
        Paint r11 = this.strokePaint;
        if (r11 == null) goto L35;
        r11.setColor(this.borderColor);
    L35:
        Paint r12 = this.mFillPaint;
        Paint r0 = null;
        if (r12 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r12 = null;
    L38:
        r12.setStyle(Paint.Style.FILL_AND_STROKE);
        Paint r13 = this.mFillPaint;
        if (r13 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L42:
        r0.setStrokeWidth(this.borderWidth);
        return;
    L41:
        r0 = r13;
        goto L42
    }

    public final void setTransparentBg(boolean r3) {
        if (r3 == false) goto L5;
        this.mBgColor = 0;
        setLayerType(1, null);
        return;
    L5:
        setLayerType(1, null);
    }

    private final void initSimpleBubbleLegPrototype() {
        float r0 = this.arrowPadding;
        float r1 = this.mHeight;
        float r2 = (r0 + (r1 / 2.0f)) - ((r1 / 2.0f) / 1.63f);
        float r3 = (r1 / 2.0f) / 1.56f;
        Path r4 = this.mBubbleArrowPath;
        Path r5 = null;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
        r4 = null;
    L5:
        r4.reset();
        Path r6 = this.mBubbleArrowPath;
        if (r6 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
        r6 = null;
    L8:
        r6.moveTo(0.0f, 0.0f);
        Path r7 = this.mBubbleArrowPath;
        if (r7 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
        r7 = null;
    L11:
        r7.lineTo(r2, -r3);
        Path r8 = this.mBubbleArrowPath;
        if (r8 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
        r8 = null;
    L14:
        r8.lineTo(r2, r3);
        Path r9 = this.mBubbleArrowPath;
        if (r9 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
        r9 = null;
    L17:
        r9.lineTo(0.0f, 0.0f);
        Path r10 = this.mBubbleArrowPath;
        if (r10 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
    L21:
        r5.close();
        return;
    L20:
        r5 = r10;
        goto L21
    }

    public final void setBubbleParams(int r1, float r2) {
        this.mBubbleArrowOffset = r2;
        this.mBubbleOrientation = r1;
    }

    public final void setBubbleOrientation(int r1) {
        this.mBubbleOrientation = r1;
    }

    public final Matrix calculateBubbleArrowMatrix(float r9, float r10) {
        float r0 = Math.max(this.mBubbleArrowOffset, this.minArrowDistance + this.arrowPadding);
        Matrix r1 = new Matrix();
        int r2 = this.borderWidth;
        int r3 = r2 / 2;
        int r4 = this.mBubbleOrientation;
        if (r4 != 0) goto L5;
        float r11 = Math.min(r0, (r9 - this.arrowPadding) - this.minArrowDistance);
        float r12 = this.borderWidth;
        r1.postRotate(90.0f);
        setPadding(0, r3, 0, 0);
    L15:
        setGravity(17);
        int r5 = this.arrowPadding;
        int r6 = this.borderWidth;
        this.mRoundRect = new RectF(r5 + (r6 / 2), r5 + (r6 / 2), (this.mWidth - r5) - r6, (this.mHeight - r5) - r6);
        r1.postTranslate(r11, r12);
        Path r13 = this.mPath;
        Path r7 = null;
        if (r13 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
        r13 = null;
    L18:
        r13.reset();
        this.tempRectPath.reset();
        Path r14 = this.tempRectPath;
        RectF r8 = this.mRoundRect;
        if (r8 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mRoundRect");
        r8 = null;
    L21:
        float r15 = this.cornerRadius;
        r14.addRoundRect(r8, r15, r15, Path.Direction.CW);
        if (this.mNeedArrow == false) goto L27;
        this.tempArrowPath.reset();
        Path r16 = this.tempArrowPath;
        Path r17 = this.mBubbleArrowPath;
        if (r17 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
        r17 = null;
    L26:
        r16.addPath(r17, r1);
        this.tempRectPath.op(this.tempArrowPath, Path.Op.UNION);
    L27:
        Path r18 = this.mPath;
        if (r18 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L31:
        r7.addPath(this.tempRectPath);
        return r1;
    L30:
        r7 = r18;
        goto L31
    L5:
        if (r4 != 1) goto L7;
        r11 = r2;
        r12 = Math.min(r0, (r10 - this.arrowPadding) - this.minArrowDistance);
        setPadding(r3, 0, 0, 0);
        goto L15
    L7:
        if (r4 != 2) goto L9;
        r11 = r9 - r2;
        r12 = Math.min(r0, (r10 - this.arrowPadding) - this.minArrowDistance);
        r1.postRotate(180.0f);
        setPadding(0, 0, r3, 0);
        goto L15
    L9:
        if (r4 == 3) goto L11;
        r11 = 0.0f;
        r12 = 0.0f;
        goto L15
    L11:
        r11 = Math.min(r0, (r9 - this.arrowPadding) - this.minArrowDistance);
        r12 = r10 - this.borderWidth;
        r1.postRotate(270.0f);
        setPadding(0, 0, 0, r3);
        goto L15
    }

    public final float getBubbleOffset() {
        float r0 = Math.max(this.mBubbleArrowOffset, this.minArrowDistance);
        int r1 = this.mBubbleOrientation;
        if (r1 == 0) goto L15;
        if (r1 == 1) goto L19;
        if (r1 == 2) goto L18;
        if (r1 == 3) goto L17;
        return 0.0f;
    L17:
        return Math.min(r0, (this.mWidth - this.arrowPadding) - this.minArrowDistance);
    L18:
        return Math.min(r0, (this.mHeight - this.arrowPadding) - this.minArrowDistance);
    L19:
        return Math.min(r0, (this.mHeight - this.arrowPadding) - this.minArrowDistance);
    L15:
        return Math.min(r0, (this.mWidth - this.arrowPadding) - this.minArrowDistance);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int r8, int r9) {
        super.onMeasure(r8, r9);
        if ((getChildAt(0) instanceof TextView) == false) goto L9;
        View r1 = getChildAt(0);
        if (r1 == null) goto L8;
        TextView r2 = (TextView) r1;
    L10:
        int r3 = View.MeasureSpec.getMode(r8);
        int r10 = View.MeasureSpec.getSize(r8);
        int r4 = View.MeasureSpec.getMode(r9);
        int r11 = View.MeasureSpec.getSize(r9);
        if (r2 == null) goto L17;
        Context r5 = getContext();
        Intrinsics.checkNotNullExpressionValue(r5, "context");
        int r6 = OUnitExtensionKt.cdp(r5, UCharacter.UnicodeBlock.MASARAM_GONDI_ID);
        if (((int) r2.getPaint().measureText(r2.getText().toString())) > r6) goto L16;
        r6 = (int) r2.getPaint().measureText(r2.getText().toString());
    L16:
        int r7 = (r6 + r2.getPaddingLeft()) + r2.getPaddingRight();
    L19:
        if (this.useDefaultView == false) goto L24;
        int r0 = this.defaultWidth;
        if (r7 <= r0) goto L23;
        r0 = (((int) this.padding) * 2) + r7;
    L23:
        int r12 = this.arrowPadding;
        int r13 = this.borderWidth;
        int r14 = (r0 + (r12 * 2)) + (r13 * 2);
        int r15 = (this.defaultHeight + (r12 * 2)) + (r13 * 2);
    L26:
        if (r3 != Integer.MIN_VALUE) goto L29;
        if (r4 != Integer.MIN_VALUE) goto L29;
        setMeasuredDimension(r14, r15);
    L33:
        this.mWidth = getMeasuredWidth();
        this.mHeight = getMeasuredHeight();
        initSimpleBubbleLegPrototype();
        return;
    L29:
        if (r3 != Integer.MIN_VALUE) goto L31;
        setMeasuredDimension(r14, r11);
        goto L33
    L31:
        if (r4 != Integer.MIN_VALUE) goto L33;
        setMeasuredDimension(r10, r15);
        goto L33
    L24:
        PopupWindow r16 = new PopupWindow(getChildAt(0), -2, -2, true);
        r16.getContentView().measure(0, 0);
        r14 = r16.getContentView().getMeasuredWidth() + (arrowPaddingDp * 2);
        r15 = r16.getContentView().getMeasuredHeight() + (arrowPaddingDp * 2);
        goto L26
    L17:
        r7 = getMeasuredWidth();
        goto L19
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L9:
        r2 = null;
        goto L10
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        if (this.mBitmap != null) goto L5;
        this.mBitmap = Bitmap.createBitmap(getContext().getResources().getDisplayMetrics(), getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        Bitmap r1 = this.mBitmap;
        Intrinsics.checkNotNull(r1);
        this.mCanvas = new Canvas(r1);
    L5:
        Paint r0 = this.mFillPaint;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r0 = null;
    L8:
        r0.setColor(getMBgColor());
        Drawable r2 = this.mPopoverGg;
        if (r2 == null) goto L34;
        int r3 = this.mBubbleOrientation;
        if (r3 != 0) goto L14;
        float r4 = 270.0f;
    L21:
        int r5 = this.arrowPadding + ((int) getPadding());
        int r6 = this.arrowPadding;
        int r7 = (getHeight() - ((int) ((((getWidth() - r5) - r6) * r2.getIntrinsicHeight()) / r2.getIntrinsicWidth()))) / 2;
        r2.setBounds(r5, r7, getWidth() - r6, getHeight() - r7);
        Canvas r8 = this.mCanvas;
        if (r8 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mCanvas");
        r8 = null;
    L24:
        r8.save();
        Canvas r9 = this.mCanvas;
        if (r9 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("mCanvas");
        r9 = null;
    L27:
        r9.rotate(r4, getWidth() / 2.0f, getHeight() / 2.0f);
        Canvas r11 = this.mCanvas;
        if (r11 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mCanvas");
        r11 = null;
    L30:
        r2.draw(r11);
        Canvas r12 = this.mCanvas;
        if (r12 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("mCanvas");
        r12 = null;
    L33:
        r12.restore();
        goto L34
    L14:
        if (r3 != 1) goto L16;
        r4 = 180.0f;
        goto L21
    L16:
        if (r3 == 3) goto L18;
        r4 = 0.0f;
        goto L21
    L18:
        r4 = 90.0f;
    L34:
        Bitmap r13 = this.mBitmap;
        Intrinsics.checkNotNull(r13);
        r10.drawBitmap(r13, 0.0f, 0.0f, null);
    }

    public final void notifyPressed(boolean r2, int r3) {
        if (r2 == true) goto L4;
        Paint r1 = this.mArrowPressedPaint;
        if (r1 == null) goto L28;
        r1.setColor(0);
        return;
    L28:
        return;
    L4:
        if (this.mArrowPressedPaint != null) goto L17;
        Paint r4 = new Paint();
        this.mArrowPressedPaint = r4;
        r4.setStyle(Paint.Style.FILL);
        Paint r5 = this.mArrowPressedPaint;
        if (r5 == null) goto L9;
        r5.setStrokeCap(Paint.Cap.BUTT);
    L9:
        Paint r6 = this.mArrowPressedPaint;
        if (r6 == null) goto L13;
        r6.setStrokeJoin(Paint.Join.MITER);
    L13:
        Paint r7 = this.mArrowPressedPaint;
        if (r7 == null) goto L17;
        r7.setAntiAlias(true);
    L17:
        Paint r8 = this.mArrowPressedPaint;
        if (r8 == null) goto L27;
        r8.setColor(r3);
        return;
    }

    public final int arrowDirection() {
        return this.mBubbleOrientation;
    }

    /* JADX INFO: renamed from: getPadding, reason: collision with other method in class */
    public final int m1286getPadding() {
        return this.arrowPadding / 2;
    }

    public final int getArrowHeight() {
        return this.arrowPadding;
    }

    public final Path getFullPath() {
        Path r0 = this.mPath;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
        return null;
    L6:
        return r0;
    }

    public final ShadowConfig getShadowConfig() {
        return this.shadowConfig;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration r3) {
        super.onConfigurationChanged(r3);
        Context r4 = getContext();
        Intrinsics.checkNotNullExpressionValue(r4, "context");
        this.arrowPadding = OUnitExtensionKt.cdp(r4, arrowPaddingDp);
        Context r5 = getContext();
        Intrinsics.checkNotNullExpressionValue(r5, "context");
        this.minArrowDistance = OUnitExtensionKt.cdpFloat(r5, minArrowDistanceDp);
        Context r6 = getContext();
        Intrinsics.checkNotNullExpressionValue(r6, "context");
        this.defaultWidth = OUnitExtensionKt.cdp(r6, defaultWidthDp);
        Context r7 = getContext();
        Intrinsics.checkNotNullExpressionValue(r7, "context");
        this.defaultHeight = OUnitExtensionKt.cdp(r7, defaultHeightDp);
        Context r8 = getContext();
        Intrinsics.checkNotNullExpressionValue(r8, "context");
        this.cornerRadius = OUnitExtensionKt.cdpFloat(r8, cornerRadiusDp);
        Context r9 = getContext();
        Intrinsics.checkNotNullExpressionValue(r9, "context");
        this.padding = OUnitExtensionKt.cdpFloat(r9, defaultPaddingDp);
    }
}
