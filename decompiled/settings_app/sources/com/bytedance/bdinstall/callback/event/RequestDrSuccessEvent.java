package com.bytedance.bdinstall.callback.event;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class RequestDrSuccessEvent {
    private final JSONObject response;

    public RequestDrSuccessEvent(JSONObject r1) {
        this.response = r1;
    }

    public JSONObject getResponse() {
        return this.response;
    }
}
