package com.ttnet.org.chromium.net.impl;

import android.util.Pair;
import com.ttnet.org.chromium.net.ExperimentalUrlRequest;
import com.ttnet.org.chromium.net.RequestFinishedInfo;
import com.ttnet.org.chromium.net.UploadDataProvider;
import com.ttnet.org.chromium.net.UrlRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public class UrlRequestBuilderImpl extends ExperimentalUrlRequest.Builder {
    private static final String TAG = "UrlRequestBuilderImpl";
    private boolean mAllowDirectExecutor;
    private final UrlRequest.Callback mCallback;
    private final CronetEngineBase mCronetEngine;
    private boolean mDisableCache;
    private boolean mDisableConnectionMigration;
    private final Executor mExecutor;
    private int mIdempotency;
    private String mMethod;
    private long mNetworkHandle;
    private int mPriority;
    private Collection<Object> mRequestAnnotations;
    private RequestFinishedInfo.Listener mRequestFinishedListener;
    private final ArrayList<Pair<String, String>> mRequestHeaders;
    private int mRequestTimeout;
    private int mSocketConnectTimeout;
    private int mSocketReadTimeout;
    private int mSocketWriteTimeout;
    private int mTrafficStatsTag;
    private boolean mTrafficStatsTagSet;
    private int mTrafficStatsUid;
    private boolean mTrafficStatsUidSet;
    private UploadDataProvider mUploadDataProvider;
    private Executor mUploadDataProviderExecutor;
    private final String mUrl;

    static {
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ ExperimentalUrlRequest.Builder addHeader(String r1, String r2) {
        return addHeader(r1, r2);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ UrlRequest.Builder addHeader(String r1, String r2) {
        return addHeader(r1, r2);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder
    public /* bridge */ /* synthetic */ ExperimentalUrlRequest.Builder addRequestAnnotation(Object r1) {
        return addRequestAnnotation(r1);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ ExperimentalUrlRequest.Builder allowDirectExecutor() {
        return allowDirectExecutor();
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ UrlRequest.Builder allowDirectExecutor() {
        return allowDirectExecutor();
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder
    public /* bridge */ /* synthetic */ ExperimentalUrlRequest.Builder bindToNetwork(long r1) {
        return bindToNetwork(r1);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ ExperimentalUrlRequest build() {
        return build();
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ UrlRequest build() {
        return build();
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ ExperimentalUrlRequest.Builder disableCache() {
        return disableCache();
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ UrlRequest.Builder disableCache() {
        return disableCache();
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder
    public /* bridge */ /* synthetic */ ExperimentalUrlRequest.Builder disableConnectionMigration() {
        return disableConnectionMigration();
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ UrlRequest.Builder setHttpMethod(String r1) {
        return setHttpMethod(r1);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder
    public /* bridge */ /* synthetic */ ExperimentalUrlRequest.Builder setIdempotency(int r1) {
        return setIdempotency(r1);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ ExperimentalUrlRequest.Builder setPriority(int r1) {
        return setPriority(r1);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ UrlRequest.Builder setPriority(int r1) {
        return setPriority(r1);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder
    public /* bridge */ /* synthetic */ ExperimentalUrlRequest.Builder setRequestFinishedListener(RequestFinishedInfo.Listener r1) {
        return setRequestFinishedListener(r1);
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ UrlRequest.Builder setRequestTimeout(int r1) {
        return setRequestTimeout(r1);
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ UrlRequest.Builder setSocketConnectTimeout(int r1) {
        return setSocketConnectTimeout(r1);
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ UrlRequest.Builder setSocketReadTimeout(int r1) {
        return setSocketReadTimeout(r1);
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ UrlRequest.Builder setSocketWriteTimeout(int r1) {
        return setSocketWriteTimeout(r1);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder
    public /* bridge */ /* synthetic */ ExperimentalUrlRequest.Builder setTrafficStatsTag(int r1) {
        return setTrafficStatsTag(r1);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder
    public /* bridge */ /* synthetic */ ExperimentalUrlRequest.Builder setTrafficStatsUid(int r1) {
        return setTrafficStatsUid(r1);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ ExperimentalUrlRequest.Builder setUploadDataProvider(UploadDataProvider r1, Executor r2) {
        return setUploadDataProvider(r1, r2);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ UrlRequest.Builder setUploadDataProvider(UploadDataProvider r1, Executor r2) {
        return setUploadDataProvider(r1, r2);
    }

    UrlRequestBuilderImpl(String r3, UrlRequest.Callback r4, Executor r5, CronetEngineBase r6) {
        this.mRequestHeaders = new ArrayList();
        this.mPriority = 3;
        this.mNetworkHandle = -1;
        this.mIdempotency = 0;
        if (r3 == null) goto L16;
        if (r4 == null) goto L14;
        if (r5 == null) goto L12;
        if (r6 == null) goto L10;
        this.mUrl = r3;
        this.mCallback = r4;
        this.mExecutor = r5;
        this.mCronetEngine = r6;
        return;
    L10:
        throw new NullPointerException("CronetEngine is required.");
    L12:
        throw new NullPointerException("Executor is required.");
    L14:
        throw new NullPointerException("Callback is required.");
    L16:
        throw new NullPointerException("URL is required.");
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public ExperimentalUrlRequest.Builder setHttpMethod(String r1) {
        if (r1 == null) goto L6;
        this.mMethod = r1;
        return this;
    L6:
        throw new NullPointerException("Method is required.");
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public UrlRequestBuilderImpl addHeader(String r2, String r3) {
        if (r2 == null) goto L9;
        if (r3 == null) goto L7;
        this.mRequestHeaders.add(Pair.create(r2, r3));
        return this;
    L7:
        throw new NullPointerException("Invalid header value.");
    L9:
        throw new NullPointerException("Invalid header name.");
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public UrlRequestBuilderImpl disableCache() {
        this.mDisableCache = true;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder
    public UrlRequestBuilderImpl disableConnectionMigration() {
        this.mDisableConnectionMigration = true;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public UrlRequestBuilderImpl setPriority(int r1) {
        this.mPriority = r1;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder
    public UrlRequestBuilderImpl setIdempotency(int r1) {
        this.mIdempotency = r1;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest.Builder
    public UrlRequestBuilderImpl setSocketConnectTimeout(int r1) {
        this.mSocketConnectTimeout = r1;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest.Builder
    public UrlRequestBuilderImpl setSocketReadTimeout(int r1) {
        this.mSocketReadTimeout = r1;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest.Builder
    public UrlRequestBuilderImpl setSocketWriteTimeout(int r1) {
        this.mSocketWriteTimeout = r1;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest.Builder
    public UrlRequestBuilderImpl setRequestTimeout(int r1) {
        this.mRequestTimeout = r1;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public UrlRequestBuilderImpl setUploadDataProvider(UploadDataProvider r2, Executor r3) {
        if (r2 == null) goto L12;
        if (r3 == null) goto L10;
        if (this.mMethod != null) goto L7;
        this.mMethod = "POST";
    L7:
        this.mUploadDataProvider = r2;
        this.mUploadDataProviderExecutor = r3;
        return this;
    L10:
        throw new NullPointerException("Invalid UploadDataProvider Executor.");
    L12:
        throw new NullPointerException("Invalid UploadDataProvider.");
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public UrlRequestBuilderImpl allowDirectExecutor() {
        this.mAllowDirectExecutor = true;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder
    public UrlRequestBuilderImpl addRequestAnnotation(Object r2) {
        if (r2 == null) goto L9;
        if (this.mRequestAnnotations != null) goto L6;
        this.mRequestAnnotations = new ArrayList();
    L6:
        this.mRequestAnnotations.add(r2);
        return this;
    L9:
        throw new NullPointerException("Invalid metrics annotation.");
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder
    public UrlRequestBuilderImpl setTrafficStatsTag(int r2) {
        this.mTrafficStatsTagSet = true;
        this.mTrafficStatsTag = r2;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder
    public UrlRequestBuilderImpl setTrafficStatsUid(int r2) {
        this.mTrafficStatsUidSet = true;
        this.mTrafficStatsUid = r2;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder
    public UrlRequestBuilderImpl setRequestFinishedListener(RequestFinishedInfo.Listener r1) {
        this.mRequestFinishedListener = r1;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder
    public UrlRequestBuilderImpl bindToNetwork(long r1) {
        this.mNetworkHandle = r1;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public UrlRequestBase build() {
        UrlRequestBase r1 = this.mCronetEngine.createRequest(this.mUrl, this.mCallback, this.mExecutor, this.mPriority, this.mRequestAnnotations, this.mDisableCache, this.mDisableConnectionMigration, this.mAllowDirectExecutor, this.mTrafficStatsTagSet, this.mTrafficStatsTag, this.mTrafficStatsUidSet, this.mTrafficStatsUid, this.mRequestFinishedListener, this.mIdempotency, this.mNetworkHandle);
        String r2 = this.mMethod;
        if (r2 == null) goto L5;
        r1.setHttpMethod(r2);
    L5:
        Iterator<Pair<String, String>> r3 = this.mRequestHeaders.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        Pair<String, String> r4 = r3.next();
        r1.addHeader((String) r4.first, (String) r4.second);
        goto L7
    L9:
        UploadDataProvider r5 = this.mUploadDataProvider;
        if (r5 == null) goto L12;
        r1.setUploadDataProvider(r5, this.mUploadDataProviderExecutor);
    L12:
        r1.setSocketConnectTimeout(this.mSocketConnectTimeout);
        r1.setSocketReadTimeout(this.mSocketReadTimeout);
        r1.setSocketWriteTimeout(this.mSocketWriteTimeout);
        r1.setRequestTimeout(this.mRequestTimeout);
        return r1;
    }
}
