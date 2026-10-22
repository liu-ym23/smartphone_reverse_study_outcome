package com.android.settings.notification;

import android.app.NotificationChannel;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import androidx.core.view.ViewGroupKt;
import bytedanceos.api.NotificationChannelSmt;
import com.android.settings.NotificationDetailsFragment;
import com.android.settings.PageConstants;
import com.android.settings.R;
import com.android.settings.applications.utils.OCardListItemUtils;
import com.android.settings.intelligent.DoubaoAssistantEnabler;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settingslib.drawer.EntriesProvider;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.oui.dialog.base.OBaseDialog;
import com.obric.oui.dialog.v2.selection.OSelectionDialog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.privacy.GrantUtil;
import com.obric.privacy.LifeHookActivity;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: compiled from: ChannelNotificationDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \"2\u00020\u00012\u00020\u0002:\u0001\"B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0012\u0010\u001e\u001a\u00020\u00192\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\u000e\u0010!\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/android/settings/notification/ChannelNotificationDialog;", "Lcom/obric/privacy/LifeHookActivity;", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "()V", "dialog", "Lcom/obric/oui/dialog/v2/selection/OSelectionDialog;", "mBackend", "Lcom/android/settings/notification/NotificationBackend;", "mChannel", "Landroid/app/NotificationChannel;", "mFloatingSwitch", "Lcom/obric/oui/lisitem/OCardListItem;", "mPkg", "", "mRingtoneSwitch", "mUid", "", "mVibrateSwitch", "getBodyView", "Landroid/view/View;", "intent", "Landroid/content/Intent;", "parent", "Landroid/view/ViewGroup;", EntriesProvider.METHOD_ON_CHECKED_CHANGED, "", "buttonView", "Landroid/widget/CompoundButton;", EntriesProvider.METHOD_IS_CHECKED, "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", DoubaoAssistantEnabler.METHOD_SHOW_ENABLE_DIALOG, "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ChannelNotificationDialog extends LifeHookActivity implements CompoundButton.OnCheckedChangeListener {
    public static final Companion Companion = null;
    private static final String TAG = "ChannelNotificationDialog";
    private OSelectionDialog dialog;
    private final NotificationBackend mBackend;
    private NotificationChannel mChannel;
    private OCardListItem mFloatingSwitch;
    private String mPkg;
    private OCardListItem mRingtoneSwitch;
    private int mUid;
    private OCardListItem mVibrateSwitch;

    /* JADX INFO: compiled from: ChannelNotificationDialog.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/android/settings/notification/ChannelNotificationDialog$Companion;", "", "()V", "TAG", "", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    public static /* synthetic */ void $r8$lambda$OTflIC6BXQlRmroeu1iS0otTN7Y(ChannelNotificationDialog r0, DialogInterface r1) {
        showDialog$lambda$0(r0, r1);
    }

    static {
        Companion = new Companion(null);
    }

    public void com_android_settings_notification_ChannelNotificationDialog__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_notification_ChannelNotificationDialog__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_notification_ChannelNotificationDialog__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_notification_ChannelNotificationDialog__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_notification_ChannelNotificationDialog_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_notification_ChannelNotificationDialog_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_notification_ChannelNotificationDialog_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_notification_ChannelNotificationDialog_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_notification_ChannelNotificationDialog_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public ChannelNotificationDialog() {
        this.mBackend = new NotificationBackend();
        this.mUid = -1;
    }

    public static final /* synthetic */ View access$getBodyView(ChannelNotificationDialog r0, Intent r1, ViewGroup r2) {
        return r0.getBodyView(r1, r2);
    }

    public static final /* synthetic */ OSelectionDialog access$getDialog$p(ChannelNotificationDialog r0) {
        return r0.dialog;
    }

    public void com_android_settings_notification_ChannelNotificationDialog__onCreate$___twin___(Bundle r5) {
        super.onCreate(r5);
        String r6 = getIntent().getStringExtra(NotificationDetailsFragment.ANDROID_PROVIDER_EXTRA_APP_PACKAGE);
        if (r6 != null) goto L6;
        finish();
        return;
    L6:
        this.mPkg = r6;
        int r7 = getPackageManager().getPackageUid(r6, 0);
        this.mUid = r7;
        if (r7 >= 0) goto L10;
        finish();
        return;
    L10:
        String r8 = getIntent().getStringExtra("android.provider.extra.CHANNEL_ID");
        NotificationBackend r0 = this.mBackend;
        String r1 = this.mPkg;
        if (r1 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mPkg");
        r1 = null;
    L13:
        NotificationChannel r9 = r0.getChannel(r1, this.mUid, r8, null);
        Intrinsics.checkNotNullExpressionValue(r9, "getChannel(...)");
        this.mChannel = r9;
        Intent r10 = getIntent();
        Intrinsics.checkNotNullExpressionValue(r10, "getIntent(...)");
        showDialog(r10);
    }

    public final void showDialog(final Intent r23) {
        Intrinsics.checkNotNullParameter(r23, "intent");
        NotificationChannel r3 = this.mChannel;
        OSelectionDialog r9 = null;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mChannel");
        r3 = null;
    L5:
        Function1<ViewGroup, View> r6 = new ChannelNotificationDialog$showDialog$modifier$1(this, r23);
        String r11 = getString(R.string.btn_done);
        Intrinsics.checkNotNullExpressionValue(r11, "getString(...)");
        OBaseDialog.ButtonConfig r7 = new OBaseDialog.ButtonConfig(r11, new ChannelNotificationDialog$showDialog$modifier$2(this), null, 4, null);
        String r10 = getString(R.string.more_btn);
        Intrinsics.checkNotNullExpressionValue(r10, "getString(...)");
        OSelectionDialog r1 = new OSelectionDialog(this, new OSelectionDialog.Modifier(String.valueOf(r3.getName()), "", r6, r7, new OBaseDialog.ButtonConfig(r10, new ChannelNotificationDialog$showDialog$modifier$3(this, r23), null, 4, null)));
        this.dialog = r1;
        r1.setOnDismissListener(new ChannelNotificationDialog$$ExternalSyntheticLambda0(this));
        OSelectionDialog r0 = this.dialog;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("dialog");
    L9:
        r9.show();
        return;
    L8:
        r9 = r0;
        goto L9
    }

    private static final void showDialog$lambda$0(ChannelNotificationDialog r0, DialogInterface r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.finish();
    }

    private final View getBodyView(Intent r10, ViewGroup r11) {
        boolean r2 = false;
        View r12 = LayoutInflater.from(this).inflate(R.layout.dialog_panel_channel_notification, r11, false);
        View r0 = r12.findViewById(R.id.items);
        Intrinsics.checkNotNullExpressionValue(r0, "findViewById(...)");
        LinearLayout r1 = (LinearLayout) r0;
        ArrayList<String> r13 = r10.getStringArrayListExtra("android.provider.extra.CHANNEL_FILTER_LIST");
        if (r13 == null) goto L8;
        Iterator<T> r3 = r13.iterator();
    L6:
        if (r3.hasNext() == false) goto L8;
        OLog.d(TAG, "filter:" + ((String) r3.next()));
    L8:
        View r4 = r12.findViewById(R.id.high_importance);
        Intrinsics.checkNotNullExpressionValue(r4, "findViewById(...)");
        this.mFloatingSwitch = (OCardListItem) r4;
        View r5 = r12.findViewById(R.id.switch_notification_ringtone);
        Intrinsics.checkNotNullExpressionValue(r5, "findViewById(...)");
        this.mRingtoneSwitch = (OCardListItem) r5;
        View r6 = r12.findViewById(R.id.switch_notification_vibrate);
        Intrinsics.checkNotNullExpressionValue(r6, "findViewById(...)");
        this.mVibrateSwitch = (OCardListItem) r6;
        Iterator<View> r7 = ViewGroupKt.getChildren(r1).iterator();
    L9:
        NotificationChannel r8 = null;
        if (r7.hasNext() == false) goto L14;
        View r9 = r7.next();
        if ((r9 instanceof OCardListItem) == false) goto L9;
        OCardListItem r14 = (OCardListItem) r9;
        OCardListItemUtils.setOnCheckedChangeListener(r14, this);
        OCardListItem.setCardPosition$default(r14, 2, false, 2, null);
        r14.setShowCardBg(false);
        goto L9
    L14:
        OCardListItem r15 = this.mFloatingSwitch;
        if (r15 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mFloatingSwitch");
        r15 = null;
    L18:
        if (r13 != null) goto L20;
    L22:
        boolean r16 = false;
    L23:
        int r17 = 8;
        if (r16 == false) goto L26;
        int r18 = 0;
    L27:
        r15.setVisibility(r18);
        OCardListItem r19 = this.mVibrateSwitch;
        if (r19 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mVibrateSwitch");
        r19 = null;
    L30:
        if (r13 != null) goto L32;
    L34:
        boolean r20 = false;
    L35:
        if (r20 == false) goto L37;
        int r21 = 0;
    L38:
        r19.setVisibility(r21);
        OCardListItem r22 = this.mRingtoneSwitch;
        if (r22 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("mRingtoneSwitch");
        r22 = null;
    L41:
        if (r13 != null) goto L43;
    L45:
        boolean r110 = false;
    L46:
        if (r110 == false) goto L48;
        r17 = 0;
    L48:
        r22.setVisibility(r17);
        OCardListItem r111 = this.mFloatingSwitch;
        if (r111 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("mFloatingSwitch");
        r111 = null;
    L51:
        NotificationChannel r23 = this.mChannel;
        if (r23 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("mChannel");
        r23 = null;
    L55:
        if (r23.getImportance() < 4) goto L57;
        r2 = true;
    L57:
        OCardListItemUtils.setChecked(r111, r2);
        OCardListItem r112 = this.mRingtoneSwitch;
        if (r112 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("mRingtoneSwitch");
        r112 = null;
    L60:
        NotificationChannelSmt r24 = NotificationChannelSmt.getInstance();
        NotificationChannel r25 = this.mChannel;
        if (r25 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("mChannel");
        r25 = null;
    L63:
        OCardListItemUtils.setChecked(r112, r24.getSoundEnabled(r25));
        OCardListItem r113 = this.mVibrateSwitch;
        if (r113 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("mVibrateSwitch");
        r113 = null;
    L66:
        NotificationChannel r26 = this.mChannel;
        if (r26 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("mChannel");
    L70:
        OCardListItemUtils.setChecked(r113, r8.shouldVibrate());
        Intrinsics.checkNotNull(r12);
        return r12;
    L69:
        r8 = r26;
        goto L70
    L43:
        if (r13.contains(PageConstants.LAUNCH_PAGE_SOUND) != true) goto L45;
        r110 = true;
        goto L46
    L37:
        r21 = 8;
        goto L38
    L32:
        if (r13.contains("vibration") != true) goto L34;
        r20 = true;
        goto L35
    L26:
        r18 = 8;
        goto L27
    L20:
        if (r13.contains("importance") != true) goto L22;
        r16 = true;
        goto L23
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "buttonView");
        OCardListItem r0 = this.mVibrateSwitch;
        NotificationChannel r1 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mVibrateSwitch");
        r0 = null;
    L6:
        if (r5 == OCardListItemUtils.getSwitchView(r0)) goto L8;
        OCardListItem r2 = this.mRingtoneSwitch;
        if (r2 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("mRingtoneSwitch");
        r2 = null;
    L28:
        if (r5 == OCardListItemUtils.getSwitchView(r2)) goto L30;
        OCardListItem r3 = this.mFloatingSwitch;
        if (r3 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("mFloatingSwitch");
        r3 = null;
    L56:
        if (r5 == OCardListItemUtils.getSwitchView(r3)) goto L58;
        return;
    L58:
        if (this.mChannel != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("mChannel");
    L60:
        NotificationChannel r7 = this.mChannel;
        if (r7 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("mChannel");
        r7 = null;
    L64:
        if (r6 == false) goto L66;
        int r8 = 4;
    L67:
        r7.setImportance(r8);
        NotificationChannel r9 = this.mChannel;
        if (r9 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("mChannel");
        r9 = null;
    L70:
        r9.lockFields(4);
        NotificationBackend r10 = this.mBackend;
        String r11 = this.mPkg;
        if (r11 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("mPkg");
        r11 = null;
    L73:
        int r4 = this.mUid;
        NotificationChannel r12 = this.mChannel;
        if (r12 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("mChannel");
    L77:
        r10.updateChannel(r11, r4, r1);
        return;
    L76:
        r1 = r12;
        goto L77
    L66:
        r8 = 3;
        goto L67
    L30:
        if (this.mChannel != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mChannel");
    L32:
        StringBuilder r13 = new StringBuilder();
        String r14 = this.mPkg;
        if (r14 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("mPkg");
        r14 = null;
    L35:
        StringBuilder r15 = r13.append(r14).append(" getSound: ");
        NotificationChannel r16 = this.mChannel;
        if (r16 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("mChannel");
        r16 = null;
    L38:
        OLog.w(TAG, r15.append(r16.getSound()).toString());
        NotificationChannelSmt r17 = NotificationChannelSmt.getInstance();
        NotificationChannel r18 = this.mChannel;
        if (r18 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("mChannel");
        r18 = null;
    L41:
        r17.setSoundEnabled(r18, r6);
        NotificationChannel r19 = this.mChannel;
        if (r19 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("mChannel");
        r19 = null;
    L44:
        r19.lockFields(32);
        NotificationBackend r20 = this.mBackend;
        String r21 = this.mPkg;
        if (r21 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("mPkg");
        r21 = null;
    L47:
        int r22 = this.mUid;
        NotificationChannel r23 = this.mChannel;
        if (r23 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("mChannel");
    L51:
        r20.updateChannel(r21, r22, r1);
        return;
    L50:
        r1 = r23;
        goto L51
    L8:
        if (this.mChannel != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mChannel");
    L10:
        NotificationChannel r24 = this.mChannel;
        if (r24 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mChannel");
        r24 = null;
    L13:
        r24.enableVibration(r6);
        NotificationChannel r25 = this.mChannel;
        if (r25 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mChannel");
        r25 = null;
    L16:
        r25.lockFields(16);
        NotificationBackend r26 = this.mBackend;
        String r27 = this.mPkg;
        if (r27 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mPkg");
        r27 = null;
    L19:
        int r28 = this.mUid;
        NotificationChannel r29 = this.mChannel;
        if (r29 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mChannel");
    L23:
        r26.updateChannel(r27, r28, r1);
        return;
    L22:
        r1 = r29;
        goto L23
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_notification_ChannelNotificationDialog_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(ChannelNotificationDialog r1) {
        com_android_settings_notification_ChannelNotificationDialog_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_notification_ChannelNotificationDialog_com_obric_hook_lancet_PrivacyHook_onCreate(ChannelNotificationDialog r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ChannelNotificationDialog r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_notification_ChannelNotificationDialog__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_notification_ChannelNotificationDialog_com_obric_hook_lancet_BatchedActivityLancet_onResume(ChannelNotificationDialog r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_notification_ChannelNotificationDialog_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_notification_ChannelNotificationDialog_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(ChannelNotificationDialog r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_notification_ChannelNotificationDialog_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        ChannelNotificationDialog r5 = r4;
        String r2 = r5.getCallingPackage();
        if (r2 != null) goto L9;
        OLog.e("BaseActivity", "isDeviceSetupComplete callingPkg is null, try getReferrer");
        Uri r6 = r5.getReferrer();
        if (r6 == null) goto L9;
        r2 = r6.toString();
    L9:
        OLog.i("TeaEventReportUtil", "callingPkg=" + r2);
        if (r2 != null) goto L12;
        r2 = "null";
    L12:
        AppMetricsUtils.INSTANCE.reportColdStartActivity(r2, r0);
    L13:
        AppMetricsUtils.INSTANCE.setColdStartTime(0);
    }

    @Insert(mayCreateSuper = true, value = "startActivityForResult")
    public static void com_android_settings_notification_ChannelNotificationDialog_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(ChannelNotificationDialog r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_notification_ChannelNotificationDialog__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_notification_ChannelNotificationDialog_com_obric_hook_lancet_BatchedActivityLancet_onStop(ChannelNotificationDialog r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_notification_ChannelNotificationDialog_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_notification_ChannelNotificationDialog_com_obric_hook_lancet_PrivacyHook_onResume(ChannelNotificationDialog r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ChannelNotificationDialog r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_notification_ChannelNotificationDialog__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_notification_ChannelNotificationDialog_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(ChannelNotificationDialog r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_notification_ChannelNotificationDialog_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_notification_ChannelNotificationDialog_com_obric_hook_lancet_PrivacyHook_onPause(ChannelNotificationDialog r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ChannelNotificationDialog r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_notification_ChannelNotificationDialog__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_notification_ChannelNotificationDialog_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(ChannelNotificationDialog r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_notification_ChannelNotificationDialog_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        ChannelNotificationDialog r5 = r3;
        String r6 = r5.getCallingPackage();
        if (r6 != null) goto L9;
        OLog.e("AppLifecycle", "isDeviceSetupComplete callingPkg is null, try getReferrer");
        Uri r7 = r5.getReferrer();
        if (r7 == null) goto L9;
        r6 = r7.toString();
    L9:
        OLog.i("AppLifecycle", "TeaEventReportUtil callingPkg=" + r6);
        if (r6 != null) goto L12;
        r6 = "null";
    L12:
        AppMetricsUtils r8 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r8.callingPackageEvent(r6, r0, false);
        return;
    }

    @Insert("onStop")
    public static void com_android_settings_notification_ChannelNotificationDialog_com_obric_hook_lancet_PrivacyHook_onStop(ChannelNotificationDialog r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ChannelNotificationDialog r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_notification_ChannelNotificationDialog__onStop$___twin___();
    }
}
