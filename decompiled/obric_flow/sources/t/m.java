package t;

import android.graphics.Color;
import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader$Token;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ko.r f22036a = null;

    static {
        f22036a = ko.r.r(new String[]{"x", "y"});
    }

    public static int a(com.airbnb.lottie.parser.moshi.a r10) {
        r10.b();
        int r5 = (int) (r10.n() * 255.0d);
        int r11 = (int) (r10.n() * 255.0d);
        int r12 = (int) (r10.n() * 255.0d);
    L4:
        if (r10.g() == false) goto L6;
        r10.N();
        goto L4
    L6:
        r10.e();
        return Color.argb(255, r5, r11, r12);
    }

    public static PointF b(com.airbnb.lottie.parser.moshi.a r5, float r10) {
        int r11 = l.f22035a[r5.J().ordinal()];
        if (r11 != 1) goto L5;
        float r12 = (float) r5.n();
        float r13 = (float) r5.n();
    L29:
        if (r5.g() == false) goto L32;
        r5.N();
        goto L29
    L32:
        return new PointF(r12 * r10, r13 * r10);
    L5:
        if (r11 != 2) goto L7;
        r5.b();
        float r14 = (float) r5.n();
        float r15 = (float) r5.n();
    L23:
        if (r5.J() == JsonReader$Token.END_ARRAY) goto L25;
        r5.N();
        goto L23
    L25:
        r5.e();
        return new PointF(r14 * r10, r15 * r10);
    L7:
        if (r11 != 3) goto L20;
        r5.d();
        float r16 = 0.0f;
        float r17 = 0.0f;
    L10:
        if (r5.g() == false) goto L17;
        int r18 = r5.L(f22036a);
        if (r18 != 0) goto L13;
        r16 = d(r5);
        goto L10
    L13:
        if (r18 != 1) goto L14;
        r17 = d(r5);
        goto L10
    L14:
        r5.M();
        r5.N();
        goto L10
    L17:
        r5.f();
        return new PointF(r16 * r10, r17 * r10);
    L20:
        throw new IllegalArgumentException("Unknown point starts with " + r5.J());
    }

    public static ArrayList c(com.airbnb.lottie.parser.moshi.a r5, float r10) {
        ArrayList r11 = new ArrayList();
        r5.b();
    L4:
        if (r5.J() != JsonReader$Token.BEGIN_ARRAY) goto L6;
        r5.b();
        r11.add(b(r5, r10));
        r5.e();
        goto L4
    L6:
        r5.e();
        return r11;
    }

    public static float d(com.airbnb.lottie.parser.moshi.a r5) {
        JsonReader$Token r10 = r5.J();
        int r11 = l.f22035a[r10.ordinal()];
        if (r11 == 1) goto L15;
        if (r11 != 2) goto L13;
        r5.b();
        float r12 = (float) r5.n();
    L8:
        if (r5.g() == false) goto L10;
        r5.N();
        goto L8
    L10:
        r5.e();
        return r12;
    L13:
        throw new IllegalArgumentException("Unknown value for token of type " + r10);
    L15:
        return (float) r5.n();
    }
}
