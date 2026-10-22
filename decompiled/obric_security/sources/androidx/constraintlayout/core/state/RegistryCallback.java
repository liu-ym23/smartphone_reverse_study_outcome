package androidx.constraintlayout.core.state;

/* JADX INFO: loaded from: classes.dex */
public interface RegistryCallback {
    String currentLayoutInformation();

    String currentMotionScene();

    long getLastModified();

    void onDimensions(int r1, int r2);

    void onNewMotionScene(String r1);

    void onProgress(float r1);

    void setDrawDebug(int r1);

    void setLayoutInformationMode(int r1);
}
