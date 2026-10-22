package okhttp3.internal;

import com.bytedance.librarian.LibrarianImpl;
import java.net.IDN;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.Buffer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class HostnamesKt {
    private static final boolean containsInvalidHostnameAsciiCodes(String r7) {
        int r0 = r7.length();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L14;
        char r3 = r7.charAt(r2);
        if (Intrinsics.h(r3, 31) <= 0) goto L13;
        if (Intrinsics.h(r3, 127) >= 0) goto L13;
        if (StringsKt.r(" #%/:?@[\\]", r3, 0, false, 6) != (-1)) goto L11;
        r2 = r2 + 1;
        goto L3
    L11:
        return true;
    L13:
        return true;
    L14:
        return false;
    }

    private static final boolean decodeIpv4Suffix(String r7, int r8, int r9, byte[] r10, int r11) {
        int r0 = r11;
    L4:
        if (r8 >= r9) goto L32;
        if (r0 == r10.length) goto L7;
        if (r0 != r11) goto L10;
    L13:
        int r2 = r8;
        int r3 = 0;
    L14:
        if (r2 >= r9) goto L28;
        char r4 = r7.charAt(r2);
        if (Intrinsics.h(r4, 48) < 0) goto L28;
        if (Intrinsics.h(r4, 57) > 0) goto L28;
        if (r3 != 0) goto L23;
        if (r8 == r2) goto L23;
        return false;
    L23:
        r3 = ((r3 * 10) + r4) - 48;
        if (r3 > 255) goto L25;
        r2 = r2 + 1;
        goto L14
    L25:
        return false;
    L28:
        if ((r2 - r8) == 0) goto L29;
        r10[r0] = (byte) r3;
        r0 = r0 + 1;
        r8 = r2;
        goto L4
    L29:
        return false;
    L10:
        if (r7.charAt(r8) != '.') goto L11;
        r8 = r8 + 1;
        goto L13
    L11:
        return false;
    L7:
        return false;
    L32:
        if (r0 != (r11 + 4)) goto L44;
        return true;
    L44:
        return false;
    }

    private static final InetAddress decodeIpv6(String r11, int r12, int r13) {
        byte[] r1 = new byte[16];
        int r4 = 0;
        int r5 = -1;
        int r6 = -1;
    L4:
        if (r12 >= r13) goto L42;
        if (r4 == 16) goto L6;
        int r8 = r12 + 2;
        if (r8 <= r13) goto L10;
    L17:
        if (r4 != 0) goto L19;
    L21:
        r6 = r12;
    L29:
        int r9 = 0;
        r12 = r6;
    L30:
        if (r12 >= r13) goto L35;
        int r10 = Util.parseHexDigit(r11.charAt(r12));
        if (r10 == (-1)) goto L35;
        r9 = (r9 << 4) + r10;
        r12 = r12 + 1;
    L35:
        int r14 = r12 - r6;
        if (r14 == 0) goto L41;
        if (r14 > 4) goto L41;
        int r7 = r4 + 1;
        r1[r4] = (byte) ((r9 >>> 8) & 255);
        r4 = r4 + 2;
        r1[r7] = (byte) (r9 & 255);
    L41:
        return null;
    L19:
        if (StringsKt.E(r11, r12, ":", false) == false) goto L23;
        r12 = r12 + 1;
        goto L21
    L23:
        if (StringsKt.E(r11, r12, LibrarianImpl.Constants.DOT, false) == true) goto L25;
        return null;
    L25:
        if (decodeIpv4Suffix(r11, r6, r13, r1, r4 - 2) == true) goto L27;
        return null;
    L27:
        r4 = r4 + 2;
        goto L42
    L10:
        if (StringsKt.E(r11, r12, "::", false) == false) goto L17;
        if (r5 != (-1)) goto L12;
        r4 = r4 + 2;
        r5 = r4;
        if (r8 == r13) goto L42;
        r6 = r8;
        goto L29
    L12:
        return null;
    L6:
        return null;
    L42:
        if (r4 == 16) goto L47;
        if (r5 != (-1)) goto L45;
        return null;
    L45:
        int r15 = r4 - r5;
        System.arraycopy(r1, r5, r1, 16 - r15, r15);
        Arrays.fill(r1, r5, (16 - r4) + r5, (byte) 0);
    L47:
        return InetAddress.getByAddress(r1);
    }

    private static final String inet6AddressToAscii(byte[] r8) {
        int r0 = -1;
        int r1 = 0;
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r2 >= r8.length) goto L18;
        int r4 = r2;
    L6:
        if (r4 >= 16) goto L12;
        if (r8[r4] != 0) goto L12;
        if (r8[r4 + 1] != 0) goto L12;
        r4 = r4 + 2;
    L12:
        int r5 = r4 - r2;
        if (r5 <= r3) goto L17;
        if (r5 < 4) goto L17;
        r0 = r2;
        r3 = r5;
    L17:
        r2 = r4 + 2;
        goto L4
    L18:
        Buffer r6 = new Buffer();
    L20:
        if (r1 >= r8.length) goto L30;
        if (r1 == r0) goto L23;
        if (r1 <= 0) goto L28;
        r6.writeByte(58);
    L28:
        r6.writeHexadecimalUnsignedLong((Util.and(r8[r1], 255) << 8) | Util.and(r8[r1 + 1], 255));
        r1 = r1 + 2;
        goto L20
    L23:
        r6.writeByte(58);
        r1 = r1 + r3;
        if (r1 != 16) goto L20;
        r6.writeByte(58);
        goto L20
    L30:
        return r6.readUtf8();
    }

    @Nullable
    public static final String toCanonicalHost(@NotNull String r4) {
        Intrinsics.f(r4, "$this$toCanonicalHost");
        if (StringsKt.m(":", false, r4) == true) goto L5;
        String r5 = IDN.toASCII(r4);     // Catch: IllegalArgumentException -> L30
        Intrinsics.e(r5, "IDN.toASCII(host)");     // Catch: IllegalArgumentException -> L30
        Locale r0 = Locale.US;     // Catch: IllegalArgumentException -> L30
        Intrinsics.e(r0, "Locale.US");     // Catch: IllegalArgumentException -> L30
        String r6 = r5.toLowerCase(r0);     // Catch: IllegalArgumentException -> L30
        Intrinsics.e(r6, "(this as java.lang.String).toLowerCase(locale)");     // Catch: IllegalArgumentException -> L30
        if (r6.length() != 0) goto L25;
        return null;
    L25:
        if (containsInvalidHostnameAsciiCodes(r6) == false) goto L29;
        return null;
    L29:
        return r6;
    L34:
        return null;
    L5:
        if (StringsKt.F(r4, "[", false) == true) goto L7;
    L9:
        InetAddress r1 = decodeIpv6(r4, 0, r4.length());
    L10:
        if (r1 == null) goto L21;
        byte[] r2 = r1.getAddress();
        if (r2.length != 16) goto L16;
        return inet6AddressToAscii(r2);
    L16:
        if (r2.length != 4) goto L20;
        return r1.getHostAddress();
    L20:
        throw new AssertionError("Invalid IPv6 address: '" + r4 + '\'');
    L21:
        return null;
    L7:
        if (StringsKt.o(r4, "]") == false) goto L9;
        r1 = decodeIpv6(r4, 1, r4.length() - 1);
        goto L10
    }
}
