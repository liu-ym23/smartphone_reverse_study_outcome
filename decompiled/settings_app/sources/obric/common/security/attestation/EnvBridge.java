package obric.common.security.attestation;

import android.provider.Settings;
import com.android.settings.SettingsApplication;
import com.bytedance.privacy.bridge.IEnvBridge;
import kotlin.Metadata;

/* JADX INFO: compiled from: EnvBridge.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lobric/common/security/attestation/EnvBridge;", "Lcom/bytedance/privacy/bridge/IEnvBridge;", "()V", "onIsBoeEnv", "", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class EnvBridge implements IEnvBridge {
    public EnvBridge() {
    }

    @Override // com.bytedance.privacy.bridge.IEnvBridge
    public boolean onIsBoeEnv() {
        if (Settings.Global.getInt(SettingsApplication.getContext().getContentResolver(), "matrix_env_status_is_boe", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }
}
