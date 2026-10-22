package com.obric.safecheck.dataSync.httpclient;

import com.google.gson.Gson;
import com.obric.olog.OLog;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/* JADX INFO: loaded from: classes4.dex */
public class OkHttpUtils {
    private static final int CONNECT_TIMEOUT = 10;
    private static final HttpLoggingInterceptor LOGGING_INTERCEPTOR = null;
    private static final int READ_TIMEOUT = 30;
    private static final int WRITE_TIMEOUT = 10;

    private static class SingletonHolder {
        private static final Gson GSON_INSTANCE = null;
        private static final OkHttpClient INSTANCE = null;

        /* JADX INFO: renamed from: -$$Nest$sfgetGSON_INSTANCE, reason: not valid java name */
        static /* bridge */ /* synthetic */ Gson m601$$Nest$sfgetGSON_INSTANCE() {
            return GSON_INSTANCE;
        }

        /* JADX INFO: renamed from: -$$Nest$sfgetINSTANCE, reason: not valid java name */
        static /* bridge */ /* synthetic */ OkHttpClient m602$$Nest$sfgetINSTANCE() {
            return INSTANCE;
        }

        private SingletonHolder() {
        }

        static {
            INSTANCE = new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).writeTimeout(10, TimeUnit.SECONDS).dns(new AnonymousClass2()).addInterceptor(OkHttpUtils.m600$$Nest$sfgetLOGGING_INTERCEPTOR()).addNetworkInterceptor(new AnonymousClass1()).build();
            GSON_INSTANCE = new Gson();
        }
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetLOGGING_INTERCEPTOR, reason: not valid java name */
    static /* bridge */ /* synthetic */ HttpLoggingInterceptor m600$$Nest$sfgetLOGGING_INTERCEPTOR() {
        return LOGGING_INTERCEPTOR;
    }

    static {
        LOGGING_INTERCEPTOR = new HttpLoggingInterceptor(new OkHttpUtils$$ExternalSyntheticLambda0()).setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    static /* synthetic */ void lambda$static$0(String r1) {
        OLog.i("OkHttp", r1);
    }

    public static OkHttpClient getInstance() {
        return SingletonHolder.m602$$Nest$sfgetINSTANCE();
    }

    public static Gson getGsonInstance() {
        return SingletonHolder.m601$$Nest$sfgetGSON_INSTANCE();
    }

    private OkHttpUtils() {
    }
}
