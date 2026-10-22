package com.bytedance.news.common.settings.g;

import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f5311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private JSONObject f5312b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f5313c;

    public c(JSONObject r3, JSONObject r4) {
        this(r3, r4, UUID.randomUUID().toString(), true);
    }

    public c(JSONObject r1, JSONObject r2, String r3, boolean r4) {
        this.f5311a = r1;
        this.f5312b = r2;
        this.f5313c = r3;
    }

    public JSONObject a() {
        return this.f5311a;
    }

    public String b() {
        return this.f5313c;
    }

    public JSONObject c() {
        return this.f5312b;
    }
}
