package com.bytedance.crash.entity;

import androidx.core.app.NotificationCompat;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ScheduleMsgItem {
    public static final int SCHEDULE_TYPE_IDLE = 0;
    public static final int SCHEDULE_TYPE_LAST_LONG_MSG = 4;
    public static final int SCHEDULE_TYPE_LONG_IDLE = 1;
    public static final int SCHEDULE_TYPE_LONG_MSG = 8;
    public static final int SCHEDULE_TYPE_MSG = 2;
    public static final int SCHEDULE_TYPE_MSGS = 9;
    public static final int SCHEDULE_TYPE_MSGS_IDLE = 7;
    public static final int SCHEDULE_TYPE_MSGS_LONG_IDLE = 5;
    public static final int SCHEDULE_TYPE_MSG_IDLE = 3;
    public static final int SCHEDULE_TYPE_MSG_LONG_IDLE = 6;
    public String mBlockStack;
    public long mDuration;
    public long mDurationCpuTime;
    public long mDurationTick;
    public boolean mIncluseIdle;
    public int mMsgs;
    public String mScheduleMsg;
    public String mSeriousBlockStack;
    public int mType;
    public String uuid;

    public ScheduleMsgItem() {
    }

    public boolean isIdle() {
        int r2 = this.mType;
        if (r2 == 0) goto L16;
        if (r2 != 1) goto L6;
        return true;
    L6:
        if (r2 != 3) goto L8;
        return true;
    L8:
        if (r2 != 6) goto L10;
        return true;
    L10:
        if (r2 != 7) goto L12;
        return true;
    L12:
        if (r2 == 5) goto L21;
        return false;
    L21:
        return true;
    L16:
        return true;
    }

    public JSONObject toJson() {
        JSONObject r0 = new JSONObject();
        r0.put(NotificationCompat.CATEGORY_MESSAGE, this.mScheduleMsg);     // Catch: JSONException -> L6
        r0.put("cpuDuration", this.mDurationCpuTime);     // Catch: JSONException -> L6
        r0.put("duration", this.mDuration);     // Catch: JSONException -> L6
        r0.put("tick", this.mDurationTick);     // Catch: JSONException -> L6
        r0.put("type", this.mType);     // Catch: JSONException -> L6
        r0.put("count", this.mMsgs);     // Catch: JSONException -> L6
        String r1 = this.mBlockStack;     // Catch: JSONException -> L6
        if (r1 == null) goto L8;
        r0.put("block_stack", r1);     // Catch: JSONException -> L6
        r0.put("block_uuid", this.uuid);     // Catch: JSONException -> L6
    L8:
        String r2 = this.mSeriousBlockStack;     // Catch: JSONException -> L6
        if (r2 == null) goto L13;
        r0.put("sblock_stack", r2);     // Catch: JSONException -> L6
        r0.put("sblock_uuid", this.uuid);     // Catch: JSONException -> L6
    L13:
        return r0;
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L13
    }

    public String toString() {
        int r0 = this.mType;
        if (r0 != 0) goto L7;
        return "[[[ IDLE  ]]] cost " + this.mDurationTick + " tick , mDuration：" + this.mDuration + ",cpuTime:" + this.mDurationCpuTime;
    L7:
        if (r0 != 1) goto L11;
        return "[[[ Long IDLE  ]]] cost " + this.mDurationTick + " tick , mDuration：" + this.mDuration + ",cpuTime:" + this.mDurationCpuTime;
    L11:
        if (r0 != 2) goto L15;
        return "[[[  1 msg  ]]] cost " + this.mDurationTick + " tick , mDuration：" + this.mDuration + ",cpuTime:" + this.mDurationCpuTime + ", msg:" + this.mScheduleMsg;
    L15:
        if (r0 != 3) goto L19;
        return "[[[ 1 msg + IDLE  ]]] cost " + this.mDurationTick + " tick , mDuration：" + this.mDuration + ",cpuTime:" + this.mDurationCpuTime;
    L19:
        if (r0 != 4) goto L23;
        return "[[[ " + (this.mMsgs - 1) + " msgs  ]]] cost less than 1 tick, [[[  last msg ]]] cost more than " + (this.mDurationTick - 1) + "tick ,, mDuration：" + this.mDuration + "cpuTime:" + this.mDurationCpuTime + " msg:" + this.mScheduleMsg;
    L23:
        if (r0 != 5) goto L27;
        return "[[[ " + this.mMsgs + " msgs ]]] cost less than 1 tick but [[[  IDLE ]]] cost more than" + (this.mDurationTick - 1) + " ticks, , mDuration：" + this.mDuration + "cpuTime:" + this.mDurationCpuTime;
    L27:
        if (r0 != 6) goto L31;
        return "[[[  1 msg  ]]] cost less than 1 tick , but [[[  IDLE ]]] cost more than" + (this.mDurationTick - 1) + ", , mDuration：" + this.mDuration + "cpuTime:" + this.mDurationCpuTime;
    L31:
        if (r0 != 7) goto L35;
        return "[[[ " + this.mMsgs + " msgs + IDLE  ]]] cost 1 tick , mDuration：" + this.mDuration + " cost cpuTime:" + this.mDurationCpuTime;
    L35:
        if (r0 != 8) goto L39;
        return "[[[ 1 msgs ]]] cost " + this.mDurationTick + " ticks , mDuration：" + this.mDuration + " cost cpuTime:" + this.mDurationCpuTime + " msg:" + this.mScheduleMsg;
    L39:
        if (r0 != 9) goto L43;
        return "[[[ " + this.mMsgs + " msgs ]]] cost 1 tick , mDuration：" + this.mDuration + " cost cpuTime:" + this.mDurationCpuTime;
    L43:
        return "=========   UNKNOW =========  Type:" + this.mType + " cost ticks " + this.mDurationTick + " msgs:" + this.mMsgs;
    }
}
