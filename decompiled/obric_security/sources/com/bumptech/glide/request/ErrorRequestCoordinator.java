package com.bumptech.glide.request;

/* JADX INFO: loaded from: classes.dex */
public final class ErrorRequestCoordinator implements RequestCoordinator, Request {
    private volatile Request error;
    private RequestCoordinator.RequestState errorState;
    private final RequestCoordinator parent;
    private volatile Request primary;
    private RequestCoordinator.RequestState primaryState;
    private final Object requestLock;

    public ErrorRequestCoordinator(Object r2, RequestCoordinator r3) {
        this.primaryState = RequestCoordinator.RequestState.CLEARED;
        this.errorState = RequestCoordinator.RequestState.CLEARED;
        this.requestLock = r2;
        this.parent = r3;
    }

    public void setRequests(Request r1, Request r2) {
        this.primary = r1;
        this.error = r2;
    }

    @Override // com.bumptech.glide.request.Request
    public void begin() {
        Object r0 = this.requestLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.primaryState == RequestCoordinator.RequestState.RUNNING) goto L7;
        this.primaryState = RequestCoordinator.RequestState.RUNNING;     // Catch: Throwable -> L9
        this.primary.begin();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    @Override // com.bumptech.glide.request.Request
    public void clear() {
        Object r0 = this.requestLock;
        monitor-enter(r0);
        this.primaryState = RequestCoordinator.RequestState.CLEARED;     // Catch: Throwable -> L9
        this.primary.clear();     // Catch: Throwable -> L9
        if (this.errorState == RequestCoordinator.RequestState.CLEARED) goto L7;
        this.errorState = RequestCoordinator.RequestState.CLEARED;     // Catch: Throwable -> L9
        this.error.clear();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
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
        if (this.primaryState != RequestCoordinator.RequestState.RUNNING) goto L8;
        this.primaryState = RequestCoordinator.RequestState.PAUSED;     // Catch: Throwable -> L12
        this.primary.pause();     // Catch: Throwable -> L12
    L8:
        if (this.errorState != RequestCoordinator.RequestState.RUNNING) goto L10;
        this.errorState = RequestCoordinator.RequestState.PAUSED;     // Catch: Throwable -> L12
        this.error.pause();     // Catch: Throwable -> L12
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isRunning() {
        Object r0 = this.requestLock;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.primaryState != RequestCoordinator.RequestState.RUNNING) goto L7;
    L10:
        boolean r3 = true;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r3;
    L7:
        if (this.errorState == RequestCoordinator.RequestState.RUNNING) goto L10;
        r3 = false;
        goto L11
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isComplete() {
        Object r0 = this.requestLock;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.primaryState != RequestCoordinator.RequestState.SUCCESS) goto L7;
    L10:
        boolean r3 = true;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r3;
    L7:
        if (this.errorState == RequestCoordinator.RequestState.SUCCESS) goto L10;
        r3 = false;
        goto L11
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isCleared() {
        Object r0 = this.requestLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.primaryState == RequestCoordinator.RequestState.CLEARED) goto L7;
    L9:
        boolean r3 = false;
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r3;
    L7:
        if (this.errorState != RequestCoordinator.RequestState.CLEARED) goto L9;
        r3 = true;
        goto L10
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isEquivalentTo(Request r4) {
        if ((r4 instanceof ErrorRequestCoordinator) == false) goto L10;
        ErrorRequestCoordinator r5 = (ErrorRequestCoordinator) r4;
        if (this.primary.isEquivalentTo(r5.primary) == true) goto L7;
        return false;
    L7:
        if (this.error.isEquivalentTo(r5.error) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean canSetImage(Request r1) {
        Object r2 = this.requestLock;
        monitor-enter(r2);
        boolean r0 = parentCanSetImage();     // Catch: Throwable -> L7
        monitor-exit(r2);     // Catch: Throwable -> L7
        return r0;
    L7:
        th = move-exception;
        throw th;
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
    L12:
        th = move-exception;
        throw th;
    L5:
        if (parentCanNotifyStatusChanged() == true) goto L7;
    L9:
        boolean r2 = false;
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r2;
    L7:
        if (isValidRequestForStatusChanged(r3) == false) goto L9;
        r2 = true;
        goto L10
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean canNotifyCleared(Request r3) {
        Object r0 = this.requestLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (parentCanNotifyCleared() == true) goto L7;
    L9:
        boolean r2 = false;
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r2;
    L7:
        if (r3.equals(this.primary) == false) goto L9;
        r2 = true;
        goto L10
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

    private boolean isValidRequestForStatusChanged(Request r3) {
        if (this.primaryState == RequestCoordinator.RequestState.FAILED) goto L7;
        return r3.equals(this.primary);
    L7:
        if (r3.equals(this.error) == true) goto L9;
    L13:
        return false;
    L9:
        if (this.errorState != RequestCoordinator.RequestState.SUCCESS) goto L11;
    L12:
        return true;
    L11:
        if (this.errorState != RequestCoordinator.RequestState.FAILED) goto L13;
        goto L12
    }

    @Override // com.bumptech.glide.request.RequestCoordinator, com.bumptech.glide.request.Request
    public boolean isAnyResourceSet() {
        Object r0 = this.requestLock;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.primary.isAnyResourceSet() == false) goto L7;
    L10:
        boolean r2 = true;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r2;
    L7:
        if (this.error.isAnyResourceSet() == true) goto L10;
        r2 = false;
        goto L11
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void onRequestSuccess(Request r3) {
        Object r0 = this.requestLock;
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (r3.equals(this.primary) == false) goto L8;
        this.primaryState = RequestCoordinator.RequestState.SUCCESS;     // Catch: Throwable -> L15
    L10:
        RequestCoordinator r4 = this.parent;     // Catch: Throwable -> L15
        if (r4 == null) goto L13;
        r4.onRequestSuccess(this);     // Catch: Throwable -> L15
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L8:
        if (r3.equals(this.error) == false) goto L10;
        this.errorState = RequestCoordinator.RequestState.SUCCESS;     // Catch: Throwable -> L15
        goto L10
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void onRequestFailed(Request r3) {
        Object r0 = this.requestLock;
        monitor-enter(r0);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (r3.equals(this.error) == true) goto L11;
        this.primaryState = RequestCoordinator.RequestState.FAILED;     // Catch: Throwable -> L16
        if (this.errorState == RequestCoordinator.RequestState.RUNNING) goto L9;
        this.errorState = RequestCoordinator.RequestState.RUNNING;     // Catch: Throwable -> L16
        this.error.begin();     // Catch: Throwable -> L16
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L11:
        this.errorState = RequestCoordinator.RequestState.FAILED;     // Catch: Throwable -> L16
        RequestCoordinator r4 = this.parent;     // Catch: Throwable -> L16
        if (r4 == null) goto L14;
        r4.onRequestFailed(this);     // Catch: Throwable -> L16
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L16
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
}
