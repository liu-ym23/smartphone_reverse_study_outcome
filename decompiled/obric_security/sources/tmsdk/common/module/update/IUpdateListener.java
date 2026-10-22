package tmsdk.common.module.update;

/* JADX INFO: loaded from: classes5.dex */
public interface IUpdateListener {
    void onProgressChanged(UpdateInfo r1, int r2);

    void onUpdateCanceled();

    void onUpdateEvent(UpdateInfo r1, int r2);

    void onUpdateFinished();

    void onUpdateStarted();
}
