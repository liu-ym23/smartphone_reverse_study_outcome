package com.android.settings.notification;

import android.os.Bundle;
import android.os.UserHandle;
import android.os.UserManager;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import com.android.internal.widget.LockPatternUtils;
import com.android.settings.R;
import com.android.settings.SystemNotificationShowDetailFragment;
import com.android.settings.applications.utils.Item;
import com.android.settings.applications.utils.OCardListItemUtils;
import com.android.settings.applications.utils.OPopoverHelper;
import com.android.settings.base.BaseFragment;
import com.android.settings.databinding.LockNotificationLayoutBinding;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.teaevent.TrackerEvent;
import com.android.settings.utils.ResourceUtils;
import com.android.settingslib.drawer.EntriesProvider;
import com.obric.matrix.platform.sdk.ones.account.log.OLog;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.popover.v2.OPopover;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: compiled from: LockNotificationFragment.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 42\u00020\u0001:\u00014B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u000eH\u0002J\b\u0010\u0013\u001a\u00020\nH\u0002J\b\u0010\u0014\u001a\u00020\nH\u0002J\b\u0010\u0015\u001a\u00020\u000eH\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010\u0019\u001a\u00020\u0017H\u0002J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u000eH\u0002J$\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u0011H\u0002J\b\u0010%\u001a\u00020\u0017H\u0016J\b\u0010&\u001a\u00020\u0017H\u0016J\u001a\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\u001c2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010)\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\nH\u0002J\u0010\u0010+\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\nH\u0002J\b\u0010,\u001a\u00020\u0017H\u0002J\b\u0010-\u001a\u00020\u0017H\u0002J\b\u0010.\u001a\u00020\u0017H\u0002J\b\u0010/\u001a\u00020\u0017H\u0002J\b\u00100\u001a\u00020\u0017H\u0002J\b\u00101\u001a\u00020\u0017H\u0002J\u0010\u00102\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u000eH\u0002J\b\u00103\u001a\u00020\u0017H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/android/settings/notification/LockNotificationFragment;", "Lcom/android/settings/base/BaseFragment;", "()V", "mHideNotificationAlertDialog", "Lcom/obric/oui/dialog/v2/alert/OAlertDialog;", "mPopMenu", "Lcom/obric/oui/popover/v2/OPopover;", "viewBinding", "Lcom/android/settings/databinding/LockNotificationLayoutBinding;", "checkKeyGuardQuality", "", "genAiSpaceNotificationExpandClickListener", "Landroid/view/View$OnClickListener;", "mode", "", "genKeyguardNotificationThemeClickListener", "type", "Lcom/android/settings/notification/LockNotificationFragment$Companion$KeyguardNotificationTheme;", "getAiSpaceNotificationExpandMode", "getDozeEnableState", "getKeepLockScreenNotificationState", "getLockScreenNotificationMode", "initDozeEnableSwitch", "", "initKeepLockScreenNotificationSwitch", "initLockScreenNotification", "onAiSpaceNotificationExpandModeChanged", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onKeyguardNotificationThemeChanged", "theme", "onPause", "onResume", "onViewCreated", "view", "setDozeEnableState", EntriesProvider.METHOD_IS_CHECKED, "setKeepLockScreenNotificationState", "showHideNotificationAlertDialog", "showLockScreenNotificationPopMenu", "updateAiSpaceNotificationExpandMode", "updateDozeEnableSwitch", "updateKeepLockScreenNotificationSwitch", "updateKeyguardRoller", "updateLockScreenNotificationMode", "updateLockScreenNotificationStatus", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LockNotificationFragment extends BaseFragment {
    private static final int AI_SPACE_NOTIFICATION_EXPAND_AI_SPACE = 0;
    private static final int AI_SPACE_NOTIFICATION_EXPAND_NOTIFICATION = 1;
    public static final Companion Companion = null;
    public static final String FROM = "LockNotificationFragment";
    private static final String KEYGUARD_ROLLER = "keyguard_ntf_roller_pack_up";
    private static final String KEY_AI_SPACE_NOTIFICATION_EXPAND_MODE = "keyguard_ai_space_notification_expand_mode";
    private static final String KEY_KEEP_LOCK_SCREEN_NOTIFICATION = "obric_keyguard_show_old_ntfs";
    private static final int OFF = 0;
    private static final int ON = 1;
    private static final int TYPE_DISABLE = 2;
    private static final int TYPE_HIDE = 1;
    private static final int TYPE_SHOW = 0;
    private OAlertDialog mHideNotificationAlertDialog;
    private OPopover mPopMenu;
    private LockNotificationLayoutBinding viewBinding;

    /* JADX INFO: compiled from: LockNotificationFragment.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0010B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/android/settings/notification/LockNotificationFragment$Companion;", "", "()V", "AI_SPACE_NOTIFICATION_EXPAND_AI_SPACE", "", "AI_SPACE_NOTIFICATION_EXPAND_NOTIFICATION", "FROM", "", "KEYGUARD_ROLLER", "KEY_AI_SPACE_NOTIFICATION_EXPAND_MODE", "KEY_KEEP_LOCK_SCREEN_NOTIFICATION", "OFF", "ON", "TYPE_DISABLE", "TYPE_HIDE", "TYPE_SHOW", "KeyguardNotificationTheme", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: LockNotificationFragment.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/android/settings/notification/LockNotificationFragment$Companion$KeyguardNotificationTheme;", "", "()V", "Count", "List", "Lcom/android/settings/notification/LockNotificationFragment$Companion$KeyguardNotificationTheme$Count;", "Lcom/android/settings/notification/LockNotificationFragment$Companion$KeyguardNotificationTheme$List;", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        private static abstract class KeyguardNotificationTheme {

            /* JADX INFO: compiled from: LockNotificationFragment.kt */
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/android/settings/notification/LockNotificationFragment$Companion$KeyguardNotificationTheme$Count;", "Lcom/android/settings/notification/LockNotificationFragment$Companion$KeyguardNotificationTheme;", "()V", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static final class Count extends KeyguardNotificationTheme {
                public static final Count INSTANCE = null;

                static {
                    INSTANCE = new Count();
                }

                private Count() {
                    super(null);
                }
            }

            /* JADX INFO: compiled from: LockNotificationFragment.kt */
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/android/settings/notification/LockNotificationFragment$Companion$KeyguardNotificationTheme$List;", "Lcom/android/settings/notification/LockNotificationFragment$Companion$KeyguardNotificationTheme;", "()V", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static final class List extends KeyguardNotificationTheme {
                public static final List INSTANCE = null;

                static {
                    INSTANCE = new List();
                }

                private List() {
                    super(null);
                }
            }

            public /* synthetic */ KeyguardNotificationTheme(DefaultConstructorMarker r1) {
                this();
            }

            private KeyguardNotificationTheme() {
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    public static /* synthetic */ void $r8$lambda$5ChXlPx_o1MJcoyggMjMzzy1xFw(LockNotificationFragment r0, int r1, View r2) {
        genAiSpaceNotificationExpandClickListener$lambda$4(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$7CRtvqz3kgrBvrWYq2Hoqgc5MMw(LockNotificationFragment r0, CompoundButton r1, boolean r2) {
        initKeepLockScreenNotificationSwitch$lambda$8$lambda$7(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$JVOZum95R7KDzaiVXpVWBr3d5l8(LockNotificationFragment r0, View r1) {
        initLockScreenNotification$lambda$9(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$R9MWlpT0cdJjkt6O7gw5pUu48Y8(LockNotificationFragment r0, CompoundButton r1, boolean r2) {
        initDozeEnableSwitch$lambda$6$lambda$5(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$nR-jr2BSvcsJPh8d9td0bPkGlII, reason: not valid java name */
    public static /* synthetic */ void m525$r8$lambda$nRjr2BSvcsJPh8d9td0bPkGlII(LockNotificationFragment r0, Companion.KeyguardNotificationTheme r1, View r2) {
        genKeyguardNotificationThemeClickListener$lambda$2(r0, r1, r2);
    }

    static {
        Companion = new Companion(null);
    }

    public void com_android_settings_notification_LockNotificationFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_notification_LockNotificationFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_notification_LockNotificationFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public LockNotificationFragment() {
    }

    public static final /* synthetic */ boolean access$checkKeyGuardQuality(LockNotificationFragment r0) {
        return r0.checkKeyGuardQuality();
    }

    public static final /* synthetic */ OAlertDialog access$getMHideNotificationAlertDialog$p(LockNotificationFragment r0) {
        return r0.mHideNotificationAlertDialog;
    }

    public static final /* synthetic */ OPopover access$getMPopMenu$p(LockNotificationFragment r0) {
        return r0.mPopMenu;
    }

    public static final /* synthetic */ LockNotificationLayoutBinding access$getViewBinding$p(LockNotificationFragment r0) {
        return r0.viewBinding;
    }

    public static final /* synthetic */ void access$setMPopMenu$p(LockNotificationFragment r0, OPopover r1) {
        r0.mPopMenu = r1;
    }

    public static final /* synthetic */ void access$showHideNotificationAlertDialog(LockNotificationFragment r0) {
        r0.showHideNotificationAlertDialog();
    }

    public static final /* synthetic */ void access$updateLockScreenNotificationMode(LockNotificationFragment r0, int r1) {
        r0.updateLockScreenNotificationMode(r1);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        LockNotificationLayoutBinding r4 = LockNotificationLayoutBinding.inflate(r1, r2, false);
        Intrinsics.checkNotNullExpressionValue(r4, "inflate(...)");
        this.viewBinding = r4;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r4 = null;
    L5:
        RelativeLayout r0 = r4.getRoot();
        Intrinsics.checkNotNullExpressionValue(r0, "getRoot(...)");
        return r0;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super.onViewCreated(r3, r4);
        initDozeEnableSwitch();
        initKeepLockScreenNotificationSwitch();
        initLockScreenNotification();
        LockNotificationLayoutBinding r5 = this.viewBinding;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r5 = null;
    L5:
        r5.listCheckbox.setClickable(false);
        r5.countCheckbox.setClickable(false);
        r5.listTheme.setOnClickListener(genKeyguardNotificationThemeClickListener(Companion.KeyguardNotificationTheme.List.INSTANCE));
        r5.countTheme.setOnClickListener(genKeyguardNotificationThemeClickListener(Companion.KeyguardNotificationTheme.Count.INSTANCE));
        r5.listTheme.setChangeAlphaWhenPress(false);
        r5.countTheme.setChangeAlphaWhenPress(false);
        r5.aiSpaceExpandedCheckbox.setClickable(false);
        r5.notificationExpandedCheckbox.setClickable(false);
        r5.aiSpaceExpandedDisplay.setOnClickListener(genAiSpaceNotificationExpandClickListener(0));
        r5.notificationExpandedDisplay.setOnClickListener(genAiSpaceNotificationExpandClickListener(1));
        r5.aiSpaceExpandedDisplay.setChangeAlphaWhenPress(false);
        r5.notificationExpandedDisplay.setChangeAlphaWhenPress(false);
        updateDozeEnableSwitch();
        updateKeepLockScreenNotificationSwitch();
        updateLockScreenNotificationStatus();
        updateKeyguardRoller();
        updateAiSpaceNotificationExpandMode();
    }

    public void com_android_settings_notification_LockNotificationFragment__onResume$___twin___() {
        super.onResume();
        updateDozeEnableSwitch();
        updateKeepLockScreenNotificationSwitch();
        updateLockScreenNotificationStatus();
        updateKeyguardRoller();
        updateAiSpaceNotificationExpandMode();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        OPopover r0 = this.mPopMenu;
        if (r0 == null) goto L5;
        r0.dismiss();
    L5:
        this.mPopMenu = null;
    }

    private final void updateKeyguardRoller() {
        boolean r2 = false;
        if (Settings.System.getInt(this.mContext.getContentResolver(), KEYGUARD_ROLLER, 0) != 0) goto L5;
        r2 = true;
    L5:
        LockNotificationLayoutBinding r3 = this.viewBinding;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r3 = null;
    L8:
        r3.listCheckbox.setChecked(r2);
        r3.countCheckbox.setChecked(!r2);
    }

    private final View.OnClickListener genKeyguardNotificationThemeClickListener(final Companion.KeyguardNotificationTheme r2) {
        return new LockNotificationFragment$$ExternalSyntheticLambda3(this, r2);
    }

    private static final void genKeyguardNotificationThemeClickListener$lambda$2(LockNotificationFragment r0, Companion.KeyguardNotificationTheme r1, View r2) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        Intrinsics.checkNotNullParameter(r1, "$type");
        r0.onKeyguardNotificationThemeChanged(r1);
    }

    private final void onKeyguardNotificationThemeChanged(Companion.KeyguardNotificationTheme r3) {
        boolean r4 = Intrinsics.areEqual(r3, Companion.KeyguardNotificationTheme.List.INSTANCE);
        Settings.System.putInt(this.mContext.getContentResolver(), KEYGUARD_ROLLER, !r4 ? 1 : 0);
        updateKeyguardRoller();
    }

    private final void updateAiSpaceNotificationExpandMode() {
        if (getAiSpaceNotificationExpandMode() != 0) goto L5;
        boolean r0 = true;
    L6:
        LockNotificationLayoutBinding r3 = this.viewBinding;
        if (r3 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r3 = null;
    L9:
        r3.aiSpaceExpandedCheckbox.setChecked(r0);
        r3.notificationExpandedCheckbox.setChecked(!r0);
        return;
    L5:
        r0 = false;
        goto L6
    }

    private final View.OnClickListener genAiSpaceNotificationExpandClickListener(final int r2) {
        return new LockNotificationFragment$$ExternalSyntheticLambda0(this, r2);
    }

    private static final void genAiSpaceNotificationExpandClickListener$lambda$4(LockNotificationFragment r0, int r1, View r2) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.onAiSpaceNotificationExpandModeChanged(r1);
    }

    private final void onAiSpaceNotificationExpandModeChanged(int r3) {
        if (getAiSpaceNotificationExpandMode() != r3) goto L5;
        return;
    L5:
        Settings.System.putInt(this.mContext.getContentResolver(), KEY_AI_SPACE_NOTIFICATION_EXPAND_MODE, r3);
        updateAiSpaceNotificationExpandMode();
    }

    private final int getAiSpaceNotificationExpandMode() {
        if (Settings.System.getInt(this.mContext.getContentResolver(), KEY_AI_SPACE_NOTIFICATION_EXPAND_MODE, 0) == 1) goto L5;
        return 0;
    L5:
        return 1;
    }

    private final void initDozeEnableSwitch() {
        LockNotificationLayoutBinding r0 = this.viewBinding;
        OSwitch r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r0 = null;
    L5:
        View r1 = OCardListItemUtils.getContentView(r0.dozeEnableSwitch);
        if (r1 == null) goto L9;
        r1.setClickable(false);
    L9:
        LockNotificationLayoutBinding r3 = this.viewBinding;
        if (r3 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r3 = null;
    L12:
        View r4 = r3.dozeEnableSwitch.getCustomEndView();
        if ((r4 instanceof OSwitch) == false) goto L15;
        r2 = (OSwitch) r4;
    L15:
        if (r2 == null) goto L18;
        r2.setChecked(getDozeEnableState());
        r2.setOnCheckedChangeListener(new LockNotificationFragment$$ExternalSyntheticLambda4(this));
        return;
    }

    private static final void initDozeEnableSwitch$lambda$6$lambda$5(LockNotificationFragment r1, CompoundButton r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "<anonymous parameter 0>");
        r1.setDozeEnableState(r3);
    }

    private final void initKeepLockScreenNotificationSwitch() {
        LockNotificationLayoutBinding r0 = this.viewBinding;
        OSwitch r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r0 = null;
    L5:
        View r1 = OCardListItemUtils.getContentView(r0.keepLockScreenNotificationSwitch);
        if (r1 == null) goto L9;
        r1.setClickable(false);
    L9:
        LockNotificationLayoutBinding r3 = this.viewBinding;
        if (r3 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r3 = null;
    L12:
        View r4 = r3.keepLockScreenNotificationSwitch.getCustomEndView();
        if ((r4 instanceof OSwitch) == false) goto L15;
        r2 = (OSwitch) r4;
    L15:
        if (r2 == null) goto L18;
        r2.setChecked(getKeepLockScreenNotificationState());
        r2.setOnCheckedChangeListener(new LockNotificationFragment$$ExternalSyntheticLambda2(this));
        return;
    }

    private static final void initKeepLockScreenNotificationSwitch$lambda$8$lambda$7(LockNotificationFragment r1, CompoundButton r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "<anonymous parameter 0>");
        r1.setKeepLockScreenNotificationState(r3);
    }

    private final void initLockScreenNotification() {
        LockNotificationLayoutBinding r0 = this.viewBinding;
        LockNotificationLayoutBinding r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r0 = null;
    L5:
        OCardListItemUtils.setCustomEndTipTextView(r0.lockScreenNotification, ResourceUtils.getString(SystemNotificationShowDetailFragment.getSummaryResource(this.mContext)));
        LockNotificationLayoutBinding r2 = this.viewBinding;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L9:
        r1.lockScreenNotification.setOnContentClickListener(new LockNotificationFragment$$ExternalSyntheticLambda1(this));
        return;
    L8:
        r1 = r2;
        goto L9
    }

    private static final void initLockScreenNotification$lambda$9(LockNotificationFragment r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.showLockScreenNotificationPopMenu();
    }

    private final void updateLockScreenNotificationStatus() {
        LockNotificationLayoutBinding r0 = this.viewBinding;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r0 = null;
    L5:
        OCardListItemUtils.setCustomEndTipTextView(r0.lockScreenNotification, ResourceUtils.getString(SystemNotificationShowDetailFragment.getSummaryResource(this.mContext)));
    }

    private final void showLockScreenNotificationPopMenu() {
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L6;
        OLog.e(this.TAG, "showLockScreenNotificationPopMenu activity is null, return");
        return;
    L6:
        ArrayList r1 = new ArrayList();
        final int r2 = getLockScreenNotificationMode();
        final String[] r4 = {getString(R.string.lock_screen_notifications_summary_show), getString(R.string.lock_screen_notifications_summary_hide), getString(R.string.lock_screen_notifications_summary_disable)};
        int r5 = 0;
    L7:
        if (r5 >= 3) goto L13;
        String r9 = r4[r5];
        Intrinsics.checkNotNullExpressionValue(r9, "get(...)");
        if (r2 != r5) goto L11;
        boolean r10 = true;
    L12:
        r1.add(new Item(r9, r10, null, 4, null));
        r5 = r5 + 1;
        goto L7
    L11:
        r10 = false;
        goto L12
    L13:
        FragmentActivity r3 = r0;
        LockNotificationLayoutBinding r6 = this.viewBinding;
        if (r6 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r6 = null;
    L16:
        this.mPopMenu = OPopoverHelper.showPopoverList(r3, r6.lockScreenNotification, r1, new C01501(r2, this, r4), true);
    }

    private final void showHideNotificationAlertDialog() {
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L7;
        OLog.e(this.TAG, "showHideNotificationAlertDialog activity is null, return");
        return;
    L7:
        if (this.mHideNotificationAlertDialog != null) goto L9;
        this.mHideNotificationAlertDialog = OAlertDialogBuilder.horizontalButton$default(new OAlertDialogBuilder(r0), false, 1, null).title(android.R.string.dialog_alert_title).message(R.string.system_notification_lock_screen_hint).positiveButton(R.string.dialog_positive_button_setup, new AnonymousClass1(this)).negativeButton(android.R.string.cancel, new AnonymousClass2(this)).build();
    L9:
        OAlertDialog r4 = this.mHideNotificationAlertDialog;
        if (r4 == null) goto L13;
        r4.show();
        return;
    }

    private final boolean checkKeyGuardQuality() {
        int r0 = UserManager.get(getActivity()).getCredentialOwnerProfile(UserHandle.myUserId());
        if (new LockPatternUtils(getActivity()).getActivePasswordQuality(r0) < 65536) goto L5;
        return true;
    L5:
        return false;
    }

    private final int getLockScreenNotificationMode() {
        if (Settings.Secure.getInt(this.mContext.getContentResolver(), "lock_screen_show_notifications", 0) == 0) goto L5;
        boolean r0 = true;
    L7:
        if (new LockPatternUtils(this.mContext).isSecure(UserHandle.myUserId()) == true) goto L9;
    L12:
        boolean r5 = true;
    L13:
        if (r0 == true) goto L15;
        return 2;
    L15:
        if (r5 == false) goto L18;
        return 0;
    L18:
        return 1;
    L9:
        if (Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "lock_screen_allow_private_notifications", 0, UserHandle.myUserId()) != 0) goto L12;
        r5 = false;
        goto L13
    L5:
        r0 = false;
        goto L7
    }

    private final void updateLockScreenNotificationMode(int r4) {
        int r1 = 1;
        if (r4 == 2) goto L5;
        int r0 = 1;
    L6:
        if (r4 == 0) goto L9;
        r1 = 0;
    L9:
        Settings.Secure.putInt(this.mContext.getContentResolver(), "lock_screen_allow_private_notifications", r1);
        Settings.Secure.putInt(this.mContext.getContentResolver(), "lock_screen_show_notifications", r0);
        return;
    L5:
        r0 = 0;
        goto L6
    }

    private final void updateDozeEnableSwitch() {
        LockNotificationLayoutBinding r0 = this.viewBinding;
        OSwitch r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r0 = null;
    L5:
        View r2 = r0.dozeEnableSwitch.getCustomEndView();
        if ((r2 instanceof OSwitch) == false) goto L8;
        r1 = (OSwitch) r2;
    L8:
        if (r1 == null) goto L12;
        r1.setChecked(getDozeEnableState());
        return;
    }

    private final void updateKeepLockScreenNotificationSwitch() {
        LockNotificationLayoutBinding r0 = this.viewBinding;
        OSwitch r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r0 = null;
    L5:
        View r2 = r0.keepLockScreenNotificationSwitch.getCustomEndView();
        if ((r2 instanceof OSwitch) == false) goto L8;
        r1 = (OSwitch) r2;
    L8:
        if (r1 == null) goto L12;
        r1.setChecked(getKeepLockScreenNotificationState());
        return;
    }

    private final boolean getDozeEnableState() {
        if (Settings.Secure.getInt(this.mContext.getContentResolver(), "doze_enabled", 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private final void setDozeEnableState(boolean r2) {
        Settings.Secure.putInt(this.mContext.getContentResolver(), "doze_enabled", r2 ? 1 : 0);
        TrackerEvent.switchEvent("doze_enabled", r2);
    }

    private final boolean getKeepLockScreenNotificationState() {
        if (Settings.System.getInt(this.mContext.getContentResolver(), KEY_KEEP_LOCK_SCREEN_NOTIFICATION, 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    private final void setKeepLockScreenNotificationState(boolean r2) {
        Settings.System.putInt(this.mContext.getContentResolver(), KEY_KEEP_LOCK_SCREEN_NOTIFICATION, r2 ? 1 : 0);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_notification_LockNotificationFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(LockNotificationFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_notification_LockNotificationFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        com.obric.olog.OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_notification_LockNotificationFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(LockNotificationFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_notification_LockNotificationFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        com.obric.olog.OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_notification_LockNotificationFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(LockNotificationFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_notification_LockNotificationFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        com.obric.olog.OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
