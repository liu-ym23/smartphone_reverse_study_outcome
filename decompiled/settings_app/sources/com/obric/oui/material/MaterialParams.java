package com.obric.oui.material;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MaterialParams.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0015\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\"\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\u0010\f\u001a\u00020\r\"\u00020\tJ\u0012\u0010\u0006\u001a\u00020\u00072\n\u0010\f\u001a\u00020\r\"\u00020\tJ\u0012\u0010\u000e\u001a\u00020\u00072\n\u0010\f\u001a\u00020\r\"\u00020\tJ\u000e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000bJ.\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\tJ\u0016\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\tJ\u000e\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0018JB\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000bH\u0007R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u001f"}, d2 = {"Lcom/obric/oui/material/MaterialParams;", "", "proxy", "(Ljava/lang/Object;)V", "getProxy", "()Ljava/lang/Object;", "setObricBlendEffect", "", "curveType", "", "endPoint", "", "blendColors", "", "setObricBlendEffectToShadow", "setObricBlurEffect", "blurRadius", "blurAlpha", "blurDirection", "setObricEffectSource", "sourceType", "drawMode", "setObricLiquidGlassEffectRR", "enable", "", "refractionHeight", "refractionAmount", "highlightAngle", "highlightFalloff", "highlightWidth", "highlightOpacity", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MaterialParams {
    private final Object proxy;

    public final void setObricLiquidGlassEffectRR(float r11, float r12, float r13, float r14, float r15, float r16) {
        setObricLiquidGlassEffectRR$default(this, false, r11, r12, r13, r14, r15, r16, 1, null);
    }

    public MaterialParams(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "proxy");
        this.proxy = r2;
    }

    public final Object getProxy() {
        return this.proxy;
    }

    public final void setObricEffectSource(int r1) {
        OMaterialHelper.setEffectSrcAndDraw(this.proxy, r1);
    }

    public final void setObricEffectSource(int r1, int r2) {
        OMaterialHelper.setEffectSrcAndDraw(this.proxy, r1, r2);
    }

    public final void setObricBlurEffect(float r1) {
        OMaterialHelper.setBlurEffect(this.proxy, r1);
    }

    public final void setObricBlurEffect(float r7, float r8, int r9, int r10, float r11) {
        OMaterialHelper.setBlurEffect(this.proxy, r7, r8, r9, r10, r11);
    }

    public final void setObricBlendEffect(int... r2) {
        Intrinsics.checkNotNullParameter(r2, "blendColors");
        OMaterialHelper.setBlendEffect(this.proxy, Arrays.copyOf(r2, r2.length));
    }

    public final void setObricBlendEffect(int r2, float r3, int... r4) {
        Intrinsics.checkNotNullParameter(r4, "blendColors");
        OMaterialHelper.setBlendEffect(this.proxy, r2, r3, Arrays.copyOf(r4, r4.length));
    }

    public final void setObricBlendEffectToShadow(int... r2) {
        Intrinsics.checkNotNullParameter(r2, "blendColors");
        OMaterialHelper.setBlendEffectToShadow(this.proxy, Arrays.copyOf(r2, r2.length));
    }

    public final void setObricLiquidGlassEffectRR(boolean r1) {
        OMaterialHelper.setFluidEffect(this.proxy, r1);
    }

    public static /* synthetic */ void setObricLiquidGlassEffectRR$default(MaterialParams r10, boolean r11, float r12, float r13, float r14, float r15, float r16, float r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        boolean r3 = true;
    L6:
        r10.setObricLiquidGlassEffectRR(r3, r12, r13, r14, r15, r16, r17);
        return;
    L5:
        r3 = r11;
        goto L6
    }

    public final void setObricLiquidGlassEffectRR(boolean r3, float r4, float r5, float r6, float r7, float r8, float r9) {
        OMaterialHelper.setFluidEffect(this.proxy, r3, new float[]{r4, r5, r6, r7, r8, r9});
    }
}
