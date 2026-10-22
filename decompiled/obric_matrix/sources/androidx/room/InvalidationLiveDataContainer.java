package androidx.room;

import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.LiveData;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
class InvalidationLiveDataContainer {
    private final RoomDatabase mDatabase;

    @VisibleForTesting
    final Set<LiveData> mLiveDataSet;

    InvalidationLiveDataContainer(RoomDatabase r2) {
        this.mLiveDataSet = Collections.newSetFromMap(new IdentityHashMap());
        this.mDatabase = r2;
    }

    <T> LiveData<T> create(String[] r8, boolean r9, Callable<T> r10) {
        return new RoomTrackingLiveData(this.mDatabase, this, r9, r10, r8);
    }

    void onActive(LiveData r1) {
        this.mLiveDataSet.add(r1);
    }

    void onInactive(LiveData r1) {
        this.mLiveDataSet.remove(r1);
    }
}
