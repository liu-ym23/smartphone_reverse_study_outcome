package com.obric.matrix.proto;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;

/* JADX INFO: loaded from: classes4.dex */
public final enum NETWORK_METHOD extends Enum<NETWORK_METHOD> implements WireEnum {
    private static final /* synthetic */ NETWORK_METHOD[] $VALUES = null;
    public static final ProtoAdapter<NETWORK_METHOD> ADAPTER = null;
    public static final NETWORK_METHOD METHOD_GET = null;
    public static final NETWORK_METHOD METHOD_POST = null;
    private final int value;

    public static NETWORK_METHOD valueOf(String r1) {
        return (NETWORK_METHOD) Enum.valueOf(NETWORK_METHOD.class, r1);
    }

    public static NETWORK_METHOD[] values() {
        return (NETWORK_METHOD[]) $VALUES.clone();
    }

    static {
        NETWORK_METHOD r0 = new NETWORK_METHOD("METHOD_GET", 0, 0);
        METHOD_GET = r0;
        NETWORK_METHOD r1 = new NETWORK_METHOD("METHOD_POST", 1, 1);
        METHOD_POST = r1;
        $VALUES = new NETWORK_METHOD[]{r0, r1};
        ADAPTER = new ProtoAdapter_NETWORK_METHOD();
    }

    private NETWORK_METHOD(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static NETWORK_METHOD fromValue(int r1) {
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L8;
        return null;
    L8:
        return METHOD_POST;
    L10:
        return METHOD_GET;
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }
}
