package okio.internal;

import android.icu.text.DateFormat;
import android.icu.text.PluralRules;
import com.android.settings.applications.PreferredSettingsUtils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.Buffer;
import okio.ByteString;
import okio._Base64Kt;
import okio._JvmPlatformKt;
import okio._UtilKt;

/* JADX INFO: compiled from: -ByteString.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0002\u001a\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH\u0080\b\u001a\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0002\u001a\r\u0010\u0011\u001a\u00020\u0012*\u00020\fH\u0080\b\u001a\r\u0010\u0013\u001a\u00020\u0012*\u00020\fH\u0080\b\u001a\u0015\u0010\u0014\u001a\u00020\u0007*\u00020\f2\u0006\u0010\u0015\u001a\u00020\fH\u0080\b\u001a-\u0010\u0016\u001a\u00020\u0017*\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0080\b\u001a\u000f\u0010\u001c\u001a\u0004\u0018\u00010\f*\u00020\u0012H\u0080\b\u001a\r\u0010\u001d\u001a\u00020\f*\u00020\u0012H\u0080\b\u001a\r\u0010\u001e\u001a\u00020\f*\u00020\u0012H\u0080\b\u001a\u0015\u0010\u001f\u001a\u00020 *\u00020\f2\u0006\u0010!\u001a\u00020\tH\u0080\b\u001a\u0015\u0010\u001f\u001a\u00020 *\u00020\f2\u0006\u0010!\u001a\u00020\fH\u0080\b\u001a\u0017\u0010\"\u001a\u00020 *\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010#H\u0080\b\u001a\u0015\u0010$\u001a\u00020%*\u00020\f2\u0006\u0010&\u001a\u00020\u0007H\u0080\b\u001a\r\u0010'\u001a\u00020\u0007*\u00020\fH\u0080\b\u001a\r\u0010(\u001a\u00020\u0007*\u00020\fH\u0080\b\u001a\r\u0010)\u001a\u00020\u0012*\u00020\fH\u0080\b\u001a\u001d\u0010*\u001a\u00020\u0007*\u00020\f2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u0007H\u0080\b\u001a\r\u0010,\u001a\u00020\t*\u00020\fH\u0080\b\u001a\u001d\u0010-\u001a\u00020\u0007*\u00020\f2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u0007H\u0080\b\u001a\u001d\u0010-\u001a\u00020\u0007*\u00020\f2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010+\u001a\u00020\u0007H\u0080\b\u001a-\u0010.\u001a\u00020 *\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010/\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0080\b\u001a-\u0010.\u001a\u00020 *\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010/\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0080\b\u001a\u0015\u00100\u001a\u00020 *\u00020\f2\u0006\u00101\u001a\u00020\tH\u0080\b\u001a\u0015\u00100\u001a\u00020 *\u00020\f2\u0006\u00101\u001a\u00020\fH\u0080\b\u001a\u001d\u00102\u001a\u00020\f*\u00020\f2\u0006\u00103\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u0007H\u0080\b\u001a\r\u00105\u001a\u00020\f*\u00020\fH\u0080\b\u001a\r\u00106\u001a\u00020\f*\u00020\fH\u0080\b\u001a\r\u00107\u001a\u00020\t*\u00020\fH\u0080\b\u001a\u001d\u00108\u001a\u00020\f*\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0080\b\u001a\r\u00109\u001a\u00020\u0012*\u00020\fH\u0080\b\u001a\r\u0010:\u001a\u00020\u0012*\u00020\fH\u0080\b\u001a$\u0010;\u001a\u00020\u0017*\u00020\f2\u0006\u0010<\u001a\u00020=2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0000\"\u001c\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006>"}, d2 = {"HEX_DIGIT_CHARS", "", "getHEX_DIGIT_CHARS$annotations", "()V", "getHEX_DIGIT_CHARS", "()[C", "codePointIndexToCharIndex", "", DateFormat.SECOND, "", "codePointCount", "commonOf", "Lokio/ByteString;", "data", "decodeHexDigit", "c", "", "commonBase64", "", "commonBase64Url", "commonCompareTo", PluralRules.KEYWORD_OTHER, "commonCopyInto", "", "offset", "target", "targetOffset", "byteCount", "commonDecodeBase64", "commonDecodeHex", "commonEncodeUtf8", "commonEndsWith", "", PreferredSettingsUtils.OTHERS_SUFFIX_KEY, "commonEquals", "", "commonGetByte", "", "pos", "commonGetSize", "commonHashCode", "commonHex", "commonIndexOf", "fromIndex", "commonInternalArray", "commonLastIndexOf", "commonRangeEquals", "otherOffset", "commonStartsWith", "prefix", "commonSubstring", "beginIndex", "endIndex", "commonToAsciiLowercase", "commonToAsciiUppercase", "commonToByteArray", "commonToByteString", "commonToString", "commonUtf8", "commonWrite", "buffer", "Lokio/Buffer;", "okio"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class _ByteStringKt {
    private static final char[] HEX_DIGIT_CHARS = null;

    public static final /* synthetic */ int access$codePointIndexToCharIndex(byte[] r0, int r1) {
        return codePointIndexToCharIndex(r0, r1);
    }

    public static final /* synthetic */ int access$decodeHexDigit(char r0) {
        return decodeHexDigit(r0);
    }

    public static /* synthetic */ void getHEX_DIGIT_CHARS$annotations() {
    }

    public static final String commonUtf8(ByteString r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        String r0 = r1.getUtf8$okio();
        if (r0 != null) goto L6;
        String r2 = _JvmPlatformKt.toUtf8String(r1.internalArray$okio());
        r1.setUtf8$okio(r2);
        return r2;
    L6:
        return r0;
    }

    public static final String commonBase64(ByteString r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return _Base64Kt.encodeBase64$default(r2.getData$okio(), null, 1, null);
    }

    public static final String commonBase64Url(ByteString r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return _Base64Kt.encodeBase64(r1.getData$okio(), _Base64Kt.getBASE64_URL_SAFE());
    }

    public static final char[] getHEX_DIGIT_CHARS() {
        return HEX_DIGIT_CHARS;
    }

    static {
        HEX_DIGIT_CHARS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public static final String commonHex(ByteString r8) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        char[] r0 = new char[r8.getData$okio().length * 2];
        byte[] r9 = r8.getData$okio();
        int r1 = r9.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r1) goto L6;
        byte r4 = r9[r2];
        int r5 = r3 + 1;
        r0[r3] = getHEX_DIGIT_CHARS()[(r4 >> 4) & 15];
        r3 = r5 + 1;
        r0[r5] = getHEX_DIGIT_CHARS()[r4 & 15];
        r2 = r2 + 1;
        goto L3
    L6:
        return StringsKt.concatToString(r0);
    }

    public static final ByteString commonToAsciiLowercase(ByteString r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        int r0 = 0;
    L4:
        if (r0 >= r5.getData$okio().length) goto L22;
        byte r1 = r5.getData$okio()[r0];
        if (r1 < 65) goto L21;
        if (r1 > 90) goto L21;
        byte[] r6 = r5.getData$okio();
        byte[] r7 = Arrays.copyOf(r6, r6.length);
        Intrinsics.checkNotNullExpressionValue(r7, "copyOf(this, size)");
        int r4 = r0 + 1;
        r7[r0] = (byte) (r1 + 32);
    L12:
        if (r4 >= r7.length) goto L20;
        byte r2 = r7[r4];
        if (r2 < 65) goto L18;
        if (r2 > 90) goto L18;
        r7[r4] = (byte) (r2 + 32);
    L18:
        r4 = r4 + 1;
        goto L12
    L20:
        return new ByteString(r7);
    L21:
        r0 = r0 + 1;
        goto L4
    L22:
        return r5;
    }

    public static final ByteString commonToAsciiUppercase(ByteString r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        int r0 = 0;
    L4:
        if (r0 >= r5.getData$okio().length) goto L22;
        byte r1 = r5.getData$okio()[r0];
        if (r1 < 97) goto L21;
        if (r1 > 122) goto L21;
        byte[] r6 = r5.getData$okio();
        byte[] r7 = Arrays.copyOf(r6, r6.length);
        Intrinsics.checkNotNullExpressionValue(r7, "copyOf(this, size)");
        int r4 = r0 + 1;
        r7[r0] = (byte) (r1 - 32);
    L12:
        if (r4 >= r7.length) goto L20;
        byte r2 = r7[r4];
        if (r2 < 97) goto L18;
        if (r2 > 122) goto L18;
        r7[r4] = (byte) (r2 - 32);
    L18:
        r4 = r4 + 1;
        goto L12
    L20:
        return new ByteString(r7);
    L21:
        r0 = r0 + 1;
        goto L4
    L22:
        return r5;
    }

    public static final ByteString commonSubstring(ByteString r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        int r6 = _UtilKt.resolveDefaultParameter(r3, r5);
        boolean r0 = true;
        if (r4 < 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L28;
        if (r6 > r3.getData$okio().length) goto L10;
        boolean r7 = true;
    L11:
        if (r7 == false) goto L26;
        if ((r6 - r4) >= 0) goto L16;
        r0 = false;
    L16:
        if (r0 == false) goto L24;
        if (r4 != 0) goto L22;
        if (r6 != r3.getData$okio().length) goto L22;
        return r3;
    L22:
        return new ByteString(ArraysKt.copyOfRange(r3.getData$okio(), r4, r6));
    L24:
        throw new IllegalArgumentException("endIndex < beginIndex".toString());
    L26:
        throw new IllegalArgumentException(("endIndex > length(" + r3.getData$okio().length + ')').toString());
    L10:
        r7 = false;
        goto L11
    L28:
        throw new IllegalArgumentException("beginIndex < 0".toString());
    L5:
        r2 = false;
        goto L6
    }

    public static final byte commonGetByte(ByteString r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.getData$okio()[r2];
    }

    public static final int commonGetSize(ByteString r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.getData$okio().length;
    }

    public static final byte[] commonToByteArray(ByteString r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        byte[] r2 = r1.getData$okio();
        byte[] r3 = Arrays.copyOf(r2, r2.length);
        Intrinsics.checkNotNullExpressionValue(r3, "copyOf(this, size)");
        return r3;
    }

    public static final byte[] commonInternalArray(ByteString r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.getData$okio();
    }

    public static final boolean commonRangeEquals(ByteString r1, int r2, ByteString r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r3, PluralRules.KEYWORD_OTHER);
        return r3.rangeEquals(r4, r1.getData$okio(), r2, r5);
    }

    public static final boolean commonRangeEquals(ByteString r1, int r2, byte[] r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r3, PluralRules.KEYWORD_OTHER);
        if (r2 >= 0) goto L5;
    L12:
        return false;
    L5:
        if (r2 > (r1.getData$okio().length - r5)) goto L12;
        if (r4 < 0) goto L12;
        if (r4 > (r3.length - r5)) goto L12;
        if (_UtilKt.arrayRangeEquals(r1.getData$okio(), r2, r3, r4, r5) == false) goto L12;
        return true;
    }

    public static final void commonCopyInto(ByteString r1, int r2, byte[] r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r3, "target");
        ArraysKt.copyInto(r1.getData$okio(), r3, r4, r2, r5 + r2);
    }

    public static final boolean commonStartsWith(ByteString r2, ByteString r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "prefix");
        return r2.rangeEquals(0, r3, 0, r3.size());
    }

    public static final boolean commonStartsWith(ByteString r2, byte[] r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "prefix");
        return r2.rangeEquals(0, r3, 0, r3.length);
    }

    public static final boolean commonEndsWith(ByteString r3, ByteString r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, PreferredSettingsUtils.OTHERS_SUFFIX_KEY);
        return r3.rangeEquals(r3.size() - r4.size(), r4, 0, r4.size());
    }

    public static final boolean commonEndsWith(ByteString r3, byte[] r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, PreferredSettingsUtils.OTHERS_SUFFIX_KEY);
        return r3.rangeEquals(r3.size() - r4.length, r4, 0, r4.length);
    }

    public static final int commonIndexOf(ByteString r4, byte[] r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, PluralRules.KEYWORD_OTHER);
        int r0 = r4.getData$okio().length - r5.length;
        int r7 = Math.max(r6, 0);
        if (r7 <= r0) goto L5;
        return -1;
    L5:
        if (_UtilKt.arrayRangeEquals(r4.getData$okio(), r7, r5, 0, r5.length) == true) goto L6;
        if (r7 == r0) goto L13;
        r7 = r7 + 1;
        goto L5
    L13:
        return -1;
    L6:
        return r7;
    }

    public static final int commonLastIndexOf(ByteString r1, ByteString r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, PluralRules.KEYWORD_OTHER);
        return r1.lastIndexOf(r2.internalArray$okio(), r3);
    }

    public static final int commonLastIndexOf(ByteString r3, byte[] r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, PluralRules.KEYWORD_OTHER);
        int r6 = Math.min(_UtilKt.resolveDefaultParameter(r3, r5), r3.getData$okio().length - r4.length);
    L4:
        if ((-1) >= r6) goto L9;
        if (_UtilKt.arrayRangeEquals(r3.getData$okio(), r6, r4, 0, r4.length) == true) goto L7;
        r6 = r6 - 1;
        goto L4
    L7:
        return r6;
    L9:
        return -1;
    }

    public static final boolean commonEquals(ByteString r4, Object r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        if (r5 != r4) goto L6;
        return true;
    L6:
        if ((r5 instanceof ByteString) == false) goto L13;
        ByteString r6 = (ByteString) r5;
        if (r6.size() != r4.getData$okio().length) goto L13;
        if (r6.rangeEquals(0, r4.getData$okio(), 0, r4.getData$okio().length) == false) goto L13;
        return true;
    L13:
        return false;
    }

    public static final int commonHashCode(ByteString r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        int r0 = r1.getHashCode$okio();
        if (r0 == 0) goto L5;
        return r0;
    L5:
        int r2 = Arrays.hashCode(r1.getData$okio());
        r1.setHashCode$okio(r2);
        return r2;
    }

    public static final int commonCompareTo(ByteString r9, ByteString r10) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        Intrinsics.checkNotNullParameter(r10, PluralRules.KEYWORD_OTHER);
        int r0 = r9.size();
        int r1 = r10.size();
        int r2 = Math.min(r0, r1);
        int r4 = 0;
    L4:
        if (r4 >= r2) goto L12;
        int r7 = r9.getByte(r4) & 255;
        int r8 = r10.getByte(r4) & 255;
        if (r7 != r8) goto L8;
        r4 = r4 + 1;
        goto L4
    L8:
        if (r7 >= r8) goto L11;
        return -1;
    L11:
        return 1;
    L12:
        if (r0 != r1) goto L14;
        return 0;
    L14:
        if (r0 >= r1) goto L17;
        return -1;
    L17:
        return 1;
    }

    public static final ByteString commonOf(byte[] r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        byte[] r3 = Arrays.copyOf(r2, r2.length);
        Intrinsics.checkNotNullExpressionValue(r3, "copyOf(this, size)");
        return new ByteString(r3);
    }

    public static final ByteString commonToByteString(byte[] r7, int r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        int r10 = _UtilKt.resolveDefaultParameter(r7, r9);
        _UtilKt.checkOffsetAndCount(r7.length, r8, r10);
        return new ByteString(ArraysKt.copyOfRange(r7, r8, r10 + r8));
    }

    public static final ByteString commonEncodeUtf8(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        ByteString r0 = new ByteString(_JvmPlatformKt.asUtf8ToByteArray(r2));
        r0.setUtf8$okio(r2);
        return r0;
    }

    public static final ByteString commonDecodeBase64(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        byte[] r2 = _Base64Kt.decodeBase64ToArray(r1);
        if (r2 != null) goto L7;
        return null;
    L7:
        return new ByteString(r2);
    }

    public static final ByteString commonDecodeHex(String r6) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        int r1 = 0;
        if ((r6.length() % 2) != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L13;
        int r2 = r6.length() / 2;
        byte[] r3 = new byte[r2];
    L8:
        if (r1 >= r2) goto L11;
        int r4 = r1 * 2;
        r3[r1] = (byte) ((access$decodeHexDigit(r6.charAt(r4)) << 4) + access$decodeHexDigit(r6.charAt(r4 + 1)));
        r1 = r1 + 1;
        goto L8
    L11:
        return new ByteString(r3);
    L13:
        throw new IllegalArgumentException(("Unexpected hex string: " + r6).toString());
    L5:
        r0 = false;
        goto L6
    }

    public static final void commonWrite(ByteString r1, Buffer r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "buffer");
        r2.write(r1.getData$okio(), r3, r4);
    }

    private static final int decodeHexDigit(char r4) {
        boolean r0 = true;
        if ('0' <= r4) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == true) goto L26;
        char r2 = 'a';
        if ('a' <= r4) goto L13;
    L15:
        boolean r5 = false;
    L16:
        if (r5 == true) goto L29;
        r2 = 'A';
        if ('A' <= r4) goto L21;
    L23:
        r0 = false;
    L24:
        if (r0 == true) goto L29;
        throw new IllegalArgumentException("Unexpected hex digit: " + r4);
    L21:
        if (r4 >= 'G') goto L23;
    L29:
        return (r4 - r2) + 10;
    L13:
        if (r4 >= 'g') goto L15;
        r5 = true;
        goto L16
    L26:
        return r4 - '0';
    L5:
        if (r4 >= ':') goto L7;
        r3 = true;
        goto L8
    }

    public static final String commonToString(ByteString r21) {
        ByteString r0 = r21;
        Intrinsics.checkNotNullParameter(r0, "<this>");
        boolean r2 = true;
        if (r21.getData$okio().length != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        return "[size=0]";
    L9:
        int r3 = access$codePointIndexToCharIndex(r21.getData$okio(), 64);
        if (r3 == (-1)) goto L12;
        String r4 = r21.utf8();
        String r9 = r4.substring(0, r3);
        Intrinsics.checkNotNullExpressionValue(r9, "this as java.lang.String…ing(startIndex, endIndex)");
        String r5 = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(r9, "\\", "\\\\", false, 4, null), "\n", "\\n", false, 4, null), "\r", "\\r", false, 4, null);
        if (r3 >= r4.length()) goto L38;
        return "[size=" + r21.getData$okio().length + " text=" + r5 + "…]";
    L38:
        return "[text=" + r5 + ']';
    L12:
        if (r21.getData$okio().length <= 64) goto L39;
        StringBuilder r6 = new StringBuilder("[size=").append(r21.getData$okio().length).append(" hex=");
        int r7 = _UtilKt.resolveDefaultParameter(r0, 64);
        if (r7 > r21.getData$okio().length) goto L17;
        boolean r8 = true;
    L18:
        if (r8 == false) goto L33;
        if ((r7 + 0) >= 0) goto L23;
        r2 = false;
    L23:
        if (r2 == false) goto L31;
        if (r7 == r21.getData$okio().length) goto L29;
        r0 = new ByteString(ArraysKt.copyOfRange(r21.getData$okio(), 0, r7));
    L29:
        return r6.append(r0.hex()).append("…]").toString();
    L31:
        throw new IllegalArgumentException("endIndex < beginIndex".toString());
    L33:
        throw new IllegalArgumentException(("endIndex > length(" + r21.getData$okio().length + ')').toString());
    L17:
        r8 = false;
        goto L18
    L39:
        return "[hex=" + r21.hex() + ']';
    L5:
        r1 = false;
        goto L6
    }

    private static final int codePointIndexToCharIndex(byte[] r19, int r20) {
        int r2 = r19.length;
        int r4 = 0;
        int r5 = 0;
        int r6 = 0;
    L3:
        if (r4 >= r2) goto L254;
        byte r7 = r19[r4];
        if (r7 >= 0) goto L6;
        if ((r7 >> 5) != (-2)) goto L108;
        int r3 = r4 + 1;
        if (r2 <= r3) goto L64;
        byte r8 = r19[r3];
        if ((r8 & 192) != 128) goto L70;
        boolean r15 = true;
    L71:
        if (r15 == false) goto L72;
        int r9 = (r8 ^ 3968) ^ (r7 << 6);
        if (r9 < 128) goto L77;
        int r10 = r6 + 1;
        if (r6 == r20) goto L82;
        if (r9 == 10) goto L99;
        if (r9 == 13) goto L99;
        if (r9 < 0) goto L88;
        if (r9 >= 32) goto L88;
        boolean r11 = true;
    L89:
        if (r11 == true) goto L97;
        if (127 > r9) goto L93;
        if (r9 >= 160) goto L93;
        boolean r12 = true;
    L94:
        if (r12 == true) goto L97;
        boolean r13 = false;
    L98:
        if (r13 == false) goto L99;
    L100:
        return -1;
    L93:
        r12 = false;
    L97:
        r13 = true;
    L88:
        r11 = false;
    L99:
        if (r9 == 65533) goto L100;
        if (r9 >= 65536) goto L104;
        int r16 = 1;
    L105:
        r5 = r5 + r16;
        Unit r14 = Unit.INSTANCE;
        r4 = r4 + 2;
    L106:
        r6 = r10;
        goto L3
    L104:
        r16 = 2;
        goto L105
    L82:
        return r5;
    L77:
        if (r6 != r20) goto L79;
        return r5;
    L79:
        return -1;
    L72:
        if (r6 != r20) goto L74;
        return r5;
    L74:
        return -1;
    L70:
        r15 = false;
        goto L71
    L64:
        if (r6 != r20) goto L66;
        return r5;
    L66:
        return -1;
    L108:
        if ((r7 >> 4) != (-2)) goto L173;
        int r17 = r4 + 2;
        if (r2 <= r17) goto L111;
        byte r18 = r19[r4 + 1];
        if ((r18 & 192) != 128) goto L117;
        boolean r21 = true;
    L118:
        if (r21 == false) goto L119;
        byte r22 = r19[r17];
        if ((r22 & 192) != 128) goto L125;
        boolean r23 = true;
    L126:
        if (r23 == false) goto L127;
        int r24 = ((r22 ^ (-123008)) ^ (r18 << 6)) ^ (r7 << 12);
        if (r24 < 2048) goto L132;
        if (55296 > r24) goto L138;
        if (r24 >= 57344) goto L138;
        boolean r25 = true;
    L139:
        if (r25 == true) goto L140;
        r10 = r6 + 1;
        if (r6 == r20) goto L145;
        if (r24 == 10) goto L165;
        if (r24 == 13) goto L165;
        if (r24 < 0) goto L151;
        if (r24 >= 32) goto L151;
        boolean r26 = true;
    L152:
        if (r26 == false) goto L154;
    L162:
        boolean r27 = true;
    L163:
        if (r27 == false) goto L165;
    L166:
        return -1;
    L154:
        if (127 <= r24) goto L156;
    L158:
        boolean r28 = false;
    L159:
        if (r28 == true) goto L162;
        r27 = false;
        goto L163
    L156:
        if (r24 >= 160) goto L158;
        r28 = true;
    L151:
        r26 = false;
    L165:
        if (r24 == 65533) goto L166;
        if (r24 >= 65536) goto L170;
        int r110 = 1;
    L171:
        r5 = r5 + r110;
        Unit r29 = Unit.INSTANCE;
        r4 = r4 + 3;
        goto L106
    L170:
        r110 = 2;
        goto L171
    L145:
        return r5;
    L140:
        if (r6 != r20) goto L142;
        return r5;
    L142:
        return -1;
    L138:
        r25 = false;
        goto L139
    L132:
        if (r6 != r20) goto L134;
        return r5;
    L134:
        return -1;
    L127:
        if (r6 != r20) goto L129;
        return r5;
    L129:
        return -1;
    L125:
        r23 = false;
        goto L126
    L119:
        if (r6 != r20) goto L121;
        return r5;
    L121:
        return -1;
    L117:
        r21 = false;
        goto L118
    L111:
        if (r6 != r20) goto L113;
        return r5;
    L113:
        return -1;
    L173:
        if ((r7 >> 3) != (-2)) goto L251;
        int r30 = r4 + 3;
        if (r2 <= r30) goto L176;
        byte r31 = r19[r4 + 1];
        if ((r31 & 192) != 128) goto L182;
        boolean r111 = true;
    L183:
        if (r111 == false) goto L184;
        byte r112 = r19[r4 + 2];
        if ((r112 & 192) != 128) goto L190;
        boolean r113 = true;
    L191:
        if (r113 == false) goto L192;
        byte r32 = r19[r30];
        if ((r32 & 192) != 128) goto L198;
        boolean r114 = true;
    L199:
        if (r114 == false) goto L200;
        int r33 = (((r32 ^ 3678080) ^ (r112 << 6)) ^ (r31 << 12)) ^ (r7 << 18);
        if (r33 > 1114111) goto L205;
        if (55296 > r33) goto L211;
        if (r33 >= 57344) goto L211;
        boolean r34 = true;
    L212:
        if (r34 == true) goto L213;
        if (r33 < 65536) goto L218;
        r10 = r6 + 1;
        if (r6 == r20) goto L223;
        if (r33 == 10) goto L244;
        if (r33 == 13) goto L244;
        if (r33 >= 0) goto L228;
    L230:
        boolean r35 = false;
    L231:
        if (r35 == false) goto L233;
    L241:
        boolean r36 = true;
    L242:
        if (r36 == false) goto L244;
    L245:
        return -1;
    L233:
        if (127 <= r33) goto L235;
    L237:
        boolean r37 = false;
    L238:
        if (r37 == true) goto L241;
        r36 = false;
        goto L242
    L235:
        if (r33 >= 160) goto L237;
        r37 = true;
        goto L238
    L228:
        if (r33 >= 32) goto L230;
        r35 = true;
    L244:
        if (r33 == 65533) goto L245;
        if (r33 >= 65536) goto L249;
        int r115 = 1;
    L250:
        r5 = r5 + r115;
        Unit r38 = Unit.INSTANCE;
        r4 = r4 + 4;
        goto L106
    L249:
        r115 = 2;
        goto L250
    L223:
        return r5;
    L218:
        if (r6 != r20) goto L220;
        return r5;
    L220:
        return -1;
    L213:
        if (r6 != r20) goto L215;
        return r5;
    L215:
        return -1;
    L211:
        r34 = false;
        goto L212
    L205:
        if (r6 != r20) goto L207;
        return r5;
    L207:
        return -1;
    L200:
        if (r6 != r20) goto L202;
        return r5;
    L202:
        return -1;
    L198:
        r114 = false;
        goto L199
    L192:
        if (r6 != r20) goto L194;
        return r5;
    L194:
        return -1;
    L190:
        r113 = false;
        goto L191
    L184:
        if (r6 != r20) goto L186;
        return r5;
    L186:
        return -1;
    L182:
        r111 = false;
        goto L183
    L176:
        if (r6 != r20) goto L178;
        return r5;
    L178:
        return -1;
    L251:
        if (r6 != r20) goto L253;
        return r5;
    L253:
        return -1;
    L6:
        int r116 = r6 + 1;
        if (r6 == r20) goto L8;
        if (r7 == 10) goto L25;
        if (r7 == 13) goto L25;
        if (r7 < 0) goto L14;
        if (r7 >= 32) goto L14;
        boolean r39 = true;
    L15:
        if (r39 == true) goto L23;
        if (127 > r7) goto L19;
        if (r7 >= 160) goto L19;
        boolean r40 = true;
    L20:
        if (r40 == true) goto L23;
        boolean r41 = false;
    L24:
        if (r41 == false) goto L25;
    L26:
        return -1;
    L19:
        r40 = false;
    L23:
        r41 = true;
    L14:
        r39 = false;
    L25:
        if (r7 == 65533) goto L26;
        if (r7 >= 65536) goto L29;
        int r42 = 1;
    L30:
        r5 = r5 + r42;
        r4 = r4 + 1;
    L31:
        r6 = r116;
        if (r4 >= r2) goto L3;
        byte r43 = r19[r4];
        if (r43 < 0) goto L3;
        r4 = r4 + 1;
        r116 = r6 + 1;
        if (r6 == r20) goto L37;
        if (r43 == 10) goto L54;
        if (r43 == 13) goto L54;
        if (r43 < 0) goto L43;
        if (r43 >= 32) goto L43;
        boolean r44 = true;
    L44:
        if (r44 == true) goto L52;
        if (127 > r43) goto L48;
        if (r43 >= 160) goto L48;
        boolean r45 = true;
    L49:
        if (r45 == true) goto L52;
        boolean r46 = false;
    L53:
        if (r46 == false) goto L54;
    L55:
        return -1;
    L48:
        r45 = false;
    L52:
        r46 = true;
    L43:
        r44 = false;
    L54:
        if (r43 == 65533) goto L55;
        if (r43 >= 65536) goto L58;
        int r47 = 1;
    L59:
        r5 = r5 + r47;
        goto L31
    L58:
        r47 = 2;
        goto L59
    L37:
        return r5;
    L29:
        r42 = 2;
        goto L30
    L8:
        return r5;
    L254:
        return r5;
    }
}
