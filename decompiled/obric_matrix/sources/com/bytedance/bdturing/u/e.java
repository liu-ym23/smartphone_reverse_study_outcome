package com.bytedance.bdturing.u;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.bytedance.bdturing.g;
import com.bytedance.bdturing.j;
import com.bytedance.bdturing.q;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.matrix.common_api.INetworkApi;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e implements com.bytedance.bdturing.u.a {

    class a implements com.bytedance.bdturing.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.bytedance.bdturing.u.c f3179a;

        a(e r1, com.bytedance.bdturing.u.c r2) {
            this.f3179a = r2;
        }

        @Override // com.bytedance.bdturing.c
        public void a(int r2, @Nullable JSONObject r3) {
            JSONObject r4 = new JSONObject();     // Catch: JSONException -> L4
            r4.put("result", r2);     // Catch: JSONException -> L4
            this.f3179a.d(1, r4);     // Catch: JSONException -> L4
            return;
        }

        @Override // com.bytedance.bdturing.c
        public void b(int r1, @Nullable JSONObject r2) {
            a(r1, r2);
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f3180f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Map f3181g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f3182h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ com.bytedance.bdturing.u.c f3183i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ e f3184j;

        b(e r1, String r2, Map r3, String r4, com.bytedance.bdturing.u.c r5) {
            this.f3184j = r1;
            this.f3180f = r2;
            this.f3181g = r3;
            this.f3182h = r4;
            this.f3183i = r5;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.bytedance.bdturing.b.f().e() == null) goto L5;
            com.bytedance.bdturing.ttnet.b r0 = com.bytedance.bdturing.b.f().e().getHttpClient();
        L6:
            if (r0 == null) goto L8;
            String r1 = new String(r0.post(this.f3180f, this.f3181g, this.f3182h.getBytes()), kotlin.u0.d.f21429a);
        L9:
            e.b(this.f3184j, this.f3183i, r1);
            return;
        L8:
            r1 = "";
            goto L9
        L5:
            r0 = null;
            goto L6
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f3185f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Map f3186g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ com.bytedance.bdturing.u.c f3187h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ e f3188i;

        c(e r1, String r2, Map r3, com.bytedance.bdturing.u.c r4) {
            this.f3188i = r1;
            this.f3185f = r2;
            this.f3186g = r3;
            this.f3187h = r4;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.bytedance.bdturing.b.f().e() == null) goto L5;
            com.bytedance.bdturing.ttnet.b r0 = com.bytedance.bdturing.b.f().e().getHttpClient();
        L6:
            if (r0 == null) goto L8;
            String r1 = new String(r0.get(this.f3185f, this.f3186g), kotlin.u0.d.f21429a);
        L9:
            e.b(this.f3188i, this.f3187h, r1);
            return;
        L8:
            r1 = "";
            goto L9
        L5:
            r0 = null;
            goto L6
        }
    }

    public e() {
    }

    static /* synthetic */ void b(e r0, com.bytedance.bdturing.u.c r1, String r2) {
        r0.j(r1, r2);
    }

    private void e(com.bytedance.bdturing.u.c r11) {
        JSONObject r0 = new JSONObject(r11.f3172b);     // Catch: JSONException -> L25
        String r1 = r0.getString(WsConstants.KEY_CONNECTION_URL);     // Catch: JSONException -> L25
        String r2 = r0.getString("method");     // Catch: JSONException -> L25
        JSONObject r3 = r0.optJSONObject("query");     // Catch: JSONException -> L25
        JSONObject r4 = r0.optJSONObject("data");     // Catch: JSONException -> L25
        String r5 = null;
        if (r3 == null) goto L13;
        StringBuilder r6 = new StringBuilder(r1);     // Catch: JSONException -> L25
        r6.append("?");     // Catch: JSONException -> L25
        Iterator<String> r7 = r3.keys();     // Catch: JSONException -> L25
    L6:
        if (r7.hasNext() == false) goto L12;
        String r8 = r7.next();     // Catch: JSONException -> L25
        if (r3.get(r8) == null) goto L10;
        String r9 = r3.get(r8).toString();     // Catch: JSONException -> L25
    L11:
        r6.append("&" + r8 + "=");     // Catch: JSONException -> L25
        r6.append(r9);     // Catch: JSONException -> L25
        goto L6
    L10:
        r9 = null;
        goto L11
    L12:
        r1 = r6.toString();     // Catch: JSONException -> L25
    L13:
        String r10 = r1;
        if (r4 == null) goto L18;
        r5 = r4.toString().replaceAll("\\\\/", "/");     // Catch: JSONException -> L25
    L18:
        if (g.d() == false) goto L20;
        g.a("CallNativeRequest", r10);     // Catch: JSONException -> L25
    L20:
        HashMap r12 = new HashMap();     // Catch: JSONException -> L25
        r12.put(INetworkApi.CONTENT_TYPE, INetworkApi.DEFAULT_CONTENT_TYPE);     // Catch: JSONException -> L25
        if (r2.equals("post") == false) goto L23;
        q.c().e(new b(this, r10, r12, r5, r11));     // Catch: JSONException -> L25
        return;
    L23:
        q.c().e(new c(this, r10, r12, r11));     // Catch: JSONException -> L25
        return;
    L25:
        e = move-exception;
        e.printStackTrace();
    }

    private void j(com.bytedance.bdturing.u.c r3, String r4) {
        if (g.d() == false) goto L5;
        g.a("CallNativeRequest", r4);
    L5:
        int r2 = !TextUtils.isEmpty(r4) ? 1 : 0;
        JSONObject r0 = new JSONObject();
        r0.put("content", r4);     // Catch: JSONException -> L8
        r0 = new JSONObject(r4);     // Catch: JSONException -> L8
    L10:
        r3.d(r2, r0);
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        r2 = 0;
        goto L10
    }

    @Override // com.bytedance.bdturing.u.a
    public void a(com.bytedance.bdturing.u.c r8) {
        String r0 = r8.f3171a;     // Catch: Exception -> L68
        byte r1 = -1;
        switch(r0.hashCode()) {
            case -1759249244: goto L42;
            case -1628743486: goto L39;
            case -1563440329: goto L36;
            case -1534238297: goto L33;
            case -1471628194: goto L30;
            case -1366167938: goto L27;
            case -1028963129: goto L24;
            case -985680828: goto L21;
            case -514719849: goto L18;
            case 428780843: goto L15;
            case 491779646: goto L12;
            case 1154510586: goto L9;
            case 1176627553: goto L6;
            default: goto L45;
        };     // Catch: Exception -> L68
    L45:
        switch(r1) {
            case 0: goto L66;
            case 1: goto L65;
            case 2: goto L64;
            case 3: goto L63;
            case 4: goto L62;
            case 5: goto L54;
            case 6: goto L53;
            case 7: goto L52;
            case 8: goto L51;
            case 9: goto L50;
            case 10: goto L49;
            case 11: goto L48;
            case 12: goto L47;
            default: goto L86;
        };
    L47:
        com.bytedance.bdturing.e.o(System.currentTimeMillis() - j.a().b());     // Catch: Exception -> L68
        return;
    L48:
        j.a().d();     // Catch: Exception -> L68
        com.bytedance.bdturing.e.p(System.currentTimeMillis() - j.a().c());     // Catch: Exception -> L68
        return;
    L49:
        k();     // Catch: Exception -> L68
        return;
    L50:
        h(new JSONObject(r8.f3172b).getString("params"), new a(this, r8));     // Catch: Exception -> L68
        return;
    L51:
        d(r8);     // Catch: Exception -> L68
        return;
    L52:
        e(r8);     // Catch: Exception -> L68
        return;
    L53:
        JSONObject r7 = new JSONObject(r8.f3172b);     // Catch: Exception -> L68
        com.bytedance.bdturing.e.g(r7.optString(NotificationCompat.CATEGORY_EVENT), r7);     // Catch: Exception -> L68
        return;
    L54:
        JSONObject r9 = new JSONObject(r8.f3172b);     // Catch: Exception -> L68
        HashMap r10 = new HashMap();     // Catch: Exception -> L68
        Iterator<String> r2 = r9.keys();     // Catch: Exception -> L68
    L56:
        if (r2.hasNext() == false) goto L88;
        String r3 = r2.next();     // Catch: Exception -> L68
        Object r4 = r9.opt(r3);     // Catch: Exception -> L68
        if (r4 == null) goto L60;
        String r5 = r4.toString();     // Catch: Exception -> L68
    L61:
        r10.put(r3, r5);     // Catch: Exception -> L68
        goto L56
    L60:
        r5 = null;
        goto L61
    L88:
        return;
    L62:
        JSONObject r6 = new JSONObject(r8.f3172b);     // Catch: Exception -> L68
        i(r6.optInt("result"), r6.optString("mode"), r6.optString(WsConstants.KEY_CONNECTION_TYPE), r6.optString("token"), r6.optString("mobile"));     // Catch: Exception -> L68
        return;
    L63:
        c();     // Catch: Exception -> L68
        return;
    L64:
        q.c().h(2, r8);     // Catch: Exception -> L68
        return;
    L65:
        JSONObject r11 = new JSONObject(r8.f3172b);     // Catch: Exception -> L68
        g(r11.getInt("w"), r11.getInt("h"));     // Catch: Exception -> L68
        return;
    L66:
        JSONObject r12 = new JSONObject(r8.f3172b);     // Catch: Exception -> L68
        f(r12.getInt("w"), r12.getInt("h"));     // Catch: Exception -> L68
        return;
    L86:
        return;
    L6:
        if (r0.equals("bytedcert.network.request") == false) goto L45;
        r1 = 7;
        goto L45
    L9:
        if (r0.equals("bytedcert.readyView") == false) goto L45;
        r1 = 10;
        goto L45
    L12:
        if (r0.equals("bytedcert.eventToNative") == false) goto L45;
        r1 = 6;
        goto L45
    L15:
        if (r0.equals("bytedcert.getSettings") == false) goto L45;
        r1 = 8;
        goto L45
    L18:
        if (r0.equals("bytedcert.dialogSize") == false) goto L45;
        r1 = 0;
        goto L45
    L21:
        if (r0.equals("bytedcert.dialogSize_V2") == false) goto L45;
        r1 = 1;
        goto L45
    L24:
        if (r0.equals("bytedcert.preLoadVerifyFinish") == false) goto L45;
        r1 = 11;
        goto L45
    L27:
        if (r0.equals("bytedcert.refreshVerifyViewFinish") == false) goto L45;
        r1 = 12;
        goto L45
    L30:
        if (r0.equals("bytedcert.pageEnd") == false) goto L45;
        r1 = 3;
        goto L45
    L33:
        if (r0.equals("bytedcert.verify") == false) goto L45;
        r1 = 9;
        goto L45
    L36:
        if (r0.equals("bytedcert.getTouch") == false) goto L45;
        r1 = 2;
        goto L45
    L39:
        if (r0.equals("bytedcert.h5_state_changed") == false) goto L45;
        r1 = 5;
        goto L45
    L42:
        if (r0.equals("bytedcert.verifyResult") == false) goto L45;
        r1 = 4;
    L68:
        e = move-exception;
        e.printStackTrace();
    }

    public void c() {
        throw null;
    }

    public void d(com.bytedance.bdturing.u.c r1) {
        throw null;
    }

    public void f(int r1, int r2) {
        throw null;
    }

    public void g(int r1, int r2) {
        throw null;
    }

    public void h(String r1, com.bytedance.bdturing.c r2) {
        throw null;
    }

    public void i(int r1, String r2, String r3, String r4, String r5) {
        throw null;
    }

    public void k() {
        throw null;
    }
}
