package com.google.crypto.tink.shaded.protobuf;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public final class Internal {
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    public static final byte[] EMPTY_BYTE_ARRAY = null;
    public static final ByteBuffer EMPTY_BYTE_BUFFER = null;
    public static final CodedInputStream EMPTY_CODED_INPUT_STREAM = null;
    static final Charset ISO_8859_1 = null;
    static final Charset US_ASCII = null;
    static final Charset UTF_8 = null;

    public interface BooleanList extends ProtobufList<Boolean> {
        void addBoolean(boolean element);

        boolean getBoolean(int index);

        @Override // 
        ProtobufList<Boolean> mutableCopyWithCapacity(int capacity);

        boolean setBoolean(int index, boolean element);

        @Override // com.google.crypto.tink.shaded.protobuf.Internal.ProtobufList, com.google.crypto.tink.shaded.protobuf.Internal.BooleanList
        /* JADX INFO: renamed from: mutableCopyWithCapacity, reason: avoid collision after fix types in other method */
        /* bridge */ /* synthetic */ default ProtobufList<Boolean> mutableCopyWithCapacity2(int capacity) {
            return mutableCopyWithCapacity(capacity);
        }
    }

    public interface DoubleList extends ProtobufList<Double> {
        void addDouble(double element);

        double getDouble(int index);

        @Override // com.google.crypto.tink.shaded.protobuf.Internal.ProtobufList, com.google.crypto.tink.shaded.protobuf.Internal.BooleanList
        ProtobufList<Double> mutableCopyWithCapacity(int capacity);

        double setDouble(int index, double element);

        @Override // com.google.crypto.tink.shaded.protobuf.Internal.ProtobufList, com.google.crypto.tink.shaded.protobuf.Internal.BooleanList
        /* JADX INFO: renamed from: mutableCopyWithCapacity, reason: avoid collision after fix types in other method */
        /* bridge */ /* synthetic */ default ProtobufList<Double> mutableCopyWithCapacity2(int capacity) {
            return mutableCopyWithCapacity(capacity);
        }
    }

    public interface EnumLite {
        int getNumber();
    }

    public interface EnumLiteMap<T extends EnumLite> {
        T findValueByNumber(int number);
    }

    public interface EnumVerifier {
        boolean isInRange(int number);
    }

    public interface FloatList extends ProtobufList<Float> {
        void addFloat(float element);

        float getFloat(int index);

        @Override // com.google.crypto.tink.shaded.protobuf.Internal.ProtobufList, com.google.crypto.tink.shaded.protobuf.Internal.BooleanList
        ProtobufList<Float> mutableCopyWithCapacity(int capacity);

        float setFloat(int index, float element);

        @Override // com.google.crypto.tink.shaded.protobuf.Internal.ProtobufList, com.google.crypto.tink.shaded.protobuf.Internal.BooleanList
        /* JADX INFO: renamed from: mutableCopyWithCapacity, reason: avoid collision after fix types in other method */
        /* bridge */ /* synthetic */ default ProtobufList<Float> mutableCopyWithCapacity2(int capacity) {
            return mutableCopyWithCapacity(capacity);
        }
    }

    public interface IntList extends ProtobufList<Integer> {
        void addInt(int element);

        int getInt(int index);

        @Override // com.google.crypto.tink.shaded.protobuf.Internal.ProtobufList, com.google.crypto.tink.shaded.protobuf.Internal.BooleanList
        ProtobufList<Integer> mutableCopyWithCapacity(int capacity);

        int setInt(int index, int element);

        @Override // com.google.crypto.tink.shaded.protobuf.Internal.ProtobufList, com.google.crypto.tink.shaded.protobuf.Internal.BooleanList
        /* JADX INFO: renamed from: mutableCopyWithCapacity, reason: avoid collision after fix types in other method */
        /* bridge */ /* synthetic */ default ProtobufList<Integer> mutableCopyWithCapacity2(int capacity) {
            return mutableCopyWithCapacity(capacity);
        }
    }

    public static class ListAdapter<F, T> extends AbstractList<T> {
        private final Converter<F, T> converter;
        private final List<F> fromList;

        public interface Converter<F, T> {
            T convert(F from);
        }

        public ListAdapter(List<F> fromList, Converter<F, T> converter) {
            this.fromList = fromList;
            this.converter = converter;
        }

        @Override // java.util.AbstractList, java.util.List
        public T get(int r2) {
            return (T) this.converter.convert(this.fromList.get(r2));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.fromList.size();
        }
    }

    public interface LongList extends ProtobufList<Long> {
        void addLong(long element);

        long getLong(int index);

        @Override // com.google.crypto.tink.shaded.protobuf.Internal.ProtobufList, com.google.crypto.tink.shaded.protobuf.Internal.BooleanList
        ProtobufList<Long> mutableCopyWithCapacity(int capacity);

        long setLong(int index, long element);

        @Override // com.google.crypto.tink.shaded.protobuf.Internal.ProtobufList, com.google.crypto.tink.shaded.protobuf.Internal.BooleanList
        /* JADX INFO: renamed from: mutableCopyWithCapacity, reason: avoid collision after fix types in other method */
        /* bridge */ /* synthetic */ default ProtobufList<Long> mutableCopyWithCapacity2(int capacity) {
            return mutableCopyWithCapacity(capacity);
        }
    }

    public static class MapAdapter<K, V, RealValue> extends AbstractMap<K, V> {
        private final Map<K, RealValue> realMap;
        private final Converter<RealValue, V> valueConverter;

        public interface Converter<A, B> {
            A doBackward(B object);

            B doForward(A object);
        }

        private class EntryAdapter implements Map.Entry<K, V> {
            private final Map.Entry<K, RealValue> realEntry;
            final /* synthetic */ MapAdapter this$0;

            public EntryAdapter(final MapAdapter this$0, Map.Entry<K, RealValue> realEntry) {
                this.this$0 = this$0;
                this.realEntry = realEntry;
            }

            @Override // java.util.Map.Entry
            public K getKey() {
                return this.realEntry.getKey();
            }

            @Override // java.util.Map.Entry
            public V getValue() {
                return (V) MapAdapter.access$000(this.this$0).doForward(this.realEntry.getValue());
            }

            @Override // java.util.Map.Entry
            public V setValue(V r3) {
                RealValue r4 = this.realEntry.setValue((RealValue) MapAdapter.access$000(this.this$0).doBackward(r3));
                if (r4 != null) goto L7;
                return null;
            L7:
                return (V) MapAdapter.access$000(this.this$0).doForward(r4);
            }

            @Override // java.util.Map.Entry
            public boolean equals(Object o) {
                if (o != this) goto L6;
                return true;
            L6:
                if ((o instanceof Map.Entry) == true) goto L9;
                return false;
            L9:
                if (getKey().equals(((Map.Entry) o).getKey()) == false) goto L14;
                if (getValue().equals(getValue()) == false) goto L14;
                return true;
            L14:
                return false;
            }

            @Override // java.util.Map.Entry
            public int hashCode() {
                return this.realEntry.hashCode();
            }
        }

        private class IteratorAdapter implements Iterator<Map.Entry<K, V>> {
            private final Iterator<Map.Entry<K, RealValue>> realIterator;
            final /* synthetic */ MapAdapter this$0;

            @Override // java.util.Iterator
            public /* bridge */ /* synthetic */ Object next() {
                return next();
            }

            public IteratorAdapter(final MapAdapter this$0, Iterator<Map.Entry<K, RealValue>> realIterator) {
                this.this$0 = this$0;
                this.realIterator = realIterator;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.realIterator.hasNext();
            }

            @Override // java.util.Iterator
            public Map.Entry<K, V> next() {
                return new EntryAdapter(this.this$0, this.realIterator.next());
            }

            @Override // java.util.Iterator
            public void remove() {
                this.realIterator.remove();
            }
        }

        private class SetAdapter extends AbstractSet<Map.Entry<K, V>> {
            private final Set<Map.Entry<K, RealValue>> realSet;
            final /* synthetic */ MapAdapter this$0;

            public SetAdapter(final MapAdapter this$0, Set<Map.Entry<K, RealValue>> realSet) {
                this.this$0 = this$0;
                this.realSet = realSet;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, V>> iterator() {
                return new IteratorAdapter(this.this$0, this.realSet.iterator());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return this.realSet.size();
            }
        }

        static /* synthetic */ Converter access$000(MapAdapter r0) {
            return r0.valueConverter;
        }

        public static <T extends EnumLite> Converter<Integer, T> newEnumConverter(final EnumLiteMap<T> r1, final T r2) {
            return (Converter<Integer, T>) new AnonymousClass1(r1, r2);
        }

        public MapAdapter(Map<K, RealValue> realMap, Converter<RealValue, V> valueConverter) {
            this.realMap = realMap;
            this.valueConverter = valueConverter;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object key) {
            RealValue r2 = this.realMap.get(key);
            if (r2 != null) goto L7;
            return null;
        L7:
            return this.valueConverter.doForward(r2);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // java.util.AbstractMap, java.util.Map
        public V put(K r3, V r4) {
            RealValue r5 = this.realMap.put(r3, this.valueConverter.doBackward(r4));
            if (r5 != null) goto L7;
            return null;
        L7:
            return this.valueConverter.doForward(r5);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            return new SetAdapter(this, this.realMap.entrySet());
        }
    }

    public interface ProtobufList<E> extends List<E>, RandomAccess {
        boolean isModifiable();

        void makeImmutable();

        ProtobufList<E> mutableCopyWithCapacity(int capacity);
    }

    public static int hashBoolean(boolean b) {
        if (b == false) goto L4;
        return 1231;
    L4:
        return 1237;
    }

    public static int hashLong(long n) {
        return (int) (n ^ (n >>> 32));
    }

    private Internal() {
    }

    static {
        US_ASCII = Charset.forName("US-ASCII");
        UTF_8 = Charset.forName("UTF-8");
        ISO_8859_1 = Charset.forName("ISO-8859-1");
        byte[] r0 = new byte[0];
        EMPTY_BYTE_ARRAY = r0;
        EMPTY_BYTE_BUFFER = ByteBuffer.wrap(r0);
        EMPTY_CODED_INPUT_STREAM = CodedInputStream.newInstance(r0);
    }

    static <T> T checkNotNull(T obj) {
        obj.getClass();
        return obj;
    }

    static <T> T checkNotNull(T obj, String message) {
        if (obj == null) goto L5;
        return obj;
    L5:
        throw new NullPointerException(message);
    }

    public static String stringDefaultValue(String bytes) {
        return new String(bytes.getBytes(ISO_8859_1), UTF_8);
    }

    public static ByteString bytesDefaultValue(String bytes) {
        return ByteString.copyFrom(bytes.getBytes(ISO_8859_1));
    }

    public static byte[] byteArrayDefaultValue(String bytes) {
        return bytes.getBytes(ISO_8859_1);
    }

    public static ByteBuffer byteBufferDefaultValue(String bytes) {
        return ByteBuffer.wrap(byteArrayDefaultValue(bytes));
    }

    public static ByteBuffer copyByteBuffer(ByteBuffer source) {
        ByteBuffer r1 = source.duplicate();
        r1.clear();
        ByteBuffer r0 = ByteBuffer.allocate(r1.capacity());
        r0.put(r1);
        r0.clear();
        return r0;
    }

    public static boolean isValidUtf8(ByteString byteString) {
        return byteString.isValidUtf8();
    }

    public static boolean isValidUtf8(byte[] byteArray) {
        return Utf8.isValidUtf8(byteArray);
    }

    public static byte[] toByteArray(String value) {
        return value.getBytes(UTF_8);
    }

    public static String toStringUtf8(byte[] bytes) {
        return new String(bytes, UTF_8);
    }

    public static int hashEnum(EnumLite e) {
        return e.getNumber();
    }

    public static int hashEnumList(List<? extends EnumLite> list) {
        Iterator<? extends EnumLite> r2 = list.iterator();
        int r0 = 1;
    L4:
        if (r2.hasNext() == false) goto L6;
        r0 = (r0 * 31) + hashEnum(r2.next());
        goto L4
    L6:
        return r0;
    }

    public static boolean equals(List<byte[]> a, List<byte[]> b) {
        if (a.size() == b.size()) goto L5;
        return false;
    L5:
        int r0 = 0;
    L7:
        if (r0 >= a.size()) goto L12;
        if (Arrays.equals(a.get(r0), b.get(r0)) == false) goto L10;
        r0 = r0 + 1;
        goto L7
    L10:
        return false;
    L12:
        return true;
    }

    public static int hashCode(List<byte[]> list) {
        Iterator<byte[]> r2 = list.iterator();
        int r0 = 1;
    L4:
        if (r2.hasNext() == false) goto L6;
        r0 = (r0 * 31) + hashCode(r2.next());
        goto L4
    L6:
        return r0;
    }

    public static int hashCode(byte[] bytes) {
        return hashCode(bytes, 0, bytes.length);
    }

    static int hashCode(byte[] bytes, int offset, int length) {
        int r0 = partialHash(length, bytes, offset, length);
        if (r0 != 0) goto L6;
        return 1;
    L6:
        return r0;
    }

    static int partialHash(int h, byte[] bytes, int offset, int length) {
        int r0 = offset;
    L4:
        if (r0 >= (offset + length)) goto L6;
        h = (h * 31) + bytes[r0];
        r0 = r0 + 1;
        goto L4
    L6:
        return h;
    }

    public static boolean equalsByteBuffer(ByteBuffer a, ByteBuffer b) {
        if (a.capacity() == b.capacity()) goto L6;
        return false;
    L6:
        ByteBuffer r2 = a.duplicate();
        Java8Compatibility.clear(r2);
        ByteBuffer r3 = b.duplicate();
        Java8Compatibility.clear(r3);
        return r2.equals(r3);
    }

    public static boolean equalsByteBuffer(List<ByteBuffer> a, List<ByteBuffer> b) {
        if (a.size() == b.size()) goto L5;
        return false;
    L5:
        int r0 = 0;
    L7:
        if (r0 >= a.size()) goto L12;
        if (equalsByteBuffer(a.get(r0), b.get(r0)) == false) goto L10;
        r0 = r0 + 1;
        goto L7
    L10:
        return false;
    L12:
        return true;
    }

    public static int hashCodeByteBuffer(List<ByteBuffer> list) {
        Iterator<ByteBuffer> r2 = list.iterator();
        int r0 = 1;
    L4:
        if (r2.hasNext() == false) goto L6;
        r0 = (r0 * 31) + hashCodeByteBuffer(r2.next());
        goto L4
    L6:
        return r0;
    }

    public static int hashCodeByteBuffer(ByteBuffer bytes) {
        if (bytes.hasArray() == false) goto L9;
        int r6 = partialHash(bytes.capacity(), bytes.array(), bytes.arrayOffset(), bytes.capacity());
        if (r6 != 0) goto L8;
        return 1;
    L8:
        return r6;
    L9:
        int r2 = 4096;
        if (bytes.capacity() > 4096) goto L13;
        r2 = bytes.capacity();
    L13:
        byte[] r0 = new byte[r2];
        ByteBuffer r3 = bytes.duplicate();
        Java8Compatibility.clear(r3);
        int r7 = bytes.capacity();
    L15:
        if (r3.remaining() <= 0) goto L21;
        if (r3.remaining() > r2) goto L19;
        int r4 = r3.remaining();
    L20:
        r3.get(r0, 0, r4);
        r7 = partialHash(r7, r0, 0, r4);
        goto L15
    L19:
        r4 = r2;
        goto L20
    L21:
        if (r7 != 0) goto L24;
        return 1;
    L24:
        return r7;
    }

    public static <T extends MessageLite> T getDefaultInstance(Class<T> clazz) {
        java.lang.reflect.Method r0 = clazz.getMethod("getDefaultInstance", new Class[0]);     // Catch: Exception -> L4
        return (T) r0.invoke(r0, new Object[0]);
    L4:
        e = move-exception;
        throw new RuntimeException("Failed to get default instance for " + clazz, e);
    }

    static Object mergeMessage(Object destination, Object source) {
        return ((MessageLite) destination).toBuilder().mergeFrom((MessageLite) source).buildPartial();
    }
}
