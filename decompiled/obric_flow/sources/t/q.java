package t;

import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import androidx.room.jarjarred.org.antlr.v4.analysis.LeftRecursiveRuleTransformer;
import com.airbnb.lottie.model.layer.Layer$LayerType;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ko.r f22044a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ko.r f22045b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ko.r f22046c = null;
    public static final ko.r d = null;

    static {
        f22044a = ko.r.r(new String[]{"w", "h", "ip", "op", "fr", "v", "layers", "assets", "fonts", "chars", "markers"});
        f22045b = ko.r.r(new String[]{"id", "layers", "w", "h", LeftRecursiveRuleTransformer.PRECEDENCE_OPTION_NAME, "u"});
        f22046c = ko.r.r(new String[]{"list"});
        d = ko.r.r(new String[]{"cm", "tm", "dr"});
    }

    public static com.airbnb.lottie.h a(com.airbnb.lottie.parser.moshi.b r30) {
        float r5 = u.f.c();
        LongSparseArray r10 = new LongSparseArray();
        ArrayList r11 = new ArrayList();
        HashMap r12 = new HashMap();
        HashMap r13 = new HashMap();
        HashMap r14 = new HashMap();
        ArrayList r15 = new ArrayList();
        SparseArrayCompat r16 = new SparseArrayCompat();
        com.airbnb.lottie.h r17 = new com.airbnb.lottie.h();
        r30.d();
        float r18 = 0.0f;
        int r19 = 0;
        int r110 = 0;
        float r111 = 0.0f;
        float r112 = 0.0f;
    L4:
        if (r30.g() == false) goto L165;
        switch(r30.L(f22044a)) {
            case 0: goto L164;
            case 1: goto L163;
            case 2: goto L162;
            case 3: goto L161;
            case 4: goto L158;
            case 5: goto L145;
            case 6: goto L135;
            case 7: goto L98;
            case 8: goto L69;
            case 9: goto L31;
            case 10: goto L9;
            default: goto L7;
        };
    L158:
        r112 = (float) r30.n();
    L159:
        r5 = r5;
    L160:
        r14 = r14;
        goto L4
    L161:
        r18 = ((float) r30.n()) - 0.01f;
        goto L159
    L162:
        r111 = (float) r30.n();
        goto L159
    L163:
        r14 = r14;
        r110 = r30.p();
        goto L160
    L164:
        r14 = r14;
        r19 = r30.p();
        goto L160
    L7:
        r30.M();
        r30.N();
        r5 = r5;
        r14 = r14;
        ArrayList r21 = r15;
        SparseArrayCompat r24 = r16;
        float r22 = r18;
        int r25 = r110;
        float r20 = r111;
    L157:
        r5 = r5;
        r111 = r20;
        r15 = r21;
        r18 = r22;
        r14 = r14;
        r16 = r24;
        r110 = r25;
        goto L4
    L9:
        r30.b();
    L11:
        if (r30.g() == false) goto L28;
        r30.d();
        String r113 = null;
        float r23 = 0.0f;
        float r26 = 0.0f;
    L14:
        if (r30.g() == false) goto L27;
        int r27 = r30.L(d);
        if (r27 == 0) goto L26;
        float r28 = r18;
        if (r27 == 1) goto L25;
        if (r27 != 2) goto L21;
        r111 = r111;
        r26 = (float) r30.n();
    L24:
        r18 = r28;
        r110 = r110;
        goto L14
    L21:
        r30.M();
        r30.N();
    L22:
        r18 = r28;
        goto L14
    L25:
        r111 = r111;
        r23 = (float) r30.n();
        goto L24
    L26:
        r28 = r18;
        r113 = r30.q();
        goto L22
    L27:
        float r29 = r18;
        r30.f();
        r15.add(new o.h(r113, r23, r26));
        r110 = r110;
        r111 = r111;
        r18 = r29;
        goto L11
    L28:
        r22 = r18;
        int r31 = r110;
        r20 = r111;
        r30.e();
    L29:
        r25 = r31;
        r21 = r15;
    L30:
        r24 = r16;
        goto L157
    L31:
        r22 = r18;
        r31 = r110;
        r20 = r111;
        r30.b();
    L33:
        if (r30.g() == false) goto L68;
        ko.r r114 = h.f22027a;
        ArrayList r115 = new ArrayList();
        r30.d();
        double r210 = 0.0d;
        String r211 = null;
        String r212 = null;
        char r213 = 0;
    L36:
        if (r30.g() == false) goto L67;
        int r116 = r30.L(h.f22027a);
        if (r116 != 0) goto L40;
        r213 = r30.q().charAt(0);
        goto L36
    L40:
        if (r116 != 1) goto L42;
        r30.n();
        goto L36
    L42:
        if (r116 != 2) goto L44;
        r210 = r30.n();
        goto L36
    L44:
        if (r116 != 3) goto L46;
        r211 = r30.q();
        goto L36
    L46:
        if (r116 != 4) goto L48;
        r212 = r30.q();
        goto L36
    L48:
        if (r116 != 5) goto L49;
        r30.d();
    L52:
        if (r30.g() == false) goto L61;
        if (r30.L(h.f22028b) != 0) goto L55;
        r30.b();
    L58:
        if (r30.g() == false) goto L60;
        r115.add((q.l) f.a(r30, r17));
        goto L58
    L60:
        r30.e();
        goto L52
    L55:
        r30.M();
        r30.N();
        goto L52
    L61:
        r30.f();
        goto L36
    L49:
        r30.M();
        r30.N();
        goto L36
    L67:
        r30.f();
        o.d r117 = new o.d(r115, r213, r210, r211, r212);
        r16.put(r117.hashCode(), r117);
        goto L33
    L68:
        r30.e();
        goto L29
    L69:
        r22 = r18;
        int r32 = r110;
        r20 = r111;
        r30.d();
    L71:
        if (r30.g() == false) goto L97;
        if (r30.L(f22046c) != 0) goto L74;
        r30.b();
    L77:
        if (r30.g() == false) goto L96;
        ko.r r118 = i.f22029a;
        r30.d();
        String r119 = null;
        String r120 = null;
        String r121 = null;
    L80:
        if (r30.g() == false) goto L95;
        int r122 = r30.L(i.f22029a);
        if (r122 != 0) goto L83;
        r119 = r30.q();
        goto L80
    L83:
        ArrayList r214 = r15;
        if (r122 != 1) goto L86;
        r120 = r30.q();
    L90:
        r15 = r214;
        goto L80
    L86:
        if (r122 != 2) goto L88;
        r121 = r30.q();
        goto L90
    L88:
        if (r122 == 3) goto L91;
        r30.M();
        r30.N();
        goto L90
    L91:
        r30.n();
        goto L90
    L95:
        r30.f();
        r14.put(r120, new o.c(r119, r120, r121));
        r15 = r15;
        goto L77
    L96:
        r30.e();
        goto L71
    L74:
        r30.M();
        r30.N();
        goto L71
    L97:
        r21 = r15;
        r30.f();
        r25 = r32;
        goto L30
    L98:
        r21 = r15;
        r22 = r18;
        int r33 = r110;
        r20 = r111;
        r30.b();
    L100:
        if (r30.g() == false) goto L134;
        ArrayList r34 = new ArrayList();
        LongSparseArray r123 = new LongSparseArray();
        r30.d();
        HashMap r215 = r14;
        String r35 = null;
        String r124 = null;
        int r125 = 0;
        int r126 = 0;
    L103:
        if (r30.g() == false) goto L129;
        r16 = r16;
        int r36 = r30.L(f22045b);
        if (r36 != 0) goto L106;
        r35 = r30.q();
        goto L103
    L106:
        int r216 = r33;
        if (r36 != 1) goto L109;
        r30.b();
    L124:
        if (r30.g() == false) goto L126;
        r.g r37 = p.a(r30, r17);
        r123.put(r37.d, r37);
        r34.add(r37);
        r5 = r5;
        goto L124
    L126:
        float r127 = r5;
        r30.e();
    L127:
        r5 = r127;
    L118:
        r33 = r216;
        goto L103
    L109:
        if (r36 != 2) goto L111;
        r125 = r30.p();
        goto L118
    L111:
        if (r36 != 3) goto L113;
        r126 = r30.p();
        goto L118
    L113:
        if (r36 != 4) goto L115;
        r124 = r30.q();
        goto L118
    L115:
        if (r36 == 5) goto L117;
        r30.M();
        r30.N();
        r127 = r5;
        goto L127
    L117:
        r30.q();
        goto L118
    L129:
        int r217 = r33;
        float r128 = r5;
        SparseArrayCompat r218 = r16;
        r30.f();
        if (r124 == null) goto L132;
        r13.put(r35, new com.airbnb.lottie.x(r125, r126, r35, r124));
    L133:
        r5 = r128;
        r14 = r215;
        r16 = r218;
        r33 = r217;
        goto L100
    L132:
        r12.put(r35, r34);
        goto L133
    L134:
        r25 = r33;
        r5 = r5;
        r14 = r14;
        r24 = r16;
        r30.e();
        goto L157
    L135:
        r5 = r5;
        r14 = r14;
        r21 = r15;
        r24 = r16;
        r22 = r18;
        r25 = r110;
        r20 = r111;
        r30.b();
        int r38 = 0;
    L137:
        if (r30.g() == false) goto L144;
        r.g r39 = p.a(r30, r17);
        if (r39.e != Layer$LayerType.IMAGE) goto L141;
        r38 = r38 + 1;
    L141:
        r11.add(r39);
        r10.put(r39.d, r39);
        if (r38 <= 4) goto L137;
        u.b.b("You have " + r38 + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
        goto L137
    L144:
        r30.e();
        goto L157
    L145:
        r5 = r5;
        r14 = r14;
        r21 = r15;
        r24 = r16;
        r22 = r18;
        r25 = r110;
        r20 = r111;
        String[] r40 = r30.q().split("\\.");
        int r41 = Integer.parseInt(r40[0]);
        int r42 = Integer.parseInt(r40[1]);
        int r43 = Integer.parseInt(r40[2]);
        if (r41 < 4) goto L156;
        if (r41 > 4) goto L157;
        if (r42 < 4) goto L156;
        if (r42 > 4) goto L157;
        if (r43 >= 0) goto L157;
    L156:
        r17.a("Lottie only supports bodymovin >= 4.4.0");
        goto L157
    L165:
        float r129 = r5;
        r17.f1265j = new Rect(0, 0, (int) (r19 * r129), (int) (r110 * r129));
        r17.f1266k = r111;
        r17.f1267l = r18;
        r17.f1268m = r112;
        r17.f1264i = r11;
        r17.f1263h = r10;
        r17.f1262c = r12;
        r17.d = r13;
        r17.g = r16;
        r17.e = r14;
        r17.f = r15;
        return r17;
    }
}
