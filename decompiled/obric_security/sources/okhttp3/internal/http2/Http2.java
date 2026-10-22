package okhttp3.internal.http2;

import java.io.IOException;
import okhttp3.internal.Util;
import okio.ByteString;
import tmsdk.common.tcc.DeepCleanSAFEngine;

/* JADX INFO: loaded from: classes5.dex */
public final class Http2 {
    static final String[] BINARY = null;
    static final ByteString CONNECTION_PREFACE = null;
    static final String[] FLAGS = null;
    static final byte FLAG_ACK = 1;
    static final byte FLAG_COMPRESSED = 32;
    static final byte FLAG_END_HEADERS = 4;
    static final byte FLAG_END_PUSH_PROMISE = 4;
    static final byte FLAG_END_STREAM = 1;
    static final byte FLAG_NONE = 0;
    static final byte FLAG_PADDED = 8;
    static final byte FLAG_PRIORITY = 32;
    private static final String[] FRAME_NAMES = null;
    static final int INITIAL_MAX_FRAME_SIZE = 16384;
    static final byte TYPE_CONTINUATION = 9;
    static final byte TYPE_DATA = 0;
    static final byte TYPE_GOAWAY = 7;
    static final byte TYPE_HEADERS = 1;
    static final byte TYPE_PING = 6;
    static final byte TYPE_PRIORITY = 2;
    static final byte TYPE_PUSH_PROMISE = 5;
    static final byte TYPE_RST_STREAM = 3;
    static final byte TYPE_SETTINGS = 4;
    static final byte TYPE_WINDOW_UPDATE = 8;

    static {
        CONNECTION_PREFACE = ByteString.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
        FRAME_NAMES = new String[]{"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
        FLAGS = new String[64];
        BINARY = new String[256];
        int r0 = 0;
        int r1 = 0;
    L3:
        String[] r2 = BINARY;
        if (r1 >= r2.length) goto L6;
        r2[r1] = Util.format("%8s", new Object[]{Integer.toBinaryString(r1)}).replace(' ', DeepCleanSAFEngine.DetailPath.KEY);
        r1 = r1 + 1;
        goto L3
    L6:
        String[] r3 = FLAGS;
        r3[0] = "";
        r3[1] = "END_STREAM";
        int[] r4 = {1};
        r3[8] = "PADDED";
        r3[1 | 8] = r3[1] + "|PADDED";
        r3[4] = "END_HEADERS";
        r3[32] = "PRIORITY";
        r3[36] = "END_HEADERS|PRIORITY";
        int[] r5 = {4, 32, 36};
        int r6 = 0;
    L7:
        if (r6 >= 3) goto L9;
        int r7 = r5[r6];
        int r8 = r4[0];
        String[] r9 = FLAGS;
        int r10 = r8 | r7;
        r9[r10] = r9[r8] + '|' + r9[r7];
        r9[r10 | 8] = r9[r8] + '|' + r9[r7] + "|PADDED";
        r6 = r6 + 1;
    L9:
        String[] r11 = FLAGS;
        if (r0 >= r11.length) goto L15;
        if (r11[r0] != null) goto L14;
        r11[r0] = BINARY[r0];
    L14:
        r0 = r0 + 1;
        goto L9
    }

    private Http2() {
    }

    static IllegalArgumentException illegalArgument(String r1, Object... r2) {
        throw new IllegalArgumentException(Util.format(r1, r2));
    }

    static IOException ioException(String r1, Object... r2) throws IOException {
        throw new IOException(Util.format(r1, r2));
    }

    static String frameLog(boolean r4, int r5, int r6, byte r7, byte r8) {
        String[] r0 = FRAME_NAMES;
        if (r7 >= r0.length) goto L5;
        String r1 = r0[r7];
    L6:
        String r9 = formatFlags(r7, r8);
        Object[] r10 = new Object[5];
        if (r4 == false) goto L9;
        String r11 = "<<";
    L10:
        r10[0] = r11;
        r10[1] = Integer.valueOf(r5);
        r10[2] = Integer.valueOf(r6);
        r10[3] = r1;
        r10[4] = r9;
        return Util.format("%s 0x%08x %5d %-13s %s", r10);
    L9:
        r11 = ">>";
        goto L10
    L5:
        r1 = Util.format("0x%02x", new Object[]{Byte.valueOf(r7)});
        goto L6
    }

    static String formatFlags(byte r2, byte r3) {
        if (r3 != 0) goto L6;
        return "";
    L6:
        if (r2 == 2) goto L39;
        if (r2 == 3) goto L39;
        if (r2 == 4) goto L34;
        if (r2 == 6) goto L34;
        if (r2 == 7) goto L39;
        if (r2 == 8) goto L39;
        String[] r0 = FLAGS;
        if (r3 >= r0.length) goto L20;
        String r1 = r0[r3];
    L22:
        if (r2 == 5) goto L24;
    L27:
        if (r2 == 0) goto L29;
    L32:
        return r1;
    L29:
        if ((r3 & 32) == 0) goto L32;
        return r1.replace("PRIORITY", "COMPRESSED");
    L24:
        if ((r3 & 4) == 0) goto L27;
        return r1.replace("HEADERS", "PUSH_PROMISE");
    L20:
        r1 = BINARY[r3];
    L34:
        if (r3 != 1) goto L37;
        return "ACK";
    L37:
        return BINARY[r3];
    L39:
        return BINARY[r3];
    }
}
