package com.obric.oui.banner.configs;

import a.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class GridTriptychBannerConfig implements IBannerConfig {
    public final boolean equals(Object r1) {
        if (this != r1) goto L4;
        return true;
    L4:
        if ((r1 instanceof GridTriptychBannerConfig) == false) goto L8;
        ((GridTriptychBannerConfig) r1).getClass();
        if (Float.compare(0.0f, 0.0f) == 0) goto L13;
        return false;
    L13:
        return true;
    L8:
        return false;
    }

    public final int hashCode() {
        int r2 = a.c(0, Float.hashCode(0.0f) * 31, 31);
        return Integer.hashCode(0) + r2;
    }

    public final String toString() {
        return "GridTriptychBannerConfig(titleTextSize=0.0, gridSpan=0, itemGutter=0)";
    }
}
