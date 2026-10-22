package com.bytedanceos.utils;

/* JADX INFO: loaded from: classes2.dex */
public class ByteUnitPair {
    public final String unit;
    public final String value;

    public ByteUnitPair(String value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    public String getValue() {
        return this.value;
    }

    public String getUnit() {
        return this.unit;
    }
}
