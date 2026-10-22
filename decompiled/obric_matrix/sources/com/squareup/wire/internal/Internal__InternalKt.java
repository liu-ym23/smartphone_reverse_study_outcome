package com.squareup.wire.internal;

import com.squareup.wire.ProtoAdapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.i0.m0;
import kotlin.i0.r;
import kotlin.n0.d.j0;
import kotlin.n0.d.o;
import kotlin.r0.b;
import kotlin.r0.e;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\u001a\u0019\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a%\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005¢\u0006\u0004\b\u0007\u0010\b\u001a3\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\u0006\u0010\n\u001a\u00020\t2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000bH\u0007¢\u0006\u0004\b\r\u0010\u000e\u001a'\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b¢\u0006\u0004\b\r\u0010\u000f\u001aE\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u00052\u0006\u0010\n\u001a\u00020\t2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0010H\u0007¢\u0006\u0004\b\r\u0010\u0012\u001a9\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u00052\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0010¢\u0006\u0004\b\r\u0010\u0013\u001a/\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u00002\u0006\u0010\n\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b¢\u0006\u0004\b\u0014\u0010\u000e\u001aE\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0010\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u00052\u0006\u0010\n\u001a\u00020\t2\u0016\u0010\u0011\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u0010¢\u0006\u0004\b\u0014\u0010\u0012\u001a3\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0007¢\u0006\u0004\b\u0017\u0010\u0018\u001aE\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0010\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00102\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00010\u0015H\u0007¢\u0006\u0004\b\u0017\u0010\u001a\u001a!\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u001f\u0010 \u001a)\u0010%\u001a\u00060#j\u0002`$2\u0016\u0010\"\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u001b0!\"\u0004\u0018\u00010\u001b¢\u0006\u0004\b%\u0010&\u001a\u0019\u0010(\u001a\u00020'2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000b¢\u0006\u0004\b(\u0010)\u001a\u001d\u0010(\u001a\u00020'2\u000e\u0010\u0011\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0010¢\u0006\u0004\b(\u0010*\u001a!\u0010,\u001a\u00020+2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b,\u0010-\u001a+\u0010,\u001a\u00020+2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001b2\b\u0010.\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b,\u0010/\u001aM\u0010,\u001a\u00020+2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001b2\b\u0010.\u001a\u0004\u0018\u00010\u001b2\b\u00100\u001a\u0004\u0018\u00010\u001b2\u0016\u00101\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u001b0!\"\u0004\u0018\u00010\u001b¢\u0006\u0004\b,\u00102¨\u00063"}, d2 = {"T", "", "newMutableList", "()Ljava/util/List;", "K", "V", "", "newMutableMap", "()Ljava/util/Map;", "", "name", "", "list", "copyOf", "(Ljava/lang/String;Ljava/util/List;)Ljava/util/List;", "(Ljava/util/List;)Ljava/util/List;", "", "map", "(Ljava/lang/String;Ljava/util/Map;)Ljava/util/Map;", "(Ljava/util/Map;)Ljava/util/Map;", "immutableCopyOf", "Lcom/squareup/wire/ProtoAdapter;", "adapter", "-redactElements", "(Ljava/util/List;Lcom/squareup/wire/ProtoAdapter;)Ljava/util/List;", "redactElements", "(Ljava/util/Map;Lcom/squareup/wire/ProtoAdapter;)Ljava/util/Map;", "", "a", "b", "", "equals", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "", "args", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "missingRequiredFields", "([Ljava/lang/Object;)Ljava/lang/IllegalStateException;", "Lkotlin/f0;", "checkElementsNotNull", "(Ljava/util/List;)V", "(Ljava/util/Map;)V", "", "countNonNull", "(Ljava/lang/Object;Ljava/lang/Object;)I", "c", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)I", "d", "rest", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)I", "wire-runtime"}, k = 5, mv = {1, 1, 15}, xs = "com/squareup/wire/internal/Internal")
final /* synthetic */ class Internal__InternalKt {
    /* JADX INFO: renamed from: -redactElements, reason: not valid java name */
    public static final <T> List<T> m70redactElements(List<? extends T> r2, ProtoAdapter<T> r3) {
        o.g(r2, "$this$redactElements");
        o.g(r3, "adapter");
        ArrayList r0 = new ArrayList(r.q(r2, 10));
        Iterator<T> r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r0.add(r3.redact(r4.next()));
        goto L4
    L6:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: -redactElements, reason: not valid java name */
    public static final <K, V> Map<K, V> m71redactElements(Map<K, ? extends V> r3, ProtoAdapter<V> r4) {
        o.g(r3, "$this$redactElements");
        o.g(r4, "adapter");
        LinkedHashMap r0 = new LinkedHashMap(m0.d(r3.size()));
        Iterator<T> r5 = r3.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        Map.Entry r1 = (Map.Entry) r5.next();
        r0.put(r1.getKey(), r4.redact(r1.getValue()));
        goto L4
    L6:
        return r0;
    }

    public static final void checkElementsNotNull(List<?> r3) {
        o.g(r3, "list");
        int r0 = r3.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        if (r3.get(r1) == null) goto L8;
        r1 = r1 + 1;
        goto L3
    L8:
        throw new NullPointerException("Element at index " + r1 + " is null");
    }

    public static final void checkElementsNotNull(Map<?, ?> r3) {
        o.g(r3, "map");
        Iterator<Map.Entry<?, ?>> r4 = r3.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L10;
        Map.Entry<?, ?> r0 = r4.next();
        Object r1 = r0.getKey();
        Object r2 = r0.getValue();
        Objects.requireNonNull(r1, "map.containsKey(null)");
        if (r2 != null) goto L4;
        throw new NullPointerException("Value for key " + r1 + " is null");
    }

    public static final <T> List<T> copyOf(String r1, List<? extends T> r2) {
        o.g(r1, "name");
        if (r2 != null) goto L5;
        o.p();
        throw null;
    L5:
        return Internal.copyOf(r2);
    }

    public static final <T> List<T> copyOf(List<? extends T> r1) {
        o.g(r1, "list");
        if (r1 == r.g()) goto L9;
        if ((r1 instanceof ImmutableList) == true) goto L9;
        return new ArrayList(r1);
    L9:
        return new MutableOnWriteList(r1);
    }

    public static final <K, V> Map<K, V> copyOf(String r1, Map<K, ? extends V> r2) {
        o.g(r1, "name");
        if (r2 != null) goto L5;
        o.p();
        throw null;
    L5:
        return Internal.copyOf(r2);
    }

    public static final <K, V> Map<K, V> copyOf(Map<K, ? extends V> r1) {
        o.g(r1, "map");
        return new LinkedHashMap(r1);
    }

    public static final int countNonNull(Object r2, Object r3) {
        int r0 = 1;
        if (r2 == null) goto L5;
        int r4 = 1;
    L6:
        if (r3 != null) goto L10;
        r0 = 0;
    L10:
        return r4 + r0;
    L5:
        r4 = 0;
        goto L6
    }

    public static final int countNonNull(Object r2, Object r3, Object r4) {
        int r0 = 1;
        if (r2 == null) goto L5;
        int r5 = 1;
    L6:
        if (r3 == null) goto L8;
        int r6 = 1;
    L9:
        int r7 = r5 + r6;
        if (r4 != null) goto L14;
        r0 = 0;
    L14:
        return r7 + r0;
    L8:
        r6 = 0;
        goto L9
    L5:
        r5 = 0;
        goto L6
    }

    public static final int countNonNull(Object r1, Object r2, Object r3, Object r4, Object... r5) {
        o.g(r5, "rest");
        int r0 = 0;
        if (r1 == null) goto L5;
        int r6 = 1;
    L6:
        if (r2 == null) goto L8;
        r6 = r6 + 1;
    L8:
        if (r3 == null) goto L10;
        r6 = r6 + 1;
    L10:
        if (r4 == null) goto L12;
        r6 = r6 + 1;
    L12:
        int r7 = r5.length;
    L13:
        if (r0 >= r7) goto L18;
        if (r5[r0] == null) goto L17;
        r6 = r6 + 1;
    L17:
        r0 = r0 + 1;
        goto L13
    L18:
        return r6;
    L5:
        r6 = 0;
        goto L6
    }

    public static final boolean equals(Object r0, Object r1) {
        if (r0 == r1) goto L8;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (o.a(r0, r1) == false) goto L7;
    L8:
        return true;
    }

    public static final <T> List<T> immutableCopyOf(String r1, List<? extends T> r2) {
        o.g(r1, "name");
        o.g(r2, "list");
        if ((r2 instanceof MutableOnWriteList) == false) goto L6;
        r2 = (List<T>) ((MutableOnWriteList) r2).getMutableList$wire_runtime();
    L6:
        if (r2 != r.g()) goto L8;
    L15:
        return (List<T>) r2;
    L8:
        if ((r2 instanceof ImmutableList) == true) goto L15;
        ImmutableList r0 = new ImmutableList(r2);
        if ((!r0.contains(null)) == false) goto L14;
        return r0;
    L14:
        throw new IllegalArgumentException((r1 + ".contains(null)").toString());
    }

    public static final <K, V> Map<K, V> immutableCopyOf(String r2, Map<K, ? extends V> r3) {
        o.g(r2, "name");
        o.g(r3, "map");
        if (r3.isEmpty() == true) goto L5;
        LinkedHashMap r0 = new LinkedHashMap(r3);
        if ((!r0.keySet().contains(null)) == false) goto L15;
        if ((!r0.values().contains(null)) == false) goto L13;
        Map<K, V> r4 = Collections.unmodifiableMap(j0.c(r0));
        o.b(r4, "Collections.unmodifiableMap(this)");
        return r4;
    L13:
        throw new IllegalArgumentException((r2 + ".containsValue(null)").toString());
    L15:
        throw new IllegalArgumentException((r2 + ".containsKey(null)").toString());
    L5:
        return m0.h();
    }

    public static final IllegalStateException missingRequiredFields(Object... r7) {
        o.g(r7, "args");
        StringBuilder r0 = new StringBuilder();
        b r1 = e.l(e.m(0, r7.length), 2);
        int r3 = r1.a();
        int r4 = r1.b();
        int r2 = r1.c();
        String r5 = "";
        if (r2 < 0) goto L6;
        if (r3 <= r4) goto L8;
    L18:
        String r8 = r0.toString();
        o.b(r8, "StringBuilder().apply(builderAction).toString()");
        throw new IllegalStateException("Required field" + r5 + " not set:" + r8);
    L8:
        if (r7[r3] == null) goto L10;
    L16:
        if (r3 == r4) goto L18;
        r3 = r3 + r2;
        goto L8
    L10:
        if (r0.length() <= 0) goto L12;
        boolean r6 = true;
    L13:
        if (r6 == false) goto L15;
        r5 = "s";
    L15:
        r0.append("\n  ");
        r0.append(r7[r3 + 1]);
        goto L16
    L12:
        r6 = false;
        goto L13
    L6:
        if (r3 < r4) goto L18;
        goto L18
    }

    public static final <T> List<T> newMutableList() {
        return new MutableOnWriteList(r.g());
    }

    public static final <K, V> Map<K, V> newMutableMap() {
        return new LinkedHashMap();
    }
}
