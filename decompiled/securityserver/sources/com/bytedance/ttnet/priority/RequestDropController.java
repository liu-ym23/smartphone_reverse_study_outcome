package com.bytedance.ttnet.priority;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.exception.DroppedByThrottleControlException;
import com.bytedance.retrofit2.client.Request;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class RequestDropController {
    private final Set<String> mDropList;

    public RequestDropController() {
        this.mDropList = new CopyOnWriteArraySet();
    }

    public void initWithLocal(Set<String> r2) {
        this.mDropList.clear();
        this.mDropList.addAll(r2);
    }

    public void initWithTncConfig(JSONObject r4) {
        this.mDropList.clear();
        JSONArray r5 = r4.optJSONArray("dl");
        if (r5 == null) goto L11;
        int r0 = 0;
    L6:
        if (r0 >= r5.length()) goto L15;
        String r1 = r5.optString(r0);
        if (TextUtils.isEmpty(r1) == true) goto L10;
        this.mDropList.add(r1);
    L10:
        r0 = r0 + 1;
        goto L6
    L15:
        return;
    }

    public boolean isValid() {
        if (this.mDropList.size() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void raiseExceptionIfDrop(Request r2) {
        if (TTHttpCallPriorityControl.isMatch(this.mDropList, r2.getPath()) == true) goto L5;
        return;
    L5:
        if (Logger.debug() == false) goto L8;
        Logger.d("RequestDropController", "check drop and match " + r2.getPath());
    L8:
        throw new DroppedByThrottleControlException();
    }
}
