package sf;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.text.TextUtils;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.lynx.base.log.LynxLog;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.react.bridge.ReadableMap;
import com.ss.ttvideoengine.DataSource;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.model.VideoRef;
import g8.g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends d implements of.a {
    public final uf.e f;
    public FrameLayout g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ViewGroup f21897h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f21898i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Integer f21899j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Integer f21900k;

    public f(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5);
        this.f = new uf.e(r5);
    }

    public static Activity l(Context r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        if (Activity.class.isInstance(r5) == false) goto L10;
        return (Activity) r5;
    L10:
        if (ContextWrapper.class.isInstance(r5) == true) goto L12;
        return null;
    L12:
        return l(((ContextWrapper) r5).getBaseContext());
    }

    public static Resolution m(String r5) {
        Resolution[] r10 = Resolution.values();
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L9;
        Resolution r13 = r10[r12];
        if (TextUtils.equals(r5, r13.toString(VideoRef.TYPE_VIDEO)) == true) goto L6;
        r12 = r12 + 1;
        goto L3
    L6:
        return r13;
    L9:
        return Resolution.Standard;
    }

    @Override // sf.a
    public final void a(Map r35) {
        Intrinsics.checkNotNullParameter(r35, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r35, LynxResourceModule.PARAMS_KEY);
        int r5 = r35.size();
        String r10 = "auto";
        uf.e r11 = this.f;
        if (r5 == 1) goto L5;
    L47:
        Object r12 = r35.get("player-type");
        if ((r12 instanceof String) == false) goto L50;
        String r13 = (String) r12;
    L51:
        if (r13 != null) goto L53;
        r13 = "default";
    L53:
        String r15 = "";
        if (r35.containsKey("video_model") == false) goto L61;
        Object r14 = r35.get("video_model");
        if ((r14 instanceof String) == false) goto L58;
        String r18 = (String) r14;
    L59:
        this.f21896c = new pf.b(null, r18, null, null, null, null, null, 125);
    L102:
        pf.b r16 = this.f21896c;
        if (r16 == null) goto L230;
        boolean r19 = r35.containsKey("muted");
        pf.a r17 = r16.f21339n;
        if (r19 == false) goto L116;
        Object r20 = r35.get("muted");
        if ((r20 instanceof Boolean) == false) goto L109;
        Boolean r21 = (Boolean) r20;
    L110:
        if (r21 == null) goto L112;
        boolean r22 = r21.booleanValue();
    L113:
        r17.f21326a = r22;
        goto L116
    L112:
        r22 = false;
        goto L113
    L109:
        r21 = null;
    L116:
        if (r35.containsKey("loop") == false) goto L126;
        Object r23 = r35.get("loop");
        if ((r23 instanceof Boolean) == false) goto L120;
        Boolean r24 = (Boolean) r23;
    L121:
        if (r24 == null) goto L123;
        boolean r25 = r24.booleanValue();
    L124:
        r17.f21327b = r25;
        goto L126
    L123:
        r25 = false;
        goto L124
    L120:
        r24 = null;
    L126:
        if (r35.containsKey("inittime") == false) goto L136;
        Object r26 = r35.get("inittime");
        if ((r26 instanceof Integer) == false) goto L130;
        Integer r27 = (Integer) r26;
    L131:
        if (r27 == null) goto L133;
        int r28 = r27.intValue();
    L134:
        r16.f21338m = r28;
        goto L136
    L133:
        r28 = -1;
        goto L134
    L130:
        r27 = null;
    L136:
        if (r35.containsKey("objectfit") == false) goto L156;
        Object r29 = r35.get("objectfit");
        if (Intrinsics.areEqual(r29, "cover") == false) goto L141;
    L144:
        Object r30 = r35.get("objectfit");
        if (Intrinsics.areEqual(r30, "cover") == false) goto L148;
    L153:
        int r31 = 2;
    L154:
        r17.f = r31;
        goto L156
    L148:
        if (Intrinsics.areEqual(r30, "contain") == false) goto L151;
        r31 = 0;
        goto L154
    L151:
        if (Intrinsics.areEqual(r30, "fill") == false) goto L153;
        r31 = 1;
        goto L154
    L141:
        if (Intrinsics.areEqual(r29, "contain") == true) goto L144;
        Intrinsics.areEqual(r29, "fill");
    L156:
        if (r35.containsKey("headers") == false) goto L163;
        Object r32 = r35.get("headers");
        if ((r32 instanceof ReadableMap) == false) goto L160;
        ReadableMap r33 = (ReadableMap) r32;
    L161:
        r17.g = r33;
        goto L163
    L160:
        r33 = null;
    L163:
        if (r35.containsKey("experimental-props") == false) goto L170;
        Object r34 = r35.get("experimental-props");
        if ((r34 instanceof Map) == false) goto L167;
        Map r36 = (Map) r34;
    L168:
        r17.f21329h = r36;
        goto L170
    L167:
        r36 = null;
    L170:
        if (r35.containsKey("volume") == false) goto L180;
        Object r37 = r35.get("volume");
        if ((r37 instanceof Float) == false) goto L174;
        Float r38 = (Float) r37;
    L175:
        if (r38 == null) goto L177;
        float r39 = r38.floatValue();
    L178:
        r17.f21328c = r39;
        goto L180
    L177:
        r39 = -1.0f;
        goto L178
    L174:
        r38 = null;
    L180:
        if (r35.containsKey("speed") == false) goto L190;
        Object r40 = r35.get("speed");
        if ((r40 instanceof Float) == false) goto L184;
        Float r41 = (Float) r40;
    L185:
        if (r41 == null) goto L187;
        float r42 = r41.floatValue();
    L188:
        r17.d = r42;
        goto L190
    L187:
        r42 = 1.0f;
        goto L188
    L184:
        r41 = null;
    L190:
        if (r35.containsKey("resolution") == false) goto L199;
        Object r43 = r35.get("resolution");
        if ((r43 instanceof String) == false) goto L194;
        String r44 = (String) r43;
    L195:
        if (r44 != null) goto L197;
        r44 = "auto";
    L197:
        Intrinsics.checkNotNullParameter(r44, "<set-?>");
        r17.e = r44;
        goto L199
    L194:
        r44 = null;
    L199:
        if (r35.containsKey("tag") == false) goto L208;
        Object r45 = r35.get("tag");
        if ((r45 instanceof String) == false) goto L203;
        String r46 = (String) r45;
    L204:
        if (r46 != null) goto L206;
        r46 = "";
    L206:
        r16.f21336k = r46;
        goto L208
    L203:
        r46 = null;
    L208:
        if (r35.containsKey("sub_tag") == false) goto L218;
        Object r47 = r35.get("sub_tag");
        if ((r47 instanceof String) == false) goto L212;
        String r48 = (String) r47;
    L213:
        if (r48 == null) goto L216;
        r15 = r48;
    L216:
        r16.f21337l = r15;
        goto L218
    L212:
        r48 = null;
    L218:
        if (r35.containsKey("cache-size") == false) goto L228;
        Object r49 = r35.get("cache-size");
        if ((r49 instanceof Integer) == false) goto L222;
        Integer r110 = (Integer) r49;
    L223:
        if (r110 == null) goto L225;
        int r50 = r110.intValue();
    L226:
        r16.f21335j = r50;
        goto L228
    L225:
        r50 = 0;
        goto L226
    L222:
        r110 = null;
    L228:
        if (r35.containsKey("progress_update_interval") == false) goto L230;
        boolean r51 = r35.get("progress_update_interval") instanceof Integer;
    L230:
        pf.b r52 = this.f21896c;
        if (r52 == null) goto L243;
        e r53 = new e(this, r13);
        if (r11.f22338a == r52) goto L239;
        of.e r54 = new of.e(r11.getContext(), r52);
        r11.f22339b = r54;
        r54.f = r53;
        DataSource r55 = r11.d;
        if (r55 == null) goto L238;
        r54.e = r55;
    L238:
        r11.f22338a = r52;
    L239:
        of.e r56 = r11.f22339b;
        if (r56 == null) goto L243;
        r56.f20561h = r11;
    L243:
        if (r35.containsKey("objectfit") == false) goto L257;
        Object r57 = r35.get("objectfit");
        if (Intrinsics.areEqual(r57, "cover") == false) goto L248;
    L253:
        int r111 = 2;
    L254:
        r11.setTextureLayout(r111);
        return;
    L248:
        if (Intrinsics.areEqual(r57, "contain") == false) goto L251;
        r111 = 0;
        goto L254
    L251:
        if (Intrinsics.areEqual(r57, "fill") == false) goto L253;
        r111 = 1;
        goto L254
    L257:
        return;
    L58:
        r18 = null;
        goto L59
    L61:
        if (r35.containsKey("video_id") == false) goto L76;
        Object r58 = r35.get("video_id");
        if ((r58 instanceof String) == false) goto L65;
        String r112 = (String) r58;
    L66:
        Object r59 = r35.get("token");
        if ((r59 instanceof String) == false) goto L69;
        String r113 = (String) r59;
    L70:
        Object r60 = r35.get("domain");
        if ((r60 instanceof String) == false) goto L73;
        String r210 = (String) r60;
    L74:
        this.f21896c = new pf.b(r112, null, r113, r210, null, null, null, 114);
        goto L102
    L73:
        r210 = null;
        goto L74
    L69:
        r113 = null;
        goto L70
    L65:
        r112 = null;
        goto L66
    L76:
        if (r35.containsKey("play_url") == false) goto L102;
        if (r35.containsKey("preload-key") == false) goto L84;
        Object r114 = r35.get("preload-key");
        if ((r114 instanceof String) == false) goto L82;
        String r115 = (String) r114;
    L83:
        if (r115 == null) goto L84;
        String r211 = r115;
    L86:
        Object r61 = r35.get("play_url");
        if ((r61 instanceof String) == false) goto L89;
        String r62 = (String) r61;
    L90:
        if (r62 != null) goto L92;
        r62 = "";
    L92:
        Intrinsics.checkNotNullParameter(r62, "url");
        if (StringsKt.P(r62, "http://") == true) goto L99;
        if (StringsKt.P(r62, "https://") == true) goto L99;
        this.f21896c = new pf.b(null, null, null, null, null, null, r62, 63);
    L99:
        if (r211.length() <= 0) goto L101;
        this.f21896c = new pf.b(null, null, null, null, r211, r62, null, 79);
        goto L102
    L101:
        this.f21896c = new pf.b(null, null, null, null, null, r62, null, 95);
        goto L102
    L89:
        r62 = null;
        goto L90
    L82:
        r115 = null;
    L84:
        r211 = "";
        goto L86
    L50:
        r13 = null;
        goto L51
    L5:
        if (j(r35) == false) goto L47;
        if (r35.containsKey("muted") == false) goto L17;
        Object r63 = r35.get("muted");
        if ((r63 instanceof Boolean) == false) goto L11;
        Boolean r64 = (Boolean) r63;
    L12:
        if (r64 == null) goto L14;
        boolean r65 = r64.booleanValue();
    L15:
        r11.setMute(r65);
        goto L17
    L14:
        r65 = false;
        goto L15
    L11:
        r64 = null;
    L17:
        if (r35.containsKey("loop") == false) goto L27;
        Object r66 = r35.get("loop");
        if ((r66 instanceof Boolean) == false) goto L21;
        Boolean r67 = (Boolean) r66;
    L22:
        if (r67 == null) goto L24;
        boolean r116 = r67.booleanValue();
    L25:
        r11.setLoop(r116);
        goto L27
    L24:
        r116 = false;
        goto L25
    L21:
        r67 = null;
    L27:
        if (r35.containsKey("speed") == false) goto L37;
        Object r68 = r35.get("speed");
        if ((r68 instanceof Float) == false) goto L31;
        Float r69 = (Float) r68;
    L32:
        if (r69 == null) goto L34;
        float r70 = r69.floatValue();
    L35:
        r11.setSpeed(r70);
        goto L37
    L34:
        r70 = 1.0f;
        goto L35
    L31:
        r69 = null;
    L37:
        if (r35.containsKey("resolution") == false) goto L256;
        Object r71 = r35.get("resolution");
        if ((r71 instanceof String) == false) goto L41;
        String r117 = (String) r71;
    L42:
        if (r117 == null) goto L45;
        r10 = r117;
    L45:
        r11.setResolution(r10);
        return;
    L41:
        r117 = null;
        goto L42
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
        Boolean r10 = Boolean.TRUE;
        this.f.d(r10);
        r5.f(0, 0, null);
    }

    @Override // sf.a
    public final void e(com.bytedance.lynx.media.f r5) {
        Intrinsics.checkNotNullParameter(r5, "parentLayout");
        uf.e r10 = this.f;
        r5.addView(r10, -1, -1);
        r10.setParentLayout(r5);
    }

    @Override // sf.a
    public final void f(g r5) {
        Boolean r10 = Boolean.FALSE;
        this.f.d(r10);
        r5.f(0, 0, null);
    }

    @Override // sf.a
    public final void g(g r10) {
        uf.e r5 = this.f;
        if (r5.c() == true) goto L6;
        LynxLog.b(2, "VideoMediaView", "Failed to trigger prepare due to not properly initialized");
    L25:
        if (r10 == null) goto L27;
        r10.f(0, 0, null);
    L27:
        LynxLog.b(2, "TTVideoEngineMediaPlayable", "Trigger prepare in MediaPlayable instance");
        return;
    L6:
        if (r5.f22351j == false) goto L8;
        LynxLog.b(2, "VideoMediaView", "Failed to trigger prepare due to already called");
        goto L25
    L8:
        r5.f22339b.f();
        of.e r11 = r5.f22339b;
        if (r11 != null) goto L11;
    L13:
        jm.a r12 = new jm.a(r5, 12);
        Surface r13 = r5.getSurface();
        if (r13 == null) goto L21;
        if (r13.isValid() == false) goto L21;
        of.e r14 = r5.f22339b;
        if (r14 == null) goto L21;
        r14.d(r13);
        r12.run();
    L24:
        LynxLog.b(2, "VideoMediaView", "Did trigger VideoController prepare in VideoMediaView");
        r5.f22351j = true;
    L21:
        if (r5.f22349h != null) goto L23;
        r5.f22349h = new ArrayList();
    L23:
        r5.f22349h.add(r12);
        goto L24
    L11:
        if (r11.n() == false) goto L13;
        goto L13
    }

    @Override // sf.a
    public final void h(g r10) {
        uf.e r11 = this.f;
        if (r11.c() == true) goto L5;
    L51:
        r10.f(0, 0, null);
        return;
    L5:
        if (r11.f22339b.f20565l == false) goto L51;
        WeakReference r5 = r11.g;
        if (r5 == null) goto L51;
        of.a r12 = (of.a) r5.get();
        if (r12 == null) goto L51;
        r11.f22339b.f20565l = false;
        f r13 = (f) r12;
        Intrinsics.checkNotNullParameter(r11, "videoView");
        Context r14 = r13.f21894a;
        Activity r15 = l(r14);
        if (r15 == null) goto L48;
        r15.getWindow().clearFlags(1024);
        Activity r16 = l(r14);
        if (r16 == null) goto L17;
        int r17 = r16.getRequestedOrientation();
    L18:
        if (1 == r17) goto L22;
        Activity r18 = l(r14);
        if (r18 == null) goto L22;
        r18.setRequestedOrientation(1);
    L22:
        FrameLayout r19 = r13.g;
        if (r19 == null) goto L25;
        r19.removeAllViews();
    L25:
        FrameLayout r20 = r13.g;
        if (r20 == null) goto L29;
        r20.setVisibility(8);
    L29:
        r11.getParentLayout().addView(r11, new ViewGroup.LayoutParams(-1, -1));
        Window r21 = r15.getWindow();
        if (r21 == null) goto L48;
        WindowManager.LayoutParams r22 = r21.getAttributes();
        if (r22 == null) goto L48;
        r22.layoutInDisplayCutoutMode = r13.f21898i;
        Integer r23 = r13.f21899j;
        if (r23 == null) goto L42;
        int r24 = r23.intValue();
        Window r25 = r15.getWindow();
        if (r25 == null) goto L38;
        View r26 = r25.getDecorView();
    L39:
        if (r26 == null) goto L42;
        r26.setSystemUiVisibility(r24);
        goto L42
    L38:
        r26 = null;
    L42:
        Integer r27 = r13.f21900k;
        if (r27 == null) goto L48;
        int r28 = r27.intValue();
        Window r29 = r15.getWindow();
        if (r29 == null) goto L48;
        r29.setStatusBarColor(r28);
        goto L48
    L17:
        r17 = 1;
    L48:
        rf.a r30 = r11.f22340c;
        if (r30 == null) goto L51;
        ((rf.b) r30).f21737a.i("fullscreenchange", MapsKt.hashMapOf(new Pair[]{TuplesKt.to("fullscreen", Boolean.FALSE)}));
        goto L51
    }

    @Override // sf.d
    public final boolean j(Map r5) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.PARAMS_KEY);
        if (super.j(r5) == false) goto L5;
        return true;
    L5:
        if (r5.containsKey("resolution") == true) goto L11;
        return false;
    L11:
        return true;
    }

    @Override // sf.a
    public final void a() {
        uf.e r5 = this.f;
        r5.setTransformer(this);
        Intrinsics.checkNotNullParameter(r5, "delegate");
        this.f21895b = r5;
    }
}
