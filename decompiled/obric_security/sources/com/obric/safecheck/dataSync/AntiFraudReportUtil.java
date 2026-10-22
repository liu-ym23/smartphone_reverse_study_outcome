package com.obric.safecheck.dataSync;

import android.content.Context;
import com.google.gson.Gson;
import com.obric.safecheck.dataSync.httpclient.OkHttpUtils;
import com.obric.safecheck.dataSync.model.AntiFraudHitCount;
import com.obric.safecheck.dataSync.model.ReportAntiFraudHitStatisticsReq;
import com.obric.safecheck.dataSync.model.ReportAntiFraudHitStatisticsResp;
import com.obric.safecheck.service.BlacklistRecordSP;
import com.obric.securitycenter.api.MatrixUtil;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes4.dex */
public class AntiFraudReportUtil {
    private static final String API_PATH = "/cloud/os/api/anti_fraud/report";
    private static final String BASE_URL = "https://os.obriccloud.com";
    private final Gson GSON;
    private final MediaType JSON_MEDIA_TYPE;
    private final OkHttpClient OK_HTTP_CLIENT;
    private BlacklistRecordSP blacklistRecordSP;

    public interface ReportCallback {
        void onFailure(Throwable e);

        void onSuccess(ReportAntiFraudHitStatisticsResp response);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetGSON, reason: not valid java name */
    static /* bridge */ /* synthetic */ Gson m598$$Nest$fgetGSON(AntiFraudReportUtil r0) {
        return r0.GSON;
    }

    public AntiFraudReportUtil() {
        this.JSON_MEDIA_TYPE = MediaType.parse("application/json; charset=utf-8");
        this.OK_HTTP_CLIENT = OkHttpUtils.getInstance();
        this.GSON = OkHttpUtils.getGsonInstance();
        this.blacklistRecordSP = null;
    }

    public void report(Context context, String key) {
        if (this.blacklistRecordSP != null) goto L5;
        this.blacklistRecordSP = new BlacklistRecordSP(context);
    L5:
        BlacklistRecordSP.DailyHitCounts r3 = this.blacklistRecordSP.recordHit(key);
        AntiFraudHitCount r4 = new AntiFraudHitCount();
        r4.setPhoneNumberCount(r3.getPhoneCount());
        r4.setUrlCount(r3.getUrlCount());
        r4.setApkCount(r3.getApkCount());
        reportHitStatisticsAsync(r4, this.blacklistRecordSP.getCurrentDateString(), MatrixUtil.INSTANCE.getDeviceId(), new AnonymousClass1(this));
    }

    public void reportHitStatisticsAsync(AntiFraudHitCount hitStatistics, String dateTime, String did, final ReportCallback callback) {
        ReportAntiFraudHitStatisticsReq r0 = new ReportAntiFraudHitStatisticsReq();
        r0.setHitStatistics(hitStatistics);
        r0.setDateTime(dateTime);
        r0.setDid(did);
        String r2 = this.GSON.toJson(r0);
        Request r3 = AntiFraudApiClient.buildRequest("https://os.obriccloud.com/cloud/os/api/anti_fraud/report", RequestBody.create(this.JSON_MEDIA_TYPE, r2), SignGenerator.generateFinalSign(dateTime, true));
        this.OK_HTTP_CLIENT.newCall(r3).enqueue(new AnonymousClass2(this, callback));
    }
}
