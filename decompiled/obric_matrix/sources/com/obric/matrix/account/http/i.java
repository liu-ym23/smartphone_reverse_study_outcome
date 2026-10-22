package com.obric.matrix.account.http;

import android.util.Pair;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.Gson;
import com.obric.matrix.common_api.INetworkApi;
import h.a.m0;
import h.a.n1;
import h.a.p1;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.c.p;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.u;
import kotlin.v;
import kotlin.w;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u000e\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u000e\u001a\u008c\u0001\u00103\u001a\u0018\u0012\f\u0012\n\u0012\u0004\u0012\u0002H6\u0018\u000105\u0012\u0006\u0012\u0004\u0018\u00010704\"\b\b\u0000\u00106*\u0002082\f\u00109\u001a\b\u0012\u0004\u0012\u0002H60:2\u0006\u0010;\u001a\u00020\u00012\u0006\u0010<\u001a\u00020\u00012\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u00112\n\b\u0002\u0010>\u001a\u0004\u0018\u00010?2\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u00112\u0012\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0011\u001ax\u0010B\u001a\u0018\u0012\f\u0012\n\u0012\u0004\u0012\u0002H6\u0018\u000105\u0012\u0006\u0012\u0004\u0018\u00010704\"\b\b\u0000\u00106*\u0002082\f\u00109\u001a\b\u0012\u0004\u0012\u0002H60:2\u0006\u0010;\u001a\u00020\u00012\u0006\u0010C\u001a\u00020\u00012\u0006\u0010D\u001a\u00020\u00012\u0014\b\u0002\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u00112\u0014\b\u0002\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0011\u001ax\u0010E\u001a\u0018\u0012\f\u0012\n\u0012\u0004\u0012\u0002H6\u0018\u000105\u0012\u0006\u0012\u0004\u0018\u00010704\"\b\b\u0000\u00106*\u0002082\f\u00109\u001a\b\u0012\u0004\u0012\u0002H60:2\u0006\u0010;\u001a\u00020\u00012\u0006\u0010C\u001a\u00020\u00012\u0006\u0010D\u001a\u00020\u00012\u0014\b\u0002\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u00112\u0014\b\u0002\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0011\u001as\u0010F\u001a\b\u0012\u0004\u0012\u0002H60G\"\b\b\u0000\u00106*\u0002082\f\u00109\u001a\b\u0012\u0004\u0012\u0002H60:2\u0006\u0010;\u001a\u00020\u00012\u0006\u0010C\u001a\u00020\u00012\u0006\u0010D\u001a\u00020\u00012\u0014\b\u0002\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u00112\u0014\b\u0002\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0011H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010H\u001ay\u0010I\u001a\b\u0012\u0004\u0012\u0002H60G\"\b\b\u0000\u00106*\u0002082\f\u00109\u001a\b\u0012\u0004\u0012\u0002H60:2\u0006\u0010;\u001a\u00020\u00012\u0014\b\u0002\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u00112\u0014\b\u0002\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u00112\u0014\b\u0002\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0011H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010J\u001as\u0010K\u001a\b\u0012\u0004\u0012\u0002H60G\"\b\b\u0000\u00106*\u0002082\f\u00109\u001a\b\u0012\u0004\u0012\u0002H60:2\u0006\u0010;\u001a\u00020\u00012\u0006\u0010>\u001a\u00020?2\u0006\u0010L\u001a\u00020\u00012\u0014\b\u0002\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u00112\u0014\b\u0002\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0011H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010M\u001ak\u0010K\u001a\b\u0012\u0004\u0012\u0002H60G\"\b\b\u0000\u00106*\u0002082\f\u00109\u001a\b\u0012\u0004\u0012\u0002H60:2\u0006\u0010;\u001a\u00020\u00012\u0006\u0010>\u001a\u00020N2\u0014\b\u0002\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u00112\u0014\b\u0002\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0011H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010O\u001as\u0010P\u001a\b\u0012\u0004\u0012\u0002H60G\"\b\b\u0000\u00106*\u0002082\f\u00109\u001a\b\u0012\u0004\u0012\u0002H60:2\u0006\u0010;\u001a\u00020\u00012\u0006\u0010C\u001a\u00020\u00012\u0006\u0010D\u001a\u00020\u00012\u0014\b\u0002\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u00112\u0014\b\u0002\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0011H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010H\u001a\u000e\u0010Q\u001a\u0002012\u0006\u00102\u001a\u00020\u000e\u001a4\u0010R\u001a\b\u0012\u0004\u0012\u0002H60G\"\b\b\u0000\u00106*\u0002082\u000e\u0010S\u001a\n\u0012\u0004\u0012\u0002H6\u0018\u0001052\n\b\u0002\u0010T\u001a\u0004\u0018\u000107H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\")\u0010\u0006\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000\".\u0010\u000f\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0011\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\"\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0011\u0010\u001e\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019\"\u001b\u0010 \u001a\u00020\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b!\u0010\"\"\u0011\u0010%\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001d\"\u0011\u0010'\u001a\u00020(¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*\"\u001b\u0010+\u001a\u00020,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010$\u001a\u0004\b-\u0010.\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006U"}, d2 = {"HEADER_KEY_NOT_OLY_ACCOUNT", "", "HEADER_KEY_OLY_ACCOUNT", "HEADER_KEY_USE_BOE", "HEADER_KEY_USE_PPE", "HEADER_KEY_X_TT", "UrlHandler", "Lcom/obric/matrix/account/common/InitOnce;", "Lkotlin/Function2;", "Lcom/obric/matrix/account/http/HttpEnv;", "getUrlHandler", "()Lcom/obric/matrix/account/common/InitOnce;", "apiRespInterceptors", "", "Lcom/obric/matrix/account/http/IApiRespInterceptor;", "commonHeaderFetcher", "Lkotlin/Function0;", "", "getCommonHeaderFetcher", "()Lkotlin/jvm/functions/Function0;", "setCommonHeaderFetcher", "(Lkotlin/jvm/functions/Function0;)V", "fileDispatcher", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "getFileDispatcher", "()Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "fileExecutor", "Ljava/util/concurrent/ExecutorService;", "getFileExecutor", "()Ljava/util/concurrent/ExecutorService;", "httpDispatcher", "getHttpDispatcher", "httpEnv", "getHttpEnv", "()Lcom/obric/matrix/account/http/HttpEnv;", "httpEnv$delegate", "Lkotlin/Lazy;", "httpExecutor", "getHttpExecutor", "httpGson", "Lcom/google/gson/Gson;", "getHttpGson", "()Lcom/google/gson/Gson;", "networkClient", "Lcom/bytedance/common/utility/NetworkClient;", "getNetworkClient", "()Lcom/bytedance/common/utility/NetworkClient;", "networkClient$delegate", "addApiRespInterceptor", "", "interceptor", "doExecute", "Lkotlin/Pair;", "Lcom/obric/matrix/account/http/Resp;", "T", "", "", "clazz", "Ljava/lang/Class;", WsConstants.KEY_CONNECTION_URL, "method", "params", "body", "", "headers", "query", "doExecuteFile", "name", "path", "doExecutePostFile", "httpFile", "Lcom/obric/matrix/account/http/Async;", "(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "httpGet", "(Ljava/lang/Class;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "httpPost", "contentType", "(Ljava/lang/Class;Ljava/lang/String;[BLjava/lang/String;Ljava/util/Map;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lorg/json/JSONObject;", "(Ljava/lang/Class;Ljava/lang/String;Lorg/json/JSONObject;Ljava/util/Map;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "httpPostFile", "removeApiRespInterceptor", "wrapResult", "resp", "throwable", "account_cnRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ExecutorService f8505a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final n1 f8506b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ExecutorService f8507c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Gson f8508d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final kotlin.h f8509e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final com.obric.matrix.account.m.b<p<h, String, String>> f8510f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final List<j> f8511g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final kotlin.h f8512h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static kotlin.n0.c.a<? extends Map<String, String>> f8513i;

    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lkotlin/Function2;", "Lcom/obric/matrix/account/http/HttpEnv;", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class a extends q implements kotlin.n0.c.a<p<? super h, ? super String, ? extends String>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f8514f = null;

        /* JADX INFO: renamed from: com.obric.matrix.account.http.i$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Lcom/obric/matrix/account/http/HttpEnv;", WsConstants.KEY_CONNECTION_URL, "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        static final class C0219a extends q implements p<h, String, String> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final C0219a f8515f = null;

            static {
                f8515f = new C0219a();
            }

            C0219a() {
                super(2);
            }

            public final String a(h r1, String r2) {
                o.f(r1, "<anonymous parameter 0>");
                o.f(r2, WsConstants.KEY_CONNECTION_URL);
                return r2;
            }

            @Override // kotlin.n0.c.p
            public /* bridge */ /* synthetic */ String invoke(h r1, String r2) {
                String r3 = r2;
                a(r1, r3);
                return r3;
            }
        }

        static {
            f8514f = new a();
        }

        a() {
            super(0);
        }

        public final p<h, String, String> a() {
            return C0219a.f8515f;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ p<? super h, ? super String, ? extends String> invoke() {
            return a();
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lkotlin/Function2;", "Lcom/obric/matrix/account/http/HttpEnv;", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class b extends q implements kotlin.n0.c.a<p<? super h, ? super String, ? extends String>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f8516f = null;

        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "httpEnv", "Lcom/obric/matrix/account/http/HttpEnv;", WsConstants.KEY_CONNECTION_URL, "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        static final class a extends q implements p<h, String, String> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final a f8517f = null;

            static {
                f8517f = new a();
            }

            a() {
                super(2);
            }

            public final String a(h r4, String r5) {
                o.f(r4, "httpEnv");
                o.f(r5, WsConstants.KEY_CONNECTION_URL);
                if (kotlin.u0.k.A(r5, "/", false, 2, null) == true) goto L5;
                return r5;
            L5:
                if (r4.a() == false) goto L7;
                StringBuilder r3 = new StringBuilder();
                com.obric.matrix.account.m.a r0 = com.obric.matrix.account.m.a.f8586a;
                r3.append("https://");
                String r6 = "os-assistant-boe.bytedance.net";
            L8:
                r3.append(r6);
                r3.append(r5);
                return r3.toString();
            L7:
                r3 = new StringBuilder();
                com.obric.matrix.account.m.a r1 = com.obric.matrix.account.m.a.f8586a;
                r3.append("https://");
                r6 = "os.oceancloudapi.com";
                goto L8
            }

            @Override // kotlin.n0.c.p
            public /* bridge */ /* synthetic */ String invoke(h r1, String r2) {
                return a(r1, r2);
            }
        }

        static {
            f8516f = new b();
        }

        b() {
            super(0);
        }

        public final p<h, String, String> a() {
            return a.f8517f;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ p<? super h, ? super String, ? extends String> invoke() {
            return a();
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/obric/matrix/account/http/HttpEnv;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class c extends q implements kotlin.n0.c.a<h> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final c f8518f = null;

        static {
            f8518f = new c();
        }

        c() {
            super(0);
        }

        public final h a() {
            return h.f8500e.a();
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ h invoke() {
            return a();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @kotlin.k0.j.a.f(c = "com.obric.matrix.account.http.HttpExtKt$httpPost$3", f = "HttpExt.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "Lcom/obric/matrix/account/http/Async;", "T", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class d<T> extends kotlin.k0.j.a.l implements p<m0, kotlin.k0.d<? super com.obric.matrix.account.http.b<? extends T>>, Object> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f8519f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Map<String, String> f8520g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f8521h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ Class<T> f8522i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ String f8523j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ byte[] f8524k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ Map<String, String> f8525l;

        d(Map<String, String> r1, String r2, Class<T> r3, String r4, byte[] r5, Map<String, String> r6, kotlin.k0.d<? super d> r7) {
            this.f8520g = r1;
            this.f8521h = r2;
            this.f8522i = r3;
            this.f8523j = r4;
            this.f8524k = r5;
            this.f8525l = r6;
            super(2, r7);
        }

        @Override // kotlin.k0.j.a.a
        public final kotlin.k0.d<f0> create(Object r9, kotlin.k0.d<?> r10) {
            return new d(this.f8520g, this.f8521h, this.f8522i, this.f8523j, this.f8524k, this.f8525l, r10);
        }

        public final Object invoke(m0 r1, kotlin.k0.d<? super com.obric.matrix.account.http.b<? extends T>> r2) {
            return ((d) create(r1, r2)).invokeSuspend(f0.f18324a);
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ Object invoke(m0 r1, Object r2) {
            return invoke(r1, (kotlin.k0.d) r2);
        }

        @Override // kotlin.k0.j.a.a
        public final Object invokeSuspend(Object r8) {
            kotlin.k0.i.b.c();
            if (this.f8519f != 0) goto L7;
            w.b(r8);
            Map r5 = kotlin.i0.m0.u(this.f8520g);
            r5.put(INetworkApi.CONTENT_TYPE, this.f8521h);
            u r7 = i.b(this.f8522i, this.f8523j, "POST", kotlin.i0.m0.h(), this.f8524k, r5, this.f8525l);
            return i.a((Resp) r7.c(), (Throwable) r7.d());
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/obric/matrix/account/http/CustomNetworkClient;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class e extends q implements kotlin.n0.c.a<f> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final e f8526f = null;

        static {
            f8526f = new e();
        }

        e() {
            super(0);
        }

        public final f a() {
            return new f();
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ f invoke() {
            return a();
        }
    }

    static {
        ExecutorService r1 = Executors.newFixedThreadPool(1);
        o.e(r1, "newFixedThreadPool(1)");
        f8505a = r1;
        f8506b = p1.b(r1);
        ExecutorService r0 = Executors.newFixedThreadPool(1);
        o.e(r0, "newFixedThreadPool(1)");
        f8507c = r0;
        p1.b(r0);
        Gson r2 = new com.google.gson.e().d();
        o.e(r2, "GsonBuilder().create()");
        f8508d = r2;
        f8509e = kotlin.i.b(e.f8526f);
        com.obric.matrix.account.m.b<p<h, String, String>> r3 = new com.obric.matrix.account.m.b(a.f8514f);
        r3.d(b.f8516f);
        f8510f = r3;
        f8511g = new ArrayList();
        f8512h = kotlin.i.b(c.f8518f);
    }

    public static final /* synthetic */ com.obric.matrix.account.http.b a(Resp r0, Throwable r1) {
        return h(r0, r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v32 */
    /* JADX WARN: Type inference failed for: r0v33 */
    /* JADX WARN: Type inference failed for: r0v36 */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v16 */
    public static final <T> u<Resp<T>, Throwable> b(Class<T> r8, String r9, String r10, Map<String, String> r11, byte[] r12, Map<String, String> r13, Map<String, String> r14) {
        o.f(r8, "clazz");
        o.f(r9, WsConstants.KEY_CONNECTION_URL);
        o.f(r10, "method");
        o.f(r11, "params");
        o.f(r13, "headers");
        o.f(r14, "query");
        com.obric.matrix.r.c.c.j("doExecute", r9 + ' ' + r10);
        Map<String, String> r15 = kotlin.i0.m0.u(r13);
        kotlin.n0.c.a<? extends Map<String, String>> r0 = f8513i;
        if (r0 == null) goto L7;
        Map<String, String> r1 = r0.invoke();
        if (r1 == null) goto L7;
        r15.putAll(r1);
    L7:
        d.b.h.a.a.h.s.k r2 = new d.b.h.a.a.h.s.k(f8510f.c().invoke(c(), r9));
        if (r15.containsKey("not-use-olympus-account") == false) goto L10;
        r2.b("use-olympus-account", BDLocationException.ERROR_TIMEOUT);
        r15.remove("not-use-olympus-account");
    L11:
        Iterator<Map.Entry<String, String>> r16 = r14.entrySet().iterator();
    L13:
        if (r16.hasNext() == false) goto L15;
        Map.Entry<String, String> r3 = r16.next();
        r2.b(r3.getKey(), r3.getValue());
        goto L13
    L15:
        String r17 = r2.toString();
        o.e(r17, "UrlBuilder(UrlHandler()(…       }\n    }.toString()");
        u<String, String> r4 = com.obric.matrix.account.b.f8440a.a();
        if (r4 == null) goto L18;
        r15.put(r4.c(), r4.d());
    L18:
        boolean r5 = false;
        if (c().a() == false) goto L28;
        r15.put("x-use-boe", LocationInfoConst.ALLOW_USE_LOCATION);
        if (c().b().length() <= 0) goto L23;
        ?? r6 = true;
    L24:
        if (r6 == false) goto L35;
        String r7 = c().b();
    L26:
        r15.put("x-tt-env", r7);
    L35:
        com.bytedance.common.utility.g.a r18 = new com.bytedance.common.utility.g.a();
        v.a r19 = v.f21457g;     // Catch: Throwable -> L53
        if (o.a("POST", r10) == false) goto L46;
        r18.f3274a = true;     // Catch: Throwable -> L53
        if (r12 == null) goto L41;
        Object r110 = d().h(r17, r12, r15, r18);     // Catch: Throwable -> L53
    L51:
        v.b(r110);     // Catch: Throwable -> L53
    L55:
        Throwable r111 = v.d(r110);
        Resp<T> r20 = null;
        Object r21 = null;
        if (r111 != null) goto L58;
        r111 = null;
    L59:
        String r112 = (String) r110;
        if (r111 == null) goto L93;
    L78:
        List<j> r22 = f8511g;
        if ((!r22.isEmpty()) == false) goto L87;
        Iterator<T> r23 = r22.iterator();
    L82:
        if (r23.hasNext() == false) goto L87;
        if (((j) r23.next()).a(r9, r20, r111) == false) goto L82;
        r5 = true;
    L87:
        if (r5 == false) goto L89;
        u<Resp<T>, Throwable> r24 = new u(r20, new com.obric.matrix.account.http.a(r20, r111));
    L90:
        return r24;
    L89:
        r24 = new u(r20, r111);
        goto L90
    L93:
        v.a r25 = v.f21457g;     // Catch: Throwable -> L63
        Object r26 = (Resp) f8508d.n(r112, com.google.gson.z.a.getParameterized(Resp.class, new Type[]{r8}).getType());     // Catch: Throwable -> L63
        v.b(r26);     // Catch: Throwable -> L63
    L65:
        Throwable r113 = v.d(r26);
        if (r113 != null) goto L68;
        r21 = r26;
    L69:
        r20 = (Resp) r21;
        if (r20 != null) goto L72;
    L77:
        com.obric.matrix.r.c.c.f("httpext", r17 + '[' + r10 + "]: " + r18);
        goto L78
    L72:
        if (r20.getCode() != 0) goto L74;
        ?? r114 = true;
    L75:
        if (r114 == false) goto L77;
        com.obric.matrix.r.c.c.b("httpext", r17 + '[' + r10 + "]: " + r18);
        goto L78
    L74:
        r114 = false;
        goto L75
    L68:
        r111 = r113;
    L63:
        th = move-exception;
        v.a r115 = v.f21457g;
        r26 = w.a(th);
        v.b(r26);
        goto L65
    L58:
        com.obric.matrix.r.c.c.g("httpext", r17 + '[' + r10 + "]:", r111);
        r110 = "";
        goto L59
    L41:
        ArrayList r116 = new ArrayList();     // Catch: Throwable -> L53
        ArrayList r27 = new ArrayList(r11.size());     // Catch: Throwable -> L53
        Iterator<Map.Entry<String, String>> r117 = r11.entrySet().iterator();     // Catch: Throwable -> L53
    L43:
        if (r117.hasNext() == false) goto L45;
        Map.Entry<String, String> r28 = r117.next();     // Catch: Throwable -> L53
        r27.add(Boolean.valueOf(r116.add(new Pair(r28.getKey(), r28.getValue()))));     // Catch: Throwable -> L53
        goto L43
    L45:
        r110 = d().g(r17, r116, r15, r18);     // Catch: Throwable -> L53
        goto L51
    L46:
        d.b.h.a.a.h.s.k r118 = new d.b.h.a.a.h.s.k(r17);     // Catch: Throwable -> L53
        Iterator<Map.Entry<String, String>> r119 = r11.entrySet().iterator();     // Catch: Throwable -> L53
    L48:
        if (r119.hasNext() == false) goto L50;
        Map.Entry<String, String> r29 = r119.next();     // Catch: Throwable -> L53
        r118.b(r29.getKey(), r29.getValue());     // Catch: Throwable -> L53
        goto L48
    L50:
        r110 = d().e(r17, r15, r18);     // Catch: Throwable -> L53
    L53:
        th = move-exception;
        v.a r120 = v.f21457g;
        r110 = w.a(th);
        v.b(r110);
        goto L55
    L23:
        r6 = false;
        goto L24
    L28:
        if (c().c() == false) goto L35;
        r15.put("x-use-ppe", LocationInfoConst.ALLOW_USE_LOCATION);
        if (c().d().length() <= 0) goto L32;
        ?? r30 = true;
    L33:
        if (r30 == false) goto L35;
        r7 = c().d();
        goto L26
    L32:
        r30 = false;
        goto L33
    L10:
        r2.b("use-olympus-account", LocationInfoConst.ALLOW_USE_LOCATION);
        goto L11
    }

    public static final h c() {
        return (h) f8512h.getValue();
    }

    private static final com.bytedance.common.utility.g d() {
        return (com.bytedance.common.utility.g) f8509e.getValue();
    }

    public static final <T> Object e(Class<T> r8, String r9, JSONObject r10, Map<String, String> r11, Map<String, String> r12, kotlin.k0.d<? super com.obric.matrix.account.http.b<? extends T>> r13) {
        String r14 = r10.toString();
        o.e(r14, "body.toString()");
        byte[] r3 = r14.getBytes(kotlin.u0.d.f21429a);
        o.e(r3, "this as java.lang.String).getBytes(charset)");
        return f(r8, r9, r3, "application/json", r11, r12, r13);
    }

    public static final <T> Object f(Class<T> r10, String r11, byte[] r12, String r13, Map<String, String> r14, Map<String, String> r15, kotlin.k0.d<? super com.obric.matrix.account.http.b<? extends T>> r16) {
        return h.a.h.e(f8506b, new d(r14, r13, r10, r11, r12, r15, null), r16);
    }

    public static /* synthetic */ Object g(Class r6, String r7, JSONObject r8, Map r9, Map r10, kotlin.k0.d r11, int r12, Object r13) {
        if ((r12 & 8) == 0) goto L5;
        r9 = kotlin.i0.m0.h();
    L5:
        Map r3 = r9;
        if ((r12 & 16) == 0) goto L9;
        r10 = kotlin.i0.m0.h();
    L9:
        return e(r6, r7, r8, r3, r10, r11);
    }

    private static final <T> com.obric.matrix.account.http.b<T> h(Resp<T> r3, Throwable r4) {
        boolean r0 = true;
        if (r3 != null) goto L5;
    L10:
        r0 = false;
    L11:
        if (r0 == false) goto L14;
        return new l(r3.getData(), r3.getPayload());
    L14:
        if (r3 == null) goto L16;
        int r2 = r3.getCode();
    L17:
        if (r3 == null) goto L20;
        String r5 = r3.getMsg();
        if (r5 == null) goto L20;
    L21:
        if (r4 != null) goto L24;
        r4 = k.f8527f;
    L24:
        return new g(new com.obric.matrix.account.http.d(r2, r5, r4), null, 2, null);
    L20:
        r5 = "";
        goto L21
    L16:
        r2 = Resp.CODE_UNKNOWN;
        goto L17
    L5:
        if (r3.getCode() != 0) goto L7;
        boolean r6 = true;
    L8:
        if (r6 != true) goto L10;
    L7:
        r6 = false;
        goto L8
    }
}
