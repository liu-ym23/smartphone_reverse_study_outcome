package coil.memory;

import coil.util.Collections;
import com.bytedance.apm.constant.PerfConsts;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;

/* JADX INFO: compiled from: RealMemoryCache.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\tH\u0096\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\tH\u0016J\u0019\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0015H\u0096\u0002J\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\rH\u0016R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcoil/memory/RealMemoryCache;", "Lcoil/memory/MemoryCache;", "strongMemoryCache", "Lcoil/memory/StrongMemoryCache;", "weakMemoryCache", "Lcoil/memory/WeakMemoryCache;", "(Lcoil/memory/StrongMemoryCache;Lcoil/memory/WeakMemoryCache;)V", "keys", "", "Lcoil/memory/MemoryCache$Key;", "getKeys", "()Ljava/util/Set;", "maxSize", "", "getMaxSize", "()I", PerfConsts.PERF_DISK_FILE_SIZE, "getSize", "clear", "", "get", "Lcoil/memory/MemoryCache$Value;", "key", "remove", "", "set", "value", "trimMemory", "level", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RealMemoryCache implements MemoryCache {
    private final StrongMemoryCache strongMemoryCache;
    private final WeakMemoryCache weakMemoryCache;

    public RealMemoryCache(StrongMemoryCache r1, WeakMemoryCache r2) {
        this.strongMemoryCache = r1;
        this.weakMemoryCache = r2;
    }

    @Override // coil.memory.MemoryCache
    public int getSize() {
        return this.strongMemoryCache.getSize();
    }

    @Override // coil.memory.MemoryCache
    public int getMaxSize() {
        return this.strongMemoryCache.getMaxSize();
    }

    @Override // coil.memory.MemoryCache
    public Set<MemoryCache.Key> getKeys() {
        return SetsKt.plus(this.strongMemoryCache.getKeys(), this.weakMemoryCache.getKeys());
    }

    @Override // coil.memory.MemoryCache
    public MemoryCache.Value get(MemoryCache.Key r2) {
        MemoryCache.Value r0 = this.strongMemoryCache.get(r2);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return this.weakMemoryCache.get(r2);
    }

    @Override // coil.memory.MemoryCache
    public void set(MemoryCache.Key r4, MemoryCache.Value r5) {
        this.strongMemoryCache.set(MemoryCache.Key.copy$default(r4, null, Collections.toImmutableMap(r4.getExtras()), 1, null), r5.getBitmap(), Collections.toImmutableMap(r5.getExtras()));
    }

    @Override // coil.memory.MemoryCache
    public boolean remove(MemoryCache.Key r2) {
        boolean r0 = this.strongMemoryCache.remove(r2);
        boolean r1 = this.weakMemoryCache.remove(r2);
        if (r0 == true) goto L7;
        if (r1 == true) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // coil.memory.MemoryCache
    public void clear() {
        this.strongMemoryCache.clearMemory();
        this.weakMemoryCache.clearMemory();
    }

    @Override // coil.memory.MemoryCache
    public void trimMemory(int r2) {
        this.strongMemoryCache.trimMemory(r2);
        this.weakMemoryCache.trimMemory(r2);
    }
}
