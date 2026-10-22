package tmsdk.fg.module.cleanV2;

/* JADX INFO: loaded from: classes5.dex */
public interface IScanTaskCallBack {
    void onDirectoryChange(String r1, int r2);

    void onRubbishFound(RubbishEntity r1);

    void onScanCanceled(RubbishHolder r1);

    void onScanError(int r1, RubbishHolder r2);

    void onScanFinished(RubbishHolder r1);

    void onScanStarted();
}
