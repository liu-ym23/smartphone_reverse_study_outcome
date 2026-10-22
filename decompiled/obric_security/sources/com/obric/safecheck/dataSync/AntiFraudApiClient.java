package com.obric.safecheck.dataSync;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.Header;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Streaming;
import com.google.gson.Gson;
import com.obric.matrix.platform.sdk.ones.internal.monitor.EventConstants;
import com.obric.matrix.sdk.network.HttpRequestManager;
import com.obric.olog.OLog;
import com.obric.safecheck.dataSync.httpclient.OkHttpUtils;
import com.obric.safecheck.dataSync.model.AntiFraudModel;
import com.obric.safecheck.parser.DirectoryParser;
import com.obric.safecheck.util.GetDateAfter6MonthsKt;
import com.obric.securitycenter.api.TrackUtils;
import io.reactivex.Observable;
import java.io.IOException;
import java.util.HashMap;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* JADX INFO: loaded from: classes4.dex */
public class AntiFraudApiClient {
    private static final String API_PATH = "/cloud/os/api/anti_fraud/get";
    private static final String BASE_URL = "https://os.obriccloud.com";
    public static HashMap<String, Object> reportParams;
    private final OkHttpClient client;
    private final Gson gson;
    public boolean taskDoing;

    public interface AntiFraudCallback {
        void onFailure(int errorCode, String errorMsg);

        void onSuccess(AntiFraudModel.GetAntiFraudDataByDateTimeResp response);
    }

    private interface GetAntiFraudDataApi {
        @POST("https://os.obriccloud.com/cloud/os/api/anti_fraud/get")
        @Streaming
        Observable<AntiFraudModel.GetAntiFraudDataByDateTimeResp> getAntiFraudData(@Header("sign") String token, @Body AntiFraudModel.GetAntiFraudDataByDateTimeReq requestBody);
    }

    private static class SingletonHolder {
        private static final AntiFraudApiClient INSTANCE = null;

        /* JADX INFO: renamed from: -$$Nest$sfgetINSTANCE, reason: not valid java name */
        static /* bridge */ /* synthetic */ AntiFraudApiClient m597$$Nest$sfgetINSTANCE() {
            return INSTANCE;
        }

        private SingletonHolder() {
        }

        static {
            INSTANCE = new AntiFraudApiClient(null);
        }
    }

    /* synthetic */ AntiFraudApiClient(AntiFraudApiClientIA r1) {
        this();
    }

    static {
        reportParams = new HashMap();
    }

    public static AntiFraudApiClient getInstance() {
        return SingletonHolder.m597$$Nest$sfgetINSTANCE();
    }

    private AntiFraudApiClient() {
        this.taskDoing = false;
        this.client = OkHttpUtils.getInstance();
        this.gson = OkHttpUtils.getGsonInstance();
    }

    public void getAntiFraudDataAsync(String from) {
        if (this.taskDoing == false) goto L6;
        HashMap r2 = new HashMap();
        r2.put("result", "failed");
        r2.put(EventConstants.EVENT_KEY_ERROR_MESSAGE, "taskDoing");
        TrackUtils.INSTANCE.trackEvent("antiFraud_data_sync_task", r2);
        return;
    L6:
        reportParams.clear();
        reportParams.put("from", from);
        this.taskDoing = true;
        String r3 = DirectoryParser.INSTANCE.getEndData();
        OLog.d("_AntiFraud", "getAntiFraudDataByDateTimeAsync end:" + r3);
        if (r3.equals(DirectoryParser.DEFAULT_END_DATE) == false) goto L9;
        r3 = GetDateAfter6MonthsKt.getDateBeforeXMonths(12);
    L9:
        getAntiFraudDataByDateTimeAsync(r3);
    }

    public void getAntiFraudDataByDateTimeAsync(final String dateTime) {
        reportParams.put("start_data", dateTime);
        final DatabaseConsumer[] r0 = {null};
        getAntiFraudDataByDateTimeAsync(dateTime, new AnonymousClass1(this, dateTime, r0));
    }

    public void getAntiFraudDataByDateTimeAsync(final String dateTime, final AntiFraudCallback callback) {
        if (callback == null) goto L16;
        if (dateTime != null) goto L5;
    L13:
        callback.onFailure(1001, "日期参数不能为空");
        return;
    L5:
        if (dateTime.trim().isEmpty() == true) goto L13;
        if (dateTime.matches("\\d{4}-\\d{2}-\\d{2}") == true) goto L11;
        callback.onFailure(1002, "日期格式错误，正确格式：yyyy-MM-dd");
        return;
    L11:
        HttpRequestManager.INSTANCE.request(GetAntiFraudDataApi.class, new AntiFraudApiClient$$ExternalSyntheticLambda0(dateTime), new AntiFraudApiClient$$ExternalSyntheticLambda1(callback), new AntiFraudApiClient$$ExternalSyntheticLambda2(callback), HttpRequestManager.INSTANCE.getDEFAULT_SUBSCRIBE_SCHEDULER(), HttpRequestManager.INSTANCE.getDEFAULT_OBSERVE_SCHEDULER());
        return;
    L16:
        throw new IllegalArgumentException("Callback不能为null");
    }

    static /* synthetic */ Observable lambda$getAntiFraudDataByDateTimeAsync$0(String r2, GetAntiFraudDataApi r3) throws Exception {
        AntiFraudModel.GetAntiFraudDataByDateTimeReq r0 = new AntiFraudModel.GetAntiFraudDataByDateTimeReq();
        r0.dateTime = r2;
        return r3.getAntiFraudData(SignGenerator.generateFinalSign(r2, true), r0);
    }

    static /* synthetic */ void lambda$getAntiFraudDataByDateTimeAsync$1(AntiFraudCallback r4, AntiFraudModel.GetAntiFraudDataByDateTimeResp r5) {
        if (r5 != null) goto L4;
    L6:
        if (r5 == null) goto L8;
        long r0 = r5.code;
    L9:
        int r1 = (int) r0;
        if (r5 == null) goto L12;
        String r6 = r5.message;
    L13:
        r4.onFailure(r1, r6);
        return;
    L12:
        r6 = "未知错误";
        goto L13
    L8:
        r0 = -1;
        goto L9
    L4:
        if (r5.code != 0) goto L6;
        r4.onSuccess(r5);
    }

    static /* synthetic */ void lambda$getAntiFraudDataByDateTimeAsync$2(AntiFraudCallback r2, Throwable r3) {
        r2.onFailure(1004, "网络或解析异常：" + r3.getMessage());
    }

    public AntiFraudModel.GetAntiFraudDataByDateTimeResp getAntiFraudDataByDateTime(String dateTime) throws IOException {
        Response r6 = this.client.newCall(buildRequest("https://os.obriccloud.com/cloud/os/api/anti_fraud/get", buildJsonBody(dateTime), SignGenerator.generateFinalSign(dateTime, true))).execute();
    L11:
        th = move-exception;
        if (r6 != null) goto L19;
    L17:
        throw th;
    L19:
        r6.close();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        th.addSuppressed(th);
        goto L17
    L4:
        if (r6.isSuccessful() == false) goto L10;
        AntiFraudModel.GetAntiFraudDataByDateTimeResp r5 = (AntiFraudModel.GetAntiFraudDataByDateTimeResp) this.gson.fromJson(r6.body().string(), AntiFraudModel.GetAntiFraudDataByDateTimeResp.class);     // Catch: Throwable -> L11
        if (r6 == null) goto L8;
        r6.close();
    L8:
        return r5;
    L10:
        throw new IOException(String.format("请求失败：状态码=%d, 消息=%s", new Object[]{Integer.valueOf(r6.code()), r6.message()}));     // Catch: Throwable -> L11
    }

    private RequestBody buildJsonBody(String dateTime) {
        if (dateTime == null) goto L6;
        AntiFraudModel.GetAntiFraudDataByDateTimeReq r0 = new AntiFraudModel.GetAntiFraudDataByDateTimeReq();
        r0.dateTime = dateTime;
        String r1 = this.gson.toJson(r0);
        return RequestBody.create(MediaType.parse("application/json; charset=utf-8"), r1);
    L6:
        throw new IllegalArgumentException("请求参数不能为null");
    }

    public static Request buildRequest(String url, RequestBody requestBody, String sign) {
        return new Request.Builder().url(url).post(requestBody).addHeader("Content-Type", "application/json").addHeader("sign", sign).build();
    }
}
