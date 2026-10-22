package com.android.apksig.internal.asn1;

/* JADX INFO: loaded from: classes.dex */
public final enum Asn1Tagging extends Enum<Asn1Tagging> {
    private static final /* synthetic */ Asn1Tagging[] $VALUES = null;
    public static final Asn1Tagging EXPLICIT = null;
    public static final Asn1Tagging IMPLICIT = null;
    public static final Asn1Tagging NORMAL = null;

    static {
        Asn1Tagging r0 = new Asn1Tagging("NORMAL", 0);
        NORMAL = r0;
        Asn1Tagging r1 = new Asn1Tagging("EXPLICIT", 1);
        EXPLICIT = r1;
        Asn1Tagging r3 = new Asn1Tagging("IMPLICIT", 2);
        IMPLICIT = r3;
        $VALUES = new Asn1Tagging[]{r0, r1, r3};
    }

    private Asn1Tagging(String r1, int r2) {
        super(r1, r2);
    }

    public static Asn1Tagging valueOf(String r1) {
        return (Asn1Tagging) Enum.valueOf(Asn1Tagging.class, r1);
    }

    public static Asn1Tagging[] values() {
        return (Asn1Tagging[]) $VALUES.clone();
    }
}
