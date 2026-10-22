package com.android.settings.about.status;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.UserHandle;
import android.provider.Settings;
import android.util.AttributeSet;
import android.view.View;
import com.android.internal.widget.LockPatternUtils;
import com.android.settings.ChooseLockSettingsHelper;
import com.android.settings.R;
import com.android.settings.SettingsApplication;
import com.android.settings.about.DeviceStatusItemView;
import com.android.settings.about.DeviceUtils;
import com.android.settings.settingitemsprovider.DatabaseHelper;
import com.android.settings.utils.DevicePolicyUtils;
import com.android.settings.utils.ResourceUtils;
import com.obric.oui.toast.OToast;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ModVersionStatusItemView.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0018\u001a\u00020\u0019H\u0002J\"\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0019H\u0002R\u000e\u0010\t\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006 "}, d2 = {"Lcom/android/settings/about/status/ModVersionStatusItemView;", "Lcom/android/settings/about/DeviceStatusItemView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "REQUEST_CONFIRM_PWD_CODE", "TAPS_TO_BE_A_DEVELOPER", "activity", "Landroid/app/Activity;", "mDevHitCountdown", "getMDevHitCountdown", "()I", "setMDevHitCountdown", "(I)V", "mDevHitToast", "Lcom/obric/oui/toast/OToast;", "getMDevHitToast", "()Lcom/obric/oui/toast/OToast;", "setMDevHitToast", "(Lcom/obric/oui/toast/OToast;)V", "enableDevelopSettings", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onDevHit", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ModVersionStatusItemView extends DeviceStatusItemView {
    private final int REQUEST_CONFIRM_PWD_CODE;
    private final int TAPS_TO_BE_A_DEVELOPER;
    private final Activity activity;
    private int mDevHitCountdown;
    private OToast mDevHitToast;

    /* JADX INFO: renamed from: $r8$lambda$_LQmsRfbf4_WI4Ny6WcuWPzEG-Q, reason: not valid java name */
    public static /* synthetic */ void m224$r8$lambda$_LQmsRfbf4_WI4Ny6WcuWPzEGQ(ModVersionStatusItemView r0, View r1) {
        _init_$lambda$0(r0, r1);
    }

    public ModVersionStatusItemView(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public ModVersionStatusItemView(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ ModVersionStatusItemView(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public ModVersionStatusItemView(Context r8, AttributeSet r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r9, r10, null, 197);
        int r11 = 7;
        this.TAPS_TO_BE_A_DEVELOPER = 7;
        this.REQUEST_CONFIRM_PWD_CODE = 1;
        this.activity = (Activity) r8;
        if (SettingsApplication.getContext().getSharedPreferences("development", 0).getBoolean("show", false) == false) goto L5;
        r11 = -1;
    L5:
        this.mDevHitCountdown = r11;
        initData(ResourceUtils.getString(R.string.mod_version), DeviceUtils.INSTANCE.getShortOSVersion());
        setOnClickListener(new ModVersionStatusItemView$$ExternalSyntheticLambda0(this));
    }

    public final int getMDevHitCountdown() {
        return this.mDevHitCountdown;
    }

    public final void setMDevHitCountdown(int r1) {
        this.mDevHitCountdown = r1;
    }

    public final OToast getMDevHitToast() {
        return this.mDevHitToast;
    }

    public final void setMDevHitToast(OToast r1) {
        this.mDevHitToast = r1;
    }

    private static final void _init_$lambda$0(ModVersionStatusItemView r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.onDevHit();
    }

    private final void onDevHit() {
        if (UserHandle.myUserId() == 0) goto L5;
        return;
    L5:
        Context r0 = getContext();
        Intrinsics.checkNotNullExpressionValue(r0, "getContext(...)");
        if (DevicePolicyUtils.trySendShowAdminSupportDetailsIntent(r0, "no_debugging_features") == false) goto L8;
        return;
    L8:
        int r1 = this.mDevHitCountdown;
        if (r1 <= 0) goto L25;
        int r2 = r1 - 1;
        this.mDevHitCountdown = r2;
        if (r2 != 0) goto L20;
        OToast r3 = this.mDevHitToast;
        if (r3 == null) goto L16;
        r3.cancel();
    L16:
        if (new LockPatternUtils(getContext()).isSecure(UserHandle.myUserId()) == false) goto L18;
        new ChooseLockSettingsHelper(this.activity).launchConfirmationActivity(this.REQUEST_CONFIRM_PWD_CODE, null, 2, true);
        return;
    L18:
        enableDevelopSettings();
        return;
    L20:
        if (r2 >= (this.TAPS_TO_BE_A_DEVELOPER - 2)) goto L33;
        OToast r4 = this.mDevHitToast;
        if (r4 == null) goto L24;
        r4.cancel();
    L24:
        Activity r5 = this.activity;
        Resources r6 = ResourceUtils.getResources();
        int r7 = this.mDevHitCountdown;
        String r8 = r6.getQuantityString(R.plurals.show_dev_countdown, r7, new Object[]{Integer.valueOf(r7)});
        Intrinsics.checkNotNullExpressionValue(r8, "getQuantityString(...)");
        OToast r9 = new OToast(r5, r8, 80, true, null, 0, 48, null);
        this.mDevHitToast = r9;
        r9.show();
        return;
    L33:
        return;
    L25:
        if (r1 >= 0) goto L35;
        OToast r10 = this.mDevHitToast;
        if (r10 == null) goto L29;
        r10.cancel();
    L29:
        OToast r11 = new OToast(this.activity, ResourceUtils.getString(R.string.show_dev_already), 80, true, null, 0, 48, null);
        this.mDevHitToast = r11;
        r11.show();
        return;
    }

    private final void enableDevelopSettings() {
        SettingsApplication.getContext().getSharedPreferences("development", 0).edit().putBoolean("show", true).apply();
        DatabaseHelper.getInstance(this.activity).updateDevelopmentSettingsSearchable(true);
        Settings.Global.putInt(this.activity.getContentResolver(), "development_settings_enabled", 1);
        OToast r0 = new OToast(this.activity, ResourceUtils.getString(R.string.show_dev_on), 80, true, null, 0, 48, null).setLeftDrawable(Integer.valueOf(R.drawable.settings_oic_checkmark_checked));
        this.mDevHitToast = r0;
        if (r0 == null) goto L6;
        r0.show();
        return;
    }

    @Override // com.android.settings.about.DeviceStatusItemView
    public void onActivityResult(int r1, int r2, Intent r3) {
        super.onActivityResult(r1, r2, r3);
        if (r1 == this.REQUEST_CONFIRM_PWD_CODE) goto L5;
        return;
    L5:
        if (r2 != (-1)) goto L9;
        enableDevelopSettings();
        return;
    }
}
