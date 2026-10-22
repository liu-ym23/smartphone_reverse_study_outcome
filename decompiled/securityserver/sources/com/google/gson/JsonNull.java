package com.google.gson;

/* JADX INFO: loaded from: classes.dex */
public final class JsonNull extends JsonElement {
    public static final JsonNull INSTANCE = null;

    static {
        INSTANCE = new JsonNull();
    }

    @Deprecated
    public JsonNull() {
    }

    @Override // com.google.gson.JsonElement
    public /* bridge */ /* synthetic */ JsonElement deepCopy() {
        return deepCopy();
    }

    public boolean equals(Object r1) {
        if (this != r1) goto L4;
    L7:
        return true;
    L4:
        if ((r1 instanceof JsonNull) == true) goto L7;
        return false;
    }

    public int hashCode() {
        return JsonNull.class.hashCode();
    }

    @Override // com.google.gson.JsonElement
    public JsonNull deepCopy() {
        return INSTANCE;
    }
}
