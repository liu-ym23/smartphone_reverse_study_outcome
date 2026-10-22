package com.ss.android.init.tasks;

import android.app.Application;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.utility.i;
import com.bytedance.common.utility.k;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.bytedance.lego.init.e.h;
import com.bytedance.mpaas.applog.IBdtrackerService;
import com.bytedance.mpaas.monitor.IMonitorService;
import com.bytedance.news.common.service.manager.d;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.s.e;
import d.b.h.a.a.h.g;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.n0.d.o;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0004J!\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/ss/android/init/tasks/TTNetInitTask;", "Lcom/bytedance/lego/init/e/h;", "Lkotlin/f0;", "b", "()V", "Lorg/json/JSONObject;", "jsonObject", "e", "(Lorg/json/JSONObject;)V", "Lcom/bytedance/ttnet/m/b;", LocationMonitorConst.INFO, "c", "(Lcom/bytedance/ttnet/m/b;Lorg/json/JSONObject;)V", "run", "", "t", "d", "(Ljava/lang/Throwable;Lorg/json/JSONObject;)V", "<init>", "init_ttnet_release"}, k = 1, mv = {1, 1, 15})
public final class TTNetInitTask extends h {

    public static final class a implements com.bytedance.mpaas.applog.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f11947a;

        a(CountDownLatch r1) {
            this.f11947a = r1;
        }

        @Override // com.bytedance.mpaas.applog.a
        public void a(String r1, String r2) {
            this.f11947a.countDown();
        }
    }

    public static final class b implements g.d<com.bytedance.ttnet.m.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f11948a;

        b(CountDownLatch r1) {
            this.f11948a = r1;
        }

        @Override // d.b.h.a.a.h.g.d
        public /* bridge */ /* synthetic */ void a(String r1, long r2, d.b.h.a.a.h.b r4) {
            f(r1, r2, (com.bytedance.ttnet.m.b) r4);
        }

        @Override // d.b.h.a.a.h.g.d
        public String addCommonParams(String r1, boolean r2) {
            o.g(r1, WsConstants.KEY_CONNECTION_URL);
            IBdtrackerService r0 = (IBdtrackerService) d.a(IBdtrackerService.class);
            if (r0 == null) goto L6;
            String r3 = r0.addCommonParams(r1, r2);
            o.b(r3, "appLogService.addCommonParams(url, isApi)");
            return r3;
        L6:
            return r1;
        }

        @Override // d.b.h.a.a.h.g.d
        public String b(String r1, boolean r2, Object... r3) {
            o.g(r1, WsConstants.KEY_CONNECTION_URL);
            o.g(r3, WsConstants.KEY_EXTRA);
            return r1;
        }

        @Override // d.b.h.a.a.h.g.d
        public /* bridge */ /* synthetic */ void c(String r1, Throwable r2, long r3, d.b.h.a.a.h.b r5) {
            e(r1, r2, r3, (com.bytedance.ttnet.m.b) r5);
        }

        @Override // d.b.h.a.a.h.g.d
        public void d() {
            IBdtrackerService r0 = (IBdtrackerService) d.a(IBdtrackerService.class);
            if (r0 == null) goto L5;
            String r1 = r0.getDeviceId();
        L6:
            if (r1 != null) goto L9;
            this.f11948a.await(2, TimeUnit.SECONDS);
            return;
        L9:
            return;
        L5:
            r1 = null;
            goto L6
        }

        public void e(String r1, Throwable r2, long r3, com.bytedance.ttnet.m.b r5) {
            o.g(r1, WsConstants.KEY_CONNECTION_URL);
            o.g(r2, "e");
        }

        public void f(String r1, long r2, com.bytedance.ttnet.m.b r4) {
            o.g(r1, WsConstants.KEY_CONNECTION_URL);
        }

        @Override // d.b.h.a.a.h.g.d
        public void putCommonParams(Map<String, String> r1, boolean r2) {
            o.g(r1, "params");
            IBdtrackerService r0 = (IBdtrackerService) d.a(IBdtrackerService.class);
            if (r0 == null) goto L6;
            r0.putCommonParams(r1, r2);
            return;
        }
    }

    public static final class c implements g.l<com.bytedance.ttnet.m.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TTNetInitTask f11949a;

        c(TTNetInitTask r1) {
            this.f11949a = r1;
        }

        @Override // d.b.h.a.a.h.g.l
        public /* bridge */ /* synthetic */ void a(long r1, long r3, String r5, String r6, d.b.h.a.a.h.b r7) {
            d(r1, r3, r5, r6, (com.bytedance.ttnet.m.b) r7);
        }

        @Override // d.b.h.a.a.h.g.l
        public /* bridge */ /* synthetic */ void b(long r1, long r3, String r5, String r6, d.b.h.a.a.h.b r7, Throwable r8) {
            c(r1, r3, r5, r6, (com.bytedance.ttnet.m.b) r7, r8);
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public void c(long r19, long r21, String r23, String r24, com.bytedance.ttnet.m.b r25, Throwable r26) {
            o.g(r26, "e");
            IMonitorService r3 = (IMonitorService) d.a(IMonitorService.class);
            if (r3 != null) goto L54;
            return;
        L54:
            String[] r14 = new String[1];     // Catch: Throwable -> L51
            int r13 = com.ss.android.k.c.a.a(r26, r14);     // Catch: Throwable -> L51
            JSONObject r12 = new JSONObject();     // Catch: Throwable -> L51
            if (k.c(r26.getClass().getName()) == true) goto L20;
            r12.put("ex_name", r26.getClass().getName());     // Catch: Throwable -> L51
            if (r13 != 1) goto L13;
            if (r3.getLogTypeSwitch("ex_message_open") == false) goto L13;
        L14:
            String r4 = e.f(r26);     // Catch: Throwable -> L51
            o.b(r4, "TtnetUtil.outputThrowableStackTrace(e)");     // Catch: Throwable -> L51
            if (k.c(r4) == true) goto L17;
            r12.put("ex_message", r4);     // Catch: Throwable -> L51
        L17:
            String r5 = com.bytedance.ttnet.d.a();     // Catch: Throwable -> L51
            if (k.c(r5) == true) goto L20;
            r12.put("cronet_init_ex_message", r5);     // Catch: Throwable -> L51
        L13:
            if (r3.getLogTypeSwitch("debug_ex_message_open") == true) goto L14;
        L20:
            this.f11949a.d(r26, r12);     // Catch: Throwable -> L51
            if (k.c(r14[0]) == false) goto L31;
            if (r25 == null) goto L31;
            r14[0] = r25.f13357d;     // Catch: Throwable -> L51
            T r6 = r25.f13358e;     // Catch: Throwable -> L51
            if (r6 == 0) goto L31;
            if (((com.bytedance.ttnet.m.d) r6).E <= 0) goto L28;
            r12.put("index", ((com.bytedance.ttnet.m.d) r6).E);     // Catch: Throwable -> L51
        L28:
            T r7 = r25.f13358e;     // Catch: Throwable -> L51
            if (((com.bytedance.ttnet.m.d) r7).D <= 0) goto L31;
            r12.put("httpIndex", ((com.bytedance.ttnet.m.d) r7).D);     // Catch: Throwable -> L51
        L31:
            TTNetInitTask.a(this.f11949a, r25, r12);     // Catch: Throwable -> L51
            int r0 = com.ss.android.k.c.b.a(com.bytedance.mpaas.app.a.f5245g).a();     // Catch: Throwable -> L51
            if (r13 < 400) goto L34;
        L35:
            Application r8 = com.bytedance.mpaas.app.a.f5245g;     // Catch: Throwable -> L51
            o.b(r8, "LaunchApplication.sApplication");     // Catch: Throwable -> L51
            if (d.b.m.e.a.b(r8) == false) goto L38;
            d.b.m.d.a.b("AppConfig", new Object[]{"status = " + r13 + " tr = " + r26.getMessage()});     // Catch: Throwable -> L51
        L38:
            if (r25 != null) goto L40;
        L49:
            JSONObject r1 = r12;
            r13 = r13;
            r3.monitorApiError(r19, r21, r23, r14[0], r24, r13, r0, r1);     // Catch: Throwable -> L51
            String r10 = r14[0];     // Catch: Throwable -> L51
        L48:
            r3.monitorSLA(r19, r21, r23, r10, r24, r13, r0, r1);     // Catch: Throwable -> L51
            return;
        L40:
            if (r25.G == false) goto L49;
            if (r3.getLogTypeSwitch("downloadFileError") == false) goto L44;
            r1 = r12;
            r3.monitorApiError(r19, r21, r23, r14[0], r24, r13, r0, r1);     // Catch: Throwable -> L51
        L46:
            if (r3.getLogTypeSwitch("downloadFileSuccess") == false) goto L56;
            r10 = r14[0];     // Catch: Throwable -> L51
            goto L48
        L56:
            return;
        L44:
            r1 = r12;
            goto L46
        L34:
            if (r13 >= 200) goto L38;
        L51:
            th = move-exception;
            d.b.m.d.a.c("ttnet", new Object[]{th});
        }

        public void d(long r15, long r17, String r19, String r20, com.bytedance.ttnet.m.b r21) {
            IMonitorService r2 = (IMonitorService) d.a(IMonitorService.class);
            if (r2 != null) goto L34;
            return;
        L34:
            String[] r3 = new String[1];     // Catch: Throwable -> L31
            JSONObject r11 = new JSONObject();     // Catch: Throwable -> L31
            if (r19 == null) goto L12;
            if (kotlin.u0.k.F(r19, "&config_retry=b", false, 2, null) != true) goto L12;
            r11.put("log_config_retry", 1);     // Catch: Throwable -> L31
        L12:
            if (k.c(r3[0]) == false) goto L22;
            if (r21 == null) goto L22;
            r3[0] = r21.f13357d;     // Catch: Throwable -> L31
            T r4 = r21.f13358e;     // Catch: Throwable -> L31
            if (r4 == 0) goto L22;
            if (((com.bytedance.ttnet.m.d) r4).E <= 0) goto L19;
            r11.put("index", ((com.bytedance.ttnet.m.d) r4).E);     // Catch: Throwable -> L31
        L19:
            T r5 = r21.f13358e;     // Catch: Throwable -> L31
            if (((com.bytedance.ttnet.m.d) r5).D <= 0) goto L22;
            r11.put("httpIndex", ((com.bytedance.ttnet.m.d) r5).D);     // Catch: Throwable -> L31
        L22:
            TTNetInitTask.a(this.f11949a, r21, r11);     // Catch: Throwable -> L31
            i.a r6 = com.ss.android.k.c.b.a(com.bytedance.mpaas.app.a.f5245g);     // Catch: Throwable -> L31
            o.b(r6, "NetworkUtils.getNetworkT…Application.sApplication)");     // Catch: Throwable -> L31
            int r10 = r6.a();     // Catch: Throwable -> L31
            if (r21 != null) goto L25;
        L29:
            r2.monitorSLA(r15, r17, r19, r3[0], r20, 200, r10, r11);     // Catch: Throwable -> L31
            return;
        L25:
            if (r21.G == false) goto L29;
            if (r2.getLogTypeSwitch("downloadFileSuccess") == false) goto L35;
            r2.monitorSLA(r15, r17, r19, r3[0], r20, 200, r10, r11);     // Catch: Throwable -> L31
            return;
        L35:
            return;
        L31:
            th = move-exception;
            d.b.m.d.a.c("ttnet", new Object[]{th});
        }
    }

    public TTNetInitTask() {
    }

    public static final /* synthetic */ void a(TTNetInitTask r0, com.bytedance.ttnet.m.b r1, JSONObject r2) {
        r0.c(r1, r2);
    }

    private final void b() {
        Application r1 = com.bytedance.mpaas.app.a.f5245g;
        IBdtrackerService r0 = (IBdtrackerService) d.a(IBdtrackerService.class);
        CountDownLatch r2 = new CountDownLatch(1);
        if (r0 == null) goto L5;
        r0.registerDataListener(new a(r2));
    L5:
        TTNetInit.tryInitTTNet(r1, r1, new b(r2), new c(this), null, true, new boolean[0]);
    }

    private final void c(com.bytedance.ttnet.m.b r3, JSONObject r4) {
        if (r3 == null) goto L19;
        if (r4 == null) goto L20;
        e(r4);
        r4.put("appLevelRequestStart", r3.f13359f);     // Catch: JSONException -> L14
        r4.put("beforeAllInterceptors", r3.f13360g);     // Catch: JSONException -> L14
        r4.put("requestStart", r3.f13361h);     // Catch: JSONException -> L14
        r4.put("responseBack", r3.f13362i);     // Catch: JSONException -> L14
        r4.put("completeReadResponse", r3.f13365l);     // Catch: JSONException -> L14
        r4.put("requestEnd", r3.m);     // Catch: JSONException -> L14
        r4.put("recycleCount", r3.n);     // Catch: JSONException -> L14
        if (r3.B != 0) goto L9;
        r4.put("timing_dns", r3.o);     // Catch: JSONException -> L14
        r4.put("timing_connect", r3.p);     // Catch: JSONException -> L14
        r4.put("timing_ssl", r3.q);     // Catch: JSONException -> L14
        r4.put("timing_send", r3.r);     // Catch: JSONException -> L14
        r4.put("timing_waiting", r3.v);     // Catch: JSONException -> L14
        r4.put("timing_receive", r3.t);     // Catch: JSONException -> L14
        r4.put("timing_total", r3.w);     // Catch: JSONException -> L14
        r4.put("timing_isSocketReused", r3.u);     // Catch: JSONException -> L14
        r4.put("timing_totalSendBytes", r3.x);     // Catch: JSONException -> L14
        r4.put("timing_totalReceivedBytes", r3.y);     // Catch: JSONException -> L14
        r4.put("timing_remoteIP", r3.f13357d);     // Catch: JSONException -> L14
        r4.put(ICronetClient.KEY_REQUEST_LOG, r3.E);     // Catch: JSONException -> L14
    L9:
        JSONObject r2 = r3.F;     // Catch: JSONException -> L14
        if (r2 == null) goto L12;
        r4.put("req_info", r2);     // Catch: JSONException -> L14
    L12:
        r4.put("download", r3.G);     // Catch: JSONException -> L14
        return;
    L14:
        e = move-exception;
        d.b.m.d.a.g("ttnet", new Object[]{"[packageRequestParamters] json op error. ", e});
        return;
    L20:
        return;
    }

    private final void e(JSONObject r3) {
        if (r3 != null) goto L9;
        return;
    L9:
        d.b.h.a.a.f.b r0 = d.b.h.a.a.f.b.c();     // Catch: Throwable -> L6
        o.b(r0, "ConnectionClassManager.getInstance()");     // Catch: Throwable -> L6
        r3.put("nt_band_width", r0.b());     // Catch: Throwable -> L6
        d.b.h.a.a.f.a r1 = d.b.h.a.a.f.a.h();     // Catch: Throwable -> L6
        o.b(r1, "CdnConnectionClassManager.getInstance()");     // Catch: Throwable -> L6
        r3.put("cdn_nt_band_width", r1.b());     // Catch: Throwable -> L6
        com.bytedance.ttnet.j.a r2 = com.bytedance.ttnet.j.a.s(com.bytedance.mpaas.app.a.f5245g);     // Catch: Throwable -> L6
        o.b(r2, "AppConfig.getInstance(La…Application.sApplication)");     // Catch: Throwable -> L6
        r3.put("cronet_open", r2.i());     // Catch: Throwable -> L6
        r3.put("cronet_plugin_install", TTNetInit.getTTNetDepend().g());     // Catch: Throwable -> L6
        r3.put("cronet_crash", false);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    public final void d(Throwable r9, JSONObject r10) {
        if (r9 == null) goto L54;
        if (r10 == null) goto L58;
        String r8 = r9.getMessage();     // Catch: Throwable -> L42
        if (k.c(r8) == false) goto L8;
        return;
    L8:
        if (r8 == null) goto L39;
        int r11 = r8.length();     // Catch: Throwable -> L42
        int r0 = kotlin.u0.k.Q(r8, "ErrorCode=", 0, false, 6, null);     // Catch: Throwable -> L42
        if (r0 == (-1)) goto L24;
        StringBuilder r1 = new StringBuilder();     // Catch: Throwable -> L42
        int r2 = r0 + 10;     // Catch: Throwable -> L42
    L12:
        if (r2 >= r11) goto L22;
        char r3 = r8.charAt(r2);     // Catch: Throwable -> L42
        if (Character.isSpaceChar(r3) == true) goto L20;
        if (r3 != '-') goto L18;
    L19:
        r1.append(r3);     // Catch: Throwable -> L42
        goto L20
    L18:
        if (Character.isDigit(r3) == false) goto L22;
    L20:
        r2 = r2 + 1;     // Catch: Throwable -> L42
    L22:
        if (r1.length() <= 0) goto L24;
        r10.put("cronet_error_code", r1.toString());     // Catch: Throwable -> L42
    L24:
        int r4 = kotlin.u0.k.Q(r8, "InternalErrorCode=", 0, false, 6, null);     // Catch: Throwable -> L42
        if (r4 == (-1)) goto L55;
        StringBuilder r5 = new StringBuilder();     // Catch: Throwable -> L42
        int r6 = r4 + 18;     // Catch: Throwable -> L42
    L27:
        if (r6 >= r11) goto L37;
        char r7 = r8.charAt(r6);     // Catch: Throwable -> L42
        if (Character.isSpaceChar(r7) == true) goto L35;
        if (r7 != '-') goto L33;
    L34:
        r5.append(r7);     // Catch: Throwable -> L42
        goto L35
    L33:
        if (Character.isDigit(r7) == false) goto L37;
    L35:
        r6 = r6 + 1;     // Catch: Throwable -> L42
    L37:
        if (r5.length() <= 0) goto L56;
        r10.put("cronet_internal_error_code", r5.toString());     // Catch: Throwable -> L42
        return;
    L56:
        return;
    L55:
        return;
    L39:
        o.p();     // Catch: Throwable -> L42
        throw null;
    L42:
        th = move-exception;
        d.b.m.d.a.g("ttnet", new Object[]{"[tryAddCronetErrCode] ignore Throwable. ", th});
        return;
    L58:
        return;
    }

    @Override // java.lang.Runnable
    public void run() {
        d.b.m.d.a.b("mPaaSInit", new Object[]{"TTNetInitTask", "start init"});
        TTNetInitTaskHook r2 = (TTNetInitTaskHook) d.b.m.e.a.a(TTNetInitTaskHook.class);
        if (r2 == null) goto L5;
        r2.before();
    L5:
        if (r2 != null) goto L7;
    L8:
        b();
    L9:
        if (r2 == null) goto L11;
        r2.after();
    L11:
        if (r2 == null) goto L13;
        com.bytedance.mpaas.monitor.a.d(TTNetInitTaskHook.class.getName());
    L13:
        d.b.m.d.a.b("mPaaSInit", new Object[]{"TTNetInitTask", "end init"});
        return;
    L7:
        if (r2.hook() == true) goto L9;
        goto L8
    }
}
