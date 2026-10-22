package com.android.volley;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface Cache {

    public static class Entry {
        public List<Header> allResponseHeaders;
        public byte[] data;
        public String etag;
        public long lastModified;
        public Map<String, String> responseHeaders;
        public long serverDate;
        public long softTtl;
        public long ttl;

        public Entry() {
            this.responseHeaders = Collections.emptyMap();
        }

        public boolean isExpired() {
            return isExpired(System.currentTimeMillis());
        }

        boolean isExpired(long r3) {
            if (this.ttl >= r3) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean refreshNeeded() {
            return refreshNeeded(System.currentTimeMillis());
        }

        boolean refreshNeeded(long r3) {
            if (this.softTtl >= r3) goto L5;
            return true;
        L5:
            return false;
        }
    }

    void clear();

    Entry get(String r1);

    void initialize();

    void invalidate(String r1, boolean r2);

    void put(String r1, Entry r2);

    void remove(String r1);
}
