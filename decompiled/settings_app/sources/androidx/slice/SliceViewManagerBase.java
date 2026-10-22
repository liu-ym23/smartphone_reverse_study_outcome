package androidx.slice;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.ArrayMap;
import android.util.Pair;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public abstract class SliceViewManagerBase extends SliceViewManager {
    protected final Context mContext;
    private final ArrayMap<Pair<Uri, SliceViewManager.SliceCallback>, SliceListenerImpl> mListenerLookup;

    private class SliceListenerImpl {
        final SliceViewManager.SliceCallback mCallback;
        final Executor mExecutor;
        private final ContentObserver mObserver;
        private boolean mPinned;
        final Runnable mUpdateSlice;
        Uri mUri;
        final /* synthetic */ SliceViewManagerBase this$0;

        SliceListenerImpl(SliceViewManagerBase r3, Uri r4, Executor r5, SliceViewManager.SliceCallback r6) {
            this.this$0 = r3;
            this.mUpdateSlice = new AnonymousClass1(this);
            final Handler r0 = new Handler(Looper.getMainLooper());
            this.mObserver = new AnonymousClass2(this, r0);
            this.mUri = r4;
            this.mExecutor = r5;
            this.mCallback = r6;
        }

        void startListening() {
            this.this$0.mContext.getContentResolver().registerContentObserver(this.mUri, true, this.mObserver);
            tryPin();
        }

        void tryPin() {
            if (this.mPinned == true) goto L9;
            this.this$0.pinSlice(this.mUri);     // Catch: SecurityException -> L6
            this.mPinned = true;     // Catch: SecurityException -> L6
            return;
        L10:
            return;
        }

        void stopListening() {
            this.this$0.mContext.getContentResolver().unregisterContentObserver(this.mObserver);
            if (this.mPinned == false) goto L6;
            this.this$0.unpinSlice(this.mUri);
            this.mPinned = false;
            return;
        }
    }

    SliceViewManagerBase(Context r2) {
        this.mListenerLookup = new ArrayMap();
        this.mContext = r2;
    }

    @Override // androidx.slice.SliceViewManager
    public void registerSliceCallback(Uri r3, SliceViewManager.SliceCallback r4) {
        final Handler r0 = new Handler(Looper.getMainLooper());
        registerSliceCallback(r3, new AnonymousClass1(this, r0), r4);
    }

    @Override // androidx.slice.SliceViewManager
    public void registerSliceCallback(Uri r2, Executor r3, SliceViewManager.SliceCallback r4) {
        getListener(r2, r4, new SliceListenerImpl(this, r2, r3, r4)).startListening();
    }

    @Override // androidx.slice.SliceViewManager
    public void unregisterSliceCallback(Uri r3, SliceViewManager.SliceCallback r4) {
        ArrayMap<Pair<Uri, SliceViewManager.SliceCallback>, SliceListenerImpl> r0 = this.mListenerLookup;
        monitor-enter(r0);
        SliceListenerImpl r2 = this.mListenerLookup.remove(new Pair(r3, r4));     // Catch: Throwable -> L9
        if (r2 == null) goto L7;
        r2.stopListening();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private SliceListenerImpl getListener(Uri r2, SliceViewManager.SliceCallback r3, SliceListenerImpl r4) {
        Pair<Uri, SliceViewManager.SliceCallback> r0 = new Pair(r2, r3);
        ArrayMap<Pair<Uri, SliceViewManager.SliceCallback>, SliceListenerImpl> r5 = this.mListenerLookup;
        monitor-enter(r5);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mListenerLookup.containsKey(r0) == false) goto L7;
        this.mListenerLookup.get(r0).stopListening();     // Catch: Throwable -> L10
    L7:
        this.mListenerLookup.put(r0, r4);     // Catch: Throwable -> L10
        monitor-exit(r5);     // Catch: Throwable -> L10
        return r4;
    }
}
