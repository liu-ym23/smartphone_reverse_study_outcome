package com.bytedance.mpaas.bdtracker;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.bdinstall.m0;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.mpaas.applog.IBdtrackerService;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.h;
import kotlin.i;
import kotlin.n0.c.l;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import org.json.JSONObject;
import os.teatracker.e;
import os.teatracker.k;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0011H\u0016J\b\u0010\u001f\u001a\u0004\u0018\u00010\u0011J\b\u0010 \u001a\u00020\u0011H\u0016J\b\u0010!\u001a\u00020\u0011H\u0016J\n\u0010\"\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010#\u001a\u00020\u0011H\u0016J\b\u0010$\u001a\u00020\u0011H\u0016J\b\u0010%\u001a\u00020&H\u0016J\u0018\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u00112\u0006\u0010)\u001a\u00020*H\u0016J<\u0010+\u001a\u00020&2\u0006\u0010,\u001a\u00020\u00112\u0006\u0010-\u001a\u00020\u00112\b\u0010.\u001a\u0004\u0018\u00010\u00112\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002002\b\u00102\u001a\u0004\u0018\u000103H\u0016J\u001a\u00104\u001a\u00020&2\u0006\u00105\u001a\u00020\u00112\b\u00106\u001a\u0004\u0018\u000103H\u0016J\u001a\u00107\u001a\u00020&2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u001108J\u000e\u00109\u001a\u00020\u00112\u0006\u0010:\u001a\u00020\u0011J$\u0010;\u001a\u00020&2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011082\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J,\u0010<\u001a\u00020&2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011082\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010=\u001a\u00020*H\u0016J\u0010\u0010>\u001a\u00020&2\u0006\u0010?\u001a\u00020\u000bH\u0016J\u0010\u0010@\u001a\u00020&2\u0006\u0010A\u001a\u00020\u0011H\u0016J\u0010\u0010B\u001a\u00020&2\u0006\u0010C\u001a\u000200H\u0016J\u0010\u0010D\u001a\u00020&2\u0006\u0010?\u001a\u00020\u000bH\u0016R\u001d\u0010\u0003\u001a\u0004\u0018\u00010\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u000e\u0010\u0019\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Lcom/bytedance/mpaas/bdtracker/BdtrackerService;", "Lcom/bytedance/mpaas/applog/IBdtrackerService;", "()V", "curDidField", "Ljava/lang/reflect/Field;", "getCurDidField", "()Ljava/lang/reflect/Field;", "curDidField$delegate", "Lkotlin/Lazy;", "dataListenerMgr", "Lcom/bytedance/mpaas/common/ListenerManager;", "Lcom/bytedance/mpaas/applog/IBdtrackerDataListener;", "getDataListenerMgr", "()Lcom/bytedance/mpaas/common/ListenerManager;", "setDataListenerMgr", "(Lcom/bytedance/mpaas/common/ListenerManager;)V", "mDid", "", "getMDid", "()Ljava/lang/String;", "setMDid", "(Ljava/lang/String;)V", "mIid", "getMIid", "setMIid", "mSessionKey", "addCommonParams", WsConstants.KEY_CONNECTION_URL, "isApi", "", "getClientUdid", "getCurDidViaReflection", "getDeviceId", "getInstallId", "getSessionId", "getSessionKey", "getUserId", "onActivityPaused", "", "onActivityResume", "activityName", "hashCode", "", "onEvent", "category", LocationMonitorConst.TAG, "label", "value", "", "extValue", "params", "Lorg/json/JSONObject;", "onEventV3", "eventName", "jsonObject", "processDeviceIdParams", "", "processDeviceIdUrl", "urlString", "putCommonParams", "putCommonParamsWithLevel", "level", "registerDataListener", "listener", "setSessionKey", "sessionKey", "setUserId", "userId", "unregisterDataListener", "ostracker_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BdtrackerService implements IBdtrackerService {
    private final h curDidField$delegate;
    private d.b.m.b.a<com.bytedance.mpaas.applog.a> dataListenerMgr;
    private String mDid;
    private String mIid;
    private String mSessionKey;

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b"}, d2 = {"com/bytedance/mpaas/bdtracker/BdtrackerService$1", "Los/teatracker/TeaAgent$TeaListener;", "onDeviceIdLoaded", "", "did", "", "onInstallIdLoaded", WsConstants.KEY_INSTALL_ID, "ostracker_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a implements e.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BdtrackerService f5253a;

        /* JADX INFO: renamed from: com.bytedance.mpaas.bdtracker.BdtrackerService$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/bytedance/mpaas/applog/IBdtrackerDataListener;", "invoke", "(Lcom/bytedance/mpaas/applog/IBdtrackerDataListener;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
        static final class C0167a extends q implements l<com.bytedance.mpaas.applog.a, Boolean> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ BdtrackerService f5254f;

            C0167a(BdtrackerService r1) {
                this.f5254f = r1;
                super(1);
            }

            public final Boolean a(com.bytedance.mpaas.applog.a r2) {
                o.f(r2, "it");
                r2.a(this.f5254f.getMDid(), this.f5254f.getMIid());
                return Boolean.FALSE;
            }

            @Override // kotlin.n0.c.l
            public /* bridge */ /* synthetic */ Boolean invoke(com.bytedance.mpaas.applog.a r1) {
                return a(r1);
            }
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/bytedance/mpaas/applog/IBdtrackerDataListener;", "invoke", "(Lcom/bytedance/mpaas/applog/IBdtrackerDataListener;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
        static final class b extends q implements l<com.bytedance.mpaas.applog.a, Boolean> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ BdtrackerService f5255f;

            b(BdtrackerService r1) {
                this.f5255f = r1;
                super(1);
            }

            public final Boolean a(com.bytedance.mpaas.applog.a r2) {
                o.f(r2, "it");
                r2.a(this.f5255f.getMDid(), this.f5255f.getMIid());
                return Boolean.FALSE;
            }

            @Override // kotlin.n0.c.l
            public /* bridge */ /* synthetic */ Boolean invoke(com.bytedance.mpaas.applog.a r1) {
                return a(r1);
            }
        }

        a(BdtrackerService r1) {
            this.f5253a = r1;
        }

        @Override // os.teatracker.e.a
        public void a(String r2) {
            if (TextUtils.isEmpty(r2) == false) goto L5;
            return;
        L5:
            this.f5253a.setMDid(r2);
            if (TextUtils.isEmpty(this.f5253a.getMIid()) == true) goto L12;
            this.f5253a.getDataListenerMgr().a(new C0167a(this.f5253a));     // Catch: Exception -> L9
            return;
        L13:
            return;
        }

        @Override // os.teatracker.e.a
        public void b(String r2) {
            if (TextUtils.isEmpty(r2) == false) goto L5;
            return;
        L5:
            this.f5253a.setMIid(r2);
            if (TextUtils.isEmpty(this.f5253a.getMDid()) == true) goto L12;
            this.f5253a.getDataListenerMgr().a(new b(this.f5253a));     // Catch: Exception -> L9
            return;
        L13:
            return;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/lang/reflect/Field;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class b extends q implements kotlin.n0.c.a<Field> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f5256f = null;

        static {
            f5256f = new b();
        }

        b() {
            super(0);
        }

        public final Field a() {
            Field r1 = Class.forName("com.obric.matrix.dataanalysis.DeviceIdUtil").getDeclaredField("deviceId");     // Catch: Exception -> L4
            r1.setAccessible(true);     // Catch: Exception -> L4
            return r1;
        L4:
            return null;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Field invoke() {
            return a();
        }
    }

    public BdtrackerService() {
        e.a(new a(this));
        this.mSessionKey = "";
        this.curDidField$delegate = i.b(b.f5256f);
        this.dataListenerMgr = new d.b.m.b.a();
    }

    private final Field getCurDidField() {
        return (Field) this.curDidField$delegate.getValue();
    }

    @Override // com.bytedance.mpaas.applog.IBdtrackerService
    public String addCommonParams(String r4, boolean r5) {
        o.f(r4, WsConstants.KEY_CONNECTION_URL);
        String r6 = com.bytedance.bdinstall.i.c(com.bytedance.mpaas.app.a.a(), new StringBuilder(r4), k.b(com.bytedance.mpaas.app.a.a()), r5, m0.f2843g);
        o.e(r6, "finalUrl");
        return processDeviceIdUrl(r6);
    }

    @Override // com.bytedance.mpaas.applog.IBdtrackerService
    public String getClientUdid() {
        String r0 = e.e();
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public final String getCurDidViaReflection() {
        Field r2 = getCurDidField();     // Catch: Exception -> L12
        if (r2 == null) goto L6;
        Object r3 = r2.get(null);     // Catch: Exception -> L12
    L8:
        if ((r3 instanceof String) == false) goto L15;
        return (String) r3;
    L15:
        return null;
    L6:
        r3 = null;
    L16:
        return null;
    }

    public final d.b.m.b.a<com.bytedance.mpaas.applog.a> getDataListenerMgr() {
        return this.dataListenerMgr;
    }

    @Override // com.bytedance.mpaas.applog.IBdtrackerService
    public String getDeviceId() {
        String r0 = e.c();
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    @Override // com.bytedance.mpaas.applog.IBdtrackerService
    public String getInstallId() {
        d.b.m.d.a.g("mPaaS", new Object[]{"pico not support"});
        String r2 = e.d();
        o.e(r2, "getInstallId()");
        return r2;
    }

    public final String getMDid() {
        return this.mDid;
    }

    public final String getMIid() {
        return this.mIid;
    }

    @Override // com.bytedance.mpaas.applog.IBdtrackerService
    public String getSessionId() {
        return null;
    }

    @Override // com.bytedance.mpaas.applog.IBdtrackerService
    public String getSessionKey() {
        return this.mSessionKey;
    }

    @Override // com.bytedance.mpaas.applog.IBdtrackerService
    public String getUserId() {
        d.b.m.d.a.g("mPaaS", new Object[]{"pico not support"});
        return "";
    }

    @Override // com.bytedance.mpaas.applog.IBdtrackerService
    public void onActivityPaused() {
        d.b.m.d.a.g("mPaaS", new Object[]{"pico not support"});
    }

    @Override // com.bytedance.mpaas.applog.IBdtrackerService
    public void onActivityResume(String r1, int r2) {
        o.f(r1, "activityName");
        d.b.m.d.a.g("mPaaS", new Object[]{"pico not support"});
    }

    @Override // com.bytedance.mpaas.applog.IBdtrackerService
    public void onEvent(String r1, String r2, String r3, long r4, long r6, JSONObject r8) {
        o.f(r1, "category");
        o.f(r2, LocationMonitorConst.TAG);
        d.b.m.d.a.g("mPaaS", new Object[]{"pico not support"});
    }

    @Override // com.bytedance.mpaas.applog.IBdtrackerService
    public void onEventV3(String r1, JSONObject r2) {
        o.f(r1, "eventName");
        e.g(r1, r2);
    }

    public final void processDeviceIdParams(Map<String, String> r5) {
        o.f(r5, "params");
        com.obric.matrix.r.c.e.d("mPaaS", "processDeviceIdParams 原始params=" + r5);
        String r4 = com.obric.matrix.ostracker_api.b.c();
        String r1 = "";
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        String r2 = com.obric.matrix.ostracker_api.b.e();
        if (r2 == null) goto L9;
        r1 = r2;
    L9:
        com.obric.matrix.r.c.e.d("mPaaS", "processDeviceIdParams 尝试补充上device_id字段=" + r4 + ", iid=" + r1);
        if (com.obric.matrix.dataanalysis.i.a(r4) == true) goto L12;
    L14:
        com.obric.matrix.r.c.e.d("mPaaS", "processDeviceIdParams 最终params=" + r5);
        return;
    L12:
        if (com.obric.matrix.dataanalysis.i.a(r1) == false) goto L14;
        r5.put(WsConstants.KEY_DEVICE_ID, r4);
        r5.put(WsConstants.KEY_INSTALL_ID, r1);
        goto L14
    }

    public final String processDeviceIdUrl(String r8) {
        o.f(r8, "urlString");
        com.obric.matrix.r.c.e.d("mPaaS", "processDeviceIdUrl 原始url=" + r8);
        Uri r7 = Uri.parse(r8);
        Uri.Builder r1 = r7.buildUpon().clearQuery();
        LinkedHashMap r2 = new LinkedHashMap();
        Set<String> r3 = r7.getQueryParameterNames();
        o.e(r3, "uri.queryParameterNames");
        Iterator<T> r4 = r3.iterator();
    L3:
        String r5 = "";
        if (r4.hasNext() == false) goto L10;
        String r6 = (String) r4.next();
        String r9 = r7.getQueryParameter(r6);
        if (r9 == null) goto L9;
        r5 = r9;
    L9:
        o.e(r5, "uri.getQueryParameter(paramName) ?: \"\"");
        o.e(r6, "paramName");
        r2.put(r6, r5);
        goto L3
    L10:
        String r10 = com.obric.matrix.ostracker_api.b.c();
        if (r10 == null) goto L14;
        r5 = r10;
    L14:
        com.obric.matrix.r.c.e.d("mPaaS", "尝试给" + r8 + " 补充上device_id字段=" + r5);
        if (com.obric.matrix.dataanalysis.i.a(r5) == false) goto L17;
        r2.put(WsConstants.KEY_DEVICE_ID, r5);
    L17:
        Iterator r11 = r2.entrySet().iterator();
    L19:
        if (r11.hasNext() == false) goto L21;
        Map.Entry r12 = (Map.Entry) r11.next();
        r1.appendQueryParameter((String) r12.getKey(), (String) r12.getValue());
        goto L19
    L21:
        String r13 = r1.build().toString();
        o.e(r13, "builder.build().toString()");
        com.obric.matrix.r.c.e.d("mPaaS", "processDeviceIdUrl 最终url=" + r13);
        return r13;
    }

    @Override // com.bytedance.mpaas.applog.IBdtrackerService
    public void putCommonParams(Map<String, String> r3, boolean r4) {
        o.f(r3, "params");
        com.obric.matrix.r.c.e.d("mPaaS", "putCommonParams 原始params=" + r3);
        com.bytedance.bdinstall.i.p(com.bytedance.mpaas.app.a.a(), r3, r4, m0.f2843g);
        processDeviceIdParams(r3);
    }

    @Override // com.bytedance.mpaas.applog.IBdtrackerService
    public void putCommonParamsWithLevel(Map<String, String> r3, boolean r4, int r5) {
        o.f(r3, "params");
        com.obric.matrix.r.c.e.d("mPaaS", "putCommonParamsWithLevel 原始params=" + r3);
        if (r5 != 0) goto L5;
        Context r6 = com.bytedance.mpaas.app.a.a();
        m0 r0 = m0.f2842f;
    L9:
        com.bytedance.bdinstall.i.p(r6, r3, r4, r0);
    L10:
        processDeviceIdParams(r3);
        return;
    L5:
        if (r5 != 1) goto L10;
        r6 = com.bytedance.mpaas.app.a.a();
        r0 = m0.f2843g;
        goto L9
    }

    @Override // com.bytedance.mpaas.applog.IBdtrackerService
    public void registerDataListener(com.bytedance.mpaas.applog.a r2) {
        o.f(r2, "listener");
        this.dataListenerMgr.b(r2);
    }

    public final void setDataListenerMgr(d.b.m.b.a<com.bytedance.mpaas.applog.a> r2) {
        o.f(r2, "<set-?>");
        this.dataListenerMgr = r2;
    }

    public final void setMDid(String r1) {
        this.mDid = r1;
    }

    public final void setMIid(String r1) {
        this.mIid = r1;
    }

    @Override // com.bytedance.mpaas.applog.IBdtrackerService
    public void setSessionKey(String r2) {
        o.f(r2, "sessionKey");
        this.mSessionKey = r2;
    }

    @Override // com.bytedance.mpaas.applog.IBdtrackerService
    public void setUserId(long r1) {
        d.b.m.d.a.g("mPaaS", new Object[]{"pico not support"});
    }

    @Override // com.bytedance.mpaas.applog.IBdtrackerService
    public void unregisterDataListener(com.bytedance.mpaas.applog.a r2) {
        o.f(r2, "listener");
        this.dataListenerMgr.c(r2);
    }
}
