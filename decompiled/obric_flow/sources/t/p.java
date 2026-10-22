package t;

import android.graphics.Color;
import com.airbnb.lottie.model.content.Mask$MaskMode;
import com.airbnb.lottie.model.layer.Layer$LayerType;
import com.airbnb.lottie.model.layer.Layer$MatteType;
import java.util.ArrayList;
import kotlin.jvm.internal.CharCompanionObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ko.r f22041a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ko.r f22042b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ko.r f22043c = null;

    static {
        f22041a = ko.r.r(new String[]{"nm", "ind", "refId", "ty", "parent", "sw", "sh", "sc", "ks", "tt", "masksProperties", "shapes", "t", "ef", "sr", "st", "w", "h", "ip", "op", "tm", "cl", "hd"});
        f22042b = ko.r.r(new String[]{"d", "a"});
        f22043c = ko.r.r(new String[]{"nm"});
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r15v8 */
    public static r.g a(com.airbnb.lottie.parser.moshi.b r42, com.airbnb.lottie.h r43) {
        int r5 = 3;
        int r10 = 2;
        Layer$MatteType r11 = Layer$MatteType.NONE;
        ArrayList r12 = new ArrayList();
        ArrayList r13 = new ArrayList();
        r42.d();
        char r14 = CharCompanionObject.MIN_VALUE;
        Float r15 = Float.valueOf(1.0f);
        Float r16 = Float.valueOf(0.0f);
        String r17 = "UNSET";
        long r18 = 0;
        boolean r19 = false;
        int r23 = 0;
        int r24 = 0;
        int r25 = 0;
        int r28 = 0;
        int r29 = 0;
        boolean r34 = false;
        Layer$MatteType r32 = r11;
        float r26 = 1.0f;
        float r20 = 0.0f;
        float r27 = 0.0f;
        float r35 = 0.0f;
        long r110 = -1;
        Layer$LayerType r111 = null;
        String r21 = null;
        p.d r22 = null;
        p.a r30 = null;
        ja.d r31 = null;
        p.b r33 = null;
        String r36 = null;
    L4:
        if (r42.g() == false) goto L152;
        switch(r42.L(f22041a)) {
            case 0: goto L151;
            case 1: goto L150;
            case 2: goto L149;
            case 3: goto L146;
            case 4: goto L145;
            case 5: goto L144;
            case 6: goto L143;
            case 7: goto L142;
            case 8: goto L141;
            case 9: goto L140;
            case 10: goto L80;
            case 11: goto L73;
            case 12: goto L31;
            case 13: goto L19;
            case 14: goto L18;
            case 15: goto L17;
            case 16: goto L16;
            case 17: goto L15;
            case 18: goto L14;
            case 19: goto L12;
            case 20: goto L11;
            case 21: goto L10;
            case 22: goto L8;
            default: goto L7;
        };
    L7:
        r42.M();
        r42.N();
        char r112 = r14;
        long r38 = r18;
    L138:
        r14 = r112;
        r18 = r38;
    L139:
        r19 = false;
        r5 = 3;
        r10 = 2;
        goto L4
    L8:
        r34 = r42.m();
        goto L4
    L10:
        r36 = r42.q();
        goto L4
    L11:
        r33 = mn.h.n(r42, r43, r19);
        goto L4
    L12:
        r35 = (float) r42.n();
    L13:
        r18 = r18;
        goto L4
    L14:
        r20 = (float) r42.n();
        goto L13
    L15:
        r29 = (int) (u.f.c() * r42.p());
        goto L13
    L16:
        r28 = (int) (u.f.c() * r42.p());
        goto L13
    L17:
        r27 = (float) r42.n();
        goto L13
    L18:
        r26 = (float) r42.n();
        goto L13
    L19:
        r38 = r18;
        r42.b();
        ArrayList r113 = new ArrayList();
    L21:
        if (r42.g() == false) goto L30;
        r42.d();
    L24:
        if (r42.g() == false) goto L29;
        if (r42.L(f22043c) != 0) goto L27;
        r113.add(r42.q());
        goto L24
    L27:
        r42.M();
        r42.N();
        goto L24
    L29:
        r42.f();
        goto L21
    L30:
        r42.e();
        r43.a("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + r113);
        r112 = r14;
        goto L138
    L31:
        long r39 = r18;
        r42.d();
    L33:
        if (r42.g() == false) goto L72;
        int r37 = r42.L(f22042b);
        if (r37 != 0) goto L36;
        r30 = new p.a(o.a(r42, r43, 1.0f, g.f22025a), 6);
        r14 = 0;
        goto L33
    L36:
        if (r37 != 1) goto L37;
        r42.b();
        if (r42.g() == false) goto L68;
        ko.r r40 = b.f22016a;
        r42.d();
        ja.d r41 = null;
    L42:
        if (r42.g() == false) goto L61;
        if (r42.L(b.f22016a) != 0) goto L45;
        r42.d();
        p.a r44 = null;
        p.b r114 = null;
        p.a r115 = null;
        p.b r116 = null;
    L48:
        if (r42.g() == false) goto L60;
        int r45 = r42.L(b.f22017b);
        if (r45 == 0) goto L59;
        if (r45 == 1) goto L58;
        if (r45 == r10) goto L57;
        if (r45 == r5) goto L56;
        r42.M();
        r42.N();
        goto L48
    L56:
        r114 = mn.h.n(r42, r43, true);
        goto L48
    L57:
        r116 = mn.h.n(r42, r43, true);
        goto L48
    L58:
        r115 = mn.h.m(r42, r43);
        goto L48
    L59:
        r44 = mn.h.m(r42, r43);
        goto L48
    L60:
        r42.f();
        r41 = new ja.d(r44, r115, r116, r114);
        goto L42
    L45:
        r42.M();
        r42.N();
        goto L42
    L61:
        r42.f();
        if (r41 != null) goto L65;
        r41 = new ja.d(null, null, null, null);
    L65:
        r31 = r41;
    L68:
        if (r42.g() == false) goto L70;
        r42.N();
        goto L68
    L70:
        r42.e();
        r14 = CharCompanionObject.MIN_VALUE;
        goto L33
    L37:
        r42.M();
        r42.N();
        goto L33
    L72:
        r42.f();
        r14 = r14;
        r18 = r39;
        r19 = false;
        goto L4
    L73:
        r112 = r14;
        r38 = r18;
        r42.b();
    L75:
        if (r42.g() == false) goto L79;
        q.b r46 = f.a(r42, r43);
        if (r46 == null) goto L75;
        r13.add(r46);
        goto L75
    L79:
        r42.e();
        goto L138
    L80:
        r112 = r14;
        r38 = r18;
        Mask$MaskMode r47 = null;
        r42.b();
    L82:
        if (r42.g() == false) goto L137;
        r42.d();
        Mask$MaskMode r48 = r47;
        Mask$MaskMode r117 = r48;
        p.a r118 = r117;
        boolean r49 = false;
        p.a r119 = r117;
    L85:
        if (r42.g() == false) goto L136;
        String r50 = r42.T();
        r50.getClass();
        switch(r50.hashCode()) {
            case 111: goto L102;
            case 3588: goto L98;
            case 104433: goto L94;
            case 3357091: goto L90;
            default: goto L88;
        };
    L88:
        byte r51 = -1;
    L105:
        switch(r51) {
            case 0: goto L134;
            case 1: goto L133;
            case 2: goto L132;
            case 3: goto L107;
            default: goto L106;
        };
    L106:
        r42.N();
    L135:
        r119 = r119;
        r118 = r118;
        goto L85
    L107:
        String r52 = r42.q();
        r52.getClass();
        switch(r52.hashCode()) {
            case 97: goto L123;
            case 105: goto L119;
            case 110: goto L115;
            case 115: goto L111;
            default: goto L109;
        };
    L109:
        byte r53 = -1;
    L126:
        switch(r53) {
            case 0: goto L131;
            case 1: goto L130;
            case 2: goto L129;
            case 3: goto L128;
            default: goto L127;
        };
    L127:
        u.b.b("Unknown mask mode " + r50 + ". Defaulting to Add.");
        r48 = Mask$MaskMode.MASK_MODE_ADD;
        goto L135
    L128:
        r48 = Mask$MaskMode.MASK_MODE_SUBTRACT;
        goto L135
    L129:
        r48 = Mask$MaskMode.MASK_MODE_NONE;
        goto L135
    L130:
        r43.a("Animation contains intersect masks. They are not supported but will be treated like add masks.");
        r48 = Mask$MaskMode.MASK_MODE_INTERSECT;
        goto L135
    L131:
        r48 = Mask$MaskMode.MASK_MODE_ADD;
        goto L135
    L111:
        if (r52.equals("s") == false) goto L109;
        r53 = 3;
        goto L126
    L115:
        if (r52.equals("n") == false) goto L109;
        r53 = 2;
        goto L126
    L119:
        if (r52.equals("i") == false) goto L109;
        r53 = 1;
        goto L126
    L123:
        if (r52.equals("a") == false) goto L109;
        r53 = 0;
        goto L126
    L132:
        r49 = r42.m();
        goto L135
    L133:
        r119 = new p.a(o.a(r42, r43, u.f.c(), v.f22051a), 5);
        goto L135
    L134:
        r118 = mn.h.o(r42, r43);
        goto L135
    L90:
        if (r50.equals("mode") == false) goto L88;
        r51 = 3;
        goto L105
    L94:
        if (r50.equals("inv") == false) goto L88;
        r51 = 2;
        goto L105
    L98:
        if (r50.equals("pt") == false) goto L88;
        r51 = 1;
        goto L105
    L102:
        if (r50.equals("o") == false) goto L88;
        r51 = 0;
        goto L105
    L136:
        r42.f();
        r12.add(new q.f(r48, r119, r118, r49));
        r47 = null;
        goto L82
    L137:
        r43.f1269n += r12.size();
        r42.e();
        goto L138
    L140:
        r112 = r14;
        r38 = r18;
        r32 = Layer$MatteType.values()[r42.p()];
        r43.f1269n++;
        goto L138
    L141:
        r22 = c.a(r42, r43);
        goto L139
    L142:
        r25 = Color.parseColor(r42.q());
        goto L139
    L143:
        r24 = (int) (u.f.c() * r42.p());
        goto L139
    L144:
        r23 = (int) (u.f.c() * r42.p());
        goto L139
    L145:
        r110 = r42.p();
        goto L139
    L146:
        r112 = r14;
        r38 = r18;
        int r54 = r42.p();
        r111 = Layer$LayerType.UNKNOWN;
        if (r54 >= r111.ordinal()) goto L138;
        r111 = Layer$LayerType.values()[r54];
        goto L138
    L149:
        r21 = r42.q();
        goto L139
    L150:
        r18 = r42.p();
        goto L139
    L151:
        r17 = r42.q();
        goto L139
    L152:
        long r310 = r18;
        r42.f();
        float r120 = r20 / r26;
        float r311 = r35 / r26;
        ArrayList r121 = new ArrayList();
        if (r120 <= 0.0f) goto L156;
        r121.add(new v.a(r43, r16, r16, null, 0.0f, Float.valueOf(r120)));
    L156:
        if (r311 > 0.0f) goto L159;
        r311 = r43.f1267l;
    L159:
        r121.add(new v.a(r43, r15, r15, null, r120, Float.valueOf(r311)));
        r121.add(new v.a(r43, r16, r16, null, r311, Float.valueOf(Float.MAX_VALUE)));
        if (r17.endsWith(".ai") == false) goto L162;
    L163:
        r43.a("Convert your Illustrator layers to shape layers.");
    L165:
        return new r.g(r13, r43, r17, r310, r111, r110, r21, r12, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r121, r32, r33, r34);
    L162:
        if ("ai".equals(r36) == false) goto L165;
        goto L163
    }
}
