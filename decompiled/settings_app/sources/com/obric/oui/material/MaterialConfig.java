package com.obric.oui.material;

import android.content.res.ColorStateList;
import android.icu.text.PluralRules;
import androidx.core.view.PointerIconCompat;
import com.obric.oui.blur.BlurConfig;
import com.obric.oui.blur.BlurConfigCore;
import com.obric.oui.color.BlendConfig;
import com.obric.oui.color.BlendConfigCore;
import com.obric.oui.color.BlendConfigKt;
import com.obric.oui.color.StrokeConfig;
import com.obric.oui.color.StrokeConfigCore;
import com.obric.oui.fluid.FluidConfig;
import com.obric.oui.fluid.FluidConfigCore;
import com.obric.oui.res.BlendConfigStateList;
import com.obric.oui.res.BlendConfigStateListCore;
import com.obric.oui.res.StrokeStateList;
import com.obric.oui.res.StrokeStateListCore;
import com.obric.oui.shadow.ShadowConfig;
import com.obric.oui.shadow.ShadowConfigCore;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MaterialConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b9\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u008b\u0001\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0016\u0010C\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010D\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u0010\u0010H\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010%J\u0016\u0010I\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u00104J\u0006\u0010J\u001a\u00020\u0000J\u0092\u0001\u0010J\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÆ\u0001¢\u0006\u0002\u0010KJ\u0006\u0010L\u001a\u00020\u0000J\u0006\u0010M\u001a\u00020\u0000J\u0013\u0010N\u001a\u00020O2\b\u0010P\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010Q\u001a\u00020RH\u0016J\r\u0010S\u001a\u00020TH\u0000¢\u0006\u0002\bUJ\t\u0010V\u001a\u00020WHÖ\u0001R$\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001d\"\u0004\b2\u0010\u001fR$\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u00107\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?¨\u0006X"}, d2 = {"Lcom/obric/oui/material/MaterialConfig;", "", "fallbackBgColor", "Landroid/content/res/ColorStateList;", "blendConfigStateList", "Lcom/obric/oui/res/BlendConfigStateList;", "blendConfig", "", "Lcom/obric/oui/color/BlendConfig;", "strokeStateList", "Lcom/obric/oui/res/StrokeStateList;", MaterialConfigFormatNames.STROKE, "Lcom/obric/oui/color/StrokeConfig;", "overlayBlendConfigStateList", "blurConfig", "Lcom/obric/oui/blur/BlurConfig;", "blurRadius", "", MaterialConfigFormatNames.SHADOW, "Lcom/obric/oui/shadow/ShadowConfig;", MaterialConfigFormatNames.FLUID, "Lcom/obric/oui/fluid/FluidConfig;", "(Landroid/content/res/ColorStateList;Lcom/obric/oui/res/BlendConfigStateList;[Lcom/obric/oui/color/BlendConfig;Lcom/obric/oui/res/StrokeStateList;Lcom/obric/oui/color/StrokeConfig;Lcom/obric/oui/res/BlendConfigStateList;Lcom/obric/oui/blur/BlurConfig;Ljava/lang/Float;[Lcom/obric/oui/shadow/ShadowConfig;Lcom/obric/oui/fluid/FluidConfig;)V", "getBlendConfig", "()[Lcom/obric/oui/color/BlendConfig;", "setBlendConfig", "([Lcom/obric/oui/color/BlendConfig;)V", "[Lcom/obric/oui/color/BlendConfig;", "getBlendConfigStateList", "()Lcom/obric/oui/res/BlendConfigStateList;", "setBlendConfigStateList", "(Lcom/obric/oui/res/BlendConfigStateList;)V", "getBlurConfig", "()Lcom/obric/oui/blur/BlurConfig;", "setBlurConfig", "(Lcom/obric/oui/blur/BlurConfig;)V", "getBlurRadius", "()Ljava/lang/Float;", "setBlurRadius", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getFallbackBgColor", "()Landroid/content/res/ColorStateList;", "setFallbackBgColor", "(Landroid/content/res/ColorStateList;)V", "getFluid", "()Lcom/obric/oui/fluid/FluidConfig;", "setFluid", "(Lcom/obric/oui/fluid/FluidConfig;)V", "getOverlayBlendConfigStateList", "setOverlayBlendConfigStateList", "getShadow", "()[Lcom/obric/oui/shadow/ShadowConfig;", "setShadow", "([Lcom/obric/oui/shadow/ShadowConfig;)V", "[Lcom/obric/oui/shadow/ShadowConfig;", "getStroke", "()Lcom/obric/oui/color/StrokeConfig;", "setStroke", "(Lcom/obric/oui/color/StrokeConfig;)V", "getStrokeStateList", "()Lcom/obric/oui/res/StrokeStateList;", "setStrokeStateList", "(Lcom/obric/oui/res/StrokeStateList;)V", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Landroid/content/res/ColorStateList;Lcom/obric/oui/res/BlendConfigStateList;[Lcom/obric/oui/color/BlendConfig;Lcom/obric/oui/res/StrokeStateList;Lcom/obric/oui/color/StrokeConfig;Lcom/obric/oui/res/BlendConfigStateList;Lcom/obric/oui/blur/BlurConfig;Ljava/lang/Float;[Lcom/obric/oui/shadow/ShadowConfig;Lcom/obric/oui/fluid/FluidConfig;)Lcom/obric/oui/material/MaterialConfig;", "deepCopy", "deepCopyFromCore", "equals", "", PluralRules.KEYWORD_OTHER, "hashCode", "", "toCore", "Lcom/obric/oui/material/MaterialConfigCore;", "toCore$OUI_standardRelease", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MaterialConfig {
    private BlendConfig[] blendConfig;
    private BlendConfigStateList blendConfigStateList;
    private BlurConfig blurConfig;
    private Float blurRadius;
    private ColorStateList fallbackBgColor;
    private FluidConfig fluid;
    private BlendConfigStateList overlayBlendConfigStateList;
    private ShadowConfig[] shadow;
    private StrokeConfig stroke;
    private StrokeStateList strokeStateList;

    public MaterialConfig() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    public MaterialConfig(ColorStateList r14) {
        this(r14, null, null, null, null, null, null, null, null, null, 1022, null);
    }

    public MaterialConfig(ColorStateList r14, BlendConfigStateList r15) {
        this(r14, r15, null, null, null, null, null, null, null, null, PointerIconCompat.TYPE_GRAB, null);
    }

    public MaterialConfig(ColorStateList r14, BlendConfigStateList r15, BlendConfig[] r16) {
        this(r14, r15, r16, null, null, null, null, null, null, null, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, null);
    }

    public MaterialConfig(ColorStateList r14, BlendConfigStateList r15, BlendConfig[] r16, StrokeStateList r17) {
        this(r14, r15, r16, r17, null, null, null, null, null, null, PointerIconCompat.TYPE_TEXT, null);
    }

    public MaterialConfig(ColorStateList r14, BlendConfigStateList r15, BlendConfig[] r16, StrokeStateList r17, StrokeConfig r18) {
        this(r14, r15, r16, r17, r18, null, null, null, null, null, 992, null);
    }

    public MaterialConfig(ColorStateList r14, BlendConfigStateList r15, BlendConfig[] r16, StrokeStateList r17, StrokeConfig r18, BlendConfigStateList r19) {
        this(r14, r15, r16, r17, r18, r19, null, null, null, null, 960, null);
    }

    public MaterialConfig(ColorStateList r14, BlendConfigStateList r15, BlendConfig[] r16, StrokeStateList r17, StrokeConfig r18, BlendConfigStateList r19, BlurConfig r20) {
        this(r14, r15, r16, r17, r18, r19, r20, null, null, null, 896, null);
    }

    public MaterialConfig(ColorStateList r14, BlendConfigStateList r15, BlendConfig[] r16, StrokeStateList r17, StrokeConfig r18, BlendConfigStateList r19, BlurConfig r20, Float r21) {
        this(r14, r15, r16, r17, r18, r19, r20, r21, null, null, 768, null);
    }

    public MaterialConfig(ColorStateList r14, BlendConfigStateList r15, BlendConfig[] r16, StrokeStateList r17, StrokeConfig r18, BlendConfigStateList r19, BlurConfig r20, Float r21, ShadowConfig[] r22) {
        this(r14, r15, r16, r17, r18, r19, r20, r21, r22, null, 512, null);
    }

    public static /* synthetic */ MaterialConfig copy$default(MaterialConfig r11, ColorStateList r12, BlendConfigStateList r13, BlendConfig[] r14, StrokeStateList r15, StrokeConfig r16, BlendConfigStateList r17, BlurConfig r18, Float r19, ShadowConfig[] r20, FluidConfig r21, int r22, Object r23) {
        if ((r22 & 1) == 0) goto L5;
        ColorStateList r2 = r11.fallbackBgColor;
    L7:
        if ((r22 & 2) == 0) goto L9;
        BlendConfigStateList r3 = r11.blendConfigStateList;
    L11:
        if ((r22 & 4) == 0) goto L13;
        BlendConfig[] r4 = r11.blendConfig;
    L15:
        if ((r22 & 8) == 0) goto L17;
        StrokeStateList r5 = r11.strokeStateList;
    L19:
        if ((r22 & 16) == 0) goto L21;
        StrokeConfig r6 = r11.stroke;
    L23:
        if ((r22 & 32) == 0) goto L25;
        BlendConfigStateList r7 = r11.overlayBlendConfigStateList;
    L27:
        if ((r22 & 64) == 0) goto L29;
        BlurConfig r8 = r11.blurConfig;
    L31:
        if ((r22 & 128) == 0) goto L33;
        Float r9 = r11.blurRadius;
    L35:
        if ((r22 & 256) == 0) goto L37;
        ShadowConfig[] r10 = r11.shadow;
    L39:
        if ((r22 & 512) == 0) goto L41;
        FluidConfig r1 = r11.fluid;
    L43:
        return r11.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r1);
    L41:
        r1 = r21;
        goto L43
    L37:
        r10 = r20;
        goto L39
    L33:
        r9 = r19;
        goto L35
    L29:
        r8 = r18;
        goto L31
    L25:
        r7 = r17;
        goto L27
    L21:
        r6 = r16;
        goto L23
    L17:
        r5 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r2 = r12;
        goto L7
    }

    public final ColorStateList component1() {
        return this.fallbackBgColor;
    }

    public final FluidConfig component10() {
        return this.fluid;
    }

    public final BlendConfigStateList component2() {
        return this.blendConfigStateList;
    }

    public final BlendConfig[] component3() {
        return this.blendConfig;
    }

    public final StrokeStateList component4() {
        return this.strokeStateList;
    }

    public final StrokeConfig component5() {
        return this.stroke;
    }

    public final BlendConfigStateList component6() {
        return this.overlayBlendConfigStateList;
    }

    public final BlurConfig component7() {
        return this.blurConfig;
    }

    public final Float component8() {
        return this.blurRadius;
    }

    public final ShadowConfig[] component9() {
        return this.shadow;
    }

    public final MaterialConfig copy(ColorStateList r13, BlendConfigStateList r14, BlendConfig[] r15, StrokeStateList r16, StrokeConfig r17, BlendConfigStateList r18, BlurConfig r19, Float r20, ShadowConfig[] r21, FluidConfig r22) {
        return new MaterialConfig(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    public String toString() {
        return "MaterialConfig(fallbackBgColor=" + this.fallbackBgColor + ", blendConfigStateList=" + this.blendConfigStateList + ", blendConfig=" + Arrays.toString(this.blendConfig) + ", strokeStateList=" + this.strokeStateList + ", stroke=" + this.stroke + ", overlayBlendConfigStateList=" + this.overlayBlendConfigStateList + ", blurConfig=" + this.blurConfig + ", blurRadius=" + this.blurRadius + ", shadow=" + Arrays.toString(this.shadow) + ", fluid=" + this.fluid + ')';
    }

    public MaterialConfig(ColorStateList r1, BlendConfigStateList r2, BlendConfig[] r3, StrokeStateList r4, StrokeConfig r5, BlendConfigStateList r6, BlurConfig r7, Float r8, ShadowConfig[] r9, FluidConfig r10) {
        this.fallbackBgColor = r1;
        this.blendConfigStateList = r2;
        this.blendConfig = r3;
        this.strokeStateList = r4;
        this.stroke = r5;
        this.overlayBlendConfigStateList = r6;
        this.blurConfig = r7;
        this.blurRadius = r8;
        this.shadow = r9;
        this.fluid = r10;
    }

    public /* synthetic */ MaterialConfig(ColorStateList r2, BlendConfigStateList r3, BlendConfig[] r4, StrokeStateList r5, StrokeConfig r6, BlendConfigStateList r7, BlurConfig r8, Float r9, ShadowConfig[] r10, FluidConfig r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r12 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r12 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r12 & 16) == 0) goto L18;
        r6 = null;
    L18:
        if ((r12 & 32) == 0) goto L21;
        r7 = null;
    L21:
        if ((r12 & 64) == 0) goto L24;
        r8 = null;
    L24:
        if ((r12 & 128) == 0) goto L27;
        r9 = null;
    L27:
        if ((r12 & 256) == 0) goto L30;
        r10 = null;
    L30:
        if ((r12 & 512) == 0) goto L32;
        r11 = null;
    L32:
        this(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    public final ColorStateList getFallbackBgColor() {
        return this.fallbackBgColor;
    }

    public final void setFallbackBgColor(ColorStateList r1) {
        this.fallbackBgColor = r1;
    }

    public final BlendConfigStateList getBlendConfigStateList() {
        return this.blendConfigStateList;
    }

    public final void setBlendConfigStateList(BlendConfigStateList r1) {
        this.blendConfigStateList = r1;
    }

    public final BlendConfig[] getBlendConfig() {
        return this.blendConfig;
    }

    public final void setBlendConfig(BlendConfig[] r1) {
        this.blendConfig = r1;
    }

    public final StrokeStateList getStrokeStateList() {
        return this.strokeStateList;
    }

    public final void setStrokeStateList(StrokeStateList r1) {
        this.strokeStateList = r1;
    }

    public final StrokeConfig getStroke() {
        return this.stroke;
    }

    public final void setStroke(StrokeConfig r1) {
        this.stroke = r1;
    }

    public final BlendConfigStateList getOverlayBlendConfigStateList() {
        return this.overlayBlendConfigStateList;
    }

    public final void setOverlayBlendConfigStateList(BlendConfigStateList r1) {
        this.overlayBlendConfigStateList = r1;
    }

    public final BlurConfig getBlurConfig() {
        return this.blurConfig;
    }

    public final void setBlurConfig(BlurConfig r1) {
        this.blurConfig = r1;
    }

    public final Float getBlurRadius() {
        return this.blurRadius;
    }

    public final void setBlurRadius(Float r1) {
        this.blurRadius = r1;
    }

    public final ShadowConfig[] getShadow() {
        return this.shadow;
    }

    public final void setShadow(ShadowConfig[] r1) {
        this.shadow = r1;
    }

    public final FluidConfig getFluid() {
        return this.fluid;
    }

    public final void setFluid(FluidConfig r1) {
        this.fluid = r1;
    }

    public final MaterialConfigCore toCore$OUI_standardRelease() {
        ColorStateList r1 = this.fallbackBgColor;
        BlendConfigStateList r0 = this.blendConfigStateList;
        if (r0 != null) goto L5;
        BlendConfigStateListCore r3 = null;
    L6:
        BlendConfig[] r2 = this.blendConfig;
        if (r2 != null) goto L9;
        BlendConfigCore[] r4 = null;
    L10:
        StrokeStateList r5 = this.strokeStateList;
        if (r5 != null) goto L13;
        StrokeStateListCore r6 = null;
    L14:
        StrokeConfig r7 = this.stroke;
        if (r7 != null) goto L17;
        StrokeConfigCore r8 = null;
    L18:
        BlendConfigStateList r9 = this.overlayBlendConfigStateList;
        if (r9 != null) goto L21;
        BlendConfigStateListCore r10 = null;
    L22:
        BlurConfig r11 = this.blurConfig;
        if (r11 != null) goto L25;
        BlurConfigCore r12 = null;
    L26:
        Float r13 = this.blurRadius;
        ShadowConfig[] r14 = this.shadow;
        if (r14 != null) goto L29;
        ShadowConfigCore[] r15 = null;
    L30:
        FluidConfig r16 = this.fluid;
        if (r16 != null) goto L33;
        FluidConfigCore r17 = null;
    L35:
        return new MaterialConfigCore(r1, r3, r4, r6, r8, r10, r12, r13, r15, r17);
    L33:
        r17 = r16.toCore$OUI_standardRelease();
        goto L35
    L29:
        r15 = MaterialConfigKt.toCoreArray(r14);
        goto L30
    L25:
        r12 = r11.toCore$OUI_standardRelease();
        goto L26
    L21:
        r10 = r9.toCore$OUI_standardRelease();
        goto L22
    L17:
        r8 = r7.toCore$OUI_standardRelease();
        goto L18
    L13:
        r6 = r5.toCore$OUI_standardRelease();
        goto L14
    L9:
        r4 = BlendConfigKt.toCoreArray(r2);
        goto L10
    L5:
        r3 = r0.toCore$OUI_standardRelease();
        goto L6
    }

    public final MaterialConfig deepCopy() {
        MaterialConfigCore r0 = toCore$OUI_standardRelease().deepCopy();
        Intrinsics.checkNotNullExpressionValue(r0, "toCore().deepCopy()");
        MaterialConfig r1 = MaterialConfigKt.toConfig(r0);
        ColorStateList r2 = getFallbackBgColor();
        if (r2 != null) goto L5;
        ColorStateList r3 = null;
    L6:
        r1.setFallbackBgColor(r3);
        return r1;
    L5:
        r3 = MaterialConfigKt.deepCopy(r2);
        goto L6
    }

    public final MaterialConfig copy() {
        return deepCopy();
    }

    public final MaterialConfig deepCopyFromCore() {
        MaterialConfigCore r1 = toCore$OUI_standardRelease().deepCopy();
        Intrinsics.checkNotNullExpressionValue(r1, "toCore().deepCopy()");
        return MaterialConfigKt.toConfig(r1);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L5;
        return true;
    L5:
        Class<?> r1 = getClass();
        if (r5 != null) goto L8;
        Class<?> r2 = null;
    L10:
        if (Intrinsics.areEqual(r1, r2) == true) goto L12;
        return false;
    L12:
        if (r5 == null) goto L45;
        MaterialConfig r6 = (MaterialConfig) r5;
        if (Intrinsics.areEqual(this.blurRadius, r6.blurRadius) == true) goto L17;
        return false;
    L17:
        if (Intrinsics.areEqual(this.fallbackBgColor, r6.fallbackBgColor) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.blendConfigStateList, r6.blendConfigStateList) == true) goto L23;
        return false;
    L23:
        if (Arrays.equals(this.blendConfig, r6.blendConfig) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.strokeStateList, r6.strokeStateList) == true) goto L29;
        return false;
    L29:
        if (Intrinsics.areEqual(this.stroke, r6.stroke) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.overlayBlendConfigStateList, r6.overlayBlendConfigStateList) == true) goto L35;
        return false;
    L35:
        if (Intrinsics.areEqual(this.blurConfig, r6.blurConfig) == true) goto L38;
        return false;
    L38:
        if (Arrays.equals(this.shadow, r6.shadow) == true) goto L41;
        return false;
    L41:
        if (Intrinsics.areEqual(this.fluid, r6.fluid) == true) goto L43;
        return false;
    L43:
        return true;
    L45:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.material.MaterialConfig");
    L8:
        r2 = r5.getClass();
        goto L10
    }

    public int hashCode() {
        Float r0 = this.blurRadius;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        ColorStateList r4 = this.fallbackBgColor;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        BlendConfigStateList r7 = this.blendConfigStateList;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        BlendConfig[] r10 = this.blendConfig;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        StrokeStateList r13 = this.strokeStateList;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        StrokeConfig r16 = this.stroke;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        BlendConfigStateList r19 = this.overlayBlendConfigStateList;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        BlurConfig r22 = this.blurConfig;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        ShadowConfig[] r25 = this.shadow;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        FluidConfig r28 = this.fluid;
        if (r28 == null) goto L43;
        r1 = r28.hashCode();
    L43:
        return r27 + r1;
    L37:
        r26 = Arrays.hashCode(r25);
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = Arrays.hashCode(r10);
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }
}
