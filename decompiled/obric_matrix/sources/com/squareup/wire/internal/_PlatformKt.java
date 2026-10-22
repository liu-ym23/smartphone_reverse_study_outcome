package com.squareup.wire.internal;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.n0.d.i0;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0000\n\u0002\u0010!\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a&\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086\b¢\u0006\u0004\b\u0003\u0010\u0004\u001a8\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\"\u0004\b\u0000\u0010\u0005\"\u0004\b\u0001\u0010\u0006*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007H\u0086\b¢\u0006\u0004\b\t\u0010\n\u001a,\u0010\u000f\u001a\u00020\u000b*\u00020\u000b2\u0016\u0010\u000e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\f\"\u0004\u0018\u00010\rH\u0080\b¢\u0006\u0004\b\u000f\u0010\u0010*\n\u0010\u0012\"\u00020\u00112\u00020\u0011*\n\u0010\u0014\"\u00020\u00132\u00020\u0013*\n\u0010\u0016\"\u00020\u00152\u00020\u0015*\n\u0010\u0017\"\u00020\r2\u00020\r¨\u0006\u0018"}, d2 = {"T", "", "", "toUnmodifiableList", "(Ljava/util/List;)Ljava/util/List;", "K", "V", "", "", "toUnmodifiableMap", "(Ljava/util/Map;)Ljava/util/Map;", "", "", "", "args", "format", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "Ljava/io/ObjectStreamException;", "ObjectStreamException", "Ljava/net/ProtocolException;", "ProtocolException", "Ljava/io/Serializable;", "Serializable", "Throws", "wire-runtime"}, k = 2, mv = {1, 1, 15})
public final class _PlatformKt {
    public static final String format(String r1, Object... r2) {
        o.g(r1, "$this$format");
        o.g(r2, "args");
        i0 r0 = i0.f18445a;
        Object[] r3 = Arrays.copyOf(r2, r2.length);
        String r4 = String.format(r1, Arrays.copyOf(r3, r3.length));
        o.b(r4, "java.lang.String.format(format, *args)");
        return r4;
    }

    public static final <T> List<T> toUnmodifiableList(List<T> r1) {
        o.g(r1, "$this$toUnmodifiableList");
        List<T> r2 = Collections.unmodifiableList(r1);
        o.b(r2, "Collections.unmodifiableList(this)");
        return r2;
    }

    public static final <K, V> Map<K, V> toUnmodifiableMap(Map<K, V> r1) {
        o.g(r1, "$this$toUnmodifiableMap");
        Map<K, V> r2 = Collections.unmodifiableMap(r1);
        o.b(r2, "Collections.unmodifiableMap(this)");
        return r2;
    }
}
