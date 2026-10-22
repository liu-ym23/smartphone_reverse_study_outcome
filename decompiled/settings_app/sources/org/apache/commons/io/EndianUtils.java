package org.apache.commons.io;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes6.dex */
public class EndianUtils {
    public static int swapInteger(int r2) {
        return (((((r2 >> 0) & 255) << 24) + (((r2 >> 8) & 255) << 16)) + (((r2 >> 16) & 255) << 8)) + (((r2 >> 24) & 255) << 0);
    }

    public static long swapLong(long r14) {
        return (((((((((r14 >> 0) & 255) << 56) + (((r14 >> 8) & 255) << 48)) + (((r14 >> 16) & 255) << 40)) + (((r14 >> 24) & 255) << 32)) + (((r14 >> 32) & 255) << 24)) + (((r14 >> 40) & 255) << 16)) + (((r14 >> 48) & 255) << 8)) + (((r14 >> 56) & 255) << 0);
    }

    public static short swapShort(short r1) {
        return (short) ((((r1 >> 0) & 255) << 8) + (((r1 >> 8) & 255) << 0));
    }

    public EndianUtils() {
    }

    public static float swapFloat(float r0) {
        return Float.intBitsToFloat(swapInteger(Float.floatToIntBits(r0)));
    }

    public static double swapDouble(double r0) {
        return Double.longBitsToDouble(swapLong(Double.doubleToLongBits(r0)));
    }

    public static void writeSwappedShort(byte[] r2, int r3, short r4) {
        r2[r3 + 0] = (byte) ((r4 >> 0) & 255);
        r2[r3 + 1] = (byte) ((r4 >> 8) & 255);
    }

    public static short readSwappedShort(byte[] r1, int r2) {
        return (short) (((r1[r2 + 0] & 255) << 0) + ((r1[r2 + 1] & 255) << 8));
    }

    public static int readSwappedUnsignedShort(byte[] r1, int r2) {
        return ((r1[r2 + 0] & 255) << 0) + ((r1[r2 + 1] & 255) << 8);
    }

    public static void writeSwappedInteger(byte[] r2, int r3, int r4) {
        r2[r3 + 0] = (byte) ((r4 >> 0) & 255);
        r2[r3 + 1] = (byte) ((r4 >> 8) & 255);
        r2[r3 + 2] = (byte) ((r4 >> 16) & 255);
        r2[r3 + 3] = (byte) ((r4 >> 24) & 255);
    }

    public static int readSwappedInteger(byte[] r2, int r3) {
        return ((((r2[r3 + 0] & 255) << 0) + ((r2[r3 + 1] & 255) << 8)) + ((r2[r3 + 2] & 255) << 16)) + ((r2[r3 + 3] & 255) << 24);
    }

    public static long readSwappedUnsignedInteger(byte[] r4, int r5) {
        return (((long) (r4[r5 + 3] & 255)) << 24) + (((((r4[r5 + 0] & 255) << 0) + ((r4[r5 + 1] & 255) << 8)) + ((r4[r5 + 2] & 255) << 16)) & 4294967295L);
    }

    public static void writeSwappedLong(byte[] r5, int r6, long r7) {
        r5[r6 + 0] = (byte) ((r7 >> 0) & 255);
        r5[r6 + 1] = (byte) ((r7 >> 8) & 255);
        r5[r6 + 2] = (byte) ((r7 >> 16) & 255);
        r5[r6 + 3] = (byte) ((r7 >> 24) & 255);
        r5[r6 + 4] = (byte) ((r7 >> 32) & 255);
        r5[r6 + 5] = (byte) ((r7 >> 40) & 255);
        r5[r6 + 6] = (byte) ((r7 >> 48) & 255);
        r5[r6 + 7] = (byte) ((r7 >> 56) & 255);
    }

    public static long readSwappedLong(byte[] r4, int r5) {
        return (((long) (((((r4[r5 + 4] & 255) << 0) + ((r4[r5 + 5] & 255) << 8)) + ((r4[r5 + 6] & 255) << 16)) + ((r4[r5 + 7] & 255) << 24))) << 32) + ((((((r4[r5 + 0] & 255) << 0) + ((r4[r5 + 1] & 255) << 8)) + ((r4[r5 + 2] & 255) << 16)) + ((r4[r5 + 3] & 255) << 24)) & 4294967295L);
    }

    public static void writeSwappedFloat(byte[] r0, int r1, float r2) {
        writeSwappedInteger(r0, r1, Float.floatToIntBits(r2));
    }

    public static float readSwappedFloat(byte[] r0, int r1) {
        return Float.intBitsToFloat(readSwappedInteger(r0, r1));
    }

    public static void writeSwappedDouble(byte[] r0, int r1, double r2) {
        writeSwappedLong(r0, r1, Double.doubleToLongBits(r2));
    }

    public static double readSwappedDouble(byte[] r0, int r1) {
        return Double.longBitsToDouble(readSwappedLong(r0, r1));
    }

    public static void writeSwappedShort(OutputStream r1, short r2) throws IOException {
        r1.write((byte) ((r2 >> 0) & 255));
        r1.write((byte) ((r2 >> 8) & 255));
    }

    public static short readSwappedShort(InputStream r1) throws IOException {
        return (short) (((read(r1) & 255) << 0) + ((read(r1) & 255) << 8));
    }

    public static int readSwappedUnsignedShort(InputStream r1) throws IOException {
        int r0 = read(r1);
        return ((r0 & 255) << 0) + ((read(r1) & 255) << 8);
    }

    public static void writeSwappedInteger(OutputStream r1, int r2) throws IOException {
        r1.write((byte) ((r2 >> 0) & 255));
        r1.write((byte) ((r2 >> 8) & 255));
        r1.write((byte) ((r2 >> 16) & 255));
        r1.write((byte) ((r2 >> 24) & 255));
    }

    public static int readSwappedInteger(InputStream r3) throws IOException {
        int r0 = read(r3);
        int r1 = read(r3);
        int r2 = read(r3);
        return ((((r0 & 255) << 0) + ((r1 & 255) << 8)) + ((r2 & 255) << 16)) + ((read(r3) & 255) << 24);
    }

    public static long readSwappedUnsignedInteger(InputStream r6) throws IOException {
        return (((long) (read(r6) & 255)) << 24) + (((((read(r6) & 255) << 0) + ((read(r6) & 255) << 8)) + ((read(r6) & 255) << 16)) & 4294967295L);
    }

    public static void writeSwappedLong(OutputStream r4, long r5) throws IOException {
        r4.write((byte) ((r5 >> 0) & 255));
        r4.write((byte) ((r5 >> 8) & 255));
        r4.write((byte) ((r5 >> 16) & 255));
        r4.write((byte) ((r5 >> 24) & 255));
        r4.write((byte) ((r5 >> 32) & 255));
        r4.write((byte) ((r5 >> 40) & 255));
        r4.write((byte) ((r5 >> 48) & 255));
        r4.write((byte) ((r5 >> 56) & 255));
    }

    public static long readSwappedLong(InputStream r5) throws IOException {
        byte[] r1 = new byte[8];
        int r3 = 0;
    L3:
        if (r3 >= 8) goto L6;
        r1[r3] = (byte) read(r5);
        r3 = r3 + 1;
        goto L3
    L6:
        return readSwappedLong(r1, 0);
    }

    public static void writeSwappedFloat(OutputStream r0, float r1) throws IOException {
        writeSwappedInteger(r0, Float.floatToIntBits(r1));
    }

    public static float readSwappedFloat(InputStream r0) throws IOException {
        return Float.intBitsToFloat(readSwappedInteger(r0));
    }

    public static void writeSwappedDouble(OutputStream r0, double r1) throws IOException {
        writeSwappedLong(r0, Double.doubleToLongBits(r1));
    }

    public static double readSwappedDouble(InputStream r2) throws IOException {
        return Double.longBitsToDouble(readSwappedLong(r2));
    }

    private static int read(InputStream r1) throws IOException {
        int r2 = r1.read();
        if ((-1) == r2) goto L6;
        return r2;
    L6:
        throw new EOFException("Unexpected EOF reached");
    }
}
