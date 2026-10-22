package com.bytedance.frameworks.baselib.network.http;

import a.a;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import java.net.URI;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class NativeRequestInterceptor {
    private static final String TAG = "NativeRequestInterceptor";
    private static RequestInterceptorCallback sRequestInterceptorCallback;

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.http.NativeRequestInterceptor$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$frameworks$baselib$network$http$NativeRequestInterceptor$RequestModified = null;

        static {
            int[] r0 = new int[RequestModified.values().length];
            $SwitchMap$com$bytedance$frameworks$baselib$network$http$NativeRequestInterceptor$RequestModified = r0;
            r0[RequestModified.URL_MODIFIED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$bytedance$frameworks$baselib$network$http$NativeRequestInterceptor$RequestModified[RequestModified.HEADER_MODIFIED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$bytedance$frameworks$baselib$network$http$NativeRequestInterceptor$RequestModified[RequestModified.BOTH_MODIFIED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public interface RequestInterceptorCallback {
        RequestResult onRequestInterceptorCallback(String r1, Map<String, String> r2, List<String> r3);

        ResponseResult onResponseInterceptorCallback(String r1, Map<String, List<String>> r2, int r3);
    }

    public static final enum RequestModified extends Enum<RequestModified> {
        private static final /* synthetic */ RequestModified[] $VALUES = null;
        public static final RequestModified BOTH_MODIFIED = null;
        public static final RequestModified HEADER_MODIFIED = null;
        public static final RequestModified NOT_MODIFIED = null;
        public static final RequestModified URL_MODIFIED = null;
        public final int mValue;

        static {
            RequestModified r0 = new RequestModified("NOT_MODIFIED", 0, 0);
            NOT_MODIFIED = r0;
            RequestModified r1 = new RequestModified("URL_MODIFIED", 1, 1);
            URL_MODIFIED = r1;
            RequestModified r2 = new RequestModified("HEADER_MODIFIED", 2, 2);
            HEADER_MODIFIED = r2;
            RequestModified r3 = new RequestModified("BOTH_MODIFIED", 3, 3);
            BOTH_MODIFIED = r3;
            $VALUES = new RequestModified[]{r0, r1, r2, r3};
        }

        private RequestModified(String r1, int r2, int r3) {
            super(r1, r2);
            this.mValue = r3;
        }

        public static RequestModified valueOf(String r1) {
            return (RequestModified) Enum.valueOf(RequestModified.class, r1);
        }

        public static RequestModified[] values() {
            return (RequestModified[]) $VALUES.clone();
        }

        public int getValue() {
            return this.mValue;
        }
    }

    public static class RequestResult {
        private RequestModified modified;
        private Map<String, String> newHeaders;
        private String newUrl;
        private Set<String> removedHeaders;

        public RequestResult(RequestModified r1) {
            this.modified = r1;
        }

        private static void constructHeaderJson(JSONObject r2, Map<String, String> r3, Set<String> r4) {
            if (r4 == null) goto L8;
            JSONArray r0 = new JSONArray();
            Iterator<String> r5 = r4.iterator();
        L5:
            if (r5.hasNext() == false) goto L7;
            r0.put(r5.next());
            goto L5
        L7:
            r2.put("removed_headers", r0);
        L8:
            if (r3 != null) goto L10;
            return;
        L10:
            JSONObject r6 = new JSONObject();
            Iterator<Map.Entry<String, String>> r7 = r3.entrySet().iterator();
        L12:
            if (r7.hasNext() == false) goto L17;
            Map.Entry<String, String> r1 = r7.next();
            if (r1.getValue().isEmpty() == true) goto L12;
            r6.put(r1.getKey(), r1.getValue());
            goto L12
        L17:
            r2.put("new_headers", r6);
        }

        private static void constructUrlJson(JSONObject r1, String r2) {
            if (TextUtils.isEmpty(r2) == false) goto L8;
            return;
        L8:
            new URI(r2);     // Catch: Exception -> L7
            r1.put("new_url", r2);     // Catch: Exception -> L7
            return;
        }

        public void setNewHeaders(Map<String, String> r1) {
            this.newHeaders = r1;
        }

        public void setNewUrl(String r1) {
            this.newUrl = r1;
        }

        public void setRemoveHeaders(Set<String> r1) {
            this.removedHeaders = r1;
        }

        public String toJsonStr() {
            JSONObject r0 = new JSONObject();
            int r1 = AnonymousClass1.$SwitchMap$com$bytedance$frameworks$baselib$network$http$NativeRequestInterceptor$RequestModified[this.modified.ordinal()];     // Catch: JSONException -> L16
            if (r1 != 1) goto L7;
            r0.put("modified", RequestModified.URL_MODIFIED.getValue());     // Catch: JSONException -> L16
            constructUrlJson(r0, this.newUrl);     // Catch: JSONException -> L16
        L17:
            goto L15
        L7:
            if (r1 != 2) goto L9;
            r0.put("modified", RequestModified.HEADER_MODIFIED.getValue());     // Catch: JSONException -> L16
            constructHeaderJson(r0, this.newHeaders, this.removedHeaders);     // Catch: JSONException -> L16
            goto L17
        L9:
            if (r1 != 3) goto L17;
            r0.put("modified", RequestModified.BOTH_MODIFIED.getValue());     // Catch: JSONException -> L16
            constructUrlJson(r0, this.newUrl);     // Catch: JSONException -> L16
            constructHeaderJson(r0, this.newHeaders, this.removedHeaders);     // Catch: JSONException -> L16
        L15:
            return r0.toString();
        }
    }

    public static class ResponseResult {
        private RequestModified modified;
        private Map<String, List<String>> newHeaders;
        private Set<String> removedHeaders;

        public ResponseResult(RequestModified r1) {
            this.modified = r1;
        }

        private static JSONObject constructHeaderJson(Map<String, List<String>> r6) {
            if (r6 != null) goto L4;
            return null;
        L4:
            if (r6.isEmpty() == true) goto L25;
            JSONObject r0 = new JSONObject();
            Iterator<Map.Entry<String, List<String>>> r7 = r6.entrySet().iterator();
        L8:
            if (r7.hasNext() == false) goto L16;
            Map.Entry<String, List<String>> r1 = r7.next();
            JSONArray r2 = new JSONArray();
            Iterator<String> r3 = r1.getValue().iterator();
        L11:
            if (r3.hasNext() == false) goto L15;
            String r4 = r3.next();
            if (TextUtils.isEmpty(r4) == true) goto L11;
            r2.put(r4);
            goto L11
        L15:
            r0.put(r1.getKey(), r2);
            goto L8
        L16:
            return r0;
        L25:
            return null;
        }

        public void setNewHeaders(Map<String, List<String>> r1) {
            this.newHeaders = r1;
        }

        public void setRemoveHeaders(Set<String> r1) {
            this.removedHeaders = r1;
        }

        public String toJsonStr() {
            RequestModified r0 = this.modified;
            if (r0 == RequestModified.HEADER_MODIFIED) goto L7;
            if (r0 == RequestModified.BOTH_MODIFIED) goto L7;
            return null;
        L7:
            if (this.newHeaders == null) goto L9;
        L12:
            JSONObject r1 = new JSONObject();
            r1.put("modified", this.modified.getValue());     // Catch: JSONException -> L25
            Map<String, List<String>> r2 = this.newHeaders;     // Catch: JSONException -> L25
            if (r2 == null) goto L17;
            r1.put("new_headers", constructHeaderJson(r2));     // Catch: JSONException -> L25
        L17:
            if (this.removedHeaders == null) goto L24;
            JSONArray r3 = new JSONArray();     // Catch: JSONException -> L25
            Iterator<String> r4 = this.removedHeaders.iterator();     // Catch: JSONException -> L25
        L20:
            if (r4.hasNext() == false) goto L22;
            r3.put(r4.next());     // Catch: JSONException -> L25
            goto L20
        L22:
            r1.put("removed_headers", r3);     // Catch: JSONException -> L25
        L24:
            return r1.toString();
        L9:
            if (this.removedHeaders != null) goto L12;
            return null;
        }
    }

    public NativeRequestInterceptor() {
    }

    public static String onCallRequestInterceptorToStart(String r4, Map<String, String> r5, List<String> r6) {
        if (sRequestInterceptorCallback != null) goto L6;
        return null;
    L6:
        if (Logger.debug() == false) goto L8;
        StringBuilder r0 = a.u("request url:", r4, " headers:");
        r0.append(r5.toString());
        r0.append(" domains:");
        r0.append(r6);
        Logger.d(TAG, r0.toString());
    L8:
        RequestResult r7 = sRequestInterceptorCallback.onRequestInterceptorCallback(r4, r5, r6);
        if (r7 != null) goto L11;
        return null;
    L11:
        String r8 = r7.toJsonStr();
        if (Logger.debug() == false) goto L14;
        a.y("request json:", r8, TAG);
    L14:
        return r8;
    }

    public static String onCallResponseInterceptorToStart(String r4, Map<String, List<String>> r5, int r6) {
        if (sRequestInterceptorCallback != null) goto L6;
        return null;
    L6:
        if (Logger.debug() == false) goto L8;
        StringBuilder r0 = a.u("response url:", r4, " headers:");
        r0.append(r5.toString());
        r0.append(" code:");
        r0.append(r6);
        Logger.d(TAG, r0.toString());
    L8:
        ResponseResult r7 = sRequestInterceptorCallback.onResponseInterceptorCallback(r4, r5, r6);
        if (r7 != null) goto L11;
        return null;
    L11:
        String r8 = r7.toJsonStr();
        if (Logger.debug() == false) goto L14;
        a.y("response json:", r8, TAG);
    L14:
        return r8;
    }

    public static void setRequestInterceptorCallback(RequestInterceptorCallback r0) {
        sRequestInterceptorCallback = r0;
    }
}
