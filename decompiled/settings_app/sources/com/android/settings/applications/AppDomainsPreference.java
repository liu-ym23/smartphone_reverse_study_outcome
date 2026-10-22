package com.android.settings.applications;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.android.settings.R;
import com.android.settings.accessibility.ListDialogPreference;

/* JADX INFO: loaded from: classes2.dex */
public class AppDomainsPreference extends ListDialogPreference {
    private int mNumEntries;

    public AppDomainsPreference(Context r1, AttributeSet r2) {
        super(r1, r2);
        setDialogLayoutResource(R.layout.app_domains_dialog);
        setListItemLayoutResource(R.layout.app_domains_item);
    }

    @Override // com.android.settings.accessibility.ListDialogPreference
    public void setTitles(CharSequence[] r2) {
        if (r2 == null) goto L4;
        int r0 = r2.length;
    L5:
        this.mNumEntries = r0;
        super.setTitles(r2);
        return;
    L4:
        r0 = 0;
        goto L5
    }

    @Override // com.android.settings.accessibility.ListDialogPreference, androidx.preference.Preference
    public CharSequence getSummary() {
        Context r0 = getContext();
        if (this.mNumEntries == 0) goto L5;
        CharSequence r1 = super.getSummary();
        if (this.mNumEntries != 1) goto L9;
        int r4 = R.string.domain_urls_summary_one;
    L11:
        return r0.getString(r4, new Object[]{r1});
    L9:
        r4 = R.string.domain_urls_summary_some;
        goto L11
    L5:
        return r0.getString(R.string.domain_urls_summary_none);
    }

    @Override // com.android.settings.accessibility.ListDialogPreference
    protected void onBindListItem(View r1, int r2) {
        CharSequence r0 = getTitleAt(r2);
        if (r0 == null) goto L6;
        ((TextView) r1.findViewById(R.id.domain_name)).setText(r0);
        return;
    }
}
