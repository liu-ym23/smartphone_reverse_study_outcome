package com.obric.oui.banner;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final enum BannerStyle extends Enum<BannerStyle> {
    public static final /* synthetic */ BannerStyle[] b = null;

    static {
        b = new BannerStyle[]{new BannerStyle("FILL", 0), new BannerStyle("INDENT", 1), new BannerStyle("TRIPTYCH", 2)};
    }

    public static BannerStyle valueOf(String r1) {
        return (BannerStyle) Enum.valueOf(BannerStyle.class, r1);
    }

    public static BannerStyle[] values() {
        return (BannerStyle[]) b.clone();
    }
}
