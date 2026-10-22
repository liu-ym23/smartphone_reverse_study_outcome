package com.obric.oui.actionbar.v2;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.obric.common.oui.R;
import com.obric.oui.blur.BlurConfig;
import com.obric.oui.blur.BlurToken;
import com.obric.oui.material.MaskMaterialOwner;
import com.obric.oui.material.MaterialConfig;
import com.obric.oui.material.MaterialOwner;
import com.obric.oui.material.MaterialOwnerKt;
import com.obric.oui.material.OMaterialExtBaseKt;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.utils.log.L;
import com.obric.oui.window.floating.OFloatingWindowHelper;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OBottomActionBarFloating.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\b\u000e\u0018\u0000 ?2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001?B9\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\fH\u0016J\u0010\u0010%\u001a\u00020#2\u0006\u0010$\u001a\u00020\fH\u0016J\b\u0010&\u001a\u0004\u0018\u00010\u000fJ\n\u0010'\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010(\u001a\u00020\fH\u0002J\b\u0010)\u001a\u00020#H\u0014J\b\u0010*\u001a\u00020#H\u0014J\b\u0010+\u001a\u00020#H\u0002J\u0012\u0010,\u001a\u00020#2\b\u0010-\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010.\u001a\u00020#2\u0006\u0010/\u001a\u00020\u0014H\u0002J\u0014\u00100\u001a\u00020#2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u001202J\b\u00103\u001a\u00020#H\u0002J\u001e\u00104\u001a\u00020#2\u0006\u00105\u001a\u00020\u00122\u0006\u00106\u001a\u00020\u000f2\u0006\u00107\u001a\u00020\fJ\u0016\u00108\u001a\u00020#2\u0006\u00106\u001a\u00020\u000f2\u0006\u00109\u001a\u00020\tJ\u0010\u0010:\u001a\u00020#2\u0006\u0010;\u001a\u00020\tH\u0016J\u0010\u0010<\u001a\u00020#2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u000e\u0010=\u001a\u00020#2\u0006\u0010>\u001a\u00020\tR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/obric/oui/actionbar/v2/OBottomActionBarFloating;", "Landroid/widget/FrameLayout;", "Lcom/obric/oui/material/MaterialOwner;", "Lcom/obric/oui/material/MaskMaterialOwner;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "enableSetBackDropTarget", "", "(Landroid/content/Context;Landroid/util/AttributeSet;IIZ)V", "actionGroup", "Landroid/view/ViewGroup;", "backdropTarget", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "backgroundBlurRadius", "", "centerContainer", "Landroid/widget/LinearLayout;", "defaultPaddingBottom", "enableBackDropTarget", "floatingWindowHelper", "Lcom/obric/oui/window/floating/OFloatingWindowHelper;", "isBackdropView", "leftContainer", "maskMaterialConfig", "Lcom/obric/oui/material/MaterialConfig;", "materialSrcType", "rightContainer", "rootView", "applyContentMaterial", "", "apply", "applyMaskMaterial", "getActionGroup", "getDefaultTargetView", "isDarkTheme", "onAttachedToWindow", "onFinishInflate", "resetContainers", "setBackdropTarget", "view", "setBackgroundBlurRadius", "radius", "setButtons", "buttons", "", "setDefaultBackdropTargetForChild", "setMixed", "button", "group", "isButtonLeft", "setSingleGroup", "gravity", "updateBackdropSrcType", "srcType", "updateBackdropTargetType", "updateLayoutForInsetBottom", "insetBottom", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OBottomActionBarFloating extends FrameLayout implements MaterialOwner, MaskMaterialOwner {
    public static final Companion Companion = null;
    public static final String TAG = "OBottomActionBarFloating";
    private ViewGroup actionGroup;
    private WeakReference<View> backdropTarget;
    private float backgroundBlurRadius;
    private LinearLayout centerContainer;
    private int defaultPaddingBottom;
    private final boolean enableBackDropTarget;
    private final OFloatingWindowHelper floatingWindowHelper;
    private boolean isBackdropView;
    private LinearLayout leftContainer;
    private final MaterialConfig maskMaterialConfig;
    private int materialSrcType;
    private LinearLayout rightContainer;
    private ViewGroup rootView;

    /* JADX INFO: compiled from: OBottomActionBarFloating.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/actionbar/v2/OBottomActionBarFloating$Companion;", "", "()V", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

    public OBottomActionBarFloating(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this(r10, null, 0, 0, false, 30, null);
    }

    public OBottomActionBarFloating(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this(r10, r11, 0, 0, false, 28, null);
    }

    public OBottomActionBarFloating(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this(r10, r11, r12, 0, false, 24, null);
    }

    public OBottomActionBarFloating(Context r10, AttributeSet r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this(r10, r11, r12, r13, false, 16, null);
    }

    public /* synthetic */ OBottomActionBarFloating(Context r7, AttributeSet r8, int r9, int r10, boolean r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r8 = null;
    L5:
        AttributeSet r2 = r8;
        if ((r12 & 4) == 0) goto L8;
        int r3 = 0;
    L10:
        if ((r12 & 8) == 0) goto L12;
        int r4 = 0;
    L14:
        if ((r12 & 16) == 0) goto L16;
        r11 = true;
    L16:
        this(r7, r2, r3, r4, r11);
        return;
    L12:
        r4 = r10;
        goto L14
    L8:
        r3 = r9;
        goto L10
    }

    public OBottomActionBarFloating(Context r23, AttributeSet r24, int r25, int r26, boolean r27) {
        Intrinsics.checkNotNullParameter(r23, "context");
        super(r23, r24, r25, r26);
        this.isBackdropView = true;
        this.materialSrcType = 2;
        this.enableBackDropTarget = r27;
        OFloatingWindowHelper r4 = new OFloatingWindowHelper(this);
        this.floatingWindowHelper = r4;
        MaterialConfig r5 = new MaterialConfig(null, null, OMaterialHelper.getBlendConfigArray(getResources(), R.array.oui_bottom_actionbar_blur_colors, R.array.oui_bottom_actionbar_blur_blend_modes), null, null, null, new BlurConfig(BlurToken.Blur_Progress_Thin, 2, 0.0f, 6, 0.0f, 20, null), null, null, null, 955, null);
        this.maskMaterialConfig = r5;
        this.backgroundBlurRadius = BlurToken.Blur_Progress_Thin;
        boolean r6 = false;
        setClipChildren(false);
        setClipToPadding(false);
        this.defaultPaddingBottom = getPaddingBottom();
        FrameLayout.inflate(r23, R.layout.o_widget_bottom_action_bar_v2_floating, this);
        View r7 = findViewById(R.id.bottom_action_bar_root);
        Intrinsics.checkNotNullExpressionValue(r7, "findViewById(R.id.bottom_action_bar_root)");
        this.rootView = (ViewGroup) r7;
        View r8 = findViewById(R.id.action_bar_left_container);
        Intrinsics.checkNotNullExpressionValue(r8, "findViewById(R.id.action_bar_left_container)");
        this.leftContainer = (LinearLayout) r8;
        View r9 = findViewById(R.id.action_bar_center_container);
        Intrinsics.checkNotNullExpressionValue(r9, "findViewById(R.id.action_bar_center_container)");
        this.centerContainer = (LinearLayout) r9;
        View r10 = findViewById(R.id.action_bar_right_container);
        Intrinsics.checkNotNullExpressionValue(r10, "findViewById(R.id.action_bar_right_container)");
        this.rightContainer = (LinearLayout) r10;
        int[] r11 = R.styleable.OBottomActionBar;
        Intrinsics.checkNotNullExpressionValue(r11, "OBottomActionBar");
        TypedArray r1 = r23.obtainStyledAttributes(r24, r11, 0, 0);
        Intrinsics.checkNotNullExpressionValue(r1, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        this.materialSrcType = r1.getInt(R.styleable.OBottomActionBar_oui_widgetMaterialSrcType, 2);
        if (r1.hasValue(R.styleable.OBottomActionBar_oui_widgetBlurColors) == false) goto L10;
        if (r1.hasValue(R.styleable.OBottomActionBar_oui_widgetBlurBlendModes) == false) goto L10;
        r5.setBlendConfig(OMaterialHelper.getBlendConfigArray(r1.getResources(), r1.getResourceId(R.styleable.OBottomActionBar_oui_widgetBlurColors, R.array.oui_bottom_actionbar_blur_colors), r1.getResourceId(R.styleable.OBottomActionBar_oui_widgetBlurBlendModes, R.array.oui_bottom_actionbar_blur_blend_modes)));
        if (r5.getBlendConfig() != null) goto L10;
        L.e(TAG, "init get widget blur colors or modes error");
    L10:
        if (r1.hasValue(R.styleable.OBottomActionBar_oui_widgetBlurRadius) == false) goto L13;
        this.backgroundBlurRadius = r1.getFloat(R.styleable.OBottomActionBar_oui_widgetBlurRadius, BlurToken.Blur_Progress_Thin);
    L13:
        if (r1.hasValue(R.styleable.OBottomActionBar_oui_bottomActionBarType) == true) goto L15;
    L18:
        r4.setupInsets(r1.getBoolean(R.styleable.OBottomActionBar_oui_widgetFitInsetBottom, true), new OBottomActionBarFloating$1$1(this));
        r1.recycle();
        setBackgroundBlurRadius(this.backgroundBlurRadius);
        setDefaultBackdropTargetForChild();
        r4.setGravity(81);
        return;
    L15:
        if (r1.getInt(R.styleable.OBottomActionBar_oui_bottomActionBarType, 0) != 1) goto L17;
        r6 = true;
    L17:
        r4.setFloatingType(r6);
        goto L18
    }

    public final void updateLayoutForInsetBottom(int r5) {
        setPaddingRelative(getPaddingLeft(), getPaddingTop(), getPaddingRight(), Math.max(r5, this.defaultPaddingBottom));
    }

    public final ViewGroup getActionGroup() {
        return this.actionGroup;
    }

    public final void setSingleGroup(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "group");
        resetContainers();
        if (r4 != 1) goto L5;
    L17:
        this.centerContainer.addView(r3);
        this.centerContainer.setVisibility(0);
    L18:
        this.actionGroup = r3;
        setDefaultBackdropTargetForChild();
        int r5 = this.materialSrcType;
        if (r5 == (-1)) goto L26;
        ViewParent r2 = this.actionGroup;
        if ((r2 instanceof MaterialOwner) == false) goto L27;
        if (r2 == null) goto L25;
        ((MaterialOwner) r2).updateBackdropSrcType(r5);
        return;
    L25:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.material.MaterialOwner");
    L27:
        return;
    L26:
        return;
    L5:
        if (r4 != 3) goto L7;
    L16:
        this.leftContainer.addView(r3);
        this.leftContainer.setVisibility(0);
        goto L18
    L7:
        if (r4 != 5) goto L9;
    L15:
        this.rightContainer.addView(r3);
        this.rightContainer.setVisibility(0);
        goto L18
    L9:
        if (r4 == 17) goto L17;
        if (r4 == 8388611) goto L16;
        if (r4 == 8388613) goto L15;
        goto L15
    }

    public final void setButtons(List<? extends View> r5) {
        Intrinsics.checkNotNullParameter(r5, "buttons");
        resetContainers();
        if (r5.isEmpty() == false) goto L6;
        return;
    L6:
        if (r5.size() != 1) goto L9;
        this.centerContainer.addView(r5.get(0));
        this.centerContainer.setVisibility(0);
    L11:
        Iterator<T> r6 = r5.iterator();
    L13:
        if (r6.hasNext() == false) goto L22;
        KeyEvent.Callback r0 = (View) r6.next();
        if ((r0 instanceof MaterialOwner) == false) goto L13;
        if (this.enableBackDropTarget == false) goto L19;
        ((MaterialOwner) r0).setBackdropTarget(getDefaultTargetView());
    L19:
        int r1 = this.materialSrcType;
        if (r1 == (-1)) goto L13;
        ((MaterialOwner) r0).updateBackdropSrcType(r1);
        goto L13
    L22:
        return;
    L9:
        if (r5.size() < 2) goto L11;
        this.leftContainer.addView(r5.get(0));
        this.leftContainer.setVisibility(0);
        this.rightContainer.addView(r5.get(1));
        this.rightContainer.setVisibility(0);
        goto L11
    }

    public final void setMixed(View r3, ViewGroup r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "button");
        Intrinsics.checkNotNullParameter(r4, "group");
        resetContainers();
        if (r5 == false) goto L5;
        this.leftContainer.addView(r3);
        this.leftContainer.setVisibility(0);
        this.rightContainer.addView(r4);
        this.rightContainer.setVisibility(0);
    L6:
        this.actionGroup = r4;
        return;
    L5:
        this.leftContainer.addView(r4);
        this.leftContainer.setVisibility(0);
        this.rightContainer.addView(r3);
        this.rightContainer.setVisibility(0);
        goto L6
    }

    private final void resetContainers() {
        this.leftContainer.removeAllViews();
        this.centerContainer.removeAllViews();
        this.rightContainer.removeAllViews();
        this.leftContainer.setVisibility(8);
        this.centerContainer.setVisibility(8);
        this.rightContainer.setVisibility(8);
        this.actionGroup = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.floatingWindowHelper.onAttachedToWindow();
    }

    private final void setBackgroundBlurRadius(float r3) {
        setOutlineProvider(new AnonymousClass1());
        int r0 = this.materialSrcType;
        if (r0 != (-1)) goto L6;
        r0 = 2;
    L6:
        BlurConfig r1 = this.maskMaterialConfig.getBlurConfig();
        if (r1 == null) goto L11;
        r1.setBlurRadius(r3);
        this.floatingWindowHelper.applyBlur(this, this.maskMaterialConfig, r0);
        return;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int r0 = this.materialSrcType;
        if (r0 == (-1)) goto L6;
        OMaterialExtBaseKt.updateMaterialBackdropSrcType(this, r0);
        MaterialOwnerKt.dispatchBackdropSrcType(new LinearLayout[]{this.leftContainer, this.centerContainer, this.rightContainer}, this.materialSrcType);
        return;
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

    @Override // com.obric.oui.material.MaterialOwner
    public void applyContentMaterial(boolean r4) {
        MaterialOwnerKt.dispatchApplyContentMaterial(new LinearLayout[]{this.leftContainer, this.centerContainer, this.rightContainer}, r4);
    }

    private final View getDefaultTargetView() {
        WeakReference<View> r0 = this.backdropTarget;
        if (r0 == null) goto L7;
        Intrinsics.checkNotNull(r0);
        return r0.get();
    L7:
        if (OMaterialHelper.getEffectOverlayLevel() <= 1) goto L11;
        return this.rootView;
    L11:
        return this;
    }

    private final void setDefaultBackdropTargetForChild() {
        if (this.enableBackDropTarget == true) goto L5;
        return;
    L5:
        View r0 = getDefaultTargetView();
        MaterialOwnerKt.dispatchBackdropTarget(new LinearLayout[]{this.leftContainer, this.centerContainer, this.rightContainer}, r0);
        ViewParent r4 = this.actionGroup;
        if ((r4 instanceof MaterialOwner) == false) goto L11;
        if (r4 == null) goto L10;
        ((MaterialOwner) r4).setBackdropTarget(r0);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.material.MaterialOwner");
    }

    @Override // com.obric.oui.material.MaterialOwner, com.obric.oui.material.MaskMaterialOwner
    public void setBackdropTarget(View r4) {
        if (this.enableBackDropTarget == true) goto L5;
        return;
    L5:
        this.backdropTarget = new WeakReference(r4);
        MaterialOwnerKt.dispatchBackdropTarget(new LinearLayout[]{this.leftContainer, this.centerContainer, this.rightContainer}, r4);
        ViewParent r3 = this.actionGroup;
        if ((r3 instanceof MaterialOwner) == false) goto L11;
        if (r3 == null) goto L10;
        ((MaterialOwner) r3).setBackdropTarget(r4);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.material.MaterialOwner");
    }

    @Override // com.obric.oui.material.MaterialOwner, com.obric.oui.material.MaskMaterialOwner
    public void updateBackdropTargetType(boolean r4) {
        if (this.isBackdropView == r4) goto L16;
        this.isBackdropView = r4;
        if (this.materialSrcType == (-1)) goto L8;
        return;
    L8:
        if (this.floatingWindowHelper.isFloatingType() == true) goto L10;
        OMaterialExtBaseKt.updateMaterialBackdropTargetType(this, this.isBackdropView);
    L10:
        MaterialOwnerKt.dispatchBackdropTargetType(new LinearLayout[]{this.leftContainer, this.centerContainer, this.rightContainer}, r4);
        ViewParent r5 = this.actionGroup;
        if ((r5 instanceof MaterialOwner) == false) goto L17;
        if (r5 == null) goto L15;
        ((MaterialOwner) r5).updateBackdropTargetType(this.isBackdropView);
        return;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.material.MaterialOwner");
    L17:
        return;
    }

    @Override // com.obric.oui.material.MaterialOwner, com.obric.oui.material.MaskMaterialOwner
    public void updateBackdropSrcType(int r4) {
        this.materialSrcType = r4;
        OMaterialExtBaseKt.updateMaterialBackdropSrcType(this, r4);
        MaterialOwnerKt.dispatchBackdropSrcType(new LinearLayout[]{this.leftContainer, this.centerContainer, this.rightContainer}, this.materialSrcType);
        ViewParent r3 = this.actionGroup;
        if ((r3 instanceof MaterialOwner) == false) goto L8;
        if (r3 == null) goto L7;
        ((MaterialOwner) r3).updateBackdropSrcType(r4);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.material.MaterialOwner");
    }

    private final boolean isDarkTheme() {
        if ((getResources().getConfiguration().uiMode & 48) != 32) goto L5;
        return true;
    L5:
        return false;
    }
}
