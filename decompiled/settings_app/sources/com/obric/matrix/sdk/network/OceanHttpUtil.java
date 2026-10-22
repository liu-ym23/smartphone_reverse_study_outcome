package com.obric.matrix.sdk.network;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.android.settings.wifi.WifiAuthorizeUtils;
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
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OceanHttpUtil.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u0015J\u001f\u0010\u0016\u001a\u0002H\u0017\"\u0004\b\u0000\u0010\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u000f¢\u0006\u0002\u0010\u0019J\u001f\u0010\u001a\u001a\u0002H\u0017\"\u0004\b\u0000\u0010\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u000f¢\u0006\u0002\u0010\u0019J'\u0010\u001b\u001a\u0002H\u0017\"\u0004\b\u0000\u0010\u00172\u0006\u0010\u001c\u001a\u00020\u00042\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u000f¢\u0006\u0002\u0010\u001dJ\u0006\u0010\u001e\u001a\u00020\u0012J\u0006\u0010\u001f\u001a\u00020\u0004J\u0006\u0010 \u001a\u00020\u0004J\u0006\u0010!\u001a\u00020\u0012J\b\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020#H\u0002J'\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020\u00042\u0010\b\u0002\u0010'\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0015H\u0000¢\u0006\u0002\b(R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f\u0012\u0004\u0012\u00020\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f\u0012\u0004\u0012\u00020\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/obric/matrix/sdk/network/OceanHttpUtil;", "", "()V", "<set-?>", "", "RELEASE_HOST", "getRELEASE_HOST", "()Ljava/lang/String;", "RELEASE_URL", "getRELEASE_URL", "interceptorsList", "", "Lcom/bytedance/retrofit2/intercept/Interceptor;", "sArrayMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/lang/Class;", "sDownloadArrayMap", "sDownloadRetrofit", "Lcom/bytedance/retrofit2/Retrofit;", "sRetrofit", "buildInterceptors", "", "create", ExifInterface.GPS_DIRECTION_TRUE, "service", "(Ljava/lang/Class;)Ljava/lang/Object;", "createDownloadService", "createDownloadServiceWithCustomUrl", "customUrl", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "getDownloadRetrofit", "getURLDomain", "getUrl", "getsRetrofit", "resetDownloadRetrofit", "", "resetRetrofit", "setParam", WifiAuthorizeUtils.AUTO_LOGIN_HOST, "interceptors", "setParam$sdk_network_release", "sdk_network_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OceanHttpUtil {
    public static final OceanHttpUtil INSTANCE = null;
    private static String RELEASE_HOST;
    private static List<Interceptor> interceptorsList;
    private static final ConcurrentHashMap<Class<?>, Object> sArrayMap = null;
    private static final ConcurrentHashMap<Class<?>, Object> sDownloadArrayMap = null;
    private static volatile Retrofit sDownloadRetrofit;
    private static volatile Retrofit sRetrofit;

    private OceanHttpUtil() {
    }

    static {
        INSTANCE = new OceanHttpUtil();
        RELEASE_HOST = "";
        interceptorsList = new ArrayList();
        sArrayMap = new ConcurrentHashMap();
        sDownloadArrayMap = new ConcurrentHashMap();
    }

    public final String getRELEASE_HOST() {
        return RELEASE_HOST;
    }

    private final String getRELEASE_URL() {
        return "https://" + RELEASE_HOST;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setParam$sdk_network_release$default(OceanHttpUtil r0, String r1, List r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.setParam$sdk_network_release(r1, r2);
    }

    public final void setParam$sdk_network_release(String r2, List<? extends Interceptor> r3) {
        Intrinsics.checkNotNullParameter(r2, WifiAuthorizeUtils.AUTO_LOGIN_HOST);
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        RELEASE_HOST = r2;
        if (r3 == null) goto L9;
        ArrayList r4 = CollectionsKt.toMutableList(r3);
        if (r4 == null) goto L9;
    L10:
        interceptorsList = r4;
        if (sRetrofit == null) goto L14;
        resetRetrofit();
    L14:
        if (sDownloadRetrofit == null) goto L17;
        resetDownloadRetrofit();
        return;
    L17:
        return;
    L9:
        r4 = new ArrayList();
        goto L10
    }

    private final void resetRetrofit() {
        monitor-enter(OceanHttpUtil.class);
        sRetrofit = null;     // Catch: Throwable -> L8
        sArrayMap.clear();     // Catch: Throwable -> L8
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(OceanHttpUtil.class);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private final void resetDownloadRetrofit() {
        monitor-enter(OceanHttpUtil.class);
        sDownloadRetrofit = null;     // Catch: Throwable -> L8
        sDownloadArrayMap.clear();     // Catch: Throwable -> L8
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(OceanHttpUtil.class);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final String getUrl() {
        return getRELEASE_URL();
    }

    public final <T> T create(Class<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "service");
        ConcurrentHashMap<Class<?>, Object> r0 = sArrayMap;
        if (r0.containsKey(r3) == true) goto L5;
        T r2 = (T) getsRetrofit().create(r3);
        ConcurrentHashMap<Class<?>, Object> r1 = r0;
        if (r2 == null) goto L11;
        r1.put(r3, r2);
        return r2;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
    L5:
        return (T) r0.get(r3);
    }

    public final <T> T createDownloadService(Class<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "service");
        ConcurrentHashMap<Class<?>, Object> r0 = sDownloadArrayMap;
        if (r0.containsKey(r3) == true) goto L5;
        T r2 = (T) getDownloadRetrofit().create(r3);
        ConcurrentHashMap<Class<?>, Object> r1 = r0;
        if (r2 == null) goto L11;
        r1.put(r3, r2);
        return r2;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
    L5:
        return (T) r0.get(r3);
    }

    public final Retrofit getsRetrofit() {
        if (sRetrofit == null) goto L5;
    L15:
        Retrofit r5 = sRetrofit;
        Intrinsics.checkNotNull(r5);
        return r5;
    L5:
        monitor-enter(OceanHttpUtil.class);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (sRetrofit != null) goto L9;
        OceanHttpUtil r0 = INSTANCE;     // Catch: Throwable -> L12
        sRetrofit = RetrofitUtils.createRetrofit(r0.getUrl(), r0.buildInterceptors(), GSonConverterFactory2TT.create(), RxJava2CallAdapterFactory.create(), null);     // Catch: Throwable -> L12
    L9:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(OceanHttpUtil.class);
        goto L15
    }

    public final Retrofit getDownloadRetrofit() {
        if (sDownloadRetrofit == null) goto L5;
    L15:
        Retrofit r5 = sDownloadRetrofit;
        Intrinsics.checkNotNull(r5);
        return r5;
    L5:
        monitor-enter(OceanHttpUtil.class);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (sDownloadRetrofit != null) goto L9;
        OceanHttpUtil r0 = INSTANCE;     // Catch: Throwable -> L12
        sDownloadRetrofit = RetrofitUtils.createRetrofit(r0.getUrl(), r0.buildInterceptors(), NoOpConverterFactory.create(), RxJava2CallAdapterFactory.create(), null);     // Catch: Throwable -> L12
    L9:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(OceanHttpUtil.class);
        goto L15
    }

    public final List<Interceptor> buildInterceptors() {
        ArrayList r1 = new ArrayList();
        r1.addAll(interceptorsList);
        return r1;
    }

    public final String getURLDomain() {
        return RELEASE_HOST;
    }

    public final <T> T createDownloadServiceWithCustomUrl(String r3, Class<T> r4) {
        Intrinsics.checkNotNullParameter(r3, "customUrl");
        Intrinsics.checkNotNullParameter(r4, "service");
        return (T) RetrofitUtils.createRetrofit(r3, buildInterceptors(), null, RxJava2CallAdapterFactory.create(), null).create(r4);
    }
}
