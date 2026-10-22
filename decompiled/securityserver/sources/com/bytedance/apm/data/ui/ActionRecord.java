package com.bytedance.apm.data.ui;

import com.bytedance.apm.structure.LimitQueue;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ActionRecord {
    private static volatile ActionRecord singleton;
    private LimitQueue<JSONObject> mActionQueue;

    private ActionRecord() {
        this.mActionQueue = new LimitQueue(20);
    }

    public static ActionRecord getInstance() {
        if (singleton != null) goto L16;
        monitor-enter(ActionRecord.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (singleton != null) goto L11;
        singleton = new ActionRecord();     // Catch: Throwable -> L9
    L11:
        monitor-exit(ActionRecord.class);     // Catch: Throwable -> L9
    L16:
        return singleton;
    }

    public void addRecord(JSONObject r1) {
        this.mActionQueue.enqueue(r1);
    }

    public List<JSONObject> getRecords() {
        return this.mActionQueue.toList();
    }
}
