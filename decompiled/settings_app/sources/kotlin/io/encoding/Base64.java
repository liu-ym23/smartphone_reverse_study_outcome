package kotlin.io.encoding;

import androidx.exifinterface.media.ExifInterface;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import okio.Utf8;

/* JADX INFO: compiled from: Base64.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0017\u0018\u0000 22\u00020\u0001:\u00012B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\b\rJ%\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u0013J \u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0011H\u0002J%\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u001bJ\"\u0010\u001c\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0011J\"\u0010\u001c\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0011J0\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J4\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\f2\b\b\u0002\u0010\u0017\u001a\u00020\u00112\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0011J4\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\f2\b\b\u0002\u0010\u0017\u001a\u00020\u00112\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0011J \u0010 \u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\"\u0010!\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0011J4\u0010\"\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\f2\b\b\u0002\u0010\u0017\u001a\u00020\u00112\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0011J5\u0010#\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0000¢\u0006\u0002\b$J\u0010\u0010%\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0011H\u0002J=\u0010&\u001a\u0002H'\"\f\b\u0000\u0010'*\u00060(j\u0002`)2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001e\u001a\u0002H'2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0011¢\u0006\u0002\u0010*J\"\u0010+\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0011J%\u0010,\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0000¢\u0006\u0002\b-J(\u0010.\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010/\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u00100\u001a\u00020\u0011H\u0002J \u00101\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0002R\u0014\u0010\u0004\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u00063"}, d2 = {"Lkotlin/io/encoding/Base64;", "", "isUrlSafe", "", "isMimeScheme", "(ZZ)V", "isMimeScheme$kotlin_stdlib", "()Z", "isUrlSafe$kotlin_stdlib", "bytesToStringImpl", "", "source", "", "bytesToStringImpl$kotlin_stdlib", "charsToBytesImpl", "", "startIndex", "", "endIndex", "charsToBytesImpl$kotlin_stdlib", "checkDestinationBounds", "", "destinationSize", "destinationOffset", "capacityNeeded", "checkSourceBounds", "sourceSize", "checkSourceBounds$kotlin_stdlib", "decode", "decodeImpl", "destination", "decodeIntoByteArray", "decodeSize", "encode", "encodeIntoByteArray", "encodeIntoByteArrayImpl", "encodeIntoByteArrayImpl$kotlin_stdlib", "encodeSize", "encodeToAppendable", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "([BLjava/lang/Appendable;II)Ljava/lang/Appendable;", "encodeToByteArray", "encodeToByteArrayImpl", "encodeToByteArrayImpl$kotlin_stdlib", "handlePaddingSymbol", "padIndex", "byteStart", "skipIllegalSymbolsIfMime", "Default", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class Base64 {
    public static final Default Default = null;
    private static final Base64 Mime = null;
    private static final Base64 UrlSafe = null;
    private static final int bitsPerByte = 8;
    private static final int bitsPerSymbol = 6;
    public static final int bytesPerGroup = 3;
    private static final int mimeGroupsPerLine = 19;
    public static final int mimeLineLength = 76;
    private static final byte[] mimeLineSeparatorSymbols = null;
    public static final byte padSymbol = 61;
    public static final int symbolsPerGroup = 4;
    private final boolean isMimeScheme;
    private final boolean isUrlSafe;

    /* JADX INFO: compiled from: Base64.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0005R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0080T¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lkotlin/io/encoding/Base64$Default;", "Lkotlin/io/encoding/Base64;", "()V", "Mime", "getMime", "()Lkotlin/io/encoding/Base64;", "UrlSafe", "getUrlSafe", "bitsPerByte", "", "bitsPerSymbol", "bytesPerGroup", "mimeGroupsPerLine", "mimeLineLength", "mimeLineSeparatorSymbols", "", "getMimeLineSeparatorSymbols$kotlin_stdlib", "()[B", "padSymbol", "", "symbolsPerGroup", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Default extends Base64 {
        public /* synthetic */ Default(DefaultConstructorMarker r1) {
            this();
        }

        private Default() {
            boolean r0 = false;
            super(r0, r0, null);
        }

        public final byte[] getMimeLineSeparatorSymbols$kotlin_stdlib() {
            return Base64.access$getMimeLineSeparatorSymbols$cp();
        }

        public final Base64 getUrlSafe() {
            return Base64.access$getUrlSafe$cp();
        }

        public final Base64 getMime() {
            return Base64.access$getMime$cp();
        }
    }

    public /* synthetic */ Base64(boolean r1, boolean r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    private Base64(boolean r1, boolean r2) {
        this.isUrlSafe = r1;
        this.isMimeScheme = r2;
        if (r1 == false) goto L7;
        if (r2 == false) goto L7;
        boolean r0 = false;
    L8:
        if (r0 == false) goto L11;
        return;
    L11:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L7:
        r0 = true;
        goto L8
    }

    public static final /* synthetic */ Base64 access$getMime$cp() {
        return Mime;
    }

    public static final /* synthetic */ byte[] access$getMimeLineSeparatorSymbols$cp() {
        return mimeLineSeparatorSymbols;
    }

    public static final /* synthetic */ Base64 access$getUrlSafe$cp() {
        return UrlSafe;
    }

    public final boolean isUrlSafe$kotlin_stdlib() {
        return this.isUrlSafe;
    }

    public final boolean isMimeScheme$kotlin_stdlib() {
        return this.isMimeScheme;
    }

    public static /* synthetic */ byte[] encodeToByteArray$default(Base64 r0, byte[] r1, int r2, int r3, int r4, Object r5) {
        if (r5 != null) goto L12;
        if ((r4 & 2) == 0) goto L7;
        r2 = 0;
    L7:
        if ((r4 & 4) == 0) goto L10;
        r3 = r1.length;
    L10:
        return r0.encodeToByteArray(r1, r2, r3);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeToByteArray");
    }

    public final byte[] encodeToByteArray(byte[] r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "source");
        return encodeToByteArrayImpl$kotlin_stdlib(r2, r3, r4);
    }

    public static /* synthetic */ int encodeIntoByteArray$default(Base64 r7, byte[] r8, byte[] r9, int r10, int r11, int r12, int r13, Object r14) {
        if (r14 != null) goto L17;
        if ((r13 & 4) == 0) goto L6;
        int r4 = 0;
    L8:
        if ((r13 & 8) == 0) goto L10;
        int r5 = 0;
    L12:
        if ((r13 & 16) == 0) goto L15;
        r12 = r8.length;
    L15:
        return r7.encodeIntoByteArray(r8, r9, r4, r5, r12);
    L10:
        r5 = r11;
        goto L12
    L6:
        r4 = r10;
        goto L8
    L17:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeIntoByteArray");
    }

    public final int encodeIntoByteArray(byte[] r2, byte[] r3, int r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r2, "source");
        Intrinsics.checkNotNullParameter(r3, "destination");
        return encodeIntoByteArrayImpl$kotlin_stdlib(r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ String encode$default(Base64 r0, byte[] r1, int r2, int r3, int r4, Object r5) {
        if (r5 != null) goto L12;
        if ((r4 & 2) == 0) goto L7;
        r2 = 0;
    L7:
        if ((r4 & 4) == 0) goto L10;
        r3 = r1.length;
    L10:
        return r0.encode(r1, r2, r3);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encode");
    }

    public final String encode(byte[] r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "source");
        return new String(encodeToByteArrayImpl$kotlin_stdlib(r2, r3, r4), Charsets.ISO_8859_1);
    }

    public static /* synthetic */ Appendable encodeToAppendable$default(Base64 r0, byte[] r1, Appendable r2, int r3, int r4, int r5, Object r6) {
        if (r6 != null) goto L12;
        if ((r5 & 4) == 0) goto L7;
        r3 = 0;
    L7:
        if ((r5 & 8) == 0) goto L10;
        r4 = r1.length;
    L10:
        return r0.encodeToAppendable(r1, r2, r3, r4);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeToAppendable");
    }

    public final <A extends Appendable> A encodeToAppendable(byte[] r2, A r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "source");
        Intrinsics.checkNotNullParameter(r3, "destination");
        r3.append(new String(encodeToByteArrayImpl$kotlin_stdlib(r2, r4, r5), Charsets.ISO_8859_1));
        return r3;
    }

    public static /* synthetic */ byte[] decode$default(Base64 r0, byte[] r1, int r2, int r3, int r4, Object r5) {
        if (r5 != null) goto L12;
        if ((r4 & 2) == 0) goto L7;
        r2 = 0;
    L7:
        if ((r4 & 4) == 0) goto L10;
        r3 = r1.length;
    L10:
        return r0.decode(r1, r2, r3);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decode");
    }

    public final byte[] decode(byte[] r9, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "source");
        checkSourceBounds$kotlin_stdlib(r9.length, r10, r11);
        int r0 = decodeSize(r9, r10, r11);
        byte[] r7 = new byte[r0];
        if (decodeImpl(r9, r7, 0, r10, r11) != r0) goto L5;
        boolean r8 = true;
    L6:
        if (r8 == false) goto L9;
        return r7;
    L9:
        throw new IllegalStateException("Check failed.".toString());
    L5:
        r8 = false;
        goto L6
    }

    public static /* synthetic */ int decodeIntoByteArray$default(Base64 r7, byte[] r8, byte[] r9, int r10, int r11, int r12, int r13, Object r14) {
        if (r14 != null) goto L17;
        if ((r13 & 4) == 0) goto L6;
        int r4 = 0;
    L8:
        if ((r13 & 8) == 0) goto L10;
        int r5 = 0;
    L12:
        if ((r13 & 16) == 0) goto L15;
        r12 = r8.length;
    L15:
        return r7.decodeIntoByteArray(r8, r9, r4, r5, r12);
    L10:
        r5 = r11;
        goto L12
    L6:
        r4 = r10;
        goto L8
    L17:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeIntoByteArray");
    }

    public final int decodeIntoByteArray(byte[] r3, byte[] r4, int r5, int r6, int r7) {
        Intrinsics.checkNotNullParameter(r3, "source");
        Intrinsics.checkNotNullParameter(r4, "destination");
        checkSourceBounds$kotlin_stdlib(r3.length, r6, r7);
        checkDestinationBounds(r4.length, r5, decodeSize(r3, r6, r7));
        return decodeImpl(r3, r4, r5, r6, r7);
    }

    public static /* synthetic */ byte[] decode$default(Base64 r0, CharSequence r1, int r2, int r3, int r4, Object r5) {
        if (r5 != null) goto L12;
        if ((r4 & 2) == 0) goto L7;
        r2 = 0;
    L7:
        if ((r4 & 4) == 0) goto L10;
        r3 = r1.length();
    L10:
        return r0.decode(r1, r2, r3);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decode");
    }

    public final byte[] decode(CharSequence r7, int r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "source");
        if ((r7 instanceof String) == false) goto L5;
        checkSourceBounds$kotlin_stdlib(r7.length(), r8, r9);
        String r10 = ((String) r7).substring(r8, r9);
        Intrinsics.checkNotNullExpressionValue(r10, "substring(...)");
        Charset r11 = Charsets.ISO_8859_1;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type java.lang.String");
        byte[] r12 = r10.getBytes(r11);
        Intrinsics.checkNotNullExpressionValue(r12, "getBytes(...)");
    L7:
        return decode$default(this, r12, 0, 0, 6, null);
    L5:
        r12 = charsToBytesImpl$kotlin_stdlib(r7, r8, r9);
        goto L7
    }

    public static /* synthetic */ int decodeIntoByteArray$default(Base64 r7, CharSequence r8, byte[] r9, int r10, int r11, int r12, int r13, Object r14) {
        if (r14 != null) goto L17;
        if ((r13 & 4) == 0) goto L6;
        int r4 = 0;
    L8:
        if ((r13 & 8) == 0) goto L10;
        int r5 = 0;
    L12:
        if ((r13 & 16) == 0) goto L15;
        r12 = r8.length();
    L15:
        return r7.decodeIntoByteArray(r8, r9, r4, r5, r12);
    L10:
        r5 = r11;
        goto L12
    L6:
        r4 = r10;
        goto L8
    L17:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeIntoByteArray");
    }

    public final int decodeIntoByteArray(CharSequence r9, byte[] r10, int r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r9, "source");
        Intrinsics.checkNotNullParameter(r10, "destination");
        if ((r9 instanceof String) == false) goto L5;
        checkSourceBounds$kotlin_stdlib(r9.length(), r12, r13);
        String r14 = ((String) r9).substring(r12, r13);
        Intrinsics.checkNotNullExpressionValue(r14, "substring(...)");
        Charset r15 = Charsets.ISO_8859_1;
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type java.lang.String");
        byte[] r16 = r14.getBytes(r15);
        Intrinsics.checkNotNullExpressionValue(r16, "getBytes(...)");
    L7:
        return decodeIntoByteArray$default(this, r16, r10, r11, 0, 0, 24, null);
    L5:
        r16 = charsToBytesImpl$kotlin_stdlib(r9, r12, r13);
        goto L7
    }

    public final byte[] encodeToByteArrayImpl$kotlin_stdlib(byte[] r8, int r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, "source");
        checkSourceBounds$kotlin_stdlib(r8.length, r9, r10);
        byte[] r0 = new byte[encodeSize(r10 - r9)];
        encodeIntoByteArrayImpl$kotlin_stdlib(r8, r0, 0, r9, r10);
        return r0;
    }

    public final int encodeIntoByteArrayImpl$kotlin_stdlib(byte[] r10, byte[] r11, int r12, int r13, int r14) {
        Intrinsics.checkNotNullParameter(r10, "source");
        Intrinsics.checkNotNullParameter(r11, "destination");
        checkSourceBounds$kotlin_stdlib(r10.length, r13, r14);
        checkDestinationBounds(r11.length, r12, encodeSize(r14 - r13));
        if (this.isUrlSafe == false) goto L5;
        byte[] r0 = Base64Kt.access$getBase64UrlEncodeMap$p();
    L7:
        if (this.isMimeScheme == false) goto L9;
        int r9 = 19;
    L10:
        int r1 = r12;
    L11:
        boolean r3 = false;
        if ((r13 + 2) >= r14) goto L19;
        int r2 = Math.min((r14 - r13) / 3, r9);
        int r5 = 0;
    L14:
        if (r5 >= r2) goto L16;
        int r6 = r13 + 1;
        int r7 = r6 + 1;
        int r15 = (((r10[r13] & 255) << 16) | ((r10[r6] & 255) << 8)) | (r10[r7] & 255);
        int r8 = r1 + 1;
        r11[r1] = r0[r15 >>> 18];
        int r4 = r8 + 1;
        r11[r8] = r0[(r15 >>> 12) & 63];
        int r16 = r4 + 1;
        r11[r4] = r0[(r15 >>> 6) & 63];
        r1 = r16 + 1;
        r11[r16] = r0[r15 & 63];
        r5 = r5 + 1;
        r13 = r7 + 1;
        goto L14
    L16:
        if (r2 != r9) goto L11;
        if (r13 == r14) goto L11;
        int r17 = r1 + 1;
        byte[] r18 = mimeLineSeparatorSymbols;
        r11[r1] = r18[0];
        r1 = r17 + 1;
        r11[r17] = r18[1];
        goto L11
    L19:
        int r19 = r14 - r13;
        if (r19 != 1) goto L22;
        int r20 = r13 + 1;
        int r110 = (r10[r13] & 255) << 4;
        int r111 = r1 + 1;
        r11[r1] = r0[r110 >>> 6];
        int r21 = r111 + 1;
        r11[r111] = r0[r110 & 63];
        int r112 = r21 + 1;
        r11[r21] = padSymbol;
        r1 = r112 + 1;
        r11[r112] = padSymbol;
        r13 = r20;
    L26:
        if (r13 != r14) goto L28;
        r3 = true;
    L28:
        if (r3 == false) goto L32;
        return r1 - r12;
    L32:
        throw new IllegalStateException("Check failed.".toString());
    L22:
        if (r19 != 2) goto L26;
        int r22 = r13 + 1;
        int r113 = r10[r13] & 255;
        int r23 = r22 + 1;
        int r24 = ((r10[r22] & 255) << 2) | (r113 << 10);
        int r114 = r1 + 1;
        r11[r1] = r0[r24 >>> 12];
        int r115 = r114 + 1;
        r11[r114] = r0[(r24 >>> 6) & 63];
        int r116 = r115 + 1;
        r11[r115] = r0[r24 & 63];
        r1 = r116 + 1;
        r11[r116] = padSymbol;
        r13 = r23;
        goto L26
    L9:
        r9 = Integer.MAX_VALUE;
        goto L10
    L5:
        r0 = Base64Kt.access$getBase64EncodeMap$p();
        goto L7
    }

    private final int encodeSize(int r1) {
        int r2 = ((r1 + 3) - 1) / 3;
        if (this.isMimeScheme == false) goto L5;
        int r0 = (r2 - 1) / 19;
    L6:
        int r3 = (r2 * 4) + (r0 * 2);
        if (r3 < 0) goto L10;
        return r3;
    L10:
        throw new IllegalArgumentException("Input is too big");
    L5:
        r0 = 0;
        goto L6
    }

    private final int decodeImpl(byte[] r19, byte[] r20, int r21, int r22, int r23) {
        if (this.isUrlSafe == false) goto L5;
        int[] r3 = Base64Kt.access$getBase64UrlDecodeMap$p();
    L6:
        int r4 = -8;
        int r8 = r21;
        int r7 = -8;
        int r6 = 0;
        int r5 = r22;
    L8:
        if (r5 >= r23) goto L29;
        if (r7 == r4) goto L11;
    L16:
        int r9 = r19[r5] & 255;
        int r14 = r3[r9];
        if (r14 >= 0) goto L25;
        if (r14 == (-2)) goto L19;
        if (this.isMimeScheme == false) goto L23;
        r5 = r5 + 1;
    L28:
        r4 = -8;
        goto L8
    L23:
        StringBuilder r1 = new StringBuilder("Invalid symbol '").append((char) r9).append("'(");
        String r2 = Integer.toString(r9, CharsKt.checkRadix(8));
        Intrinsics.checkNotNullExpressionValue(r2, "toString(...)");
        throw new IllegalArgumentException(r1.append(r2).append(") at index ").append(r5).toString());
    L19:
        r5 = handlePaddingSymbol(r19, r5, r23, r7);
        goto L29
    L25:
        r5 = r5 + 1;
        r6 = (r6 << 6) | r14;
        r7 = r7 + 6;
        if (r7 < 0) goto L28;
        r20[r8] = (byte) (r6 >>> r7);
        r6 = r6 & ((1 << r7) - 1);
        r7 = r7 - 8;
        r8 = r8 + 1;
        goto L28
    L11:
        if ((r5 + 3) >= r23) goto L16;
        int r15 = r5 + 1;
        int r10 = r3[r19[r5] & 255];
        int r16 = r15 + 1;
        int r17 = r3[r19[r15] & 255];
        int r18 = r16 + 1;
        int r11 = r3[r19[r16] & 255];
        int r110 = r18 + 1;
        int r12 = ((r11 << 6) | ((r10 << 18) | (r17 << 12))) | r3[r19[r18] & 255];
        if (r12 < 0) goto L15;
        int r13 = r8 + 1;
        r20[r8] = (byte) (r12 >> 16);
        int r24 = r13 + 1;
        r20[r13] = (byte) (r12 >> 8);
        r20[r24] = (byte) r12;
        r8 = r24 + 1;
        r5 = r110;
        goto L28
    L15:
        r5 = r110 - 4;
    L29:
        if (r7 == (-2)) goto L37;
        int r0 = skipIllegalSymbolsIfMime(r19, r5, r23);
        if (r0 >= r23) goto L33;
        int r25 = r19[r0] & 255;
        StringBuilder r26 = new StringBuilder("Symbol '").append((char) r25).append("'(");
        String r27 = Integer.toString(r25, CharsKt.checkRadix(8));
        Intrinsics.checkNotNullExpressionValue(r27, "toString(...)");
        throw new IllegalArgumentException(r26.append(r27).append(") at index ").append(r0 - 1).append(" is prohibited after the pad character").toString());
    L33:
        return r8 - r21;
    L37:
        throw new IllegalArgumentException("The last unit of input does not have enough bits");
    L5:
        r3 = Base64Kt.access$getBase64DecodeMap$p();
        goto L6
    }

    private final int decodeSize(byte[] r3, int r4, int r5) {
        int r0 = r5 - r4;
        if (r0 != 0) goto L7;
        return 0;
    L7:
        if (r0 == 1) goto L26;
        if (this.isMimeScheme == false) goto L19;
    L10:
        if (r4 >= r5) goto L24;
        int r2 = Base64Kt.access$getBase64DecodeMap$p()[r3[r4] & 255];
        if (r2 >= 0) goto L17;
        if (r2 == (-2)) goto L15;
        r0 = r0 - 1;
        goto L17
    L15:
        r0 = r0 - (r5 - r4);
    L17:
        r4 = r4 + 1;
    L24:
        return (int) ((((long) r0) * ((long) 6)) / ((long) 8));
    L19:
        if (r3[r5 - 1] != 61) goto L24;
        r0 = r0 - 1;
        if (r3[r5 - 2] != 61) goto L24;
        r0 = r0 - 1;
        goto L24
    L26:
        throw new IllegalArgumentException("Input should have at list 2 symbols for Base64 decoding, startIndex: " + r4 + ", endIndex: " + r5);
    }

    public final byte[] charsToBytesImpl$kotlin_stdlib(CharSequence r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "source");
        checkSourceBounds$kotlin_stdlib(r4.length(), r5, r6);
        byte[] r3 = new byte[r6 - r5];
        int r0 = 0;
    L3:
        if (r5 >= r6) goto L9;
        char r1 = r4.charAt(r5);
        if (r1 > 255) goto L7;
        r3[r0] = (byte) r1;
        r0 = r0 + 1;
    L8:
        r5 = r5 + 1;
        goto L3
    L7:
        r3[r0] = Utf8.REPLACEMENT_BYTE;
        r0 = r0 + 1;
        goto L8
    L9:
        return r3;
    }

    public final String bytesToStringImpl$kotlin_stdlib(byte[] r4) {
        Intrinsics.checkNotNullParameter(r4, "source");
        StringBuilder r3 = new StringBuilder(r4.length);
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r3.append((char) r4[r1]);
        r1 = r1 + 1;
        goto L3
    L5:
        String r5 = r3.toString();
        Intrinsics.checkNotNullExpressionValue(r5, "toString(...)");
        return r5;
    }

    private final int handlePaddingSymbol(byte[] r2, int r3, int r4, int r5) {
        if (r5 == (-8)) goto L23;
        if (r5 == (-6)) goto L21;
        if (r5 != (-4)) goto L9;
        int r1 = skipIllegalSymbolsIfMime(r2, r3 + 1, r4);
        if (r1 == r4) goto L19;
        if (r2[r1] != 61) goto L19;
        return r1 + 1;
    L19:
        throw new IllegalArgumentException("Missing one pad character at index " + r1);
    L9:
        if (r5 == (-2)) goto L21;
        throw new IllegalStateException("Unreachable".toString());
    L21:
        return r3 + 1;
    L23:
        throw new IllegalArgumentException("Redundant pad character at index " + r3);
    }

    private final int skipIllegalSymbolsIfMime(byte[] r2, int r3, int r4) {
        if (this.isMimeScheme == true) goto L5;
        return r3;
    L5:
        if (r3 >= r4) goto L10;
        int r1 = r2[r3] & 255;
        if (Base64Kt.access$getBase64DecodeMap$p()[r1] != (-1)) goto L8;
        r3 = r3 + 1;
        goto L5
    L8:
        return r3;
    L10:
        return r3;
    }

    public final void checkSourceBounds$kotlin_stdlib(int r1, int r2, int r3) {
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(r2, r3, r1);
    }

    private final void checkDestinationBounds(int r4, int r5, int r6) {
        if (r5 < 0) goto L12;
        if (r5 > r4) goto L12;
        int r0 = r5 + r6;
        if (r0 < 0) goto L10;
        if (r0 > r4) goto L10;
        return;
    L10:
        throw new IndexOutOfBoundsException("The destination array does not have enough capacity, destination offset: " + r5 + ", destination size: " + r4 + ", capacity needed: " + r6);
    L12:
        throw new IndexOutOfBoundsException("destination offset: " + r5 + ", destination size: " + r4);
    }

    static {
        Default = new Default(null);
        mimeLineSeparatorSymbols = new byte[]{13, 10};
        UrlSafe = new Base64(true, false);
        Mime = new Base64(false, true);
    }
}
