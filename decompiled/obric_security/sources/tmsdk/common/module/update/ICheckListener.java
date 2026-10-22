package tmsdk.common.module.update;

/* JADX INFO: loaded from: classes5.dex */
public interface ICheckListener {
    void onCheckCanceled();

    void onCheckEvent(int r1);

    void onCheckFinished(CheckResult r1);

    void onCheckStarted();
}
