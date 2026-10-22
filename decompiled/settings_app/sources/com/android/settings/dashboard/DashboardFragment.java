package com.android.settings.dashboard;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceManager;
import androidx.preference.PreferenceScreen;
import androidx.preference.SwitchPreferenceCompat;
import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.core.BasePreferenceController;
import com.android.settingslib.PrimarySwitchPreference;
import com.android.settingslib.core.AbstractPreferenceController;
import com.android.settingslib.core.instrumentation.MetricsFeatureProvider;
import com.android.settingslib.drawer.DashboardCategory;
import com.android.settingslib.drawer.Tile;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public abstract class DashboardFragment extends SettingsPreferenceFragment implements PreferenceGroup.OnExpandButtonClickListener, BasePreferenceController.UiBlockListener {
    public static final String CATEGORY = "category";
    private static final String TAG = "DashboardFragment";
    private static final long TIMEOUT_MILLIS = 50;
    UiBlockerController mBlockerController;
    private final List<AbstractPreferenceController> mControllers;
    private DashboardFeatureProvider mDashboardFeatureProvider;
    final ArrayMap<String, List<DynamicDataObserver>> mDashboardTilePrefKeys;
    private boolean mListeningToCategoryChange;
    private DashboardTilePlaceholderPreferenceController mPlaceholderPreferenceController;
    private final Map<Class, List<AbstractPreferenceController>> mPreferenceControllers;
    private final List<DynamicDataObserver> mRegisteredObservers;
    private List<String> mSuppressInjectedTileKeys;

    /* JADX INFO: renamed from: com.android.settings.dashboard.DashboardFragment$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$android$settingslib$drawer$Tile$Type = null;

        static {
            int[] r0 = new int[Tile.Type.values().length];
            $SwitchMap$com$android$settingslib$drawer$Tile$Type = r0;
            r0[Tile.Type.EXTERNAL_ACTION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$android$settingslib$drawer$Tile$Type[Tile.Type.SWITCH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$android$settingslib$drawer$Tile$Type[Tile.Type.SWITCH_WITH_ACTION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$com$android$settingslib$drawer$Tile$Type[Tile.Type.GROUP.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$com$android$settingslib$drawer$Tile$Type[Tile.Type.ACTION.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public static /* synthetic */ boolean $r8$lambda$FnBGEYXoHI65HkTLYJ2y_5K0jjk(Object r0) {
        return Objects.nonNull(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$X-oE4EXbVO2A74MRVMySFI0xBqk, reason: not valid java name */
    public static /* synthetic */ boolean m409$r8$lambda$XoE4EXbVO2A74MRVMySFI0xBqk(Object r0) {
        return Objects.nonNull(r0);
    }

    protected List<AbstractPreferenceController> createPreferenceControllers(Context r1) {
        return null;
    }

    protected abstract String getLogTag();

    protected abstract int getPreferenceScreenResId();

    protected boolean shouldForceRoundedIcon() {
        return false;
    }

    public DashboardFragment() {
        this.mDashboardTilePrefKeys = new ArrayMap();
        this.mPreferenceControllers = new ArrayMap();
        this.mRegisteredObservers = new ArrayList();
        this.mControllers = new ArrayList();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context r4) {
        super.onAttach(r4);
        this.mSuppressInjectedTileKeys = Arrays.asList(r4.getResources().getStringArray(R.array.config_suppress_injected_tile_keys));
        this.mDashboardFeatureProvider = new DashboardFeatureProviderImpl(r4);
        final int r0 = getMetricsCategory();
        this.mControllers.forEach(new DashboardFragment$$ExternalSyntheticLambda8(r0));
        DashboardTilePlaceholderPreferenceController r1 = new DashboardTilePlaceholderPreferenceController(r4);
        this.mPlaceholderPreferenceController = r1;
        this.mControllers.add(r1);
        Iterator<AbstractPreferenceController> r5 = this.mControllers.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        addPreferenceController(r5.next());
        goto L4
    }

    static /* synthetic */ void lambda$onAttach$0(int r1, AbstractPreferenceController r2) {
        if ((r2 instanceof BasePreferenceController) == false) goto L6;
        ((BasePreferenceController) r2).setMetricsCategory(r1);
        return;
    }

    void checkUiBlocker(List<AbstractPreferenceController> r4) {
        final ArrayList r0 = new ArrayList();
        final ArrayList r1 = new ArrayList();
        r4.forEach(new DashboardFragment$$ExternalSyntheticLambda0(this, r0, r1));
        if (r0.isEmpty() == true) goto L6;
        UiBlockerController r5 = new UiBlockerController(r0);
        this.mBlockerController = r5;
        r5.start(new DashboardFragment$$ExternalSyntheticLambda9(this, r1));
        return;
    }

    /* JADX INFO: renamed from: lambda$checkUiBlocker$1$com-android-settings-dashboard-DashboardFragment, reason: not valid java name */
    /* synthetic */ void m410x4fc5b0e7(List r2, List r3, AbstractPreferenceController r4) {
        if ((r4 instanceof BasePreferenceController.UiBlocker) == true) goto L5;
        return;
    L5:
        if (r4.isAvailable() == false) goto L9;
        BasePreferenceController r0 = (BasePreferenceController) r4;
        r0.setUiBlockListener(this);
        r2.add(r4.getPreferenceKey());
        r3.add(r0);
        return;
    }

    /* JADX INFO: renamed from: lambda$checkUiBlocker$3$com-android-settings-dashboard-DashboardFragment, reason: not valid java name */
    /* synthetic */ void m411x3318fd25(List r2) {
        updatePreferenceVisibility(this.mPreferenceControllers);
        r2.forEach(new DashboardFragment$$ExternalSyntheticLambda10());
    }

    static /* synthetic */ void lambda$checkUiBlocker$2(BasePreferenceController r1) {
        r1.setUiBlockerFinished(true);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r3) {
        super.onCreate(r3);
        getPreferenceManager().setPreferenceComparisonCallback(new PreferenceManager.SimplePreferenceComparisonCallback());
        if (r3 == null) goto L6;
        updatePreferenceStates();
        return;
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
    }

    public void onCategoriesChanged(Set<String> r3) {
        String r0 = getCategoryKey();
        if (this.mDashboardFeatureProvider.getTilesForCategory(r0) != null) goto L5;
        return;
    L5:
        if (r3 != null) goto L8;
        refreshDashboardTiles(getLogTag());
        return;
    L8:
        if (r3.contains(r0) == false) goto L12;
        OLog.i(TAG, "refresh tiles for " + r0);
        refreshDashboardTiles(getLogTag());
        return;
    }

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(Bundle r1, String r2) {
        checkUiBlocker(this.mControllers);
        refreshAllPreferences(getLogTag());
        this.mControllers.stream().map(new DashboardFragment$$ExternalSyntheticLambda2(this)).filter(new DashboardFragment$$ExternalSyntheticLambda3()).forEach(new DashboardFragment$$ExternalSyntheticLambda4(this));
    }

    /* JADX INFO: renamed from: lambda$onCreatePreferences$4$com-android-settings-dashboard-DashboardFragment, reason: not valid java name */
    /* synthetic */ Preference m412xa7845a5f(AbstractPreferenceController r1) {
        return findPreference(r1.getPreferenceKey());
    }

    /* JADX INFO: renamed from: lambda$onCreatePreferences$5$com-android-settings-dashboard-DashboardFragment, reason: not valid java name */
    /* synthetic */ void m413x992e007e(Preference r2) {
        r2.getExtras().putInt("category", getMetricsCategory());
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.mDashboardFeatureProvider.getTilesForCategory(getCategoryKey()) != null) goto L5;
        return;
    L5:
        getActivity();
        final ContentResolver r0 = getContentResolver();
        this.mDashboardTilePrefKeys.values().stream().filter(new DashboardFragment$$ExternalSyntheticLambda11()).flatMap(new DashboardFragment$$ExternalSyntheticLambda12()).forEach(new DashboardFragment$$ExternalSyntheticLambda13(this, r0));
    }

    /* JADX INFO: renamed from: lambda$onStart$6$com-android-settings-dashboard-DashboardFragment, reason: not valid java name */
    /* synthetic */ void m414x43a9cad7(ContentResolver r2, DynamicDataObserver r3) {
        if (this.mRegisteredObservers.contains(r3) == true) goto L6;
        registerDynamicDataObserver(r2, r3);
        return;
    }

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        updatePreferenceStates();
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.preference.PreferenceManager.OnPreferenceTreeClickListener
    public boolean onPreferenceTreeClick(Preference r2) {
        this.mPreferenceControllers.values();
        return super.onPreferenceTreeClick(r2);
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        unregisterDynamicDataObservers(new ArrayList(this.mRegisteredObservers));
        if (this.mListeningToCategoryChange == false) goto L6;
        getActivity();
        this.mListeningToCategoryChange = false;
        return;
    }

    @Override // androidx.preference.PreferenceGroup.OnExpandButtonClickListener
    public void onExpandButtonClick() {
        new MetricsFeatureProvider().action(0, 834, getMetricsCategory(), null, 0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int r5, int r6, Intent r7) {
        Iterator<List<AbstractPreferenceController>> r0 = this.mPreferenceControllers.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Iterator<AbstractPreferenceController> r1 = r0.next().iterator();
    L7:
        if (r1.hasNext() == false) goto L4;
        Object r2 = (AbstractPreferenceController) r1.next();
        if ((r2 instanceof android.preference.PreferenceManager.OnActivityResultListener) == false) goto L7;
        ((android.preference.PreferenceManager.OnActivityResultListener) r2).onActivityResult(r5, r6, r7);
        goto L7
    L11:
        super.onActivityResult(r5, r6, r7);
    }

    protected <T extends AbstractPreferenceController> T use(Class<T> r3) {
        List<AbstractPreferenceController> r2 = this.mPreferenceControllers.get(r3);
        if (r2 != null) goto L5;
        return null;
    L5:
        if (r2.size() <= 1) goto L8;
        OLog.w(TAG, "Multiple controllers of Class " + r3.getSimpleName() + " found, returning first one.");
    L8:
        return (T) r2.get(0);
    }

    protected <T extends AbstractPreferenceController> List<AbstractPreferenceController> useGroup(final Class<T> r2) {
        return this.mPreferenceControllers.values().stream().flatMap(new DashboardFragment$$ExternalSyntheticLambda12()).filter(new DashboardFragment$$ExternalSyntheticLambda15(r2)).toList();
    }

    static /* synthetic */ boolean lambda$useGroup$7(Class r0, AbstractPreferenceController r1) {
        return r0.isInstance(r1);
    }

    protected <T extends AbstractPreferenceController> List<T> useAll(Class<T> r2) {
        return (List) this.mPreferenceControllers.getOrDefault(r2, Collections.emptyList());
    }

    protected void addPreferenceController(AbstractPreferenceController r4) {
        if (this.mPreferenceControllers.get(r4.getClass()) != null) goto L5;
        this.mPreferenceControllers.put(r4.getClass(), new ArrayList());
    L5:
        this.mPreferenceControllers.get(r4.getClass()).add(r4);
    }

    public String getCategoryKey() {
        return DashboardFragmentRegistry.PARENT_TO_CATEGORY_KEY_MAP.get(getClass().getName());
    }

    protected boolean displayTile(Tile r3) {
        if (this.mSuppressInjectedTileKeys != null) goto L5;
    L8:
        return true;
    L5:
        if (r3.hasKey() == false) goto L8;
        return !this.mSuppressInjectedTileKeys.contains(r3.getKey(getContext()));
    }

    private void displayResourceTiles() {
        int r0 = getPreferenceScreenResId();
        if (r0 > 0) goto L5;
        return;
    L5:
        addPreferencesFromResource(r0);
        PreferenceScreen r1 = getPreferenceScreen();
        r1.setOnExpandButtonClickListener(this);
        displayResourceTilesToScreen(r1);
    }

    protected void displayResourceTilesToScreen(final PreferenceScreen r2) {
        this.mPreferenceControllers.values().stream().flatMap(new DashboardFragment$$ExternalSyntheticLambda12()).forEach(new DashboardFragment$$ExternalSyntheticLambda7(r2));
    }

    static /* synthetic */ void lambda$displayResourceTilesToScreen$8(PreferenceScreen r0, AbstractPreferenceController r1) {
        r1.displayPreference(r0);
    }

    protected Collection<List<AbstractPreferenceController>> getPreferenceControllers() {
        return this.mPreferenceControllers.values();
    }

    protected void updatePreferenceStates() {
        PreferenceScreen r0 = getPreferenceScreen();
        Iterator<List<AbstractPreferenceController>> r9 = this.mPreferenceControllers.values().iterator();
    L4:
        if (r9.hasNext() == false) goto L18;
        Iterator<AbstractPreferenceController> r1 = r9.next().iterator();
    L7:
        if (r1.hasNext() == false) goto L4;
        AbstractPreferenceController r2 = r1.next();
        if (r2.isAvailable() == false) goto L7;
        String r3 = r2.getPreferenceKey();
        if (TextUtils.isEmpty(r3) == true) goto L13;
        Preference r4 = r0.findPreference(r3);
        if (r4 == null) goto L16;
        r2.updateState(r4);
        goto L7
    L16:
        OLog.d(TAG, String.format("Cannot find preference with key %s in Controller %s", new Object[]{r3, r2.getClass().getSimpleName()}));
        goto L7
    L13:
        OLog.d(TAG, String.format("Preference key is %s in Controller %s", new Object[]{r3, r2.getClass().getSimpleName()}));
        goto L7
    }

    private void refreshAllPreferences(String r3) {
        PreferenceScreen r0 = getPreferenceScreen();
        if (r0 == null) goto L5;
        r0.removeAll();
    L5:
        displayResourceTiles();
        refreshDashboardTiles(r3);
        FragmentActivity r1 = getActivity();
        if (r1 == null) goto L8;
        OLog.d(r3, "All preferences added, reporting fully drawn");
        r1.reportFullyDrawn();
    L8:
        updatePreferenceVisibility(this.mPreferenceControllers);
    }

    public void forceUpdatePreferences() {
        if (getPreferenceScreen() == null) goto L20;
        Map<Class, List<AbstractPreferenceController>> r0 = this.mPreferenceControllers;
        if (r0 == null) goto L27;
        Iterator<List<AbstractPreferenceController>> r1 = r0.values().iterator();
    L9:
        if (r1.hasNext() == false) goto L28;
        Iterator<AbstractPreferenceController> r2 = r1.next().iterator();
    L12:
        if (r2.hasNext() == false) goto L9;
        AbstractPreferenceController r3 = r2.next();
        Preference r4 = findPreference(r3.getPreferenceKey());
        if (r4 == null) goto L12;
        boolean r5 = r3.isAvailable();
        if (r5 == false) goto L19;
        r3.updateState(r4);
    L19:
        r4.setVisible(r5);
        goto L12
    L28:
        return;
    L27:
        return;
    }

    void updatePreferenceVisibility(Map<Class, List<AbstractPreferenceController>> r8) {
        if (getPreferenceScreen() == null) goto L33;
        if (r8 == null) goto L43;
        UiBlockerController r0 = this.mBlockerController;
        if (r0 == null) goto L44;
        boolean r1 = r0.isBlockerFinished();
        Iterator<List<AbstractPreferenceController>> r9 = r8.values().iterator();
    L10:
        if (r9.hasNext() == false) goto L45;
        Iterator<AbstractPreferenceController> r2 = r9.next().iterator();
    L13:
        if (r2.hasNext() == false) goto L10;
        AbstractPreferenceController r3 = r2.next();
        Preference r4 = findPreference(r3.getPreferenceKey());
        if (r4 == null) goto L13;
        boolean r5 = true;
        if ((r3 instanceof BasePreferenceController.UiBlocker) == true) goto L19;
        if (r1 == true) goto L29;
    L31:
        r5 = false;
    L32:
        r4.setVisible(r5);
        goto L13
    L29:
        if (r3.isAvailable() == false) goto L31;
    L19:
        boolean r6 = ((BasePreferenceController) r3).getSavedPrefVisibility();
        if (r1 == true) goto L22;
    L25:
        r5 = false;
    L26:
        r4.setVisible(r5);
        goto L13
    L22:
        if (r3.isAvailable() == false) goto L25;
        if (r6 == false) goto L25;
    L45:
        return;
    L44:
        return;
    L43:
        return;
    }

    private void refreshDashboardTiles(String r20) {
        PreferenceScreen r10 = getPreferenceScreen();
        DashboardCategory r0 = this.mDashboardFeatureProvider.getTilesForCategory(getCategoryKey());
        if (r0 != null) goto L6;
        OLog.d(r20, "NO dashboard tiles for " + r20);
        return;
    L6:
        List<Tile> r1 = r0.getTiles();
        if (r1 != null) goto L10;
        OLog.d(r20, "tile list is empty, skipping category " + r0.key);
        return;
    L10:
        ArrayMap r11 = new ArrayMap(this.mDashboardTilePrefKeys);
        boolean r12 = shouldForceRoundedIcon();
        final ArrayList r13 = new ArrayList();
        r1.sort(Comparator.comparingInt(new DashboardFragment$$ExternalSyntheticLambda16()));
        Iterator<Tile> r14 = r1.iterator();
    L12:
        if (r14.hasNext() == false) goto L34;
        Tile r15 = r14.next();
        String r7 = this.mDashboardFeatureProvider.getDashboardKeyForTile(r15);
        if (TextUtils.isEmpty(r7) == true) goto L15;
        if (displayTile(r15) == false) goto L12;
        if (this.mDashboardTilePrefKeys.containsKey(r7) == false) goto L22;
        boolean r3 = r12;
        List<DynamicDataObserver> r2 = this.mDashboardFeatureProvider.bindPreferenceToTileAndGetObservers(getActivity(), this, r3, r10.findPreference(r7), r15, r7, this.mPlaceholderPreferenceController.getOrder());
        String r16 = r7;
    L31:
        if (r2 == null) goto L33;
        r13.addAll(r2);
    L33:
        r11.remove(r16);
        r12 = r12;
        r14 = r14;
        goto L12
    L22:
        Preference r6 = createPreference(r15);
        r16 = r7;
        r2 = this.mDashboardFeatureProvider.bindPreferenceToTileAndGetObservers(getActivity(), this, r12, r6, r15, r7, this.mPlaceholderPreferenceController.getOrder());
        if (r15.hasGroupKey() == true) goto L25;
    L29:
        r10.addPreference(r6);
    L30:
        registerDynamicDataObservers(r2);
        this.mDashboardTilePrefKeys.put(r16, r2);
        goto L31
    L25:
        if (this.mDashboardTilePrefKeys.containsKey(r15.getGroupKey()) == false) goto L29;
        Preference r4 = r10.findPreference(r15.getGroupKey());
        if ((r4 instanceof PreferenceCategory) == false) goto L30;
        ((PreferenceCategory) r4).addPreference(r6);
        goto L30
    L15:
        OLog.d(r20, "tile does not contain a key, skipping " + r15);
        goto L12
    L34:
        Iterator r5 = r11.entrySet().iterator();
    L36:
        if (r5.hasNext() == false) goto L42;
        Map.Entry r8 = (Map.Entry) r5.next();
        String r9 = (String) r8.getKey();
        this.mDashboardTilePrefKeys.remove(r9);
        Preference r17 = r10.findPreference(r9);
        if (r17 == null) goto L40;
        r10.removePreference(r17);
    L40:
        unregisterDynamicDataObservers((List) r8.getValue());
        goto L36
    L42:
        if (r13.isEmpty() == true) goto L56;
        final CountDownLatch r18 = new CountDownLatch(1);
        new Thread(new DashboardFragment$$ExternalSyntheticLambda17(this, r13, r18)).start();
        OLog.d(r20, "Start waiting observers");
        awaitObserverLatch(r18);
        OLog.d(r20, "Stop waiting observers");
        r13.forEach(new DashboardFragment$$ExternalSyntheticLambda1());
        return;
    }

    static /* synthetic */ int lambda$refreshDashboardTiles$9(Tile r1) {
        if (r1.getType() != Tile.Type.GROUP) goto L5;
        return 0;
    L5:
        return 1;
    }

    /* JADX INFO: renamed from: lambda$refreshDashboardTiles$11$com-android-settings-dashboard-DashboardFragment, reason: not valid java name */
    /* synthetic */ void m416xb411ca7a(List r2, CountDownLatch r3) {
        r2.forEach(new DashboardFragment$$ExternalSyntheticLambda5(this));
        r3.countDown();
    }

    /* JADX INFO: renamed from: lambda$refreshDashboardTiles$10$com-android-settings-dashboard-DashboardFragment, reason: not valid java name */
    /* synthetic */ void m415xc268245b(DynamicDataObserver r1) {
        awaitObserverLatch(r1.getCountDownLatch());
    }

    @Override // com.android.settings.core.BasePreferenceController.UiBlockListener
    public void onBlockerWorkFinished(BasePreferenceController r3) {
        this.mBlockerController.countDown(r3.getPreferenceKey());
        r3.setUiBlockerFinished(this.mBlockerController.isBlockerFinished());
    }

    protected Preference createPreference(Tile r7) {
        int r0 = AnonymousClass1.$SwitchMap$com$android$settingslib$drawer$Tile$Type[r7.getType().ordinal()];
        if (r0 != 1) goto L5;
        Preference r8 = new Preference(getPrefContext());
        r8.setWidgetLayoutResource(R.layout.preference_external_action_icon);
        return r8;
    L5:
        if (r0 == 2) goto L17;
        if (r0 == 3) goto L15;
        if (r0 != 4) goto L11;
        MetricsFeatureProvider r1 = new MetricsFeatureProvider();
        r1.action(r1.getAttribution(getActivity()), 1835, getMetricsCategory(), r7.getKey(getContext()), 0);
        return new PreferenceCategory(getPrefContext());
    L11:
        return new Preference(getPrefContext());
    L15:
        return new PrimarySwitchPreference(getPrefContext());
    L17:
        return new SwitchPreferenceCompat(getPrefContext());
    }

    void registerDynamicDataObservers(List<DynamicDataObserver> r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.isEmpty() == true) goto L9;
        final ContentResolver r0 = getContentResolver();
        r3.forEach(new DashboardFragment$$ExternalSyntheticLambda6(this, r0));
        return;
    }

    /* JADX INFO: renamed from: lambda$registerDynamicDataObservers$12$com-android-settings-dashboard-DashboardFragment, reason: not valid java name */
    /* synthetic */ void m417xfab7ccfe(ContentResolver r1, DynamicDataObserver r2) {
        registerDynamicDataObserver(r1, r2);
    }

    private void registerDynamicDataObserver(ContentResolver r4, DynamicDataObserver r5) {
        OLog.d(TAG, "register observer: @" + Integer.toHexString(r5.hashCode()) + ", uri: " + r5.getUri());
        r4.registerContentObserver(r5.getUri(), false, r5);     // Catch: Exception -> L5
        this.mRegisteredObservers.add(r5);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        OLog.w(TAG, "Cannot register observer: " + r5.getUri(), e);
    }

    private void unregisterDynamicDataObservers(List<DynamicDataObserver> r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.isEmpty() == true) goto L9;
        final ContentResolver r0 = getContentResolver();
        r3.forEach(new DashboardFragment$$ExternalSyntheticLambda14(this, r0));
        return;
    }

    /* JADX INFO: renamed from: lambda$unregisterDynamicDataObservers$13$com-android-settings-dashboard-DashboardFragment, reason: not valid java name */
    /* synthetic */ void m418x1efe0c76(ContentResolver r3, DynamicDataObserver r4) {
        OLog.d(TAG, "unregister observer: @" + Integer.toHexString(r4.hashCode()) + ", uri: " + r4.getUri());
        if (this.mRegisteredObservers.remove(r4) == false) goto L11;
        r3.unregisterContentObserver(r4);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        OLog.w(TAG, "Cannot unregister observer: " + r4.getUri(), e);
        return;
    }

    private void awaitObserverLatch(CountDownLatch r3) {
        r3.await(50, TimeUnit.MILLISECONDS);     // Catch: InterruptedException -> L4
        return;
    }
}
