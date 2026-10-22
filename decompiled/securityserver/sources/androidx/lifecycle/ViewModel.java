package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class ViewModel {

    @Nullable
    private final Map<String, Object> mBagOfTags;
    private volatile boolean mCleared;

    public ViewModel() {
        this.mBagOfTags = new HashMap();
        this.mCleared = false;
    }

    private static void closeWithRuntimeException(Object r1) {
        if ((r1 instanceof Closeable) == true) goto L10;
        return;
    L10:
        ((Closeable) r1).close();     // Catch: IOException -> L6
        return;
    L6:
        e = move-exception;
        throw new RuntimeException(e);
    }

    @MainThread
    public final void clear() {
        this.mCleared = true;
        Map<String, Object> r0 = this.mBagOfTags;
        if (r0 == null) goto L15;
        monitor-enter(r0);
        Iterator<Object> r1 = this.mBagOfTags.values().iterator();     // Catch: Throwable -> L9
    L7:
        if (r1.hasNext() == false) goto L11;
        closeWithRuntimeException(r1.next());     // Catch: Throwable -> L9
        goto L7
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L15:
        onCleared();
    }

    public <T> T getTag(String r2) {
        Map<String, Object> r0 = this.mBagOfTags;
        monitor-enter(r0);
        T r1 = (T) this.mBagOfTags.get(r2);
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void onCleared() {
    }

    public <T> T setTagIfAbsent(String r4, T r5) {
        Map<String, Object> r0 = this.mBagOfTags;
        monitor-enter(r0);
        Object r1 = this.mBagOfTags.get(r4);     // Catch: Throwable -> L7
        if (r1 != null) goto L9;
        this.mBagOfTags.put(r4, r5);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        if (r1 == null) goto L14;
        r5 = (T) r1;
    L14:
        if (this.mCleared == false) goto L16;
        closeWithRuntimeException(r5);
    L16:
        return r5;
    L7:
        th = move-exception;
        throw th;
    }
}
