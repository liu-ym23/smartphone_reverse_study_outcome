package tmsdk.fg.module.spacemanager;

/* JADX INFO: loaded from: classes5.dex */
public interface ISpaceScanListener {
    void onCancelFinished();

    void onFinish(int r1, Object r2);

    void onFound(Object r1);

    void onProgressChanged(int r1);

    void onStart();
}
