package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes4.dex */
final class RopeByteString extends ByteString {
    static final int[] minLengthByDepth = null;
    private static final long serialVersionUID = 1;
    private final ByteString left;
    private final int leftLength;
    private final ByteString right;
    private final int totalLength;
    private final int treeDepth;

    private static class Balancer {
        private final ArrayDeque<ByteString> prefixesStack;

        private Balancer() {
            this.prefixesStack = new ArrayDeque();
        }

        /* synthetic */ Balancer(AnonymousClass1 r1) {
            this();
        }

        static /* synthetic */ ByteString access$100(Balancer r0, ByteString r1, ByteString r2) {
            return r0.balance(r1, r2);
        }

        private ByteString balance(ByteString left, ByteString right) {
            doBalance(left);
            doBalance(right);
            ByteString r3 = this.prefixesStack.pop();
        L4:
            if (this.prefixesStack.isEmpty() == true) goto L6;
            r3 = new RopeByteString(this.prefixesStack.pop(), r3, null);
            goto L4
        L6:
            return r3;
        }

        private void doBalance(ByteString root) {
            if (root.isBalanced() == false) goto L6;
            insert(root);
            return;
        L6:
            if ((root instanceof RopeByteString) == false) goto L10;
            RopeByteString r3 = (RopeByteString) root;
            doBalance(RopeByteString.access$400(r3));
            doBalance(RopeByteString.access$500(r3));
            return;
        L10:
            throw new IllegalArgumentException("Has a new type of ByteString been created? Found " + root.getClass());
        }

        private void insert(ByteString byteString) {
            int r0 = getDepthBinForLength(byteString.size());
            int r1 = RopeByteString.minLength(r0 + 1);
            if (this.prefixesStack.isEmpty() == false) goto L5;
        L20:
            this.prefixesStack.push(byteString);
            return;
        L5:
            if (this.prefixesStack.peek().size() >= r1) goto L20;
            int r2 = RopeByteString.minLength(r0);
            ByteString r3 = this.prefixesStack.pop();
        L8:
            AnonymousClass1 r4 = null;
            if (this.prefixesStack.isEmpty() == true) goto L13;
            if (this.prefixesStack.peek().size() >= r2) goto L13;
            r3 = new RopeByteString(this.prefixesStack.pop(), r3, r4);
        L13:
            RopeByteString r5 = new RopeByteString(r3, byteString, r4);
        L15:
            if (this.prefixesStack.isEmpty() == true) goto L19;
            int r6 = RopeByteString.minLength(getDepthBinForLength(r5.size()) + 1);
            if (this.prefixesStack.peek().size() >= r6) goto L19;
            r5 = new RopeByteString(this.prefixesStack.pop(), r5, r4);
        L19:
            this.prefixesStack.push(r5);
        }

        private int getDepthBinForLength(int length) {
            int r0 = Arrays.binarySearch(RopeByteString.minLengthByDepth, length);
            if (r0 < 0) goto L5;
            return r0;
        L5:
            return (-(r0 + 1)) - 1;
        }
    }

    private static final class PieceIterator implements Iterator<ByteString.LeafByteString> {
        private final ArrayDeque<RopeByteString> breadCrumbs;
        private ByteString.LeafByteString next;

        /* synthetic */ PieceIterator(ByteString r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ ByteString.LeafByteString next() {
            return next();
        }

        private PieceIterator(ByteString root) {
            if ((root instanceof RopeByteString) == false) goto L5;
            RopeByteString r3 = (RopeByteString) root;
            ArrayDeque<RopeByteString> r0 = new ArrayDeque(r3.getTreeDepth());
            this.breadCrumbs = r0;
            r0.push(r3);
            this.next = getLeafByLeft(RopeByteString.access$400(r3));
            return;
        L5:
            this.breadCrumbs = null;
            this.next = (ByteString.LeafByteString) root;
        }

        private ByteString.LeafByteString getLeafByLeft(ByteString root) {
        L3:
            if ((root instanceof RopeByteString) == false) goto L6;
            RopeByteString r2 = (RopeByteString) root;
            this.breadCrumbs.push(r2);
            root = RopeByteString.access$400(r2);
            goto L3
        L6:
            return (ByteString.LeafByteString) root;
        }

        private ByteString.LeafByteString getNextNonEmptyLeaf() {
        L2:
            ArrayDeque<RopeByteString> r0 = this.breadCrumbs;
            if (r0 == null) goto L10;
            if (r0.isEmpty() == true) goto L16;
            ByteString.LeafByteString r1 = getLeafByLeft(RopeByteString.access$500(this.breadCrumbs.pop()));
            if (r1.isEmpty() == true) goto L2;
            return r1;
        L16:
            return null;
        L10:
            return null;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.next == null) goto L5;
            return true;
        L5:
            return false;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public ByteString.LeafByteString next() {
            ByteString.LeafByteString r0 = this.next;
            if (r0 == null) goto L7;
            this.next = getNextNonEmptyLeaf();
            return r0;
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class RopeInputStream extends InputStream {
        private ByteString.LeafByteString currentPiece;
        private int currentPieceIndex;
        private int currentPieceOffsetInRope;
        private int currentPieceSize;
        private int mark;
        private PieceIterator pieceIterator;
        final /* synthetic */ RopeByteString this$0;

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        public RopeInputStream(final RopeByteString this$0) {
            this.this$0 = this$0;
            initialize();
        }

        @Override // java.io.InputStream
        public int read(byte[] b, int offset, int length) {
            b.getClass();
            if (offset < 0) goto L16;
            if (length < 0) goto L16;
            if (length > (b.length - offset)) goto L16;
            int r2 = readSkipInternal(b, offset, length);
            if (r2 != 0) goto L14;
            if (length <= 0) goto L11;
            return -1;
        L11:
            if (availableInternal() != 0) goto L14;
            return -1;
        L14:
            return r2;
        L16:
            throw new IndexOutOfBoundsException();
        }

        @Override // java.io.InputStream
        public long skip(long length) {
            if (length < 0) goto L10;
            if (length <= 2147483647L) goto L8;
            length = 2147483647L;
        L8:
            return readSkipInternal(null, 0, (int) length);
        L10:
            throw new IndexOutOfBoundsException();
        }

        private int readSkipInternal(byte[] b, int offset, int length) {
            int r0 = length;
        L3:
            if (r0 <= 0) goto L12;
            advanceIfCurrentPieceFullyRead();
            if (this.currentPiece == null) goto L12;
            int r1 = Math.min(this.currentPieceSize - this.currentPieceIndex, r0);
            if (b == null) goto L10;
            this.currentPiece.copyTo(b, this.currentPieceIndex, offset, r1);
            offset = offset + r1;
        L10:
            this.currentPieceIndex += r1;
            r0 = r0 - r1;
        L12:
            return length - r0;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            advanceIfCurrentPieceFullyRead();
            ByteString.LeafByteString r0 = this.currentPiece;
            if (r0 != null) goto L6;
            return -1;
        L6:
            int r1 = this.currentPieceIndex;
            this.currentPieceIndex = r1 + 1;
            return r0.byteAt(r1) & 255;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return availableInternal();
        }

        @Override // java.io.InputStream
        public void mark(int readAheadLimit) {
            this.mark = this.currentPieceOffsetInRope + this.currentPieceIndex;
        }

        @Override // java.io.InputStream
        public synchronized void reset() {
            monitor-enter(this);
            initialize();     // Catch: Throwable -> L6
            readSkipInternal(null, 0, this.mark);     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        private void initialize() {
            PieceIterator r0 = new PieceIterator(this.this$0, null);
            this.pieceIterator = r0;
            ByteString.LeafByteString r1 = r0.next();
            this.currentPiece = r1;
            this.currentPieceSize = r1.size();
            this.currentPieceIndex = 0;
            this.currentPieceOffsetInRope = 0;
        }

        private void advanceIfCurrentPieceFullyRead() {
            if (this.currentPiece == null) goto L11;
            int r0 = this.currentPieceIndex;
            int r1 = this.currentPieceSize;
            if (r0 != r1) goto L12;
            this.currentPieceOffsetInRope += r1;
            this.currentPieceIndex = 0;
            if (this.pieceIterator.hasNext() == false) goto L9;
            ByteString.LeafByteString r2 = this.pieceIterator.next();
            this.currentPiece = r2;
            this.currentPieceSize = r2.size();
            return;
        L9:
            this.currentPiece = null;
            this.currentPieceSize = 0;
            return;
        L12:
            return;
        }

        private int availableInternal() {
            int r0 = this.currentPieceOffsetInRope + this.currentPieceIndex;
            return this.this$0.size() - r0;
        }
    }

    /* synthetic */ RopeByteString(ByteString r1, ByteString r2, AnonymousClass1 r3) {
        this(r1, r2);
    }

    static /* synthetic */ ByteString access$400(RopeByteString r0) {
        return r0.left;
    }

    static /* synthetic */ ByteString access$500(RopeByteString r0) {
        return r0.right;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString, java.lang.Iterable
    /* JADX INFO: renamed from: iterator, reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ Iterator<Byte> iterator2() {
        return iterator();
    }

    static {
        minLengthByDepth = new int[]{1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Integer.MAX_VALUE};
    }

    private RopeByteString(ByteString left, ByteString right) {
        this.left = left;
        this.right = right;
        int r0 = left.size();
        this.leftLength = r0;
        this.totalLength = r0 + right.size();
        this.treeDepth = Math.max(left.getTreeDepth(), right.getTreeDepth()) + 1;
    }

    static ByteString concatenate(ByteString left, ByteString right) {
        if (right.size() != 0) goto L6;
        return left;
    L6:
        if (left.size() != 0) goto L8;
        return right;
    L8:
        int r0 = left.size() + right.size();
        if (r0 >= 128) goto L13;
        return concatenateBytes(left, right);
    L13:
        if ((left instanceof RopeByteString) == false) goto L25;
        RopeByteString r2 = (RopeByteString) left;
        if ((r2.right.size() + right.size()) >= 128) goto L19;
        ByteString r5 = concatenateBytes(r2.right, right);
        return new RopeByteString(r2.left, r5);
    L19:
        if (r2.left.getTreeDepth() <= r2.right.getTreeDepth()) goto L25;
        if (r2.getTreeDepth() <= right.getTreeDepth()) goto L25;
        RopeByteString r6 = new RopeByteString(r2.right, right);
        return new RopeByteString(r2.left, r6);
    L25:
        if (r0 < minLength(Math.max(left.getTreeDepth(), right.getTreeDepth()) + 1)) goto L29;
        return new RopeByteString(left, right);
    L29:
        return Balancer.access$100(new Balancer(null), left, right);
    }

    private static ByteString concatenateBytes(ByteString left, ByteString right) {
        int r0 = left.size();
        int r1 = right.size();
        byte[] r2 = new byte[r0 + r1];
        left.copyTo(r2, 0, 0, r0);
        right.copyTo(r2, 0, r0, r1);
        return ByteString.wrap(r2);
    }

    static RopeByteString newInstanceForTest(ByteString left, ByteString right) {
        return new RopeByteString(left, right);
    }

    static int minLength(int depth) {
        int[] r0 = minLengthByDepth;
        if (depth < r0.length) goto L7;
        return Integer.MAX_VALUE;
    L7:
        return r0[depth];
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public byte byteAt(int index) {
        checkIndex(index, this.totalLength);
        return internalByteAt(index);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    byte internalByteAt(int index) {
        int r0 = this.leftLength;
        if (index >= r0) goto L7;
        return this.left.internalByteAt(index);
    L7:
        return this.right.internalByteAt(index - r0);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public int size() {
        return this.totalLength;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString, java.lang.Iterable
    public Iterator<Byte> iterator() {
        return new AnonymousClass1(this);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    protected int getTreeDepth() {
        return this.treeDepth;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    protected boolean isBalanced() {
        if (this.totalLength < minLength(this.treeDepth)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public ByteString substring(int beginIndex, int endIndex) {
        int r0 = checkRange(beginIndex, endIndex, this.totalLength);
        if (r0 != 0) goto L7;
        return ByteString.EMPTY;
    L7:
        if (r0 != this.totalLength) goto L9;
        return this;
    L9:
        int r1 = this.leftLength;
        if (endIndex <= r1) goto L12;
        if (beginIndex < r1) goto L17;
        return this.right.substring(beginIndex - r1, endIndex - r1);
    L17:
        return new RopeByteString(this.left.substring(beginIndex), this.right.substring(0, endIndex - this.leftLength));
    L12:
        return this.left.substring(beginIndex, endIndex);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    protected void copyToInternal(byte[] target, int sourceOffset, int targetOffset, int numberToCopy) {
        int r0 = sourceOffset + numberToCopy;
        int r1 = this.leftLength;
        if (r0 > r1) goto L5;
        this.left.copyToInternal(target, sourceOffset, targetOffset, numberToCopy);
        return;
    L5:
        if (sourceOffset < r1) goto L7;
        this.right.copyToInternal(target, sourceOffset - r1, targetOffset, numberToCopy);
        return;
    L7:
        int r2 = r1 - sourceOffset;
        this.left.copyToInternal(target, sourceOffset, targetOffset, r2);
        this.right.copyToInternal(target, 0, targetOffset + r2, numberToCopy - r2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public void copyTo(ByteBuffer target) {
        this.left.copyTo(target);
        this.right.copyTo(target);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public ByteBuffer asReadOnlyByteBuffer() {
        return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public List<ByteBuffer> asReadOnlyByteBufferList() {
        ArrayList r0 = new ArrayList();
        PieceIterator r1 = new PieceIterator(this, null);
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.add(r1.next().asReadOnlyByteBuffer());
        goto L4
    L6:
        return r0;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public void writeTo(OutputStream outputStream) throws IOException {
        this.left.writeTo(outputStream);
        this.right.writeTo(outputStream);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    void writeToInternal(OutputStream out, int sourceOffset, int numberToWrite) throws IOException {
        int r0 = sourceOffset + numberToWrite;
        int r1 = this.leftLength;
        if (r0 > r1) goto L5;
        this.left.writeToInternal(out, sourceOffset, numberToWrite);
        return;
    L5:
        if (sourceOffset < r1) goto L7;
        this.right.writeToInternal(out, sourceOffset - r1, numberToWrite);
        return;
    L7:
        int r2 = r1 - sourceOffset;
        this.left.writeToInternal(out, sourceOffset, r2);
        this.right.writeToInternal(out, 0, numberToWrite - r2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    void writeTo(ByteOutput output) throws IOException {
        this.left.writeTo(output);
        this.right.writeTo(output);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    void writeToReverse(ByteOutput output) throws IOException {
        this.right.writeToReverse(output);
        this.left.writeToReverse(output);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    protected String toStringInternal(Charset charset) {
        return new String(toByteArray(), charset);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public boolean isValidUtf8() {
        int r0 = this.left.partialIsValidUtf8(0, 0, this.leftLength);
        ByteString r3 = this.right;
        if (r3.partialIsValidUtf8(r0, 0, r3.size()) != 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    protected int partialIsValidUtf8(int state, int offset, int length) {
        int r0 = offset + length;
        int r1 = this.leftLength;
        if (r0 <= r1) goto L5;
        if (offset >= r1) goto L8;
        int r2 = r1 - offset;
        int r3 = this.left.partialIsValidUtf8(state, offset, r2);
        return this.right.partialIsValidUtf8(r3, 0, length - r2);
    L8:
        return this.right.partialIsValidUtf8(state, offset - r1, length);
    L5:
        return this.left.partialIsValidUtf8(state, offset, length);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public boolean equals(Object other) {
        if (other != this) goto L6;
        return true;
    L6:
        if ((other instanceof ByteString) == true) goto L8;
        return false;
    L8:
        ByteString r5 = (ByteString) other;
        if (this.totalLength == r5.size()) goto L12;
        return false;
    L12:
        if (this.totalLength != 0) goto L14;
        return true;
    L14:
        int r0 = peekCachedHashCode();
        int r1 = r5.peekCachedHashCode();
        if (r0 == 0) goto L20;
        if (r1 == 0) goto L20;
        if (r0 == r1) goto L20;
        return false;
    L20:
        return equalsFragments(r5);
    }

    private boolean equalsFragments(ByteString r12) {
        AnonymousClass1 r1 = null;
        PieceIterator r0 = new PieceIterator(this, r1);
        ByteString.LeafByteString r2 = r0.next();
        PieceIterator r3 = new PieceIterator(r12, r1);
        ByteString.LeafByteString r13 = r3.next();
        int r4 = 0;
        int r5 = 0;
        int r6 = 0;
    L3:
        int r7 = r2.size() - r4;
        int r8 = r13.size() - r5;
        int r9 = Math.min(r7, r8);
        if (r4 != 0) goto L6;
        boolean r10 = r2.equalsRange(r13, r5, r9);
    L7:
        if (r10 == false) goto L8;
        r6 = r6 + r9;
        int r11 = this.totalLength;
        if (r6 >= r11) goto L11;
        if (r9 != r7) goto L18;
        r4 = 0;
        r2 = r0.next();
    L19:
        if (r9 == r8) goto L20;
        r5 = r5 + r9;
        goto L3
    L20:
        r13 = r3.next();
        r5 = 0;
        goto L3
    L18:
        r4 = r4 + r9;
        r2 = r2;
        goto L19
    L11:
        if (r6 != r11) goto L15;
        return true;
    L15:
        throw new IllegalStateException();
    L8:
        return false;
    L6:
        r10 = r13.equalsRange(r2, r4, r9);
        goto L7
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    protected int partialHash(int h, int offset, int length) {
        int r0 = offset + length;
        int r1 = this.leftLength;
        if (r0 <= r1) goto L5;
        if (offset >= r1) goto L8;
        int r2 = r1 - offset;
        int r3 = this.left.partialHash(h, offset, r2);
        return this.right.partialHash(r3, 0, length - r2);
    L8:
        return this.right.partialHash(h, offset - r1, length);
    L5:
        return this.left.partialHash(h, offset, length);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public CodedInputStream newCodedInput() {
        return CodedInputStream.newInstance(asReadOnlyByteBufferList(), true);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public InputStream newInput() {
        return new RopeInputStream(this);
    }

    Object writeReplace() {
        return ByteString.wrap(toByteArray());
    }

    private void readObject(ObjectInputStream in) throws IOException {
        throw new InvalidObjectException("RopeByteStream instances are not to be serialized directly");
    }
}
