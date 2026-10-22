package com.android.settings.provision;

import android.net.Uri;
import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.loopj.android.http.RequestParams;
import com.obric.olog.OLog;
import cz.msebera.android.httpclient.client.cache.HeaderConstants;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* JADX INFO: compiled from: ActivationDeviceRequest.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0014\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000fH\u0016J\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014R\u000e\u0010\r\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/android/settings/provision/ActivationDeviceRequest;", "Lcom/android/volley/toolbox/JsonObjectRequest;", "method", "", "url", "", "date", "Lorg/json/JSONObject;", "listener", "Lcom/android/volley/Response$Listener;", "errorListener", "Lcom/android/volley/Response$ErrorListener;", "(ILjava/lang/String;Lorg/json/JSONObject;Lcom/android/volley/Response$Listener;Lcom/android/volley/Response$ErrorListener;)V", "TAG", "getHeaders", "", "parseNetworkResponse", "Lcom/android/volley/Response;", ApmTrafficStats.TTNET_RESPONSE, "Lcom/android/volley/NetworkResponse;", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ActivationDeviceRequest extends JsonObjectRequest {
    private final String TAG;
    private final JSONObject date;
    private final int method;
    private final String url;

    public ActivationDeviceRequest(int r2, String r3, JSONObject r4, Response.Listener<JSONObject> r5, Response.ErrorListener r6) {
        Intrinsics.checkNotNullParameter(r3, "url");
        Intrinsics.checkNotNullParameter(r4, "date");
        Intrinsics.checkNotNullParameter(r5, "listener");
        Intrinsics.checkNotNullParameter(r6, "errorListener");
        super(r2, r3, r4, r5, r6);
        this.method = r2;
        this.url = r3;
        this.date = r4;
        this.TAG = "ActivationDeviceRequest";
    }

    @Override // com.android.volley.Request
    public Map<String, String> getHeaders() {
        LinkedHashMap r0 = new LinkedHashMap();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L13
        Map<String, String> r2 = super.getHeaders();     // Catch: Throwable -> L13
        if (r2 == null) goto L10;
        Intrinsics.checkNotNull(r2);     // Catch: Throwable -> L13
        Iterator<Map.Entry<String, String>> r3 = r2.entrySet().iterator();     // Catch: Throwable -> L13
    L7:
        if (r3.hasNext() == false) goto L9;
        Map.Entry<String, String> r4 = r3.next();     // Catch: Throwable -> L13
        String r5 = r4.getKey();     // Catch: Throwable -> L13
        String r6 = r4.getValue();     // Catch: Throwable -> L13
        Intrinsics.checkNotNull(r5);     // Catch: Throwable -> L13
        Intrinsics.checkNotNull(r6);     // Catch: Throwable -> L13
        r0.put(r5, r6);     // Catch: Throwable -> L13
        goto L7
    L9:
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L13
    L11:
        Object r8 = Result.m1508constructorimpl(r7);     // Catch: Throwable -> L13
    L15:
        Throwable r9 = Result.m1511exceptionOrNullimpl(r8);
        if (r9 == null) goto L18;
        OLog.e(this.TAG, "put origin header error", r9);
    L18:
        LinkedHashMap r10 = new LinkedHashMap();
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L28
        Uri r12 = Uri.parse(this.url);     // Catch: Throwable -> L28
        Set<String> r13 = r12.getQueryParameterNames();     // Catch: Throwable -> L28
        Intrinsics.checkNotNullExpressionValue(r13, "getQueryParameterNames(...)");     // Catch: Throwable -> L28
        Iterator<T> r14 = r13.iterator();     // Catch: Throwable -> L28
    L21:
        if (r14.hasNext() == false) goto L26;
        String r15 = (String) r14.next();     // Catch: Throwable -> L28
        Intrinsics.checkNotNull(r15);     // Catch: Throwable -> L28
        String r16 = r12.getQueryParameter(r15);     // Catch: Throwable -> L28
        if (r16 != null) goto L25;
        r16 = "";
    L25:
        Intrinsics.checkNotNull(r16);     // Catch: Throwable -> L28
        r10.put(r15, r16);     // Catch: Throwable -> L28
        goto L21
    L26:
        Result.m1508constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L28
    L30:
        String r17 = this.date.toString();
        Intrinsics.checkNotNullExpressionValue(r17, "toString(...)");
        byte[] r18 = r17.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(r18, "getBytes(...)");
        String r19 = ApiSignatureUtil.INSTANCE.generateSignature("POST", r10, r18, "b01b44e861fd3a62e767f43500cf6a4c");
        r0.put("Cache-Control", HeaderConstants.CACHE_CONTROL_NO_CACHE);
        r0.put("Content-Type", RequestParams.APPLICATION_JSON);
        r0.put("x-signature", "Pacific:" + r19);
        return r0;
    L28:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L30
    L10:
        r7 = null;
    L13:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r8 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    @Override // com.android.volley.toolbox.JsonObjectRequest, com.android.volley.toolbox.JsonRequest, com.android.volley.Request
    protected Response<JSONObject> parseNetworkResponse(NetworkResponse r7) {
        String r0 = this.TAG;
        StringBuilder r1 = new StringBuilder("parseNetworkResponse response: ");
        String r2 = null;
        if (r7 == null) goto L7;
        byte[] r3 = r7.data;
        if (r3 == null) goto L7;
        String r4 = new String(r3, Charsets.UTF_8);
    L8:
        OLog.i(r0, r1.append(r4).toString());
        String r5 = this.TAG;
        StringBuilder r6 = new StringBuilder("parseNetworkResponse logid=");
        if (r7 == null) goto L13;
        Map<String, String> r8 = r7.headers;
        if (r8 == null) goto L13;
        r2 = r8.get("X-Tt-Logid");
    L13:
        OLog.i(r5, r6.append(r2).toString());
        Response<JSONObject> r9 = super.parseNetworkResponse(r7);
        Intrinsics.checkNotNullExpressionValue(r9, "parseNetworkResponse(...)");
        return r9;
    L7:
        r4 = null;
        goto L8
    }
}
