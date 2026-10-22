package com.android.settings.intelligent;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;
import com.obric.olog.OLog;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class VoiceWakeupManager {
    private static final String TAG = "VoiceWakeupManager";
    public static final String VOICE_ASSISTANT_WAKEUP_STATUS = "voice_assistant_wakeup_status";
    private static VoiceWakeupManager mVoiceWakeupManager;
    private Context mContext;
    private ArrayList<WakeupChangeListener> mListeners;
    private ContentObserver mWakeupObserver;

    public interface WakeupChangeListener {
        void wakeupChanged(boolean r1);
    }

    static {
    }

    static /* synthetic */ ArrayList access$000(VoiceWakeupManager r0) {
        return r0.mListeners;
    }

    public boolean isVoiceWakeupOn() {
        if (Settings.Global.getInt(this.mContext.getContentResolver(), VOICE_ASSISTANT_WAKEUP_STATUS, 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    private VoiceWakeupManager(Context r3) {
        this.mListeners = new ArrayList();
        final Handler r1 = new Handler();
        this.mWakeupObserver = new AnonymousClass1(this, r1);
        this.mContext = r3;
    }

    public static VoiceWakeupManager getInstance(Context r1) {
        if (mVoiceWakeupManager != null) goto L6;
        mVoiceWakeupManager = new VoiceWakeupManager(r1);
    L6:
        return mVoiceWakeupManager;
    }

    public void addListener(WakeupChangeListener r2) {
        if (this.mListeners.size() != 0) goto L6;
        registerObserver();
    L6:
        if (this.mListeners.contains(r2) == true) goto L9;
        this.mListeners.add(r2);
        return;
    }

    public void removeListener(WakeupChangeListener r2) {
        if (this.mListeners.contains(r2) == false) goto L6;
        this.mListeners.remove(r2);
    L6:
        if (this.mListeners.size() != 0) goto L9;
        unRegisterObserver();
        return;
    }

    private void registerObserver() {
        OLog.d(TAG, "register observer for voice_assistant_wakeup_status");
        this.mContext.getContentResolver().registerContentObserver(Settings.Global.getUriFor(VOICE_ASSISTANT_WAKEUP_STATUS), true, this.mWakeupObserver);
    }

    private void unRegisterObserver() {
        OLog.d(TAG, "unregister observer for voice_assistant_wakeup_status");
        this.mContext.getContentResolver().unregisterContentObserver(this.mWakeupObserver);
    }
}
