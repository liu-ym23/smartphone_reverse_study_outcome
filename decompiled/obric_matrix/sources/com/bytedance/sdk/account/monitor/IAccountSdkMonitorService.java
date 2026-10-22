package com.bytedance.sdk.account.monitor;

import androidx.core.app.NotificationCompat;
import com.bytedance.news.common.service.manager.IService;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u00020\u0002J%\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/sdk/account/monitor/IAccountSdkMonitorService;", "Lcom/bytedance/news/common/service/manager/IService;", "Lcom/bytedance/sdk/account/monitor/e/a;", "", NotificationCompat.CATEGORY_EVENT, "", "", "getMonitorCommonParams", "(Ljava/lang/String;)Ljava/util/Map;", "getOverrideCommonParams", "", "isDebug", "()Z", "account-sdk-monitor_release"}, k = 1, mv = {1, 1, 15})
public interface IAccountSdkMonitorService extends IService, com.bytedance.sdk.account.monitor.e.a {
    Map<String, Object> getMonitorCommonParams(String r1);

    Map<String, Object> getOverrideCommonParams(String r1);

    boolean isDebug();

    /* synthetic */ boolean onEvent(String r1, JSONObject r2);
}
