package com.android.settingslib.location;

import android.content.Intent;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.Log;
import com.GlobalProxyLancet;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class InjectedSetting {
    public final String className;
    public final int iconId;
    public final UserHandle mUserHandle;
    public final String packageName;
    public final String settingsActivity;
    public final String title;
    public final String userRestriction;

    /* JADX INFO: renamed from: com.android.settingslib.location.InjectedSetting$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private String mClassName;
        private int mIconId;
        private String mPackageName;
        private String mSettingsActivity;
        private String mTitle;
        private UserHandle mUserHandle;
        private String mUserRestriction;

        public Builder() {
        }

        static /* synthetic */ String access$000(Builder r0) {
            return r0.mPackageName;
        }

        static /* synthetic */ String access$100(Builder r0) {
            return r0.mClassName;
        }

        static /* synthetic */ String access$200(Builder r0) {
            return r0.mTitle;
        }

        static /* synthetic */ int access$300(Builder r0) {
            return r0.mIconId;
        }

        static /* synthetic */ UserHandle access$400(Builder r0) {
            return r0.mUserHandle;
        }

        static /* synthetic */ String access$500(Builder r0) {
            return r0.mSettingsActivity;
        }

        static /* synthetic */ String access$600(Builder r0) {
            return r0.mUserRestriction;
        }

        public Builder setPackageName(String r1) {
            this.mPackageName = r1;
            return this;
        }

        public Builder setClassName(String r1) {
            this.mClassName = r1;
            return this;
        }

        public Builder setTitle(String r1) {
            this.mTitle = r1;
            return this;
        }

        public Builder setIconId(int r1) {
            this.mIconId = r1;
            return this;
        }

        public Builder setUserHandle(UserHandle r1) {
            this.mUserHandle = r1;
            return this;
        }

        public Builder setSettingsActivity(String r1) {
            this.mSettingsActivity = r1;
            return this;
        }

        public Builder setUserRestriction(String r1) {
            this.mUserRestriction = r1;
            return this;
        }

        public InjectedSetting build() {
            AnonymousClass1 r1 = null;
            if (this.mPackageName == null) goto L14;
            if (this.mClassName == null) goto L14;
            if (TextUtils.isEmpty(this.mTitle) == true) goto L14;
            if (TextUtils.isEmpty(this.mSettingsActivity) == true) goto L14;
            return new InjectedSetting(this, r1);
        L14:
            if (Log.isLoggable("SettingsInjector", 5) == false) goto L16;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w("SettingsInjector", "Illegal setting specification: package=" + this.mPackageName + ", class=" + this.mClassName + ", title=" + this.mTitle + ", settingsActivity=" + this.mSettingsActivity);
        L16:
            return null;
        }
    }

    /* synthetic */ InjectedSetting(Builder r1, AnonymousClass1 r2) {
        this(r1);
    }

    private InjectedSetting(Builder r2) {
        this.packageName = Builder.access$000(r2);
        this.className = Builder.access$100(r2);
        this.title = Builder.access$200(r2);
        this.iconId = Builder.access$300(r2);
        this.mUserHandle = Builder.access$400(r2);
        this.settingsActivity = Builder.access$500(r2);
        this.userRestriction = Builder.access$600(r2);
    }

    public String toString() {
        return "InjectedSetting{mPackageName='" + this.packageName + "', mClassName='" + this.className + "', label=" + this.title + ", iconId=" + this.iconId + ", userId=" + this.mUserHandle.getIdentifier() + ", settingsActivity='" + this.settingsActivity + "', userRestriction='" + this.userRestriction + '}';
    }

    public Intent getServiceIntent() {
        Intent r0 = new Intent();
        r0.setClassName(this.packageName, this.className);
        return r0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof InjectedSetting) == true) goto L8;
        return false;
    L8:
        InjectedSetting r6 = (InjectedSetting) r5;
        if (Objects.equals(this.packageName, r6.packageName) == false) goto L24;
        if (Objects.equals(this.className, r6.className) == false) goto L24;
        if (Objects.equals(this.title, r6.title) == false) goto L24;
        if (Objects.equals(Integer.valueOf(this.iconId), Integer.valueOf(r6.iconId)) == false) goto L24;
        if (Objects.equals(this.mUserHandle, r6.mUserHandle) == false) goto L24;
        if (Objects.equals(this.settingsActivity, r6.settingsActivity) == false) goto L24;
        if (Objects.equals(this.userRestriction, r6.userRestriction) == false) goto L24;
        return true;
    L24:
        return false;
    }

    public int hashCode() {
        int r0 = ((((((this.packageName.hashCode() * 31) + this.className.hashCode()) * 31) + this.title.hashCode()) * 31) + this.iconId) * 31;
        UserHandle r1 = this.mUserHandle;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + this.settingsActivity.hashCode()) * 31;
        String r5 = this.userRestriction;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }
}
