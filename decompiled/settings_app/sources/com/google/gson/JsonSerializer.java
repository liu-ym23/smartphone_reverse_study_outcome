package com.google.gson;

import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes4.dex */
public interface JsonSerializer<T> {
    JsonElement serialize(T r1, Type r2, JsonSerializationContext r3);
}
