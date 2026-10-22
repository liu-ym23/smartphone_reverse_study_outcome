package com.android.settings.applications;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.settings.R;
import com.android.settings.utils.HanziToPinyin;
import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes2.dex */
public class AppViewHolder {
    public ImageView appIcon;
    public TextView appName;
    public TextView disabled;
    public com.android.settingslib.applications.ApplicationsState.AppEntry entry;
    public View rootView;
    public TextView summary;

    public AppViewHolder() {
    }

    public static AppViewHolder createOrRecycle(LayoutInflater r2, View r3) {
        if (r3 != null) goto L6;
        View r4 = r2.inflate(R.layout.preference_app, null);
        r2.inflate(R.layout.widget_text_views, (ViewGroup) r4.findViewById(android.R.id.widget_frame));
        AppViewHolder r5 = new AppViewHolder();
        r5.rootView = r4;
        r5.appName = (TextView) r4.findViewById(android.R.id.title);
        r5.appIcon = (ImageView) r4.findViewById(android.R.id.icon);
        r5.summary = (TextView) r4.findViewById(R.id.widget_text1);
        r5.disabled = (TextView) r4.findViewById(R.id.widget_text2);
        r4.setTag(r5);
        return r5;
    L6:
        return (AppViewHolder) r3.getTag();
    }

    void updateSizeText(CharSequence r5, int r6) {
        if (ManageApplications.DEBUG == false) goto L6;
        OLog.i("ManageApplications", "updateSizeText of " + this.entry.label + HanziToPinyin.Token.SEPARATOR + this.entry + ": " + this.entry.sizeStr);
    L6:
        if (this.entry.sizeStr == null) goto L15;
        if (r6 != 1) goto L10;
        this.summary.setText(this.entry.internalSizeStr);
        return;
    L10:
        if (r6 == 2) goto L12;
        this.summary.setText(this.entry.sizeStr);
        return;
    L12:
        this.summary.setText(this.entry.externalSizeStr);
        return;
    L15:
        if (this.entry.size != (-2)) goto L21;
        this.summary.setText(r5);
        return;
    }
}
