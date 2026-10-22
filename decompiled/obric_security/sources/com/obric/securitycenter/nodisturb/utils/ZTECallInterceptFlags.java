package com.obric.securitycenter.nodisturb.utils;

import kotlin.Metadata;

/* JADX INFO: compiled from: SettingsUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/obric/securitycenter/nodisturb/utils/ZTECallInterceptFlags;", "", "mask", "", "(Ljava/lang/String;II)V", "getMask", "()I", "INTERCEPT_OUTSIDE_WHITELIST_MODE", "INTERCEPT_STRANGER_MODE", "INTERCEPT_ANONYMOUS_MODE", "INTERCEPT_ABROAD_NUMBER_MODE", "INTERCEPT_VIRTUAL_OPERATOR_MODE", "INTERCEPT_BLACK_LIST_MODE", "INTERCEPT_NUMBER_SEGMENT_MODE", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum ZTECallInterceptFlags extends Enum<ZTECallInterceptFlags> {
    private static final /* synthetic */ ZTECallInterceptFlags[] $VALUES = null;
    public static final ZTECallInterceptFlags INTERCEPT_ABROAD_NUMBER_MODE = null;
    public static final ZTECallInterceptFlags INTERCEPT_ANONYMOUS_MODE = null;
    public static final ZTECallInterceptFlags INTERCEPT_BLACK_LIST_MODE = null;
    public static final ZTECallInterceptFlags INTERCEPT_NUMBER_SEGMENT_MODE = null;
    public static final ZTECallInterceptFlags INTERCEPT_OUTSIDE_WHITELIST_MODE = null;
    public static final ZTECallInterceptFlags INTERCEPT_STRANGER_MODE = null;
    public static final ZTECallInterceptFlags INTERCEPT_VIRTUAL_OPERATOR_MODE = null;
    private final int mask;

    private static final /* synthetic */ ZTECallInterceptFlags[] $values() {
        return new ZTECallInterceptFlags[]{INTERCEPT_OUTSIDE_WHITELIST_MODE, INTERCEPT_STRANGER_MODE, INTERCEPT_ANONYMOUS_MODE, INTERCEPT_ABROAD_NUMBER_MODE, INTERCEPT_VIRTUAL_OPERATOR_MODE, INTERCEPT_BLACK_LIST_MODE, INTERCEPT_NUMBER_SEGMENT_MODE};
    }

    public static ZTECallInterceptFlags valueOf(String r1) {
        return (ZTECallInterceptFlags) Enum.valueOf(ZTECallInterceptFlags.class, r1);
    }

    public static ZTECallInterceptFlags[] values() {
        return (ZTECallInterceptFlags[]) $VALUES.clone();
    }

    private ZTECallInterceptFlags(String r1, int r2, int r3) {
        super(r1, r2);
        this.mask = r3;
    }

    public final int getMask() {
        return this.mask;
    }

    static {
        INTERCEPT_OUTSIDE_WHITELIST_MODE = new ZTECallInterceptFlags("INTERCEPT_OUTSIDE_WHITELIST_MODE", 0, 256);
        INTERCEPT_STRANGER_MODE = new ZTECallInterceptFlags("INTERCEPT_STRANGER_MODE", 1, 4);
        INTERCEPT_ANONYMOUS_MODE = new ZTECallInterceptFlags("INTERCEPT_ANONYMOUS_MODE", 2, 8);
        INTERCEPT_ABROAD_NUMBER_MODE = new ZTECallInterceptFlags("INTERCEPT_ABROAD_NUMBER_MODE", 3, 64);
        INTERCEPT_VIRTUAL_OPERATOR_MODE = new ZTECallInterceptFlags("INTERCEPT_VIRTUAL_OPERATOR_MODE", 4, 16384);
        INTERCEPT_BLACK_LIST_MODE = new ZTECallInterceptFlags("INTERCEPT_BLACK_LIST_MODE", 5, 2);
        INTERCEPT_NUMBER_SEGMENT_MODE = new ZTECallInterceptFlags("INTERCEPT_NUMBER_SEGMENT_MODE", 6, 32);
        $VALUES = $values();
    }
}
