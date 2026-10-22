package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes5.dex */
public class HttpRequestFutureTask<V> extends FutureTask<V> {
    private final HttpRequestTaskCallable<V> callable;
    private final HttpUriRequest request;

    public HttpRequestFutureTask(HttpUriRequest r1, HttpRequestTaskCallable<V> r2) {
        super(r2);
        this.request = r1;
        this.callable = r2;
    }

    @Override // java.util.concurrent.FutureTask, java.util.concurrent.Future
    public boolean cancel(boolean r2) {
        this.callable.cancel();
        if (r2 == false) goto L6;
        this.request.abort();
    L6:
        return super.cancel(r2);
    }

    public long scheduledTime() {
        return this.callable.getScheduled();
    }

    public long startedTime() {
        return this.callable.getStarted();
    }

    public long endedTime() {
        if (isDone() == false) goto L7;
        return this.callable.getEnded();
    L7:
        throw new IllegalStateException("Task is not done yet");
    }

    public long requestDuration() {
        if (isDone() == false) goto L7;
        return endedTime() - startedTime();
    L7:
        throw new IllegalStateException("Task is not done yet");
    }

    public long taskDuration() {
        if (isDone() == false) goto L7;
        return endedTime() - scheduledTime();
    L7:
        throw new IllegalStateException("Task is not done yet");
    }

    @Override // java.util.concurrent.FutureTask
    public String toString() {
        return this.request.getRequestLine().getUri();
    }
}
