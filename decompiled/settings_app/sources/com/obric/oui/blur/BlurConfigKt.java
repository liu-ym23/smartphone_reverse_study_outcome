package com.obric.oui.blur;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BlurConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"toConfig", "Lcom/obric/oui/blur/BlurConfig;", "Lcom/obric/oui/blur/BlurConfigCore;", "OUI_standardRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class BlurConfigKt {
    public static final BlurConfig toConfig(BlurConfigCore r7) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        return new BlurConfig(r7.getBlurRadius(), r7.getDirection(), r7.getAlpha(), r7.getCurveType(), r7.getEndPoint());
    }
}
