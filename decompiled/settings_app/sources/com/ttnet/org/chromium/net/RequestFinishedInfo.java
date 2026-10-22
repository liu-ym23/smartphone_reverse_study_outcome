package com.ttnet.org.chromium.net;

import java.util.Collection;
import java.util.Date;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes5.dex */
public abstract class RequestFinishedInfo {
    public static final int CANCELED = 2;
    public static final int FAILED = 1;
    public static final int SUCCEEDED = 0;

    public static abstract class Listener {
        private final Executor mExecutor;

        public abstract void onRequestFinished(RequestFinishedInfo r1);

        public Listener(Executor r1) {
            if (r1 == null) goto L7;
            this.mExecutor = r1;
            return;
        L7:
            throw new IllegalStateException("Executor must not be null");
        }

        public Executor getExecutor() {
            return this.mExecutor;
        }
    }

    public static abstract class Metrics {
        public abstract Long getAddCookieCostUs();

        public abstract Date getConnectEnd();

        public abstract Date getConnectStart();

        public abstract Date getDnsEnd();

        public abstract Date getDnsStart();

        public abstract String getPeerAddr();

        public abstract Long getPeerPort();

        public abstract Date getPostTaskStartMs();

        public abstract Date getPushEnd();

        public abstract Date getPushStart();

        public abstract Long getReceivedByteCount();

        public abstract Integer getRequestCookieSource();

        public abstract Date getRequestEnd();

        public abstract String getRequestHeaders();

        public abstract Date getRequestStart();

        public abstract String getResponseHeaders();

        public abstract Date getResponseStart();

        public abstract Long getRetryAttempts();

        public abstract Long getSaveCookieCostUs();

        public abstract Date getSendingEnd();

        public abstract Date getSendingStart();

        public abstract Long getSentByteCount();

        public abstract boolean getSocketReused();

        public abstract Date getSslEnd();

        public abstract Date getSslStart();

        public abstract Long getTotalTimeMs();

        public abstract Long getTtfbMs();

        public Metrics() {
        }
    }

    public abstract Collection<Object> getAnnotations();

    public abstract CronetException getException();

    public abstract int getFinishedReason();

    public abstract Metrics getMetrics();

    public abstract UrlResponseInfo getResponseInfo();

    public abstract String getUrl();

    public RequestFinishedInfo() {
    }
}
