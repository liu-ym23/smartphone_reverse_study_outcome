package com.obric.matrix.sdk.network;

import android.text.TextUtils;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.obric.matrix.sdk.network.converter.GSonConverterFactory2TT;
import com.obric.matrix.sdk.network.converter.NoOpConverterFactory;
import com.obric.matrix.sdk.network.converter.RxJava2CallAdapterFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OceanHttpUtil {

    @NotNull
    public static final OceanHttpUtil INSTANCE = null;

    @NotNull
    private static String RELEASE_HOST;

    @NotNull
    private static List<Interceptor> interceptorsList;

    @NotNull
    private static final ConcurrentHashMap<Class<?>, Object> sArrayMap = null;

    @NotNull
    private static final ConcurrentHashMap<Class<?>, Object> sDownloadArrayMap = null;

    @Nullable
    private static volatile Retrofit sDownloadRetrofit;

    @Nullable
    private static volatile Retrofit sRetrofit;

    static {
        INSTANCE = new OceanHttpUtil();
        RELEASE_HOST = "";
        interceptorsList = new ArrayList();
        sArrayMap = new ConcurrentHashMap();
        sDownloadArrayMap = new ConcurrentHashMap();
    }

    private OceanHttpUtil() {
    }

    private final String getRELEASE_URL() {
        return "https://" + RELEASE_HOST;
    }

    private final void resetDownloadRetrofit() {
        monitor-enter(OceanHttpUtil.class);
        sDownloadRetrofit = null;     // Catch: Throwable -> L8
        sDownloadArrayMap.clear();     // Catch: Throwable -> L8
        monitor-exit(OceanHttpUtil.class);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private final void resetRetrofit() {
        monitor-enter(OceanHttpUtil.class);
        sRetrofit = null;     // Catch: Throwable -> L8
        sArrayMap.clear();     // Catch: Throwable -> L8
        monitor-exit(OceanHttpUtil.class);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setParam$sdk_network_release$default(OceanHttpUtil r0, String r1, List r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.setParam$sdk_network_release(r1, r2);
    }

    @NotNull
    public final List<Interceptor> buildInterceptors() {
        ArrayList r1 = new ArrayList();
        r1.addAll(interceptorsList);
        return r1;
    }

    public final <T> T create(@NotNull Class<T> r3) {
        Intrinsics.f(r3, "service");
        ConcurrentHashMap<Class<?>, Object> r0 = sArrayMap;
        if (r0.containsKey(r3) == true) goto L5;
        T r2 = (T) getsRetrofit().create(r3);
        if (r2 == null) goto L11;
        r0.put((Class<?>) r3, r2);
        return r2;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
    L5:
        return (T) r0.get(r3);
    }

    public final <T> T createDownloadService(@NotNull Class<T> r3) {
        Intrinsics.f(r3, "service");
        ConcurrentHashMap<Class<?>, Object> r0 = sDownloadArrayMap;
        if (r0.containsKey(r3) == true) goto L5;
        T r2 = (T) getDownloadRetrofit().create(r3);
        if (r2 == null) goto L11;
        r0.put((Class<?>) r3, r2);
        return r2;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
    L5:
        return (T) r0.get(r3);
    }

    public final <T> T createDownloadServiceWithCustomUrl(@NotNull String r3, @NotNull Class<T> r4) {
        Intrinsics.f(r3, "customUrl");
        Intrinsics.f(r4, "service");
        return (T) RetrofitUtils.createRetrofit(r3, buildInterceptors(), null, RxJava2CallAdapterFactory.create(), null).create(r4);
    }

    @NotNull
    public final Retrofit getDownloadRetrofit() {
        if (sDownloadRetrofit == null) goto L5;
    L16:
        Retrofit r5 = sDownloadRetrofit;
        Intrinsics.c(r5);
        return r5;
    L5:
        monitor-enter(OceanHttpUtil.class);
    L10:
        th = move-exception;
        throw th;
    L7:
        if (sDownloadRetrofit != null) goto L12;
        OceanHttpUtil r0 = INSTANCE;     // Catch: Throwable -> L10
        sDownloadRetrofit = RetrofitUtils.createRetrofit(r0.getUrl(), r0.buildInterceptors(), NoOpConverterFactory.create(), RxJava2CallAdapterFactory.create(), null);     // Catch: Throwable -> L10
    L12:
        monitor-exit(OceanHttpUtil.class);
        goto L16
    }

    @NotNull
    public final String getRELEASE_HOST() {
        return RELEASE_HOST;
    }

    @NotNull
    public final String getURLDomain() {
        return RELEASE_HOST;
    }

    @NotNull
    public final String getUrl() {
        return getRELEASE_URL();
    }

    @NotNull
    public final Retrofit getsRetrofit() {
        if (sRetrofit == null) goto L5;
    L16:
        Retrofit r5 = sRetrofit;
        Intrinsics.c(r5);
        return r5;
    L5:
        monitor-enter(OceanHttpUtil.class);
    L10:
        th = move-exception;
        throw th;
    L7:
        if (sRetrofit != null) goto L12;
        OceanHttpUtil r0 = INSTANCE;     // Catch: Throwable -> L10
        sRetrofit = RetrofitUtils.createRetrofit(r0.getUrl(), r0.buildInterceptors(), GSonConverterFactory2TT.create(), RxJava2CallAdapterFactory.create(), null);     // Catch: Throwable -> L10
    L12:
        monitor-exit(OceanHttpUtil.class);
        goto L16
    }

    public final void setParam$sdk_network_release(@NotNull String r2, @Nullable List<? extends Interceptor> r3) {
        Intrinsics.f(r2, "host");
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        RELEASE_HOST = r2;
        if (r3 == null) goto L8;
        ArrayList r4 = CollectionsKt.r(r3);
    L9:
        interceptorsList = r4;
        if (sRetrofit == null) goto L13;
        resetRetrofit();
    L13:
        if (sDownloadRetrofit == null) goto L16;
        resetDownloadRetrofit();
        return;
    L16:
        return;
    L8:
        r4 = new ArrayList();
        goto L9
    }
}
