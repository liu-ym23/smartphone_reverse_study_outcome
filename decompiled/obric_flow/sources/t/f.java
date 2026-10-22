package t;

import android.graphics.Path;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.content.MergePaths$MergePathsMode;
import com.airbnb.lottie.model.content.PolystarShape$Type;
import com.airbnb.lottie.model.content.ShapeStroke$LineCapType;
import com.airbnb.lottie.model.content.ShapeStroke$LineJoinType;
import com.airbnb.lottie.model.content.ShapeTrimPath$Type;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ko.r f22024a = null;

    static {
        f22024a = ko.r.r(new String[]{"ty", "d"});
    }

    public static q.b a(com.airbnb.lottie.parser.moshi.b r32, com.airbnb.lottie.h r33) {
        boolean r10 = false;
        int r11 = 0;
        boolean r12 = false;
        r32.d();
        int r13 = 2;
    L3:
        String r14 = null;
        q.b r15 = null;
        String r16 = null;
        String r17 = null;
        if (r32.g() == false) goto L11;
        int r18 = r32.L(f22024a);
        if (r18 == 0) goto L10;
        if (r18 != 1) goto L8;
        r13 = r32.p();
        goto L3
    L8:
        r32.M();
        r32.N();
        goto L3
    L10:
        String r19 = r32.q();
    L12:
        if (r19 != null) goto L15;
        return null;
    L15:
        switch(r19.hashCode()) {
            case 3239: goto L66;
            case 3270: goto L62;
            case 3295: goto L58;
            case 3307: goto L54;
            case 3308: goto L50;
            case 3488: goto L46;
            case 3633: goto L42;
            case 3646: goto L38;
            case 3669: goto L34;
            case 3679: goto L30;
            case 3681: goto L26;
            case 3705: goto L22;
            case 3710: goto L18;
            default: goto L16;
        };
    L16:
        byte r20 = -1;
    L69:
        switch(r20) {
            case 0: goto L341;
            case 1: goto L319;
            case 2: goto L287;
            case 3: goto L269;
            case 4: goto L215;
            case 5: goto L203;
            case 6: goto L187;
            case 7: goto L171;
            case 8: goto L156;
            case 9: goto L139;
            case 10: goto L90;
            case 11: goto L72;
            case 12: goto L71;
            default: goto L70;
        };
    L70:
        u.b.b("Unknown shape type ".concat(r19));
    L365:
        if (r32.g() == false) goto L367;
        r32.N();
        goto L365
    L367:
        r32.f();
        return r15;
    L71:
        r15 = c.a(r32, r33);
        goto L365
    L72:
        ko.r r5 = a0.f22015a;
        boolean r21 = false;
        String r110 = null;
        ShapeTrimPath$Type r111 = null;
        p.b r112 = null;
        p.b r113 = null;
        p.b r22 = null;
    L74:
        if (r32.g() == false) goto L89;
        int r23 = r32.L(a0.f22015a);
        if (r23 != 0) goto L77;
        r112 = mn.h.n(r32, r33, false);
        goto L74
    L77:
        if (r23 != 1) goto L78;
        r113 = mn.h.n(r32, r33, false);
        goto L74
    L78:
        if (r23 != 2) goto L79;
        r22 = mn.h.n(r32, r33, false);
        goto L74
    L79:
        if (r23 != 3) goto L80;
        r110 = r32.q();
        goto L74
    L80:
        if (r23 != 4) goto L81;
        r111 = ShapeTrimPath$Type.forId(r32.p());
        goto L74
    L81:
        if (r23 != 5) goto L82;
        r21 = r32.m();
        goto L74
    L82:
        r32.N();
        goto L74
    L89:
        r15 = new q.i(r110, r111, r112, r113, r22, r21);
        goto L365
    L90:
        ko.r r24 = z.f22056a;
        ArrayList r25 = new ArrayList();
        boolean r28 = false;
        String r114 = null;
        p.b r26 = null;
        p.a r27 = null;
        p.a r29 = null;
        p.b r210 = null;
        ShapeStroke$LineCapType r211 = null;
        ShapeStroke$LineJoinType r212 = null;
        float r213 = 0.0f;
    L92:
        if (r32.g() == false) goto L138;
        switch(r32.L(z.f22056a)) {
            case 0: goto L137;
            case 1: goto L136;
            case 2: goto L135;
            case 3: goto L134;
            case 4: goto L133;
            case 5: goto L132;
            case 6: goto L131;
            case 7: goto L130;
            case 8: goto L96;
            default: goto L95;
        };
    L96:
        r32.b();
    L98:
        if (r32.g() == false) goto L127;
        r32.d();
        String r30 = null;
        p.b r31 = null;
    L101:
        if (r32.g() == false) goto L108;
        int r34 = r32.L(z.f22057b);
        if (r34 != 0) goto L104;
        r30 = r32.q();
        goto L101
    L104:
        if (r34 != 1) goto L105;
        r31 = mn.h.n(r32, r33, true);
        goto L101
    L105:
        r32.M();
        r32.N();
        goto L101
    L108:
        r32.f();
        r30.getClass();
        switch(r30.hashCode()) {
            case 100: goto L120;
            case 103: goto L116;
            case 111: goto L112;
            default: goto L110;
        };
    L110:
        byte r35 = -1;
    L123:
        switch(r35) {
            case 0: goto L126;
            case 1: goto L126;
            case 2: goto L125;
            default: goto L98;
        };
    L125:
        r26 = r31;
        goto L98
    L126:
        r33.getClass();
        r25.add(r31);
        goto L98
    L112:
        if (r30.equals("o") == false) goto L110;
        r35 = 2;
        goto L123
    L116:
        if (r30.equals("g") == false) goto L110;
        r35 = 1;
        goto L123
    L120:
        if (r30.equals("d") == false) goto L110;
        r35 = 0;
        goto L123
    L127:
        r32.e();
        if (r25.size() != 1) goto L92;
        r25.add(r25.get(0));
        goto L92
    L130:
        r28 = r32.m();
        goto L92
    L131:
        r213 = (float) r32.n();
        goto L92
    L132:
        r212 = ShapeStroke$LineJoinType.values()[r32.p() - 1];
        goto L92
    L133:
        r211 = ShapeStroke$LineCapType.values()[r32.p() - 1];
        goto L92
    L134:
        r29 = mn.h.o(r32, r33);
        goto L92
    L135:
        r210 = mn.h.n(r32, r33, true);
        goto L92
    L136:
        r27 = mn.h.m(r32, r33);
        goto L92
    L137:
        r114 = r32.q();
        goto L92
    L95:
        r32.N();
        goto L92
    L138:
        r15 = new q.o(r114, r26, r25, r27, r29, r210, r211, r212, r213, r28);
        goto L365
    L139:
        ko.r r36 = s.f22048a;
        boolean r214 = false;
        String r115 = null;
        PolystarShape$Type r116 = null;
        p.b r117 = null;
        p.e r118 = null;
        p.b r215 = null;
        p.b r216 = null;
        p.b r217 = null;
        p.b r218 = null;
        p.b r219 = null;
    L141:
        if (r32.g() == false) goto L155;
        switch(r32.L(s.f22048a)) {
            case 0: goto L154;
            case 1: goto L153;
            case 2: goto L152;
            case 3: goto L151;
            case 4: goto L150;
            case 5: goto L149;
            case 6: goto L148;
            case 7: goto L147;
            case 8: goto L146;
            case 9: goto L145;
            default: goto L144;
        };
    L145:
        r214 = r32.m();
        goto L141
    L146:
        r218 = mn.h.n(r32, r33, false);
        goto L141
    L147:
        r216 = mn.h.n(r32, r33, true);
        goto L141
    L148:
        r219 = mn.h.n(r32, r33, false);
        goto L141
    L149:
        r217 = mn.h.n(r32, r33, true);
        goto L141
    L150:
        r215 = mn.h.n(r32, r33, false);
        goto L141
    L151:
        r118 = a.b(r32, r33);
        goto L141
    L152:
        r117 = mn.h.n(r32, r33, false);
        goto L141
    L153:
        r116 = PolystarShape$Type.forValue(r32.p());
        goto L141
    L154:
        r115 = r32.q();
        goto L141
    L144:
        r32.M();
        r32.N();
        goto L141
    L155:
        r15 = new q.h(r115, r116, r117, r118, r215, r216, r217, r218, r219, r214);
        goto L365
    L156:
        ko.r r37 = y.f22055a;
        boolean r38 = false;
        p.a r39 = null;
    L158:
        if (r32.g() == false) goto L169;
        int r40 = r32.L(y.f22055a);
        if (r40 != 0) goto L161;
        r16 = r32.q();
        goto L158
    L161:
        if (r40 != 1) goto L162;
        r11 = r32.p();
        goto L158
    L162:
        if (r40 != 2) goto L163;
        r39 = new p.a(o.a(r32, r33, u.f.c(), v.f22051a), 5);
        goto L158
    L163:
        if (r40 != 3) goto L164;
        r38 = r32.m();
        goto L158
    L164:
        r32.N();
        goto L158
    L169:
        q.b r41 = new q.m(r16, r11, r39, r38);
    L170:
        r15 = r41;
        goto L365
    L171:
        ko.r r42 = u.f22050a;
        boolean r220 = false;
        String r119 = null;
        p.b r120 = null;
        p.b r121 = null;
        p.d r122 = null;
    L173:
        if (r32.g() == false) goto L186;
        int r43 = r32.L(u.f22050a);
        if (r43 != 0) goto L176;
        r119 = r32.q();
        goto L173
    L176:
        if (r43 != 1) goto L177;
        r120 = mn.h.n(r32, r33, false);
        goto L173
    L177:
        if (r43 != 2) goto L178;
        r121 = mn.h.n(r32, r33, false);
        goto L173
    L178:
        if (r43 != 3) goto L179;
        r122 = c.a(r32, r33);
        goto L173
    L179:
        if (r43 != 4) goto L180;
        r220 = r32.m();
        goto L173
    L180:
        r32.N();
        goto L173
    L186:
        r15 = new q.i(r119, r120, r121, r122, r220);
        goto L365
    L187:
        ko.r r44 = t.f22049a;
        boolean r221 = false;
        String r123 = null;
        p.e r124 = null;
        p.a r125 = null;
        p.b r126 = null;
    L189:
        if (r32.g() == false) goto L202;
        int r45 = r32.L(t.f22049a);
        if (r45 != 0) goto L192;
        r123 = r32.q();
        goto L189
    L192:
        if (r45 != 1) goto L193;
        r124 = a.b(r32, r33);
        goto L189
    L193:
        if (r45 != 2) goto L194;
        r125 = mn.h.p(r32, r33);
        goto L189
    L194:
        if (r45 != 3) goto L195;
        r126 = mn.h.n(r32, r33, true);
        goto L189
    L195:
        if (r45 != 4) goto L196;
        r221 = r32.m();
        goto L189
    L196:
        r32.N();
        goto L189
    L202:
        r15 = new q.i(r123, r124, r125, r126, r221);
        goto L365
    L203:
        ko.r r46 = r.f22047a;
        MergePaths$MergePathsMode r47 = null;
    L205:
        if (r32.g() == false) goto L214;
        int r48 = r32.L(r.f22047a);
        if (r48 != 0) goto L208;
        r17 = r32.q();
        goto L205
    L208:
        if (r48 != 1) goto L209;
        r47 = MergePaths$MergePathsMode.forId(r32.p());
        goto L205
    L209:
        if (r48 != 2) goto L210;
        r12 = r32.m();
        goto L205
    L210:
        r32.M();
        r32.N();
        goto L205
    L214:
        q.g r49 = new q.g(r17, r47, r12);
        r33.a("Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove().");
        r15 = r49;
        goto L365
    L215:
        ko.r r50 = k.f22032a;
        ArrayList r51 = new ArrayList();
        boolean r310 = false;
        String r127 = null;
        GradientType r222 = null;
        p.a r223 = null;
        p.a r224 = null;
        p.a r225 = null;
        p.a r226 = null;
        p.b r227 = null;
        ShapeStroke$LineCapType r228 = null;
        ShapeStroke$LineJoinType r229 = null;
        p.b r311 = null;
        float r230 = 0.0f;
    L217:
        if (r32.g() == false) goto L268;
        switch(r32.L(k.f22032a)) {
            case 0: goto L267;
            case 1: goto L257;
            case 2: goto L256;
            case 3: goto L252;
            case 4: goto L250;
            case 5: goto L249;
            case 6: goto L248;
            case 7: goto L247;
            case 8: goto L246;
            case 9: goto L245;
            case 10: goto L244;
            case 11: goto L221;
            default: goto L220;
        };
    L221:
        r32.b();
    L223:
        if (r32.g() == false) goto L241;
        r32.d();
        String r52 = null;
        p.b r53 = null;
    L226:
        if (r32.g() == false) goto L233;
        int r54 = r32.L(k.f22034c);
        if (r54 != 0) goto L229;
        r52 = r32.q();
        goto L226
    L229:
        if (r54 != 1) goto L230;
        r53 = mn.h.n(r32, r33, true);
        goto L226
    L230:
        r32.M();
        r32.N();
        goto L226
    L233:
        r32.f();
        if (r52.equals("o") == true) goto L235;
        if (r52.equals("d") == true) goto L240;
        if (r52.equals("g") == false) goto L223;
    L240:
        r33.getClass();
        r51.add(r53);
        goto L223
    L235:
        r311 = r53;
        goto L223
    L241:
        r32.e();
        if (r51.size() != 1) goto L217;
        r51.add(r51.get(0));
        goto L217
    L244:
        r310 = r32.m();
        goto L217
    L245:
        r230 = (float) r32.n();
        goto L217
    L246:
        r229 = ShapeStroke$LineJoinType.values()[r32.p() - 1];
        goto L217
    L247:
        r228 = ShapeStroke$LineCapType.values()[r32.p() - 1];
        goto L217
    L248:
        r227 = mn.h.n(r32, r33, true);
        goto L217
    L249:
        r226 = mn.h.p(r32, r33);
        goto L217
    L250:
        r225 = mn.h.p(r32, r33);
        goto L217
    L252:
        if (r32.p() != 1) goto L255;
        GradientType r55 = GradientType.LINEAR;
    L254:
        r222 = r55;
        goto L217
    L255:
        r55 = GradientType.RADIAL;
        goto L254
    L256:
        r224 = mn.h.o(r32, r33);
        goto L217
    L257:
        r32.d();
        int r56 = -1;
    L259:
        if (r32.g() == false) goto L266;
        int r57 = r32.L(k.f22033b);
        if (r57 != 0) goto L262;
        r56 = r32.p();
        goto L259
    L262:
        if (r57 != 1) goto L263;
        com.bytedance.crash.upload.k r58 = new com.bytedance.crash.upload.k();
        r58.f4136a = r56;
        r223 = new p.a(o.a(r32, r33, 1.0f, r58), 1);
        goto L259
    L263:
        r32.M();
        r32.N();
        goto L259
    L266:
        r32.f();
        goto L217
    L267:
        r127 = r32.q();
        goto L217
    L220:
        r32.M();
        r32.N();
        goto L217
    L268:
        r15 = new q.e(r127, r222, r223, r224, r225, r226, r227, r228, r229, r230, r51, r311, r310);
        goto L365
    L269:
        ko.r r59 = x.f22054a;
        ArrayList r60 = new ArrayList();
    L271:
        if (r32.g() == false) goto L286;
        int r61 = r32.L(x.f22054a);
        if (r61 != 0) goto L274;
        r14 = r32.q();
        goto L271
    L274:
        if (r61 != 1) goto L275;
        r10 = r32.m();
        goto L271
    L275:
        if (r61 != 2) goto L276;
        r32.b();
    L279:
        if (r32.g() == false) goto L283;
        q.b r62 = a(r32, r33);
        if (r62 == null) goto L279;
        r60.add(r62);
        goto L279
    L283:
        r32.e();
        goto L271
    L276:
        r32.N();
        goto L271
    L286:
        r41 = new q.l(r14, r10, r60);
        goto L170
    L287:
        ko.r r63 = j.f22030a;
        Path.FillType r231 = Path.FillType.WINDING;
        boolean r232 = false;
        String r128 = null;
        GradientType r233 = null;
        p.a r234 = null;
        p.a r235 = null;
        p.a r236 = null;
        p.a r237 = null;
    L289:
        if (r32.g() == false) goto L318;
        switch(r32.L(j.f22030a)) {
            case 0: goto L317;
            case 1: goto L307;
            case 2: goto L306;
            case 3: goto L302;
            case 4: goto L300;
            case 5: goto L299;
            case 6: goto L295;
            case 7: goto L293;
            default: goto L292;
        };
    L293:
        r232 = r32.m();
        goto L289
    L295:
        if (r32.p() != 1) goto L298;
        Path.FillType r64 = Path.FillType.WINDING;
    L297:
        r231 = r64;
        goto L289
    L298:
        r64 = Path.FillType.EVEN_ODD;
        goto L297
    L299:
        r237 = mn.h.p(r32, r33);
        goto L289
    L300:
        r236 = mn.h.p(r32, r33);
        goto L289
    L302:
        if (r32.p() != 1) goto L305;
        GradientType r65 = GradientType.LINEAR;
    L304:
        r233 = r65;
        goto L289
    L305:
        r65 = GradientType.RADIAL;
        goto L304
    L306:
        r235 = mn.h.o(r32, r33);
        goto L289
    L307:
        r32.d();
        int r66 = -1;
    L309:
        if (r32.g() == false) goto L316;
        int r67 = r32.L(j.f22031b);
        if (r67 != 0) goto L312;
        r66 = r32.p();
        goto L309
    L312:
        if (r67 != 1) goto L313;
        com.bytedance.crash.upload.k r68 = new com.bytedance.crash.upload.k();
        r68.f4136a = r66;
        r234 = new p.a(o.a(r32, r33, 1.0f, r68), 1);
        goto L309
    L313:
        r32.M();
        r32.N();
        goto L309
    L316:
        r32.f();
        goto L289
    L317:
        r128 = r32.q();
        goto L289
    L292:
        r32.M();
        r32.N();
        goto L289
    L318:
        r15 = new q.d(r128, r233, r231, r234, r235, r236, r237, r232);
        goto L365
    L319:
        ko.r r69 = w.f22053a;
        boolean r129 = false;
        boolean r238 = false;
        int r70 = 1;
        String r130 = null;
        p.a r131 = null;
        p.a r239 = null;
    L321:
        if (r32.g() == false) goto L336;
        int r71 = r32.L(w.f22053a);
        if (r71 != 0) goto L324;
        r130 = r32.q();
        goto L321
    L324:
        if (r71 != 1) goto L325;
        r131 = mn.h.m(r32, r33);
        goto L321
    L325:
        if (r71 != 2) goto L326;
        r239 = mn.h.o(r32, r33);
        goto L321
    L326:
        if (r71 != 3) goto L327;
        r129 = r32.m();
        goto L321
    L327:
        if (r71 != 4) goto L328;
        r70 = r32.p();
        goto L321
    L328:
        if (r71 != 5) goto L329;
        r238 = r32.m();
        goto L321
    L329:
        r32.M();
        r32.N();
        goto L321
    L336:
        if (r70 != 1) goto L339;
        Path.FillType r72 = Path.FillType.WINDING;
    L340:
        r15 = new q.k(r130, r129, r72, r131, r239, r238);
        goto L365
    L339:
        r72 = Path.FillType.EVEN_ODD;
        goto L340
    L341:
        ko.r r73 = d.f22020a;
        if (r13 != 3) goto L344;
        boolean r74 = true;
    L345:
        boolean r132 = r74;
        boolean r240 = false;
        String r133 = null;
        p.e r134 = null;
        p.a r135 = null;
    L347:
        if (r32.g() == false) goto L363;
        int r75 = r32.L(d.f22020a);
        if (r75 != 0) goto L350;
        r133 = r32.q();
        goto L347
    L350:
        if (r75 != 1) goto L351;
        r134 = a.b(r32, r33);
        goto L347
    L351:
        if (r75 != 2) goto L352;
        r135 = mn.h.p(r32, r33);
        goto L347
    L352:
        if (r75 != 3) goto L353;
        r240 = r32.m();
        goto L347
    L353:
        if (r75 != 4) goto L354;
        if (r32.p() == 3) goto L357;
        r132 = false;
        goto L347
    L357:
        r132 = true;
        goto L347
    L354:
        r32.M();
        r32.N();
        goto L347
    L363:
        r15 = new q.a(r133, r134, r135, r132, r240);
        goto L365
    L344:
        r74 = false;
        goto L345
    L18:
        if (r19.equals("tr") == false) goto L16;
        r20 = 12;
        goto L69
    L22:
        if (r19.equals("tm") == false) goto L16;
        r20 = 11;
        goto L69
    L26:
        if (r19.equals("st") == false) goto L16;
        r20 = 10;
        goto L69
    L30:
        if (r19.equals("sr") == false) goto L16;
        r20 = 9;
        goto L69
    L34:
        if (r19.equals("sh") == false) goto L16;
        r20 = 8;
        goto L69
    L38:
        if (r19.equals("rp") == false) goto L16;
        r20 = 7;
        goto L69
    L42:
        if (r19.equals("rc") == false) goto L16;
        r20 = 6;
        goto L69
    L46:
        if (r19.equals("mm") == false) goto L16;
        r20 = 5;
        goto L69
    L50:
        if (r19.equals("gs") == false) goto L16;
        r20 = 4;
        goto L69
    L54:
        if (r19.equals("gr") == false) goto L16;
        r20 = 3;
        goto L69
    L58:
        if (r19.equals("gf") == false) goto L16;
        r20 = 2;
        goto L69
    L62:
        if (r19.equals("fl") == false) goto L16;
        r20 = 1;
        goto L69
    L66:
        if (r19.equals("el") == false) goto L16;
        r20 = 0;
        goto L69
    L11:
        r19 = null;
        goto L12
    }
}
