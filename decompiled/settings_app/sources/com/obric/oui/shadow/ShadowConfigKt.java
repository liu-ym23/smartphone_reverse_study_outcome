package com.obric.oui.shadow;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ShadowConfig.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"toConfig", "Lcom/obric/oui/shadow/ShadowConfig;", "Lcom/obric/oui/shadow/ShadowConfigCore;", "OUI_standardRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ShadowConfigKt {
    public static final ShadowConfig toConfig(ShadowConfigCore r8) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        return new ShadowConfig(r8.getX(), r8.getY(), r8.getBlurRadius(), r8.getColor(), r8.getSpread(), r8.getBlendMode());
    }
}
