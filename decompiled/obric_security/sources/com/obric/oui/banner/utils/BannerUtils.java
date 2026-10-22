package com.obric.oui.banner.utils;

import kotlin.Metadata;

/* JADX INFO: compiled from: BannerUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004¨\u0006\t"}, d2 = {"Lcom/obric/oui/banner/utils/BannerUtils;", "", "()V", "getRealPosition", "", "isIncrease", "", "position", "realCount", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BannerUtils {
    public static final BannerUtils INSTANCE = null;

    static {
        INSTANCE = new BannerUtils();
    }

    private BannerUtils() {
    }

    public final int getRealPosition(boolean r1, int r2, int r3) {
        if (r1 == false) goto L9;
        if (r3 > 0) goto L8;
        r3 = 1;
    L8:
        return r2 % r3;
    L9:
        return r2;
    }
}
