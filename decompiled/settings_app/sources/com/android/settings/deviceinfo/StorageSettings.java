package com.android.settings.deviceinfo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.storage.DiskInfo;
import android.os.storage.StorageEventListener;
import android.os.storage.StorageManager;
import android.os.storage.VolumeInfo;
import android.os.storage.VolumeRecord;
import android.text.TextUtils;
import android.text.format.Formatter;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.ToastUtils;
import com.android.settings.Utils;
import com.android.settings.search.Indexable;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.NullSafe;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import cz.msebera.android.httpclient.client.cache.HeaderConstants;
import java.io.File;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class StorageSettings extends SettingsPreferenceFragment implements Indexable {
    static final int[] COLOR_PRIVATE = null;
    static final int COLOR_PUBLIC = 0;
    static final int COLOR_WARNING = 0;
    public static final Indexable.SearchIndexProvider SEARCH_INDEX_DATA_PROVIDER = null;
    static final String TAG = "StorageSettings";
    private static final String TAG_DISK_INIT = "disk_init";
    private static final String TAG_VOLUME_UNMOUNTED = "volume_unmounted";
    private PreferenceCategory mExternalCategory;
    private PreferenceCategory mInternalCategory;
    private StorageSummaryPreference mInternalSummary;
    private final StorageEventListener mStorageListener;
    private StorageManager mStorageManager;

    public static class DiskInitFragment extends DialogFragment {
        public void com_android_settings_deviceinfo_StorageSettings$DiskInitFragment__onCreate$___twin___(Bundle r1) {
            super.onCreate(r1);
        }

        public void com_android_settings_deviceinfo_StorageSettings$DiskInitFragment__onResume$___twin___() {
            super.onResume();
        }

        @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
        public void onCreate(Bundle r1) {
            com_android_settings_deviceinfo_StorageSettings$DiskInitFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
        }

        @Override // androidx.fragment.app.Fragment
        public void onResume() {
            com_android_settings_deviceinfo_StorageSettings$DiskInitFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
        }

        public DiskInitFragment() {
        }

        public static void show(Fragment r2, int r3, String r4) {
            Bundle r0 = new Bundle();
            r0.putInt("android.intent.extra.TEXT", r3);
            r0.putString("android.os.storage.extra.DISK_ID", r4);
            DiskInitFragment r5 = new DiskInitFragment();
            r5.setArguments(r0);
            r5.setTargetFragment(r2, 0);
            r5.show(r2.getFragmentManager(), StorageSettings.TAG_DISK_INIT);
        }

        @Override // androidx.fragment.app.DialogFragment
        public Dialog onCreateDialog(Bundle r7) {
            final FragmentActivity r8 = getActivity();
            StorageManager r0 = (StorageManager) r8.getSystemService(StorageManager.class);
            int r1 = getArguments().getInt("android.intent.extra.TEXT");
            final String r2 = getArguments().getString("android.os.storage.extra.DISK_ID");
            DiskInfo r3 = r0.findDiskById(r2);
            AlertDialog.Builder r4 = new AlertDialog.Builder(r8);
            r4.setMessage(TextUtils.expandTemplate(getText(r1), new CharSequence[]{r3.getDescription()}));
            r4.setPositiveButton(R.string.storage_menu_set_up, new AnonymousClass1(this, r8, r2));
            r4.setNegativeButton(R.string.cancel, null);
            return r4.create();
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onCreate")
        public static void com_android_settings_deviceinfo_StorageSettings$DiskInitFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(DiskInitFragment r2, Bundle r3) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_deviceinfo_StorageSettings$DiskInitFragment__onCreate$___twin___(r3);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
            AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r4.callingPackageEvent("self", r0, true);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_deviceinfo_StorageSettings$DiskInitFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(DiskInitFragment r2) {
            String r0 = r2.getClass().getName();
            com_android_settings_deviceinfo_StorageSettings$DiskInitFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.recordVisibleTime(r0);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_deviceinfo_StorageSettings$DiskInitFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(DiskInitFragment r2) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_deviceinfo_StorageSettings$DiskInitFragment__onResume$___twin___();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.reportVisibleTime(r0, true);
            return;
        }
    }

    public static class MountTask extends AsyncTask<Void, Void, Exception> {
        private final Context mContext;
        private final String mDescription;
        private final StorageManager mStorageManager;
        private final String mVolumeId;

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ Exception doInBackground(Void[] r1) {
            return doInBackground2(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(Exception r1) {
            onPostExecute2(r1);
        }

        public MountTask(Context r2, VolumeInfo r3) {
            Context r4 = r2.getApplicationContext();
            this.mContext = r4;
            StorageManager r5 = (StorageManager) NullSafe.nonNull((StorageManager) r4.getSystemService(StorageManager.class));
            this.mStorageManager = r5;
            this.mVolumeId = r3.getId();
            this.mDescription = r5.getBestVolumeDescription(r3);
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected Exception doInBackground2(Void... r1) {
            this.mStorageManager.mount(this.mVolumeId);     // Catch: Exception -> L5
            return null;
        L5:
            e = move-exception;
            return e;
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(Exception r5) {
            if (r5 != null) goto L5;
            Context r6 = this.mContext;
            ToastUtils.show(r6, r6.getString(R.string.storage_mount_success, new Object[]{this.mDescription}));
            return;
        L5:
            OLog.e(StorageSettings.TAG, "Failed to mount " + this.mVolumeId, r5);
            Context r7 = this.mContext;
            ToastUtils.show(r7, r7.getString(R.string.storage_mount_failure, new Object[]{this.mDescription}));
        }
    }

    public static class UnmountTask extends AsyncTask<Void, Void, Exception> {
        private final Context mContext;
        private final String mDescription;
        private final StorageManager mStorageManager;
        private final String mVolumeId;

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ Exception doInBackground(Void[] r1) {
            return doInBackground2(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(Exception r1) {
            onPostExecute2(r1);
        }

        public UnmountTask(Context r2, VolumeInfo r3) {
            Context r4 = r2.getApplicationContext();
            this.mContext = r4;
            StorageManager r5 = (StorageManager) r4.getSystemService(StorageManager.class);
            this.mStorageManager = r5;
            this.mVolumeId = r3.getId();
            this.mDescription = r5.getBestVolumeDescription(r3);
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected Exception doInBackground2(Void... r1) {
            this.mStorageManager.unmount(this.mVolumeId);     // Catch: Exception -> L5
            return null;
        L5:
            e = move-exception;
            return e;
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(Exception r5) {
            if (r5 != null) goto L5;
            Context r6 = this.mContext;
            ToastUtils.show(r6, r6.getString(R.string.storage_unmount_success, new Object[]{this.mDescription}));
            return;
        L5:
            OLog.e(StorageSettings.TAG, "Failed to unmount " + this.mVolumeId, r5);
            Context r7 = this.mContext;
            ToastUtils.show(r7, r7.getString(R.string.storage_unmount_failure, new Object[]{this.mDescription}));
        }
    }

    public static class VolumeUnmountedFragment extends DialogFragment {
        public void com_android_settings_deviceinfo_StorageSettings$VolumeUnmountedFragment__onCreate$___twin___(Bundle r1) {
            super.onCreate(r1);
        }

        public void com_android_settings_deviceinfo_StorageSettings$VolumeUnmountedFragment__onResume$___twin___() {
            super.onResume();
        }

        @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
        public void onCreate(Bundle r1) {
            com_android_settings_deviceinfo_StorageSettings$VolumeUnmountedFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
        }

        @Override // androidx.fragment.app.Fragment
        public void onResume() {
            com_android_settings_deviceinfo_StorageSettings$VolumeUnmountedFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
        }

        public VolumeUnmountedFragment() {
        }

        public static void show(Fragment r2, String r3) {
            Bundle r0 = new Bundle();
            r0.putString("android.os.storage.extra.VOLUME_ID", r3);
            VolumeUnmountedFragment r4 = new VolumeUnmountedFragment();
            r4.setArguments(r0);
            r4.setTargetFragment(r2, 0);
            r4.show(r2.getFragmentManager(), StorageSettings.TAG_VOLUME_UNMOUNTED);
        }

        @Override // androidx.fragment.app.DialogFragment
        public Dialog onCreateDialog(Bundle r7) {
            final FragmentActivity r8 = getActivity();
            final VolumeInfo r0 = ((StorageManager) r8.getSystemService(StorageManager.class)).findVolumeById(getArguments().getString("android.os.storage.extra.VOLUME_ID"));
            AlertDialog.Builder r1 = new AlertDialog.Builder(r8);
            r1.setMessage(TextUtils.expandTemplate(getText(R.string.storage_dialog_unmounted), new CharSequence[]{r0.getDisk().getDescription()}));
            r1.setPositiveButton(R.string.storage_menu_mount, new AnonymousClass1(this, r8, r0));
            r1.setNegativeButton(R.string.cancel, null);
            return r1.create();
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onCreate")
        public static void com_android_settings_deviceinfo_StorageSettings$VolumeUnmountedFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(VolumeUnmountedFragment r2, Bundle r3) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_deviceinfo_StorageSettings$VolumeUnmountedFragment__onCreate$___twin___(r3);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
            AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r4.callingPackageEvent("self", r0, true);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_deviceinfo_StorageSettings$VolumeUnmountedFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(VolumeUnmountedFragment r2) {
            String r0 = r2.getClass().getName();
            com_android_settings_deviceinfo_StorageSettings$VolumeUnmountedFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.recordVisibleTime(r0);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_deviceinfo_StorageSettings$VolumeUnmountedFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(VolumeUnmountedFragment r2) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_deviceinfo_StorageSettings$VolumeUnmountedFragment__onResume$___twin___();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.reportVisibleTime(r0, true);
            return;
        }
    }

    @Override // com.android.settings.SettingsPreferenceFragment
    protected int getHelpResource() {
        return R.string.help_uri_storage;
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_deviceinfo_StorageSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_deviceinfo_StorageSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public StorageSettings() {
        this.mStorageListener = new AnonymousClass1(this);
    }

    static /* synthetic */ boolean access$000(VolumeInfo r0) {
        return isInteresting(r0);
    }

    static /* synthetic */ void access$100(StorageSettings r0) {
        r0.refresh();
    }

    static {
        COLOR_PUBLIC = Color.parseColor("#ff9e9e9e");
        COLOR_WARNING = Color.parseColor("#fff4511e");
        COLOR_PRIVATE = new int[]{Color.parseColor("#ff26a69a"), Color.parseColor("#ffab47bc"), Color.parseColor("#fff2a600"), Color.parseColor("#ffec407a"), Color.parseColor("#ffc0ca33")};
        SEARCH_INDEX_DATA_PROVIDER = new AnonymousClass2();
    }

    public void com_android_settings_deviceinfo_StorageSettings__onCreate$___twin___(Bundle r2) {
        super.onCreate(r2);
        StorageManager r3 = (StorageManager) getActivity().getSystemService(StorageManager.class);
        this.mStorageManager = r3;
        r3.registerListener(this.mStorageListener);
        addPreferencesFromResource(R.xml.device_info_storage);
        this.mInternalCategory = (PreferenceCategory) findPreference("storage_internal");
        this.mExternalCategory = (PreferenceCategory) findPreference("storage_external");
        this.mInternalSummary = new StorageSummaryPreference(getPrefContext());
        setHasOptionsMenu(true);
    }

    private static boolean isInteresting(VolumeInfo r1) {
        int r2 = r1.getType();
        if (r2 == 0) goto L7;
        if (r2 == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private void refresh() {
        Context r0 = getPrefContext();
        getPreferenceScreen().removeAll();
        this.mInternalCategory.removeAll();
        this.mExternalCategory.removeAll();
        this.mInternalCategory.addPreference(this.mInternalSummary);
        List r1 = this.mStorageManager.getVolumes();
        Collections.sort(r1, VolumeInfo.getDescriptionComparator());
        Iterator r2 = r1.iterator();
        int r5 = 0;
        long r6 = 0;
        long r8 = 0;
    L4:
        if (r2.hasNext() == false) goto L14;
        VolumeInfo r10 = (VolumeInfo) r2.next();
        if (r10.getType() == 1) goto L7;
        if (r10.getType() != 0) goto L4;
        this.mExternalCategory.addPreference(new StorageVolumePreference(r0, r10, COLOR_PUBLIC));
        goto L4
    L7:
        int[] r11 = COLOR_PRIVATE;
        int r12 = r5 + 1;
        this.mInternalCategory.addPreference(new StorageVolumePreference(r0, r10, r11[r5 % r11.length]));
        if (r10.isMountedReadable() == false) goto L10;
        File r7 = r10.getPath();
        r6 = r6 + (r7.getTotalSpace() - r7.getFreeSpace());
        r8 = r8 + r7.getTotalSpace();
    L10:
        r5 = r12;
        goto L4
    L14:
        Iterator r3 = this.mStorageManager.getVolumeRecords().iterator();
    L16:
        if (r3.hasNext() == false) goto L24;
        VolumeRecord r9 = (VolumeRecord) r3.next();
        if (r9.getType() != 1) goto L16;
        if (this.mStorageManager.findVolumeByUuid(r9.getFsUuid()) != null) goto L16;
        Drawable r15 = null;
        r15.mutate();
        throw null;
    L24:
        Iterator r4 = this.mStorageManager.getDisks().iterator();
    L26:
        if (r4.hasNext() == false) goto L32;
        DiskInfo r13 = (DiskInfo) r4.next();
        if (r13.volumeCount != 0) goto L26;
        if (r13.size <= 0) goto L26;
        Preference r14 = new Preference(r0);
        r14.setKey(r13.getId());
        r14.setTitle(r13.getDescription());
        r14.setSummary(android.R.string.fingerprint_acquired_too_bright);
        this.mExternalCategory.addPreference(r14);
        goto L26
    L32:
        Formatter.BytesResult r16 = Formatter.formatBytes(getResources(), r6, 0);
        this.mInternalSummary.setTitle(TextUtils.expandTemplate(getText(R.string.storage_size_large), new CharSequence[]{r16.value, r16.units}));
        this.mInternalSummary.setSummary(getString(R.string.storage_volume_used_total, new Object[]{Formatter.formatFileSize(r0, r8).replace('k', 'K')}));
        if (this.mInternalCategory.getPreferenceCount() <= 0) goto L36;
        getPreferenceScreen().addPreference(this.mInternalCategory);
    L36:
        if (this.mExternalCategory.getPreferenceCount() <= 0) goto L39;
        getPreferenceScreen().addPreference(this.mExternalCategory);
    L39:
        if (this.mInternalCategory.getPreferenceCount() == 2) goto L41;
        return;
    L41:
        if (this.mExternalCategory.getPreferenceCount() != 0) goto L66;
        Bundle r17 = new Bundle();
        r17.putString("android.os.storage.extra.VOLUME_ID", HeaderConstants.PRIVATE);
        Intent r18 = Utils.onBuildStartFragmentIntent(getActivity(), PrivateVolumeSettings.class.getName(), r17, null, R.string.apps_storage, null, false);
        r18.putExtra("show_drawer_menu", true);
        getActivity().startActivity(r18);
        finish();
        return;
    }

    public void com_android_settings_deviceinfo_StorageSettings__onResume$___twin___() {
        super.onResume();
        this.mStorageManager.registerListener(this.mStorageListener);
        refresh();
    }

    @Override // com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mStorageManager.unregisterListener(this.mStorageListener);
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.preference.PreferenceManager.OnPreferenceTreeClickListener
    public boolean onPreferenceTreeClick(Preference r11) {
        String r0 = r11.getKey();
        if ((r11 instanceof StorageVolumePreference) == false) goto L29;
        VolumeInfo r12 = this.mStorageManager.findVolumeById(r0);
        if (r12 != null) goto L8;
        return false;
    L8:
        if (r12.getState() != 0) goto L12;
        VolumeUnmountedFragment.show(this, r12.getId());
        return true;
    L12:
        if (r12.getState() != 6) goto L16;
        DiskInitFragment.show(this, R.string.storage_dialog_unmountable, r12.getDiskId());
        return true;
    L16:
        if (r12.getType() != 1) goto L20;
        Bundle r9 = new Bundle();
        r9.putString("android.os.storage.extra.VOLUME_ID", r12.getId());
        startFragment(this, PrivateVolumeSettings.class.getCanonicalName(), -1, 0, r9);
        return true;
    L20:
        if (r12.getType() == 0) goto L22;
        return false;
    L22:
        if (r12.isMountedReadable() == false) goto L25;
        startActivity(r12.buildBrowseIntent());
        return true;
    L25:
        Bundle r7 = new Bundle();
        r7.putString("android.os.storage.extra.VOLUME_ID", r12.getId());
        startFragment(this, PublicVolumeSettings.class.getCanonicalName(), -1, 0, r7);
        return true;
    L29:
        if (r0.startsWith("disk:") == false) goto L32;
        DiskInitFragment.show(this, R.string.storage_dialog_unsupported, r0);
        return true;
    L32:
        Bundle r8 = new Bundle();
        r8.putString("android.os.storage.extra.FS_UUID", r0);
        startFragment(this, PrivateVolumeForget.class.getCanonicalName(), R.string.storage_menu_forget, 0, r8);
        return true;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_deviceinfo_StorageSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(StorageSettings r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_deviceinfo_StorageSettings__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_deviceinfo_StorageSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(StorageSettings r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_deviceinfo_StorageSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_deviceinfo_StorageSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(StorageSettings r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_deviceinfo_StorageSettings__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
