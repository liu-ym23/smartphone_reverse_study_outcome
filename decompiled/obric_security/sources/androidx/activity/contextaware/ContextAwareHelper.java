package androidx.activity.contextaware;

import android.content.Context;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes.dex */
public final class ContextAwareHelper {
    private volatile Context mContext;
    private final Set<OnContextAvailableListener> mListeners;

    public ContextAwareHelper() {
        this.mListeners = new CopyOnWriteArraySet();
    }

    public Context peekAvailableContext() {
        return this.mContext;
    }

    public void addOnContextAvailableListener(OnContextAvailableListener r2) {
        if (this.mContext == null) goto L5;
        r2.onContextAvailable(this.mContext);
    L5:
        this.mListeners.add(r2);
    }

    public void removeOnContextAvailableListener(OnContextAvailableListener r1) {
        this.mListeners.remove(r1);
    }

    public void dispatchOnContextAvailable(Context r2) {
        this.mContext = r2;
        Iterator<OnContextAvailableListener> r1 = this.mListeners.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().onContextAvailable(r2);
        goto L4
    }

    public void clearAvailableContext() {
        this.mContext = null;
    }
}
