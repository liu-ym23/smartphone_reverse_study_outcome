package cz.msebera.android.httpclient.conn.util;

import com.bytedance.networkstackapplib.NetworkStackConstant;

/* JADX INFO: loaded from: classes5.dex */
public final enum DomainType extends Enum<DomainType> {
    private static final /* synthetic */ DomainType[] $VALUES = null;
    public static final DomainType ICANN = null;
    public static final DomainType PRIVATE = null;
    public static final DomainType UNKNOWN = null;

    private DomainType(String r1, int r2) {
        super(r1, r2);
    }

    public static DomainType valueOf(String r1) {
        return (DomainType) Enum.valueOf(DomainType.class, r1);
    }

    public static DomainType[] values() {
        return (DomainType[]) $VALUES.clone();
    }

    static {
        DomainType r0 = new DomainType(NetworkStackConstant.UNKNOWN_TYPE, 0);
        UNKNOWN = r0;
        DomainType r1 = new DomainType("ICANN", 1);
        ICANN = r1;
        DomainType r3 = new DomainType("PRIVATE", 2);
        PRIVATE = r3;
        $VALUES = new DomainType[]{r0, r1, r3};
    }
}
