package com.google.common.base;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class Suppliers {

    static class ExpiringMemoizingSupplier<T> implements Supplier<T>, Serializable {
        private static final long serialVersionUID = 0;
        final Supplier<T> delegate;
        final long durationNanos;
        volatile transient long expirationNanos;

        @CheckForNull
        volatile transient T value;

        ExpiringMemoizingSupplier(Supplier<T> r3, long r4, TimeUnit r6) {
            this.delegate = (Supplier) Preconditions.checkNotNull(r3);
            this.durationNanos = r6.toNanos(r4);
            if (r4 <= 0) goto L5;
            boolean r2 = true;
        L6:
            Preconditions.checkArgument(r2, "duration (%s %s) must be > 0", r4, r6);
            return;
        L5:
            r2 = false;
            goto L6
        }

        @Override // com.google.common.base.Supplier, java.util.function.Supplier
        @ParametricNullness
        public T get() {
            long r0 = this.expirationNanos;
            long r2 = Platform.systemNanoTime();
            if (r0 != 0) goto L5;
        L6:
            monitor-enter(this);
        L18:
            th = move-exception;
            throw th;
        L8:
            if (r0 != this.expirationNanos) goto L15;
            T r1 = this.delegate.get();     // Catch: Throwable -> L18
            this.value = r1;     // Catch: Throwable -> L18
            long r3 = r2 + this.durationNanos;     // Catch: Throwable -> L18
            if (r3 != 0) goto L12;
            r3 = 1;
        L12:
            this.expirationNanos = r3;     // Catch: Throwable -> L18
            monitor-exit(this);     // Catch: Throwable -> L18
            return r1;
        L15:
            monitor-exit(this);     // Catch: Throwable -> L18
        L17:
            return (T) NullnessCasts.uncheckedCastNullableTToT(this.value);
        L5:
            if ((r2 - r0) < 0) goto L17;
            goto L6
        }

        public String toString() {
            String r0 = String.valueOf(this.delegate);
            long r1 = this.durationNanos;
            return new StringBuilder(String.valueOf(r0).length() + 62).append("Suppliers.memoizeWithExpiration(").append(r0).append(", ").append(r1).append(", NANOS)").toString();
        }
    }

    static class MemoizingSupplier<T> implements Supplier<T>, Serializable {
        private static final long serialVersionUID = 0;
        final Supplier<T> delegate;
        volatile transient boolean initialized;

        @CheckForNull
        transient T value;

        MemoizingSupplier(Supplier<T> r1) {
            this.delegate = (Supplier) Preconditions.checkNotNull(r1);
        }

        @Override // com.google.common.base.Supplier, java.util.function.Supplier
        @ParametricNullness
        public T get() {
            if (this.initialized == true) goto L16;
            monitor-enter(this);
        L12:
            th = move-exception;
            throw th;
        L6:
            if (this.initialized == true) goto L10;
            T r0 = this.delegate.get();     // Catch: Throwable -> L12
            this.value = r0;     // Catch: Throwable -> L12
            this.initialized = true;     // Catch: Throwable -> L12
            monitor-exit(this);     // Catch: Throwable -> L12
            return r0;
        L10:
            monitor-exit(this);     // Catch: Throwable -> L12
        L16:
            return (T) NullnessCasts.uncheckedCastNullableTToT(this.value);
        }

        public String toString() {
            if (this.initialized == false) goto L5;
            String r2 = String.valueOf(this.value);
            Object r3 = new StringBuilder(String.valueOf(r2).length() + 25).append("<supplier that returned ").append(r2).append(">").toString();
        L6:
            String r4 = String.valueOf(r3);
            return new StringBuilder(String.valueOf(r4).length() + 19).append("Suppliers.memoize(").append(r4).append(")").toString();
        L5:
            r3 = this.delegate;
            goto L6
        }
    }

    static class NonSerializableMemoizingSupplier<T> implements Supplier<T> {

        @CheckForNull
        volatile Supplier<T> delegate;
        volatile boolean initialized;

        @CheckForNull
        T value;

        NonSerializableMemoizingSupplier(Supplier<T> r1) {
            this.delegate = (Supplier) Preconditions.checkNotNull(r1);
        }

        @Override // com.google.common.base.Supplier, java.util.function.Supplier
        @ParametricNullness
        public T get() {
            if (this.initialized == true) goto L16;
            monitor-enter(this);
        L12:
            th = move-exception;
            throw th;
        L6:
            if (this.initialized == true) goto L10;
            T r0 = (T) ((Supplier) java.util.Objects.requireNonNull(this.delegate)).get();
            this.value = r0;     // Catch: Throwable -> L12
            this.initialized = true;     // Catch: Throwable -> L12
            this.delegate = null;     // Catch: Throwable -> L12
            monitor-exit(this);     // Catch: Throwable -> L12
            return r0;
        L10:
            monitor-exit(this);     // Catch: Throwable -> L12
        L16:
            return (T) NullnessCasts.uncheckedCastNullableTToT(this.value);
        }

        public String toString() {
            Object r0 = this.delegate;
            if (r0 != null) goto L5;
            String r2 = String.valueOf(this.value);
            r0 = new StringBuilder(String.valueOf(r2).length() + 25).append("<supplier that returned ").append(r2).append(">").toString();
        L5:
            String r3 = String.valueOf(r0);
            return new StringBuilder(String.valueOf(r3).length() + 19).append("Suppliers.memoize(").append(r3).append(")").toString();
        }
    }

    private static class SupplierComposition<F, T> implements Supplier<T>, Serializable {
        private static final long serialVersionUID = 0;
        final Function<? super F, T> function;
        final Supplier<F> supplier;

        SupplierComposition(Function<? super F, T> r1, Supplier<F> r2) {
            this.function = (Function) Preconditions.checkNotNull(r1);
            this.supplier = (Supplier) Preconditions.checkNotNull(r2);
        }

        @Override // com.google.common.base.Supplier, java.util.function.Supplier
        @ParametricNullness
        public T get() {
            return this.function.apply(this.supplier.get());
        }

        public boolean equals(@CheckForNull Object r4) {
            if ((r4 instanceof SupplierComposition) == false) goto L10;
            SupplierComposition r5 = (SupplierComposition) r4;
            if (this.function.equals(r5.function) == true) goto L7;
            return false;
        L7:
            if (this.supplier.equals(r5.supplier) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        public int hashCode() {
            return Objects.hashCode(new Object[]{this.function, this.supplier});
        }

        public String toString() {
            String r0 = String.valueOf(this.function);
            String r3 = String.valueOf(this.supplier);
            return new StringBuilder((String.valueOf(r0).length() + 21) + String.valueOf(r3).length()).append("Suppliers.compose(").append(r0).append(", ").append(r3).append(")").toString();
        }
    }

    private interface SupplierFunction<T> extends Function<Supplier<T>, T> {
    }

    private static final enum SupplierFunctionImpl extends Enum<SupplierFunctionImpl> implements SupplierFunction<Object> {
        private static final /* synthetic */ SupplierFunctionImpl[] $VALUES = null;
        public static final SupplierFunctionImpl INSTANCE = null;

        @Override // java.lang.Enum
        public String toString() {
            return "Suppliers.supplierFunction()";
        }

        private static /* synthetic */ SupplierFunctionImpl[] $values() {
            return new SupplierFunctionImpl[]{INSTANCE};
        }

        private SupplierFunctionImpl(String r1, int r2) {
            super(r1, r2);
        }

        public static SupplierFunctionImpl valueOf(String r1) {
            return (SupplierFunctionImpl) Enum.valueOf(SupplierFunctionImpl.class, r1);
        }

        public static SupplierFunctionImpl[] values() {
            return (SupplierFunctionImpl[]) $VALUES.clone();
        }

        @Override // com.google.common.base.Function, java.util.function.Function
        @CheckForNull
        public /* bridge */ /* synthetic */ Object apply(Object r1) {
            return apply((Supplier) r1);
        }

        static {
            INSTANCE = new SupplierFunctionImpl("INSTANCE", 0);
            $VALUES = $values();
        }

        @CheckForNull
        public Object apply(Supplier<Object> r1) {
            return r1.get();
        }
    }

    private static class SupplierOfInstance<T> implements Supplier<T>, Serializable {
        private static final long serialVersionUID = 0;

        @ParametricNullness
        final T instance;

        SupplierOfInstance(@ParametricNullness T r1) {
            this.instance = r1;
        }

        @Override // com.google.common.base.Supplier, java.util.function.Supplier
        @ParametricNullness
        public T get() {
            return this.instance;
        }

        public boolean equals(@CheckForNull Object r2) {
            if ((r2 instanceof SupplierOfInstance) == true) goto L5;
            return false;
        L5:
            return Objects.equal(this.instance, ((SupplierOfInstance) r2).instance);
        }

        public int hashCode() {
            return Objects.hashCode(new Object[]{this.instance});
        }

        public String toString() {
            String r2 = String.valueOf(this.instance);
            return new StringBuilder(String.valueOf(r2).length() + 22).append("Suppliers.ofInstance(").append(r2).append(")").toString();
        }
    }

    private static class ThreadSafeSupplier<T> implements Supplier<T>, Serializable {
        private static final long serialVersionUID = 0;
        final Supplier<T> delegate;

        ThreadSafeSupplier(Supplier<T> r1) {
            this.delegate = (Supplier) Preconditions.checkNotNull(r1);
        }

        @Override // com.google.common.base.Supplier, java.util.function.Supplier
        @ParametricNullness
        public T get() {
            Supplier<T> r0 = this.delegate;
            monitor-enter(r0);
            T r1 = this.delegate.get();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public String toString() {
            String r2 = String.valueOf(this.delegate);
            return new StringBuilder(String.valueOf(r2).length() + 32).append("Suppliers.synchronizedSupplier(").append(r2).append(")").toString();
        }
    }

    private Suppliers() {
    }

    public static <F, T> Supplier<T> compose(Function<? super F, T> r1, Supplier<F> r2) {
        return new SupplierComposition(r1, r2);
    }

    public static <T> Supplier<T> memoize(Supplier<T> r1) {
        if ((r1 instanceof NonSerializableMemoizingSupplier) == false) goto L5;
    L12:
        return r1;
    L5:
        if ((r1 instanceof MemoizingSupplier) == true) goto L12;
        if ((r1 instanceof Serializable) == false) goto L11;
        return new MemoizingSupplier(r1);
    L11:
        return new NonSerializableMemoizingSupplier(r1);
    }

    public static <T> Supplier<T> memoizeWithExpiration(Supplier<T> r1, long r2, TimeUnit r4) {
        return new ExpiringMemoizingSupplier(r1, r2, r4);
    }

    public static <T> Supplier<T> ofInstance(@ParametricNullness T r1) {
        return new SupplierOfInstance(r1);
    }

    public static <T> Supplier<T> synchronizedSupplier(Supplier<T> r1) {
        return new ThreadSafeSupplier(r1);
    }

    public static <T> Function<Supplier<T>, T> supplierFunction() {
        return SupplierFunctionImpl.INSTANCE;
    }
}
