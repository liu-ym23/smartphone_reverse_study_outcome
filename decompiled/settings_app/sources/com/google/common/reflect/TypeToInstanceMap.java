package com.google.common.reflect;

import com.google.errorprone.annotations.DoNotMock;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
@DoNotMock("Use ImmutableTypeToInstanceMap or MutableTypeToInstanceMap")
public interface TypeToInstanceMap<B> extends Map<TypeToken<? extends B>, B> {
    <T extends B> T getInstance(TypeToken<T> r1);

    <T extends B> T getInstance(Class<T> r1);

    <T extends B> T putInstance(TypeToken<T> r1, T r2);

    <T extends B> T putInstance(Class<T> r1, T r2);
}
