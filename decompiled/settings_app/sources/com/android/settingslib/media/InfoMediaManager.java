package com.android.settingslib.media;

import android.bluetooth.BluetoothAdapter;
import android.content.ComponentName;
import android.content.Context;
import android.media.MediaRoute2Info;
import android.media.RouteListingPreference;
import android.media.RoutingSessionInfo;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.os.Build;
import android.os.Process;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.Log;
import com.GlobalProxyLancet;
import com.android.settingslib.bluetooth.CachedBluetoothDevice;
import com.android.settingslib.bluetooth.LocalBluetoothManager;
import com.android.settingslib.media.flags.Flags;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* JADX INFO: loaded from: classes.dex */
public abstract class InfoMediaManager {
    private static final boolean DEBUG = false;
    private static final String TAG = "InfoMediaManager";
    private final LocalBluetoothManager mBluetoothManager;
    private final Collection<MediaDeviceCallback> mCallbacks;
    protected final Context mContext;
    private MediaDevice mCurrentConnectedDevice;
    private MediaController.PlaybackInfo mLastKnownPlaybackInfo;
    private MediaController mMediaController;
    private final MediaController.Callback mMediaControllerCallback;
    protected final List<MediaDevice> mMediaDevices;
    protected final String mPackageName;
    private final Map<String, RouteListingPreference.Item> mPreferenceItemMap;
    protected final UserHandle mUserHandle;

    /* JADX INFO: renamed from: com.android.settingslib.media.InfoMediaManager$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    static class Api34Impl {
        public static /* synthetic */ String $r8$lambda$h1yTUs3x4ZC81Y72wBT4ojMDSZw(MediaRoute2Info r0) {
            return r0.getId();
        }

        static /* synthetic */ MediaRoute2Info lambda$arrangeRouteListByPreference$0(MediaRoute2Info r0, MediaRoute2Info r1) {
            return r0;
        }

        Api34Impl() {
        }

        static List<RouteListingPreference.Item> composePreferenceRouteListing(RouteListingPreference r3) {
            ArrayList r0 = new ArrayList();
            Iterator<RouteListingPreference.Item> r4 = r3.getItems().iterator();
        L4:
            if (r4.hasNext() == false) goto L9;
            RouteListingPreference.Item r1 = r4.next();
            if ((r1.getFlags() & 4) != 0) goto L7;
            r0.add(r1);
            goto L4
        L7:
            r0.add(0, r1);
            goto L4
        L9:
            return r0;
        }

        static synchronized List<MediaRoute2Info> filterDuplicatedIds(List<MediaRoute2Info> r5) {
            monitor-enter(Api34Impl.class);
            ArrayList r1 = new ArrayList();     // Catch: Throwable -> L14
            HashSet r2 = new HashSet();     // Catch: Throwable -> L14
            Iterator<MediaRoute2Info> r6 = r5.iterator();     // Catch: Throwable -> L14
        L6:
            if (r6.hasNext() == false) goto L12;
            MediaRoute2Info r3 = r6.next();     // Catch: Throwable -> L14
            if (Collections.disjoint(r3.getDeduplicationIds(), r2) == false) goto L6;
            r1.add(r3);     // Catch: Throwable -> L14
            r2.addAll(r3.getDeduplicationIds());     // Catch: Throwable -> L14
            goto L6
        L12:
            monitor-exit(Api34Impl.class);
            return r1;
        L14:
            th = move-exception;
            throw th;
        }

        static List<MediaRoute2Info> arrangeRouteListByPreference(List<MediaRoute2Info> r4, List<MediaRoute2Info> r5, List<RouteListingPreference.Item> r6) {
            LinkedHashSet r0 = new LinkedHashSet();
            Iterator<MediaRoute2Info> r1 = r4.iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            r0.add(r1.next().getId());
            goto L4
        L6:
            Iterator<MediaRoute2Info> r2 = r5.iterator();
        L8:
            if (r2.hasNext() == false) goto L12;
            MediaRoute2Info r3 = r2.next();
            if (r3.isSystemRoute() == false) goto L8;
            r0.add(r3.getId());
            goto L8
        L12:
            final Map r7 = (Map) Stream.concat(r4.stream(), r5.stream()).collect(Collectors.toMap(new InfoMediaManager$Api34Impl$$ExternalSyntheticLambda1(), Function.identity(), new InfoMediaManager$Api34Impl$$ExternalSyntheticLambda2()));
            Iterator<RouteListingPreference.Item> r8 = r6.iterator();
        L14:
            if (r8.hasNext() == false) goto L18;
            MediaRoute2Info r9 = (MediaRoute2Info) r7.get(r8.next().getRouteId());
            if (r9 == null) goto L14;
            r0.add(r9.getId());
            goto L14
        L18:
            Stream r10 = r0.stream();
            Objects.requireNonNull(r7);
            return (List) r10.map(new InfoMediaManager$Api34Impl$$ExternalSyntheticLambda3(r7)).collect(Collectors.toList());
        }

        static boolean preferRouteListingOrdering(RouteListingPreference r0) {
            if (r0 != null) goto L4;
        L6:
            return false;
        L4:
            if (r0.getUseSystemOrdering() == true) goto L6;
            return true;
        }

        static ComponentName getLinkedItemComponentName(RouteListingPreference r0) {
            if (r0 != null) goto L5;
            return null;
        L5:
            return r0.getLinkedItemComponentName();
        }

        static void onRouteListingPreferenceUpdated(RouteListingPreference r1, final Map<String, RouteListingPreference.Item> r2) {
            r2.clear();
            if (r1 == null) goto L6;
            r1.getItems().forEach(new InfoMediaManager$Api34Impl$$ExternalSyntheticLambda0(r2));
            return;
        }

        static /* synthetic */ void lambda$onRouteListingPreferenceUpdated$1(Map r1, RouteListingPreference.Item r2) {
            r1.put(r2.getRouteId(), r2);
        }
    }

    private final class MediaControllerCallback extends MediaController.Callback {
        final /* synthetic */ InfoMediaManager this$0;

        private MediaControllerCallback(InfoMediaManager r1) {
            this.this$0 = r1;
        }

        /* synthetic */ MediaControllerCallback(InfoMediaManager r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.media.session.MediaController.Callback
        public void onSessionDestroyed() {
            InfoMediaManager.access$102(this.this$0, null);
            this.this$0.refreshDevices();
        }

        @Override // android.media.session.MediaController.Callback
        public void onAudioInfoChanged(MediaController.PlaybackInfo r3) {
            if (r3.getPlaybackType() == InfoMediaManager.access$200(this.this$0).getPlaybackType()) goto L5;
        L6:
            this.this$0.refreshDevices();
        L7:
            InfoMediaManager.access$202(this.this$0, r3);
            return;
        L5:
            if (TextUtils.equals(r3.getVolumeControlId(), InfoMediaManager.access$200(this.this$0).getVolumeControlId()) == true) goto L7;
            goto L6
        }
    }

    public interface MediaDeviceCallback {
        void onConnectedDeviceChanged(String r1);

        void onDeviceListAdded(List<MediaDevice> r1);

        void onDeviceListRemoved(List<MediaDevice> r1);

        void onRequestFailed(int r1);
    }

    public static class PackageNotAvailableException extends Exception {
        public PackageNotAvailableException(String r1) {
            super(r1);
        }
    }

    protected abstract void deselectRoute(MediaRoute2Info r1, RoutingSessionInfo r2);

    protected abstract List<MediaRoute2Info> getAvailableRoutesFromRouter();

    protected abstract List<MediaRoute2Info> getDeselectableRoutes(RoutingSessionInfo r1);

    protected abstract List<RoutingSessionInfo> getRemoteSessions();

    protected abstract RouteListingPreference getRouteListingPreference();

    protected abstract RoutingSessionInfo getRoutingSessionById(String r1);

    protected abstract List<RoutingSessionInfo> getRoutingSessionsForPackage();

    protected abstract List<MediaRoute2Info> getSelectableRoutes(RoutingSessionInfo r1);

    protected abstract List<MediaRoute2Info> getSelectedRoutes(RoutingSessionInfo r1);

    protected abstract List<MediaRoute2Info> getTransferableRoutes(String r1);

    protected abstract void registerRouter();

    protected abstract void releaseSession(RoutingSessionInfo r1);

    protected abstract void selectRoute(MediaRoute2Info r1, RoutingSessionInfo r2);

    protected abstract void setRouteVolume(MediaRoute2Info r1, int r2);

    protected abstract void setSessionVolume(RoutingSessionInfo r1, int r2);

    protected abstract void startScanOnRouter();

    protected abstract void stopScanOnRouter();

    protected abstract void transferToRoute(MediaRoute2Info r1);

    protected abstract void unregisterRouter();

    static /* synthetic */ MediaController access$102(InfoMediaManager r0, MediaController r1) {
        r0.mMediaController = r1;
        return r1;
    }

    static /* synthetic */ MediaController.PlaybackInfo access$200(InfoMediaManager r0) {
        return r0.mLastKnownPlaybackInfo;
    }

    static /* synthetic */ MediaController.PlaybackInfo access$202(InfoMediaManager r0, MediaController.PlaybackInfo r1) {
        r0.mLastKnownPlaybackInfo = r1;
        return r1;
    }

    static {
        DEBUG = Log.isLoggable(TAG, 3);
    }

    InfoMediaManager(Context r3, String r4, UserHandle r5, LocalBluetoothManager r6, MediaController r7) {
        this.mMediaDevices = new CopyOnWriteArrayList();
        this.mCallbacks = new CopyOnWriteArrayList();
        this.mPreferenceItemMap = new ConcurrentHashMap();
        this.mMediaControllerCallback = new MediaControllerCallback(this, null);
        this.mContext = r3;
        this.mBluetoothManager = r6;
        this.mPackageName = r4;
        this.mUserHandle = r5;
        this.mMediaController = r7;
        if (r7 == null) goto L6;
        this.mLastKnownPlaybackInfo = r7.getPlaybackInfo();
        return;
    }

    public static InfoMediaManager createInstance(Context r7, String r8, UserHandle r9, LocalBluetoothManager r10, MediaSession.Token r11) {
        if (Flags.usePlaybackInfoForRoutingControls() == false) goto L6;
        if (r11 == null) goto L6;
        MediaController r0 = new MediaController(r7, r11);
    L8:
        if (TextUtils.isEmpty(r8) == false) goto L10;
        r8 = r7.getPackageName();
    L10:
        if (r9 != null) goto L13;
        r9 = Process.myUserHandle();
    L13:
        if (Flags.useMediaRouter2ForInfoMediaManager() == false) goto L19;
        return new RouterInfoMediaManager(r7, r8, r9, r10, r0);
    L16:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Returning a no-op InfoMediaManager for package " + r8);
        return new NoOpInfoMediaManager(r7, r8, r9, r10, r0);
    L19:
        return new ManagerInfoMediaManager(r7, r8, r9, r10, r0);
    L6:
        r0 = null;
        goto L8
    }

    public void startScan() {
        startScanOnRouter();
    }

    private void updateRouteListingPreference() {
        if (Build.VERSION.SDK_INT < 34) goto L6;
        Api34Impl.onRouteListingPreferenceUpdated(getRouteListingPreference(), this.mPreferenceItemMap);
        return;
    }

    public final void stopScan() {
        stopScanOnRouter();
    }

    protected final void rebuildDeviceList() {
        buildAvailableRoutes();
    }

    protected final void notifyCurrentConnectedDeviceChanged() {
        MediaDevice r0 = this.mCurrentConnectedDevice;
        if (r0 == null) goto L5;
        String r1 = r0.getId();
    L6:
        dispatchConnectedDeviceChanged(r1);
        return;
    L5:
        r1 = null;
        goto L6
    }

    protected final void notifyRouteListingPreferenceUpdated(RouteListingPreference r1) {
        Api34Impl.onRouteListingPreferenceUpdated(r1, this.mPreferenceItemMap);
    }

    protected final MediaDevice findMediaDevice(String r3) {
        Iterator<MediaDevice> r2 = this.mMediaDevices.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        MediaDevice r0 = r2.next();
        if (r0.getId().equals(r3) == false) goto L4;
        return r0;
    L8:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_e(TAG, "findMediaDevice() can't find device with id: " + r3);
        return null;
    }

    public final void registerCallback(MediaDeviceCallback r3) {
        boolean r0 = this.mCallbacks.isEmpty();
        if (this.mCallbacks.contains(r3) == true) goto L11;
        this.mCallbacks.add(r3);
        if (r0 == false) goto L12;
        this.mMediaDevices.clear();
        registerRouter();
        MediaController r4 = this.mMediaController;
        if (r4 == null) goto L9;
        r4.registerCallback(this.mMediaControllerCallback);
    L9:
        updateRouteListingPreference();
        refreshDevices();
        return;
    L12:
        return;
    }

    public final void unregisterCallback(MediaDeviceCallback r2) {
        if (this.mCallbacks.remove(r2) == true) goto L5;
        return;
    L5:
        if (this.mCallbacks.isEmpty() == false) goto L12;
        MediaController r3 = this.mMediaController;
        if (r3 == null) goto L9;
        r3.unregisterCallback(this.mMediaControllerCallback);
    L9:
        unregisterRouter();
        return;
    }

    private void dispatchDeviceListAdded(List<MediaDevice> r3) {
        Iterator<MediaDeviceCallback> r2 = getCallbacks().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r2.next().onDeviceListAdded(new ArrayList(r3));
        goto L4
    }

    private void dispatchConnectedDeviceChanged(String r2) {
        Iterator<MediaDeviceCallback> r1 = getCallbacks().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().onConnectedDeviceChanged(r2);
        goto L4
    }

    protected void dispatchOnRequestFailed(int r2) {
        Iterator<MediaDeviceCallback> r1 = getCallbacks().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().onRequestFailed(r2);
        goto L4
    }

    private Collection<MediaDeviceCallback> getCallbacks() {
        return new CopyOnWriteArrayList(this.mCallbacks);
    }

    MediaDevice getCurrentConnectedDevice() {
        return this.mCurrentConnectedDevice;
    }

    void connectToDevice(MediaDevice r2) {
        if (r2.mRouteInfo != null) goto L6;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Unable to connect. RouteInfo is empty");
        return;
    L6:
        r2.setConnectedRecord();
        transferToRoute(r2.mRouteInfo);
    }

    boolean addDeviceToPlayMedia(MediaDevice r4) {
        RoutingSessionInfo r0 = getActiveRoutingSession();
        if (r0.getSelectableRoutes().contains(r4.mRouteInfo.getId()) == true) goto L6;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "addDeviceToPlayMedia() Ignoring selecting a non-selectable device : " + r4.getName());
        return false;
    L6:
        selectRoute(r4.mRouteInfo, r0);
        return true;
    }

    private RoutingSessionInfo getActiveRoutingSession() {
        List<RoutingSessionInfo> r0 = getRoutingSessionsForPackage();
        RoutingSessionInfo r1 = r0.get(r0.size() - 1);
        if (Flags.usePlaybackInfoForRoutingControls() == false) goto L22;
        MediaController r3 = this.mMediaController;
        if (r3 == null) goto L22;
        MediaController.PlaybackInfo r4 = r3.getPlaybackInfo();
        if (r4.getPlaybackType() == 1) goto L10;
        String r2 = r4.getVolumeControlId();
        Iterator<RoutingSessionInfo> r5 = r0.iterator();
    L13:
        if (r5.hasNext() == false) goto L22;
        RoutingSessionInfo r6 = r5.next();
        if (TextUtils.equals(r2, r6.getId()) == true) goto L16;
        if (TextUtils.equals(r2, r6.getOriginalId()) == false) goto L13;
        if (TextUtils.equals(this.mMediaController.getPackageName(), r6.getOwnerPackageName()) == false) goto L13;
        return r6;
    L16:
        return r6;
    L10:
        return r0.get(0);
    L22:
        return r1;
    }

    boolean isRoutingSessionAvailableForVolumeControl() {
        Iterator<RoutingSessionInfo> r0 = getRoutingSessionsForPackage().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        RoutingSessionInfo r1 = r0.next();
        if (r1.isSystemSession() == true) goto L4;
        if (r1.getVolumeHandling() == 0) goto L4;
        return true;
    L11:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "No routing session for " + this.mPackageName);
        return false;
    }

    boolean preferRouteListingOrdering() {
        if (Build.VERSION.SDK_INT >= 34) goto L5;
    L7:
        return false;
    L5:
        if (Api34Impl.preferRouteListingOrdering(getRouteListingPreference()) == false) goto L7;
        return true;
    }

    ComponentName getLinkedItemComponentName() {
        if (Build.VERSION.SDK_INT >= 34) goto L9;
        if (TextUtils.isEmpty(this.mPackageName) == false) goto L9;
        return null;
    L9:
        return Api34Impl.getLinkedItemComponentName(getRouteListingPreference());
    }

    boolean removeDeviceFromPlayMedia(MediaDevice r4) {
        RoutingSessionInfo r0 = getActiveRoutingSession();
        if (r0.getSelectedRoutes().contains(r4.mRouteInfo.getId()) == true) goto L6;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "removeDeviceFromMedia() Ignoring deselecting a non-deselectable device : " + r4.getName());
        return false;
    L6:
        deselectRoute(r4.mRouteInfo, r0);
        return true;
    }

    boolean releaseSession() {
        releaseSession(getActiveRoutingSession());
        return true;
    }

    List<MediaDevice> getSelectableMediaDevices() {
        RoutingSessionInfo r0 = getActiveRoutingSession();
        ArrayList r1 = new ArrayList();
        Iterator<MediaRoute2Info> r2 = getSelectableRoutes(r0).iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        MediaRoute2Info r3 = r2.next();
        r1.add(new InfoMediaDevice(this.mContext, r3, this.mPreferenceItemMap.get(r3.getId())));
        goto L4
    L6:
        return r1;
    }

    List<MediaDevice> getDeselectableMediaDevices() {
        RoutingSessionInfo r0 = getActiveRoutingSession();
        ArrayList r1 = new ArrayList();
        Iterator<MediaRoute2Info> r2 = getDeselectableRoutes(r0).iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        MediaRoute2Info r3 = r2.next();
        r1.add(new InfoMediaDevice(this.mContext, r3, this.mPreferenceItemMap.get(r3.getId())));
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, r3.getName() + " is deselectable for " + this.mPackageName);
        goto L4
    L6:
        return r1;
    }

    List<MediaDevice> getSelectedMediaDevices() {
        RoutingSessionInfo r0 = getActiveRoutingSession();
        ArrayList r1 = new ArrayList();
        Iterator<MediaRoute2Info> r2 = getSelectedRoutes(r0).iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        MediaRoute2Info r3 = r2.next();
        r1.add(new InfoMediaDevice(this.mContext, r3, this.mPreferenceItemMap.get(r3.getId())));
        goto L4
    L6:
        return r1;
    }

    void adjustDeviceVolume(MediaDevice r2, int r3) {
        if (r2.mRouteInfo != null) goto L6;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Unable to set volume. RouteInfo is empty");
        return;
    L6:
        setRouteVolume(r2.mRouteInfo, r3);
    }

    void adjustSessionVolume(RoutingSessionInfo r1, int r2) {
        if (r1 != null) goto L5;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Unable to adjust session volume. RoutingSessionInfo is empty");
        return;
    L5:
        setSessionVolume(r1, r2);
    }

    void adjustSessionVolume(int r3) {
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "adjustSessionVolume() adjust volume: " + r3 + ", with : " + this.mPackageName);
        setSessionVolume(getActiveRoutingSession(), r3);
    }

    public int getSessionVolumeMax() {
        return getActiveRoutingSession().getVolumeMax();
    }

    public int getSessionVolume() {
        return getActiveRoutingSession().getVolume();
    }

    CharSequence getSessionName() {
        return getActiveRoutingSession().getName();
    }

    boolean shouldEnableVolumeSeekBar(RoutingSessionInfo r1) {
        if (r1.isSystemSession() == false) goto L5;
    L8:
        return true;
    L5:
        if (r1.getVolumeHandling() != 0) goto L8;
        return false;
    }

    protected final synchronized void refreshDevices() {
        monitor-enter(this);
        rebuildDeviceList();     // Catch: Throwable -> L6
        dispatchDeviceListAdded(this.mMediaDevices);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private synchronized void buildAvailableRoutes() {
        monitor-enter(this);
        this.mMediaDevices.clear();     // Catch: Throwable -> L23
        RoutingSessionInfo r0 = getActiveRoutingSession();     // Catch: Throwable -> L23
        Iterator<MediaRoute2Info> r1 = getAvailableRoutes(r0).iterator();     // Catch: Throwable -> L23
    L5:
        if (r1.hasNext() == false) goto L11;
        MediaRoute2Info r2 = r1.next();     // Catch: Throwable -> L23
        if (DEBUG == false) goto L9;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "buildAvailableRoutes() route : " + r2.getName() + ", volume : " + r2.getVolume() + ", type : " + r2.getType());     // Catch: Throwable -> L23
    L9:
        addMediaDevice(r2, r0);     // Catch: Throwable -> L23
        goto L5
    L11:
        if (this.mMediaDevices.isEmpty() == true) goto L21;
        Iterator<MediaDevice> r3 = this.mMediaDevices.iterator();     // Catch: Throwable -> L23
    L14:
        if (r3.hasNext() == false) goto L19;
        MediaDevice r4 = r3.next();     // Catch: Throwable -> L23
        if (r4.getState() != 4) goto L14;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "buildAvailableRoutes() first selected device : " + r4.getDeviceType());     // Catch: Throwable -> L23
        this.mCurrentConnectedDevice = r4;     // Catch: Throwable -> L23
    L19:
        if (this.mCurrentConnectedDevice != null) goto L21;
        this.mCurrentConnectedDevice = this.mMediaDevices.get(0);     // Catch: Throwable -> L23
    L21:
        monitor-exit(this);
        return;
    L23:
        th = move-exception;
        throw th;
    }

    private synchronized List<MediaRoute2Info> getAvailableRoutes(RoutingSessionInfo r7) {
        monitor-enter(this);
        List r0 = new ArrayList();     // Catch: Throwable -> L25
        List<MediaRoute2Info> r1 = getSelectedRoutes(r7);     // Catch: Throwable -> L25
        r0.addAll(r1);     // Catch: Throwable -> L25
        r0.addAll(getSelectableRoutes(r7));     // Catch: Throwable -> L25
        Iterator<MediaRoute2Info> r8 = getTransferableRoutes(this.mPackageName).iterator();     // Catch: Throwable -> L25
    L5:
        if (r8.hasNext() == false) goto L16;
        MediaRoute2Info r2 = r8.next();     // Catch: Throwable -> L25
        Iterator r3 = r0.iterator();     // Catch: Throwable -> L25
    L8:
        if (r3.hasNext() == false) goto L12;
        MediaRoute2Info r4 = (MediaRoute2Info) r3.next();     // Catch: Throwable -> L25
        if (TextUtils.equals(r2.getId(), r4.getId()) == false) goto L8;
        boolean r5 = true;
    L13:
        if (r5 == true) goto L5;
        r0.add(r2);     // Catch: Throwable -> L25
        goto L5
    L12:
        r5 = false;
        goto L13
    L16:
        if (Build.VERSION.SDK_INT < 34) goto L23;
        RouteListingPreference r9 = getRouteListingPreference();     // Catch: Throwable -> L25
        if (r9 == null) goto L20;
        List<RouteListingPreference.Item> r10 = Api34Impl.composePreferenceRouteListing(r9);     // Catch: Throwable -> L25
        r0 = Api34Impl.arrangeRouteListByPreference(r1, getAvailableRoutesFromRouter(), r10);     // Catch: Throwable -> L25
    L20:
        List<MediaRoute2Info> r11 = Api34Impl.filterDuplicatedIds(r0);     // Catch: Throwable -> L25
        monitor-exit(this);
        return r11;
    L23:
        monitor-exit(this);
        return r0;
    L25:
        th = move-exception;
        throw th;
    }

    void addMediaDevice(MediaRoute2Info r8, RoutingSessionInfo r9) {
        int r0 = r8.getType();
        if (r0 == 0) goto L30;
        MediaDevice r4 = null;
        if (r0 == 26) goto L25;
        if (r0 != 29) goto L9;
    L23:
        r4 = new PhoneMediaDevice(this.mContext, r8, this.mPreferenceItemMap.getOrDefault(r8.getId(), null));
    L31:
        if (r4 != null) goto L33;
        return;
    L33:
        if (r9.getSelectedRoutes().contains(r8.getId()) == false) goto L35;
        r4.setState(4);
    L35:
        this.mMediaDevices.add(r4);
        return;
    L9:
        if (r0 == 2000) goto L30;
        if (r0 == 2) goto L23;
        if (r0 == 3) goto L23;
        if (r0 == 4) goto L23;
        if (r0 == 22) goto L23;
        if (r0 == 23) goto L25;
        switch(r0) {
            case 8: goto L25;
            case 9: goto L23;
            case 10: goto L23;
            case 11: goto L23;
            case 12: goto L23;
            case 13: goto L23;
            default: goto L20;
        };
    L20:
        switch(r0) {
            case 1001: goto L30;
            case 1002: goto L30;
            case 1003: goto L22;
            case 1004: goto L30;
            case 1005: goto L30;
            case 1006: goto L30;
            case 1007: goto L30;
            case 1008: goto L30;
            case 1009: goto L30;
            case 1010: goto L30;
            default: goto L21;
        };
    L21:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "addMediaDevice() unknown device type : " + r0);
        goto L31
    L22:
        r4 = new ComplexMediaDevice(this.mContext, r8, this.mPreferenceItemMap.get(r8.getId()));
    L25:
        if (r8.getAddress() != null) goto L27;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_e(TAG, "Ignoring bluetooth route with no set address: " + r8);
        goto L31
    L27:
        CachedBluetoothDevice r1 = this.mBluetoothManager.getCachedDeviceManager().findDevice(BluetoothAdapter.getDefaultAdapter().getRemoteDevice(r8.getAddress()));
        if (r1 == null) goto L31;
        r4 = new BluetoothMediaDevice(this.mContext, r1, r8, this.mPreferenceItemMap.getOrDefault(r8.getId(), null));
    L30:
        r4 = new InfoMediaDevice(this.mContext, r8, this.mPreferenceItemMap.get(r8.getId()));
        goto L31
    }
}
