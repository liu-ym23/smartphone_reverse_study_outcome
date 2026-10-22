package t;

import com.airbnb.lottie.model.DocumentData$Justification;

/* JADX INFO: loaded from: classes.dex */
public final class g implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f22025a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ko.r f22026b = null;

    static {
        f22025a = new g();
        f22026b = ko.r.r(new String[]{"t", "f", "s", "j", "tr", "lh", "ls", "fc", "sc", "sw", "of"});
    }

    @Override // t.b0
    public final Object a(com.airbnb.lottie.parser.moshi.a r18, float r19) {
        DocumentData$Justification r5 = DocumentData$Justification.CENTER;
        r18.d();
        DocumentData$Justification r10 = r5;
        String r11 = null;
        String r12 = null;
        float r13 = 0.0f;
        float r14 = 0.0f;
        float r15 = 0.0f;
        float r16 = 0.0f;
        int r17 = 0;
        int r110 = 0;
        int r111 = 0;
        boolean r112 = true;
    L4:
        if (r18.g() == false) goto L23;
        switch(r18.L(f22026b)) {
            case 0: goto L22;
            case 1: goto L21;
            case 2: goto L20;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            case 8: goto L10;
            case 9: goto L9;
            case 10: goto L8;
            default: goto L7;
        };
    L8:
        r112 = r18.m();
        goto L4
    L9:
        r16 = (float) r18.n();
        goto L4
    L10:
        r111 = m.a(r18);
        goto L4
    L11:
        r110 = m.a(r18);
        goto L4
    L12:
        r15 = (float) r18.n();
        goto L4
    L13:
        r14 = (float) r18.n();
        goto L4
    L14:
        r17 = r18.p();
        goto L4
    L15:
        int r20 = r18.p();
        r10 = DocumentData$Justification.CENTER;
        if (r20 > r10.ordinal()) goto L4;
        if (r20 < 0) goto L4;
        r10 = DocumentData$Justification.values()[r20];
        goto L4
    L20:
        r13 = (float) r18.n();
        goto L4
    L21:
        r12 = r18.q();
        goto L4
    L22:
        r11 = r18.q();
        goto L4
    L7:
        r18.M();
        r18.N();
        goto L4
    L23:
        r18.f();
        return new o.b(r11, r12, r13, r10, r17, r14, r15, r110, r111, r16, r112);
    }
}
