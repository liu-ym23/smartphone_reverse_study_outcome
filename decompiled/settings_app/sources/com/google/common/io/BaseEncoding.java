package com.google.common.io;

import com.google.common.base.Ascii;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.math.RoundingMode;
import java.util.Arrays;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public abstract class BaseEncoding {
    private static final BaseEncoding BASE16 = null;
    private static final BaseEncoding BASE32 = null;
    private static final BaseEncoding BASE32_HEX = null;
    private static final BaseEncoding BASE64 = null;
    private static final BaseEncoding BASE64_URL = null;

    private static final class Alphabet {
        final int bitsPerChar;
        final int bytesPerChunk;
        private final char[] chars;
        final int charsPerChunk;
        private final byte[] decodabet;
        final int mask;
        private final String name;
        private final boolean[] validPadding;

        static /* synthetic */ char[] access$000(Alphabet r0) {
            return r0.chars;
        }

        Alphabet(String r9, char[] r10) {
            this.name = (String) Preconditions.checkNotNull(r9);
            this.chars = (char[]) Preconditions.checkNotNull(r10);
            int r11 = IntMath.log2(r10.length, RoundingMode.UNNECESSARY);     // Catch: ArithmeticException -> L31
            this.bitsPerChar = r11;     // Catch: ArithmeticException -> L31
            int r0 = Math.min(8, Integer.lowestOneBit(r11));
            this.charsPerChunk = 8 / r0;     // Catch: ArithmeticException -> L24
            this.bytesPerChunk = r11 / r0;     // Catch: ArithmeticException -> L24
            this.mask = r10.length - 1;
            byte[] r1 = new byte[128];
            Arrays.fill(r1, (byte) -1);
            int r3 = 0;
            int r4 = 0;
        L8:
            if (r4 >= r10.length) goto L18;
            char r5 = r10[r4];
            if (r5 >= 128) goto L12;
            boolean r6 = true;
        L13:
            Preconditions.checkArgument(r6, "Non-ASCII character: %s", r5);
            if (r1[r5] != (-1)) goto L16;
            boolean r7 = true;
        L17:
            Preconditions.checkArgument(r7, "Duplicate character: %s", r5);
            r1[r5] = (byte) r4;
            r4 = r4 + 1;
            goto L8
        L16:
            r7 = false;
            goto L17
        L12:
            r6 = false;
            goto L13
        L18:
            this.decodabet = r1;
            boolean[] r12 = new boolean[this.charsPerChunk];
        L20:
            if (r3 >= this.bytesPerChunk) goto L22;
            r12[IntMath.divide(r3 * 8, this.bitsPerChar, RoundingMode.CEILING)] = true;
            r3 = r3 + 1;
            goto L20
        L22:
            this.validPadding = r12;
            return;
        L24:
            e = move-exception;
            String r2 = new String(r10);
            if (r2.length() == 0) goto L28;
            String r13 = "Illegal alphabet ".concat(r2);
        L30:
            throw new IllegalArgumentException(r13, e);
        L28:
            r13 = new String("Illegal alphabet ");
        L31:
            e = move-exception;
            throw new IllegalArgumentException(new StringBuilder(35).append("Illegal alphabet length ").append(r10.length).toString(), e);
        }

        char encode(int r1) {
            return this.chars[r1];
        }

        boolean isValidPaddingStartPosition(int r2) {
            return this.validPadding[r2 % this.charsPerChunk];
        }

        boolean canDecode(char r2) {
            if (r2 <= 127) goto L5;
        L7:
            return false;
        L5:
            if (this.decodabet[r2] == (-1)) goto L7;
            return true;
        }

        int decode(char r4) throws DecodingException {
            if (r4 <= 127) goto L10;
            String r5 = String.valueOf(Integer.toHexString(r4));
            if (r5.length() == 0) goto L7;
            String r6 = "Unrecognized character: 0x".concat(r5);
        L9:
            throw new DecodingException(r6);
        L7:
            r6 = new String("Unrecognized character: 0x");
            goto L9
        L10:
            byte r3 = this.decodabet[r4];
            if (r3 == (-1)) goto L13;
            return r3;
        L13:
            if (r4 <= ' ') goto L18;
            if (r4 == 127) goto L18;
            throw new DecodingException(new StringBuilder(25).append("Unrecognized character: ").append(r4).toString());
        L18:
            String r7 = String.valueOf(Integer.toHexString(r4));
            if (r7.length() == 0) goto L21;
            String r8 = "Unrecognized character: 0x".concat(r7);
        L23:
            throw new DecodingException(r8);
        L21:
            r8 = new String("Unrecognized character: 0x");
            goto L23
        }

        private boolean hasLowerCase() {
            char[] r4 = this.chars;
            int r0 = r4.length;
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L9;
            if (Ascii.isLowerCase(r4[r2]) == true) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return true;
        L9:
            return false;
        }

        private boolean hasUpperCase() {
            char[] r4 = this.chars;
            int r0 = r4.length;
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L9;
            if (Ascii.isUpperCase(r4[r2]) == true) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return true;
        L9:
            return false;
        }

        Alphabet upperCase() {
            if (hasLowerCase() == true) goto L5;
            return this;
        L5:
            Preconditions.checkState(!hasUpperCase(), "Cannot call upperCase() on a mixed-case alphabet");
            char[] r0 = new char[this.chars.length];
            int r1 = 0;
        L6:
            char[] r2 = this.chars;
            if (r1 >= r2.length) goto L10;
            r0[r1] = Ascii.toUpperCase(r2[r1]);
            r1 = r1 + 1;
            goto L6
        L10:
            return new Alphabet(String.valueOf(this.name).concat(".upperCase()"), r0);
        }

        Alphabet lowerCase() {
            if (hasUpperCase() == true) goto L5;
            return this;
        L5:
            Preconditions.checkState(!hasLowerCase(), "Cannot call lowerCase() on a mixed-case alphabet");
            char[] r0 = new char[this.chars.length];
            int r1 = 0;
        L6:
            char[] r2 = this.chars;
            if (r1 >= r2.length) goto L10;
            r0[r1] = Ascii.toLowerCase(r2[r1]);
            r1 = r1 + 1;
            goto L6
        L10:
            return new Alphabet(String.valueOf(this.name).concat(".lowerCase()"), r0);
        }

        public boolean matches(char r2) {
            byte[] r1 = this.decodabet;
            if (r2 < r1.length) goto L5;
        L7:
            return false;
        L5:
            if (r1[r2] == (-1)) goto L7;
            return true;
        }

        public String toString() {
            return this.name;
        }

        public boolean equals(@CheckForNull Object r2) {
            if ((r2 instanceof Alphabet) == true) goto L5;
            return false;
        L5:
            return Arrays.equals(this.chars, ((Alphabet) r2).chars);
        }

        public int hashCode() {
            return Arrays.hashCode(this.chars);
        }
    }

    static final class Base16Encoding extends StandardBaseEncoding {
        final char[] encoding;

        Base16Encoding(String r2, String r3) {
            this(new Alphabet(r2, r3.toCharArray()));
        }

        private Base16Encoding(Alphabet r5) {
            super(r5, null);
            this.encoding = new char[512];
            int r2 = 0;
            if (Alphabet.access$000(r5).length != 16) goto L5;
            boolean r0 = true;
        L6:
            Preconditions.checkArgument(r0);
        L8:
            if (r2 >= 256) goto L10;
            this.encoding[r2] = r5.encode(r2 >>> 4);
            this.encoding[r2 | 256] = r5.encode(r2 & 15);
            r2 = r2 + 1;
            goto L8
        L10:
            return;
        L5:
            r0 = false;
            goto L6
        }

        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding, com.google.common.io.BaseEncoding
        void encodeTo(Appendable r4, byte[] r5, int r6, int r7) throws IOException {
            Preconditions.checkNotNull(r4);
            Preconditions.checkPositionIndexes(r6, r6 + r7, r5.length);
            int r0 = 0;
        L3:
            if (r0 >= r7) goto L5;
            int r1 = r5[r6 + r0] & 255;
            r4.append(this.encoding[r1]);
            r4.append(this.encoding[r1 | 256]);
            r0 = r0 + 1;
            goto L3
        }

        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding, com.google.common.io.BaseEncoding
        int decodeTo(byte[] r6, CharSequence r7) throws DecodingException {
            Preconditions.checkNotNull(r6);
            if ((r7.length() % 2) == 1) goto L10;
            int r0 = 0;
            int r1 = 0;
        L6:
            if (r0 >= r7.length()) goto L8;
            r6[r1] = (byte) ((this.alphabet.decode(r7.charAt(r0)) << 4) | this.alphabet.decode(r7.charAt(r0 + 1)));
            r0 = r0 + 2;
            r1 = r1 + 1;
            goto L6
        L8:
            return r1;
        L10:
            throw new DecodingException(new StringBuilder(32).append("Invalid input length ").append(r7.length()).toString());
        }

        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding
        BaseEncoding newInstance(Alphabet r1, @CheckForNull Character r2) {
            return new Base16Encoding(r1);
        }
    }

    static final class Base64Encoding extends StandardBaseEncoding {
        Base64Encoding(String r2, String r3, @CheckForNull Character r4) {
            this(new Alphabet(r2, r3.toCharArray()), r4);
        }

        private Base64Encoding(Alphabet r1, @CheckForNull Character r2) {
            super(r1, r2);
            if (Alphabet.access$000(r1).length != 64) goto L5;
            boolean r0 = true;
        L6:
            Preconditions.checkArgument(r0);
            return;
        L5:
            r0 = false;
            goto L6
        }

        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding, com.google.common.io.BaseEncoding
        void encodeTo(Appendable r5, byte[] r6, int r7, int r8) throws IOException {
            Preconditions.checkNotNull(r5);
            int r0 = r7 + r8;
            Preconditions.checkPositionIndexes(r7, r0, r6.length);
        L4:
            if (r8 < 3) goto L6;
            int r1 = r7 + 1;
            int r2 = r1 + 1;
            int r9 = ((r6[r7] & 255) << 16) | ((r6[r1] & 255) << 8);
            int r10 = r9 | (r6[r2] & 255);
            r5.append(this.alphabet.encode(r10 >>> 18));
            r5.append(this.alphabet.encode((r10 >>> 12) & 63));
            r5.append(this.alphabet.encode((r10 >>> 6) & 63));
            r5.append(this.alphabet.encode(r10 & 63));
            r8 = r8 - 3;
            r7 = r2 + 1;
            goto L4
        L6:
            if (r7 >= r0) goto L10;
            encodeChunkTo(r5, r6, r7, r0 - r7);
            return;
        }

        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding, com.google.common.io.BaseEncoding
        int decodeTo(byte[] r6, CharSequence r7) throws DecodingException {
            Preconditions.checkNotNull(r6);
            CharSequence r8 = trimTrailingPadding(r7);
            if (this.alphabet.isValidPaddingStartPosition(r8.length()) == false) goto L16;
            int r0 = 0;
            int r1 = 0;
        L6:
            if (r0 >= r8.length()) goto L14;
            int r3 = r0 + 1;
            int r4 = r3 + 1;
            int r2 = (this.alphabet.decode(r8.charAt(r0)) << 18) | (this.alphabet.decode(r8.charAt(r3)) << 12);
            int r5 = r1 + 1;
            r6[r1] = (byte) (r2 >>> 16);
            if (r4 >= r8.length()) goto L13;
            int r9 = r4 + 1;
            int r10 = r2 | (this.alphabet.decode(r8.charAt(r4)) << 6);
            r1 = r5 + 1;
            r6[r5] = (byte) ((r10 >>> 8) & 255);
            if (r9 >= r8.length()) goto L12;
            r4 = r9 + 1;
            r5 = r1 + 1;
            r6[r1] = (byte) ((r10 | this.alphabet.decode(r8.charAt(r9))) & 255);
            goto L13
        L12:
            r0 = r9;
        L13:
            r1 = r5;
            r0 = r4;
            goto L6
        L14:
            return r1;
        L16:
            throw new DecodingException(new StringBuilder(32).append("Invalid input length ").append(r8.length()).toString());
        }

        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding
        BaseEncoding newInstance(Alphabet r1, @CheckForNull Character r2) {
            return new Base64Encoding(r1, r2);
        }
    }

    public static final class DecodingException extends IOException {
        DecodingException(String r1) {
            super(r1);
        }

        DecodingException(Throwable r1) {
            super(r1);
        }
    }

    static final class SeparatedBaseEncoding extends BaseEncoding {
        private final int afterEveryChars;
        private final BaseEncoding delegate;
        private final String separator;

        SeparatedBaseEncoding(BaseEncoding r1, String r2, int r3) {
            this.delegate = (BaseEncoding) Preconditions.checkNotNull(r1);
            this.separator = (String) Preconditions.checkNotNull(r2);
            this.afterEveryChars = r3;
            if (r3 <= 0) goto L5;
            boolean r0 = true;
        L6:
            Preconditions.checkArgument(r0, "Cannot add a separator after every %s chars", r3);
            return;
        L5:
            r0 = false;
            goto L6
        }

        @Override // com.google.common.io.BaseEncoding
        CharSequence trimTrailingPadding(CharSequence r1) {
            return this.delegate.trimTrailingPadding(r1);
        }

        @Override // com.google.common.io.BaseEncoding
        int maxEncodedSize(int r4) {
            int r5 = this.delegate.maxEncodedSize(r4);
            return r5 + (this.separator.length() * IntMath.divide(Math.max(0, r5 - 1), this.afterEveryChars, RoundingMode.FLOOR));
        }

        @Override // com.google.common.io.BaseEncoding
        public OutputStream encodingStream(Writer r3) {
            return this.delegate.encodingStream(separatingWriter(r3, this.separator, this.afterEveryChars));
        }

        @Override // com.google.common.io.BaseEncoding
        void encodeTo(Appendable r3, byte[] r4, int r5, int r6) throws IOException {
            this.delegate.encodeTo(separatingAppendable(r3, this.separator, this.afterEveryChars), r4, r5, r6);
        }

        @Override // com.google.common.io.BaseEncoding
        int maxDecodedSize(int r1) {
            return this.delegate.maxDecodedSize(r1);
        }

        @Override // com.google.common.io.BaseEncoding
        public boolean canDecode(CharSequence r5) {
            StringBuilder r0 = new StringBuilder();
            int r1 = 0;
        L4:
            if (r1 >= r5.length()) goto L10;
            char r2 = r5.charAt(r1);
            if (this.separator.indexOf(r2) >= 0) goto L8;
            r0.append(r2);
        L8:
            r1 = r1 + 1;
            goto L4
        L10:
            return this.delegate.canDecode(r0);
        }

        @Override // com.google.common.io.BaseEncoding
        int decodeTo(byte[] r5, CharSequence r6) throws DecodingException {
            StringBuilder r0 = new StringBuilder(r6.length());
            int r1 = 0;
        L4:
            if (r1 >= r6.length()) goto L10;
            char r2 = r6.charAt(r1);
            if (this.separator.indexOf(r2) >= 0) goto L8;
            r0.append(r2);
        L8:
            r1 = r1 + 1;
            goto L4
        L10:
            return this.delegate.decodeTo(r5, r0);
        }

        @Override // com.google.common.io.BaseEncoding
        public InputStream decodingStream(Reader r2) {
            return this.delegate.decodingStream(ignoringReader(r2, this.separator));
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding omitPadding() {
            return this.delegate.omitPadding().withSeparator(this.separator, this.afterEveryChars);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding withPadChar(char r2) {
            return this.delegate.withPadChar(r2).withSeparator(this.separator, this.afterEveryChars);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding withSeparator(String r1, int r2) {
            throw new UnsupportedOperationException("Already have a separator");
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding upperCase() {
            return this.delegate.upperCase().withSeparator(this.separator, this.afterEveryChars);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding lowerCase() {
            return this.delegate.lowerCase().withSeparator(this.separator, this.afterEveryChars);
        }

        public String toString() {
            String r0 = String.valueOf(this.delegate);
            String r1 = this.separator;
            int r4 = this.afterEveryChars;
            return new StringBuilder((String.valueOf(r0).length() + 31) + String.valueOf(r1).length()).append(r0).append(".withSeparator(\"").append(r1).append("\", ").append(r4).append(")").toString();
        }
    }

    static class StandardBaseEncoding extends BaseEncoding {
        final Alphabet alphabet;

        @CheckForNull
        @LazyInit
        private transient BaseEncoding lowerCase;

        @CheckForNull
        final Character paddingChar;

        @CheckForNull
        @LazyInit
        private transient BaseEncoding upperCase;

        StandardBaseEncoding(String r2, String r3, @CheckForNull Character r4) {
            this(new Alphabet(r2, r3.toCharArray()), r4);
        }

        StandardBaseEncoding(Alphabet r2, @CheckForNull Character r3) {
            this.alphabet = (Alphabet) Preconditions.checkNotNull(r2);
            if (r3 != null) goto L5;
        L8:
            boolean r4 = true;
        L9:
            Preconditions.checkArgument(r4, "Padding character %s was already in alphabet", r3);
            this.paddingChar = r3;
            return;
        L5:
            if (r2.matches(r3.charValue()) == false) goto L8;
            r4 = false;
            goto L9
        }

        @Override // com.google.common.io.BaseEncoding
        int maxEncodedSize(int r3) {
            return this.alphabet.charsPerChunk * IntMath.divide(r3, this.alphabet.bytesPerChunk, RoundingMode.CEILING);
        }

        @Override // com.google.common.io.BaseEncoding
        public OutputStream encodingStream(final Writer r2) {
            Preconditions.checkNotNull(r2);
            return new AnonymousClass1(this, r2);
        }

        @Override // com.google.common.io.BaseEncoding
        void encodeTo(Appendable r5, byte[] r6, int r7, int r8) throws IOException {
            Preconditions.checkNotNull(r5);
            Preconditions.checkPositionIndexes(r7, r7 + r8, r6.length);
            int r0 = 0;
        L3:
            if (r0 >= r8) goto L5;
            encodeChunkTo(r5, r6, r7 + r0, Math.min(this.alphabet.bytesPerChunk, r8 - r0));
            r0 = r0 + this.alphabet.bytesPerChunk;
            goto L3
        }

        void encodeChunkTo(Appendable r8, byte[] r9, int r10, int r11) throws IOException {
            Preconditions.checkNotNull(r8);
            Preconditions.checkPositionIndexes(r10, r10 + r11, r9.length);
            int r1 = 0;
            if (r11 > this.alphabet.bytesPerChunk) goto L5;
            boolean r0 = true;
        L6:
            Preconditions.checkArgument(r0);
            long r2 = 0;
            int r3 = 0;
        L8:
            if (r3 >= r11) goto L10;
            r2 = (r2 | ((long) (r9[r10 + r3] & 255))) << 8;
            r3 = r3 + 1;
            goto L8
        L10:
            int r12 = ((r11 + 1) * 8) - this.alphabet.bitsPerChar;
        L12:
            if (r1 >= (r11 * 8)) goto L15;
            r8.append(this.alphabet.encode(((int) (r2 >>> (r12 - r1))) & this.alphabet.mask));
            r1 = r1 + this.alphabet.bitsPerChar;
            goto L12
        L15:
            if (this.paddingChar != null) goto L17;
            return;
        L17:
            if (r1 >= (this.alphabet.bytesPerChunk * 8)) goto L23;
            r8.append(this.paddingChar.charValue());
            r1 = r1 + this.alphabet.bitsPerChar;
            goto L17
        L23:
            return;
        L5:
            r0 = false;
            goto L6
        }

        @Override // com.google.common.io.BaseEncoding
        int maxDecodedSize(int r3) {
            return (int) (((((long) this.alphabet.bitsPerChar) * ((long) r3)) + 7) / 8);
        }

        @Override // com.google.common.io.BaseEncoding
        CharSequence trimTrailingPadding(CharSequence r3) {
            Preconditions.checkNotNull(r3);
            Character r2 = this.paddingChar;
            if (r2 != null) goto L5;
            return r3;
        L5:
            char r4 = r2.charValue();
            int r0 = r3.length() - 1;
        L6:
            if (r0 < 0) goto L12;
            if (r3.charAt(r0) != r4) goto L12;
            r0 = r0 - 1;
        L12:
            return r3.subSequence(0, r0 + 1);
        }

        @Override // com.google.common.io.BaseEncoding
        public boolean canDecode(CharSequence r5) {
            Preconditions.checkNotNull(r5);
            CharSequence r6 = trimTrailingPadding(r5);
            if (this.alphabet.isValidPaddingStartPosition(r6.length()) == true) goto L5;
            return false;
        L5:
            int r0 = 0;
        L7:
            if (r0 >= r6.length()) goto L12;
            if (this.alphabet.canDecode(r6.charAt(r0)) == false) goto L10;
            r0 = r0 + 1;
            goto L7
        L10:
            return false;
        L12:
            return true;
        }

        @Override // com.google.common.io.BaseEncoding
        int decodeTo(byte[] r13, CharSequence r14) throws DecodingException {
            Preconditions.checkNotNull(r13);
            CharSequence r15 = trimTrailingPadding(r14);
            if (this.alphabet.isValidPaddingStartPosition(r15.length()) == false) goto L20;
            int r1 = 0;
            int r2 = 0;
        L6:
            if (r1 >= r15.length()) goto L18;
            long r3 = 0;
            int r5 = 0;
            int r6 = 0;
        L9:
            if (r5 >= this.alphabet.charsPerChunk) goto L14;
            r3 = r3 << this.alphabet.bitsPerChar;
            if ((r1 + r5) >= r15.length()) goto L13;
            r3 = r3 | ((long) this.alphabet.decode(r15.charAt(r6 + r1)));
            r6 = r6 + 1;
        L13:
            r5 = r5 + 1;
            goto L9
        L14:
            int r7 = (this.alphabet.bytesPerChunk * 8) - (r6 * this.alphabet.bitsPerChar);
            int r8 = (this.alphabet.bytesPerChunk - 1) * 8;
        L15:
            if (r8 < r7) goto L17;
            r13[r2] = (byte) ((r3 >>> r8) & 255);
            r8 = r8 - 8;
            r2 = r2 + 1;
            goto L15
        L17:
            r1 = r1 + this.alphabet.charsPerChunk;
            goto L6
        L18:
            return r2;
        L20:
            throw new DecodingException(new StringBuilder(32).append("Invalid input length ").append(r15.length()).toString());
        }

        @Override // com.google.common.io.BaseEncoding
        public InputStream decodingStream(final Reader r2) {
            Preconditions.checkNotNull(r2);
            return new AnonymousClass2(this, r2);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding omitPadding() {
            if (this.paddingChar != null) goto L6;
            return this;
        L6:
            return newInstance(this.alphabet, null);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding withPadChar(char r3) {
            if ((8 % this.alphabet.bitsPerChar) == 0) goto L11;
            Character r0 = this.paddingChar;
            if (r0 == null) goto L10;
            if (r0.charValue() != r3) goto L10;
            return this;
        L10:
            return newInstance(this.alphabet, Character.valueOf(r3));
        L11:
            return this;
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding withSeparator(String r6, int r7) {
            boolean r0 = false;
            int r1 = 0;
        L4:
            if (r1 >= r6.length()) goto L6;
            Preconditions.checkArgument(!this.alphabet.matches(r6.charAt(r1)), "Separator (%s) cannot contain alphabet characters", r6);
            r1 = r1 + 1;
            goto L4
        L6:
            Character r2 = this.paddingChar;
            if (r2 == null) goto L13;
            if (r6.indexOf(r2.charValue()) >= 0) goto L11;
            r0 = true;
        L11:
            Preconditions.checkArgument(r0, "Separator (%s) cannot contain padding character", r6);
        L13:
            return new SeparatedBaseEncoding(this, r6, r7);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding upperCase() {
            BaseEncoding r0 = this.upperCase;
            if (r0 != null) goto L9;
            Alphabet r1 = this.alphabet.upperCase();
            if (r1 != this.alphabet) goto L7;
            r0 = this;
        L8:
            this.upperCase = r0;
            goto L9
        L7:
            r0 = newInstance(r1, this.paddingChar);
        L9:
            return r0;
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding lowerCase() {
            BaseEncoding r0 = this.lowerCase;
            if (r0 != null) goto L9;
            Alphabet r1 = this.alphabet.lowerCase();
            if (r1 != this.alphabet) goto L7;
            r0 = this;
        L8:
            this.lowerCase = r0;
            goto L9
        L7:
            r0 = newInstance(r1, this.paddingChar);
        L9:
            return r0;
        }

        BaseEncoding newInstance(Alphabet r1, @CheckForNull Character r2) {
            return new StandardBaseEncoding(r1, r2);
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder("BaseEncoding.");
            r0.append(this.alphabet.toString());
            if ((8 % this.alphabet.bitsPerChar) == 0) goto L9;
            if (this.paddingChar != null) goto L7;
            r0.append(".omitPadding()");
            goto L9
        L7:
            r0.append(".withPadChar('").append(this.paddingChar).append("')");
        L9:
            return r0.toString();
        }

        public boolean equals(@CheckForNull Object r4) {
            if ((r4 instanceof StandardBaseEncoding) == false) goto L10;
            StandardBaseEncoding r5 = (StandardBaseEncoding) r4;
            if (this.alphabet.equals(r5.alphabet) == true) goto L7;
            return false;
        L7:
            if (Objects.equal(this.paddingChar, r5.paddingChar) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        public int hashCode() {
            return Objects.hashCode(new Object[]{this.paddingChar}) ^ this.alphabet.hashCode();
        }
    }

    public abstract boolean canDecode(CharSequence r1);

    abstract int decodeTo(byte[] r1, CharSequence r2) throws DecodingException;

    public abstract InputStream decodingStream(Reader r1);

    abstract void encodeTo(Appendable r1, byte[] r2, int r3, int r4) throws IOException;

    public abstract OutputStream encodingStream(Writer r1);

    public abstract BaseEncoding lowerCase();

    abstract int maxDecodedSize(int r1);

    abstract int maxEncodedSize(int r1);

    public abstract BaseEncoding omitPadding();

    public abstract BaseEncoding upperCase();

    public abstract BaseEncoding withPadChar(char r1);

    public abstract BaseEncoding withSeparator(String r1, int r2);

    BaseEncoding() {
    }

    public String encode(byte[] r3) {
        return encode(r3, 0, r3.length);
    }

    public final String encode(byte[] r3, int r4, int r5) {
        Preconditions.checkPositionIndexes(r4, r4 + r5, r3.length);
        StringBuilder r0 = new StringBuilder(maxEncodedSize(r5));
        encodeTo(r0, r3, r4, r5);     // Catch: IOException -> L6
        return r0.toString();
    L6:
        e = move-exception;
        throw new AssertionError(e);
    }

    public final ByteSink encodingSink(final CharSink r2) {
        Preconditions.checkNotNull(r2);
        return new AnonymousClass1(this, r2);
    }

    private static byte[] extract(byte[] r2, int r3) {
        if (r3 != r2.length) goto L5;
        return r2;
    L5:
        byte[] r0 = new byte[r3];
        System.arraycopy(r2, 0, r0, 0, r3);
        return r0;
    }

    public final byte[] decode(CharSequence r1) {
        return decodeChecked(r1);
    L4:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    final byte[] decodeChecked(CharSequence r2) throws DecodingException {
        CharSequence r3 = trimTrailingPadding(r2);
        byte[] r0 = new byte[maxDecodedSize(r3.length())];
        return extract(r0, decodeTo(r0, r3));
    }

    public final ByteSource decodingSource(final CharSource r2) {
        Preconditions.checkNotNull(r2);
        return new AnonymousClass2(this, r2);
    }

    CharSequence trimTrailingPadding(CharSequence r1) {
        return (CharSequence) Preconditions.checkNotNull(r1);
    }

    static {
        BASE64 = new Base64Encoding("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", '=');
        BASE64_URL = new Base64Encoding("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", '=');
        BASE32 = new StandardBaseEncoding("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", '=');
        BASE32_HEX = new StandardBaseEncoding("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", '=');
        BASE16 = new Base16Encoding("base16()", "0123456789ABCDEF");
    }

    public static BaseEncoding base64() {
        return BASE64;
    }

    public static BaseEncoding base64Url() {
        return BASE64_URL;
    }

    public static BaseEncoding base32() {
        return BASE32;
    }

    public static BaseEncoding base32Hex() {
        return BASE32_HEX;
    }

    public static BaseEncoding base16() {
        return BASE16;
    }

    static Reader ignoringReader(final Reader r1, final String r2) {
        Preconditions.checkNotNull(r1);
        Preconditions.checkNotNull(r2);
        return new AnonymousClass3(r1, r2);
    }

    static Appendable separatingAppendable(final Appendable r1, final String r2, final int r3) {
        Preconditions.checkNotNull(r1);
        Preconditions.checkNotNull(r2);
        if (r3 <= 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0);
        return new AnonymousClass4(r3, r1, r2);
    L5:
        r0 = false;
        goto L6
    }

    static Writer separatingWriter(final Writer r0, String r1, int r2) {
        final Appendable r3 = separatingAppendable(r0, r1, r2);
        return new AnonymousClass5(r3, r0);
    }
}
