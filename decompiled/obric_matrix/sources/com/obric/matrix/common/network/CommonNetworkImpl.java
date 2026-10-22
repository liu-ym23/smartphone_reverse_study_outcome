package com.obric.matrix.common.network;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.mpaas.app.AppInfo;
import com.obric.matrix.base.settings.iconfig.IGenericNetworkConfig;
import com.obric.matrix.common_api.ICommonNetworkApi;
import com.obric.matrix.common_api.INetworkApi;
import com.obric.matrix.w.b0;
import com.obric.matrix.w.c0;
import com.obric.matrix.w.e0;
import com.obric.matrix.w.i0;
import com.obric.matrix.w.j0;
import com.obric.matrix.w.n;
import com.obric.matrix.w.s;
import h.a.b1;
import h.a.m0;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.i;
import kotlin.i0.r;
import kotlin.k0.j.a.l;
import kotlin.n0.c.p;
import kotlin.n0.d.d0;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.u0.k;
import kotlin.w;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 (2\u00020\u0001:\u0001(B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0005H\u0002J(\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0013\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005J\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0017J \u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0005H\u0002J\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0017J\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0017J\u0016\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0017J)\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00050&2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010'R!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, d2 = {"Lcom/obric/matrix/common/network/CommonNetworkImpl;", "Lcom/obric/matrix/common_api/ICommonNetworkApi;", "()V", "mAllowPathList", "", "", "getMAllowPathList", "()Ljava/util/List;", "mAllowPathList$delegate", "Lkotlin/Lazy;", "allowNetworkMethod", "", "method", "Lcom/obric/matrix/proto/NETWORK_METHOD;", "allowRequestNetwork", "path", "dispatchRequest", "Lio/reactivex/Maybe;", "Lcom/obric/matrix/model/BaseResponseBody;", "request", "Lcom/obric/matrix/proto/Request;", "accessToken", "logParams", "Lcom/obric/matrix/common/network/LogParams;", "getBody", "Lcom/bytedance/retrofit2/mime/TypedByteArray;", "Lcom/obric/matrix/proto/GenericNetworkRequest;", "getLanguage", "getTTNetParameters", "onEventForNetwork", "", "errorCode", "", "failReason", "onePartyNetworkRequest", "processGenericNetworkRequest", "sendApplogEventRequest", "switchToSpecialMethod", "Lcom/obric/matrix/common/network/CmdResult;", "(Lcom/obric/matrix/proto/Request;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "common_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CommonNetworkImpl implements ICommonNetworkApi {
    public static final a Companion = null;
    private static final String EVENT_GENERIC_NETWORK_REQUEST = "generic_network_request";
    private static final String TAG = "CommonNetworkImpl";
    private final kotlin.h mAllowPathList$delegate;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/matrix/common/network/CommonNetworkImpl$Companion;", "", "()V", "EVENT_GENERIC_NETWORK_REQUEST", "", "TAG", "common_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.n0.d.g r1) {
            this();
        }
    }

    @kotlin.k0.j.a.f(c = "com.obric.matrix.common.network.CommonNetworkImpl$dispatchRequest$1", f = "CommonNetworkImpl.kt", l = {173}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/obric/matrix/model/BaseResponseBody;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class b extends l implements p<m0, kotlin.k0.d<? super com.obric.matrix.u.b>, Object> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f8912f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ b0 f8913g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ CommonNetworkImpl f8914h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f8915i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ f f8916j;

        b(b0 r1, CommonNetworkImpl r2, String r3, f r4, kotlin.k0.d<? super b> r5) {
            this.f8913g = r1;
            this.f8914h = r2;
            this.f8915i = r3;
            this.f8916j = r4;
            super(2, r5);
        }

        @Override // kotlin.k0.j.a.a
        public final kotlin.k0.d<f0> create(Object r7, kotlin.k0.d<?> r8) {
            return new b(this.f8913g, this.f8914h, this.f8915i, this.f8916j, r8);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(m0 r1, kotlin.k0.d<? super com.obric.matrix.u.b> r2) {
            return ((b) create(r1, r2)).invokeSuspend(f0.f18324a);
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ Object invoke(m0 r1, kotlin.k0.d<? super com.obric.matrix.u.b> r2) {
            return invoke2(r1, r2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v10, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r1v15, types: [T, java.lang.String] */
        @Override // kotlin.k0.j.a.a
        public final Object invokeSuspend(Object r10) {
            Object r0 = kotlin.k0.i.b.c();
            int r1 = this.f8912f;
            String r2 = "";
            int r3 = 0;
            String r5 = "-1";
            if (r1 == 0) goto L11;
            if (r1 != 1) goto L10;
            w.b(r10);     // Catch: Exception -> L7
        L18:
            com.obric.matrix.common.network.d r11 = (com.obric.matrix.common.network.d) r10;     // Catch: Exception -> L7
            if (r11.d() == false) goto L25;
            com.obric.matrix.w.h.a r4 = new com.obric.matrix.w.h.a();     // Catch: Exception -> L7
            r4.c(kotlin.k0.j.a.b.a(true));     // Catch: Exception -> L7
            Object r6 = r11.c();     // Catch: Exception -> L7
            if (r6 == null) goto L24;
            r4.a((String) r6);     // Catch: Exception -> L7
            r4.d(r11.b());     // Catch: Exception -> L7
            com.obric.matrix.w.h r7 = r4.b();     // Catch: Exception -> L7
            o.e(r7, "Builder()\n              …                 .build()");     // Catch: Exception -> L7
            com.obric.matrix.u.a r8 = new com.obric.matrix.u.a(r11.b(), kotlin.k0.j.a.b.b(0), "");     // Catch: Exception -> L7
        L32:
            r5 = r11.b();     // Catch: Exception -> L7
        L35:
            CommonNetworkImpl r12 = this.f8914h;
            f r9 = this.f8916j;
            Integer r13 = r8.b();
            if (r13 == null) goto L38;
            r3 = r13.intValue();
        L38:
            String r14 = r8.a();
            if (r14 == null) goto L42;
            r2 = r14;
        L42:
            CommonNetworkImpl.access$onEventForNetwork(r12, r9, r3, r2);
            com.obric.matrix.r.c.c.b(com.obric.matrix.r.c.c.i(CommonNetworkImpl.TAG), "dispatchRequest return and serverLogId is " + r5);
            com.obric.matrix.u.b.a r15 = new com.obric.matrix.u.b.a();
            r15.c(r8);
            e0.a r16 = new e0.a();
            r16.d(r7);
            e0 r17 = r16.b();
            o.e(r17, "Builder().genericNetwork…cNetworkResponse).build()");
            r15.d(r17);
            return r15.a();
        L24:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");     // Catch: Exception -> L7
        L25:
            com.obric.matrix.r.c.c.b(CommonNetworkImpl.TAG, "dispatchRequest is failed and value is " + r11.c());     // Catch: Exception -> L7
            d0 r18 = new d0();     // Catch: Exception -> L7
            r18.f18431f = String.valueOf(r11.c());     // Catch: Exception -> L7
            Throwable r19 = r11.a();     // Catch: Exception -> L7
            if (r19 == null) goto L28;
            com.obric.matrix.r.c.c.b(CommonNetworkImpl.TAG, "dispatchRequest is failed and the throwable of onFailure is " + r19.getMessage());     // Catch: Exception -> L7
            r18.f18431f = r19.getMessage();     // Catch: Exception -> L7
        L28:
            com.obric.matrix.u.a r20 = g.f8932a.a((String) r18.f18431f);     // Catch: Exception -> L7
            if (r20 != null) goto L31;
            r20 = new com.obric.matrix.u.a(r11.b(), kotlin.k0.j.a.b.b(-100013), "Common network request is failed");     // Catch: Exception -> L7
        L31:
            r8 = r20;
            com.obric.matrix.w.h.a r21 = new com.obric.matrix.w.h.a();     // Catch: Exception -> L7
            r21.d(r11.b());     // Catch: Exception -> L7
            r7 = r21.b();     // Catch: Exception -> L7
            o.e(r7, "Builder()\n              …                 .build()");     // Catch: Exception -> L7
            goto L32
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            w.b(r10);
            b0 r110 = this.f8913g;
            c0 r22 = r110.o;
            if (r22 == null) goto L45;
            if (r22.u == null) goto L45;
            CommonNetworkImpl r23 = this.f8914h;     // Catch: Exception -> L7
            String r24 = this.f8915i;     // Catch: Exception -> L7
            this.f8912f = 1;     // Catch: Exception -> L7
            r10 = CommonNetworkImpl.access$switchToSpecialMethod(r23, r110, r24, this);     // Catch: Exception -> L7
            if (r10 != r0) goto L18;
            return r0;
        L45:
            throw new com.obric.matrix.s.e(this.f8913g);
        L7:
            e = move-exception;
            com.obric.matrix.r.c.c.b(CommonNetworkImpl.TAG, "dispatchRequest occurs exception: " + e.getMessage());
            String r111 = "dispatchRequest occurs exception: " + e.getMessage() + " and request is " + this.f8913g;
            com.obric.matrix.w.h.a r25 = new com.obric.matrix.w.h.a();
            r25.d("-1");
            r7 = r25.b();
            o.e(r7, "Builder()\n              …                 .build()");
            r8 = new com.obric.matrix.u.a("-1", kotlin.k0.j.a.b.b(-100010), r111);
            goto L35
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class c extends q implements kotlin.n0.c.a<List<String>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final c f8917f = null;

        static {
            f8917f = new c();
        }

        c() {
            super(0);
        }

        public final List<String> a() {
            return r.m(new String[]{"/game/v1/achievement/get_all_progress", "/game/v1/achievement/get_all_definitions", "/game/v1/achievement/get_definitions_byname", "/game/v1/achievement/get_progress_byname", "/game/v1/achievement/unlock", "/game/v1/achievement/add_count", "/game/v1/achievement/add_fields", "/game/v1/leaderboard/get", "/game/v1/leaderboard/get_entries_after_rank", "/game/v1/leaderboard/get_entries_by_ids", "/game/v1/leaderboard/get_entries", "/game/v1/leaderboard/write_entry", "/game/v1/leaderboard/write_entry_with_metric", "/game/v1/leaderboard/get_next_entries", "/game/v1/leaderboard/get_previous_entries", "/game/v1/challenge/invite", "/game/v1/challenge/get", "/game/v1/challenge/get_entries", "/game/v1/challenge/get_entries_after_rank", "/game/v1/challenge/get_entries_by_ids", "/game/v1/challenge/get_list", "/game/v1/challenge/join", "/game/v1/challenge/leave", "/rtc/v1/token/get", "/util/v1/app/store_info", "/friendship/v1/user/relationship", "/sensitive/v1/review/submit", "/oidc/v1/auth/id_token", "/iap/v1/subscription/status", "/account/v1/info/scope_id"});
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ List<String> invoke() {
            return a();
        }
    }

    @kotlin.k0.j.a.f(c = "com.obric.matrix.common.network.CommonNetworkImpl$onePartyNetworkRequest$1", f = "CommonNetworkImpl.kt", l = {440}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/obric/matrix/model/BaseResponseBody;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class d extends l implements p<m0, kotlin.k0.d<? super com.obric.matrix.u.b>, Object> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f8918f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ b0 f8919g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ f f8920h;

        d(b0 r1, f r2, kotlin.k0.d<? super d> r3) {
            this.f8919g = r1;
            this.f8920h = r2;
            super(2, r3);
        }

        @Override // kotlin.k0.j.a.a
        public final kotlin.k0.d<f0> create(Object r2, kotlin.k0.d<?> r3) {
            return new d(this.f8919g, this.f8920h, r3);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(m0 r1, kotlin.k0.d<? super com.obric.matrix.u.b> r2) {
            return ((d) create(r1, r2)).invokeSuspend(f0.f18324a);
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ Object invoke(m0 r1, kotlin.k0.d<? super com.obric.matrix.u.b> r2) {
            return invoke2(r1, r2);
        }

        @Override // kotlin.k0.j.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = kotlin.k0.i.b.c();
            int r1 = this.f8918f;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            w.b(r5);
        L11:
            return r5;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            w.b(r5);
            h r6 = h.f8933a;
            b0 r2 = this.f8919g;
            f r3 = this.f8920h;
            this.f8918f = 1;
            r5 = r6.g(r2, r3, this);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    static {
        Companion = new a(null);
    }

    public CommonNetworkImpl() {
        this.mAllowPathList$delegate = i.b(c.f8917f);
    }

    public static /* synthetic */ void a(b0 r0, f.a.b r1) {
        m54sendApplogEventRequest$lambda8(r0, r1);
    }

    public static final /* synthetic */ void access$onEventForNetwork(CommonNetworkImpl r0, f r1, int r2, String r3) {
        r0.onEventForNetwork(r1, r2, r3);
    }

    public static final /* synthetic */ Object access$switchToSpecialMethod(CommonNetworkImpl r0, b0 r1, String r2, kotlin.k0.d r3) {
        return r0.switchToSpecialMethod(r1, r2, r3);
    }

    private final boolean allowNetworkMethod(s r1) {
        return kotlin.i0.i.s(s.values(), r1);
    }

    private final boolean allowRequestNetwork(String r5) {
        Object r0 = com.bytedance.news.common.settings.e.e(IGenericNetworkConfig.class);
        o.e(r0, "obtain(IGenericNetworkConfig::class.java)");
        IGenericNetworkConfig r1 = (IGenericNetworkConfig) r0;
        boolean r2 = true;
        if (o.a(r1.getGenericNetworkConfig().c(), Boolean.FALSE) == false) goto L6;
        com.obric.matrix.r.c.c.b(TAG, "the switch of the security check from settings is false.");
        return true;
    L6:
        List<String> r3 = r1.getGenericNetworkConfig().b();
        if (r3 != null) goto L9;
    L12:
        if (r2 == false) goto L15;
        com.obric.matrix.r.c.c.b(TAG, "the allow path list from settings is null or empty.");
        return getMAllowPathList().contains(r5);
    L15:
        return r3.contains(r5);
    L9:
        if (r3.isEmpty() == true) goto L12;
        r2 = false;
        goto L12
    }

    public static /* synthetic */ void b(b0 r0, CommonNetworkImpl r1, f.a.b r2) {
        m53getTTNetParameters$lambda7(r0, r1, r2);
    }

    private final f.a.a<com.obric.matrix.u.b> dispatchRequest(b0 r9, String r10, f r11) {
        return h.a.h3.e.b(b1.a(), new b(r9, this, r10, r11, null));
    }

    private final d.b.r.k0.g getBody(com.obric.matrix.w.g r5) {
        Map<String, String> r4 = r5.f10326h;
        if (r4 != null) goto L5;
    L8:
        boolean r6 = true;
    L9:
        String r1 = INetworkApi.DEFAULT_CONTENT_TYPE;
        if (r6 == true) goto L16;
        String r7 = r5.f10326h.get(INetworkApi.CONTENT_TYPE);
        if (r7 == null) goto L16;
        r1 = r7;
    L16:
        k.h r8 = r5.f10328j;
        if (r8 != null) goto L19;
    L22:
        byte[] r9 = null;
    L23:
        if (r9 != null) goto L26;
        return null;
    L26:
        return new d.b.r.k0.g(r1, r9, new String[0]);
    L19:
        if (o.a(r8, k.h.f18266i) == true) goto L22;
        r9 = r5.f10328j.E();
        goto L23
    L5:
        if (r4.isEmpty() == true) goto L8;
        r6 = false;
        goto L9
    }

    private final List<String> getMAllowPathList() {
        return (List) this.mAllowPathList$delegate.getValue();
    }

    /* JADX INFO: renamed from: getTTNetParameters$lambda-7, reason: not valid java name */
    private static final void m53getTTNetParameters$lambda7(b0 r7, CommonNetworkImpl r8, f.a.b r9) {
        o.f(r7, "$request");
        o.f(r8, "this$0");
        o.f(r9, "it");
        if (r7.o == null) goto L11;
        if (com.obric.matrix.base.env.d.f8838a.e() == false) goto L7;
        String r10 = "https://pdev-api-boe.bytedance.net";
    L8:
        String r11 = r8.getLanguage();
        String r0 = AppInfo.getInstatnce().getVersionCode();
        JSONObject r1 = new JSONObject();
        r1.put("host", r10);
        r1.put("language", r11);
        r1.put("matrix_sdk_version_code", r0);
        n.a r12 = new n.a();
        r12.b(r1.toString());
        n r13 = r12.a();
        com.obric.matrix.u.b.a r14 = new com.obric.matrix.u.b.a();
        r14.c(new com.obric.matrix.u.a(null, null, null, 7, null));
        e0.a r2 = new e0.a();
        r2.g(r13);
        e0 r15 = r2.b();
        o.e(r15, "Builder()\n              …rametersResponse).build()");
        r14.d(r15);
        r9.b(r14.a());
        return;
    L7:
        r10 = "https://platform-cn.picovr.com";
        goto L8
    L11:
        throw new com.obric.matrix.s.e(r7);
    }

    private final void onEventForNetwork(f r1, int r2, String r3) {
        r1.a(WsConstants.ERROR_CODE, r2);
        r1.b("fail_reason", r3);
        com.obric.matrix.ostracker_api.b.g(EVENT_GENERIC_NETWORK_REQUEST, r1.c());
    }

    /* JADX INFO: renamed from: sendApplogEventRequest$lambda-8, reason: not valid java name */
    private static final void m54sendApplogEventRequest$lambda8(b0 r3, f.a.b r4) {
        o.f(r3, "$request");
        o.f(r4, "it");
        c0 r0 = r3.o;
        if (r0 == null) goto L15;
        i0 r1 = r0.t;
        if (r1 == null) goto L15;
        Map<String, String> r5 = r1.f10385g;
        if (r5 == null) goto L12;
        o.e(r5, "request.body.sendApplogEventRequest.eventMap");
        Iterator<Map.Entry<String, String>> r6 = r5.entrySet().iterator();
    L10:
        if (r6.hasNext() == false) goto L12;
        Map.Entry<String, String> r2 = r6.next();
        String r7 = r2.getKey();
        o.e(r7, "entry.key");
        com.obric.matrix.ostracker_api.b.g(r7, new JSONObject(r2.getValue()));
    L12:
        com.obric.matrix.u.b.a r8 = new com.obric.matrix.u.b.a();
        r8.c(new com.obric.matrix.u.a("", 0, ""));
        e0.a r9 = new e0.a();
        r9.j(new j0.a().a());
        e0 r10 = r9.b();
        o.e(r10, "Builder().sendApplogEven…uilder().build()).build()");
        r8.d(r10);
        r4.b(r8.a());
        return;
    L15:
        throw new com.obric.matrix.s.e(r3);
    }

    private final Object switchToSpecialMethod(b0 r13, String r14, kotlin.k0.d<? super com.obric.matrix.common.network.d<String>> r15) {
        com.obric.matrix.w.g r0 = r13.o.u;
        Map<String, String> r1 = r0.f10326h;
        boolean r2 = false;
        if (r14 != null) goto L5;
    L8:
        boolean r4 = true;
    L10:
        if (r4 == true) goto L21;
        if (r1 != null) goto L13;
    L16:
        boolean r5 = true;
    L17:
        if (r5 == false) goto L19;
        r1 = new LinkedHashMap();
    L20:
        r1.put("accessToken", r14);
        goto L21
    L19:
        LinkedHashMap r6 = new LinkedHashMap();
        o.e(r1, "headerParams");
        r6.putAll(r1);
        r1 = r6;
        goto L20
    L13:
        if (r1.isEmpty() == true) goto L16;
        r5 = false;
    L21:
        String r16 = r13.f10198i;
        if (r16 != null) goto L24;
    L27:
        boolean r17 = true;
    L28:
        if (r17 == true) goto L39;
        if (r1 != null) goto L31;
    L34:
        boolean r18 = true;
    L35:
        if (r18 == false) goto L37;
        LinkedHashMap r19 = new LinkedHashMap();
    L38:
        r1 = r19;
        r1.put("appId", r13.f10198i);
        goto L39
    L37:
        r19 = new LinkedHashMap();
        o.e(r1, "headerParams");
        r19.putAll(r1);
        goto L38
    L31:
        if (r1.isEmpty() == true) goto L34;
        r18 = false;
    L39:
        String r110 = r13.f10201l;
        if (r110 != null) goto L42;
    L45:
        boolean r111 = true;
    L46:
        if (r111 == true) goto L57;
        if (r1 != null) goto L49;
    L52:
        boolean r112 = true;
    L53:
        if (r112 == false) goto L55;
        LinkedHashMap r113 = new LinkedHashMap();
    L56:
        r1 = r113;
        r1.put("thirdAppVersion", r13.f10201l);
        goto L57
    L55:
        r113 = new LinkedHashMap();
        o.e(r1, "headerParams");
        r113.putAll(r1);
        goto L56
    L49:
        if (r1.isEmpty() == true) goto L52;
        r112 = false;
    L57:
        String r114 = r13.f10197h;
        if (r114 != null) goto L60;
    L63:
        boolean r115 = true;
    L64:
        if (r115 == true) goto L74;
        if (r1 != null) goto L67;
    L68:
        r2 = true;
    L70:
        if (r2 == false) goto L72;
        LinkedHashMap r116 = new LinkedHashMap();
    L73:
        r1 = r116;
        r1.put("platformSdkVersion", r13.f10197h);
        goto L74
    L72:
        r116 = new LinkedHashMap();
        o.e(r1, "headerParams");
        r116.putAll(r1);
        goto L73
    L67:
        if (r1.isEmpty() == false) goto L70;
    L74:
        Map<String, String> r8 = r1;
        s r117 = s.f10501g;
        s r3 = r0.f10325g;
        if (r117 != r3) goto L80;
        INetworkApi r12 = INetworkApi.Companion.a();
        String r118 = r0.f10324f;
        o.e(r118, "requestBody.path");
        o.e(r8, "headerParams");
        Map<String, String> r119 = r0.f10327i;
        o.e(r119, "requestBody.queryParams");
        d.b.r.b<String> r120 = r12.executeGet(r118, r8, r119, true);
    L78:
        return com.obric.matrix.common.network.c.b(r120, true, r15);
    L80:
        if (s.f10502h != r3) goto L86;
        o.e(r0, "requestBody");
        d.b.r.k0.g r11 = getBody(r0);
        INetworkApi.a r121 = INetworkApi.Companion;
        if (r11 != null) goto L84;
        INetworkApi r122 = r121.a();
        String r123 = r0.f10324f;
        o.e(r123, "requestBody.path");
        o.e(r8, "headerParams");
        Map<String, String> r124 = r0.f10327i;
        o.e(r124, "requestBody.queryParams");
        r120 = r122.executePost(r123, r8, r124, true);
        goto L78
    L84:
        INetworkApi r7 = r121.a();
        String r9 = r0.f10324f;
        o.e(r9, "requestBody.path");
        o.e(r8, "headerParams");
        Map<String, String> r10 = r0.f10327i;
        o.e(r10, "requestBody.queryParams");
        r120 = r7.executePost(r9, r8, r10, true, r11);
        goto L78
    L86:
        throw new com.obric.matrix.s.d(r13, "the param method is invalid or not supported which value is " + r0.f10325g);
    L60:
        if (r114.length() == 0) goto L63;
        r115 = false;
        goto L64
    L42:
        if (r110.length() == 0) goto L45;
        r111 = false;
        goto L46
    L24:
        if (r16.length() == 0) goto L27;
        r17 = false;
        goto L28
    L5:
        if (r14.length() == 0) goto L8;
        r4 = false;
        goto L10
    }

    public final String getLanguage() {
        String r5 = Locale.getDefault().getLanguage();
        if (o.a(r5, "zh") == false) goto L8;
        String r6 = Locale.getDefault().toLanguageTag();
        o.e(r6, "languageTag");
        if (k.F(r6, "zh-Hant", false, 2, null) == true) goto L7;
        return "zh";
    L7:
        return "zh-Hant";
    L8:
        return r5;
    }

    @Override // com.obric.matrix.common_api.ICommonNetworkApi
    public f.a.a<com.obric.matrix.u.b> getTTNetParameters(final b0 r3) {
        o.f(r3, "request");
        com.obric.matrix.r.c.c.b(TAG, "getTTNetParameters() called with: request = " + r3);
        f.a.a<com.obric.matrix.u.b> r2 = f.a.a.b(new com.obric.matrix.common.network.b(r3, this));
        o.e(r2, "create {\n            if …)\n            )\n        }");
        return r2;
    }

    @Override // com.obric.matrix.common_api.ICommonNetworkApi
    public f.a.a<com.obric.matrix.u.b> onePartyNetworkRequest(b0 r4) {
        o.f(r4, "request");
        f r3 = new f();
        String r0 = r4.f10198i;
        o.e(r0, "request.appKey");
        r3.b("caller_app_id", r0);
        String r1 = r4.n;
        o.e(r1, "request.appPkg");
        r3.b("caller_app_name", r1);
        com.obric.matrix.r.e.i r2 = com.obric.matrix.r.e.i.f9942a;
        String r5 = r4.n;
        o.e(r5, "request.appPkg");
        r3.b("caller_app_version", String.valueOf(r2.a(r5)));
        h.f8933a.a(r4, r3);
        return h.a.h3.e.c(null, new d(r4, r3, null), 1, null);
    }

    @Override // com.obric.matrix.common_api.ICommonNetworkApi
    public f.a.a<com.obric.matrix.u.b> processGenericNetworkRequest(b0 r6) {
        o.f(r6, "request");
        f r0 = new f();
        String r1 = r6.f10198i;
        o.e(r1, "request.appKey");
        r0.b("third_app_id", r1);
        String r2 = r6.n;
        o.e(r2, "request.appPkg");
        r0.b("third_app_name", r2);
        com.obric.matrix.r.e.i r3 = com.obric.matrix.r.e.i.f9942a;
        String r4 = r6.n;
        o.e(r4, "request.appPkg");
        r0.b("third_app_version", String.valueOf(r3.a(r4)));
        c0 r5 = r6.o;
        if (r5 == null) goto L26;
        com.obric.matrix.w.g r7 = r5.u;
        if (r7 == null) goto L26;
        String r8 = r7.f10324f;
        if (r8 != null) goto L9;
    L12:
        boolean r9 = true;
    L13:
        if (r9 == true) goto L24;
        String r10 = r7.f10324f;
        o.e(r10, "requestBody.path");
        r0.b("network_path", r10);
        r0.b("network_method", r7.f10325g.toString());
        s r11 = r7.f10325g;
        o.e(r11, "requestBody.method");
        if (allowNetworkMethod(r11) == false) goto L22;
        String r12 = r7.f10324f;
        o.e(r12, "requestBody.path");
        if (allowRequestNetwork(r12) == true) goto L19;
        com.obric.matrix.s.d r13 = new com.obric.matrix.s.d(r6, "the param url is illegal which value is " + r7.f10324f);
        onEventForNetwork(r0, r13.a(), r13.b());
        throw r13;
    L19:
        return dispatchRequest(r6, null, r0);
    L22:
        com.obric.matrix.s.d r14 = new com.obric.matrix.s.d(r6, "the param method is invalid or not supported which value is " + r7.f10325g);
        onEventForNetwork(r0, r14.a(), r14.b());
        throw r14;
    L24:
        com.obric.matrix.s.d r15 = new com.obric.matrix.s.d(r6, "the param url is invalid which value is " + r7.f10324f);
        onEventForNetwork(r0, r15.a(), r15.b());
        throw r15;
    L9:
        if (r8.length() == 0) goto L12;
        r9 = false;
    L26:
        com.obric.matrix.s.e r16 = new com.obric.matrix.s.e(r6);
        onEventForNetwork(r0, r16.a(), r16.b());
        throw r16;
    }

    @Override // com.obric.matrix.common_api.ICommonNetworkApi
    public f.a.a<com.obric.matrix.u.b> sendApplogEventRequest(final b0 r1) {
        o.f(r1, "request");
        f.a.a<com.obric.matrix.u.b> r0 = f.a.a.b(new com.obric.matrix.common.network.a(r1));
        o.e(r0, "create {\n            if …      .build())\n        }");
        return r0;
    }
}
