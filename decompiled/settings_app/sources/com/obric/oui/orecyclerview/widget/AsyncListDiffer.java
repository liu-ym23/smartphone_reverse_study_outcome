package com.obric.oui.orecyclerview.widget;

import android.os.Handler;
import android.os.Looper;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public class AsyncListDiffer<T> {
    private static final Executor sMainThreadExecutor = null;
    final AsyncDifferConfig<T> mConfig;
    private List<T> mList;
    private final List<ListListener<T>> mListeners;
    Executor mMainThreadExecutor;
    int mMaxScheduledGeneration;
    private List<T> mReadOnlyList;
    private final ListUpdateCallback mUpdateCallback;

    public interface ListListener<T> {
        void onCurrentListChanged(List<T> r1, List<T> r2);
    }

    private static class MainThreadExecutor implements Executor {
        final Handler mHandler;

        MainThreadExecutor() {
            this.mHandler = new Handler(Looper.getMainLooper());
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r1) {
            this.mHandler.post(r1);
        }
    }

    static {
        sMainThreadExecutor = new MainThreadExecutor();
    }

    public AsyncListDiffer(RecyclerView.Adapter r2, DiffUtil.ItemCallback<T> r3) {
        this(new AdapterListUpdateCallback(r2), new AsyncDifferConfig.Builder(r3).build());
    }

    public AsyncListDiffer(ListUpdateCallback r2, AsyncDifferConfig<T> r3) {
        this.mListeners = new CopyOnWriteArrayList();
        this.mReadOnlyList = Collections.emptyList();
        this.mUpdateCallback = r2;
        this.mConfig = r3;
        if (r3.getMainThreadExecutor() == null) goto L5;
        this.mMainThreadExecutor = r3.getMainThreadExecutor();
        return;
    L5:
        this.mMainThreadExecutor = sMainThreadExecutor;
    }

    public List<T> getCurrentList() {
        return this.mReadOnlyList;
    }

    public void submitList(List<T> r2) {
        submitList(r2, null);
    }

    public void submitList(final List<T> r9, final Runnable r10) {
        final int r5 = this.mMaxScheduledGeneration + 1;
        this.mMaxScheduledGeneration = r5;
        final List<T> r3 = this.mList;
        if (r9 != r3) goto L7;
        if (r10 == null) goto L16;
        r10.run();
        return;
    L16:
        return;
    L7:
        List<T> r0 = this.mReadOnlyList;
        if (r9 != null) goto L11;
        int r11 = r3.size();
        this.mList = null;
        this.mReadOnlyList = Collections.emptyList();
        this.mUpdateCallback.onRemoved(0, r11);
        onCurrentListChanged(r0, r10);
        return;
    L11:
        if (r3 != null) goto L14;
        this.mList = r9;
        this.mReadOnlyList = Collections.unmodifiableList(r9);
        this.mUpdateCallback.onInserted(0, r9.size());
        onCurrentListChanged(r0, r10);
        return;
    L14:
        this.mConfig.getBackgroundThreadExecutor().execute(new AnonymousClass1(this, r3, r9, r5, r10));
    }

    void latchList(List<T> r2, DiffUtil.DiffResult r3, Runnable r4) {
        List<T> r0 = this.mReadOnlyList;
        this.mList = r2;
        this.mReadOnlyList = Collections.unmodifiableList(r2);
        r3.dispatchUpdatesTo(this.mUpdateCallback);
        onCurrentListChanged(r0, r4);
    }

    private void onCurrentListChanged(List<T> r4, Runnable r5) {
        Iterator<ListListener<T>> r0 = this.mListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onCurrentListChanged(r4, this.mReadOnlyList);
        goto L4
    L6:
        if (r5 == null) goto L10;
        r5.run();
        return;
    }

    public void addListListener(ListListener<T> r1) {
        this.mListeners.add(r1);
    }

    public void removeListListener(ListListener<T> r1) {
        this.mListeners.remove(r1);
    }
}
