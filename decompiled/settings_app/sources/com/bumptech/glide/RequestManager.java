package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.manager.ConnectivityMonitor;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.LifecycleListener;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.bumptech.glide.manager.RequestTracker;
import com.bumptech.glide.manager.TargetTracker;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomViewTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: loaded from: classes.dex */
public class RequestManager implements ComponentCallbacks2, LifecycleListener, ModelTypes<RequestBuilder<Drawable>> {
    private static final RequestOptions DECODE_TYPE_BITMAP = null;
    private static final RequestOptions DECODE_TYPE_GIF = null;
    private static final RequestOptions DOWNLOAD_ONLY_OPTIONS = null;
    private final Runnable addSelfToLifecycle;
    private boolean clearOnStop;
    private final ConnectivityMonitor connectivityMonitor;
    protected final Context context;
    private final CopyOnWriteArrayList<RequestListener<Object>> defaultRequestListeners;
    protected final Glide glide;
    final Lifecycle lifecycle;
    private boolean pauseAllRequestsOnTrimMemoryModerate;
    private RequestOptions requestOptions;
    private final RequestTracker requestTracker;
    private final TargetTracker targetTracker;
    private final RequestManagerTreeNode treeNode;

    private static class ClearTarget extends CustomViewTarget<View, Object> {
        @Override // com.bumptech.glide.request.target.Target
        public void onLoadFailed(Drawable r1) {
        }

        @Override // com.bumptech.glide.request.target.CustomViewTarget
        protected void onResourceCleared(Drawable r1) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onResourceReady(Object r1, Transition<? super Object> r2) {
        }

        ClearTarget(View r1) {
            super(r1);
        }
    }

    private class RequestManagerConnectivityListener implements ConnectivityMonitor.ConnectivityListener {
        private final RequestTracker requestTracker;
        final /* synthetic */ RequestManager this$0;

        RequestManagerConnectivityListener(RequestManager r1, RequestTracker r2) {
            this.this$0 = r1;
            this.requestTracker = r2;
        }

        @Override // com.bumptech.glide.manager.ConnectivityMonitor.ConnectivityListener
        public void onConnectivityChanged(boolean r1) {
            if (r1 == false) goto L11;
            RequestManager r2 = this.this$0;
            monitor-enter(r2);
            this.requestTracker.restartRequests();     // Catch: Throwable -> L8
            monitor-exit(r2);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r1) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    @Override // com.bumptech.glide.ModelTypes
    public /* bridge */ /* synthetic */ RequestBuilder<Drawable> load(Bitmap r1) {
        return load(r1);
    }

    @Override // com.bumptech.glide.ModelTypes
    public /* bridge */ /* synthetic */ RequestBuilder<Drawable> load(Drawable r1) {
        return load(r1);
    }

    @Override // com.bumptech.glide.ModelTypes
    public /* bridge */ /* synthetic */ RequestBuilder<Drawable> load(Uri r1) {
        return load(r1);
    }

    @Override // com.bumptech.glide.ModelTypes
    public /* bridge */ /* synthetic */ RequestBuilder<Drawable> load(File r1) {
        return load(r1);
    }

    @Override // com.bumptech.glide.ModelTypes
    public /* bridge */ /* synthetic */ RequestBuilder<Drawable> load(Integer r1) {
        return load(r1);
    }

    @Override // com.bumptech.glide.ModelTypes
    public /* bridge */ /* synthetic */ RequestBuilder<Drawable> load(Object r1) {
        return load(r1);
    }

    @Override // com.bumptech.glide.ModelTypes
    public /* bridge */ /* synthetic */ RequestBuilder<Drawable> load(String r1) {
        return load(r1);
    }

    @Override // com.bumptech.glide.ModelTypes
    @Deprecated
    public /* bridge */ /* synthetic */ RequestBuilder<Drawable> load(URL r1) {
        return load(r1);
    }

    @Override // com.bumptech.glide.ModelTypes
    public /* bridge */ /* synthetic */ RequestBuilder<Drawable> load(byte[] r1) {
        return load(r1);
    }

    static {
        DECODE_TYPE_BITMAP = RequestOptions.decodeTypeOf(Bitmap.class).lock();
        DECODE_TYPE_GIF = RequestOptions.decodeTypeOf(GifDrawable.class).lock();
        DOWNLOAD_ONLY_OPTIONS = RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.DATA).priority(Priority.LOW).skipMemoryCache(true);
    }

    public RequestManager(Glide r8, Lifecycle r9, RequestManagerTreeNode r10, Context r11) {
        this(r8, r9, r10, new RequestTracker(), r8.getConnectivityMonitorFactory(), r11);
    }

    RequestManager(Glide r2, Lifecycle r3, RequestManagerTreeNode r4, RequestTracker r5, ConnectivityMonitorFactory r6, Context r7) {
        this.targetTracker = new TargetTracker();
        Runnable r0 = new AnonymousClass1(this);
        this.addSelfToLifecycle = r0;
        this.glide = r2;
        this.lifecycle = r3;
        this.treeNode = r4;
        this.requestTracker = r5;
        this.context = r7;
        ConnectivityMonitor r8 = r6.build(r7.getApplicationContext(), new RequestManagerConnectivityListener(this, r5));
        this.connectivityMonitor = r8;
        r2.registerRequestManager(this);
        if (Util.isOnBackgroundThread() == false) goto L5;
        Util.postOnUiThread(r0);
    L6:
        r3.addListener(r8);
        this.defaultRequestListeners = new CopyOnWriteArrayList(r2.getGlideContext().getDefaultRequestListeners());
        setRequestOptions(r2.getGlideContext().getDefaultRequestOptions());
        return;
    L5:
        r3.addListener(this);
        goto L6
    }

    protected synchronized void setRequestOptions(RequestOptions r1) {
        monitor-enter(this);
        this.requestOptions = r1.clone().autoClone();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private synchronized void updateRequestOptions(RequestOptions r2) {
        monitor-enter(this);
        this.requestOptions = this.requestOptions.apply(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized RequestManager applyDefaultRequestOptions(RequestOptions r1) {
        monitor-enter(this);
        updateRequestOptions(r1);     // Catch: Throwable -> L6
        monitor-exit(this);
        return this;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized RequestManager setDefaultRequestOptions(RequestOptions r1) {
        monitor-enter(this);
        setRequestOptions(r1);     // Catch: Throwable -> L6
        monitor-exit(this);
        return this;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized RequestManager clearOnStop() {
        monitor-enter(this);
        this.clearOnStop = true;     // Catch: Throwable -> L7
        monitor-exit(this);
        return this;
    L7:
        th = move-exception;
        throw th;
    }

    public RequestManager addDefaultRequestListener(RequestListener<Object> r2) {
        this.defaultRequestListeners.add(r2);
        return this;
    }

    public void setPauseAllRequestsOnTrimMemoryModerate(boolean r1) {
        this.pauseAllRequestsOnTrimMemoryModerate = r1;
    }

    public synchronized boolean isPaused() {
        monitor-enter(this);
        boolean r0 = this.requestTracker.isPaused();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void pauseRequests() {
        monitor-enter(this);
        this.requestTracker.pauseRequests();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void pauseAllRequests() {
        monitor-enter(this);
        this.requestTracker.pauseAllRequests();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void pauseAllRequestsRecursive() {
        monitor-enter(this);
        pauseAllRequests();     // Catch: Throwable -> L10
        Iterator<RequestManager> r0 = this.treeNode.getDescendants().iterator();     // Catch: Throwable -> L10
    L5:
        if (r0.hasNext() == false) goto L8;
        r0.next().pauseAllRequests();     // Catch: Throwable -> L10
        goto L5
    L8:
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public synchronized void pauseRequestsRecursive() {
        monitor-enter(this);
        pauseRequests();     // Catch: Throwable -> L10
        Iterator<RequestManager> r0 = this.treeNode.getDescendants().iterator();     // Catch: Throwable -> L10
    L5:
        if (r0.hasNext() == false) goto L8;
        r0.next().pauseRequests();     // Catch: Throwable -> L10
        goto L5
    L8:
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public synchronized void resumeRequests() {
        monitor-enter(this);
        this.requestTracker.resumeRequests();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void resumeRequestsRecursive() {
        monitor-enter(this);
        Util.assertMainThread();     // Catch: Throwable -> L10
        resumeRequests();     // Catch: Throwable -> L10
        Iterator<RequestManager> r0 = this.treeNode.getDescendants().iterator();     // Catch: Throwable -> L10
    L5:
        if (r0.hasNext() == false) goto L8;
        r0.next().resumeRequests();     // Catch: Throwable -> L10
        goto L5
    L8:
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public synchronized void onStart() {
        monitor-enter(this);
        resumeRequests();     // Catch: Throwable -> L6
        this.targetTracker.onStart();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public synchronized void onStop() {
        monitor-enter(this);
        this.targetTracker.onStop();     // Catch: Throwable -> L9
        if (this.clearOnStop == false) goto L6;
        clearRequests();     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L6:
        pauseRequests();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public synchronized void onDestroy() {
        monitor-enter(this);
        this.targetTracker.onDestroy();     // Catch: Throwable -> L6
        clearRequests();     // Catch: Throwable -> L6
        this.requestTracker.clearRequests();     // Catch: Throwable -> L6
        this.lifecycle.removeListener(this);     // Catch: Throwable -> L6
        this.lifecycle.removeListener(this.connectivityMonitor);     // Catch: Throwable -> L6
        Util.removeCallbacksOnUiThread(this.addSelfToLifecycle);     // Catch: Throwable -> L6
        this.glide.unregisterRequestManager(this);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public RequestBuilder<Bitmap> asBitmap() {
        return as(Bitmap.class).apply(DECODE_TYPE_BITMAP);
    }

    public RequestBuilder<GifDrawable> asGif() {
        return as(GifDrawable.class).apply(DECODE_TYPE_GIF);
    }

    public RequestBuilder<Drawable> asDrawable() {
        return as(Drawable.class);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.ModelTypes
    public RequestBuilder<Drawable> load(Bitmap r1) {
        return asDrawable().load(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.ModelTypes
    public RequestBuilder<Drawable> load(Drawable r1) {
        return asDrawable().load(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.ModelTypes
    public RequestBuilder<Drawable> load(String r1) {
        return asDrawable().load(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.ModelTypes
    public RequestBuilder<Drawable> load(Uri r1) {
        return asDrawable().load(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.ModelTypes
    public RequestBuilder<Drawable> load(File r1) {
        return asDrawable().load(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.ModelTypes
    public RequestBuilder<Drawable> load(Integer r1) {
        return asDrawable().load(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.ModelTypes
    @Deprecated
    public RequestBuilder<Drawable> load(URL r1) {
        return asDrawable().load(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.ModelTypes
    public RequestBuilder<Drawable> load(byte[] r1) {
        return asDrawable().load(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.ModelTypes
    public RequestBuilder<Drawable> load(Object r1) {
        return asDrawable().load(r1);
    }

    public RequestBuilder<File> downloadOnly() {
        return as(File.class).apply(DOWNLOAD_ONLY_OPTIONS);
    }

    public RequestBuilder<File> download(Object r1) {
        return downloadOnly().load(r1);
    }

    public RequestBuilder<File> asFile() {
        return as(File.class).apply(RequestOptions.skipMemoryCacheOf(true));
    }

    public <ResourceType> RequestBuilder<ResourceType> as(Class<ResourceType> r4) {
        return new RequestBuilder(this.glide, this, r4, this.context);
    }

    public void clear(View r2) {
        clear(new ClearTarget(r2));
    }

    public void clear(Target<?> r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        untrackOrDelegate(r1);
    }

    private void untrackOrDelegate(Target<?> r3) {
        boolean r0 = untrack(r3);
        Request r1 = r3.getRequest();
        if (r0 == false) goto L5;
        return;
    L5:
        if (this.glide.removeFromManagers(r3) == true) goto L10;
        if (r1 == null) goto L11;
        r3.setRequest(null);
        r1.clear();
        return;
    L11:
        return;
    }

    synchronized boolean untrack(Target<?> r4) {
        monitor-enter(this);
        Request r0 = r4.getRequest();     // Catch: Throwable -> L16
        if (r0 != null) goto L9;
        monitor-exit(this);
        return true;
    L9:
        if (this.requestTracker.clearAndRemove(r0) == false) goto L13;
        this.targetTracker.untrack(r4);     // Catch: Throwable -> L16
        r4.setRequest(null);     // Catch: Throwable -> L16
        monitor-exit(this);
        return true;
    L13:
        monitor-exit(this);
        return false;
    L16:
        th = move-exception;
        throw th;
    }

    synchronized void track(Target<?> r2, Request r3) {
        monitor-enter(this);
        this.targetTracker.track(r2);     // Catch: Throwable -> L6
        this.requestTracker.runRequest(r3);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    List<RequestListener<Object>> getDefaultRequestListeners() {
        return this.defaultRequestListeners;
    }

    synchronized RequestOptions getDefaultRequestOptions() {
        monitor-enter(this);
        RequestOptions r0 = this.requestOptions;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    <T> TransitionOptions<?, T> getDefaultTransitionOptions(Class<T> r1) {
        return this.glide.getGlideContext().getDefaultTransitionOptions(r1);
    }

    public synchronized String toString() {
        monitor-enter(this);
        String r0 = super.toString() + "{tracker=" + this.requestTracker + ", treeNode=" + this.treeNode + VectorFormat.DEFAULT_SUFFIX;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int r2) {
        if (r2 == 60) goto L5;
        return;
    L5:
        if (this.pauseAllRequestsOnTrimMemoryModerate == false) goto L9;
        pauseAllRequestsRecursive();
        return;
    }

    private synchronized void clearRequests() {
        monitor-enter(this);
        Iterator<Target<?>> r0 = this.targetTracker.getAll().iterator();     // Catch: Throwable -> L10
    L5:
        if (r0.hasNext() == false) goto L7;
        clear(r0.next());     // Catch: Throwable -> L10
        goto L5
    L7:
        this.targetTracker.clear();     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
