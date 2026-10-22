package com.bytedance.retrofit2.mime;

/* JADX INFO: loaded from: classes3.dex */
public class TypedString extends TypedByteArray {
    public TypedString(String r3) {
        super("text/plain; charset=UTF-8", convertToBytes(r3), new String[0]);
    }

    private static byte[] convertToBytes(String r1) {
        return r1.getBytes("UTF-8");
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    @Override // com.bytedance.retrofit2.mime.TypedByteArray
    public String toString() {
        return "TypedString[" + new String(getBytes(), "UTF-8") + "]";
    L6:
        throw new AssertionError("Must be able to decode UTF-8");
    }
}
