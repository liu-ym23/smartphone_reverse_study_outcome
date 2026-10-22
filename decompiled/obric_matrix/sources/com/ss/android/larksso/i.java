package com.ss.android.larksso;

/* JADX INFO: loaded from: classes2.dex */
public final enum i extends Enum<i> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final i f12039g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final i f12040h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final i f12041i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final i f12042j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final i f12043k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final i f12044l = null;
    private static final /* synthetic */ i[] m = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f12045f;

    static {
        i r0 = new i("BAD_STATE", 0, "-1");
        f12039g = r0;
        i r1 = new i("NO_VALID_CODE", 1, "-2");
        f12040h = r1;
        i r3 = new i("CANCELLED", 2, "-3");
        f12041i = r3;
        i r5 = new i("CAN_NOT_JUMP_TO_LARK", 3, "-4");
        f12042j = r5;
        i r7 = new i("AUTH_FAILED", 4, "-5");
        f12043k = r7;
        i r9 = new i("PARAMETER_ERROR", 5, "-6");
        f12044l = r9;
        m = new i[]{r0, r1, r3, r5, r7, r9};
    }

    private i(String r1, int r2, String r3) {
        super(r1, r2);
        this.f12045f = r3;
    }

    public static i valueOf(String r1) {
        return (i) Enum.valueOf(i.class, r1);
    }

    public static i[] values() {
        return (i[]) m.clone();
    }

    public String a() {
        return this.f12045f;
    }
}
