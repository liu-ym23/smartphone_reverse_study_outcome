package com.google.gson;

/* JADX INFO: loaded from: classes2.dex */
public abstract enum LongSerializationPolicy extends Enum<LongSerializationPolicy> {
    private static final /* synthetic */ LongSerializationPolicy[] $VALUES = null;
    public static final LongSerializationPolicy DEFAULT = null;
    public static final LongSerializationPolicy STRING = null;

    public abstract JsonElement serialize(Long r1);

    private LongSerializationPolicy(String r1, int r2) {
        super(r1, r2);
    }

    /* synthetic */ LongSerializationPolicy(String r1, int r2, AnonymousClass1 r3) {
        this(r1, r2);
    }

    public static LongSerializationPolicy valueOf(String r1) {
        return (LongSerializationPolicy) Enum.valueOf(LongSerializationPolicy.class, r1);
    }

    public static LongSerializationPolicy[] values() {
        return (LongSerializationPolicy[]) $VALUES.clone();
    }

    static {
        final String r1 = "DEFAULT";
        final int r2 = 0;
        LongSerializationPolicy r0 = new AnonymousClass1(r1, r2);
        DEFAULT = r0;
        final String r3 = "STRING";
        final int r4 = 1;
        LongSerializationPolicy r5 = new AnonymousClass2(r3, r4);
        STRING = r5;
        $VALUES = new LongSerializationPolicy[]{r0, r5};
    }
}
