package com.obric.securitycenter.nodisturb.utils;

import kotlin.Metadata;

/* JADX INFO: compiled from: SettingsUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/obric/securitycenter/nodisturb/utils/ZTESMSInterceptFlags;", "", "mask", "", "(Ljava/lang/String;II)V", "getMask", "()I", "INTELLI_MODE", "INTERCEPT_BLACK_LIST_MODE", "INTERCEPT_STRANGER_MODE", "INTERCEPT_ANONYMOUS_MODE", "INTERCEPT_KEY_WORD_MODE", "INTERCEPT_NUMBER_SEGMENT_MODE", "INTERCEPT_ABROAD_NUMBER_MODE", "INTELLI_MODE_ADS", "INTERCEPT_OUTSIDE_WHITELIST_MODE", "INTELLI_MODE_ADS_FINANCIAL", "INTELLI_MODE_ADS_OPERATOR", "INTELLI_MODE_ADS_PROMOTION", "INTELLI_MODE_ADS_OTHER", "INTELLI_MODE_SMART_INTERCEPT_LING_XI", "INTERCEPT_VIRTUAL_OPERATOR_MODE", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum ZTESMSInterceptFlags extends Enum<ZTESMSInterceptFlags> {
    private static final /* synthetic */ ZTESMSInterceptFlags[] $VALUES = null;
    public static final ZTESMSInterceptFlags INTELLI_MODE = null;
    public static final ZTESMSInterceptFlags INTELLI_MODE_ADS = null;
    public static final ZTESMSInterceptFlags INTELLI_MODE_ADS_FINANCIAL = null;
    public static final ZTESMSInterceptFlags INTELLI_MODE_ADS_OPERATOR = null;
    public static final ZTESMSInterceptFlags INTELLI_MODE_ADS_OTHER = null;
    public static final ZTESMSInterceptFlags INTELLI_MODE_ADS_PROMOTION = null;
    public static final ZTESMSInterceptFlags INTELLI_MODE_SMART_INTERCEPT_LING_XI = null;
    public static final ZTESMSInterceptFlags INTERCEPT_ABROAD_NUMBER_MODE = null;
    public static final ZTESMSInterceptFlags INTERCEPT_ANONYMOUS_MODE = null;
    public static final ZTESMSInterceptFlags INTERCEPT_BLACK_LIST_MODE = null;
    public static final ZTESMSInterceptFlags INTERCEPT_KEY_WORD_MODE = null;
    public static final ZTESMSInterceptFlags INTERCEPT_NUMBER_SEGMENT_MODE = null;
    public static final ZTESMSInterceptFlags INTERCEPT_OUTSIDE_WHITELIST_MODE = null;
    public static final ZTESMSInterceptFlags INTERCEPT_STRANGER_MODE = null;
    public static final ZTESMSInterceptFlags INTERCEPT_VIRTUAL_OPERATOR_MODE = null;
    private final int mask;

    private static final /* synthetic */ ZTESMSInterceptFlags[] $values() {
        return new ZTESMSInterceptFlags[]{INTELLI_MODE, INTERCEPT_BLACK_LIST_MODE, INTERCEPT_STRANGER_MODE, INTERCEPT_ANONYMOUS_MODE, INTERCEPT_KEY_WORD_MODE, INTERCEPT_NUMBER_SEGMENT_MODE, INTERCEPT_ABROAD_NUMBER_MODE, INTELLI_MODE_ADS, INTERCEPT_OUTSIDE_WHITELIST_MODE, INTELLI_MODE_ADS_FINANCIAL, INTELLI_MODE_ADS_OPERATOR, INTELLI_MODE_ADS_PROMOTION, INTELLI_MODE_ADS_OTHER, INTELLI_MODE_SMART_INTERCEPT_LING_XI, INTERCEPT_VIRTUAL_OPERATOR_MODE};
    }

    public static ZTESMSInterceptFlags valueOf(String r1) {
        return (ZTESMSInterceptFlags) Enum.valueOf(ZTESMSInterceptFlags.class, r1);
    }

    public static ZTESMSInterceptFlags[] values() {
        return (ZTESMSInterceptFlags[]) $VALUES.clone();
    }

    private ZTESMSInterceptFlags(String r1, int r2, int r3) {
        super(r1, r2);
        this.mask = r3;
    }

    public final int getMask() {
        return this.mask;
    }

    static {
        INTELLI_MODE = new ZTESMSInterceptFlags("INTELLI_MODE", 0, 1);
        INTERCEPT_BLACK_LIST_MODE = new ZTESMSInterceptFlags("INTERCEPT_BLACK_LIST_MODE", 1, 2);
        INTERCEPT_STRANGER_MODE = new ZTESMSInterceptFlags("INTERCEPT_STRANGER_MODE", 2, 4);
        INTERCEPT_ANONYMOUS_MODE = new ZTESMSInterceptFlags("INTERCEPT_ANONYMOUS_MODE", 3, 8);
        INTERCEPT_KEY_WORD_MODE = new ZTESMSInterceptFlags("INTERCEPT_KEY_WORD_MODE", 4, 16);
        INTERCEPT_NUMBER_SEGMENT_MODE = new ZTESMSInterceptFlags("INTERCEPT_NUMBER_SEGMENT_MODE", 5, 32);
        INTERCEPT_ABROAD_NUMBER_MODE = new ZTESMSInterceptFlags("INTERCEPT_ABROAD_NUMBER_MODE", 6, 64);
        INTELLI_MODE_ADS = new ZTESMSInterceptFlags("INTELLI_MODE_ADS", 7, 128);
        INTERCEPT_OUTSIDE_WHITELIST_MODE = new ZTESMSInterceptFlags("INTERCEPT_OUTSIDE_WHITELIST_MODE", 8, 256);
        INTELLI_MODE_ADS_FINANCIAL = new ZTESMSInterceptFlags("INTELLI_MODE_ADS_FINANCIAL", 9, 512);
        INTELLI_MODE_ADS_OPERATOR = new ZTESMSInterceptFlags("INTELLI_MODE_ADS_OPERATOR", 10, 1024);
        INTELLI_MODE_ADS_PROMOTION = new ZTESMSInterceptFlags("INTELLI_MODE_ADS_PROMOTION", 11, 2048);
        INTELLI_MODE_ADS_OTHER = new ZTESMSInterceptFlags("INTELLI_MODE_ADS_OTHER", 12, 4096);
        INTELLI_MODE_SMART_INTERCEPT_LING_XI = new ZTESMSInterceptFlags("INTELLI_MODE_SMART_INTERCEPT_LING_XI", 13, 8192);
        INTERCEPT_VIRTUAL_OPERATOR_MODE = new ZTESMSInterceptFlags("INTERCEPT_VIRTUAL_OPERATOR_MODE", 14, 16384);
        $VALUES = $values();
    }
}
