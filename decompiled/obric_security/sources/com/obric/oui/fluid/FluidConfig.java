package com.obric.oui.fluid;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FluidConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0014\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0006\u0010\t\u001a\u00020\u0000J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u0000J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\r\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u0012J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/obric/oui/fluid/FluidConfig;", "", "glassParams", "", "([F)V", "getGlassParams", "()[F", "setGlassParams", "component1", "copy", "deepCopy", "equals", "", "other", "hashCode", "", "toCore", "Lcom/obric/oui/fluid/FluidConfigCore;", "toCore$OUI_standardRelease", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FluidConfig {
    private float[] glassParams;

    /* JADX WARN: Multi-variable type inference failed */
    public FluidConfig() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ FluidConfig copy$default(FluidConfig r0, float[] r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.glassParams;
    L6:
        return r0.copy(r1);
    }

    public final float[] component1() {
        return this.glassParams;
    }

    public final FluidConfig copy(float[] r1) {
        return new FluidConfig(r1);
    }

    public String toString() {
        return "FluidConfig(glassParams=" + Arrays.toString(this.glassParams) + ')';
    }

    public FluidConfig(float[] r1) {
        this.glassParams = r1;
    }

    public /* synthetic */ FluidConfig(float[] r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }

    public final float[] getGlassParams() {
        return this.glassParams;
    }

    public final void setGlassParams(float[] r1) {
        this.glassParams = r1;
    }

    public final FluidConfigCore toCore$OUI_standardRelease() {
        return new FluidConfigCore(this.glassParams);
    }

    public final FluidConfig deepCopy() {
        return new FluidConfig(FluidConfigCore.deepCopy(toCore$OUI_standardRelease()).getGlassParams());
    }

    public final FluidConfig copy() {
        return deepCopy();
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L5;
        return true;
    L5:
        Class<?> r1 = getClass();
        if (r4 != null) goto L8;
        Class<?> r2 = null;
    L10:
        if (Intrinsics.areEqual(r1, r2) == true) goto L12;
        return false;
    L12:
        if (r4 == null) goto L18;
        if (Arrays.equals(this.glassParams, ((FluidConfig) r4).glassParams) == true) goto L16;
        return false;
    L16:
        return true;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.fluid.FluidConfig");
    L8:
        r2 = r4.getClass();
        goto L10
    }

    public int hashCode() {
        float[] r0 = this.glassParams;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return Arrays.hashCode(r0);
    }
}
