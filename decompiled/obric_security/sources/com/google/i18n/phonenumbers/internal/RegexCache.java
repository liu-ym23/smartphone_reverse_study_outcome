package com.google.i18n.phonenumbers.internal;

import java.util.LinkedHashMap;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class RegexCache {
    private LRUCache<String, Pattern> cache;

    private static class LRUCache<K, V> {
        private LinkedHashMap<K, V> map;
        private int size;

        static /* synthetic */ int access$000(LRUCache r0) {
            return r0.size;
        }

        public LRUCache(int r4) {
            this.size = r4;
            final boolean r1 = true;
            final int r5 = ((r4 * 4) / 3) + 1;
            final float r2 = 0.75f;
            this.map = new AnonymousClass1(this, r5, r2, r1);
        }

        public synchronized V get(K r2) {
            monitor-enter(this);
            V r3 = this.map.get(r2);     // Catch: Throwable -> L6
            monitor-exit(this);
            return r3;
        L6:
            th = move-exception;
            throw th;
        }

        public synchronized void put(K r2, V r3) {
            monitor-enter(this);
            this.map.put(r2, r3);     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public synchronized boolean containsKey(K r2) {
            monitor-enter(this);
            boolean r3 = this.map.containsKey(r2);     // Catch: Throwable -> L6
            monitor-exit(this);
            return r3;
        L6:
            th = move-exception;
            throw th;
        }
    }

    public RegexCache(int r2) {
        this.cache = new LRUCache(r2);
    }

    public Pattern getPatternForRegex(String r2) {
        Pattern r0 = this.cache.get(r2);
        if (r0 != null) goto L6;
        Pattern r1 = Pattern.compile(r2);
        this.cache.put(r2, r1);
        return r1;
    L6:
        return r0;
    }

    boolean containsRegex(String r1) {
        return this.cache.containsKey(r1);
    }
}
