package com.android.settingslib.media;

import android.content.Context;
import android.media.MediaRoute2Info;
import android.media.MediaRouter2;
import android.media.MediaRouter2Manager;
import android.media.RouteDiscoveryPreference;
import android.media.RouteListingPreference;
import android.media.RoutingSessionInfo;
import android.media.session.MediaController;
import android.os.UserHandle;
import android.text.TextUtils;
import com.android.media.flags.Flags;
import com.android.settingslib.bluetooth.LocalBluetoothManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes.dex */
public final class RouterInfoMediaManager extends InfoMediaManager {
    private static final String TAG = "RouterInfoMediaManager";
    private final ControllerCallback mControllerCallback;
    private final Executor mExecutor;
    private final RouteCallback mRouteCallback;
    private final Consumer<RouteListingPreference> mRouteListingPreferenceCallback;
    private final MediaRouter2 mRouter;
    private final MediaRouter2Manager mRouterManager;
    private final AtomicReference<MediaRouter2.ScanToken> mScanToken;
    private final TransferCallback mTransferCallback;

    /* JADX INFO: renamed from: com.android.settingslib.media.RouterInfoMediaManager$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private final class ControllerCallback extends MediaRouter2.ControllerCallback {
        final /* synthetic */ RouterInfoMediaManager this$0;

        private ControllerCallback(RouterInfoMediaManager r1) {
            this.this$0 = r1;
        }

        /* synthetic */ ControllerCallback(RouterInfoMediaManager r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.media.MediaRouter2.ControllerCallback
        public void onControllerUpdated(MediaRouter2.RoutingController r1) {
            this.this$0.refreshDevices();
        }
    }

    private final class RouteCallback extends MediaRouter2.RouteCallback {
        final /* synthetic */ RouterInfoMediaManager this$0;

        private RouteCallback(RouterInfoMediaManager r1) {
            this.this$0 = r1;
        }

        /* synthetic */ RouteCallback(RouterInfoMediaManager r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.media.MediaRouter2.RouteCallback
        public void onRoutesUpdated(List<MediaRoute2Info> r1) {
            this.this$0.refreshDevices();
        }

        public void onPreferredFeaturesChanged(List<String> r1) {
            this.this$0.refreshDevices();
        }
    }

    private final class TransferCallback extends MediaRouter2.TransferCallback {
        final /* synthetic */ RouterInfoMediaManager this$0;

        @Override // android.media.MediaRouter2.TransferCallback
        public void onTransferFailure(MediaRoute2Info r1) {
        }

        private TransferCallback(RouterInfoMediaManager r1) {
            this.this$0 = r1;
        }

        /* synthetic */ TransferCallback(RouterInfoMediaManager r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.media.MediaRouter2.TransferCallback
        public void onTransfer(MediaRouter2.RoutingController r1, MediaRouter2.RoutingController r2) {
            this.this$0.rebuildDeviceList();
            this.this$0.notifyCurrentConnectedDeviceChanged();
        }

        @Override // android.media.MediaRouter2.TransferCallback
        public void onStop(MediaRouter2.RoutingController r1) {
            this.this$0.refreshDevices();
        }

        public void onRequestFailed(int r1) {
            this.this$0.dispatchOnRequestFailed(r1);
        }
    }

    public static /* synthetic */ RoutingSessionInfo $r8$lambda$wSPLU93woJpKvmDtS3bxzMeLp8w(MediaRouter2.RoutingController r0) {
        return r0.getRoutingSessionInfo();
    }

    /* JADX INFO: renamed from: lambda$new$0$com-android-settingslib-media-RouterInfoMediaManager, reason: not valid java name */
    /* synthetic */ void m768xcc075d3(RouteListingPreference r1) {
        notifyRouteListingPreferenceUpdated(r1);
        refreshDevices();
    }

    /* JADX WARN: Multi-variable type inference failed */
    RouterInfoMediaManager(Context r1, String r2, UserHandle r3, LocalBluetoothManager r4, MediaController r5) throws InfoMediaManager.PackageNotAvailableException {
        super(r1, r2, r3, r4, r5);
        this.mExecutor = Executors.newSingleThreadExecutor();
        MediaRouter2 r6 = null;
        this.mRouteCallback = new RouteCallback(this, 0 == true ? 1 : 0);
        this.mTransferCallback = new TransferCallback(this, 0 == true ? 1 : 0);
        this.mControllerCallback = new ControllerCallback(this, 0 == true ? 1 : 0);
        this.mRouteListingPreferenceCallback = new RouterInfoMediaManager$$ExternalSyntheticLambda0(this);
        this.mScanToken = new AtomicReference();
        if (Flags.enableCrossUserRoutingInMediaRouter2() == true) goto L13;
        r6 = MediaRouter2.getInstance(r1, r2);
    L7:
        if (r6 == null) goto L11;
        this.mRouter = r6;
        this.mRouterManager = MediaRouter2Manager.getInstance(r1);
        return;
    L11:
        throw new InfoMediaManager.PackageNotAvailableException("Package name " + r2 + " does not exist.");
    L13:
        r6 = MediaRouter2.getInstance(r1, r2, r3);     // Catch: IllegalArgumentException -> L12
        goto L7
    }

    @Override // com.android.settingslib.media.InfoMediaManager
    protected void startScanOnRouter() {
        if (Flags.enableScreenOffScanning() == false) goto L5;
        MediaRouter2.ScanRequest r0 = new MediaRouter2.ScanRequest.Builder().build();
        this.mScanToken.compareAndSet(null, this.mRouter.requestScan(r0));
        return;
    L5:
        this.mRouter.startScan();
    }

    @Override // com.android.settingslib.media.InfoMediaManager
    protected void registerRouter() {
        this.mRouter.registerRouteCallback(this.mExecutor, this.mRouteCallback, RouteDiscoveryPreference.EMPTY);
        this.mRouter.registerRouteListingPreferenceUpdatedCallback(this.mExecutor, this.mRouteListingPreferenceCallback);
        this.mRouter.registerTransferCallback(this.mExecutor, this.mTransferCallback);
        this.mRouter.registerControllerCallback(this.mExecutor, this.mControllerCallback);
    }

    @Override // com.android.settingslib.media.InfoMediaManager
    protected void stopScanOnRouter() {
        if (Flags.enableScreenOffScanning() == false) goto L7;
        MediaRouter2.ScanToken r0 = this.mScanToken.getAndSet(null);
        if (r0 == null) goto L9;
        this.mRouter.cancelScanRequest(r0);
        return;
    L9:
        return;
    L7:
        this.mRouter.stopScan();
    }

    @Override // com.android.settingslib.media.InfoMediaManager
    protected void unregisterRouter() {
        this.mRouter.unregisterControllerCallback(this.mControllerCallback);
        this.mRouter.unregisterTransferCallback(this.mTransferCallback);
        this.mRouter.unregisterRouteListingPreferenceUpdatedCallback(this.mRouteListingPreferenceCallback);
        this.mRouter.unregisterRouteCallback(this.mRouteCallback);
    }

    @Override // com.android.settingslib.media.InfoMediaManager
    protected void transferToRoute(MediaRoute2Info r1) {
        this.mRouter.transferTo(r1);
    }

    @Override // com.android.settingslib.media.InfoMediaManager
    protected void selectRoute(MediaRoute2Info r1, RoutingSessionInfo r2) {
        MediaRouter2.RoutingController r0 = getControllerForSession(r2);
        if (r0 == null) goto L6;
        r0.selectRoute(r1);
        return;
    }

    @Override // com.android.settingslib.media.InfoMediaManager
    protected void deselectRoute(MediaRoute2Info r1, RoutingSessionInfo r2) {
        MediaRouter2.RoutingController r0 = getControllerForSession(r2);
        if (r0 == null) goto L6;
        r0.deselectRoute(r1);
        return;
    }

    @Override // com.android.settingslib.media.InfoMediaManager
    protected void releaseSession(RoutingSessionInfo r1) {
        MediaRouter2.RoutingController r0 = getControllerForSession(r1);
        if (r0 == null) goto L6;
        r0.release();
        return;
    }

    @Override // com.android.settingslib.media.InfoMediaManager
    protected List<MediaRoute2Info> getSelectableRoutes(RoutingSessionInfo r2) {
        MediaRouter2.RoutingController r1 = getControllerForSession(r2);
        if (r1 == null) goto L5;
        final List<String> r3 = r1.getRoutingSessionInfo().getSelectedRoutes();
        return (List) r1.getSelectableRoutes().stream().filter(new RouterInfoMediaManager$$ExternalSyntheticLambda7(r3)).collect(Collectors.toList());
    L5:
        return Collections.emptyList();
    }

    static /* synthetic */ boolean lambda$getSelectableRoutes$1(List r0, MediaRoute2Info r1) {
        return !r0.contains(r1.getId());
    }

    @Override // com.android.settingslib.media.InfoMediaManager
    protected List<MediaRoute2Info> getDeselectableRoutes(RoutingSessionInfo r1) {
        MediaRouter2.RoutingController r0 = getControllerForSession(r1);
        if (r0 != null) goto L7;
        return Collections.emptyList();
    L7:
        return r0.getDeselectableRoutes();
    }

    @Override // com.android.settingslib.media.InfoMediaManager
    protected List<MediaRoute2Info> getSelectedRoutes(RoutingSessionInfo r1) {
        MediaRouter2.RoutingController r0 = getControllerForSession(r1);
        if (r0 != null) goto L7;
        return Collections.emptyList();
    L7:
        return r0.getSelectedRoutes();
    }

    @Override // com.android.settingslib.media.InfoMediaManager
    protected void setSessionVolume(RoutingSessionInfo r1, int r2) {
        this.mRouterManager.setSessionVolume(r1, r2);
    }

    @Override // com.android.settingslib.media.InfoMediaManager
    protected void setRouteVolume(MediaRoute2Info r1, int r2) {
        this.mRouter.setRouteVolume(r1, r2);
    }

    @Override // com.android.settingslib.media.InfoMediaManager
    protected RouteListingPreference getRouteListingPreference() {
        return this.mRouter.getRouteListingPreference();
    }

    @Override // com.android.settingslib.media.InfoMediaManager
    protected List<RoutingSessionInfo> getRemoteSessions() {
        return this.mRouterManager.getRemoteSessions();
    }

    @Override // com.android.settingslib.media.InfoMediaManager
    protected List<RoutingSessionInfo> getRoutingSessionsForPackage() {
        return (List) this.mRouter.getControllers().stream().map(new RouterInfoMediaManager$$ExternalSyntheticLambda6()).collect(Collectors.toList());
    }

    @Override // com.android.settingslib.media.InfoMediaManager
    protected RoutingSessionInfo getRoutingSessionById(String r4) {
        Iterator<RoutingSessionInfo> r0 = getRemoteSessions().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        RoutingSessionInfo r1 = r0.next();
        if (TextUtils.equals(r1.getId(), r4) == false) goto L4;
        return r1;
    L8:
        RoutingSessionInfo r3 = this.mRouterManager.getSystemRoutingSession(null);
        if (TextUtils.equals(r3.getId(), r4) == true) goto L11;
        return null;
    L11:
        return r3;
    }

    @Override // com.android.settingslib.media.InfoMediaManager
    protected List<MediaRoute2Info> getAvailableRoutesFromRouter() {
        return this.mRouter.getRoutes();
    }

    @Override // com.android.settingslib.media.InfoMediaManager
    protected List<MediaRoute2Info> getTransferableRoutes(String r4) {
        List<MediaRouter2.RoutingController> r5 = this.mRouter.getControllers();
        MediaRouter2.RoutingController r6 = r5.get(r5.size() - 1);
        final HashMap r0 = new HashMap();
        r6.getTransferableRoutes().forEach(new RouterInfoMediaManager$$ExternalSyntheticLambda1(r0));
        if (r6.getRoutingSessionInfo().isSystemSession() == false) goto L5;
        this.mRouter.getRoutes().stream().filter(new RouterInfoMediaManager$$ExternalSyntheticLambda2()).forEach(new RouterInfoMediaManager$$ExternalSyntheticLambda3(r0));
    L7:
        return new ArrayList(r0.values());
    L5:
        this.mRouter.getRoutes().stream().filter(new RouterInfoMediaManager$$ExternalSyntheticLambda4()).forEach(new RouterInfoMediaManager$$ExternalSyntheticLambda5(r0));
        goto L7
    }

    static /* synthetic */ void lambda$getTransferableRoutes$2(HashMap r1, MediaRoute2Info r2) {
        r1.put(r2.getId(), r2);
    }

    static /* synthetic */ boolean lambda$getTransferableRoutes$3(MediaRoute2Info r0) {
        return !r0.isSystemRoute();
    }

    static /* synthetic */ void lambda$getTransferableRoutes$4(HashMap r1, MediaRoute2Info r2) {
        r1.put(r2.getId(), r2);
    }

    static /* synthetic */ boolean lambda$getTransferableRoutes$5(MediaRoute2Info r0) {
        return r0.isSystemRoute();
    }

    static /* synthetic */ void lambda$getTransferableRoutes$6(HashMap r1, MediaRoute2Info r2) {
        r1.put(r2.getId(), r2);
    }

    private MediaRouter2.RoutingController getControllerForSession(RoutingSessionInfo r1) {
        return this.mRouter.getController(r1.getId());
    }
}
