package com.android.apksig.internal.asn1;

/* JADX INFO: loaded from: classes.dex */
public final enum Asn1TagClass extends Enum<Asn1TagClass> {
    private static final /* synthetic */ Asn1TagClass[] $VALUES = null;
    public static final Asn1TagClass APPLICATION = null;
    public static final Asn1TagClass AUTOMATIC = null;
    public static final Asn1TagClass CONTEXT_SPECIFIC = null;
    public static final Asn1TagClass PRIVATE = null;
    public static final Asn1TagClass UNIVERSAL = null;

    static {
        Asn1TagClass r0 = new Asn1TagClass("UNIVERSAL", 0);
        UNIVERSAL = r0;
        Asn1TagClass r1 = new Asn1TagClass("APPLICATION", 1);
        APPLICATION = r1;
        Asn1TagClass r3 = new Asn1TagClass("CONTEXT_SPECIFIC", 2);
        CONTEXT_SPECIFIC = r3;
        Asn1TagClass r5 = new Asn1TagClass("PRIVATE", 3);
        PRIVATE = r5;
        Asn1TagClass r7 = new Asn1TagClass("AUTOMATIC", 4);
        AUTOMATIC = r7;
        $VALUES = new Asn1TagClass[]{r0, r1, r3, r5, r7};
    }

    private Asn1TagClass(String r1, int r2) {
        super(r1, r2);
    }

    public static Asn1TagClass valueOf(String r1) {
        return (Asn1TagClass) Enum.valueOf(Asn1TagClass.class, r1);
    }

    public static Asn1TagClass[] values() {
        return (Asn1TagClass[]) $VALUES.clone();
    }
}
