package com.android.settingslib.media;

import android.content.Context;
import android.media.MediaRoute2Info;
import android.media.RouteListingPreference;
import android.media.RoutingSessionInfo;
import android.media.session.MediaController;
import android.os.UserHandle;
import com.android.settingslib.bluetooth.LocalBluetoothManager;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class NoOpInfoMediaManager extends InfoMediaManager {
    private static final RoutingSessionInfo PLACEHOLDER_SESSION = null;

    @Override // com.android.settingslib.media.InfoMediaManager
    protected void deselectRoute(MediaRoute2Info r1, RoutingSessionInfo r2) {
    }

    @Override // com.android.settingslib.media.InfoMediaManager
    protected RouteListingPreference getRouteListingPreference() {
        return null;
    }

    @Override // com.android.settingslib.media.InfoMediaManager
    protected RoutingSessionInfo getRoutingSessionById(String r1) {
        return null;
    }

    @Override // com.android.settingslib.media.InfoMediaManager
    protected void registerRouter() {
    }

    @Override // com.android.settingslib.media.InfoMediaManager
    protected void releaseSession(RoutingSessionInfo r1) {
    }

    @Override // com.android.settingslib.media.InfoMediaManager
    protected void selectRoute(MediaRoute2Info r1, RoutingSessionInfo r2) {
    }

    @Override // com.android.settingslib.media.InfoMediaManager
    protected void setRouteVolume(MediaRoute2Info r1, int r2) {
    }

    @Override // com.android.settingslib.media.InfoMediaManager
    protected void setSessionVolume(RoutingSessionInfo r1, int r2) {
    }

    @Override // com.android.settingslib.media.InfoMediaManager
    protected void startScanOnRouter() {
    }

    @Override // com.android.settingslib.media.InfoMediaManager
    protected void stopScanOnRouter() {
    }

    @Override // com.android.settingslib.media.InfoMediaManager
    protected void transferToRoute(MediaRoute2Info r1) {
    }

    @Override // com.android.settingslib.media.InfoMediaManager
    protected void unregisterRouter() {
    }

    static {
        PLACEHOLDER_SESSION = new RoutingSessionInfo.Builder("FAKE_ROUTING_SESSION", "").addSelectedRoute("FAKE_SELECTED_ROUTE_ID").setVolumeMax(-1).setVolume(-1).build();
    }

    NoOpInfoMediaManager(Context r1, String r2, UserHandle r3, LocalBluetoothManager r4, MediaController r5) {
        super(r1, r2, r3, r4, r5);
    }

    @Override // com.android.settingslib.media.InfoMediaManager
    protected List<MediaRoute2Info> getSelectableRoutes(RoutingSessionInfo r1) {
        return Collections.emptyList();
    }

    @Override // com.android.settingslib.media.InfoMediaManager
    protected List<MediaRoute2Info> getDeselectableRoutes(RoutingSessionInfo r1) {
        return Collections.emptyList();
    }

    @Override // com.android.settingslib.media.InfoMediaManager
    protected List<MediaRoute2Info> getSelectedRoutes(RoutingSessionInfo r1) {
        return Collections.emptyList();
    }

    @Override // com.android.settingslib.media.InfoMediaManager
    protected List<RoutingSessionInfo> getRemoteSessions() {
        return Collections.emptyList();
    }

    @Override // com.android.settingslib.media.InfoMediaManager
    protected List<RoutingSessionInfo> getRoutingSessionsForPackage() {
        return List.of(PLACEHOLDER_SESSION);
    }

    @Override // com.android.settingslib.media.InfoMediaManager
    protected List<MediaRoute2Info> getAvailableRoutesFromRouter() {
        return Collections.emptyList();
    }

    @Override // com.android.settingslib.media.InfoMediaManager
    protected List<MediaRoute2Info> getTransferableRoutes(String r1) {
        return Collections.emptyList();
    }
}
