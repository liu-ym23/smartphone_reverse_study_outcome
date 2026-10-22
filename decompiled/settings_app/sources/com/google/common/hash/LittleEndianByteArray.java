package com.google.common.hash;

import java.nio.ByteOrder;
import java.security.AccessController;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
final class LittleEndianByteArray {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final LittleEndianBytes byteArray = null;

    /* JADX INFO: renamed from: com.google.common.hash.LittleEndianByteArray$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static abstract enum JavaLittleEndianBytes extends Enum<JavaLittleEndianBytes> implements LittleEndianBytes {
        private static final /* synthetic */ JavaLittleEndianBytes[] $VALUES = null;
        public static final JavaLittleEndianBytes INSTANCE = null;

        private static /* synthetic */ JavaLittleEndianBytes[] $values() {
            return new JavaLittleEndianBytes[]{INSTANCE};
        }

        private JavaLittleEndianBytes(String r1, int r2) {
            super(r1, r2);
        }

        /* synthetic */ JavaLittleEndianBytes(String r1, int r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        public static JavaLittleEndianBytes valueOf(String r1) {
            return (JavaLittleEndianBytes) Enum.valueOf(JavaLittleEndianBytes.class, r1);
        }

        public static JavaLittleEndianBytes[] values() {
            return (JavaLittleEndianBytes[]) $VALUES.clone();
        }

        static {
            final String r1 = "INSTANCE";
            final int r2 = 0;
            INSTANCE = new AnonymousClass1(r1, r2);
            $VALUES = $values();
        }
    }

    private interface LittleEndianBytes {
        long getLongLittleEndian(byte[] r1, int r2);

        void putLongLittleEndian(byte[] r1, int r2, long r3);
    }

    private static abstract enum UnsafeByteArray extends Enum<UnsafeByteArray> implements LittleEndianBytes {
        private static final /* synthetic */ UnsafeByteArray[] $VALUES = null;
        private static final int BYTE_ARRAY_BASE_OFFSET = 0;
        public static final UnsafeByteArray UNSAFE_BIG_ENDIAN = null;
        public static final UnsafeByteArray UNSAFE_LITTLE_ENDIAN = null;
        private static final Unsafe theUnsafe = null;

        private static /* synthetic */ UnsafeByteArray[] $values() {
            return new UnsafeByteArray[]{UNSAFE_LITTLE_ENDIAN, UNSAFE_BIG_ENDIAN};
        }

        private UnsafeByteArray(String r1, int r2) {
            super(r1, r2);
        }

        /* synthetic */ UnsafeByteArray(String r1, int r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        static /* synthetic */ int access$100() {
            return BYTE_ARRAY_BASE_OFFSET;
        }

        static /* synthetic */ Unsafe access$200() {
            return theUnsafe;
        }

        public static UnsafeByteArray valueOf(String r1) {
            return (UnsafeByteArray) Enum.valueOf(UnsafeByteArray.class, r1);
        }

        public static UnsafeByteArray[] values() {
            return (UnsafeByteArray[]) $VALUES.clone();
        }

        static {
            final String r1 = "UNSAFE_LITTLE_ENDIAN";
            final int r2 = 0;
            UNSAFE_LITTLE_ENDIAN = new AnonymousClass1(r1, r2);
            final String r3 = "UNSAFE_BIG_ENDIAN";
            final int r4 = 1;
            UNSAFE_BIG_ENDIAN = new AnonymousClass2(r3, r4);
            $VALUES = $values();
            Unsafe r0 = getUnsafe();
            theUnsafe = r0;
            BYTE_ARRAY_BASE_OFFSET = r0.arrayBaseOffset(byte[].class);
            if (r0.arrayIndexScale(byte[].class) != 1) goto L6;
            return;
        L6:
            throw new AssertionError();
        }

        private static Unsafe getUnsafe() {
            return Unsafe.getUnsafe();
        L4:
            return (Unsafe) AccessController.doPrivileged(new AnonymousClass3());
        L6:
            e = move-exception;
            throw new RuntimeException("Could not initialize intrinsics", e.getCause());
        }
    }

    static long load64(byte[] r1, int r2) {
        return byteArray.getLongLittleEndian(r1, r2);
    }

    static long load64Safely(byte[] r7, int r8, int r9) {
        int r10 = Math.min(r9, 8);
        long r0 = 0;
        int r2 = 0;
    L3:
        if (r2 >= r10) goto L5;
        r0 = r0 | ((((long) r7[r8 + r2]) & 255) << (r2 * 8));
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }

    static void store64(byte[] r1, int r2, long r3) {
        byteArray.putLongLittleEndian(r1, r2, r3);
    }

    static int load32(byte[] r2, int r3) {
        int r0 = ((r2[r3] & 255) | ((r2[r3 + 1] & 255) << 8)) | ((r2[r3 + 2] & 255) << 16);
        return ((r2[r3 + 3] & 255) << 24) | r0;
    }

    static boolean usingUnsafe() {
        return byteArray instanceof UnsafeByteArray;
    }

    static {
        LittleEndianBytes r0 = JavaLittleEndianBytes.INSTANCE;
        if ("amd64".equals(System.getProperty("os.arch")) == true) goto L6;
    L12:
        goto L9
    L6:
        if (ByteOrder.nativeOrder().equals(ByteOrder.LITTLE_ENDIAN) == false) goto L8;
        r0 = UnsafeByteArray.UNSAFE_LITTLE_ENDIAN;     // Catch: Throwable -> L11
        goto L12
    L8:
        r0 = UnsafeByteArray.UNSAFE_BIG_ENDIAN;     // Catch: Throwable -> L11
    L9:
        byteArray = r0;
    }

    private LittleEndianByteArray() {
    }
}
