package com.android.settings;

/* JADX INFO: loaded from: classes2.dex */
public class ApnItem {
    static final String TAG = "ApnPreference";
    private boolean mIsChecked;
    private String mKey;
    private boolean mReadOnly;
    private boolean mSelectable;
    private String mSummary;
    private String mTitle;

    public ApnItem() {
        this.mSelectable = true;
    }

    public String getKey() {
        return this.mKey;
    }

    public void setKey(String r1) {
        this.mKey = r1;
    }

    public void setTitle(String r1) {
        this.mTitle = r1;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setSummary(String r1) {
        this.mSummary = r1;
    }

    public String getSummary() {
        return this.mSummary;
    }

    public boolean isChecked() {
        return this.mIsChecked;
    }

    public void setChecked(boolean r1) {
        this.mIsChecked = r1;
    }

    public void setSelectable(boolean r1) {
        this.mSelectable = r1;
    }

    public boolean getSelectable() {
        return this.mSelectable;
    }

    public void setReadOnly(boolean r1) {
        this.mReadOnly = r1;
    }

    public boolean getReadOnly() {
        return this.mReadOnly;
    }
}
