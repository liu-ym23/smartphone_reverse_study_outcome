package com.obric.matrix.sdk.network.interceptor;

import a.a;
import android.text.TextUtils;
import android.util.Log;
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
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class RequestLogInterceptor implements Interceptor {
    private final long LOG_BODY_SIZE_LIMIT;

    @NotNull
    private final String TAG;

    public RequestLogInterceptor() {
        this.LOG_BODY_SIZE_LIMIT = 4096;
        this.TAG = "RequestLogInterceptor";
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    @NotNull
    public SsResponse<?> intercept(@NotNull Interceptor.Chain r11) {
        Intrinsics.f(r11, "chain");
        long r0 = System.currentTimeMillis();
        int r2 = ThreadLocalRandom.current().nextInt(1000, KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD);
        Request r3 = r11.request();
        Log.d(this.TAG, "\n");
        Log.d(this.TAG, "（" + r2 + "）【---------------------------------------- request Start ----------------------------------------------】");
        String r4 = this.TAG;
        StringBuilder r5 = a.p(r2, "（", "）【① Url 】: ");
        r5.append(r3.getUrl());
        Log.d(r4, r5.toString());
        String r6 = this.TAG;
        StringBuilder r7 = a.p(r2, "（", "）【② Method 】 : ");
        r7.append(r3.getMethod());
        Log.d(r6, r7.toString());
        String r8 = this.TAG;
        StringBuilder r9 = a.p(r2, "（", "）【③ Header 】 : ");
        r9.append(r3.getHeaders());
        Log.d(r8, r9.toString());
        TypedOutput r10 = r3.getBody();
        if (r10 == null) goto L24;
        long r12 = r10.length();
        if (r12 <= this.LOG_BODY_SIZE_LIMIT) goto L45;
        Log.d(this.TAG, "（" + r2 + "）【④ body 】 : length = " + r12);
        goto L24
    L45:
        ByteArrayOutputStream r13 = new ByteArrayOutputStream();     // Catch: Exception -> L16
        TypedOutput r14 = r3.getBody();     // Catch: Throwable -> L10
        if (r14 == null) goto L12;
        r14.writeTo(r13);     // Catch: Throwable -> L10
    L12:
        Log.d(this.TAG, "（" + r2 + "）【④ body 】 : " + r13);     // Catch: Throwable -> L10
    L14:
        CloseableKt.a(r13, null);     // Catch: Exception -> L16
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        CloseableKt.a(r13, th);     // Catch: Exception -> L16
        throw th;     // Catch: Exception -> L16
    L16:
        e = move-exception;
        Log.e(this.TAG, "intercept: ", e);
    L24:
        SsResponse<?> r15 = r11.proceed(r3);
        if ((r15.raw().getBody() instanceof TypedByteArray) == true) goto L27;
    L43:
        Log.d(this.TAG, "【---------------------------------------- End:" + (System.currentTimeMillis() - r0) + "毫秒 ----------------------------------------】");
        return r15;
    L27:
        if (TextUtils.isEmpty(r3.getUrl()) == true) goto L43;
        String r16 = r3.getUrl();
        Intrinsics.e(r16, "request.url");
        if (StringsKt.F(r16, OceanHttpUtil.INSTANCE.getUrl(), false) == false) goto L43;
        TypedInput r17 = r15.raw().getBody();
        if (r17 == null) goto L42;
        byte[] r18 = ((TypedByteArray) r17).getBytes();
        if (r18 == null) goto L43;
        if (r18.length != 0) goto L37;
        boolean r19 = true;
    L39:
        if ((!r19) == false) goto L43;
        Log.d(this.TAG, "（" + r2 + "）【 Response 】 : ");
        Log.d(this.TAG, new String(r18, 0, Math.min(r18.length, 4096), Charsets.f354a));
        goto L43
    L37:
        r19 = false;
        goto L39
    L42:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.retrofit2.mime.TypedByteArray");
    }
}
