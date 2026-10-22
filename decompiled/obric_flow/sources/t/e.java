package t;

import android.graphics.Color;
import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader$Token;

/* JADX INFO: loaded from: classes.dex */
public final class e implements b0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f22021b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e f22022c = null;
    public static final e d = null;
    public static final e e = null;
    public static final e f = null;
    public static final e g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f22023a;

    static {
        f22021b = new e(0);
        f22022c = new e(1);
        d = new e(2);
        e = new e(3);
        f = new e(4);
        g = new e(5);
    }

    public /* synthetic */ e(int r5) {
        this.f22023a = r5;
    }

    @Override // t.b0
    public final Object a(com.airbnb.lottie.parser.moshi.a r10, float r11) {
        switch(this.f22023a) {
            case 0: goto L40;
            case 1: goto L38;
            case 2: goto L36;
            case 3: goto L34;
            case 4: goto L18;
            default: goto L5;
        };
    L18:
        JsonReader$Token r12 = r10.J();
        if (r12 != JsonReader$Token.BEGIN_ARRAY) goto L22;
        return m.b(r10, r11);
    L22:
        if (r12 != JsonReader$Token.BEGIN_OBJECT) goto L25;
        return m.b(r10, r11);
    L25:
        if (r12 != JsonReader$Token.NUMBER) goto L32;
        PointF r13 = new PointF(((float) r10.n()) * r11, ((float) r10.n()) * r11);
    L28:
        if (r10.g() == false) goto L62;
        r10.N();
        goto L28
    L62:
        return r13;
    L32:
        throw new IllegalArgumentException("Cannot convert json to point. Next token is " + r12);
    L5:
        if (r10.J() != JsonReader$Token.BEGIN_ARRAY) goto L7;
        boolean r14 = true;
    L8:
        if (r14 == false) goto L10;
        r10.b();
    L10:
        float r5 = (float) r10.n();
        float r15 = (float) r10.n();
    L12:
        if (r10.g() == false) goto L14;
        r10.N();
        goto L12
    L14:
        if (r14 == false) goto L17;
        r10.e();
    L17:
        return new v.d((r5 / 100.0f) * r11, (r15 / 100.0f) * r11);
    L7:
        r14 = false;
        goto L8
    L34:
        return m.b(r10, r11);
    L36:
        return Integer.valueOf(Math.round(m.d(r10) * r11));
    L38:
        return Float.valueOf(m.d(r10) * r11);
    L40:
        if (r10.J() != JsonReader$Token.BEGIN_ARRAY) goto L42;
        boolean r16 = true;
    L43:
        if (r16 == false) goto L45;
        r10.b();
    L45:
        double r17 = r10.n();
        double r18 = r10.n();
        double r19 = r10.n();
        double r20 = r10.n();
        if (r16 == false) goto L49;
        r10.e();
    L49:
        if (r17 > 1.0d) goto L58;
        if (r18 > 1.0d) goto L58;
        if (r19 > 1.0d) goto L58;
        if (r20 > 1.0d) goto L58;
        r17 = r17 * 255.0d;
        r18 = r18 * 255.0d;
        r19 = r19 * 255.0d;
        r20 = r20 * 255.0d;
    L58:
        return Integer.valueOf(Color.argb((int) r20, (int) r17, (int) r18, (int) r19));
    L42:
        r16 = false;
        goto L43
    }
}
