package com.bytedance.mpaas.monitor;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.news.common.service.manager.IService;
import java.util.List;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001JG\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bH&¢\u0006\u0004\b\f\u0010\rJ;\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/mpaas/monitor/ISDKMonitorService;", "Lcom/bytedance/news/common/service/manager/IService;", "Landroid/content/Context;", "context", "", WsConstants.KEY_APP_ID, "Lorg/json/JSONObject;", "headerInfo", "", "configUrls", "reportUrls", "Lkotlin/f0;", "init", "(Landroid/content/Context;Ljava/lang/String;Lorg/json/JSONObject;Ljava/util/List;Ljava/util/List;)V", "serviceName", "", "status", TypedValues.TransitionType.S_DURATION, "logExtr", "monitorStatusAndDuration", "(Ljava/lang/String;Ljava/lang/String;ILorg/json/JSONObject;Lorg/json/JSONObject;)V", "launch_release"}, k = 1, mv = {1, 1, 15})
public interface ISDKMonitorService extends IService {
    void init(Context r1, String r2, JSONObject r3, List<String> r4, List<String> r5);

    void monitorStatusAndDuration(String r1, String r2, int r3, JSONObject r4, JSONObject r5);
}
