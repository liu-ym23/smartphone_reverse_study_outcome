package com.ttnet.org.chromium.net.impl;

import android.annotation.SuppressLint;
import android.os.Build;
import com.ttnet.org.chromium.net.BidirectionalStream;
import com.ttnet.org.chromium.net.ExperimentalBidirectionalStream;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class BidirectionalStreamBuilderImpl extends ExperimentalBidirectionalStream.Builder {
    private final BidirectionalStream.Callback mCallback;
    private final CronetEngineBase mCronetEngine;
    private boolean mDelayRequestHeadersUntilFirstFlush;
    private final Executor mExecutor;
    private String mHttpMethod;
    private long mNetworkHandle;
    private int mPriority;
    private Collection<Object> mRequestAnnotations;
    private final ArrayList<Map.Entry<String, String>> mRequestHeaders;
    private int mTrafficStatsTag;
    private boolean mTrafficStatsTagSet;
    private int mTrafficStatsUid;
    private boolean mTrafficStatsUidSet;
    private final String mUrl;

    BidirectionalStreamBuilderImpl(String r3, BidirectionalStream.Callback r4, Executor r5, CronetEngineBase r6) {
        this.mRequestHeaders = new ArrayList();
        this.mHttpMethod = "POST";
        this.mPriority = 3;
        this.mNetworkHandle = -1;
        Objects.requireNonNull(r3, "URL is required.");
        Objects.requireNonNull(r4, "Callback is required.");
        Objects.requireNonNull(r5, "Executor is required.");
        Objects.requireNonNull(r6, "CronetEngine is required.");
        this.mUrl = r3;
        this.mCallback = r4;
        this.mExecutor = r5;
        this.mCronetEngine = r6;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalBidirectionalStream.Builder, com.ttnet.org.chromium.net.BidirectionalStream.Builder
    public /* bridge */ /* synthetic */ BidirectionalStream.Builder addHeader(String r1, String r2) {
        return addHeader(r1, r2);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalBidirectionalStream.Builder, com.ttnet.org.chromium.net.BidirectionalStream.Builder
    public /* bridge */ /* synthetic */ ExperimentalBidirectionalStream.Builder addHeader(String r1, String r2) {
        return addHeader(r1, r2);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalBidirectionalStream.Builder, com.ttnet.org.chromium.net.BidirectionalStream.Builder
    public BidirectionalStreamBuilderImpl addHeader(String r3, String r4) {
        Objects.requireNonNull(r3, "Invalid header name.");
        Objects.requireNonNull(r4, "Invalid header value.");
        this.mRequestHeaders.add(new AbstractMap.SimpleImmutableEntry(r3, r4));
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalBidirectionalStream.Builder
    public ExperimentalBidirectionalStream.Builder addRequestAnnotation(Object r2) {
        Objects.requireNonNull(r2, "Invalid metrics annotation.");
        if (this.mRequestAnnotations != null) goto L5;
        this.mRequestAnnotations = new ArrayList();
    L5:
        this.mRequestAnnotations.add(r2);
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalBidirectionalStream.Builder
    public ExperimentalBidirectionalStream.Builder bindToNetwork(long r3) {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        this.mNetworkHandle = r3;
        return this;
    L7:
        throw new UnsupportedOperationException("The multi-network API is available starting from Android Marshmallow");
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalBidirectionalStream.Builder, com.ttnet.org.chromium.net.BidirectionalStream.Builder
    @SuppressLint({"WrongConstant"})
    public /* bridge */ /* synthetic */ BidirectionalStream build() {
        return build();
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalBidirectionalStream.Builder, com.ttnet.org.chromium.net.BidirectionalStream.Builder
    @SuppressLint({"WrongConstant"})
    public ExperimentalBidirectionalStream build() {
        return this.mCronetEngine.createBidirectionalStream(this.mUrl, this.mCallback, this.mExecutor, this.mHttpMethod, this.mRequestHeaders, this.mPriority, this.mDelayRequestHeadersUntilFirstFlush, this.mRequestAnnotations, this.mTrafficStatsTagSet, this.mTrafficStatsTag, this.mTrafficStatsUidSet, this.mTrafficStatsUid, this.mNetworkHandle);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalBidirectionalStream.Builder, com.ttnet.org.chromium.net.BidirectionalStream.Builder
    public /* bridge */ /* synthetic */ BidirectionalStream.Builder delayRequestHeadersUntilFirstFlush(boolean r1) {
        return delayRequestHeadersUntilFirstFlush(r1);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalBidirectionalStream.Builder, com.ttnet.org.chromium.net.BidirectionalStream.Builder
    public /* bridge */ /* synthetic */ ExperimentalBidirectionalStream.Builder delayRequestHeadersUntilFirstFlush(boolean r1) {
        return delayRequestHeadersUntilFirstFlush(r1);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalBidirectionalStream.Builder, com.ttnet.org.chromium.net.BidirectionalStream.Builder
    public BidirectionalStreamBuilderImpl delayRequestHeadersUntilFirstFlush(boolean r1) {
        this.mDelayRequestHeadersUntilFirstFlush = r1;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalBidirectionalStream.Builder, com.ttnet.org.chromium.net.BidirectionalStream.Builder
    public /* bridge */ /* synthetic */ BidirectionalStream.Builder setHttpMethod(String r1) {
        return setHttpMethod(r1);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalBidirectionalStream.Builder, com.ttnet.org.chromium.net.BidirectionalStream.Builder
    public /* bridge */ /* synthetic */ ExperimentalBidirectionalStream.Builder setHttpMethod(String r1) {
        return setHttpMethod(r1);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalBidirectionalStream.Builder, com.ttnet.org.chromium.net.BidirectionalStream.Builder
    public BidirectionalStreamBuilderImpl setHttpMethod(String r2) {
        Objects.requireNonNull(r2, "Method is required.");
        this.mHttpMethod = r2;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalBidirectionalStream.Builder, com.ttnet.org.chromium.net.BidirectionalStream.Builder
    public /* bridge */ /* synthetic */ BidirectionalStream.Builder setPriority(int r1) {
        return setPriority(r1);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalBidirectionalStream.Builder, com.ttnet.org.chromium.net.BidirectionalStream.Builder
    public /* bridge */ /* synthetic */ ExperimentalBidirectionalStream.Builder setPriority(int r1) {
        return setPriority(r1);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalBidirectionalStream.Builder, com.ttnet.org.chromium.net.BidirectionalStream.Builder
    public BidirectionalStreamBuilderImpl setPriority(int r1) {
        this.mPriority = r1;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalBidirectionalStream.Builder
    public ExperimentalBidirectionalStream.Builder setTrafficStatsTag(int r2) {
        this.mTrafficStatsTagSet = true;
        this.mTrafficStatsTag = r2;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalBidirectionalStream.Builder
    public ExperimentalBidirectionalStream.Builder setTrafficStatsUid(int r2) {
        this.mTrafficStatsUidSet = true;
        this.mTrafficStatsUid = r2;
        return this;
    }
}
