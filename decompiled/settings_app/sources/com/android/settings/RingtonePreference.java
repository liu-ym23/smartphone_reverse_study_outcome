package com.android.settings;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.media.RingtoneManager;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.preference.Preference;
import androidx.preference.PreferenceManager;

/* JADX INFO: loaded from: classes2.dex */
public class RingtonePreference extends Preference {
    private static final String TAG = "RingtonePreference";
    private int mRequestCode;
    private int mRingtoneType;
    private boolean mShowDefault;
    private boolean mShowSilent;

    public RingtonePreference(Context r3, AttributeSet r4) {
        super(r3, r4);
        TypedArray r5 = r3.obtainStyledAttributes(r4, com.android.internal.R.styleable.RingtonePreference, 0, 0);
        this.mRingtoneType = r5.getInt(0, 1);
        this.mShowDefault = r5.getBoolean(1, true);
        this.mShowSilent = r5.getBoolean(2, true);
        setIntent(new Intent("android.intent.action.RINGTONE_PICKER"));
        r5.recycle();
    }

    public int getRingtoneType() {
        return this.mRingtoneType;
    }

    public void setRingtoneType(int r1) {
        this.mRingtoneType = r1;
    }

    public boolean getShowDefault() {
        return this.mShowDefault;
    }

    public void setShowDefault(boolean r1) {
        this.mShowDefault = r1;
    }

    public boolean getShowSilent() {
        return this.mShowSilent;
    }

    public void setShowSilent(boolean r1) {
        this.mShowSilent = r1;
    }

    public int getRequestCode() {
        return this.mRequestCode;
    }

    public void onPrepareRingtonePickerIntent(Intent r3) {
        r3.putExtra("android.intent.extra.ringtone.EXISTING_URI", onRestoreRingtone());
        r3.putExtra("android.intent.extra.ringtone.SHOW_DEFAULT", this.mShowDefault);
        if (this.mShowDefault == false) goto L5;
        r3.putExtra("android.intent.extra.ringtone.DEFAULT_URI", RingtoneManager.getDefaultUri(getRingtoneType()));
    L5:
        r3.putExtra("android.intent.extra.ringtone.SHOW_SILENT", this.mShowSilent);
        r3.putExtra("android.intent.extra.ringtone.TYPE", this.mRingtoneType);
        r3.putExtra("android.intent.extra.ringtone.TITLE", getTitle());
        r3.putExtra("android.intent.extra.ringtone.AUDIO_ATTRIBUTES_FLAGS", 64);
    }

    protected void onSaveRingtone(Uri r1) {
        if (r1 == null) goto L4;
        String r2 = r1.toString();
    L5:
        persistString(r2);
        return;
    L4:
        r2 = "";
        goto L5
    }

    protected Uri onRestoreRingtone() {
        String r2 = getPersistedString(null);
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return null;
    L5:
        return Uri.parse(r2);
    }

    @Override // androidx.preference.Preference
    protected Object onGetDefaultValue(TypedArray r1, int r2) {
        return r1.getString(r2);
    }

    @Override // androidx.preference.Preference
    protected void onSetInitialValue(boolean r1, Object r2) {
        String r3 = (String) r2;
        if (r1 == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r3) == true) goto L9;
        onSaveRingtone(Uri.parse(r3));
        return;
    }

    @Override // androidx.preference.Preference
    protected void onAttachedToHierarchy(PreferenceManager r1) {
        super.onAttachedToHierarchy(r1);
    }

    public boolean onActivityResult(int r1, int r2, Intent r3) {
        if (r3 == null) goto L12;
        Uri r4 = (Uri) r3.getParcelableExtra("android.intent.extra.ringtone.PICKED_URI");
        if (r4 == null) goto L6;
        String r5 = r4.toString();
    L8:
        if (callChangeListener(r5) == false) goto L13;
        onSaveRingtone(r4);
        return true;
    L13:
        return true;
    L6:
        r5 = "";
        goto L8
    L12:
        return true;
    }
}
