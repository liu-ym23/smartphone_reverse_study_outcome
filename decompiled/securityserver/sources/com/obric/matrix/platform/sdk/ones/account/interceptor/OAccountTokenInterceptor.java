package com.obric.matrix.platform.sdk.ones.account.interceptor;

import android.text.TextUtils;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.obric.matrix.platform.sdk.ones.account.OAccount;
import com.obric.matrix.platform.sdk.ones.account.OAccountManager;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OAccountTokenInterceptor implements Interceptor {
    public OAccountTokenInterceptor() {
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    @NotNull
    public SsResponse<?> intercept(@NotNull Interceptor.Chain r7) {
        Intrinsics.f(r7, "chain");
        Request r6 = r7.request();
        String r0 = new URI(r6.getUrl()).getHost();
        Intrinsics.e(r0, "URI(request.url).host");
        String r1 = r0.toLowerCase();
        Intrinsics.e(r1, "this as java.lang.String).toLowerCase()");
        ArrayList r2 = new ArrayList();
        List<Header> r3 = r6.getHeaders();
        Intrinsics.e(r3, "request.headers");
        r2.addAll(r3);
        Iterator<T> r4 = OAccount.INSTANCE.accountBridge().addTokenHost().iterator();
        Map<String, String> r5 = null;
    L4:
        if (r4.hasNext() == false) goto L8;
        String r8 = ((String) r4.next()).toLowerCase();
        Intrinsics.e(r8, "this as java.lang.String).toLowerCase()");
        if (StringsKt.o(r1, r8) == false) goto L4;
        r5 = OAccountManager.INSTANCE.xttTokenMap();
        goto L4
    L8:
        if (r5 != null) goto L10;
    L19:
        SsResponse<?> r9 = r7.proceed(r6.newBuilder().headers(r2).build());
        Intrinsics.e(r9, "chain.proceed(request.ne…headers(headers).build())");
        return r9;
    L10:
        if (r5.isEmpty() == true) goto L19;
        Iterator<Map.Entry<String, String>> r10 = r5.entrySet().iterator();
    L13:
        if (r10.hasNext() == false) goto L19;
        Map.Entry<String, String> r11 = r10.next();
        if (TextUtils.isEmpty(r11.getKey()) == true) goto L13;
        if (TextUtils.isEmpty(r11.getValue()) == true) goto L13;
        r2.add(new Header(r11.getKey(), r11.getValue()));
        goto L13
    }
}
