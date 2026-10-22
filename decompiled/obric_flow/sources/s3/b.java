package s3;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.bytedance.ies.bullet.service.sdk.param.LaunchMode;
import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface b {
    boolean canBackPress();

    void close();

    void enterBackground();

    void enterForeground();

    void finish();

    LaunchMode getBDXLaunchMode();

    String getBDXTag();

    String getBid();

    String getContainerId();

    rd.b getCurrentSchema();

    View getKitView();

    rd.b getSchemaData();

    Context getSystemContext();

    String getViewType();

    WeakReference getWeakContext();

    void loadSchema(String r5, Map r10);

    void onCreate(Bundle r5);

    void onEngineReady(rb.b r5);

    void onVisibleChange(boolean r5, Boolean r10);

    void release();
}
