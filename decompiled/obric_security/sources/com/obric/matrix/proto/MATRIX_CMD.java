package com.obric.matrix.proto;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;

/* JADX INFO: loaded from: classes3.dex */
public final enum MATRIX_CMD extends Enum<MATRIX_CMD> implements WireEnum {
    private static final /* synthetic */ MATRIX_CMD[] $VALUES = null;
    public static final ProtoAdapter<MATRIX_CMD> ADAPTER = null;
    public static final MATRIX_CMD CMD_BIZ_EXAMPLE = null;
    public static final MATRIX_CMD CMD_DECODE_LOCATION = null;
    public static final MATRIX_CMD CMD_GET_INTERSECT_FENCES = null;
    public static final MATRIX_CMD CMD_GET_LOCATION = null;
    public static final MATRIX_CMD CMD_GET_TTNET_PARAMETERS = null;
    public static final MATRIX_CMD CMD_NOT_USED = null;
    public static final MATRIX_CMD CMD_PRIVATE_COMMON_NET_REQUEST = null;
    public static final MATRIX_CMD CMD_PRIVATE_PICO_LINKS_CALLBACK = null;
    public static final MATRIX_CMD CMD_PRIVATE_SEND_APPLOG_EVENT = null;
    public static final MATRIX_CMD CMD_PRIVATE_START_PICO_LINKS = null;
    public static final MATRIX_CMD CMD_REFRESH_LOCATION = null;
    public static final MATRIX_CMD CMD_SEND_NETWORK_REQUEST = null;
    public static final MATRIX_CMD CMD_SEND_WS_MESSAGE = null;
    public static final MATRIX_CMD CMD_SUBSCRIBE_WS_MSG = null;
    public static final MATRIX_CMD CMD_SUBSCRIBE_WS_MSG_BY_BROADCAST = null;
    public static final MATRIX_CMD CMD_SUBSCRIBE_WS_MSG_BY_CALLBACK = null;
    public static final MATRIX_CMD CMD_SUBSCRIBE_WS_MSG_PROVIDER = null;
    public static final MATRIX_CMD CMD_SUBSCRIBE_WS_STATUS = null;
    private final int value;

    public static MATRIX_CMD valueOf(String r1) {
        return (MATRIX_CMD) Enum.valueOf(MATRIX_CMD.class, r1);
    }

    public static MATRIX_CMD[] values() {
        return (MATRIX_CMD[]) $VALUES.clone();
    }

    static {
        MATRIX_CMD r0 = new MATRIX_CMD("CMD_NOT_USED", 0, 0);
        CMD_NOT_USED = r0;
        MATRIX_CMD r1 = new MATRIX_CMD("CMD_BIZ_EXAMPLE", 1, 100000);
        CMD_BIZ_EXAMPLE = r1;
        MATRIX_CMD r3 = new MATRIX_CMD("CMD_SEND_WS_MESSAGE", 2, 101001);
        CMD_SEND_WS_MESSAGE = r3;
        MATRIX_CMD r4 = new MATRIX_CMD("CMD_SUBSCRIBE_WS_MSG", 3, 101002);
        CMD_SUBSCRIBE_WS_MSG = r4;
        MATRIX_CMD r6 = new MATRIX_CMD("CMD_SUBSCRIBE_WS_STATUS", 4, 101003);
        CMD_SUBSCRIBE_WS_STATUS = r6;
        MATRIX_CMD r8 = new MATRIX_CMD("CMD_SUBSCRIBE_WS_MSG_PROVIDER", 5, 101004);
        CMD_SUBSCRIBE_WS_MSG_PROVIDER = r8;
        MATRIX_CMD r10 = new MATRIX_CMD("CMD_SUBSCRIBE_WS_MSG_BY_CALLBACK", 6, 101005);
        CMD_SUBSCRIBE_WS_MSG_BY_CALLBACK = r10;
        MATRIX_CMD r12 = new MATRIX_CMD("CMD_SUBSCRIBE_WS_MSG_BY_BROADCAST", 7, 101006);
        CMD_SUBSCRIBE_WS_MSG_BY_BROADCAST = r12;
        MATRIX_CMD r14 = new MATRIX_CMD("CMD_GET_LOCATION", 8, 102001);
        CMD_GET_LOCATION = r14;
        MATRIX_CMD r13 = new MATRIX_CMD("CMD_REFRESH_LOCATION", 9, 102002);
        CMD_REFRESH_LOCATION = r13;
        MATRIX_CMD r11 = new MATRIX_CMD("CMD_DECODE_LOCATION", 10, 102003);
        CMD_DECODE_LOCATION = r11;
        MATRIX_CMD r9 = new MATRIX_CMD("CMD_GET_INTERSECT_FENCES", 11, 102004);
        CMD_GET_INTERSECT_FENCES = r9;
        MATRIX_CMD r7 = new MATRIX_CMD("CMD_PRIVATE_START_PICO_LINKS", 12, 111001);
        CMD_PRIVATE_START_PICO_LINKS = r7;
        MATRIX_CMD r5 = new MATRIX_CMD("CMD_PRIVATE_PICO_LINKS_CALLBACK", 13, 111002);
        CMD_PRIVATE_PICO_LINKS_CALLBACK = r5;
        MATRIX_CMD r2 = new MATRIX_CMD("CMD_PRIVATE_COMMON_NET_REQUEST", 14, 112001);
        CMD_PRIVATE_COMMON_NET_REQUEST = r2;
        MATRIX_CMD r15 = new MATRIX_CMD("CMD_PRIVATE_SEND_APPLOG_EVENT", 15, 112002);
        CMD_PRIVATE_SEND_APPLOG_EVENT = r15;
        MATRIX_CMD r16 = new MATRIX_CMD("CMD_SEND_NETWORK_REQUEST", 16, 112003);
        CMD_SEND_NETWORK_REQUEST = r16;
        MATRIX_CMD r17 = new MATRIX_CMD("CMD_GET_TTNET_PARAMETERS", 17, 112004);
        CMD_GET_TTNET_PARAMETERS = r17;
        $VALUES = new MATRIX_CMD[]{r0, r1, r3, r4, r6, r8, r10, r12, r14, r13, r11, r9, r7, r5, r2, r15, r16, r17};
        ADAPTER = new ProtoAdapter_MATRIX_CMD();
    }

    private MATRIX_CMD(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static MATRIX_CMD fromValue(int r1) {
        if (r1 == 0) goto L46;
        if (r1 == 100000) goto L44;
        switch(r1) {
            case 101001: goto L42;
            case 101002: goto L40;
            case 101003: goto L38;
            case 101004: goto L36;
            case 101005: goto L34;
            case 101006: goto L32;
            default: goto L6;
        };
    L6:
        switch(r1) {
            case 102001: goto L30;
            case 102002: goto L28;
            case 102003: goto L26;
            case 102004: goto L24;
            default: goto L7;
        };
    L7:
        switch(r1) {
            case 111001: goto L22;
            case 111002: goto L20;
            default: goto L8;
        };
    L8:
        switch(r1) {
            case 112001: goto L18;
            case 112002: goto L16;
            case 112003: goto L14;
            case 112004: goto L12;
            default: goto L9;
        };
    L9:
        return null;
    L12:
        return CMD_GET_TTNET_PARAMETERS;
    L14:
        return CMD_SEND_NETWORK_REQUEST;
    L16:
        return CMD_PRIVATE_SEND_APPLOG_EVENT;
    L18:
        return CMD_PRIVATE_COMMON_NET_REQUEST;
    L20:
        return CMD_PRIVATE_PICO_LINKS_CALLBACK;
    L22:
        return CMD_PRIVATE_START_PICO_LINKS;
    L24:
        return CMD_GET_INTERSECT_FENCES;
    L26:
        return CMD_DECODE_LOCATION;
    L28:
        return CMD_REFRESH_LOCATION;
    L30:
        return CMD_GET_LOCATION;
    L32:
        return CMD_SUBSCRIBE_WS_MSG_BY_BROADCAST;
    L34:
        return CMD_SUBSCRIBE_WS_MSG_BY_CALLBACK;
    L36:
        return CMD_SUBSCRIBE_WS_MSG_PROVIDER;
    L38:
        return CMD_SUBSCRIBE_WS_STATUS;
    L40:
        return CMD_SUBSCRIBE_WS_MSG;
    L42:
        return CMD_SEND_WS_MESSAGE;
    L44:
        return CMD_BIZ_EXAMPLE;
    L46:
        return CMD_NOT_USED;
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }
}
