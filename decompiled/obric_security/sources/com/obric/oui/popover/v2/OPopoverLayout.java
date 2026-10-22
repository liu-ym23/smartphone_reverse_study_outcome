package com.obric.oui.popover.v2;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import com.obric.common.oui.R;
import com.obric.oui.color.OPalette;
import com.obric.oui.common.style.ODynamicThemeWidget;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.material.MaterialConfig;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.OMaterialExtBaseKt;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.utils.ViewUtilKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OPopoverLayout.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u001d\u0018\u0000 i2\u00020\u00012\u00020\u0002:\u0001iB=\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u001a\b\u0002\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rB\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010B!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0011\u001a\u00020\f¢\u0006\u0002\u0010\u0012BQ\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u001a\b\u0002\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\u0013J\u0010\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\fH\u0016J\u0010\u0010=\u001a\u00020;2\u0006\u0010>\u001a\u00020?H\u0014J\u0006\u0010@\u001a\u00020\fJ\u000e\u0010A\u001a\u00020'2\u0006\u0010B\u001a\u00020\fJ\u0006\u0010C\u001a\u00020'J\u0006\u0010D\u001a\u00020\fJ\u0018\u0010E\u001a\u00020;2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\b\u0010F\u001a\u00020\u0006H\u0016J\u0006\u0010G\u001a\u00020\u0006J\b\u0010H\u001a\u00020;H\u0014J\b\u0010I\u001a\u00020;H\u0014J\u0010\u0010J\u001a\u00020;2\u0006\u0010>\u001a\u00020?H\u0015J\u0012\u0010K\u001a\u00020\u00062\b\u0010L\u001a\u0004\u0018\u00010MH\u0016J\u0018\u0010N\u001a\u00020;2\u0006\u0010O\u001a\u00020\f2\u0006\u0010P\u001a\u00020\fH\u0015J(\u0010Q\u001a\u00020;2\u0006\u0010R\u001a\u00020\f2\u0006\u0010S\u001a\u00020\f2\u0006\u0010T\u001a\u00020\f2\u0006\u0010U\u001a\u00020\fH\u0014J\u0012\u0010V\u001a\u00020\u00062\b\u0010W\u001a\u0004\u0018\u00010MH\u0016J\u0010\u0010X\u001a\u00020;2\b\b\u0001\u0010Y\u001a\u00020\fJ\u000e\u0010Z\u001a\u00020;2\u0006\u0010Y\u001a\u00020\fJ\u000e\u0010[\u001a\u00020;2\u0006\u0010\\\u001a\u00020\fJ\u0010\u0010]\u001a\u00020;2\b\b\u0001\u0010^\u001a\u00020'J\u000e\u0010_\u001a\u00020;2\u0006\u0010`\u001a\u00020'J\u0018\u0010a\u001a\u00020;2\u0006\u0010b\u001a\u00020\u00062\b\b\u0003\u0010Y\u001a\u00020\fJ\u000e\u0010c\u001a\u00020;2\u0006\u0010d\u001a\u00020\u0006J\b\u0010e\u001a\u00020;H\u0002J\u000e\u0010f\u001a\u00020;2\u0006\u0010g\u001a\u00020'J\b\u0010h\u001a\u00020;H\u0002R\u000e\u0010\u0014\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010!\u001a\u00020\f8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010*\u001a\u00020'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u000e\u0010/\u001a\u000200X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00105\u001a\u00020'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010,\"\u0004\b7\u0010.R\u000e\u00108\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006j"}, d2 = {"Lcom/obric/oui/popover/v2/OPopoverLayout;", "Landroid/widget/LinearLayout;", "Lcom/obric/oui/common/style/ODynamicThemeWidget;", "context", "Landroid/content/Context;", "enableMaterialByUser", "", "materials", "Lkotlin/Function1;", "", "Lcom/obric/oui/material/MaterialConfig;", "materialSrcType", "", "(Landroid/content/Context;ZLkotlin/jvm/functions/Function1;I)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;IZLkotlin/jvm/functions/Function1;I)V", "appliedMaterialSrcType", "appliedMaterials", "borderColor", "borderWidth", "colorEvaluator", "Landroid/animation/ArgbEvaluator;", "coverColor", "coverColorOnAnimStart", "coverEnabled", "currentCoverColor", "enableMaterial", "fillPaintAnimator", "Landroid/animation/ValueAnimator;", "mBgColor", "getMBgColor", "()I", "setMBgColor", "(I)V", "mCornerRadius", "", "mFillPaint", "Landroid/graphics/Paint;", "mHeight", "getMHeight", "()F", "setMHeight", "(F)V", "mPath", "Landroid/graphics/Path;", "mRoundRect", "Landroid/graphics/Rect;", "mRoundRectF", "Landroid/graphics/RectF;", "mWidth", "getMWidth", "setMWidth", "pressStateColor", "strokePaint", "applyDynamicTheme", "", "themeStyle", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "getArrowHeight", "getBubbleOffset", "gravity", "getCornerRadius", "getPadding", "init", "isDarkTheme", "isEnableMaterial", "onAttachedToWindow", "onDetachedFromWindow", "onDraw", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEvent", "event", "setBgColor", "color", "setBorderColor", "setBorderWidth", MaterialConfigFormatNames.WIDTH, "setCornerRadius", "cornerRadius", "setCornerRadiusDp", "cornerRadiusDp", "setCovered", "covered", "setTransparentBg", "transparent", "startFillPaintFadeIfNeeded", "updateCoverAnimFraction", "fraction", "updateMaterial", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OPopoverLayout extends LinearLayout implements ODynamicThemeWidget {
    private static int ARROW_PADDING = 0;
    public static final int BOTTOM = 3;
    private static float CORNER_RADIUS_DP = 0.0f;
    public static final Companion Companion = null;
    private static int DEFAULT_HEIGHT = 0;
    public static final int LEFT = 1;
    private static float MIN_ARROW_DISTANCE_DP = 0.0f;
    public static final int RIGHT = 2;
    private static final String TAG = "OPopoverLayout";
    public static final int TOP = 0;
    private int appliedMaterialSrcType;
    private Function1<? super Boolean, MaterialConfig[]> appliedMaterials;
    private int borderColor;
    private int borderWidth;
    private final ArgbEvaluator colorEvaluator;
    private int coverColor;
    private int coverColorOnAnimStart;
    private boolean coverEnabled;
    private int currentCoverColor;
    private boolean enableMaterial;
    private boolean enableMaterialByUser;
    private ValueAnimator fillPaintAnimator;
    private int mBgColor;
    private float mCornerRadius;
    private Paint mFillPaint;
    private float mHeight;
    private Path mPath;
    private Rect mRoundRect;
    private RectF mRoundRectF;
    private float mWidth;
    private int pressStateColor;
    private Paint strokePaint;

    /* JADX INFO: compiled from: OPopoverLayout.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\r\"\u0004\b\u0016\u0010\u000fR\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/obric/oui/popover/v2/OPopoverLayout$Companion;", "", "()V", "ARROW_PADDING", "", "getARROW_PADDING", "()I", "setARROW_PADDING", "(I)V", "BOTTOM", "CORNER_RADIUS_DP", "", "getCORNER_RADIUS_DP", "()F", "setCORNER_RADIUS_DP", "(F)V", "DEFAULT_HEIGHT", "getDEFAULT_HEIGHT", "setDEFAULT_HEIGHT", "LEFT", "MIN_ARROW_DISTANCE_DP", "getMIN_ARROW_DISTANCE_DP", "setMIN_ARROW_DISTANCE_DP", "RIGHT", "TAG", "", "TOP", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final int getARROW_PADDING() {
            return OPopoverLayout.access$getARROW_PADDING$cp();
        }

        public final void setARROW_PADDING(int r1) {
            OPopoverLayout.access$setARROW_PADDING$cp(r1);
        }

        public final float getCORNER_RADIUS_DP() {
            return OPopoverLayout.access$getCORNER_RADIUS_DP$cp();
        }

        public final void setCORNER_RADIUS_DP(float r1) {
            OPopoverLayout.access$setCORNER_RADIUS_DP$cp(r1);
        }

        public final float getMIN_ARROW_DISTANCE_DP() {
            return OPopoverLayout.access$getMIN_ARROW_DISTANCE_DP$cp();
        }

        public final void setMIN_ARROW_DISTANCE_DP(float r1) {
            OPopoverLayout.access$setMIN_ARROW_DISTANCE_DP$cp(r1);
        }

        public final int getDEFAULT_HEIGHT() {
            return OPopoverLayout.access$getDEFAULT_HEIGHT$cp();
        }

        public final void setDEFAULT_HEIGHT(int r1) {
            OPopoverLayout.access$setDEFAULT_HEIGHT$cp(r1);
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$-wPTje6La-MggAZN9p4dG9wbBYs, reason: not valid java name */
    public static /* synthetic */ void m448$r8$lambda$wPTje6LaMggAZN9p4dG9wbBYs(OPopoverLayout r0, ValueAnimator r1) {
        m449startFillPaintFadeIfNeeded$lambda2$lambda1(r0, r1);
    }

    @Override // com.obric.oui.common.style.ODynamicThemeWidget
    public void applyDynamicTheme(int r1) {
    }

    public static final /* synthetic */ int access$getARROW_PADDING$cp() {
        return ARROW_PADDING;
    }

    public static final /* synthetic */ int access$getBorderWidth$p(OPopoverLayout r0) {
        return r0.borderWidth;
    }

    public static final /* synthetic */ float access$getCORNER_RADIUS_DP$cp() {
        return CORNER_RADIUS_DP;
    }

    public static final /* synthetic */ int access$getDEFAULT_HEIGHT$cp() {
        return DEFAULT_HEIGHT;
    }

    public static final /* synthetic */ float access$getMCornerRadius$p(OPopoverLayout r0) {
        return r0.mCornerRadius;
    }

    public static final /* synthetic */ float access$getMIN_ARROW_DISTANCE_DP$cp() {
        return MIN_ARROW_DISTANCE_DP;
    }

    public static final /* synthetic */ Rect access$getMRoundRect$p(OPopoverLayout r0) {
        return r0.mRoundRect;
    }

    public static final /* synthetic */ RectF access$getMRoundRectF$p(OPopoverLayout r0) {
        return r0.mRoundRectF;
    }

    public static final /* synthetic */ void access$setARROW_PADDING$cp(int r0) {
        ARROW_PADDING = r0;
    }

    public static final /* synthetic */ void access$setCORNER_RADIUS_DP$cp(float r0) {
        CORNER_RADIUS_DP = r0;
    }

    public static final /* synthetic */ void access$setDEFAULT_HEIGHT$cp(int r0) {
        DEFAULT_HEIGHT = r0;
    }

    public static final /* synthetic */ void access$setMIN_ARROW_DISTANCE_DP$cp(float r0) {
        MIN_ARROW_DISTANCE_DP = r0;
    }

    static {
        Companion = new Companion(null);
        CORNER_RADIUS_DP = 28.0f;
        DEFAULT_HEIGHT = 36;
    }

    public /* synthetic */ OPopoverLayout(Context r1, boolean r2, Function1 r3, int r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = MaterialToken.OUI_Bg_Popup;
    L6:
        if ((r5 & 8) == 0) goto L8;
        r4 = 3;
    L8:
        this(r1, r2, r3, r4);
    }

    public OPopoverLayout(Context r9, boolean r10, Function1<? super Boolean, MaterialConfig[]> r11, int r12) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r11, "materials");
        this(r9, null, 0, r10, r11, r12);
    }

    public OPopoverLayout(Context r11, AttributeSet r12) {
        Intrinsics.checkNotNullParameter(r11, "context");
        this(r11, r12, 0, true, null, 0, 48, null);
    }

    public OPopoverLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.mCornerRadius = OUnitExtensionKt.vdpFloat(this, CORNER_RADIUS_DP);
        this.coverColor = Color.parseColor("#20000000");
        this.coverColorOnAnimStart = this.currentCoverColor;
        this.colorEvaluator = new ArgbEvaluator();
        this.mRoundRect = new Rect();
        this.mRoundRectF = new RectF();
        this.enableMaterialByUser = true;
        this.appliedMaterials = MaterialToken.OUI_Bg_Popup;
        this.appliedMaterialSrcType = 3;
        init(r2, r3);
    }

    public /* synthetic */ OPopoverLayout(Context r8, AttributeSet r9, int r10, boolean r11, Function1 r12, int r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 8) == 0) goto L5;
        r11 = true;
    L5:
        boolean r4 = r11;
        if ((r14 & 16) == 0) goto L8;
        r12 = MaterialToken.OUI_Bg_Popup;
    L8:
        Function1 r5 = r12;
        if ((r14 & 32) == 0) goto L11;
        r13 = 3;
    L11:
        this(r8, r9, r10, r4, r5, r13);
    }

    public OPopoverLayout(Context r2, AttributeSet r3, int r4, boolean r5, Function1<? super Boolean, MaterialConfig[]> r6, int r7) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r6, "materials");
        super(r2, r3, r4);
        this.mCornerRadius = OUnitExtensionKt.vdpFloat(this, CORNER_RADIUS_DP);
        this.coverColor = Color.parseColor("#20000000");
        this.coverColorOnAnimStart = this.currentCoverColor;
        this.colorEvaluator = new ArgbEvaluator();
        this.mRoundRect = new Rect();
        this.mRoundRectF = new RectF();
        this.enableMaterialByUser = true;
        Function1<Boolean, MaterialConfig[]> r8 = MaterialToken.OUI_Bg_Popup;
        this.enableMaterialByUser = r5;
        this.appliedMaterials = r6;
        this.appliedMaterialSrcType = r7;
        init(r2, r3);
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

    public final void init(Context r5, AttributeSet r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this.mFillPaint = new Paint();
        this.mPath = new Path();
        Paint r7 = this.mFillPaint;
        Paint r0 = null;
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
        boolean r2 = true;
        r9.setAntiAlias(true);
        Paint r10 = this.mFillPaint;
        if (r10 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r10 = null;
    L14:
        r10.setStrokeJoin(Paint.Join.MITER);
        if (getMBgColor() != 0) goto L17;
        this.mBgColor = ContextCompat.getColor(r5, R.color.oui_bg_base_3);
    L17:
        Paint r11 = this.mFillPaint;
        if (r11 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L21:
        r0.setColor(getMBgColor());
        setClipChildren(false);
        setOutlineProvider(new AnonymousClass1(this));
        setClipToOutline(true);
        setBackgroundColor(0);
        if (OMaterialExtBaseKt.isMaterialEffectEnabled(this) == true) goto L24;
    L26:
        r2 = false;
    L27:
        this.enableMaterial = r2;
        updateMaterial();
        return;
    L24:
        if (OMaterialHelper.isWidgetMaterialEffectEnabled() == false) goto L26;
    L20:
        r0 = r11;
        goto L21
    }

    @Override // com.obric.oui.common.style.ODynamicThemeWidget
    public boolean isDarkTheme() {
        if (getMBgColor() != 0) goto L7;
        return ViewUtilKt.isDarkMode(this);
    L7:
        return OPalette.isDarkColor(getMBgColor());
    }

    public final void setBgColor(int r2) {
        if (getMBgColor() != r2) goto L5;
        return;
    L5:
        this.mBgColor = r2;
        Paint r3 = this.mFillPaint;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r3 = null;
    L8:
        r3.setColor(getMBgColor());
        updateMaterial();
    }

    private final void updateMaterial() {
        if (this.enableMaterialByUser == true) goto L6;
        return;
    L6:
        if (this.enableMaterial == true) goto L8;
        return;
    L8:
        MaterialConfig[] r2 = this.appliedMaterials.invoke(Boolean.valueOf(!isDarkTheme()));
        if (r2 == null) goto L13;
        OMaterialExtBaseKt.materials$default(this, r2, false, this.appliedMaterialSrcType, null, 10, null);
        return;
    }

    private final void startFillPaintFadeIfNeeded() {
        if (this.enableMaterial == true) goto L5;
        return;
    L5:
        if (this.enableMaterialByUser == false) goto L20;
        int r0 = getMBgColor();
        int r1 = ColorUtils.setAlphaComponent(getMBgColor(), 0);
        ValueAnimator r3 = this.fillPaintAnimator;
        if (r3 == null) goto L11;
        r3.cancel();
    L11:
        if (r0 != r1) goto L17;
        Paint r5 = this.mFillPaint;
        if (r5 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r5 = null;
    L15:
        r5.setColor(r1);
        return;
    L17:
        ValueAnimator r2 = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(r0), Integer.valueOf(r1)});
        r2.setDuration(400);
        r2.addUpdateListener(new OPopoverLayout$$ExternalSyntheticLambda0(this));
        r2.start();
        this.fillPaintAnimator = r2;
        return;
    }

    /* JADX INFO: renamed from: startFillPaintFadeIfNeeded$lambda-2$lambda-1, reason: not valid java name */
    private static final void m449startFillPaintFadeIfNeeded$lambda2$lambda1(OPopoverLayout r1, ValueAnimator r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "animator");
        Paint r0 = r1.mFillPaint;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r0 = null;
    L5:
        Object r3 = r2.getAnimatedValue();
        if (r3 == null) goto L10;
        r0.setColor(((Integer) r3).intValue());
        r1.invalidate();
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    public final void setCornerRadiusDp(float r2) {
        this.mCornerRadius = OUnitExtensionKt.vdpFloat(this, r2);
    }

    public final void setCornerRadius(float r1) {
        this.mCornerRadius = r1;
    }

    public final float getCornerRadius() {
        return this.mCornerRadius;
    }

    public final boolean isEnableMaterial() {
        if (this.enableMaterial == true) goto L5;
    L7:
        return false;
    L5:
        if (this.enableMaterialByUser == false) goto L7;
        return true;
    }

    public final void setBorderColor(int r2) {
        this.borderColor = r2;
        if (this.strokePaint != null) goto L5;
        this.strokePaint = new Paint(1);
    L5:
        Paint r3 = this.strokePaint;
        if (r3 == null) goto L10;
        r3.setColor(this.borderColor);
        return;
    }

    public final void setBorderWidth(int r3) {
        if (r3 > 0) goto L4;
        return;
    L4:
        this.borderWidth = r3;
        if (this.strokePaint != null) goto L7;
        this.strokePaint = new Paint(1);
    L7:
        Paint r4 = this.strokePaint;
        if (r4 == null) goto L12;
        r4.setStyle(Paint.Style.STROKE);
        r4.setStrokeWidth(this.borderWidth);
        r4.setStrokeCap(Paint.Cap.BUTT);
        r4.setStrokeJoin(Paint.Join.MITER);
        r4.setAntiAlias(true);
        r4.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
        r4.setColor(this.borderColor);
        return;
    }

    public final void setTransparentBg(boolean r2) {
        setClipToOutline(!r2);
        if (r2 == false) goto L5;
        this.mBgColor = 0;
    L5:
        invalidateOutline();
        invalidate();
    }

    public static /* synthetic */ void setCovered$default(OPopoverLayout r0, boolean r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = Color.parseColor("#20000000");
    L5:
        r0.setCovered(r1, r2);
    }

    public final void setCovered(boolean r1, int r2) {
        this.coverEnabled = r1;
        this.coverColor = r2;
        this.coverColorOnAnimStart = this.currentCoverColor;
        invalidate();
    }

    public final void updateCoverAnimFraction(float r4) {
        Object r5 = this.colorEvaluator.evaluate(r4, Integer.valueOf(this.coverColorOnAnimStart), Integer.valueOf(this.coverColor));
        if (r5 == null) goto L7;
        this.currentCoverColor = ((Integer) r5).intValue();
        invalidate();
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r2) {
        if (this.coverEnabled == false) goto L5;
    L8:
        return true;
    L5:
        if (super.onInterceptTouchEvent(r2) == true) goto L8;
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r2) {
        if (this.coverEnabled == false) goto L6;
        return true;
    L6:
        return super.onTouchEvent(r2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas r4) {
        Intrinsics.checkNotNullParameter(r4, "canvas");
        super.dispatchDraw(r4);
        if (this.coverEnabled == true) goto L5;
        return;
    L5:
        RectF r0 = this.mRoundRectF;
        Paint r1 = new Paint(1);
        r1.setColor(this.currentCoverColor);
        float r3 = this.mCornerRadius;
        r4.drawRoundRect(r0, r3, r3, r1);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        OMaterialHelper.setEffectSrc(this, this.appliedMaterialSrcType);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        OMaterialHelper.setEffectSrc(this, 0);
    }

    public final float getBubbleOffset(int r6) {
        OPopoverLayout r0 = this;
        float r1 = OUnitExtensionKt.vdpFloat(r0, MIN_ARROW_DISTANCE_DP);
        float r3 = Math.max(0.0f, r1);
        if (r6 == 0) goto L15;
        if (r6 == 1) goto L18;
        if (r6 == 2) goto L17;
        if (r6 == 3) goto L16;
        return 0.0f;
    L16:
        return Math.min(r3, (this.mWidth - OUnitExtensionKt.vdp(r0, ARROW_PADDING)) - r1);
    L17:
        return Math.min(r3, (this.mHeight - OUnitExtensionKt.vdp(r0, ARROW_PADDING)) - r1);
    L18:
        return Math.min(r3, (this.mHeight - OUnitExtensionKt.vdp(r0, ARROW_PADDING)) - r1);
    L15:
        return Math.min(r3, (this.mWidth - OUnitExtensionKt.vdp(r0, ARROW_PADDING)) - r1);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        this.mWidth = getMeasuredWidth();
        this.mHeight = getMeasuredHeight();
    }

    @Override // android.view.View
    protected void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas r6) {
        Intrinsics.checkNotNullParameter(r6, "canvas");
        Paint r1 = null;
        if (this.enableMaterial == true) goto L12;
        Paint r0 = this.mFillPaint;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r0 = null;
    L7:
        r0.setColor(getMBgColor());
        RectF r2 = this.mRoundRectF;
        float r3 = this.mCornerRadius;
        Paint r4 = this.mFillPaint;
        if (r4 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L11:
        r6.drawRoundRect(r2, r3, r3, r1);
    L17:
        Paint r5 = this.strokePaint;
        if (r5 != null) goto L21;
        return;
    L21:
        if (this.borderWidth <= 0) goto L24;
        RectF r7 = this.mRoundRectF;
        float r8 = this.mCornerRadius;
        r6.drawRoundRect(r7, r8, r8, r5);
        return;
    L24:
        return;
    L10:
        r1 = r4;
        goto L11
    L12:
        Paint r9 = this.mFillPaint;
        if (r9 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L16:
        r1.getAlpha();
        goto L17
    L15:
        r1 = r9;
        goto L16
    }

    public final int getPadding() {
        return ARROW_PADDING / 2;
    }

    public final int getArrowHeight() {
        return ARROW_PADDING;
    }
}
