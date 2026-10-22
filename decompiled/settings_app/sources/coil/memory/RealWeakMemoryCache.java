package coil.memory;

import android.graphics.Bitmap;
import com.bytedance.apm.constant.PerfConsts;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WeakMemoryCache.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0000\u0018\u0000 '2\u00020\u0001:\u0002'(B\u0005¢\u0006\u0002\u0010\u0002J\r\u0010\u0013\u001a\u00020\u0014H\u0001¢\u0006\u0002\b\u0015J\b\u0010\u0016\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u0014H\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J4\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001f2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#0!2\u0006\u0010$\u001a\u00020\u0012H\u0016J\u0010\u0010%\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\u0012H\u0016RX\u0010\u0003\u001a>\u0012\u0004\u0012\u00020\u0005\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b0\u0004j\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b`\t8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcoil/memory/RealWeakMemoryCache;", "Lcoil/memory/WeakMemoryCache;", "()V", "cache", "Ljava/util/LinkedHashMap;", "Lcoil/memory/MemoryCache$Key;", "Ljava/util/ArrayList;", "Lcoil/memory/RealWeakMemoryCache$InternalValue;", "Lkotlin/collections/ArrayList;", "Lkotlin/collections/LinkedHashMap;", "getCache$coil_base_release$annotations", "getCache$coil_base_release", "()Ljava/util/LinkedHashMap;", "keys", "", "getKeys", "()Ljava/util/Set;", "operationsSinceCleanUp", "", "cleanUp", "", "cleanUp$coil_base_release", "cleanUpIfNecessary", "clearMemory", "get", "Lcoil/memory/MemoryCache$Value;", "key", "remove", "", "set", "bitmap", "Landroid/graphics/Bitmap;", "extras", "", "", "", PerfConsts.PERF_DISK_FILE_SIZE, "trimMemory", "level", "Companion", "InternalValue", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RealWeakMemoryCache implements WeakMemoryCache {
    private static final int CLEAN_UP_INTERVAL = 10;
    public static final Companion Companion = null;
    private final LinkedHashMap<MemoryCache.Key, ArrayList<InternalValue>> cache;
    private int operationsSinceCleanUp;

    /* JADX INFO: compiled from: WeakMemoryCache.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcoil/memory/RealWeakMemoryCache$Companion;", "", "()V", "CLEAN_UP_INTERVAL", "", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: WeakMemoryCache.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\n\b\u0001\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcoil/memory/RealWeakMemoryCache$InternalValue;", "", "identityHashCode", "", "bitmap", "Ljava/lang/ref/WeakReference;", "Landroid/graphics/Bitmap;", "extras", "", "", PerfConsts.PERF_DISK_FILE_SIZE, "(ILjava/lang/ref/WeakReference;Ljava/util/Map;I)V", "getBitmap", "()Ljava/lang/ref/WeakReference;", "getExtras", "()Ljava/util/Map;", "getIdentityHashCode", "()I", "getSize", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class InternalValue {
        private final WeakReference<Bitmap> bitmap;
        private final Map<String, Object> extras;
        private final int identityHashCode;
        private final int size;

        public InternalValue(int r1, WeakReference<Bitmap> r2, Map<String, ? extends Object> r3, int r4) {
            this.identityHashCode = r1;
            this.bitmap = r2;
            this.extras = r3;
            this.size = r4;
        }

        public final int getIdentityHashCode() {
            return this.identityHashCode;
        }

        public final WeakReference<Bitmap> getBitmap() {
            return this.bitmap;
        }

        public final Map<String, Object> getExtras() {
            return this.extras;
        }

        public final int getSize() {
            return this.size;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ void getCache$coil_base_release$annotations() {
    }

    public RealWeakMemoryCache() {
        this.cache = new LinkedHashMap();
    }

    public final LinkedHashMap<MemoryCache.Key, ArrayList<InternalValue>> getCache$coil_base_release() {
        return this.cache;
    }

    @Override // coil.memory.WeakMemoryCache
    public synchronized Set<MemoryCache.Key> getKeys() {
        monitor-enter(this);
        Set<MemoryCache.Key> r0 = CollectionsKt.toSet(this.cache.keySet());     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // coil.memory.WeakMemoryCache
    public synchronized MemoryCache.Value get(MemoryCache.Key r7) {
        monitor-enter(this);
        ArrayList<InternalValue> r8 = this.cache.get(r7);     // Catch: Throwable -> L20
        MemoryCache.Value r0 = null;
        if (r8 != null) goto L8;
        monitor-exit(this);
        return null;
    L8:
        ArrayList<InternalValue> r9 = r8;     // Catch: Throwable -> L20
        int r1 = r9.size();     // Catch: Throwable -> L20
        int r2 = 0;
    L9:
        if (r2 >= r1) goto L17;
        InternalValue r3 = r9.get(r2);     // Catch: Throwable -> L20
        Bitmap r4 = r3.getBitmap().get();     // Catch: Throwable -> L20
        if (r4 == null) goto L13;
        MemoryCache.Value r5 = new MemoryCache.Value(r4, r3.getExtras());     // Catch: Throwable -> L20
    L14:
        if (r5 != null) goto L15;
        r2 = r2 + 1;     // Catch: Throwable -> L20
        goto L9
    L15:
        r0 = r5;
        goto L17
    L13:
        r5 = null;
    L17:
        cleanUpIfNecessary();     // Catch: Throwable -> L20
        monitor-exit(this);
        return r0;
    L20:
        th = move-exception;
        throw th;
    }

    @Override // coil.memory.WeakMemoryCache
    public synchronized void set(MemoryCache.Key r6, Bitmap r7, Map<String, ? extends Object> r8, int r9) {
        monitor-enter(this);
        LinkedHashMap<MemoryCache.Key, ArrayList<InternalValue>> r0 = this.cache;     // Catch: Throwable -> L21
        ArrayList<InternalValue> r1 = r0.get(r6);     // Catch: Throwable -> L21
        if (r1 != null) goto L6;
        r1 = new ArrayList();     // Catch: Throwable -> L21
        r0.put(r6, r1);     // Catch: Throwable -> L21
    L6:
        ArrayList<InternalValue> r2 = r1;     // Catch: Throwable -> L21
        RealWeakMemoryCache r10 = this;     // Catch: Throwable -> L21
        int r11 = System.identityHashCode(r7);     // Catch: Throwable -> L21
        InternalValue r3 = new InternalValue(r11, new WeakReference(r7), r8, r9);     // Catch: Throwable -> L21
        int r12 = r2.size();     // Catch: Throwable -> L21
        int r4 = 0;
    L7:
        if (r4 >= r12) goto L17;
        InternalValue r5 = r2.get(r4);     // Catch: Throwable -> L21
        if (r9 >= r5.getSize()) goto L11;
        r4 = r4 + 1;     // Catch: Throwable -> L21
        goto L7
    L11:
        if (r5.getIdentityHashCode() == r11) goto L13;
    L15:
        r2.add(r4, r3);     // Catch: Throwable -> L21
    L18:
        cleanUpIfNecessary();     // Catch: Throwable -> L21
        monitor-exit(this);
        return;
    L13:
        if (r5.getBitmap().get() != r7) goto L15;
        r2.set(r4, r3);     // Catch: Throwable -> L21
        goto L18
    L17:
        r2.add(r3);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    @Override // coil.memory.WeakMemoryCache
    public synchronized boolean remove(MemoryCache.Key r2) {
        monitor-enter(this);
        if (this.cache.remove(r2) == null) goto L6;
        boolean r3 = true;
    L7:
        monitor-exit(this);
        return r3;
    L6:
        r3 = false;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // coil.memory.WeakMemoryCache
    public synchronized void clearMemory() {
        monitor-enter(this);
        this.operationsSinceCleanUp = 0;     // Catch: Throwable -> L7
        this.cache.clear();     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // coil.memory.WeakMemoryCache
    public synchronized void trimMemory(int r2) {
        monitor-enter(this);
        if (r2 >= 10) goto L6;
    L12:
        monitor-exit(this);
        return;
    L6:
        if (r2 == 20) goto L12;
        cleanUp$coil_base_release();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    private final void cleanUpIfNecessary() {
        int r0 = this.operationsSinceCleanUp;
        this.operationsSinceCleanUp = r0 + 1;
        if (r0 < 10) goto L6;
        cleanUp$coil_base_release();
        return;
    }

    public final void cleanUp$coil_base_release() {
        this.operationsSinceCleanUp = 0;
        Iterator<ArrayList<InternalValue>> r9 = this.cache.values().iterator();
    L4:
        if (r9.hasNext() == false) goto L27;
        ArrayList<InternalValue> r1 = r9.next();
        if (r1.size() <= 1) goto L7;
        ArrayList<InternalValue> r2 = r1;
        int r4 = r2.size();
        int r5 = 0;
        int r6 = 0;
    L16:
        if (r5 >= r4) goto L25;
        int r7 = r5 - r6;
        if (r2.get(r7).getBitmap().get() != null) goto L20;
        boolean r8 = true;
    L21:
        if (r8 == false) goto L23;
        r2.remove(r7);
        r6 = r6 + 1;
    L23:
        r5 = r5 + 1;
        goto L16
    L20:
        r8 = false;
        goto L21
    L25:
        if (r1.isEmpty() == false) goto L4;
        r9.remove();
        goto L4
    L7:
        InternalValue r3 = (InternalValue) CollectionsKt.firstOrNull(r1);
        if (r3 == null) goto L12;
        WeakReference<Bitmap> r10 = r3.getBitmap();
        if (r10 == null) goto L12;
        Bitmap r11 = r10.get();
    L13:
        if (r11 != null) goto L4;
        r9.remove();
    L12:
        r11 = null;
        goto L13
    }
}
