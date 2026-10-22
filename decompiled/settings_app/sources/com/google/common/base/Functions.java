package com.google.common.base;

import java.io.Serializable;
import java.util.Map;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class Functions {

    /* JADX INFO: renamed from: com.google.common.base.Functions$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class ConstantFunction<E> implements Function<Object, E>, Serializable {
        private static final long serialVersionUID = 0;

        @ParametricNullness
        private final E value;

        public ConstantFunction(@ParametricNullness E r1) {
            this.value = r1;
        }

        @Override // com.google.common.base.Function, java.util.function.Function
        @ParametricNullness
        public E apply(@CheckForNull Object r1) {
            return this.value;
        }

        @Override // com.google.common.base.Function
        public boolean equals(@CheckForNull Object r2) {
            if ((r2 instanceof ConstantFunction) == true) goto L5;
            return false;
        L5:
            return Objects.equal(this.value, ((ConstantFunction) r2).value);
        }

        public int hashCode() {
            E r0 = this.value;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public String toString() {
            String r2 = String.valueOf(this.value);
            return new StringBuilder(String.valueOf(r2).length() + 20).append("Functions.constant(").append(r2).append(")").toString();
        }
    }

    private static class ForMapWithDefault<K, V> implements Function<K, V>, Serializable {
        private static final long serialVersionUID = 0;

        @ParametricNullness
        final V defaultValue;
        final Map<K, ? extends V> map;

        ForMapWithDefault(Map<K, ? extends V> r1, @ParametricNullness V r2) {
            this.map = (Map) Preconditions.checkNotNull(r1);
            this.defaultValue = r2;
        }

        @Override // com.google.common.base.Function, java.util.function.Function
        @ParametricNullness
        public V apply(@ParametricNullness K r3) {
            V r0 = this.map.get(r3);
            if (r0 != null) goto L9;
            if (this.map.containsKey(r3) == true) goto L9;
            return this.defaultValue;
        L9:
            return (V) NullnessCasts.uncheckedCastNullableTToT(r0);
        }

        @Override // com.google.common.base.Function
        public boolean equals(@CheckForNull Object r4) {
            if ((r4 instanceof ForMapWithDefault) == false) goto L10;
            ForMapWithDefault r5 = (ForMapWithDefault) r4;
            if (this.map.equals(r5.map) == true) goto L7;
            return false;
        L7:
            if (Objects.equal(this.defaultValue, r5.defaultValue) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        public int hashCode() {
            return Objects.hashCode(new Object[]{this.map, this.defaultValue});
        }

        public String toString() {
            String r0 = String.valueOf(this.map);
            String r3 = String.valueOf(this.defaultValue);
            return new StringBuilder((String.valueOf(r0).length() + 33) + String.valueOf(r3).length()).append("Functions.forMap(").append(r0).append(", defaultValue=").append(r3).append(")").toString();
        }
    }

    private static class FunctionComposition<A, B, C> implements Function<A, C>, Serializable {
        private static final long serialVersionUID = 0;
        private final Function<A, ? extends B> f;
        private final Function<B, C> g;

        public FunctionComposition(Function<B, C> r1, Function<A, ? extends B> r2) {
            this.g = (Function) Preconditions.checkNotNull(r1);
            this.f = (Function) Preconditions.checkNotNull(r2);
        }

        @Override // com.google.common.base.Function, java.util.function.Function
        @ParametricNullness
        public C apply(@ParametricNullness A r2) {
            return (C) this.g.apply(this.f.apply(r2));
        }

        @Override // com.google.common.base.Function
        public boolean equals(@CheckForNull Object r4) {
            if ((r4 instanceof FunctionComposition) == false) goto L10;
            FunctionComposition r5 = (FunctionComposition) r4;
            if (this.f.equals(r5.f) == true) goto L7;
            return false;
        L7:
            if (this.g.equals(r5.g) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        public int hashCode() {
            int r0 = this.f.hashCode();
            return this.g.hashCode() ^ r0;
        }

        public String toString() {
            String r0 = String.valueOf(this.g);
            String r3 = String.valueOf(this.f);
            return new StringBuilder((String.valueOf(r0).length() + 2) + String.valueOf(r3).length()).append(r0).append("(").append(r3).append(")").toString();
        }
    }

    private static class FunctionForMapNoDefault<K, V> implements Function<K, V>, Serializable {
        private static final long serialVersionUID = 0;
        final Map<K, V> map;

        FunctionForMapNoDefault(Map<K, V> r1) {
            this.map = (Map) Preconditions.checkNotNull(r1);
        }

        @Override // com.google.common.base.Function, java.util.function.Function
        @ParametricNullness
        public V apply(@ParametricNullness K r3) {
            V r0 = this.map.get(r3);
            if (r0 == null) goto L5;
        L8:
            boolean r2 = true;
        L9:
            Preconditions.checkArgument(r2, "Key '%s' not present in map", r3);
            return (V) NullnessCasts.uncheckedCastNullableTToT(r0);
        L5:
            if (this.map.containsKey(r3) == true) goto L8;
            r2 = false;
            goto L9
        }

        @Override // com.google.common.base.Function
        public boolean equals(@CheckForNull Object r2) {
            if ((r2 instanceof FunctionForMapNoDefault) == true) goto L5;
            return false;
        L5:
            return this.map.equals(((FunctionForMapNoDefault) r2).map);
        }

        public int hashCode() {
            return this.map.hashCode();
        }

        public String toString() {
            String r2 = String.valueOf(this.map);
            return new StringBuilder(String.valueOf(r2).length() + 18).append("Functions.forMap(").append(r2).append(")").toString();
        }
    }

    private static final enum IdentityFunction extends Enum<IdentityFunction> implements Function<Object, Object> {
        private static final /* synthetic */ IdentityFunction[] $VALUES = null;
        public static final IdentityFunction INSTANCE = null;

        @Override // com.google.common.base.Function, java.util.function.Function
        @CheckForNull
        public Object apply(@CheckForNull Object r1) {
            return r1;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Functions.identity()";
        }

        private static /* synthetic */ IdentityFunction[] $values() {
            return new IdentityFunction[]{INSTANCE};
        }

        private IdentityFunction(String r1, int r2) {
            super(r1, r2);
        }

        public static IdentityFunction valueOf(String r1) {
            return (IdentityFunction) Enum.valueOf(IdentityFunction.class, r1);
        }

        public static IdentityFunction[] values() {
            return (IdentityFunction[]) $VALUES.clone();
        }

        static {
            INSTANCE = new IdentityFunction("INSTANCE", 0);
            $VALUES = $values();
        }
    }

    private static class PredicateFunction<T> implements Function<T, Boolean>, Serializable {
        private static final long serialVersionUID = 0;
        private final Predicate<T> predicate;

        /* synthetic */ PredicateFunction(Predicate r1, AnonymousClass1 r2) {
            this(r1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.base.Function, java.util.function.Function
        public /* bridge */ /* synthetic */ Object apply(@ParametricNullness Object r1) {
            return apply(r1);
        }

        private PredicateFunction(Predicate<T> r1) {
            this.predicate = (Predicate) Preconditions.checkNotNull(r1);
        }

        @Override // com.google.common.base.Function, java.util.function.Function
        public Boolean apply(@ParametricNullness T r1) {
            return Boolean.valueOf(this.predicate.apply(r1));
        }

        @Override // com.google.common.base.Function
        public boolean equals(@CheckForNull Object r2) {
            if ((r2 instanceof PredicateFunction) == true) goto L5;
            return false;
        L5:
            return this.predicate.equals(((PredicateFunction) r2).predicate);
        }

        public int hashCode() {
            return this.predicate.hashCode();
        }

        public String toString() {
            String r2 = String.valueOf(this.predicate);
            return new StringBuilder(String.valueOf(r2).length() + 24).append("Functions.forPredicate(").append(r2).append(")").toString();
        }
    }

    private static class SupplierFunction<F, T> implements Function<F, T>, Serializable {
        private static final long serialVersionUID = 0;
        private final Supplier<T> supplier;

        /* synthetic */ SupplierFunction(Supplier r1, AnonymousClass1 r2) {
            this(r1);
        }

        private SupplierFunction(Supplier<T> r1) {
            this.supplier = (Supplier) Preconditions.checkNotNull(r1);
        }

        @Override // com.google.common.base.Function, java.util.function.Function
        @ParametricNullness
        public T apply(@ParametricNullness F r1) {
            return this.supplier.get();
        }

        @Override // com.google.common.base.Function
        public boolean equals(@CheckForNull Object r2) {
            if ((r2 instanceof SupplierFunction) == true) goto L5;
            return false;
        L5:
            return this.supplier.equals(((SupplierFunction) r2).supplier);
        }

        public int hashCode() {
            return this.supplier.hashCode();
        }

        public String toString() {
            String r2 = String.valueOf(this.supplier);
            return new StringBuilder(String.valueOf(r2).length() + 23).append("Functions.forSupplier(").append(r2).append(")").toString();
        }
    }

    private static final enum ToStringFunction extends Enum<ToStringFunction> implements Function<Object, String> {
        private static final /* synthetic */ ToStringFunction[] $VALUES = null;
        public static final ToStringFunction INSTANCE = null;

        @Override // java.lang.Enum
        public String toString() {
            return "Functions.toStringFunction()";
        }

        private static /* synthetic */ ToStringFunction[] $values() {
            return new ToStringFunction[]{INSTANCE};
        }

        private ToStringFunction(String r1, int r2) {
            super(r1, r2);
        }

        public static ToStringFunction valueOf(String r1) {
            return (ToStringFunction) Enum.valueOf(ToStringFunction.class, r1);
        }

        public static ToStringFunction[] values() {
            return (ToStringFunction[]) $VALUES.clone();
        }

        @Override // com.google.common.base.Function, java.util.function.Function
        public /* bridge */ /* synthetic */ Object apply(Object r1) {
            return apply(r1);
        }

        static {
            INSTANCE = new ToStringFunction("INSTANCE", 0);
            $VALUES = $values();
        }

        @Override // com.google.common.base.Function, java.util.function.Function
        public String apply(Object r1) {
            Preconditions.checkNotNull(r1);
            return r1.toString();
        }
    }

    private Functions() {
    }

    public static Function<Object, String> toStringFunction() {
        return ToStringFunction.INSTANCE;
    }

    public static <E> Function<E, E> identity() {
        return IdentityFunction.INSTANCE;
    }

    public static <K, V> Function<K, V> forMap(Map<K, V> r1) {
        return new FunctionForMapNoDefault(r1);
    }

    public static <K, V> Function<K, V> forMap(Map<K, ? extends V> r1, @ParametricNullness V r2) {
        return new ForMapWithDefault(r1, r2);
    }

    public static <A, B, C> Function<A, C> compose(Function<B, C> r1, Function<A, ? extends B> r2) {
        return new FunctionComposition(r1, r2);
    }

    public static <T> Function<T, Boolean> forPredicate(Predicate<T> r2) {
        return new PredicateFunction(r2, null);
    }

    public static <E> Function<Object, E> constant(@ParametricNullness E r1) {
        return new ConstantFunction(r1);
    }

    public static <F, T> Function<F, T> forSupplier(Supplier<T> r2) {
        return new SupplierFunction(r2, null);
    }
}
