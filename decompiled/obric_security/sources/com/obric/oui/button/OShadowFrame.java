package com.obric.oui.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.graphics.ColorUtils;
import com.obric.common.oea.foundation.animation.manager.AnimationManager;
import com.obric.common.oui.R;
import com.obric.oui.color.OPalette;
import com.obric.oui.common.style.IOUIAlpha;
import com.obric.oui.common.style.ODynamicThemeWidget;
import com.obric.oui.common.style.OUILayoutHelper;
import com.obric.oui.common.style.Shadow;
import com.obric.oui.common.style.ShadowAnimator;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.material.MaterialConfig;
import com.obric.oui.material.MaterialConfigBuilder;
import com.obric.oui.material.MaterialOwner;
import com.obric.oui.material.MaterialOwnerKt;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.OMaterialExtBaseKt;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.utils.KtExt;
import com.obric.oui.utils.ViewUtilKt;
import com.obric.oui.utils.log.L;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: OShadowFrame.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0019\b&\u0018\u0000 y2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001yB/\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\u0010\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020\u001fH\u0016J\u0010\u0010O\u001a\u00020M2\u0006\u0010P\u001a\u00020\tH\u0016J\u0010\u0010Q\u001a\u00020M2\u0006\u0010R\u001a\u00020\u001fH\u0002J\u0010\u0010S\u001a\u00020\u001f2\u0006\u0010T\u001a\u00020UH\u0016J\u0010\u0010V\u001a\u00020M2\u0006\u0010W\u001a\u00020\u001fH\u0002J.\u0010X\u001a\u00020M2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020Y2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010[H&J\u0018\u0010\\\u001a\u00020M2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010Z\u001a\u00020[H\u0004J\u0018\u0010]\u001a\u00020M2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010Z\u001a\u00020[H\u0002J\u001a\u0010^\u001a\u00020M2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010R\u001a\u00020\u001fH\u0016J\u0012\u0010_\u001a\u00020M2\b\u0010`\u001a\u0004\u0018\u00010aH\u0016J\u0012\u0010b\u001a\u00020M2\b\b\u0001\u0010c\u001a\u00020\tH\u0016J\u001c\u0010d\u001a\u00020M2\b\b\u0001\u0010e\u001a\u00020\t2\b\b\u0001\u0010f\u001a\u00020\tH\u0016JA\u0010d\u001a\u00020M2\b\b\u0001\u0010e\u001a\u00020\t2\b\b\u0001\u0010f\u001a\u00020\t2\u000e\u0010g\u001a\n\u0012\u0004\u0012\u00020:\u0018\u0001092\u000e\u0010h\u001a\n\u0012\u0004\u0012\u00020:\u0018\u000109H\u0016¢\u0006\u0002\u0010iJ0\u0010d\u001a\u00020M2\b\b\u0001\u0010e\u001a\u00020\t2\b\b\u0001\u0010f\u001a\u00020\t2\b\u0010j\u001a\u0004\u0018\u00010-2\b\u0010k\u001a\u0004\u0018\u00010-H\u0016J\u0010\u0010l\u001a\u00020M2\u0006\u0010m\u001a\u00020\u001fH\u0016J&\u0010n\u001a\u00020M2\b\u0010j\u001a\u0004\u0018\u00010-2\b\u0010k\u001a\u0004\u0018\u00010-2\b\b\u0002\u0010o\u001a\u00020\u001fH\u0017J&\u0010p\u001a\u00020M2\b\u0010q\u001a\u0004\u0018\u00010:2\b\u0010r\u001a\u0004\u0018\u00010:2\b\b\u0002\u0010o\u001a\u00020\u001fH\u0017J7\u0010p\u001a\u00020M2\u000e\u00108\u001a\n\u0012\u0004\u0012\u00020:\u0018\u0001092\u000e\u0010@\u001a\n\u0012\u0004\u0012\u00020:\u0018\u0001092\b\b\u0002\u0010o\u001a\u00020\u001fH\u0017¢\u0006\u0002\u0010sJ\u0012\u0010t\u001a\u00020M2\b\b\u0001\u0010c\u001a\u00020\tH\u0016J\u0010\u0010u\u001a\u00020M2\u0006\u0010v\u001a\u00020\tH\u0016J\u0010\u0010w\u001a\u00020M2\u0006\u0010%\u001a\u00020\u001fH\u0016J\u0010\u0010x\u001a\u00020M2\u0006\u0010m\u001a\u00020\u001fH\u0014R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\tX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\tX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u0001X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\tX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0010\"\u0004\b\u001d\u0010\u0012R\u001a\u0010\u001e\u001a\u00020\u001fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u00020\u001fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R\u001a\u0010'\u001a\u00020\u001fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010!\"\u0004\b(\u0010#R\u001a\u0010)\u001a\u00020\u001fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010!\"\u0004\b+\u0010#R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u00102\u001a\u00020\tX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0010\"\u0004\b4\u0010\u0012R\u001c\u00105\u001a\u0004\u0018\u00010-X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010/\"\u0004\b7\u00101R$\u00108\u001a\n\u0012\u0004\u0012\u00020:\u0018\u000109X\u0084\u000e¢\u0006\u0010\n\u0002\u0010?\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R$\u0010@\u001a\n\u0012\u0004\u0012\u00020:\u0018\u000109X\u0084\u000e¢\u0006\u0010\n\u0002\u0010?\u001a\u0004\bA\u0010<\"\u0004\bB\u0010>R\u0010\u0010C\u001a\u0004\u0018\u00010DX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010G\u001a\u0004\u0018\u00010DX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010H\u001a\n\u0012\u0004\u0012\u00020J\u0018\u00010IX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010K\u001a\n\u0012\u0004\u0012\u00020J\u0018\u00010IX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006z"}, d2 = {"Lcom/obric/oui/button/OShadowFrame;", "Lcom/obric/oui/layout/OUIFrameLayout;", "Lcom/obric/oui/material/MaterialOwner;", "Lcom/obric/oui/common/style/ODynamicThemeWidget;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "animAccuracy", "", "bgColorDisabled", "getBgColorDisabled", "()I", "setBgColorDisabled", "(I)V", "bgColorNormal", "getBgColorNormal", "setBgColorNormal", "contentView", "getContentView", "()Lcom/obric/oui/layout/OUIFrameLayout;", "setContentView", "(Lcom/obric/oui/layout/OUIFrameLayout;)V", "currentTheme", "getCurrentTheme", "setCurrentTheme", "enableMaterial", "", "getEnableMaterial", "()Z", "setEnableMaterial", "(Z)V", "initScale", "isBackdropView", "setBackdropView", "isMaterialFromDrawable", "setMaterialFromDrawable", "materialApplied", "getMaterialApplied", "setMaterialApplied", "materialDisabledTokenString", "", "getMaterialDisabledTokenString", "()Ljava/lang/String;", "setMaterialDisabledTokenString", "(Ljava/lang/String;)V", "materialSrcType", "getMaterialSrcType", "setMaterialSrcType", "materialTokenString", "getMaterialTokenString", "setMaterialTokenString", "materials", "", "Lcom/obric/oui/material/MaterialConfig;", "getMaterials", "()[Lcom/obric/oui/material/MaterialConfig;", "setMaterials", "([Lcom/obric/oui/material/MaterialConfig;)V", "[Lcom/obric/oui/material/MaterialConfig;", "materialsDisabled", "getMaterialsDisabled", "setMaterialsDisabled", "pressAnim", "Lcom/obric/common/oea/foundation/animation/manager/AnimationManager;", "pressColor", "pressScale", "releaseAnim", "shadowsNormal", "", "Lcom/obric/oui/common/style/Shadow;", "shadowsPressed", "applyContentMaterial", "", "apply", "applyDynamicTheme", "themeStyle", "checkColorfulBgMaterial", "isDarkTheme", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "doPressAnim", "pressed", "initContent", "Landroid/widget/FrameLayout;", "typedArray", "Landroid/content/res/TypedArray;", "initMaterials", "initShadows", "initView", "setBackdropTarget", "view", "Landroid/view/View;", "setBgColor", "color", "setBgColors", "normal", "disabled", "normalMaterialConfigs", "disabledMaterialConfigs", "(II[Lcom/obric/oui/material/MaterialConfig;[Lcom/obric/oui/material/MaterialConfig;)V", "tokenString", "disabledTokenString", "setEnabled", "enabled", "setMaterialByTokenString", "invalidate", "setMaterialConfigs", "material", "materialDisabled", "([Lcom/obric/oui/material/MaterialConfig;[Lcom/obric/oui/material/MaterialConfig;Z)V", "setPressColor", "updateBackdropSrcType", "srcType", "updateBackdropTargetType", "updateUIOnEnableChanged", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class OShadowFrame extends OUIFrameLayout implements MaterialOwner, ODynamicThemeWidget {
    public static final Companion Companion = null;
    private static final String TAG = "OShadowFrame";
    private float animAccuracy;
    private int bgColorDisabled;
    private int bgColorNormal;
    protected OUIFrameLayout contentView;
    private int currentTheme;
    private boolean enableMaterial;
    private final float initScale;
    private boolean isBackdropView;
    private boolean isMaterialFromDrawable;
    private boolean materialApplied;
    private String materialDisabledTokenString;
    private int materialSrcType;
    private String materialTokenString;
    private MaterialConfig[] materials;
    private MaterialConfig[] materialsDisabled;
    private AnimationManager pressAnim;
    private int pressColor;
    private float pressScale;
    private AnimationManager releaseAnim;
    private List<Shadow> shadowsNormal;
    private List<Shadow> shadowsPressed;

    /* JADX INFO: compiled from: OShadowFrame.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/button/OShadowFrame$Companion;", "", "()V", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

    public OShadowFrame(Context r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, null, 0, 0, 14, null);
    }

    public OShadowFrame(Context r9, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, r10, 0, 0, 12, null);
    }

    public OShadowFrame(Context r9, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, r10, r11, 0, 8, null);
    }

    public abstract void initContent(Context r1, FrameLayout r2, AttributeSet r3, TypedArray r4);

    public final void setMaterialByTokenString(String r7, String r8) {
        setMaterialByTokenString$default(this, r7, r8, false, 4, null);
    }

    public final void setMaterialConfigs(MaterialConfig r7, MaterialConfig r8) {
        setMaterialConfigs$default(this, r7, r8, false, 4, null);
    }

    public final void setMaterialConfigs(MaterialConfig[] r7, MaterialConfig[] r8) {
        setMaterialConfigs$default(this, r7, r8, false, 4, null);
    }

    public /* synthetic */ OShadowFrame(Context r2, AttributeSet r3, int r4, int r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = 0;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = 0;
    L11:
        this(r2, r3, r4, r5);
    }

    public OShadowFrame(Context r8, AttributeSet r9, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r9, r10, null, 8, null);
        this.initScale = 1.0f;
        this.pressScale = 1.0f;
        this.animAccuracy = 0.01f;
        boolean r12 = true;
        this.isBackdropView = true;
        this.materialSrcType = 2;
        if (OMaterialExtBaseKt.isMaterialEffectEnabled(this) == true) goto L5;
    L7:
        r12 = false;
    L8:
        this.enableMaterial = r12;
        this.materialApplied = r12;
        initView(r8, r9);
        return;
    L5:
        if (OMaterialHelper.isWidgetMaterialEffectEnabled() == false) goto L7;
        goto L7
    }

    protected final int getBgColorNormal() {
        return this.bgColorNormal;
    }

    protected final void setBgColorNormal(int r1) {
        this.bgColorNormal = r1;
    }

    protected final int getBgColorDisabled() {
        return this.bgColorDisabled;
    }

    protected final void setBgColorDisabled(int r1) {
        this.bgColorDisabled = r1;
    }

    protected final OUIFrameLayout getContentView() {
        OUIFrameLayout r0 = this.contentView;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("contentView");
        return null;
    }

    protected final void setContentView(OUIFrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.contentView = r2;
    }

    protected final int getCurrentTheme() {
        return this.currentTheme;
    }

    protected final void setCurrentTheme(int r1) {
        this.currentTheme = r1;
    }

    protected final boolean getEnableMaterial() {
        return this.enableMaterial;
    }

    protected final void setEnableMaterial(boolean r1) {
        this.enableMaterial = r1;
    }

    protected final String getMaterialTokenString() {
        return this.materialTokenString;
    }

    protected final void setMaterialTokenString(String r1) {
        this.materialTokenString = r1;
    }

    protected final String getMaterialDisabledTokenString() {
        return this.materialDisabledTokenString;
    }

    protected final void setMaterialDisabledTokenString(String r1) {
        this.materialDisabledTokenString = r1;
    }

    protected final MaterialConfig[] getMaterials() {
        return this.materials;
    }

    protected final void setMaterials(MaterialConfig[] r1) {
        this.materials = r1;
    }

    protected final boolean getMaterialApplied() {
        return this.materialApplied;
    }

    protected final void setMaterialApplied(boolean r1) {
        this.materialApplied = r1;
    }

    protected final boolean isBackdropView() {
        return this.isBackdropView;
    }

    protected final void setBackdropView(boolean r1) {
        this.isBackdropView = r1;
    }

    protected final MaterialConfig[] getMaterialsDisabled() {
        return this.materialsDisabled;
    }

    protected final void setMaterialsDisabled(MaterialConfig[] r1) {
        this.materialsDisabled = r1;
    }

    protected final int getMaterialSrcType() {
        return this.materialSrcType;
    }

    protected final void setMaterialSrcType(int r1) {
        this.materialSrcType = r1;
    }

    protected final boolean isMaterialFromDrawable() {
        return this.isMaterialFromDrawable;
    }

    protected final void setMaterialFromDrawable(boolean r1) {
        this.isMaterialFromDrawable = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.util.AttributeSet] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    private final void initView(Context r12, AttributeSet r13) {
        TypedArray r0 = r12.obtainStyledAttributes(r13, R.styleable.OShadowFrame);
        Intrinsics.checkNotNullExpressionValue(r0, "context.obtainStyledAttr…R.styleable.OShadowFrame)");
        if (this.enableMaterial == false) goto L5;
        boolean r1 = r0.getBoolean(R.styleable.OShadowFrame_oui_widgetEnableMaterial, true);
        this.enableMaterial = r1;
        this.materialApplied = r1;
    L5:
        ?? r5 = 0;
        r5 = 0;
        setContentView(new OUIFrameLayout(r12, r5, 0, null, 14, null));
        getContentView().setDuplicateParentStateEnabled(true);
        this.bgColorNormal = r0.getColor(R.styleable.OShadowFrame_oui_widgetBgColor, getResources().getColor(R.color.oui_floating_button_bg_color_1, null));
        this.bgColorDisabled = r0.getColor(R.styleable.OShadowFrame_oui_widgetBgColorDisabled, getResources().getColor(R.color.oui_floating_button_bg_color_1, null));
        if (this.bgColorNormal == 0) goto L8;
        getContentView().setBackgroundColor(this.bgColorNormal);
    L8:
        this.pressScale = r0.getFloat(R.styleable.OShadowFrame_oui_widgetPressScale, 1.0f);
        setChangeAlphaWhenPress(false);
        int r3 = r0.getDimensionPixelSize(R.styleable.OShadowFrame_oui_widgetPaddingL, 0);
        int r4 = r0.getDimensionPixelSize(R.styleable.OShadowFrame_oui_widgetPaddingR, 0);
        int r6 = r0.getDimensionPixelSize(R.styleable.OShadowFrame_oui_widgetPaddingT, 0);
        int r7 = r0.getDimensionPixelSize(R.styleable.OShadowFrame_oui_widgetPaddingB, 0);
        int r8 = r0.getDimensionPixelSize(R.styleable.OShadowFrame_oui_widgetRadius, 0);
        Drawable r9 = r0.getDrawable(R.styleable.OShadowFrame_oui_widgetMaterialBackground);
        getContentView().setPadding(r3, r6, r4, r7);
        getContentView().setRadius(r8);
        this.pressColor = r0.getColor(R.styleable.OShadowFrame_oui_widgetPressColor, 0);
        getContentView().setOverridePressColor(this.pressColor);
        getContentView().refreshColors(TAG);
        addView(getContentView(), new FrameLayout.LayoutParams(-1, -1));
        setShadowCornerRadius(r8);
        initContent(r12, getContentView(), r13, r0);
        if (r9 == null) goto L11;
        boolean r14 = true;
    L12:
        this.isMaterialFromDrawable = r14;
        if (r14 == false) goto L15;
        getContentView().setBackground(r9);
        getContentView().setChangeAlphaWhenPress(false);
        getContentView().setChangeAlphaWhenDisable(false);
    L15:
        KtExt r15 = KtExt.INSTANCE;
        OUIFrameLayout r16 = getContentView();
        if (r16 != null) goto L19;
    L21:
        IOUIAlpha r10 = (IOUIAlpha) r5;
        if (r10 == null) goto L25;
        r10.setChangeAlphaWhenDisable(false);
    L25:
        setChangeAlphaWhenDisable(false);
        initShadows(r12, r0);
        r0.recycle();
        setClipChildren(false);
        setClickable(true);
        updateUIOnEnableChanged(isEnabled());
        return;
    L19:
        if ((r16 instanceof IOUIAlpha) == false) goto L21;
        r5 = r16;
        goto L21
    L11:
        r14 = false;
        goto L12
    }

    private final void initShadows(Context r7, TypedArray r8) {
        int r0 = r8.getResourceId(R.styleable.OShadowFrame_oui_widgetShadowNormal, 0);
        int r9 = r8.getResourceId(R.styleable.OShadowFrame_oui_widgetShadowPressed, 0);
        if (r0 == 0) goto L5;
        List<Shadow> r1 = OUILayoutHelper.extractShadowInfo(r7, r0);
        List<Shadow> r2 = CollectionsKt.listOf(new Shadow[]{r1.get(0), r1.get(1)});
        this.shadowsNormal = r2;
        Intrinsics.checkNotNull(r2);
        Shadow r3 = (Shadow) CollectionsKt.getOrNull(r2, 0);
        List<Shadow> r4 = this.shadowsNormal;
        Intrinsics.checkNotNull(r4);
        setShadow(r3, (Shadow) CollectionsKt.getOrNull(r4, 1));
    L5:
        if (r9 == 0) goto L8;
        List<Shadow> r10 = OUILayoutHelper.extractShadowInfo(r7, r9);
        this.shadowsPressed = CollectionsKt.listOf(new Shadow[]{r10.get(0), r10.get(1)});
        return;
    }

    public static /* synthetic */ void initContent$default(OShadowFrame r0, Context r1, FrameLayout r2, AttributeSet r3, TypedArray r4, int r5, Object r6) {
        if (r6 != null) goto L9;
        if ((r5 & 8) == 0) goto L6;
        r4 = null;
    L6:
        r0.initContent(r1, r2, r3, r4);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: initContent");
    }

    protected final void initMaterials(Context r3, TypedArray r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "typedArray");
        this.materialSrcType = r4.getInt(R.styleable.OShadowFrame_oui_widgetMaterialSrcType, 2);
        String r5 = r4.getString(R.styleable.OShadowFrame_oui_widgetMaterial);
        boolean r0 = OPalette.isColorFul(this.bgColorNormal);
        if (r5 != null) goto L6;
        if (r0 == true) goto L6;
        r5 = getResources().getString(R.string.oui_material_bg_floating);
    L6:
        this.materialTokenString = r5;
        boolean r1 = isDarkTheme();
        if (r0 == false) goto L12;
        this.materials = MaterialConfigBuilder.INSTANCE.createSimpleColorful(MaterialToken.OUI_Bg_Floating_Tinted.invoke(Boolean.valueOf(!r1)), this.bgColorNormal);
        if (this.bgColorDisabled == 0) goto L17;
        this.materialsDisabled = MaterialConfigBuilder.INSTANCE.createSimpleColorful(MaterialToken.OUI_Bg_Floating_Tinted.invoke(Boolean.valueOf(!r1)), this.bgColorDisabled);
    L17:
        if (this.materials != null) goto L20;
        this.enableMaterial = false;
        this.materialApplied = false;
        return;
    L20:
        return;
    L12:
        if (this.materialTokenString == null) goto L17;
        this.materials = MaterialToken.parseSet(r5, !r1);
        String r6 = r4.getString(R.styleable.OShadowFrame_oui_widgetMaterialDisabled);
        this.materialDisabledTokenString = r6;
        if (r6 == null) goto L17;
        this.materialsDisabled = MaterialToken.parseSet(r6, !r1);
        goto L17
    }

    @Override // com.obric.oui.material.MaterialOwner, com.obric.oui.material.MaskMaterialOwner
    public void updateBackdropSrcType(int r1) {
        this.materialSrcType = r1;
        OMaterialExtBaseKt.updateMaterialBackdropSrcType(getContentView(), r1);
    }

    private final void checkColorfulBgMaterial(boolean r5) {
        ColorUtils.setAlphaComponent(this.bgColorNormal, 48);
        if (OPalette.isColorFul(this.bgColorNormal) == false) goto L9;
        MaterialConfig[] r0 = MaterialConfigBuilder.INSTANCE.createSimpleColorful(MaterialToken.OUI_Bg_Floating_Tinted.invoke(Boolean.valueOf(!r5)), this.bgColorNormal);
        if (this.bgColorDisabled == 0) goto L7;
        MaterialConfig[] r6 = MaterialConfigBuilder.INSTANCE.createSimpleColorful(MaterialToken.OUI_Bg_Floating_Tinted.invoke(Boolean.valueOf(!r5)), this.bgColorDisabled);
    L8:
        setMaterialConfigs(r0, r6, false);
        return;
    L7:
        r6 = null;
        goto L8
    L9:
        String r1 = this.materialTokenString;
        if (r1 == null) goto L15;
        MaterialConfig[] r2 = MaterialToken.parseSet(r1, !r5);
        this.materials = r2;
        String r3 = this.materialDisabledTokenString;
        if (r3 == null) goto L14;
        this.materialsDisabled = MaterialToken.parseSet(r3, !r5);
        return;
    L14:
        this.materialsDisabled = r2;
        return;
    L15:
        setMaterialConfigs(MaterialToken.OUI_Bg_Floating.invoke(Boolean.valueOf(!r5)), MaterialToken.OUI_Bg_Floating.invoke(Boolean.valueOf(!r5)), false);
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setEnabled(boolean r2) {
        super.setEnabled(r2);
        getContentView().setEnabled(r2);
        updateUIOnEnableChanged(r2);
    }

    @Override // com.obric.oui.material.MaterialOwner
    public void applyContentMaterial(boolean r3) {
        this.materialApplied = r3;
        MaterialOwnerKt.applyBackdropMaterial(getContentView(), r3, this.materialSrcType);
        updateUIOnEnableChanged(isEnabled());
        invalidate();
    }

    @Override // com.obric.oui.material.MaterialOwner, com.obric.oui.material.MaskMaterialOwner
    public void setBackdropTarget(View r1) {
        OMaterialExtBaseKt.setMaterialBackdropTarget(getContentView(), r1);
    }

    @Override // com.obric.oui.material.MaterialOwner, com.obric.oui.material.MaskMaterialOwner
    public void updateBackdropTargetType(boolean r2) {
        if (this.isBackdropView == r2) goto L6;
        this.isBackdropView = r2;
        OMaterialExtBaseKt.updateMaterialBackdropTargetType(getContentView(), r2);
        return;
    }

    public void setBgColor(int r2) {
        if (this.bgColorNormal == r2) goto L14;
        this.bgColorNormal = r2;
        this.bgColorDisabled = r2;
        boolean r3 = OPalette.isDarkColor(r2);
        checkColorfulBgMaterial(r3);
        if (r3 == false) goto L7;
        int r4 = 2;
    L9:
        if (r4 == this.currentTheme) goto L12;
        applyDynamicTheme(r4);
        return;
    L12:
        updateUIOnEnableChanged(isEnabled());
        return;
    L7:
        r4 = 1;
        goto L9
    }

    public void setBgColors(int r1, int r2) {
        this.bgColorNormal = r1;
        this.bgColorDisabled = r2;
        boolean r3 = OPalette.isDarkColor(r1);
        checkColorfulBgMaterial(r3);
        if (r3 == false) goto L5;
        int r4 = 2;
    L7:
        if (r4 == this.currentTheme) goto L10;
        applyDynamicTheme(r4);
        return;
    L10:
        updateUIOnEnableChanged(isEnabled());
        return;
    L5:
        r4 = 1;
        goto L7
    }

    public void setBgColors(int r1, int r2, String r3, String r4) {
        this.bgColorNormal = r1;
        this.bgColorDisabled = r2;
        if (r3 == null) goto L7;
        setMaterialByTokenString(r3, r4, false);
    L7:
        if (OPalette.isDarkColor(r1) == false) goto L9;
        int r5 = 2;
    L11:
        if (r5 == this.currentTheme) goto L14;
        applyDynamicTheme(r5);
        return;
    L14:
        updateUIOnEnableChanged(isEnabled());
        return;
    L9:
        r5 = 1;
        goto L11
    }

    public void setBgColors(int r1, int r2, MaterialConfig[] r3, MaterialConfig[] r4) {
        this.bgColorNormal = r1;
        this.bgColorDisabled = r2;
        setMaterialConfigs(r3, r4, false);
        if (OPalette.isDarkColor(r1) == false) goto L5;
        int r5 = 2;
    L7:
        if (r5 == this.currentTheme) goto L10;
        applyDynamicTheme(r5);
        return;
    L10:
        updateUIOnEnableChanged(isEnabled());
        return;
    L5:
        r5 = 1;
        goto L7
    }

    public void setPressColor(int r2) {
        this.pressColor = r2;
        getContentView().setOverridePressColor(this.pressColor);
        getContentView().refreshColors(TAG);
    }

    public static /* synthetic */ void setMaterialByTokenString$default(OShadowFrame r0, String r1, String r2, boolean r3, int r4, Object r5) {
        if (r5 != null) goto L9;
        if ((r4 & 4) == 0) goto L6;
        r3 = true;
    L6:
        r0.setMaterialByTokenString(r1, r2, r3);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setMaterialByTokenString");
    }

    public void setMaterialByTokenString(String r3, String r4, boolean r5) {
        if ((!Intrinsics.areEqual(this.materialTokenString, r3)) == false) goto L5;
        this.materialTokenString = r3;
        this.materials = MaterialToken.parseSet(r3, !isDarkTheme());
    L5:
        String r6 = this.materialDisabledTokenString;
        if (r6 != null) goto L8;
        boolean r7 = true;
    L10:
        if ((!r7) == false) goto L12;
        this.materialDisabledTokenString = r4;
        this.materialsDisabled = MaterialToken.parseSet(r4, !isDarkTheme());
    L12:
        if (r5 == false) goto L15;
        updateUIOnEnableChanged(isEnabled());
        return;
    L15:
        return;
    L8:
        r7 = StringsKt.contentEquals(r6, r4);
        goto L10
    }

    public static /* synthetic */ void setMaterialConfigs$default(OShadowFrame r0, MaterialConfig r1, MaterialConfig r2, boolean r3, int r4, Object r5) {
        if (r5 != null) goto L9;
        if ((r4 & 4) == 0) goto L6;
        r3 = true;
    L6:
        r0.setMaterialConfigs(r1, r2, r3);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setMaterialConfigs");
    }

    public void setMaterialConfigs(MaterialConfig r5, MaterialConfig r6, boolean r7) {
        MaterialConfig[] r0 = null;
        if (r5 != null) goto L5;
        MaterialConfig[] r3 = null;
    L6:
        if (r6 == null) goto L9;
        r0 = new MaterialConfig[]{r6};
    L9:
        setMaterialConfigs(r3, r0, r7);
        return;
    L5:
        r3 = new MaterialConfig[]{r5};
        goto L6
    }

    public static /* synthetic */ void setMaterialConfigs$default(OShadowFrame r0, MaterialConfig[] r1, MaterialConfig[] r2, boolean r3, int r4, Object r5) {
        if (r5 != null) goto L9;
        if ((r4 & 4) == 0) goto L6;
        r3 = true;
    L6:
        r0.setMaterialConfigs(r1, r2, r3);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setMaterialConfigs");
    }

    public void setMaterialConfigs(MaterialConfig[] r1, MaterialConfig[] r2, boolean r3) {
        this.materials = r1;
        this.materialsDisabled = r2;
        this.materialTokenString = null;
        this.materialDisabledTokenString = null;
        if (r3 == false) goto L6;
        updateUIOnEnableChanged(isEnabled());
        return;
    }

    public void applyDynamicTheme(int r2) {
        if (this.currentTheme == r2) goto L14;
        this.currentTheme = r2;
        String r3 = this.materialTokenString;
        if (r3 == null) goto L8;
        setMaterials(MaterialToken.parseSet(r3, !isDarkTheme()));
    L8:
        String r4 = this.materialDisabledTokenString;
        if (r4 == null) goto L12;
        setMaterialsDisabled(MaterialToken.parseSet(r4, !isDarkTheme()));
    L12:
        updateUIOnEnableChanged(isEnabled());
        return;
    }

    @Override // com.obric.oui.common.style.ODynamicThemeWidget
    public boolean isDarkTheme() {
        int r0 = this.bgColorNormal;
        if (r0 != 0) goto L7;
        return ViewUtilKt.isDarkMode(this);
    L7:
        if (this.currentTheme != 2) goto L9;
    L12:
        return true;
    L9:
        if (OPalette.isDarkColor(r0) == true) goto L12;
        return false;
    }

    protected void updateUIOnEnableChanged(boolean r18) {
        if (this.materialApplied == true) goto L9;
        getContentView().setBorderWidth(0);
        getContentView().setBorderColor(0);
        if (r18 == false) goto L7;
        getContentView().setBackgroundColor(this.bgColorNormal);
        return;
    L7:
        getContentView().setBackgroundColor(this.bgColorDisabled);
        return;
    L9:
        if (this.isMaterialFromDrawable == false) goto L11;
        return;
    L11:
        getContentView().setBackgroundColor(0);
        if (r18 == false) goto L17;
        MaterialConfig[] r4 = this.materials;
        if (r4 == null) goto L25;
        OMaterialExtBaseKt.materials$default(getContentView(), r4, false, getMaterialSrcType(), null, 10, null);
        return;
    L25:
        return;
    L17:
        MaterialConfig[] r11 = this.materialsDisabled;
        if (r11 == null) goto L26;
        OMaterialExtBaseKt.materials$default(getContentView(), r11, false, getMaterialSrcType(), null, 10, null);
        return;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        boolean r0 = super.dispatchTouchEvent(r3);
        int r4 = r3.getAction();
        if (r4 == 0) goto L9;
        if (r4 != 1) goto L6;
    L8:
        doPressAnim(false);
    L10:
        return r0;
    L6:
        if (r4 == 3) goto L8;
    L9:
        doPressAnim(true);
        goto L10
    }

    private final void doPressAnim(boolean r5) {
        if (isEnabled() == true) goto L6;
        L.d(TAG, "doPressAnim, skip, isEnabled=false");
        return;
    L6:
        L.d(TAG, Intrinsics.stringPlus("doPressAnim: ", Boolean.valueOf(r5)));
        AnimationManager r0 = this.pressAnim;
        if (r0 == null) goto L10;
        AnimationManager.cancelAnimation$default(r0, false, 1, null);
    L10:
        AnimationManager r1 = this.releaseAnim;
        if (r1 == null) goto L14;
        AnimationManager.cancelAnimation$default(r1, false, 1, null);
    L14:
        if (r5 == false) goto L16;
        this.pressAnim = ShadowAnimator.startWithScaleAnimation(this, this.initScale, this.pressScale, getCurrentShadows(), this.shadowsPressed);
        return;
    L16:
        this.releaseAnim = ShadowAnimator.startWithScaleAnimation(this, this.pressScale, this.initScale, getCurrentShadows(), this.shadowsNormal);
    }
}
