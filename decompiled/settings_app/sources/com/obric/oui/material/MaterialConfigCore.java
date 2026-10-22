package com.obric.oui.material;

import android.content.res.ColorStateList;
import com.obric.oui.blur.BlurConfigCore;
import com.obric.oui.color.BlendConfigCore;
import com.obric.oui.color.StrokeConfigCore;
import com.obric.oui.fluid.FluidConfigCore;
import com.obric.oui.res.BlendConfigStateListCore;
import com.obric.oui.res.StrokeStateListCore;
import com.obric.oui.shadow.ShadowConfigCore;

/* JADX INFO: loaded from: classes3.dex */
public final class MaterialConfigCore {
    private BlendConfigCore[] blendConfig;
    private BlendConfigStateListCore blendConfigStateList;
    private BlurConfigCore blurConfig;
    private Float blurRadius;
    private ColorStateList fallbackBgColor;
    private FluidConfigCore fluid;
    private BlendConfigStateListCore overlayBlendConfigStateList;
    private ShadowConfigCore[] shadow;
    private StrokeConfigCore stroke;
    private StrokeStateListCore strokeStateList;

    public MaterialConfigCore() {
        this(null, null, null, null, null, null, null, null, null, null);
    }

    public MaterialConfigCore(ColorStateList r12) {
        this(r12, null, null, null, null, null, null, null, null, null);
    }

    public MaterialConfigCore(ColorStateList r1, BlendConfigStateListCore r2, BlendConfigCore[] r3, StrokeStateListCore r4, StrokeConfigCore r5, BlendConfigStateListCore r6, BlurConfigCore r7, Float r8, ShadowConfigCore[] r9, FluidConfigCore r10) {
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

    public BlendConfigStateListCore getBlendConfigStateList() {
        return this.blendConfigStateList;
    }

    public void setBlendConfigStateList(BlendConfigStateListCore r1) {
        this.blendConfigStateList = r1;
    }

    public BlendConfigCore[] getBlendConfig() {
        return this.blendConfig;
    }

    public void setBlendConfig(BlendConfigCore[] r1) {
        this.blendConfig = r1;
    }

    public StrokeStateListCore getStrokeStateList() {
        return this.strokeStateList;
    }

    public void setStrokeStateList(StrokeStateListCore r1) {
        this.strokeStateList = r1;
    }

    public StrokeConfigCore getStroke() {
        return this.stroke;
    }

    public void setStroke(StrokeConfigCore r1) {
        this.stroke = r1;
    }

    public BlendConfigStateListCore getOverlayBlendConfigStateList() {
        return this.overlayBlendConfigStateList;
    }

    public void setOverlayBlendConfigStateList(BlendConfigStateListCore r1) {
        this.overlayBlendConfigStateList = r1;
    }

    public BlurConfigCore getBlurConfig() {
        return this.blurConfig;
    }

    public void setBlurConfig(BlurConfigCore r1) {
        this.blurConfig = r1;
    }

    public Float getBlurRadius() {
        return this.blurRadius;
    }

    public void setBlurRadius(Float r1) {
        this.blurRadius = r1;
    }

    public ShadowConfigCore[] getShadow() {
        return this.shadow;
    }

    public void setShadow(ShadowConfigCore[] r1) {
        this.shadow = r1;
    }

    public FluidConfigCore getFluid() {
        return this.fluid;
    }

    public void setFluid(FluidConfigCore r1) {
        this.fluid = r1;
    }

    public MaterialConfigCore deepCopy() {
        ColorStateList r0 = this.fallbackBgColor;
        if (r0 == null) goto L5;
        ColorStateList r2 = r0;
    L6:
        BlendConfigStateListCore r1 = this.blendConfigStateList;
        if (r1 == null) goto L9;
        BlendConfigStateListCore r3 = r1.deepCopy();
    L10:
        BlendConfigCore[] r4 = BlendConfigCore.deepCopy(this.blendConfig);
        StrokeStateListCore r5 = this.strokeStateList;
        if (r5 == null) goto L13;
        StrokeStateListCore r6 = r5.deepCopy();
    L14:
        StrokeConfigCore r7 = this.stroke;
        if (r7 == null) goto L17;
        StrokeConfigCore r8 = r7.deepCopy();
    L18:
        BlendConfigStateListCore r9 = this.overlayBlendConfigStateList;
        if (r9 == null) goto L21;
        BlendConfigStateListCore r10 = r9.deepCopy();
    L22:
        BlurConfigCore r11 = this.blurConfig;
        if (r11 == null) goto L25;
        BlurConfigCore r12 = r11.deepCopy();
    L26:
        Float r13 = this.blurRadius;
        ShadowConfigCore[] r14 = ShadowConfigCore.deepCopy(this.shadow);
        FluidConfigCore r15 = this.fluid;
        if (r15 == null) goto L29;
        FluidConfigCore r16 = r15.deepCopy();
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
}
