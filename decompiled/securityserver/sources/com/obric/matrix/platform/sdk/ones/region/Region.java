package com.obric.matrix.platform.sdk.ones.region;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final enum Region extends Enum<Region> {
    private static final /* synthetic */ Region[] $VALUES = null;
    public static final Region CN = null;
    public static final Region HK = null;

    private static final /* synthetic */ Region[] $values() {
        return new Region[]{HK, CN};
    }

    static {
        HK = new Region("HK", 0);
        CN = new Region("CN", 1);
        $VALUES = $values();
    }

    private Region(String r1, int r2) {
        super(r1, r2);
    }

    public static Region valueOf(String r1) {
        return (Region) Enum.valueOf(Region.class, r1);
    }

    public static Region[] values() {
        return (Region[]) $VALUES.clone();
    }
}
