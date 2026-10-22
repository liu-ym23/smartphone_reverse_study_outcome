package com.obric.safecheck.riskcontrol.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.lifecycle.ViewModelProvider;
import com.obric.matrix.platform.sdk.ones.account.AccountInfoBundleKey;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.safecheck.R;
import com.obric.safecheck.provider.ApkVirusCheckProvider;
import com.obric.safecheck.riskcontrol.api.model.RiskControlFlags;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: RiskAppDetailActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 d2\u00020\u0001:\u0001dB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010C\u001a\u00020DH\u0002J\u0010\u0010E\u001a\u00020D2\u0006\u0010F\u001a\u00020\u0015H\u0002J\u0018\u0010G\u001a\u00020D2\u0006\u0010H\u001a\u00020\u00192\u0006\u0010I\u001a\u00020\u0018H\u0002J\b\u0010J\u001a\u00020DH\u0002J\u0010\u0010K\u001a\u00020D2\u0006\u0010I\u001a\u00020\u0018H\u0002J\b\u0010L\u001a\u00020DH\u0002J\b\u0010M\u001a\u00020DH\u0002J\b\u0010N\u001a\u00020DH\u0002J\u0010\u0010O\u001a\u00020\u00042\u0006\u0010P\u001a\u00020*H\u0002J\u0012\u0010Q\u001a\u00020D2\b\u0010R\u001a\u0004\u0018\u00010SH\u0014J\b\u0010T\u001a\u00020DH\u0014J\u0010\u0010U\u001a\u00020*2\u0006\u0010I\u001a\u00020\u0018H\u0002J\u0010\u0010V\u001a\u00020*2\u0006\u0010I\u001a\u00020\u0018H\u0002J\u0018\u0010W\u001a\u00020D2\u0006\u0010H\u001a\u00020\u00192\u0006\u0010X\u001a\u00020\u0004H\u0002J\b\u0010Y\u001a\u00020DH\u0002J.\u0010Z\u001a\u00020D2\u0006\u0010[\u001a\u00020*2\u0006\u0010\\\u001a\u00020*2\u0006\u0010]\u001a\u00020\u00042\f\u0010^\u001a\b\u0012\u0004\u0012\u00020D0_H\u0002J\u0010\u0010`\u001a\u00020D2\u0006\u0010a\u001a\u00020\u0018H\u0002J\u0010\u0010b\u001a\u00020D2\u0006\u0010a\u001a\u00020\u0018H\u0002J\u0010\u0010c\u001a\u00020D2\u0006\u0010a\u001a\u00020\u0018H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR#\u0010\u000f\u001a\n \n*\u0004\u0018\u00010\u00100\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R'\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u000e\u001a\u0004\b\u001a\u0010\u001bR#\u0010\u001d\u001a\n \n*\u0004\u0018\u00010\u00100\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000e\u001a\u0004\b\u001e\u0010\u0012R#\u0010 \u001a\n \n*\u0004\u0018\u00010!0!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u000e\u001a\u0004\b\"\u0010#R#\u0010%\u001a\n \n*\u0004\u0018\u00010\t0\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u000e\u001a\u0004\b&\u0010\fR\u000e\u0010(\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010,\u001a\n \n*\u0004\u0018\u00010-0-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\u000e\u001a\u0004\b.\u0010/R#\u00101\u001a\n \n*\u0004\u0018\u00010\t0\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\u000e\u001a\u0004\b2\u0010\fR#\u00104\u001a\n \n*\u0004\u0018\u00010\t0\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u0010\u000e\u001a\u0004\b5\u0010\fR#\u00107\u001a\n \n*\u0004\u0018\u00010\t0\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\u000e\u001a\u0004\b8\u0010\fR\u000e\u0010:\u001a\u00020;X\u0082.¢\u0006\u0002\n\u0000R#\u0010<\u001a\n \n*\u0004\u0018\u00010\u00190\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u0010\u000e\u001a\u0004\b=\u0010>R#\u0010@\u001a\n \n*\u0004\u0018\u00010\u00190\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u0010\u000e\u001a\u0004\bA\u0010>¨\u0006e"}, d2 = {"Lcom/obric/safecheck/riskcontrol/ui/RiskAppDetailActivity;", "Landroidx/activity/ComponentActivity;", "()V", "awaitingUninstallResult", "", "bindingSwitchState", "confirmDialog", "Lcom/obric/oui/dialog/v2/alert/OAlertDialog;", "controlButton", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getControlButton", "()Landroid/widget/TextView;", "controlButton$delegate", "Lkotlin/Lazy;", "controlsCard", "Landroid/view/View;", "getControlsCard", "()Landroid/view/View;", "controlsCard$delegate", "currentState", "Lcom/obric/safecheck/riskcontrol/ui/RiskAppDetailUiState;", "flagSwitchRows", "", "", "Lcom/obric/oui/lisitem/OCardListItem;", "getFlagSwitchRows", "()Ljava/util/Map;", "flagSwitchRows$delegate", "footer", "getFooter", "footer$delegate", "iconView", "Landroid/widget/ImageView;", "getIconView", "()Landroid/widget/ImageView;", "iconView$delegate", "installSourceText", "getInstallSourceText", "installSourceText$delegate", "isInstallationPackage", ApkVirusCheckProvider.KEY_PKG, "", "targetUserId", "titleBar", "Lcom/obric/oui/titlebar/OFloatingTitleBar;", "getTitleBar", "()Lcom/obric/oui/titlebar/OFloatingTitleBar;", "titleBar$delegate", "titleText", "getTitleText", "titleText$delegate", "uninstallButton", "getUninstallButton", "uninstallButton$delegate", "versionText", "getVersionText", "versionText$delegate", "viewModel", "Lcom/obric/safecheck/riskcontrol/ui/RiskAppDetailViewModel;", "virusDescriptionRow", "getVirusDescriptionRow", "()Lcom/obric/oui/lisitem/OCardListItem;", "virusDescriptionRow$delegate", "virusTypeRow", "getVirusTypeRow", "virusTypeRow$delegate", "bindActions", "", "bindContent", "state", "bindFlagSwitch", "row", "flag", "bindSwitches", "handleFlagSwitchChanged", "initFooterInsets", "initRiskInfoCards", "initTitleBar", "isPackageInstalled", "packageName", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "permissionName", "permissionReleaseAction", "setSwitchChecked", "checked", "setupImmersiveStatusBar", "showConfirmDialog", "title", "subtitle", "showAppIcon", "onConfirm", "Lkotlin/Function0;", "updateControlButtonText", "controlFlags", "updateInstalledPackageControls", "updateSwitchState", "Companion", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class RiskAppDetailActivity extends ComponentActivity {
    public static final Companion Companion = null;
    public static final String EXTRA_IS_INSTALLATION_PACKAGE = "risk_control_is_installation_package";
    public static final String EXTRA_PACKAGE_NAME = "risk_control_pkg";
    public static final String EXTRA_USER_ID = "risk_control_user_id";
    private boolean awaitingUninstallResult;
    private boolean bindingSwitchState;
    private OAlertDialog confirmDialog;
    private final Lazy controlButton$delegate;
    private final Lazy controlsCard$delegate;
    private RiskAppDetailUiState currentState;
    private final Lazy flagSwitchRows$delegate;
    private final Lazy footer$delegate;
    private final Lazy iconView$delegate;
    private final Lazy installSourceText$delegate;
    private boolean isInstallationPackage;
    private String pkg;
    private int targetUserId;
    private final Lazy titleBar$delegate;
    private final Lazy titleText$delegate;
    private final Lazy uninstallButton$delegate;
    private final Lazy versionText$delegate;
    private RiskAppDetailViewModel viewModel;
    private final Lazy virusDescriptionRow$delegate;
    private final Lazy virusTypeRow$delegate;

    /* JADX INFO: compiled from: RiskAppDetailActivity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0007J(\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/safecheck/riskcontrol/ui/RiskAppDetailActivity$Companion;", "", "()V", "EXTRA_IS_INSTALLATION_PACKAGE", "", "EXTRA_PACKAGE_NAME", "EXTRA_USER_ID", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", ApkVirusCheckProvider.KEY_PKG, AccountInfoBundleKey.USER_ID, "", "isInstallationPackage", "", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public final Intent createIntent(Context r2, String r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, ApkVirusCheckProvider.KEY_PKG);
            return createIntent(r2, r3, r4, false);
        }

        @JvmStatic
        public final Intent createIntent(Context r2, String r3, int r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, ApkVirusCheckProvider.KEY_PKG);
            Intent r1 = new Intent(r2, RiskAppDetailActivity.class).putExtra(RiskAppDetailActivity.EXTRA_PACKAGE_NAME, r3).putExtra(RiskAppDetailActivity.EXTRA_USER_ID, r4).putExtra(RiskAppDetailActivity.EXTRA_IS_INSTALLATION_PACKAGE, r5);
            Intrinsics.checkNotNullExpressionValue(r1, "Intent(context, RiskAppD…E, isInstallationPackage)");
            return r1;
        }
    }

    static {
        Companion = new Companion(null);
    }

    @JvmStatic
    public static final Intent createIntent(Context r1, String r2, int r3) {
        return Companion.createIntent(r1, r2, r3);
    }

    @JvmStatic
    public static final Intent createIntent(Context r1, String r2, int r3, boolean r4) {
        return Companion.createIntent(r1, r2, r3, r4);
    }

    private final TextView getControlButton() {
        return (TextView) this.controlButton$delegate.getValue();
    }

    private final View getControlsCard() {
        return (View) this.controlsCard$delegate.getValue();
    }

    private final Map<Integer, OCardListItem> getFlagSwitchRows() {
        return (Map) this.flagSwitchRows$delegate.getValue();
    }

    private final View getFooter() {
        return (View) this.footer$delegate.getValue();
    }

    private final ImageView getIconView() {
        return (ImageView) this.iconView$delegate.getValue();
    }

    private final TextView getInstallSourceText() {
        return (TextView) this.installSourceText$delegate.getValue();
    }

    private final OFloatingTitleBar getTitleBar() {
        return (OFloatingTitleBar) this.titleBar$delegate.getValue();
    }

    private final TextView getTitleText() {
        return (TextView) this.titleText$delegate.getValue();
    }

    private final TextView getUninstallButton() {
        return (TextView) this.uninstallButton$delegate.getValue();
    }

    private final TextView getVersionText() {
        return (TextView) this.versionText$delegate.getValue();
    }

    private final OCardListItem getVirusDescriptionRow() {
        return (OCardListItem) this.virusDescriptionRow$delegate.getValue();
    }

    private final OCardListItem getVirusTypeRow() {
        return (OCardListItem) this.virusTypeRow$delegate.getValue();
    }

    public RiskAppDetailActivity() {
        this.pkg = "";
        this.currentState = new RiskAppDetailUiState(null, null, 0, false, 15, null);
        this.titleBar$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new RiskAppDetailActivity$titleBar$2(this));
        this.footer$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new RiskAppDetailActivity$footer$2(this));
        this.titleText$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new RiskAppDetailActivity$titleText$2(this));
        this.versionText$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new RiskAppDetailActivity$versionText$2(this));
        this.installSourceText$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new RiskAppDetailActivity$installSourceText$2(this));
        this.iconView$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new RiskAppDetailActivity$iconView$2(this));
        this.virusTypeRow$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new RiskAppDetailActivity$virusTypeRow$2(this));
        this.virusDescriptionRow$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new RiskAppDetailActivity$virusDescriptionRow$2(this));
        this.controlsCard$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new RiskAppDetailActivity$controlsCard$2(this));
        this.controlButton$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new RiskAppDetailActivity$controlButton$2(this));
        this.uninstallButton$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new RiskAppDetailActivity$uninstallButton$2(this));
        this.flagSwitchRows$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new RiskAppDetailActivity$flagSwitchRows$2(this));
    }

    public static final /* synthetic */ void access$bindContent(RiskAppDetailActivity r0, RiskAppDetailUiState r1) {
        r0.bindContent(r1);
    }

    public static final /* synthetic */ boolean access$getAwaitingUninstallResult$p(RiskAppDetailActivity r0) {
        return r0.awaitingUninstallResult;
    }

    public static final /* synthetic */ OAlertDialog access$getConfirmDialog$p(RiskAppDetailActivity r0) {
        return r0.confirmDialog;
    }

    public static final /* synthetic */ RiskAppDetailUiState access$getCurrentState$p(RiskAppDetailActivity r0) {
        return r0.currentState;
    }

    public static final /* synthetic */ String access$getPkg$p(RiskAppDetailActivity r0) {
        return r0.pkg;
    }

    public static final /* synthetic */ RiskAppDetailViewModel access$getViewModel$p(RiskAppDetailActivity r1) {
        RiskAppDetailViewModel r2 = r1.viewModel;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        return r2;
    }

    public static final /* synthetic */ void access$handleFlagSwitchChanged(RiskAppDetailActivity r0, int r1) {
        r0.handleFlagSwitchChanged(r1);
    }

    public static final /* synthetic */ boolean access$isInstallationPackage$p(RiskAppDetailActivity r0) {
        return r0.isInstallationPackage;
    }

    public static final /* synthetic */ void access$setAwaitingUninstallResult$p(RiskAppDetailActivity r0, boolean r1) {
        r0.awaitingUninstallResult = r1;
    }

    public static final /* synthetic */ void access$setConfirmDialog$p(RiskAppDetailActivity r0, OAlertDialog r1) {
        r0.confirmDialog = r1;
    }

    public static final /* synthetic */ void access$setCurrentState$p(RiskAppDetailActivity r0, RiskAppDetailUiState r1) {
        r0.currentState = r1;
    }

    public static final /* synthetic */ void access$setInstallationPackage$p(RiskAppDetailActivity r0, boolean r1) {
        r0.isInstallationPackage = r1;
    }

    public static final /* synthetic */ void access$setPkg$p(RiskAppDetailActivity r0, String r1) {
        r0.pkg = r1;
    }

    public static final /* synthetic */ void access$setViewModel$p(RiskAppDetailActivity r0, RiskAppDetailViewModel r1) {
        r0.viewModel = r1;
    }

    public static final /* synthetic */ void access$showConfirmDialog(RiskAppDetailActivity r0, String r1, String r2, boolean r3, Function0 r4) {
        r0.showConfirmDialog(r1, r2, r3, r4);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r6) {
        setupImmersiveStatusBar();
        super.onCreate(r6);
        RiskControlRuntimeDependencies r7 = RiskControlRuntimeDependencies.INSTANCE;
        Context r0 = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(r0, "applicationContext");
        r7.ensureInitialized(r0);
        String r8 = getIntent().getStringExtra(EXTRA_PACKAGE_NAME);
        if (r8 != null) goto L5;
        r8 = "";
    L5:
        this.pkg = r8;
        this.targetUserId = getIntent().getIntExtra(EXTRA_USER_ID, 0);
        this.isInstallationPackage = getIntent().getBooleanExtra(EXTRA_IS_INSTALLATION_PACKAGE, false);
        setContentView(R.layout.activity_risk_app_detail);
        initTitleBar();
        initFooterInsets();
        initRiskInfoCards();
        bindSwitches();
        bindActions();
        RiskAppDetailViewModel r9 = (RiskAppDetailViewModel) new ViewModelProvider(this, RiskAppDetailViewModel.Companion.factory(this, this.pkg, this.targetUserId)).get(RiskAppDetailViewModel.class);
        this.viewModel = r9;
        if (r9 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L8:
        r9.getUiState().observe(this, new C03241(this));
        RiskAppDetailViewModel r5 = this.viewModel;
        if (r5 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L11:
        r5.load();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.awaitingUninstallResult == false) goto L10;
        this.awaitingUninstallResult = false;
        if (this.isInstallationPackage == false) goto L7;
        return;
    L7:
        if (isPackageInstalled(this.pkg) == true) goto L12;
        finish();
        return;
    L12:
        return;
    }

    private final boolean isPackageInstalled(String r3) {
        if (StringsKt.isBlank(r3) == false) goto L14;
        return false;
    L14:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        RiskAppDetailActivity r1 = this;     // Catch: Throwable -> L7
        getPackageManager().getApplicationInfo(r3, 0);     // Catch: Throwable -> L7
        Object r2 = Result.m774constructorimpl(true);     // Catch: Throwable -> L7
    L10:
        if (Result.m780isFailureimpl(r2) == false) goto L13;
        r2 = false;
    L13:
        return ((Boolean) r2).booleanValue();
    L7:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r2 = Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    private final void initRiskInfoCards() {
        OCardListItem r0 = getVirusTypeRow();
        OCardListItem.setCardPosition$default(r0, 1, false, 2, null);
        r0.showCustomEnd(true);
        OTextView r1 = r0.getEndDetail();
        if (r1 == null) goto L5;
        r1.setMaxLines(1);
    L5:
        OCardListItem r5 = getVirusDescriptionRow();
        OCardListItem.setCardPosition$default(r5, 3, false, 2, null);
        r5.showCustomEnd(true);
        OTextView r6 = r5.getEndDetail();
        if (r6 == null) goto L9;
        TextUtils.TruncateAt r2 = (TextUtils.TruncateAt) null;
        r6.setEllipsize(null);
        r6.setMaxLines(Integer.MAX_VALUE);
        return;
    }

    private final void setupImmersiveStatusBar() {
        boolean r1 = false;
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().addFlags(Integer.MIN_VALUE);
        Window r0 = getWindow();
        Intrinsics.checkNotNullExpressionValue(r0, "window");
        r0.setStatusBarColor(0);
        Window r2 = getWindow();
        Intrinsics.checkNotNullExpressionValue(r2, "window");
        r2.setNavigationBarColor(0);
        Resources r3 = getResources();
        Intrinsics.checkNotNullExpressionValue(r3, "resources");
        if ((r3.getConfiguration().uiMode & 48) != 32) goto L5;
        r1 = true;
    L5:
        Window r4 = getWindow();
        Window r5 = getWindow();
        Intrinsics.checkNotNullExpressionValue(r5, "window");
        new WindowInsetsControllerCompat(r4, r5.getDecorView()).setAppearanceLightStatusBars(!r1);
    }

    private final void initTitleBar() {
        getTitleBar().addStartAction(R.drawable.o_floating_title_bar_icon_back, -1, new ViewOnClickListenerC03231(this));
    }

    private final void initFooterInsets() {
        View r0 = getFooter();
        Intrinsics.checkNotNullExpressionValue(r0, "footer");
        final int r1 = r0.getPaddingBottom();
        ViewCompat.setOnApplyWindowInsetsListener(getFooter(), new C03221(r1));
        ViewCompat.requestApplyInsets(getFooter());
    }

    private final void bindContent(RiskAppDetailUiState r11) {
        this.currentState = r11;
        RiskAppContentUiInfo r0 = r11.getContent();
        if (r0 != null) goto L5;
        return;
    L5:
        RiskAppUiInfo r1 = r11.getAppInfo();
        if (r1 != null) goto L8;
        String r4 = this.pkg;
        r1 = new RiskAppUiInfo(r4, r4, null, null, null, 28, null);
    L8:
        TextView r2 = getTitleText();
        Intrinsics.checkNotNullExpressionValue(r2, "titleText");
        r2.setText(r1.getAppName());
        TextView r3 = getVersionText();
        Intrinsics.checkNotNullExpressionValue(r3, "versionText");
        if (this.isInstallationPackage == false) goto L20;
        String r5 = r1.getVersionName();
        if (r5 != null) goto L13;
    L16:
        boolean r6 = true;
    L17:
        if (r6 == true) goto L20;
        String r7 = getString(R.string.app_version, new Object[]{r1.getVersionName()});
    L24:
        r3.setText(r7);
        TextView r8 = getInstallSourceText();
        String r9 = r1.getInstallSource();
        if (this.isInstallationPackage == true) goto L35;
        String r10 = r9;
        if (r10 != null) goto L29;
    L32:
        boolean r12 = true;
    L33:
        if (r12 == true) goto L35;
        int r13 = 0;
    L36:
        r8.setVisibility(r13);
        if (r8.getVisibility() != 0) goto L39;
        boolean r14 = true;
    L41:
        if (r14 == false) goto L43;
        String r15 = getString(R.string.install_source, new Object[]{r9});
    L44:
        r8.setText(r15);
        Drawable r16 = r1.getIcon();
        if (r16 == null) goto L47;
        getIconView().setImageDrawable(r16);
    L47:
        OCardListItem r17 = getVirusTypeRow();
        OCardListItem.setEndDetailText$default(r17, r0.getVirusType(), 0, 2, null);
        OTextView r18 = r17.getEndDetail();
        if (r18 == null) goto L50;
        r18.setMaxLines(1);
    L50:
        OCardListItem r19 = getVirusDescriptionRow();
        String r20 = r0.getVirusDescription();
        if (r20 != null) goto L53;
        r20 = "";
    L53:
        OCardListItem.setEndDetailText$default(r19, r20, 0, 2, null);
        OTextView r21 = r19.getEndDetail();
        if (r21 == null) goto L56;
        TextUtils.TruncateAt r22 = (TextUtils.TruncateAt) null;
        r21.setEllipsize(null);
        r21.setMaxLines(Integer.MAX_VALUE);
    L56:
        updateInstalledPackageControls(r11.getControlFlags());
        return;
    L43:
        r15 = null;
        goto L44
    L39:
        r14 = false;
        goto L41
    L29:
        if (StringsKt.isBlank(r10) == true) goto L32;
        r12 = false;
    L35:
        r13 = 8;
        goto L36
    L13:
        if (StringsKt.isBlank(r5) == true) goto L16;
        r6 = false;
    L20:
        if (this.isInstallationPackage == false) goto L22;
        int r23 = R.string.install_package;
    L23:
        r7 = getString(r23);
        goto L24
    L22:
        r23 = R.string.installed_apps;
        goto L23
    }

    private final void bindSwitches() {
        Iterator<Map.Entry<Integer, OCardListItem>> r0 = getFlagSwitchRows().entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Map.Entry<Integer, OCardListItem> r1 = r0.next();
        int r2 = r1.getKey().intValue();
        bindFlagSwitch(r1.getValue(), r2);
        goto L4
    }

    private final void bindFlagSwitch(OCardListItem r4, final int r5) {
        r4.setDefaultCustomEndView(1);
        OSwitch r1 = r4.getEndSwitch();
        if (r1 == null) goto L5;
        r1.setOnTouchListener(new RiskAppDetailActivity$bindFlagSwitch$$inlined$apply$lambda$1(this, r5));
    L5:
        r4.showCustomEnd(true);
    }

    private final void handleFlagSwitchChanged(final int r7) {
        if ((this.currentState.getControlFlags() & r7) != 0) goto L9;
        RiskAppDetailViewModel r6 = this.viewModel;
        if (r6 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L7:
        r6.setFlag(r7, true);
        return;
    L9:
        String r0 = getString(R.string.cancel_control_permission_confirm, new Object[]{permissionName(r7)});
        Intrinsics.checkNotNullExpressionValue(r0, "getString(R.string.cance…rm, permissionName(flag))");
        String r2 = getString(R.string.cancel_control_permission_risk, new Object[]{permissionReleaseAction(r7)});
        Intrinsics.checkNotNullExpressionValue(r2, "getString(\n             …ction(flag)\n            )");
        showConfirmDialog(r0, r2, true, new C03211(this, r7));
    }

    private final void bindActions() {
        getControlButton().setOnClickListener(new AnonymousClass1(this));
        getUninstallButton().setOnClickListener(new AnonymousClass2(this));
    }

    private final void updateInstalledPackageControls(int r7) {
        TextView r0 = getControlButton();
        TextView r1 = getUninstallButton();
        View r2 = getControlsCard();
        Intrinsics.checkNotNullExpressionValue(r2, "controlsCard");
        int r4 = 8;
        if (this.isInstallationPackage == false) goto L5;
        int r3 = 8;
    L6:
        r2.setVisibility(r3);
        Intrinsics.checkNotNullExpressionValue(r1, "uninstall");
        if (this.isInstallationPackage == false) goto L9;
        int r5 = R.string.risk_control_delete;
    L10:
        r1.setText(getString(r5));
        Intrinsics.checkNotNullExpressionValue(r0, "control");
        if (this.isInstallationPackage == true) goto L14;
        r4 = 0;
    L14:
        r0.setVisibility(r4);
        ViewGroup.LayoutParams r6 = r1.getLayoutParams();
        if ((r6 instanceof LinearLayout.LayoutParams) == true) goto L17;
        r6 = null;
    L17:
        LinearLayout.LayoutParams r8 = (LinearLayout.LayoutParams) r6;
        if (r8 == null) goto L25;
        r8.width = 0;
        r8.weight = 1.0f;
        if (this.isInstallationPackage == false) goto L22;
        int r9 = 0;
    L23:
        r8.setMarginStart(r9);
        r8.setMarginEnd(0);
        r1.setLayoutParams(r8);
        goto L25
    L22:
        r9 = MathKt.roundToInt(TypedValue.applyDimension(1, 6, Resources.getSystem().getDisplayMetrics()));
    L25:
        if (this.isInstallationPackage == true) goto L28;
        updateSwitchState(r7);
        updateControlButtonText(r7);
        return;
    L28:
        return;
    L9:
        r5 = R.string.risk_control_uninstall;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    private final void showConfirmDialog(String r19, String r20, boolean r21, final Function0<Unit> r22) {
        OAlertDialog r1 = this.confirmDialog;
        if (r1 == null) goto L6;
        r1.dismiss();
    L6:
        if (r21 == false) goto L12;
        RiskAppUiInfo r2 = this.currentState.getAppInfo();
        if (r2 == null) goto L11;
        Drawable r3 = r2.getIcon();
        if (r3 == null) goto L11;
    L13:
        float r4 = 56;
        OAlertDialogBuilder r5 = OAlertDialogBuilder.title$default(new OAlertDialogBuilder(this), r19, false, 2, null).message(r20).imageSize(MathKt.roundToInt(TypedValue.applyDimension(1, r4, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, r4, Resources.getSystem().getDisplayMetrics())));
        if (r3 == null) goto L16;
        r5.icon(r3);
    L16:
        Unit r6 = Unit.INSTANCE;
        OAlertDialogBuilder r7 = r5.horizontalButton(true);
        String r8 = getString(R.string.cancel_control);
        Intrinsics.checkNotNullExpressionValue(r8, "getString(R.string.cancel_control)");
        OAlertDialogBuilder r12 = OAlertDialogBuilder.positiveButton$default(r7, r8, new DialogInterfaceOnClickListenerC03252(r22), null, 4, null);
        String r9 = getString(R.string.keep_control);
        Intrinsics.checkNotNullExpressionValue(r9, "getString(R.string.keep_control)");
        final OAlertDialog r10 = OAlertDialogBuilder.negativeButton$default(r12, r9, AnonymousClass3.INSTANCE, null, 4, null).build();
        r10.setOnDismissListener(new RiskAppDetailActivity$showConfirmDialog$$inlined$also$lambda$1(r10, this));
        r10.show();
        Unit r11 = Unit.INSTANCE;
        this.confirmDialog = r10;
        return;
    L11:
        ImageView r13 = getIconView();
        Intrinsics.checkNotNullExpressionValue(r13, "iconView");
        r3 = r13.getDrawable();
        goto L13
    L12:
        r3 = null;
        goto L13
    }

    private final void updateControlButtonText(int r3) {
        TextView r0 = getControlButton();
        Intrinsics.checkNotNullExpressionValue(r0, "controlButton");
        if (RiskControlFlags.hasControlledItem(r3) == false) goto L5;
        String r2 = getString(R.string.cancel_control);
    L6:
        r0.setText(r2);
        return;
    L5:
        r2 = getString(R.string.control);
        goto L6
    }

    private final void updateSwitchState(int r6) {
        this.bindingSwitchState = true;
        Iterator<Map.Entry<Integer, OCardListItem>> r1 = getFlagSwitchRows().entrySet().iterator();
    L3:
        boolean r3 = false;
        if (r1.hasNext() == false) goto L9;
        Map.Entry<Integer, OCardListItem> r2 = r1.next();
        int r4 = r2.getKey().intValue();
        OCardListItem r5 = r2.getValue();
        if ((r4 & r6) == 0) goto L8;
        r3 = true;
    L8:
        setSwitchChecked(r5, r3);
        goto L3
    L9:
        this.bindingSwitchState = false;
    }

    private final void setSwitchChecked(OCardListItem r1, boolean r2) {
        View r0 = r1.getCustomEndView();
        if ((r0 instanceof OSwitch) == true) goto L5;
        r0 = null;
    L5:
        OSwitch r3 = (OSwitch) r0;
        if (r3 == null) goto L9;
        r3.setChecked(r2);
        return;
    }

    private final String permissionName(int r2) {
        if (r2 != 3) goto L5;
        String r1 = getString(R.string.risk_control_item_network);
        Intrinsics.checkNotNullExpressionValue(r1, "getString(R.string.risk_control_item_network)");
        return r1;
    L5:
        if (r2 != 28) goto L7;
        String r3 = getString(R.string.risk_control_item_permission);
        Intrinsics.checkNotNullExpressionValue(r3, "getString(R.string.risk_control_item_permission)");
        return r3;
    L7:
        if (r2 != 32) goto L9;
        String r4 = getString(R.string.risk_control_item_accessibility);
        Intrinsics.checkNotNullExpressionValue(r4, "getString(R.string.risk_…ntrol_item_accessibility)");
        return r4;
    L9:
        if (r2 == 64) goto L11;
        String r5 = getString(R.string.cancel_control);
        Intrinsics.checkNotNullExpressionValue(r5, "getString(R.string.cancel_control)");
        return r5;
    L11:
        String r6 = getString(R.string.risk_control_item_notification);
        Intrinsics.checkNotNullExpressionValue(r6, "getString(R.string.risk_control_item_notification)");
        return r6;
    }

    private final String permissionReleaseAction(int r3) {
        if (r3 != 3) goto L5;
        String r2 = getString(R.string.allow_network_after_cancel_control);
        Intrinsics.checkNotNullExpressionValue(r2, "getString(R.string.allow…ork_after_cancel_control)");
        return r2;
    L5:
        if (r3 != 28) goto L7;
        String r4 = getString(R.string.allow_sensitive_permission_after_cancel_control);
        Intrinsics.checkNotNullExpressionValue(r4, "getString(R.string.allow…ion_after_cancel_control)");
        return r4;
    L7:
        if (r3 != 32) goto L9;
        String r5 = getString(R.string.allow_accessibility_after_cancel_control);
        Intrinsics.checkNotNullExpressionValue(r5, "getString(R.string.allow…ity_after_cancel_control)");
        return r5;
    L9:
        if (r3 == 64) goto L11;
        String r6 = getString(R.string.cancel_control_risk);
        Intrinsics.checkNotNullExpressionValue(r6, "getString(R.string.cancel_control_risk)");
        return r6;
    L11:
        String r7 = getString(R.string.allow_notification_after_cancel_control);
        Intrinsics.checkNotNullExpressionValue(r7, "getString(R.string.allow…ion_after_cancel_control)");
        return r7;
    }
}
