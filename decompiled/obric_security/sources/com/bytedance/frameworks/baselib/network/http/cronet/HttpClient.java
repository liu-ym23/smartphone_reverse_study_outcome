package com.bytedance.frameworks.baselib.network.http.cronet;

import android.content.Context;
import com.bytedance.frameworks.baselib.network.http.IHttpClient;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient;

/* JADX INFO: loaded from: classes.dex */
public class HttpClient {
    static final BaseImpl IMPL = null;

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.http.cronet.HttpClient$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class BaseImpl {
        private BaseImpl() {
        }

        /* synthetic */ BaseImpl(AnonymousClass1 r1) {
            this();
        }

        public IHttpClient getHttpClient(Context r1) {
            return SsCronetHttpClient.inst(r1);
        }
    }

    public HttpClient() {
    }

    static {
        IMPL = new BaseImpl(null);
    }

    public static IHttpClient getHttpClient(Context r0, String r1) {
        return IMPL.getHttpClient(r0);
    }
}
