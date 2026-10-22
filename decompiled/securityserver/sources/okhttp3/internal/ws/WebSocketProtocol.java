package okhttp3.internal.ws;

import a.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class WebSocketProtocol {

    @NotNull
    public static final String ACCEPT_MAGIC = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
    public static final int B0_FLAG_FIN = 128;
    public static final int B0_FLAG_RSV1 = 64;
    public static final int B0_FLAG_RSV2 = 32;
    public static final int B0_FLAG_RSV3 = 16;
    public static final int B0_MASK_OPCODE = 15;
    public static final int B1_FLAG_MASK = 128;
    public static final int B1_MASK_LENGTH = 127;
    public static final int CLOSE_CLIENT_GOING_AWAY = 1001;
    public static final long CLOSE_MESSAGE_MAX = 123;
    public static final int CLOSE_NO_STATUS_CODE = 1005;
    public static final WebSocketProtocol INSTANCE = null;
    public static final int OPCODE_BINARY = 2;
    public static final int OPCODE_CONTINUATION = 0;
    public static final int OPCODE_CONTROL_CLOSE = 8;
    public static final int OPCODE_CONTROL_PING = 9;
    public static final int OPCODE_CONTROL_PONG = 10;
    public static final int OPCODE_FLAG_CONTROL = 8;
    public static final int OPCODE_TEXT = 1;
    public static final long PAYLOAD_BYTE_MAX = 125;
    public static final int PAYLOAD_LONG = 127;
    public static final int PAYLOAD_SHORT = 126;
    public static final long PAYLOAD_SHORT_MAX = 65535;

    static {
        INSTANCE = new WebSocketProtocol();
    }

    private WebSocketProtocol() {
    }

    @NotNull
    public final String acceptHeader(@NotNull String r2) {
        Intrinsics.f(r2, "key");
        return ByteString.Companion.encodeUtf8(r2.concat(ACCEPT_MAGIC)).sha1().base64();
    }

    @Nullable
    public final String closeCodeExceptionMessage(int r2) {
        if (r2 < 1000) goto L19;
        if (r2 >= 5000) goto L19;
        if (1004 > r2) goto L12;
        if (1006 < r2) goto L12;
    L20:
        return a.f(r2, "Code ", " is reserved and may not be used.");
    L12:
        if (1015 <= r2) goto L15;
    L17:
        return null;
    L15:
        if (2999 < r2) goto L17;
    L19:
        return a.e(r2, "Code must be in range [1000,5000): ");
    }

    public final void toggleMask(@NotNull Buffer.UnsafeCursor r7, @NotNull byte[] r8) {
        Intrinsics.f(r7, "cursor");
        Intrinsics.f(r8, "key");
        int r6 = r8.length;
        int r0 = 0;
    L3:
        byte[] r1 = r7.data;
        int r2 = r7.start;
        int r3 = r7.end;
        if (r1 == null) goto L8;
    L5:
        if (r2 >= r3) goto L8;
        int r4 = r0 % r6;
        r1[r2] = (byte) (r1[r2] ^ r8[r4]);
        r2 = r2 + 1;
        r0 = r4 + 1;
    L8:
        if (r7.next() != (-1)) goto L3;
    }

    public final void validateCloseCode(int r1) {
        String r0 = closeCodeExceptionMessage(r1);
        if (r0 != null) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L8;
        return;
    L8:
        Intrinsics.c(r0);
        throw new IllegalArgumentException(r0.toString());
    L5:
        r2 = false;
        goto L6
    }
}
