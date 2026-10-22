package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;

/* JADX INFO: loaded from: classes.dex */
public class Transformations {
    private Transformations() {
    }

    @NonNull
    @MainThread
    public static <X> LiveData<X> distinctUntilChanged(@NonNull LiveData<X> r2) {
        final MediatorLiveData r0 = new MediatorLiveData();
        r0.addSource(r2, new AnonymousClass3(r0));
        return r0;
    }

    @NonNull
    @MainThread
    public static <X, Y> LiveData<Y> map(@NonNull LiveData<X> r2, @NonNull final Function<X, Y> r3) {
        final MediatorLiveData r0 = new MediatorLiveData();
        r0.addSource(r2, new AnonymousClass1(r0, r3));
        return r0;
    }

    @NonNull
    @MainThread
    public static <X, Y> LiveData<Y> switchMap(@NonNull LiveData<X> r2, @NonNull final Function<X, LiveData<Y>> r3) {
        final MediatorLiveData r0 = new MediatorLiveData();
        r0.addSource(r2, new AnonymousClass2(r3, r0));
        return r0;
    }
}
