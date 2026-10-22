package com.bumptech.glide.request;

/* JADX INFO: loaded from: classes.dex */
public class ThumbnailRequestCoordinator implements RequestCoordinator, Request {
    private volatile Request full;
    private RequestCoordinator.RequestState fullState;
    private boolean isRunningDuringBegin;
    private final RequestCoordinator parent;
    private final Object requestLock;
    private volatile Request thumb;
    private RequestCoordinator.RequestState thumbState;

    public ThumbnailRequestCoordinator(Object r2, RequestCoordinator r3) {
        this.fullState = RequestCoordinator.RequestState.CLEARED;
        this.thumbState = RequestCoordinator.RequestState.CLEARED;
        this.requestLock = r2;
        this.parent = r3;
    }

    public void setRequests(Request r1, Request r2) {
        this.full = r1;
        this.thumb = r2;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean canSetImage(Request r3) {
        Object r0 = this.requestLock;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (parentCanSetImage() == true) goto L7;
    L11:
        boolean r2 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return r2;
    L7:
        if (r3.equals(this.full) == false) goto L9;
    L10:
        r2 = true;
        goto L12
    L9:
        if (this.fullState == RequestCoordinator.RequestState.SUCCESS) goto L11;
        goto L10
    }

    private boolean parentCanSetImage() {
        RequestCoordinator r0 = this.parent;
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (r0.canSetImage(this) == true) goto L8;
        return false;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean canNotifyStatusChanged(Request r3) {
        Object r0 = this.requestLock;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (parentCanNotifyStatusChanged() == true) goto L7;
    L11:
        boolean r2 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return r2;
    L7:
        if (r3.equals(this.full) == false) goto L11;
        if (isAnyResourceSet() == true) goto L11;
        r2 = true;
        goto L12
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean canNotifyCleared(Request r3) {
        Object r0 = this.requestLock;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (parentCanNotifyCleared() == true) goto L7;
    L11:
        boolean r2 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return r2;
    L7:
        if (r3.equals(this.full) == false) goto L11;
        if (this.fullState == RequestCoordinator.RequestState.PAUSED) goto L11;
        r2 = true;
        goto L12
    }

    private boolean parentCanNotifyCleared() {
        RequestCoordinator r0 = this.parent;
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (r0.canNotifyCleared(this) == true) goto L8;
        return false;
    }

    private boolean parentCanNotifyStatusChanged() {
        RequestCoordinator r0 = this.parent;
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (r0.canNotifyStatusChanged(this) == true) goto L8;
        return false;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator, com.bumptech.glide.request.Request
    public boolean isAnyResourceSet() {
        Object r0 = this.requestLock;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.thumb.isAnyResourceSet() == false) goto L7;
    L10:
        boolean r2 = true;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r2;
    L7:
        if (this.full.isAnyResourceSet() == true) goto L10;
        r2 = false;
        goto L11
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void onRequestSuccess(Request r3) {
        Object r0 = this.requestLock;
        monitor-enter(r0);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (r3.equals(this.thumb) == false) goto L9;
        this.thumbState = RequestCoordinator.RequestState.SUCCESS;     // Catch: Throwable -> L17
        monitor-exit(r0);     // Catch: Throwable -> L17
        return;
    L9:
        this.fullState = RequestCoordinator.RequestState.SUCCESS;     // Catch: Throwable -> L17
        RequestCoordinator r4 = this.parent;     // Catch: Throwable -> L17
        if (r4 == null) goto L13;
        r4.onRequestSuccess(this);     // Catch: Throwable -> L17
    L13:
        if (this.thumbState.isComplete() == true) goto L15;
        this.thumb.clear();     // Catch: Throwable -> L17
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L17
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void onRequestFailed(Request r3) {
        Object r0 = this.requestLock;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (r3.equals(this.full) == true) goto L9;
        this.thumbState = RequestCoordinator.RequestState.FAILED;     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L9:
        this.fullState = RequestCoordinator.RequestState.FAILED;     // Catch: Throwable -> L14
        RequestCoordinator r4 = this.parent;     // Catch: Throwable -> L14
        if (r4 == null) goto L12;
        r4.onRequestFailed(this);     // Catch: Throwable -> L14
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.bumptech.glide.request.RequestCoordinator] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    @Override // com.bumptech.glide.request.RequestCoordinator
    public RequestCoordinator getRoot() {
        Object r0 = this.requestLock;
        monitor-enter(r0);
        RequestCoordinator r1 = this.parent;     // Catch: Throwable -> L9
        ?? r2 = this;
        if (r1 == null) goto L7;
        r2 = r1.getRoot();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.request.Request
    public void begin() {
        Object r0 = this.requestLock;
        monitor-enter(r0);
        this.isRunningDuringBegin = true;     // Catch: Throwable -> L23
    L20:
        th = move-exception;
        this.isRunningDuringBegin = false;     // Catch: Throwable -> L23
        throw th;     // Catch: Throwable -> L23
    L8:
        if (this.fullState == RequestCoordinator.RequestState.SUCCESS) goto L13;
        if (this.thumbState == RequestCoordinator.RequestState.RUNNING) goto L13;
        this.thumbState = RequestCoordinator.RequestState.RUNNING;     // Catch: Throwable -> L20
        this.thumb.begin();     // Catch: Throwable -> L20
    L13:
        if (this.isRunningDuringBegin == true) goto L15;
    L17:
        this.isRunningDuringBegin = false;     // Catch: Throwable -> L23
        monitor-exit(r0);     // Catch: Throwable -> L23
        return;
    L15:
        if (this.fullState == RequestCoordinator.RequestState.RUNNING) goto L17;
        this.fullState = RequestCoordinator.RequestState.RUNNING;     // Catch: Throwable -> L20
        this.full.begin();     // Catch: Throwable -> L20
    L23:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.request.Request
    public void clear() {
        Object r0 = this.requestLock;
        monitor-enter(r0);
        this.isRunningDuringBegin = false;     // Catch: Throwable -> L8
        this.fullState = RequestCoordinator.RequestState.CLEARED;     // Catch: Throwable -> L8
        this.thumbState = RequestCoordinator.RequestState.CLEARED;     // Catch: Throwable -> L8
        this.thumb.clear();     // Catch: Throwable -> L8
        this.full.clear();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.request.Request
    public void pause() {
        Object r0 = this.requestLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.thumbState.isComplete() == true) goto L8;
        this.thumbState = RequestCoordinator.RequestState.PAUSED;     // Catch: Throwable -> L12
        this.thumb.pause();     // Catch: Throwable -> L12
    L8:
        if (this.fullState.isComplete() == true) goto L10;
        this.fullState = RequestCoordinator.RequestState.PAUSED;     // Catch: Throwable -> L12
        this.full.pause();     // Catch: Throwable -> L12
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isRunning() {
        Object r0 = this.requestLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.fullState != RequestCoordinator.RequestState.RUNNING) goto L7;
        boolean r2 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r2;
    L7:
        r2 = false;
        goto L8
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isComplete() {
        Object r0 = this.requestLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.fullState != RequestCoordinator.RequestState.SUCCESS) goto L7;
        boolean r2 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r2;
    L7:
        r2 = false;
        goto L8
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isCleared() {
        Object r0 = this.requestLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.fullState != RequestCoordinator.RequestState.CLEARED) goto L7;
        boolean r2 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r2;
    L7:
        r2 = false;
        goto L8
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isEquivalentTo(Request r4) {
        if ((r4 instanceof ThumbnailRequestCoordinator) == false) goto L20;
        ThumbnailRequestCoordinator r5 = (ThumbnailRequestCoordinator) r4;
        if (this.full != null) goto L10;
        if (r5.full == null) goto L12;
        return false;
    L12:
        if (this.thumb != null) goto L17;
        if (r5.thumb != null) goto L23;
    L18:
        return true;
    L23:
        return false;
    L17:
        if (this.thumb.isEquivalentTo(r5.thumb) == true) goto L18;
        return false;
    L10:
        if (this.full.isEquivalentTo(r5.full) == true) goto L12;
        return false;
    L20:
        return false;
    }
}
