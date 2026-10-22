package com.google.common.collect;

import com.google.common.base.Objects;
import java.util.Map;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
abstract class AbstractMapEntry<K, V> implements Map.Entry<K, V> {
    @Override // java.util.Map.Entry
    @ParametricNullness
    public abstract K getKey();

    @Override // java.util.Map.Entry
    @ParametricNullness
    public abstract V getValue();

    AbstractMapEntry() {
    }

    @Override // java.util.Map.Entry
    @ParametricNullness
    public V setValue(@ParametricNullness V r1) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map.Entry
    public boolean equals(@CheckForNull Object r4) {
        if ((r4 instanceof Map.Entry) == false) goto L10;
        Map.Entry r5 = (Map.Entry) r4;
        if (Objects.equal(getKey(), r5.getKey()) == true) goto L7;
        return false;
    L7:
        if (Objects.equal(getValue(), r5.getValue()) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        K r0 = getKey();
        V r2 = getValue();
        int r1 = 0;
        if (r0 != null) goto L5;
        int r3 = 0;
    L6:
        if (r2 == null) goto L10;
        r1 = r2.hashCode();
    L10:
        return r3 ^ r1;
    L5:
        r3 = r0.hashCode();
        goto L6
    }

    public String toString() {
        String r0 = String.valueOf(getKey());
        String r3 = String.valueOf(getValue());
        return new StringBuilder((String.valueOf(r0).length() + 1) + String.valueOf(r3).length()).append(r0).append("=").append(r3).toString();
    }
}
