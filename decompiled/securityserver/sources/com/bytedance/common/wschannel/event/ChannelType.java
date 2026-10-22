package com.bytedance.common.wschannel.event;

import a.a;

/* JADX INFO: loaded from: classes.dex */
public final enum ChannelType extends Enum<ChannelType> {
    private static final /* synthetic */ ChannelType[] $VALUES = null;
    public static final ChannelType CHANNEL_OK = null;
    public static final ChannelType CHANNEL_SELF = null;
    int mTypeValue;

    static {
        ChannelType r0 = new ChannelType("CHANNEL_SELF", 0, 1);
        CHANNEL_SELF = r0;
        ChannelType r1 = new ChannelType("CHANNEL_OK", 1, 2);
        CHANNEL_OK = r1;
        $VALUES = new ChannelType[]{r0, r1};
    }

    private ChannelType(String r1, int r2, int r3) {
        super(r1, r2);
        this.mTypeValue = r3;
    }

    public static ChannelType of(int r1) {
        if (r1 != 1) goto L7;
        return CHANNEL_SELF;
    L7:
        return CHANNEL_OK;
    }

    public static ChannelType valueOf(String r1) {
        return (ChannelType) Enum.valueOf(ChannelType.class, r1);
    }

    public static ChannelType[] values() {
        return (ChannelType[]) $VALUES.clone();
    }

    public int getVal() {
        return this.mTypeValue;
    }

    @Override // java.lang.Enum
    public String toString() {
        return a.l(new StringBuilder("ChannelType{Type="), this.mTypeValue, '}');
    }
}
