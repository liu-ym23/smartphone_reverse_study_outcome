package com.bytedance.bdturing.u;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.bdturing.g;
import com.bytedance.bdturing.q;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.matrix.common_api.INetworkApi;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import os.teatracker.IBdInstall;

/* JADX INFO: loaded from: classes.dex */
public class d implements com.bytedance.bdturing.u.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Activity f3175a;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ JSONObject f3176f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ c f3177g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ d f3178h;

        a(d r1, JSONObject r2, c r3) {
            this.f3178h = r1;
            this.f3176f = r2;
            this.f3177g = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject r0 = new JSONObject();
            String r1 = this.f3176f.optString(WsConstants.KEY_CONNECTION_URL);
            String r2 = this.f3176f.optString("method");
            String r3 = this.f3176f.optString("params");
            JSONObject r4 = this.f3176f.optJSONObject("data");
            boolean r5 = this.f3176f.optBoolean("needCommonParams");
            StringBuilder r6 = null;
            if (r3 != null) goto L38;
        L9:
            JSONObject r7 = null;
        L10:
            if (r5 == false) goto L42;
            if (r7 == null) goto L40;
        L13:
            BdTuringConfig r8 = com.bytedance.bdturing.b.f().e();     // Catch: Exception -> L37
            d r9 = this.f3178h;     // Catch: Exception -> L37
            d.c(r9, r7, r8, d.b(r9));     // Catch: Exception -> L37
            goto L42
        L40:
            r7 = new JSONObject();     // Catch: Exception -> L37
        L42:
            if (r7 == null) goto L17;
            StringBuilder r10 = com.bytedance.bdturing.x.e.d(r1, r7);     // Catch: Throwable -> L31 Exception -> L34
        L18:
            HashMap r11 = new HashMap();     // Catch: Throwable -> L31 Exception -> L34
            r11.put(INetworkApi.CONTENT_TYPE, "application/x-www-form-urlencoded");     // Catch: Throwable -> L31 Exception -> L34
            com.bytedance.bdturing.ttnet.b r12 = com.bytedance.bdturing.b.f().e().getHttpClient();     // Catch: Throwable -> L31 Exception -> L34
            if ("get".equals(r2) == false) goto L21;
            String r13 = new String(r12.get(r10.toString(), r11), kotlin.u0.d.f21429a);     // Catch: Throwable -> L31 Exception -> L34
        L29:
            r0.put("response", r13);     // Catch: Throwable -> L31 Exception -> L34
            StringBuilder r14 = new StringBuilder();
        L35:
            r14.append("data = ");
            r14.append(r0.toString());
            g.a("BDFetch", r14.toString());
            this.f3177g.d(1, r0);
            return;
        L21:
            if (r4 == null) goto L23;
            r6 = com.bytedance.bdturing.x.e.e(r4);     // Catch: Throwable -> L31 Exception -> L34
        L23:
            String r15 = r10.toString();     // Catch: Throwable -> L31 Exception -> L34
            if (r6 == null) goto L27;
            String r16 = r6.toString();     // Catch: Throwable -> L31 Exception -> L34
        L28:
            r13 = new String(r12.post(r15, r11, r16.getBytes()), kotlin.u0.d.f21429a);     // Catch: Throwable -> L31 Exception -> L34
            goto L29
        L27:
            r16 = "";
            goto L28
        L17:
            r10 = new StringBuilder(r1);     // Catch: Throwable -> L31 Exception -> L34
        L34:
            r14 = new StringBuilder();
        L31:
            th = move-exception;
            g.a("BDFetch", "data = " + r0.toString());
            this.f3177g.d(1, r0);
            throw th;
        L38:
        L8:
            r7 = null;
            goto L42
        L5:
            if (r3.isEmpty() == true) goto L9;
            r7 = new JSONObject(r3);     // Catch: Exception -> L8
            goto L10
        }
    }

    public d(Activity r1) {
        this.f3175a = r1;
    }

    static /* synthetic */ Activity b(d r0) {
        return r0.f3175a;
    }

    static /* synthetic */ void c(d r0, JSONObject r1, BdTuringConfig r2, Activity r3) {
        r0.h(r1, r2, r3);
    }

    private void h(JSONObject r3, BdTuringConfig r4, Activity r5) {
        if (r4 == null) goto L52;
        if (r3.has(IBdInstall.PARAM_APP_NAME) == true) goto L7;
        r3.put(IBdInstall.PARAM_APP_NAME, r4.getAppName());
    L7:
        if (r3.has(WsConstants.KEY_APP_VERSION) == true) goto L10;
        r3.put(WsConstants.KEY_APP_VERSION, r4.getAppVersion());
    L10:
        if (r3.has("version_code") == true) goto L13;
        r3.put("version_code", r4.getAppVersionCode());
    L13:
        if (r3.has("version_name") == true) goto L16;
        r3.put("version_name", r4.getAppVersion());
    L16:
        if (r3.has(WsConstants.KEY_APP_ID) == true) goto L19;
        r3.put(WsConstants.KEY_APP_ID, r4.getAppId());
    L19:
        if (r3.has(WsConstants.KEY_INSTALL_ID) == true) goto L22;
        r3.put(WsConstants.KEY_INSTALL_ID, r4.getInstallId());
    L22:
        if (r3.has(WsConstants.KEY_DEVICE_ID) == true) goto L25;
        r3.put(WsConstants.KEY_DEVICE_ID, r4.getDeviceId());
    L25:
        if (r3.has("device_model") == true) goto L28;
        r3.put("device_model", r4.getDeviceModel());
    L28:
        if (r3.has("device_brand") == true) goto L31;
        r3.put("device_brand", r4.getDeviceBrand());
    L31:
        if (r3.has("os_type") == true) goto L34;
        r3.put("os_type", r4.getOsType());
    L34:
        if (r3.has("os_version") == true) goto L37;
        r3.put("os_version", r4.getOsVersion());
    L37:
        if (r3.has("channel") == true) goto L40;
        r3.put("channel", r4.getChannel());
    L40:
        if (r3.has("region") == true) goto L43;
        r3.put("region", r4.getRegionType());
    L43:
        if (r3.has("sdk_version") == true) goto L46;
        r3.put("sdk_version", r4.getSdkVersion());
    L46:
        if (r3.has("language") == true) goto L49;
        r3.put("language", r4.getLanguage());
    L49:
        if (r3.has("locale") == true) goto L52;
        r3.put("locale", r4.getLocale());
    L52:
        if (r3.has("time") == true) goto L55;
        r3.put("time", System.currentTimeMillis());
    L55:
        if (r3.has("device_platform") == true) goto L58;
        r3.put("device_platform", "android");
    L58:
        if (r3.has("resolution") == true) goto L62;
        if (r5 == null) goto L63;
        r3.put("resolution", com.bytedance.bdturing.x.e.h(r5));
        return;
    L63:
        return;
    }

    @Override // com.bytedance.bdturing.u.a
    public void a(c r5) {
        String r0 = r5.f3171a;     // Catch: JSONException -> L46
        if (r0 != null) goto L5;
        return;
    L5:
        byte r1 = -1;
        switch(r0.hashCode()) {
            case -433891794: goto L30;
            case -431325456: goto L27;
            case -418116003: goto L24;
            case -268991152: goto L21;
            case 103102532: goto L18;
            case 239578933: goto L15;
            case 428780843: goto L12;
            case 1807041893: goto L9;
            default: goto L33;
        };     // Catch: JSONException -> L46
    L33:
        switch(r1) {
            case 0: goto L44;
            case 1: goto L43;
            case 2: goto L41;
            case 3: goto L39;
            case 4: goto L38;
            case 5: goto L37;
            case 6: goto L36;
            case 7: goto L35;
            default: goto L58;
        };
    L35:
        e(r5);     // Catch: JSONException -> L46
        return;
    L36:
        JSONObject r2 = new JSONObject(r5.f3172b);     // Catch: JSONException -> L46
        g(r2.optString("phone_number"), r2.optString("sms_content"));     // Catch: JSONException -> L46
        return;
    L37:
        r5.d(1, null);     // Catch: JSONException -> L46
        return;
    L38:
        i(new JSONObject(r5.f3172b).optString("text"));     // Catch: JSONException -> L46
        return;
    L39:
        j(new JSONObject(r5.f3172b).optString("text"));     // Catch: JSONException -> L46
        return;
    L43:
        JSONObject r3 = new JSONObject(r5.f3172b);     // Catch: JSONException -> L46
        f(r3.optInt("status_code"), r3.optString("message"));     // Catch: JSONException -> L46
        return;
    L44:
        d(r5);     // Catch: JSONException -> L46
        return;
    L58:
        return;
    L41:
        if (com.bytedance.bdturing.twiceverify.c.d().c() == null) goto L55;
        com.bytedance.bdturing.twiceverify.c.d().c().f();     // Catch: JSONException -> L46
        return;
    L55:
        return;
    L9:
        if (r0.equals("second_verify.openSms") == false) goto L33;
        r1 = 6;
        goto L33
    L12:
        if (r0.equals("bytedcert.getSettings") == false) goto L33;
        r1 = 7;
        goto L33
    L15:
        if (r0.equals("second_verify.showLoading") == false) goto L33;
        r1 = 4;
        goto L33
    L18:
        if (r0.equals("second_verify.isSmsAvailable") == false) goto L33;
        r1 = 5;
        goto L33
    L21:
        if (r0.equals("second_verify.hideLoading") == false) goto L33;
        r1 = 2;
        goto L33
    L24:
        if (r0.equals("second_verify.toast") == false) goto L33;
        r1 = 3;
        goto L33
    L27:
        if (r0.equals("second_verify.fetch") == false) goto L33;
        r1 = 0;
        goto L33
    L30:
        if (r0.equals("second_verify.close") == false) goto L33;
        r1 = 1;
    L46:
        e = move-exception;
        e.printStackTrace();
    }

    public void d(c r4) {
        JSONObject r0 = new JSONObject(r4.f3172b);     // Catch: Exception -> L4
        q.c().e(new a(this, r0, r4));     // Catch: Exception -> L4
        return;
    }

    public void e(c r2) {
        if (com.bytedance.bdturing.b.f().e() == null) goto L5;
        JSONObject r1 = com.bytedance.bdturing.b.f().e().getTheme(4);
    L6:
        r2.d(1, r1);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public void f(int r2, String r3) {
        com.bytedance.bdturing.twiceverify.c.b r0 = com.bytedance.bdturing.twiceverify.c.d().f();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r2 != 0) goto L7;
        r0.onSuccess();
    L8:
        Activity r1 = this.f3175a;
        if (r1 == null) goto L12;
        r1.finish();
        return;
    L12:
        return;
    L7:
        r0.a(r2, r3);
        goto L8
    }

    public void g(String r3, String r4) {
        if (this.f3175a == null) goto L6;
        Intent r0 = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + r3));
        r0.putExtra("sms_body", r4);
        this.f3175a.startActivity(r0);
        return;
    }

    public void i(String r2) {
        if (this.f3175a != null) goto L5;
        return;
    L5:
        if (com.bytedance.bdturing.twiceverify.c.d().c() == null) goto L9;
        com.bytedance.bdturing.twiceverify.c.d().c().d(this.f3175a, r2);
        return;
    }

    public void j(String r2) {
        Activity r1 = this.f3175a;
        if (r1 == null) goto L6;
        Toast.makeText(r1, r2, 0).show();
        return;
    }
}
