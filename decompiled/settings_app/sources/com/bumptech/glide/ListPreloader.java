package com.bumptech.glide;

import android.graphics.drawable.Drawable;
import android.widget.AbsListView;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Util;
import java.util.List;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
public class ListPreloader<T> implements AbsListView.OnScrollListener {
    private boolean isIncreasing;
    private int lastEnd;
    private int lastFirstVisible;
    private int lastStart;
    private final int maxPreload;
    private final PreloadSizeProvider<T> preloadDimensionProvider;
    private final PreloadModelProvider<T> preloadModelProvider;
    private final PreloadTargetQueue preloadTargetQueue;
    private final RequestManager requestManager;
    private int totalItemCount;

    public interface PreloadModelProvider<U> {
        List<U> getPreloadItems(int r1);

        RequestBuilder<?> getPreloadRequestBuilder(U r1);
    }

    public interface PreloadSizeProvider<T> {
        int[] getPreloadSize(T r1, int r2, int r3);
    }

    private static final class PreloadTarget implements Target<Object> {
        int photoHeight;
        int photoWidth;
        private Request request;

        @Override // com.bumptech.glide.manager.LifecycleListener
        public void onDestroy() {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadCleared(Drawable r1) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadFailed(Drawable r1) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadStarted(Drawable r1) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onResourceReady(Object r1, Transition<? super Object> r2) {
        }

        @Override // com.bumptech.glide.manager.LifecycleListener
        public void onStart() {
        }

        @Override // com.bumptech.glide.manager.LifecycleListener
        public void onStop() {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void removeCallback(SizeReadyCallback r1) {
        }

        PreloadTarget() {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void getSize(SizeReadyCallback r2) {
            r2.onSizeReady(this.photoWidth, this.photoHeight);
        }

        @Override // com.bumptech.glide.request.target.Target
        public void setRequest(Request r1) {
            this.request = r1;
        }

        @Override // com.bumptech.glide.request.target.Target
        public Request getRequest() {
            return this.request;
        }
    }

    private static final class PreloadTargetQueue {
        final Queue<PreloadTarget> queue;

        PreloadTargetQueue(int r4) {
            this.queue = Util.createQueue(r4);
            int r0 = 0;
        L3:
            if (r0 >= r4) goto L5;
            this.queue.offer(new PreloadTarget());
            r0 = r0 + 1;
            goto L3
        }

        public PreloadTarget next(int r2, int r3) {
            PreloadTarget r0 = this.queue.poll();
            this.queue.offer(r0);
            r0.photoWidth = r2;
            r0.photoHeight = r3;
            return r0;
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView r1, int r2) {
    }

    public ListPreloader(RequestManager r2, PreloadModelProvider<T> r3, PreloadSizeProvider<T> r4, int r5) {
        this.lastFirstVisible = -1;
        this.isIncreasing = true;
        this.requestManager = r2;
        this.preloadModelProvider = r3;
        this.preloadDimensionProvider = r4;
        this.maxPreload = r5;
        this.preloadTargetQueue = new PreloadTargetQueue(r5 + 1);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView r1, int r2, int r3, int r4) {
        if (this.totalItemCount != 0) goto L6;
        if (r4 != 0) goto L6;
        return;
    L6:
        this.totalItemCount = r4;
        int r5 = this.lastFirstVisible;
        if (r2 <= r5) goto L9;
        preload(r3 + r2, true);
    L11:
        this.lastFirstVisible = r2;
        return;
    L9:
        if (r2 >= r5) goto L11;
        preload(r2, false);
        goto L11
    }

    private void preload(int r2, boolean r3) {
        if (this.isIncreasing == r3) goto L5;
        this.isIncreasing = r3;
        cancelAll();
    L5:
        if (r3 == false) goto L7;
        int r4 = this.maxPreload;
    L8:
        preload(r2, r4 + r2);
        return;
    L7:
        r4 = -this.maxPreload;
        goto L8
    }

    private void preload(int r5, int r6) {
        if (r5 >= r6) goto L4;
        int r1 = Math.max(this.lastEnd, r5);
        int r0 = r6;
    L5:
        int r2 = Math.min(this.totalItemCount, r0);
        int r3 = Math.min(this.totalItemCount, Math.max(0, r1));
        if (r5 >= r6) goto L10;
        int r7 = r3;
    L8:
        if (r7 >= r2) goto L13;
        preloadAdapterPosition(this.preloadModelProvider.getPreloadItems(r7), r7, true);
        r7 = r7 + 1;
    L13:
        this.lastStart = r3;
        this.lastEnd = r2;
        return;
    L10:
        int r8 = r2 - 1;
    L11:
        if (r8 < r3) goto L13;
        preloadAdapterPosition(this.preloadModelProvider.getPreloadItems(r8), r8, false);
        r8 = r8 - 1;
        goto L11
    L4:
        r0 = Math.min(this.lastStart, r5);
        r1 = r6;
        goto L5
    }

    private void preloadAdapterPosition(List<T> r3, int r4, boolean r5) {
        int r0 = r3.size();
        if (r5 == false) goto L7;
        int r6 = 0;
    L5:
        if (r6 >= r0) goto L10;
        preloadItem(r3.get(r6), r4, r6);
        r6 = r6 + 1;
        goto L5
    L10:
        return;
    L7:
        int r1 = r0 - 1;
    L8:
        if (r1 < 0) goto L13;
        preloadItem(r3.get(r1), r4, r1);
        r1 = r1 - 1;
        goto L8
    }

    private void preloadItem(T r2, int r3, int r4) {
        if (r2 != null) goto L4;
        return;
    L4:
        int[] r5 = this.preloadDimensionProvider.getPreloadSize(r2, r3, r4);
        if (r5 != null) goto L7;
        return;
    L7:
        RequestBuilder<?> r6 = this.preloadModelProvider.getPreloadRequestBuilder(r2);
        if (r6 != null) goto L10;
        return;
    L10:
        r6.into(this.preloadTargetQueue.next(r5[0], r5[1]));
    }

    private void cancelAll() {
        int r1 = 0;
    L4:
        if (r1 >= this.preloadTargetQueue.queue.size()) goto L6;
        this.requestManager.clear(this.preloadTargetQueue.next(0, 0));
        r1 = r1 + 1;
        goto L4
    }
}
