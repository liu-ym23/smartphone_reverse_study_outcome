package s3;

import android.os.Bundle;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements b {
    public void bindContainerId(String r5) {
        Intrinsics.checkNotNullParameter(r5, "containerId");
    }

    @Override // s3.b
    public boolean canBackPress() {
        return false;
    }

    public boolean canGoBack() {
        return false;
    }

    @Override // s3.b
    public void finish() {
    }

    public void goBack() {
    }

    public void hideError() {
    }

    public void onAttachToWindow() {
    }

    @Override // s3.b
    public void onCreate(Bundle r5) {
    }

    @Override // s3.b
    public void onEngineReady(rb.b r5) {
        Intrinsics.checkNotNullParameter(r5, "contextProviderFactory");
    }

    public void preloadSchema(String r5) {
        Intrinsics.checkNotNullParameter(r5, "schema");
    }

    public void reloadTemplate(Map<String, ? extends Object> r5) {
    }
}
