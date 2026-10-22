package com.android.settings.intelligent;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;
import android.text.TextUtils;
import com.obric.olog.OLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class VoicePrintRecognitionManager {
    public static final String ASSISTANT_WAKEUP_METHOD = "camera_always_on";
    private static final String TAG = "VoicePrintRecognitionManager";
    public static final String VOICEPRINT_RECOGNITION_STATUS = "voiceprint_recognition_status";
    public static final String VOICEPRINT_WAKEUP_STATUS = "voiceprint_wakeup_status";
    private final String VOICEPRINT_ENROLL_INFO;
    private ContentObserver mAssistantWakeUpMethodObserver;
    private Context mContext;
    private ArrayList<VoicePrintRecognitionChangeListener> mListeners;
    private ContentObserver mVoicePrintObserver;
    private ContentObserver mVoicePrintRecogntionInfo;

    public interface VoicePrintRecognitionChangeListener {
        void OnAssistantWakeUpMethodChanged(boolean r1);

        void OnVoicePrintRecognitionChanged(boolean r1);

        void OnVoicePrintRecognitionModelPathChanged(boolean r1);
    }

    static /* synthetic */ ArrayList access$000(VoicePrintRecognitionManager r0) {
        return r0.mListeners;
    }

    VoicePrintRecognitionManager(Context r3) {
        this.VOICEPRINT_ENROLL_INFO = "voiceprint_enroll_info";
        this.mListeners = new ArrayList();
        final Handler r1 = new Handler();
        this.mVoicePrintObserver = new AnonymousClass1(this, r1);
        final Handler r2 = new Handler();
        this.mVoicePrintRecogntionInfo = new AnonymousClass2(this, r2);
        final Handler r4 = new Handler();
        this.mAssistantWakeUpMethodObserver = new AnonymousClass3(this, r4);
        this.mContext = r3;
    }

    public void addListener(VoicePrintRecognitionChangeListener r2) {
        if (this.mListeners.size() != 0) goto L6;
        registerObserver();
    L6:
        if (this.mListeners.contains(r2) == true) goto L9;
        this.mListeners.add(r2);
        return;
    }

    public void removeListener(VoicePrintRecognitionChangeListener r2) {
        if (this.mListeners.contains(r2) == false) goto L6;
        this.mListeners.remove(r2);
    L6:
        if (this.mListeners.size() != 0) goto L9;
        unRegisterObserver();
        return;
    }

    private void registerObserver() {
        OLog.d(TAG, "register observer for voiceprint_recognition_status");
        this.mContext.getContentResolver().registerContentObserver(Settings.Global.getUriFor(VOICEPRINT_WAKEUP_STATUS), true, this.mVoicePrintObserver);
        this.mContext.getContentResolver().registerContentObserver(Settings.Global.getUriFor(VOICEPRINT_RECOGNITION_STATUS), true, this.mVoicePrintObserver);
        this.mContext.getContentResolver().registerContentObserver(Settings.Global.getUriFor("voiceprint_enroll_info"), true, this.mVoicePrintRecogntionInfo);
        this.mContext.getContentResolver().registerContentObserver(Settings.Global.getUriFor("camera_always_on"), true, this.mAssistantWakeUpMethodObserver);
    }

    private void unRegisterObserver() {
        OLog.d(TAG, "unregister observer for voiceprint_recognition_status");
        this.mContext.getContentResolver().unregisterContentObserver(this.mVoicePrintObserver);
        this.mContext.getContentResolver().unregisterContentObserver(this.mAssistantWakeUpMethodObserver);
        this.mContext.getContentResolver().unregisterContentObserver(this.mVoicePrintRecogntionInfo);
    }

    public boolean getSpeechVoicePrintState() {
        if (Settings.Global.getInt(this.mContext.getContentResolver(), VOICEPRINT_RECOGNITION_STATUS, 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    public void setSpeechVoicePrintState(boolean r2) {
        Settings.Global.putInt(this.mContext.getContentResolver(), VOICEPRINT_RECOGNITION_STATUS, r2 ? 1 : 0);
    }

    public boolean getWakeupVoicePrintState() {
        if (Settings.Global.getInt(this.mContext.getContentResolver(), VOICEPRINT_WAKEUP_STATUS, 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    public void setWakeupVoicePrintState(boolean r2) {
        Settings.Global.putInt(this.mContext.getContentResolver(), VOICEPRINT_WAKEUP_STATUS, r2 ? 1 : 0);
    }

    public boolean hasRecordVoicePrint() {
        String r7 = Settings.Global.getString(this.mContext.getContentResolver(), "voiceprint_enroll_info");
        if (TextUtils.isEmpty(r7) == false) goto L20;
        return false;
    L20:
        JSONObject r1 = new JSONObject(r7);     // Catch: JSONException -> L17
        String r8 = r1.optString("uuid");     // Catch: JSONException -> L17
        long r3 = r1.optLong("timestamp");     // Catch: JSONException -> L17
        String r2 = r1.optString("engine-version");     // Catch: JSONException -> L17
        OLog.d(TAG, "hasRecordVoicePrint uuid:" + r8 + " timestamp:" + r3 + " version:" + r2);     // Catch: JSONException -> L17
        if (TextUtils.isEmpty(r8) == false) goto L8;
    L16:
        return false;
    L8:
        if (r8.length() < 2) goto L16;
        if (r3 == 0) goto L16;
        if (TextUtils.isEmpty(r2) == true) goto L16;
        return true;
    L17:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public void startVoicePrintRecognition() {
        Intent r0 = new Intent();
        r0.setClassName("com.obric.assistant", "com.obric.sva.sdk.enroll.ui.VoicePrintEnrollActivity");
        this.mContext.startActivity(r0);     // Catch: ActivityNotFoundException -> L5
        return;
    L5:
        OLog.e(TAG, "can not find DefaultTrainingActivity");
    }
}
