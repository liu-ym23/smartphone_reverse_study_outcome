package com.android.settings.service;

import com.android.settings.service.bean.DeviceInfo;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HeaderMap;
import com.bytedance.retrofit2.http.Query;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: ApiService.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001JH\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u00052\u0016\b\u0001\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tH§@¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/android/settings/service/ApiService;", "", "getDeviceInfo", "Lcom/android/settings/service/bean/DeviceInfo;", "osRegion", "", "osLanguage", "model", "headers", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface ApiService {

    /* JADX INFO: compiled from: ApiService.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Object getDeviceInfo$default(ApiService r6, String r7, String r8, String r9, Map r10, Continuation r11, int r12, Object r13) {
            if (r13 != null) goto L9;
            if ((r12 & 1) == 0) goto L7;
            r7 = null;
        L7:
            return r6.getDeviceInfo(r7, r8, r9, r10, r11);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getDeviceInfo");
        }
    }

    @GET("/cloud/os/api/warranty/v2")
    Object getDeviceInfo(@Query("os_region") String r1, @Query("os_language") String r2, @Query("model") String r3, @HeaderMap Map<String, String> r4, Continuation<? super DeviceInfo> r5);
}
