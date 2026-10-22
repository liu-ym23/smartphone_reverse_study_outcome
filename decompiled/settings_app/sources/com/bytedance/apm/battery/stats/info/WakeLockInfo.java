package com.bytedance.apm.battery.stats.info;

import com.android.launcher3.icons.cache.BaseIconCache;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class WakeLockInfo extends BaseHookInfo {
    public int flags;
    public String tag;

    public WakeLockInfo() {
    }

    public String toString() {
        return "WakeLockInfo{flags=" + this.flags + ", tag=" + this.tag + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", threadName=" + this.threadName + ", threadStack=" + getStackDetails() + '}';
    }

    public JSONObject toJson() {
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L4
        r0.put(BaseIconCache.IconDB.COLUMN_FLAGS, this.flags);     // Catch: Throwable -> L4
        r0.put("tag", this.tag);     // Catch: Throwable -> L4
        r0.put("start_time", this.startTime);     // Catch: Throwable -> L4
        r0.put("end_time", this.endTime);     // Catch: Throwable -> L4
        r0.put("thread_name", this.threadName);     // Catch: Throwable -> L4
        r0.put("thread_stack", getStackDetails());     // Catch: Throwable -> L4
        return r0;
    L4:
        return null;
    }
}
