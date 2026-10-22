package t;

import android.graphics.PointF;
import androidx.room.jarjarred.org.antlr.v4.analysis.LeftRecursiveRuleTransformer;
import com.airbnb.lottie.parser.moshi.JsonReader$Token;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ko.r f22018a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ko.r f22019b = null;

    static {
        f22018a = ko.r.r(new String[]{"a", LeftRecursiveRuleTransformer.PRECEDENCE_OPTION_NAME, "s", "rz", "r", "o", "so", "eo", "sk", "sa"});
        f22019b = ko.r.r(new String[]{"k"});
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static p.d a(com.airbnb.lottie.parser.moshi.b r27, com.airbnb.lottie.h r28) {
        boolean r10 = false;
        if (r27.J() != JsonReader$Token.BEGIN_OBJECT) goto L5;
        Object[] r11 = true;
    L6:
        if (r11 == false) goto L8;
        r27.d();
    L8:
        p.b r5 = null;
        p.b r12 = null;
        m0.b r13 = null;
        p.e r14 = null;
        p.a r15 = null;
        p.b r16 = null;
        p.a r21 = null;
        p.b r22 = null;
        p.b r23 = null;
    L10:
        if (r27.g() == false) goto L39;
        switch(r27.L(f22018a)) {
            case 0: goto L31;
            case 1: goto L30;
            case 2: goto L29;
            case 3: goto L19;
            case 4: goto L20;
            case 5: goto L18;
            case 6: goto L17;
            case 7: goto L16;
            case 8: goto L15;
            case 9: goto L14;
            default: goto L13;
        };
    L14:
        r12 = mn.h.n(r27, r28, r10);
        goto L10
    L15:
        r16 = mn.h.n(r27, r28, r10);
        goto L10
    L16:
        r23 = mn.h.n(r27, r28, r10);
        goto L10
    L17:
        r22 = mn.h.n(r27, r28, r10);
        goto L10
    L18:
        r21 = mn.h.o(r27, r28);
        goto L10
    L19:
        r28.a("Lottie doesn't support 3D layers.");
    L20:
        p.b r17 = mn.h.n(r27, r28, r10);
        ArrayList r18 = (ArrayList) r17.f22372b;
        if (r18.isEmpty() == false) goto L23;
        p.b r19 = r17;
        p.b r26 = r12;
        r18.add(new v.a(r28, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(r28.f1267l)));
    L26:
        r5 = r19;
    L27:
        r12 = r26;
    L28:
        r10 = false;
        goto L10
    L23:
        r19 = r17;
        r26 = r12;
        if (((v.a) r18.get(r10 ? 1 : 0)).f22471b != null) goto L26;
        r18.set(0, new v.a(r28, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(r28.f1267l)));
        goto L26
    L29:
        r26 = r12;
        r15 = new p.a(o.a(r27, r28, 1.0f, e.g), 4);
        goto L27
    L30:
        r14 = a.b(r27, r28);
        goto L28
    L31:
        r26 = r12;
        r27.d();
    L33:
        if (r27.g() == false) goto L38;
        if (r27.L(f22019b) != 0) goto L36;
        r13 = a.a(r27, r28);
        goto L33
    L36:
        r27.M();
        r27.N();
        goto L33
    L38:
        r27.f();
        goto L27
    L13:
        r27.M();
        r27.N();
        goto L10
    L39:
        p.b r29 = r12;
        if (r11 == false) goto L42;
        r27.f();
    L42:
        if (r13 != null) goto L44;
    L49:
        m0.b r110 = null;
    L50:
        if (r14 != null) goto L52;
    L59:
        p.e r111 = null;
    L60:
        if (r5 != null) goto L62;
    L65:
        r5 = null;
    L66:
        if (r15 != null) goto L68;
    L75:
        p.a r112 = null;
    L76:
        if (r16 != null) goto L78;
    L83:
        p.b r24 = null;
    L84:
        if (r29 != 0) goto L86;
    L91:
        p.b r25 = null;
    L93:
        return new p.d(r110, r111, r112, r5, r21, r22, r23, r24, r25);
    L86:
        if (r29.isStatic() == true) goto L88;
    L90:
        r25 = r29;
        goto L93
    L88:
        if (((Float) ((v.a) ((ArrayList) r29.f22372b).get(0)).f22471b).floatValue() != 0.0f) goto L90;
    L78:
        if (r16.isStatic() == true) goto L80;
    L82:
        r24 = r16;
        goto L84
    L80:
        if (((Float) ((v.a) ((ArrayList) r16.f22372b).get(0)).f22471b).floatValue() != 0.0f) goto L82;
    L68:
        if (r15.isStatic() == false) goto L74;
        v.d r20 = (v.d) ((v.a) ((ArrayList) r15.f22372b).get(0)).f22471b;
        if (r20.f22484a != 1.0f) goto L74;
        if (r20.f22485b == 1.0f) goto L75;
    L74:
        r112 = r15;
        goto L76
    L62:
        if (r5.isStatic() == false) goto L66;
        if (((Float) ((v.a) ((ArrayList) r5.f22372b).get(0)).f22471b).floatValue() != 0.0f) goto L66;
    L52:
        if ((r14 instanceof p.c) == false) goto L54;
    L58:
        r111 = r14;
        goto L60
    L54:
        if (r14.isStatic() == false) goto L58;
        if (((PointF) ((v.a) r14.e().get(0)).f22471b).equals(0.0f, 0.0f) == false) goto L58;
    L44:
        if (r13.isStatic() == true) goto L46;
    L48:
        r110 = r13;
        goto L50
    L46:
        if (((PointF) ((v.a) r13.f19945a.get(0)).f22471b).equals(0.0f, 0.0f) == false) goto L48;
    L5:
        r11 = false;
        goto L6
    }
}
