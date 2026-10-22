package com.android.settings.dashboard;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Bundle;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Pair;
import android.view.View;
import android.widget.CompoundButton;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import androidx.preference.TwoStatePreference;
import com.android.settings.R;
import com.android.settings.SettingsActivity;
import com.android.settings.ToastUtils;
import com.android.settings.base.BaseFragment;
import com.android.settings.dashboard.profileselector.ProfileSelectDialog;
import com.android.settings.homepage.TopLevelHighlightMixin;
import com.android.settingslib.PrimarySwitchPreference;
import com.android.settingslib.core.instrumentation.MetricsFeatureProvider;
import com.android.settingslib.drawer.ActivityTile;
import com.android.settingslib.drawer.CategoryKey;
import com.android.settingslib.drawer.DashboardCategory;
import com.android.settingslib.drawer.EntriesProvider;
import com.android.settingslib.drawer.Tile;
import com.android.settingslib.drawer.TileUtils;
import com.android.settingslib.utils.ThreadUtils;
import com.android.settingslib.widget.AdaptiveIcon;
import com.google.common.collect.Iterables;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class DashboardFeatureProviderImpl implements DashboardFeatureProvider {
    private static final String DASHBOARD_TILE_PREF_KEY_PREFIX = "dashboard_tile_pref_";
    private static final String META_DATA_KEY_INTENT_ACTION = "com.android.settings.intent.action";
    private static final String TAG = "DashboardFeatureImpl";
    private final CategoryManager mCategoryManager;
    protected final Context mContext;
    private final MetricsFeatureProvider mMetricsFeatureProvider;
    private final PackageManager mPackageManager;

    static /* synthetic */ void access$000(DashboardFeatureProviderImpl r0, Uri r1, Preference r2, DynamicDataObserver r3) {
        r0.refreshTitle(r1, r2, r3);
    }

    static /* synthetic */ void access$100(DashboardFeatureProviderImpl r0, Uri r1, Preference r2, DynamicDataObserver r3) {
        r0.refreshSummary(r1, r2, r3);
    }

    static /* synthetic */ void access$200(DashboardFeatureProviderImpl r0, Uri r1, Preference r2, DynamicDataObserver r3) {
        r0.refreshSwitch(r1, r2, r3);
    }

    static /* synthetic */ void access$300(DashboardFeatureProviderImpl r0, Uri r1, OCardListItem r2, DynamicDataObserver r3) {
        r0.refreshTitle(r1, r2, r3);
    }

    static /* synthetic */ void access$400(DashboardFeatureProviderImpl r0, Uri r1, OCardListItem r2, DynamicDataObserver r3) {
        r0.refreshSummary(r1, r2, r3);
    }

    static /* synthetic */ void access$500(DashboardFeatureProviderImpl r0, Uri r1, OCardListItem r2, DynamicDataObserver r3) {
        r0.refreshSwitch(r1, r2, r3);
    }

    public DashboardFeatureProviderImpl(Context r2) {
        this.mContext = r2.getApplicationContext();
        this.mCategoryManager = CategoryManager.get(r2);
        this.mMetricsFeatureProvider = new MetricsFeatureProvider();
        this.mPackageManager = r2.getPackageManager();
    }

    @Override // com.android.settings.dashboard.DashboardFeatureProvider
    public DashboardCategory getTilesForCategory(String r2) {
        return this.mCategoryManager.getTilesByCategory(this.mContext, r2);
    }

    @Override // com.android.settings.dashboard.DashboardFeatureProvider
    public List<DashboardCategory> getAllCategories() {
        return this.mCategoryManager.getCategories(this.mContext);
    }

    @Override // com.android.settings.dashboard.DashboardFeatureProvider
    public String getDashboardKeyForTile(Tile r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        if (r2.hasKey() == false) goto L10;
        return r2.getKey(this.mContext);
    L10:
        return DASHBOARD_TILE_PREF_KEY_PREFIX + r2.getIntent().getComponent().getClassName();
    }

    @Override // com.android.settings.dashboard.DashboardFeatureProvider
    public List<DynamicDataObserver> bindPreferenceToTileAndGetObservers(final FragmentActivity r8, final DashboardFragment r9, boolean r10, Preference r11, final Tile r12, String r13, int r14) {
        if (r11 != null) goto L6;
        return null;
    L6:
        if (TextUtils.isEmpty(r13) == true) goto L8;
        r11.setKey(r13);
    L9:
        ArrayList r15 = new ArrayList();
        DynamicDataObserver r1 = bindTitleAndGetObserver(r11, r12);
        if (r1 == null) goto L12;
        r15.add(r1);
    L12:
        DynamicDataObserver r2 = bindSummaryAndGetObserver(r11, r12);
        if (r2 == null) goto L15;
        r15.add(r2);
    L15:
        DynamicDataObserver r3 = bindSwitchAndGetObserver(r11, r12);
        if (r3 == null) goto L18;
        r15.add(r3);
    L18:
        bindIcon(r11, r12, r10);
        if (r12.hasPendingIntent() == false) goto L22;
        r11.setOnPreferenceClickListener(new DashboardFeatureProviderImpl$$ExternalSyntheticLambda3(this, r8, r12, r9));
    L35:
        if (r12.hasOrder() == false) goto L44;
        String r7 = r8.getPackageName();
        int r16 = r12.getOrder();
        if (TextUtils.equals(r7, r12.getIntent().getComponent().getPackageName()) == false) goto L39;
    L42:
        r11.setOrder(r16);
        goto L44
    L39:
        if (r14 == Integer.MAX_VALUE) goto L42;
        r11.setOrder(r16 + r14);
    L44:
        if (r15.isEmpty() == false) goto L47;
        return null;
    L47:
        return r15;
    L22:
        if ((r12 instanceof ActivityTile) == false) goto L35;
        final int r6 = r9.getMetricsCategory();
        Bundle r17 = r12.getMetaData();
        if (r17 == null) goto L26;
        String r18 = r17.getString(SettingsActivity.META_DATA_KEY_FRAGMENT_CLASS);
        String r19 = r17.getString(META_DATA_KEY_INTENT_ACTION);
    L28:
        if (TextUtils.isEmpty(r18) == true) goto L30;
        r11.setFragment(r18);
        goto L35
    L30:
        final Intent r5 = new Intent(r12.getIntent());
        r5.putExtra(MetricsFeatureProvider.EXTRA_SOURCE_METRICS_CATEGORY, r6);
        if (r19 == null) goto L33;
        r5.setAction(r19);
    L33:
        r11.setOnPreferenceClickListener(new DashboardFeatureProviderImpl$$ExternalSyntheticLambda4(this, r8, r12, r5, r6));
        goto L35
    L26:
        r19 = null;
        r18 = null;
        goto L28
    L8:
        r11.setKey(getDashboardKeyForTile(r12));
        goto L9
    }

    /* JADX INFO: renamed from: lambda$bindPreferenceToTileAndGetObservers$0$com-android-settings-dashboard-DashboardFeatureProviderImpl, reason: not valid java name */
    /* synthetic */ boolean m392x2a94fe14(FragmentActivity r1, Tile r2, DashboardFragment r3, Preference r4) {
        launchPendingIntentOrSelectProfile(r1, r2, r3.getMetricsCategory());
        return true;
    }

    /* JADX INFO: renamed from: lambda$bindPreferenceToTileAndGetObservers$1$com-android-settings-dashboard-DashboardFeatureProviderImpl, reason: not valid java name */
    /* synthetic */ boolean m393xe50a9e95(FragmentActivity r8, Tile r9, Intent r10, int r11, Preference r12) {
        launchIntentOrSelectProfile(r8, r9, r10, r11, null, false);
        return true;
    }

    @Override // com.android.settings.dashboard.DashboardFeatureProvider
    public void openTileIntent(FragmentActivity r10, Tile r11) {
        if (r11 != null) goto L6;
        Intent r12 = new Intent("android.settings.SETTINGS").setPackage(this.mContext.getPackageName()).addFlags(32768);
        this.mContext.startActivity(r12);
        return;
    L6:
        launchIntentOrSelectProfile(r10, r11, new Intent(r11.getIntent()).putExtra(MetricsFeatureProvider.EXTRA_SOURCE_METRICS_CATEGORY, 35).addFlags(32768), 35, null, false);
    }

    private DynamicDataObserver createDynamicDataObserver(final String r2, final Uri r3, final Preference r4) {
        return new AnonymousClass1(this, r3, r2, r4);
    }

    private DynamicDataObserver bindTitleAndGetObserver(Preference r4, Tile r5) {
        CharSequence r0 = r5.getTitle(this.mContext.getApplicationContext());
        if (r0 == null) goto L7;
        r4.setTitle(r0);
        return null;
    L7:
        if (r5.getMetaData() != null) goto L9;
    L15:
        return null;
    L9:
        if (r5.getMetaData().containsKey(TileUtils.META_DATA_PREFERENCE_TITLE_URI) == false) goto L15;
        if (r4.getTitle() != null) goto L14;
        r4.setTitle(R.string.summary_placeholder);
    L14:
        return createDynamicDataObserver(EntriesProvider.METHOD_GET_DYNAMIC_TITLE, TileUtils.getCompleteUri(r5, TileUtils.META_DATA_PREFERENCE_TITLE_URI, EntriesProvider.METHOD_GET_DYNAMIC_TITLE), r4);
    }

    private void refreshTitle(final Uri r2, final Preference r3, final DynamicDataObserver r4) {
        ThreadUtils.postOnBackgroundThread(new DashboardFeatureProviderImpl$$ExternalSyntheticLambda8(this, r2, r3, r4));
    }

    /* JADX INFO: renamed from: lambda$refreshTitle$3$com-android-settings-dashboard-DashboardFeatureProviderImpl, reason: not valid java name */
    /* synthetic */ void m408x37102671(Uri r3, final Preference r4, DynamicDataObserver r5) {
        ArrayMap r0 = new ArrayMap();
        final String r2 = TileUtils.getTextFromUri(this.mContext, r3, r0, TileUtils.META_DATA_PREFERENCE_TITLE);
        if (TextUtils.equals(r2, r4.getTitle()) == true) goto L6;
        r5.post(new DashboardFeatureProviderImpl$$ExternalSyntheticLambda23(r4, r2));
        return;
    }

    static /* synthetic */ void lambda$refreshTitle$2(Preference r0, String r1) {
        r0.setTitle(r1);
    }

    private DynamicDataObserver bindSummaryAndGetObserver(Preference r3, Tile r4) {
        CharSequence r0 = r4.getSummary(this.mContext);
        if (r0 == null) goto L6;
        r3.setSummary(r0);
        return null;
    L6:
        if (r4.getMetaData() != null) goto L8;
        return null;
    L8:
        if (r4.getMetaData().containsKey(TileUtils.META_DATA_PREFERENCE_SUMMARY_URI) == true) goto L10;
        return null;
    L10:
        if (r3.getSummary() != null) goto L13;
        r3.setSummary(R.string.summary_placeholder);
    L13:
        return createDynamicDataObserver(EntriesProvider.METHOD_GET_DYNAMIC_SUMMARY, TileUtils.getCompleteUri(r4, TileUtils.META_DATA_PREFERENCE_SUMMARY_URI, EntriesProvider.METHOD_GET_DYNAMIC_SUMMARY), r3);
    }

    private void refreshSummary(final Uri r2, final Preference r3, final DynamicDataObserver r4) {
        ThreadUtils.postOnBackgroundThread(new DashboardFeatureProviderImpl$$ExternalSyntheticLambda2(this, r2, r3, r4));
    }

    /* JADX INFO: renamed from: lambda$refreshSummary$5$com-android-settings-dashboard-DashboardFeatureProviderImpl, reason: not valid java name */
    /* synthetic */ void m403xc1b1f7c1(Uri r3, final Preference r4, DynamicDataObserver r5) {
        ArrayMap r0 = new ArrayMap();
        final String r2 = TileUtils.getTextFromUri(this.mContext, r3, r0, TileUtils.META_DATA_PREFERENCE_SUMMARY);
        if (TextUtils.equals(r2, r4.getSummary()) == true) goto L6;
        r5.post(new DashboardFeatureProviderImpl$$ExternalSyntheticLambda10(r4, r2));
        return;
    }

    static /* synthetic */ void lambda$refreshSummary$4(Preference r0, String r1) {
        r0.setSummary(r1);
    }

    private DynamicDataObserver bindSwitchAndGetObserver(Preference r4, Tile r5) {
        if (r5.hasSwitch() == true) goto L6;
        return null;
    L6:
        final Uri r0 = TileUtils.getCompleteUri(r5, TileUtils.META_DATA_PREFERENCE_SWITCH_URI, EntriesProvider.METHOD_ON_CHECKED_CHANGED);
        r4.setOnPreferenceChangeListener(new DashboardFeatureProviderImpl$$ExternalSyntheticLambda9(this, r0));
        Uri r6 = TileUtils.getCompleteUri(r5, TileUtils.META_DATA_PREFERENCE_SWITCH_URI, EntriesProvider.METHOD_IS_CHECKED);
        setSwitchEnabled(r4, false);
        return createDynamicDataObserver(EntriesProvider.METHOD_IS_CHECKED, r6, r4);
    }

    /* JADX INFO: renamed from: lambda$bindSwitchAndGetObserver$6$com-android-settings-dashboard-DashboardFeatureProviderImpl, reason: not valid java name */
    /* synthetic */ boolean m395xe74e949d(Uri r1, Preference r2, Object r3) {
        onCheckedChanged(r1, r2, ((Boolean) r3).booleanValue());
        return true;
    }

    private void onCheckedChanged(final Uri r2, final Preference r3, final boolean r4) {
        setSwitchEnabled(r3, false);
        ThreadUtils.postOnBackgroundThread(new DashboardFeatureProviderImpl$$ExternalSyntheticLambda20(this, r2, r4, r3));
    }

    /* JADX INFO: renamed from: lambda$onCheckedChanged$8$com-android-settings-dashboard-DashboardFeatureProviderImpl, reason: not valid java name */
    /* synthetic */ void m401xa9cd6ac5(Uri r4, final boolean r5, final Preference r6) {
        ArrayMap r0 = new ArrayMap();
        final Bundle r7 = TileUtils.putBooleanToUriAndGetResult(this.mContext, r4, r0, EntriesProvider.EXTRA_SWITCH_CHECKED_STATE, r5);
        ThreadUtils.postOnMainThread(new DashboardFeatureProviderImpl$$ExternalSyntheticLambda0(this, r6, r7, r5));
    }

    /* JADX INFO: renamed from: lambda$onCheckedChanged$7$com-android-settings-dashboard-DashboardFeatureProviderImpl, reason: not valid java name */
    /* synthetic */ void m400xef57ca44(Preference r3, Bundle r4, boolean r5) {
        setSwitchEnabled(r3, true);
        if (r4.getBoolean(EntriesProvider.EXTRA_SWITCH_SET_CHECKED_ERROR) == true) goto L5;
        return;
    L5:
        setSwitchChecked(r3, !r5);
        String r6 = r4.getString(EntriesProvider.EXTRA_SWITCH_SET_CHECKED_ERROR_MESSAGE);
        if (TextUtils.isEmpty(r6) == true) goto L9;
        ToastUtils.show(this.mContext, r6);
        return;
    }

    private void refreshSwitch(final Uri r2, final Preference r3, final DynamicDataObserver r4) {
        ThreadUtils.postOnBackgroundThread(new DashboardFeatureProviderImpl$$ExternalSyntheticLambda24(this, r2, r4, r3));
    }

    /* JADX INFO: renamed from: lambda$refreshSwitch$10$com-android-settings-dashboard-DashboardFeatureProviderImpl, reason: not valid java name */
    /* synthetic */ void m404x22c22299(Uri r4, DynamicDataObserver r5, final Preference r6) {
        ArrayMap r0 = new ArrayMap();
        final boolean r7 = TileUtils.getBooleanFromUri(this.mContext, r4, r0, EntriesProvider.EXTRA_SWITCH_CHECKED_STATE);
        r5.post(new DashboardFeatureProviderImpl$$ExternalSyntheticLambda15(this, r6, r7));
    }

    /* JADX INFO: renamed from: lambda$refreshSwitch$9$com-android-settings-dashboard-DashboardFeatureProviderImpl, reason: not valid java name */
    /* synthetic */ void m406x4a4cc94f(Preference r1, boolean r2) {
        setSwitchChecked(r1, r2);
        setSwitchEnabled(r1, true);
    }

    private void setSwitchChecked(Preference r1, boolean r2) {
        if ((r1 instanceof PrimarySwitchPreference) == false) goto L6;
        ((PrimarySwitchPreference) r1).setChecked(r2);
        return;
    L6:
        if ((r1 instanceof TwoStatePreference) == false) goto L10;
        ((TwoStatePreference) r1).setChecked(r2);
        return;
    }

    private void setSwitchEnabled(Preference r1, boolean r2) {
        if ((r1 instanceof PrimarySwitchPreference) == false) goto L5;
        ((PrimarySwitchPreference) r1).setSwitchEnabled(r2);
        return;
    L5:
        r1.setEnabled(r2);
    }

    void bindIcon(final Preference r8, final Tile r9, final boolean r10) {
        if (r9.getMetaData() != null) goto L5;
    L8:
        Icon r6 = r9.getIcon(r8.getContext());
        if (r6 != null) goto L11;
        return;
    L11:
        setPreferenceIcon(r8, r9, r10, r9.getPackageName(), r6);
        return;
    L5:
        if (r9.getMetaData().containsKey(TileUtils.META_DATA_PREFERENCE_ICON_URI) == false) goto L8;
        r8.setIconSpaceReserved(true);
        ThreadUtils.postOnBackgroundThread(new DashboardFeatureProviderImpl$$ExternalSyntheticLambda6(this, r9, r8, r10));
    }

    /* JADX INFO: renamed from: lambda$bindIcon$12$com-android-settings-dashboard-DashboardFeatureProviderImpl, reason: not valid java name */
    /* synthetic */ void m389xd4d774ba(final Tile r12, final Preference r13, final boolean r14) {
        Intent r0 = r12.getIntent();
        String r2 = null;
        if (TextUtils.isEmpty(r0.getPackage()) == true) goto L6;
        String r1 = r0.getPackage();
    L9:
        ArrayMap r3 = new ArrayMap();
        Uri r4 = TileUtils.getCompleteUri(r12, TileUtils.META_DATA_PREFERENCE_ICON_URI, EntriesProvider.METHOD_GET_PROVIDER_ICON);
        Pair<String, Integer> r5 = TileUtils.getIconFromUri(this.mContext, r1, r4, r3);
        if (r5 == null) goto L12;
        final Icon r10 = Icon.createWithResource((String) r5.first, ((Integer) r5.second).intValue());
    L13:
        if (r10 != null) goto L16;
        OLog.w(TAG, "Failed to get icon from uri " + r4);
        return;
    L16:
        if (r5 == null) goto L18;
        r2 = (String) r5.first;
    L18:
        final String r9 = r2;
        ThreadUtils.postOnMainThread(new DashboardFeatureProviderImpl$$ExternalSyntheticLambda17(this, r13, r12, r14, r9, r10));
        return;
    L12:
        r10 = null;
        goto L13
    L6:
        if (r0.getComponent() == null) goto L8;
        r1 = r0.getComponent().getPackageName();
        goto L9
    L8:
        r1 = null;
        goto L9
    }

    /* JADX INFO: renamed from: lambda$bindIcon$11$com-android-settings-dashboard-DashboardFeatureProviderImpl, reason: not valid java name */
    /* synthetic */ void m388x1a61d439(Preference r1, Tile r2, boolean r3, String r4, Icon r5) {
        setPreferenceIcon(r1, r2, r3, r4, r5);
    }

    private void setPreferenceIcon(Preference r3, Tile r4, boolean r5, String r6, Icon r7) {
        Drawable r8 = r7.loadDrawable(r3.getContext());
        if (r8 != null) goto L7;
        OLog.w(TAG, "Set null preference icon for: " + r6);
        r3.setIcon(null);
        return;
    L7:
        if (TextUtils.equals(r4.getCategory(), CategoryKey.CATEGORY_HOMEPAGE) == true) goto L9;
    L13:
        if (r5 == true) goto L15;
    L17:
        r3.setIcon(r8);
        return;
    L15:
        if (TextUtils.equals(this.mContext.getPackageName(), r6) == true) goto L17;
        AdaptiveIcon r9 = new AdaptiveIcon(this.mContext, r8, R.dimen.dashboard_tile_foreground_image_inset);
        r9.setBackgroundColor(this.mContext, r4);
        r8 = r9;
        goto L17
    L9:
        if (TextUtils.equals(r4.getGroupKey(), "top_level_account_category") == false) goto L13;
        if (r6 != null) goto L13;
        r3.setIcon(r8);
    }

    private void launchPendingIntentOrSelectProfile(FragmentActivity r9, Tile r10, int r11) {
        ProfileSelectDialog.updatePendingIntentsIfNeeded(this.mContext, r10);
        if (r10.pendingIntentMap.isEmpty() == false) goto L6;
        OLog.w(TAG, "Cannot resolve pendingIntent, skipping. " + r10.getIntent());
        return;
    L6:
        this.mMetricsFeatureProvider.logSettingsTileClick(r10.getKey(this.mContext), r11);
        if (r10.pendingIntentMap.size() != 1) goto L14;
        PendingIntent r8 = (PendingIntent) Iterables.getOnlyElement(r10.pendingIntentMap.values());
        r8.send();     // Catch: PendingIntent.CanceledException -> L11
        return;
    L11:
        e = move-exception;
        OLog.w(TAG, "Failed executing pendingIntent. " + r8.getIntent(), e);
        return;
    L14:
        ProfileSelectDialog.show(r9.getSupportFragmentManager(), r10, r11, null, null, null);
    }

    private void launchPendingIntentOrSelectProfile(Activity r2, Tile r3, int r4) {
        ProfileSelectDialog.updatePendingIntentsIfNeeded(this.mContext, r3);
        if (r3.pendingIntentMap.isEmpty() == false) goto L6;
        OLog.w(TAG, "Cannot resolve pendingIntent, skipping. " + r3.getIntent());
        return;
    L6:
        this.mMetricsFeatureProvider.logSettingsTileClick(r3.getKey(this.mContext), r4);
        if (r3.pendingIntentMap.size() != 1) goto L16;
        PendingIntent r1 = (PendingIntent) Iterables.getOnlyElement(r3.pendingIntentMap.values());
        r1.send();     // Catch: PendingIntent.CanceledException -> L11
        return;
    L11:
        e = move-exception;
        OLog.w(TAG, "Failed executing pendingIntent. " + r1.getIntent(), e);
        return;
    }

    private void launchIntentOrSelectProfile(FragmentActivity r7, Tile r8, Intent r9, int r10, TopLevelHighlightMixin r11, boolean r12) {
        if (isIntentResolvable(r9) == true) goto L6;
        OLog.w(TAG, "Cannot resolve intent, skipping. " + r9);
        return;
    L6:
        ProfileSelectDialog.updateUserHandlesIfNeeded(this.mContext, r8);
        if (r8.userHandle != null) goto L9;
    L28:
        if (r12 == true) goto L36;
        this.mMetricsFeatureProvider.logStartedIntent(r9, r10);
        r7.startActivity(r9);
        return;
    L36:
        return;
    L9:
        if (r8.isPrimaryProfileOnly() == true) goto L28;
        if (r8.userHandle.size() != 1) goto L15;
        if (r12 == true) goto L33;
        this.mMetricsFeatureProvider.logStartedIntent(r9, r10);
        r7.startActivityAsUser(r9, r8.userHandle.get(0));
        return;
    L33:
        return;
    L15:
        UserHandle r0 = (UserHandle) r9.getParcelableExtra("android.intent.extra.USER");
        if (r0 != null) goto L18;
    L22:
        List<UserHandle> r1 = getResolvableUsers(r9, r8);
        if (r1.size() != 1) goto L27;
        if (r12 == true) goto L32;
        this.mMetricsFeatureProvider.logStartedIntent(r9, r10);
        r7.startActivityAsUser(r9, r1.get(0));
        return;
    L32:
        return;
    L27:
        this.mMetricsFeatureProvider.logStartedIntent(r9, r10);
        ProfileSelectDialog.show(r7.getSupportFragmentManager(), r8, r10, r11, r11, r11);
        return;
    L18:
        if (r8.userHandle.contains(r0) == false) goto L22;
        if (r12 == true) goto L31;
        this.mMetricsFeatureProvider.logStartedIntent(r9, r10);
        r7.startActivityAsUser(r9, r0);
        return;
    }

    private void launchIntentOrSelectProfile(Activity r4, Tile r5, Intent r6, int r7, TopLevelHighlightMixin r8, boolean r9) {
        if (isIntentResolvable(r6) == true) goto L6;
        OLog.w(TAG, "Cannot resolve intent, skipping. " + r6);
        return;
    L6:
        ProfileSelectDialog.updateUserHandlesIfNeeded(this.mContext, r5);
        if (r5.userHandle != null) goto L9;
    L27:
        if (r9 == true) goto L35;
        this.mMetricsFeatureProvider.logStartedIntent(r6, r7);
        r4.startActivity(r6);
        return;
    L35:
        return;
    L9:
        if (r5.isPrimaryProfileOnly() == true) goto L27;
        if (r5.userHandle.size() != 1) goto L15;
        if (r9 == true) goto L32;
        this.mMetricsFeatureProvider.logStartedIntent(r6, r7);
        r4.startActivityAsUser(r6, r5.userHandle.get(0));
        return;
    L32:
        return;
    L15:
        UserHandle r10 = (UserHandle) r6.getParcelableExtra("android.intent.extra.USER");
        if (r10 != null) goto L18;
    L22:
        List<UserHandle> r11 = getResolvableUsers(r6, r5);
        if (r11.size() != 1) goto L34;
        if (r9 == true) goto L31;
        this.mMetricsFeatureProvider.logStartedIntent(r6, r7);
        r4.startActivityAsUser(r6, r11.get(0));
        return;
    L31:
        return;
    L34:
        return;
    L18:
        if (r5.userHandle.contains(r10) == false) goto L22;
        if (r9 == true) goto L30;
        this.mMetricsFeatureProvider.logStartedIntent(r6, r7);
        r4.startActivityAsUser(r6, r10);
        return;
    }

    private boolean isIntentResolvable(Intent r2) {
        if (this.mPackageManager.resolveActivity(r2, 0) == null) goto L6;
        return true;
    L6:
        return false;
    }

    private List<UserHandle> getResolvableUsers(Intent r6, Tile r7) {
        ArrayList r0 = new ArrayList();
        Iterator<UserHandle> r8 = r7.userHandle.iterator();
    L4:
        if (r8.hasNext() == false) goto L8;
        UserHandle r1 = r8.next();
        if (this.mPackageManager.resolveActivityAsUser(r6, 0, r1.getIdentifier()) == null) goto L4;
        r0.add(r1);
        goto L4
    L8:
        return r0;
    }

    @Override // com.android.settings.dashboard.DashboardFeatureProvider
    public List<DynamicDataObserver> bindOUIToTileAndGetObservers(final Activity r7, final BaseFragment r8, boolean r9, OCardListItem r10, final Tile r11, String r12, int r13) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if (TextUtils.isEmpty(r12) == true) goto L8;
        r10.setTag(r12);
    L9:
        ArrayList r14 = new ArrayList();
        DynamicDataObserver r15 = bindTitleAndGetObserver(r10, r11);
        if (r15 == null) goto L12;
        r14.add(r15);
    L12:
        DynamicDataObserver r16 = bindSummaryAndGetObserver(r10, r11);
        if (r16 == null) goto L15;
        r14.add(r16);
    L15:
        DynamicDataObserver r17 = bindSwitchAndGetObserver(r10, r11);
        if (r17 == null) goto L19;
        r14.add(r17);
    L19:
        if (r11.hasPendingIntent() == false) goto L22;
        r10.setOnContentClickListener(new DashboardFeatureProviderImpl$$ExternalSyntheticLambda12(this, r7, r11, r8));
    L35:
        if (r14.isEmpty() == false) goto L38;
        return null;
    L38:
        return r14;
    L22:
        if ((r11 instanceof ActivityTile) == false) goto L35;
        final int r5 = r8.getMetricsCategory();
        Bundle r18 = r11.getMetaData();
        if (r18 == null) goto L26;
        String r19 = r18.getString(SettingsActivity.META_DATA_KEY_FRAGMENT_CLASS);
        String r20 = r18.getString(META_DATA_KEY_INTENT_ACTION);
    L28:
        if (TextUtils.isEmpty(r19) == false) goto L35;
        final Intent r4 = new Intent(r11.getIntent());
        r4.putExtra(MetricsFeatureProvider.EXTRA_SOURCE_METRICS_CATEGORY, r5);
        if (r20 == null) goto L33;
        r4.setAction(r20);
    L33:
        r10.setOnContentClickListener(new DashboardFeatureProviderImpl$$ExternalSyntheticLambda13(this, r7, r11, r4, r5));
        goto L35
    L26:
        r20 = null;
        r19 = null;
        goto L28
    L8:
        r10.setTag(getDashboardKeyForTile(r11));
        goto L9
    }

    /* JADX INFO: renamed from: lambda$bindOUIToTileAndGetObservers$13$com-android-settings-dashboard-DashboardFeatureProviderImpl, reason: not valid java name */
    /* synthetic */ void m390xd1901d02(Activity r1, Tile r2, BaseFragment r3, View r4) {
        launchPendingIntentOrSelectProfile(r1, r2, r3.getMetricsCategory());
    }

    /* JADX INFO: renamed from: lambda$bindOUIToTileAndGetObservers$14$com-android-settings-dashboard-DashboardFeatureProviderImpl, reason: not valid java name */
    /* synthetic */ void m391x8c05bd83(Activity r8, Tile r9, Intent r10, int r11, View r12) {
        launchIntentOrSelectProfile(r8, r9, r10, r11, null, false);
    }

    private DynamicDataObserver bindTitleAndGetObserver(OCardListItem r4, Tile r5) {
        CharSequence r0 = r5.getTitle(this.mContext.getApplicationContext());
        if (r0 == null) goto L7;
        r4.setTitle(r0);
        return null;
    L7:
        if (r5.getMetaData() != null) goto L9;
    L15:
        return null;
    L9:
        if (r5.getMetaData().containsKey(TileUtils.META_DATA_PREFERENCE_TITLE_URI) == false) goto L15;
        if (r4.getTitle() != null) goto L14;
        r4.setTitle(this.mContext.getString(R.string.summary_placeholder));
    L14:
        return createDynamicDataObserver(EntriesProvider.METHOD_GET_DYNAMIC_TITLE, TileUtils.getCompleteUri(r5, TileUtils.META_DATA_PREFERENCE_TITLE_URI, EntriesProvider.METHOD_GET_DYNAMIC_TITLE), r4);
    }

    private DynamicDataObserver createDynamicDataObserver(final String r2, final Uri r3, final OCardListItem r4) {
        return new AnonymousClass2(this, r3, r2, r4);
    }

    private void refreshTitle(final Uri r2, final OCardListItem r3, final DynamicDataObserver r4) {
        ThreadUtils.postOnBackgroundThread(new DashboardFeatureProviderImpl$$ExternalSyntheticLambda11(this, r2, r3, r4));
    }

    /* JADX INFO: renamed from: lambda$refreshTitle$16$com-android-settings-dashboard-DashboardFeatureProviderImpl, reason: not valid java name */
    /* synthetic */ void m407xa6a2ca77(Uri r3, final OCardListItem r4, DynamicDataObserver r5) {
        ArrayMap r0 = new ArrayMap();
        final String r2 = TileUtils.getTextFromUri(this.mContext, r3, r0, TileUtils.META_DATA_PREFERENCE_TITLE);
        if (TextUtils.equals(r2, r4.getTitle()) == true) goto L6;
        r5.post(new DashboardFeatureProviderImpl$$ExternalSyntheticLambda25(r4, r2));
        return;
    }

    static /* synthetic */ void lambda$refreshTitle$15(OCardListItem r0, String r1) {
        r0.setTitle(r1);
    }

    private DynamicDataObserver bindSummaryAndGetObserver(OCardListItem r4, Tile r5) {
        CharSequence r0 = r5.getSummary(this.mContext);
        if (r0 == null) goto L6;
        r4.setSubTitle(r0);
        return null;
    L6:
        if (r5.getMetaData() != null) goto L8;
        return null;
    L8:
        if (r5.getMetaData().containsKey(TileUtils.META_DATA_PREFERENCE_SUMMARY_URI) == true) goto L10;
        return null;
    L10:
        if (r4.getSubTitle() != null) goto L13;
        r4.setSubTitle(this.mContext.getString(R.string.summary_placeholder));
    L13:
        return createDynamicDataObserver(EntriesProvider.METHOD_GET_DYNAMIC_SUMMARY, TileUtils.getCompleteUri(r5, TileUtils.META_DATA_PREFERENCE_SUMMARY_URI, EntriesProvider.METHOD_GET_DYNAMIC_SUMMARY), r4);
    }

    private void refreshSummary(final Uri r2, final OCardListItem r3, final DynamicDataObserver r4) {
        ThreadUtils.postOnBackgroundThread(new DashboardFeatureProviderImpl$$ExternalSyntheticLambda18(this, r2, r3, r4));
    }

    /* JADX INFO: renamed from: lambda$refreshSummary$18$com-android-settings-dashboard-DashboardFeatureProviderImpl, reason: not valid java name */
    /* synthetic */ void m402xbca984eb(Uri r3, final OCardListItem r4, DynamicDataObserver r5) {
        ArrayMap r0 = new ArrayMap();
        final String r2 = TileUtils.getTextFromUri(this.mContext, r3, r0, TileUtils.META_DATA_PREFERENCE_SUMMARY);
        if (TextUtils.equals(r2, r4.getSubTitle().toString()) == true) goto L6;
        r5.post(new DashboardFeatureProviderImpl$$ExternalSyntheticLambda22(r4, r2));
        return;
    }

    static /* synthetic */ void lambda$refreshSummary$17(OCardListItem r0, String r1) {
        r0.setSubTitle(r1);
    }

    private DynamicDataObserver bindSwitchAndGetObserver(final OCardListItem r5, Tile r6) {
        if (r6.hasSwitch() == true) goto L6;
        return null;
    L6:
        final Uri r0 = TileUtils.getCompleteUri(r6, TileUtils.META_DATA_PREFERENCE_SWITCH_URI, EntriesProvider.METHOD_ON_CHECKED_CHANGED);
        ((OSwitch) Objects.requireNonNull(r5.getEndSwitch())).setOnCheckedChangeListener(new DashboardFeatureProviderImpl$$ExternalSyntheticLambda7(this, r0, r5));
        Uri r7 = TileUtils.getCompleteUri(r6, TileUtils.META_DATA_PREFERENCE_SWITCH_URI, EntriesProvider.METHOD_IS_CHECKED);
        ((OSwitch) Objects.requireNonNull(r5.getEndSwitch())).setEnabled(false);
        return createDynamicDataObserver(EntriesProvider.METHOD_IS_CHECKED, r7, r5);
    }

    /* JADX INFO: renamed from: lambda$bindSwitchAndGetObserver$19$com-android-settings-dashboard-DashboardFeatureProviderImpl, reason: not valid java name */
    /* synthetic */ void m394x70d7b471(Uri r1, OCardListItem r2, CompoundButton r3, boolean r4) {
        onCheckedChanged(r1, r2, r4);
    }

    private void onCheckedChanged(final Uri r3, final OCardListItem r4, final boolean r5) {
        ((OSwitch) Objects.requireNonNull(r4.getEndSwitch())).setEnabled(false);
        ThreadUtils.postOnBackgroundThread(new DashboardFeatureProviderImpl$$ExternalSyntheticLambda16(this, r3, r5, r4));
    }

    /* JADX INFO: renamed from: lambda$onCheckedChanged$21$com-android-settings-dashboard-DashboardFeatureProviderImpl, reason: not valid java name */
    /* synthetic */ void m399x96482fa2(Uri r4, final boolean r5, final OCardListItem r6) {
        ArrayMap r0 = new ArrayMap();
        final Bundle r7 = TileUtils.putBooleanToUriAndGetResult(this.mContext, r4, r0, EntriesProvider.EXTRA_SWITCH_CHECKED_STATE, r5);
        ThreadUtils.postOnMainThread(new DashboardFeatureProviderImpl$$ExternalSyntheticLambda19(this, r6, r7, r5));
    }

    /* JADX INFO: renamed from: lambda$onCheckedChanged$20$com-android-settings-dashboard-DashboardFeatureProviderImpl, reason: not valid java name */
    /* synthetic */ void m398xdbd28f21(OCardListItem r3, Bundle r4, boolean r5) {
        ((OSwitch) Objects.requireNonNull(r3.getEndSwitch())).setEnabled(true);
        if (r4.getBoolean(EntriesProvider.EXTRA_SWITCH_SET_CHECKED_ERROR) == true) goto L5;
        return;
    L5:
        ((OSwitch) Objects.requireNonNull(r3.getEndSwitch())).setChecked(!r5);
        String r6 = r4.getString(EntriesProvider.EXTRA_SWITCH_SET_CHECKED_ERROR_MESSAGE);
        if (TextUtils.isEmpty(r6) == true) goto L9;
        ToastUtils.show(this.mContext, r6);
        return;
    }

    private void refreshSwitch(final Uri r2, final OCardListItem r3, final DynamicDataObserver r4) {
        ThreadUtils.postOnBackgroundThread(new DashboardFeatureProviderImpl$$ExternalSyntheticLambda5(this, r2, r4, r3));
    }

    /* JADX INFO: renamed from: lambda$refreshSwitch$23$com-android-settings-dashboard-DashboardFeatureProviderImpl, reason: not valid java name */
    /* synthetic */ void m405xe66173bb(Uri r3, DynamicDataObserver r4, final OCardListItem r5) {
        ArrayMap r0 = new ArrayMap();
        final boolean r2 = TileUtils.getBooleanFromUri(this.mContext, r3, r0, EntriesProvider.EXTRA_SWITCH_CHECKED_STATE);
        r4.post(new DashboardFeatureProviderImpl$$ExternalSyntheticLambda21(r5, r2));
    }

    static /* synthetic */ void lambda$refreshSwitch$22(OCardListItem r1, boolean r2) {
        ((OSwitch) Objects.requireNonNull(r1.getEndSwitch())).setChecked(r2);
        ((OSwitch) Objects.requireNonNull(r1.getEndSwitch())).setEnabled(true);
    }

    @Override // com.android.settings.dashboard.DashboardFeatureProvider
    public void getTitleAndSummaryFromUri(final Tile r2, final DashboardFeatureProvider.OnTitleLoadedListener r3) {
        ThreadUtils.postOnBackgroundThread(new DashboardFeatureProviderImpl$$ExternalSyntheticLambda1(this, r2, r3));
    }

    /* JADX INFO: renamed from: lambda$getTitleAndSummaryFromUri$24$com-android-settings-dashboard-DashboardFeatureProviderImpl, reason: not valid java name */
    /* synthetic */ void m397x5c82725a(Tile r5, DashboardFeatureProvider.OnTitleLoadedListener r6) {
        ArrayMap r0 = new ArrayMap();
        String r1 = TileUtils.getTextFromUri(this.mContext, TileUtils.getCompleteUri(r5, TileUtils.META_DATA_PREFERENCE_TITLE_URI, EntriesProvider.METHOD_GET_DYNAMIC_TITLE), r0, TileUtils.META_DATA_PREFERENCE_TITLE);
        String r4 = TileUtils.getTextFromUri(this.mContext, TileUtils.getCompleteUri(r5, TileUtils.META_DATA_PREFERENCE_SUMMARY_URI, EntriesProvider.METHOD_GET_DYNAMIC_SUMMARY), r0, TileUtils.META_DATA_PREFERENCE_SUMMARY);
        OLog.d("getTitleAndSummaryFromUri", "titleFromUri: " + r1 + ", summaryFromUri: " + r4);
        if (r6 == null) goto L6;
        r6.onTitleLoaded(r1, r4);
        return;
    }

    @Override // com.android.settings.dashboard.DashboardFeatureProvider
    public String getTitleFromUri(Tile r4) {
        ArrayMap r0 = new ArrayMap();
        Uri r5 = TileUtils.getCompleteUri(r4, TileUtils.META_DATA_PREFERENCE_TITLE_URI, EntriesProvider.METHOD_GET_DYNAMIC_TITLE);
        return TileUtils.getTextFromUri(this.mContext, r5, r0, TileUtils.META_DATA_PREFERENCE_TITLE);
    }

    @Override // com.android.settings.dashboard.DashboardFeatureProvider
    public void getIconFromUri(final Tile r2, boolean r3, final DashboardFeatureProvider.OnIconLoadedListener r4) {
        if (r2.getMetaData() != null) goto L5;
        return;
    L5:
        if (r2.getMetaData().containsKey(TileUtils.META_DATA_PREFERENCE_ICON_URI) == false) goto L9;
        ThreadUtils.postOnBackgroundThread(new DashboardFeatureProviderImpl$$ExternalSyntheticLambda14(this, r2, r4));
        return;
    }

    /* JADX INFO: renamed from: lambda$getIconFromUri$25$com-android-settings-dashboard-DashboardFeatureProviderImpl, reason: not valid java name */
    /* synthetic */ void m396xd1168df(Tile r6, DashboardFeatureProvider.OnIconLoadedListener r7) {
        Intent r0 = r6.getIntent();
        Icon r2 = null;
        if (TextUtils.isEmpty(r0.getPackage()) == true) goto L6;
        String r1 = r0.getPackage();
    L9:
        ArrayMap r3 = new ArrayMap();
        Uri r8 = TileUtils.getCompleteUri(r6, TileUtils.META_DATA_PREFERENCE_ICON_URI, EntriesProvider.METHOD_GET_PROVIDER_ICON);
        Pair<String, Integer> r5 = TileUtils.getIconFromUri(this.mContext, r1, r8, r3);
        if (r5 == null) goto L12;
        r2 = Icon.createWithResource((String) r5.first, ((Integer) r5.second).intValue());
    L12:
        if (r2 != null) goto L15;
        OLog.w(TAG, "Failed to get icon from uri " + r8);
        return;
    L15:
        if (r5 == null) goto L17;
        String r9 = (String) r5.first;
    L17:
        r7.onIconLoaded(r2);
        return;
    L6:
        if (r0.getComponent() == null) goto L8;
        r1 = r0.getComponent().getPackageName();
        goto L9
    L8:
        r1 = null;
        goto L9
    }
}
