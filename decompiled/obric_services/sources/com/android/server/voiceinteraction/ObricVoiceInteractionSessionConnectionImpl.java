package com.android.server.voiceinteraction;

import com.android.server.wm.ActivityAssistInfo;
import com.obric.internal.app.ObricAssistUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ObricVoiceInteractionSessionConnectionImpl implements IObricVoiceInteractionSessionConnection {
    public static final String COM_LARUS_NOVA = "com.larus.nova";
    private VoiceInteractionSessionConnection mBase;

    public ObricVoiceInteractionSessionConnectionImpl(VoiceInteractionSessionConnection base) {
        this.mBase = base;
    }

    public boolean forceAllowAssistDataRequest() {
        if (this.mBase.mSessionComponentName != null) goto L5;
        return false;
    L5:
        if (this.mBase.mSessionComponentName.getPackageName() != null) goto L7;
        return false;
    L7:
        return this.mBase.mSessionComponentName.getPackageName().contains(COM_LARUS_NOVA);
    }

    public boolean assistantExclude(List<ActivityAssistInfo> topActivities, int i) {
        ActivityAssistInfo assistInfo = topActivities.get(i);
        if (assistInfo.getObricExt().getWindowMode() != 5) goto L5;
    L16:
        return true;
    L5:
        if (assistInfo.getObricExt().getWindowMode() == 2) goto L16;
        if (this.mBase.mSessionComponentName.getPackageName().contains(COM_LARUS_NOVA) == true) goto L10;
    L14:
        return false;
    L10:
        if (assistInfo.getComponentName().getPackageName().equals(this.mBase.mSessionComponentName.getPackageName()) == false) goto L14;
        if (ObricAssistUtils.containsAssistantSpecialPage(assistInfo.getComponentName().getClassName()) == true) goto L14;
        return true;
    }
}
