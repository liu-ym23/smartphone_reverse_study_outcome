package com.bytedance.retrofit2.client;

import com.bytedance.retrofit2.OptConfig;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.Utils;
import com.bytedance.retrofit2.mime.FormUrlEncodedTypedOutput;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes3.dex */
public final class Request {
    public static final String KEY_BYPASS_DISPATCH = "x-tt-bypass-dp";
    public static final String KEY_BYPASS_OKHTTP_COOKIE = "x-metasec-bypass-okhttp-cookie";
    public static final String KEY_BYPASS_TTNET_FEATURES = "x-metasec-bypass-ttnet-features";
    private final boolean addCommonParam;
    private final TypedOutput body;
    private final int commonParamLevel;
    private Object extraInfo;
    private final List<Header> headers;
    private boolean isBodyEncryptEnabled;
    private boolean isQueryEncryptEnabled;
    private final int maxLength;
    private final String method;
    private RetrofitMetrics metrics;
    private final int priorityLevel;
    private int queryFilterPriority;
    private final RequestBody requestBody;
    private final int requestPriorityLevel;
    private final boolean responseStreaming;
    private final String serviceType;
    private final Map<Class<?>, Object> tags;
    private URI uri;
    private final String url;

    public static class Builder {
        boolean addCommonParam;
        TypedOutput body;
        int commonParamLevel;
        Object extraInfo;
        List<Header> headers;
        boolean isBodyEncryptEnabled;
        boolean isQueryEncryptEnabled;
        int maxLength;
        String method;
        RetrofitMetrics metrics;
        int priorityLevel;
        RequestBody requestBody;
        int requestPriorityLevel;
        boolean responseStreaming;
        String serviceType;
        Map<Class<?>, Object> tags;
        String url;

        public Builder() {
            this.method = "GET";
        }

        Builder(Request r3) {
            this.method = Request.access$000(r3);
            this.url = Request.access$100(r3);
            LinkedList r0 = new LinkedList();
            this.headers = r0;
            r0.addAll(Request.access$200(r3));
            this.body = Request.access$300(r3);
            this.requestBody = Request.access$400(r3);
            this.priorityLevel = Request.access$500(r3);
            this.requestPriorityLevel = Request.access$600(r3);
            this.responseStreaming = Request.access$700(r3);
            this.maxLength = Request.access$800(r3);
            this.addCommonParam = Request.access$900(r3);
            this.commonParamLevel = Request.access$1000(r3);
            this.extraInfo = Request.access$1100(r3);
            this.serviceType = Request.access$1200(r3);
            this.metrics = Request.access$1300(r3);
            this.tags = Request.access$1400(r3);
            this.isQueryEncryptEnabled = Request.access$1500(r3);
            this.isBodyEncryptEnabled = Request.access$1600(r3);
        }

        public Builder get() {
            return method("GET", null);
        }

        public Builder head() {
            return method("HEAD", null);
        }

        public Builder post(TypedOutput r2) {
            return method("POST", r2);
        }

        public Builder delete(TypedOutput r2) {
            return method("DELETE", r2);
        }

        public Builder put(TypedOutput r2) {
            return method("PUT", r2);
        }

        public Builder patch(TypedOutput r2) {
            return method("PATCH", r2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v0, types: [com.bytedance.retrofit2.mime.TypedOutput] */
        /* JADX WARN: Type inference failed for: r4v1, types: [com.bytedance.retrofit2.mime.TypedOutput] */
        /* JADX WARN: Type inference failed for: r4v2, types: [com.bytedance.retrofit2.mime.FormUrlEncodedTypedOutput] */
        public Builder method(String r3, TypedOutput r4) {
            if (r3 == null) goto L20;
            if (r3.length() == 0) goto L18;
            if (r4 != 0) goto L7;
        L11:
            if (r4 == 0) goto L13;
        L15:
            this.method = r3;
            this.body = r4;
            return this;
        L13:
            if (Utils.requiresRequestBody(r3) == false) goto L15;
            r4 = new FormUrlEncodedTypedOutput();
            r4.addField("body", "null");
            goto L15
        L7:
            if (Utils.permitsRequestBody(r3) == true) goto L11;
            throw new IllegalArgumentException("method " + r3 + " must not have a request body.");
        L18:
            throw new IllegalArgumentException("method.length() == 0");
        L20:
            throw new NullPointerException("method == null");
        }

        public Builder url(String r1) {
            if (r1 == null) goto L6;
            this.url = r1;
            return this;
        L6:
            throw new NullPointerException("url == null");
        }

        public Builder headers(List<Header> r1) {
            this.headers = r1;
            return this;
        }

        public Builder priorityLevel(int r1) {
            this.priorityLevel = r1;
            return this;
        }

        public Builder requestPriorityLevel(int r1) {
            this.requestPriorityLevel = r1;
            return this;
        }

        public Builder serviceType(String r1) {
            this.serviceType = r1;
            return this;
        }

        public Builder responseStreaming(boolean r1) {
            this.responseStreaming = r1;
            return this;
        }

        public Builder maxLength(int r1) {
            this.maxLength = r1;
            return this;
        }

        public Builder setExtraInfo(Object r1) {
            this.extraInfo = r1;
            return this;
        }

        public Builder tag(Object r2) {
            return tag(Object.class, r2);
        }

        public <T> Builder tag(Class<? super T> r2, T r3) {
            if (r2 == null) goto L11;
            if (this.tags != null) goto L6;
            this.tags = new HashMap();
        L6:
            if (r3 != null) goto L8;
            this.tags.remove(r2);
        L9:
            return this;
        L8:
            this.tags.put(r2, r2.cast(r3));
            goto L9
        L11:
            throw new NullPointerException("type == null");
        }

        public Request build() {
            if (this.url == null) goto L7;
            return new Request(this);
        L7:
            throw new IllegalStateException("url == null");
        }
    }

    static /* synthetic */ String access$000(Request r0) {
        return r0.method;
    }

    static /* synthetic */ String access$100(Request r0) {
        return r0.url;
    }

    static /* synthetic */ int access$1000(Request r0) {
        return r0.commonParamLevel;
    }

    static /* synthetic */ Object access$1100(Request r0) {
        return r0.extraInfo;
    }

    static /* synthetic */ String access$1200(Request r0) {
        return r0.serviceType;
    }

    static /* synthetic */ RetrofitMetrics access$1300(Request r0) {
        return r0.metrics;
    }

    static /* synthetic */ Map access$1400(Request r0) {
        return r0.tags;
    }

    static /* synthetic */ boolean access$1500(Request r0) {
        return r0.isQueryEncryptEnabled;
    }

    static /* synthetic */ boolean access$1600(Request r0) {
        return r0.isBodyEncryptEnabled;
    }

    static /* synthetic */ List access$200(Request r0) {
        return r0.headers;
    }

    static /* synthetic */ TypedOutput access$300(Request r0) {
        return r0.body;
    }

    static /* synthetic */ RequestBody access$400(Request r0) {
        return r0.requestBody;
    }

    static /* synthetic */ int access$500(Request r0) {
        return r0.priorityLevel;
    }

    static /* synthetic */ int access$600(Request r0) {
        return r0.requestPriorityLevel;
    }

    static /* synthetic */ boolean access$700(Request r0) {
        return r0.responseStreaming;
    }

    static /* synthetic */ int access$800(Request r0) {
        return r0.maxLength;
    }

    static /* synthetic */ boolean access$900(Request r0) {
        return r0.addCommonParam;
    }

    public Request(String r16, String r17, List<Header> r18, TypedOutput r19, int r20, boolean r21, int r22, boolean r23, Object r24) {
        this(r16, r17, r18, r19, null, r20, 3, r21, r22, r23, 0, r24, "", null);
    }

    public Request(String r2, String r3, List<Header> r4, TypedOutput r5, RequestBody r6, int r7, int r8, boolean r9, int r10, boolean r11, int r12, Object r13, String r14, Map<Class<?>, Object> r15) {
        this.queryFilterPriority = 0;
        if (r2 == null) goto L14;
        if (r3 == null) goto L12;
        this.method = r2;
        this.url = r3;
        if (r4 != null) goto L8;
        this.headers = Collections.emptyList();
    L9:
        this.body = r5;
        this.requestBody = r6;
        this.priorityLevel = r7;
        this.requestPriorityLevel = r8;
        this.responseStreaming = r9;
        this.maxLength = r10;
        this.addCommonParam = r11;
        this.commonParamLevel = r12;
        this.extraInfo = r13;
        this.serviceType = r14;
        this.tags = r15;
        return;
    L8:
        this.headers = Collections.unmodifiableList(new ArrayList(r4));
        goto L9
    L12:
        throw new NullPointerException("URL must not be null.");
    L14:
        throw new NullPointerException("Method must not be null.");
    }

    Request(Builder r3) {
        this.queryFilterPriority = 0;
        if (r3.url == null) goto L15;
        this.url = r3.url;
        if (r3.method == null) goto L13;
        this.method = r3.method;
        if (r3.headers != null) goto L9;
        this.headers = Collections.emptyList();
    L10:
        this.body = r3.body;
        this.requestBody = r3.requestBody;
        this.priorityLevel = r3.priorityLevel;
        this.requestPriorityLevel = r3.requestPriorityLevel;
        this.responseStreaming = r3.responseStreaming;
        this.maxLength = r3.maxLength;
        this.addCommonParam = r3.addCommonParam;
        this.commonParamLevel = r3.commonParamLevel;
        this.extraInfo = r3.extraInfo;
        this.serviceType = r3.serviceType;
        this.metrics = r3.metrics;
        this.tags = r3.tags;
        this.isQueryEncryptEnabled = r3.isQueryEncryptEnabled;
        this.isBodyEncryptEnabled = r3.isBodyEncryptEnabled;
        return;
    L9:
        this.headers = Collections.unmodifiableList(new ArrayList(r3.headers));
        goto L10
    L13:
        throw new NullPointerException("Method must not be null.");
    L15:
        throw new NullPointerException("URL must not be null.");
    }

    public String getMethod() {
        return this.method;
    }

    public String getUrl() {
        return this.url;
    }

    public List<Header> getHeaders() {
        return this.headers;
    }

    public Header getFirstHeader(String r4) {
        if (r4 == null) goto L13;
        List<Header> r3 = this.headers;
        if (r3 == null) goto L13;
        Iterator<Header> r5 = r3.iterator();
    L9:
        if (r5.hasNext() == false) goto L13;
        Header r1 = r5.next();
        if (r4.equalsIgnoreCase(r1.getName()) == false) goto L9;
        return r1;
    L13:
        return null;
    }

    public List<Header> headers(String r4) {
        ArrayList r0 = null;
        if (r4 == null) goto L15;
        List<Header> r3 = this.headers;
        if (r3 == null) goto L15;
        Iterator<Header> r5 = r3.iterator();
    L9:
        if (r5.hasNext() == false) goto L15;
        Header r1 = r5.next();
        if (r4.equalsIgnoreCase(r1.getName()) == false) goto L9;
        if (r0 != null) goto L14;
        r0 = new ArrayList();
    L14:
        r0.add(r1);
    L15:
        return r0;
    }

    public TypedOutput getBody() {
        RequestBody r0 = this.requestBody;
        if (r0 == null) goto L7;
        return Utils.convert(r0);
    L7:
        return this.body;
    }

    public RequestBody getRequestBody() {
        return this.requestBody;
    }

    public int getPriorityLevel() {
        return this.priorityLevel;
    }

    public int getRequestPriorityLevel() {
        return this.requestPriorityLevel;
    }

    public boolean isResponseStreaming() {
        return this.responseStreaming;
    }

    public boolean isAddCommonParam() {
        return this.addCommonParam;
    }

    public int getCommonParamLevel() {
        return this.commonParamLevel;
    }

    public int getMaxLength() {
        return this.maxLength;
    }

    public void setExtraInfo(Object r1) {
        this.extraInfo = r1;
    }

    public Object getExtraInfo() {
        return this.extraInfo;
    }

    public String getServiceType() {
        return this.serviceType;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public String getHost() {
        URI r0 = getUri();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getHost();
    }

    public String getPath() {
        URI r0 = getUri();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPath();
    }

    public RetrofitMetrics getMetrics() {
        return this.metrics;
    }

    public void setMetrics(RetrofitMetrics r1) {
        this.metrics = r1;
    }

    public int getQueryFilterPriority() {
        return this.queryFilterPriority;
    }

    public void setQueryFilterPriority(int r1) {
        this.queryFilterPriority = r1;
    }

    public boolean isQueryEncryptEnabled() {
        return this.isQueryEncryptEnabled;
    }

    public void setQueryEncryptEnabled(boolean r1) {
        this.isQueryEncryptEnabled = r1;
    }

    public boolean isBodyEncryptEnabled() {
        return this.isBodyEncryptEnabled;
    }

    public void setBodyEncryptEnabled(boolean r1) {
        this.isBodyEncryptEnabled = r1;
    }

    private URI getUri() {
        if (OptConfig.isEnableRequestOpt() == false) goto L18;
        if (this.uri != null) goto L16;
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (this.uri != null) goto L10;
        this.uri = safeCreateUri(this.url);     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);     // Catch: Throwable -> L12
    L16:
        return this.uri;
    L18:
        return safeCreateUri(this.url);
    }

    private static URI safeCreateUri(String r2) throws RuntimeException {
        if (r2 != null) goto L4;
        return null;
    L4:
        if (r2.isEmpty() == true) goto L17;
        return new URI(r2);
    L8:
        return URI.create(r2.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
    L11:
        return createUriWithOutQuery(r2);
    L17:
        return null;
    }

    private static URI createUriWithOutQuery(String r2) throws RuntimeException {
        if (r2 != null) goto L4;
        return null;
    L4:
        if (r2.isEmpty() == true) goto L18;
        int r0 = r2.indexOf("?");     // Catch: Exception -> L11
        if (r0 <= 0) goto L9;
        r2 = r2.substring(0, r0);     // Catch: Exception -> L11
    L9:
        return URI.create(r2);
    L11:
        e = move-exception;
        throw new RuntimeException(e);
    L18:
        return null;
    }

    public Object tag() {
        return tag(Object.class);
    }

    public <T> T tag(Class<? extends T> r1) {
        Map<Class<?>, Object> r0 = this.tags;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r1.cast(r0.get(r1));
    }

    public boolean isPureRequest() {
        List<Header> r2 = headers(KEY_BYPASS_TTNET_FEATURES);
        if (r2 != null) goto L5;
    L10:
        return false;
    L5:
        if (r2.size() <= 0) goto L10;
        if ("1".equals(r2.get(0).getValue()) == false) goto L10;
        return true;
    }

    public boolean isBypassDispatch() {
        List<Header> r2 = headers(KEY_BYPASS_DISPATCH);
        if (r2 != null) goto L5;
    L10:
        return false;
    L5:
        if (r2.size() <= 0) goto L10;
        if ("1".equals(r2.get(0).getValue()) == false) goto L10;
        return true;
    }
}
