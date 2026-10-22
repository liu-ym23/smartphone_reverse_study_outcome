package kotlin.i0;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0007\u0018\u0000 P*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001PB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0007\b\u0016¢\u0006\u0002\u0010\u0006B\u0015\b\u0016\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0002\u0010\tJ\u0015\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\u001d\u0010\u0013\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0019J\u001e\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016J\u0016\u0010\u001a\u001a\u00020\u00142\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016J\u0013\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00028\u0000¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00028\u0000¢\u0006\u0002\u0010\u001cJ\b\u0010\u001e\u001a\u00020\u0017H\u0016J\u0016\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0016J\u001e\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0002J\u0010\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u0004H\u0002J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0010\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u0004H\u0002J\u001d\u0010'\u001a\u00020\u00142\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00140)H\u0082\bJ\u000b\u0010*\u001a\u00028\u0000¢\u0006\u0002\u0010+J\r\u0010,\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010+J\u0016\u0010-\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u0004H\u0096\u0002¢\u0006\u0002\u0010.J\u0010\u0010/\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0015\u00100\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00101J\u0016\u00102\u001a\u00028\u00002\u0006\u0010!\u001a\u00020\u0004H\u0083\b¢\u0006\u0002\u0010.J\u0011\u0010!\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0083\bJM\u00103\u001a\u00020\u00172>\u00104\u001a:\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(\u000e\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b¢\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u001705H\u0000¢\u0006\u0002\b8J\b\u00109\u001a\u00020\u0014H\u0016J\u000b\u0010:\u001a\u00028\u0000¢\u0006\u0002\u0010+J\u0015\u0010;\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00101J\r\u0010<\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010+J\u0010\u0010=\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0010\u0010>\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0015\u0010?\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\u0016\u0010@\u001a\u00020\u00142\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016J\u0015\u0010A\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0002\u0010.J\u000b\u0010B\u001a\u00028\u0000¢\u0006\u0002\u0010+J\r\u0010C\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010+J\u000b\u0010D\u001a\u00028\u0000¢\u0006\u0002\u0010+J\r\u0010E\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010+J\u0016\u0010F\u001a\u00020\u00142\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016J\u001e\u0010G\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010HJ\u0017\u0010I\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\u0000¢\u0006\u0004\bJ\u0010KJ)\u0010I\u001a\b\u0012\u0004\u0012\u0002HL0\u000b\"\u0004\b\u0001\u0010L2\f\u0010M\u001a\b\u0012\u0004\u0012\u0002HL0\u000bH\u0000¢\u0006\u0004\bJ\u0010NJ\u0015\u0010O\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\u0016¢\u0006\u0002\u0010KJ'\u0010O\u001a\b\u0012\u0004\u0012\u0002HL0\u000b\"\u0004\b\u0001\u0010L2\f\u0010M\u001a\b\u0012\u0004\u0012\u0002HL0\u000bH\u0016¢\u0006\u0002\u0010NR\u0018\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006Q"}, d2 = {"Lkotlin/collections/ArrayDeque;", "E", "Lkotlin/collections/AbstractMutableList;", "initialCapacity", "", "(I)V", "()V", "elements", "", "(Ljava/util/Collection;)V", "elementData", "", "", "[Ljava/lang/Object;", "head", "<set-?>", "size", "getSize", "()I", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "addFirst", "(Ljava/lang/Object;)V", "addLast", "clear", "contains", "copyCollectionElements", "internalIndex", "copyElements", "newCapacity", "decremented", "ensureCapacity", "minCapacity", "filterInPlace", "predicate", "Lkotlin/Function1;", "first", "()Ljava/lang/Object;", "firstOrNull", "get", "(I)Ljava/lang/Object;", "incremented", "indexOf", "(Ljava/lang/Object;)I", "internalGet", "internalStructure", "structure", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "internalStructure$kotlin_stdlib", "isEmpty", "last", "lastIndexOf", "lastOrNull", "negativeMod", "positiveMod", "remove", "removeAll", "removeAt", "removeFirst", "removeFirstOrNull", "removeLast", "removeLastOrNull", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "testToArray", "testToArray$kotlin_stdlib", "()[Ljava/lang/Object;", "T", "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "toArray", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class h<E> extends e<E> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f18347i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Object[] f18348j = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f18349f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Object[] f18350g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f18351h;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0007\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkotlin/collections/ArrayDeque$Companion;", "", "()V", "defaultMinCapacity", "", "emptyElementData", "", "[Ljava/lang/Object;", "maxArraySize", "newCapacity", "oldCapacity", "minCapacity", "newCapacity$kotlin_stdlib", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.n0.d.g r1) {
            this();
        }

        public final int a(int r2, int r3) {
            int r4 = r2 + (r2 >> 1);
            if ((r4 - r3) >= 0) goto L5;
            r4 = r3;
        L5:
            int r1 = 2147483639;
            if ((r4 - 2147483639) <= 0) goto L11;
            if (r3 <= 2147483639) goto L10;
            r1 = Integer.MAX_VALUE;
        L10:
            return r1;
        L11:
            return r4;
        }
    }

    static {
        f18347i = new a(null);
        f18348j = new Object[0];
    }

    public h() {
        this.f18350g = f18348j;
    }

    public h(int r3) {
        if (r3 != 0) goto L5;
        Object[] r4 = f18348j;
    L7:
        this.f18350g = r4;
        return;
    L5:
        if (r3 <= 0) goto L10;
        r4 = new Object[r3];
        goto L7
    L10:
        throw new IllegalArgumentException("Illegal Capacity: " + r3);
    }

    private final void a(int r5, Collection<? extends E> r6) {
        Iterator<? extends E> r0 = r6.iterator();
        int r1 = this.f18350g.length;
    L3:
        if (r5 >= r1) goto L7;
        if (r0.hasNext() == false) goto L7;
        this.f18350g[r5] = r0.next();
        r5 = r5 + 1;
    L7:
        int r7 = 0;
        int r2 = this.f18349f;
    L8:
        if (r7 >= r2) goto L12;
        if (r0.hasNext() == false) goto L12;
        this.f18350g[r7] = r0.next();
        r7 = r7 + 1;
    L12:
        this.f18351h = size() + r6.size();
    }

    private final void b(int r5) {
        Object[] r6 = new Object[r5];
        Object[] r0 = this.f18350g;
        i.f(r0, r6, 0, this.f18349f, r0.length);
        Object[] r1 = this.f18350g;
        int r2 = r1.length;
        int r3 = this.f18349f;
        i.f(r1, r6, r2 - r3, 0, r3);
        this.f18349f = 0;
        this.f18350g = r6;
    }

    private final int c(int r1) {
        if (r1 != 0) goto L5;
        return i.z(this.f18350g);
    L5:
        return r1 - 1;
    }

    private final void g(int r3) {
        if (r3 < 0) goto L13;
        Object[] r0 = this.f18350g;
        if (r3 > r0.length) goto L7;
        return;
    L7:
        if (r0 != f18348j) goto L10;
        this.f18350g = new Object[kotlin.r0.e.c(r3, 10)];
        return;
    L10:
        b(f18347i.a(r0.length, r3));
        return;
    L13:
        throw new IllegalStateException("Deque is too big.");
    }

    private final int n(int r1) {
        if (r1 != i.z(this.f18350g)) goto L6;
        return 0;
    L6:
        return r1 + 1;
    }

    private final int q(int r1) {
        if (r1 < 0) goto L4;
        return r1;
    L4:
        return r1 + this.f18350g.length;
    }

    private final int r(int r2) {
        Object[] r1 = this.f18350g;
        if (r2 >= r1.length) goto L5;
        return r2;
    L5:
        return r2 - r1.length;
    }

    @Override // kotlin.i0.e, java.util.AbstractList, java.util.List
    public void add(int r8, E r9) {
        c.Companion.b(r8, size());
        if (r8 != size()) goto L6;
        addLast(r9);
        return;
    L6:
        if (r8 != 0) goto L9;
        addFirst(r9);
        return;
    L9:
        g(size() + 1);
        int r0 = r(this.f18349f + r8);
        if (r8 >= ((size() + 1) >> 1)) goto L16;
        int r10 = c(r0);
        int r1 = c(this.f18349f);
        int r2 = this.f18349f;
        if (r10 < r2) goto L14;
        Object[] r3 = this.f18350g;
        r3[r1] = r3[r2];
        i.f(r3, r3, r2, r2 + 1, r10 + 1);
    L15:
        this.f18350g[r10] = r9;
        this.f18349f = r1;
    L21:
        this.f18351h = size() + 1;
        return;
    L14:
        Object[] r4 = this.f18350g;
        i.f(r4, r4, r2 - 1, r2, r4.length);
        Object[] r5 = this.f18350g;
        r5[r5.length - 1] = r5[0];
        i.f(r5, r5, 0, 1, r10 + 1);
        goto L15
    L16:
        int r11 = r(this.f18349f + size());
        Object[] r6 = this.f18350g;
        if (r0 >= r11) goto L19;
        i.f(r6, r6, r0 + 1, r0, r11);
    L20:
        this.f18350g[r0] = r9;
        goto L21
    L19:
        i.f(r6, r6, 1, 0, r11);
        Object[] r12 = this.f18350g;
        r12[0] = r12[r12.length - 1];
        i.f(r12, r12, r0 + 1, r0, r12.length - 1);
        goto L20
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E r1) {
        addLast(r1);
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int r9, Collection<? extends E> r10) {
        kotlin.n0.d.o.f(r10, "elements");
        c.Companion.b(r9, size());
        if (r10.isEmpty() == false) goto L6;
        return false;
    L6:
        if (r9 == size()) goto L8;
        g(size() + r10.size());
        int r0 = r(this.f18349f + size());
        int r2 = r(this.f18349f + r9);
        int r3 = r10.size();
        if (r9 >= ((size() + 1) >> 1)) goto L24;
        int r11 = this.f18349f;
        int r1 = r11 - r3;
        if (r2 < r11) goto L19;
        if (r1 < 0) goto L15;
        Object[] r4 = this.f18350g;
        i.f(r4, r4, r1, r11, r2);
    L23:
        this.f18349f = r1;
        a(q(r2 - r3), r10);
    L38:
        return true;
    L15:
        Object[] r5 = this.f18350g;
        r1 = r1 + r5.length;
        int r6 = r2 - r11;
        int r7 = r5.length - r1;
        if (r7 < r6) goto L18;
        i.f(r5, r5, r1, r11, r2);
        goto L23
    L18:
        i.f(r5, r5, r1, r11, r11 + r7);
        Object[] r12 = this.f18350g;
        i.f(r12, r12, 0, this.f18349f + r7, r2);
        goto L23
    L19:
        Object[] r8 = this.f18350g;
        i.f(r8, r8, r1, r11, r8.length);
        Object[] r13 = this.f18350g;
        if (r3 < r2) goto L22;
        i.f(r13, r13, r13.length - r3, 0, r2);
        goto L23
    L22:
        i.f(r13, r13, r13.length - r3, 0, r3);
        Object[] r14 = this.f18350g;
        i.f(r14, r14, 0, r3, r2);
        goto L23
    L24:
        int r15 = r2 + r3;
        if (r2 >= r0) goto L33;
        int r16 = r3 + r0;
        Object[] r17 = this.f18350g;
        if (r16 > r17.length) goto L30;
    L28:
        i.f(r17, r17, r15, r2, r0);
    L37:
        a(r2, r10);
        goto L38
    L30:
        if (r15 < r17.length) goto L32;
        r15 = r15 - r17.length;
        goto L28
    L32:
        int r18 = r0 - (r16 - r17.length);
        i.f(r17, r17, 0, r18, r0);
        Object[] r19 = this.f18350g;
        i.f(r19, r19, r15, r2, r18);
        goto L37
    L33:
        Object[] r20 = this.f18350g;
        i.f(r20, r20, r3, 0, r0);
        Object[] r21 = this.f18350g;
        if (r15 < r21.length) goto L36;
        i.f(r21, r21, r15 - r21.length, r2, r21.length);
        goto L37
    L36:
        i.f(r21, r21, 0, r21.length - r3, r21.length);
        Object[] r22 = this.f18350g;
        i.f(r22, r22, r15, r2, r22.length - r3);
        goto L37
    L8:
        return addAll(r10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> r3) {
        kotlin.n0.d.o.f(r3, "elements");
        if (r3.isEmpty() == false) goto L6;
        return false;
    L6:
        g(size() + r3.size());
        a(r(this.f18349f + size()), r3);
        return true;
    }

    public final void addFirst(E r3) {
        g(size() + 1);
        int r0 = c(this.f18349f);
        this.f18349f = r0;
        this.f18350g[r0] = r3;
        this.f18351h = size() + 1;
    }

    public final void addLast(E r4) {
        g(size() + 1);
        this.f18350g[r(this.f18349f + size())] = r4;
        this.f18351h = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        int r0 = r(this.f18349f + size());
        int r1 = this.f18349f;
        if (r1 >= r0) goto L6;
        i.l(this.f18350g, null, r1, r0);
    L8:
        this.f18349f = 0;
        this.f18351h = 0;
        return;
    L6:
        if ((!isEmpty()) == false) goto L8;
        Object[] r2 = this.f18350g;
        i.l(r2, null, this.f18349f, r2.length);
        i.l(this.f18350g, null, 0, r0);
        goto L8
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object r1) {
        if (indexOf(r1) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int r3) {
        c.Companion.a(r3, size());
        return (E) this.f18350g[r(this.f18349f + r3)];
    }

    @Override // kotlin.i0.e
    public int getSize() {
        return this.f18351h;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object r5) {
        int r0 = r(this.f18349f + size());
        int r1 = this.f18349f;
        if (r1 >= r0) goto L10;
    L4:
        if (r1 >= r0) goto L31;
        if (kotlin.n0.d.o.a(r5, this.f18350g[r1]) == true) goto L8;
        r1 = r1 + 1;
    L8:
        return r1 - this.f18349f;
    L31:
        return -1;
    L10:
        if (r1 < r0) goto L23;
        int r2 = this.f18350g.length;
    L12:
        if (r1 >= r2) goto L17;
        if (kotlin.n0.d.o.a(r5, this.f18350g[r1]) == true) goto L8;
        r1 = r1 + 1;
        goto L12
    L17:
        int r3 = 0;
    L18:
        if (r3 >= r0) goto L32;
        if (kotlin.n0.d.o.a(r5, this.f18350g[r3]) == true) goto L21;
        r3 = r3 + 1;
        goto L18
    L21:
        r1 = r3 + this.f18350g.length;
        goto L8
    L32:
        return -1;
    L23:
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final E l() {
        if (isEmpty() == true) goto L7;
        return (E) this.f18350g[this.f18349f];
    L7:
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object r5) {
        int r0 = r(this.f18349f + size());
        int r1 = this.f18349f;
        if (r1 >= r0) goto L12;
        int r2 = r0 - 1;
        if (r1 <= r2) goto L7;
    L26:
        return -1;
    L7:
        if (kotlin.n0.d.o.a(r5, this.f18350g[r2]) == true) goto L9;
        if (r2 == r1) goto L26;
        r2 = r2 - 1;
    L9:
        return r2 - this.f18349f;
    L12:
        if (r1 <= r0) goto L26;
        int r3 = r0 - 1;
    L14:
        if ((-1) >= r3) goto L19;
        if (kotlin.n0.d.o.a(r5, this.f18350g[r3]) == true) goto L17;
        r3 = r3 - 1;
        goto L14
    L17:
        r2 = r3 + this.f18350g.length;
        goto L9
    L19:
        r2 = i.z(this.f18350g);
        int r4 = this.f18349f;
        if (r4 > r2) goto L26;
    L22:
        if (kotlin.n0.d.o.a(r5, this.f18350g[r2]) == true) goto L9;
        if (r2 == r4) goto L26;
        r2 = r2 - 1;
        goto L22
    }

    public final E m() {
        if (isEmpty() == false) goto L6;
        return null;
    L6:
        return (E) this.f18350g[this.f18349f];
    }

    public final E o() {
        if (isEmpty() == true) goto L7;
        return (E) this.f18350g[r(this.f18349f + r.i(this))];
    L7:
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public final E p() {
        if (isEmpty() == false) goto L6;
        return null;
    L6:
        return (E) this.f18350g[r(this.f18349f + r.i(this))];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object r2) {
        int r3 = indexOf(r2);
        if (r3 != (-1)) goto L6;
        return false;
    L6:
        remove(r3);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<? extends Object> r12) {
        kotlin.n0.d.o.f(r12, "elements");
        boolean r1 = false;
        r1 = false;
        int r2 = 0;
        r1 = false;
        if (isEmpty() == false) goto L5;
    L37:
        return r1;
    L5:
        if (this.f18350g.length != 0) goto L7;
        Object[] r0 = true;
    L8:
        if (r0 == true) goto L37;
        int r3 = r(this.f18349f + size());
        int r4 = this.f18349f;
        if (r4 >= r3) goto L20;
        int r5 = r4;
    L13:
        if (r4 >= r3) goto L19;
        Object r6 = this.f18350g[r4];
        if ((!r12.contains(r6)) == false) goto L17;
        this.f18350g[r5] = r6;
        r5 = r5 + 1;
    L18:
        r4 = r4 + 1;
        goto L13
    L17:
        r1 = true;
        goto L18
    L19:
        i.l(this.f18350g, null, r5, r3);
    L35:
        if (r1 == false) goto L37;
        this.f18351h = q(r5 - this.f18349f);
        goto L37
    L20:
        int r7 = this.f18350g.length;
        boolean r8 = false;
        int r9 = r4;
    L21:
        if (r4 >= r7) goto L27;
        Object[] r10 = this.f18350g;
        Object r11 = r10[r4];
        r10[r4] = null;
        if ((!r12.contains(r11)) == false) goto L25;
        this.f18350g[r9] = r11;
        r9 = r9 + 1;
    L26:
        r4 = r4 + 1;
        goto L21
    L25:
        r8 = true;
        goto L26
    L27:
        r5 = r(r9);
    L28:
        if (r2 >= r3) goto L34;
        Object[] r13 = this.f18350g;
        Object r14 = r13[r2];
        r13[r2] = null;
        if ((!r12.contains(r14)) == false) goto L32;
        this.f18350g[r5] = r14;
        r5 = n(r5);
    L33:
        r2 = r2 + 1;
        goto L28
    L32:
        r8 = true;
        goto L33
    L34:
        r1 = r8;
        goto L35
    L7:
        r0 = false;
        goto L8
    }

    @Override // kotlin.i0.e
    public E removeAt(int r9) {
        c.Companion.a(r9, size());
        if (r9 == r.i(this)) goto L5;
        if (r9 == 0) goto L8;
        int r0 = r(this.f18349f + r9);
        E r1 = (E) this.f18350g[r0];
        if (r9 >= (size() >> 1)) goto L16;
        int r10 = this.f18349f;
        if (r0 < r10) goto L14;
        Object[] r2 = this.f18350g;
        i.f(r2, r2, r10 + 1, r10, r0);
    L15:
        Object[] r11 = this.f18350g;
        int r3 = this.f18349f;
        r11[r3] = null;
        this.f18349f = n(r3);
    L21:
        this.f18351h = size() - 1;
        return r1;
    L14:
        Object[] r12 = this.f18350g;
        i.f(r12, r12, 1, 0, r0);
        Object[] r13 = this.f18350g;
        r13[0] = r13[r13.length - 1];
        int r4 = this.f18349f;
        i.f(r13, r13, r4 + 1, r4, r13.length - 1);
        goto L15
    L16:
        int r14 = r(this.f18349f + r.i(this));
        Object[] r5 = this.f18350g;
        if (r0 > r14) goto L19;
        i.f(r5, r5, r0, r0 + 1, r14 + 1);
    L20:
        this.f18350g[r14] = null;
        goto L21
    L19:
        i.f(r5, r5, r0, r0 + 1, r5.length);
        Object[] r6 = this.f18350g;
        r6[r6.length - 1] = r6[0];
        i.f(r6, r6, 0, 1, r14 + 1);
        goto L20
    L8:
        return removeFirst();
    L5:
        return removeLast();
    }

    public final E removeFirst() {
        if (isEmpty() == true) goto L7;
        Object[] r0 = this.f18350g;
        int r1 = this.f18349f;
        E r2 = (E) r0[r1];
        r0[r1] = null;
        this.f18349f = n(r1);
        this.f18351h = size() - 1;
        return r2;
    L7:
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public final E removeLast() {
        if (isEmpty() == true) goto L7;
        int r0 = r(this.f18349f + r.i(this));
        Object[] r1 = this.f18350g;
        E r2 = (E) r1[r0];
        r1[r0] = null;
        this.f18351h = size() - 1;
        return r2;
    L7:
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<? extends Object> r12) {
        kotlin.n0.d.o.f(r12, "elements");
        boolean r1 = false;
        r1 = false;
        int r2 = 0;
        r1 = false;
        if (isEmpty() == false) goto L5;
    L37:
        return r1;
    L5:
        if (this.f18350g.length != 0) goto L7;
        Object[] r0 = true;
    L8:
        if (r0 == true) goto L37;
        int r3 = r(this.f18349f + size());
        int r4 = this.f18349f;
        if (r4 >= r3) goto L20;
        int r5 = r4;
    L13:
        if (r4 >= r3) goto L19;
        Object r6 = this.f18350g[r4];
        if (r12.contains(r6) == false) goto L17;
        this.f18350g[r5] = r6;
        r5 = r5 + 1;
    L18:
        r4 = r4 + 1;
        goto L13
    L17:
        r1 = true;
        goto L18
    L19:
        i.l(this.f18350g, null, r5, r3);
    L35:
        if (r1 == false) goto L37;
        this.f18351h = q(r5 - this.f18349f);
        goto L37
    L20:
        int r7 = this.f18350g.length;
        boolean r8 = false;
        int r9 = r4;
    L21:
        if (r4 >= r7) goto L27;
        Object[] r10 = this.f18350g;
        Object r11 = r10[r4];
        r10[r4] = null;
        if (r12.contains(r11) == false) goto L25;
        this.f18350g[r9] = r11;
        r9 = r9 + 1;
    L26:
        r4 = r4 + 1;
        goto L21
    L25:
        r8 = true;
        goto L26
    L27:
        r5 = r(r9);
    L28:
        if (r2 >= r3) goto L34;
        Object[] r13 = this.f18350g;
        Object r14 = r13[r2];
        r13[r2] = null;
        if (r12.contains(r14) == false) goto L32;
        this.f18350g[r5] = r14;
        r5 = n(r5);
    L33:
        r2 = r2 + 1;
        goto L28
    L32:
        r8 = true;
        goto L33
    L34:
        r1 = r8;
        goto L35
    L7:
        r0 = false;
        goto L8
    }

    @Override // kotlin.i0.e, java.util.AbstractList, java.util.List
    public E set(int r3, E r4) {
        c.Companion.a(r3, size());
        int r5 = r(this.f18349f + r3);
        Object[] r2 = this.f18350g;
        E r0 = (E) r2[r5];
        r2[r5] = r4;
        return r0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] r8) {
        kotlin.n0.d.o.f(r8, "array");
        if (r8.length >= size()) goto L6;
        r8 = (T[]) j.a(r8, size());
    L6:
        kotlin.n0.d.o.d(r8, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        int r4 = r(this.f18349f + size());
        int r3 = this.f18349f;
        if (r3 >= r4) goto L10;
        i.h(this.f18350g, r8, 0, r3, r4, 2, null);
    L13:
        if (r8.length <= size()) goto L15;
        r8[size()] = null;
    L15:
        return r8;
    L10:
        if ((!isEmpty()) == false) goto L13;
        Object[] r0 = this.f18350g;
        i.f(r0, r8, 0, this.f18349f, r0.length);
        Object[] r1 = this.f18350g;
        i.f(r1, r8, r1.length - this.f18349f, 0, r4);
        goto L13
    }
}
