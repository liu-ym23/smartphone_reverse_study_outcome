package com.obric.safecheck.dataSync.miitAntiFraud;

import com.obric.olog.Constants;
import com.obric.olog.OLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.json.JSONObject;

/* JADX INFO: compiled from: PushTokenOkHttpReporter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/safecheck/dataSync/miitAntiFraud/PushTokenOkHttpReporter;", "", "()V", "API_PATH", "", "BASE_URL", "PUSH_TOKEN_KEY", "SUCCESS_CODE", "", "TAG", "jsonMediaType", "Lokhttp3/MediaType;", "okHttpClient", "Lokhttp3/OkHttpClient;", Constants.REPORT_FIELD, "", "deviceToken", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class PushTokenOkHttpReporter {
    private static final String API_PATH = "/cloud/os/api/anti_fraud/push_token";
    private static final String BASE_URL = "https://os.oceancloudapi.com";
    public static final PushTokenOkHttpReporter INSTANCE = null;
    private static final String PUSH_TOKEN_KEY = "push_token";
    private static final int SUCCESS_CODE = 0;
    private static final String TAG = "PushTokenOkHttpReporter";
    private static final MediaType jsonMediaType = null;
    private static final OkHttpClient okHttpClient = null;

    static {
        INSTANCE = new PushTokenOkHttpReporter();
        jsonMediaType = MediaType.parse("application/json; charset=utf-8");
        okHttpClient = new OkHttpClient();
    }

    private PushTokenOkHttpReporter() {
    }

    @JvmStatic
    public static final void report(String r4) {
        Intrinsics.checkNotNullParameter(r4, "deviceToken");
        if (StringsKt.isBlank(r4) == false) goto L6;
        OLog.w(TAG, "skip report push token, token is blank");
        return;
    L6:
        String r5 = new JSONObject().put(PUSH_TOKEN_KEY, r4).toString();
        Intrinsics.checkNotNullExpressionValue(r5, "JSONObject()\n           …)\n            .toString()");
        RequestBody r6 = RequestBody.create(jsonMediaType, r5);
        GxbAttestationHeaders r0 = GxbAttestationHeaders.INSTANCE;
        Request.Builder r7 = new Request.Builder().url("https://os.oceancloudapi.com/cloud/os/api/anti_fraud/push_token").post(r6).addHeader("Content-Type", "application/json");
        Intrinsics.checkNotNullExpressionValue(r7, "Request.Builder()\n      …ype\", \"application/json\")");
        Request r8 = r0.addTo(r7, GxbAttestationHeaders.INSTANCE.getPemCertChain(TAG)).build();
        okHttpClient.newCall(r8).enqueue(new AnonymousClass1());
    }
}
