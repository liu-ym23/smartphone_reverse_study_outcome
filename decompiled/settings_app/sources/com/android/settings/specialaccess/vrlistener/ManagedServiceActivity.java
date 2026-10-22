package com.android.settings.specialaccess.vrlistener;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.UserHandle;
import android.os.UserManager;
import android.text.TextUtils;
import android.util.IconDrawableFactory;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.accounts.obric.ObricIconUtils;
import com.android.settings.applications.PickApplicationActivity;
import com.android.settings.specialaccess.SpecialAccessBaseActivity;
import com.android.settings.specialaccess.SpecialAccessHeaderAdapter;
import com.android.settings.specialaccess.SpecialAccessSwitchViewHolder;
import com.android.settingslib.applications.ServiceListing;
import com.obric.olog.OLog;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.sectiontitlebar.OSectionSupportiveText;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ManagedServiceActivity extends SpecialAccessBaseActivity {
    private static final String TAG = "VrListenerActivity";
    private ApplicationAdapter mApplicationAdapter;
    private final Config mConfig;
    protected Context mContext;
    private DevicePolicyManager mDpm;
    private IconDrawableFactory mIconDrawableFactory;
    private PackageManager mPm;
    private ServiceListing mServiceListing;

    static class ApplicationAdapter extends SpecialAccessHeaderAdapter {
        private final Activity activity;
        private DevicePolicyManager mDpm;
        private PackageManager mPkgMan;
        private ServiceListing mServiceListing;
        private int managedProfileId;
        List<ServiceInfo> pipApps;

        private final boolean enableSwitch(ComponentName r1) {
            return true;
        }

        @Override // com.android.settings.specialaccess.HeaderBaseAdapter
        public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateContentViewHolder(ViewGroup r1, int r2) {
            return onCreateContentViewHolder(r1, r2);
        }

        public ApplicationAdapter(Activity r1, PackageManager r2, DevicePolicyManager r3, ServiceListing r4, Function1<OSectionSupportiveText, Unit> r5) {
            super(r5);
            this.managedProfileId = -10000;
            this.pipApps = new ArrayList();
            this.activity = r1;
            this.mPkgMan = r2;
            this.mDpm = r3;
            this.mServiceListing = r4;
        }

        public void setManagedProfileId(int r1) {
            this.managedProfileId = r1;
        }

        public void setData(List<ServiceInfo> r1) {
            this.pipApps = r1;
            notifyDataSetChanged();
        }

        @Override // com.android.settings.specialaccess.HeaderBaseAdapter
        public SpecialAccessSwitchViewHolder onCreateContentViewHolder(ViewGroup r1, int r2) {
            return new SpecialAccessSwitchViewHolder(SpecialAccessSwitchViewHolder.newView(r1));
        }

        @Override // com.android.settings.specialaccess.HeaderBaseAdapter
        public void onBindContentViewHolder(RecyclerView.ViewHolder r7, int r8) {
            SpecialAccessSwitchViewHolder r9 = (SpecialAccessSwitchViewHolder) r7;
            ServiceInfo r0 = this.pipApps.get(r8);
            ComponentName r1 = new ComponentName(r0.packageName, r0.name);
            CharSequence r2 = this.mPkgMan.getApplicationInfoAsUser(r0.packageName, 0, UserHandle.myUserId()).loadLabel(this.mPkgMan);     // Catch: PackageManager.NameNotFoundException -> L5
        L7:
            String r3 = r0.loadLabel(this.mPkgMan).toString();
            r9.initCardItemInAdapter(this.pipApps.size(), r8);
            r9.setIcon(ObricIconUtils.getDrawable(r0.applicationInfo));
            if (r2 != null) goto L10;
        L12:
            r9.setTitle(r3, r3);
        L14:
            if (this.managedProfileId != (-10000)) goto L16;
        L18:
            r9.updateSwitch(getSwitchOnCheckedListener(r1), enableSwitch(r1), checkSwitch(r1));
            return;
        L16:
            if (this.mDpm.isNotificationListenerServicePermitted(r0.packageName, this.managedProfileId) == true) goto L18;
            r9.setSummary(this.mDpm.getResources().getString("Settings.WORK_PROFILE_NOTIFICATION_LISTENER_BLOCKED", new ManagedServiceActivity$ApplicationAdapter$$ExternalSyntheticLambda1(this)));
            goto L18
        L10:
            if (r2.equals(r3) == true) goto L12;
            r9.setTitle(r2, r2);
            r9.setSummary(r3);
        L5:
            e = move-exception;
            OLog.e(ManagedServiceActivity.TAG, "can't find package name", e);
            r2 = null;
            goto L7
        }

        /* JADX INFO: renamed from: lambda$onBindContentViewHolder$0$com-android-settings-specialaccess-vrlistener-ManagedServiceActivity$ApplicationAdapter, reason: not valid java name */
        /* synthetic */ String m619xf40478aa() {
            return this.activity.getString(R.string.work_profile_notification_access_blocked_summary);
        }

        @Override // com.android.settings.specialaccess.HeaderBaseAdapter
        public int getItemContentCount() {
            List<ServiceInfo> r0 = this.pipApps;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.size();
        }

        public CompoundButton.OnCheckedChangeListener getSwitchOnCheckedListener(final ComponentName r2) {
            if (r2 != null) goto L6;
            return null;
        L6:
            return new ManagedServiceActivity$ApplicationAdapter$$ExternalSyntheticLambda0(this, r2);
        }

        /* JADX INFO: renamed from: lambda$getSwitchOnCheckedListener$1$com-android-settings-specialaccess-vrlistener-ManagedServiceActivity$ApplicationAdapter, reason: not valid java name */
        /* synthetic */ void m618x4deea6e9(ComponentName r1, CompoundButton r2, boolean r3) {
            setEnabled(r1, r3);
        }

        private final boolean checkSwitch(ComponentName r1) {
            return isServiceEnabled(r1);
        }

        protected boolean isServiceEnabled(ComponentName r1) {
            return this.mServiceListing.isEnabled(r1);
        }

        protected boolean setEnabled(ComponentName r2, boolean r3) {
            if (r3 == true) goto L7;
            this.mServiceListing.setEnabled(r2, false);
            return true;
        L7:
            if (this.mServiceListing.isEnabled(r2) == false) goto L9;
            return true;
        L9:
            this.mServiceListing.setEnabled(r2, true);
            return true;
        }
    }

    public static class Config {
        public final String configIntentAction;
        public final int emptyText;
        public final String intentAction;
        public final String noun;
        public final String permission;
        public final String setting;
        public final String tag;
        public final int warningDialogSummary;
        public final int warningDialogTitle;

        public static class Builder {
            private String mConfigIntentAction;
            private int mEmptyText;
            private String mIntentAction;
            private String mNoun;
            private String mPermission;
            private String mSetting;
            private String mTag;
            private int mWarningDialogSummary;
            private int mWarningDialogTitle;

            public Builder() {
            }

            public Builder setTag(String r1) {
                this.mTag = r1;
                return this;
            }

            public Builder setSetting(String r1) {
                this.mSetting = r1;
                return this;
            }

            public Builder setIntentAction(String r1) {
                this.mIntentAction = r1;
                return this;
            }

            public Builder setConfigurationIntentAction(String r1) {
                this.mConfigIntentAction = r1;
                return this;
            }

            public Builder setPermission(String r1) {
                this.mPermission = r1;
                return this;
            }

            public Builder setNoun(String r1) {
                this.mNoun = r1;
                return this;
            }

            public Builder setWarningDialogTitle(int r1) {
                this.mWarningDialogTitle = r1;
                return this;
            }

            public Builder setWarningDialogSummary(int r1) {
                this.mWarningDialogSummary = r1;
                return this;
            }

            public Builder setEmptyText(int r1) {
                this.mEmptyText = r1;
                return this;
            }

            public Config build() {
                return new Config(this.mTag, this.mSetting, this.mIntentAction, this.mConfigIntentAction, this.mPermission, this.mNoun, this.mWarningDialogTitle, this.mWarningDialogSummary, this.mEmptyText, null);
            }
        }

        /* synthetic */ Config(String r1, String r2, String r3, String r4, String r5, String r6, int r7, int r8, int r9, AnonymousClass1 r10) {
            this(r1, r2, r3, r4, r5, r6, r7, r8, r9);
        }

        private Config(String r1, String r2, String r3, String r4, String r5, String r6, int r7, int r8, int r9) {
            this.tag = r1;
            this.setting = r2;
            this.intentAction = r3;
            this.permission = r5;
            this.noun = r6;
            this.warningDialogTitle = r7;
            this.warningDialogSummary = r8;
            this.emptyText = r9;
            this.configIntentAction = r4;
        }
    }

    public static /* synthetic */ void $r8$lambda$PPfySaZvgI88hxCGC8D6v8tC1jA(ManagedServiceActivity r0, List r1) {
        r0.updateList(r1);
    }

    protected abstract Config getConfig();

    static /* synthetic */ void access$000(ManagedServiceActivity r0, OSectionSupportiveText r1) {
        r0.initDescText(r1);
    }

    public ManagedServiceActivity() {
        this.mConfig = getConfig();
    }

    @Override // com.android.settings.specialaccess.SpecialAccessBaseActivity, com.android.settingslib.core.lifecycle.ObservableActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r8) {
        super.onCreate(r8);
        this.mContext = this;
        this.mPm = getPackageManager();
        this.mDpm = (DevicePolicyManager) this.mContext.getSystemService("device_policy");
        this.mIconDrawableFactory = IconDrawableFactory.newInstance(this.mContext);
        ServiceListing r9 = new ServiceListing.Builder(this.mContext).setPermission(this.mConfig.permission).setIntentAction(this.mConfig.intentAction).setNoun(this.mConfig.noun).setSetting(this.mConfig.setting).setTag(this.mConfig.tag).build();
        this.mServiceListing = r9;
        r9.addCallback(new ManagedServiceActivity$$ExternalSyntheticLambda0(this));
        this.mApplicationAdapter = new ApplicationAdapter(this, this.mPm, this.mDpm, this.mServiceListing, new AnonymousClass1(this));
        this.mRecyclerView.setAdapter(this.mApplicationAdapter);
    }

    @Override // com.android.settingslib.core.lifecycle.ObservableActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.mServiceListing.reload();
        this.mServiceListing.setListening(true);
    }

    @Override // com.android.settingslib.core.lifecycle.ObservableActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.mServiceListing.setListening(false);
    }

    @Override // com.android.settings.specialaccess.SpecialAccessBaseActivity
    protected int getPackageIdx(String r4) {
        int r0 = this.mApplicationAdapter.getItemCount();
        if (this.mPackageName == null) goto L13;
        if (r0 <= 0) goto L13;
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L13;
        ServiceInfo r2 = this.mApplicationAdapter.pipApps.get(r1);
        if (r2 == null) goto L12;
        if (TextUtils.equals(r4, r2.packageName) == false) goto L12;
    L14:
        OLog.i(TAG, "jump to: " + r1 + ", package: " + r4);
        return r1;
    L12:
        r1 = r1 + 1;
    L13:
        r1 = -1;
        goto L14
    }

    private void updateList(List<ServiceInfo> r4) {
        int r0 = Utils.getManagedProfileId((UserManager) this.mContext.getSystemService(PickApplicationActivity.EXTRA_USER), UserHandle.myUserId());
        r4.sort(new PackageItemInfo.DisplayNameComparator(this.mPm));
        if (r4.isEmpty() == false) goto L5;
        showEmptyView();
    L6:
        this.mApplicationAdapter.setManagedProfileId(r0);
        this.mApplicationAdapter.setData(r4);
        updatePositionAfterNotify();
        return;
    L5:
        showContent();
        goto L6
    }

    private int getCurrentUser(int r1) {
        if (r1 == (-10000)) goto L6;
        return r1;
    L6:
        return UserHandle.myUserId();
    }

    protected boolean isServiceEnabled(ComponentName r1) {
        return this.mServiceListing.isEnabled(r1);
    }

    protected boolean setEnabled(ComponentName r1, String r2, boolean r3) {
        if (r3 == true) goto L7;
        this.mServiceListing.setEnabled(r1, false);
        return true;
    L7:
        if (this.mServiceListing.isEnabled(r1) == false) goto L9;
        return true;
    L9:
        enable(r1);
        return true;
    }

    protected void enable(ComponentName r2) {
        this.mServiceListing.setEnabled(r2, true);
    }
}
