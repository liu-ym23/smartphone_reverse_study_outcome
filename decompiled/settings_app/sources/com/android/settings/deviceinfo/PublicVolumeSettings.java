package com.android.settings.deviceinfo;

import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.UserManager;
import android.os.storage.DiskInfo;
import android.os.storage.StorageEventListener;
import android.os.storage.StorageManager;
import android.os.storage.VolumeInfo;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import com.android.internal.util.Preconditions;
import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class PublicVolumeSettings extends SettingsPreferenceFragment {
    private DiskInfo mDisk;
    private Preference mFormatPrivate;
    private Preference mFormatPublic;
    private boolean mIsPermittedToAdopt;
    private Preference mMount;
    private final StorageEventListener mStorageListener;
    private StorageManager mStorageManager;
    private StorageSummaryPreference mSummary;
    private Button mUnmount;
    private final View.OnClickListener mUnmountListener;
    private VolumeInfo mVolume;
    private String mVolumeId;

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_deviceinfo_PublicVolumeSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_deviceinfo_PublicVolumeSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public PublicVolumeSettings() {
        this.mUnmountListener = new AnonymousClass1(this);
        this.mStorageListener = new AnonymousClass2(this);
    }

    static /* synthetic */ VolumeInfo access$000(PublicVolumeSettings r0) {
        return r0.mVolume;
    }

    static /* synthetic */ VolumeInfo access$002(PublicVolumeSettings r0, VolumeInfo r1) {
        r0.mVolume = r1;
        return r1;
    }

    static /* synthetic */ String access$100(PublicVolumeSettings r0) {
        return r0.mVolumeId;
    }

    static /* synthetic */ StorageManager access$200(PublicVolumeSettings r0) {
        return r0.mStorageManager;
    }

    private boolean isVolumeValid() {
        VolumeInfo r0 = this.mVolume;
        if (r0 != null) goto L5;
    L9:
        return false;
    L5:
        if (r0.getType() != 0) goto L9;
        if (this.mVolume.isMountedReadable() == false) goto L9;
        return true;
    }

    public void com_android_settings_deviceinfo_PublicVolumeSettings__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        FragmentActivity r4 = getActivity();
        if (UserManager.get(r4).isAdminUser() == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        this.mIsPermittedToAdopt = r0;
        this.mStorageManager = (StorageManager) r4.getSystemService(StorageManager.class);
        if ("android.provider.action.DOCUMENT_ROOT_SETTINGS".equals(getActivity().getIntent().getAction()) == false) goto L11;
        this.mVolume = this.mStorageManager.findVolumeByUuid(DocumentsContract.getRootId(getActivity().getIntent().getData()));
    L13:
        if (isVolumeValid() == true) goto L16;
        getActivity().finish();
        return;
    L16:
        DiskInfo r5 = this.mStorageManager.findDiskById(this.mVolume.getDiskId());
        this.mDisk = r5;
        Preconditions.checkNotNull(r5);
        this.mVolumeId = this.mVolume.getId();
        addPreferencesFromResource(R.xml.device_info_storage_volume);
        getPreferenceScreen().setOrderingAsAdded(true);
        this.mSummary = new StorageSummaryPreference(getPrefContext());
        this.mMount = buildAction(R.string.storage_menu_mount);
        Button r6 = new Button(getActivity());
        this.mUnmount = r6;
        r6.setText(R.string.storage_menu_unmount);
        this.mUnmount.setOnClickListener(this.mUnmountListener);
        this.mFormatPublic = buildAction(R.string.storage_menu_format);
        if (this.mIsPermittedToAdopt == false) goto L20;
        this.mFormatPrivate = buildAction(R.string.storage_menu_format_private);
        return;
    L20:
        return;
    L11:
        this.mVolume = this.mStorageManager.findVolumeById(getArguments().getString("android.os.storage.extra.VOLUME_ID"));
        goto L13
    L5:
        if (ActivityManager.isUserAMonkey() == true) goto L7;
        r0 = true;
        goto L8
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle r4) {
        super.onActivityCreated(r4);
        int r5 = getResources().getDimensionPixelSize(R.dimen.unmount_button_padding);
        ViewGroup r0 = getButtonBar();
        r0.removeAllViews();
        r0.setPadding(r5, r5, r5, r5);
        r0.addView(this.mUnmount, new ViewGroup.LayoutParams(-1, -2));
    }

    public void update() {
        if (isVolumeValid() == true) goto L6;
        getActivity().finish();
        return;
    L6:
        getActivity().setTitle(this.mStorageManager.getBestVolumeDescription(this.mVolume));
        FragmentActivity r0 = getActivity();
        getPreferenceScreen().removeAll();
        if (this.mVolume.isMountedReadable() == false) goto L10;
        addPreference(this.mSummary);
        File r1 = this.mVolume.getPath();
        long r3 = r1.getTotalSpace();
        long r5 = r3 - r1.getFreeSpace();
        Formatter.BytesResult r2 = Formatter.formatBytes(getResources(), r5, 0);
        this.mSummary.setTitle(TextUtils.expandTemplate(getText(R.string.storage_size_large), new CharSequence[]{r2.value, r2.units}));
        this.mSummary.setSummary(getString(R.string.storage_volume_used, new Object[]{Formatter.formatFileSize(r0, r3).replace('k', 'K')}));
        this.mSummary.setPercent((int) ((r5 * 100) / r3));
    L10:
        if (this.mVolume.getState() != 0) goto L13;
        addPreference(this.mMount);
    L13:
        if (this.mVolume.isMountedReadable() == false) goto L15;
        getButtonBar().setVisibility(0);
    L15:
        addPreference(this.mFormatPublic);
        if (this.mDisk.isAdoptable() == true) goto L18;
        return;
    L18:
        if (this.mIsPermittedToAdopt == false) goto L22;
        addPreference(this.mFormatPrivate);
        return;
    }

    private void addPreference(Preference r2) {
        r2.setOrder(Integer.MAX_VALUE);
        getPreferenceScreen().addPreference(r2);
    }

    private Preference buildAction(int r2) {
        Preference r0 = new Preference(getPrefContext());
        r0.setTitle(r2);
        return r0;
    }

    public void com_android_settings_deviceinfo_PublicVolumeSettings__onResume$___twin___() {
        super.onResume();
        this.mVolume = this.mStorageManager.findVolumeById(this.mVolumeId);
        if (isVolumeValid() == true) goto L6;
        getActivity().finish();
        return;
    L6:
        this.mStorageManager.registerListener(this.mStorageListener);
        update();
    }

    @Override // com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mStorageManager.unregisterListener(this.mStorageListener);
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.preference.PreferenceManager.OnPreferenceTreeClickListener
    public boolean onPreferenceTreeClick(Preference r7) {
        FragmentActivity r0 = getActivity();
        if (r7 != this.mMount) goto L6;
        new StorageSettings.MountTask(r0, this.mVolume).execute(new Void[0]);
    L12:
        return super.onPreferenceTreeClick(r7);
    L6:
        if (r7 != this.mFormatPublic) goto L9;
        Intent r1 = new Intent(r0, StorageWizardFormatConfirm.class);
        r1.putExtra("android.os.storage.extra.DISK_ID", this.mDisk.getId());
        r1.putExtra(StorageWizardFormatConfirm.EXTRA_FORMAT_PRIVATE, false);
        startActivity(r1);
        goto L12
    L9:
        if (r7 != this.mFormatPrivate) goto L12;
        Intent r2 = new Intent(r0, StorageWizardFormatConfirm.class);
        r2.putExtra("android.os.storage.extra.DISK_ID", this.mDisk.getId());
        r2.putExtra(StorageWizardFormatConfirm.EXTRA_FORMAT_PRIVATE, true);
        startActivity(r2);
        goto L12
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_deviceinfo_PublicVolumeSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(PublicVolumeSettings r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_deviceinfo_PublicVolumeSettings__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_deviceinfo_PublicVolumeSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(PublicVolumeSettings r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_deviceinfo_PublicVolumeSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_deviceinfo_PublicVolumeSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(PublicVolumeSettings r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_deviceinfo_PublicVolumeSettings__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
