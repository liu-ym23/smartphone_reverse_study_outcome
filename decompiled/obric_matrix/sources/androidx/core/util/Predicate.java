package androidx.core.util;

import android.annotation.SuppressLint;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"UnknownNullness"})
public interface Predicate<T> {
    static /* synthetic */ boolean a(Object r0) {
        return Objects.isNull(r0);
    }

    static /* synthetic */ boolean b(Object r0, Object r1) {
        return r0.equals(r1);
    }

    static /* synthetic */ boolean c(Predicate r0, Predicate r1, Object r2) {
        if (r0.test(r2) == true) goto L5;
    L7:
        return false;
    L5:
        if (r1.test(r2) == false) goto L7;
        return true;
    }

    static /* synthetic */ boolean d(Predicate r0, Predicate r1, Object r2) {
        if (r0.test(r2) == false) goto L5;
    L8:
        return true;
    L5:
        if (r1.test(r2) == true) goto L8;
        return false;
    }

    static /* synthetic */ boolean e(Predicate r0, Object r1) {
        return !r0.test(r1);
    }

    @SuppressLint({"MissingNullability"})
    static <T> Predicate<T> isEqual(@SuppressLint({"MissingNullability"}) final Object r1) {
        if (r1 != null) goto L5;
        return d.f338a;
    L5:
        return new a(r1);
    }

    @SuppressLint({"MissingNullability"})
    static <T> Predicate<T> not(@SuppressLint({"MissingNullability"}) Predicate<? super T> r0) {
        Objects.requireNonNull(r0);
        return r0.negate();
    }

    @SuppressLint({"MissingNullability"})
    default Predicate<T> and(@SuppressLint({"MissingNullability"}) final Predicate<? super T> r2) {
        Objects.requireNonNull(r2);
        return new c(this, r2);
    }

    @SuppressLint({"MissingNullability"})
    default Predicate<T> negate() {
        return new b(this);
    }

    @SuppressLint({"MissingNullability"})
    default Predicate<T> or(@SuppressLint({"MissingNullability"}) final Predicate<? super T> r2) {
        Objects.requireNonNull(r2);
        return new e(this, r2);
    }

    boolean test(T r1);
}
