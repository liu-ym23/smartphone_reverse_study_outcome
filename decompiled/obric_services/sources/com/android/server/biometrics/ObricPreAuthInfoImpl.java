package com.android.server.biometrics;

import com.android.server.voiceinteraction.ObricVoiceInteractionSessionConnectionImpl;

/* JADX INFO: loaded from: classes.dex */
public class ObricPreAuthInfoImpl implements IObricPreAuthInfo {
    public ObricPreAuthInfoImpl() {
    }

    public boolean forceAllowFace(int modality, String opPackageName, int requestedStrength) {
        if (modality == 8) goto L5;
    L9:
        return false;
    L5:
        if (ObricVoiceInteractionSessionConnectionImpl.COM_LARUS_NOVA.equals(opPackageName) == false) goto L9;
        if (requestedStrength != 255) goto L9;
        return true;
    }
}
