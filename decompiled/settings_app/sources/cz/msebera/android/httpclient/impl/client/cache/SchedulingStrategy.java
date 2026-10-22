package cz.msebera.android.httpclient.impl.client.cache;

import java.io.Closeable;

/* JADX INFO: loaded from: classes5.dex */
public interface SchedulingStrategy extends Closeable {
    void schedule(AsynchronousValidationRequest r1);
}
