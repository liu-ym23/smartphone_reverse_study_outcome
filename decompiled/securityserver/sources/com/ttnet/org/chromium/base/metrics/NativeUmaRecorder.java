package com.ttnet.org.chromium.base.metrics;

import com.ttnet.org.chromium.base.Callback;
import com.ttnet.org.chromium.base.TimeUtils;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.MainDex;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("base::android")
@MainDex
final class NativeUmaRecorder implements UmaRecorder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Map<String, Long> mNativeHints;
    private Map<Callback<String>, Long> mUserActionTestingCallbackNativePtrs;

    public interface Natives {
        long addActionCallbackForTesting(Callback<String> r1);

        long createHistogramSnapshotForTesting();

        void destroyHistogramSnapshotForTesting(long r1);

        int getHistogramTotalCountForTesting(String r1, long r2);

        int getHistogramValueCountForTesting(String r1, int r2, long r3);

        long recordBooleanHistogram(String r1, long r2, boolean r4);

        long recordExponentialHistogram(String r1, long r2, int r4, int r5, int r6, int r7);

        long recordLinearHistogram(String r1, long r2, int r4, int r5, int r6, int r7);

        long recordSparseHistogram(String r1, long r2, int r4);

        void recordUserAction(String r1, long r2);

        void removeActionCallbackForTesting(long r1);
    }

    public NativeUmaRecorder() {
        this.mNativeHints = Collections.synchronizedMap(new HashMap());
    }

    private long getNativeHint(String r1) {
        Long r0 = this.mNativeHints.get(r1);
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.longValue();
    }

    private void maybeUpdateNativeHint(String r1, long r2, long r4) {
        if (r2 == r4) goto L6;
        this.mNativeHints.put(r1, Long.valueOf(r4));
        return;
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    public void addUserActionCallbackForTesting(Callback<String> r4) {
        long r0 = NativeUmaRecorderJni.get().addActionCallbackForTesting(r4);
        if (this.mUserActionTestingCallbackNativePtrs != null) goto L5;
        this.mUserActionTestingCallbackNativePtrs = Collections.synchronizedMap(new HashMap());
    L5:
        this.mUserActionTestingCallbackNativePtrs.put(r4, Long.valueOf(r0));
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    public int getHistogramTotalCountForTesting(String r3) {
        return NativeUmaRecorderJni.get().getHistogramTotalCountForTesting(r3, 0);
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    public int getHistogramValueCountForTesting(String r3, int r4) {
        return NativeUmaRecorderJni.get().getHistogramValueCountForTesting(r3, r4, 0);
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    public void recordBooleanHistogram(String r7, boolean r8) {
        long r2 = getNativeHint(r7);
        maybeUpdateNativeHint(r7, r2, NativeUmaRecorderJni.get().recordBooleanHistogram(r7, r2, r8));
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    public void recordExponentialHistogram(String r11, int r12, int r13, int r14, int r15) {
        long r8 = getNativeHint(r11);
        maybeUpdateNativeHint(r11, r8, NativeUmaRecorderJni.get().recordExponentialHistogram(r11, r8, r12, r13, r14, r15));
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    public void recordLinearHistogram(String r11, int r12, int r13, int r14, int r15) {
        long r8 = getNativeHint(r11);
        maybeUpdateNativeHint(r11, r8, NativeUmaRecorderJni.get().recordLinearHistogram(r11, r8, r12, r13, r14, r15));
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    public void recordSparseHistogram(String r7, int r8) {
        long r2 = getNativeHint(r7);
        maybeUpdateNativeHint(r7, r2, NativeUmaRecorderJni.get().recordSparseHistogram(r7, r2, r8));
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    public void recordUserAction(String r3, long r4) {
        long r0 = TimeUtils.elapsedRealtimeMillis() - r4;
        NativeUmaRecorderJni.get().recordUserAction(r3, r0);
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    public void removeUserActionCallbackForTesting(Callback<String> r3) {
        Map<Callback<String>, Long> r2 = this.mUserActionTestingCallbackNativePtrs;
        if (r2 != null) goto L5;
        return;
    L5:
        Long r4 = r2.remove(r3);
        if (r4 != null) goto L8;
        return;
    L8:
        NativeUmaRecorderJni.get().removeActionCallbackForTesting(r4.longValue());
    }
}
