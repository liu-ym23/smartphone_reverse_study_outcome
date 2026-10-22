package okhttp3.internal.http2;

import a.a;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.internal.Util;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class Http2 {
    private static final String[] BINARY = null;

    @JvmField
    @NotNull
    public static final ByteString CONNECTION_PREFACE = null;
    private static final String[] FLAGS = null;
    public static final int FLAG_ACK = 1;
    public static final int FLAG_COMPRESSED = 32;
    public static final int FLAG_END_HEADERS = 4;
    public static final int FLAG_END_PUSH_PROMISE = 4;
    public static final int FLAG_END_STREAM = 1;
    public static final int FLAG_NONE = 0;
    public static final int FLAG_PADDED = 8;
    public static final int FLAG_PRIORITY = 32;
    private static final String[] FRAME_NAMES = null;
    public static final int INITIAL_MAX_FRAME_SIZE = 16384;
    public static final Http2 INSTANCE = null;
    public static final int TYPE_CONTINUATION = 9;
    public static final int TYPE_DATA = 0;
    public static final int TYPE_GOAWAY = 7;
    public static final int TYPE_HEADERS = 1;
    public static final int TYPE_PING = 6;
    public static final int TYPE_PRIORITY = 2;
    public static final int TYPE_PUSH_PROMISE = 5;
    public static final int TYPE_RST_STREAM = 3;
    public static final int TYPE_SETTINGS = 4;
    public static final int TYPE_WINDOW_UPDATE = 8;

    static {
        INSTANCE = new Http2();
        CONNECTION_PREFACE = ByteString.Companion.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
        FRAME_NAMES = new String[]{"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
        FLAGS = new String[64];
        String[] r1 = new String[256];
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r3 >= 256) goto L5;
        String r4 = Integer.toBinaryString(r3);
        Intrinsics.e(r4, "Integer.toBinaryString(it)");
        String r5 = Util.format("%8s", new Object[]{r4});
        Intrinsics.f(r5, "<this>");
        String r6 = r5.replace(' ', '0');
        Intrinsics.e(r6, "this as java.lang.String…replace(oldChar, newChar)");
        r1[r3] = r6;
        r3 = r3 + 1;
        goto L3
    L5:
        BINARY = r1;
        String[] r0 = FLAGS;
        r0[0] = "";
        r0[1] = "END_STREAM";
        int[] r7 = {1};
        r0[8] = "PADDED";
        int r8 = r7[0];
        r0[r8 | 8] = r0[r8] + "|PADDED";
        r0[4] = "END_HEADERS";
        r0[32] = "PRIORITY";
        r0[36] = "END_HEADERS|PRIORITY";
        int[] r9 = {4, 32, 36};
        int r10 = 0;
    L7:
        if (r10 >= 3) goto L9;
        int r11 = r9[r10];
        int r12 = r7[0];
        String[] r13 = FLAGS;
        int r14 = r12 | r11;
        r13[r14] = r13[r12] + "|" + r13[r11];
        StringBuilder r15 = new StringBuilder();
        r15.append(r13[r12]);
        r15.append("|");
        r13[r14 | 8] = a.o(r15, r13[r11], "|PADDED");
        r10 = r10 + 1;
        goto L7
    L9:
        int r16 = FLAGS.length;
    L10:
        if (r2 >= r16) goto L15;
        String[] r17 = FLAGS;
        if (r17[r2] != null) goto L14;
        r17[r2] = BINARY[r2];
    L14:
        r2 = r2 + 1;
        goto L10
    }

    private Http2() {
    }

    @NotNull
    public final String formatFlags(int r2, int r3) {
        if (r3 != 0) goto L6;
        return "";
    L6:
        if (r2 == 2) goto L37;
        if (r2 == 3) goto L37;
        if (r2 == 4) goto L32;
        if (r2 == 6) goto L32;
        if (r2 == 7) goto L37;
        if (r2 == 8) goto L37;
        String[] r1 = FLAGS;
        if (r3 >= r1.length) goto L20;
        String r4 = r1[r3];
        Intrinsics.c(r4);
    L22:
        if (r2 == 5) goto L24;
    L26:
        if (r2 == 0) goto L28;
        return r4;
    L28:
        if ((r3 & 32) != 0) goto L30;
        return r4;
    L30:
        return StringsKt.B(r4, "PRIORITY", "COMPRESSED");
    L24:
        if ((r3 & 4) == 0) goto L26;
        return StringsKt.B(r4, "HEADERS", "PUSH_PROMISE");
    L20:
        r4 = BINARY[r3];
    L32:
        if (r3 != 1) goto L35;
        return "ACK";
    L35:
        return BINARY[r3];
    L37:
        return BINARY[r3];
    }

    @NotNull
    public final String formattedType$okhttp(int r2) {
        String[] r1 = FRAME_NAMES;
        if (r2 >= r1.length) goto L6;
        return r1[r2];
    L6:
        return Util.format("0x%02x", new Object[]{Integer.valueOf(r2)});
    }

    @NotNull
    public final String frameLog(boolean r2, int r3, int r4, int r5, int r6) {
        String r0 = formattedType$okhttp(r5);
        String r1 = formatFlags(r5, r6);
        if (r2 == false) goto L5;
        String r7 = "<<";
    L7:
        return Util.format("%s 0x%08x %5d %-13s %s", new Object[]{r7, Integer.valueOf(r3), Integer.valueOf(r4), r0, r1});
    L5:
        r7 = ">>";
        goto L7
    }
}
