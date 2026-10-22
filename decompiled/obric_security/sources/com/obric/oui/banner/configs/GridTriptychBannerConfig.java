package com.obric.oui.banner.configs;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GridTriptychBannerConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/obric/oui/banner/configs/GridTriptychBannerConfig;", "Lcom/obric/oui/banner/configs/IBannerConfig;", "titleTextSizeSp", "", "gridSpan", "", "itemGutterDp", "(FII)V", "getGridSpan", "()I", "getItemGutterDp", "getTitleTextSizeSp", "()F", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GridTriptychBannerConfig implements IBannerConfig {
    private final int gridSpan;
    private final int itemGutterDp;
    private final float titleTextSizeSp;

    public static /* synthetic */ GridTriptychBannerConfig copy$default(GridTriptychBannerConfig r0, float r1, int r2, int r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.getTitleTextSizeSp();
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.gridSpan;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.itemGutterDp;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final float component1() {
        return getTitleTextSizeSp();
    }

    public final int component2() {
        return this.gridSpan;
    }

    public final int component3() {
        return this.itemGutterDp;
    }

    public final GridTriptychBannerConfig copy(float r1, int r2, int r3) {
        return new GridTriptychBannerConfig(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof GridTriptychBannerConfig) == true) goto L8;
        return false;
    L8:
        GridTriptychBannerConfig r6 = (GridTriptychBannerConfig) r5;
        if (Intrinsics.areEqual(Float.valueOf(getTitleTextSizeSp()), Float.valueOf(r6.getTitleTextSizeSp())) == true) goto L12;
        return false;
    L12:
        if (this.gridSpan == r6.gridSpan) goto L15;
        return false;
    L15:
        if (this.itemGutterDp == r6.itemGutterDp) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Float.hashCode(getTitleTextSizeSp()) * 31) + Integer.hashCode(this.gridSpan)) * 31) + Integer.hashCode(this.itemGutterDp);
    }

    public String toString() {
        return "GridTriptychBannerConfig(titleTextSizeSp=" + getTitleTextSizeSp() + ", gridSpan=" + this.gridSpan + ", itemGutterDp=" + this.itemGutterDp + ')';
    }

    public GridTriptychBannerConfig(float r1, int r2, int r3) {
        this.titleTextSizeSp = r1;
        this.gridSpan = r2;
        this.itemGutterDp = r3;
    }

    public /* synthetic */ GridTriptychBannerConfig(float r1, int r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = 8;
    L5:
        this(r1, r2, r3);
    }

    @Override // com.obric.oui.banner.configs.IBannerConfig
    public float getTitleTextSizeSp() {
        return this.titleTextSizeSp;
    }

    public final int getGridSpan() {
        return this.gridSpan;
    }

    public final int getItemGutterDp() {
        return this.itemGutterDp;
    }
}
