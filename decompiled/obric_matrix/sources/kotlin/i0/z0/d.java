package kotlin.i0.z0;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.i0.i;
import kotlin.i0.j0;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0010#\n\u0002\u0010'\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010&\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 {*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u00060\u0004j\u0002`\u0005:\u0007{|}~\u007f\u0080\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tBE\b\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0002\u0010\u0012J\u0017\u00102\u001a\u00020\b2\u0006\u00103\u001a\u00028\u0000H\u0000¢\u0006\u0004\b4\u00105J\u0013\u00106\u001a\b\u0012\u0004\u0012\u00028\u00010\u000bH\u0002¢\u0006\u0002\u00107J\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000109J\r\u0010:\u001a\u00020;H\u0000¢\u0006\u0002\b<J\b\u0010=\u001a\u00020;H\u0016J\b\u0010>\u001a\u00020;H\u0002J\u0019\u0010?\u001a\u00020!2\n\u0010@\u001a\u0006\u0012\u0002\b\u00030AH\u0000¢\u0006\u0002\bBJ!\u0010C\u001a\u00020!2\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010EH\u0000¢\u0006\u0002\bFJ\u0015\u0010G\u001a\u00020!2\u0006\u00103\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010HJ\u0015\u0010I\u001a\u00020!2\u0006\u0010J\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010HJ\u0018\u0010K\u001a\u00020!2\u000e\u0010L\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u000309H\u0002J\u0010\u0010M\u001a\u00020;2\u0006\u0010\u0013\u001a\u00020\bH\u0002J\u0010\u0010N\u001a\u00020;2\u0006\u0010O\u001a\u00020\bH\u0002J\u0019\u0010P\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010QH\u0000¢\u0006\u0002\bRJ\u0013\u0010S\u001a\u00020!2\b\u0010L\u001a\u0004\u0018\u00010TH\u0096\u0002J\u0015\u0010U\u001a\u00020\b2\u0006\u00103\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00105J\u0015\u0010V\u001a\u00020\b2\u0006\u0010J\u001a\u00028\u0001H\u0002¢\u0006\u0002\u00105J\u0018\u0010W\u001a\u0004\u0018\u00018\u00012\u0006\u00103\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010XJ\u0015\u0010Y\u001a\u00020\b2\u0006\u00103\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00105J\b\u0010Z\u001a\u00020\bH\u0016J\b\u0010[\u001a\u00020!H\u0016J\u0019\u0010\\\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010]H\u0000¢\u0006\u0002\b^J\u001f\u0010_\u001a\u0004\u0018\u00018\u00012\u0006\u00103\u001a\u00028\u00002\u0006\u0010J\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010`J\u001e\u0010a\u001a\u00020;2\u0014\u0010b\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000109H\u0016J\"\u0010c\u001a\u00020!2\u0018\u0010b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010E0AH\u0002J\u001c\u0010d\u001a\u00020!2\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010EH\u0002J\u0010\u0010e\u001a\u00020!2\u0006\u0010f\u001a\u00020\bH\u0002J\u0010\u0010g\u001a\u00020;2\u0006\u0010h\u001a\u00020\bH\u0002J\u0017\u0010i\u001a\u0004\u0018\u00018\u00012\u0006\u00103\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010XJ!\u0010j\u001a\u00020!2\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010EH\u0000¢\u0006\u0002\bkJ\u0010\u0010l\u001a\u00020;2\u0006\u0010m\u001a\u00020\bH\u0002J\u0017\u0010n\u001a\u00020\b2\u0006\u00103\u001a\u00028\u0000H\u0000¢\u0006\u0004\bo\u00105J\u0010\u0010p\u001a\u00020;2\u0006\u0010q\u001a\u00020\bH\u0002J\u0017\u0010r\u001a\u00020!2\u0006\u0010s\u001a\u00028\u0001H\u0000¢\u0006\u0004\bt\u0010HJ\b\u0010u\u001a\u00020vH\u0016J\u0019\u0010w\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010xH\u0000¢\u0006\u0002\byJ\b\u0010z\u001a\u00020TH\u0002R\u0014\u0010\u0013\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R&\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00180\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0015R\u001e\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020!@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u001aR\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010'R\u0016\u0010(\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010*\u001a\u00020\b2\u0006\u0010 \u001a\u00020\b@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0015R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00010-8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0018\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010'R\u0016\u00100\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0081\u0001"}, d2 = {"Lkotlin/collections/builders/MapBuilder;", "K", "V", "", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "()V", "initialCapacity", "", "(I)V", "keysArray", "", "valuesArray", "presenceArray", "", "hashArray", "maxProbeDistance", "length", "([Ljava/lang/Object;[Ljava/lang/Object;[I[III)V", "capacity", "getCapacity", "()I", "entries", "", "", "getEntries", "()Ljava/util/Set;", "entriesView", "Lkotlin/collections/builders/MapBuilderEntries;", "hashShift", "hashSize", "getHashSize", "<set-?>", "", "isReadOnly", "isReadOnly$kotlin_stdlib", "()Z", "keys", "getKeys", "[Ljava/lang/Object;", "keysView", "Lkotlin/collections/builders/MapBuilderKeys;", "size", "getSize", "values", "", "getValues", "()Ljava/util/Collection;", "valuesView", "Lkotlin/collections/builders/MapBuilderValues;", "addKey", "key", "addKey$kotlin_stdlib", "(Ljava/lang/Object;)I", "allocateValuesArray", "()[Ljava/lang/Object;", "build", "", "checkIsMutable", "", "checkIsMutable$kotlin_stdlib", "clear", "compact", "containsAllEntries", "m", "", "containsAllEntries$kotlin_stdlib", "containsEntry", "entry", "", "containsEntry$kotlin_stdlib", "containsKey", "(Ljava/lang/Object;)Z", "containsValue", "value", "contentEquals", "other", "ensureCapacity", "ensureExtraCapacity", "n", "entriesIterator", "Lkotlin/collections/builders/MapBuilder$EntriesItr;", "entriesIterator$kotlin_stdlib", "equals", "", "findKey", "findValue", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "hash", "hashCode", "isEmpty", "keysIterator", "Lkotlin/collections/builders/MapBuilder$KeysItr;", "keysIterator$kotlin_stdlib", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "putAll", TypedValues.TransitionType.S_FROM, "putAllEntries", "putEntry", "putRehash", "i", "rehash", "newHashSize", "remove", "removeEntry", "removeEntry$kotlin_stdlib", "removeHashAt", "removedHash", "removeKey", "removeKey$kotlin_stdlib", "removeKeyAt", "index", "removeValue", "element", "removeValue$kotlin_stdlib", "toString", "", "valuesIterator", "Lkotlin/collections/builders/MapBuilder$ValuesItr;", "valuesIterator$kotlin_stdlib", "writeReplace", "Companion", "EntriesItr", "EntryRef", "Itr", "KeysItr", "ValuesItr", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class d<K, V> implements Map<K, V>, Serializable, kotlin.n0.d.l0.d {
    private static final a r = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private K[] f18375f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private V[] f18376g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int[] f18377h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int[] f18378i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f18379j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f18380k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f18381l;
    private int m;
    private kotlin.i0.z0.f<K> n;
    private g<V> o;
    private kotlin.i0.z0.e<K, V> p;
    private boolean q;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkotlin/collections/builders/MapBuilder$Companion;", "", "()V", "INITIAL_CAPACITY", "", "INITIAL_MAX_PROBE_DISTANCE", "MAGIC", "TOMBSTONE", "computeHashSize", "capacity", "computeShift", "hashSize", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.n0.d.g r1) {
            this();
        }

        public static final /* synthetic */ int a(a r0, int r1) {
            return r0.c(r1);
        }

        public static final /* synthetic */ int b(a r0, int r1) {
            return r0.d(r1);
        }

        private final int c(int r1) {
            return Integer.highestOneBit(kotlin.r0.e.c(r1, 1) * 3);
        }

        private final int d(int r1) {
            return Integer.numberOfLeadingZeros(r1) + 1;
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0002\u0010'\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00050\u0004B\u0019\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0007¢\u0006\u0002\u0010\bJ\u0015\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\nH\u0096\u0002J\u0012\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u00060\u000ej\u0002`\u000fJ\r\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lkotlin/collections/builders/MapBuilder$EntriesItr;", "K", "V", "Lkotlin/collections/builders/MapBuilder$Itr;", "", "", "map", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "next", "Lkotlin/collections/builders/MapBuilder$EntryRef;", "nextAppendString", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "nextHashCode", "", "nextHashCode$kotlin_stdlib", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b<K, V> extends C0474d<K, V> implements Iterator<Map.Entry<K, V>>, Object {
        public b(d<K, V> r2) {
            o.f(r2, "map");
            super(r2);
        }

        public c<K, V> j() {
            if (b() >= d.c(e())) goto L7;
            int r0 = b();
            g(r0 + 1);
            h(r0);
            c<K, V> r1 = new c(e(), c());
            f();
            return r1;
        L7:
            throw new NoSuchElementException();
        }

        public final void l(StringBuilder r4) {
            o.f(r4, "sb");
            if (b() >= d.c(e())) goto L15;
            int r0 = b();
            g(r0 + 1);
            h(r0);
            Object r1 = d.b(e())[c()];
            if (o.a(r1, e()) == false) goto L7;
            r4.append("(this Map)");
        L8:
            r4.append('=');
            Object[] r2 = d.f(e());
            o.c(r2);
            Object r3 = r2[c()];
            if (o.a(r3, e()) == false) goto L11;
            r4.append("(this Map)");
        L12:
            f();
            return;
        L11:
            r4.append(r3);
            goto L12
        L7:
            r4.append(r1);
            goto L8
        L15:
            throw new NoSuchElementException();
        }

        public final int m() {
            if (b() >= d.c(e())) goto L14;
            int r0 = b();
            g(r0 + 1);
            h(r0);
            Object r1 = d.b(e())[c()];
            int r2 = 0;
            if (r1 == null) goto L7;
            int r3 = r1.hashCode();
        L8:
            Object[] r4 = d.f(e());
            o.c(r4);
            Object r5 = r4[c()];
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            int r6 = r3 ^ r2;
            f();
            return r6;
        L7:
            r3 = 0;
            goto L8
        L14:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return j();
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B!\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\u0015\u0010\u0013\u001a\u00028\u00032\u0006\u0010\u0014\u001a\u00028\u0003H\u0016¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00028\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00028\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b¨\u0006\u0018"}, d2 = {"Lkotlin/collections/builders/MapBuilder$EntryRef;", "K", "V", "", "map", "Lkotlin/collections/builders/MapBuilder;", "index", "", "(Lkotlin/collections/builders/MapBuilder;I)V", "key", "getKey", "()Ljava/lang/Object;", "value", "getValue", "equals", "", "other", "", "hashCode", "setValue", "newValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class c<K, V> implements Map.Entry<K, V>, Object {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final d<K, V> f18382f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final int f18383g;

        public c(d<K, V> r2, int r3) {
            o.f(r2, "map");
            this.f18382f = r2;
            this.f18383g = r3;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object r3) {
            if ((r3 instanceof Map.Entry) == false) goto L9;
            Map.Entry r4 = (Map.Entry) r3;
            if (o.a(r4.getKey(), getKey()) == false) goto L9;
            if (o.a(r4.getValue(), getValue()) == false) goto L9;
            return true;
        L9:
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return (K) d.b(this.f18382f)[this.f18383g];
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            Object[] r0 = d.f(this.f18382f);
            o.c(r0);
            return (V) r0[this.f18383g];
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K r0 = getKey();
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            V r3 = getValue();
            if (r3 == null) goto L10;
            r1 = r3.hashCode();
        L10:
            return r2 ^ r1;
        L5:
            r2 = 0;
            goto L6
        }

        @Override // java.util.Map.Entry
        public V setValue(V r3) {
            this.f18382f.m();
            Object[] r0 = d.a(this.f18382f);
            int r2 = this.f18383g;
            V r1 = (V) r0[r2];
            r0[r2] = r3;
            return r1;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append(getKey());
            r0.append('=');
            r0.append(getValue());
            return r0.toString();
        }
    }

    /* JADX INFO: renamed from: kotlin.i0.z0.d$d, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0010\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0012\u001a\u00020\u0013J\r\u0010\u0014\u001a\u00020\u0015H\u0000¢\u0006\u0002\b\u0016J\u0006\u0010\u0017\u001a\u00020\u0015R\u001a\u0010\u0007\u001a\u00020\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR \u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, d2 = {"Lkotlin/collections/builders/MapBuilder$Itr;", "K", "V", "", "map", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "index", "", "getIndex$kotlin_stdlib", "()I", "setIndex$kotlin_stdlib", "(I)V", "lastIndex", "getLastIndex$kotlin_stdlib", "setLastIndex$kotlin_stdlib", "getMap$kotlin_stdlib", "()Lkotlin/collections/builders/MapBuilder;", "hasNext", "", "initNext", "", "initNext$kotlin_stdlib", "remove", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static class C0474d<K, V> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final d<K, V> f18384f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f18385g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f18386h;

        public C0474d(d<K, V> r2) {
            o.f(r2, "map");
            this.f18384f = r2;
            this.f18386h = -1;
            f();
        }

        public final int b() {
            return this.f18385g;
        }

        public final int c() {
            return this.f18386h;
        }

        public final d<K, V> e() {
            return this.f18384f;
        }

        public final void f() {
        L3:
            if (this.f18385g >= d.c(this.f18384f)) goto L7;
            int[] r0 = d.e(this.f18384f);
            int r1 = this.f18385g;
            if (r0[r1] >= 0) goto L10;
            this.f18385g = r1 + 1;
            goto L3
        L10:
            return;
        }

        public final void g(int r1) {
            this.f18385g = r1;
        }

        public final void h(int r1) {
            this.f18386h = r1;
        }

        public final boolean hasNext() {
            if (this.f18385g >= d.c(this.f18384f)) goto L5;
            return true;
        L5:
            return false;
        }

        public final void remove() {
            if (this.f18386h == (-1)) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L10;
            this.f18384f.m();
            d.g(this.f18384f, this.f18386h);
            this.f18386h = -1;
            return;
        L10:
            throw new IllegalStateException("Call next() before removing element from the iterator.".toString());
        L5:
            r0 = false;
            goto L6
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u0019\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\b\u001a\u00028\u0002H\u0096\u0002¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lkotlin/collections/builders/MapBuilder$KeysItr;", "K", "V", "Lkotlin/collections/builders/MapBuilder$Itr;", "", "map", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class e<K, V> extends C0474d<K, V> implements Iterator<K>, Object {
        public e(d<K, V> r2) {
            o.f(r2, "map");
            super(r2);
        }

        @Override // java.util.Iterator
        public K next() {
            if (b() >= d.c(e())) goto L7;
            int r0 = b();
            g(r0 + 1);
            h(r0);
            K r1 = (K) d.b(e())[c()];
            f();
            return r1;
        L7:
            throw new NoSuchElementException();
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00020\u0004B\u0019\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\b\u001a\u00028\u0003H\u0096\u0002¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lkotlin/collections/builders/MapBuilder$ValuesItr;", "K", "V", "Lkotlin/collections/builders/MapBuilder$Itr;", "", "map", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class f<K, V> extends C0474d<K, V> implements Iterator<V>, Object {
        public f(d<K, V> r2) {
            o.f(r2, "map");
            super(r2);
        }

        @Override // java.util.Iterator
        public V next() {
            if (b() >= d.c(e())) goto L7;
            int r0 = b();
            g(r0 + 1);
            h(r0);
            Object[] r1 = d.f(e());
            o.c(r1);
            V r2 = (V) r1[c()];
            f();
            return r2;
        L7:
            throw new NoSuchElementException();
        }
    }

    static {
        r = new a(null);
    }

    public d() {
        this(8);
    }

    public d(int r8) {
        this(kotlin.i0.z0.c.d(r8), null, new int[r8], new int[a.a(r, r8)], 2, 0);
    }

    private d(K[] r1, V[] r2, int[] r3, int[] r4, int r5, int r6) {
        this.f18375f = r1;
        this.f18376g = r2;
        this.f18377h = r3;
        this.f18378i = r4;
        this.f18379j = r5;
        this.f18380k = r6;
        this.f18381l = a.b(r, y());
    }

    private final int C(K r2) {
        if (r2 == null) goto L4;
        int r3 = r2.hashCode();
    L6:
        return (r3 * (-1640531527)) >>> this.f18381l;
    L4:
        r3 = 0;
        goto L6
    }

    private final boolean E(Collection<? extends Map.Entry<? extends K, ? extends V>> r3) {
        boolean r1 = false;
        if (r3.isEmpty() == false) goto L5;
        return false;
    L5:
        s(r3.size());
        Iterator<? extends Map.Entry<? extends K, ? extends V>> r4 = r3.iterator();
    L7:
        if (r4.hasNext() == false) goto L11;
        if (F(r4.next()) == false) goto L7;
        r1 = true;
        goto L7
    L11:
        return r1;
    }

    private final boolean F(Map.Entry<? extends K, ? extends V> r5) {
        int r0 = h(r5.getKey());
        V[] r4 = j();
        if (r0 < 0) goto L6;
        r4[r0] = r5.getValue();
        return true;
    L6:
        int r1 = (-r0) - 1;
        V r2 = r4[r1];
        if (o.a(r5.getValue(), r2) == true) goto L10;
        r4[r1] = r5.getValue();
        return true;
    L10:
        return false;
    }

    private final boolean G(int r6) {
        int r0 = C(this.f18375f[r6]);
        int r1 = this.f18379j;
    L3:
        int[] r2 = this.f18378i;
        if (r2[r0] == 0) goto L5;
        r1 = r1 - 1;
        if (r1 < 0) goto L9;
        int r3 = r0 - 1;
        if (r0 == 0) goto L13;
        r0 = r3;
        goto L3
    L13:
        r0 = y() - 1;
        goto L3
    L9:
        return false;
    L5:
        r2[r0] = r6 + 1;
        this.f18377h[r6] = r0;
        return true;
    }

    private final void H(int r3) {
        if (this.f18380k <= size()) goto L5;
        n();
    L5:
        int r1 = 0;
        if (r3 == y()) goto L8;
        this.f18378i = new int[r3];
        this.f18381l = a.b(r, r3);
    L10:
        if (r1 >= this.f18380k) goto L16;
        int r4 = r1 + 1;
        if (G(r1) == false) goto L15;
        r1 = r4;
        goto L10
    L15:
        throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
    L16:
        return;
    L8:
        i.k(this.f18378i, 0, 0, y());
        goto L10
    }

    private final void J(int r10) {
        int r2 = kotlin.r0.e.f(this.f18379j * 2, y() / 2);
        int r3 = 0;
        int r0 = r10;
    L3:
        int r4 = r10 - 1;
        if (r10 != 0) goto L6;
        r10 = y() - 1;
    L7:
        r3 = r3 + 1;
        if (r3 > this.f18379j) goto L9;
        int[] r5 = this.f18378i;
        int r6 = r5[r10];
        if (r6 == 0) goto L13;
        if (r6 >= 0) goto L19;
        r5[r0] = -1;
    L18:
        r0 = r10;
        r3 = 0;
    L22:
        r2 = r2 - 1;
        if (r2 >= 0) goto L3;
        this.f18378i[r0] = -1;
        return;
    L19:
        int r7 = r6 - 1;
        if (((C(this.f18375f[r7]) - r10) & (y() - 1)) < r3) goto L22;
        this.f18378i[r0] = r6;
        this.f18377h[r7] = r0;
        goto L18
    L13:
        r5[r0] = 0;
        return;
    L9:
        this.f18378i[r0] = 0;
        return;
    L6:
        r10 = r4;
        goto L7
    }

    private final void L(int r3) {
        kotlin.i0.z0.c.f(this.f18375f, r3);
        J(this.f18377h[r3]);
        this.f18377h[r3] = -1;
        this.m = size() - 1;
    }

    public static final /* synthetic */ Object[] a(d r0) {
        return r0.j();
    }

    public static final /* synthetic */ Object[] b(d r0) {
        return r0.f18375f;
    }

    public static final /* synthetic */ int c(d r0) {
        return r0.f18380k;
    }

    public static final /* synthetic */ int[] e(d r0) {
        return r0.f18377h;
    }

    public static final /* synthetic */ Object[] f(d r0) {
        return r0.f18376g;
    }

    public static final /* synthetic */ void g(d r0, int r1) {
        r0.L(r1);
    }

    private final V[] j() {
        V[] r0 = this.f18376g;
        if (r0 == null) goto L5;
        return r0;
    L5:
        V[] r1 = (V[]) kotlin.i0.z0.c.d(w());
        this.f18376g = r1;
        return r1;
    }

    private final void n() {
        V[] r0 = this.f18376g;
        int r1 = 0;
        int r2 = 0;
    L3:
        int r3 = this.f18380k;
        if (r1 >= r3) goto L12;
        if (this.f18377h[r1] < 0) goto L11;
        K[] r4 = this.f18375f;
        r4[r2] = r4[r1];
        if (r0 == null) goto L10;
        r0[r2] = r0[r1];
    L10:
        r2 = r2 + 1;
    L11:
        r1 = r1 + 1;
        goto L3
    L12:
        kotlin.i0.z0.c.g(this.f18375f, r2, r3);
        if (r0 == null) goto L15;
        kotlin.i0.z0.c.g(r0, r2, this.f18380k);
    L15:
        this.f18380k = r2;
    }

    private final boolean q(Map<?, ?> r3) {
        if (size() == r3.size()) goto L5;
    L7:
        return false;
    L5:
        if (o(r3.entrySet()) == false) goto L7;
        return true;
    }

    private final void r(int r3) {
        if (r3 < 0) goto L22;
        if (r3 <= w()) goto L17;
        int r0 = (w() * 3) / 2;
        if (r3 > r0) goto L9;
        r3 = r0;
    L9:
        this.f18375f = (K[]) kotlin.i0.z0.c.e(this.f18375f, r3);
        V[] r1 = this.f18376g;
        if (r1 == null) goto L12;
        V[] r2 = (V[]) kotlin.i0.z0.c.e(r1, r3);
    L13:
        this.f18376g = r2;
        int[] r4 = Arrays.copyOf(this.f18377h, r3);
        o.e(r4, "copyOf(this, newSize)");
        this.f18377h = r4;
        int r5 = a.a(r, r3);
        if (r5 <= y()) goto L23;
    L19:
        H(r5);
        return;
    L23:
        return;
    L12:
        r2 = null;
        goto L13
    L17:
        if (((this.f18380k + r3) - size()) <= w()) goto L24;
        r5 = y();
        goto L19
    L24:
        return;
    L22:
        throw new OutOfMemoryError();
    }

    private final void s(int r2) {
        r(this.f18380k + r2);
    }

    private final int u(K r6) {
        int r0 = C(r6);
        int r1 = this.f18379j;
    L3:
        int r2 = this.f18378i[r0];
        if (r2 == 0) goto L5;
        if (r2 <= 0) goto L10;
        int r3 = r2 - 1;
        if (o.a(this.f18375f[r3], r6) == false) goto L10;
        return r3;
    L10:
        r1 = r1 - 1;
        if (r1 < 0) goto L12;
        int r4 = r0 - 1;
        if (r0 == 0) goto L15;
        r0 = r4;
        goto L3
    L15:
        r0 = y() - 1;
        goto L3
    L12:
        return -1;
    L5:
        return -1;
    }

    private final int v(V r3) {
        int r0 = this.f18380k;
    L3:
        r0 = r0 - 1;
        if (r0 < 0) goto L10;
        if (this.f18377h[r0] < 0) goto L3;
        V[] r1 = this.f18376g;
        o.c(r1);
        if (o.a(r1[r0], r3) == false) goto L3;
        return r0;
    L10:
        return -1;
    }

    private final int w() {
        return this.f18375f.length;
    }

    private final int y() {
        return this.f18378i.length;
    }

    public int A() {
        return this.m;
    }

    public Collection<V> B() {
        g<V> r0 = this.o;
        if (r0 != null) goto L6;
        g<V> r1 = new g(this);
        this.o = r1;
        return r1;
    L6:
        return r0;
    }

    public final e<K, V> D() {
        return new e(this);
    }

    public final boolean I(Map.Entry<? extends K, ? extends V> r4) {
        o.f(r4, "entry");
        m();
        int r0 = u(r4.getKey());
        if (r0 >= 0) goto L5;
        return false;
    L5:
        V[] r2 = this.f18376g;
        o.c(r2);
        if (o.a(r2[r0], r4.getValue()) == true) goto L8;
        return false;
    L8:
        L(r0);
        return true;
    }

    public final int K(K r1) {
        m();
        int r2 = u(r1);
        if (r2 >= 0) goto L6;
        return -1;
    L6:
        L(r2);
        return r2;
    }

    public final boolean M(V r1) {
        m();
        int r2 = v(r1);
        if (r2 >= 0) goto L6;
        return false;
    L6:
        L(r2);
        return true;
    }

    public final f<K, V> N() {
        return new f(this);
    }

    @Override // java.util.Map
    public void clear() {
        m();
        j0 r0 = new kotlin.r0.d(0, this.f18380k - 1).g();
    L4:
        if (r0.hasNext() == false) goto L8;
        int r1 = r0.nextInt();
        int[] r3 = this.f18377h;
        int r4 = r3[r1];
        if (r4 < 0) goto L4;
        this.f18378i[r4] = 0;
        r3[r1] = -1;
        goto L4
    L8:
        kotlin.i0.z0.c.g(this.f18375f, 0, this.f18380k);
        V[] r2 = this.f18376g;
        if (r2 == null) goto L11;
        kotlin.i0.z0.c.g(r2, 0, this.f18380k);
    L11:
        this.m = 0;
        this.f18380k = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsKey(Object r1) {
        if (u(r1) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsValue(Object r1) {
        if (v(r1) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return x();
    }

    @Override // java.util.Map
    public boolean equals(Object r2) {
        if (r2 != this) goto L4;
    L9:
        return true;
    L4:
        if ((r2 instanceof Map) == true) goto L6;
    L8:
        return false;
    L6:
        if (q((Map) r2) == false) goto L8;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public V get(Object r1) {
        int r2 = u(r1);
        if (r2 >= 0) goto L6;
        return null;
    L6:
        V[] r0 = this.f18376g;
        o.c(r0);
        return r0[r2];
    }

    public final int h(K r8) {
        m();
    L3:
        int r0 = C(r8);
        int r1 = kotlin.r0.e.f(this.f18379j * 2, y() / 2);
        int r2 = 0;
    L4:
        int r3 = this.f18378i[r0];
        if (r3 <= 0) goto L7;
        if (o.a(this.f18375f[r3 - 1], r8) == true) goto L16;
        r2 = r2 + 1;
        if (r2 > r1) goto L19;
        int r4 = r0 - 1;
        if (r0 == 0) goto L22;
        r0 = r4;
        goto L4
    L22:
        r0 = y() - 1;
        goto L4
    L19:
        H(y() * 2);
        goto L3
    L16:
        return -r3;
    L7:
        if (this.f18380k < w()) goto L9;
        s(1);
        goto L3
    L9:
        int r5 = this.f18380k;
        int r6 = r5 + 1;
        this.f18380k = r6;
        this.f18375f[r5] = r8;
        this.f18377h[r5] = r0;
        this.f18378i[r0] = r6;
        this.m = size() + 1;
        if (r2 <= this.f18379j) goto L12;
        this.f18379j = r2;
    L12:
        return r5;
    }

    @Override // java.util.Map
    public int hashCode() {
        b<K, V> r2 = t();
        int r0 = 0;
    L4:
        if (r2.hasNext() == false) goto L6;
        r0 = r0 + r2.m();
        goto L4
    L6:
        return r0;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return z();
    }

    public final Map<K, V> l() {
        m();
        this.q = true;
        return this;
    }

    public final void m() {
        if (this.q == true) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException();
    }

    public final boolean o(Collection<?> r3) {
        o.f(r3, "m");
        Iterator<?> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L10;
        Object r0 = r4.next();
        if (r0 == null) goto L9;
        if (p((Map.Entry) r0) == true) goto L4;
    L9:
        return false;
    L10:
        return true;
    }

    public final boolean p(Map.Entry<? extends K, ? extends V> r2) {
        o.f(r2, "entry");
        int r0 = u(r2.getKey());
        if (r0 >= 0) goto L6;
        return false;
    L6:
        V[] r1 = this.f18376g;
        o.c(r1);
        return o.a(r1[r0], r2.getValue());
    }

    @Override // java.util.Map
    public V put(K r2, V r3) {
        m();
        int r4 = h(r2);
        V[] r1 = j();
        if (r4 >= 0) goto L6;
        int r5 = (-r4) - 1;
        V r0 = r1[r5];
        r1[r5] = r3;
        return r0;
    L6:
        r1[r4] = r3;
        return null;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> r2) {
        o.f(r2, TypedValues.TransitionType.S_FROM);
        m();
        E(r2.entrySet());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public V remove(Object r2) {
        int r3 = K(r2);
        if (r3 >= 0) goto L6;
        return null;
    L6:
        V[] r1 = this.f18376g;
        o.c(r1);
        V r0 = r1[r3];
        kotlin.i0.z0.c.f(r1, r3);
        return r0;
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return A();
    }

    public final b<K, V> t() {
        return new b(this);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder((size() * 3) + 2);
        r0.append("{");
        b<K, V> r3 = t();
        int r1 = 0;
    L4:
        if (r3.hasNext() == false) goto L8;
        if (r1 <= 0) goto L7;
        r0.append(", ");
    L7:
        r3.l(r0);
        r1 = r1 + 1;
        goto L4
    L8:
        r0.append("}");
        String r4 = r0.toString();
        o.e(r4, "sb.toString()");
        return r4;
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return B();
    }

    public Set<Map.Entry<K, V>> x() {
        kotlin.i0.z0.e<K, V> r0 = this.p;
        if (r0 != null) goto L6;
        kotlin.i0.z0.e<K, V> r1 = new kotlin.i0.z0.e(this);
        this.p = r1;
        return r1;
    L6:
        return r0;
    }

    public Set<K> z() {
        kotlin.i0.z0.f<K> r0 = this.n;
        if (r0 != null) goto L6;
        kotlin.i0.z0.f<K> r1 = new kotlin.i0.z0.f(this);
        this.n = r1;
        return r1;
    L6:
        return r0;
    }
}
