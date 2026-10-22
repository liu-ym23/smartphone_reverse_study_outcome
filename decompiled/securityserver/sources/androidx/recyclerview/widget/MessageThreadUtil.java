package androidx.recyclerview.widget;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
class MessageThreadUtil<T> implements ThreadUtil<T> {

    /* JADX INFO: renamed from: androidx.recyclerview.widget.MessageThreadUtil$1, reason: invalid class name */
    public class AnonymousClass1 implements ThreadUtil.MainThreadCallback<T> {
        static final int ADD_TILE = 2;
        static final int REMOVE_TILE = 3;
        static final int UPDATE_ITEM_COUNT = 1;
        private final Handler mMainThreadHandler;
        private Runnable mMainThreadRunnable;
        final MessageQueue mQueue;
        final /* synthetic */ MessageThreadUtil this$0;
        final /* synthetic */ ThreadUtil.MainThreadCallback val$callback;

        public AnonymousClass1(MessageThreadUtil r1, ThreadUtil.MainThreadCallback r2) {
            this.this$0 = r1;
            this.val$callback = r2;
            this.mQueue = new MessageQueue();
            this.mMainThreadHandler = new Handler(Looper.getMainLooper());
            this.mMainThreadRunnable = new RunnableC00041(this);
        }

        private void sendMessage(SyncQueueItem r2) {
            this.mQueue.sendMessage(r2);
            this.mMainThreadHandler.post(this.mMainThreadRunnable);
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public void addTile(int r2, TileList.Tile<T> r3) {
            sendMessage(SyncQueueItem.obtainMessage(2, r2, r3));
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public void removeTile(int r2, int r3) {
            sendMessage(SyncQueueItem.obtainMessage(3, r2, r3));
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public void updateItemCount(int r2, int r3) {
            sendMessage(SyncQueueItem.obtainMessage(1, r2, r3));
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.MessageThreadUtil$2, reason: invalid class name */
    public class AnonymousClass2 implements ThreadUtil.BackgroundCallback<T> {
        static final int LOAD_TILE = 3;
        static final int RECYCLE_TILE = 4;
        static final int REFRESH = 1;
        static final int UPDATE_RANGE = 2;
        private Runnable mBackgroundRunnable;
        AtomicBoolean mBackgroundRunning;
        private final Executor mExecutor;
        final MessageQueue mQueue;
        final /* synthetic */ MessageThreadUtil this$0;
        final /* synthetic */ ThreadUtil.BackgroundCallback val$callback;

        public AnonymousClass2(MessageThreadUtil r1, ThreadUtil.BackgroundCallback r2) {
            this.this$0 = r1;
            this.val$callback = r2;
            this.mQueue = new MessageQueue();
            this.mExecutor = AsyncTask.THREAD_POOL_EXECUTOR;
            this.mBackgroundRunning = new AtomicBoolean(false);
            this.mBackgroundRunnable = new AnonymousClass1(this);
        }

        private void maybeExecuteBackgroundRunnable() {
            if (this.mBackgroundRunning.compareAndSet(false, true) == false) goto L6;
            this.mExecutor.execute(this.mBackgroundRunnable);
            return;
        }

        private void sendMessage(SyncQueueItem r2) {
            this.mQueue.sendMessage(r2);
            maybeExecuteBackgroundRunnable();
        }

        private void sendMessageAtFrontOfQueue(SyncQueueItem r2) {
            this.mQueue.sendMessageAtFrontOfQueue(r2);
            maybeExecuteBackgroundRunnable();
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void loadTile(int r2, int r3) {
            sendMessage(SyncQueueItem.obtainMessage(3, r2, r3));
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void recycleTile(TileList.Tile<T> r3) {
            sendMessage(SyncQueueItem.obtainMessage(4, 0, r3));
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void refresh(int r3) {
            sendMessageAtFrontOfQueue(SyncQueueItem.obtainMessage(1, r3, null));
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void updateRange(int r8, int r9, int r10, int r11, int r12) {
            sendMessageAtFrontOfQueue(SyncQueueItem.obtainMessage(2, r8, r9, r10, r11, r12, null));
        }
    }

    public static class MessageQueue {
        private SyncQueueItem mRoot;

        public MessageQueue() {
        }

        public synchronized SyncQueueItem next() {
            monitor-enter(this);
            SyncQueueItem r0 = this.mRoot;     // Catch: Throwable -> L11
            if (r0 != null) goto L8;
            monitor-exit(this);
            return null;
        L8:
            this.mRoot = r0.next;     // Catch: Throwable -> L11
            monitor-exit(this);
            return r0;
        L11:
            th = move-exception;
            throw th;
        }

        public synchronized void removeMessages(int r5) {
            monitor-enter(this);
        L23:
            SyncQueueItem r0 = this.mRoot;     // Catch: Throwable -> L8
            if (r0 == null) goto L10;
            if (r0.what != r5) goto L10;
            this.mRoot = r0.next;     // Catch: Throwable -> L8
            r0.recycle();     // Catch: Throwable -> L8
        L10:
            if (r0 == null) goto L19;
            SyncQueueItem r1 = r0.next;     // Catch: Throwable -> L8
        L12:
            if (r1 == null) goto L19;
            SyncQueueItem r2 = r1.next;     // Catch: Throwable -> L8
            if (r1.what != r5) goto L17;
            r0.next = r2;     // Catch: Throwable -> L8
            r1.recycle();     // Catch: Throwable -> L8
        L18:
            r1 = r2;
            goto L12
        L17:
            r0 = r1;
        L19:
            monitor-exit(this);
            return;
        L8:
            th = move-exception;
            throw th;
        }

        public synchronized void sendMessage(SyncQueueItem r3) {
            monitor-enter(this);
            SyncQueueItem r0 = this.mRoot;     // Catch: Throwable -> L8
            if (r0 != null) goto L10;
            this.mRoot = r3;     // Catch: Throwable -> L8
            monitor-exit(this);
            return;
        L10:
            SyncQueueItem r1 = r0.next;     // Catch: Throwable -> L8
            if (r1 == null) goto L13;
            r0 = r1;
            goto L10
        L13:
            r0.next = r3;     // Catch: Throwable -> L8
            monitor-exit(this);
            return;
        L8:
            th = move-exception;
            throw th;
        }

        public synchronized void sendMessageAtFrontOfQueue(SyncQueueItem r2) {
            monitor-enter(this);
            r2.next = this.mRoot;     // Catch: Throwable -> L6
            this.mRoot = r2;     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }
    }

    public static class SyncQueueItem {
        private static SyncQueueItem sPool;
        private static final Object sPoolLock = null;
        public int arg1;
        public int arg2;
        public int arg3;
        public int arg4;
        public int arg5;
        public Object data;
        SyncQueueItem next;
        public int what;

        static {
            sPoolLock = new Object();
        }

        public SyncQueueItem() {
        }

        public static SyncQueueItem obtainMessage(int r3, int r4, int r5, int r6, int r7, int r8, Object r9) {
            Object r0 = sPoolLock;
            monitor-enter(r0);
            SyncQueueItem r1 = sPool;     // Catch: Throwable -> L7
            if (r1 != null) goto L9;
            r1 = new SyncQueueItem();     // Catch: Throwable -> L7
        L10:
            r1.what = r3;     // Catch: Throwable -> L7
            r1.arg1 = r4;     // Catch: Throwable -> L7
            r1.arg2 = r5;     // Catch: Throwable -> L7
            r1.arg3 = r6;     // Catch: Throwable -> L7
            r1.arg4 = r7;     // Catch: Throwable -> L7
            r1.arg5 = r8;     // Catch: Throwable -> L7
            r1.data = r9;     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L9:
            sPool = r1.next;     // Catch: Throwable -> L7
            r1.next = null;     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            throw th;
        }

        public void recycle() {
            this.next = null;
            this.arg5 = 0;
            this.arg4 = 0;
            this.arg3 = 0;
            this.arg2 = 0;
            this.arg1 = 0;
            this.what = 0;
            this.data = null;
            Object r0 = sPoolLock;
            monitor-enter(r0);
            SyncQueueItem r1 = sPool;     // Catch: Throwable -> L7
            if (r1 == null) goto L9;
            this.next = r1;     // Catch: Throwable -> L7
        L9:
            sPool = this;     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public static SyncQueueItem obtainMessage(int r7, int r8, int r9) {
            return obtainMessage(r7, r8, r9, 0, 0, 0, null);
        }

        public static SyncQueueItem obtainMessage(int r7, int r8, Object r9) {
            return obtainMessage(r7, r8, 0, 0, 0, 0, r9);
        }
    }

    public MessageThreadUtil() {
    }

    @Override // androidx.recyclerview.widget.ThreadUtil
    public ThreadUtil.BackgroundCallback<T> getBackgroundProxy(ThreadUtil.BackgroundCallback<T> r2) {
        return new AnonymousClass2(this, r2);
    }

    @Override // androidx.recyclerview.widget.ThreadUtil
    public ThreadUtil.MainThreadCallback<T> getMainThreadProxy(ThreadUtil.MainThreadCallback<T> r2) {
        return new AnonymousClass1(this, r2);
    }
}
