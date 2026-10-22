package com.bytedance.apm6.consumer.slardar.send.downgrade;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.apm6.util.log.Logger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DowngradeInfo {
    public static final String FIELD_DURATION = "duration";
    public static final String FIELD_EXPIRE_TIME = "expire_time";
    public long expireTime;
    public Map<LogType, SubInfo> mEventMap;

    public static final enum LogType extends Enum<LogType> {
        private static final /* synthetic */ LogType[] $VALUES = null;
        public static final LogType OTHER_LOG_TYPE = null;
        public static final LogType SERVICE_MONITOR = null;
        public final String logType;

        static {
            LogType r0 = new LogType("OTHER_LOG_TYPE", 0, "other");
            OTHER_LOG_TYPE = r0;
            LogType r1 = new LogType("SERVICE_MONITOR", 1, "service_monitor");
            SERVICE_MONITOR = r1;
            $VALUES = new LogType[]{r0, r1};
        }

        private LogType(String r1, int r2, String r3) {
            super(r1, r2);
            this.logType = r3;
        }

        public static LogType valueOf(String r1) {
            return (LogType) Enum.valueOf(LogType.class, r1);
        }

        public static LogType[] values() {
            return (LogType[]) $VALUES.clone();
        }
    }

    public static class SubInfo {
        public static final String FIELD_DEFAULT_RATE = "default";
        public Map<String, JSONObject> aidMap;
        public boolean defaultRate;

        public SubInfo() {
            this.aidMap = new HashMap();
        }

        public static SubInfo parse(JSONObject r6) {
            SubInfo r0 = new SubInfo();
            boolean r2 = true;
            if (r6.optInt("default", 1) == 1) goto L6;
            r2 = false;
        L6:
            r0.defaultRate = r2;
            Iterator<String> r3 = r6.keys();
        L8:
            if (r3.hasNext() == false) goto L14;
            String r4 = r3.next();
            if (TextUtils.equals(r4, "default") == true) goto L8;
            JSONObject r5 = r6.optJSONObject(r4);
            if (r5 == null) goto L8;
            r0.aidMap.put(r4, r5);
            goto L8
        L14:
            return r0;
        }

        @Nullable
        public JSONObject toJson() {
            JSONObject r0 = new JSONObject();     // Catch: JSONException -> L8
            r0.put("default", this.defaultRate ? 1 : 0);     // Catch: JSONException -> L8
            Iterator<Map.Entry<String, JSONObject>> r3 = this.aidMap.entrySet().iterator();     // Catch: JSONException -> L8
        L4:
            if (r3.hasNext() == false) goto L7;
            Map.Entry<String, JSONObject> r1 = r3.next();     // Catch: JSONException -> L8
            r0.put(r1.getKey(), r1.getValue());     // Catch: JSONException -> L8
            goto L4
        L7:
            return r0;
        L8:
            return null;
        }
    }

    public DowngradeInfo() {
        this.mEventMap = new HashMap();
    }

    public static DowngradeInfo parse(JSONObject r8) {
        if (ApmBaseContext.isDebugMode() == false) goto L5;
        Logger.i(Constants.TAG, "DowngradeRule=" + r8.toString());
    L5:
        DowngradeInfo r0 = new DowngradeInfo();
        long r4 = r8.optLong("duration", 0);
        long r6 = r8.optLong(FIELD_EXPIRE_TIME, 0);
        if (r6 <= 0) goto L8;
        r0.expireTime = r6;
    L9:
        LogType r1 = LogType.OTHER_LOG_TYPE;
        JSONObject r2 = r8.optJSONObject(r1.logType);
        if (r2 == null) goto L12;
        r0.mEventMap.put(r1, SubInfo.parse(r2));
    L12:
        LogType r3 = LogType.SERVICE_MONITOR;
        JSONObject r9 = r8.optJSONObject(r3.logType);
        if (r9 == null) goto L15;
        r0.mEventMap.put(r3, SubInfo.parse(r9));
    L15:
        return r0;
    L8:
        r0.expireTime = (r4 * 1000) + System.currentTimeMillis();
        goto L9
    }

    @Nullable
    public JSONObject toJson() {
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L8
        r0.put(FIELD_EXPIRE_TIME, this.expireTime);     // Catch: JSONException -> L8
        Iterator<Map.Entry<LogType, SubInfo>> r4 = this.mEventMap.entrySet().iterator();     // Catch: JSONException -> L8
    L4:
        if (r4.hasNext() == false) goto L7;
        Map.Entry<LogType, SubInfo> r1 = r4.next();     // Catch: JSONException -> L8
        r0.put(r1.getKey().logType, r1.getValue().toJson());     // Catch: JSONException -> L8
        goto L4
    L7:
        return r0;
    L8:
        return null;
    }
}
