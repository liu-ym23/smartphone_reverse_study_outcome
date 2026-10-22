package com.ttnet.org.chromium.net;

import java.nio.ByteBuffer;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes5.dex */
public abstract class UrlRequest {

    public static abstract class Builder {
        public static final int REQUEST_PRIORITY_HIGHEST = 4;
        public static final int REQUEST_PRIORITY_IDLE = 0;
        public static final int REQUEST_PRIORITY_LOW = 2;
        public static final int REQUEST_PRIORITY_LOWEST = 1;
        public static final int REQUEST_PRIORITY_MEDIUM = 3;

        public abstract Builder addHeader(String r1, String r2);

        public abstract Builder allowDirectExecutor();

        public abstract UrlRequest build();

        public abstract Builder disableCache();

        public abstract Builder setHttpMethod(String r1);

        public abstract Builder setPriority(int r1);

        public abstract Builder setRequestTimeout(int r1);

        public abstract Builder setSocketConnectTimeout(int r1);

        public abstract Builder setSocketReadTimeout(int r1);

        public abstract Builder setSocketWriteTimeout(int r1);

        public abstract Builder setUploadDataProvider(UploadDataProvider r1, Executor r2);

        public Builder() {
        }
    }

    public static abstract class Callback {
        public void onCanceled(UrlRequest r1, UrlResponseInfo r2) {
        }

        public abstract void onFailed(UrlRequest r1, UrlResponseInfo r2, CronetException r3);

        public void onMetricsCollected(UrlRequest r1, RequestFinishedInfo r2) {
        }

        public abstract void onReadCompleted(UrlRequest r1, UrlResponseInfo r2, ByteBuffer r3) throws Exception;

        public abstract void onRedirectReceived(UrlRequest r1, UrlResponseInfo r2, String r3, String r4) throws Exception;

        public void onRequestLogCollected(String r1, RequestFinishedInfo r2) {
        }

        public abstract void onResponseStarted(UrlRequest r1, UrlResponseInfo r2, String r3) throws Exception;

        public abstract void onSucceeded(UrlRequest r1, UrlResponseInfo r2);

        public Callback() {
        }
    }

    public static class Status {
        public static final int CONNECTING = 10;
        public static final int DOWNLOADING_PAC_FILE = 5;
        public static final int ESTABLISHING_PROXY_TUNNEL = 8;
        public static final int IDLE = 0;
        public static final int INVALID = -1;
        public static final int READING_RESPONSE = 14;
        public static final int RESOLVING_HOST = 9;
        public static final int RESOLVING_HOST_IN_PAC_FILE = 7;
        public static final int RESOLVING_PROXY_FOR_URL = 6;
        public static final int SENDING_REQUEST = 12;
        public static final int SSL_HANDSHAKE = 11;
        public static final int WAITING_FOR_AVAILABLE_SOCKET = 2;
        public static final int WAITING_FOR_CACHE = 4;
        public static final int WAITING_FOR_DELEGATE = 3;
        public static final int WAITING_FOR_RESPONSE = 13;
        public static final int WAITING_FOR_STALLED_SOCKET_POOL = 1;

        private Status() {
        }
    }

    public static abstract class StatusListener {
        public abstract void onStatus(int r1);

        public StatusListener() {
        }
    }

    public abstract void AddRequestCookieHeader(String r1, String r2);

    public abstract void RemoveRequestCookieHeader();

    public void appTimeout() {
    }

    public abstract void cancel();

    public abstract void followRedirect();

    public abstract String getFinalUrl();

    public abstract String getRequestLog();

    public abstract void getStatus(StatusListener r1);

    public abstract boolean isDone();

    public abstract void read(ByteBuffer r1);

    public abstract void setAddCookieCostUs(long r1);

    public abstract void setAuthCredentials(String r1, String r2);

    public abstract void setRequestCookieSource(int r1);

    public void setRequestFlag(int r1) {
    }

    public abstract void setRequestTypeFlags(int r1);

    public abstract void setSaveCookieCostUs(long r1);

    public abstract void setThrottleNetSpeed(long r1);

    public abstract void start();

    public abstract void stopRedirect();

    public UrlRequest() {
    }
}
