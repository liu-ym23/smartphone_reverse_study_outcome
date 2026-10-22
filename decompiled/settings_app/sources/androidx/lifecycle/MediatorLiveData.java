package androidx.lifecycle;

import androidx.arch.core.internal.SafeIterableMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class MediatorLiveData<T> extends MutableLiveData<T> {
    private SafeIterableMap<LiveData<?>, Source<?>> mSources;

    private static class Source<V> implements Observer<V> {
        final LiveData<V> mLiveData;
        final Observer<? super V> mObserver;
        int mVersion;

        Source(LiveData<V> r2, Observer<? super V> r3) {
            this.mVersion = -1;
            this.mLiveData = r2;
            this.mObserver = r3;
        }

        void plug() {
            this.mLiveData.observeForever(this);
        }

        void unplug() {
            this.mLiveData.removeObserver(this);
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(V r3) {
            if (this.mVersion == this.mLiveData.getVersion()) goto L6;
            this.mVersion = this.mLiveData.getVersion();
            this.mObserver.onChanged(r3);
            return;
        }
    }

    public MediatorLiveData() {
        this.mSources = new SafeIterableMap();
    }

    public MediatorLiveData(T r1) {
        super(r1);
        this.mSources = new SafeIterableMap();
    }

    public <S> void addSource(LiveData<S> r3, Observer<? super S> r4) {
        if (r3 == null) goto L17;
        Source<?> r0 = new Source(r3, r4);
        Source<?> r5 = this.mSources.putIfAbsent(r3, r0);
        if (r5 != null) goto L6;
    L10:
        if (r5 == null) goto L13;
        return;
    L13:
        if (hasActiveObservers() == false) goto L18;
        r0.plug();
        return;
    L18:
        return;
    L6:
        if (r5.mObserver == r4) goto L10;
        throw new IllegalArgumentException("This source was already added with the different observer");
    L17:
        throw new NullPointerException("source cannot be null");
    }

    public <S> void removeSource(LiveData<S> r1) {
        Source<?> r0 = this.mSources.remove(r1);
        if (r0 == null) goto L6;
        r0.unplug();
        return;
    }

    @Override // androidx.lifecycle.LiveData
    protected void onActive() {
        Iterator<Map.Entry<LiveData<?>, Source<?>>> r1 = this.mSources.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().getValue().plug();
        goto L4
    }

    @Override // androidx.lifecycle.LiveData
    protected void onInactive() {
        Iterator<Map.Entry<LiveData<?>, Source<?>>> r1 = this.mSources.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().getValue().unplug();
        goto L4
    }
}
