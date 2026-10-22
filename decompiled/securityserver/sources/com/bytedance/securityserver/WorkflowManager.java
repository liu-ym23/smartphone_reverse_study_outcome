package com.bytedance.securityserver;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes.dex */
public class WorkflowManager {
    public static final MediaType c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static WorkflowManager f35d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OkHttpClient f36a;
    public final Handler b;

    public interface ApiCallback {
        void onError(String r1);

        void onSuccess(String r1);
    }

    static {
        c = MediaType.get("application/json; charset=utf-8");
    }

    public WorkflowManager() {
        OkHttpClient.Builder r0 = new OkHttpClient.Builder();
        TimeUnit r1 = TimeUnit.SECONDS;
        this.f36a = r0.connectTimeout(10, r1).readTimeout(30, r1).build();
        this.b = new Handler(Looper.getMainLooper());
    }

    public final void a(HashMap r10, final ApiCallback r11) {
        StringBuilder r0 = new StringBuilder("{\"workflow_id\": \"7532716453222809626\",\"parameters\": ");
        StringBuilder r1 = new StringBuilder("{");
        Iterator r12 = r10.entrySet().iterator();
        boolean r3 = true;
    L4:
        if (r12.hasNext() == false) goto L27;
        Map.Entry r4 = (Map.Entry) r12.next();
        if (r3 == true) goto L8;
        r1.append(",");
    L8:
        r1.append("\"");
        r1.append((String) r4.getKey());
        r1.append("\":");
        Object r5 = r4.getValue();
        if ((r5 instanceof String) == false) goto L12;
        r1.append("\"");
        r1.append(r5);
        r1.append("\"");
    L26:
        r3 = false;
        goto L4
    L12:
        if ((r5 instanceof List) == false) goto L25;
        r1.append("[");
        Iterator r6 = ((List) r5).iterator();
        boolean r7 = true;
    L15:
        if (r6.hasNext() == false) goto L24;
        Object r8 = r6.next();
        if (r7 == true) goto L20;
        r1.append(",");
    L20:
        if ((r8 instanceof String) == false) goto L22;
        r1.append("\"");
        r1.append(r8);
        r1.append("\"");
    L23:
        r7 = false;
        goto L15
    L22:
        r1.append(r8);
        goto L23
    L24:
        r1.append("]");
        goto L26
    L25:
        r1.append(r5);
        goto L26
    L27:
        r1.append("}");
        r0.append(r1.toString());
        r0.append("}");
        this.f36a.newCall(new Request.Builder().url("https://api.coze.cn/v1/workflow/stream_run").post(RequestBody.create(r0.toString(), c)).addHeader("Authorization", "Bearer pat_zU3qRwXigldBJgGsriMNlwXHHdPo7Sl5ZOLHsIaKehSqWV3dmw1oJftyAJ4SHZId").build()).enqueue(new AnonymousClass1(this, r11));
    }
}
