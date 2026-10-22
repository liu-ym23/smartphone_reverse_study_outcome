package com.google.gson.stream;

/* JADX INFO: loaded from: classes.dex */
public final enum JsonToken extends Enum<JsonToken> {
    private static final /* synthetic */ JsonToken[] $VALUES = null;
    public static final JsonToken BEGIN_ARRAY = null;
    public static final JsonToken BEGIN_OBJECT = null;
    public static final JsonToken BOOLEAN = null;
    public static final JsonToken END_ARRAY = null;
    public static final JsonToken END_DOCUMENT = null;
    public static final JsonToken END_OBJECT = null;
    public static final JsonToken NAME = null;
    public static final JsonToken NULL = null;
    public static final JsonToken NUMBER = null;
    public static final JsonToken STRING = null;

    static {
        JsonToken r0 = new JsonToken("BEGIN_ARRAY", 0);
        BEGIN_ARRAY = r0;
        JsonToken r1 = new JsonToken("END_ARRAY", 1);
        END_ARRAY = r1;
        JsonToken r2 = new JsonToken("BEGIN_OBJECT", 2);
        BEGIN_OBJECT = r2;
        JsonToken r3 = new JsonToken("END_OBJECT", 3);
        END_OBJECT = r3;
        JsonToken r4 = new JsonToken("NAME", 4);
        NAME = r4;
        JsonToken r5 = new JsonToken("STRING", 5);
        STRING = r5;
        JsonToken r6 = new JsonToken("NUMBER", 6);
        NUMBER = r6;
        JsonToken r7 = new JsonToken("BOOLEAN", 7);
        BOOLEAN = r7;
        JsonToken r8 = new JsonToken("NULL", 8);
        NULL = r8;
        JsonToken r9 = new JsonToken("END_DOCUMENT", 9);
        END_DOCUMENT = r9;
        $VALUES = new JsonToken[]{r0, r1, r2, r3, r4, r5, r6, r7, r8, r9};
    }

    private JsonToken(String r1, int r2) {
        super(r1, r2);
    }

    public static JsonToken valueOf(String r1) {
        return (JsonToken) Enum.valueOf(JsonToken.class, r1);
    }

    public static JsonToken[] values() {
        return (JsonToken[]) $VALUES.clone();
    }
}
