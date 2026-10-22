package com.zte.settings.backup;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes5.dex */
public class SettingsEntry implements Parcelable {
    public static final Parcelable.Creator<SettingsEntry> CREATOR = null;
    private int alarmVolume;
    private int autoRotation;
    private float fontScale;
    private boolean is24HourTimeFormate;
    private boolean isAutoTime;
    private boolean isAutoTimeZone;
    private int lockScreenSound;
    private int musicVolume;
    private String notificationRingtoneUri;
    private String powerOnOffSound;
    private int ringVolume;
    private int screenBrightness;
    private int screenBrightnessBack;
    private int screenBrightnessMode;
    private int screenBrightnessModeBack;
    private int screenOffTimeOut;
    private int toneWhenDialing;
    private int touchSound;
    private int vibrateWhenRinging;
    private int vibrateWhenTouch;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public SettingsEntry() {
    }

    static /* synthetic */ float access$002(SettingsEntry r0, float r1) {
        r0.fontScale = r1;
        return r1;
    }

    public int getVibrateWhenTouch() {
        return this.vibrateWhenTouch;
    }

    public void setVibrateWhenTouch(int r1) {
        this.vibrateWhenTouch = r1;
    }

    public String getPowerOnOffSound() {
        return this.powerOnOffSound;
    }

    public void setPowerOnOffSound(String r1) {
        this.powerOnOffSound = r1;
    }

    public String getNotificationRingtoneUri() {
        return this.notificationRingtoneUri;
    }

    public void setNotificationRingtoneUri(String r1) {
        this.notificationRingtoneUri = r1;
    }

    public int getAutoRotation() {
        return this.autoRotation;
    }

    public void setAutoRotation(int r1) {
        this.autoRotation = r1;
    }

    public int getScreenBrightnessMode() {
        return this.screenBrightnessMode;
    }

    public void setScreenBrightnessMode(int r1) {
        this.screenBrightnessMode = r1;
    }

    public int getScreenBrightness() {
        return this.screenBrightness;
    }

    public void setScreenBrightness(int r1) {
        this.screenBrightness = r1;
    }

    public int getScreenBrightnessModeBack() {
        return this.screenBrightnessModeBack;
    }

    public void setScreenBrightnessModeBack(int r1) {
        this.screenBrightnessModeBack = r1;
    }

    public int getScreenBrightnessBack() {
        return this.screenBrightnessBack;
    }

    public void setScreenBrightnessBack(int r1) {
        this.screenBrightnessBack = r1;
    }

    public int getScreenOffTimeOut() {
        return this.screenOffTimeOut;
    }

    public void setScreenOffTimeOut(int r1) {
        this.screenOffTimeOut = r1;
    }

    public int getToneWhenDialing() {
        return this.toneWhenDialing;
    }

    public void setToneWhenDialing(int r1) {
        this.toneWhenDialing = r1;
    }

    public int getLockScreenSound() {
        return this.lockScreenSound;
    }

    public void setLockScreenSound(int r1) {
        this.lockScreenSound = r1;
    }

    public int getTouchSound() {
        return this.touchSound;
    }

    public void setTouchSound(int r1) {
        this.touchSound = r1;
    }

    public int getVibrateWhenRinging() {
        return this.vibrateWhenRinging;
    }

    public void setVibrateWhenRinging(int r1) {
        this.vibrateWhenRinging = r1;
    }

    public int getRingVolume() {
        return this.ringVolume;
    }

    public void setRingVolume(int r1) {
        this.ringVolume = r1;
    }

    public int getMusicVolume() {
        return this.musicVolume;
    }

    public void setMusicVolume(int r1) {
        this.musicVolume = r1;
    }

    public int getAlarmVolume() {
        return this.alarmVolume;
    }

    public void setAlarmVolume(int r1) {
        this.alarmVolume = r1;
    }

    public boolean isAutoTime() {
        return this.isAutoTime;
    }

    public void setAutoTime(boolean r1) {
        this.isAutoTime = r1;
    }

    public boolean isAutoTimeZone() {
        return this.isAutoTimeZone;
    }

    public void setAutoTimeZone(boolean r1) {
        this.isAutoTimeZone = r1;
    }

    public boolean isIs24HourTimeFormate() {
        return this.is24HourTimeFormate;
    }

    public void setIs24HourTimeFormate(boolean r1) {
        this.is24HourTimeFormate = r1;
    }

    public float getFontScale() {
        return this.fontScale;
    }

    public void setFontScale(float r1) {
        this.fontScale = r1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeFloat(this.fontScale);
    }

    static {
        CREATOR = new AnonymousClass1();
    }
}
