package com.android.settingslib.drawer;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public abstract class EntryController {
    private String mAuthority;

    protected static class MetaData {
        private String mCategory;
        private int mIcon;
        private int mIconBackgroundArgb;
        private int mIconBackgroundHint;
        private Boolean mIconTintable;
        private int mOrder;
        private PendingIntent mPendingIntent;
        private String mSummary;
        private int mSummaryId;
        private String mTitle;
        private int mTitleId;

        public MetaData(String r1) {
            this.mCategory = r1;
        }

        public MetaData setOrder(int r1) {
            this.mOrder = r1;
            return this;
        }

        public MetaData setIcon(int r1) {
            this.mIcon = r1;
            return this;
        }

        public MetaData setIconBackgoundHint(int r1) {
            this.mIconBackgroundHint = r1;
            return this;
        }

        public MetaData setIconBackgoundArgb(int r1) {
            this.mIconBackgroundArgb = r1;
            return this;
        }

        public MetaData setIconTintable(boolean r1) {
            this.mIconTintable = Boolean.valueOf(r1);
            return this;
        }

        public MetaData setTitle(int r1) {
            this.mTitleId = r1;
            return this;
        }

        public MetaData setTitle(String r1) {
            this.mTitle = r1;
            return this;
        }

        public MetaData setSummary(int r1) {
            this.mSummaryId = r1;
            return this;
        }

        public MetaData setSummary(String r1) {
            this.mSummary = r1;
            return this;
        }

        public MetaData setPendingIntent(PendingIntent r1) {
            this.mPendingIntent = r1;
            return this;
        }

        protected Bundle build() {
            Bundle r0 = new Bundle();
            r0.putString("com.android.settings.category", this.mCategory);
            int r1 = this.mOrder;
            if (r1 == 0) goto L5;
            r0.putInt(TileUtils.META_DATA_KEY_ORDER, r1);
        L5:
            int r2 = this.mIcon;
            if (r2 == 0) goto L8;
            r0.putInt(TileUtils.META_DATA_PREFERENCE_ICON, r2);
        L8:
            int r3 = this.mIconBackgroundHint;
            if (r3 == 0) goto L11;
            r0.putInt(TileUtils.META_DATA_PREFERENCE_ICON_BACKGROUND_HINT, r3);
        L11:
            int r4 = this.mIconBackgroundArgb;
            if (r4 == 0) goto L14;
            r0.putInt(TileUtils.META_DATA_PREFERENCE_ICON_BACKGROUND_ARGB, r4);
        L14:
            Boolean r5 = this.mIconTintable;
            if (r5 == null) goto L17;
            r0.putBoolean(TileUtils.META_DATA_PREFERENCE_ICON_TINTABLE, r5.booleanValue());
        L17:
            int r6 = this.mTitleId;
            if (r6 == 0) goto L20;
            r0.putInt(TileUtils.META_DATA_PREFERENCE_TITLE, r6);
        L23:
            int r7 = this.mSummaryId;
            if (r7 == 0) goto L26;
            r0.putInt(TileUtils.META_DATA_PREFERENCE_SUMMARY, r7);
        L29:
            PendingIntent r8 = this.mPendingIntent;
            if (r8 == null) goto L32;
            r0.putParcelable(TileUtils.META_DATA_PREFERENCE_PENDING_INTENT, r8);
        L32:
            return r0;
        L26:
            String r9 = this.mSummary;
            if (r9 == null) goto L29;
            r0.putString(TileUtils.META_DATA_PREFERENCE_SUMMARY, r9);
            goto L29
        L20:
            String r10 = this.mTitle;
            if (r10 == null) goto L23;
            r0.putString(TileUtils.META_DATA_PREFERENCE_TITLE, r10);
            goto L23
        }
    }

    public abstract String getKey();

    protected abstract MetaData getMetaData();

    public EntryController() {
    }

    public void notifyTitleChanged(Context r2) {
        if ((this instanceof DynamicTitle) == false) goto L6;
        notifyChanged(r2, EntriesProvider.METHOD_GET_DYNAMIC_TITLE);
        return;
    }

    public void notifySummaryChanged(Context r2) {
        if ((this instanceof DynamicSummary) == false) goto L6;
        notifyChanged(r2, EntriesProvider.METHOD_GET_DYNAMIC_SUMMARY);
        return;
    }

    void setAuthority(String r1) {
        this.mAuthority = r1;
    }

    Bundle getBundle() {
        MetaData r0 = getMetaData();
        if (r0 == null) goto L18;
        Bundle r1 = r0.build();
        String r2 = new Uri.Builder().scheme("content").authority(this.mAuthority).build().toString();
        r1.putString(TileUtils.META_DATA_PREFERENCE_KEYHINT, getKey());
        if ((this instanceof ProviderIcon) == false) goto L8;
        r1.putString(TileUtils.META_DATA_PREFERENCE_ICON_URI, r2);
    L8:
        if ((this instanceof DynamicTitle) == false) goto L11;
        r1.putString(TileUtils.META_DATA_PREFERENCE_TITLE_URI, r2);
    L11:
        if ((this instanceof DynamicSummary) == false) goto L14;
        r1.putString(TileUtils.META_DATA_PREFERENCE_SUMMARY_URI, r2);
    L14:
        if ((this instanceof ProviderSwitch) == false) goto L16;
        r1.putString(TileUtils.META_DATA_PREFERENCE_SWITCH_URI, r2);
    L16:
        return r1;
    L18:
        throw new NullPointerException("Should not return null in getMetaData()");
    }

    private void notifyChanged(Context r2, String r3) {
        Uri r1 = TileUtils.buildUri(this.mAuthority, r3, getKey());
        r2.getContentResolver().notifyChange(r1, null);
    }
}
