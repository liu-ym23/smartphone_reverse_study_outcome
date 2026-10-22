package com.obric.oui.fluid;

/* JADX INFO: loaded from: classes4.dex */
public final class FluidConfigCore {
    private float[] glassParams;

    public FluidConfigCore() {
        this(null);
    }

    public FluidConfigCore(float[] r1) {
        this.glassParams = r1;
    }

    public float[] getGlassParams() {
        return this.glassParams;
    }

    public void setGlassParams(float[] r1) {
        this.glassParams = r1;
    }

    public FluidConfigCore deepCopy() {
        return deepCopy(this);
    }

    public static FluidConfigCore deepCopy(FluidConfigCore r2) {
        float[] r0 = null;
        if (r2 != null) goto L5;
        return null;
    L5:
        float[] r3 = r2.glassParams;
        if (r3 == null) goto L9;
        r0 = (float[]) r3.clone();
    L9:
        return new FluidConfigCore(r0);
    }
}
