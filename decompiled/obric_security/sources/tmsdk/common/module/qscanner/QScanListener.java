package tmsdk.common.module.qscanner;

import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public interface QScanListener {
    void onScanCanceled(int r1);

    void onScanContinue(int r1);

    void onScanError(int r1);

    void onScanFinished(int r1, List<QScanResultEntity> r2);

    void onScanPaused(int r1);

    void onScanProgress(int r1, int r2, int r3, String r4, String r5);

    void onScanStarted(int r1);
}
