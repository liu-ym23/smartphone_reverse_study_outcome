package com.google.gson;

import com.google.gson.internal.LazilyParsedNumber;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public final class JsonPrimitive extends JsonElement {
    private final Object value;

    @Override // com.google.gson.JsonElement
    public JsonPrimitive deepCopy() {
        return this;
    }

    @Override // com.google.gson.JsonElement
    public /* bridge */ /* synthetic */ JsonElement deepCopy() {
        return deepCopy();
    }

    public JsonPrimitive(Boolean r1) {
        this.value = Objects.requireNonNull(r1);
    }

    public JsonPrimitive(Number r1) {
        this.value = Objects.requireNonNull(r1);
    }

    public JsonPrimitive(String r1) {
        this.value = Objects.requireNonNull(r1);
    }

    public JsonPrimitive(Character r1) {
        this.value = ((Character) Objects.requireNonNull(r1)).toString();
    }

    public boolean isBoolean() {
        return this.value instanceof Boolean;
    }

    @Override // com.google.gson.JsonElement
    public boolean getAsBoolean() {
        if (isBoolean() == false) goto L7;
        return ((Boolean) this.value).booleanValue();
    L7:
        return Boolean.parseBoolean(getAsString());
    }

    public boolean isNumber() {
        return this.value instanceof Number;
    }

    @Override // com.google.gson.JsonElement
    public Number getAsNumber() {
        Object r0 = this.value;
        if ((r0 instanceof Number) == false) goto L7;
        return (Number) r0;
    L7:
        if ((r0 instanceof String) == false) goto L11;
        return new LazilyParsedNumber((String) this.value);
    L11:
        throw new UnsupportedOperationException("Primitive is neither a number nor a string");
    }

    public boolean isString() {
        return this.value instanceof String;
    }

    @Override // com.google.gson.JsonElement
    public String getAsString() {
        Object r0 = this.value;
        if ((r0 instanceof String) == false) goto L7;
        return (String) r0;
    L7:
        if (isNumber() == false) goto L11;
        return getAsNumber().toString();
    L11:
        if (isBoolean() == false) goto L15;
        return ((Boolean) this.value).toString();
    L15:
        throw new AssertionError("Unexpected value type: " + this.value.getClass());
    }

    @Override // com.google.gson.JsonElement
    public double getAsDouble() {
        if (isNumber() == false) goto L6;
        return getAsNumber().doubleValue();
    L6:
        return Double.parseDouble(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public BigDecimal getAsBigDecimal() {
        Object r0 = this.value;
        if ((r0 instanceof BigDecimal) == false) goto L6;
        return (BigDecimal) r0;
    L6:
        return new BigDecimal(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public BigInteger getAsBigInteger() {
        Object r0 = this.value;
        if ((r0 instanceof BigInteger) == false) goto L6;
        return (BigInteger) r0;
    L6:
        return new BigInteger(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public float getAsFloat() {
        if (isNumber() == false) goto L6;
        return getAsNumber().floatValue();
    L6:
        return Float.parseFloat(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public long getAsLong() {
        if (isNumber() == false) goto L6;
        return getAsNumber().longValue();
    L6:
        return Long.parseLong(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public short getAsShort() {
        if (isNumber() == false) goto L6;
        return getAsNumber().shortValue();
    L6:
        return Short.parseShort(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public int getAsInt() {
        if (isNumber() == false) goto L6;
        return getAsNumber().intValue();
    L6:
        return Integer.parseInt(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public byte getAsByte() {
        if (isNumber() == false) goto L6;
        return getAsNumber().byteValue();
    L6:
        return Byte.parseByte(getAsString());
    }

    @Override // com.google.gson.JsonElement
    @Deprecated
    public char getAsCharacter() {
        String r1 = getAsString();
        if (r1.isEmpty() == true) goto L7;
        return r1.charAt(0);
    L7:
        throw new UnsupportedOperationException("String value is empty");
    }

    public int hashCode() {
        if (this.value != null) goto L7;
        return 31;
    L7:
        if (isIntegral(this) == false) goto L11;
        long r2 = getAsNumber().longValue();
    L10:
        return (int) ((r2 >>> 32) ^ r2);
    L11:
        Object r0 = this.value;
        if ((r0 instanceof Number) == false) goto L15;
        r2 = Double.doubleToLongBits(getAsNumber().doubleValue());
        goto L10
    L15:
        return r0.hashCode();
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L6;
        return true;
    L6:
        if (r6 != null) goto L8;
    L41:
        return false;
    L8:
        if (getClass() != r6.getClass()) goto L41;
        JsonPrimitive r7 = (JsonPrimitive) r6;
        if (this.value != null) goto L18;
        if (r7.value != null) goto L16;
        return true;
    L16:
        return false;
    L18:
        if (isIntegral(this) == true) goto L20;
    L26:
        Object r2 = this.value;
        if ((r2 instanceof Number) == false) goto L40;
        if ((r7.value instanceof Number) == false) goto L40;
        double r3 = getAsNumber().doubleValue();
        double r5 = r7.getAsNumber().doubleValue();
        if (r3 != r5) goto L33;
        return true;
    L33:
        if (Double.isNaN(r3) == false) goto L38;
        if (Double.isNaN(r5) == false) goto L38;
        return true;
    L38:
        return false;
    L40:
        return r2.equals(r7.value);
    L20:
        if (isIntegral(r7) == false) goto L26;
        if (getAsNumber().longValue() != r7.getAsNumber().longValue()) goto L25;
        return true;
    L25:
        return false;
    }

    private static boolean isIntegral(JsonPrimitive r2) {
        Object r3 = r2.value;
        if ((r3 instanceof Number) == false) goto L16;
        Number r4 = (Number) r3;
        if ((r4 instanceof BigInteger) == false) goto L7;
    L14:
        return true;
    L7:
        if ((r4 instanceof Long) == true) goto L14;
        if ((r4 instanceof Integer) == true) goto L14;
        if ((r4 instanceof Short) == true) goto L14;
        if ((r4 instanceof Byte) == true) goto L14;
        return false;
    L16:
        return false;
    }
}
