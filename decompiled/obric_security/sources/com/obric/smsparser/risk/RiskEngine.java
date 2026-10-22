package com.obric.smsparser.risk;

import android.content.Context;
import com.bytedanceos.securitycenter.appBgBatteryControl.AppBgBatteryControlDataHelper;
import kotlin.Metadata;
import obric.util.Utils;

/* JADX INFO: compiled from: RiskEngine.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0007H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0012"}, d2 = {"Lcom/obric/smsparser/risk/RiskEngine;", "", "name", "", "getName", "()Ljava/lang/String;", "init", "", "context", "Landroid/content/Context;", Utils.KEY_OA_ID, "isReady", "", "query", "Lcom/obric/smsparser/risk/SmsRiskResult;", AppBgBatteryControlDataHelper.ItemColumns.PARAM, "Lcom/obric/smsparser/risk/SmsRiskQueryParam;", "release", "smsrisk-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface RiskEngine {
    String getName();

    void init(Context r1, String r2);

    boolean isReady();

    SmsRiskResult query(SmsRiskQueryParam r1);

    void release();
}
