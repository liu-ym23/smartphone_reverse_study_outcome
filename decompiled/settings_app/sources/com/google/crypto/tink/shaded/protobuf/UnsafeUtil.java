package com.google.crypto.tink.shaded.protobuf;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes4.dex */
final class UnsafeUtil {
    private static final long BOOLEAN_ARRAY_BASE_OFFSET = 0;
    private static final long BOOLEAN_ARRAY_INDEX_SCALE = 0;
    private static final long BUFFER_ADDRESS_OFFSET = 0;
    private static final int BYTE_ARRAY_ALIGNMENT = 0;
    static final long BYTE_ARRAY_BASE_OFFSET = 0;
    private static final long DOUBLE_ARRAY_BASE_OFFSET = 0;
    private static final long DOUBLE_ARRAY_INDEX_SCALE = 0;
    private static final long FLOAT_ARRAY_BASE_OFFSET = 0;
    private static final long FLOAT_ARRAY_INDEX_SCALE = 0;
    private static final boolean HAS_UNSAFE_ARRAY_OPERATIONS = false;
    private static final boolean HAS_UNSAFE_BYTEBUFFER_OPERATIONS = false;
    private static final long INT_ARRAY_BASE_OFFSET = 0;
    private static final long INT_ARRAY_INDEX_SCALE = 0;
    private static final boolean IS_ANDROID_32 = false;
    private static final boolean IS_ANDROID_64 = false;
    static final boolean IS_BIG_ENDIAN = false;
    private static final long LONG_ARRAY_BASE_OFFSET = 0;
    private static final long LONG_ARRAY_INDEX_SCALE = 0;
    private static final MemoryAccessor MEMORY_ACCESSOR = null;
    private static final Class<?> MEMORY_CLASS = null;
    private static final long OBJECT_ARRAY_BASE_OFFSET = 0;
    private static final long OBJECT_ARRAY_INDEX_SCALE = 0;
    private static final int STRIDE = 8;
    private static final int STRIDE_ALIGNMENT_MASK = 7;
    private static final Unsafe UNSAFE = null;

    private static final class Android32MemoryAccessor extends MemoryAccessor {
        private static final long SMALL_ADDRESS_MASK = -1;

        private static int smallAddress(long address) {
            return (int) (address & (-1));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public boolean supportsUnsafeByteBufferOperations() {
            return false;
        }

        Android32MemoryAccessor(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public Object getStaticObject(java.lang.reflect.Field field) {
            return field.get(null);
        L8:
            return null;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public byte getByte(Object target, long offset) {
            if (UnsafeUtil.IS_BIG_ENDIAN == false) goto L7;
            return UnsafeUtil.access$200(target, offset);
        L7:
            return UnsafeUtil.access$300(target, offset);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void putByte(Object target, long offset, byte value) {
            if (UnsafeUtil.IS_BIG_ENDIAN == false) goto L5;
            UnsafeUtil.access$400(target, offset, value);
            return;
        L5:
            UnsafeUtil.access$500(target, offset, value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public boolean getBoolean(Object target, long offset) {
            if (UnsafeUtil.IS_BIG_ENDIAN == false) goto L7;
            return UnsafeUtil.access$600(target, offset);
        L7:
            return UnsafeUtil.access$700(target, offset);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void putBoolean(Object target, long offset, boolean value) {
            if (UnsafeUtil.IS_BIG_ENDIAN == false) goto L5;
            UnsafeUtil.access$800(target, offset, value);
            return;
        L5:
            UnsafeUtil.access$900(target, offset, value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public float getFloat(Object target, long offset) {
            return Float.intBitsToFloat(getInt(target, offset));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void putFloat(Object target, long offset, float value) {
            putInt(target, offset, Float.floatToIntBits(value));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public double getDouble(Object target, long offset) {
            return Double.longBitsToDouble(getLong(target, offset));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void putDouble(Object target, long offset, double value) {
            putLong(target, offset, Double.doubleToLongBits(value));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public byte getByte(long address) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void putByte(long address, byte value) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public int getInt(long address) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void putInt(long address, int value) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public long getLong(long address) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void putLong(long address, long value) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void copyMemory(long srcOffset, byte[] target, long targetIndex, long length) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void copyMemory(byte[] src, long srcIndex, long targetOffset, long length) {
            throw new UnsupportedOperationException();
        }
    }

    private static final class Android64MemoryAccessor extends MemoryAccessor {
        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public boolean supportsUnsafeByteBufferOperations() {
            return false;
        }

        Android64MemoryAccessor(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public Object getStaticObject(java.lang.reflect.Field field) {
            return field.get(null);
        L8:
            return null;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public byte getByte(Object target, long offset) {
            if (UnsafeUtil.IS_BIG_ENDIAN == false) goto L7;
            return UnsafeUtil.access$200(target, offset);
        L7:
            return UnsafeUtil.access$300(target, offset);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void putByte(Object target, long offset, byte value) {
            if (UnsafeUtil.IS_BIG_ENDIAN == false) goto L5;
            UnsafeUtil.access$400(target, offset, value);
            return;
        L5:
            UnsafeUtil.access$500(target, offset, value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public boolean getBoolean(Object target, long offset) {
            if (UnsafeUtil.IS_BIG_ENDIAN == false) goto L7;
            return UnsafeUtil.access$600(target, offset);
        L7:
            return UnsafeUtil.access$700(target, offset);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void putBoolean(Object target, long offset, boolean value) {
            if (UnsafeUtil.IS_BIG_ENDIAN == false) goto L5;
            UnsafeUtil.access$800(target, offset, value);
            return;
        L5:
            UnsafeUtil.access$900(target, offset, value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public float getFloat(Object target, long offset) {
            return Float.intBitsToFloat(getInt(target, offset));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void putFloat(Object target, long offset, float value) {
            putInt(target, offset, Float.floatToIntBits(value));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public double getDouble(Object target, long offset) {
            return Double.longBitsToDouble(getLong(target, offset));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void putDouble(Object target, long offset, double value) {
            putLong(target, offset, Double.doubleToLongBits(value));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public byte getByte(long address) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void putByte(long address, byte value) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public int getInt(long address) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void putInt(long address, int value) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public long getLong(long address) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void putLong(long address, long value) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void copyMemory(long srcOffset, byte[] target, long targetIndex, long length) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void copyMemory(byte[] src, long srcIndex, long targetOffset, long length) {
            throw new UnsupportedOperationException();
        }
    }

    private static final class JvmMemoryAccessor extends MemoryAccessor {
        JvmMemoryAccessor(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public Object getStaticObject(java.lang.reflect.Field field) {
            return getObject(this.unsafe.staticFieldBase(field), this.unsafe.staticFieldOffset(field));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public boolean supportsUnsafeArrayOperations() {
            if (super.supportsUnsafeArrayOperations() == true) goto L10;
            return false;
        L10:
            Class<?> r7 = this.unsafe.getClass();     // Catch: Throwable -> L7
            r7.getMethod("getByte", new Class[]{Object.class, Long.TYPE});     // Catch: Throwable -> L7
            r7.getMethod("putByte", new Class[]{Object.class, Long.TYPE, Byte.TYPE});     // Catch: Throwable -> L7
            r7.getMethod("getBoolean", new Class[]{Object.class, Long.TYPE});     // Catch: Throwable -> L7
            r7.getMethod("putBoolean", new Class[]{Object.class, Long.TYPE, Boolean.TYPE});     // Catch: Throwable -> L7
            r7.getMethod("getFloat", new Class[]{Object.class, Long.TYPE});     // Catch: Throwable -> L7
            r7.getMethod("putFloat", new Class[]{Object.class, Long.TYPE, Float.TYPE});     // Catch: Throwable -> L7
            r7.getMethod("getDouble", new Class[]{Object.class, Long.TYPE});     // Catch: Throwable -> L7
            r7.getMethod("putDouble", new Class[]{Object.class, Long.TYPE, Double.TYPE});     // Catch: Throwable -> L7
            return true;
        L7:
            th = move-exception;
            UnsafeUtil.access$000(th);
            return false;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public byte getByte(Object target, long offset) {
            return this.unsafe.getByte(target, offset);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void putByte(Object target, long offset, byte value) {
            this.unsafe.putByte(target, offset, value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public boolean getBoolean(Object target, long offset) {
            return this.unsafe.getBoolean(target, offset);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void putBoolean(Object target, long offset, boolean value) {
            this.unsafe.putBoolean(target, offset, value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public float getFloat(Object target, long offset) {
            return this.unsafe.getFloat(target, offset);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void putFloat(Object target, long offset, float value) {
            this.unsafe.putFloat(target, offset, value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public double getDouble(Object target, long offset) {
            return this.unsafe.getDouble(target, offset);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void putDouble(Object target, long offset, double value) {
            this.unsafe.putDouble(target, offset, value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public boolean supportsUnsafeByteBufferOperations() {
            if (super.supportsUnsafeByteBufferOperations() == true) goto L10;
            return false;
        L10:
            Class<?> r7 = this.unsafe.getClass();     // Catch: Throwable -> L7
            r7.getMethod("getByte", new Class[]{Long.TYPE});     // Catch: Throwable -> L7
            r7.getMethod("putByte", new Class[]{Long.TYPE, Byte.TYPE});     // Catch: Throwable -> L7
            r7.getMethod("getInt", new Class[]{Long.TYPE});     // Catch: Throwable -> L7
            r7.getMethod("putInt", new Class[]{Long.TYPE, Integer.TYPE});     // Catch: Throwable -> L7
            r7.getMethod("getLong", new Class[]{Long.TYPE});     // Catch: Throwable -> L7
            r7.getMethod("putLong", new Class[]{Long.TYPE, Long.TYPE});     // Catch: Throwable -> L7
            r7.getMethod("copyMemory", new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});     // Catch: Throwable -> L7
            r7.getMethod("copyMemory", new Class[]{Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE});     // Catch: Throwable -> L7
            return true;
        L7:
            th = move-exception;
            UnsafeUtil.access$000(th);
            return false;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public byte getByte(long address) {
            return this.unsafe.getByte(address);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void putByte(long address, byte value) {
            this.unsafe.putByte(address, value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public int getInt(long address) {
            return this.unsafe.getInt(address);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void putInt(long address, int value) {
            this.unsafe.putInt(address, value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public long getLong(long address) {
            return this.unsafe.getLong(address);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void putLong(long address, long value) {
            this.unsafe.putLong(address, value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void copyMemory(long srcOffset, byte[] target, long targetIndex, long length) {
            this.unsafe.copyMemory(null, srcOffset, target, UnsafeUtil.BYTE_ARRAY_BASE_OFFSET + targetIndex, length);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void copyMemory(byte[] src, long srcIndex, long targetOffset, long length) {
            this.unsafe.copyMemory(src, UnsafeUtil.BYTE_ARRAY_BASE_OFFSET + srcIndex, null, targetOffset, length);
        }
    }

    private static abstract class MemoryAccessor {
        Unsafe unsafe;

        public abstract void copyMemory(long srcOffset, byte[] target, long targetIndex, long length);

        public abstract void copyMemory(byte[] src, long srcIndex, long targetOffset, long length);

        public abstract boolean getBoolean(Object target, long offset);

        public abstract byte getByte(long address);

        public abstract byte getByte(Object target, long offset);

        public abstract double getDouble(Object target, long offset);

        public abstract float getFloat(Object target, long offset);

        public abstract int getInt(long address);

        public abstract long getLong(long address);

        public abstract Object getStaticObject(java.lang.reflect.Field field);

        public abstract void putBoolean(Object target, long offset, boolean value);

        public abstract void putByte(long address, byte value);

        public abstract void putByte(Object target, long offset, byte value);

        public abstract void putDouble(Object target, long offset, double value);

        public abstract void putFloat(Object target, long offset, float value);

        public abstract void putInt(long address, int value);

        public abstract void putLong(long address, long value);

        MemoryAccessor(Unsafe unsafe) {
            this.unsafe = unsafe;
        }

        public final long objectFieldOffset(java.lang.reflect.Field field) {
            return this.unsafe.objectFieldOffset(field);
        }

        public final int arrayBaseOffset(Class<?> clazz) {
            return this.unsafe.arrayBaseOffset(clazz);
        }

        public final int arrayIndexScale(Class<?> clazz) {
            return this.unsafe.arrayIndexScale(clazz);
        }

        public boolean supportsUnsafeArrayOperations() {
            Unsafe r7 = this.unsafe;
            if (r7 != null) goto L10;
            return false;
        L10:
            Class<?> r8 = r7.getClass();     // Catch: Throwable -> L7
            r8.getMethod("objectFieldOffset", new Class[]{java.lang.reflect.Field.class});     // Catch: Throwable -> L7
            r8.getMethod("arrayBaseOffset", new Class[]{Class.class});     // Catch: Throwable -> L7
            r8.getMethod("arrayIndexScale", new Class[]{Class.class});     // Catch: Throwable -> L7
            r8.getMethod("getInt", new Class[]{Object.class, Long.TYPE});     // Catch: Throwable -> L7
            r8.getMethod("putInt", new Class[]{Object.class, Long.TYPE, Integer.TYPE});     // Catch: Throwable -> L7
            r8.getMethod("getLong", new Class[]{Object.class, Long.TYPE});     // Catch: Throwable -> L7
            r8.getMethod("putLong", new Class[]{Object.class, Long.TYPE, Long.TYPE});     // Catch: Throwable -> L7
            r8.getMethod("getObject", new Class[]{Object.class, Long.TYPE});     // Catch: Throwable -> L7
            r8.getMethod("putObject", new Class[]{Object.class, Long.TYPE, Object.class});     // Catch: Throwable -> L7
            return true;
        L7:
            th = move-exception;
            UnsafeUtil.access$000(th);
            return false;
        }

        public final int getInt(Object target, long offset) {
            return this.unsafe.getInt(target, offset);
        }

        public final void putInt(Object target, long offset, int value) {
            this.unsafe.putInt(target, offset, value);
        }

        public final long getLong(Object target, long offset) {
            return this.unsafe.getLong(target, offset);
        }

        public final void putLong(Object target, long offset, long value) {
            this.unsafe.putLong(target, offset, value);
        }

        public final Object getObject(Object target, long offset) {
            return this.unsafe.getObject(target, offset);
        }

        public final void putObject(Object target, long offset, Object value) {
            this.unsafe.putObject(target, offset, value);
        }

        public boolean supportsUnsafeByteBufferOperations() {
            Unsafe r5 = this.unsafe;
            if (r5 != null) goto L12;
            return false;
        L12:
            Class<?> r6 = r5.getClass();     // Catch: Throwable -> L9
            r6.getMethod("objectFieldOffset", new Class[]{java.lang.reflect.Field.class});     // Catch: Throwable -> L9
            r6.getMethod("getLong", new Class[]{Object.class, Long.TYPE});     // Catch: Throwable -> L9
            if (UnsafeUtil.access$100() != null) goto L8;
            return false;
        L8:
            return true;
        L9:
            th = move-exception;
            UnsafeUtil.access$000(th);
            return false;
        }
    }

    static /* synthetic */ void access$000(Throwable r0) {
        logMissingMethod(r0);
    }

    static /* synthetic */ java.lang.reflect.Field access$100() {
        return bufferAddressField();
    }

    static /* synthetic */ byte access$200(Object r0, long r1) {
        return getByteBigEndian(r0, r1);
    }

    static /* synthetic */ byte access$300(Object r0, long r1) {
        return getByteLittleEndian(r0, r1);
    }

    static /* synthetic */ void access$400(Object r0, long r1, byte r3) {
        putByteBigEndian(r0, r1, r3);
    }

    static /* synthetic */ void access$500(Object r0, long r1, byte r3) {
        putByteLittleEndian(r0, r1, r3);
    }

    static /* synthetic */ boolean access$600(Object r0, long r1) {
        return getBooleanBigEndian(r0, r1);
    }

    static /* synthetic */ boolean access$700(Object r0, long r1) {
        return getBooleanLittleEndian(r0, r1);
    }

    static /* synthetic */ void access$800(Object r0, long r1, boolean r3) {
        putBooleanBigEndian(r0, r1, r3);
    }

    static /* synthetic */ void access$900(Object r0, long r1, boolean r3) {
        putBooleanLittleEndian(r0, r1, r3);
    }

    static {
        UNSAFE = getUnsafe();
        MEMORY_CLASS = Android.getMemoryClass();
        IS_ANDROID_64 = determineAndroidSupportByAddressSize(Long.TYPE);
        IS_ANDROID_32 = determineAndroidSupportByAddressSize(Integer.TYPE);
        MEMORY_ACCESSOR = getMemoryAccessor();
        HAS_UNSAFE_BYTEBUFFER_OPERATIONS = supportsUnsafeByteBufferOperations();
        HAS_UNSAFE_ARRAY_OPERATIONS = supportsUnsafeArrayOperations();
        long r0 = arrayBaseOffset(byte[].class);
        BYTE_ARRAY_BASE_OFFSET = r0;
        BOOLEAN_ARRAY_BASE_OFFSET = arrayBaseOffset(boolean[].class);
        BOOLEAN_ARRAY_INDEX_SCALE = arrayIndexScale(boolean[].class);
        INT_ARRAY_BASE_OFFSET = arrayBaseOffset(int[].class);
        INT_ARRAY_INDEX_SCALE = arrayIndexScale(int[].class);
        LONG_ARRAY_BASE_OFFSET = arrayBaseOffset(long[].class);
        LONG_ARRAY_INDEX_SCALE = arrayIndexScale(long[].class);
        FLOAT_ARRAY_BASE_OFFSET = arrayBaseOffset(float[].class);
        FLOAT_ARRAY_INDEX_SCALE = arrayIndexScale(float[].class);
        DOUBLE_ARRAY_BASE_OFFSET = arrayBaseOffset(double[].class);
        DOUBLE_ARRAY_INDEX_SCALE = arrayIndexScale(double[].class);
        OBJECT_ARRAY_BASE_OFFSET = arrayBaseOffset(Object[].class);
        OBJECT_ARRAY_INDEX_SCALE = arrayIndexScale(Object[].class);
        BUFFER_ADDRESS_OFFSET = fieldOffset(bufferAddressField());
        BYTE_ARRAY_ALIGNMENT = (int) (r0 & 7);
        if (ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN) goto L5;
        boolean r1 = true;
    L6:
        IS_BIG_ENDIAN = r1;
        return;
    L5:
        r1 = false;
        goto L6
    }

    private UnsafeUtil() {
    }

    static boolean hasUnsafeArrayOperations() {
        return HAS_UNSAFE_ARRAY_OPERATIONS;
    }

    static boolean hasUnsafeByteBufferOperations() {
        return HAS_UNSAFE_BYTEBUFFER_OPERATIONS;
    }

    static boolean isAndroid64() {
        return IS_ANDROID_64;
    }

    static <T> T allocateInstance(Class<T> r1) {
        return (T) UNSAFE.allocateInstance(r1);
    L4:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    static long objectFieldOffset(java.lang.reflect.Field field) {
        return MEMORY_ACCESSOR.objectFieldOffset(field);
    }

    private static int arrayBaseOffset(Class<?> clazz) {
        if (HAS_UNSAFE_ARRAY_OPERATIONS == true) goto L7;
        return -1;
    L7:
        return MEMORY_ACCESSOR.arrayBaseOffset(clazz);
    }

    private static int arrayIndexScale(Class<?> clazz) {
        if (HAS_UNSAFE_ARRAY_OPERATIONS == true) goto L7;
        return -1;
    L7:
        return MEMORY_ACCESSOR.arrayIndexScale(clazz);
    }

    static byte getByte(Object target, long offset) {
        return MEMORY_ACCESSOR.getByte(target, offset);
    }

    static void putByte(Object target, long offset, byte value) {
        MEMORY_ACCESSOR.putByte(target, offset, value);
    }

    static int getInt(Object target, long offset) {
        return MEMORY_ACCESSOR.getInt(target, offset);
    }

    static void putInt(Object target, long offset, int value) {
        MEMORY_ACCESSOR.putInt(target, offset, value);
    }

    static long getLong(Object target, long offset) {
        return MEMORY_ACCESSOR.getLong(target, offset);
    }

    static void putLong(Object target, long offset, long value) {
        MEMORY_ACCESSOR.putLong(target, offset, value);
    }

    static boolean getBoolean(Object target, long offset) {
        return MEMORY_ACCESSOR.getBoolean(target, offset);
    }

    static void putBoolean(Object target, long offset, boolean value) {
        MEMORY_ACCESSOR.putBoolean(target, offset, value);
    }

    static float getFloat(Object target, long offset) {
        return MEMORY_ACCESSOR.getFloat(target, offset);
    }

    static void putFloat(Object target, long offset, float value) {
        MEMORY_ACCESSOR.putFloat(target, offset, value);
    }

    static double getDouble(Object target, long offset) {
        return MEMORY_ACCESSOR.getDouble(target, offset);
    }

    static void putDouble(Object target, long offset, double value) {
        MEMORY_ACCESSOR.putDouble(target, offset, value);
    }

    static Object getObject(Object target, long offset) {
        return MEMORY_ACCESSOR.getObject(target, offset);
    }

    static void putObject(Object target, long offset, Object value) {
        MEMORY_ACCESSOR.putObject(target, offset, value);
    }

    static byte getByte(byte[] target, long index) {
        return MEMORY_ACCESSOR.getByte(target, BYTE_ARRAY_BASE_OFFSET + index);
    }

    static void putByte(byte[] target, long index, byte value) {
        MEMORY_ACCESSOR.putByte(target, BYTE_ARRAY_BASE_OFFSET + index, value);
    }

    static int getInt(int[] target, long index) {
        return MEMORY_ACCESSOR.getInt(target, INT_ARRAY_BASE_OFFSET + (index * INT_ARRAY_INDEX_SCALE));
    }

    static void putInt(int[] target, long index, int value) {
        MEMORY_ACCESSOR.putInt(target, INT_ARRAY_BASE_OFFSET + (index * INT_ARRAY_INDEX_SCALE), value);
    }

    static long getLong(long[] target, long index) {
        return MEMORY_ACCESSOR.getLong(target, LONG_ARRAY_BASE_OFFSET + (index * LONG_ARRAY_INDEX_SCALE));
    }

    static void putLong(long[] target, long index, long value) {
        MEMORY_ACCESSOR.putLong(target, LONG_ARRAY_BASE_OFFSET + (index * LONG_ARRAY_INDEX_SCALE), value);
    }

    static boolean getBoolean(boolean[] target, long index) {
        return MEMORY_ACCESSOR.getBoolean(target, BOOLEAN_ARRAY_BASE_OFFSET + (index * BOOLEAN_ARRAY_INDEX_SCALE));
    }

    static void putBoolean(boolean[] target, long index, boolean value) {
        MEMORY_ACCESSOR.putBoolean(target, BOOLEAN_ARRAY_BASE_OFFSET + (index * BOOLEAN_ARRAY_INDEX_SCALE), value);
    }

    static float getFloat(float[] target, long index) {
        return MEMORY_ACCESSOR.getFloat(target, FLOAT_ARRAY_BASE_OFFSET + (index * FLOAT_ARRAY_INDEX_SCALE));
    }

    static void putFloat(float[] target, long index, float value) {
        MEMORY_ACCESSOR.putFloat(target, FLOAT_ARRAY_BASE_OFFSET + (index * FLOAT_ARRAY_INDEX_SCALE), value);
    }

    static double getDouble(double[] target, long index) {
        return MEMORY_ACCESSOR.getDouble(target, DOUBLE_ARRAY_BASE_OFFSET + (index * DOUBLE_ARRAY_INDEX_SCALE));
    }

    static void putDouble(double[] target, long index, double value) {
        MEMORY_ACCESSOR.putDouble(target, DOUBLE_ARRAY_BASE_OFFSET + (index * DOUBLE_ARRAY_INDEX_SCALE), value);
    }

    static Object getObject(Object[] target, long index) {
        return MEMORY_ACCESSOR.getObject(target, OBJECT_ARRAY_BASE_OFFSET + (index * OBJECT_ARRAY_INDEX_SCALE));
    }

    static void putObject(Object[] target, long index, Object value) {
        MEMORY_ACCESSOR.putObject(target, OBJECT_ARRAY_BASE_OFFSET + (index * OBJECT_ARRAY_INDEX_SCALE), value);
    }

    static void copyMemory(byte[] src, long srcIndex, long targetOffset, long length) {
        MEMORY_ACCESSOR.copyMemory(src, srcIndex, targetOffset, length);
    }

    static void copyMemory(long srcOffset, byte[] target, long targetIndex, long length) {
        MEMORY_ACCESSOR.copyMemory(srcOffset, target, targetIndex, length);
    }

    static void copyMemory(byte[] src, long srcIndex, byte[] target, long targetIndex, long length) {
        System.arraycopy(src, (int) srcIndex, target, (int) targetIndex, (int) length);
    }

    static byte getByte(long address) {
        return MEMORY_ACCESSOR.getByte(address);
    }

    static void putByte(long address, byte value) {
        MEMORY_ACCESSOR.putByte(address, value);
    }

    static int getInt(long address) {
        return MEMORY_ACCESSOR.getInt(address);
    }

    static void putInt(long address, int value) {
        MEMORY_ACCESSOR.putInt(address, value);
    }

    static long getLong(long address) {
        return MEMORY_ACCESSOR.getLong(address);
    }

    static void putLong(long address, long value) {
        MEMORY_ACCESSOR.putLong(address, value);
    }

    static long addressOffset(ByteBuffer buffer) {
        return MEMORY_ACCESSOR.getLong(buffer, BUFFER_ADDRESS_OFFSET);
    }

    static Object getStaticObject(java.lang.reflect.Field field) {
        return MEMORY_ACCESSOR.getStaticObject(field);
    }

    static Unsafe getUnsafe() {
        return (Unsafe) AccessController.doPrivileged(new AnonymousClass1());
    L4:
        return null;
    }

    private static MemoryAccessor getMemoryAccessor() {
        Unsafe r0 = UNSAFE;
        if (r0 != null) goto L6;
        return null;
    L6:
        if (Android.isOnAndroidDevice() == false) goto L16;
        if (IS_ANDROID_64 == false) goto L12;
        return new Android64MemoryAccessor(r0);
    L12:
        if (IS_ANDROID_32 == true) goto L14;
        return null;
    L14:
        return new Android32MemoryAccessor(r0);
    L16:
        return new JvmMemoryAccessor(r0);
    }

    private static boolean supportsUnsafeArrayOperations() {
        MemoryAccessor r0 = MEMORY_ACCESSOR;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.supportsUnsafeArrayOperations();
    }

    private static boolean supportsUnsafeByteBufferOperations() {
        MemoryAccessor r0 = MEMORY_ACCESSOR;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.supportsUnsafeByteBufferOperations();
    }

    static boolean determineAndroidSupportByAddressSize(Class<?> addressClass) {
        if (Android.isOnAndroidDevice() == true) goto L8;
        return false;
    L8:
        Class<?> r1 = MEMORY_CLASS;     // Catch: Throwable -> L7
        r1.getMethod("peekLong", new Class[]{addressClass, Boolean.TYPE});     // Catch: Throwable -> L7
        r1.getMethod("pokeLong", new Class[]{addressClass, Long.TYPE, Boolean.TYPE});     // Catch: Throwable -> L7
        r1.getMethod("pokeInt", new Class[]{addressClass, Integer.TYPE, Boolean.TYPE});     // Catch: Throwable -> L7
        r1.getMethod("peekInt", new Class[]{addressClass, Boolean.TYPE});     // Catch: Throwable -> L7
        r1.getMethod("pokeByte", new Class[]{addressClass, Byte.TYPE});     // Catch: Throwable -> L7
        r1.getMethod("peekByte", new Class[]{addressClass});     // Catch: Throwable -> L7
        r1.getMethod("pokeByteArray", new Class[]{addressClass, byte[].class, Integer.TYPE, Integer.TYPE});     // Catch: Throwable -> L7
        r1.getMethod("peekByteArray", new Class[]{addressClass, byte[].class, Integer.TYPE, Integer.TYPE});     // Catch: Throwable -> L7
        return true;
    L7:
        return false;
    }

    private static java.lang.reflect.Field bufferAddressField() {
        if (Android.isOnAndroidDevice() == false) goto L7;
        java.lang.reflect.Field r0 = field(Buffer.class, "effectiveDirectAddress");
        if (r0 == null) goto L7;
        return r0;
    L7:
        java.lang.reflect.Field r1 = field(Buffer.class, "address");
        if (r1 != null) goto L10;
    L12:
        return null;
    L10:
        if (r1.getType() != Long.TYPE) goto L12;
        return r1;
    }

    private static int firstDifferingByteIndexNativeEndian(long left, long right) {
        if (IS_BIG_ENDIAN == false) goto L5;
        int r1 = Long.numberOfLeadingZeros(left ^ right);
    L7:
        return r1 >> 3;
    L5:
        r1 = Long.numberOfTrailingZeros(left ^ right);
        goto L7
    }

    static int mismatch(byte[] left, int leftOff, byte[] right, int rightOff, int length) {
        if (leftOff < 0) goto L34;
        if (rightOff < 0) goto L34;
        if (length < 0) goto L34;
        if ((leftOff + length) > left.length) goto L34;
        if ((rightOff + length) > right.length) goto L34;
        int r1 = 0;
        if (HAS_UNSAFE_ARRAY_OPERATIONS == false) goto L26;
        int r0 = (BYTE_ARRAY_ALIGNMENT + leftOff) & 7;
    L12:
        if (r1 >= length) goto L19;
        if ((r0 & 7) == 0) goto L19;
        if (left[leftOff + r1] != right[rightOff + r1]) goto L17;
        r1 = r1 + 1;
        r0 = r0 + 1;
        goto L12
    L17:
        return r1;
    L19:
        int r2 = ((length - r1) & (-8)) + r1;
    L20:
        if (r1 >= r2) goto L26;
        long r3 = BYTE_ARRAY_BASE_OFFSET;
        long r6 = r1;
        long r4 = getLong(left, (((long) leftOff) + r3) + r6);
        long r5 = getLong(right, (r3 + ((long) rightOff)) + r6);
        if (r4 != r5) goto L24;
        r1 = r1 + 8;
        goto L20
    L24:
        return r1 + firstDifferingByteIndexNativeEndian(r4, r5);
    L26:
        if (r1 >= length) goto L31;
        if (left[leftOff + r1] != right[rightOff + r1]) goto L29;
        r1 = r1 + 1;
        goto L26
    L29:
        return r1;
    L31:
        return -1;
    L34:
        throw new IndexOutOfBoundsException();
    }

    private static long fieldOffset(java.lang.reflect.Field field) {
        if (field == null) goto L7;
        MemoryAccessor r0 = MEMORY_ACCESSOR;
        if (r0 == null) goto L7;
        return r0.objectFieldOffset(field);
    L7:
        return -1;
    }

    private static java.lang.reflect.Field field(Class<?> clazz, String fieldName) {
        return clazz.getDeclaredField(fieldName);
    L4:
        return null;
    }

    private static byte getByteBigEndian(Object target, long offset) {
        return (byte) ((getInt(target, (-4) & offset) >>> ((int) (((~offset) & 3) << 3))) & 255);
    }

    private static byte getByteLittleEndian(Object target, long offset) {
        return (byte) ((getInt(target, (-4) & offset) >>> ((int) ((offset & 3) << 3))) & 255);
    }

    private static void putByteBigEndian(Object target, long offset, byte value) {
        long r0 = (-4) & offset;
        int r2 = getInt(target, r0);
        int r5 = ((~((int) offset)) & 3) << 3;
        int r3 = r2 & (~(255 << r5));
        putInt(target, r0, ((255 & value) << r5) | r3);
    }

    private static void putByteLittleEndian(Object target, long offset, byte value) {
        long r0 = (-4) & offset;
        int r5 = (((int) offset) & 3) << 3;
        int r2 = getInt(target, r0) & (~(255 << r5));
        putInt(target, r0, ((255 & value) << r5) | r2);
    }

    private static boolean getBooleanBigEndian(Object target, long offset) {
        if (getByteBigEndian(target, offset) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean getBooleanLittleEndian(Object target, long offset) {
        if (getByteLittleEndian(target, offset) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static void putBooleanBigEndian(Object r0, long r1, boolean r3) {
        putByteBigEndian(r0, r1, r3 ? 1 : 0);
    }

    private static void putBooleanLittleEndian(Object r0, long r1, boolean r3) {
        putByteLittleEndian(r0, r1, r3 ? 1 : 0);
    }

    private static void logMissingMethod(Throwable e) {
        Logger.getLogger(UnsafeUtil.class.getName()).log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + e);
    }
}
