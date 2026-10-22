package com.android.settings.slices;

import android.app.PendingIntent;
import android.app.slice.SliceManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.StrictMode;
import android.os.UserManager;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.KeyValueListParser;
import androidx.collection.ArraySet;
import androidx.slice.Slice;
import androidx.slice.SliceProvider;
import com.android.settings.R;
import com.android.settings.bluetooth.BluetoothSliceBuilder;
import com.android.settings.notification.zen.ZenModeSliceBuilder;
import com.android.settings.overlay.FeatureFactory;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settingslib.SliceBroadcastRelay;
import com.android.settingslib.utils.ThreadUtils;
import com.android.vcard.VCardConfig;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.stream.Collectors;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class SettingsSliceProvider extends SliceProvider {
    public static final String ACTION_SLIDER_CHANGED = "com.android.settings.slice.action.SLIDER_CHANGED";
    public static final String ACTION_TOGGLE_CHANGED = "com.android.settings.slice.action.TOGGLE_CHANGED";
    public static final String EXTRA_SLICE_KEY = "com.android.settings.slice.extra.key";
    private static final KeyValueListParser KEY_VALUE_LIST_PARSER = null;
    private static final List<Uri> PUBLICLY_SUPPORTED_CUSTOM_SLICE_URIS = null;
    public static final String SLICE_AUTHORITY = "com.android.settings.slices";
    private static final String TAG = "SettingsSliceProvider";
    private boolean mFirstSliceBound;
    private boolean mFirstSlicePinned;
    private Boolean mNightMode;
    final Map<Uri, SliceBackgroundWorker> mPinnedWorkers;
    Map<Uri, SliceData> mSliceWeakDataCache;
    SlicesDatabaseAccessor mSlicesDatabaseAccessor;

    public void com_android_settings_slices_SettingsSliceProvider__onCreate$___twin___() {
        super.onCreate();
    }

    boolean isPrivateSlicesNeeded(Uri r1) {
        return false;
    }

    @Override // android.content.ContentProvider
    public void onCreate() {
        com_android_settings_slices_SettingsSliceProvider_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Provider(this);
    }

    static {
        PUBLICLY_SUPPORTED_CUSTOM_SLICE_URIS = Arrays.asList(new Uri[]{CustomSliceRegistry.BLUETOOTH_URI, CustomSliceRegistry.FLASHLIGHT_SLICE_URI, CustomSliceRegistry.LOCATION_SLICE_URI, CustomSliceRegistry.MOBILE_DATA_SLICE_URI, CustomSliceRegistry.WIFI_CALLING_URI, CustomSliceRegistry.WIFI_SLICE_URI, CustomSliceRegistry.ZEN_MODE_SLICE_URI});
        KEY_VALUE_LIST_PARSER = new KeyValueListParser(',');
    }

    public SettingsSliceProvider() {
        super(new String[]{"android.permission.READ_SEARCH_INDEXABLES"});
        this.mPinnedWorkers = new ArrayMap();
        OLog.d(TAG, "init");
    }

    @Override // androidx.slice.SliceProvider
    public boolean onCreateSliceProvider() {
        OLog.d(TAG, "onCreateSliceProvider");
        this.mSlicesDatabaseAccessor = new SlicesDatabaseAccessor(getContext());
        this.mSliceWeakDataCache = new WeakHashMap();
        return true;
    }

    @Override // androidx.slice.SliceProvider
    public void onSlicePinned(final Uri r8) {
        if (this.mFirstSlicePinned == true) goto L5;
        OLog.d(TAG, "onSlicePinned: " + r8);
        this.mFirstSlicePinned = true;
    L5:
        FeatureFactory.getFeatureFactory().getMetricsFeatureProvider().action(0, 1371, 0, r8.getLastPathSegment(), 0);
        if (CustomSliceRegistry.isValidUri(r8) == false) goto L13;
        final CustomSliceable r0 = FeatureFactory.getFeatureFactory().getSlicesFeatureProvider().getSliceableFromUri(getContext(), r8);
        IntentFilter r1 = r0.getIntentFilter();
        if (r1 == null) goto L10;
        registerIntentToUri(r1, r8);
    L10:
        ThreadUtils.postOnMainThread(new SettingsSliceProvider$$ExternalSyntheticLambda3(this, r0, r8));
        return;
    L13:
        if (CustomSliceRegistry.ZEN_MODE_SLICE_URI.equals(r8) == false) goto L17;
        registerIntentToUri(ZenModeSliceBuilder.INTENT_FILTER, r8);
        return;
    L17:
        if (CustomSliceRegistry.BLUETOOTH_URI.equals(r8) == false) goto L20;
        registerIntentToUri(BluetoothSliceBuilder.INTENT_FILTER, r8);
        return;
    L20:
        loadSliceInBackground(r8);
    }

    /* JADX INFO: renamed from: lambda$onSlicePinned$0$com-android-settings-slices-SettingsSliceProvider, reason: not valid java name */
    /* synthetic */ void m602xad98c52a(CustomSliceable r1, Uri r2) {
        startBackgroundWorker(r1, r2);
    }

    @Override // androidx.slice.SliceProvider
    public void onSliceUnpinned(final Uri r3) {
        this.mSliceWeakDataCache.remove(r3);
        Context r0 = getContext();
        if (VolumeSliceHelper.unregisterUri(r0, r3) == true) goto L5;
        SliceBroadcastRelay.unregisterReceivers(r0, r3);
    L5:
        ThreadUtils.postOnMainThread(new SettingsSliceProvider$$ExternalSyntheticLambda2(this, r3));
    }

    /* JADX INFO: renamed from: lambda$onSliceUnpinned$1$com-android-settings-slices-SettingsSliceProvider, reason: not valid java name */
    /* synthetic */ void m603xc3cfbac4(Uri r1) {
        stopBackgroundWorker(r1);
    }

    @Override // androidx.slice.SliceProvider
    public Slice onBindSlice(Uri r8) {
        if (this.mFirstSliceBound == true) goto L5;
        OLog.d(TAG, "onBindSlice start: " + r8);
    L5:
        StrictMode.ThreadPolicy r2 = StrictMode.getThreadPolicy();
    L71:
        th = move-exception;
        StrictMode.setThreadPolicy(r2);
        if (this.mFirstSliceBound == true) goto L75;
        OLog.v(TAG, "onBindSlice end");
        this.mFirstSliceBound = true;
    L75:
        throw th;
    L7:
        if (ThreadUtils.isMainThread() == true) goto L10;
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());     // Catch: Throwable -> L71
    L10:
        if (getBlockedKeys().contains(r8.getLastPathSegment()) == false) goto L16;
        OLog.e(TAG, "Requested blocked slice with Uri: " + r8);     // Catch: Throwable -> L71
        StrictMode.setThreadPolicy(r2);
        if (this.mFirstSliceBound == true) goto L15;
        OLog.v(TAG, "onBindSlice end");
        this.mFirstSliceBound = true;
    L15:
        return null;
    L16:
        Boolean r1 = this.mNightMode;     // Catch: Throwable -> L71
        if (r1 != null) goto L20;
        this.mNightMode = false;     // Catch: Throwable -> L71
        getContext().setTheme(2132019116);     // Catch: Throwable -> L71
    L23:
        if (((UserManager) getContext().getSystemService(UserManager.class)).isGuestUser() == false) goto L32;
        if (RestrictedSliceUtils.isGuestRestricted(r8) == false) goto L32;
        OLog.i(TAG, "Guest user access denied.");     // Catch: Throwable -> L71
        StrictMode.setThreadPolicy(r2);
        if (this.mFirstSliceBound == true) goto L30;
        OLog.v(TAG, "onBindSlice end");
        this.mFirstSliceBound = true;
    L30:
        return null;
    L32:
        if (CustomSliceRegistry.isValidUri(r8) == false) goto L39;
        Slice r9 = FeatureFactory.getFeatureFactory().getSlicesFeatureProvider().getSliceableFromUri(getContext(), r8).getSlice();     // Catch: Throwable -> L71
        StrictMode.setThreadPolicy(r2);
        if (this.mFirstSliceBound == true) goto L37;
        OLog.v(TAG, "onBindSlice end");
        this.mFirstSliceBound = true;
    L37:
        return r9;
    L39:
        if (CustomSliceRegistry.WIFI_CALLING_URI.equals(r8) == false) goto L46;
        Slice r10 = FeatureFactory.getFeatureFactory().getSlicesFeatureProvider().getNewWifiCallingSliceHelper(getContext()).createWifiCallingSlice(r8);     // Catch: Throwable -> L71
        StrictMode.setThreadPolicy(r2);
        if (this.mFirstSliceBound == true) goto L44;
        OLog.v(TAG, "onBindSlice end");
        this.mFirstSliceBound = true;
    L44:
        return r10;
    L46:
        if (CustomSliceRegistry.ZEN_MODE_SLICE_URI.equals(r8) == false) goto L53;
        Slice r11 = ZenModeSliceBuilder.getSlice(getContext());     // Catch: Throwable -> L71
        StrictMode.setThreadPolicy(r2);
        if (this.mFirstSliceBound == true) goto L51;
        OLog.v(TAG, "onBindSlice end");
        this.mFirstSliceBound = true;
    L51:
        return r11;
    L53:
        if (CustomSliceRegistry.BLUETOOTH_URI.equals(r8) == false) goto L59;
        Slice r12 = BluetoothSliceBuilder.getSlice(getContext());     // Catch: Throwable -> L71
        StrictMode.setThreadPolicy(r2);
        if (this.mFirstSliceBound == true) goto L58;
        OLog.v(TAG, "onBindSlice end");
        this.mFirstSliceBound = true;
    L58:
        return r12;
    L59:
        SliceData r3 = this.mSliceWeakDataCache.get(r8);     // Catch: Throwable -> L71
        if (r3 != null) goto L66;
        loadSliceInBackground(r8);     // Catch: Throwable -> L71
        Slice r13 = getSliceStub(r8);     // Catch: Throwable -> L71
        StrictMode.setThreadPolicy(r2);
        if (this.mFirstSliceBound == true) goto L65;
        OLog.v(TAG, "onBindSlice end");
        this.mFirstSliceBound = true;
    L65:
        return r13;
    L66:
        Slice r14 = SliceBuilderUtils.buildSlice(getContext(), r3);     // Catch: Throwable -> L71
        StrictMode.setThreadPolicy(r2);
        if (this.mFirstSliceBound == true) goto L70;
        OLog.v(TAG, "onBindSlice end");
        this.mFirstSliceBound = true;
    L70:
        return r14;
    L20:
        if (r1.booleanValue() == false) goto L23;
        OLog.d(TAG, "Night mode changed, reload theme");     // Catch: Throwable -> L71
        this.mNightMode = false;     // Catch: Throwable -> L71
        getContext().getTheme().rebase();     // Catch: Throwable -> L71
        goto L23
    }

    @Override // androidx.slice.SliceProvider
    public Collection<Uri> onGetSliceDescendants(Uri r5) {
        ArrayList r0 = new ArrayList();
        if (isPrivateSlicesNeeded(r5) == false) goto L6;
        r0.addAll(this.mSlicesDatabaseAccessor.getSliceUris(r5.getAuthority(), false));
        OLog.d(TAG, "provide " + r0.size() + " non-public slices");
        r5 = new Uri.Builder().scheme("content").authority(r5.getAuthority()).build();
    L6:
        if (SliceBuilderUtils.getPathData(r5) == null) goto L9;
        r0.add(r5);
        return r0;
    L9:
        final String r1 = r5.getAuthority();
        String r6 = r5.getPath();
        boolean r2 = r6.isEmpty();
        if (r2 == false) goto L12;
    L16:
        r0.addAll(this.mSlicesDatabaseAccessor.getSliceUris(r1, true));
        if (r2 == true) goto L19;
    L21:
        r0.addAll((List) PUBLICLY_SUPPORTED_CUSTOM_SLICE_URIS.stream().filter(new SettingsSliceProvider$$ExternalSyntheticLambda4(r1)).collect(Collectors.toList()));
    L22:
        grantAllowlistedPackagePermissions(getContext(), r0);
        return r0;
    L19:
        if (TextUtils.isEmpty(r1) == false) goto L21;
        r0.addAll(PUBLICLY_SUPPORTED_CUSTOM_SLICE_URIS);
        goto L22
    L12:
        if (TextUtils.equals(r6, "/action") == true) goto L16;
        if (TextUtils.equals(r6, "/intent") == true) goto L16;
        return r0;
    }

    static /* synthetic */ boolean lambda$onGetSliceDescendants$2(String r0, Uri r1) {
        return TextUtils.equals(r0, r1.getAuthority());
    }

    public PendingIntent onCreatePermissionRequest(Uri r2, String r3) {
        Intent r4 = new Intent("android.settings.SETTINGS").setPackage("com.android.settings");
        return PendingIntent.getActivity(getContext(), 0, r4, VCardConfig.FLAG_APPEND_TYPE_PARAM);
    }

    static void grantAllowlistedPackagePermissions(Context r5, List<Uri> r6) {
        if (r6 != null) goto L5;
        OLog.d(TAG, "No descendants to grant permission with, skipping.");
    L5:
        ArrayList r1 = new ArrayList();
        String[] r2 = r5.getResources().getStringArray(R.array.slice_allowlist_package_names);
        if (r2 == null) goto L9;
        r1.addAll(Arrays.asList(r2));
    L9:
        if (Build.IS_DEBUGGABLE == false) goto L14;
        String[] r3 = r5.getResources().getStringArray(R.array.slice_allowlist_package_names_for_dev);
        if (r3 == null) goto L14;
        r1.addAll(Arrays.asList(r3));
    L14:
        if (r1.size() != 0) goto L17;
        OLog.d(TAG, "No packages to allowlist, skipping.");
        return;
    L17:
        OLog.d(TAG, String.format("Allowlisting %d uris to %d pkgs.", new Object[]{Integer.valueOf(r6.size()), Integer.valueOf(r1.size())}));
        SliceManager r7 = (SliceManager) r5.getSystemService(SliceManager.class);
        Iterator<Uri> r8 = r6.iterator();
    L19:
        if (r8.hasNext() == false) goto L24;
        Uri r0 = r8.next();
        Iterator r4 = r1.iterator();
    L22:
        if (r4.hasNext() == false) goto L19;
        r7.grantSlicePermission((String) r4.next(), r0);
        goto L22
    }

    @Override // android.content.ContentProvider
    public void shutdown() {
        ThreadUtils.postOnMainThread(new SettingsSliceProvider$$ExternalSyntheticLambda1());
    }

    static /* synthetic */ void lambda$shutdown$3() {
        SliceBackgroundWorker.shutdown();
    }

    void loadSlice(Uri r7) {
        if (this.mSliceWeakDataCache.containsKey(r7) == false) goto L6;
        OLog.d(TAG, r7 + " loaded from cache");
        return;
    L6:
        long r2 = System.currentTimeMillis();
        SliceData r0 = this.mSlicesDatabaseAccessor.getSliceDataFromUri(r7);     // Catch: IllegalStateException -> L10
        SliceBuilderUtils.getPreferenceController(getContext(), r0);
        this.mSliceWeakDataCache.put(r7, r0);
        getContext().getContentResolver().notifyChange(r7, null);
        OLog.d(TAG, "Built slice (" + r7 + ") in: " + (System.currentTimeMillis() - r2));
        return;
    L10:
        e = move-exception;
        OLog.d(TAG, "Could not create slicedata for uri: " + r7, e);
    }

    /* JADX INFO: renamed from: lambda$loadSliceInBackground$4$com-android-settings-slices-SettingsSliceProvider, reason: not valid java name */
    /* synthetic */ void m601x10ddc522(Uri r1) {
        loadSlice(r1);
    }

    void loadSliceInBackground(final Uri r2) {
        ThreadUtils.postOnBackgroundThread(new SettingsSliceProvider$$ExternalSyntheticLambda0(this, r2));
    }

    void registerIntentToUri(IntentFilter r2, Uri r3) {
        SliceBroadcastRelay.registerReceiver(getContext(), r3, SliceRelayReceiver.class, r2);
    }

    Set<String> getBlockedKeys() {
        return new ArraySet();
    }

    private void startBackgroundWorker(Sliceable r3, Uri r4) {
        if (r3.getBackgroundWorkerClass() != null) goto L6;
        return;
    L6:
        if (this.mPinnedWorkers.containsKey(r4) == false) goto L8;
        return;
    L8:
        OLog.d(TAG, "Starting background worker for: " + r4);
        SliceBackgroundWorker r5 = SliceBackgroundWorker.getInstance(getContext(), r3, r4);
        this.mPinnedWorkers.put(r4, r5);
        r5.pin();
    }

    private void stopBackgroundWorker(Uri r4) {
        SliceBackgroundWorker r0 = this.mPinnedWorkers.get(r4);
        if (r0 == null) goto L6;
        OLog.d(TAG, "Stopping background worker for: " + r4);
        r0.unpin();
        this.mPinnedWorkers.remove(r4);
        return;
    }

    private static Slice getSliceStub(Uri r1) {
        return new Slice.Builder(r1).addHints(new String[]{"partial"}).build();
    }

    private static String[] parseStringArray(String r1) {
        if (r1 == null) goto L7;
        String[] r2 = r1.split(":");
        if (r2.length <= 0) goto L7;
        return r2;
    L7:
        return new String[0];
    }

    @TargetClass(scope = Scope.LEAF, value = "android.content.ContentProvider")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_slices_SettingsSliceProvider_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Provider(SettingsSliceProvider r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_slices_SettingsSliceProvider__onCreate$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportColdStartProvider(r0);
    L5:
        AppMetricsUtils.INSTANCE.setColdStartTime(0);
    }
}
