package org.threeten.bp.format;

/* JADX INFO: loaded from: classes6.dex */
public final enum SignStyle extends Enum<SignStyle> {
    private static final /* synthetic */ SignStyle[] $VALUES = null;
    public static final SignStyle ALWAYS = null;
    public static final SignStyle EXCEEDS_PAD = null;
    public static final SignStyle NEVER = null;
    public static final SignStyle NORMAL = null;
    public static final SignStyle NOT_NEGATIVE = null;

    private SignStyle(String r1, int r2) {
        super(r1, r2);
    }

    public static SignStyle valueOf(String r1) {
        return (SignStyle) Enum.valueOf(SignStyle.class, r1);
    }

    public static SignStyle[] values() {
        return (SignStyle[]) $VALUES.clone();
    }

    static {
        SignStyle r0 = new SignStyle("NORMAL", 0);
        NORMAL = r0;
        SignStyle r1 = new SignStyle("ALWAYS", 1);
        ALWAYS = r1;
        SignStyle r3 = new SignStyle("NEVER", 2);
        NEVER = r3;
        SignStyle r5 = new SignStyle("NOT_NEGATIVE", 3);
        NOT_NEGATIVE = r5;
        SignStyle r7 = new SignStyle("EXCEEDS_PAD", 4);
        EXCEEDS_PAD = r7;
        $VALUES = new SignStyle[]{r0, r1, r3, r5, r7};
    }

    boolean parse(boolean r3, boolean r4, boolean r5) {
        int r2 = ordinal();
        if (r2 == 0) goto L12;
        if (r2 != 1) goto L6;
    L11:
        return true;
    L6:
        if (r2 == 4) goto L11;
        if (r4 == true) goto L16;
        if (r5 == false) goto L10;
        return false;
    L10:
        return true;
    L16:
        return false;
    L12:
        if (r3 == false) goto L15;
        if (r4 == false) goto L15;
        return false;
    L15:
        return true;
    }
}
