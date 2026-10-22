package com.google.gson;

import com.google.gson.internal.NonNullElementWrapperList;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class JsonArray extends JsonElement implements Iterable<JsonElement> {
    private final ArrayList<JsonElement> elements;

    @Override // com.google.gson.JsonElement
    public /* bridge */ /* synthetic */ JsonElement deepCopy() {
        return deepCopy();
    }

    public JsonArray() {
        this.elements = new ArrayList();
    }

    public JsonArray(int r2) {
        this.elements = new ArrayList(r2);
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

    public void add(Boolean r2) {
        ArrayList<JsonElement> r1 = this.elements;
        if (r2 != null) goto L5;
        JsonElement r3 = JsonNull.INSTANCE;
    L6:
        r1.add(r3);
        return;
    L5:
        r3 = new JsonPrimitive(r2);
        goto L6
    }

    public void add(Character r2) {
        ArrayList<JsonElement> r1 = this.elements;
        if (r2 != null) goto L5;
        JsonElement r3 = JsonNull.INSTANCE;
    L6:
        r1.add(r3);
        return;
    L5:
        r3 = new JsonPrimitive(r2);
        goto L6
    }

    public void add(Number r2) {
        ArrayList<JsonElement> r1 = this.elements;
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
        ArrayList<JsonElement> r1 = this.elements;
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

    public void addAll(JsonArray r1) {
        this.elements.addAll(r1.elements);
    }

    public JsonElement set(int r1, JsonElement r2) {
        ArrayList<JsonElement> r0 = this.elements;
        if (r2 != null) goto L6;
        r2 = JsonNull.INSTANCE;
    L6:
        return r0.set(r1, r2);
    }

    public boolean remove(JsonElement r1) {
        return this.elements.remove(r1);
    }

    public JsonElement remove(int r1) {
        return this.elements.remove(r1);
    }

    public boolean contains(JsonElement r1) {
        return this.elements.contains(r1);
    }

    public int size() {
        return this.elements.size();
    }

    public boolean isEmpty() {
        return this.elements.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator<JsonElement> iterator() {
        return this.elements.iterator();
    }

    public JsonElement get(int r1) {
        return this.elements.get(r1);
    }

    private JsonElement getAsSingleElement() {
        int r0 = this.elements.size();
        if (r0 != 1) goto L7;
        return this.elements.get(0);
    L7:
        throw new IllegalStateException("Array must have size 1, but has size " + r0);
    }

    @Override // com.google.gson.JsonElement
    public Number getAsNumber() {
        return getAsSingleElement().getAsNumber();
    }

    @Override // com.google.gson.JsonElement
    public String getAsString() {
        return getAsSingleElement().getAsString();
    }

    @Override // com.google.gson.JsonElement
    public double getAsDouble() {
        return getAsSingleElement().getAsDouble();
    }

    @Override // com.google.gson.JsonElement
    public BigDecimal getAsBigDecimal() {
        return getAsSingleElement().getAsBigDecimal();
    }

    @Override // com.google.gson.JsonElement
    public BigInteger getAsBigInteger() {
        return getAsSingleElement().getAsBigInteger();
    }

    @Override // com.google.gson.JsonElement
    public float getAsFloat() {
        return getAsSingleElement().getAsFloat();
    }

    @Override // com.google.gson.JsonElement
    public long getAsLong() {
        return getAsSingleElement().getAsLong();
    }

    @Override // com.google.gson.JsonElement
    public int getAsInt() {
        return getAsSingleElement().getAsInt();
    }

    @Override // com.google.gson.JsonElement
    public byte getAsByte() {
        return getAsSingleElement().getAsByte();
    }

    @Override // com.google.gson.JsonElement
    @Deprecated
    public char getAsCharacter() {
        return getAsSingleElement().getAsCharacter();
    }

    @Override // com.google.gson.JsonElement
    public short getAsShort() {
        return getAsSingleElement().getAsShort();
    }

    @Override // com.google.gson.JsonElement
    public boolean getAsBoolean() {
        return getAsSingleElement().getAsBoolean();
    }

    public List<JsonElement> asList() {
        return new NonNullElementWrapperList(this.elements);
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

    public int hashCode() {
        return this.elements.hashCode();
    }
}
