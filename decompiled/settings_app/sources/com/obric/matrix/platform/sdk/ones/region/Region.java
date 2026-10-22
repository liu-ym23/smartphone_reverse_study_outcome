package com.obric.matrix.platform.sdk.ones.region;

import kotlin.Metadata;

/* JADX INFO: compiled from: RegionUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/region/Region;", "", "(Ljava/lang/String;I)V", "HK", "CN", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum Region extends Enum<Region> {
    private static final /* synthetic */ Region[] $VALUES = null;
    public static final Region CN = null;
    public static final Region HK = null;

    private static final /* synthetic */ Region[] $values() {
        return new Region[]{HK, CN};
    }

    public static Region valueOf(String r1) {
        return (Region) Enum.valueOf(Region.class, r1);
    }

    public static Region[] values() {
        return (Region[]) $VALUES.clone();
    }

    private Region(String r1, int r2) {
        super(r1, r2);
    }

    static {
        HK = new Region("HK", 0);
        CN = new Region("CN", 1);
        $VALUES = $values();
    }
}
