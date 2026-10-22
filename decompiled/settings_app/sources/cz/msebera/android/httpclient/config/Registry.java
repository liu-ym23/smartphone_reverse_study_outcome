package cz.msebera.android.httpclient.config;

import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
public final class Registry<I> implements Lookup<I> {
    private final Map<String, I> map;

    Registry(Map<String, I> r2) {
        this.map = new ConcurrentHashMap(r2);
    }

    @Override // cz.msebera.android.httpclient.config.Lookup
    public I lookup(String r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return this.map.get(r2.toLowerCase(Locale.ROOT));
    }

    public String toString() {
        return this.map.toString();
    }
}
