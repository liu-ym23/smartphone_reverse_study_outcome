package com.obric.securitycenter.nodisturb.utils;

import kotlin.Metadata;

/* JADX INFO: compiled from: SettingsUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/obric/securitycenter/nodisturb/utils/ZTECallMarkInterceptFlags;", "", "mask", "", "(Ljava/lang/String;II)V", "getMask", "()I", "MARK_TYPE_CRANK_CALL_FLAG", "MARK_TYPE_SUSPECTED_FRAUD_FLAG", "MARK_TYPE_PROMOTE_FLAG", "MARK_TYPE_INTERMEDIARY_FLAG", "MARK_TYPE_REPEAT_CALL_NOT_WARNING_FLAG", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum ZTECallMarkInterceptFlags extends Enum<ZTECallMarkInterceptFlags> {
    private static final /* synthetic */ ZTECallMarkInterceptFlags[] $VALUES = null;
    public static final ZTECallMarkInterceptFlags MARK_TYPE_CRANK_CALL_FLAG = null;
    public static final ZTECallMarkInterceptFlags MARK_TYPE_INTERMEDIARY_FLAG = null;
    public static final ZTECallMarkInterceptFlags MARK_TYPE_PROMOTE_FLAG = null;
    public static final ZTECallMarkInterceptFlags MARK_TYPE_REPEAT_CALL_NOT_WARNING_FLAG = null;
    public static final ZTECallMarkInterceptFlags MARK_TYPE_SUSPECTED_FRAUD_FLAG = null;
    private final int mask;

    private static final /* synthetic */ ZTECallMarkInterceptFlags[] $values() {
        return new ZTECallMarkInterceptFlags[]{MARK_TYPE_CRANK_CALL_FLAG, MARK_TYPE_SUSPECTED_FRAUD_FLAG, MARK_TYPE_PROMOTE_FLAG, MARK_TYPE_INTERMEDIARY_FLAG, MARK_TYPE_REPEAT_CALL_NOT_WARNING_FLAG};
    }

    public static ZTECallMarkInterceptFlags valueOf(String r1) {
        return (ZTECallMarkInterceptFlags) Enum.valueOf(ZTECallMarkInterceptFlags.class, r1);
    }

    public static ZTECallMarkInterceptFlags[] values() {
        return (ZTECallMarkInterceptFlags[]) $VALUES.clone();
    }

    private ZTECallMarkInterceptFlags(String r1, int r2, int r3) {
        super(r1, r2);
        this.mask = r3;
    }

    public final int getMask() {
        return this.mask;
    }

    static {
        MARK_TYPE_CRANK_CALL_FLAG = new ZTECallMarkInterceptFlags("MARK_TYPE_CRANK_CALL_FLAG", 0, 2);
        MARK_TYPE_SUSPECTED_FRAUD_FLAG = new ZTECallMarkInterceptFlags("MARK_TYPE_SUSPECTED_FRAUD_FLAG", 1, 32);
        MARK_TYPE_PROMOTE_FLAG = new ZTECallMarkInterceptFlags("MARK_TYPE_PROMOTE_FLAG", 2, 4);
        MARK_TYPE_INTERMEDIARY_FLAG = new ZTECallMarkInterceptFlags("MARK_TYPE_INTERMEDIARY_FLAG", 3, 8);
        MARK_TYPE_REPEAT_CALL_NOT_WARNING_FLAG = new ZTECallMarkInterceptFlags("MARK_TYPE_REPEAT_CALL_NOT_WARNING_FLAG", 4, 4096);
        $VALUES = $values();
    }
}
