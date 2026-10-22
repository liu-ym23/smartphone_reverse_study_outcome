package com.android.settingslib.media;

import android.content.Context;
import android.media.MediaRoute2Info;
import android.media.MediaRouter2Manager;
import android.media.RouteListingPreference;
import android.media.RoutingSessionInfo;
import android.media.session.MediaController;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.Log;
import com.GlobalProxyLancet;
import com.android.settingslib.bluetooth.LocalBluetoothManager;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public class ManagerInfoMediaManager extends InfoMediaManager {
    private static final boolean DEBUG = false;
    private static final String TAG = "ManagerInfoMediaManager";
    private final Executor mExecutor;
    boolean mIsScanning;
    final RouterManagerCallback mMediaRouterCallback;
    MediaRouter2Manager mRouterManager;

    final class RouterManagerCallback implements MediaRouter2Manager.Callback {
        final /* synthetic */ ManagerInfoMediaManager this$0;

        public void onTransferFailed(RoutingSessionInfo r1, MediaRoute2Info r2) {
        }

        RouterManagerCallback(ManagerInfoMediaManager r1) {
            this.this$0 = r1;
        }

        public void onRoutesUpdated() {
            this.this$0.refreshDevices();
        }

        public void onPreferredFeaturesChanged(String r1, List<String> r2) {
            if (TextUtils.equals(this.this$0.mPackageName, r1) == false) goto L6;
            this.this$0.refreshDevices();
            return;
        }

        public void onTransferred(RoutingSessionInfo r3, RoutingSessionInfo r4) {
            if (ManagerInfoMediaManager.access$000() == false) goto L5;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(ManagerInfoMediaManager.TAG, "onTransferred() oldSession : " + r3.getName() + ", newSession : " + r4.getName());
        L5:
            this.this$0.rebuildDeviceList();
            this.this$0.notifyCurrentConnectedDeviceChanged();
        }

        public void onRequestFailed(int r1) {
            this.this$0.dispatchOnRequestFailed(r1);
        }

        public void onSessionUpdated(RoutingSessionInfo r1) {
            this.this$0.refreshDevices();
        }

        public void onSessionReleased(RoutingSessionInfo r1) {
            this.this$0.refreshDevices();
        }

        public void onRouteListingPreferenceUpdated(String r2, RouteListingPreference r3) {
            if (TextUtils.equals(this.this$0.mPackageName, r2) == true) goto L5;
            return;
        L5:
            this.this$0.notifyRouteListingPreferenceUpdated(r3);
            this.this$0.refreshDevices();
        }
    }

    static /* synthetic */ boolean access$000() {
        return DEBUG;
    }

    static {
        DEBUG = Log.isLoggable(TAG, 3);
    }

    ManagerInfoMediaManager(Context r1, String r2, UserHandle r3, LocalBluetoothManager r4, MediaController r5) {
        super(r1, r2, r3, r4, r5);
        this.mMediaRouterCallback = new RouterManagerCallback(this);
        this.mIsScanning = false;
        this.mExecutor = Executors.newSingleThreadExecutor();
        this.mRouterManager = MediaRouter2Manager.getInstance(r1);
    }

    @Override // com.android.settingslib.media.InfoMediaManager
    protected void startScanOnRouter() {
        if (this.mIsScanning == true) goto L6;
        this.mRouterManager.registerScanRequest();
        this.mIsScanning = true;
        return;
    }

    @Override // com.android.settingslib.media.InfoMediaManager
    protected void registerRouter() {
        this.mRouterManager.registerCallback(this.mExecutor, this.mMediaRouterCallback);
    }

    @Override // com.android.settingslib.media.InfoMediaManager
    protected void stopScanOnRouter() {
        if (this.mIsScanning == false) goto L6;
        this.mRouterManager.unregisterScanRequest();
        this.mIsScanning = false;
        return;
    }

    @Override // com.android.settingslib.media.InfoMediaManager
    protected void unregisterRouter() {
        this.mRouterManager.unregisterCallback(this.mMediaRouterCallback);
    }

    @Override // com.android.settingslib.media.InfoMediaManager
    protected void transferToRoute(MediaRoute2Info r3) {
        this.mRouterManager.transfer(this.mPackageName, r3, this.mUserHandle);
    }

    @Override // com.android.settingslib.media.InfoMediaManager
    protected void selectRoute(MediaRoute2Info r1, RoutingSessionInfo r2) {
        this.mRouterManager.selectRoute(r2, r1);
    }

    @Override // com.android.settingslib.media.InfoMediaManager
    protected void deselectRoute(MediaRoute2Info r1, RoutingSessionInfo r2) {
        this.mRouterManager.deselectRoute(r2, r1);
    }

    @Override // com.android.settingslib.media.InfoMediaManager
    protected void releaseSession(RoutingSessionInfo r1) {
        this.mRouterManager.releaseSession(r1);
    }

    @Override // com.android.settingslib.media.InfoMediaManager
    protected List<MediaRoute2Info> getSelectableRoutes(RoutingSessionInfo r1) {
        return this.mRouterManager.getSelectableRoutes(r1);
    }

    @Override // com.android.settingslib.media.InfoMediaManager
    protected List<MediaRoute2Info> getDeselectableRoutes(RoutingSessionInfo r1) {
        return this.mRouterManager.getDeselectableRoutes(r1);
    }

    @Override // com.android.settingslib.media.InfoMediaManager
    protected List<MediaRoute2Info> getSelectedRoutes(RoutingSessionInfo r1) {
        return this.mRouterManager.getSelectedRoutes(r1);
    }

    @Override // com.android.settingslib.media.InfoMediaManager
    protected void setSessionVolume(RoutingSessionInfo r1, int r2) {
        this.mRouterManager.setSessionVolume(r1, r2);
    }

    @Override // com.android.settingslib.media.InfoMediaManager
    protected void setRouteVolume(MediaRoute2Info r1, int r2) {
        this.mRouterManager.setRouteVolume(r1, r2);
    }

    @Override // com.android.settingslib.media.InfoMediaManager
    protected RouteListingPreference getRouteListingPreference() {
        return this.mRouterManager.getRouteListingPreference(this.mPackageName);
    }

    @Override // com.android.settingslib.media.InfoMediaManager
    protected List<RoutingSessionInfo> getRoutingSessionsForPackage() {
        return this.mRouterManager.getRoutingSessions(this.mPackageName);
    }

    @Override // com.android.settingslib.media.InfoMediaManager
    protected List<RoutingSessionInfo> getRemoteSessions() {
        return this.mRouterManager.getRemoteSessions();
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
        return this.mRouterManager.getAvailableRoutes(this.mPackageName);
    }

    @Override // com.android.settingslib.media.InfoMediaManager
    protected List<MediaRoute2Info> getTransferableRoutes(String r1) {
        return this.mRouterManager.getTransferableRoutes(r1);
    }
}
