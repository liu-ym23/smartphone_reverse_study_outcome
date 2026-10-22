package com.obric.oui.banner.configs;

import a.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class GridFillBannerConfig implements IBannerConfig {
    public final boolean equals(Object r1) {
        if (this != r1) goto L4;
        return true;
    L4:
        if ((r1 instanceof GridFillBannerConfig) == false) goto L10;
        ((GridFillBannerConfig) r1).getClass();
        if (Float.compare(0.0f, 0.0f) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(0.0f, 0.0f) == 0) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r2 = a.b(0.0f, Float.hashCode(0.0f) * 31, 31);
        return Integer.hashCode(0) + r2;
    }

    public final String toString() {
        return "GridFillBannerConfig(titleTextSize=0.0, bannerRatio=0.0, maxHeight=0)";
    }
}
