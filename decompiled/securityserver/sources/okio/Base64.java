package okio;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: okio.-Base64, reason: invalid class name */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@JvmName
public final class Base64 {

    @NotNull
    private static final byte[] BASE64 = null;

    @NotNull
    private static final byte[] BASE64_URL_SAFE = null;

    static {
        ByteString.Companion r0 = ByteString.Companion;
        BASE64 = r0.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").getData$okio();
        BASE64_URL_SAFE = r0.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").getData$okio();
    }

    @Nullable
    public static final byte[] decodeBase64ToArray(@NotNull String r14) {
        Intrinsics.f(r14, "$this$decodeBase64ToArray");
        int r0 = r14.length();
    L4:
        if (r0 <= 0) goto L13;
        char r5 = r14.charAt(r0 - 1);
        if (r5 == '=') goto L12;
        if (r5 == '\n') goto L12;
        if (r5 == '\r') goto L12;
        if (r5 == ' ') goto L12;
        if (r5 != '\t') goto L13;
    L12:
        r0 = r0 - 1;
    L13:
        int r6 = (int) ((((long) r0) * 6) / 8);
        byte[] r7 = new byte[r6];
        int r8 = 0;
        int r9 = 0;
        int r10 = 0;
        int r11 = 0;
    L15:
        if (r8 >= r0) goto L56;
        char r12 = r14.charAt(r8);
        if ('A' > r12) goto L23;
        if ('Z' < r12) goto L23;
        int r13 = r12 - 'A';
    L52:
        r10 = (r10 << 6) | r13;
        r9 = r9 + 1;
        if ((r9 % 4) != 0) goto L55;
        r7[r11] = (byte) (r10 >> 16);
        int r15 = r11 + 2;
        r7[r11 + 1] = (byte) (r10 >> 8);
        r11 = r11 + 3;
        r7[r15] = (byte) r10;
    L55:
        r8 = r8 + 1;
    L23:
        if ('a' > r12) goto L29;
        if ('z' < r12) goto L29;
        r13 = r12 - 'G';
    L29:
        if ('0' > r12) goto L35;
        if ('9' < r12) goto L35;
        r13 = r12 + 4;
    L35:
        if (r12 != '+') goto L37;
    L51:
        r13 = 62;
        goto L52
    L37:
        if (r12 == '-') goto L51;
        if (r12 != '/') goto L42;
    L50:
        r13 = 63;
        goto L52
    L42:
        if (r12 == '_') goto L50;
        if (r12 == '\n') goto L55;
        if (r12 == '\r') goto L55;
        if (r12 == ' ') goto L55;
        if (r12 == '\t') goto L55;
        return null;
    L56:
        int r16 = r9 % 4;
        if (r16 != 1) goto L59;
        return null;
    L59:
        if (r16 != 2) goto L61;
        r7[r11] = (byte) ((r10 << 12) >> 16);
        r11 = r11 + 1;
    L65:
        if (r11 != r6) goto L67;
        return r7;
    L67:
        byte[] r17 = Arrays.copyOf(r7, r11);
        Intrinsics.e(r17, "java.util.Arrays.copyOf(this, newSize)");
        return r17;
    L61:
        if (r16 != 3) goto L65;
        int r18 = r10 << 6;
        int r1 = r11 + 1;
        r7[r11] = (byte) (r18 >> 16);
        r11 = r11 + 2;
        r7[r1] = (byte) (r18 >> 8);
        goto L65
    }

    @NotNull
    public static final String encodeBase64(@NotNull byte[] r11, @NotNull byte[] r12) {
        Intrinsics.f(r11, "$this$encodeBase64");
        Intrinsics.f(r12, "map");
        byte[] r0 = new byte[((r11.length + 2) / 3) * 4];
        int r2 = r11.length - (r11.length % 3);
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r3 >= r2) goto L5;
        byte r6 = r11[r3];
        int r7 = r3 + 2;
        byte r5 = r11[r3 + 1];
        r3 = r3 + 3;
        byte r8 = r11[r7];
        r0[r4] = r12[(r6 & 255) >> 2];
        r0[r4 + 1] = r12[((r6 & 3) << 4) | ((r5 & 255) >> 4)];
        int r9 = r4 + 3;
        r0[r4 + 2] = r12[((r5 & 15) << 2) | ((r8 & 255) >> 6)];
        r4 = r4 + 4;
        r0[r9] = r12[r8 & Utf8.REPLACEMENT_BYTE];
        goto L3
    L5:
        int r10 = r11.length - r2;
        if (r10 == 1) goto L10;
        if (r10 != 2) goto L12;
        int r13 = r3 + 1;
        byte r14 = r11[r3];
        byte r15 = r11[r13];
        r0[r4] = r12[(r14 & 255) >> 2];
        r0[r4 + 1] = r12[((r14 & 3) << 4) | ((r15 & 255) >> 4)];
        r0[r4 + 2] = r12[(r15 & 15) << 2];
        r0[r4 + 3] = (byte) 61;
    L12:
        return Platform.toUtf8String(r0);
    L10:
        byte r16 = r11[r3];
        r0[r4] = r12[(r16 & 255) >> 2];
        r0[r4 + 1] = r12[(r16 & 3) << 4];
        byte r17 = (byte) 61;
        r0[r4 + 2] = r17;
        r0[r4 + 3] = r17;
        goto L12
    }

    public static /* synthetic */ String encodeBase64$default(byte[] r0, byte[] r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = BASE64;
    L6:
        return encodeBase64(r0, r1);
    }

    @NotNull
    public static final byte[] getBASE64() {
        return BASE64;
    }

    @NotNull
    public static final byte[] getBASE64_URL_SAFE() {
        return BASE64_URL_SAFE;
    }
}
