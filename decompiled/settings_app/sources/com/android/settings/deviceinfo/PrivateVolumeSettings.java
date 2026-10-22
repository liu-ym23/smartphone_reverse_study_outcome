package com.android.settings.deviceinfo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.IPackageDataObserver;
import android.content.pm.UserInfo;
import android.database.ContentObserver;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.UserHandle;
import android.os.UserManager;
import android.os.storage.StorageEventListener;
import android.os.storage.StorageManager;
import android.os.storage.VolumeInfo;
import android.os.storage.VolumeRecord;
import android.provider.Settings;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceScreen;
import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.google.android.collect.Lists;
import com.obric.olog.OLog;
import com.obric.oui.forms.OEditText;
import com.obric.oui.forms.OInputView;
import com.obric.privacy.GrantUtil;
import cz.msebera.android.httpclient.client.cache.HeaderConstants;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public class PrivateVolumeSettings extends SettingsPreferenceFragment {
    private static final String AUTHORITY_MEDIA = "com.android.providers.media.documents";
    private static final String BIG_FILE_SCANNING_STATE = "BigFileScanningState";
    private static final int BIG_FILE_SCAN_DONE = 1;
    private static final int[] ITEMS_COLOR_NO_SHOW_SHARED = null;
    private static final int[] ITEMS_COLOR_SHOW_SHARED = null;
    private static final int[] ITEMS_NO_SHOW_SHARED = null;
    private static final int[] ITEMS_SHOW_SHARED = null;
    private static final String STORAGE_CLEANUP_PACKAGE = "com.qti.storagecleaner";
    private static final String STORAGE_CLENUP_CLASS = "com.qti.storagecleaner.CleanerActivity";
    private static final String TAG_CONFIRM_CLEAR_CACHE = "confirmClearCache";
    private static final String TAG_OTHER_INFO = "otherInfo";
    private static final String TAG_RENAME = "rename";
    private static final String TAG_USER_INFO = "userInfo";
    private ContentObserver mBigFileScanObserver;
    private View mBigFileScanProgressBar;
    private SettingItemText mBigFilesCleanUp;
    private final View.OnClickListener mClickListener;
    private ContentResolver mContentResolver;
    private UserInfo mCurrentUser;
    private Preference mExplore;
    private int mHeaderPoolIndex;
    private List<PreferenceCategory> mHeaderPreferencePool;
    private int mItemPoolIndex;
    private List<StorageItemPreference> mItemPreferencePool;
    private com.android.settingslib.deviceinfo.StorageMeasurement mMeasure;
    private boolean mNeedsUpdate;
    private final com.android.settingslib.deviceinfo.StorageMeasurement.MeasurementReceiver mReceiver;
    private VolumeInfo mSharedVolume;
    private final StorageEventListener mStorageListener;
    private StorageManager mStorageManager;
    private StorageSummaryPreference mSummary;
    private int mTitleRes;
    private UserManager mUserManager;
    private VolumeInfo mVolume;
    private String mVolumeId;

    private static class ClearCacheObserver extends IPackageDataObserver.Stub {
        private int mRemaining;
        private final PrivateVolumeSettings mTarget;

        static /* synthetic */ PrivateVolumeSettings access$700(ClearCacheObserver r0) {
            return r0.mTarget;
        }

        public ClearCacheObserver(PrivateVolumeSettings r1, int r2) {
            this.mTarget = r1;
            this.mRemaining = r2;
        }

        public void onRemoveCompleted(String r1, boolean r2) {
            monitor-enter(this);
            int r3 = this.mRemaining - 1;     // Catch: Throwable -> L8
            this.mRemaining = r3;     // Catch: Throwable -> L8
            if (r3 != 0) goto L6;
            this.mTarget.getActivity().runOnUiThread(new AnonymousClass1(this));     // Catch: Throwable -> L8
        L6:
            monitor-exit(this);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }
    }

    public static class ConfirmClearCacheFragment extends DialogFragment {
        public void com_android_settings_deviceinfo_PrivateVolumeSettings$ConfirmClearCacheFragment__onCreate$___twin___(Bundle r1) {
            super.onCreate(r1);
        }

        public void com_android_settings_deviceinfo_PrivateVolumeSettings$ConfirmClearCacheFragment__onResume$___twin___() {
            super.onResume();
        }

        @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
        public void onCreate(Bundle r1) {
            com_android_settings_deviceinfo_PrivateVolumeSettings$ConfirmClearCacheFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
        }

        @Override // androidx.fragment.app.Fragment
        public void onResume() {
            com_android_settings_deviceinfo_PrivateVolumeSettings$ConfirmClearCacheFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
        }

        public ConfirmClearCacheFragment() {
        }

        public static void show(Fragment r2) {
            if (r2.isAdded() == true) goto L5;
            return;
        L5:
            ConfirmClearCacheFragment r0 = new ConfirmClearCacheFragment();
            r0.setTargetFragment(r2, 0);
            r0.show(r2.getParentFragmentManager(), PrivateVolumeSettings.TAG_CONFIRM_CLEAR_CACHE);
        }

        @Override // androidx.fragment.app.DialogFragment
        public Dialog onCreateDialog(Bundle r3) {
            final FragmentActivity r4 = getActivity();
            AlertDialog.Builder r0 = new AlertDialog.Builder(r4);
            r0.setTitle(R.string.memory_clear_cache_title);
            r0.setMessage(getString(R.string.memory_clear_cache_message));
            r0.setPositiveButton(android.R.string.ok, new AnonymousClass1(this, r4));
            r0.setNegativeButton(android.R.string.cancel, null);
            return r0.create();
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onCreate")
        public static void com_android_settings_deviceinfo_PrivateVolumeSettings$ConfirmClearCacheFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(ConfirmClearCacheFragment r2, Bundle r3) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_deviceinfo_PrivateVolumeSettings$ConfirmClearCacheFragment__onCreate$___twin___(r3);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
            AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r4.callingPackageEvent("self", r0, true);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_deviceinfo_PrivateVolumeSettings$ConfirmClearCacheFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(ConfirmClearCacheFragment r2) {
            String r0 = r2.getClass().getName();
            com_android_settings_deviceinfo_PrivateVolumeSettings$ConfirmClearCacheFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.recordVisibleTime(r0);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_deviceinfo_PrivateVolumeSettings$ConfirmClearCacheFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(ConfirmClearCacheFragment r2) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_deviceinfo_PrivateVolumeSettings$ConfirmClearCacheFragment__onResume$___twin___();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.reportVisibleTime(r0, true);
            return;
        }
    }

    public static class OtherInfoFragment extends DialogFragment {
        public void com_android_settings_deviceinfo_PrivateVolumeSettings$OtherInfoFragment__onCreate$___twin___(Bundle r1) {
            super.onCreate(r1);
        }

        public void com_android_settings_deviceinfo_PrivateVolumeSettings$OtherInfoFragment__onResume$___twin___() {
            super.onResume();
        }

        @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
        public void onCreate(Bundle r1) {
            com_android_settings_deviceinfo_PrivateVolumeSettings$OtherInfoFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
        }

        @Override // androidx.fragment.app.Fragment
        public void onResume() {
            com_android_settings_deviceinfo_PrivateVolumeSettings$OtherInfoFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
        }

        public OtherInfoFragment() {
        }

        public static void show(Fragment r3, String r4, VolumeInfo r5) {
            if (r3.isAdded() == true) goto L5;
            return;
        L5:
            OtherInfoFragment r0 = new OtherInfoFragment();
            r0.setTargetFragment(r3, 0);
            Bundle r1 = new Bundle();
            r1.putString("android.intent.extra.TITLE", r4);
            r1.putParcelable("android.intent.extra.INTENT", r5.buildBrowseIntent());
            r0.setArguments(r1);
            r0.show(r3.getParentFragmentManager(), PrivateVolumeSettings.TAG_OTHER_INFO);
        }

        @Override // androidx.fragment.app.DialogFragment
        public Dialog onCreateDialog(Bundle r6) {
            FragmentActivity r7 = getActivity();
            String r0 = getArguments().getString("android.intent.extra.TITLE");
            final Intent r1 = (Intent) getArguments().getParcelable("android.intent.extra.INTENT");
            AlertDialog.Builder r2 = new AlertDialog.Builder(r7);
            r2.setMessage(TextUtils.expandTemplate(getText(R.string.storage_detail_dialog_other), new CharSequence[]{r0}));
            r2.setPositiveButton(R.string.storage_menu_explore, new AnonymousClass1(this, r1));
            r2.setNegativeButton(android.R.string.cancel, null);
            return r2.create();
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onCreate")
        public static void com_android_settings_deviceinfo_PrivateVolumeSettings$OtherInfoFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(OtherInfoFragment r2, Bundle r3) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_deviceinfo_PrivateVolumeSettings$OtherInfoFragment__onCreate$___twin___(r3);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
            AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r4.callingPackageEvent("self", r0, true);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_deviceinfo_PrivateVolumeSettings$OtherInfoFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(OtherInfoFragment r2) {
            String r0 = r2.getClass().getName();
            com_android_settings_deviceinfo_PrivateVolumeSettings$OtherInfoFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.recordVisibleTime(r0);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_deviceinfo_PrivateVolumeSettings$OtherInfoFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(OtherInfoFragment r2) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_deviceinfo_PrivateVolumeSettings$OtherInfoFragment__onResume$___twin___();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.reportVisibleTime(r0, true);
            return;
        }
    }

    public static class RenameFragment extends DialogFragment {
        public void com_android_settings_deviceinfo_PrivateVolumeSettings$RenameFragment__onCreate$___twin___(Bundle r1) {
            super.onCreate(r1);
        }

        public void com_android_settings_deviceinfo_PrivateVolumeSettings$RenameFragment__onResume$___twin___() {
            super.onResume();
        }

        @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
        public void onCreate(Bundle r1) {
            com_android_settings_deviceinfo_PrivateVolumeSettings$RenameFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
        }

        @Override // androidx.fragment.app.Fragment
        public void onResume() {
            com_android_settings_deviceinfo_PrivateVolumeSettings$RenameFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
        }

        public RenameFragment() {
        }

        public static void show(PrivateVolumeSettings r3, VolumeInfo r4) {
            if (r3.isAdded() == true) goto L5;
            return;
        L5:
            RenameFragment r0 = new RenameFragment();
            r0.setTargetFragment(r3, 0);
            Bundle r1 = new Bundle();
            r1.putString("android.os.storage.extra.FS_UUID", r4.getFsUuid());
            r0.setArguments(r1);
            r0.show(r3.getParentFragmentManager(), PrivateVolumeSettings.TAG_RENAME);
        }

        @Override // androidx.fragment.app.DialogFragment
        public Dialog onCreateDialog(Bundle r8) {
            FragmentActivity r9 = getActivity();
            final StorageManager r0 = (StorageManager) r9.getSystemService(StorageManager.class);
            final String r1 = getArguments().getString("android.os.storage.extra.FS_UUID");
            r0.findVolumeByUuid(r1);
            VolumeRecord r2 = r0.findRecordByUuid(r1);
            AlertDialog.Builder r3 = new AlertDialog.Builder(r9);
            View r10 = LayoutInflater.from(r3.getContext()).inflate(R.layout.dialog_edittext, null, false);
            final OEditText r4 = ((OInputView) r10.findViewById(R.id.edittext)).getVInput();
            r4.setText(r2.getNickname());
            r3.setTitle(R.string.storage_rename_title);
            r3.setView(r10);
            r3.setPositiveButton(R.string.save, new AnonymousClass1(this, r0, r1, r4));
            r3.setNegativeButton(R.string.cancel, null);
            return r3.create();
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onCreate")
        public static void com_android_settings_deviceinfo_PrivateVolumeSettings$RenameFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(RenameFragment r2, Bundle r3) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_deviceinfo_PrivateVolumeSettings$RenameFragment__onCreate$___twin___(r3);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
            AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r4.callingPackageEvent("self", r0, true);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_deviceinfo_PrivateVolumeSettings$RenameFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(RenameFragment r2) {
            String r0 = r2.getClass().getName();
            com_android_settings_deviceinfo_PrivateVolumeSettings$RenameFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.recordVisibleTime(r0);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_deviceinfo_PrivateVolumeSettings$RenameFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(RenameFragment r2) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_deviceinfo_PrivateVolumeSettings$RenameFragment__onResume$___twin___();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.reportVisibleTime(r0, true);
            return;
        }
    }

    public static class UserInfoFragment extends DialogFragment {
        public void com_android_settings_deviceinfo_PrivateVolumeSettings$UserInfoFragment__onCreate$___twin___(Bundle r1) {
            super.onCreate(r1);
        }

        public void com_android_settings_deviceinfo_PrivateVolumeSettings$UserInfoFragment__onResume$___twin___() {
            super.onResume();
        }

        @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
        public void onCreate(Bundle r1) {
            com_android_settings_deviceinfo_PrivateVolumeSettings$UserInfoFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
        }

        @Override // androidx.fragment.app.Fragment
        public void onResume() {
            com_android_settings_deviceinfo_PrivateVolumeSettings$UserInfoFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
        }

        public UserInfoFragment() {
        }

        public static void show(Fragment r3, CharSequence r4, CharSequence r5) {
            if (r3.isAdded() == true) goto L5;
            return;
        L5:
            UserInfoFragment r0 = new UserInfoFragment();
            r0.setTargetFragment(r3, 0);
            Bundle r1 = new Bundle();
            r1.putCharSequence("android.intent.extra.TITLE", r4);
            r1.putCharSequence("android.intent.extra.SUBJECT", r5);
            r0.setArguments(r1);
            r0.show(r3.getParentFragmentManager(), PrivateVolumeSettings.TAG_USER_INFO);
        }

        @Override // androidx.fragment.app.DialogFragment
        public Dialog onCreateDialog(Bundle r5) {
            FragmentActivity r6 = getActivity();
            CharSequence r0 = getArguments().getCharSequence("android.intent.extra.TITLE");
            CharSequence r1 = getArguments().getCharSequence("android.intent.extra.SUBJECT");
            AlertDialog.Builder r2 = new AlertDialog.Builder(r6);
            r2.setMessage(TextUtils.expandTemplate(getText(R.string.storage_detail_dialog_user), new CharSequence[]{r0, r1}));
            r2.setPositiveButton(android.R.string.ok, null);
            return r2.create();
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onCreate")
        public static void com_android_settings_deviceinfo_PrivateVolumeSettings$UserInfoFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(UserInfoFragment r2, Bundle r3) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_deviceinfo_PrivateVolumeSettings$UserInfoFragment__onCreate$___twin___(r3);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
            AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r4.callingPackageEvent("self", r0, true);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_deviceinfo_PrivateVolumeSettings$UserInfoFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(UserInfoFragment r2) {
            String r0 = r2.getClass().getName();
            com_android_settings_deviceinfo_PrivateVolumeSettings$UserInfoFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.recordVisibleTime(r0);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_deviceinfo_PrivateVolumeSettings$UserInfoFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(UserInfoFragment r2) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_deviceinfo_PrivateVolumeSettings$UserInfoFragment__onResume$___twin___();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.reportVisibleTime(r0, true);
            return;
        }
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_deviceinfo_PrivateVolumeSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_deviceinfo_PrivateVolumeSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    static /* synthetic */ void access$000(PrivateVolumeSettings r0) {
        r0.setBigFileScanProgress();
    }

    static /* synthetic */ int access$100(PrivateVolumeSettings r0) {
        return r0.mTitleRes;
    }

    static /* synthetic */ void access$200(PrivateVolumeSettings r0, com.android.settingslib.deviceinfo.StorageMeasurement.MeasurementDetails r1) {
        r0.updateDetails(r1);
    }

    static /* synthetic */ VolumeInfo access$300(PrivateVolumeSettings r0) {
        return r0.mVolume;
    }

    static /* synthetic */ VolumeInfo access$302(PrivateVolumeSettings r0, VolumeInfo r1) {
        r0.mVolume = r1;
        return r1;
    }

    static /* synthetic */ void access$400(PrivateVolumeSettings r0) {
        r0.update();
    }

    static /* synthetic */ String access$500(PrivateVolumeSettings r0) {
        return r0.mVolumeId;
    }

    static /* synthetic */ StorageManager access$600(PrivateVolumeSettings r0) {
        return r0.mStorageManager;
    }

    static {
        ITEMS_NO_SHOW_SHARED = new int[]{R.string.storage_detail_apps};
        ITEMS_SHOW_SHARED = new int[]{R.string.storage_detail_apps, R.string.storage_detail_images, R.string.storage_detail_videos, R.string.storage_detail_audio, R.string.storage_detail_other};
        ITEMS_COLOR_NO_SHOW_SHARED = new int[]{R.color.memory_apps_usage};
        ITEMS_COLOR_SHOW_SHARED = new int[]{R.color.memory_apps_usage, R.color.memory_dcim, R.color.memory_video, R.color.memory_audio, R.color.memory_misc};
    }

    private boolean isVolumeValid() {
        VolumeInfo r0 = this.mVolume;
        if (r0 != null) goto L5;
    L9:
        return false;
    L5:
        if (r0.getType() != 1) goto L9;
        if (this.mVolume.isMountedReadable() == false) goto L9;
        return true;
    }

    public PrivateVolumeSettings() {
        this.mItemPreferencePool = Lists.newArrayList();
        this.mHeaderPreferencePool = Lists.newArrayList();
        this.mTitleRes = R.string.advanced_item_storate;
        final Handler r1 = new Handler();
        this.mBigFileScanObserver = new AnonymousClass1(this, r1);
        this.mClickListener = new AnonymousClass2(this);
        this.mReceiver = new AnonymousClass3(this);
        this.mStorageListener = new AnonymousClass4(this);
        setRetainInstance(true);
    }

    public void com_android_settings_deviceinfo_PrivateVolumeSettings__onCreate$___twin___(Bundle r5) {
        super.onCreate(r5);
        FragmentActivity r6 = getActivity();
        ContentResolver r0 = r6.getContentResolver();
        this.mContentResolver = r0;
        r0.registerContentObserver(Settings.System.getUriFor(BIG_FILE_SCANNING_STATE), false, this.mBigFileScanObserver);
        this.mUserManager = (UserManager) r6.getSystemService(UserManager.class);
        StorageManager r1 = (StorageManager) r6.getSystemService(StorageManager.class);
        this.mStorageManager = r1;
        this.mVolumeId = HeaderConstants.PRIVATE;
        VolumeInfo r2 = r1.findVolumeById(HeaderConstants.PRIVATE);
        this.mVolume = r2;
        this.mSharedVolume = this.mStorageManager.findEmulatedForPrivate(r2);
        com.android.settingslib.deviceinfo.StorageMeasurement r3 = new com.android.settingslib.deviceinfo.StorageMeasurement(r6, this.mVolume, this.mSharedVolume);
        this.mMeasure = r3;
        r3.setReceiver(this.mReceiver);
        if (isVolumeValid() == true) goto L6;
        getActivity().finish();
        return;
    L6:
        addPreferencesFromResource(R.xml.device_info_storage_volume);
        getPreferenceScreen().setOrderingAsAdded(true);
        this.mSummary = new StorageSummaryPreference(getPrefContext());
        this.mCurrentUser = this.mUserManager.getUserInfo(UserHandle.myUserId());
        this.mExplore = buildAction(R.string.storage_menu_explore);
        this.mNeedsUpdate = true;
        setHasOptionsMenu(true);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle r3) {
        super.onActivityCreated(r3);
        ListView r4 = (ListView) getView().findViewById(android.R.id.list);
        r4.setPadding(0, getResources().getDimensionPixelSize(R.dimen.settings_item_top_bottom_margin), 0, 0);
        r4.setSelector(android.R.color.transparent);
        r4.addFooterView(inflateFileCleanupView());
    }

    private View inflateFileCleanupView() {
        LayoutInflater r0 = LayoutInflater.from(getActivity());
        View r1 = r0.inflate(R.layout.memory_file_cleanup, null);
        SettingItemText r2 = (SettingItemText) r1.findViewById(R.id.big_files_cleanup);
        this.mBigFilesCleanUp = r2;
        r2.setOnClickListener(this.mClickListener);
        this.mBigFileScanProgressBar = r0.inflate(R.layout.progress_white_small_layout, this.mBigFilesCleanUp, false);
        setBigFileScanProgress();
        r1.findViewById(R.id.app_management).setOnClickListener(this.mClickListener);
        return r1;
    }

    private void setBigFileScanProgress() {
        if (this.mBigFilesCleanUp != null) goto L5;
        return;
    L5:
        boolean r2 = true;
        if (Settings.System.getInt(this.mContentResolver, BIG_FILE_SCANNING_STATE, 1) == 1) goto L9;
        r2 = false;
    L9:
        SettingItemText r0 = this.mBigFilesCleanUp;
        if (r2 == false) goto L12;
        View r3 = null;
    L13:
        r0.setRightExpandView(r3);
        return;
    L12:
        r3 = this.mBigFileScanProgressBar;
        goto L13
    }

    private void setTitle() {
        getActivity().setTitle(this.mStorageManager.getBestVolumeDescription(this.mVolume));
    }

    private void update() {
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L6;
        return;
    L6:
        if (isVolumeValid() == true) goto L9;
        r0.finish();
        return;
    L9:
        setTitle();
        r0.invalidateOptionsMenu();
        FragmentActivity r1 = getActivity();
        PreferenceScreen r2 = getPreferenceScreen();
        r2.removeAll();
        addPreference(r2, this.mSummary);
        List r3 = this.mUserManager.getUsers();
        int r4 = r3.size();
        if (r4 <= 1) goto L12;
        boolean r5 = true;
    L13:
        VolumeInfo r6 = this.mSharedVolume;
        if (r6 != null) goto L16;
    L18:
        boolean r7 = false;
    L19:
        this.mItemPoolIndex = 0;
        this.mHeaderPoolIndex = 0;
        int r8 = 0;
        int r9 = 0;
    L20:
        if (r8 >= r4) goto L29;
        UserInfo r10 = (UserInfo) r3.get(r8);
        if (isProfileOf(this.mCurrentUser, r10) == false) goto L27;
        if (r5 == false) goto L25;
        PreferenceGroup r11 = addCategory(r2, r10.name);
    L26:
        addDetailItems(r11, r7, r10.id);
        r9 = r9 + 1;
        goto L27
    L25:
        r11 = r2;
    L27:
        r8 = r8 + 1;
        goto L20
    L29:
        if ((r4 - r9) <= 0) goto L36;
        PreferenceCategory r12 = addCategory(r2, getText(R.string.storage_other_users));
        int r13 = 0;
    L31:
        if (r13 >= r4) goto L36;
        UserInfo r14 = (UserInfo) r3.get(r13);
        if (isProfileOf(this.mCurrentUser, r14) == true) goto L35;
        addItem(r12, 0, r14.name, r14.id, 0);
    L35:
        r13 = r13 + 1;
    L36:
        addItem(r2, R.string.storage_detail_cached, null, -10000, R.color.memory_cache);
        File r15 = this.mVolume.getPath();
        long r16 = r15.getTotalSpace();
        long r17 = r16 - r15.getFreeSpace();
        Formatter.BytesResult r18 = Formatter.formatBytes(getResources(), r17, 0);
        this.mSummary.setTitle(TextUtils.expandTemplate(getText(R.string.storage_size_large), new CharSequence[]{r18.value, r18.units}));
        this.mSummary.setSummary(getString(R.string.storage_volume_used, new Object[]{Formatter.formatFileSize(r1, r16).replace('k', 'K')}));
        this.mSummary.setPercent((int) ((r17 * 100) / r16));
        this.mMeasure.forceMeasure();
        this.mNeedsUpdate = false;
        return;
    L16:
        if (r6.isMountedReadable() == false) goto L18;
        r7 = true;
        goto L19
    L12:
        r5 = false;
        goto L13
    }

    private void addPreference(PreferenceGroup r1, Preference r2) {
        r2.setOrder(Integer.MAX_VALUE);
        r1.addPreference(r2);
    }

    private PreferenceCategory addCategory(PreferenceGroup r5, CharSequence r6) {
        if (this.mHeaderPoolIndex >= this.mHeaderPreferencePool.size()) goto L5;
        PreferenceCategory r0 = this.mHeaderPreferencePool.get(this.mHeaderPoolIndex);
    L6:
        r0.setTitle(r6);
        r0.removeAll();
        addPreference(r5, r0);
        this.mHeaderPoolIndex++;
        return r0;
    L5:
        r0 = new PreferenceCategory(getPrefContext(), null, android.R.attr.preferenceCategoryStyle);
        this.mHeaderPreferencePool.add(r0);
        goto L6
    }

    private void addDetailItems(PreferenceGroup r10, boolean r11, int r12) {
        if (r11 == false) goto L4;
        int[] r0 = ITEMS_SHOW_SHARED;
    L5:
        if (r11 == false) goto L7;
        int[] r13 = ITEMS_COLOR_SHOW_SHARED;
    L8:
        int r1 = 0;
    L10:
        if (r1 >= r0.length) goto L12;
        addItem(r10, r0[r1], null, r12, r13[r1]);
        r1 = r1 + 1;
        goto L10
    L12:
        return;
    L7:
        r13 = ITEMS_COLOR_NO_SHOW_SHARED;
        goto L8
    L4:
        r0 = ITEMS_NO_SHOW_SHARED;
        goto L5
    }

    private void addItem(PreferenceGroup r3, int r4, CharSequence r5, int r6, int r7) {
        if (this.mItemPoolIndex >= this.mItemPreferencePool.size()) goto L5;
        StorageItemPreference r8 = this.mItemPreferencePool.get(this.mItemPoolIndex);
    L6:
        if (r5 == null) goto L8;
        r8.setTitle(r5);
        r8.setKey(r5.toString());
    L9:
        r8.setSummary(R.string.memory_calculating_size);
        r8.userHandle = r6;
        addPreference(r3, r8);
        this.mItemPoolIndex++;
        return;
    L8:
        r8.setTitle(r4);
        r8.setKey(Integer.toString(r4));
        goto L9
    L5:
        r8 = buildItem(r7);
        this.mItemPreferencePool.add(r8);
        goto L6
    }

    private StorageItemPreference buildItem(int r2) {
        return new StorageItemPreference(getPrefContext(), r2);
    }

    private Preference buildAction(int r2) {
        Preference r0 = new Preference(getPrefContext());
        r0.setTitle(r2);
        r0.setKey(Integer.toString(r2));
        return r0;
    }

    public void com_android_settings_deviceinfo_PrivateVolumeSettings__onResume$___twin___() {
        super.onResume();
        this.mVolume = this.mStorageManager.findVolumeById(this.mVolumeId);
        if (isVolumeValid() == true) goto L6;
        getActivity().finish();
        return;
    L6:
        this.mStorageManager.registerListener(this.mStorageListener);
        if (this.mNeedsUpdate == false) goto L9;
        update();
        return;
    L9:
        setTitle();
    }

    @Override // com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mStorageManager.unregisterListener(this.mStorageListener);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        StorageManager r0 = this.mStorageManager;
        if (r0 == null) goto L7;
        StorageEventListener r1 = this.mStorageListener;
        if (r1 == null) goto L7;
        r0.unregisterListener(r1);
    L7:
        ContentResolver r2 = this.mContentResolver;
        if (r2 == null) goto L12;
        ContentObserver r3 = this.mBigFileScanObserver;
        if (r3 == null) goto L12;
        r2.unregisterContentObserver(r3);
    L12:
        super.onDestroy();
        com.android.settingslib.deviceinfo.StorageMeasurement r4 = this.mMeasure;
        if (r4 == null) goto L16;
        r4.onDestroy();
        return;
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu r1, MenuInflater r2) {
        super.onCreateOptionsMenu(r1, r2);
        r2.inflate(R.menu.storage_volume, r1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPrepareOptionsMenu(Menu r9) {
        if (isVolumeValid() == true) goto L5;
        return;
    L5:
        MenuItem r0 = r9.findItem(R.id.storage_rename);
        MenuItem r1 = r9.findItem(R.id.storage_mount);
        MenuItem r2 = r9.findItem(R.id.storage_unmount);
        MenuItem r3 = r9.findItem(R.id.storage_format);
        MenuItem r4 = r9.findItem(R.id.storage_migrate);
        MenuItem r10 = r9.findItem(R.id.storage_cleanup);
        boolean r6 = true;
        if (HeaderConstants.PRIVATE.equals(this.mVolume.getId()) == false) goto L9;
        r0.setVisible(false);
        r1.setVisible(false);
        r2.setVisible(false);
        r3.setVisible(false);
    L17:
        r3.setTitle(R.string.storage_menu_format_public);
        VolumeInfo r5 = getActivity().getPackageManager().getPrimaryStorageCurrentVolume();
        if (r5 != null) goto L20;
    L24:
        r6 = false;
    L25:
        r4.setVisible(r6);
        r10.setVisible(getResources().getBoolean(R.bool.enable_storage_cleanup));
        return;
    L20:
        if (r5.getType() != 1) goto L24;
        if (Objects.equals(this.mVolume, r5) == true) goto L24;
    L9:
        if (this.mVolume.getType() != 1) goto L11;
        boolean r7 = true;
    L12:
        r0.setVisible(r7);
        if (this.mVolume.getState() != 0) goto L15;
        boolean r8 = true;
    L16:
        r1.setVisible(r8);
        r2.setVisible(this.mVolume.isMountedReadable());
        r3.setVisible(true);
        goto L17
    L15:
        r8 = false;
        goto L16
    L11:
        r7 = false;
        goto L12
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem r9) {
        FragmentActivity r0 = getActivity();
        Bundle r6 = new Bundle();
        switch(r9.getItemId()) {
            case 2131431075: goto L16;
            case 2131431077: goto L14;
            case 2131431080: goto L12;
            case 2131431081: goto L10;
            case 2131431086: goto L8;
            case 2131431087: goto L6;
            default: goto L5;
        };
    L6:
        r6.putString("android.os.storage.extra.VOLUME_ID", this.mVolume.getId());
        startFragment(this, PrivateVolumeUnmount.class.getCanonicalName(), R.string.storage_menu_unmount, 0, r6);
        return true;
    L8:
        RenameFragment.show(this, this.mVolume);
        return true;
    L10:
        new StorageSettings.MountTask(r0, this.mVolume).execute(new Void[0]);
        return true;
    L12:
        Intent r10 = new Intent(r0, StorageWizardMigrateConfirm.class);
        r10.putExtra("android.os.storage.extra.VOLUME_ID", this.mVolume.getId());
        startActivity(r10);
        return true;
    L14:
        r6.putString("android.os.storage.extra.VOLUME_ID", this.mVolume.getId());
        startFragment(this, PrivateVolumeFormat.class.getCanonicalName(), R.string.storage_menu_format, 0, r6);
        return true;
    L16:
        startStorageCleanupActivity();
        return true;
    L5:
        return super.onOptionsItemSelected(r9);
    }

    private void startStorageCleanupActivity() {
        Intent r0 = new Intent();     // Catch: ActivityNotFoundException -> L4
        r0.setClassName(STORAGE_CLEANUP_PACKAGE, STORAGE_CLENUP_CLASS);     // Catch: ActivityNotFoundException -> L4
        startActivity(r0);     // Catch: ActivityNotFoundException -> L4
        return;
    L4:
        OLog.e("StorageSettings", "Can't start storage cleanup activity");
    }

    private void updateDetails(com.android.settingslib.deviceinfo.StorageMeasurement.MeasurementDetails r10) {
        int r1 = 0;
    L4:
        if (r1 >= this.mItemPoolIndex) goto L22;
        StorageItemPreference r2 = this.mItemPreferencePool.get(r1);
        int r3 = r2.userHandle;
        int r4 = Integer.parseInt(r2.getKey());     // Catch: NumberFormatException -> L8
    L9:
        if (r4 != 0) goto L11;
        updatePreference(r2, r10.usersSize.get(r3));
    L21:
        r1 = r1 + 1;
        goto L4
    L11:
        switch(r4) {
            case 2131958689: goto L19;
            case 2131958690: goto L18;
            case 2131958691: goto L17;
            default: goto L12;
        };
    L12:
        switch(r4) {
            case 2131958695: goto L16;
            case 2131958696: goto L15;
            case 2131958697: goto L14;
            default: goto L21;
        };
    L14:
        updatePreference(r2, totalValues(r10, r3, new String[]{Environment.DIRECTORY_MOVIES}));
        goto L21
    L15:
        updatePreference(r2, r10.miscSize.get(r3));
        goto L21
    L16:
        updatePreference(r2, totalValues(r10, r3, new String[]{Environment.DIRECTORY_DCIM, Environment.DIRECTORY_MOVIES, Environment.DIRECTORY_PICTURES}));
        goto L21
    L17:
        updatePreference(r2, r10.cacheSize);
        goto L21
    L18:
        updatePreference(r2, totalValues(r10, r3, new String[]{Environment.DIRECTORY_MUSIC, Environment.DIRECTORY_ALARMS, Environment.DIRECTORY_NOTIFICATIONS, Environment.DIRECTORY_RINGTONES, Environment.DIRECTORY_PODCASTS}));
        goto L21
    L19:
        updatePreference(r2, r10.appsSize.get(r3));
    L8:
        r4 = 0;
        goto L9
    }

    private void updatePreference(StorageItemPreference r3, long r4) {
        r3.setStorageSize(r4, this.mVolume.getPath().getTotalSpace());
    }

    private boolean isProfileOf(UserInfo r2, UserInfo r3) {
        if (r2.id != r3.id) goto L5;
    L10:
        return true;
    L5:
        if (r2.profileGroupId != (-10000)) goto L7;
    L9:
        return false;
    L7:
        if (r2.profileGroupId != r3.profileGroupId) goto L9;
        goto L9
    }

    private static long totalValues(com.android.settingslib.deviceinfo.StorageMeasurement.MeasurementDetails r5, int r6, String... r7) {
        HashMap<String, Long> r8 = r5.mediaSize.get(r6);
        long r0 = 0;
        if (r8 == null) goto L10;
        int r9 = r7.length;
        int r2 = 0;
    L5:
        if (r2 >= r9) goto L11;
        String r3 = r7[r2];
        if (r8.containsKey(r3) == false) goto L9;
        r0 = r0 + r8.get(r3).longValue();
    L9:
        r2 = r2 + 1;
    L11:
        return r0;
    L10:
        OLog.w("StorageSettings", "MeasurementDetails mediaSize array does not have key for user " + r6);
        goto L11
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_deviceinfo_PrivateVolumeSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(PrivateVolumeSettings r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_deviceinfo_PrivateVolumeSettings__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_deviceinfo_PrivateVolumeSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(PrivateVolumeSettings r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_deviceinfo_PrivateVolumeSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_deviceinfo_PrivateVolumeSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(PrivateVolumeSettings r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_deviceinfo_PrivateVolumeSettings__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
