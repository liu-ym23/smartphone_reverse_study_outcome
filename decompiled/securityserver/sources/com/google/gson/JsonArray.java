package com.google.gson;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class JsonArray extends JsonElement implements Iterable<JsonElement> {
    private final List<JsonElement> elements;

    public JsonArray() {
        this.elements = new ArrayList();
    }

    public void add(Boolean r2) {
        List<JsonElement> r1 = this.elements;
        if (r2 != null) goto L5;
        JsonElement r3 = JsonNull.INSTANCE;
    L6:
        r1.add(r3);
        return;
    L5:
        r3 = new JsonPrimitive(r2);
        goto L6
    }

    public void addAll(JsonArray r1) {
        this.elements.addAll(r1.elements);
    }

    public boolean contains(JsonElement r1) {
        return this.elements.contains(r1);
    }

    @Override // com.google.gson.JsonElement
    public /* bridge */ /* synthetic */ JsonElement deepCopy() {
        return deepCopy();
    }

    public boolean equals(Object r2) {
        if (r2 != this) goto L4;
    L9:
        return true;
    L4:
        if ((r2 instanceof JsonArray) == true) goto L6;
    L8:
        return false;
    L6:
        if (((JsonArray) r2).elements.equals(this.elements) == false) goto L8;
        goto L8
    }

    public JsonElement get(int r1) {
        return this.elements.get(r1);
    }

    @Override // com.google.gson.JsonElement
    public BigDecimal getAsBigDecimal() {
        if (this.elements.size() != 1) goto L7;
        return this.elements.get(0).getAsBigDecimal();
    L7:
        throw new IllegalStateException();
    }

    @Override // com.google.gson.JsonElement
    public BigInteger getAsBigInteger() {
        if (this.elements.size() != 1) goto L7;
        return this.elements.get(0).getAsBigInteger();
    L7:
        throw new IllegalStateException();
    }

    @Override // com.google.gson.JsonElement
    public boolean getAsBoolean() {
        if (this.elements.size() != 1) goto L7;
        return this.elements.get(0).getAsBoolean();
    L7:
        throw new IllegalStateException();
    }

    @Override // com.google.gson.JsonElement
    public byte getAsByte() {
        if (this.elements.size() != 1) goto L7;
        return this.elements.get(0).getAsByte();
    L7:
        throw new IllegalStateException();
    }

    @Override // com.google.gson.JsonElement
    public char getAsCharacter() {
        if (this.elements.size() != 1) goto L7;
        return this.elements.get(0).getAsCharacter();
    L7:
        throw new IllegalStateException();
    }

    @Override // com.google.gson.JsonElement
    public double getAsDouble() {
        if (this.elements.size() != 1) goto L7;
        return this.elements.get(0).getAsDouble();
    L7:
        throw new IllegalStateException();
    }

    @Override // com.google.gson.JsonElement
    public float getAsFloat() {
        if (this.elements.size() != 1) goto L7;
        return this.elements.get(0).getAsFloat();
    L7:
        throw new IllegalStateException();
    }

    @Override // com.google.gson.JsonElement
    public int getAsInt() {
        if (this.elements.size() != 1) goto L7;
        return this.elements.get(0).getAsInt();
    L7:
        throw new IllegalStateException();
    }

    @Override // com.google.gson.JsonElement
    public long getAsLong() {
        if (this.elements.size() != 1) goto L7;
        return this.elements.get(0).getAsLong();
    L7:
        throw new IllegalStateException();
    }

    @Override // com.google.gson.JsonElement
    public Number getAsNumber() {
        if (this.elements.size() != 1) goto L7;
        return this.elements.get(0).getAsNumber();
    L7:
        throw new IllegalStateException();
    }

    @Override // com.google.gson.JsonElement
    public short getAsShort() {
        if (this.elements.size() != 1) goto L7;
        return this.elements.get(0).getAsShort();
    L7:
        throw new IllegalStateException();
    }

    @Override // com.google.gson.JsonElement
    public String getAsString() {
        if (this.elements.size() != 1) goto L7;
        return this.elements.get(0).getAsString();
    L7:
        throw new IllegalStateException();
    }

    public int hashCode() {
        return this.elements.hashCode();
    }

    public boolean isEmpty() {
        return this.elements.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator<JsonElement> iterator() {
        return this.elements.iterator();
    }

    public boolean remove(JsonElement r1) {
        return this.elements.remove(r1);
    }

    public JsonElement set(int r1, JsonElement r2) {
        return this.elements.set(r1, r2);
    }

    public int size() {
        return this.elements.size();
    }

    public void add(Character r2) {
        List<JsonElement> r1 = this.elements;
        if (r2 != null) goto L5;
        JsonElement r3 = JsonNull.INSTANCE;
    L6:
        r1.add(r3);
        return;
    L5:
        r3 = new JsonPrimitive(r2);
        goto L6
    }

    @Override // com.google.gson.JsonElement
    public JsonArray deepCopy() {
        if (this.elements.isEmpty() == true) goto L10;
        JsonArray r0 = new JsonArray(this.elements.size());
        Iterator<JsonElement> r2 = this.elements.iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        r0.add(r2.next().deepCopy());
        goto L6
    L8:
        return r0;
    L10:
        return new JsonArray();
    }

    public JsonElement remove(int r1) {
        return this.elements.remove(r1);
    }

    public JsonArray(int r2) {
        this.elements = new ArrayList(r2);
    }

    public void add(Number r2) {
        List<JsonElement> r1 = this.elements;
        if (r2 != null) goto L5;
        JsonElement r3 = JsonNull.INSTANCE;
    L6:
        r1.add(r3);
        return;
    L5:
        r3 = new JsonPrimitive(r2);
        goto L6
    }

    public void add(String r2) {
        List<JsonElement> r1 = this.elements;
        if (r2 != null) goto L5;
        JsonElement r3 = JsonNull.INSTANCE;
    L6:
        r1.add(r3);
        return;
    L5:
        r3 = new JsonPrimitive(r2);
        goto L6
    }

    public void add(JsonElement r1) {
        if (r1 != null) goto L4;
        r1 = JsonNull.INSTANCE;
    L4:
        this.elements.add(r1);
    }
}
