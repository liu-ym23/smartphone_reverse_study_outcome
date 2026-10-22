package com.qq.taf.jce;

import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public abstract class JceStruct implements Serializable {
    public static final byte BYTE = 0;
    public static final byte DOUBLE = 5;
    public static final byte FLOAT = 4;
    public static final byte INT = 2;
    public static final int JCE_MAX_STRING_LENGTH = 104857600;
    public static final byte LIST = 9;
    public static final byte LONG = 3;
    public static final byte MAP = 8;
    public static final byte SHORT = 1;
    public static final byte SIMPLE_LIST = 13;
    public static final byte STRING1 = 6;
    public static final byte STRING4 = 7;
    public static final byte STRUCT_BEGIN = 10;
    public static final byte STRUCT_END = 11;
    public static final byte ZERO_TAG = 12;

    public JceStruct() {
    }

    public boolean containField(String r1) {
        return false;
    }

    public void display(StringBuilder r1, int r2) {
    }

    public void displaySimple(StringBuilder r1, int r2) {
    }

    public Object getFieldByName(String r1) {
        return null;
    }

    public JceStruct newInit() {
        return null;
    }

    public abstract void readFrom(JceInputStream r1);

    public void recyle() {
    }

    public void setFieldByName(String r1, Object r2) {
    }

    public byte[] toByteArray() {
        JceOutputStream r0 = new JceOutputStream();
        writeTo(r0);
        return r0.toByteArray();
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        display(r0, 0);
        return r0.toString();
    }

    public abstract void writeTo(JceOutputStream r1);

    public byte[] toByteArray(String r2) {
        JceOutputStream r0 = new JceOutputStream();
        r0.setServerEncoding(r2);
        writeTo(r0);
        return r0.toByteArray();
    }
}
