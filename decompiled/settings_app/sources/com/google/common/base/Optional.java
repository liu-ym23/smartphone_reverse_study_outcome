package com.google.common.base;

import com.google.errorprone.annotations.DoNotMock;
import java.io.Serializable;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@DoNotMock("Use Optional.of(value) or Optional.absent()")
@ElementTypesAreNonnullByDefault
public abstract class Optional<T> implements Serializable {
    private static final long serialVersionUID = 0;

    public abstract Set<T> asSet();

    public abstract boolean equals(@CheckForNull Object r1);

    public abstract T get();

    public abstract int hashCode();

    public abstract boolean isPresent();

    public abstract Optional<T> or(Optional<? extends T> r1);

    public abstract T or(Supplier<? extends T> r1);

    public abstract T or(T r1);

    @CheckForNull
    public abstract T orNull();

    public abstract String toString();

    public abstract <V> Optional<V> transform(Function<? super T, V> r1);

    public static <T> Optional<T> absent() {
        return Absent.withType();
    }

    public static <T> Optional<T> of(T r1) {
        return new Present(Preconditions.checkNotNull(r1));
    }

    public static <T> Optional<T> fromNullable(@CheckForNull T r1) {
        if (r1 != null) goto L5;
        return absent();
    L5:
        return new Present(r1);
    }

    @CheckForNull
    public static <T> Optional<T> fromJavaUtil(@CheckForNull java.util.Optional<T> r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return fromNullable(r1.orElse(null));
    }

    @CheckForNull
    public static <T> java.util.Optional<T> toJavaUtil(@CheckForNull Optional<T> r0) {
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.toJavaUtil();
    }

    public java.util.Optional<T> toJavaUtil() {
        return java.util.Optional.ofNullable(orNull());
    }

    Optional() {
    }

    public static <T> Iterable<T> presentInstances(final Iterable<? extends Optional<? extends T>> r1) {
        Preconditions.checkNotNull(r1);
        return new AnonymousClass1(r1);
    }
}
