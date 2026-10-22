package com.android.settings.slices;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.ArrayMap;
import com.obric.olog.OLog;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class SliceBackgroundWorker<E> implements Closeable {
    private static final Map<Uri, SliceBackgroundWorker> LIVE_WORKERS = null;
    private static final long SLICE_UPDATE_THROTTLE_INTERVAL = 300;
    private static final String TAG = "SliceBackgroundWorker";
    private List<E> mCachedResults;
    private final Context mContext;
    private final Uri mUri;

    private static class NotifySliceChangeHandler extends Handler {
        private static final int MSG_UPDATE_SLICE = 1000;
        private static NotifySliceChangeHandler sHandler;
        private final Map<Uri, Long> mLastUpdateTimeLookup;

        static /* synthetic */ NotifySliceChangeHandler access$000() {
            return getInstance();
        }

        static /* synthetic */ void access$100(NotifySliceChangeHandler r0, SliceBackgroundWorker r1) {
            r0.updateSlice(r1);
        }

        static /* synthetic */ void access$200(NotifySliceChangeHandler r0, SliceBackgroundWorker r1) {
            r0.cancelSliceUpdate(r1);
        }

        private static NotifySliceChangeHandler getInstance() {
            if (sHandler != null) goto L6;
            HandlerThread r0 = new HandlerThread("NotifySliceChangeHandler", 10);
            r0.start();
            sHandler = new NotifySliceChangeHandler(r0.getLooper());
        L6:
            return sHandler;
        }

        private NotifySliceChangeHandler(Looper r1) {
            super(r1);
            this.mLastUpdateTimeLookup = Collections.synchronizedMap(new ArrayMap());
        }

        @Override // android.os.Handler
        public void handleMessage(Message r4) {
            if (r4.what == 1000) goto L5;
            return;
        L5:
            SliceBackgroundWorker r5 = (SliceBackgroundWorker) r4.obj;
            Uri r0 = r5.getUri();
            Context r6 = r5.getContext();
            this.mLastUpdateTimeLookup.put(r0, Long.valueOf(SystemClock.uptimeMillis()));
            r6.getContentResolver().notifyChange(r0, null);
        }

        private void updateSlice(SliceBackgroundWorker r9) {
            if (hasMessages(1000, r9) == false) goto L5;
            return;
        L5:
            Message r0 = obtainMessage(1000, r9);
            long r4 = this.mLastUpdateTimeLookup.getOrDefault(r9.getUri(), 0L).longValue();
            if (r4 != 0) goto L9;
            sendMessageDelayed(r0, 300);
            return;
        L9:
            if ((SystemClock.uptimeMillis() - r4) <= 300) goto L11;
            sendMessage(r0);
            return;
        L11:
            sendMessageAtTime(r0, r4 + 300);
        }

        private void cancelSliceUpdate(SliceBackgroundWorker r2) {
            removeMessages(1000, r2);
            this.mLastUpdateTimeLookup.remove(r2.getUri());
        }
    }

    protected abstract void onSlicePinned();

    protected abstract void onSliceUnpinned();

    static {
        LIVE_WORKERS = new ArrayMap();
    }

    protected SliceBackgroundWorker(Context r1, Uri r2) {
        this.mContext = r1;
        this.mUri = r2;
    }

    protected Uri getUri() {
        return this.mUri;
    }

    protected Context getContext() {
        return this.mContext;
    }

    public static <T extends SliceBackgroundWorker> T getInstance(Uri r1) {
        return (T) LIVE_WORKERS.get(r1);
    }

    static SliceBackgroundWorker getInstance(Context r1, Sliceable r2, Uri r3) {
        SliceBackgroundWorker r0 = getInstance(r3);
        if (r0 != null) goto L6;
        Class<? extends SliceBackgroundWorker> r4 = r2.getBackgroundWorkerClass();
        SliceBackgroundWorker r5 = createInstance(r1.getApplicationContext(), r3, r4);
        LIVE_WORKERS.put(r3, r5);
        return r5;
    L6:
        return r0;
    }

    private static SliceBackgroundWorker createInstance(Context r5, Uri r6, Class<? extends SliceBackgroundWorker> r7) {
        OLog.d(TAG, "create instance: " + r7);
        return r7.getConstructor(new Class[]{Context.class, Uri.class}).newInstance(new Object[]{r5, r6});
    L5:
        e = move-exception;
        throw new IllegalStateException("Invalid slice background worker: " + r7, e);
    }

    static void shutdown() {
        Iterator<SliceBackgroundWorker> r0 = LIVE_WORKERS.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        r0.next().close();     // Catch: IOException -> L8
    L8:
        e = move-exception;
        OLog.w(TAG, "Shutting down worker failed", e);
        goto L4
    L10:
        LIVE_WORKERS.clear();
    }

    public final List<E> getResults() {
        if (this.mCachedResults != null) goto L6;
        return null;
    L6:
        return new ArrayList(this.mCachedResults);
    }

    protected final void updateResults(List<E> r3) {
        boolean r0 = true;
        if (r3 == null) goto L5;
        r0 = true ^ areListsTheSame(r3, this.mCachedResults);
    L9:
        if (r0 == false) goto L12;
        this.mCachedResults = r3;
        notifySliceChange();
        return;
    L12:
        return;
    L5:
        if (this.mCachedResults != null) goto L9;
        r0 = false;
        goto L9
    }

    protected boolean areListsTheSame(List<E> r1, List<E> r2) {
        return r1.equals(r2);
    }

    public final void notifySliceChange() {
        NotifySliceChangeHandler.access$100(NotifySliceChangeHandler.access$000(), this);
    }

    void pin() {
        onSlicePinned();
    }

    void unpin() {
        onSliceUnpinned();
        NotifySliceChangeHandler.access$200(NotifySliceChangeHandler.access$000(), this);
    }
}
