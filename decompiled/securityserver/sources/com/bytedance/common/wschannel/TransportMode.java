package com.bytedance.common.wschannel;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final enum TransportMode extends Enum<TransportMode> {
    private static final /* synthetic */ TransportMode[] $VALUES = null;
    public static final TransportMode HTTP2 = null;
    public static final TransportMode TLS = null;
    public static final TransportMode TLS_PROXY = null;
    public static final TransportMode TUDP = null;
    public static final TransportMode TUDP_PROXY = null;
    final int mTypeValue;

    static {
        TransportMode r0 = new TransportMode("TUDP", 0, 0);
        TUDP = r0;
        TransportMode r1 = new TransportMode("TLS", 1, 1);
        TLS = r1;
        TransportMode r2 = new TransportMode("HTTP2", 2, 2);
        HTTP2 = r2;
        TransportMode r3 = new TransportMode("TUDP_PROXY", 3, 3);
        TUDP_PROXY = r3;
        TransportMode r4 = new TransportMode("TLS_PROXY", 4, 4);
        TLS_PROXY = r4;
        $VALUES = new TransportMode[]{r0, r1, r2, r3, r4};
    }

    private TransportMode(String r1, int r2, int r3) {
        super(r1, r2);
        this.mTypeValue = r3;
    }

    @Nullable
    public static TransportMode convertToMode() {
        return null;
    }

    public static TransportMode valueOf(String r1) {
        return (TransportMode) Enum.valueOf(TransportMode.class, r1);
    }

    public static TransportMode[] values() {
        return (TransportMode[]) $VALUES.clone();
    }

    public int getTypeValue() {
        return this.mTypeValue;
    }
}
