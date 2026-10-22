package com.obric.oui.banner.configs;

import android.icu.text.PluralRules;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GridIndentBannerConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/obric/oui/banner/configs/GridIndentBannerConfig;", "Lcom/obric/oui/banner/configs/IBannerConfig;", "titleTextSizeSp", "", "bannerRatio", "maxHeight", "", "(FFI)V", "getBannerRatio", "()F", "getMaxHeight", "()I", "getTitleTextSizeSp", "component1", "component2", "component3", "copy", "equals", "", PluralRules.KEYWORD_OTHER, "", "hashCode", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GridIndentBannerConfig implements IBannerConfig {
    private final float bannerRatio;
    private final int maxHeight;
    private final float titleTextSizeSp;

    public static /* synthetic */ GridIndentBannerConfig copy$default(GridIndentBannerConfig r0, float r1, float r2, int r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.getTitleTextSizeSp();
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.bannerRatio;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.maxHeight;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final float component1() {
        return getTitleTextSizeSp();
    }

    public final float component2() {
        return this.bannerRatio;
    }

    public final int component3() {
        return this.maxHeight;
    }

    public final GridIndentBannerConfig copy(float r1, float r2, int r3) {
        return new GridIndentBannerConfig(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof GridIndentBannerConfig) == true) goto L8;
        return false;
    L8:
        GridIndentBannerConfig r6 = (GridIndentBannerConfig) r5;
        if (Intrinsics.areEqual(Float.valueOf(getTitleTextSizeSp()), Float.valueOf(r6.getTitleTextSizeSp())) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(Float.valueOf(this.bannerRatio), Float.valueOf(r6.bannerRatio)) == true) goto L15;
        return false;
    L15:
        if (this.maxHeight == r6.maxHeight) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Float.hashCode(getTitleTextSizeSp()) * 31) + Float.hashCode(this.bannerRatio)) * 31) + Integer.hashCode(this.maxHeight);
    }

    public String toString() {
        return "GridIndentBannerConfig(titleTextSizeSp=" + getTitleTextSizeSp() + ", bannerRatio=" + this.bannerRatio + ", maxHeight=" + this.maxHeight + ')';
    }

    public GridIndentBannerConfig(float r1, float r2, int r3) {
        this.titleTextSizeSp = r1;
        this.bannerRatio = r2;
        this.maxHeight = r3;
    }

    public /* synthetic */ GridIndentBannerConfig(float r1, float r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = Integer.MAX_VALUE;
    L5:
        this(r1, r2, r3);
    }

    @Override // com.obric.oui.banner.configs.IBannerConfig
    public float getTitleTextSizeSp() {
        return this.titleTextSizeSp;
    }

    public final float getBannerRatio() {
        return this.bannerRatio;
    }

    public final int getMaxHeight() {
        return this.maxHeight;
    }
}
