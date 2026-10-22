package com.android.settings;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import bytedanceos.api.PackageManagerSmt;
import com.GlobalProxyLancet;
import com.android.settings.applications.PreferredSettingsUtils;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes2.dex */
public class SetupDefaultAppService extends IntentService implements DefaultFileSetter.StatusListener {
    public static final String EVENT_FOR_FINISH_WIZARD = "event_for_finish_wizard";
    public static final String EVENT_FOR_INSTALL_WPS = "event_for_install_wps";
    public static final String EVENT_FOR_OTA_UPDATE = "event_for_ota_update";
    public static final String EVENT_FOR_UNINSTALL_APP = "event_for_uninstall_app";
    public static final String EXTRA_BUNDLE = "extra_bundle";
    public static final String EXTRA_EVENT_TYPE = "extra_event_type";
    private static final String SETUP_DEFAULT_APP_ACTION = "com.bytedanceos.action.settings.SetupDefalutAppService";
    private static final String TAG = "SetupDefaultAppService";

    public SetupDefaultAppService() {
        super(TAG);
    }

    @Override // com.android.settings.DefaultFileSetter.StatusListener
    public void onCompleted() {
        EventBus.getDefault().post(new EventType.InstallWpsEvent());
    }

    public static void start(Context r2, Bundle r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        Intent r0 = new Intent(SETUP_DEFAULT_APP_ACTION);
        r0.setClass(r2, SetupDefaultAppService.class);
        r0.setPackage("com.android.settings");
        r0.putExtra(EXTRA_BUNDLE, r3);
        r2.startService(r0);
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent r4) {
        Bundle r5 = GlobalProxyLancet.com_bytedance_sysoptimizer_BadParcelableLancet_getBundleExtra(r4, EXTRA_BUNDLE);
        String r0 = r5.getString(EXTRA_EVENT_TYPE);
        OLog.d(TAG, "handleIntent eventType: " + r0);
        if (EVENT_FOR_UNINSTALL_APP.equals(r0) == false) goto L6;
        handleUninstallApp(r5);
        return;
    L6:
        if (EVENT_FOR_FINISH_WIZARD.equals(r0) == false) goto L9;
        handleFinishWizard();
        return;
    L9:
        if (EVENT_FOR_OTA_UPDATE.equals(r0) == false) goto L12;
        handleOtaUpdate();
        return;
    L12:
        if (EVENT_FOR_INSTALL_WPS.equals(r0) == false) goto L18;
        handleInstallWpsApp();
        return;
    }

    private void handleInstallWpsApp() {
        List<String> r0 = getLocalMimeTypesWithCategory(PreferredSettingsUtils.Category.text);
        final List<String> r1 = getAlreadySetupMimeTypes();
        List r2 = (List) r0.stream().filter(new SetupDefaultAppService$$ExternalSyntheticLambda7(r1)).collect(Collectors.toList());
        DefaultFileSetter.start(getApplicationContext(), r2, PreferredSettingsUtils.Category.text, new SetupDefaultAppService$$ExternalSyntheticLambda8(this));
    }

    static /* synthetic */ boolean lambda$handleInstallWpsApp$0(List r0, String r1) {
        return !r0.contains(r1);
    }

    private void handleUninstallApp(Bundle r4) {
        ArrayList<String> r0 = r4.getStringArrayList("mime_list");
        r4.getString("uninstalled_pkg");
        if (r0 != null) goto L5;
    L9:
        OLog.d(TAG, "mimeTypes is empty, when uninstalled app.");
        return;
    L5:
        if (r0.isEmpty() == true) goto L9;
        final List<String> r5 = getLocalMimeTypesWithCategory(PreferredSettingsUtils.Category.others);
        Stream<String> r1 = r0.stream();
        Objects.requireNonNull(r5);
        Map r6 = (Map) r1.collect(Collectors.groupingBy(new SetupDefaultAppService$$ExternalSyntheticLambda6(r5)));
        DefaultFileSetter.start(getApplicationContext(), (List) r6.get(true), null);
        PreferredSettingsUtils.changeOthersMimeTypeStatus(getApplicationContext(), (List) r6.get(false), false);
    }

    private void handleFinishWizard() {
        PreferredSettingsUtils.Category[] r0 = PreferredSettingsUtils.Category.values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        PreferredSettingsUtils.Category r3 = r0[r2];
        if (r3 == PreferredSettingsUtils.Category.others) goto L8;
        List<String> r4 = getLocalMimeTypesWithCategory(r3);
        DefaultFileSetter.start(getApplicationContext(), r4, r3);
    L8:
        r2 = r2 + 1;
        goto L3
    }

    private void handleOtaUpdate() {
        final List<String> r0 = getAlreadySetupMimeTypes();
        PreferredSettingsUtils.Category[] r1 = PreferredSettingsUtils.Category.values();
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L14;
        PreferredSettingsUtils.Category r4 = r1[r3];
        if (r4 != PreferredSettingsUtils.Category.others) goto L7;
        final List<String> r5 = getLocalMimeTypesWithCategory(PreferredSettingsUtils.Category.others);
        List r6 = (List) r0.stream().filter(new SetupDefaultAppService$$ExternalSyntheticLambda0(r5)).distinct().collect(Collectors.toList());
        PreferredSettingsUtils.synchronizeOthersPreferenceData(getApplicationContext(), r6);
    L13:
        r3 = r3 + 1;
        goto L3
    L7:
        List r7 = (List) getLocalMimeTypesWithCategory(r4).stream().filter(new SetupDefaultAppService$$ExternalSyntheticLambda1(r0)).collect(Collectors.toList());
        if (r4 == PreferredSettingsUtils.Category.text) goto L10;
    L12:
        DefaultFileSetter.start(getApplicationContext(), r7, r4);
        goto L13
    L10:
        if (Utils.isAppInstalled(getApplication(), Constants.PKG_WPS) == true) goto L12;
    }

    static /* synthetic */ boolean lambda$handleOtaUpdate$1(List r1, String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
    L7:
        return false;
    L5:
        if (r1.contains(r2) == true) goto L7;
        return true;
    }

    static /* synthetic */ boolean lambda$handleOtaUpdate$2(List r1, String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
    L7:
        return false;
    L5:
        if (r1.contains(r2) == true) goto L7;
        return true;
    }

    private List<String> getLocalMimeTypesWithCategory(PreferredSettingsUtils.Category r2) {
        List<String> r1 = (List) PreferredSettingsUtils.getLocalFileTypeConfig(r2).stream().filter(new SetupDefaultAppService$$ExternalSyntheticLambda2()).flatMap(new SetupDefaultAppService$$ExternalSyntheticLambda3()).distinct().collect(Collectors.toList());
        if (r2 != PreferredSettingsUtils.Category.text) goto L5;
    L6:
        r1.add("text/html");
    L7:
        return r1;
    L5:
        if (r2 != PreferredSettingsUtils.Category.others) goto L7;
        goto L6
    }

    static /* synthetic */ boolean lambda$getLocalMimeTypesWithCategory$3(PreferredSettingsUtils.FileType r0) {
        return !TextUtils.isEmpty(r0.getMimeType());
    }

    static /* synthetic */ Stream lambda$getLocalMimeTypesWithCategory$4(PreferredSettingsUtils.FileType r1) {
        return Stream.of(r1.getMimeType().split(";"));
    }

    private List<String> getAlreadySetupMimeTypes() {
        ArrayList r0 = new ArrayList();
        PackageManagerSmt.getInstance().getAlwaysPreferredActivities(getPackageManager(), r0, new ArrayList(), null);
        if (r0.isEmpty() == true) goto L7;
        return (List) r0.stream().filter(new SetupDefaultAppService$$ExternalSyntheticLambda4()).flatMap(new SetupDefaultAppService$$ExternalSyntheticLambda5()).collect(Collectors.toList());
    L7:
        return Collections.EMPTY_LIST;
    }

    static /* synthetic */ boolean lambda$getAlreadySetupMimeTypes$5(IntentFilter r0) {
        if (r0.countDataTypes() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    static /* synthetic */ Stream lambda$getAlreadySetupMimeTypes$6(IntentFilter r1) {
        return Stream.of(r1.getDataType(0));
    }
}
