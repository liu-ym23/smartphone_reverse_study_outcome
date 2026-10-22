package okio;

import com.android.vcard.VCardConstants;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: -Base64.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u000e\u0010\t\u001a\u0004\u0018\u00010\u0001*\u00020\nH\u0000\u001a\u0016\u0010\u000b\u001a\u00020\n*\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\u0001H\u0000\"\u001c\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u001c\u0010\u0006\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\u0005¨\u0006\r"}, d2 = {VCardConstants.PARAM_ENCODING_BASE64, "", "getBASE64$annotations", "()V", "getBASE64", "()[B", "BASE64_URL_SAFE", "getBASE64_URL_SAFE$annotations", "getBASE64_URL_SAFE", "decodeBase64ToArray", "", "encodeBase64", "map", "okio"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class _Base64Kt {
    private static final byte[] BASE64 = null;
    private static final byte[] BASE64_URL_SAFE = null;

    public static /* synthetic */ void getBASE64$annotations() {
    }

    public static /* synthetic */ void getBASE64_URL_SAFE$annotations() {
    }

    public static final byte[] getBASE64() {
        return BASE64;
    }

    static {
        BASE64 = ByteString.Companion.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").getData$okio();
        BASE64_URL_SAFE = ByteString.Companion.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").getData$okio();
    }

    public static final byte[] getBASE64_URL_SAFE() {
        return BASE64_URL_SAFE;
    }

    public static final byte[] decodeBase64ToArray(String r16) {
        Intrinsics.checkNotNullParameter(r16, "<this>");
        int r1 = r16.length();
    L4:
        if (r1 <= 0) goto L13;
        char r6 = r16.charAt(r1 - 1);
        if (r6 == '=') goto L12;
        if (r6 == '\n') goto L12;
        if (r6 == '\r') goto L12;
        if (r6 == ' ') goto L12;
        if (r6 != '\t') goto L13;
    L12:
        r1 = r1 - 1;
    L13:
        int r7 = (int) ((((long) r1) * 6) / 8);
        byte[] r8 = new byte[r7];
        int r9 = 0;
        int r10 = 0;
        int r11 = 0;
        int r12 = 0;
    L14:
        boolean r14 = true;
        if (r9 >= r1) goto L62;
        char r15 = r16.charAt(r9);
        if ('A' <= r15) goto L19;
    L21:
        boolean r13 = false;
    L22:
        if (r13 == false) goto L25;
        int r17 = r15 - 'A';
    L58:
        r11 = (r11 << 6) | r17;
        r10 = r10 + 1;
        if ((r10 % 4) != 0) goto L61;
        int r18 = r12 + 1;
        r8[r12] = (byte) (r11 >> 16);
        int r19 = r18 + 1;
        r8[r18] = (byte) (r11 >> 8);
        r8[r19] = (byte) r11;
        r12 = r19 + 1;
    L61:
        r9 = r9 + 1;
        goto L14
    L25:
        if ('a' <= r15) goto L27;
    L29:
        boolean r20 = false;
    L30:
        if (r20 == false) goto L33;
        r17 = r15 - 'G';
        goto L58
    L33:
        if ('0' <= r15) goto L35;
    L37:
        r14 = false;
    L38:
        if (r14 == false) goto L41;
        r17 = r15 + 4;
        goto L58
    L41:
        if (r15 != '+') goto L43;
    L57:
        r17 = 62;
        goto L58
    L43:
        if (r15 == '-') goto L57;
        if (r15 != '/') goto L48;
    L56:
        r17 = 63;
        goto L58
    L48:
        if (r15 == '_') goto L56;
        if (r15 == '\n') goto L61;
        if (r15 == '\r') goto L61;
        if (r15 == ' ') goto L61;
        if (r15 == '\t') goto L61;
        return null;
    L35:
        if (r15 >= ':') goto L37;
    L27:
        if (r15 >= '{') goto L29;
        r20 = true;
        goto L30
    L19:
        if (r15 >= '[') goto L21;
        r13 = true;
        goto L22
    L62:
        int r110 = r10 % 4;
        if (r110 != 1) goto L65;
        return null;
    L65:
        if (r110 != 2) goto L67;
        r8[r12] = (byte) ((r11 << 12) >> 16);
        r12 = r12 + 1;
    L71:
        if (r12 != r7) goto L73;
        return r8;
    L73:
        byte[] r0 = Arrays.copyOf(r8, r12);
        Intrinsics.checkNotNullExpressionValue(r0, "copyOf(this, newSize)");
        return r0;
    L67:
        if (r110 != 3) goto L71;
        int r2 = r11 << 6;
        int r3 = r12 + 1;
        r8[r12] = (byte) (r2 >> 16);
        r12 = r3 + 1;
        r8[r3] = (byte) (r2 >> 8);
        goto L71
    }

    public static /* synthetic */ String encodeBase64$default(byte[] r0, byte[] r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = BASE64;
    L6:
        return encodeBase64(r0, r1);
    }

    public static final String encodeBase64(byte[] r10, byte[] r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "map");
        byte[] r0 = new byte[((r10.length + 2) / 3) * 4];
        int r2 = r10.length - (r10.length % 3);
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r3 >= r2) goto L5;
        int r5 = r3 + 1;
        byte r6 = r10[r3];
        int r7 = r5 + 1;
        byte r8 = r10[r5];
        int r9 = r7 + 1;
        byte r12 = r10[r7];
        int r13 = r4 + 1;
        r0[r4] = r11[(r6 & 255) >> 2];
        int r14 = r13 + 1;
        r0[r13] = r11[((r6 & 3) << 4) | ((r8 & 255) >> 4)];
        int r15 = r14 + 1;
        r0[r14] = r11[((r8 & 15) << 2) | ((r12 & 255) >> 6)];
        r4 = r15 + 1;
        r0[r15] = r11[r12 & Utf8.REPLACEMENT_BYTE];
        r3 = r9;
        goto L3
    L5:
        int r16 = r10.length - r2;
        if (r16 == 1) goto L10;
        if (r16 != 2) goto L12;
        int r17 = r3 + 1;
        byte r18 = r10[r3];
        byte r19 = r10[r17];
        int r20 = r4 + 1;
        r0[r4] = r11[(r18 & 255) >> 2];
        int r21 = r20 + 1;
        r0[r20] = r11[((r18 & 3) << 4) | ((r19 & 255) >> 4)];
        r0[r21] = r11[(r19 & 15) << 2];
        r0[r21 + 1] = Base64.padSymbol;
    L12:
        return _JvmPlatformKt.toUtf8String(r0);
    L10:
        byte r110 = r10[r3];
        int r22 = r4 + 1;
        r0[r4] = r11[(r110 & 255) >> 2];
        int r1 = r22 + 1;
        r0[r22] = r11[(r110 & 3) << 4];
        r0[r1] = Base64.padSymbol;
        r0[r1 + 1] = Base64.padSymbol;
        goto L12
    }
}
