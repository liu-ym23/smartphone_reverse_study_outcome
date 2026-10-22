package io.reactivex.schedulers;

import io.reactivex.annotations.NonNull;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class Timed<T> {
    final long time;
    final TimeUnit unit;
    final T value;

    public Timed(@NonNull T r1, long r2, @NonNull TimeUnit r4) {
        this.value = r1;
        this.time = r2;
        this.unit = (TimeUnit) ObjectHelper.requireNonNull(r4, "unit is null");
    }

    public boolean equals(Object r7) {
        if ((r7 instanceof Timed) == false) goto L12;
        Timed r8 = (Timed) r7;
        if (ObjectHelper.equals(this.value, r8.value) == true) goto L7;
        return false;
    L7:
        if (this.time == r8.time) goto L9;
        return false;
    L9:
        if (ObjectHelper.equals(this.unit, r8.unit) == false) goto L15;
        return true;
    L15:
        return false;
    L12:
        return false;
    }

    public int hashCode() {
        T r0 = this.value;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L6:
        long r2 = this.time;
        int r6 = this.unit.hashCode();
        return r6 + (((r1 * 31) + ((int) (r2 ^ (r2 >>> 31)))) * 31);
    L5:
        r1 = 0;
        goto L6
    }

    public long time() {
        return this.time;
    }

    public String toString() {
        return "Timed[time=" + this.time + ", unit=" + this.unit + ", value=" + this.value + "]";
    }

    @NonNull
    public TimeUnit unit() {
        return this.unit;
    }

    @NonNull
    public T value() {
        return this.value;
    }

    public long time(@NonNull TimeUnit r3) {
        return r3.convert(this.time, this.unit);
    }
}
