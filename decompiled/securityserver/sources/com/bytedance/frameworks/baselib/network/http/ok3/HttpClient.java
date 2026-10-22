package com.bytedance.frameworks.baselib.network.http.ok3;

import android.content.Context;
import com.bytedance.frameworks.baselib.network.http.IHttpClient;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.SsOkHttp3Client;

/* JADX INFO: loaded from: classes.dex */
public class HttpClient {
    static final BaseImpl IMPL = null;

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.http.ok3.HttpClient$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class BaseImpl {
        private BaseImpl() {
        }

        public IHttpClient getHttpClient(Context r1) {
            return SsOkHttp3Client.inst(r1);
        }

        public /* synthetic */ BaseImpl(AnonymousClass1 r1) {
            this();
        }
    }

    static {
        IMPL = new BaseImpl(null);
    }

    public HttpClient() {
    }

    public static IHttpClient getHttpClient(Context r0, String r1) {
        return IMPL.getHttpClient(r0);
    }
}
