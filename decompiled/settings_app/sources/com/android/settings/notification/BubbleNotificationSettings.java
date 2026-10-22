package com.android.settings.notification;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import com.GlobalProxyLancet;
import com.android.settings.NotificationDetailsFragment;
import com.android.settings.R;
import com.android.settings.applications.utils.OCardListItemUtils;
import com.android.settings.base.BaseFragment;
import com.android.settings.search.IndexDatabaseHelper;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settingslib.drawer.EntriesProvider;
import com.obric.olog.OLog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.privacy.GrantUtil;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: compiled from: BubbleNotificationSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u001c\u0010'\u001a\u0004\u0018\u00010\u001a2\b\u0010(\u001a\u0004\u0018\u00010\u00182\u0006\u0010)\u001a\u00020%H\u0002J\b\u0010*\u001a\u00020%H\u0002J\b\u0010+\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020.H\u0002J\b\u0010/\u001a\u00020,H\u0002J\u0018\u00100\u001a\u00020,2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020.H\u0016J\u0012\u00104\u001a\u00020,2\b\u00105\u001a\u0004\u0018\u000106H\u0016J$\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<2\b\u00105\u001a\u0004\u0018\u000106H\u0016J\b\u0010=\u001a\u00020,H\u0016J\u0012\u0010>\u001a\u00020,2\b\u00105\u001a\u0004\u0018\u000106H\u0016J\u0010\u0010?\u001a\u00020,2\u0006\u0010@\u001a\u00020%H\u0002J\u0010\u0010A\u001a\u00020,2\u0006\u0010B\u001a\u00020.H\u0002J\u0010\u0010C\u001a\u00020,2\u0006\u0010@\u001a\u00020%H\u0002J\b\u0010D\u001a\u00020,H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001b\u0010\u001f\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0016\u001a\u0004\b!\u0010\"R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Lcom/android/settings/notification/BubbleNotificationSettings;", "Lcom/android/settings/base/BaseFragment;", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "()V", "bubbleItem", "Lcom/obric/oui/lisitem/OCardListItem;", "itemAppBubble", "Landroid/widget/LinearLayout;", "itemCheckAll", "itemCheckNone", "itemCheckSelected", "mAppRow", "Lcom/android/settings/notification/NotificationBackend$AppRow;", "mBackend", "Lcom/android/settings/notification/NotificationBackend;", "mIntent", "Landroid/content/Intent;", "mNm", "Landroid/app/NotificationManager;", "getMNm", "()Landroid/app/NotificationManager;", "mNm$delegate", "Lkotlin/Lazy;", "mPkg", "", "mPkgInfo", "Landroid/content/pm/PackageInfo;", "getMPkgInfo", "()Landroid/content/pm/PackageInfo;", "setMPkgInfo", "(Landroid/content/pm/PackageInfo;)V", "mPm", "Landroid/content/pm/PackageManager;", "getMPm", "()Landroid/content/pm/PackageManager;", "mPm$delegate", "mUid", "", "mUserId", "findPackageInfo", "pkg", "uid", "getAppCheckPreference", "initDataFromIntent", "", "isBubblesEnabled", "", "loadAppRow", EntriesProvider.METHOD_ON_CHECKED_CHANGED, "buttonView", "Landroid/widget/CompoundButton;", EntriesProvider.METHOD_IS_CHECKED, "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onResume", "onViewStateRestored", "setAppBubbleCheck", "preference", "setBubblesEnabled", IndexDatabaseHelper.IndexColumns.ENABLED, "updateAppCheck", "updateBubbleSwitch", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class BubbleNotificationSettings extends BaseFragment implements CompoundButton.OnCheckedChangeListener {
    private OCardListItem bubbleItem;
    private LinearLayout itemAppBubble;
    private OCardListItem itemCheckAll;
    private OCardListItem itemCheckNone;
    private OCardListItem itemCheckSelected;
    private NotificationBackend.AppRow mAppRow;
    private final NotificationBackend mBackend;
    private Intent mIntent;
    private final Lazy mNm$delegate;
    private String mPkg;
    private PackageInfo mPkgInfo;
    private final Lazy mPm$delegate;
    private int mUid;
    private int mUserId;

    public static /* synthetic */ void $r8$lambda$LGhjGAoEDXAe3VvNgWY0NEoog4k(BubbleNotificationSettings r0, View r1) {
        onCreateView$lambda$0(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$TEGq0MyIH0sV7YVXso-oDZeGnzI, reason: not valid java name */
    public static /* synthetic */ void m519$r8$lambda$TEGq0MyIH0sV7YVXsooDZeGnzI(BubbleNotificationSettings r0, View r1) {
        onCreateView$lambda$1(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$UGfRrwau5oPMRGfOg9tEI3MR9Yw(BubbleNotificationSettings r0, View r1) {
        onCreateView$lambda$2(r0, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_notification_BubbleNotificationSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_notification_BubbleNotificationSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public BubbleNotificationSettings() {
        this.mPm$delegate = LazyKt.lazy(new BubbleNotificationSettings$mPm$2(this));
        this.mBackend = new NotificationBackend();
        this.mNm$delegate = LazyKt.lazy(new BubbleNotificationSettings$mNm$2(this));
        this.mUid = -1;
        this.mUserId = -1;
    }

    public static final /* synthetic */ NotificationBackend access$getMBackend$p(BubbleNotificationSettings r0) {
        return r0.mBackend;
    }

    public static final /* synthetic */ void access$setBubblesEnabled(BubbleNotificationSettings r0, boolean r1) {
        r0.setBubblesEnabled(r1);
    }

    public static final /* synthetic */ void access$updateAppCheck(BubbleNotificationSettings r0, int r1) {
        r0.updateAppCheck(r1);
    }

    private final PackageManager getMPm() {
        Object r1 = this.mPm$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(r1, "getValue(...)");
        return (PackageManager) r1;
    }

    private final NotificationManager getMNm() {
        Object r1 = this.mNm$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(r1, "getValue(...)");
        return (NotificationManager) r1;
    }

    protected final PackageInfo getMPkgInfo() {
        return this.mPkgInfo;
    }

    protected final void setMPkgInfo(PackageInfo r1) {
        this.mPkgInfo = r1;
    }

    public void com_android_settings_notification_BubbleNotificationSettings__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
        initDataFromIntent();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        this.mRootView = r2.inflate(R.layout.fragment_bubble, r3, false);
        this.bubbleItem = (OCardListItem) findViewByIdNullable(R.id.item_bubble);
        this.itemAppBubble = (LinearLayout) findViewByIdNullable(R.id.item_app_bubble);
        this.itemCheckAll = (OCardListItem) findViewByIdNullable(R.id.item_check_all);
        this.itemCheckSelected = (OCardListItem) findViewByIdNullable(R.id.item_check_selected);
        this.itemCheckNone = (OCardListItem) findViewByIdNullable(R.id.item_check_none);
        OCardListItem r5 = this.itemCheckAll;
        if (r5 == null) goto L5;
        r5.setOnContentClickListener(new BubbleNotificationSettings$$ExternalSyntheticLambda0(this));
    L5:
        OCardListItem r6 = this.itemCheckSelected;
        if (r6 == null) goto L8;
        r6.setOnContentClickListener(new BubbleNotificationSettings$$ExternalSyntheticLambda1(this));
    L8:
        OCardListItem r7 = this.itemCheckNone;
        if (r7 == null) goto L12;
        r7.setOnContentClickListener(new BubbleNotificationSettings$$ExternalSyntheticLambda2(this));
    L12:
        if (this.mPkgInfo == null) goto L22;
        LinearLayout r8 = this.itemAppBubble;
        if (r8 == null) goto L17;
        r8.setVisibility(0);
    L17:
        OCardListItem r9 = this.bubbleItem;
        if (r9 == null) goto L21;
        r9.setVisibility(8);
    L21:
        updateAppCheck(getAppCheckPreference());
    L30:
        View r1 = this.mRootView;
        Intrinsics.checkNotNull(r1);
        return r1;
    L22:
        LinearLayout r10 = this.itemAppBubble;
        if (r10 == null) goto L26;
        r10.setVisibility(8);
    L26:
        OCardListItem r11 = this.bubbleItem;
        if (r11 == null) goto L30;
        r11.setVisibility(0);
        goto L30
    }

    private static final void onCreateView$lambda$0(BubbleNotificationSettings r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.setAppBubbleCheck(1);
        r0.updateAppCheck(1);
    }

    private static final void onCreateView$lambda$1(BubbleNotificationSettings r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.setAppBubbleCheck(2);
        r0.updateAppCheck(2);
    }

    private static final void onCreateView$lambda$2(BubbleNotificationSettings r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.setAppBubbleCheck(0);
        r0.updateAppCheck(0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateBubbleSwitch();
    }

    public void com_android_settings_notification_BubbleNotificationSettings__onResume$___twin___() {
        super.onResume();
        updateBubbleSwitch();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "buttonView");
        setBubblesEnabled(r3);
    }

    private final void updateBubbleSwitch() {
        OCardListItem r0 = this.bubbleItem;
        if (r0 != null) goto L5;
        return;
    L5:
        OSwitch r1 = OCardListItemUtils.getSwitchView(r0);
        if (r1 != null) goto L8;
        return;
    L8:
        r1.setOnCheckedChangeListener(null);
        r1.setChecked(isBubblesEnabled());
        r1.setOnCheckedChangeListener(this);
    }

    private final boolean isBubblesEnabled() {
        if (Settings.Secure.getInt(this.mContext.getContentResolver(), "notification_bubbles", 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private final void setBubblesEnabled(boolean r2) {
        Settings.Secure.putInt(this.mContext.getContentResolver(), "notification_bubbles", r2 ? 1 : 0);
    }

    private final void updateAppCheck(int r3) {
        OCardListItem r0 = this.itemCheckAll;
        if (r0 == null) goto L5;
        r0.showCustomEnd(false);
    L5:
        OCardListItem r1 = this.itemCheckSelected;
        if (r1 == null) goto L8;
        r1.showCustomEnd(false);
    L8:
        OCardListItem r2 = this.itemCheckNone;
        if (r2 == null) goto L12;
        r2.showCustomEnd(false);
    L12:
        if (r3 == 0) goto L28;
        if (r3 == 1) goto L22;
        if (r3 != 2) goto L40;
        OCardListItem r4 = this.itemCheckSelected;
        if (r4 == null) goto L19;
        r4.setDefaultCustomEndView(2);
    L19:
        OCardListItem r5 = this.itemCheckSelected;
        if (r5 == null) goto L35;
        r5.showCustomEnd(true);
        return;
    L35:
        return;
    L40:
        return;
    L22:
        OCardListItem r6 = this.itemCheckAll;
        if (r6 == null) goto L25;
        r6.setDefaultCustomEndView(2);
    L25:
        OCardListItem r7 = this.itemCheckAll;
        if (r7 == null) goto L37;
        r7.showCustomEnd(true);
        return;
    L37:
        return;
    L28:
        OCardListItem r8 = this.itemCheckNone;
        if (r8 == null) goto L31;
        r8.setDefaultCustomEndView(2);
    L31:
        OCardListItem r9 = this.itemCheckNone;
        if (r9 == null) goto L39;
        r9.showCustomEnd(true);
        return;
    }

    private final int getAppCheckPreference() {
        if (isBubblesEnabled() == true) goto L5;
        return 0;
    L5:
        NotificationBackend.AppRow r2 = this.mAppRow;
        if (r2 != null) goto L8;
        return 0;
    L8:
        return r2.bubblePreference;
    }

    private final void setAppBubbleCheck(final int r5) {
        final NotificationBackend.AppRow r0 = this.mAppRow;
        if (r0 != null) goto L6;
        return;
    L6:
        if (getAppCheckPreference() != r5) goto L9;
        return;
    L9:
        if (isBubblesEnabled() == false) goto L11;
    L14:
        r0.bubblePreference = r5;
        this.mBackend.setAllowBubbles(r0.pkg, r0.uid, r5);
        return;
    L11:
        if (getAppCheckPreference() != 0) goto L14;
        FragmentActivity r2 = requireActivity();
        Intrinsics.checkNotNullExpressionValue(r2, "requireActivity(...)");
        new OAlertDialogBuilder(r2).title(R.string.bubbles_feature_disabled_dialog_title).message(R.string.bubbles_feature_disabled_dialog_text).positiveButton(R.string.bubbles_feature_disabled_button_approve, new AnonymousClass1(this, r0, r5)).negativeButton(R.string.bubbles_feature_disabled_button_cancel, new AnonymousClass2(this)).show();
    }

    private final void initDataFromIntent() {
        Activity r0 = this._mActivity;
        String r1 = null;
        if (r0 == null) goto L5;
        Intent r2 = r0.getIntent();
    L6:
        this.mIntent = r2;
        if (r2 == null) goto L9;
        r1 = r2.getStringExtra(NotificationDetailsFragment.ANDROID_PROVIDER_EXTRA_APP_PACKAGE);
    L9:
        this.mPkg = r1;
        Intent r3 = this.mIntent;
        int r4 = -1;
        if (r3 == null) goto L12;
        r4 = r3.getIntExtra("app_uid", -1);
    L12:
        this.mUid = r4;
        if (r4 >= 0) goto L23;
        String r5 = this.mPkg;
        if (r5 != null) goto L17;
    L20:
        boolean r6 = true;
    L21:
        if (r6 == true) goto L23;
        PackageManager r7 = getMPm();     // Catch: PackageManager.NameNotFoundException -> L27
        String r8 = this.mPkg;     // Catch: PackageManager.NameNotFoundException -> L27
        Intrinsics.checkNotNull(r8);     // Catch: PackageManager.NameNotFoundException -> L27
        this.mUid = r7.getPackageUid(r8, 0);     // Catch: PackageManager.NameNotFoundException -> L27
        goto L23
    L17:
        if (r5.length() == 0) goto L20;
        r6 = false;
    L23:
        PackageInfo r9 = findPackageInfo(this.mPkg, this.mUid);
        this.mPkgInfo = r9;
        if (r9 == null) goto L30;
        loadAppRow();
        return;
    L30:
        return;
    L5:
        r2 = null;
        goto L6
    }

    private final void loadAppRow() {
        this.mAppRow = this.mBackend.loadAppRow(this.mContext, getMPm(), this.mPkgInfo);
    }

    private final PackageInfo findPackageInfo(String r6, int r7) {
        if (r6 == null) goto L19;
        if (r7 < 0) goto L19;
        PackageManager r1 = this.mContext.getPackageManager();
        String[] r8 = r1.getPackagesForUid(r7);
        if (r8 == null) goto L19;
        int r2 = r8.length;
        int r3 = 0;
    L9:
        if (r3 >= r2) goto L19;
        if (Intrinsics.areEqual(r6, r8[r3]) == true) goto L20;
        r3 = r3 + 1;
        goto L9
    L20:
        return r1.getPackageInfo(r6, 4160);
    L15:
        e = move-exception;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(this.TAG, "Failed to load package " + r6, e);
        return null;
    L19:
        return null;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_notification_BubbleNotificationSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(BubbleNotificationSettings r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_notification_BubbleNotificationSettings__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_notification_BubbleNotificationSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(BubbleNotificationSettings r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_notification_BubbleNotificationSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_notification_BubbleNotificationSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(BubbleNotificationSettings r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_notification_BubbleNotificationSettings__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
