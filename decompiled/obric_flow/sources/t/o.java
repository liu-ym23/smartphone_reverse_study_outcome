package t;

import com.airbnb.lottie.parser.moshi.JsonReader$Token;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ko.r f22040a = null;

    static {
        f22040a = ko.r.r(new String[]{"k"});
    }

    public static ArrayList a(com.airbnb.lottie.parser.moshi.a r5, com.airbnb.lottie.h r10, float r11, b0 r12) {
        ArrayList r13 = new ArrayList();
        if (r5.J() != JsonReader$Token.STRING) goto L6;
        r10.a("Lottie doesn't support expressions.");
        return r13;
    L6:
        r5.d();
    L8:
        if (r5.g() == false) goto L22;
        if (r5.L(f22040a) != 0) goto L11;
        if (r5.J() == JsonReader$Token.BEGIN_ARRAY) goto L14;
        r13.add(n.a(r5, r10, r11, r12, false));
        goto L8
    L14:
        r5.b();
        if (r5.J() != JsonReader$Token.NUMBER) goto L18;
        r13.add(n.a(r5, r10, r11, r12, false));
    L20:
        r5.e();
    L18:
        if (r5.g() == false) goto L20;
        r13.add(n.a(r5, r10, r11, r12, true));
        goto L18
    L11:
        r5.N();
        goto L8
    L22:
        r5.f();
        b(r13);
        return r13;
    }

    public static void b(ArrayList r5) {
        int r10 = r5.size();
        int r11 = 0;
    L3:
        int r12 = r10 - 1;
        if (r11 >= r12) goto L12;
        v.a r13 = (v.a) r5.get(r11);
        r11 = r11 + 1;
        v.a r14 = (v.a) r5.get(r11);
        r13.f = Float.valueOf(r14.e);
        if (r13.f22472c != null) goto L3;
        Object r15 = r14.f22471b;
        if (r15 == null) goto L3;
        r13.f22472c = r15;
        if ((r13 instanceof l.i) == false) goto L3;
        ((l.i) r13).d();
        goto L3
    L12:
        v.a r16 = (v.a) r5.get(r12);
        if (r16.f22471b == null) goto L17;
        if (r16.f22472c == null) goto L17;
        return;
    L17:
        if (r5.size() <= 1) goto L30;
        r5.remove(r16);
        return;
    }
}
