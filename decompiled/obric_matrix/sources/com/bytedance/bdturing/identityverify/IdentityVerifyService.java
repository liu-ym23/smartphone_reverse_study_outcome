package com.bytedance.bdturing.identityverify;

import android.app.Activity;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.bdturing.g;
import com.bytedance.bdturing.q;
import com.bytedance.bdturing.verify.b.e;
import com.bytedance.bdturing.verify.b.i;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.matrix.common_api.INetworkApi;
import java.nio.charset.Charset;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class IdentityVerifyService extends com.bytedance.bdturing.x.a implements com.bytedance.bdturing.verify.a {
    private static final String MSG_SUCCESS = "certificate_success";
    private static final String TAG = "CertifyService";
    private static final String TWO_FACTOR_VERIFY_FLOW = "webcast_risk_auth";
    private boolean isOnVerify;
    private com.bytedance.bdturing.identityverify.c mDialog;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.bytedance.bdturing.verify.b.a f3066f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Activity f3067g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ com.bytedance.bdturing.c f3068h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ IdentityVerifyService f3069i;

        a(IdentityVerifyService r1, com.bytedance.bdturing.verify.b.a r2, Activity r3, com.bytedance.bdturing.c r4) {
            this.f3069i = r1;
            this.f3066f = r2;
            this.f3067g = r3;
            this.f3068h = r4;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((e) this.f3066f).t() == false) goto L5;
            IdentityVerifyService.access$000(this.f3069i, this.f3067g, this.f3066f, this.f3068h);
            return;
        L5:
            IdentityVerifyService.access$100(this.f3069i, this.f3067g, this.f3066f, this.f3068h);
        }
    }

    class b implements com.bytedance.bdturing.identityverify.c.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.bytedance.bdturing.verify.b.a f3070a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f3071b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.bytedance.bdturing.c f3072c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ IdentityVerifyService f3073d;

        b(IdentityVerifyService r1, com.bytedance.bdturing.verify.b.a r2, Activity r3, com.bytedance.bdturing.c r4) {
            this.f3073d = r1;
            this.f3070a = r2;
            this.f3071b = r3;
            this.f3072c = r4;
        }

        @Override // com.bytedance.bdturing.identityverify.c.d
        public void a() {
            com.bytedance.bdturing.e.b(0);
            IdentityVerifyService.access$200(this.f3073d, (e) this.f3070a, this.f3071b, this.f3072c);
        }

        @Override // com.bytedance.bdturing.identityverify.c.d
        public void onCancel() {
            g.b(IdentityVerifyService.TAG, "cert verify cancel by user");
            com.bytedance.bdturing.e.b(1);
            this.f3071b.getApplication().unregisterActivityLifecycleCallbacks(this.f3073d);
            IdentityVerifyService.access$300(this.f3073d, false);
            JSONObject r0 = new JSONObject();
            com.bytedance.bdturing.x.d.a(r0, "errorMsg", "cert verify cancel by user");
            IdentityVerifyService.access$400(this.f3073d, false, r0, this.f3072c);
        }
    }

    class c implements com.bytedance.bdturing.identityverify.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.bytedance.bdturing.c f3074a;

        c(IdentityVerifyService r1, com.bytedance.bdturing.c r2, e r3) {
            this.f3074a = r2;
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ e f3075f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ JSONObject f3076g;

        d(IdentityVerifyService r1, e r2, JSONObject r3) {
            this.f3075f = r2;
            this.f3076g = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            String r0 = this.f3075f.k();     // Catch: Exception -> L24
            if (TextUtils.isEmpty(r0) == true) goto L31;
            JSONObject r1 = new JSONObject();     // Catch: Exception -> L24
            long r2 = 0;
            JSONObject r5 = null;
            if (com.bytedance.bdturing.b.f().e() == null) goto L8;
            String r4 = com.bytedance.bdturing.b.f().e().getAppId();     // Catch: Exception -> L24
        L29:
        L13:
            e = move-exception;
            e.printStackTrace();     // Catch: Exception -> L24
        L15:
            r1.put(WsConstants.KEY_APP_ID, r2);     // Catch: Exception -> L24
            r1.put("scene", this.f3075f.s());     // Catch: Exception -> L24
            r1.put("detail", this.f3075f.q());     // Catch: Exception -> L24
            JSONObject r7 = this.f3076g;     // Catch: Exception -> L24
            if (r7 == null) goto L19;
            r5 = r7.optJSONObject("ext_data");     // Catch: Exception -> L24
        L19:
            if (r5 == null) goto L21;
            String r3 = r5.optString("ticket");     // Catch: Exception -> L24
        L22:
            r1.put("ticket", r3);     // Catch: Exception -> L24
            String r8 = r1.toString();     // Catch: Exception -> L24
            Charset r6 = kotlin.u0.d.f21429a;     // Catch: Exception -> L24
            byte[] r9 = r8.getBytes(r6);     // Catch: Exception -> L24
            com.bytedance.bdturing.ttnet.b r10 = com.bytedance.bdturing.b.f().e().getHttpClient();     // Catch: Exception -> L24
            HashMap r11 = new HashMap();     // Catch: Exception -> L24
            r11.put(INetworkApi.CONTENT_TYPE, INetworkApi.DEFAULT_CONTENT_TYPE);     // Catch: Exception -> L24
            g.c(IdentityVerifyService.TAG, "===>reportVerifyResult finish stateCode:" + new JSONObject(new String(r10.post(r0, r11, r9), r6)).optInt(LocationMonitorConst.ERR_CODE, -1));     // Catch: Exception -> L24
            return;
        L21:
            r3 = "";
            goto L22
        L10:
            if (TextUtils.isEmpty(r4) == true) goto L15;
            r2 = Long.parseLong(r4);     // Catch: Exception -> L13
        L8:
            r4 = null;
            goto L29
        L31:
            return;
        L24:
            e = move-exception;
            e.printStackTrace();
        }
    }

    public IdentityVerifyService() {
    }

    static /* synthetic */ void access$000(IdentityVerifyService r0, Activity r1, com.bytedance.bdturing.verify.b.a r2, com.bytedance.bdturing.c r3) {
        r0.verifyWithDialog(r1, r2, r3);
    }

    static /* synthetic */ void access$100(IdentityVerifyService r0, Activity r1, com.bytedance.bdturing.verify.b.a r2, com.bytedance.bdturing.c r3) {
        r0.verifyWithOutDialog(r1, r2, r3);
    }

    static /* synthetic */ void access$200(IdentityVerifyService r0, e r1, Activity r2, com.bytedance.bdturing.c r3) {
        r0.doVerify(r1, r2, r3);
    }

    static /* synthetic */ void access$300(IdentityVerifyService r0, boolean r1) {
        r0.setVerifySate(r1);
    }

    static /* synthetic */ void access$400(IdentityVerifyService r0, boolean r1, JSONObject r2, com.bytedance.bdturing.c r3) {
        r0.noticeResult(r1, r2, r3);
    }

    static /* synthetic */ boolean access$500(IdentityVerifyService r0, JSONObject r1, JSONObject r2) {
        return r0.isVerifySuccess(r1, r2);
    }

    static /* synthetic */ void access$600(IdentityVerifyService r0, JSONObject r1, e r2) {
        r0.reportVerifyResult(r1, r2);
    }

    private void doVerify(e r11, Activity r12, com.bytedance.bdturing.c r13) {
        String r0 = r11.s();
        String r1 = r11.u();
        String r2 = r11.r();
        g.b(TAG, "===>execute:scene=" + r0 + ":channel=" + r1 + ":flow=" + r2);
        if (com.bytedance.bdturing.b.f().e() == null) goto L5;
        com.bytedance.bdturing.identityverify.a r3 = com.bytedance.bdturing.b.f().e().getIdentityVerifyDepend();
    L7:
        if (r3 != null) goto L25;
        g.c(TAG, "certVerifyDepend is null");
        JSONObject r14 = new JSONObject();
        com.bytedance.bdturing.x.d.a(r14, NotificationCompat.CATEGORY_MESSAGE, "certVerifyDepend is null");
        noticeResult(false, r14, r13);
        return;
    L25:
        HashMap r8 = new HashMap();     // Catch: Exception -> L21
        r8.put("scene", r0);     // Catch: Exception -> L21
        r8.put("flow", r2);     // Catch: Exception -> L21
        r8.put("cert_app_id", com.bytedance.bdturing.b.f().e().getAppId());     // Catch: Exception -> L21
        r8.put("mode", BDLocationException.ERROR_TIMEOUT);     // Catch: Exception -> L21
        r8.put("source", r1);     // Catch: Exception -> L21
        r8.put("use_new_api", "true");     // Catch: Exception -> L21
        if (TextUtils.isEmpty(r11.v()) == true) goto L13;
        r8.put("ticket", r11.v());     // Catch: Exception -> L21
    L13:
        if (com.bytedance.bdturing.b.f().e().getRegionType() != BdTuringConfig.c.f3014k) goto L15;
        boolean r4 = true;
    L16:
        com.bytedance.bdturing.identityverify.d r5 = new com.bytedance.bdturing.identityverify.d(r12, r8, r4);     // Catch: Exception -> L21
        com.bytedance.bdturing.w.c r15 = com.bytedance.bdturing.b.f().e().getThemeConfig();     // Catch: Exception -> L21
        if (r15 != null) goto L19;
        r5.a(null);     // Catch: Exception -> L21
        r3.a(r5, new c(this, r13, r11));     // Catch: Exception -> L21
        com.bytedance.bdturing.e.d(0);     // Catch: Exception -> L21
        return;
    L19:
        r15.b();     // Catch: Exception -> L21
        throw null;
    L15:
        r4 = false;
    L21:
        e = move-exception;
        e.printStackTrace();
        com.bytedance.bdturing.e.d(1);
        JSONObject r16 = new JSONObject();
        com.bytedance.bdturing.x.d.a(r16, NotificationCompat.CATEGORY_MESSAGE, "load cert sdk failed");
        noticeResult(false, r16, r13);
        return;
    L5:
        r3 = null;
        goto L7
    }

    private boolean isVerifySuccess(JSONObject r2, JSONObject r3) {
        if (r2 == null) goto L8;
        int r1 = r2.optInt(WsConstants.ERROR_CODE, -1);
        String r4 = r2.optString("error_msg");
        if (MSG_SUCCESS.equals(r4) == false) goto L7;
        if (r1 != 0) goto L7;
        return true;
    L7:
        com.bytedance.bdturing.x.d.a(r3, "errorCode", Integer.valueOf(r1));
        com.bytedance.bdturing.x.d.a(r3, "errorMsg", r4);
    L8:
        return false;
    }

    private void noticeResult(boolean r3, JSONObject r4, com.bytedance.bdturing.c r5) {
        setVerifySate(false);
        this.mDialog = null;
        if (r5 == null) goto L15;
        if (r3 == false) goto L6;
        r5.b(0, new JSONObject());     // Catch: Exception -> L8
    L11:
        return;
    L6:
        r5.a(1, r4);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    private void reportVerifyResult(JSONObject r3, e r4) {
        q.c().e(new d(this, r4, r3));
    }

    private synchronized void setVerifySate(boolean r1) {
        monitor-enter(this);
        this.isOnVerify = r1;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private void verifyWithDialog(Activity r4, com.bytedance.bdturing.verify.b.a r5, @NonNull com.bytedance.bdturing.c r6) {
        r4.getApplication().unregisterActivityLifecycleCallbacks(this);     // Catch: Exception -> L9
        this.mDialog = new com.bytedance.bdturing.identityverify.c(r4, new b(this, r5, r4, r6));     // Catch: Exception -> L9
        if (r4.isFinishing() == false) goto L6;
        return;
    L6:
        if (this.mDialog.isShowing() == true) goto L19;
        r4.getApplication().registerActivityLifecycleCallbacks(this);     // Catch: Exception -> L9
        this.mDialog.show();     // Catch: Exception -> L9
        com.bytedance.bdturing.e.c(0);     // Catch: Exception -> L9
        setVerifySate(true);     // Catch: Exception -> L9
        return;
    L19:
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        com.bytedance.bdturing.e.c(1);
        if (r4 == null) goto L13;
        r4.getApplication().unregisterActivityLifecycleCallbacks(this);
    L13:
        if (r6 == null) goto L20;
        JSONObject r3 = new JSONObject();
        com.bytedance.bdturing.x.d.a(r3, "errorMsg", "hand cert verify fail");
        r6.a(1, r3);
        return;
    }

    private void verifyWithOutDialog(Activity r2, com.bytedance.bdturing.verify.b.a r3, com.bytedance.bdturing.c r4) {
        com.bytedance.bdturing.e.c(2);     // Catch: Exception -> L5
        setVerifySate(true);     // Catch: Exception -> L5
        doVerify((e) r3, r2, r4);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        JSONObject r5 = new JSONObject();
        com.bytedance.bdturing.x.d.a(r5, "errorMsg", "doVerify exception");
        noticeResult(false, r5, r4);
    }

    @Override // com.bytedance.bdturing.verify.a
    public boolean execute(@NonNull com.bytedance.bdturing.verify.b.a r6, @NonNull com.bytedance.bdturing.c r7) {
        if ((r6 instanceof i) == false) goto L5;
        com.bytedance.bdturing.verify.b.a r0 = ((i) r6).q();
    L7:
        if (r0 != null) goto L9;
    L20:
        JSONObject r5 = new JSONObject();
        com.bytedance.bdturing.x.d.a(r5, "errorMsg", "request type is not CertifyRequest!");
        r7.a(996, r5);
        return true;
    L9:
        if ((r0 instanceof e) == false) goto L20;
        if (isOnVerify() == false) goto L15;
        r7.a(998, null);
        return true;
    L15:
        Activity r8 = r6.b();
        if (r8 == null) goto L18;
        r8.runOnUiThread(new a(this, r0, r8, r7));
    L19:
        return true;
    L18:
        g.b(TAG, "topActivity is null");
        JSONObject r9 = new JSONObject();
        com.bytedance.bdturing.x.d.a(r9, "errorMsg", "topActivity is null");
        noticeResult(false, r9, r7);
        goto L19
    L5:
        r0 = null;
        goto L7
    }

    public synchronized boolean isOnVerify() {
        monitor-enter(this);
        boolean r0 = this.isOnVerify;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.bdturing.verify.a
    public boolean isProcess(int r1) {
        if (14 != r1) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.bdturing.x.a, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity r2) {
        com.bytedance.bdturing.identityverify.c r0 = this.mDialog;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShowing() == true) goto L7;
        return;
    L7:
        if (this.mDialog.getOwnerActivity() != r2) goto L12;
        setVerifySate(false);
        this.mDialog.dismiss();
        this.mDialog = null;
        return;
    }
}
