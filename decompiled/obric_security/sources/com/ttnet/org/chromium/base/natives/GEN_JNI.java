package com.ttnet.org.chromium.base.natives;

import J.N;

/* JADX INFO: loaded from: classes4.dex */
public class GEN_JNI {
    public static final boolean REQUIRE_MOCK = false;
    public static final boolean TESTING_ENABLED = false;

    public GEN_JNI() {
    }

    public static void com_ttnet_org_chromium_base_ApplicationStatus_onApplicationStateChange(int r0) {
        N.M$lotPPc(r0);
    }

    public static boolean com_ttnet_org_chromium_base_BaseFeatureList_isEnabled(String r0) {
        return N.Mtllg_IO(r0);
    }

    public static void com_ttnet_org_chromium_base_CommandLine_init(String[] r0) {
        N.MZSU27YP(r0);
    }

    public static boolean com_ttnet_org_chromium_base_CommandLine_hasSwitch(String r0) {
        return N.MhlgTxh2(r0);
    }

    public static String com_ttnet_org_chromium_base_CommandLine_getSwitchValue(String r0) {
        return N.MaCXZYAa(r0);
    }

    public static String[] com_ttnet_org_chromium_base_CommandLine_getSwitchesFlattened() {
        return N.MahsXrQs();
    }

    public static void com_ttnet_org_chromium_base_CommandLine_appendSwitch(String r0) {
        N.MawtMrJF(r0);
    }

    public static void com_ttnet_org_chromium_base_CommandLine_appendSwitchWithValue(String r0, String r1) {
        N.MIZelAXD(r0, r1);
    }

    public static void com_ttnet_org_chromium_base_CommandLine_appendSwitchesAndArguments(String[] r0) {
        N.MjOVh1Zv(r0);
    }

    public static void com_ttnet_org_chromium_base_CommandLine_removeSwitch(String r0) {
        N.MP5WQt3J(r0);
    }

    public static int com_ttnet_org_chromium_base_CpuFeatures_getCoreCount() {
        return N.Mcaj_8qf();
    }

    public static long com_ttnet_org_chromium_base_CpuFeatures_getCpuFeatures() {
        return N.M1UV95tj();
    }

    public static void com_ttnet_org_chromium_base_EarlyTraceEvent_recordEarlyBeginEvent(String r0, long r1, int r3, long r4) {
        N.MCawLSFP(r0, r1, r3, r4);
    }

    public static void com_ttnet_org_chromium_base_EarlyTraceEvent_recordEarlyEndEvent(String r0, long r1, int r3, long r4) {
        N.MvvW3g4w(r0, r1, r3, r4);
    }

    public static void com_ttnet_org_chromium_base_EarlyTraceEvent_recordEarlyToplevelBeginEvent(String r0, long r1, int r3, long r4) {
        N.MjWH5Jmd(r0, r1, r3, r4);
    }

    public static void com_ttnet_org_chromium_base_EarlyTraceEvent_recordEarlyToplevelEndEvent(String r0, long r1, int r3, long r4) {
        N.MoB6dYvZ(r0, r1, r3, r4);
    }

    public static void com_ttnet_org_chromium_base_EarlyTraceEvent_recordEarlyAsyncBeginEvent(String r0, long r1, long r3) {
        N.M88o6Bs3(r0, r1, r3);
    }

    public static void com_ttnet_org_chromium_base_EarlyTraceEvent_recordEarlyAsyncEndEvent(String r0, long r1, long r3) {
        N.MohIB14s(r0, r1, r3);
    }

    public static boolean com_ttnet_org_chromium_base_FeatureList_isInitialized() {
        return N.Md1lGM43();
    }

    public static boolean com_ttnet_org_chromium_base_Features_isEnabled(long r0) {
        return N.MoITUwC2(r0);
    }

    public static boolean com_ttnet_org_chromium_base_Features_getFieldTrialParamByFeatureAsBoolean(long r0, String r2, boolean r3) {
        return N.MiTw3O_J(r0, r2, r3);
    }

    public static String com_ttnet_org_chromium_base_FieldTrialList_findFullName(String r0) {
        return N.MfcktC_e(r0);
    }

    public static boolean com_ttnet_org_chromium_base_FieldTrialList_trialExists(String r0) {
        return N.MBEGQVWX(r0);
    }

    public static String com_ttnet_org_chromium_base_FieldTrialList_getVariationParameter(String r0, String r1) {
        return N.Msd5Ns7Y(r0, r1);
    }

    public static void com_ttnet_org_chromium_base_FieldTrialList_logActiveTrials() {
        N.M2n_z3BB();
    }

    public static boolean com_ttnet_org_chromium_base_FieldTrialList_createFieldTrial(String r0, String r1) {
        return N.MzhBrODy(r0, r1);
    }

    public static String com_ttnet_org_chromium_base_FileUtils_getAbsoluteFilePath(String r0) {
        return N.MKMoqNq6(r0);
    }

    public static boolean com_ttnet_org_chromium_base_ImportantFileWriterAndroid_writeFileAtomically(String r0, byte[] r1) {
        return N.M1jycjxU(r0, r1);
    }

    public static void com_ttnet_org_chromium_base_JavaExceptionReporter_reportJavaException(boolean r0, Throwable r1) {
        N.M9gfm$zh(r0, r1);
    }

    public static void com_ttnet_org_chromium_base_JavaExceptionReporter_reportJavaStackTrace(String r0) {
        N.MuvJZ5jK(r0);
    }

    public static void com_ttnet_org_chromium_base_JavaHandlerThread_initializeThread(long r0, long r2) {
        N.M3RaWo13(r0, r2);
    }

    public static void com_ttnet_org_chromium_base_JavaHandlerThread_onLooperStopped(long r0) {
        N.MSKUcgE4(r0);
    }

    public static void com_ttnet_org_chromium_base_PathService_override(int r0, String r1) {
        N.MvMFfChw(r0, r1);
    }

    public static void com_ttnet_org_chromium_base_PowerMonitor_onBatteryChargingChanged() {
        N.MxETr4iO();
    }

    public static void com_ttnet_org_chromium_base_PowerMonitor_onSuspend() {
        N.MBffe1lF();
    }

    public static void com_ttnet_org_chromium_base_PowerMonitor_onResume() {
        N.MyS7kauI();
    }

    public static void com_ttnet_org_chromium_base_PowerMonitor_onInstantSuspend() {
        N.MolcG1Wq();
    }

    public static void com_ttnet_org_chromium_base_PowerMonitor_onInstantResume() {
        N.MELAwTDU();
    }

    public static void com_ttnet_org_chromium_base_PowerMonitor_onThermalStatusChanged(int r0) {
        N.MuSEGQ9M(r0);
    }

    public static void com_ttnet_org_chromium_base_SysUtils_logPageFaultCountToTracing() {
        N.Mm3sCch3();
    }

    public static void com_ttnet_org_chromium_base_TraceEvent_registerEnabledObserver() {
        N.M8F7L$JR();
    }

    public static void com_ttnet_org_chromium_base_TraceEvent_startATrace(String r0) {
        N.MiUfkLIq(r0);
    }

    public static void com_ttnet_org_chromium_base_TraceEvent_stopATrace() {
        N.MTnadCLu();
    }

    public static void com_ttnet_org_chromium_base_TraceEvent_setupATraceStartupTrace(String r0) {
        N.M8MvK2gp(r0);
    }

    public static void com_ttnet_org_chromium_base_TraceEvent_instant(String r0, String r1) {
        N.Mz5qii_R(r0, r1);
    }

    public static void com_ttnet_org_chromium_base_TraceEvent_begin(String r0, String r1) {
        N.MajVTFsV(r0, r1);
    }

    public static void com_ttnet_org_chromium_base_TraceEvent_end(String r0, String r1) {
        N.M5yUVmrW(r0, r1);
    }

    public static void com_ttnet_org_chromium_base_TraceEvent_beginToplevel(String r0) {
        N.MljCyOuh(r0);
    }

    public static void com_ttnet_org_chromium_base_TraceEvent_endToplevel(String r0) {
        N.M6R6NWXS(r0);
    }

    public static void com_ttnet_org_chromium_base_TraceEvent_startAsync(String r0, long r1) {
        N.MKlPFTpb(r0, r1);
    }

    public static void com_ttnet_org_chromium_base_TraceEvent_finishAsync(String r0, long r1) {
        N.MjXrJVoa(r0, r1);
    }

    public static boolean com_ttnet_org_chromium_base_TraceEvent_viewHierarchyDumpEnabled() {
        return N.MpI7Xy5x();
    }

    public static void com_ttnet_org_chromium_base_TraceEvent_initViewHierarchyDump() {
        N.MgOuiubc();
    }

    public static long com_ttnet_org_chromium_base_TraceEvent_startActivityDump(String r0, long r1) {
        return N.MgxFMA1H(r0, r1);
    }

    public static void com_ttnet_org_chromium_base_TraceEvent_addViewDump(int r0, int r1, boolean r2, boolean r3, String r4, String r5, long r6) {
        N.MxGy3cn_(r0, r1, r2, r3, r4, r5, r6);
    }

    public static void com_ttnet_org_chromium_base_TraceEvent_instantAndroidIPC(String r0, long r1) {
        N.MMXoiNW_(r0, r1);
    }

    public static void com_ttnet_org_chromium_base_jank_1tracker_JankMetricUMARecorder_recordJankMetrics(String r0, long[] r1, long[] r2, long[] r3, int r4) {
        N.Mw$h3q2i(r0, r1, r2, r3, r4);
    }

    public static boolean com_ttnet_org_chromium_base_library_1loader_LibraryLoader_libraryLoaded(int r0) {
        return N.MnwWsRxg(r0);
    }

    public static void com_ttnet_org_chromium_base_library_1loader_LibraryLoader_registerNonMainDexJni() {
        N.MU8nwPRG();
    }

    public static void com_ttnet_org_chromium_base_library_1loader_LibraryPrefetcher_forkAndPrefetchNativeLibrary() {
        N.MVIMN27T();
    }

    public static int com_ttnet_org_chromium_base_library_1loader_LibraryPrefetcher_percentageOfResidentNativeLibraryCode() {
        return N.MA6QAXj_();
    }

    public static void com_ttnet_org_chromium_base_library_1loader_LibraryPrefetcher_periodicallyCollectResidency() {
        N.MtuV2SWL();
    }

    public static long com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_recordBooleanHistogram(String r0, long r1, boolean r3) {
        return N.MYPj82kt(r0, r1, r3);
    }

    public static long com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_recordExponentialHistogram(String r0, long r1, int r3, int r4, int r5, int r6) {
        return N.M45N7QIN(r0, r1, r3, r4, r5, r6);
    }

    public static long com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_recordLinearHistogram(String r0, long r1, int r3, int r4, int r5, int r6) {
        return N.Mx1k0LvC(r0, r1, r3, r4, r5, r6);
    }

    public static long com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_recordSparseHistogram(String r0, long r1, int r3) {
        return N.MV$7$UuP(r0, r1, r3);
    }

    public static void com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_recordUserAction(String r0, long r1) {
        N.MxViw_go(r0, r1);
    }

    public static int com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_getHistogramValueCountForTesting(String r0, int r1, long r2) {
        return N.MkFXHbyW_ForTesting(r0, r1, r2);
    }

    public static int com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_getHistogramTotalCountForTesting(String r0, long r1) {
        return N.M7NlTYxi_ForTesting(r0, r1);
    }

    public static long com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_createHistogramSnapshotForTesting() {
        return N.M_034fMZ_ForTesting();
    }

    public static void com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_destroyHistogramSnapshotForTesting(long r0) {
        N.Me95ZC6G_ForTesting(r0);
    }

    public static long com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_addActionCallbackForTesting(Object r2) {
        return N.MDoBOCZO_ForTesting(r2);
    }

    public static void com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_removeActionCallbackForTesting(long r0) {
        N.MYkUp9vo_ForTesting(r0);
    }

    public static String com_ttnet_org_chromium_base_metrics_StatisticsRecorderAndroid_toJson(int r0) {
        return N.M5gAmtvn(r0);
    }

    public static void com_ttnet_org_chromium_base_task_PostTask_postDelayedTask(int r0, boolean r1, boolean r2, byte r3, byte[] r4, Object r5, long r6, String r8) {
        N.Mwr17eXX(r0, r1, r2, r3, r4, r5, r6, r8);
    }

    public static long com_ttnet_org_chromium_base_task_TaskRunnerImpl_init(int r0, int r1, boolean r2, boolean r3, byte r4, byte[] r5) {
        return N.MLtH82Um(r0, r1, r2, r3, r4, r5);
    }

    public static void com_ttnet_org_chromium_base_task_TaskRunnerImpl_destroy(long r0) {
        N.Mvd960xb(r0);
    }

    public static void com_ttnet_org_chromium_base_task_TaskRunnerImpl_postDelayedTask(long r0, Object r2, long r3, String r5) {
        N.MJ_h_2p2(r0, r2, r3, r5);
    }

    public static boolean com_ttnet_org_chromium_base_task_TaskRunnerImpl_belongsToCurrentThread(long r0) {
        return N.Mz$BG_4y(r0);
    }

    public static void com_ttnet_org_chromium_net_AndroidNetworkLibrary_onCellularAlwaysUp(boolean r0, int r1) {
        N.MeYG7FqD(r0, r1);
    }

    public static String com_ttnet_org_chromium_net_GURLUtils_getOrigin(String r0) {
        return N.McGsvqvj(r0);
    }

    public static void com_ttnet_org_chromium_net_HttpNegotiateAuthenticator_setResult(long r0, Object r2, int r3, String r4) {
        N.MsAf1sYp(r0, r2, r3, r4);
    }

    public static boolean com_ttnet_org_chromium_net_HttpUtil_isAllowedHeader(String r0, String r1) {
        return N.MsTaj7yX(r0, r1);
    }

    public static void com_ttnet_org_chromium_net_NetworkActiveNotifier_notifyOfDefaultNetworkActive(long r0) {
        N.M5aI8A5Z(r0);
    }

    public static void com_ttnet_org_chromium_net_NetworkChangeNotifier_notifyConnectionTypeChanged(long r0, Object r2, int r3, long r4) {
        N.MjJzrRFH(r0, r2, r3, r4);
    }

    public static void com_ttnet_org_chromium_net_NetworkChangeNotifier_notifyConnectionCostChanged(long r0, Object r2, int r3) {
        N.MZnuk2LK(r0, r2, r3);
    }

    public static void com_ttnet_org_chromium_net_NetworkChangeNotifier_notifyMaxBandwidthChanged(long r0, Object r2, int r3) {
        N.MqNJnYjG(r0, r2, r3);
    }

    public static void com_ttnet_org_chromium_net_NetworkChangeNotifier_notifyOfNetworkConnect(long r0, Object r2, long r3, boolean r5, int r6) {
        N.MZ5e75rQ(r0, r2, r3, r5, r6);
    }

    public static void com_ttnet_org_chromium_net_NetworkChangeNotifier_notifyOfNetworkSoonToDisconnect(long r0, Object r2, long r3) {
        N.MssT8yD3(r0, r2, r3);
    }

    public static void com_ttnet_org_chromium_net_NetworkChangeNotifier_notifyOfNetworkDisconnect(long r0, Object r2, boolean r3, long r4) {
        N.Ms7JLaGI(r0, r2, r3, r4);
    }

    public static void com_ttnet_org_chromium_net_NetworkChangeNotifier_notifyPurgeActiveNetworkList(long r0, Object r2, long[] r3) {
        N.Mvng38R0(r0, r2, r3);
    }

    public static void com_ttnet_org_chromium_net_ProxyChangeListener_proxySettingsChangedTo(long r0, Object r2, String r3, int r4, String r5, String[] r6) {
        N.MtXZ30qk(r0, r2, r3, r4, r5, r6);
    }

    public static void com_ttnet_org_chromium_net_ProxyChangeListener_proxySettingsChanged(long r0, Object r2) {
        N.MKwsFZ4t(r0, r2);
    }

    public static boolean com_ttnet_org_chromium_net_TTAppSecurityManager_isUserPrivacyRestrictionEnabled() {
        return N.MaSRwBiO();
    }

    public static boolean com_ttnet_org_chromium_net_TTAppSecurityManager_isTTPRestrictionEnabled() {
        return N.Mhd7DRFo();
    }

    public static void com_ttnet_org_chromium_net_TTSocketAccelerate_OnCheckSystemAvailableResult(long r0, Object r2, int r3) {
        N.MXvQH$ie(r0, r2, r3);
    }

    public static void com_ttnet_org_chromium_net_TTSocketAccelerate_OnNotifyAccelerateResult(long r0, Object r2, int r3, int r4) {
        N.MOfWrYJI(r0, r2, r3, r4);
    }

    public static void com_ttnet_org_chromium_net_X509Util_notifyKeyChainChanged() {
        N.MzV1TXLS();
    }

    public static long com_ttnet_org_chromium_net_impl_CronetBidirectionalStream_createBidirectionalStream(Object r0, long r1, boolean r3, boolean r4, int r5, boolean r6, int r7, long r8) {
        return N.MSnVviPU(r0, r1, r3, r4, r5, r6, r7, r8);
    }

    public static int com_ttnet_org_chromium_net_impl_CronetBidirectionalStream_start(long r0, Object r2, String r3, int r4, String r5, String[] r6, boolean r7) {
        return N.MycrIbGr(r0, r2, r3, r4, r5, r6, r7);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetBidirectionalStream_sendRequestHeaders(long r0, Object r2) {
        N.MhETl_ev(r0, r2);
    }

    public static boolean com_ttnet_org_chromium_net_impl_CronetBidirectionalStream_readData(long r0, Object r2, Object r3, int r4, int r5) {
        return N.M21CWxxV(r0, r2, r3, r4, r5);
    }

    public static boolean com_ttnet_org_chromium_net_impl_CronetBidirectionalStream_writevData(long r0, Object r2, Object[] r3, int[] r4, int[] r5, boolean r6) {
        return N.MYRRygif(r0, r2, r3, r4, r5, r6);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetBidirectionalStream_destroy(long r0, Object r2, boolean r3) {
        N.My0p82p4(r0, r2, r3);
    }

    public static long com_ttnet_org_chromium_net_impl_CronetFrontierClient_createFrontierClientAdapter(Object r2) {
        return N.MagNlhNv(r2);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetFrontierClient_addHeader(long r0, Object r2, String r3, String r4) {
        N.MwZrRAIG(r0, r2, r3, r4);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetFrontierClient_addServiceId(long r0, Object r2, int r3) {
        N.Msf3H5kQ(r0, r2, r3);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetFrontierClient_configParams(long r0, Object r2, int r3, int r4, String r5, int r6, String r7, String r8, String r9, String r10, int r11, int r12, int r13, boolean r14, String r15, String r16) {
        N.Mhk1t9AY(r0, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetFrontierClient_registerService(long r0, Object r2, String[] r3, Object r4, int r5, int r6, boolean r7) {
        N.MKu8Zh_d(r0, r2, r3, r4, r5, r6, r7);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetFrontierClient_unregisterService(long r0, Object r2, int r3) {
        N.M4rPfgYd(r0, r2, r3);
    }

    public static boolean com_ttnet_org_chromium_net_impl_CronetFrontierClient_isServiceReady(long r0, Object r2, int r3) {
        return N.My_P9YPg(r0, r2, r3);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetFrontierClient_sendMessage(long r0, Object r2, int r3, String[] r4, Object r5) {
        N.MKYiSehZ(r0, r2, r3, r4, r5);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetFrontierClient_reportAppStateChange(long r0, Object r2, boolean r3) {
        N.MlH8$Rpg(r0, r2, r3);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetFrontierClient_destroy(long r0, Object r2) {
        N.MKRYs$fc(r0, r2);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetLibraryLoader_cronetInitOnInitThread() {
        N.MyweRqSS();
    }

    public static String com_ttnet_org_chromium_net_impl_CronetLibraryLoader_getCronetVersion() {
        return N.MVlvYo_c();
    }

    public static void com_ttnet_org_chromium_net_impl_CronetLibraryLoader_createNetworkChangeNotifierOnInitThread() {
        N.MhrJ$_b0();
    }

    public static long com_ttnet_org_chromium_net_impl_CronetUploadDataStream_attachUploadDataToRequest(Object r0, long r1, long r3) {
        return N.M89UGLMC(r0, r1, r3);
    }

    public static long com_ttnet_org_chromium_net_impl_CronetUploadDataStream_createAdapterForTesting(Object r2) {
        return N.M3b_yKC0_ForTesting(r2);
    }

    public static long com_ttnet_org_chromium_net_impl_CronetUploadDataStream_createUploadDataStreamForTesting(Object r0, long r1, long r3) {
        return N.MKATyFlf_ForTesting(r0, r1, r3);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUploadDataStream_onReadSucceeded(long r0, Object r2, int r3, boolean r4) {
        N.MYsxiVBk(r0, r2, r3, r4);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUploadDataStream_onRewindSucceeded(long r0, Object r2) {
        N.M3Tck9nA(r0, r2);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUploadDataStream_destroy(long r0) {
        N.Mx3T_YwB(r0);
    }

    public static long com_ttnet_org_chromium_net_impl_CronetUrlRequest_createRequestAdapter(Object r0, long r1, String r3, int r4, int r5, boolean r6, boolean r7, boolean r8, int r9, boolean r10, int r11, int r12, long r13) {
        return N.MnXVOzVo(r0, r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    }

    public static boolean com_ttnet_org_chromium_net_impl_CronetUrlRequest_setHttpMethod(long r0, Object r2, String r3) {
        return N.MfdvbiJC(r0, r2, r3);
    }

    public static boolean com_ttnet_org_chromium_net_impl_CronetUrlRequest_addRequestHeader(long r0, Object r2, String r3, String r4) {
        return N.MtJFji5x(r0, r2, r3, r4);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequest_start(long r0, Object r2) {
        N.Mv2a151P(r0, r2);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequest_followDeferredRedirect(long r0, Object r2) {
        N.MhCyx70S(r0, r2);
    }

    public static boolean com_ttnet_org_chromium_net_impl_CronetUrlRequest_readData(long r0, Object r2, Object r3, int r4, int r5) {
        return N.MJbYA4in(r0, r2, r3, r4, r5);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequest_destroy(long r0, Object r2, boolean r3) {
        N.MIb9tt7_(r0, r2, r3);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequest_appTimeout(long r0, Object r2) {
        N.M3xsE8SK(r0, r2);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequest_abortWhenUploadException(long r0, Object r2) {
        N.MzKjGz9N(r0, r2);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequest_stopRedirect(long r0, Object r2) {
        N.MFMoBdtW(r0, r2);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequest_addRequestCookieHeader(long r0, Object r2, String r3, String r4) {
        N.M2jrbUOP(r0, r2, r3, r4);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequest_removeRequestCookieHeader(long r0, Object r2) {
        N.MjbEhTZs(r0, r2);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequest_setSocketTimeout(long r0, Object r2, int r3, int r4, int r5) {
        N.M4C6WZaz(r0, r2, r3, r4, r5);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequest_setRequestTimeout(long r0, Object r2, int r3) {
        N.MaFGwSbC(r0, r2, r3);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequest_setThrottleNetSpeed(long r0, Object r2, long r3) {
        N.ML2WrLQ6(r0, r2, r3);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequest_setRequestTypeFlags(long r0, Object r2, int r3) {
        N.MC7pScOk(r0, r2, r3);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequest_setAuthCredentials(long r0, Object r2, String r3, String r4) {
        N.Mor7A21H(r0, r2, r3, r4);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequest_getStatus(long r0, Object r2, Object r3) {
        N.MmSvKAJE(r0, r2, r3);
    }

    public static long com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_createRequestContextConfig(String r0, String r1, boolean r2, String r3, boolean r4, boolean r5, boolean r6, int r7, long r8, String r10, long r11, boolean r13, boolean r14, int r15) {
        return N.Mmo_MQVE(r0, r1, r2, r3, r4, r5, r6, r7, r8, r10, r11, r13, r14, r15);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_addQuicHint(long r0, String r2, int r3, int r4) {
        N.M6WZ7Wt0(r0, r2, r3, r4);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_addPkp(long r0, String r2, byte[][] r3, boolean r4, long r5) {
        N.Mkx3KULb(r0, r2, r3, r4, r5);
    }

    public static long com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_createRequestContextAdapter(long r0) {
        return N.MuixiOYs(r0);
    }

    public static int com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setMinLogLevel(int r0) {
        return N.MyyJ5zsH(r0);
    }

    public static byte[] com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_getHistogramDeltas() {
        return N.MdOiNSC0();
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_destroy(long r0, Object r2) {
        N.MG$DT18r(r0, r2);
    }

    public static boolean com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_startNetLogToFile(long r0, Object r2, String r3, boolean r4) {
        return N.Mt89JXhb(r0, r2, r3, r4);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_startNetLogToDisk(long r0, Object r2, String r3, boolean r4, int r5) {
        N.MuR7zLrb(r0, r2, r3, r4, r5);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_stopNetLog(long r0, Object r2) {
        N.ML5dVOOG(r0, r2);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_initRequestContextOnInitThread(long r0, Object r2) {
        N.Mdu$OLLN(r0, r2);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_configureNetworkQualityEstimatorForTesting(long r0, Object r2, boolean r3, boolean r4, boolean r5) {
        N.MNAF9eXw_ForTesting(r0, r2, r3, r4, r5);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_provideRTTObservations(long r0, Object r2, boolean r3) {
        N.Mk1UqBGq(r0, r2, r3);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setTTNetInitConfig(long r0, int r2, boolean r3, boolean r4, String r5, String r6, String r7, boolean r8, String r9, String r10, byte[][] r11, Object[] r12, boolean r13, boolean r14, boolean r15, String r16, Object r17, long r18, boolean r20, boolean r21, boolean r22, Object r23, boolean r24, String r25) {
        N.MawZO189(r0, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r20, r21, r22, r23, r24, r25);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setClientOpaqueData(long r0, String[] r2, byte[] r3, byte[] r4) {
        N.MTZ7mkhc(r0, r2, r3, r4);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_initALogFuncAddr(long r0) {
        N.MjS9m1YQ(r0);
    }

    public static long[] com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_getOpaqueFuncAddress() {
        return N.MlOQJZ8w();
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_parseTNCConfigFromSystemHTTPRequest(long r0, Object r2, String r3, String r4, String r5, String r6, String r7, String r8) {
        N.MU6k4d25(r0, r2, r3, r4, r5, r6, r7, r8);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_triggerTNCRequestByUser(long r0, Object r2, boolean r3) {
        N.MN8yyQkr(r0, r2, r3);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_ttUrlDispatch(long r0, Object r2, Object r3, String r4, boolean r5) {
        N.MRTGlzo1(r0, r2, r3, r4, r5);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_runInBackGround(long r0, Object r2, boolean r3) {
        N.MWOUQ7KG(r0, r2, r3);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_addClientOpaqueData(long r0, Object r2, String[] r3, byte[] r4, byte[] r5, long r6, long r8) {
        N.MWb1lJ5e(r0, r2, r3, r4, r5, r6, r8);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_clearClientOpaqueData(long r0, Object r2) {
        N.MK0SE_Ub(r0, r2);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_removeClientOpaqueData(long r0, Object r2, String r3) {
        N.Mcfn2q8$(r0, r2, r3);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setProxy(long r0, Object r2, String r3) {
        N.Mj4Pi_Pa(r0, r2, r3);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_preconnectUrl(long r0, Object r2, String r3, int r4, String r5) {
        N.MBtj30QU(r0, r2, r3, r4, r5);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_ttDnsResolve(long r0, Object r2, String r3, int r4, String r5, String r6) {
        N.MH0muaR3(r0, r2, r3, r4, r5, r6);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_controlHttpDNSConfig(long r0, Object r2, boolean r3, boolean r4, boolean r5) {
        N.MHps7uOC(r0, r2, r3, r4, r5);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setHostResolverRules(long r0, Object r2, String r3) {
        N.MlH1XMiR(r0, r2, r3);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_addSamplingSetting(long r0, Object r2, Object r3) {
        N.MKYzOUkj(r0, r2, r3);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_tryStartNetDetect(long r0, Object r2, String[] r3, int r4, int r5) {
        N.MA5SsGAv(r0, r2, r3, r4, r5);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_updateStoreRegionFromServer(long r0, Object r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11, String r12, String r13) {
        N.MqjX8qD1(r0, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setAlogFuncAddr(long r0, Object r2, long r3) {
        N.Me3xdZoU(r0, r2, r3);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setZstdFuncAddr(long r0, Object r2, long r3, long r5, long r7, long r9, long r11, long r13, long r15, long r17) {
        N.MIs1FVFz(r0, r2, r3, r5, r7, r9, r11, r13, r15, r17);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setRouteSelectionBestHost(long r0, Object r2, String r3, String r4) {
        N.MhbNiNFL(r0, r2, r3, r4);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_startThrottle(long r0, Object r2, String[] r3, int r4, long r5) {
        N.MiGn0DCY(r0, r2, r3, r4, r5);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_stopThrottle(long r0, Object r2, String[] r3, int r4) {
        N.MohL$06P(r0, r2, r3, r4);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_enableTTBizHttpDns(long r0, Object r2, boolean r3, String r4, String r5, String r6, boolean r7, String r8) {
        N.M2ni33Tk(r0, r2, r3, r4, r5, r6, r7, r8);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_notifySwitchToMultiNetwork(long r0, Object r2, boolean r3) {
        N.Mbnl3sIw(r0, r2, r3);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_triggerWiFiToCellularByThirdParty(long r0, Object r2) {
        N.M221PN7l(r0, r2);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setAppStartUpState(long r0, Object r2, int r3) {
        N.MksRT8QX(r0, r2, r3);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setCookieInitCompleted(long r0, Object r2) {
        N.MaSOyuXL(r0, r2);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_reportNetDiagnosisUserLog(long r0, Object r2, String r3) {
        N.MPONMQm_(r0, r2, r3);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_provideThroughputObservations(long r0, Object r2, boolean r3) {
        N.MHUcn7PP(r0, r2, r3);
    }

    public static boolean com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_skipLogging(long r0, Object r2) {
        return N.MLLAskZ0(r0, r2);
    }

    public static long com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_createWebsocketConnectionAdapter(Object r0, long r1) {
        return N.MRAGjNeT(r0, r1);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_startWithFrontier(long r0, Object r2, int r3, String r4, long r5, int r7, long r8, String r10, int r11, String r12, boolean r13) {
        N.MWq0tMul(r0, r2, r3, r4, r5, r7, r8, r10, r11, r12, r13);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_startWithWSChannel(long r0, Object r2, boolean r3) {
        N.MVrBbeuj(r0, r2, r3);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_stop(long r0, Object r2) {
        N.M14GZgiH(r0, r2);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_sendText(long r0, Object r2, String r3) {
        N.MRnDfpSi(r0, r2, r3);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_sendBinary(long r0, Object r2, Object r3) {
        N.MRfZ_7V_(r0, r2, r3);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_destroy(long r0, Object r2) {
        N.MCzpxGQD(r0, r2);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_addUrl(long r0, Object r2, String r3) {
        N.MgN9hn8A(r0, r2, r3);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_addHeader(long r0, Object r2, String r3, String r4) {
        N.MKmGe$35(r0, r2, r3, r4);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_addGetParam(long r0, Object r2, String r3, String r4) {
        N.Mzisx1kZ(r0, r2, r3, r4);
    }

    public static long com_ttnet_org_chromium_net_impl_TTCronetNetExpRequest_createRequestAdapter(Object r0, long r1, int r3, String[] r4, int r5, int r6, int r7) {
        return N.MPJAsrFC(r0, r1, r3, r4, r5, r6, r7);
    }

    public static void com_ttnet_org_chromium_net_impl_TTCronetNetExpRequest_start(long r0, Object r2) {
        N.MLiR9ZbW(r0, r2);
    }

    public static void com_ttnet_org_chromium_net_impl_TTCronetNetExpRequest_destroy(long r0, Object r2) {
        N.M6$xRvea(r0, r2);
    }

    public static void com_ttnet_org_chromium_net_impl_TTCronetNetExpRequest_doExtraCommand(long r0, Object r2, String r3, String r4) {
        N.MDZjmtTn(r0, r2, r3, r4);
    }
}
