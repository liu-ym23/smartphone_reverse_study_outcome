package t;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader$Token;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public final class v implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v f22051a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ko.r f22052b = null;

    static {
        f22051a = new v();
        f22052b = ko.r.r(new String[]{"c", "v", "i", "o"});
    }

    @Override // t.b0
    public final Object a(com.airbnb.lottie.parser.moshi.a r12, float r13) {
        if (r12.J() != JsonReader$Token.BEGIN_ARRAY) goto L5;
        r12.b();
    L5:
        r12.d();
        ArrayList r11 = null;
        ArrayList r5 = null;
        ArrayList r10 = null;
        boolean r14 = false;
    L7:
        if (r12.g() == false) goto L20;
        int r15 = r12.L(f22052b);
        if (r15 != 0) goto L10;
        r14 = r12.m();
        goto L7
    L10:
        if (r15 != 1) goto L12;
        r11 = m.c(r12, r13);
        goto L7
    L12:
        if (r15 != 2) goto L14;
        r5 = m.c(r12, r13);
        goto L7
    L14:
        if (r15 != 3) goto L15;
        r10 = m.c(r12, r13);
        goto L7
    L15:
        r12.M();
        r12.N();
        goto L7
    L20:
        r12.f();
        if (r12.J() != JsonReader$Token.END_ARRAY) goto L23;
        r12.e();
    L23:
        if (r11 == null) goto L37;
        if (r5 == null) goto L37;
        if (r10 == null) goto L37;
        if (r11.isEmpty() == true) goto L54;
        int r16 = r11.size();
        PointF r17 = (PointF) r11.get(0);
        ArrayList r18 = new ArrayList(r16);
        int r19 = 1;
    L30:
        if (r19 >= r16) goto L32;
        PointF r20 = (PointF) r11.get(r19);
        int r21 = r19 - 1;
        r18.add(new o.a(u.e.a((PointF) r11.get(r21), (PointF) r10.get(r21)), u.e.a(r20, (PointF) r5.get(r19)), r20));
        r19 = r19 + 1;
        goto L30
    L32:
        if (r14 == false) goto L35;
        PointF r22 = (PointF) r11.get(0);
        int r110 = r16 - 1;
        r18.add(new o.a(u.e.a((PointF) r11.get(r110), (PointF) r10.get(r110)), u.e.a(r22, (PointF) r5.get(0)), r22));
    L35:
        return new q.j(r17, r14, r18);
    L54:
        return new q.j(new PointF(), false, Collections.emptyList());
    L37:
        throw new IllegalArgumentException("Shape data was missing information.");
    }
}
