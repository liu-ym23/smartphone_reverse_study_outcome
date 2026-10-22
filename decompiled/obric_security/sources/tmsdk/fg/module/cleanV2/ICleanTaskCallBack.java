package tmsdk.fg.module.cleanV2;

/* JADX INFO: loaded from: classes5.dex */
public interface ICleanTaskCallBack {
    void onCleanCanceled();

    void onCleanError(int r1);

    void onCleanFinished();

    void onCleanProcessChange(int r1, String r2);

    void onCleanStarted();
}
