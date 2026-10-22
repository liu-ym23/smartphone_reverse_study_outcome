package com.bytedance.common.wschannel.channel.impl.ok.ws;

import a.a;
import okio.Buffer;
import okio.ByteString;

/* JADX INFO: loaded from: classes.dex */
public final class WebSocketProtocol {
    static final String ACCEPT_MAGIC = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
    static final int B0_FLAG_FIN = 128;
    static final int B0_FLAG_RSV1 = 64;
    static final int B0_FLAG_RSV2 = 32;
    static final int B0_FLAG_RSV3 = 16;
    static final int B0_MASK_OPCODE = 15;
    static final int B1_FLAG_MASK = 128;
    static final int B1_MASK_LENGTH = 127;
    static final int CLOSE_CLIENT_GOING_AWAY = 1001;
    static final long CLOSE_MESSAGE_MAX = 123;
    static final int CLOSE_NO_STATUS_CODE = 1005;
    static final int OPCODE_BINARY = 2;
    static final int OPCODE_CONTINUATION = 0;
    static final int OPCODE_CONTROL_CLOSE = 8;
    static final int OPCODE_CONTROL_PING = 9;
    static final int OPCODE_CONTROL_PONG = 10;
    static final int OPCODE_FLAG_CONTROL = 8;
    static final int OPCODE_TEXT = 1;
    static final long PAYLOAD_BYTE_MAX = 125;
    static final int PAYLOAD_LONG = 127;
    static final int PAYLOAD_SHORT = 126;
    static final long PAYLOAD_SHORT_MAX = 65535;

    private WebSocketProtocol() {
        throw new AssertionError("No instances.");
    }

    public static String acceptHeader(String r1) {
        return ByteString.encodeUtf8(r1 + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").sha1().base64();
    }

    public static String closeCodeExceptionMessage(int r2) {
        if (r2 < 1000) goto L20;
        if (r2 >= 5000) goto L20;
        if (r2 < 1004) goto L12;
        if (r2 > 1006) goto L12;
    L16:
        return a.f(r2, "Code ", " is reserved and may not be used.");
    L12:
        if (r2 >= 1012) goto L14;
        return null;
    L14:
        if (r2 <= 2999) goto L16;
        return null;
    L20:
        return a.e(r2, "Code must be in range [1000,5000): ");
    }

    public static void toggleMask(Buffer.UnsafeCursor r7, byte[] r8) {
        int r0 = r8.length;
        int r1 = 0;
    L3:
        byte[] r2 = r7.data;
        int r3 = r7.start;
        int r4 = r7.end;
    L4:
        if (r3 >= r4) goto L7;
        int r5 = r1 % r0;
        r2[r3] = (byte) (r2[r3] ^ r8[r5]);
        r3 = r3 + 1;
        r1 = r5 + 1;
        goto L4
    L7:
        if (r7.next() != (-1)) goto L3;
    }

    public static void validateCloseCode(int r1) {
        String r2 = closeCodeExceptionMessage(r1);
        if (r2 != null) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(r2);
    }
}
