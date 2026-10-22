package com.google.gson;

/* JADX INFO: loaded from: classes4.dex */
public final class JsonNull extends JsonElement {
    public static final JsonNull INSTANCE = null;

    @Override // com.google.gson.JsonElement
    public /* bridge */ /* synthetic */ JsonElement deepCopy() {
        return deepCopy();
    }

    static {
        INSTANCE = new JsonNull();
    }

    @Deprecated
    public JsonNull() {
    }

    @Override // com.google.gson.JsonElement
    public JsonNull deepCopy() {
        return INSTANCE;
    }

    public int hashCode() {
        return JsonNull.class.hashCode();
    }

    public boolean equals(Object r1) {
        return r1 instanceof JsonNull;
    }
}
