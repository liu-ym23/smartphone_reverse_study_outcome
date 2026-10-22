package com.ttnet.org.chromium.base.metrics;

import com.ttnet.org.chromium.base.Callback;

/* JADX INFO: loaded from: classes5.dex */
public interface UmaRecorder {
    void addUserActionCallbackForTesting(Callback<String> r1);

    int getHistogramTotalCountForTesting(String r1);

    int getHistogramValueCountForTesting(String r1, int r2);

    void recordBooleanHistogram(String r1, boolean r2);

    void recordExponentialHistogram(String r1, int r2, int r3, int r4, int r5);

    void recordLinearHistogram(String r1, int r2, int r3, int r4, int r5);

    void recordSparseHistogram(String r1, int r2);

    void recordUserAction(String r1, long r2);

    void removeUserActionCallbackForTesting(Callback<String> r1);
}
