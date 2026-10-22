package cz.msebera.android.httpclient.protocol;

import com.android.settings.ApnEditor;
import cz.msebera.android.httpclient.util.Args;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public class UriPatternMatcher<T> {
    private final Map<String, T> map;

    public UriPatternMatcher() {
        this.map = new LinkedHashMap();
    }

    public synchronized Set<Map.Entry<String, T>> entrySet() {
        monitor-enter(this);
        HashSet r0 = new HashSet(this.map.entrySet());     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void register(String r2, T r3) {
        monitor-enter(this);
        Args.notNull(r2, "URI request pattern");     // Catch: Throwable -> L6
        this.map.put(r2, r3);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void unregister(String r2) {
        monitor-enter(this);
        if (r2 != null) goto L12;
        monitor-exit(this);
        return;
    L12:
        this.map.remove(r2);     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Deprecated
    public synchronized void setHandlers(Map<String, T> r2) {
        monitor-enter(this);
        Args.notNull(r2, "Map of handlers");     // Catch: Throwable -> L6
        this.map.clear();     // Catch: Throwable -> L6
        this.map.putAll(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Deprecated
    public synchronized void setObjects(Map<String, T> r2) {
        monitor-enter(this);
        Args.notNull(r2, "Map of handlers");     // Catch: Throwable -> L6
        this.map.clear();     // Catch: Throwable -> L6
        this.map.putAll(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Deprecated
    public synchronized Map<String, T> getObjects() {
        monitor-enter(this);
        Map<String, T> r0 = this.map;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized T lookup(String r7) {
        monitor-enter(this);
        Args.notNull(r7, "Request path");     // Catch: Throwable -> L21
        T r0 = this.map.get(r7);     // Catch: Throwable -> L21
        if (r0 != null) goto L19;
        Iterator<String> r1 = this.map.keySet().iterator();     // Catch: Throwable -> L21
        String r2 = null;
    L6:
        if (r1.hasNext() == false) goto L19;
        String r3 = r1.next();     // Catch: Throwable -> L21
        if (matchUriRequestPattern(r3, r7) == false) goto L6;
        if (r2 == null) goto L17;
        if (r2.length() < r3.length()) goto L17;
        if (r2.length() != r3.length()) goto L6;
        if (r3.endsWith(ApnEditor.APN_TYPE_ALL) == false) goto L6;
    L17:
        r0 = this.map.get(r3);     // Catch: Throwable -> L21
        r2 = r3;
    L19:
        monitor-exit(this);
        return r0;
    L21:
        th = move-exception;
        throw th;
    }

    protected boolean matchUriRequestPattern(String r4, String r5) {
        if (r4.equals(ApnEditor.APN_TYPE_ALL) == false) goto L6;
        return true;
    L6:
        if (r4.endsWith(ApnEditor.APN_TYPE_ALL) == false) goto L10;
        if (r5.startsWith(r4.substring(0, r4.length() - 1)) == false) goto L10;
        return true;
    L10:
        if (r4.startsWith(ApnEditor.APN_TYPE_ALL) == false) goto L15;
        if (r5.endsWith(r4.substring(1, r4.length())) == false) goto L15;
        return true;
    L15:
        return false;
    }

    public String toString() {
        return this.map.toString();
    }
}
