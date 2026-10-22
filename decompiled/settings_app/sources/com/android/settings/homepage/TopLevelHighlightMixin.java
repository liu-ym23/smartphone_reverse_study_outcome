package com.android.settings.homepage;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.android.settings.SettingsActivity;
import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes2.dex */
public class TopLevelHighlightMixin implements Parcelable, DialogInterface.OnShowListener, DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    public static final Parcelable.Creator<TopLevelHighlightMixin> CREATOR = null;
    private static final String TAG = "TopLevelHighlightMixin";
    private boolean mActivityEmbedded;
    private String mCurrentKey;
    private DialogInterface mDialog;
    private String mHiddenKey;
    private String mPreviousKey;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public TopLevelHighlightMixin(boolean r1) {
        this.mActivityEmbedded = r1;
    }

    public TopLevelHighlightMixin(Parcel r2) {
        this.mCurrentKey = r2.readString();
        this.mPreviousKey = r2.readString();
        this.mHiddenKey = r2.readString();
        this.mActivityEmbedded = r2.readBoolean();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.mCurrentKey);
        r1.writeString(this.mPreviousKey);
        r1.writeString(this.mHiddenKey);
        r1.writeBoolean(this.mActivityEmbedded);
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface r1) {
        this.mDialog = r1;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface r1) {
        this.mDialog = null;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface r1) {
        this.mCurrentKey = this.mPreviousKey;
        this.mPreviousKey = null;
    }

    void setActivityEmbedded(boolean r1) {
        this.mActivityEmbedded = r1;
    }

    boolean isActivityEmbedded() {
        return this.mActivityEmbedded;
    }

    public String getHighlightPreferenceKey() {
        return this.mCurrentKey;
    }

    private static String getHighlightPrefKeyFromArguments(Bundle r4) {
        String r5 = r4.getString(SettingsActivity.EXTRA_FRAGMENT_ARG_KEY);
        String r0 = HighlightableMenu.lookupPreferenceKey(r5);
        if (TextUtils.isEmpty(r0) == false) goto L5;
        OLog.e(TAG, "Invalid highlight menu key: " + r5);
    L6:
        return r0;
    L5:
        OLog.d(TAG, "Menu key: " + r5);
        goto L6
    }

    private void ensureDialogDismissed() {
        DialogInterface r0 = this.mDialog;
        if (r0 == null) goto L6;
        onCancel(r0);
        this.mDialog.dismiss();
        return;
    }
}
