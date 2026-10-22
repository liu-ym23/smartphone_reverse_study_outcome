package com.android.settings;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class InputPasswordMediator {
    private AudioManager mAudioManager;
    private Context mContext;
    private float mLockPinVolume;
    private int mMasterStreamType;
    private int mPinKeySoundId;
    private int mPinKeySoundStreamId;
    private SoundPool mPinKeySounds;

    public InputPasswordMediator(Context r4) {
        this.mContext = r4;
        this.mLockPinVolume = r4.getResources().getInteger(android.R.integer.config_maxNumVisibleRecentTasks) * 17;
        SoundPool r0 = new SoundPool(1, 1, 0);
        this.mPinKeySounds = r0;
        this.mPinKeySoundId = r0.load(r4, R.raw.pin_key_sound, 1);
    }

    public void playPinKeyboardSound() {
        this.mPinKeySounds.stop(this.mPinKeySoundStreamId);
        if (this.mAudioManager != null) goto L9;
        AudioManager r0 = (AudioManager) this.mContext.getSystemService("audio");
        this.mAudioManager = r0;
        if (r0 != null) goto L7;
        return;
    L7:
        this.mMasterStreamType = 0;
    L9:
        if (this.mAudioManager.isStreamMute(this.mMasterStreamType) == false) goto L12;
        return;
    L12:
        if (this.mLockPinVolume >= 0.0f) goto L14;
        this.mLockPinVolume = 1.0f;
    L14:
        SoundPool r1 = this.mPinKeySounds;
        int r2 = this.mPinKeySoundId;
        float r4 = this.mLockPinVolume;
        this.mPinKeySoundStreamId = r1.play(r2, r4, r4, 1, 0, 1.0f);
    }

    public void setSoundEffectsEnabled(boolean r3, View... r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        int r2 = r4.length;
        int r0 = 0;
    L5:
        if (r0 >= r2) goto L7;
        r4[r0].setSoundEffectsEnabled(r3);
        r0 = r0 + 1;
        goto L5
    }

    public void release() {
        SoundPool r0 = this.mPinKeySounds;
        if (r0 == null) goto L6;
        r0.release();
        return;
    }
}
