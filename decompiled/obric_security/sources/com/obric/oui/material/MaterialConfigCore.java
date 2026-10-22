package com.obric.oui.material;

import android.content.res.ColorStateList;
import com.obric.oui.blur.BlurConfig;
import com.obric.oui.color.BlendConfig;
import com.obric.oui.color.StrokeConfig;
import com.obric.oui.fluid.FluidConfig;
import com.obric.oui.res.BlendConfigStateList;
import com.obric.oui.res.StrokeStateList;
import com.obric.oui.shadow.ShadowConfig;

/* JADX INFO: loaded from: classes3.dex */
public final class MaterialConfigCore {
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

    public MaterialConfigCore() {
        this(null, null, null, null, null, null, null, null, null, null);
    }

    public MaterialConfigCore(ColorStateList r12) {
        this(r12, null, null, null, null, null, null, null, null, null);
    }

    public MaterialConfigCore(ColorStateList r1, BlendConfigStateList r2, BlendConfig[] r3, StrokeStateList r4, StrokeConfig r5, BlendConfigStateList r6, BlurConfig r7, Float r8, ShadowConfig[] r9, FluidConfig r10) {
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

    public ColorStateList getFallbackBgColor() {
        return this.fallbackBgColor;
    }

    public void setFallbackBgColor(ColorStateList r1) {
        this.fallbackBgColor = r1;
    }

    public BlendConfigStateList getBlendConfigStateList() {
        return this.blendConfigStateList;
    }

    public void setBlendConfigStateList(BlendConfigStateList r1) {
        this.blendConfigStateList = r1;
    }

    public BlendConfig[] getBlendConfig() {
        return this.blendConfig;
    }

    public void setBlendConfig(BlendConfig[] r1) {
        this.blendConfig = r1;
    }

    public StrokeStateList getStrokeStateList() {
        return this.strokeStateList;
    }

    public void setStrokeStateList(StrokeStateList r1) {
        this.strokeStateList = r1;
    }

    public StrokeConfig getStroke() {
        return this.stroke;
    }

    public void setStroke(StrokeConfig r1) {
        this.stroke = r1;
    }

    public BlendConfigStateList getOverlayBlendConfigStateList() {
        return this.overlayBlendConfigStateList;
    }

    public void setOverlayBlendConfigStateList(BlendConfigStateList r1) {
        this.overlayBlendConfigStateList = r1;
    }

    public BlurConfig getBlurConfig() {
        return this.blurConfig;
    }

    public void setBlurConfig(BlurConfig r1) {
        this.blurConfig = r1;
    }

    public Float getBlurRadius() {
        return this.blurRadius;
    }

    public void setBlurRadius(Float r1) {
        this.blurRadius = r1;
    }

    public ShadowConfig[] getShadow() {
        return this.shadow;
    }

    public void setShadow(ShadowConfig[] r1) {
        this.shadow = r1;
    }

    public FluidConfig getFluid() {
        return this.fluid;
    }

    public void setFluid(FluidConfig r1) {
        this.fluid = r1;
    }

    public MaterialConfigCore deepCopy() {
        ColorStateList r0 = this.fallbackBgColor;
        if (r0 == null) goto L5;
        ColorStateList r2 = r0;
    L6:
        BlendConfigStateList r1 = this.blendConfigStateList;
        if (r1 == null) goto L9;
        BlendConfigStateList r3 = r1.deepCopy();
    L10:
        BlendConfig[] r4 = copyBlendConfigs(this.blendConfig);
        StrokeStateList r5 = this.strokeStateList;
        if (r5 == null) goto L13;
        StrokeStateList r6 = r5.deepCopy();
    L14:
        StrokeConfig r7 = this.stroke;
        if (r7 == null) goto L17;
        StrokeConfig r8 = r7.deepCopy();
    L18:
        BlendConfigStateList r9 = this.overlayBlendConfigStateList;
        if (r9 == null) goto L21;
        BlendConfigStateList r10 = r9.deepCopy();
    L22:
        BlurConfig r11 = this.blurConfig;
        if (r11 == null) goto L25;
        BlurConfig r12 = r11.deepCopy();
    L26:
        Float r13 = this.blurRadius;
        ShadowConfig[] r14 = copyShadowConfigs(this.shadow);
        FluidConfig r15 = this.fluid;
        if (r15 == null) goto L29;
        FluidConfig r16 = r15.deepCopy();
    L31:
        return new MaterialConfigCore(r2, r3, r4, r6, r8, r10, r12, r13, r14, r16);
    L29:
        r16 = null;
        goto L31
    L25:
        r12 = null;
        goto L26
    L21:
        r10 = null;
        goto L22
    L17:
        r8 = null;
        goto L18
    L13:
        r6 = null;
        goto L14
    L9:
        r3 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public static MaterialConfig deepCopy(MaterialConfig r13) {
        FluidConfig r0 = null;
        if (r13 != null) goto L6;
        return null;
    L6:
        if (r13.getFallbackBgColor() == null) goto L8;
        ColorStateList r2 = MaterialConfigKt.deepCopy(r13.getFallbackBgColor());
    L10:
        if (r13.getBlendConfigStateList() == null) goto L12;
        BlendConfigStateList r3 = r13.getBlendConfigStateList().deepCopy();
    L13:
        BlendConfig[] r4 = copyBlendConfigs(r13.getBlendConfig());
        if (r13.getStrokeStateList() == null) goto L16;
        StrokeStateList r5 = r13.getStrokeStateList().deepCopy();
    L18:
        if (r13.getStroke() == null) goto L20;
        StrokeConfig r6 = r13.getStroke().deepCopy();
    L22:
        if (r13.getOverlayBlendConfigStateList() == null) goto L24;
        BlendConfigStateList r7 = r13.getOverlayBlendConfigStateList().deepCopy();
    L26:
        if (r13.getBlurConfig() == null) goto L28;
        BlurConfig r8 = r13.getBlurConfig().deepCopy();
    L29:
        Float r9 = r13.getBlurRadius();
        ShadowConfig[] r10 = copyShadowConfigs(r13.getShadow());
        if (r13.getFluid() == null) goto L33;
        r0 = r13.getFluid().deepCopy();
    L33:
        return new MaterialConfig(r2, r3, r4, r5, r6, r7, r8, r9, r10, r0);
    L28:
        r8 = null;
        goto L29
    L24:
        r7 = null;
        goto L26
    L20:
        r6 = null;
        goto L22
    L16:
        r5 = null;
        goto L18
    L12:
        r3 = null;
        goto L13
    L8:
        r2 = null;
        goto L10
    }

    private static BlendConfig[] copyBlendConfigs(BlendConfig[] r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        BlendConfig[] r1 = new BlendConfig[r4.length];
        int r2 = 0;
    L7:
        if (r2 >= r4.length) goto L13;
        BlendConfig r3 = r4[r2];
        if (r3 == null) goto L11;
        BlendConfig r5 = r3.deepCopy();
    L12:
        r1[r2] = r5;
        r2 = r2 + 1;
        goto L7
    L11:
        r5 = null;
        goto L12
    L13:
        return r1;
    }

    private static ShadowConfig[] copyShadowConfigs(ShadowConfig[] r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        ShadowConfig[] r1 = new ShadowConfig[r4.length];
        int r2 = 0;
    L7:
        if (r2 >= r4.length) goto L13;
        ShadowConfig r3 = r4[r2];
        if (r3 == null) goto L11;
        ShadowConfig r5 = r3.deepCopy();
    L12:
        r1[r2] = r5;
        r2 = r2 + 1;
        goto L7
    L11:
        r5 = null;
        goto L12
    L13:
        return r1;
    }
}
