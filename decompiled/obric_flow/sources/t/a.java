package t;

import com.airbnb.lottie.parser.moshi.JsonReader$Token;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ko.r f22014a = null;

    static {
        f22014a = ko.r.r(new String[]{"k", "x", "y"});
    }

    public static m0.b a(com.airbnb.lottie.parser.moshi.b r5, com.airbnb.lottie.h r10) {
        ArrayList r11 = new ArrayList();
        if (r5.J() != JsonReader$Token.BEGIN_ARRAY) goto L13;
        r5.b();
    L6:
        if (r5.g() == false) goto L12;
        if (r5.J() != JsonReader$Token.BEGIN_OBJECT) goto L10;
        boolean r12 = true;
    L11:
        r11.add(new l.i(r10, n.a(r5, r10, u.f.c(), e.e, r12)));
        goto L6
    L10:
        r12 = false;
        goto L11
    L12:
        r5.e();
        o.b(r11);
    L15:
        return new m0.b(r11);
    L13:
        r11.add(new v.a(m.b(r5, u.f.c())));
        goto L15
    }

    public static p.e b(com.airbnb.lottie.parser.moshi.b r10, com.airbnb.lottie.h r11) {
        r10.d();
        m0.b r5 = null;
        p.b r12 = null;
        boolean r13 = false;
        p.b r14 = null;
    L4:
        if (r10.J() == JsonReader$Token.END_OBJECT) goto L22;
        int r15 = r10.L(f22014a);
        if (r15 != 0) goto L8;
        r5 = a(r10, r11);
        goto L4
    L8:
        if (r15 != 1) goto L10;
        if (r10.J() == JsonReader$Token.STRING) goto L19;
        r14 = mn.h.n(r10, r11, true);
        goto L4
    L19:
        r10.N();
    L15:
        r13 = true;
        goto L4
    L10:
        if (r15 != 2) goto L11;
        if (r10.J() == JsonReader$Token.STRING) goto L14;
        r12 = mn.h.n(r10, r11, true);
        goto L4
    L14:
        r10.N();
        goto L15
    L11:
        r10.M();
        r10.N();
        goto L4
    L22:
        r10.f();
        if (r13 == false) goto L25;
        r11.a("Lottie doesn't support expressions.");
    L25:
        if (r5 == null) goto L28;
        return r5;
    L28:
        return new p.c(r14, r12);
    }
}
