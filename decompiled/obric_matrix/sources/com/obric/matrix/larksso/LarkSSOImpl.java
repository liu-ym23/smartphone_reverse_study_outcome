package com.obric.matrix.larksso;

import com.bytedance.feedbackerlib.Feedbacker;
import com.bytedance.ttnet.TTNetInit;
import com.obric.matrix.larksso_api.ILarkSSOService;
import kotlin.Metadata;
import kotlin.n0.d.g;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t*\u0001\u0004\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001c\u001dB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\rH\u0016J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\rH\u0016J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0007H\u0016J\u000e\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u0011R\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/obric/matrix/larksso/LarkSSOImpl;", "Lcom/obric/matrix/larksso_api/ILarkSSOService;", "()V", "feedbackerCallback", "com/obric/matrix/larksso/LarkSSOImpl$feedbackerCallback$1", "Lcom/obric/matrix/larksso/LarkSSOImpl$feedbackerCallback$1;", "onLarkSSOCallback", "Lcom/obric/matrix/larksso_api/OnLarkSSOCallback;", "getOnLarkSSOCallback", "()Lcom/obric/matrix/larksso_api/OnLarkSSOCallback;", "setOnLarkSSOCallback", "(Lcom/obric/matrix/larksso_api/OnLarkSSOCallback;)V", "authIfNeed", "", "configInfo", "Lcom/obric/matrix/larksso/LarkSSOImpl$ConfigInfo;", "force", "", "clearCache", "doInit", "getAccessToken", "", "init", "larkSSOAuthIfNeeded", "setCallback", "ssoCallback", "switchToBoe", TTNetInit.DOMAIN_BOE_KEY, "Companion", "ConfigInfo", "larksso_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LarkSSOImpl implements ILarkSSOService {
    public static final a Companion = null;
    private static final String TAG = "LarkSSOImpl";
    private final d feedbackerCallback;
    private com.obric.matrix.larksso_api.a onLarkSSOCallback;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/matrix/larksso/LarkSSOImpl$Companion;", "", "()V", "TAG", "", "larksso_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/obric/matrix/larksso/LarkSSOImpl$ConfigInfo;", "", "appId", "", "deviceId", "", "updateVersionCode", "channel", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()I", "getChannel", "()Ljava/lang/String;", "getDeviceId", "getUpdateVersionCode", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "larksso_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f9108a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f9109b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f9110c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f9111d;

        public b(int r2, String r3, String r4, String r5) {
            o.f(r3, "deviceId");
            o.f(r4, "updateVersionCode");
            o.f(r5, "channel");
            this.f9108a = r2;
            this.f9109b = r3;
            this.f9110c = r4;
            this.f9111d = r5;
        }

        public final int a() {
            return this.f9108a;
        }

        public final String b() {
            return this.f9111d;
        }

        public final String c() {
            return this.f9109b;
        }

        public final String d() {
            return this.f9110c;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.f9108a == r6.f9108a) goto L12;
            return false;
        L12:
            if (o.a(this.f9109b, r6.f9109b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f9110c, r6.f9110c) == true) goto L18;
            return false;
        L18:
            if (o.a(this.f9111d, r6.f9111d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((Integer.hashCode(this.f9108a) * 31) + this.f9109b.hashCode()) * 31) + this.f9110c.hashCode()) * 31) + this.f9111d.hashCode();
        }

        public String toString() {
            return "ConfigInfo(appId=" + this.f9108a + ", deviceId=" + this.f9109b + ", updateVersionCode=" + this.f9110c + ", channel=" + this.f9111d + ')';
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u0016¨\u0006\u000f"}, d2 = {"com/obric/matrix/larksso/LarkSSOImpl$doInit$1", "Lcom/bytedance/feedbackerlib/Feedbacker$IFeedbackCommonInfo;", "getALogFilesDir", "", "getAid", "", "getAppId", "getChannel", "getDid", "getOnFeedbackClickListener", "Lcom/bytedance/feedbackerlib/Feedbacker$OnFeedbackClickListener;", "getOnMediasUploadFailedListener", "Lcom/bytedance/feedbackerlib/Feedbacker$OnMediasUploadFailedListener;", "getUpdateVersionCode", "getUserId", "larksso_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class c implements Feedbacker.IFeedbackCommonInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f9112a;

        c(b r1) {
            this.f9112a = r1;
        }

        private static final void a() {
        }

        private static final void b() {
        }

        public static /* synthetic */ void c() {
            a();
        }

        public static /* synthetic */ void d() {
            b();
        }

        @Override // com.bytedance.feedbackerlib.Feedbacker.IFeedbackCommonInfo
        public String getALogFilesDir() {
            return null;
        }

        @Override // com.bytedance.feedbackerlib.Feedbacker.IFeedbackCommonInfo
        public int getAid() {
            return this.f9112a.a();
        }

        @Override // com.bytedance.feedbackerlib.Feedbacker.IFeedbackCommonInfo
        public String getAppId() {
            return "lka5086bf562bb500c";
        }

        @Override // com.bytedance.feedbackerlib.Feedbacker.IFeedbackCommonInfo
        public String getChannel() {
            return this.f9112a.b();
        }

        @Override // com.bytedance.feedbackerlib.Feedbacker.IFeedbackCommonInfo
        public String getDid() {
            return this.f9112a.c();
        }

        @Override // com.bytedance.feedbackerlib.Feedbacker.IFeedbackCommonInfo
        public Feedbacker.n getOnFeedbackClickListener() {
            return com.obric.matrix.larksso.a.f9114a;
        }

        @Override // com.bytedance.feedbackerlib.Feedbacker.IFeedbackCommonInfo
        public Feedbacker.o getOnMediasUploadFailedListener() {
            return com.obric.matrix.larksso.b.f9115a;
        }

        @Override // com.bytedance.feedbackerlib.Feedbacker.IFeedbackCommonInfo
        public String getUpdateVersionCode() {
            return this.f9112a.d();
        }

        @Override // com.bytedance.feedbackerlib.Feedbacker.IFeedbackCommonInfo
        public String getUserId() {
            return null;
        }
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016¨\u0006\b"}, d2 = {"com/obric/matrix/larksso/LarkSSOImpl$feedbackerCallback$1", "Lcom/bytedance/feedbackerlib/Feedbacker$LarkSSOCallback;", "onLarkSSOBypassed", "", "onLarkSSOSuccess", "larkSSOEmail", "", "onLarkSSPFailed", "larksso_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class d implements Feedbacker.m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ LarkSSOImpl f9113a;

        d(LarkSSOImpl r1) {
            this.f9113a = r1;
        }

        @Override // com.bytedance.feedbackerlib.Feedbacker.m
        public void a() {
            String r0 = Feedbacker.getLarkSSOEmail();
            com.obric.matrix.r.c.c.b(LarkSSOImpl.TAG, "Bypassed: called " + r0);
            com.obric.matrix.larksso_api.a r3 = this.f9113a.getOnLarkSSOCallback();
            if (r3 == null) goto L8;
            if (r0 != null) goto L6;
            r0 = "";
        L6:
            r3.a(r0);
            return;
        }

        @Override // com.bytedance.feedbackerlib.Feedbacker.m
        public void b(String r3) {
            o.f(r3, "larkSSOEmail");
            com.obric.matrix.r.c.c.b(LarkSSOImpl.TAG, "Success: called, larkSSOEmail = " + r3);
            com.obric.matrix.larksso_api.a r2 = this.f9113a.getOnLarkSSOCallback();
            if (r2 == null) goto L6;
            r2.a(r3);
            return;
        }

        @Override // com.bytedance.feedbackerlib.Feedbacker.m
        public void c() {
            com.obric.matrix.r.c.c.b(LarkSSOImpl.TAG, "PFailed: called");
            com.obric.matrix.larksso_api.a r2 = this.f9113a.getOnLarkSSOCallback();
            if (r2 == null) goto L6;
            r2.onFailed();
            return;
        }
    }

    static {
        Companion = new a(null);
    }

    public LarkSSOImpl() {
        this.feedbackerCallback = new d(this);
    }

    private final void authIfNeed(b r3, boolean r4) {
        com.obric.matrix.r.c.c.b(TAG, "initIfNeed called， configInfo = " + r3);
        String r0 = Feedbacker.getLarkSSOEmail();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L11;
        if (r4 == true) goto L11;
        return;
    L11:
        doInit(r3);
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    private final void doInit(b r3) {
        com.obric.matrix.r.c.c.b(TAG, "doInit called");
        Feedbacker.init(d.g.f.a.a.f16974a.c(), false);
        Feedbacker.registerLarkSSOCallback(this.feedbackerCallback);
        Feedbacker.setIFeedbackCommonInfo(new c(r3));
    }

    @Override // com.obric.matrix.larksso_api.ILarkSSOService
    public void clearCache() {
        Feedbacker.clearSSOCache();
    }

    @Override // com.obric.matrix.larksso_api.ILarkSSOService
    public String getAccessToken() {
        String r0 = Feedbacker.getUserAccessToken();
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public final com.obric.matrix.larksso_api.a getOnLarkSSOCallback() {
        return this.onLarkSSOCallback;
    }

    @Override // com.obric.matrix.larksso_api.ILarkSSOService
    public void init() {
        com.obric.matrix.larksso.c.f9116a.b();
    }

    @Override // com.obric.matrix.larksso_api.ILarkSSOService
    public void larkSSOAuthIfNeeded(boolean r2) {
        b r0 = com.obric.matrix.larksso.c.f9116a.a();
        if (r0 == null) goto L6;
        authIfNeed(r0, r2);
        return;
    }

    @Override // com.obric.matrix.larksso_api.ILarkSSOService
    public void setCallback(com.obric.matrix.larksso_api.a r2) {
        o.f(r2, "ssoCallback");
        this.onLarkSSOCallback = r2;
    }

    public final void setOnLarkSSOCallback(com.obric.matrix.larksso_api.a r1) {
        this.onLarkSSOCallback = r1;
    }

    public final void switchToBoe(boolean r1) {
        if (r1 == false) goto L4;
        Feedbacker.switchToBoeDomain();
        return;
    L4:
        Feedbacker.switchToOnlineDomain();
    }
}
