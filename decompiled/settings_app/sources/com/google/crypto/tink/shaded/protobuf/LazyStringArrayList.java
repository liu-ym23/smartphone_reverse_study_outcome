package com.google.crypto.tink.shaded.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes4.dex */
public class LazyStringArrayList extends AbstractProtobufList<String> implements LazyStringList, RandomAccess {

    @Deprecated
    public static final LazyStringList EMPTY = null;
    private static final LazyStringArrayList EMPTY_LIST = null;
    private final List<Object> list;

    private static class ByteArrayListView extends AbstractList<byte[]> implements RandomAccess {
        private final LazyStringArrayList list;

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ void add(int index, Object s) {
            add(index, (byte[]) s);
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object get(int index) {
            return get(index);
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object remove(int index) {
            return remove(index);
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object set(int index, Object s) {
            return set(index, (byte[]) s);
        }

        ByteArrayListView(LazyStringArrayList list) {
            this.list = list;
        }

        @Override // java.util.AbstractList, java.util.List
        public byte[] get(int index) {
            return this.list.getByteArray(index);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.list.size();
        }

        public byte[] set(int index, byte[] s) {
            Object r2 = LazyStringArrayList.access$000(this.list, index, s);
            this.modCount++;
            return LazyStringArrayList.access$100(r2);
        }

        public void add(int index, byte[] s) {
            LazyStringArrayList.access$200(this.list, index, s);
            this.modCount++;
        }

        @Override // java.util.AbstractList, java.util.List
        public byte[] remove(int index) {
            String r2 = this.list.remove(index);
            this.modCount++;
            return LazyStringArrayList.access$100(r2);
        }
    }

    private static class ByteStringListView extends AbstractList<ByteString> implements RandomAccess {
        private final LazyStringArrayList list;

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ void add(int index, Object s) {
            add(index, (ByteString) s);
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object get(int index) {
            return get(index);
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object remove(int index) {
            return remove(index);
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object set(int index, Object s) {
            return set(index, (ByteString) s);
        }

        ByteStringListView(LazyStringArrayList list) {
            this.list = list;
        }

        @Override // java.util.AbstractList, java.util.List
        public ByteString get(int index) {
            return this.list.getByteString(index);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.list.size();
        }

        public ByteString set(int index, ByteString s) {
            Object r2 = LazyStringArrayList.access$300(this.list, index, s);
            this.modCount++;
            return LazyStringArrayList.access$400(r2);
        }

        public void add(int index, ByteString s) {
            LazyStringArrayList.access$500(this.list, index, s);
            this.modCount++;
        }

        @Override // java.util.AbstractList, java.util.List
        public ByteString remove(int index) {
            String r2 = this.list.remove(index);
            this.modCount++;
            return LazyStringArrayList.access$400(r2);
        }
    }

    static /* synthetic */ Object access$000(LazyStringArrayList r0, int r1, byte[] r2) {
        return r0.setAndReturn(r1, r2);
    }

    static /* synthetic */ byte[] access$100(Object r0) {
        return asByteArray(r0);
    }

    static /* synthetic */ void access$200(LazyStringArrayList r0, int r1, byte[] r2) {
        r0.add(r1, r2);
    }

    static /* synthetic */ Object access$300(LazyStringArrayList r0, int r1, ByteString r2) {
        return r0.setAndReturn(r1, r2);
    }

    static /* synthetic */ ByteString access$400(Object r0) {
        return asByteString(r0);
    }

    static /* synthetic */ void access$500(LazyStringArrayList r0, int r1, ByteString r2) {
        r0.add(r1, r2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ void add(int index, Object element) {
        add(index, (String) element);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean add(Object e) {
        return super.add(e);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean equals(Object o) {
        return super.equals(o);
    }

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object get(int index) {
        return get(index);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, com.google.crypto.tink.shaded.protobuf.Internal.ProtobufList
    public /* bridge */ /* synthetic */ boolean isModifiable() {
        return super.isModifiable();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.ProtobufList, com.google.crypto.tink.shaded.protobuf.Internal.BooleanList
    public /* bridge */ /* synthetic */ Internal.ProtobufList mutableCopyWithCapacity(int capacity) {
        return mutableCopyWithCapacity(capacity);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object remove(int index) {
        return remove(index);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean remove(Object o) {
        return super.remove(o);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean removeAll(Collection c) {
        return super.removeAll(c);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean retainAll(Collection c) {
        return super.retainAll(c);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object set(int index, Object s) {
        return set(index, (String) s);
    }

    static {
        LazyStringArrayList r0 = new LazyStringArrayList(false);
        EMPTY_LIST = r0;
        EMPTY = r0;
    }

    public static LazyStringArrayList emptyList() {
        return EMPTY_LIST;
    }

    public LazyStringArrayList() {
        this(10);
    }

    private LazyStringArrayList(boolean isMutable) {
        super(isMutable);
        this.list = Collections.emptyList();
    }

    public LazyStringArrayList(int initialCapacity) {
        this(new ArrayList(initialCapacity));
    }

    public LazyStringArrayList(LazyStringList from) {
        this.list = new ArrayList(from.size());
        addAll(from);
    }

    public LazyStringArrayList(List<String> from) {
        this(new ArrayList(from));
    }

    private LazyStringArrayList(ArrayList<Object> list) {
        this.list = list;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.ProtobufList, com.google.crypto.tink.shaded.protobuf.Internal.BooleanList
    public LazyStringArrayList mutableCopyWithCapacity(int capacity) {
        if (capacity < size()) goto L7;
        ArrayList r0 = new ArrayList(capacity);
        r0.addAll(this.list);
        return new LazyStringArrayList(r0);
    L7:
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public String get(int index) {
        Object r0 = this.list.get(index);
        if ((r0 instanceof String) == false) goto L7;
        return (String) r0;
    L7:
        if ((r0 instanceof ByteString) == false) goto L12;
        ByteString r1 = (ByteString) r0;
        String r2 = r1.toStringUtf8();
        if (r1.isValidUtf8() == false) goto L11;
        this.list.set(index, r2);
    L11:
        return r2;
    L12:
        byte[] r3 = (byte[]) r0;
        String r4 = Internal.toStringUtf8(r3);
        if (Internal.isValidUtf8(r3) == false) goto L15;
        this.list.set(index, r4);
    L15:
        return r4;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.list.size();
    }

    public String set(int index, String s) {
        ensureIsMutable();
        return asString(this.list.set(index, s));
    }

    public void add(int index, String element) {
        ensureIsMutable();
        this.list.add(index, element);
        this.modCount++;
    }

    private void add(int index, ByteString element) {
        ensureIsMutable();
        this.list.add(index, element);
        this.modCount++;
    }

    private void add(int index, byte[] element) {
        ensureIsMutable();
        this.list.add(index, element);
        this.modCount++;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends String> c) {
        return addAll(size(), c);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public boolean addAll(int index, Collection<? extends String> c) {
        ensureIsMutable();
        if ((c instanceof LazyStringList) == false) goto L5;
        c = ((LazyStringList) c).getUnderlyingElements();
    L5:
        boolean r2 = this.list.addAll(index, c);
        this.modCount++;
        return r2;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public boolean addAllByteString(Collection<? extends ByteString> values) {
        ensureIsMutable();
        boolean r2 = this.list.addAll(values);
        this.modCount++;
        return r2;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public boolean addAllByteArray(Collection<byte[]> c) {
        ensureIsMutable();
        boolean r2 = this.list.addAll(c);
        this.modCount++;
        return r2;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public String remove(int index) {
        ensureIsMutable();
        Object r2 = this.list.remove(index);
        this.modCount++;
        return asString(r2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        ensureIsMutable();
        this.list.clear();
        this.modCount++;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public void add(ByteString element) {
        ensureIsMutable();
        this.list.add(element);
        this.modCount++;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public void add(byte[] element) {
        ensureIsMutable();
        this.list.add(element);
        this.modCount++;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public Object getRaw(int index) {
        return this.list.get(index);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public ByteString getByteString(int index) {
        Object r0 = this.list.get(index);
        ByteString r1 = asByteString(r0);
        if (r1 == r0) goto L5;
        this.list.set(index, r1);
    L5:
        return r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public byte[] getByteArray(int r3) {
        Object r0 = this.list.get(r3);
        byte[] r1 = asByteArray(r0);
        if (r1 == r0) goto L5;
        this.list.set(r3, r1);
    L5:
        return r1;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public void set(int index, ByteString s) {
        setAndReturn(index, s);
    }

    private Object setAndReturn(int index, ByteString s) {
        ensureIsMutable();
        return this.list.set(index, s);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public void set(int index, byte[] s) {
        setAndReturn(index, s);
    }

    private Object setAndReturn(int index, byte[] s) {
        ensureIsMutable();
        return this.list.set(index, s);
    }

    private static String asString(Object o) {
        if ((o instanceof String) == false) goto L7;
        return (String) o;
    L7:
        if ((o instanceof ByteString) == false) goto L11;
        return ((ByteString) o).toStringUtf8();
    L11:
        return Internal.toStringUtf8((byte[]) o);
    }

    private static ByteString asByteString(Object o) {
        if ((o instanceof ByteString) == false) goto L7;
        return (ByteString) o;
    L7:
        if ((o instanceof String) == false) goto L11;
        return ByteString.copyFromUtf8((String) o);
    L11:
        return ByteString.copyFrom((byte[]) o);
    }

    private static byte[] asByteArray(Object o) {
        if ((o instanceof byte[]) == false) goto L7;
        return (byte[]) o;
    L7:
        if ((o instanceof String) == false) goto L11;
        return Internal.toByteArray((String) o);
    L11:
        return ((ByteString) o).toByteArray();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public List<?> getUnderlyingElements() {
        return Collections.unmodifiableList(this.list);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public void mergeFrom(LazyStringList other) {
        ensureIsMutable();
        Iterator<?> r4 = other.getUnderlyingElements().iterator();
    L4:
        if (r4.hasNext() == false) goto L9;
        Object r0 = r4.next();
        if ((r0 instanceof byte[]) == true) goto L7;
        this.list.add(r0);
        goto L4
    L7:
        byte[] r1 = (byte[]) r0;
        this.list.add(Arrays.copyOf(r1, r1.length));
        goto L4
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public List<byte[]> asByteArrayList() {
        return new ByteArrayListView(this);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ProtocolStringList
    public List<ByteString> asByteStringList() {
        return new ByteStringListView(this);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public LazyStringList getUnmodifiableView() {
        if (isModifiable() == true) goto L5;
        return this;
    L5:
        return new UnmodifiableLazyStringList(this);
    }
}
