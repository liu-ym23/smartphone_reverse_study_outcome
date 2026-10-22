package com.android.server.voiceinteraction;

import android.os.Bundle;
import android.util.Slog;
import com.android.server.LocalServices;
import com.android.server.wm.IObricWindowManagerInternal;
import com.android.server.wm.WindowManagerInternal;

/* JADX INFO: loaded from: classes.dex */
public class ObricVoiceInteractionManagerServiceImpl implements IObricVoiceInteractionManagerService {
    private static final String TAG = "ObricVoiceInteractionManagerServiceImpl";
    private VoiceInteractionManagerService mService;

    public ObricVoiceInteractionManagerServiceImpl(VoiceInteractionManagerService base) {
        this.mService = base;
    }

    public int adjustSessionSourceFlags(Bundle args, int sourceFlags) {
        if (args == null) goto L8;
        if (args.containsKey("custom_show_flags") == false) goto L8;
        int finalFlags = sourceFlags | args.getInt("custom_show_flags", 3);
        Slog.d(TAG, "showSessionForActiveService flags=" + finalFlags + " args=" + args);
        return finalFlags;
    L8:
        return sourceFlags | 3;
    }

    public void fillActiveServiceDisplayId(Bundle args) {
        if (args != null) goto L4;
        return;
    L4:
        WindowManagerInternal wmInternal = (WindowManagerInternal) LocalServices.getService(WindowManagerInternal.class);
        if (wmInternal == null) goto L7;
        IObricWindowManagerInternal obricWm = wmInternal.getObricWindowManagerInternal();
    L8:
        if (obricWm != null) goto L10;
        return;
    L10:
        int displayId = obricWm.getAllowlistedAssistSourceDisplayId();
        if (displayId == (-1)) goto L16;
        if (displayId == 0) goto L17;
        args.putInt("display_id", displayId);
        return;
    L17:
        return;
    L16:
        return;
    L7:
        obricWm = null;
        goto L8
    }
}
