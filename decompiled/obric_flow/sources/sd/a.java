package sd;

import ai.p;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.ies.bullet.forest.n;
import com.bytedance.ies.bullet.kit.resourceloader.g;
import com.bytedance.ies.bullet.kit.resourceloader.h;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.bullet.service.sdk.b;
import com.bytedance.ies.bullet.service.sdk.c;
import com.bytedance.ies.bullet.web.pia.i;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.bytedance.pia.core.setting.Settings;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.serval.svg.SVGRenderEngine;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import oh.f;
import xc.d;
import xc.e;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set f21885c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f21886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n f21887b;

    static {
        f21885c = SetsKt.setOf(new String[]{"packages", "__x_session_id", "web_domain_party", "enable_third_party_web_ui"});
    }

    public a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "bid");
        this.f21886a = r5;
        this.f21887b = new n(0);
    }

    @Override // com.bytedance.ies.bullet.service.sdk.c
    public final boolean a(b r22) {
        Intrinsics.checkNotNullParameter(r22, "schemaData");
        String r5 = (String) new vd.a(r22, "container_bgcolor", null).f22372b;
        if (r5 == null) goto L5;
        r22.b("container_bg_color", new vd.a(r5, 7), false);
    L5:
        String r10 = (String) new vd.a(r22, "bg_color", null).f22372b;
        if (r10 == null) goto L8;
        r22.b("container_bg_color", new vd.a(r10, 7), false);
    L8:
        Boolean r11 = (Boolean) new vd.a(r22, "hide_loading", null).f22372b;
        if (r11 == null) goto L11;
        r22.b("show_loading", new vd.a(Boolean.valueOf(!r11.booleanValue()), 0), false);
    L11:
        String r12 = (String) new vd.a(r22, "secLinkScene", null).f22372b;
        if (r12 == null) goto L15;
        r22.b("sec_link_scene", new vd.a(r12, 7), false);
    L15:
        if (Intrinsics.areEqual(r22.d, "bullet") == false) goto L20;
        if (Intrinsics.areEqual(r22.a(), "bullet") == false) goto L20;
        return true;
    L20:
        if (Intrinsics.areEqual(r22.d, "http") == false) goto L22;
    L23:
        Intrinsics.checkNotNullParameter("webview", SVGRenderEngine.PATH);
        r22.e = "webview";
        r22.b("url", new vd.a(r22.f6135c, 8), true);
    L24:
        this.f21887b.a(r22);
        LinkedHashMap r13 = r22.f6143o;
        String r14 = "";
        if (r13.containsKey("lynx_schema") == false) goto L27;
        KitType r15 = KitType.d;
    L59:
        ConcurrentHashMap r16 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(e.class, "cls");
        e r17 = (e) yc.a.a(e.class, "default_bid");
        if (r17 == null) goto L66;
        d r18 = (d) r17.a(d.class);
        if (r18 == null) goto L66;
        Boolean r19 = r18.i();
        if (r19 == null) goto L66;
        boolean r110 = r19.booleanValue();
    L67:
        Boolean r20 = Boolean.FALSE;
        Boolean r21 = (Boolean) new vd.a(r22, "clear_url_params", r20).f22372b;
        int r23 = r15.ordinal();
        Set r24 = f21885c;
        Class r111 = d.class;
        String r112 = "default_bid";
        Class r113 = e.class;
        String r114 = this.f21886a;
        String r25 = "cls";
        if (r23 != 1) goto L70;
        Intrinsics.checkNotNullParameter("bullet", "scheme");
        r22.d = "bullet";
        Intrinsics.checkNotNullParameter("bullet", SVGRenderEngine.PATH);
        r22.e = "bullet";
        String r26 = (String) r13.get("url");
        if (r26 == null) goto L163;
        LinkedHashMap r27 = i.f6234a;
        Intrinsics.checkNotNullParameter(r26, "url");
        Intrinsics.checkNotNullParameter(r114, "bid");
        i.a(r114);
        if (((f) p.g(f.class)) == null) goto L157;
        Lazy r28 = Settings.B;
        if (com.lynx.tasm.p.a().r() == false) goto L145;
    L219:
        Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L151
        Object r30 = Result.m124constructorimpl(Uri.parse(r26));     // Catch: Throwable -> L151
    L154:
        if (Result.m130isFailureimpl(r30) == false) goto L156;
        r30 = null;
    L156:
        boolean r31 = f.a((Uri) r30);
    L158:
        if (r31 == false) goto L163;
        Object r32 = new vd.a(r22, "disable_pia", null).f22372b;
        Boolean r33 = Boolean.TRUE;
        if (Intrinsics.areEqual(r32, r33) == true) goto L163;
        r22.b("__x_param_pia", new vd.a(r33, 0), false);
    L151:
        th = move-exception;
        Result.Companion r34 = Result.Companion;
        r30 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L154
    L145:
        if (StringsKt.g(r26, "__pia_manifest__") == true) goto L219;
        if (StringsKt.g(r26, "_pia_") == true) goto L219;
    L157:
        r31 = false;
    L163:
        if (Intrinsics.areEqual(r21, r20) == true) goto L167;
        if (r110 == false) goto L167;
    L166:
        return true;
    L167:
        String r35 = (String) r13.get("url");
        if (r35 == null) goto L166;
        boolean r36 = false;
        int r37 = StringsKt.q(r35, '?', 0, 6);
        if (r37 != (-1)) goto L172;
        String r38 = r35;
    L173:
        if (r37 != (-1)) goto L175;
        int r39 = -1;
    L176:
        if (r39 == (-1)) goto L179;
        r14 = r35.substring(r39, r35.length());
    L179:
        StringBuilder r40 = new StringBuilder(r38);
        Iterator r41 = r13.entrySet().iterator();
        boolean r115 = true;
    L181:
        if (r41.hasNext() == false) goto L217;
        Map.Entry r42 = (Map.Entry) r41.next();
        if (Intrinsics.areEqual(r42.getKey(), "url") == false) goto L185;
    L216:
        Class r43 = r111;
        String r116 = r112;
        Class r44 = r113;
        String r117 = r25;
    L215:
        r111 = r43;
        r113 = r44;
        r25 = r117;
        r112 = r116;
        r36 = false;
        goto L181
    L185:
        if (r24.contains(r42.getKey()) == true) goto L216;
        if (r115 == false) goto L188;
        r40.append('?');
        r115 = r36;
    L190:
        if (Intrinsics.areEqual(r114, "webcast") == true) goto L192;
    L213:
        r43 = r111;
        r116 = r112;
        r44 = r113;
        r117 = r25;
    L214:
        r40.append(Uri.encode((String) r42.getKey()));
        r40.append('=');
        r40.append(Uri.encode((String) r42.getValue()));
        goto L215
    L192:
        if (Intrinsics.areEqual(r42.getKey(), "token") == false) goto L213;
        ConcurrentHashMap r45 = yc.a.f23246a;
        r44 = r113;
        r117 = r25;
        Intrinsics.checkNotNullParameter(r44, r117);
        r116 = r112;
        e r46 = (e) yc.a.a(r44, r116);
        r43 = r111;
        if (r46 == null) goto L200;
        d r47 = (d) r46.a(r43);
        if (r47 == null) goto L200;
        List r48 = r47.g0();
        if (r48 == null) goto L200;
    L201:
        if (r48 != null) goto L203;
    L205:
        Iterator r49 = r48.iterator();
    L207:
        if (r49.hasNext() == false) goto L214;
        if (StringsKt.g(r38, (String) r49.next()) == false) goto L207;
        r40.append(Uri.encode((String) r42.getKey()));
        r40.append('=');
        r40.append((String) r42.getValue());
        goto L215
    L203:
        if (r48.isEmpty() == false) goto L205;
    L200:
        r48 = CollectionsKt.emptyList();
        goto L201
    L188:
        r40.append(Typography.amp);
        goto L190
    L217:
        r40.append(r14);
        r22.b("url", new vd.a(r40.toString(), 7), true);
        return true;
    L175:
        r39 = StringsKt.q(r35, '#', r37 + 1, 4);
        goto L176
    L172:
        r38 = r35.substring(0, r37);
        goto L173
    L70:
        if (r23 == 3) goto L73;
        return false;
    L73:
        Intrinsics.checkNotNullParameter("bullet", "scheme");
        r22.d = "bullet";
        Intrinsics.checkNotNullParameter("bullet", SVGRenderEngine.PATH);
        r22.e = "bullet";
        if (Intrinsics.areEqual(r21, r20) == true) goto L78;
        if (r110 == false) goto L78;
        return true;
    L78:
        String r50 = (String) r13.get("url");
        String r51 = (String) r13.get("res_url");
        if (r51 != null) goto L81;
        r51 = (String) r13.get("surl");
    L81:
        if (r51 != null) goto L85;
        if (r50 != null) goto L86;
        r50 = null;
    L86:
        h r52 = g.a(r114);
        r52.getClass();
        if (r50 != null) goto L90;
    L88:
        fc.a r53 = null;
    L97:
        String r54 = LynxMonitorService.KEY_CHANNEL;
        if (r53 != null) goto L100;
    L104:
        String r55 = (String) r13.get(LynxMonitorService.KEY_CHANNEL);
    L105:
        String r56 = "bundle";
        if (r53 != null) goto L108;
    L112:
        String r57 = (String) r13.get("bundle");
    L113:
        Bundle r58 = r22.f6134b;
        if (r58 == null) goto L119;
        if (r55 == null) goto L117;
        r58.putString("__x_param_channel", r55);
    L117:
        if (r57 == null) goto L119;
        r58.putString("__x_param_bundle", r57);
    L119:
        StringBuilder r59 = new StringBuilder("lynxview://");
        if (r55 == null) goto L123;
        r54 = r55;
    L123:
        r59.append(r54);
        r59.append('/');
        if (r57 == null) goto L127;
        r56 = r57;
    L127:
        r59.append(r56);
        r59.append('?');
        Iterator r60 = r13.entrySet().iterator();
        boolean r61 = true;
    L129:
        if (r60.hasNext() == false) goto L136;
        Map.Entry r62 = (Map.Entry) r60.next();
        if (r24.contains(r62.getKey()) == true) goto L129;
        if (r61 == false) goto L134;
        r61 = false;
    L135:
        r59.append(Uri.encode((String) r62.getKey()));
        r59.append('=');
        r59.append(Uri.encode((String) r62.getValue()));
        goto L129
    L134:
        r59.append(Typography.amp);
        goto L135
    L136:
        r22.b("url", new vd.a(r59.toString(), 7), true);
        return true;
    L108:
        if (r53.f16890c == false) goto L110;
        r57 = r53.f16889b;
    L111:
        if (r57 != null) goto L113;
    L110:
        r57 = null;
        goto L111
    L100:
        if (r53.f16890c == false) goto L102;
        r55 = r53.f16888a;
    L103:
        if (r55 != null) goto L105;
    L102:
        r55 = null;
        goto L103
    L90:
        if (Uri.parse(r50).isHierarchical() == true) goto L92;
        dc.b.a("parseChannelBundle: is notHierarchical");
        goto L88
    L92:
        ConcurrentHashMap r63 = com.bytedance.ies.bullet.kit.resourceloader.a.f5444a;
        wc.e r64 = r52.d();
        String r65 = r52.e;
        if (r65 != null) goto L96;
        Intrinsics.throwUninitializedPropertyAccessException("bid");
        r65 = null;
    L96:
        r53 = com.bytedance.ies.bullet.kit.resourceloader.a.a(r50, r64, r65, true, new wc.g(""));
        goto L97
    L85:
        r50 = r51;
    L66:
        r110 = true;
        goto L67
    L27:
        String r118 = r22.a();
        if (r118 != null) goto L31;
        r118 = "";
    L31:
        switch(r118.hashCode()) {
            case -1932693274: goto L56;
            case -1772600516: goto L52;
            case -1001735703: goto L49;
            case 862922167: goto L46;
            case 981209732: goto L43;
            case 1224424441: goto L40;
            case 1630240178: goto L37;
            case 2015851285: goto L34;
            default: goto L58;
        };
    L58:
        r15 = KitType.f6011b;
        goto L59
    L34:
        if (r118.equals("webview_page") == false) goto L58;
    L57:
        r15 = KitType.f6012c;
        goto L59
    L37:
        if (r118.equals("lynxview_page") == false) goto L58;
    L54:
        r15 = KitType.d;
        goto L59
    L40:
        if (r118.equals("webview") == true) goto L57;
    L43:
        if (r118.equals("lynx_popup") == true) goto L54;
    L46:
        if (r118.equals("lynx_page") == true) goto L54;
    L49:
        if (r118.equals("lynxview_popup") == true) goto L54;
    L52:
        if (r118.equals("lynxview") == true) goto L54;
    L56:
        if (r118.equals("webview_popup") == false) goto L58;
    L22:
        if (Intrinsics.areEqual(r22.d, IIvyAIPackageResourceService.SCHEMA) == false) goto L24;
        goto L23
    }

    @Override // com.bytedance.ies.bullet.service.sdk.c
    public final String b() {
        return "Bullet";
    }
}
