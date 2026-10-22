package com.android.apksig.internal.asn1;

/* JADX INFO: loaded from: classes.dex */
public final enum Asn1Type extends Enum<Asn1Type> {
    private static final /* synthetic */ Asn1Type[] $VALUES = null;
    public static final Asn1Type ANY = null;
    public static final Asn1Type BIT_STRING = null;
    public static final Asn1Type BOOLEAN = null;
    public static final Asn1Type CHOICE = null;
    public static final Asn1Type GENERALIZED_TIME = null;
    public static final Asn1Type INTEGER = null;
    public static final Asn1Type OBJECT_IDENTIFIER = null;
    public static final Asn1Type OCTET_STRING = null;
    public static final Asn1Type SEQUENCE = null;
    public static final Asn1Type SEQUENCE_OF = null;
    public static final Asn1Type SET_OF = null;
    public static final Asn1Type UNENCODED_CONTAINER = null;
    public static final Asn1Type UTC_TIME = null;

    static {
        Asn1Type r0 = new Asn1Type("ANY", 0);
        ANY = r0;
        Asn1Type r1 = new Asn1Type("CHOICE", 1);
        CHOICE = r1;
        Asn1Type r3 = new Asn1Type("INTEGER", 2);
        INTEGER = r3;
        Asn1Type r5 = new Asn1Type("OBJECT_IDENTIFIER", 3);
        OBJECT_IDENTIFIER = r5;
        Asn1Type r7 = new Asn1Type("OCTET_STRING", 4);
        OCTET_STRING = r7;
        Asn1Type r9 = new Asn1Type("SEQUENCE", 5);
        SEQUENCE = r9;
        Asn1Type r11 = new Asn1Type("SEQUENCE_OF", 6);
        SEQUENCE_OF = r11;
        Asn1Type r13 = new Asn1Type("SET_OF", 7);
        SET_OF = r13;
        Asn1Type r15 = new Asn1Type("BIT_STRING", 8);
        BIT_STRING = r15;
        Asn1Type r14 = new Asn1Type("UTC_TIME", 9);
        UTC_TIME = r14;
        Asn1Type r12 = new Asn1Type("GENERALIZED_TIME", 10);
        GENERALIZED_TIME = r12;
        Asn1Type r10 = new Asn1Type("BOOLEAN", 11);
        BOOLEAN = r10;
        Asn1Type r8 = new Asn1Type("UNENCODED_CONTAINER", 12);
        UNENCODED_CONTAINER = r8;
        $VALUES = new Asn1Type[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8};
    }

    private Asn1Type(String r1, int r2) {
        super(r1, r2);
    }

    public static Asn1Type valueOf(String r1) {
        return (Asn1Type) Enum.valueOf(Asn1Type.class, r1);
    }

    public static Asn1Type[] values() {
        return (Asn1Type[]) $VALUES.clone();
    }
}
