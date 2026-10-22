package com.obric.oui.fluid;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FluidConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"toConfig", "Lcom/obric/oui/fluid/FluidConfig;", "Lcom/obric/oui/fluid/FluidConfigCore;", "OUI_standardRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class FluidConfigKt {
    public static final FluidConfig toConfig(FluidConfigCore r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return new FluidConfig(r1.getGlassParams());
    }
}
