package com.obric.matrix.common.network;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.matrix.base.settings.iconfig.IOnePartyCommonNetworkConfig;
import com.obric.matrix.common_api.INetworkApi;
import com.obric.matrix.w.b0;
import com.obric.matrix.w.c0;
import com.obric.matrix.w.e0;
import com.obric.matrix.w.s;
import com.obric.matrix.w.u;
import com.obric.matrix.w.v;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.i;
import kotlin.i0.r;
import kotlin.n0.d.d0;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.w;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J'\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u000fH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J(\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0004H\u0002J \u0010 \u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0004H\u0002J!\u0010$\u001a\u00020%2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010&R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006'"}, d2 = {"Lcom/obric/matrix/common/network/OnePartyCommonNetworkHelper;", "", "()V", "EVENT_ONE_PARTY_NETWORK_REQUEST", "", "TAG", "onePartyAllowPathList", "", "getOnePartyAllowPathList", "()Ljava/util/List;", "onePartyAllowPathList$delegate", "Lkotlin/Lazy;", "checkIsValidRequest", "", "request", "Lcom/obric/matrix/proto/Request;", "logParams", "Lcom/obric/matrix/common/network/LogParams;", "doOnePartyNetRequest", "Lcom/obric/matrix/common/network/CmdResult;", "requestBody", "Lcom/obric/matrix/proto/OnePartyCommonNetworkRequest;", "(Lcom/obric/matrix/proto/OnePartyCommonNetworkRequest;Lcom/obric/matrix/proto/Request;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBody", "Lcom/bytedance/retrofit2/mime/TypedByteArray;", "headerParams", "", "byteBody", "Lokio/ByteString;", "isAllowPath", "", "path", "onEventForOnePartyNetwork", "code", "", NotificationCompat.CATEGORY_MESSAGE, "onePartyNetworkRequest", "Lcom/obric/matrix/model/BaseResponseBody;", "(Lcom/obric/matrix/proto/Request;Lcom/obric/matrix/common/network/LogParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "common_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f8933a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final kotlin.h f8934b = null;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f8935a = null;

        static {
            int[] r0 = new int[s.values().length];
            r0[s.f10501g.ordinal()] = 1;
            r0[s.f10502h.ordinal()] = 2;
            f8935a = r0;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class b extends q implements kotlin.n0.c.a<List<String>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f8936f = null;

        static {
            f8936f = new b();
        }

        b() {
            super(0);
        }

        public final List<String> a() {
            return r.m(new String[]{"/passport/auth/get_oauth_token/", "/passport/auth/unbind/", "/passport/mobile/validate_code/", "/passport/auth/gen_otp/", "/passport/auth/check_otp/", "/passport/auth/bind/", "/passport/account/info/v2/"});
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ List<String> invoke() {
            return a();
        }
    }

    @kotlin.k0.j.a.f(c = "com.obric.matrix.common.network.OnePartyCommonNetworkHelper", f = "OnePartyCommonNetworkHelper.kt", l = {48}, m = "onePartyNetworkRequest")
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    static final class c extends kotlin.k0.j.a.d {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f8937f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Object f8938g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        Object f8939h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        Object f8940i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f8941j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        /* synthetic */ Object f8942k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ h f8943l;
        int m;

        c(h r1, kotlin.k0.d<? super c> r2) {
            this.f8943l = r1;
            super(r2);
        }

        @Override // kotlin.k0.j.a.a
        public final Object invokeSuspend(Object r2) {
            this.f8942k = r2;
            this.m |= Integer.MIN_VALUE;
            return this.f8943l.g(null, null, this);
        }
    }

    static {
        f8933a = new h();
        f8934b = i.b(b.f8936f);
    }

    private h() {
    }

    private final Object b(u r10, b0 r11, kotlin.k0.d<? super d<String>> r12) {
        String r0 = r10.f10523g;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        String r1 = "https://matrix-cn.picovr.com" + r10.f10522f;
    L12:
        String r3 = r1;
        s r4 = r10.f10524h;
        if (r4 != null) goto L15;
        int r5 = -1;
    L17:
        if (r5 != 1) goto L19;
        INetworkApi r9 = INetworkApi.Companion.a();
        Map<String, String> r13 = r10.f10525i;
        o.e(r13, "requestBody.headerParams");
        Map<String, String> r6 = r10.f10526j;
        o.e(r6, "requestBody.queryParams");
        Boolean r14 = r10.m;
        o.e(r14, "requestBody.addCommonParam");
        d.b.r.b<String> r15 = r9.executeGet(r3, r13, r6, r14.booleanValue());
    L26:
        return com.obric.matrix.common.network.c.b(r15, true, r12);
    L19:
        if (r5 != 2) goto L32;
        Map<String, String> r16 = r10.f10528l;
        if (r16 == null) goto L27;
        o.e(r16, "requestBody.fieldMap");
        if ((!r16.isEmpty()) == false) goto L27;
        INetworkApi r17 = INetworkApi.Companion.a();
        Boolean r7 = r10.m;
        o.e(r7, "requestBody.addCommonParam");
        boolean r8 = r7.booleanValue();
        Map<String, String> r18 = r10.f10525i;
        o.e(r18, "requestBody.headerParams");
        Map<String, String> r19 = r10.f10528l;
        o.e(r19, "requestBody.fieldMap");
        Map<String, String> r110 = r10.f10526j;
        o.e(r110, "requestBody.queryParams");
        r15 = r17.doPost(r3, -1, r8, r18, r19, r110);
    L27:
        Map<String, String> r111 = r10.f10525i;
        o.e(r111, "requestBody.headerParams");
        d.b.r.k0.g r20 = c(r111, r10.f10527k);
        INetworkApi r21 = INetworkApi.Companion.a();
        Map<String, String> r112 = r10.f10525i;
        o.e(r112, "requestBody.headerParams");
        if (r20 != null) goto L30;
        Map<String, String> r22 = r10.f10526j;
        o.e(r22, "requestBody.queryParams");
        Boolean r113 = r10.m;
        o.e(r113, "requestBody.addCommonParam");
        r15 = r21.executePost(r3, r112, r22, r113.booleanValue());
        goto L26
    L30:
        Map<String, String> r23 = r10.f10526j;
        o.e(r23, "requestBody.queryParams");
        Boolean r114 = r10.m;
        o.e(r114, "requestBody.addCommonParam");
        r15 = r21.executePost(r3, r112, r23, r114.booleanValue(), r20);
        goto L26
    L32:
        throw new com.obric.matrix.s.d(r11, "the param method is invalid or not supported which value is " + r10.f10524h);
    L15:
        r5 = a.f8935a[r4.ordinal()];
        goto L17
    L11:
        r1 = "https://" + r0 + r10.f10522f;
        goto L12
    L5:
        if (r0.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    private final d.b.r.k0.g c(Map<String, String> r3, k.h r4) {
        if (r3 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        String r1 = INetworkApi.DEFAULT_CONTENT_TYPE;
        if (r0 == true) goto L17;
        String r5 = r3.get(INetworkApi.CONTENT_TYPE);
        if (r5 == null) goto L17;
        r1 = r5;
    L17:
        if (r4 != null) goto L19;
    L22:
        byte[] r6 = null;
    L23:
        if (r6 != null) goto L26;
        return null;
    L26:
        return new d.b.r.k0.g(r1, r6, new String[0]);
    L19:
        if (o.a(r4, k.h.f18266i) == true) goto L22;
        r6 = r4.E();
        goto L23
    L5:
        if (r3.isEmpty() == true) goto L8;
        r0 = false;
        goto L9
    }

    private final List<String> d() {
        return (List) f8934b.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    private final boolean e(String r4) {
        List<String> r0 = ((IOnePartyCommonNetworkConfig) com.bytedance.news.common.settings.e.e(IOnePartyCommonNetworkConfig.class)).getOnePartyCommonNetworkConfig().b();     // Catch: Exception -> L12
        boolean r2 = true;
        if ((!r0.isEmpty()) == false) goto L10;
        h this = this;
        if (r0.contains(r4) == true) goto L15;
        boolean r3 = d().contains(r4);     // Catch: Exception -> L12
        if (r3 == false) goto L9;
        this = r3;
        goto L15
    L9:
        r2 = false;
        this = r3;
    L15:
        return r2;
    L10:
        r2 = d().contains(r4);     // Catch: Exception -> L12
        this = this;
    L12:
        e = move-exception;
        com.obric.matrix.r.c.c.g("OnePartyCommonNetworkHelper", "isAllowPath, get config exception ", e);
        return this.d().contains(r4);
    }

    private final void f(f r1, int r2, String r3) {
        r1.a(WsConstants.ERROR_CODE, r2);
        r1.b("fail_reason", r3);
        com.obric.matrix.ostracker_api.b.g("one_party_network_request", r1.c());
    }

    public final void a(b0 r5, f r6) {
        o.f(r5, "request");
        o.f(r6, "logParams");
        c0 r0 = r5.o;
        if (r0 == null) goto L21;
        u r1 = r0.s;
        if (r1 == null) goto L21;
        String r2 = r1.f10522f;
        if (r2 != null) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == true) goto L19;
        String r4 = r1.f10522f;
        o.e(r4, "requestBody.path");
        if (e(r4) == false) goto L17;
        return;
    L17:
        com.obric.matrix.s.d r7 = new com.obric.matrix.s.d(r5, "the param url is illegal which value is " + r1.f10522f);
        f(r6, r7.a(), r7.b());
        throw r7;
    L19:
        com.obric.matrix.s.d r8 = new com.obric.matrix.s.d(r5, "the param url is invalid which value is " + r1.f10522f);
        f(r6, r8.a(), r8.b());
        throw r8;
    L9:
        if (r2.length() == 0) goto L12;
        r3 = false;
    L21:
        com.obric.matrix.s.e r9 = new com.obric.matrix.s.e(r5);
        f(r6, r9.a(), r9.b());
        throw r9;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v11, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v5, types: [T, java.lang.String] */
    public final Object g(b0 r20, f r21, kotlin.k0.d<? super com.obric.matrix.u.b> r22) {
        h r1 = this;
        b0 r2 = r20;
        if ((r22 instanceof c) == false) goto L7;
        c r3 = (c) r22;
        int r4 = r3.m;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.m = r4 - Integer.MIN_VALUE;
    L8:
        Object r0 = r3.f8942k;
        Object r5 = kotlin.k0.i.b.c();
        int r6 = r3.m;
        String r7 = "";
        String r8 = "-1";
        int r10 = 0;
        if (r6 == 0) goto L18;
        if (r6 != 1) goto L17;
        v.a r9 = (v.a) r3.f8941j;
        u r11 = (u) r3.f8940i;
        f r12 = (f) r3.f8939h;
        b0 r13 = (b0) r3.f8938g;
        h r14 = (h) r3.f8937f;
        w.b(r0);     // Catch: Exception -> L14
        v.a r15 = r9;
        r1 = r14;
        f r16 = r12;
        u r17 = r11;
    L24:
        d r18 = (d) r0;     // Catch: Exception -> L40
        if (r18.d() == false) goto L31;
        r15.c(kotlin.k0.j.a.b.a(true));     // Catch: Exception -> L40
        Object r19 = r18.c();     // Catch: Exception -> L40
        if (r19 == null) goto L30;
        r15.a((String) r19);     // Catch: Exception -> L40
        r15.d(r18.b());     // Catch: Exception -> L40
        r15.b();     // Catch: Exception -> L40
        com.obric.matrix.u.a r23 = new com.obric.matrix.u.a(r18.b(), kotlin.k0.j.a.b.b(0), "");     // Catch: Exception -> L40
    L38:
        String r24 = r18.b();     // Catch: Exception -> L40
        r16.b("log_id", r24);     // Catch: Exception -> L40
        com.obric.matrix.r.c.c.b("OnePartyCommonNetworkHelper", "onePartyNetworkRequest path = " + r17.f10522f + " , logid is " + r24);     // Catch: Exception -> L40
        r8 = r24;
    L45:
        Integer r25 = r23.b();
        if (r25 == null) goto L48;
        r10 = r25.intValue();
    L48:
        String r26 = r23.a();
        if (r26 == null) goto L52;
        r7 = r26;
    L52:
        r1.f(r16, r10, r7);
        com.obric.matrix.r.c.c.b(com.obric.matrix.r.c.c.i("OnePartyCommonNetworkHelper"), "onePartyNetworkRequest path = " + r17.f10522f + " return and serverLogId is " + r8);
        com.obric.matrix.u.b.a r27 = new com.obric.matrix.u.b.a();
        r27.c(r23);
        e0.a r28 = new e0.a();
        r28.h(r15.b());
        e0 r29 = r28.b();
        o.e(r29, "Builder().onePartyCommon…eBuilder.build()).build()");
        r27.d(r29);
        return r27.a();
    L30:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");     // Catch: Exception -> L40
    L31:
        com.obric.matrix.r.c.c.b("OnePartyCommonNetworkHelper", "onePartyNetworkRequest failed and value is " + r18.c());     // Catch: Exception -> L40
        d0 r30 = new d0();     // Catch: Exception -> L40
        r30.f18431f = String.valueOf(r18.c());     // Catch: Exception -> L40
        Throwable r31 = r18.a();     // Catch: Exception -> L40
        if (r31 == null) goto L34;
        com.obric.matrix.r.c.c.b("OnePartyCommonNetworkHelper", "onePartyNetworkRequest is failed and the throwable of onFailure is " + r31.getMessage());     // Catch: Exception -> L40
        com.obric.matrix.r.c.c.d("OnePartyCommonNetworkHelper", "onePartyNetworkRequest exception " + Log.getStackTraceString(r31));     // Catch: Exception -> L40
        r30.f18431f = r31.getMessage();     // Catch: Exception -> L40
    L34:
        r23 = g.f8932a.a((String) r30.f18431f);     // Catch: Exception -> L40
        if (r23 != null) goto L37;
        r23 = new com.obric.matrix.u.a(r18.b(), kotlin.k0.j.a.b.b(-100013), "Common network request is failed");     // Catch: Exception -> L40
    L37:
        r15.c(kotlin.k0.j.a.b.a(false));     // Catch: Exception -> L40
        r15.d(r18.b());     // Catch: Exception -> L40
        r15.b();     // Catch: Exception -> L40
    L14:
        e = e;
        r15 = r9;
        r1 = r14;
        r16 = r12;
        r17 = r11;
        r2 = r13;
    L44:
        String r32 = "onePartyNetworkRequest occurs exception: " + e.getMessage() + " and request is " + r2;
        r15.c(kotlin.k0.j.a.b.a(false));
        r15.d("-1");
        r15.b();
        r23 = new com.obric.matrix.u.a("-1", kotlin.k0.j.a.b.b(-100010), r32);
        goto L45
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        w.b(r0);
        r17 = r2.o.s;
        new com.obric.matrix.u.a(null, null, null, 7, null);
        r15 = new v.a();
        o.e(r17, "requestBody");     // Catch: Exception -> L42
        r3.f8937f = r1;     // Catch: Exception -> L42
        r3.f8938g = r2;     // Catch: Exception -> L42
        r16 = r21;
        r3.f8939h = r16;     // Catch: Exception -> L40
        r3.f8940i = r17;     // Catch: Exception -> L40
        r3.f8941j = r15;     // Catch: Exception -> L40
        r3.m = 1;     // Catch: Exception -> L40
        r0 = r1.b(r17, r2, r3);     // Catch: Exception -> L40
        if (r0 != r5) goto L24;
        return r5;
    L40:
        e = e;
    L42:
        e = e;
        r16 = r21;
    L7:
        r3 = new c(r1, r22);
        goto L8
    }
}
