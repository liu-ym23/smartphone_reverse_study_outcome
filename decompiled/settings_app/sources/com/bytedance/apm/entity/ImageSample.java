package com.bytedance.apm.entity;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ImageSample {
    public int count;
    public long last_duration;
    public JSONObject last_extra;
    public String last_ip;
    public long last_timestamp;
    public String last_uri;
    public int status;

    public ImageSample(String r1, int r2, String r3, long r4, long r6, JSONObject r8) {
        this.last_ip = r3;
        this.last_uri = r1;
        this.status = r2;
        this.last_timestamp = r4;
        this.last_duration = r6;
        this.last_extra = r8;
        this.count = 1;
    }
}
