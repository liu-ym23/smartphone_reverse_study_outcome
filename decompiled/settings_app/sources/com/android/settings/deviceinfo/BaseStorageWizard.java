package com.android.settings.deviceinfo;

import android.os.Bundle;
import android.os.storage.DiskInfo;
import android.os.storage.StorageEventListener;
import android.os.storage.StorageManager;
import android.os.storage.VolumeInfo;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.android.settings.R;
import com.android.settings.utils.NullSafe;
import com.android.setupwizardlib.SetupWizardLayout;
import com.obric.privacy.GrantUtil;
import com.obric.privacy.LifeHookActivity2;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Insert;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseStorageWizard extends LifeHookActivity2 {
    protected static final int ILLUSTRATION_INTERNAL = 1;
    protected static final int ILLUSTRATION_PORTABLE = 2;
    protected static final int ILLUSTRATION_SETUP = 0;
    private View mCustomNav;
    private Button mCustomNext;
    protected DiskInfo mDisk;
    protected StorageManager mStorage;
    private final StorageEventListener mStorageListener;
    protected VolumeInfo mVolume;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_deviceinfo_BaseStorageWizard_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com_android_settings_deviceinfo_BaseStorageWizard_com_obric_hook_lancet_PrivacyHookActivity2_onDestroy(this);
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle r1) {
        com_android_settings_deviceinfo_BaseStorageWizard_com_obric_hook_lancet_PrivacyHookActivity2_onPostCreate(this, r1);
    }

    protected void setIllustrationType(int r1) {
    }

    public BaseStorageWizard() {
        this.mStorageListener = new AnonymousClass2(this);
    }

    public void com_android_settings_deviceinfo_BaseStorageWizard__onCreate$___twin___(Bundle r2) {
        super.onCreate(r2);
        this.mStorage = (StorageManager) NullSafe.nonNull((StorageManager) getSystemService(StorageManager.class));
        String r3 = getIntent().getStringExtra("android.os.storage.extra.VOLUME_ID");
        if (TextUtils.isEmpty(r3) == true) goto L5;
        this.mVolume = this.mStorage.findVolumeById(r3);
    L5:
        String r4 = getIntent().getStringExtra("android.os.storage.extra.DISK_ID");
        if (TextUtils.isEmpty(r4) == true) goto L8;
        this.mDisk = this.mStorage.findDiskById(r4);
    L11:
        setTheme(R.style.ActivityTheme2);
        if (this.mDisk == null) goto L15;
        this.mStorage.registerListener(this.mStorageListener);
        return;
    L15:
        return;
    L8:
        VolumeInfo r5 = this.mVolume;
        if (r5 == null) goto L11;
        this.mDisk = r5.getDisk();
        goto L11
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int r5) {
        super.setContentView(r5);
        ViewGroup r0 = (ViewGroup) findViewById(R.id.suw_layout_navigation_bar).getParent();
        int r3 = 0;
        View r1 = getLayoutInflater().inflate(R.layout.storage_wizard_navigation, r0, false);
        this.mCustomNav = r1;
        Button r2 = (Button) r1.findViewById(R.id.suw_navbar_next);
        this.mCustomNext = r2;
        r2.setOnClickListener(new AnonymousClass1(this));
    L4:
        if (r3 >= r0.getChildCount()) goto L12;
        if (r0.getChildAt(r3).getId() == R.id.suw_layout_navigation_bar) goto L7;
        r3 = r3 + 1;
        goto L4
    L7:
        r0.removeViewAt(r3);
        r0.addView(this.mCustomNav, r3);
        return;
    }

    public void com_android_settings_deviceinfo_BaseStorageWizard__onPostCreate$___twin___(Bundle r2) {
        super.onPostCreate(r2);
        Window r3 = getWindow();
        r3.addFlags(-2147417856);
        r3.setStatusBarColor(0);
        this.mCustomNav.setSystemUiVisibility(1280);
    }

    public void com_android_settings_deviceinfo_BaseStorageWizard__onDestroy$___twin___() {
        this.mStorage.unregisterListener(this.mStorageListener);
        super.onDestroy();
    }

    protected Button getNextButton() {
        return this.mCustomNext;
    }

    protected SetupWizardLayout getSetupWizardLayout() {
        return (SetupWizardLayout) findViewById(R.id.setup_wizard_layout);
    }

    protected ProgressBar getProgressBar() {
        return (ProgressBar) findViewById(R.id.storage_wizard_progress);
    }

    protected void setCurrentProgress(int r6) {
        ProgressBar r0 = getProgressBar();
        if (r0 == null) goto L5;
        r0.setProgress(r6);
    L5:
        TextView r5 = (TextView) findViewById(R.id.storage_wizard_progress_summary);
        if (r5 == null) goto L9;
        r5.setText(NumberFormat.getPercentInstance().format(((double) r6) / 100.0d));
        return;
    }

    protected void setHeaderText(int r1, String... r2) {
        CharSequence r3 = TextUtils.expandTemplate(getText(r1), r2);
        SetupWizardLayout r4 = getSetupWizardLayout();
        if (r4 == null) goto L5;
        r4.setHeaderText(r3);
    L5:
        setTitle(r3);
    }

    protected void setBodyText(int r2, String... r3) {
        ((TextView) findViewById(R.id.storage_wizard_body)).setText(TextUtils.expandTemplate(getText(r2), r3));
    }

    protected void setSecondaryBodyText(int r2, String... r3) {
        TextView r0 = (TextView) findViewById(R.id.storage_wizard_second_body);
        r0.setText(TextUtils.expandTemplate(getText(r2), r3));
        r0.setVisibility(0);
    }

    protected void setKeepScreenOn(boolean r1) {
        SetupWizardLayout r0 = getSetupWizardLayout();
        if (r0 == null) goto L6;
        r0.setKeepScreenOn(r1);
        return;
    }

    public void onNavigateNext() {
        throw new UnsupportedOperationException();
    }

    protected VolumeInfo findFirstVolume(int r5) {
        Iterator r0 = this.mStorage.getVolumes().iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        VolumeInfo r1 = (VolumeInfo) r0.next();
        if (Objects.equals(this.mDisk.getId(), r1.getDiskId()) == false) goto L4;
        if (r1.getType() != r5) goto L4;
        return r1;
    L10:
        return null;
    }

    @Insert("onCreate")
    public static void com_android_settings_deviceinfo_BaseStorageWizard_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(BaseStorageWizard r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        BaseStorageWizard r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_deviceinfo_BaseStorageWizard__onCreate$___twin___(r4);
    }

    @Insert("onPostCreate")
    public static void com_android_settings_deviceinfo_BaseStorageWizard_com_obric_hook_lancet_PrivacyHookActivity2_onPostCreate(BaseStorageWizard r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        BaseStorageWizard r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPostCreate(r4);
        return;
    L6:
        r3.com_android_settings_deviceinfo_BaseStorageWizard__onPostCreate$___twin___(r4);
    }

    @Insert("onDestroy")
    public static void com_android_settings_deviceinfo_BaseStorageWizard_com_obric_hook_lancet_PrivacyHookActivity2_onDestroy(BaseStorageWizard r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        BaseStorageWizard r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperDestroy();
        return;
    L6:
        r3.com_android_settings_deviceinfo_BaseStorageWizard__onDestroy$___twin___();
    }
}
