package com.obric.matrix.ostracker_api;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.bytedance.news.common.service.manager.IService;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\n\u0010\t\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\n\u001a\u00020\u0003H&J\u001a\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&J6\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H&J\u0012\u0010\u0017\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0014H&¨\u0006\u001a"}, d2 = {"Lcom/obric/matrix/ostracker_api/IOSTracker;", "Lcom/bytedance/news/common/service/manager/IService;", "addTeaTrackerListener", "", "listener", "Lcom/obric/matrix/ostracker_api/IOSTrackerListener;", "getDeviceId", "", "getInstallId", "getUDID", "init", "onEvent", NotificationCompat.CATEGORY_EVENT, "params", "Lorg/json/JSONObject;", "putCommonParams", "context", "Landroid/content/Context;", "", "isApi", "", "level", "", "removeTeaTrackerListener", "setBoe", "isBoe", "ostracker_api_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IOSTracker extends IService {
    void addTeaTrackerListener(a r1);

    String getDeviceId();

    String getInstallId();

    String getUDID();

    void init();

    void onEvent(String r1, JSONObject r2);

    void putCommonParams(Context r1, Map<String, String> r2, boolean r3, int r4);

    void removeTeaTrackerListener(a r1);

    void setBoe(boolean r1);
}
