package com.bytedance.ttnet.priority;

import com.bytedance.retrofit2.client.Request;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class RequestPriorityController {
    private Set<String> mHighList;
    private Set<String> mLowList;
    private Set<String> mNormalList;

    public RequestPriorityController() {
        this.mHighList = new CopyOnWriteArraySet();
        this.mNormalList = new CopyOnWriteArraySet();
        this.mLowList = new CopyOnWriteArraySet();
    }

    public void initWithTncConfig(JSONObject r2) {
        this.mHighList = TTHttpCallPriorityControl.getSetFromJSONArray(r2, "high");
        this.mNormalList = TTHttpCallPriorityControl.getSetFromJSONArray(r2, "normal");
        this.mLowList = TTHttpCallPriorityControl.getSetFromJSONArray(r2, "low");
    }

    public void initWithLocal(Set<String> r2, Set<String> r3, Set<String> r4) {
        this.mHighList.clear();
        this.mNormalList.clear();
        this.mLowList.clear();
        this.mHighList.addAll(r2);
        this.mNormalList.addAll(r3);
        this.mLowList.addAll(r4);
    }

    public Request setPriorityToRequest(Request r10) {
        Request.Builder r6 = r10.newBuilder();
        if (setPriorityToRequestInternal(this.mHighList, r10.getPath(), r6, 3, 4) == false) goto L7;
        return r6.build();
    L7:
        if (setPriorityToRequestInternal(this.mLowList, r10.getPath(), r6, -1, 1) == true) goto L9;
        int r0 = r10.getPriorityLevel();
        if (r0 < 3) goto L14;
        r0 = 1;
    L14:
        if (r0 > (-1)) goto L16;
        r0 = 0;
    L16:
        int r4 = r0;
        int r1 = r10.getRequestPriorityLevel();
        if (r1 < 4) goto L19;
        r1 = 3;
    L19:
        if (r1 < 1) goto L22;
        r1 = 2;
    L22:
        if (setPriorityToRequestInternal(this.mNormalList, r10.getPath(), r6, r4, r1) == false) goto L26;
        return r6.build();
    L26:
        return r6.priorityLevel(1).requestPriorityLevel(3).build();
    L9:
        return r6.build();
    }

    private boolean setPriorityToRequestInternal(Set<String> r1, String r2, Request.Builder r3, int r4, int r5) {
        if (TTHttpCallPriorityControl.isMatch(r1, r2) == false) goto L6;
        r3.priorityLevel(r4);
        r3.requestPriorityLevel(r5);
        return true;
    L6:
        return false;
    }
}
