package com.google.crypto.tink.shaded.protobuf;

import com.android.settings.CustomKeyUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
@CheckReturnValue
public abstract class ByteString implements Iterable<Byte>, Serializable {
    static final int CONCATENATE_BY_COPY_SIZE = 128;
    public static final ByteString EMPTY = null;
    static final int MAX_READ_FROM_CHUNK_SIZE = 8192;
    static final int MIN_READ_FROM_CHUNK_SIZE = 256;
    private static final int UNSIGNED_BYTE_MASK = 255;
    private static final Comparator<ByteString> UNSIGNED_LEXICOGRAPHICAL_COMPARATOR = null;
    private static final ByteArrayCopier byteArrayCopier = null;
    private static final long serialVersionUID = 1;
    private int hash;

    static abstract class AbstractByteIterator implements ByteIterator {
        AbstractByteIterator() {
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Byte next() {
            return next();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public final Byte next() {
            return Byte.valueOf(nextByte());
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private static final class ArraysByteArrayCopier implements ByteArrayCopier {
        private ArraysByteArrayCopier() {
        }

        /* synthetic */ ArraysByteArrayCopier(AnonymousClass1 r1) {
            this();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString.ByteArrayCopier
        public byte[] copyFrom(byte[] bytes, int offset, int size) {
            return Arrays.copyOfRange(bytes, offset, size + offset);
        }
    }

    private static final class BoundedByteString extends LiteralByteString {
        private static final long serialVersionUID = 1;
        private final int bytesLength;
        private final int bytesOffset;

        BoundedByteString(byte[] bytes, int offset, int length) {
            super(bytes);
            checkRange(offset, offset + length, bytes.length);
            this.bytesOffset = offset;
            this.bytesLength = length;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString.LiteralByteString, com.google.crypto.tink.shaded.protobuf.ByteString
        public byte byteAt(int index) {
            checkIndex(index, size());
            return this.bytes[this.bytesOffset + index];
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString.LiteralByteString, com.google.crypto.tink.shaded.protobuf.ByteString
        byte internalByteAt(int index) {
            return this.bytes[this.bytesOffset + index];
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString.LiteralByteString, com.google.crypto.tink.shaded.protobuf.ByteString
        public int size() {
            return this.bytesLength;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString.LiteralByteString
        protected int getOffsetIntoBytes() {
            return this.bytesOffset;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString.LiteralByteString, com.google.crypto.tink.shaded.protobuf.ByteString
        protected void copyToInternal(byte[] target, int sourceOffset, int targetOffset, int numberToCopy) {
            System.arraycopy(this.bytes, getOffsetIntoBytes() + sourceOffset, target, targetOffset, numberToCopy);
        }

        Object writeReplace() {
            return ByteString.wrap(toByteArray());
        }

        private void readObject(ObjectInputStream in) throws IOException {
            throw new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
        }
    }

    private interface ByteArrayCopier {
        byte[] copyFrom(byte[] bytes, int offset, int size);
    }

    public interface ByteIterator extends Iterator<Byte> {
        byte nextByte();
    }

    static final class CodedBuilder {
        private final byte[] buffer;
        private final CodedOutputStream output;

        /* synthetic */ CodedBuilder(int r1, AnonymousClass1 r2) {
            this(r1);
        }

        private CodedBuilder(int size) {
            byte[] r1 = new byte[size];
            this.buffer = r1;
            this.output = CodedOutputStream.newInstance(r1);
        }

        public ByteString build() {
            this.output.checkNoSpaceLeft();
            return new LiteralByteString(this.buffer);
        }

        public CodedOutputStream getCodedOutput() {
            return this.output;
        }
    }

    static abstract class LeafByteString extends ByteString {
        private static final long serialVersionUID = 1;

        abstract boolean equalsRange(ByteString other, int offset, int length);

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        protected final int getTreeDepth() {
            return 0;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        protected final boolean isBalanced() {
            return true;
        }

        LeafByteString() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator<Byte> iterator() {
            return super.iterator();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        void writeToReverse(ByteOutput byteOutput) throws IOException {
            writeTo(byteOutput);
        }
    }

    private static class LiteralByteString extends LeafByteString {
        private static final long serialVersionUID = 1;
        protected final byte[] bytes;

        protected int getOffsetIntoBytes() {
            return 0;
        }

        LiteralByteString(byte[] bytes) {
            bytes.getClass();
            this.bytes = bytes;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public byte byteAt(int index) {
            return this.bytes[index];
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        byte internalByteAt(int index) {
            return this.bytes[index];
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public int size() {
            return this.bytes.length;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public final ByteString substring(int beginIndex, int endIndex) {
            int r4 = checkRange(beginIndex, endIndex, size());
            if (r4 != 0) goto L7;
            return ByteString.EMPTY;
        L7:
            return new BoundedByteString(this.bytes, getOffsetIntoBytes() + beginIndex, r4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        protected void copyToInternal(byte[] target, int sourceOffset, int targetOffset, int numberToCopy) {
            System.arraycopy(this.bytes, sourceOffset, target, targetOffset, numberToCopy);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public final void copyTo(ByteBuffer target) {
            target.put(this.bytes, getOffsetIntoBytes(), size());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public final ByteBuffer asReadOnlyByteBuffer() {
            return ByteBuffer.wrap(this.bytes, getOffsetIntoBytes(), size()).asReadOnlyBuffer();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public final List<ByteBuffer> asReadOnlyByteBufferList() {
            return Collections.singletonList(asReadOnlyByteBuffer());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public final void writeTo(OutputStream outputStream) throws IOException {
            outputStream.write(toByteArray());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        final void writeToInternal(OutputStream outputStream, int sourceOffset, int numberToWrite) throws IOException {
            outputStream.write(this.bytes, getOffsetIntoBytes() + sourceOffset, numberToWrite);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        final void writeTo(ByteOutput output) throws IOException {
            output.writeLazy(this.bytes, getOffsetIntoBytes(), size());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        protected final String toStringInternal(Charset charset) {
            return new String(this.bytes, getOffsetIntoBytes(), size(), charset);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public final boolean isValidUtf8() {
            int r0 = getOffsetIntoBytes();
            return Utf8.isValidUtf8(this.bytes, r0, size() + r0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        protected final int partialIsValidUtf8(int state, int offset, int length) {
            int r0 = getOffsetIntoBytes() + offset;
            return Utf8.partialIsValidUtf8(state, this.bytes, r0, length + r0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public final boolean equals(Object other) {
            if (other != this) goto L6;
            return true;
        L6:
            if ((other instanceof ByteString) == true) goto L9;
            return false;
        L9:
            if (size() == ((ByteString) other).size()) goto L12;
            return false;
        L12:
            if (size() != 0) goto L15;
            return true;
        L15:
            if ((other instanceof LiteralByteString) == false) goto L24;
            LiteralByteString r5 = (LiteralByteString) other;
            int r0 = peekCachedHashCode();
            int r1 = r5.peekCachedHashCode();
            if (r0 == 0) goto L22;
            if (r1 == 0) goto L22;
            if (r0 == r1) goto L22;
            return false;
        L22:
            return equalsRange(r5, 0, size());
        L24:
            return other.equals(this);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString.LeafByteString
        final boolean equalsRange(ByteString other, int offset, int length) {
            if (length > other.size()) goto L21;
            int r0 = offset + length;
            if (r0 > other.size()) goto L19;
            if ((other instanceof LiteralByteString) == false) goto L17;
            LiteralByteString r5 = (LiteralByteString) other;
            byte[] r1 = this.bytes;
            byte[] r2 = r5.bytes;
            int r3 = getOffsetIntoBytes() + length;
            int r4 = getOffsetIntoBytes();
            int r6 = r5.getOffsetIntoBytes() + offset;
        L9:
            if (r4 >= r3) goto L14;
            if (r1[r4] != r2[r6]) goto L12;
            r4 = r4 + 1;
            r6 = r6 + 1;
            goto L9
        L12:
            return false;
        L14:
            return true;
        L17:
            return other.substring(offset, r0).equals(substring(0, length));
        L19:
            throw new IllegalArgumentException("Ran off end of other: " + offset + ", " + length + ", " + other.size());
        L21:
            throw new IllegalArgumentException("Length too large: " + length + size());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        protected final int partialHash(int h, int offset, int length) {
            return Internal.partialHash(h, this.bytes, getOffsetIntoBytes() + offset, length);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public final InputStream newInput() {
            return new ByteArrayInputStream(this.bytes, getOffsetIntoBytes(), size());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public final CodedInputStream newCodedInput() {
            return CodedInputStream.newInstance(this.bytes, getOffsetIntoBytes(), size(), true);
        }
    }

    public static final class Output extends OutputStream {
        private static final byte[] EMPTY_BYTE_ARRAY = null;
        private byte[] buffer;
        private int bufferPos;
        private final ArrayList<ByteString> flushedBuffers;
        private int flushedBuffersTotalBytes;
        private final int initialCapacity;

        static {
            EMPTY_BYTE_ARRAY = new byte[0];
        }

        Output(int initialCapacity) {
            if (initialCapacity < 0) goto L7;
            this.initialCapacity = initialCapacity;
            this.flushedBuffers = new ArrayList();
            this.buffer = new byte[initialCapacity];
            return;
        L7:
            throw new IllegalArgumentException("Buffer size < 0");
        }

        @Override // java.io.OutputStream
        public synchronized void write(int b) {
            monitor-enter(this);
        L9:
            th = move-exception;
            throw th;
        L4:
            if (this.bufferPos != this.buffer.length) goto L6;
            flushFullBuffer(1);     // Catch: Throwable -> L9
        L6:
            byte[] r0 = this.buffer;     // Catch: Throwable -> L9
            int r1 = this.bufferPos;     // Catch: Throwable -> L9
            this.bufferPos = r1 + 1;     // Catch: Throwable -> L9
            r0[r1] = (byte) b;     // Catch: Throwable -> L9
            monitor-exit(this);
        }

        @Override // java.io.OutputStream
        public synchronized void write(byte[] b, int offset, int length) {
            monitor-enter(this);
            byte[] r0 = this.buffer;     // Catch: Throwable -> L9
            int r1 = r0.length;     // Catch: Throwable -> L9
            int r2 = this.bufferPos;     // Catch: Throwable -> L9
            if (length > (r1 - r2)) goto L6;
            System.arraycopy(b, offset, r0, r2, length);     // Catch: Throwable -> L9
            this.bufferPos += length;     // Catch: Throwable -> L9
        L7:
            monitor-exit(this);
            return;
        L6:
            int r3 = r0.length - r2;     // Catch: Throwable -> L9
            System.arraycopy(b, offset, r0, r2, r3);     // Catch: Throwable -> L9
            int r6 = length - r3;     // Catch: Throwable -> L9
            flushFullBuffer(r6);     // Catch: Throwable -> L9
            System.arraycopy(b, offset + r3, this.buffer, 0, r6);     // Catch: Throwable -> L9
            this.bufferPos = r6;     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            throw th;
        }

        public synchronized ByteString toByteString() {
            monitor-enter(this);
            flushLastBuffer();     // Catch: Throwable -> L6
            ByteString r0 = ByteString.copyFrom(this.flushedBuffers);     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }

        public void writeTo(OutputStream out) throws IOException {
            monitor-enter(this);
            int r1 = 0;
            ByteString[] r0 = (ByteString[]) this.flushedBuffers.toArray(new ByteString[0]);     // Catch: Throwable -> L10
            byte[] r2 = this.buffer;     // Catch: Throwable -> L10
            int r3 = this.bufferPos;     // Catch: Throwable -> L10
            monitor-exit(this);     // Catch: Throwable -> L10
            int r5 = r0.length;
        L6:
            if (r1 >= r5) goto L8;
            r0[r1].writeTo(out);
            r1 = r1 + 1;
            goto L6
        L8:
            out.write(Arrays.copyOf(r2, r3));
            return;
        L10:
            th = move-exception;
            throw th;
        }

        public synchronized int size() {
            monitor-enter(this);
            int r0 = this.flushedBuffersTotalBytes + this.bufferPos;
            monitor-exit(this);
            return r0;
        L7:
            th = move-exception;
            throw th;
        }

        public synchronized void reset() {
            monitor-enter(this);
            this.flushedBuffers.clear();     // Catch: Throwable -> L6
            this.flushedBuffersTotalBytes = 0;     // Catch: Throwable -> L6
            this.bufferPos = 0;     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public String toString() {
            return String.format("<ByteString.Output@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())});
        }

        private void flushFullBuffer(int minSize) {
            this.flushedBuffers.add(new LiteralByteString(this.buffer));
            int r0 = this.flushedBuffersTotalBytes + this.buffer.length;
            this.flushedBuffersTotalBytes = r0;
            this.buffer = new byte[Math.max(this.initialCapacity, Math.max(minSize, r0 >>> 1))];
            this.bufferPos = 0;
        }

        private void flushLastBuffer() {
            int r0 = this.bufferPos;
            byte[] r1 = this.buffer;
            if (r0 >= r1.length) goto L6;
            if (r0 <= 0) goto L7;
            this.flushedBuffers.add(new LiteralByteString(Arrays.copyOf(r1, r0)));
        L7:
            this.flushedBuffersTotalBytes += this.bufferPos;
            this.bufferPos = 0;
            return;
        L6:
            this.flushedBuffers.add(new LiteralByteString(this.buffer));
            this.buffer = EMPTY_BYTE_ARRAY;
            goto L7
        }
    }

    private static final class SystemByteArrayCopier implements ByteArrayCopier {
        private SystemByteArrayCopier() {
        }

        /* synthetic */ SystemByteArrayCopier(AnonymousClass1 r1) {
            this();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString.ByteArrayCopier
        public byte[] copyFrom(byte[] bytes, int offset, int size) {
            byte[] r1 = new byte[size];
            System.arraycopy(bytes, offset, r1, 0, size);
            return r1;
        }
    }

    private static int hexDigit(char c) {
        if (c >= '0') goto L5;
    L8:
        char r0 = 'A';
        if (c >= 'A') goto L11;
    L14:
        r0 = 'a';
        if (c >= 'a') goto L17;
        return -1;
    L17:
        if (c <= 'f') goto L13;
        return -1;
    L13:
        return (c - r0) + 10;
    L11:
        if (c > 'F') goto L14;
    L5:
        if (c > '9') goto L8;
        return c - '0';
    }

    private static int toInt(byte value) {
        return value & 255;
    }

    public abstract ByteBuffer asReadOnlyByteBuffer();

    public abstract List<ByteBuffer> asReadOnlyByteBufferList();

    public abstract byte byteAt(int index);

    public abstract void copyTo(ByteBuffer target);

    protected abstract void copyToInternal(byte[] target, int sourceOffset, int targetOffset, int numberToCopy);

    public abstract boolean equals(Object o);

    protected abstract int getTreeDepth();

    abstract byte internalByteAt(int index);

    protected abstract boolean isBalanced();

    public abstract boolean isValidUtf8();

    public abstract CodedInputStream newCodedInput();

    public abstract InputStream newInput();

    protected abstract int partialHash(int h, int offset, int length);

    protected abstract int partialIsValidUtf8(int state, int offset, int length);

    public abstract int size();

    public abstract ByteString substring(int beginIndex, int endIndex);

    protected abstract String toStringInternal(Charset charset);

    abstract void writeTo(ByteOutput byteOutput) throws IOException;

    public abstract void writeTo(OutputStream out) throws IOException;

    abstract void writeToInternal(OutputStream out, int sourceOffset, int numberToWrite) throws IOException;

    abstract void writeToReverse(ByteOutput byteOutput) throws IOException;

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: iterator, reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ Iterator<Byte> iterator2() {
        return iterator();
    }

    static /* synthetic */ int access$200(byte r0) {
        return toInt(r0);
    }

    static {
        EMPTY = new LiteralByteString(Internal.EMPTY_BYTE_ARRAY);
        AnonymousClass1 r1 = null;
        if (Android.isOnAndroidDevice() == false) goto L5;
        ByteArrayCopier r0 = new SystemByteArrayCopier(r1);
    L6:
        byteArrayCopier = r0;
        UNSIGNED_LEXICOGRAPHICAL_COMPARATOR = new AnonymousClass2();
        return;
    L5:
        r0 = new ArraysByteArrayCopier(r1);
        goto L6
    }

    ByteString() {
        this.hash = 0;
    }

    @Override // java.lang.Iterable
    public Iterator<Byte> iterator() {
        return new AnonymousClass1(this);
    }

    public final boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final ByteString empty() {
        return EMPTY;
    }

    private static int extractHexDigit(String hexString, int index) {
        int r0 = hexDigit(hexString.charAt(index));
        if (r0 == (-1)) goto L6;
        return r0;
    L6:
        throw new NumberFormatException("Invalid hexString " + hexString + " must only contain [0-9a-fA-F] but contained " + hexString.charAt(index) + " at index " + index);
    }

    public static Comparator<ByteString> unsignedLexicographicalComparator() {
        return UNSIGNED_LEXICOGRAPHICAL_COMPARATOR;
    }

    public final ByteString substring(int beginIndex) {
        return substring(beginIndex, size());
    }

    public final boolean startsWith(ByteString prefix) {
        if (size() >= prefix.size()) goto L5;
        return false;
    L5:
        if (substring(0, prefix.size()).equals(prefix) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean endsWith(ByteString suffix) {
        if (size() >= suffix.size()) goto L5;
    L7:
        return false;
    L5:
        if (substring(size() - suffix.size()).equals(suffix) == false) goto L7;
        return true;
    }

    public static ByteString fromHex(String hexString) {
        if ((hexString.length() % 2) != 0) goto L10;
        int r0 = hexString.length() / 2;
        byte[] r1 = new byte[r0];
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L8;
        int r3 = r2 * 2;
        r1[r2] = (byte) (extractHexDigit(hexString, r3 + 1) | (extractHexDigit(hexString, r3) << 4));
        r2 = r2 + 1;
        goto L5
    L8:
        return new LiteralByteString(r1);
    L10:
        throw new NumberFormatException("Invalid hexString " + hexString + " of length " + hexString.length() + " must be even.");
    }

    public static ByteString copyFrom(byte[] bytes, int offset, int size) {
        checkRange(offset, offset + size, bytes.length);
        return new LiteralByteString(byteArrayCopier.copyFrom(bytes, offset, size));
    }

    public static ByteString copyFrom(byte[] bytes) {
        return copyFrom(bytes, 0, bytes.length);
    }

    static ByteString wrap(ByteBuffer buffer) {
        if (buffer.hasArray() == false) goto L7;
        int r0 = buffer.arrayOffset();
        return wrap(buffer.array(), r0 + buffer.position(), buffer.remaining());
    L7:
        return new NioByteString(buffer);
    }

    static ByteString wrap(byte[] bytes) {
        return new LiteralByteString(bytes);
    }

    static ByteString wrap(byte[] bytes, int offset, int length) {
        return new BoundedByteString(bytes, offset, length);
    }

    public static ByteString copyFrom(ByteBuffer bytes, int size) {
        checkRange(0, size, bytes.remaining());
        byte[] r3 = new byte[size];
        bytes.get(r3);
        return new LiteralByteString(r3);
    }

    public static ByteString copyFrom(ByteBuffer bytes) {
        return copyFrom(bytes, bytes.remaining());
    }

    public static ByteString copyFrom(String text, String charsetName) throws UnsupportedEncodingException {
        return new LiteralByteString(text.getBytes(charsetName));
    }

    public static ByteString copyFrom(String text, Charset charset) {
        return new LiteralByteString(text.getBytes(charset));
    }

    public static ByteString copyFromUtf8(String text) {
        return new LiteralByteString(text.getBytes(Internal.UTF_8));
    }

    public static ByteString readFrom(InputStream streamToDrain) throws IOException {
        return readFrom(streamToDrain, 256, 8192);
    }

    public static ByteString readFrom(InputStream streamToDrain, int chunkSize) throws IOException {
        return readFrom(streamToDrain, chunkSize, chunkSize);
    }

    public static ByteString readFrom(InputStream streamToDrain, int minChunkSize, int maxChunkSize) throws IOException {
        ArrayList r0 = new ArrayList();
    L3:
        ByteString r1 = readChunk(streamToDrain, minChunkSize);
        if (r1 == null) goto L6;
        r0.add(r1);
        minChunkSize = Math.min(minChunkSize * 2, maxChunkSize);
        goto L3
    L6:
        return copyFrom(r0);
    }

    private static ByteString readChunk(InputStream in, final int chunkSize) throws IOException {
        byte[] r0 = new byte[chunkSize];
        int r2 = 0;
    L3:
        if (r2 >= chunkSize) goto L8;
        int r3 = in.read(r0, r2, chunkSize - r2);
        if (r3 == (-1)) goto L8;
        r2 = r2 + r3;
    L8:
        if (r2 != 0) goto L12;
        return null;
    L12:
        return copyFrom(r0, 0, r2);
    }

    public final ByteString concat(ByteString other) {
        if ((Integer.MAX_VALUE - size()) < other.size()) goto L7;
        return RopeByteString.concatenate(this, other);
    L7:
        throw new IllegalArgumentException("ByteString would be too long: " + size() + CustomKeyUtils.KEY_SEPARATE_FOR_SHOW + other.size());
    }

    public static ByteString copyFrom(Iterable<ByteString> byteStrings) {
        if ((byteStrings instanceof Collection) == true) goto L8;
        Iterator<ByteString> r0 = byteStrings.iterator();
        int r1 = 0;
    L6:
        if (r0.hasNext() == false) goto L9;
        r0.next();
        r1 = r1 + 1;
    L9:
        if (r1 != 0) goto L13;
        return EMPTY;
    L13:
        return balancedConcat(byteStrings.iterator(), r1);
    L8:
        r1 = ((Collection) byteStrings).size();
        goto L9
    }

    private static ByteString balancedConcat(Iterator<ByteString> iterator, int length) {
        if (length < 1) goto L9;
        if (length == 1) goto L10;
        int r0 = length >>> 1;
        return balancedConcat(iterator, r0).concat(balancedConcat(iterator, length - r0));
    L10:
        return iterator.next();
    L9:
        throw new IllegalArgumentException(String.format("length (%s) must be >= 1", new Object[]{Integer.valueOf(length)}));
    }

    public void copyTo(byte[] target, int offset) {
        copyTo(target, 0, offset, size());
    }

    @Deprecated
    public final void copyTo(byte[] target, int sourceOffset, int targetOffset, int numberToCopy) {
        checkRange(sourceOffset, sourceOffset + numberToCopy, size());
        checkRange(targetOffset, targetOffset + numberToCopy, target.length);
        if (numberToCopy <= 0) goto L6;
        copyToInternal(target, sourceOffset, targetOffset, numberToCopy);
        return;
    }

    public final byte[] toByteArray() {
        int r0 = size();
        if (r0 == 0) goto L5;
        byte[] r1 = new byte[r0];
        copyToInternal(r1, 0, 0, r0);
        return r1;
    L5:
        return Internal.EMPTY_BYTE_ARRAY;
    }

    final void writeTo(OutputStream out, int sourceOffset, int numberToWrite) throws IOException {
        checkRange(sourceOffset, sourceOffset + numberToWrite, size());
        if (numberToWrite <= 0) goto L6;
        writeToInternal(out, sourceOffset, numberToWrite);
        return;
    }

    public final String toString(String charsetName) throws UnsupportedEncodingException {
        return toString(Charset.forName(charsetName));
    L4:
        e = move-exception;
        UnsupportedEncodingException r0 = new UnsupportedEncodingException(charsetName);
        r0.initCause(e);
        throw r0;
    }

    public final String toString(Charset charset) {
        if (size() != 0) goto L6;
        return "";
    L6:
        return toStringInternal(charset);
    }

    public final String toStringUtf8() {
        return toString(Internal.UTF_8);
    }

    public final int hashCode() {
        int r0 = this.hash;
        if (r0 != 0) goto L8;
        int r1 = size();
        r0 = partialHash(r1, 0, r1);
        if (r0 != 0) goto L7;
        r0 = 1;
    L7:
        this.hash = r0;
    L8:
        return r0;
    }

    public static Output newOutput(int initialCapacity) {
        return new Output(initialCapacity);
    }

    public static Output newOutput() {
        return new Output(128);
    }

    static CodedBuilder newCodedBuilder(int size) {
        return new CodedBuilder(size, null);
    }

    protected final int peekCachedHashCode() {
        return this.hash;
    }

    static void checkIndex(int index, int size) {
        if (((size - (index + 1)) | index) >= 0) goto L9;
        if (index >= 0) goto L8;
        throw new ArrayIndexOutOfBoundsException("Index < 0: " + index);
    L8:
        throw new ArrayIndexOutOfBoundsException("Index > length: " + index + ", " + size);
    }

    static int checkRange(int startIndex, int endIndex, int size) {
        int r0 = endIndex - startIndex;
        if ((((startIndex | endIndex) | r0) | (size - endIndex)) >= 0) goto L12;
        if (startIndex < 0) goto L11;
        if (endIndex >= startIndex) goto L9;
        throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + startIndex + ", " + endIndex);
    L9:
        throw new IndexOutOfBoundsException("End index: " + endIndex + " >= " + size);
    L11:
        throw new IndexOutOfBoundsException("Beginning index: " + startIndex + " < 0");
    L12:
        return r0;
    }

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()), truncateAndEscapeForDisplay()});
    }

    private String truncateAndEscapeForDisplay() {
        if (size() > 50) goto L6;
        return TextFormatEscaper.escapeBytes(this);
    L6:
        return TextFormatEscaper.escapeBytes(substring(0, 47)) + "...";
    }
}
