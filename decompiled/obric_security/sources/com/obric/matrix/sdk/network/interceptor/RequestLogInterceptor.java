package com.obric.matrix.sdk.network.interceptor;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.keva.KevaImpl;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.obric.matrix.sdk.network.OceanHttpUtil;
import java.io.ByteArrayOutputStream;
import java.util.concurrent.ThreadLocalRandom;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.apache.commons.io.IOUtils;

/* JADX INFO: compiled from: RequestLogInterceptor.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/matrix/sdk/network/interceptor/RequestLogInterceptor;", "Lcom/bytedance/retrofit2/intercept/Interceptor;", "()V", "LOG_BODY_SIZE_LIMIT", "", "TAG", "", "intercept", "Lcom/bytedance/retrofit2/SsResponse;", "chain", "Lcom/bytedance/retrofit2/intercept/Interceptor$Chain;", "sdk_network_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RequestLogInterceptor implements Interceptor {
    private final long LOG_BODY_SIZE_LIMIT;
    private final String TAG;

    public RequestLogInterceptor() {
        this.LOG_BODY_SIZE_LIMIT = 4096;
        this.TAG = "RequestLogInterceptor";
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public SsResponse<?> intercept(Interceptor.Chain r12) {
        Intrinsics.checkNotNullParameter(r12, "chain");
        long r0 = System.currentTimeMillis();
        int r2 = ThreadLocalRandom.current().nextInt(1000, KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD);
        Request r3 = r12.request();
        Log.d(this.TAG, IOUtils.LINE_SEPARATOR_UNIX);
        Log.d(this.TAG, "（" + r2 + "）【---------------------------------------- request Start ----------------------------------------------】");
        Log.d(this.TAG, "（" + r2 + "）【① Url 】: " + r3.getUrl());
        Log.d(this.TAG, "（" + r2 + "）【② Method 】 : " + r3.getMethod());
        Log.d(this.TAG, "（" + r2 + "）【③ Header 】 : " + r3.getHeaders());
        TypedOutput r4 = r3.getBody();
        if (r4 == null) goto L21;
        long r7 = r4.length();
        if (r7 <= this.LOG_BODY_SIZE_LIMIT) goto L46;
        Log.d(this.TAG, "（" + r2 + "）【④ body 】 : length = " + r7);
        goto L21
    L46:
        ByteArrayOutputStream r5 = new ByteArrayOutputStream();     // Catch: Exception -> L18
        ByteArrayOutputStream r8 = r5;     // Catch: Throwable -> L13
        TypedOutput r9 = r3.getBody();     // Catch: Throwable -> L13
        if (r9 == null) goto L10;
        r9.writeTo(r8);     // Catch: Throwable -> L13
    L10:
        Log.d(this.TAG, "（" + r2 + "）【④ body 】 : " + r8);     // Catch: Throwable -> L13
        CloseableKt.closeFinally(r5, null);     // Catch: Exception -> L18
        goto L21
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        CloseableKt.closeFinally(r5, th);     // Catch: Exception -> L18
        throw th;     // Catch: Exception -> L18
    L18:
        e = move-exception;
        Log.e(this.TAG, "intercept: ", e);
    L21:
        SsResponse<?> r13 = r12.proceed(r3);
        if ((r13.raw().getBody() instanceof TypedByteArray) == true) goto L24;
    L40:
        Log.d(this.TAG, "【---------------------------------------- End:" + (System.currentTimeMillis() - r0) + "毫秒 ----------------------------------------】");
        Intrinsics.checkNotNullExpressionValue(r13, ApmTrafficStats.TTNET_RESPONSE);
        return r13;
    L24:
        if (TextUtils.isEmpty(r3.getUrl()) == true) goto L40;
        String r6 = r3.getUrl();
        Intrinsics.checkNotNullExpressionValue(r6, "request.url");
        if (StringsKt.startsWith$default(r6, OceanHttpUtil.INSTANCE.getUrl(), false, 2, null) == false) goto L40;
        TypedInput r10 = r13.raw().getBody();
        if (r10 == null) goto L39;
        byte[] r11 = ((TypedByteArray) r10).getBytes();
        if (r11 == null) goto L40;
        if (r11.length != 0) goto L34;
        boolean r14 = true;
    L36:
        if ((!r14) == false) goto L40;
        Log.d(this.TAG, "（" + r2 + "）【 Response 】 : ");
        Log.d(this.TAG, new String(r11, 0, Math.min(r11.length, 4096), Charsets.UTF_8));
        goto L40
    L34:
        r14 = false;
        goto L36
    L39:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.retrofit2.mime.TypedByteArray");
    }
}
