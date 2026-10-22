package com.android.settings.eldership;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.Settings;
import android.text.TextUtils;
import com.android.settings.ExecutorManager;
import com.android.settings.FontScaleSettingsActivity;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.base.BaseFragment;
import com.obric.olog.OLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import obric.app.settings.search.SettingsSwitchKeyUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class WizardEldershipSettingsBehavior implements IEldershipSettingsBehavior {
    private static final String ORIGINAL_ELDERSHIP_SETTING_FILE = "eldership_original_setting.json";
    private static final int REQUEST_CODE_FONT_SIZE_SETTING = 2;
    private static final int REQUEST_CODE_LAUNCHER_SETTING = 1;
    private static final String TAG = "WizardEldershipSettingsBehavior";
    private Context mContext;
    private SettingsEntry mEldershipSettingsEntry;
    private final Handler mHandler;
    private BaseFragment mHostFragment;
    private SettingsEntry mMyselfSettingsEntry;

    private static class SettingsEntry implements Parcelable {
        public static final Parcelable.Creator<SettingsEntry> CREATOR = null;
        boolean mEldershipModeEnable;
        float mFontSize;
        int mLauncherMode;
        int mLauncherTheme;
        boolean mMuteDoubleCheckEnable;
        boolean mOneStepEnable;
        private boolean mSettingsSaved;
        boolean mTextBoomEnable;
        boolean mthinkboostEnable;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        static /* synthetic */ boolean access$002(SettingsEntry r0, boolean r1) {
            r0.mSettingsSaved = r1;
            return r1;
        }

        public void saveSettings(final Context r2, final Runnable r3) {
            ExecutorManager.execute(new AnonymousClass1(this, r2, r3));
        }

        public boolean areSettingsSaved() {
            monitor-enter(this);
            boolean r0 = this.mSettingsSaved;     // Catch: Throwable -> L6
            monitor-exit(this);     // Catch: Throwable -> L6
            return r0;
        L6:
            th = move-exception;
            throw th;
        }

        public String toJson() {
            JSONObject r1 = new JSONObject();     // Catch: JSONException -> L5
            r1.put("mEldershipModeEnable", this.mEldershipModeEnable);     // Catch: JSONException -> L5
            r1.put("mMuteDoubleCheckEnable", this.mMuteDoubleCheckEnable);     // Catch: JSONException -> L5
            r1.put("mTextBoomEnable", this.mTextBoomEnable);     // Catch: JSONException -> L5
            r1.put("mOneStepEnable", this.mOneStepEnable);     // Catch: JSONException -> L5
            r1.put("mthinkboostEnable", this.mthinkboostEnable);     // Catch: JSONException -> L5
            r1.put("mFontSize", this.mFontSize);     // Catch: JSONException -> L5
            r1.put("mLauncherMode", this.mLauncherMode);     // Catch: JSONException -> L5
            r1.put("mLauncherTheme", this.mLauncherTheme);     // Catch: JSONException -> L5
            String r5 = r1.toString();     // Catch: JSONException -> L5
            OLog.d(WizardEldershipSettingsBehavior.TAG, "settings entry to json : " + r5);     // Catch: JSONException -> L5
            return r5;
        L5:
            e = move-exception;
            e.printStackTrace();
            return null;
        }

        public static SettingsEntry fromJson(String r4) {
            OLog.d(WizardEldershipSettingsBehavior.TAG, "settings entry from json : " + r4);
            if (TextUtils.isEmpty(r4) == false) goto L10;
            return null;
        L10:
            JSONObject r0 = new JSONObject(r4);     // Catch: JSONException -> L7
            SettingsEntry r5 = new SettingsEntry();     // Catch: JSONException -> L7
            r5.mEldershipModeEnable = r0.getBoolean("mEldershipModeEnable");     // Catch: JSONException -> L7
            r5.mMuteDoubleCheckEnable = r0.getBoolean("mMuteDoubleCheckEnable");     // Catch: JSONException -> L7
            r5.mTextBoomEnable = r0.getBoolean("mTextBoomEnable");     // Catch: JSONException -> L7
            r5.mOneStepEnable = r0.getBoolean("mOneStepEnable");     // Catch: JSONException -> L7
            r5.mthinkboostEnable = r0.getBoolean("mthinkboostEnable");     // Catch: JSONException -> L7
            r5.mFontSize = (float) r0.getDouble("mFontSize");     // Catch: JSONException -> L7
            r5.mLauncherMode = r0.getInt("mLauncherMode");     // Catch: JSONException -> L7
            r5.mLauncherTheme = r0.getInt("mLauncherTheme");     // Catch: JSONException -> L7
            return r5;
        L7:
            e = move-exception;
            e.printStackTrace();
            return null;
        }

        public SettingsEntry() {
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            r1.writeByte(this.mEldershipModeEnable ? 1 : 0);
            r1.writeByte(this.mMuteDoubleCheckEnable ? 1 : 0);
            r1.writeByte(this.mTextBoomEnable ? 1 : 0);
            r1.writeByte(this.mOneStepEnable ? 1 : 0);
            r1.writeByte(this.mthinkboostEnable ? 1 : 0);
            r1.writeFloat(this.mFontSize);
            r1.writeInt(this.mLauncherMode);
            r1.writeInt(this.mLauncherTheme);
            r1.writeByte(this.mSettingsSaved ? 1 : 0);
        }

        protected SettingsEntry(Parcel r4) {
            boolean r1 = true;
            if (r4.readByte() == 0) goto L5;
            boolean r0 = true;
        L6:
            this.mEldershipModeEnable = r0;
            if (r4.readByte() == 0) goto L9;
            boolean r2 = true;
        L10:
            this.mMuteDoubleCheckEnable = r2;
            if (r4.readByte() == 0) goto L13;
            boolean r3 = true;
        L14:
            this.mTextBoomEnable = r3;
            if (r4.readByte() == 0) goto L17;
            boolean r5 = true;
        L18:
            this.mOneStepEnable = r5;
            if (r4.readByte() == 0) goto L21;
            boolean r6 = true;
        L22:
            this.mthinkboostEnable = r6;
            this.mFontSize = r4.readFloat();
            this.mLauncherMode = r4.readInt();
            this.mLauncherTheme = r4.readInt();
            if (r4.readByte() != 0) goto L26;
            r1 = false;
        L26:
            this.mSettingsSaved = r1;
            return;
        L21:
            r6 = false;
            goto L22
        L17:
            r5 = false;
            goto L18
        L13:
            r3 = false;
            goto L14
        L9:
            r2 = false;
            goto L10
        L5:
            r0 = false;
            goto L6
        }

        static {
            CREATOR = new AnonymousClass2();
        }
    }

    @Override // com.android.settings.eldership.IEldershipSettingsBehavior
    public CharSequence getScreenZoom() {
        return null;
    }

    @Override // com.android.settings.eldership.IEldershipSettingsBehavior
    public void startScreenZoomSetting() {
    }

    static /* synthetic */ Handler access$100(WizardEldershipSettingsBehavior r0) {
        return r0.mHandler;
    }

    public WizardEldershipSettingsBehavior(BaseFragment r2, Bundle r3) {
        this.mHostFragment = r2;
        this.mContext = r2.getContext();
        this.mHandler = new Handler(Looper.getMainLooper());
        initMyselfSettingsEntry(r3);
        initEldershipSettingsEntry(r3);
    }

    private void initMyselfSettingsEntry(Bundle r5) {
        if (r5 == null) goto L5;
        this.mMyselfSettingsEntry = (SettingsEntry) r5.getParcelable("mMyselfSettingsEntry");
    L5:
        if (this.mMyselfSettingsEntry != null) goto L8;
        this.mMyselfSettingsEntry = readOriginalSettingsFromFile();
    L8:
        if (this.mMyselfSettingsEntry != null) goto L22;
        this.mMyselfSettingsEntry = new SettingsEntry();
        ContentResolver r6 = this.mContext.getContentResolver();
        boolean r1 = false;
        this.mMyselfSettingsEntry.mEldershipModeEnable = false;
        this.mMyselfSettingsEntry.mMuteDoubleCheckEnable = false;
        SettingsEntry r0 = this.mMyselfSettingsEntry;
        if (Settings.Global.getInt(r6, "text_boom", 1) != 1) goto L12;
        boolean r2 = true;
    L13:
        r0.mTextBoomEnable = r2;
        SettingsEntry r3 = this.mMyselfSettingsEntry;
        if (Settings.Global.getInt(r6, "side_bar_mode", 1) != 1) goto L16;
        boolean r4 = true;
    L17:
        r3.mOneStepEnable = r4;
        SettingsEntry r7 = this.mMyselfSettingsEntry;
        if (Settings.Global.getInt(r6, SettingsSwitchKeyUtil.VOICE_INPUT, 1) != 1) goto L20;
        r1 = true;
    L20:
        r7.mthinkboostEnable = r1;
        this.mMyselfSettingsEntry.mFontSize = Utils.getCurrentFontScale();
        this.mMyselfSettingsEntry.mLauncherMode = Utils.getCurrentLauncherMode(this.mContext);
        this.mMyselfSettingsEntry.mLauncherTheme = Utils.getCurrentLauncherTheme(this.mContext);
        writeOriginalSettingsToFile(this.mMyselfSettingsEntry);
        return;
    L16:
        r4 = false;
        goto L17
    L12:
        r2 = false;
        goto L13
    }

    private void initEldershipSettingsEntry(Bundle r2) {
        if (r2 == null) goto L5;
        this.mEldershipSettingsEntry = (SettingsEntry) r2.getParcelable("mEldershipSettingsEntry");
    L5:
        if (this.mEldershipSettingsEntry != null) goto L8;
        setEldershipSettingsToDefault();
        return;
    }

    public void setEldershipSettingsToDefault() {
        if (this.mEldershipSettingsEntry != null) goto L5;
        this.mEldershipSettingsEntry = new SettingsEntry();
    L5:
        SettingsEntry.access$002(this.mEldershipSettingsEntry, false);
        this.mEldershipSettingsEntry.mEldershipModeEnable = false;
        this.mEldershipSettingsEntry.mMuteDoubleCheckEnable = true;
        this.mEldershipSettingsEntry.mTextBoomEnable = false;
        this.mEldershipSettingsEntry.mOneStepEnable = false;
        this.mEldershipSettingsEntry.mthinkboostEnable = false;
        SettingsEntry r0 = this.mEldershipSettingsEntry;
        r0.mFontSize = EldershipUtils.getDefaultEldershipFontSize(this.mContext);
        SettingsEntry r1 = this.mEldershipSettingsEntry;
        r1.mLauncherMode = EldershipUtils.getDefaultEldershipLauncherMode();
        this.mEldershipSettingsEntry.mLauncherTheme = 1;
    }

    @Override // com.android.settings.eldership.IEldershipSettingsBehavior
    public void onSaveInstanceState(Bundle r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        r3.putParcelable("mEldershipSettingsEntry", this.mEldershipSettingsEntry);
        r3.putParcelable("mMyselfSettingsEntry", this.mMyselfSettingsEntry);
    }

    public void saveSettings(Runnable r2) {
        if (isEldershipModeEnable() == false) goto L5;
        saveEntrySettings(this.mEldershipSettingsEntry, r2);
        return;
    L5:
        saveEntrySettings(this.mMyselfSettingsEntry, r2);
    }

    private void saveEntrySettings(SettingsEntry r3, final Runnable r4) {
        Context r0 = this.mContext;
        if (r4 != null) goto L5;
        Runnable r2 = null;
    L6:
        r3.saveSettings(r0, r2);
        return;
    L5:
        r2 = new AnonymousClass1(this, r4);
        goto L6
    }

    public boolean areEldershipSettingsSaved() {
        return this.mEldershipSettingsEntry.areSettingsSaved();
    }

    @Override // com.android.settings.eldership.IEldershipSettingsBehavior
    public void startLauncherSetting() {
        Intent r0 = new Intent(this.mContext, com.android.settings.Settings.EldershipLauncherSettingActivity.class);
        r0.putExtra(EldershipLauncherSettingFragment.EXTRA_LAUNCHER_MODE, this.mEldershipSettingsEntry.mLauncherMode);
        r0.putExtra(EldershipLauncherSettingFragment.EXTRA_LAUNCHER_THEME, this.mEldershipSettingsEntry.mLauncherTheme);
        r0.putExtra("extra_request_as_result", true);
        r0.putExtra("back_text_id", R.string.eldership_mode_settings_setup_wizard_title);
        Utils.startActivity(this.mHostFragment, r0, 1);
    }

    @Override // com.android.settings.eldership.IEldershipSettingsBehavior
    public void startFontSizeSetting() {
        Intent r0 = new Intent(this.mContext, FontScaleSettingsActivity.class);
        r0.putExtra("extra_request_as_result", true);
        r0.putExtra(FontScaleSettingsActivity.EXTRA_FONT_SIZE, this.mEldershipSettingsEntry.mFontSize);
        r0.putExtra("back_text_id", R.string.eldership_mode_settings_setup_wizard_title);
        Utils.startActivity(this.mHostFragment, r0, 2);
    }

    @Override // com.android.settings.eldership.IEldershipSettingsBehavior
    public void handleSubSettingsResult(int r2, int r3, Bundle r4) {
        if (r3 != (-1)) goto L14;
        if (r4 != null) goto L7;
        return;
    L7:
        if (r2 != 1) goto L9;
        SettingsEntry r5 = this.mEldershipSettingsEntry;
        r5.mLauncherMode = r4.getInt(EldershipLauncherSettingFragment.EXTRA_LAUNCHER_MODE, r5.mLauncherMode);
        SettingsEntry r1 = this.mEldershipSettingsEntry;
        r1.mLauncherTheme = r4.getInt(EldershipLauncherSettingFragment.EXTRA_LAUNCHER_THEME, r1.mLauncherTheme);
        return;
    L9:
        if (r2 != 2) goto L17;
        SettingsEntry r6 = this.mEldershipSettingsEntry;
        r6.mFontSize = r4.getFloat(FontScaleSettingsActivity.EXTRA_FONT_SIZE, r6.mFontSize);
        return;
    L17:
        return;
    }

    @Override // com.android.settings.eldership.IEldershipSettingsBehavior
    public CharSequence getLauncherSetting() {
        return EldershipUtils.getLauncherSettingSubTitle(this.mContext, this.mEldershipSettingsEntry.mLauncherMode, this.mEldershipSettingsEntry.mLauncherTheme);
    }

    @Override // com.android.settings.eldership.IEldershipSettingsBehavior
    public CharSequence getFontSize() {
        return Utils.getFontScaleStr(this.mContext, this.mEldershipSettingsEntry.mFontSize);
    }

    @Override // com.android.settings.eldership.IEldershipSettingsBehavior
    public boolean isEldershipModeEnable() {
        return this.mEldershipSettingsEntry.mEldershipModeEnable;
    }

    @Override // com.android.settings.eldership.IEldershipSettingsBehavior
    public void setEldershipModeEnable(boolean r1) {
        this.mEldershipSettingsEntry.mEldershipModeEnable = r1;
    }

    @Override // com.android.settings.eldership.IEldershipSettingsBehavior
    public boolean isMuteDoubleCheckEnable() {
        return this.mEldershipSettingsEntry.mMuteDoubleCheckEnable;
    }

    @Override // com.android.settings.eldership.IEldershipSettingsBehavior
    public void setMuteDoubleCheckEnable(boolean r1) {
        this.mEldershipSettingsEntry.mMuteDoubleCheckEnable = r1;
    }

    @Override // com.android.settings.eldership.IEldershipSettingsBehavior
    public boolean isTextBoomEnable() {
        return this.mEldershipSettingsEntry.mTextBoomEnable;
    }

    @Override // com.android.settings.eldership.IEldershipSettingsBehavior
    public void setTextBoomEnable(boolean r1) {
        this.mEldershipSettingsEntry.mTextBoomEnable = r1;
    }

    @Override // com.android.settings.eldership.IEldershipSettingsBehavior
    public boolean isOneStepEnable() {
        return this.mEldershipSettingsEntry.mOneStepEnable;
    }

    @Override // com.android.settings.eldership.IEldershipSettingsBehavior
    public void setOneStepEnable(boolean r1) {
        this.mEldershipSettingsEntry.mOneStepEnable = r1;
    }

    @Override // com.android.settings.eldership.IEldershipSettingsBehavior
    public boolean isthinkboostEnable() {
        return this.mEldershipSettingsEntry.mthinkboostEnable;
    }

    @Override // com.android.settings.eldership.IEldershipSettingsBehavior
    public void setthinkboostEnable(boolean r1) {
        this.mEldershipSettingsEntry.mthinkboostEnable = r1;
    }

    private void writeOriginalSettingsToFile(SettingsEntry r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        FileOutputStream r0 = null;
        File r3 = getOriginalSettingsFile(this.mContext);     // Catch: Throwable -> L13 IOException -> L15
        deleteFileIfExists(r3);     // Catch: Throwable -> L13 IOException -> L15
        FileOutputStream r1 = new FileOutputStream(r3, false);     // Catch: Throwable -> L13 IOException -> L15
        r1.write(r4.toJson().getBytes());     // Catch: Throwable -> L9 IOException -> L11
        r1.flush();     // Catch: Throwable -> L9 IOException -> L11
        r1.close();     // Catch: IOException -> L20
    L29:
    L34:
        return;
    L11:
        e = e;
        r0 = r1;
    L16:
        e.printStackTrace();     // Catch: Throwable -> L13
        if (r0 == null) goto L34;
        r0.close();     // Catch: IOException -> L20
    L9:
        th = th;
        r0 = r1;
    L23:
        if (r0 != null) goto L32;
    L28:
        throw th;
    L32:
        r0.close();     // Catch: IOException -> L26
    L26:
        e = move-exception;
        e.printStackTrace();
    L20:
        e = move-exception;
        e.printStackTrace();
    L15:
        e = e;
    L13:
        th = th;
        goto L23
    }

    private SettingsEntry readOriginalSettingsFromFile() {
        FileInputStream r0 = null;
        File r6 = getOriginalSettingsFile(this.mContext);     // Catch: Throwable -> L20 IOException -> L22
        if (r6.exists() == true) goto L7;
        OLog.d(TAG, "eldership original setting from file NOT exists");     // Catch: Throwable -> L20 IOException -> L22
        return null;
    L7:
        FileInputStream r1 = new FileInputStream(r6);     // Catch: Throwable -> L20 IOException -> L22
        StringBuilder r7 = new StringBuilder();     // Catch: IOException -> L18 Throwable -> L31
        byte[] r2 = new byte[1024];     // Catch: IOException -> L18 Throwable -> L31
    L9:
        int r3 = r1.read(r2);     // Catch: IOException -> L18 Throwable -> L31
        if (r3 == (-1)) goto L12;
        r7.append(new String(r2, 0, r3));     // Catch: IOException -> L18 Throwable -> L31
        goto L9
    L12:
        SettingsEntry r8 = SettingsEntry.fromJson(r7.toString());     // Catch: IOException -> L18 Throwable -> L31
        r1.close();     // Catch: IOException -> L15
    L17:
        return r8;
    L15:
        e = move-exception;
        e.printStackTrace();
    L18:
        e = e;
    L24:
        e.printStackTrace();     // Catch: Throwable -> L31
        if (r1 != null) goto L41;
    L30:
        return null;
    L41:
        r1.close();     // Catch: IOException -> L28
    L28:
        e = move-exception;
        e.printStackTrace();
    L31:
        th = th;
        r0 = r1;
    L33:
        if (r0 != null) goto L43;
    L38:
        throw th;
    L43:
        r0.close();     // Catch: IOException -> L36
    L36:
        e = move-exception;
        e.printStackTrace();
    L22:
        e = e;
        r1 = null;
    L20:
        th = th;
        goto L33
    }

    private static File getOriginalSettingsFile(Context r2) {
        return new File(r2.getFilesDir(), ORIGINAL_ELDERSHIP_SETTING_FILE);
    }

    private static void deleteFileIfExists(File r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.exists() == false) goto L7;
        OLog.d(TAG, r3.delete() + " delete file : " + r3.getAbsolutePath());
        return;
    L7:
        OLog.d(TAG, "not exist file : " + r3.getAbsolutePath());
    }

    public static void deleteOriginalSettingsFile(Context r0) {
        deleteFileIfExists(getOriginalSettingsFile(r0));
    }
}
