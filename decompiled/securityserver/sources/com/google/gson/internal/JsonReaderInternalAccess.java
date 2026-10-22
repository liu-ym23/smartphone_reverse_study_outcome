package com.google.gson.internal;

import com.google.gson.stream.JsonReader;

/* JADX INFO: loaded from: classes.dex */
public abstract class JsonReaderInternalAccess {
    public static JsonReaderInternalAccess INSTANCE;

    public JsonReaderInternalAccess() {
    }

    public abstract void promoteNameToValue(JsonReader r1);
}
