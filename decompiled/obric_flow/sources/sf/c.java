package sf;

import android.content.Context;
import com.lynx.base.log.LynxLog;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.react.bridge.ReadableMap;
import com.ss.ttvideoengine.DataSource;
import g8.g;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends d {
    public final uf.a f;

    public c(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5);
        this.f = new uf.a(r5);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // sf.a
    public final void a(Map r29) {
        Intrinsics.checkNotNullParameter(r29, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r29, LynxResourceModule.PARAMS_KEY);
        int r5 = r29.size();
        float r10 = 1.0f;
        uf.a r11 = this.f;
        int r12 = 0;
        boolean r13 = false;
        Integer r14 = null;
        Float r15 = null;
        if (r5 == 1) goto L5;
    L34:
        Object r16 = r29.get("player-type");
        if ((r16 instanceof String) == false) goto L37;
        String r17 = (String) r16;
    L38:
        if (r17 != null) goto L40;
        r17 = "default";
    L40:
        String r18 = "";
        if (r29.containsKey("video_model") == false) goto L48;
        Object r19 = r29.get("video_model");
        if ((r19 instanceof String) == false) goto L45;
        String r110 = (String) r19;
    L46:
        this.f21896c = new pf.b(null, r110, null, null, null, null, null, 125);
    L89:
        pf.b r20 = this.f21896c;
        if (r20 == null) goto L184;
        boolean r111 = r29.containsKey("muted");
        pf.a r112 = r20.f21339n;
        if (r111 == false) goto L102;
        Object r21 = r29.get("muted");
        if ((r21 instanceof Boolean) == false) goto L96;
        Boolean r22 = (Boolean) r21;
    L97:
        if (r22 == null) goto L99;
        boolean r23 = r22.booleanValue();
    L100:
        r112.f21326a = r23;
        goto L102
    L99:
        r23 = false;
        goto L100
    L96:
        r22 = null;
    L102:
        if (r29.containsKey("loop") == false) goto L112;
        Object r24 = r29.get("loop");
        if ((r24 instanceof Boolean) == false) goto L106;
        Boolean r25 = (Boolean) r24;
    L107:
        if (r25 == null) goto L109;
        boolean r26 = r25.booleanValue();
    L110:
        r112.f21327b = r26;
        goto L112
    L109:
        r26 = false;
        goto L110
    L106:
        r25 = null;
    L112:
        if (r29.containsKey("inittime") == false) goto L122;
        Object r27 = r29.get("inittime");
        if ((r27 instanceof Integer) == false) goto L116;
        Integer r28 = (Integer) r27;
    L117:
        if (r28 == null) goto L119;
        int r30 = r28.intValue();
    L120:
        r20.f21338m = r30;
        goto L122
    L119:
        r30 = -1;
        goto L120
    L116:
        r28 = null;
    L122:
        if (r29.containsKey("headers") == false) goto L129;
        Object r31 = r29.get("headers");
        if ((r31 instanceof ReadableMap) == false) goto L126;
        ReadableMap r32 = (ReadableMap) r31;
    L127:
        r112.g = r32;
        goto L129
    L126:
        r32 = null;
    L129:
        if (r29.containsKey("experimental-props") == false) goto L136;
        Object r33 = r29.get("experimental-props");
        if ((r33 instanceof Map) == false) goto L133;
        Map r34 = (Map) r33;
    L134:
        r112.f21329h = r34;
        goto L136
    L133:
        r34 = null;
    L136:
        if (r29.containsKey("volume") == false) goto L146;
        Object r35 = r29.get("volume");
        if ((r35 instanceof Float) == false) goto L140;
        Float r36 = (Float) r35;
    L141:
        if (r36 == null) goto L143;
        float r37 = r36.floatValue();
    L144:
        r112.f21328c = r37;
        goto L146
    L143:
        r37 = -1.0f;
        goto L144
    L140:
        r36 = null;
    L146:
        if (r29.containsKey("speed") == false) goto L155;
        Object r38 = r29.get("speed");
        if ((r38 instanceof Float) == false) goto L150;
        Float r39 = (Float) r38;
    L151:
        if (r39 == null) goto L153;
        r10 = r39.floatValue();
    L153:
        r112.d = r10;
        goto L155
    L150:
        r39 = null;
    L155:
        if (r29.containsKey("tag") == false) goto L164;
        Object r40 = r29.get("tag");
        if ((r40 instanceof String) == false) goto L159;
        String r41 = (String) r40;
    L160:
        if (r41 != null) goto L162;
        r41 = "";
    L162:
        r20.f21336k = r41;
        goto L164
    L159:
        r41 = null;
    L164:
        if (r29.containsKey("sub_tag") == false) goto L174;
        Object r42 = r29.get("sub_tag");
        if ((r42 instanceof String) == false) goto L168;
        String r43 = (String) r42;
    L169:
        if (r43 == null) goto L172;
        r18 = r43;
    L172:
        r20.f21337l = r18;
        goto L174
    L168:
        r43 = null;
    L174:
        if (r29.containsKey("cache-size") == false) goto L182;
        Object r44 = r29.get("cache-size");
        if ((r44 instanceof Integer) == false) goto L178;
        r14 = (Integer) r44;
    L178:
        if (r14 == null) goto L180;
        r12 = r14.intValue();
    L180:
        r20.f21335j = r12;
    L182:
        if (r29.containsKey("progress_update_interval") == false) goto L184;
        boolean r45 = r29.get("progress_update_interval") instanceof Integer;
    L184:
        pf.b r46 = this.f21896c;
        if (r46 == null) goto L198;
        b r47 = new b(this, r17);
        if (r11.f22338a == r46) goto L193;
        of.e r48 = new of.e(r11.getContext(), r46);
        r11.f22339b = r48;
        r48.f = r47;
        DataSource r49 = r11.d;
        if (r49 == null) goto L192;
        r48.e = r49;
    L192:
        r11.f22338a = r46;
    L193:
        of.e r50 = r11.f22339b;
        if (r50 == null) goto L199;
        r50.f20561h = r11;
        return;
    L199:
        return;
    L198:
        return;
    L45:
        r110 = null;
        goto L46
    L48:
        if (r29.containsKey("video_id") == false) goto L63;
        Object r51 = r29.get("video_id");
        if ((r51 instanceof String) == false) goto L52;
        String r113 = (String) r51;
    L53:
        Object r52 = r29.get("token");
        if ((r52 instanceof String) == false) goto L56;
        String r114 = (String) r52;
    L57:
        Object r53 = r29.get("domain");
        if ((r53 instanceof String) == false) goto L60;
        String r115 = (String) r53;
    L61:
        this.f21896c = new pf.b(r113, null, r114, r115, null, null, null, 114);
        goto L89
    L60:
        r115 = null;
        goto L61
    L56:
        r114 = null;
        goto L57
    L52:
        r113 = null;
        goto L53
    L63:
        if (r29.containsKey("play_url") == false) goto L89;
        if (r29.containsKey("preload-key") == false) goto L71;
        Object r116 = r29.get("preload-key");
        if ((r116 instanceof String) == false) goto L69;
        String r117 = (String) r116;
    L70:
        if (r117 == null) goto L71;
        String r118 = r117;
    L73:
        Object r54 = r29.get("play_url");
        if ((r54 instanceof String) == false) goto L76;
        String r55 = (String) r54;
    L77:
        if (r55 != null) goto L79;
        r55 = "";
    L79:
        Intrinsics.checkNotNullParameter(r55, "url");
        if (StringsKt.P(r55, "http://") == true) goto L86;
        if (StringsKt.P(r55, "https://") == true) goto L86;
        this.f21896c = new pf.b(null, null, null, null, null, null, r55, 63);
    L86:
        if (r118.length() <= 0) goto L88;
        this.f21896c = new pf.b(null, null, null, null, r118, r55, null, 79);
        goto L89
    L88:
        this.f21896c = new pf.b(null, null, null, null, null, r55, null, 95);
        goto L89
    L76:
        r55 = null;
        goto L77
    L69:
        r117 = null;
    L71:
        r118 = "";
        goto L73
    L37:
        r17 = null;
        goto L38
    L5:
        if (j(r29) == false) goto L34;
        if (r29.containsKey("muted") == false) goto L17;
        Object r56 = r29.get("muted");
        if ((r56 instanceof Boolean) == false) goto L11;
        Boolean r57 = (Boolean) r56;
    L12:
        if (r57 == null) goto L14;
        boolean r58 = r57.booleanValue();
    L15:
        r11.setMute(r58);
        goto L17
    L14:
        r58 = false;
        goto L15
    L11:
        r57 = null;
    L17:
        if (r29.containsKey("loop") == false) goto L26;
        Object r59 = r29.get("loop");
        if ((r59 instanceof Boolean) == false) goto L21;
        Boolean r60 = (Boolean) r59;
    L22:
        if (r60 == null) goto L24;
        r13 = r60.booleanValue();
    L24:
        r11.setLoop(r13);
        goto L26
    L21:
        r60 = null;
    L26:
        if (r29.containsKey("speed") == false) goto L197;
        Object r61 = r29.get("speed");
        if ((r61 instanceof Float) == false) goto L30;
        r15 = (Float) r61;
    L30:
        if (r15 == null) goto L32;
        r10 = r15.floatValue();
    L32:
        r11.setSpeed(r10);
        return;
    }

    @Override // sf.a
    public final void b(g r5) {
        this.f.getClass();
        if (r5 == null) goto L6;
        r5.f(7, -1, "player is not prepared");
        return;
    }

    @Override // sf.a
    public final void c(g r5) {
        this.f.getClass();
        r5.f(7, -1, "player is not prepared");
    }

    @Override // sf.a
    public final void d(g r5) {
        r5.f(3, 0, "enterFullScreen not supported");
    }

    @Override // sf.a
    public final void e(com.bytedance.lynx.media.f r5) {
        Intrinsics.checkNotNullParameter(r5, "parentLayout");
    }

    @Override // sf.a
    public final void f(g r5) {
        r5.f(3, 0, "requestPortraitFullScreen not supported");
    }

    @Override // sf.a
    public final void g(g r5) {
        uf.a r10 = this.f;
        if (r10.c() == true) goto L6;
        LynxLog.b(2, "AudioMediaView", "Failed to trigger prepare due to not properly initialized");
    L11:
        if (r5 == null) goto L13;
        r5.f(0, 0, null);
    L13:
        LynxLog.b(2, "TTVideoEngineAudioPlayable", "Trigger prepare in MediaPlayable instance");
        return;
    L6:
        if (r10.e == false) goto L8;
        LynxLog.b(2, "AudioMediaView", "Failed to trigger prepare due to already called");
        goto L11
    L8:
        r10.f22339b.f();
        LynxLog.b(2, "AudioMediaView", "Did trigger VideoController prepare in AudioMediaView");
        if (r10.e == true) goto L11;
        r10.e = true;
        goto L11
    }

    @Override // sf.a
    public final void h(g r5) {
        r5.f(3, 0, "exitFullScreen not supported");
    }

    @Override // sf.a
    public final void a() {
        uf.a r5 = this.f;
        Intrinsics.checkNotNullParameter(r5, "delegate");
        this.f21895b = r5;
    }
}
