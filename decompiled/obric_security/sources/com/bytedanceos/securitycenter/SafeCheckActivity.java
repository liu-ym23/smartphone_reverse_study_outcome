package com.bytedanceos.securitycenter;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.networkstackapplib.NetworkStackConstant;
import com.bytedanceos.security.BaseActivity;
import com.bytedanceos.securitycenter.scan.SafeCheckRiskAppItem;
import com.bytedanceos.securitycenter.scan.SafeCheckRiskAppUseCase;
import com.bytedanceos.securitycenter.scan.SafeCheckUiState;
import com.bytedanceos.securitycenter.scan.ScanSettingsRepository;
import com.obric.netdetect.Modules.HttpProbe.HttpProbeResult;
import com.obric.oui.animation.ScrollingNumbersView;
import com.obric.oui.badge.OBadgeAttachUtils;
import com.obric.oui.badge.OBadgeDrawable;
import com.obric.oui.button.OButton;
import com.obric.oui.button.OButtonGroup;
import com.obric.oui.checkbox.OCheckBoxLayout;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.security.R;
import com.obric.security.mainpage.util.DisplaySizeStableContext;
import com.obric.security.mainpage.view.GlowDotRingProg;
import com.obric.security.mainpage.view.RotatePannelManager2;
import com.obric.security.mainpage.view.RotatePannelView2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import tmsdk.common.module.qscanner.QScanResultEntity;

/* JADX INFO: compiled from: SafeCheckActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Í\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d*\u0001b\u0018\u0000 ¡\u00012\u00020\u0001:\u0006¡\u0001¢\u0001£\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010k\u001a\u00020\u00042\u0006\u0010l\u001a\u00020\u00042\u0006\u0010m\u001a\u00020nH\u0002J\u0010\u0010o\u001a\u00020p2\u0006\u0010q\u001a\u00020\u0004H\u0002J\u0010\u0010r\u001a\u00020p2\u0006\u0010s\u001a\u00020\u0004H\u0002J\u0010\u0010t\u001a\u00020p2\u0006\u0010l\u001a\u00020\u0004H\u0002J\b\u0010u\u001a\u00020pH\u0002J\b\u0010v\u001a\u00020pH\u0002J\u0010\u0010w\u001a\u00020p2\u0006\u0010x\u001a\u00020\u001bH\u0002J\u0010\u0010y\u001a\u00020p2\u0006\u0010x\u001a\u00020\u001bH\u0002J\u0016\u0010z\u001a\u00020p2\f\u0010{\u001a\b\u0012\u0004\u0012\u00020\"0\u0016H\u0002J\b\u0010|\u001a\u00020pH\u0002J\b\u0010}\u001a\u00020pH\u0002J\b\u0010~\u001a\u00020pH\u0002J\b\u0010\u007f\u001a\u00020pH\u0002J\t\u0010\u0080\u0001\u001a\u00020pH\u0002J\u001c\u0010\u0081\u0001\u001a\u00020p2\u0007\u0010\u0082\u0001\u001a\u00020&2\b\u0010\u0083\u0001\u001a\u00030\u0084\u0001H\u0002J\u0015\u0010\u0085\u0001\u001a\u00020p2\n\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0087\u0001H\u0014J\t\u0010\u0088\u0001\u001a\u00020pH\u0014J\t\u0010\u0089\u0001\u001a\u00020pH\u0014J\u0017\u0010\u008a\u0001\u001a\u00020p2\f\u0010{\u001a\b\u0012\u0004\u0012\u00020\"0\u0016H\u0002J\u0012\u0010\u008b\u0001\u001a\u00020&2\u0007\u0010\u008c\u0001\u001a\u00020\u0004H\u0002J\t\u0010\u008d\u0001\u001a\u00020pH\u0002J\u0018\u0010\u008e\u0001\u001a\u00020p2\r\u0010\u008f\u0001\u001a\b\u0012\u0004\u0012\u00020&0%H\u0002J\u0018\u0010\u0090\u0001\u001a\u00020p2\r\u0010\u0091\u0001\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0002J\t\u0010\u0092\u0001\u001a\u00020pH\u0002J\t\u0010\u0093\u0001\u001a\u00020pH\u0002J\u0017\u0010\u0094\u0001\u001a\u00020p2\f\u0010{\u001a\b\u0012\u0004\u0012\u00020\"0\u0016H\u0002J\t\u0010\u0095\u0001\u001a\u00020&H\u0016J\t\u0010\u0096\u0001\u001a\u00020pH\u0002J\t\u0010\u0097\u0001\u001a\u00020pH\u0002J\u001a\u0010\u0098\u0001\u001a\u00020p2\u0006\u0010l\u001a\u00020\u00042\u0007\u0010\u0099\u0001\u001a\u00020&H\u0002J\t\u0010\u009a\u0001\u001a\u00020pH\u0002J\u0012\u0010\u009b\u0001\u001a\u00020p2\u0007\u0010\u0082\u0001\u001a\u00020&H\u0002J\t\u0010\u009c\u0001\u001a\u00020pH\u0002J\t\u0010\u009d\u0001\u001a\u00020pH\u0002J\t\u0010\u009e\u0001\u001a\u00020pH\u0002J\u0012\u0010\u009f\u0001\u001a\u00020p2\u0007\u0010 \u0001\u001a\u00020\u001bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001cR\u001b\u0010\u001e\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\f\u001a\u0004\b\u001f\u0010\nR\u001c\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0019R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u001b\u0010)\u001a\u00020*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\f\u001a\u0004\b+\u0010,R\u0012\u0010.\u001a\u00060/R\u00020\u0000X\u0082.¢\u0006\u0002\n\u0000R\u001b\u00100\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\f\u001a\u0004\b1\u0010\nR\u001b\u00103\u001a\u0002048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u0010\f\u001a\u0004\b5\u00106R\u001b\u00108\u001a\u0002098BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u0010\f\u001a\u0004\b:\u0010;R\u001b\u0010=\u001a\u00020>8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bA\u0010\f\u001a\u0004\b?\u0010@R\u001b\u0010B\u001a\u00020*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bD\u0010\f\u001a\u0004\bC\u0010,R\u000e\u0010E\u001a\u00020FX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010G\u001a\u00020H8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bK\u0010\f\u001a\u0004\bI\u0010JR\u001b\u0010L\u001a\u00020M8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bP\u0010\f\u001a\u0004\bN\u0010OR\u001b\u0010Q\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bS\u0010\f\u001a\u0004\bR\u0010\nR\u001b\u0010T\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bV\u0010\f\u001a\u0004\bU\u0010\nR\u001b\u0010W\u001a\u00020X8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b[\u0010\f\u001a\u0004\bY\u0010ZR\u001a\u0010\\\u001a\b\u0012\u0004\u0012\u00020&0%8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b]\u0010(R\u0010\u0010^\u001a\u0004\u0018\u00010_X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010a\u001a\u00020bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010cR\u001b\u0010d\u001a\u00020*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bf\u0010\f\u001a\u0004\be\u0010,R\u000e\u0010g\u001a\u00020hX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010i\u001a\u00020jX\u0082.¢\u0006\u0002\n\u0000¨\u0006¤\u0001"}, d2 = {"Lcom/bytedanceos/securitycenter/SafeCheckActivity;", "Lcom/bytedanceos/security/BaseActivity;", "()V", "baseBottomActionBarHeightPx", "", "baseBottomButtonMarginPx", "baseScrollPaddingBottomPx", "bottomActionBar", "Landroid/view/View;", "getBottomActionBar", "()Landroid/view/View;", "bottomActionBar$delegate", "Lkotlin/Lazy;", "btnBottom", "Lcom/obric/oui/button/OButton;", "getBtnBottom", "()Lcom/obric/oui/button/OButton;", "btnBottom$delegate", "btnCleanPrimary", "getBtnCleanPrimary", "btnCleanPrimary$delegate", "currentRiskApps", "", "Lcom/bytedanceos/securitycenter/scan/SafeCheckRiskAppItem;", "getCurrentRiskApps", "()Ljava/util/List;", "isScanFinished", "", "()Z", "isScanUiFinished", "panelContainer", "getPanelContainer", "panelContainer$delegate", "pendingScanResults", "Ltmsdk/common/module/qscanner/QScanResultEntity;", "getPendingScanResults", "pendingUninstallKeys", "", "", "getPendingUninstallKeys", "()Ljava/util/Set;", "resultStateText", "Landroid/widget/TextView;", "getResultStateText", "()Landroid/widget/TextView;", "resultStateText$delegate", "riskAppAdapter", "Lcom/bytedanceos/securitycenter/SafeCheckActivity$RiskAppSelectionAdapter;", "riskAppListCard", "getRiskAppListCard", "riskAppListCard$delegate", "riskAppRecyclerView", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "getRiskAppRecyclerView", "()Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "riskAppRecyclerView$delegate", "riskAppUseCase", "Lcom/bytedanceos/securitycenter/scan/SafeCheckRiskAppUseCase;", "getRiskAppUseCase", "()Lcom/bytedanceos/securitycenter/scan/SafeCheckRiskAppUseCase;", "riskAppUseCase$delegate", "riskCard", "Lcom/obric/oui/lisitem/OCardListItem;", "getRiskCard", "()Lcom/obric/oui/lisitem/OCardListItem;", "riskCard$delegate", "riskSectionTitle", "getRiskSectionTitle", "riskSectionTitle$delegate", "rotatePanelManager", "Lcom/obric/security/mainpage/view/RotatePannelManager2;", "rotatePanelStableContainer", "Landroid/view/ViewGroup;", "getRotatePanelStableContainer", "()Landroid/view/ViewGroup;", "rotatePanelStableContainer$delegate", "rotatePanelView", "Lcom/obric/security/mainpage/view/RotatePannelView2;", "getRotatePanelView", "()Lcom/obric/security/mainpage/view/RotatePannelView2;", "rotatePanelView$delegate", "safeCheckContainer", "getSafeCheckContainer", "safeCheckContainer$delegate", "safeCheckScroll", "getSafeCheckScroll", "safeCheckScroll$delegate", "scanSettingsRepository", "Lcom/bytedanceos/securitycenter/scan/ScanSettingsRepository;", "getScanSettingsRepository", "()Lcom/bytedanceos/securitycenter/scan/ScanSettingsRepository;", "scanSettingsRepository$delegate", "selectedRiskKeys", "getSelectedRiskKeys", "settingsBadge", "Lcom/obric/oui/badge/OBadgeDrawable;", "settingsBadgeAttached", "silentUninstallReceiver", "com/bytedanceos/securitycenter/SafeCheckActivity$silentUninstallReceiver$1", "Lcom/bytedanceos/securitycenter/SafeCheckActivity$silentUninstallReceiver$1;", "subtitleText", "getSubtitleText", "subtitleText$delegate", "uiState", "Lcom/bytedanceos/securitycenter/scan/SafeCheckUiState;", "viewModel", "Lcom/bytedanceos/securitycenter/SafeCheckViewModel;", "applyAlpha", "color", "alpha", "", "applyBottomNavigationInset", "", "navigationBarBottomInsetPx", "applyRotatePanelColor", "colorRes", "applyRotatePanelColorValue", "applyStablePanelSpacing", "cleanSelectedRiskApps", "configureBottomButtonWhite", "enabled", "configureCleanButtonPrimary", "finishScanAnimation", "allResults", "hideRotatePanelScanningContent", "inflateStableRotatePanel", "initBottomNavigationInsets", "initObservers", "initTitle", "launchUninstallConfirmation", "packageName", "resultIntent", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "onScanComplete", "packageInstallerStatusName", "status", "registerSilentUninstallReceiver", "removeCleanedRiskApps", "cleanedKeys", "renderScanResult", "riskApps", "renderScanResultIfReady", "resetScanResultUi", "restoreScanResult", "scene", "showCleanConfirmDialog", "showSafeResultState", "showScanResultOnly", "resultText", "showStopConfirmationDialog", "silentUninstallPackage", "startScanning", "updateBottomActionBarVisibility", "updateCleanButtonState", "updateSettingsBadge", "hasUpdate", "Companion", "RiskAppSelectionAdapter", "RiskAppViewHolder", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class SafeCheckActivity extends BaseActivity {
    private static final String ACTION_SILENT_UNINSTALL_RESULT = "com.bytedanceos.securitycenter.action.SILENT_UNINSTALL_RESULT";
    public static final Companion Companion = null;
    private static final String DANGER_RESULT_COLOR = "#FF850D";
    private static final String EXTRA_UNINSTALL_PACKAGE_NAME = "extra_uninstall_package_name";
    private static final float PANEL_TOP_PADDING_DP = 112.0f;
    private static final float RESULT_RING_ALPHA = 0.3f;
    private static final long RESULT_TEXT_START_DELAY_MS = 200;
    private static final float ROTATE_PANEL_SIZE_DP = 212.0f;
    private static final float SAFE_CHECK_PANEL_HEIGHT_DP = 242.0f;
    private static final int SCAN_COMPLETE_PROGRESS = 100;
    private static final String TAG = "SafeCheckActivity";
    private HashMap _$_findViewCache;
    private int baseBottomActionBarHeightPx;
    private int baseBottomButtonMarginPx;
    private int baseScrollPaddingBottomPx;
    private final Lazy bottomActionBar$delegate;
    private final Lazy btnBottom$delegate;
    private final Lazy btnCleanPrimary$delegate;
    private final Lazy panelContainer$delegate;
    private final Lazy resultStateText$delegate;
    private RiskAppSelectionAdapter riskAppAdapter;
    private final Lazy riskAppListCard$delegate;
    private final Lazy riskAppRecyclerView$delegate;
    private final Lazy riskAppUseCase$delegate;
    private final Lazy riskCard$delegate;
    private final Lazy riskSectionTitle$delegate;
    private RotatePannelManager2 rotatePanelManager;
    private final Lazy rotatePanelStableContainer$delegate;
    private final Lazy rotatePanelView$delegate;
    private final Lazy safeCheckContainer$delegate;
    private final Lazy safeCheckScroll$delegate;
    private final Lazy scanSettingsRepository$delegate;
    private OBadgeDrawable settingsBadge;
    private boolean settingsBadgeAttached;
    private final SafeCheckActivity$silentUninstallReceiver$1 silentUninstallReceiver;
    private final Lazy subtitleText$delegate;
    private SafeCheckUiState uiState;
    private SafeCheckViewModel viewModel;

    /* JADX INFO: compiled from: SafeCheckActivity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedanceos/securitycenter/SafeCheckActivity$Companion;", "", "()V", "ACTION_SILENT_UNINSTALL_RESULT", "", "DANGER_RESULT_COLOR", "EXTRA_UNINSTALL_PACKAGE_NAME", "PANEL_TOP_PADDING_DP", "", "RESULT_RING_ALPHA", "RESULT_TEXT_START_DELAY_MS", "", "ROTATE_PANEL_SIZE_DP", "SAFE_CHECK_PANEL_HEIGHT_DP", "SCAN_COMPLETE_PROGRESS", "", "TAG", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: compiled from: SafeCheckActivity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\tH\u0016J\u001c\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0016J\u001c\u0010\u000f\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\tH\u0016J\u0014\u0010\u0013\u001a\u00020\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedanceos/securitycenter/SafeCheckActivity$RiskAppSelectionAdapter;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedanceos/securitycenter/SafeCheckActivity$RiskAppViewHolder;", "Lcom/bytedanceos/securitycenter/SafeCheckActivity;", "(Lcom/bytedanceos/securitycenter/SafeCheckActivity;)V", "items", "", "Lcom/bytedanceos/securitycenter/scan/SafeCheckRiskAppItem;", "getCardPosition", "", "position", "getItemCount", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "submitList", "nextItems", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    private final class RiskAppSelectionAdapter extends RecyclerView.Adapter<RiskAppViewHolder> {
        private List<SafeCheckRiskAppItem> items;
        final /* synthetic */ SafeCheckActivity this$0;

        public RiskAppSelectionAdapter(SafeCheckActivity r1) {
            this.this$0 = r1;
            this.items = CollectionsKt.emptyList();
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
            onBindViewHolder((RiskAppViewHolder) r1, r2);
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
            return onCreateViewHolder(r1, r2);
        }

        public final void submitList(List<SafeCheckRiskAppItem> r2) {
            Intrinsics.checkNotNullParameter(r2, "nextItems");
            this.items = r2;
            notifyDataSetChanged();
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
        public RiskAppViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
            Intrinsics.checkNotNullParameter(r4, "parent");
            SafeCheckActivity r3 = this.this$0;
            View r6 = LayoutInflater.from(r4.getContext()).inflate(R.layout.risk_app_list_item, r4, false);
            Intrinsics.checkNotNullExpressionValue(r6, "LayoutInflater.from(pare…list_item, parent, false)");
            return new RiskAppViewHolder(r3, r6);
        }

        public void onBindViewHolder(RiskAppViewHolder r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "holder");
            r2.bind(this.items.get(r3), getCardPosition(r3));
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.items.size();
        }

        private final int getCardPosition(int r3) {
            if (getItemCount() == 1) goto L10;
            if (r3 != 0) goto L7;
            return 1;
        L7:
            if (r3 != (getItemCount() - 1)) goto L9;
            return 3;
        L9:
            return 2;
        L10:
            return 0;
        }
    }

    /* JADX INFO: compiled from: SafeCheckActivity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedanceos/securitycenter/SafeCheckActivity$RiskAppViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/bytedanceos/securitycenter/SafeCheckActivity;Landroid/view/View;)V", "card", "Lcom/obric/oui/lisitem/OCardListItem;", "checkBoxLayout", "Lcom/obric/oui/checkbox/OCheckBoxLayout;", "bind", "", "data", "Lcom/bytedanceos/securitycenter/scan/SafeCheckRiskAppItem;", "cardPosition", "", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    private final class RiskAppViewHolder extends RecyclerView.ViewHolder {
        private final OCardListItem card;
        private OCheckBoxLayout checkBoxLayout;
        final /* synthetic */ SafeCheckActivity this$0;

        public RiskAppViewHolder(SafeCheckActivity r2, View r3) {
            Intrinsics.checkNotNullParameter(r3, "itemView");
            this.this$0 = r2;
            super(r3);
            View r4 = r3.findViewById(R.id.risk_app_list_item_card);
            Intrinsics.checkNotNullExpressionValue(r4, "itemView.findViewById(co….risk_app_list_item_card)");
            this.card = (OCardListItem) r4;
        }

        public static final /* synthetic */ OCardListItem access$getCard$p(RiskAppViewHolder r0) {
            return r0.card;
        }

        public final void bind(final SafeCheckRiskAppItem r7, int r8) {
            Intrinsics.checkNotNullParameter(r7, "data");
            this.card.setDefaultCustomStartView(0);
            this.card.showCustomStart(true);
            View r0 = this.card.getCustomStartView();
            if ((r0 instanceof OCheckBoxLayout) == true) goto L5;
            r0 = null;
        L5:
            OCheckBoxLayout r1 = (OCheckBoxLayout) r0;
            this.checkBoxLayout = r1;
            if (r1 == null) goto L8;
            r1.setOnCheckedChangeListener(null);
        L8:
            OCheckBoxLayout r2 = this.checkBoxLayout;
            if (r2 == null) goto L11;
            r2.setChecked(SafeCheckActivity.access$getSelectedRiskKeys$p(this.this$0).contains(r7.getKey()));
        L11:
            OCheckBoxLayout r3 = this.checkBoxLayout;
            if (r3 == null) goto L14;
            r3.setOnCheckedChangeListener(new SafeCheckActivity$RiskAppViewHolder$bind$1(this, r7));
        L14:
            this.card.setTitle(r7.getAppInfo().getAppName());
            this.card.showTitle(true);
            OCardListItem r4 = this.card;
            SafeCheckActivity r5 = this.this$0;
            if (r7.isInstallationPackage() == false) goto L17;
            int r6 = R.string.install_package;
        L18:
            r4.setSubTitle(r5.getString(r6));
            this.card.showSubTitle(true);
            this.card.setDefaultTailIcon(0);
            this.card.showTailIcon(true);
            OCardListItem.setCardPosition$default(this.card, r8, false, 2, null);
            final View.OnClickListener r9 = new SafeCheckActivity$RiskAppViewHolder$bind$openDetail$1(this, r7);
            this.card.setOnContentClickListener(new SafeCheckActivity$RiskAppViewHolder$bind$2(this, r9));
            this.card.setOnClickListener(r9);
            this.itemView.setOnClickListener(r9);
            return;
        L17:
            r6 = R.string.installed_apps;
            goto L18
        }
    }

    /* JADX INFO: renamed from: com.bytedanceos.securitycenter.SafeCheckActivity$cleanSelectedRiskApps$2, reason: invalid class name */
    /* JADX INFO: compiled from: SafeCheckActivity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedanceos.securitycenter.SafeCheckActivity$cleanSelectedRiskApps$2", f = "SafeCheckActivity.kt", i = {}, l = {587}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef $apkApps;
        int label;
        final /* synthetic */ SafeCheckActivity this$0;

        AnonymousClass2(SafeCheckActivity r1, Ref.ObjectRef r2, Continuation r3) {
            this.this$0 = r1;
            this.$apkApps = r2;
            super(2, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Intrinsics.checkNotNullParameter(r3, "completion");
            return new AnonymousClass2(this.this$0, this.$apkApps, r3);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((AnonymousClass2) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L11:
            Set r6 = (Set) r5;
            if ((!r6.isEmpty()) == false) goto L15;
            SafeCheckActivity.access$removeCleanedRiskApps(this.this$0, r6);
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            CoroutineDispatcher r7 = Dispatchers.getIO();
            SafeCheckActivity$cleanSelectedRiskApps$2$cleanedKeys$1 r2 = new SafeCheckActivity$cleanSelectedRiskApps$2$cleanedKeys$1(this, null);
            this.label = 1;
            r5 = BuildersKt.withContext(r7, r2, this);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.bytedanceos.securitycenter.SafeCheckActivity$onScanComplete$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SafeCheckActivity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedanceos.securitycenter.SafeCheckActivity$onScanComplete$1", f = "SafeCheckActivity.kt", i = {}, l = {327}, m = "invokeSuspend", n = {}, s = {})
    static final class C01541 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List $allResults;
        int label;
        final /* synthetic */ SafeCheckActivity this$0;

        C01541(SafeCheckActivity r1, List r2, Continuation r3) {
            this.this$0 = r1;
            this.$allResults = r2;
            super(2, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Intrinsics.checkNotNullParameter(r3, "completion");
            return new C01541(this.this$0, this.$allResults, r3);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((C01541) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L11:
            SafeCheckActivity r4 = this.this$0;
            SafeCheckActivity.access$renderScanResult(r4, (List) r5);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            CoroutineDispatcher r6 = Dispatchers.getIO();
            SafeCheckActivity$onScanComplete$1$riskApps$1 r2 = new SafeCheckActivity$onScanComplete$1$riskApps$1(this, null);
            this.label = 1;
            r5 = BuildersKt.withContext(r6, r2, this);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.bytedanceos.securitycenter.SafeCheckActivity$removeCleanedRiskApps$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SafeCheckActivity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedanceos.securitycenter.SafeCheckActivity$removeCleanedRiskApps$1", f = "SafeCheckActivity.kt", i = {}, l = {HttpProbeResult.FAILED_RESPONSE_CODE}, m = "invokeSuspend", n = {}, s = {})
    static final class C01551 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Set $cleanedKeys;
        int label;
        final /* synthetic */ SafeCheckActivity this$0;

        /* JADX INFO: renamed from: com.bytedanceos.securitycenter.SafeCheckActivity$removeCleanedRiskApps$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: SafeCheckActivity.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
        @DebugMetadata(c = "com.bytedanceos.securitycenter.SafeCheckActivity$removeCleanedRiskApps$1$1", f = "SafeCheckActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C00301 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ C01551 this$0;

            C00301(C01551 r1, Continuation r2) {
                this.this$0 = r1;
                super(2, r2);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
                Intrinsics.checkNotNullParameter(r2, "completion");
                return new C00301(this.this$0, r2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return ((C00301) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r2);
                SafeCheckActivity.access$getRiskAppUseCase$p(this.this$0.this$0).deleteRecords(this.this$0.$cleanedKeys);
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        C01551(SafeCheckActivity r1, Set r2, Continuation r3) {
            this.this$0 = r1;
            this.$cleanedKeys = r2;
            super(2, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Intrinsics.checkNotNullParameter(r3, "completion");
            return new C01551(this.this$0, this.$cleanedKeys, r3);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((C01551) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r11);
        L11:
            SafeCheckActivity r12 = this.this$0;
            SafeCheckUiState r2 = SafeCheckActivity.access$getUiState$p(r12);
            List r3 = SafeCheckActivity.access$getCurrentRiskApps$p(this.this$0);
            ArrayList r4 = new ArrayList();
            Iterator r5 = r3.iterator();
        L13:
            if (r5.hasNext() == false) goto L17;
            Object r6 = r5.next();
            if (this.$cleanedKeys.contains(((SafeCheckRiskAppItem) r6).getKey()) == true) goto L13;
            r4.add(r6);
            goto L13
        L17:
            SafeCheckActivity.access$setUiState$p(r12, SafeCheckUiState.copy$default(r2, false, false, null, r4, null, SetsKt.minus(SafeCheckActivity.access$getSelectedRiskKeys$p(this.this$0), this.$cleanedKeys), null, 87, null));
            SafeCheckActivity.access$getRiskAppAdapter$p(this.this$0).submitList(SafeCheckActivity.access$getCurrentRiskApps$p(this.this$0));
            if (SafeCheckActivity.access$getCurrentRiskApps$p(this.this$0).isEmpty() == false) goto L21;
            SafeCheckActivity.access$showSafeResultState(this.this$0);
            return Unit.INSTANCE;
        L21:
            SafeCheckActivity.access$updateCleanButtonState(this.this$0);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r11);
            CoroutineDispatcher r13 = Dispatchers.getIO();
            C00301 r7 = new C00301(this, null);
            this.label = 1;
            if (BuildersKt.withContext(r13, r7, this) != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.bytedanceos.securitycenter.SafeCheckActivity$restoreScanResult$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SafeCheckActivity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedanceos.securitycenter.SafeCheckActivity$restoreScanResult$1", f = "SafeCheckActivity.kt", i = {}, l = {349}, m = "invokeSuspend", n = {}, s = {})
    static final class C01591 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List $allResults;
        int label;
        final /* synthetic */ SafeCheckActivity this$0;

        C01591(SafeCheckActivity r1, List r2, Continuation r3) {
            this.this$0 = r1;
            this.$allResults = r2;
            super(2, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Intrinsics.checkNotNullParameter(r3, "completion");
            return new C01591(this.this$0, this.$allResults, r3);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((C01591) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L11:
            SafeCheckActivity r4 = this.this$0;
            SafeCheckActivity.access$renderScanResult(r4, (List) r5);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            CoroutineDispatcher r6 = Dispatchers.getIO();
            SafeCheckActivity$restoreScanResult$1$riskApps$1 r2 = new SafeCheckActivity$restoreScanResult$1$riskApps$1(this, null);
            this.label = 1;
            r5 = BuildersKt.withContext(r6, r2, this);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    static {
        Companion = new Companion(null);
    }

    private final View getBottomActionBar() {
        return (View) this.bottomActionBar$delegate.getValue();
    }

    private final OButton getBtnBottom() {
        return (OButton) this.btnBottom$delegate.getValue();
    }

    private final OButton getBtnCleanPrimary() {
        return (OButton) this.btnCleanPrimary$delegate.getValue();
    }

    private final View getPanelContainer() {
        return (View) this.panelContainer$delegate.getValue();
    }

    private final TextView getResultStateText() {
        return (TextView) this.resultStateText$delegate.getValue();
    }

    private final View getRiskAppListCard() {
        return (View) this.riskAppListCard$delegate.getValue();
    }

    private final RecyclerView getRiskAppRecyclerView() {
        return (RecyclerView) this.riskAppRecyclerView$delegate.getValue();
    }

    private final SafeCheckRiskAppUseCase getRiskAppUseCase() {
        return (SafeCheckRiskAppUseCase) this.riskAppUseCase$delegate.getValue();
    }

    private final OCardListItem getRiskCard() {
        return (OCardListItem) this.riskCard$delegate.getValue();
    }

    private final TextView getRiskSectionTitle() {
        return (TextView) this.riskSectionTitle$delegate.getValue();
    }

    private final ViewGroup getRotatePanelStableContainer() {
        return (ViewGroup) this.rotatePanelStableContainer$delegate.getValue();
    }

    private final RotatePannelView2 getRotatePanelView() {
        return (RotatePannelView2) this.rotatePanelView$delegate.getValue();
    }

    private final View getSafeCheckContainer() {
        return (View) this.safeCheckContainer$delegate.getValue();
    }

    private final View getSafeCheckScroll() {
        return (View) this.safeCheckScroll$delegate.getValue();
    }

    private final ScanSettingsRepository getScanSettingsRepository() {
        return (ScanSettingsRepository) this.scanSettingsRepository$delegate.getValue();
    }

    private final TextView getSubtitleText() {
        return (TextView) this.subtitleText$delegate.getValue();
    }

    private final String packageInstallerStatusName(int r1) {
        switch(r1) {
            case -1: goto L12;
            case 0: goto L11;
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L5;
            case 7: goto L4;
            default: goto L3;
        };
    L3:
        return NetworkStackConstant.UNKNOWN_TYPE;
    L4:
        return "STATUS_FAILURE_INCOMPATIBLE";
    L5:
        return "STATUS_FAILURE_STORAGE";
    L6:
        return "STATUS_FAILURE_CONFLICT";
    L7:
        return "STATUS_FAILURE_INVALID";
    L8:
        return "STATUS_FAILURE_ABORTED";
    L9:
        return "STATUS_FAILURE_BLOCKED";
    L10:
        return "STATUS_FAILURE";
    L11:
        return "STATUS_SUCCESS";
    L12:
        return "STATUS_PENDING_USER_ACTION";
    }

    public void _$_clearFindViewByIdCache() {
        HashMap r0 = this._$_findViewCache;
        if (r0 == null) goto L6;
        r0.clear();
        return;
    }

    public View _$_findCachedViewById(int r3) {
        if (this._$_findViewCache != null) goto L5;
        this._$_findViewCache = new HashMap();
    L5:
        View r0 = (View) this._$_findViewCache.get(Integer.valueOf(r3));
        if (r0 != null) goto L9;
        View r1 = findViewById(r3);
        this._$_findViewCache.put(Integer.valueOf(r3), r1);
        return r1;
    L9:
        return r0;
    }

    @Override // com.bytedanceos.security.BaseActivity
    public String scene() {
        return "safe_check_page";
    }

    /* JADX WARN: Type inference failed for: r0v35, types: [com.bytedanceos.securitycenter.SafeCheckActivity$silentUninstallReceiver$1] */
    public SafeCheckActivity() {
        this.rotatePanelView$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new SafeCheckActivity$rotatePanelView$2(this));
        this.subtitleText$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new SafeCheckActivity$subtitleText$2(this));
        this.safeCheckContainer$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new SafeCheckActivity$safeCheckContainer$2(this));
        this.panelContainer$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new SafeCheckActivity$panelContainer$2(this));
        this.rotatePanelStableContainer$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new SafeCheckActivity$rotatePanelStableContainer$2(this));
        this.resultStateText$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new SafeCheckActivity$resultStateText$2(this));
        this.riskCard$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new SafeCheckActivity$riskCard$2(this));
        this.riskSectionTitle$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new SafeCheckActivity$riskSectionTitle$2(this));
        this.riskAppListCard$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new SafeCheckActivity$riskAppListCard$2(this));
        this.riskAppRecyclerView$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new SafeCheckActivity$riskAppRecyclerView$2(this));
        this.safeCheckScroll$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new SafeCheckActivity$safeCheckScroll$2(this));
        this.bottomActionBar$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new SafeCheckActivity$bottomActionBar$2(this));
        this.btnBottom$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new SafeCheckActivity$btnBottom$2(this));
        this.btnCleanPrimary$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new SafeCheckActivity$btnCleanPrimary$2(this));
        this.riskAppUseCase$delegate = LazyKt.lazy(new SafeCheckActivity$riskAppUseCase$2(this));
        this.scanSettingsRepository$delegate = LazyKt.lazy(new SafeCheckActivity$scanSettingsRepository$2(this));
        this.uiState = new SafeCheckUiState(false, false, null, null, null, null, null, 127, null);
        this.silentUninstallReceiver = new SafeCheckActivity$silentUninstallReceiver$1(this);
    }

    public static final /* synthetic */ void access$applyBottomNavigationInset(SafeCheckActivity r0, int r1) {
        r0.applyBottomNavigationInset(r1);
    }

    public static final /* synthetic */ void access$applyRotatePanelColorValue(SafeCheckActivity r0, int r1) {
        r0.applyRotatePanelColorValue(r1);
    }

    public static final /* synthetic */ void access$cleanSelectedRiskApps(SafeCheckActivity r0) {
        r0.cleanSelectedRiskApps();
    }

    public static final /* synthetic */ void access$finishScanAnimation(SafeCheckActivity r0, List r1) {
        r0.finishScanAnimation(r1);
    }

    public static final /* synthetic */ List access$getCurrentRiskApps$p(SafeCheckActivity r0) {
        return r0.getCurrentRiskApps();
    }

    public static final /* synthetic */ Set access$getPendingUninstallKeys$p(SafeCheckActivity r0) {
        return r0.getPendingUninstallKeys();
    }

    public static final /* synthetic */ TextView access$getResultStateText$p(SafeCheckActivity r0) {
        return r0.getResultStateText();
    }

    public static final /* synthetic */ RiskAppSelectionAdapter access$getRiskAppAdapter$p(SafeCheckActivity r1) {
        RiskAppSelectionAdapter r2 = r1.riskAppAdapter;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("riskAppAdapter");
    L5:
        return r2;
    }

    public static final /* synthetic */ SafeCheckRiskAppUseCase access$getRiskAppUseCase$p(SafeCheckActivity r0) {
        return r0.getRiskAppUseCase();
    }

    public static final /* synthetic */ OCardListItem access$getRiskCard$p(SafeCheckActivity r0) {
        return r0.getRiskCard();
    }

    public static final /* synthetic */ RotatePannelManager2 access$getRotatePanelManager$p(SafeCheckActivity r1) {
        RotatePannelManager2 r2 = r1.rotatePanelManager;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rotatePanelManager");
    L5:
        return r2;
    }

    public static final /* synthetic */ ViewGroup access$getRotatePanelStableContainer$p(SafeCheckActivity r0) {
        return r0.getRotatePanelStableContainer();
    }

    public static final /* synthetic */ RotatePannelView2 access$getRotatePanelView$p(SafeCheckActivity r0) {
        return r0.getRotatePanelView();
    }

    public static final /* synthetic */ Set access$getSelectedRiskKeys$p(SafeCheckActivity r0) {
        return r0.getSelectedRiskKeys();
    }

    public static final /* synthetic */ TextView access$getSubtitleText$p(SafeCheckActivity r0) {
        return r0.getSubtitleText();
    }

    public static final /* synthetic */ SafeCheckUiState access$getUiState$p(SafeCheckActivity r0) {
        return r0.uiState;
    }

    public static final /* synthetic */ SafeCheckViewModel access$getViewModel$p(SafeCheckActivity r1) {
        SafeCheckViewModel r2 = r1.viewModel;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        return r2;
    }

    public static final /* synthetic */ void access$hideRotatePanelScanningContent(SafeCheckActivity r0) {
        r0.hideRotatePanelScanningContent();
    }

    public static final /* synthetic */ boolean access$isScanFinished$p(SafeCheckActivity r0) {
        return r0.isScanFinished();
    }

    public static final /* synthetic */ boolean access$isScanUiFinished$p(SafeCheckActivity r0) {
        return r0.isScanUiFinished();
    }

    public static final /* synthetic */ void access$launchUninstallConfirmation(SafeCheckActivity r0, String r1, Intent r2) {
        r0.launchUninstallConfirmation(r1, r2);
    }

    public static final /* synthetic */ String access$packageInstallerStatusName(SafeCheckActivity r0, int r1) {
        return r0.packageInstallerStatusName(r1);
    }

    public static final /* synthetic */ void access$removeCleanedRiskApps(SafeCheckActivity r0, Set r1) {
        r0.removeCleanedRiskApps(r1);
    }

    public static final /* synthetic */ void access$renderScanResult(SafeCheckActivity r0, List r1) {
        r0.renderScanResult(r1);
    }

    public static final /* synthetic */ void access$renderScanResultIfReady(SafeCheckActivity r0) {
        r0.renderScanResultIfReady();
    }

    public static final /* synthetic */ void access$resetScanResultUi(SafeCheckActivity r0) {
        r0.resetScanResultUi();
    }

    public static final /* synthetic */ void access$setRiskAppAdapter$p(SafeCheckActivity r0, RiskAppSelectionAdapter r1) {
        r0.riskAppAdapter = r1;
    }

    public static final /* synthetic */ void access$setRotatePanelManager$p(SafeCheckActivity r0, RotatePannelManager2 r1) {
        r0.rotatePanelManager = r1;
    }

    public static final /* synthetic */ void access$setUiState$p(SafeCheckActivity r0, SafeCheckUiState r1) {
        r0.uiState = r1;
    }

    public static final /* synthetic */ void access$setViewModel$p(SafeCheckActivity r0, SafeCheckViewModel r1) {
        r0.viewModel = r1;
    }

    public static final /* synthetic */ void access$showCleanConfirmDialog(SafeCheckActivity r0) {
        r0.showCleanConfirmDialog();
    }

    public static final /* synthetic */ void access$showSafeResultState(SafeCheckActivity r0) {
        r0.showSafeResultState();
    }

    public static final /* synthetic */ void access$showStopConfirmationDialog(SafeCheckActivity r0) {
        r0.showStopConfirmationDialog();
    }

    public static final /* synthetic */ void access$updateCleanButtonState(SafeCheckActivity r0) {
        r0.updateCleanButtonState();
    }

    public static final /* synthetic */ void access$updateSettingsBadge(SafeCheckActivity r0, boolean r1) {
        r0.updateSettingsBadge(r1);
    }

    private final boolean isScanFinished() {
        return this.uiState.isScanFinished();
    }

    private final boolean isScanUiFinished() {
        return this.uiState.isScanUiFinished();
    }

    private final List<QScanResultEntity> getPendingScanResults() {
        return this.uiState.getPendingScanResults();
    }

    private final List<SafeCheckRiskAppItem> getCurrentRiskApps() {
        return this.uiState.getRiskApps();
    }

    private final Set<String> getSelectedRiskKeys() {
        return this.uiState.getSelectedRiskKeys();
    }

    private final Set<String> getPendingUninstallKeys() {
        return this.uiState.getPendingUninstallKeys();
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r3) {
        super.onCreate(r3);
        setContentView(R.layout.activity_safe_check);
        applyStablePanelSpacing();
        inflateStableRotatePanel();
        RotatePannelManager2 r4 = new RotatePannelManager2(getRotatePanelView());
        this.rotatePanelManager = r4;
        r4.setRotateListener(new C01531(this));
        ViewGroup r5 = getRotatePanelView().getScoreGroup();
        if (r5 == null) goto L5;
        r5.setOnClickListener(null);
    L5:
        registerSilentUninstallReceiver();
        initBottomNavigationInsets();
        this.riskAppAdapter = new RiskAppSelectionAdapter(this);
        RecyclerView r6 = getRiskAppRecyclerView();
        r6.setLayoutManager(new LinearLayoutManager(this));
        RiskAppSelectionAdapter r0 = this.riskAppAdapter;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("riskAppAdapter");
    L8:
        r6.setAdapter(r0);
        r6.setHasFixedSize(false);
        this.viewModel = (SafeCheckViewModel) new ViewModelProvider(this).get(SafeCheckViewModel.class);
        initTitle();
        initObservers();
        SafeCheckViewModel r7 = this.viewModel;
        if (r7 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L11:
        ScanState r8 = r7.getScanState().getValue();
        if ((r8 instanceof ScanState.Finished) == false) goto L15;
        restoreScanResult(((ScanState.Finished) r8).getAllResults());
    L18:
        SafeCheckViewModel r2 = this.viewModel;
        if (r2 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L21:
        r2.checkVirusDbUpdate();
        return;
    L15:
        if ((r8 instanceof ScanState.Error) == false) goto L17;
        restoreScanResult(CollectionsKt.emptyList());
        goto L18
    L17:
        startScanning();
        goto L18
    }

    private final void applyStablePanelSpacing() {
        SafeCheckActivity r3 = this;
        getSafeCheckScroll().setPadding(getSafeCheckScroll().getPaddingLeft(), DisplaySizeStableContext.INSTANCE.dpToPx(r3, PANEL_TOP_PADDING_DP), getSafeCheckScroll().getPaddingRight(), getSafeCheckScroll().getPaddingBottom());
        View r0 = getPanelContainer();
        ViewGroup.LayoutParams r1 = getPanelContainer().getLayoutParams();
        r1.height = DisplaySizeStableContext.INSTANCE.dpToPx(r3, SAFE_CHECK_PANEL_HEIGHT_DP);
        Unit r2 = Unit.INSTANCE;
        r0.setLayoutParams(r1);
        ViewGroup r4 = getRotatePanelStableContainer();
        ViewGroup.LayoutParams r6 = getRotatePanelStableContainer().getLayoutParams();
        r6.width = DisplaySizeStableContext.INSTANCE.dpToPx(r3, ROTATE_PANEL_SIZE_DP);
        r6.height = DisplaySizeStableContext.INSTANCE.dpToPx(r3, ROTATE_PANEL_SIZE_DP);
        Unit r5 = Unit.INSTANCE;
        r4.setLayoutParams(r6);
    }

    private final void inflateStableRotatePanel() {
        View r0 = getRotatePanelStableContainer().findViewById(R.id.main_rotate_pannel);
        if (r0 == null) goto L5;
        getRotatePanelStableContainer().removeView(r0);
    L5:
        View r1 = LayoutInflater.from(DisplaySizeStableContext.INSTANCE.create(this)).inflate(R.layout.rotate_pannel_view, getRotatePanelStableContainer(), false);
        getRotatePanelStableContainer().addView(r1, 0);
    }

    private final void initBottomNavigationInsets() {
        this.baseScrollPaddingBottomPx = getSafeCheckScroll().getPaddingBottom();
        this.baseBottomActionBarHeightPx = getBottomActionBar().getLayoutParams().height;
        ViewGroup.LayoutParams r0 = getBtnBottom().getLayoutParams();
        if (r0 == null) goto L7;
        this.baseBottomButtonMarginPx = ((ViewGroup.MarginLayoutParams) r0).bottomMargin;
        ViewCompat.setOnApplyWindowInsetsListener(getSafeCheckContainer(), new C01481(this));
        ViewCompat.requestApplyInsets(getSafeCheckContainer());
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    private final void applyBottomNavigationInset(int r6) {
        View r0 = getSafeCheckScroll();
        r0.setPadding(r0.getPaddingLeft(), r0.getPaddingTop(), r0.getPaddingRight(), this.baseScrollPaddingBottomPx + r6);
        View r1 = getBottomActionBar();
        ViewGroup.LayoutParams r2 = getBottomActionBar().getLayoutParams();
        r2.height = this.baseBottomActionBarHeightPx + r6;
        Unit r3 = Unit.INSTANCE;
        r1.setLayoutParams(r2);
        Iterator r4 = CollectionsKt.listOf(new OButton[]{getBtnBottom(), getBtnCleanPrimary()}).iterator();
    L4:
        if (r4.hasNext() == false) goto L10;
        OButton r5 = (OButton) r4.next();
        ViewGroup.LayoutParams r7 = r5.getLayoutParams();
        if (r7 == null) goto L9;
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) r7;
        r8.bottomMargin = this.baseBottomButtonMarginPx + r6;
        r5.setLayoutParams(r8);
        goto L4
    L9:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    private final void initTitle() {
        initTitleBar(false, false);
        this.mTitle.setCenterTitle(getString(R.string.safe_check));
        this.mTitle.addEndAction(R.drawable.controled_icon, -1, new ViewOnClickListenerC01511(this));
        this.mTitle.addEndAction(R.drawable.oic_disturb_settings, -1, new ViewOnClickListenerC01522(this));
    }

    private final void startScanning() {
        this.uiState = new SafeCheckUiState(false, false, null, null, null, null, null, 127, null);
        RotatePannelManager2 r0 = this.rotatePanelManager;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rotatePanelManager");
    L5:
        r0.setScanResultRingColor(null);
        getRiskSectionTitle().setVisibility(8);
        getRiskAppListCard().setVisibility(8);
        getRiskCard().setVisibility(0);
        getResultStateText().setVisibility(8);
        getBtnBottom().setVisibility(0);
        getBtnCleanPrimary().setVisibility(8);
        getBtnBottom().setText(getString(R.string.stop_scanning));
        configureBottomButtonWhite(true);
        getBtnBottom().setOnClickListener(new ViewOnClickListenerC01631(this));
        updateBottomActionBarVisibility();
        applyRotatePanelColor(R.color.oui_functional_blue_6);
        RotatePannelManager2 r3 = this.rotatePanelManager;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("rotatePanelManager");
    L8:
        r3.setMaxScore(100);
        RotatePannelManager2 r4 = this.rotatePanelManager;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("rotatePanelManager");
    L11:
        r4.startScan(true);
        View r1 = LayoutInflater.from(this).inflate(R.layout.layout_small_loading, null);
        getRiskCard().setCustomEndView(r1);
        getRiskCard().showCustomEnd(true);
        getRiskCard().showTailIcon(false);
        getRiskCard().setSubTitle(getString(R.string.safe_check_scan_initializing));
        getRiskCard().showSubTitle(true);
        boolean r2 = getScanSettingsRepository().isCloudScanEnabled();
        SafeCheckViewModel r11 = this.viewModel;
        if (r11 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L14:
        r11.startScan(r2);
    }

    private final void initObservers() {
        SafeCheckViewModel r0 = this.viewModel;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        SafeCheckActivity r2 = this;
        r0.getVirusDbUpdateAvailable().observe(r2, new C01491(this));
        SafeCheckViewModel r1 = this.viewModel;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L8:
        r1.getScanState().observe(r2, new C01502(this));
    }

    private final void finishScanAnimation(List<? extends QScanResultEntity> r11) {
        this.uiState = SafeCheckUiState.copy$default(this.uiState, false, false, r11, null, null, null, null, 123, null);
        RotatePannelManager2 r12 = this.rotatePanelManager;
        if (r12 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rotatePanelManager");
    L5:
        r12.finishScanToScore(100, false, false);
        renderScanResultIfReady();
    }

    private final void renderScanResultIfReady() {
        List<QScanResultEntity> r0 = getPendingScanResults();
        if (r0 != null) goto L6;
        return;
    L6:
        if (isScanUiFinished() == true) goto L8;
        return;
    L8:
        this.uiState = SafeCheckUiState.copy$default(this.uiState, false, false, null, null, null, null, null, 123, null);
        onScanComplete(r0);
    }

    private final void onScanComplete(List<? extends QScanResultEntity> r12) {
        if (isScanFinished() == false) goto L5;
        return;
    L5:
        this.uiState = SafeCheckUiState.copy$default(this.uiState, true, false, null, null, null, null, null, 126, null);
        getRiskCard().showCustomEnd(false);
        getRiskCard().showTailIcon(true);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C01541(this, r12, null), 3, null);
    }

    private final void restoreScanResult(List<? extends QScanResultEntity> r11) {
        this.uiState = SafeCheckUiState.copy$default(this.uiState, true, true, null, null, null, null, null, 124, null);
        getRiskCard().setVisibility(8);
        getResultStateText().setVisibility(8);
        getBtnBottom().setVisibility(8);
        getBtnCleanPrimary().setVisibility(8);
        updateBottomActionBarVisibility();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C01591(this, r11, null), 3, null);
    }

    private final void renderScanResult(List<SafeCheckRiskAppItem> r15) {
        int r0 = r15.size();
        if (r0 != 0) goto L6;
        showSafeResultState();
        return;
    L6:
        int r1 = Color.parseColor(DANGER_RESULT_COLOR);
        String r2 = getString(R.string.danger);
        Intrinsics.checkNotNullExpressionValue(r2, "getString(com.obric.safecheck.R.string.danger)");
        showScanResultOnly(r1, r2);
        getSubtitleText().setVisibility(4);
        getSubtitleText().setTextColor(r1);
        getSubtitleText().setText(getString(R.string.detected_risk_apps_handle, new Object[]{Integer.valueOf(r0)}));
        getSubtitleText().postDelayed(new RunnableC01561(this), 200);
        getRiskCard().setVisibility(8);
        getRiskSectionTitle().setVisibility(0);
        getRiskAppListCard().setVisibility(0);
        SafeCheckUiState r4 = this.uiState;
        List<SafeCheckRiskAppItem> r3 = r15;
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator<T> r6 = r3.iterator();
    L8:
        if (r6.hasNext() == false) goto L10;
        r5.add(((SafeCheckRiskAppItem) r6.next()).getKey());
        goto L8
    L10:
        this.uiState = SafeCheckUiState.copy$default(r4, false, false, null, r15, null, (Set) CollectionsKt.toCollection(r5, new LinkedHashSet()), null, 87, null);
        RiskAppSelectionAdapter r7 = this.riskAppAdapter;
        if (r7 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("riskAppAdapter");
    L13:
        r7.submitList(r15);
        getBtnBottom().setVisibility(8);
        getBtnCleanPrimary().setVisibility(0);
        getBtnCleanPrimary().setText(getString(R.string.one_key_clean));
        updateCleanButtonState();
        getBtnCleanPrimary().setOnClickListener(new ViewOnClickListenerC01573(this));
        updateBottomActionBarVisibility();
    }

    private final void resetScanResultUi() {
        this.uiState = new SafeCheckUiState(false, false, null, null, null, null, null, 127, null);
        RiskAppSelectionAdapter r0 = this.riskAppAdapter;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("riskAppAdapter");
    L5:
        r0.submitList(CollectionsKt.emptyList());
        getRiskSectionTitle().setVisibility(8);
        getRiskAppListCard().setVisibility(8);
        getRiskCard().setVisibility(0);
        getResultStateText().setVisibility(8);
        getSubtitleText().setVisibility(8);
        getBtnBottom().setVisibility(0);
        getBtnCleanPrimary().setVisibility(8);
        getBtnBottom().setText(getString(R.string.stop_scanning));
        configureBottomButtonWhite(true);
        getBtnBottom().setOnClickListener(new ViewOnClickListenerC01581(this));
        updateBottomActionBarVisibility();
    }

    private final void showSafeResultState() {
        int r0 = getColor(R.color.oui_functional_green_6);
        String r1 = getString(R.string.safe);
        Intrinsics.checkNotNullExpressionValue(r1, "getString(com.obric.safecheck.R.string.safe)");
        showScanResultOnly(r0, r1);
        getSubtitleText().setVisibility(4);
        getSubtitleText().setTextColor(r0);
        getSubtitleText().setText(getString(R.string.no_security_risk));
        getSubtitleText().postDelayed(new RunnableC01601(this), 200);
        this.uiState = SafeCheckUiState.copy$default(this.uiState, false, false, null, CollectionsKt.emptyList(), null, SetsKt.emptySet(), SetsKt.emptySet(), 23, null);
        RiskAppSelectionAdapter r2 = this.riskAppAdapter;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("riskAppAdapter");
    L5:
        r2.submitList(CollectionsKt.emptyList());
        getRiskCard().setVisibility(8);
        getRiskSectionTitle().setVisibility(8);
        getRiskAppListCard().setVisibility(8);
        getBtnBottom().setVisibility(0);
        getBtnCleanPrimary().setVisibility(8);
        getBtnBottom().setText(getString(R.string.done));
        configureBottomButtonWhite(true);
        getBtnBottom().setOnClickListener(new ViewOnClickListenerC01612(this));
        updateBottomActionBarVisibility();
    }

    private final void applyRotatePanelColor(int r1) {
        applyRotatePanelColorValue(getColor(r1));
    }

    private final void applyRotatePanelColorValue(int r2) {
        getRotatePanelView().setRotatingDialColor(r2);
        GlowDotRingProg r0 = getRotatePanelView().getProgressBar();
        if (r0 == null) goto L5;
        r0.setDotColor(r2);
    L5:
        ScrollingNumbersView r1 = getRotatePanelView().getProgressNumberView();
        if (r1 == null) goto L8;
        r1.setPaintColor(r2);
    L8:
        ScrollingNumbersView r3 = getRotatePanelView().getProgressNumberView();
        if (r3 == null) goto L11;
        r3.invalidate();
    L11:
        ScrollingNumbersView r4 = getRotatePanelView().getScoreNumberView();
        if (r4 == null) goto L14;
        r4.setPaintColor(r2);
    L14:
        ScrollingNumbersView r5 = getRotatePanelView().getScoreNumberView();
        if (r5 == null) goto L17;
        r5.invalidate();
    L17:
        ScrollingNumbersView r6 = getRotatePanelView().getScoreNumberFullView();
        if (r6 == null) goto L20;
        r6.setPaintColor(r2);
    L20:
        ScrollingNumbersView r7 = getRotatePanelView().getScoreNumberFullView();
        if (r7 == null) goto L23;
        r7.invalidate();
    L23:
        TextView r8 = getRotatePanelView().getScanningText();
        if (r8 == null) goto L26;
        r8.setTextColor(r2);
    L26:
        TextView r9 = getRotatePanelView().getScoreText();
        if (r9 == null) goto L30;
        r9.setTextColor(r2);
        return;
    }

    private final void showScanResultOnly(final int r11, final String r12) {
        this.uiState = SafeCheckUiState.copy$default(this.uiState, false, false, null, null, new SafeCheckUiState.ResultState(r11, r12), null, null, 111, null);
        final int r0 = applyAlpha(r11, 0.3f);
        RotatePannelManager2 r1 = this.rotatePanelManager;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rotatePanelManager");
    L5:
        r1.setScanResultRingColor(Integer.valueOf(r0));
        getRotatePanelView().post(new RunnableC01621(this, r11, r0, r12));
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (isScanFinished() == false) goto L7;
        SafeCheckUiState.ResultState r0 = this.uiState.getResultState();
        if (r0 == null) goto L7;
        showScanResultOnly(r0.getColor(), r0.getText());
    L7:
        SafeCheckViewModel r2 = this.viewModel;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L10:
        r2.refreshVirusDbBadge();
    }

    private final void updateSettingsBadge(boolean r11) {
        OButtonGroup r0 = this.mTitle.getEndButtonGroup();
        if (r11 == true) goto L5;
        OBadgeDrawable r12 = this.settingsBadge;
        if (r12 != null) goto L15;
        return;
    L15:
        if (this.settingsBadgeAttached == true) goto L17;
        return;
    L17:
        OBadgeAttachUtils.detachBadgeDrawable(r12, r0, this.mTitle);
        this.settingsBadgeAttached = false;
        return;
    L5:
        if (this.settingsBadgeAttached == false) goto L7;
        return;
    L7:
        OBadgeDrawable r13 = this.settingsBadge;
        if (r13 != null) goto L10;
        r13 = OBadgeDrawable.Companion.create(this);
        r13.setBadgeGravity(OBadgeDrawable.BadgeGravity.TOP_END);
        r13.setHorizontalOffset(MathKt.roundToInt(TypedValue.applyDimension(1, -5, Resources.getSystem().getDisplayMetrics())));
        r13.setVerticalOffset(MathKt.roundToInt(TypedValue.applyDimension(1, 5, Resources.getSystem().getDisplayMetrics())));
        this.settingsBadge = r13;
    L10:
        OBadgeAttachUtils.attachBadgeDrawable$default(r13, r0, this.mTitle, null, null, 24, null);
        this.settingsBadgeAttached = true;
    }

    private final int applyAlpha(int r2, float r3) {
        return Color.argb((int) (Color.alpha(r2) * r3), Color.red(r2), Color.green(r2), Color.blue(r2));
    }

    private final void updateBottomActionBarVisibility() {
        View r0 = getBottomActionBar();
        if (getBtnBottom().getVisibility() != 0) goto L5;
    L8:
        int r2 = 0;
    L9:
        r0.setVisibility(r2);
        return;
    L5:
        if (getBtnCleanPrimary().getVisibility() == 0) goto L8;
        r2 = 8;
        goto L9
    }

    private final void configureBottomButtonWhite(boolean r1) {
        getBtnBottom().setEnabled(r1);
    }

    private final void updateCleanButtonState() {
        boolean r1 = true;
        if ((!getSelectedRiskKeys().isEmpty()) == true) goto L5;
    L7:
        r1 = false;
    L8:
        getBtnBottom().setEnabled(r1);
        configureBottomButtonWhite(r1);
        configureCleanButtonPrimary(r1);
        return;
    L5:
        if (getPendingUninstallKeys().isEmpty() == false) goto L7;
        goto L7
    }

    private final void configureCleanButtonPrimary(boolean r1) {
        getBtnCleanPrimary().setEnabled(r1);
    }

    private final void showCleanConfirmDialog() {
        List<SafeCheckRiskAppItem> r1 = getCurrentRiskApps();
        ArrayList r2 = new ArrayList();
        Iterator<T> r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        Object r4 = r3.next();
        if (getSelectedRiskKeys().contains(((SafeCheckRiskAppItem) r4).getKey()) == false) goto L4;
        r2.add(r4);
        goto L4
    L8:
        ArrayList r5 = r2;
        if (r5.isEmpty() == false) goto L12;
        updateCleanButtonState();
        return;
    L12:
        int r6 = r5.size();
        ArrayList r7 = r5;
        ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r9 = r7.iterator();
    L14:
        if (r9.hasNext() == false) goto L16;
        r8.add(((SafeCheckRiskAppItem) r9.next()).getAppInfo().getAppName());
        goto L14
    L16:
        ArrayList r10 = r8;
        if (r6 != 1) goto L19;
        String r11 = getString(R.string.safe_check_clean_single_app_title, new Object[]{CollectionsKt.first(r10)});
        Intrinsics.checkNotNullExpressionValue(r11, "getString(R.string.safe_…_title, appNames.first())");
        String r12 = getString(R.string.safe_check_clean_single_app_message);
        Intrinsics.checkNotNullExpressionValue(r12, "getString(R.string.safe_…clean_single_app_message)");
    L20:
        OAlertDialogBuilder r13 = OAlertDialogBuilder.title$default(new OAlertDialogBuilder(this), r11, false, 2, null).message(r12).horizontalButton(true);
        String r14 = getString(R.string.clear_text);
        Intrinsics.checkNotNullExpressionValue(r14, "getString(R.string.clear_text)");
        OAlertDialogBuilder r15 = r13.positiveButton(r14, new SafeCheckActivity$showCleanConfirmDialog$builder$1(this));
        String r0 = getString(R.string.cancel);
        Intrinsics.checkNotNullExpressionValue(r0, "getString(R.string.cancel)");
        r15.negativeButton(r0, SafeCheckActivity$showCleanConfirmDialog$builder$2.INSTANCE).build().show();
        return;
    L19:
        String r16 = getString(R.string.safe_check_clean_multiple_apps_title, new Object[]{Integer.valueOf(r6)});
        Intrinsics.checkNotNullExpressionValue(r16, "getString(R.string.safe_…pps_title, selectedCount)");
        ArrayList r17 = r10;
        String r18 = getString(R.string.safe_check_app_name_separator);
        Intrinsics.checkNotNullExpressionValue(r18, "getString(R.string.safe_check_app_name_separator)");
        r12 = getString(R.string.safe_check_clean_multiple_apps_message, new Object[]{CollectionsKt.joinToString$default(r17, r18, null, null, 0, null, null, 62, null), Integer.valueOf(r6)});
        Intrinsics.checkNotNullExpressionValue(r12, "getString(\n             …ectedCount,\n            )");
        r11 = r16;
        goto L20
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.util.List] */
    private final void cleanSelectedRiskApps() {
        Ref.ObjectRef r0 = new Ref.ObjectRef();
        SafeCheckRiskAppUseCase.CleanTargets r1 = getRiskAppUseCase().buildCleanTargets(getCurrentRiskApps(), getSelectedRiskKeys());
        r0.element = r1.component1();
        Iterator<T> r2 = r1.component2().iterator();
    L4:
        if (r2.hasNext() == false) goto L14;
        SafeCheckRiskAppItem r3 = (SafeCheckRiskAppItem) r2.next();
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L8
        SafeCheckActivity r5 = this;     // Catch: Throwable -> L8
        silentUninstallPackage(r3.getKey());     // Catch: Throwable -> L8
        Object r6 = Result.m774constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r7 = Result.m777exceptionOrNullimpl(r6);
        if (r7 == null) goto L4;
        this.uiState = SafeCheckUiState.copy$default(this.uiState, false, false, null, null, null, null, SetsKt.minus(getPendingUninstallKeys(), r3.getKey()), 63, null);
        Log.w(TAG, "Failed to request silent uninstall: package=" + r3.getKey(), r7);
        updateCleanButtonState();
    L8:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L10
    L14:
        if (((List) r0.element).isEmpty() == false) goto L16;
        return;
    L16:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass2(this, r0, null), 3, null);
    }

    private final void removeCleanedRiskApps(Set<String> r8) {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C01551(this, r8, null), 3, null);
    }

    private final void silentUninstallPackage(String r12) {
        this.uiState = SafeCheckUiState.copy$default(this.uiState, false, false, null, null, null, null, SetsKt.plus(getPendingUninstallKeys(), r12), 63, null);
        updateCleanButtonState();
        if (getRiskAppUseCase().isPackageInstalled(r12) == true) goto L6;
        this.uiState = SafeCheckUiState.copy$default(this.uiState, false, false, null, null, null, null, SetsKt.minus(getPendingUninstallKeys(), r12), 63, null);
        Log.w(TAG, "Skip silent uninstall because package is not installed: package=" + r12);
        updateCleanButtonState();
        return;
    L6:
        Intent r0 = new Intent(ACTION_SILENT_UNINSTALL_RESULT);
        Context r1 = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(r1, "applicationContext");
        Intent r2 = r0.setPackage(r1.getPackageName()).putExtra(EXTRA_UNINSTALL_PACKAGE_NAME, r12);
        Intrinsics.checkNotNullExpressionValue(r2, "Intent(ACTION_SILENT_UNI…ACKAGE_NAME, packageName)");
        if (Build.VERSION.SDK_INT < 31) goto L9;
        int r3 = 33554432;
    L10:
        PendingIntent r4 = PendingIntent.getBroadcast(this, r12.hashCode(), r2, r3 | 134217728);
        Intrinsics.checkNotNullExpressionValue(r4, "pendingIntent");
        IntentSender r5 = r4.getIntentSender();
        Intrinsics.checkNotNullExpressionValue(r5, "pendingIntent.intentSender");
        getRiskAppUseCase().requestInstalledUninstall(r12, r5);
        return;
    L9:
        r3 = 0;
        goto L10
    }

    private final void launchUninstallConfirmation(String r12, Intent r13) {
        if (Build.VERSION.SDK_INT < 33) goto L5;
        Intent r14 = (Intent) r13.getParcelableExtra("android.intent.extra.INTENT", Intent.class);
    L7:
        if (r14 != null) goto L10;
        this.uiState = SafeCheckUiState.copy$default(this.uiState, false, false, null, null, null, null, SetsKt.minus(getPendingUninstallKeys(), r12), 63, null);
        Log.w(TAG, "Missing system uninstall confirmation intent: package=" + r12);
        updateCleanButtonState();
        return;
    L10:
        r14.addFlags(268435456);
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L13
        SafeCheckActivity r2 = this;     // Catch: Throwable -> L13
        startActivity(r14);     // Catch: Throwable -> L13
        Object r15 = Result.m774constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L13
    L15:
        Throwable r16 = Result.m777exceptionOrNullimpl(r15);
        if (r16 == null) goto L21;
        this.uiState = SafeCheckUiState.copy$default(this.uiState, false, false, null, null, null, null, SetsKt.minus(getPendingUninstallKeys(), r12), 63, null);
        Log.w(TAG, "Failed to launch system uninstall dialog: package=" + r12, r16);
        updateCleanButtonState();
        return;
    L21:
        return;
    L13:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r15 = Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L15
    L5:
        r14 = (Intent) r13.getParcelableExtra("android.intent.extra.INTENT");
        goto L7
    }

    private final void registerSilentUninstallReceiver() {
        IntentFilter r0 = new IntentFilter(ACTION_SILENT_UNINSTALL_RESULT);
        if (Build.VERSION.SDK_INT < 33) goto L5;
        registerReceiver(this.silentUninstallReceiver, r0, 4);
        return;
    L5:
        registerReceiver(this.silentUninstallReceiver, r0);
    }

    private final void hideRotatePanelScanningContent() {
        ViewGroup r0 = getRotatePanelView().getScanningGroup();
        if (r0 == null) goto L13;
        ViewPropertyAnimator r1 = r0.animate();
        if (r1 == null) goto L13;
        ViewPropertyAnimator r2 = r1.alpha(0.0f);
        if (r2 == null) goto L13;
        ViewPropertyAnimator r3 = r2.setDuration(200);
        if (r3 == null) goto L13;
        ViewPropertyAnimator r4 = r3.withEndAction(new AnonymousClass1(this));
        if (r4 == null) goto L13;
        r4.start();
    L13:
        ViewGroup r5 = getRotatePanelView().getScoreGroup();
        if (r5 == null) goto L24;
        ViewPropertyAnimator r6 = r5.animate();
        if (r6 == null) goto L24;
        ViewPropertyAnimator r7 = r6.alpha(0.0f);
        if (r7 == null) goto L24;
        ViewPropertyAnimator r8 = r7.setDuration(200);
        if (r8 == null) goto L24;
        ViewPropertyAnimator r9 = r8.withEndAction(new RunnableC01472(this));
        if (r9 == null) goto L24;
        r9.start();
    L24:
        ScrollingNumbersView r10 = getRotatePanelView().getProgressNumberView();
        if (r10 == null) goto L35;
        ViewPropertyAnimator r11 = r10.animate();
        if (r11 == null) goto L35;
        ViewPropertyAnimator r12 = r11.alpha(0.0f);
        if (r12 == null) goto L35;
        ViewPropertyAnimator r13 = r12.setDuration(200);
        if (r13 == null) goto L35;
        ViewPropertyAnimator r14 = r13.withEndAction(new AnonymousClass3(this));
        if (r14 == null) goto L35;
        r14.start();
    L35:
        ScrollingNumbersView r15 = getRotatePanelView().getScoreNumberView();
        if (r15 == null) goto L46;
        ViewPropertyAnimator r16 = r15.animate();
        if (r16 == null) goto L46;
        ViewPropertyAnimator r17 = r16.alpha(0.0f);
        if (r17 == null) goto L46;
        ViewPropertyAnimator r18 = r17.setDuration(200);
        if (r18 == null) goto L46;
        ViewPropertyAnimator r19 = r18.withEndAction(new AnonymousClass4(this));
        if (r19 == null) goto L46;
        r19.start();
    L46:
        ScrollingNumbersView r20 = getRotatePanelView().getScoreNumberFullView();
        if (r20 == null) goto L57;
        ViewPropertyAnimator r21 = r20.animate();
        if (r21 == null) goto L57;
        ViewPropertyAnimator r22 = r21.alpha(0.0f);
        if (r22 == null) goto L57;
        ViewPropertyAnimator r23 = r22.setDuration(200);
        if (r23 == null) goto L57;
        ViewPropertyAnimator r24 = r23.withEndAction(new AnonymousClass5(this));
        if (r24 == null) goto L57;
        r24.start();
    L57:
        TextView r25 = getRotatePanelView().getScanningText();
        if (r25 == null) goto L68;
        ViewPropertyAnimator r26 = r25.animate();
        if (r26 == null) goto L68;
        ViewPropertyAnimator r27 = r26.alpha(0.0f);
        if (r27 == null) goto L68;
        ViewPropertyAnimator r28 = r27.setDuration(200);
        if (r28 == null) goto L68;
        ViewPropertyAnimator r29 = r28.withEndAction(new AnonymousClass6(this));
        if (r29 == null) goto L68;
        r29.start();
    L68:
        TextView r30 = getRotatePanelView().getScoreText();
        if (r30 == null) goto L80;
        ViewPropertyAnimator r31 = r30.animate();
        if (r31 == null) goto L81;
        ViewPropertyAnimator r32 = r31.alpha(0.0f);
        if (r32 == null) goto L82;
        ViewPropertyAnimator r33 = r32.setDuration(200);
        if (r33 == null) goto L83;
        ViewPropertyAnimator r34 = r33.withEndAction(new AnonymousClass7(this));
        if (r34 == null) goto L84;
        r34.start();
        return;
    L84:
        return;
    L83:
        return;
    L82:
        return;
    L81:
        return;
    }

    private final void showStopConfirmationDialog() {
        OAlertDialogBuilder.horizontalButton$default(OAlertDialogBuilder.title$default(new OAlertDialogBuilder(this), getString(R.string.stop_virus_scan), false, 2, null), false, 1, null).positiveButton(R.string.stop, new SafeCheckActivity$showStopConfirmationDialog$builder$1(this)).negativeButton(R.string.cancel, SafeCheckActivity$showStopConfirmationDialog$builder$2.INSTANCE).build().show();
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        SafeCheckActivity r1 = this;     // Catch: Throwable -> L4
        unregisterReceiver(this.silentUninstallReceiver);     // Catch: Throwable -> L4
        Result.m774constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L6:
        RotatePannelManager2 r2 = this.rotatePanelManager;
        if (r2 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("rotatePanelManager");
    L9:
        r2.onDestory();
        super.onDestroy();
        return;
    L4:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L6
    }
}
