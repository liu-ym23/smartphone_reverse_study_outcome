package kotlin;

/* JADX INFO: compiled from: Numbers.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0005\n\u0002\u0010\n\n\u0002\b\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0003H\u0087\b\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0003H\u0087\b\u001a\r\u0010\u0005\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\r\u0010\u0005\u001a\u00020\u0001*\u00020\u0003H\u0087\b\u001a\u0014\u0010\u0006\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0007\u001a\u0014\u0010\u0006\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0001H\u0007\u001a\u0014\u0010\b\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0007\u001a\u0014\u0010\b\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0001H\u0007\u001a\r\u0010\t\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010\t\u001a\u00020\u0003*\u00020\u0003H\u0087\b\u001a\r\u0010\n\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010\n\u001a\u00020\u0003*\u00020\u0003H\u0087\b¨\u0006\u000b"}, d2 = {"countLeadingZeroBits", "", "", "", "countOneBits", "countTrailingZeroBits", "rotateLeft", "bitCount", "rotateRight", "takeHighestOneBit", "takeLowestOneBit", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/NumbersKt")
class NumbersKt__NumbersKt extends NumbersKt__NumbersJVMKt {
    public NumbersKt__NumbersKt() {
    }

    public static final byte rotateLeft(byte r1, int r2) {
        int r3 = r2 & 7;
        int r0 = r1 << r3;
        return (byte) (((r1 & 255) >>> (8 - r3)) | r0);
    }

    public static final short rotateLeft(short r2, int r3) {
        int r4 = r3 & 15;
        int r0 = r2 << r4;
        return (short) (((r2 & 65535) >>> (16 - r4)) | r0);
    }

    public static final byte rotateRight(byte r1, int r2) {
        int r3 = r2 & 7;
        int r0 = r1 << (8 - r3);
        return (byte) (((r1 & 255) >>> r3) | r0);
    }

    public static final short rotateRight(short r2, int r3) {
        int r4 = r3 & 15;
        int r0 = r2 << (16 - r4);
        return (short) (((r2 & 65535) >>> r4) | r0);
    }

    private static final int countOneBits(byte r0) {
        return Integer.bitCount(r0 & 255);
    }

    private static final int countLeadingZeroBits(byte r0) {
        return Integer.numberOfLeadingZeros(r0 & 255) - 24;
    }

    private static final int countTrailingZeroBits(byte r0) {
        return Integer.numberOfTrailingZeros(r0 | 256);
    }

    private static final byte takeHighestOneBit(byte r0) {
        return (byte) Integer.highestOneBit(r0 & 255);
    }

    private static final byte takeLowestOneBit(byte r0) {
        return (byte) Integer.lowestOneBit(r0);
    }

    private static final int countOneBits(short r1) {
        return Integer.bitCount(r1 & 65535);
    }

    private static final int countLeadingZeroBits(short r1) {
        return Integer.numberOfLeadingZeros(r1 & 65535) - 16;
    }

    private static final int countTrailingZeroBits(short r1) {
        return Integer.numberOfTrailingZeros(r1 | 65536);
    }

    private static final short takeHighestOneBit(short r1) {
        return (short) Integer.highestOneBit(r1 & 65535);
    }

    private static final short takeLowestOneBit(short r0) {
        return (short) Integer.lowestOneBit(r0);
    }
}
