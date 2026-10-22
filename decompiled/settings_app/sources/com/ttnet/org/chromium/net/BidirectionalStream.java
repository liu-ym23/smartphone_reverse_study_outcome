package com.ttnet.org.chromium.net;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
public abstract class BidirectionalStream {

    public static abstract class Builder {
        public static final int STREAM_PRIORITY_HIGHEST = 4;
        public static final int STREAM_PRIORITY_IDLE = 0;
        public static final int STREAM_PRIORITY_LOW = 2;
        public static final int STREAM_PRIORITY_LOWEST = 1;
        public static final int STREAM_PRIORITY_MEDIUM = 3;

        public abstract Builder addHeader(String r1, String r2);

        public abstract BidirectionalStream build();

        public abstract Builder delayRequestHeadersUntilFirstFlush(boolean r1);

        public abstract Builder setHttpMethod(String r1);

        public abstract Builder setPriority(int r1);

        public Builder() {
        }
    }

    public static abstract class Callback {
        public void onCanceled(BidirectionalStream r1, UrlResponseInfo r2) {
        }

        public abstract void onFailed(BidirectionalStream r1, UrlResponseInfo r2, CronetException r3);

        public abstract void onReadCompleted(BidirectionalStream r1, UrlResponseInfo r2, ByteBuffer r3, boolean r4);

        public abstract void onResponseHeadersReceived(BidirectionalStream r1, UrlResponseInfo r2);

        public void onResponseTrailersReceived(BidirectionalStream r1, UrlResponseInfo r2, UrlResponseInfo.HeaderBlock r3) {
        }

        public abstract void onStreamReady(BidirectionalStream r1);

        public abstract void onSucceeded(BidirectionalStream r1, UrlResponseInfo r2);

        public abstract void onWriteCompleted(BidirectionalStream r1, UrlResponseInfo r2, ByteBuffer r3, boolean r4);

        public Callback() {
        }
    }

    public abstract void cancel();

    public abstract void flush();

    public abstract boolean isDone();

    public abstract void read(ByteBuffer r1);

    public abstract void start();

    public abstract void write(ByteBuffer r1, boolean r2);

    public BidirectionalStream() {
    }
}
