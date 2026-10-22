package com.google.common.graph;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.errorprone.annotations.Immutable;
import java.util.Comparator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@Immutable
@ElementTypesAreNonnullByDefault
public final class ElementOrder<T> {

    @CheckForNull
    private final Comparator<T> comparator;
    private final Type type;

    /* JADX INFO: renamed from: com.google.common.graph.ElementOrder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$common$graph$ElementOrder$Type = null;

        static {
            int[] r0 = new int[Type.values().length];
            $SwitchMap$com$google$common$graph$ElementOrder$Type = r0;
            r0[Type.UNORDERED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$google$common$graph$ElementOrder$Type[Type.INSERTION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$google$common$graph$ElementOrder$Type[Type.STABLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$google$common$graph$ElementOrder$Type[Type.SORTED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type INSERTION = null;
        public static final Type SORTED = null;
        public static final Type STABLE = null;
        public static final Type UNORDERED = null;

        private static /* synthetic */ Type[] $values() {
            return new Type[]{UNORDERED, STABLE, INSERTION, SORTED};
        }

        private Type(String r1, int r2) {
            super(r1, r2);
        }

        public static Type valueOf(String r1) {
            return (Type) Enum.valueOf(Type.class, r1);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        static {
            UNORDERED = new Type("UNORDERED", 0);
            STABLE = new Type("STABLE", 1);
            INSERTION = new Type("INSERTION", 2);
            SORTED = new Type("SORTED", 3);
            $VALUES = $values();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    <T1 extends T> ElementOrder<T1> cast() {
        return this;
    }

    private ElementOrder(Type r3, @CheckForNull Comparator<T> r4) {
        this.type = (Type) Preconditions.checkNotNull(r3);
        this.comparator = r4;
        boolean r0 = true;
        if (r3 != Type.SORTED) goto L5;
        boolean r2 = true;
    L6:
        if (r4 == null) goto L8;
        boolean r5 = true;
    L9:
        if (r2 == r5) goto L12;
        r0 = false;
    L12:
        Preconditions.checkState(r0);
        return;
    L8:
        r5 = false;
        goto L9
    L5:
        r2 = false;
        goto L6
    }

    public static <S> ElementOrder<S> unordered() {
        return new ElementOrder(Type.UNORDERED, null);
    }

    public static <S> ElementOrder<S> stable() {
        return new ElementOrder(Type.STABLE, null);
    }

    public static <S> ElementOrder<S> insertion() {
        return new ElementOrder(Type.INSERTION, null);
    }

    public static <S extends Comparable<? super S>> ElementOrder<S> natural() {
        return new ElementOrder(Type.SORTED, Ordering.natural());
    }

    public static <S> ElementOrder<S> sorted(Comparator<S> r2) {
        return new ElementOrder(Type.SORTED, (Comparator) Preconditions.checkNotNull(r2));
    }

    public Type type() {
        return this.type;
    }

    public Comparator<T> comparator() {
        Comparator<T> r1 = this.comparator;
        if (r1 == null) goto L6;
        return r1;
    L6:
        throw new UnsupportedOperationException("This ordering does not define a comparator.");
    }

    public boolean equals(@CheckForNull Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof ElementOrder) == true) goto L8;
        return false;
    L8:
        ElementOrder r6 = (ElementOrder) r5;
        if (this.type != r6.type) goto L14;
        if (Objects.equal(this.comparator, r6.comparator) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.type, this.comparator});
    }

    public String toString() {
        MoreObjects.ToStringHelper r0 = MoreObjects.toStringHelper(this).add("type", this.type);
        Comparator<T> r3 = this.comparator;
        if (r3 == null) goto L6;
        r0.add("comparator", r3);
    L6:
        return r0.toString();
    }

    <K extends T, V> Map<K, V> createMap(int r3) {
        int r0 = AnonymousClass1.$SwitchMap$com$google$common$graph$ElementOrder$Type[this.type.ordinal()];
        if (r0 == 1) goto L17;
        if (r0 == 2) goto L15;
        if (r0 == 3) goto L15;
        if (r0 != 4) goto L13;
        return Maps.newTreeMap(comparator());
    L13:
        throw new AssertionError();
    L15:
        return Maps.newLinkedHashMapWithExpectedSize(r3);
    L17:
        return Maps.newHashMapWithExpectedSize(r3);
    }
}
