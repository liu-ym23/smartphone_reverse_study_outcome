package com.bytedance.ttnet;

import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.BaseRequestContext;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.retrofit2.SsHttpCall;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class TNCRequestFlagHandler implements SsHttpCall.IRequestFlagHandler {
    private static final String TAG = "TNCRequestFlagHandler";
    private static volatile TNCRequestFlagHandler sInstance;
    private final List<SingleRequestFlagConfig> mRequestFlagConfigs;
    private final AtomicBoolean mRequestFlagCtlEnabled;

    public static final class SingleRequestFlagConfig {
        final List<String> mMatchHosts;
        final List<String> mMatchPaths;
        int mTncRequestCronetFlags;
        int mTncRequestTTNetFlags;

        public SingleRequestFlagConfig(int r3, int r4, List<String> r5, List<String> r6) {
            ArrayList r0 = new ArrayList();
            this.mMatchHosts = r0;
            ArrayList r1 = new ArrayList();
            this.mMatchPaths = r1;
            this.mTncRequestCronetFlags = r3;
            this.mTncRequestTTNetFlags = r4;
            r0.addAll(r5);
            r1.addAll(r6);
        }
    }

    public TNCRequestFlagHandler() {
        this.mRequestFlagConfigs = new CopyOnWriteArrayList();
        this.mRequestFlagCtlEnabled = new AtomicBoolean(false);
    }

    public static TNCRequestFlagHandler getInstance() {
        if (sInstance != null) goto L16;
        monitor-enter(TNCRequestFlagHandler.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L11;
        sInstance = new TNCRequestFlagHandler();     // Catch: Throwable -> L9
        SsHttpCall.setRequestFlagHandler(sInstance);     // Catch: Throwable -> L9
    L11:
        monitor-exit(TNCRequestFlagHandler.class);     // Catch: Throwable -> L9
    L16:
        return sInstance;
    }

    @Override // com.bytedance.retrofit2.SsHttpCall.IRequestFlagHandler
    public Request handleFlag(Request r5) {
        if (r5 != null) goto L4;
        return r5;
    L4:
        if (this.mRequestFlagCtlEnabled.get() == false) goto L67;
        Iterator<SingleRequestFlagConfig> r4 = this.mRequestFlagConfigs.iterator();
    L8:
        if (r4.hasNext() == false) goto L31;
        SingleRequestFlagConfig r0 = r4.next();
        Iterator<String> r1 = r0.mMatchHosts.iterator();
    L11:
        if (r1.hasNext() == false) goto L8;
        if (UrlUtils.matchPattern(r5.getHost(), r1.next()) == false) goto L11;
        List<String> r2 = r0.mMatchPaths;
        if (r2 == null) goto L8;
        Iterator<String> r3 = r2.iterator();
    L19:
        if (r3.hasNext() == false) goto L8;
        String r6 = r3.next();
        if (r5.getPath() == null) goto L19;
        if (r5.getPath().startsWith(r6) == false) goto L19;
        if (r5.getExtraInfo() != null) goto L28;
        Request.Builder r7 = r5.newBuilder();
        r7.setExtraInfo(new BaseRequestContext());
        r5 = r7.build();
    L28:
        if ((r5.getExtraInfo() instanceof BaseRequestContext) == false) goto L8;
        BaseRequestContext r8 = (BaseRequestContext) r5.getExtraInfo();
        r8.request_flag |= r0.mTncRequestCronetFlags;
        r8.request_type_flags = r0.mTncRequestTTNetFlags | r8.request_type_flags;
        Request.Builder r9 = r5.newBuilder();
        r9.setExtraInfo(r8);
        r5 = r9.build();
        goto L8
    L31:
        if ((r5.getExtraInfo() instanceof BaseRequestContext) == false) goto L65;
        int r10 = ((BaseRequestContext) r5.getExtraInfo()).request_type_flags;
        boolean r11 = false;
        if ((r10 & 512) <= 0) goto L35;
        boolean r12 = true;
    L37:
        if ((r10 & 1024) <= 0) goto L39;
        r11 = true;
    L39:
        if (r12 == true) goto L41;
        if (r11 == true) goto L41;
        return r5;
    L41:
        Request.Builder r13 = r5.newBuilder();
        ArrayList r14 = new ArrayList();
        r14.addAll(r5.getHeaders());
        if (r12 == false) goto L44;
        r14.add(new Header(Request.KEY_BYPASS_TTNET_FEATURES, "1"));
    L44:
        if (r11 == false) goto L46;
        r14.add(new Header(Request.KEY_BYPASS_DISPATCH, "1"));
    L46:
        r13.headers(r14);
        return r13.build();
    L35:
        r12 = false;
        goto L37
    L65:
        return r5;
    L67:
        return r5;
    }

    public void parseJson2Config(JSONObject r14) {
        JSONArray r1 = r14.optJSONArray("request_flag_control");
        if (r1 != null) goto L5;
        return;
    L5:
        this.mRequestFlagCtlEnabled.set(false);
        this.mRequestFlagConfigs.clear();
        ArrayList r2 = new ArrayList();     // Catch: JSONException -> L38
        int r4 = 0;
    L8:
        if (r4 >= r1.length()) goto L33;
        JSONObject r5 = r1.getJSONObject(r4);     // Catch: JSONException -> L38
        int r6 = r5.optInt("cronet_flags");     // Catch: JSONException -> L38
        int r7 = r5.optInt("ttnet_flags");     // Catch: JSONException -> L38
        JSONArray r8 = r5.optJSONArray("prefix_group");     // Catch: JSONException -> L38
        JSONArray r9 = r5.optJSONArray("host_group");     // Catch: JSONException -> L38
        ArrayList r10 = new ArrayList();     // Catch: JSONException -> L38
        if (r8 == null) goto L16;
        int r11 = 0;
    L14:
        if (r11 >= r8.length()) goto L16;
        r10.add(r8.optString(r11, ""));     // Catch: JSONException -> L38
        r11 = r11 + 1;     // Catch: JSONException -> L38
    L16:
        ArrayList r12 = new ArrayList();     // Catch: JSONException -> L38
        if (r9 == null) goto L22;
        int r13 = 0;
    L20:
        if (r13 >= r9.length()) goto L22;
        r12.add(r9.optString(r13, ""));     // Catch: JSONException -> L38
        r13 = r13 + 1;     // Catch: JSONException -> L38
    L22:
        if (r6 > 0) goto L25;
        if (r7 > 0) goto L25;
    L31:
        r4 = r4 + 1;     // Catch: JSONException -> L38
    L25:
        if (r10.isEmpty() == true) goto L31;
        if (r12.isEmpty() == true) goto L31;
        r2.add(new SingleRequestFlagConfig(r6, r7, r12, r10));     // Catch: JSONException -> L38
        if (Logger.debug() == false) goto L31;
        Logger.d(TAG, "paths: " + r10);     // Catch: JSONException -> L38
        Logger.d(TAG, "hosts: " + r12);     // Catch: JSONException -> L38
        Logger.d(TAG, "flag: " + r6);     // Catch: JSONException -> L38
        Logger.d(TAG, "type flag: " + r7);     // Catch: JSONException -> L38
        goto L31
    L33:
        if (r14.optInt("req_flag_ctl_enabled") > 0) goto L35;
        return;
    L35:
        if (r2.size() <= 0) goto L50;
        this.mRequestFlagConfigs.addAll(r2);     // Catch: JSONException -> L38
        this.mRequestFlagCtlEnabled.set(true);     // Catch: JSONException -> L38
        return;
    L50:
        return;
    }

    @Override // com.bytedance.retrofit2.SsHttpCall.IRequestFlagHandler
    public boolean shouldBypassInterceptor(Request r2) {
        if ((r2.getExtraInfo() instanceof BaseRequestContext) == false) goto L10;
        int r1 = ((BaseRequestContext) r2.getExtraInfo()).request_type_flags;
        if ((r1 & 256) <= 0) goto L7;
    L8:
        return true;
    L7:
        if ((r1 & 512) > 0) goto L8;
        return false;
    L10:
        return false;
    }
}
