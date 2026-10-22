package com.obric.oui.blur;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import com.obric.common.oui.R;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.material.MaskMaterialOwner;
import com.obric.oui.material.MaterialConfig;
import com.obric.oui.material.MaterialOwner;
import com.obric.oui.material.MaterialOwnerKt;
import com.obric.oui.material.OMaterialExtBaseKt;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.utils.log.L;
import com.obric.oui.view.Insets;
import com.obric.oui.window.OWindowConfigController;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: compiled from: OBlurMaskView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0012\u0018\u0000 82\u00020\u00012\u00020\u00022\u00020\u0003:\u00018B%\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000eH\u0016J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000eH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\b\u0010\u001e\u001a\u00020\u0018H\u0014J\u0012\u0010\u001f\u001a\u00020\u00182\b\u0010 \u001a\u0004\u0018\u00010\u001cH\u0016J\u0006\u0010!\u001a\u00020\u0018J\u000e\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020$J\u000e\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020'J\u0010\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\tH\u0007J\u0010\u0010*\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u000eH\u0007J\b\u0010,\u001a\u00020\u0018H\u0002J\u0010\u0010-\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000eH\u0002J\u0010\u0010.\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\tH\u0016J\u0010\u00100\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u000e\u00101\u001a\u00020\u00182\u0006\u00102\u001a\u00020\tJ\u000e\u00103\u001a\u00020\u00182\u0006\u00104\u001a\u00020\tJ\u0010\u00105\u001a\u00020\u00182\u0006\u00106\u001a\u00020\u0003H\u0002J\u0010\u00107\u001a\u00020\u00182\u0006\u00106\u001a\u00020\u0003H\u0002R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/obric/oui/blur/OBlurMaskView;", "Landroid/widget/FrameLayout;", "Lcom/obric/oui/material/MaskMaterialOwner;", "Lcom/obric/oui/material/MaterialOwner;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defaultPaddingBottom", "defaultPaddingTop", "fitInsetBottom", "", "fitInsetTop", "isBackdropView", "isInflated", "maskMaterialConfig", "Lcom/obric/oui/material/MaterialConfig;", "materialMask", "Landroid/view/ViewGroup;", "materialSrcType", "applyContentMaterial", "", "apply", "applyMaskMaterial", "getDefaultTargetView", "Landroid/view/View;", "initAttrs", "onFinishInflate", "setBackdropTarget", "view", "setDefaultMaskBackground", "setMaskBackground", "drawable", "Landroid/graphics/drawable/Drawable;", "setMaskBlurRadius", "radius", "", "setMaskHeight", MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "showMask", "show", "updateBackdropConfigOfChildren", "updateBackdropEnableOfChildren", "updateBackdropSrcType", "srcType", "updateBackdropTargetType", "updateLayoutForInsetBottom", "insetBottom", "updateLayoutForInsetTop", "insetTop", "updateMaterialOwnerChildBackdropSrcType", "child", "updateMaterialOwnerChildBackdropTarget", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OBlurMaskView extends FrameLayout implements MaskMaterialOwner, MaterialOwner {
    public static final Companion Companion = null;
    private static final String TAG = "OBlurMaskView";
    private int defaultPaddingBottom;
    private int defaultPaddingTop;
    private boolean fitInsetBottom;
    private boolean fitInsetTop;
    private boolean isBackdropView;
    private boolean isInflated;
    private final MaterialConfig maskMaterialConfig;
    private final ViewGroup materialMask;
    private int materialSrcType;

    /* JADX INFO: compiled from: OBlurMaskView.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/blur/OBlurMaskView$Companion;", "", "()V", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$6OEdmTm0C9N_W-BV0WdW23Sx5ok, reason: not valid java name */
    public static /* synthetic */ WindowInsets m1063$r8$lambda$6OEdmTm0C9N_WBV0WdW23Sx5ok(OBlurMaskView r0, View r1, WindowInsets r2) {
        return m1064initAttrs$lambda3$lambda2(r0, r1, r2);
    }

    static {
        Companion = new Companion(null);
    }

    public OBlurMaskView(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public OBlurMaskView(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    @Deprecated(message = "")
    public final void setMaskHeight(int r1) {
    }

    public /* synthetic */ OBlurMaskView(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public OBlurMaskView(Context r22, AttributeSet r23, int r24) {
        Intrinsics.checkNotNullParameter(r22, "context");
        super(r22, r23, r24);
        OBlurMaskView r2 = this;
        this.defaultPaddingTop = OUnitExtensionKt.vdp(r2, 24);
        this.defaultPaddingBottom = OUnitExtensionKt.vdp(r2, 24);
        this.isBackdropView = true;
        this.materialSrcType = 2;
        this.maskMaterialConfig = new MaterialConfig(null, null, OMaterialHelper.getBlendConfigArray(getResources(), R.array.oui_titlebar_blur_colors, R.array.oui_titlebar_blur_blend_modes), null, null, null, new BlurConfig(BlurToken.Blur_Progress_Thin, 1, 0.0f, 6, 0.0f, 20, null), null, null, null, 955, null);
        LayoutInflater.from(r22).inflate(R.layout.o_blur_mask_view, this, true);
        View r3 = findViewById(R.id.material_mask);
        Intrinsics.checkNotNullExpressionValue(r3, "findViewById(R.id.material_mask)");
        this.materialMask = (ViewGroup) r3;
        setClipChildren(false);
        setClipToPadding(false);
        this.isInflated = true;
        if (r23 == null) goto L6;
        initAttrs(r23);
        return;
    }

    private final void initAttrs(AttributeSet r7) {
        Context r0 = getContext();
        Intrinsics.checkNotNullExpressionValue(r0, "context");
        int[] r1 = R.styleable.OBlurMaskView;
        Intrinsics.checkNotNullExpressionValue(r1, TAG);
        TypedArray r8 = r0.obtainStyledAttributes(r7, r1, 0, 0);
        Intrinsics.checkNotNullExpressionValue(r8, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        if (r8.hasValue(R.styleable.OBlurMaskView_oui_widgetMaterialSrcType) == false) goto L6;
        this.materialSrcType = r8.getInt(R.styleable.OBlurMaskView_oui_widgetMaterialSrcType, 2);
    L6:
        if (r8.hasValue(R.styleable.OBlurMaskView_oui_widgetBlurType) == false) goto L12;
        int r2 = r8.getInt(R.styleable.OBlurMaskView_oui_widgetBlurType, 0);
        BlurConfig r3 = this.maskMaterialConfig.getBlurConfig();
        if (r3 == null) goto L12;
        r3.setDirection(r2);
    L12:
        if (r8.hasValue(R.styleable.OBlurMaskView_oui_widgetBlurColors) == false) goto L19;
        if (r8.hasValue(R.styleable.OBlurMaskView_oui_widgetBlurBlendModes) == false) goto L19;
        int r4 = r8.getResourceId(R.styleable.OBlurMaskView_oui_widgetBlurColors, R.array.oui_titlebar_blur_colors);
        int r5 = r8.getResourceId(R.styleable.OBlurMaskView_oui_widgetBlurBlendModes, R.array.oui_titlebar_blur_blend_modes);
        this.maskMaterialConfig.setBlendConfig(OMaterialHelper.getBlendConfigArray(r8.getResources(), r4, r5));
        if (this.maskMaterialConfig.getBlendConfig() != null) goto L19;
        L.e(TAG, "init get widget blur colors or modes error");
    L19:
        if (r8.hasValue(R.styleable.OBlurMaskView_oBlurMask_blurRadius) == false) goto L26;
        float r6 = r8.getFloat(R.styleable.OBlurMaskView_oBlurMask_blurRadius, BlurToken.Blur_Progress_Thin);
        BlurConfig r9 = this.maskMaterialConfig.getBlurConfig();
        if (r9 == null) goto L24;
        r9.setBlurRadius(r6);
    L24:
        setMaskBlurRadius(r6);
    L26:
        if (r8.hasValue(R.styleable.OBlurMaskView_oBlurMask_maskHeight) == false) goto L30;
        int r10 = r8.getDimensionPixelSize(R.styleable.OBlurMaskView_oBlurMask_maskHeight, 0);
        if (r10 <= 0) goto L30;
        setMaskHeight(r10);
    L30:
        boolean r11 = r8.getBoolean(R.styleable.OBlurMaskView_oBlurMask_statusBarImmersion, false);
        this.fitInsetTop = r8.getBoolean(R.styleable.OBlurMaskView_oui_widgetFitInsetTop, r11);
        boolean r12 = r8.getBoolean(R.styleable.OBlurMaskView_oui_widgetFitInsetBottom, false);
        this.fitInsetBottom = r12;
        if (this.fitInsetTop == true) goto L33;
        if (r12 == true) goto L33;
    L42:
        r8.recycle();
        return;
    L33:
        OWindowConfigController r13 = OWindowConfigController.INSTANCE;
        Insets r14 = OWindowConfigController.getSystemBarInsetsInfo(this, null, true);
        if (this.fitInsetTop == false) goto L36;
        int r15 = r14.top;
    L37:
        updateLayoutForInsetTop(r15);
        if (this.fitInsetBottom == false) goto L40;
        int r16 = r14.bottom;
    L41:
        updateLayoutForInsetBottom(r16);
        setOnApplyWindowInsetsListener(new OBlurMaskView$$ExternalSyntheticLambda0(this));
        goto L42
    L40:
        r16 = this.defaultPaddingBottom;
        goto L41
    L36:
        r15 = this.defaultPaddingTop;
        goto L37
    }

    /* JADX INFO: renamed from: initAttrs$lambda-3$lambda-2, reason: not valid java name */
    private static final WindowInsets m1064initAttrs$lambda3$lambda2(OBlurMaskView r1, View r2, WindowInsets r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "$noName_0");
        Intrinsics.checkNotNullParameter(r3, "insets");
        OWindowConfigController r4 = OWindowConfigController.INSTANCE;
        Insets r5 = OWindowConfigController.getSystemBarInsetsInfo(r1, r3, true);
        if (r1.fitInsetTop == false) goto L5;
        int r0 = r5.top;
    L6:
        r1.updateLayoutForInsetTop(r0);
        if (r1.fitInsetBottom == false) goto L9;
        int r6 = r5.bottom;
    L10:
        r1.updateLayoutForInsetBottom(r6);
        return r3;
    L9:
        r6 = r1.defaultPaddingBottom;
        goto L10
    L5:
        r0 = r1.defaultPaddingTop;
        goto L6
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        updateBackdropConfigOfChildren();
    }

    private final void updateBackdropConfigOfChildren() {
        int r0 = getChildCount();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L16;
        int r3 = r2 + 1;
        KeyEvent.Callback r4 = getChildAt(r2);
        if ((r4 instanceof MaterialOwner) == false) goto L8;
        MaterialOwner r5 = (MaterialOwner) r4;
        updateMaterialOwnerChildBackdropSrcType(r5);
        updateMaterialOwnerChildBackdropTarget(r5);
    L15:
        r2 = r3;
        goto L3
    L8:
        if ((r4 instanceof ViewGroup) == false) goto L15;
        ViewGroup r6 = (ViewGroup) r4;
        int r7 = r6.getChildCount();
        int r8 = 0;
    L10:
        if (r8 >= r7) goto L15;
        int r9 = r8 + 1;
        KeyEvent.Callback r10 = r6.getChildAt(r8);
        if ((r10 instanceof MaterialOwner) == false) goto L14;
        MaterialOwner r11 = (MaterialOwner) r10;
        updateMaterialOwnerChildBackdropSrcType(r11);
        updateMaterialOwnerChildBackdropTarget(r11);
    L14:
        r8 = r9;
        goto L10
    }

    private final void updateBackdropEnableOfChildren(boolean r9) {
        int r0 = getChildCount();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L16;
        int r3 = r2 + 1;
        KeyEvent.Callback r4 = getChildAt(r2);
        if ((r4 instanceof MaterialOwner) == false) goto L8;
        ((MaterialOwner) r4).applyContentMaterial(r9);
    L15:
        r2 = r3;
        goto L3
    L8:
        if ((r4 instanceof ViewGroup) == false) goto L15;
        ViewGroup r5 = (ViewGroup) r4;
        int r6 = r5.getChildCount();
        int r7 = 0;
    L10:
        if (r7 >= r6) goto L15;
        int r8 = r7 + 1;
        KeyEvent.Callback r10 = r5.getChildAt(r7);
        if ((r10 instanceof MaterialOwner) == false) goto L14;
        ((MaterialOwner) r10).applyContentMaterial(r9);
    L14:
        r7 = r8;
        goto L10
    }

    private final View getDefaultTargetView() {
        if (OMaterialHelper.getEffectOverlayLevel() <= 1) goto L7;
        return this.materialMask;
    L7:
        return this;
    }

    private final void updateMaterialOwnerChildBackdropTarget(MaterialOwner r3) {
        if ((r3 instanceof MaskMaterialOwner) == false) goto L5;
        ((MaskMaterialOwner) r3).applyMaskMaterial(false);
    L5:
        r3.setBackdropTarget(getDefaultTargetView());
    }

    private final void updateMaterialOwnerChildBackdropSrcType(MaterialOwner r1) {
        r1.updateBackdropSrcType(this.materialSrcType);
    }

    public final void setMaskBlurRadius(float r2) {
        BlurConfig r0 = this.maskMaterialConfig.getBlurConfig();
        if (r0 == null) goto L6;
        r0.setBlurRadius(r2);
    L6:
        OBlurMaskView r3 = this;
        OMaterialHelper.setCommonGradientBlur(r3, this.maskMaterialConfig);
        OMaterialExtBaseKt.setMaterialBackdropTarget(r3, r3);
    }

    public final void setMaskBackground(Drawable r2) {
        Intrinsics.checkNotNullParameter(r2, "drawable");
        setBackground(r2);
    }

    public final void setDefaultMaskBackground() {
        Drawable r0 = getResources().getDrawable(R.drawable.o_floating_title_bar_default_mask_bg);
        Intrinsics.checkNotNullExpressionValue(r0, "resources.getDrawable(R.…itle_bar_default_mask_bg)");
        setMaskBackground(r0);
    }

    @Deprecated(message = "Use android:visibility instead")
    public final void showMask(boolean r1) {
        if (r1 == false) goto L4;
        int r2 = 0;
    L5:
        setVisibility(r2);
        return;
    L4:
        r2 = 8;
        goto L5
    }

    @Override // com.obric.oui.material.MaterialOwner
    public void applyContentMaterial(boolean r1) {
        updateBackdropEnableOfChildren(r1);
    }

    @Override // com.obric.oui.material.MaskMaterialOwner
    public void applyMaskMaterial(boolean r3) {
        int r0 = this.materialSrcType;
        if (r0 == (-1)) goto L6;
        MaterialOwnerKt.applyBackdropMaterial(this, r3, r0);
        return;
    L6:
        MaterialOwnerKt.applyBackdropMaterial(this, r3, this.isBackdropView);
    }

    @Override // com.obric.oui.material.MaskMaterialOwner
    public void setBackdropTarget(View r1) {
        if (r1 != null) goto L5;
        OBlurMaskView r0 = this;
        OMaterialExtBaseKt.setMaterialBackdropTarget(r0, r0);
        return;
    L5:
        OMaterialExtBaseKt.setMaterialBackdropTarget(this, r1);
    }

    @Override // com.obric.oui.material.MaskMaterialOwner
    public void updateBackdropTargetType(boolean r1) {
        this.isBackdropView = r1;
        OMaterialExtBaseKt.updateMaterialBackdropTargetType(this, r1);
    }

    @Override // com.obric.oui.material.MaskMaterialOwner
    public void updateBackdropSrcType(int r2) {
        this.materialSrcType = r2;
        OMaterialExtBaseKt.updateMaterialBackdropSrcType(this, r2);
        updateBackdropConfigOfChildren();
    }

    public final void updateLayoutForInsetTop(int r4) {
        OBlurMaskView r3 = this;
        r3.setPadding(r3.getPaddingLeft(), r4, r3.getPaddingRight(), r3.getPaddingBottom());
    }

    public final void updateLayoutForInsetBottom(int r4) {
        OBlurMaskView r3 = this;
        r3.setPadding(r3.getPaddingLeft(), r3.getPaddingTop(), r3.getPaddingRight(), r4);
    }
}
