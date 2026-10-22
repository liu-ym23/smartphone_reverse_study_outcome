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

/* JADX INFO: compiled from: OAccountTokenInterceptor.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/account/interceptor/OAccountTokenInterceptor;", "Lcom/bytedance/retrofit2/intercept/Interceptor;", "()V", "intercept", "Lcom/bytedance/retrofit2/SsResponse;", "chain", "Lcom/bytedance/retrofit2/intercept/Interceptor$Chain;", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OAccountTokenInterceptor implements Interceptor {
    public OAccountTokenInterceptor() {
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public SsResponse<?> intercept(Interceptor.Chain r10) {
        Intrinsics.checkNotNullParameter(r10, "chain");
        Request r9 = r10.request();
        String r0 = new URI(r9.getUrl()).getHost();
        Intrinsics.checkNotNullExpressionValue(r0, "URI(request.url).host");
        String r1 = r0.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(r1, "this as java.lang.String).toLowerCase()");
        ArrayList r2 = new ArrayList();
        List<Header> r3 = r9.getHeaders();
        Intrinsics.checkNotNullExpressionValue(r3, "request.headers");
        r2.addAll(r3);
        Iterator<T> r4 = OAccount.INSTANCE.accountBridge().addTokenHost().iterator();
        Map<String, String> r5 = null;
    L4:
        if (r4.hasNext() == false) goto L8;
        String r6 = ((String) r4.next()).toLowerCase();
        Intrinsics.checkNotNullExpressionValue(r6, "this as java.lang.String).toLowerCase()");
        if (StringsKt.endsWith$default(r1, r6, false, 2, null) == false) goto L4;
        r5 = OAccountManager.INSTANCE.xttTokenMap();
        goto L4
    L8:
        if (r5 != null) goto L10;
    L19:
        SsResponse<?> r11 = r10.proceed(r9.newBuilder().headers(r2).build());
        Intrinsics.checkNotNullExpressionValue(r11, "chain.proceed(request.ne…headers(headers).build())");
        return r11;
    L10:
        if (r5.isEmpty() == true) goto L19;
        Iterator<Map.Entry<String, String>> r7 = r5.entrySet().iterator();
    L13:
        if (r7.hasNext() == false) goto L19;
        Map.Entry<String, String> r8 = r7.next();
        if (TextUtils.isEmpty(r8.getKey()) == true) goto L13;
        if (TextUtils.isEmpty(r8.getValue()) == true) goto L13;
        r2.add(new Header(r8.getKey(), r8.getValue()));
        goto L13
    }
}
