package com.bumptech.glide.load.model;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class LazyHeaders implements Headers {
    private volatile Map<String, String> combinedHeaders;
    private final Map<String, List<LazyHeaderFactory>> headers;

    public static final class Builder {
        private static final Map<String, List<LazyHeaderFactory>> DEFAULT_HEADERS = null;
        private static final String DEFAULT_USER_AGENT = null;
        private static final String USER_AGENT_HEADER = "User-Agent";
        private boolean copyOnModify;
        private Map<String, List<LazyHeaderFactory>> headers;
        private boolean isUserAgentDefault;

        public Builder() {
            this.copyOnModify = true;
            this.headers = DEFAULT_HEADERS;
            this.isUserAgentDefault = true;
        }

        static {
            String r0 = getSanitizedUserAgent();
            DEFAULT_USER_AGENT = r0;
            HashMap r1 = new HashMap(2);
            if (TextUtils.isEmpty(r0) == true) goto L5;
            r1.put("User-Agent", Collections.singletonList(new StringHeaderFactory(r0)));
        L5:
            DEFAULT_HEADERS = Collections.unmodifiableMap(r1);
        }

        public Builder addHeader(String r2, String r3) {
            return addHeader(r2, new StringHeaderFactory(r3));
        }

        public Builder addHeader(String r2, LazyHeaderFactory r3) {
            if (this.isUserAgentDefault == true) goto L5;
        L8:
            copyIfNecessary();
            getFactories(r2).add(r3);
            return this;
        L5:
            if ("User-Agent".equalsIgnoreCase(r2) == false) goto L8;
            return setHeader(r2, r3);
        }

        public Builder setHeader(String r2, String r3) {
            if (r3 != null) goto L4;
            StringHeaderFactory r4 = null;
        L6:
            return setHeader(r2, r4);
        L4:
            r4 = new StringHeaderFactory(r3);
            goto L6
        }

        public Builder setHeader(String r2, LazyHeaderFactory r3) {
            copyIfNecessary();
            if (r3 != null) goto L5;
            this.headers.remove(r2);
        L7:
            if (this.isUserAgentDefault == true) goto L9;
        L11:
            return this;
        L9:
            if ("User-Agent".equalsIgnoreCase(r2) == false) goto L11;
            this.isUserAgentDefault = false;
            goto L11
        L5:
            List<LazyHeaderFactory> r0 = getFactories(r2);
            r0.clear();
            r0.add(r3);
            goto L7
        }

        private List<LazyHeaderFactory> getFactories(String r2) {
            List<LazyHeaderFactory> r0 = this.headers.get(r2);
            if (r0 != null) goto L6;
            ArrayList r1 = new ArrayList();
            this.headers.put(r2, r1);
            return r1;
        L6:
            return r0;
        }

        private void copyIfNecessary() {
            if (this.copyOnModify == false) goto L6;
            this.copyOnModify = false;
            this.headers = copyHeaders();
            return;
        }

        public LazyHeaders build() {
            this.copyOnModify = true;
            return new LazyHeaders(this.headers);
        }

        private Map<String, List<LazyHeaderFactory>> copyHeaders() {
            HashMap r0 = new HashMap(this.headers.size());
            Iterator<Map.Entry<String, List<LazyHeaderFactory>>> r4 = this.headers.entrySet().iterator();
        L4:
            if (r4.hasNext() == false) goto L6;
            Map.Entry<String, List<LazyHeaderFactory>> r1 = r4.next();
            ArrayList r2 = new ArrayList(r1.getValue());
            r0.put(r1.getKey(), r2);
            goto L4
        L6:
            return r0;
        }

        static String getSanitizedUserAgent() {
            String r0 = System.getProperty("http.agent");
            if (TextUtils.isEmpty(r0) == false) goto L5;
            return r0;
        L5:
            int r1 = r0.length();
            StringBuilder r2 = new StringBuilder(r0.length());
            int r3 = 0;
        L6:
            if (r3 >= r1) goto L17;
            char r4 = r0.charAt(r3);
            if (r4 > 31) goto L12;
            if (r4 == '\t') goto L12;
        L14:
            r2.append('?');
        L15:
            r3 = r3 + 1;
        L12:
            if (r4 >= 127) goto L14;
            r2.append(r4);
            goto L15
        L17:
            return r2.toString();
        }
    }

    static final class StringHeaderFactory implements LazyHeaderFactory {
        private final String value;

        StringHeaderFactory(String r1) {
            this.value = r1;
        }

        @Override // com.bumptech.glide.load.model.LazyHeaderFactory
        public String buildHeader() {
            return this.value;
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.value + "'}";
        }

        public boolean equals(Object r2) {
            if ((r2 instanceof StringHeaderFactory) == true) goto L5;
            return false;
        L5:
            return this.value.equals(((StringHeaderFactory) r2).value);
        }

        public int hashCode() {
            return this.value.hashCode();
        }
    }

    LazyHeaders(Map<String, List<LazyHeaderFactory>> r1) {
        this.headers = Collections.unmodifiableMap(r1);
    }

    @Override // com.bumptech.glide.load.model.Headers
    public Map<String, String> getHeaders() {
        if (this.combinedHeaders != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.combinedHeaders != null) goto L8;
        this.combinedHeaders = Collections.unmodifiableMap(generateHeaders());     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.combinedHeaders;
    }

    private Map<String, String> generateHeaders() {
        HashMap r0 = new HashMap();
        Iterator<Map.Entry<String, List<LazyHeaderFactory>>> r1 = this.headers.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        Map.Entry<String, List<LazyHeaderFactory>> r2 = r1.next();
        String r3 = buildHeaderValue(r2.getValue());
        if (TextUtils.isEmpty(r3) == true) goto L4;
        r0.put(r2.getKey(), r3);
        goto L4
    L8:
        return r0;
    }

    private String buildHeaderValue(List<LazyHeaderFactory> r5) {
        StringBuilder r4 = new StringBuilder();
        int r0 = r5.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L11;
        String r2 = r5.get(r1).buildHeader();
        if (TextUtils.isEmpty(r2) == true) goto L9;
        r4.append(r2);
        if (r1 == (r5.size() - 1)) goto L9;
        r4.append(',');
    L9:
        r1 = r1 + 1;
        goto L3
    L11:
        return r4.toString();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.headers + '}';
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof LazyHeaders) == true) goto L5;
        return false;
    L5:
        return this.headers.equals(((LazyHeaders) r2).headers);
    }

    public int hashCode() {
        return this.headers.hashCode();
    }
}
