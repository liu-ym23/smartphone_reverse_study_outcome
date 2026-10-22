package androidx.lifecycle;

import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.internal.SafeIterableMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class MediatorLiveData<T> extends MutableLiveData<T> {
    private SafeIterableMap<LiveData<?>, Source<?>> mSources;

    public static class Source<V> implements Observer<V> {
        final LiveData<V> mLiveData;
        final Observer<? super V> mObserver;
        int mVersion;

        public Source(LiveData<V> r2, Observer<? super V> r3) {
            this.mVersion = -1;
            this.mLiveData = r2;
            this.mObserver = r3;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(@Nullable V r3) {
            if (this.mVersion == this.mLiveData.getVersion()) goto L6;
            this.mVersion = this.mLiveData.getVersion();
            this.mObserver.onChanged(r3);
            return;
        }

        public void plug() {
            this.mLiveData.observeForever(this);
        }

        public void unplug() {
            this.mLiveData.removeObserver(this);
        }
    }

    public MediatorLiveData() {
        this.mSources = new SafeIterableMap();
    }

    @MainThread
    public <S> void addSource(@NonNull LiveData<S> r3, @NonNull Observer<? super S> r4) {
        Source<?> r0 = new Source(r3, r4);
        Source<?> r5 = this.mSources.putIfAbsent(r3, r0);
        if (r5 != null) goto L5;
    L9:
        if (r5 == null) goto L12;
        return;
    L12:
        if (hasActiveObservers() == false) goto L15;
        r0.plug();
        return;
    L15:
        return;
    L5:
        if (r5.mObserver == r4) goto L9;
        throw new IllegalArgumentException("This source was already added with the different observer");
    }

    @Override // androidx.lifecycle.LiveData
    @CallSuper
    public void onActive() {
        Iterator<Map.Entry<LiveData<?>, Source<?>>> r1 = this.mSources.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().getValue().plug();
        goto L4
    }

    @Override // androidx.lifecycle.LiveData
    @CallSuper
    public void onInactive() {
        Iterator<Map.Entry<LiveData<?>, Source<?>>> r1 = this.mSources.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().getValue().unplug();
        goto L4
    }

    @MainThread
    public <S> void removeSource(@NonNull LiveData<S> r1) {
        Source<?> r0 = this.mSources.remove(r1);
        if (r0 == null) goto L6;
        r0.unplug();
        return;
    }
}
