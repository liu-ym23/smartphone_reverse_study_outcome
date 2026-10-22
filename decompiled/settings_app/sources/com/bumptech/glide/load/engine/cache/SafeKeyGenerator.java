package com.bumptech.glide.load.engine.cache;

import androidx.core.util.Pools;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes3.dex */
public class SafeKeyGenerator {
    private final Pools.Pool<PoolableDigestContainer> digestPool;
    private final LruCache<Key, String> loadIdToSafeHash;

    private static final class PoolableDigestContainer implements FactoryPools.Poolable {
        final MessageDigest messageDigest;
        private final StateVerifier stateVerifier;

        PoolableDigestContainer(MessageDigest r2) {
            this.stateVerifier = StateVerifier.newInstance();
            this.messageDigest = r2;
        }

        @Override // com.bumptech.glide.util.pool.FactoryPools.Poolable
        public StateVerifier getVerifier() {
            return this.stateVerifier;
        }
    }

    public SafeKeyGenerator() {
        this.loadIdToSafeHash = new LruCache(1000);
        this.digestPool = FactoryPools.threadSafe(10, new AnonymousClass1(this));
    }

    public String getSafeKey(Key r4) {
        LruCache<Key, String> r0 = this.loadIdToSafeHash;
        monitor-enter(r0);
        String r1 = this.loadIdToSafeHash.get(r4);     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        if (r1 != null) goto L8;
        r1 = calculateHexStringDigest(r4);
    L8:
        LruCache<Key, String> r2 = this.loadIdToSafeHash;
        monitor-enter(r2);
        this.loadIdToSafeHash.put(r4, r1);     // Catch: Throwable -> L13
        monitor-exit(r2);     // Catch: Throwable -> L13
        return r1;
    L13:
        th = move-exception;
        throw th;
    L16:
        th = move-exception;
        throw th;
    }

    private String calculateHexStringDigest(Key r3) {
        PoolableDigestContainer r0 = (PoolableDigestContainer) Preconditions.checkNotNull(this.digestPool.acquire());
        r3.updateDiskCacheKey(r0.messageDigest);     // Catch: Throwable -> L6
        String r4 = Util.sha256BytesToHex(r0.messageDigest.digest());     // Catch: Throwable -> L6
        this.digestPool.release(r0);
        return r4;
    L6:
        th = move-exception;
        this.digestPool.release(r0);
        throw th;
    }
}
