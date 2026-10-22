package com.google.gson;

import com.google.gson.internal.LinkedTreeMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class JsonObject extends JsonElement {
    private final LinkedTreeMap<String, JsonElement> members;

    public JsonObject() {
        this.members = new LinkedTreeMap();
    }

    public void add(String r1, JsonElement r2) {
        LinkedTreeMap<String, JsonElement> r0 = this.members;
        if (r2 != null) goto L5;
        r2 = JsonNull.INSTANCE;
    L5:
        r0.put(r1, r2);
    }

    public void addProperty(String r2, String r3) {
        if (r3 != null) goto L4;
        JsonElement r4 = JsonNull.INSTANCE;
    L5:
        add(r2, r4);
        return;
    L4:
        r4 = new JsonPrimitive(r3);
        goto L5
    }

    @Override // com.google.gson.JsonElement
    public /* bridge */ /* synthetic */ JsonElement deepCopy() {
        return deepCopy();
    }

    public Set<Map.Entry<String, JsonElement>> entrySet() {
        return this.members.entrySet();
    }

    public boolean equals(Object r2) {
        if (r2 != this) goto L4;
    L9:
        return true;
    L4:
        if ((r2 instanceof JsonObject) == true) goto L6;
    L8:
        return false;
    L6:
        if (((JsonObject) r2).members.equals(this.members) == false) goto L8;
        goto L8
    }

    public JsonElement get(String r1) {
        return this.members.get(r1);
    }

    public JsonArray getAsJsonArray(String r1) {
        return (JsonArray) this.members.get(r1);
    }

    public JsonObject getAsJsonObject(String r1) {
        return (JsonObject) this.members.get(r1);
    }

    public JsonPrimitive getAsJsonPrimitive(String r1) {
        return (JsonPrimitive) this.members.get(r1);
    }

    public boolean has(String r1) {
        return this.members.containsKey(r1);
    }

    public int hashCode() {
        return this.members.hashCode();
    }

    public Set<String> keySet() {
        return this.members.keySet();
    }

    public JsonElement remove(String r1) {
        return this.members.remove(r1);
    }

    public int size() {
        return this.members.size();
    }

    public void addProperty(String r2, Number r3) {
        if (r3 != null) goto L4;
        JsonElement r4 = JsonNull.INSTANCE;
    L5:
        add(r2, r4);
        return;
    L4:
        r4 = new JsonPrimitive(r3);
        goto L5
    }

    @Override // com.google.gson.JsonElement
    public JsonObject deepCopy() {
        JsonObject r0 = new JsonObject();
        Iterator<Map.Entry<String, JsonElement>> r3 = this.members.entrySet().iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        Map.Entry<String, JsonElement> r1 = r3.next();
        r0.add(r1.getKey(), r1.getValue().deepCopy());
        goto L4
    L6:
        return r0;
    }

    public void addProperty(String r2, Boolean r3) {
        if (r3 != null) goto L4;
        JsonElement r4 = JsonNull.INSTANCE;
    L5:
        add(r2, r4);
        return;
    L4:
        r4 = new JsonPrimitive(r3);
        goto L5
    }

    public void addProperty(String r2, Character r3) {
        if (r3 != null) goto L4;
        JsonElement r4 = JsonNull.INSTANCE;
    L5:
        add(r2, r4);
        return;
    L4:
        r4 = new JsonPrimitive(r3);
        goto L5
    }
}
