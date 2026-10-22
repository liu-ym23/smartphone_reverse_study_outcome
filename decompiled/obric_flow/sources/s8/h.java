package s8;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import androidx.core.view.PointerIconCompat;
import com.bytedance.apm.j;
import com.bytedance.apm.k;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.server.WsChannelService;
import com.bytedance.pia.core.utils.m;
import com.bytedance.pia.core.worker.bridge.BridgeModule;
import com.bytedance.salamander.anniex.b0;
import com.google.common.reflect.w;
import com.lynx.tasm.behavior.shadow.text.TextShadowNode;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.l;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ym.p;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f21852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f21853b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f21854c;

    public /* synthetic */ h(int r5, Object r10, Object r11) {
        this.f21852a = r5;
        this.f21854c = r10;
        this.f21853b = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r5 = 1;
        int r10 = 0;
        switch(this.f21852a) {
            case 0: goto L108;
            case 1: goto L106;
            case 2: goto L97;
            case 3: goto L40;
            case 4: goto L23;
            case 5: goto L17;
            case 6: goto L15;
            case 7: goto L11;
            case 8: goto L6;
            default: goto L4;
        };
    L4:
        ((TextShadowNode) this.f21853b).k().g.b((com.lynx.animax.i) this.f21854c);
        return;
    L6:
        p r11 = (p) this.f21854c;
        View r12 = (View) r11.f23312b;
        if (r12 == null) goto L9;
        r12.requestLayout();
    L9:
        r11.f23313c = (a6.a) this.f21853b;
        return;
    L11:
        yf.b r13 = (yf.b) ((ConcurrentHashMap) ((ug.d) this.f21854c).g).remove((String) this.f21853b);
        if (r13 == null) goto L127;
        r13.b("UserTimeout", false);
        return;
    L127:
        return;
    L15:
        ((l) this.f21853b).F((wt.d) this.f21854c, Unit.INSTANCE);
        return;
    L17:
        Process.setThreadPriority(10);
        ((Runnable) this.f21853b).run();     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        io.reactivex.exceptions.a.n("APM-AsyncTask", "SingleThreadFactory error when running in thread " + ((String) ((jf.a) this.f21854c).f18318b), th);
        return;
    L23:
        rh.g r14 = (rh.g) this.f21854c;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L26
        Object r16 = Result.m124constructorimpl(new rh.i(r14));     // Catch: Throwable -> L26
    L28:
        boolean r17 = Result.m131isSuccessimpl(r16);
        p r18 = (p) this.f21853b;
        if (r17 == false) goto L31;
        rh.i r19 = (rh.i) r16;
        r19.f("!function(){var e=globalThis.NativeModules,t=e.get(\"BaseModule\");globalThis.location={href:t.getHref()},globalThis.navigator={userAgent:t.getUserAgent()},globalThis.NativeModules={get:function(l){var a=e.get(l);return\"BaseModule\"==l?Object.assign(a,{storeNSRHtml:function(e){t.terminateWithResult({html:e})}}):a}}}();");
        r19.f21770o.b(BridgeModule.class, r19.f21772q, "bridge");
        r19.h();
        r19.c(new vh.a(r18, r10));
        r19.f21762c.b(new rh.e(r19, new vh.a(r18, r5), r5));
        w r20 = ((nh.d) r18.f23312b).f20247r;
        com.bytedance.pia.nsr.a r21 = new com.bytedance.pia.nsr.a(r18);
        r20.getClass();
        m.b(new a2.b(11, r20, r21));
    L31:
        Throwable r22 = Result.m127exceptionOrNullimpl(r16);
        if (r22 == null) goto L35;
        ((nh.d) r18.f23312b).f20239j.b(PointerIconCompat.TYPE_HELP, "prefetch", Log.getStackTraceString(r22));
    L35:
        if (Result.m130isFailureimpl(r16) == false) goto L37;
        Object r23 = null;
    L38:
        r18.f23313c = (rh.i) r23;
        return;
    L37:
        r23 = r16;
    L26:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r16 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L28
    L40:
        v6.g r25 = (v6.g) this.f21854c;
        HashMap r26 = r25.f22542p;
        if (r26 == null) goto L129;
        String r27 = (String) this.f21853b;
        if (r26.containsKey(r27) == false) goto L135;
        long r28 = ((com.bytedance.apm.util.h) r25.f22542p.get(r27)).f3917a.longValue();
        long r29 = r25.s.h() - ((com.bytedance.apm.util.h) r25.f22542p.get(r27)).f3918b.longValue();
        v6.e r110 = (v6.e) r25.s.f21695a;
        r110.b();
        long r111 = (r110.f22528b + r110.d) - ((com.bytedance.apm.util.h) r25.f22543q.get(r27)).f3918b.longValue();
        v6.e r112 = (v6.e) r25.s.f21695a;
        r112.b();
        long r113 = (r112.f22529c + r112.e) - ((com.bytedance.apm.util.h) r25.f22544r.get(r27)).f3918b.longValue();
        r25.f22542p.remove(r27);
        r25.f22543q.remove(r27);
        r25.f22544r.remove(r27);
        if (r29 >= 0) goto L51;
        HashMap r30 = v6.b.f22516a.f22523k;
        if (r30 == null) goto L136;
        r30.remove(r27);
        return;
    L136:
        return;
    L51:
        v6.c r31 = v6.b.f22516a;
        if (r31.f22523k != null) goto L54;
    L57:
        Map r32 = null;
    L123:
        JSONObject r33 = new JSONObject();     // Catch: Exception -> L67
        r33.put("init_ts", r28);     // Catch: Exception -> L67
        r33.put("usage_ts", System.currentTimeMillis());     // Catch: Exception -> L67
        if (r32 != null) goto L61;
    L70:
        HashMap r34 = v6.b.f22516a.f22523k;     // Catch: Exception -> L67
        if (r34 == null) goto L74;
        r34.remove(r27);     // Catch: Exception -> L67
    L74:
        JSONObject r35 = new JSONObject();     // Catch: Exception -> L67
        r35.put(r27, r29);     // Catch: Exception -> L67
        r35.put(r27 + "$wifi", r111);     // Catch: Exception -> L67
        r35.put(r27 + "$mobile", r113);     // Catch: Exception -> L67
        j6.e r36 = new j6.e();     // Catch: Exception -> L67
        r36.f18259a = r25.d;     // Catch: Exception -> L67
        r36.f18260b = r35;     // Catch: Exception -> L67
        r36.e = r33;     // Catch: Exception -> L67
        JSONObject r37 = r36.c();     // Catch: Exception -> L67
        j7.b r38 = new j7.b("performance_monitor", r37);     // Catch: Exception -> L67
        JSONObject r39 = r25.f22545t;     // Catch: Exception -> L67
        if (r39 != null) goto L81;
        v6.g.f22532v.c(r38);     // Catch: Exception -> L67
        v6.g.f22533w.c(r27);     // Catch: Exception -> L67
        if (j.f3887a == false) goto L131;
        Log.d("Traffic", com.bytedance.android.anniex.base.service.f.o(new String[]{"config==null:"}));     // Catch: Exception -> L67
        return;
    L131:
        return;
    L81:
        if (r39.optInt(r27, 0) != 1) goto L84;
        b0 r40 = h7.a.f17285a;     // Catch: Exception -> L67
        p7.a.a(r38);     // Catch: Exception -> L67
    L87:
        if (j.f3887a == false) goto L133;
        StringBuilder r41 = new StringBuilder();     // Catch: Exception -> L67
        r41.append("isSample:");     // Catch: Exception -> L67
        boolean r42 = false;
        if (r25.f22545t.optInt(r27, 0) != 1) goto L91;
        r42 = true;
    L91:
        r41.append(r42);     // Catch: Exception -> L67
        Log.d("Traffic", com.bytedance.android.anniex.base.service.f.o(new String[]{r41.toString()}));     // Catch: Exception -> L67
        return;
    L133:
        return;
    L84:
        if (j.f3887a == false) goto L87;
        l6.a.a("performance_monitor", r37);     // Catch: Exception -> L67
        goto L87
    L61:
        if (r32.size() <= 0) goto L70;
        JSONObject r43 = new JSONObject();     // Catch: Exception -> L67
        JSONArray r44 = new JSONArray();     // Catch: Exception -> L67
        Iterator r45 = r32.entrySet().iterator();     // Catch: Exception -> L67 JSONException -> L118
    L65:
        if (r45.hasNext() == false) goto L69;
        JSONObject r46 = ((v6.a) ((Map.Entry) r45.next()).getValue()).b();     // Catch: Exception -> L67 JSONException -> L118
        r46.put("traffic_category", r27);     // Catch: Exception -> L67 JSONException -> L118
        r44.put(r46);     // Catch: Exception -> L67 JSONException -> L118
        goto L65
    L69:
        r43.put("usage", r44);     // Catch: Exception -> L67 JSONException -> L118
        r33.put("detail", r43);     // Catch: Exception -> L67 JSONException -> L118
    L67:
        e = move-exception;
        k.f3892a.getClass();
        if (j.f3887a == false) goto L134;
        e.printStackTrace();
        return;
    L134:
        return;
    L54:
        if (TextUtils.isEmpty(r27) == true) goto L57;
        r32 = (Map) r31.f22523k.get(r27);
        goto L123
    L135:
        return;
    L129:
        return;
    L97:
        Activity r47 = (Activity) this.f21854c;
        Intrinsics.checkNotNullParameter(r47, "activity");
        WeakReference r48 = new WeakReference(r47);
        v0.d r49 = (v0.d) this.f21853b;
        r49.f22505j = r48;
        t0.b r50 = com.bytedance.ai.model.p.f2294c;
        if (r50 == null) goto L104;
        Pair r51 = r50.getFloatViewRestriction(r47);
        if (r51 == null) goto L104;
        v0.a r52 = r49.f;
        if (r52 == null) goto L104;
        r52.c(r51);
    L104:
        r49.p(r47);
        return;
    L106:
        ((v0.c) this.f21854c).getClass();
        return;
    L108:
        int r53 = WsChannelService.f4020c;
        WsChannelService r54 = (WsChannelService) this.f21854c;
        r54.getClass();
        Intent r55 = (Intent) this.f21853b;
        if (r55 == null) goto L140;
        String r56 = r55.getAction();
        if (WsConstants.APP_STATE_ACTION.equals(r56) == false) goto L115;
        int r57 = r55.getIntExtra(WsConstants.KEY_APP_STATE, -1);
        Message r58 = new Message();
        r58.what = 2;
        r58.arg1 = r57;
        r54.a(r58);
        return;
    L115:
        if (WsConstants.NETWORK_STATE_ACTION.equals(r56) == false) goto L139;
        int r59 = r55.getIntExtra(WsConstants.KEY_NETWORK_STATE, -1);
        Message r60 = new Message();
        r60.what = 3;
        r60.arg1 = r59;
        r54.a(r60);
        return;
    L139:
        return;
    }

    public /* synthetic */ h(int r5, Object r10, boolean r11, Object r12) {
        this.f21852a = r5;
        this.f21853b = r10;
        this.f21854c = r12;
    }

    public h(v0.c r5) {
        this.f21852a = 1;
        this.f21854c = r5;
        this.f21853b = new Handler(Looper.getMainLooper());
    }
}
