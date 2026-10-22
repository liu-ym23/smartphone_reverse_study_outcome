package com.android.settings;

import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes2.dex */
public class DefaultRingtonePreference extends android.preference.RingtonePreference {
    private static final String TAG = "DefaultRingtonePreference";

    public DefaultRingtonePreference(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    @Override // android.preference.RingtonePreference
    public void onPrepareRingtonePickerIntent(Intent r2) {
        super.onPrepareRingtonePickerIntent(r2);
        r2.putExtra("android.intent.extra.ringtone.SHOW_DEFAULT", false);
    }

    @Override // android.preference.RingtonePreference
    protected void onSaveRingtone(Uri r2) {
        RingtoneManager.setActualDefaultRingtoneUri(getContext(), getRingtoneType(), r2);
    }

    @Override // android.preference.RingtonePreference
    protected Uri onRestoreRingtone() {
        return RingtoneManager.getActualDefaultRingtoneUri(getContext(), getRingtoneType());
    }
}
