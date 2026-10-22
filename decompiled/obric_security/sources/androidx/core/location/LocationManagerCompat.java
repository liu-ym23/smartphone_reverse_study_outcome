package androidx.core.location;

import android.location.GnssMeasurementsEvent;
import android.location.GnssStatus;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationRequest;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.collection.SimpleArrayMap;
import androidx.core.os.CancellationSignal;
import androidx.core.os.ExecutorCompat;
import androidx.core.util.Consumer;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes.dex */
public final class LocationManagerCompat {
    private static final long GET_CURRENT_LOCATION_TIMEOUT_MS = 30000;
    private static final long MAX_CURRENT_LOCATION_AGE_MS = 10000;
    private static final long PRE_N_LOOPER_TIMEOUT_S = 5;
    private static Field sContextField;
    private static Method sGnssRequestBuilderBuildMethod;
    private static Class<?> sGnssRequestBuilderClass;
    static final WeakHashMap<LocationListenerKey, WeakReference<LocationListenerTransport>> sLocationListeners = null;
    private static Method sRegisterGnssMeasurementsCallbackMethod;

    static class Api19Impl {
        private static Class<?> sLocationRequestClass;
        private static Method sRequestLocationUpdatesLooperMethod;

        private Api19Impl() {
        }

        static boolean tryRequestLocationUpdates(LocationManager r8, String r9, LocationRequestCompat r10, LocationListenerTransport r11) {
            if (sLocationRequestClass != null) goto L7;
            sLocationRequestClass = Class.forName("android.location.LocationRequest");     // Catch: Throwable -> L20
        L7:
            if (sRequestLocationUpdatesLooperMethod != null) goto L9;
            Method r1 = LocationManager.class.getDeclaredMethod("requestLocationUpdates", new Class[]{sLocationRequestClass, LocationListener.class, Looper.class});     // Catch: Throwable -> L20
            sRequestLocationUpdatesLooperMethod = r1;     // Catch: Throwable -> L20
            r1.setAccessible(true);     // Catch: Throwable -> L20
        L9:
            LocationRequest r12 = r10.toLocationRequest(r9);     // Catch: Throwable -> L20
            if (r12 == null) goto L19;
            WeakHashMap<LocationListenerKey, WeakReference<LocationListenerTransport>> r13 = LocationManagerCompat.sLocationListeners;     // Catch: Throwable -> L20
            monitor-enter(r13);     // Catch: Throwable -> L20
            sRequestLocationUpdatesLooperMethod.invoke(r8, new Object[]{r12, r11, Looper.getMainLooper()});     // Catch: Throwable -> L16
            LocationManagerCompat.registerLocationListenerTransport(r8, r11);     // Catch: Throwable -> L16
            monitor-exit(r13);     // Catch: Throwable -> L16
            return true;
        L16:
            th = move-exception;
            throw th;     // Catch: Throwable -> L20 Throwable -> L20 Throwable -> L20 Throwable -> L20 Throwable -> L20
        L19:
            return false;
        }

        static boolean tryRequestLocationUpdates(LocationManager r8, String r9, LocationRequestCompat r10, LocationListenerCompat r11, Looper r12) {
            if (sLocationRequestClass != null) goto L7;
            sLocationRequestClass = Class.forName("android.location.LocationRequest");     // Catch: Throwable -> L14
        L7:
            if (sRequestLocationUpdatesLooperMethod != null) goto L9;
            Method r1 = LocationManager.class.getDeclaredMethod("requestLocationUpdates", new Class[]{sLocationRequestClass, LocationListener.class, Looper.class});     // Catch: Throwable -> L14
            sRequestLocationUpdatesLooperMethod = r1;     // Catch: Throwable -> L14
            r1.setAccessible(true);     // Catch: Throwable -> L14
        L9:
            LocationRequest r13 = r10.toLocationRequest(r9);     // Catch: Throwable -> L14
            if (r13 == null) goto L13;
            sRequestLocationUpdatesLooperMethod.invoke(r8, new Object[]{r13, r11, r12});     // Catch: Throwable -> L14
            return true;
        L13:
            return false;
        }
    }

    static class Api24Impl {
        private Api24Impl() {
        }

        static boolean registerGnssMeasurementsCallback(LocationManager r0, GnssMeasurementsEvent.Callback r1, Handler r2) {
            return r0.registerGnssMeasurementsCallback(r1, r2);
        }

        static void unregisterGnssMeasurementsCallback(LocationManager r0, GnssMeasurementsEvent.Callback r1) {
            r0.unregisterGnssMeasurementsCallback(r1);
        }

        static boolean registerGnssStatusCallback(LocationManager r4, Handler r5, Executor r6, GnssStatusCompat.Callback r7) {
            if (r5 == null) goto L5;
            boolean r2 = true;
        L6:
            Preconditions.checkArgument(r2);
            SimpleArrayMap<Object, Object> r3 = GnssListenersHolder.sGnssStatusListeners;
            monitor-enter(r3);
            PreRGnssStatusTransport r8 = (PreRGnssStatusTransport) GnssListenersHolder.sGnssStatusListeners.get(r7);     // Catch: Throwable -> L19
            if (r8 != null) goto L11;
            r8 = new PreRGnssStatusTransport(r7);     // Catch: Throwable -> L19
        L12:
            r8.register(r6);     // Catch: Throwable -> L19
            if (r4.registerGnssStatusCallback(r8, r5) == false) goto L17;
            GnssListenersHolder.sGnssStatusListeners.put(r7, r8);     // Catch: Throwable -> L19
            monitor-exit(r3);     // Catch: Throwable -> L19
            return true;
        L17:
            monitor-exit(r3);     // Catch: Throwable -> L19
            return false;
        L11:
            r8.unregister();     // Catch: Throwable -> L19
        L19:
            th = move-exception;
            throw th;
        L5:
            r2 = false;
            goto L6
        }

        static void unregisterGnssStatusCallback(LocationManager r1, Object r2) {
            if ((r2 instanceof PreRGnssStatusTransport) == false) goto L5;
            ((PreRGnssStatusTransport) r2).unregister();
        L5:
            r1.unregisterGnssStatusCallback((GnssStatus.Callback) r2);
        }
    }

    private static class Api28Impl {
        private Api28Impl() {
        }

        static boolean isLocationEnabled(LocationManager r0) {
            return r0.isLocationEnabled();
        }

        static String getGnssHardwareModelName(LocationManager r0) {
            return r0.getGnssHardwareModelName();
        }

        static int getGnssYearOfHardware(LocationManager r0) {
            return r0.getGnssYearOfHardware();
        }
    }

    private static class Api30Impl {
        private static Class<?> sLocationRequestClass;
        private static Method sRequestLocationUpdatesExecutorMethod;

        private Api30Impl() {
        }

        static void getCurrentLocation(LocationManager r1, String r2, CancellationSignal r3, Executor r4, final Consumer<Location> r5) {
            if (r3 == null) goto L4;
            android.os.CancellationSignal r6 = (android.os.CancellationSignal) r3.getCancellationSignalObject();
        L5:
            Objects.requireNonNull(r5);
            r1.getCurrentLocation(r2, r6, r4, new LocationManagerCompat$Api30Impl$$ExternalSyntheticLambda0(r5));
            return;
        L4:
            r6 = null;
            goto L5
        }

        public static boolean tryRequestLocationUpdates(LocationManager r8, String r9, LocationRequestCompat r10, Executor r11, LocationListenerCompat r12) {
            if (sLocationRequestClass != null) goto L7;
            sLocationRequestClass = Class.forName("android.location.LocationRequest");     // Catch: Throwable -> L14
        L7:
            if (sRequestLocationUpdatesExecutorMethod != null) goto L9;
            Method r1 = LocationManager.class.getDeclaredMethod("requestLocationUpdates", new Class[]{sLocationRequestClass, Executor.class, LocationListener.class});     // Catch: Throwable -> L14
            sRequestLocationUpdatesExecutorMethod = r1;     // Catch: Throwable -> L14
            r1.setAccessible(true);     // Catch: Throwable -> L14
        L9:
            LocationRequest r13 = r10.toLocationRequest(r9);     // Catch: Throwable -> L14
            if (r13 == null) goto L13;
            sRequestLocationUpdatesExecutorMethod.invoke(r8, new Object[]{r13, r11, r12});     // Catch: Throwable -> L14
            return true;
        L13:
            return false;
        }

        public static boolean registerGnssStatusCallback(LocationManager r1, Handler r2, Executor r3, GnssStatusCompat.Callback r4) {
            SimpleArrayMap<Object, Object> r5 = GnssListenersHolder.sGnssStatusListeners;
            monitor-enter(r5);
            GnssStatusTransport r0 = (GnssStatusTransport) GnssListenersHolder.sGnssStatusListeners.get(r4);     // Catch: Throwable -> L16
            if (r0 != null) goto L8;
            r0 = new GnssStatusTransport(r4);     // Catch: Throwable -> L16
        L8:
            if (r1.registerGnssStatusCallback(r3, r0) == false) goto L13;
            GnssListenersHolder.sGnssStatusListeners.put(r4, r0);     // Catch: Throwable -> L16
            monitor-exit(r5);     // Catch: Throwable -> L16
            return true;
        L13:
            monitor-exit(r5);     // Catch: Throwable -> L16
            return false;
        L16:
            th = move-exception;
            throw th;
        }
    }

    private static class Api31Impl {
        private Api31Impl() {
        }

        static boolean hasProvider(LocationManager r0, String r1) {
            return r0.hasProvider(r1);
        }

        static void requestLocationUpdates(LocationManager r0, String r1, LocationRequest r2, Executor r3, LocationListener r4) {
            r0.requestLocationUpdates(r1, r2, r3, r4);
        }

        static boolean registerGnssMeasurementsCallback(LocationManager r0, Executor r1, GnssMeasurementsEvent.Callback r2) {
            return r0.registerGnssMeasurementsCallback(r1, r2);
        }
    }

    private static final class CancellableLocationListener implements LocationListener {
        private Consumer<Location> mConsumer;
        private final Executor mExecutor;
        private final LocationManager mLocationManager;
        private final Handler mTimeoutHandler;
        Runnable mTimeoutRunnable;
        private boolean mTriggered;

        @Override // android.location.LocationListener
        public void onProviderEnabled(String r1) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String r1, int r2, Bundle r3) {
        }

        CancellableLocationListener(LocationManager r1, Executor r2, Consumer<Location> r3) {
            this.mLocationManager = r1;
            this.mExecutor = r2;
            this.mTimeoutHandler = new Handler(Looper.getMainLooper());
            this.mConsumer = r3;
        }

        public void cancel() {
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L4:
            if (this.mTriggered == false) goto L7;
            monitor-exit(this);     // Catch: Throwable -> L11
            return;
        L7:
            this.mTriggered = true;     // Catch: Throwable -> L11
            monitor-exit(this);     // Catch: Throwable -> L11
            cleanup();
        }

        public void startTimeout(long r3) {
            monitor-enter(this);
        L10:
            th = move-exception;
            throw th;
        L4:
            if (this.mTriggered == false) goto L7;
            monitor-exit(this);     // Catch: Throwable -> L10
            return;
        L7:
            Runnable r0 = new LocationManagerCompat$CancellableLocationListener$$ExternalSyntheticLambda0(this);     // Catch: Throwable -> L10
            this.mTimeoutRunnable = r0;     // Catch: Throwable -> L10
            this.mTimeoutHandler.postDelayed(r0, r3);     // Catch: Throwable -> L10
            monitor-exit(this);     // Catch: Throwable -> L10
        }

        /* JADX INFO: renamed from: lambda$startTimeout$0$androidx-core-location-LocationManagerCompat$CancellableLocationListener, reason: not valid java name */
        /* synthetic */ void m22x40ccd759() {
            this.mTimeoutRunnable = null;
            Location r1 = (Location) null;
            onLocationChanged(null);
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String r2) {
            Location r0 = (Location) null;
            onLocationChanged(null);
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(final Location r4) {
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L4:
            if (this.mTriggered == false) goto L7;
            monitor-exit(this);     // Catch: Throwable -> L11
            return;
        L7:
            this.mTriggered = true;     // Catch: Throwable -> L11
            monitor-exit(this);     // Catch: Throwable -> L11
            final Consumer<Location> r0 = this.mConsumer;
            this.mExecutor.execute(new LocationManagerCompat$CancellableLocationListener$$ExternalSyntheticLambda1(r0, r4));
            cleanup();
        }

        static /* synthetic */ void lambda$onLocationChanged$1(Consumer r0, Location r1) {
            r0.accept(r1);
        }

        private void cleanup() {
            this.mConsumer = null;
            this.mLocationManager.removeUpdates(this);
            Runnable r1 = this.mTimeoutRunnable;
            if (r1 == null) goto L6;
            this.mTimeoutHandler.removeCallbacks(r1);
            this.mTimeoutRunnable = null;
            return;
        }
    }

    private static class GnssListenersHolder {
        static final SimpleArrayMap<Object, Object> sGnssStatusListeners = null;

        private GnssListenersHolder() {
        }

        static {
            sGnssStatusListeners = new SimpleArrayMap();
        }
    }

    private static class GnssStatusTransport extends GnssStatus.Callback {
        final GnssStatusCompat.Callback mCallback;

        GnssStatusTransport(GnssStatusCompat.Callback r3) {
            if (r3 == null) goto L5;
            boolean r0 = true;
        L6:
            Preconditions.checkArgument(r0, "invalid null callback");
            this.mCallback = r3;
            return;
        L5:
            r0 = false;
            goto L6
        }

        @Override // android.location.GnssStatus.Callback
        public void onStarted() {
            this.mCallback.onStarted();
        }

        @Override // android.location.GnssStatus.Callback
        public void onStopped() {
            this.mCallback.onStopped();
        }

        @Override // android.location.GnssStatus.Callback
        public void onFirstFix(int r1) {
            this.mCallback.onFirstFix(r1);
        }

        @Override // android.location.GnssStatus.Callback
        public void onSatelliteStatusChanged(GnssStatus r1) {
            this.mCallback.onSatelliteStatusChanged(GnssStatusCompat.wrap(r1));
        }
    }

    private static class GpsStatusTransport implements GpsStatus.Listener {
        final GnssStatusCompat.Callback mCallback;
        volatile Executor mExecutor;
        private final LocationManager mLocationManager;

        GpsStatusTransport(LocationManager r3, GnssStatusCompat.Callback r4) {
            if (r4 == null) goto L5;
            boolean r0 = true;
        L6:
            Preconditions.checkArgument(r0, "invalid null callback");
            this.mLocationManager = r3;
            this.mCallback = r4;
            return;
        L5:
            r0 = false;
            goto L6
        }

        public void register(Executor r2) {
            if (this.mExecutor != null) goto L5;
            boolean r0 = true;
        L6:
            Preconditions.checkState(r0);
            this.mExecutor = r2;
            return;
        L5:
            r0 = false;
            goto L6
        }

        public void unregister() {
            this.mExecutor = null;
        }

        @Override // android.location.GpsStatus.Listener
        public void onGpsStatusChanged(int r4) {
            final Executor r0 = this.mExecutor;
            if (r0 != null) goto L6;
            return;
        L6:
            if (r4 != 1) goto L8;
            r0.execute(new LocationManagerCompat$GpsStatusTransport$$ExternalSyntheticLambda0(this, r0));
            return;
        L8:
            if (r4 != 2) goto L10;
            r0.execute(new LocationManagerCompat$GpsStatusTransport$$ExternalSyntheticLambda1(this, r0));
            return;
        L10:
            if (r4 != 3) goto L12;
            GpsStatus r5 = this.mLocationManager.getGpsStatus(null);
            if (r5 == null) goto L25;
            final int r6 = r5.getTimeToFirstFix();
            r0.execute(new LocationManagerCompat$GpsStatusTransport$$ExternalSyntheticLambda2(this, r0, r6));
            return;
        L25:
            return;
        L12:
            if (r4 != 4) goto L28;
            GpsStatus r7 = this.mLocationManager.getGpsStatus(null);
            if (r7 == null) goto L23;
            final GnssStatusCompat r8 = GnssStatusCompat.wrap(r7);
            r0.execute(new LocationManagerCompat$GpsStatusTransport$$ExternalSyntheticLambda3(this, r0, r8));
            return;
        L23:
            return;
        }

        /* JADX INFO: renamed from: lambda$onGpsStatusChanged$0$androidx-core-location-LocationManagerCompat$GpsStatusTransport, reason: not valid java name */
        /* synthetic */ void m23x75e92221(Executor r2) {
            if (this.mExecutor == r2) goto L5;
            return;
        L5:
            this.mCallback.onStarted();
        }

        /* JADX INFO: renamed from: lambda$onGpsStatusChanged$1$androidx-core-location-LocationManagerCompat$GpsStatusTransport, reason: not valid java name */
        /* synthetic */ void m24xc3a89a22(Executor r2) {
            if (this.mExecutor == r2) goto L5;
            return;
        L5:
            this.mCallback.onStopped();
        }

        /* JADX INFO: renamed from: lambda$onGpsStatusChanged$2$androidx-core-location-LocationManagerCompat$GpsStatusTransport, reason: not valid java name */
        /* synthetic */ void m25x11681223(Executor r2, int r3) {
            if (this.mExecutor == r2) goto L5;
            return;
        L5:
            this.mCallback.onFirstFix(r3);
        }

        /* JADX INFO: renamed from: lambda$onGpsStatusChanged$3$androidx-core-location-LocationManagerCompat$GpsStatusTransport, reason: not valid java name */
        /* synthetic */ void m26x5f278a24(Executor r2, GnssStatusCompat r3) {
            if (this.mExecutor == r2) goto L5;
            return;
        L5:
            this.mCallback.onSatelliteStatusChanged(r3);
        }
    }

    private static final class InlineHandlerExecutor implements Executor {
        private final Handler mHandler;

        InlineHandlerExecutor(Handler r1) {
            this.mHandler = (Handler) Preconditions.checkNotNull(r1);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r3) {
            if (Looper.myLooper() != this.mHandler.getLooper()) goto L6;
            r3.run();
            return;
        L6:
            if (this.mHandler.post((Runnable) Preconditions.checkNotNull(r3)) == false) goto L9;
            return;
        L9:
            throw new RejectedExecutionException(this.mHandler + " is shutting down");
        }
    }

    private static class LocationListenerKey {
        final LocationListenerCompat mListener;
        final String mProvider;

        LocationListenerKey(String r2, LocationListenerCompat r3) {
            this.mProvider = (String) ObjectsCompat.requireNonNull(r2, "invalid null provider");
            this.mListener = (LocationListenerCompat) ObjectsCompat.requireNonNull(r3, "invalid null listener");
        }

        public boolean equals(Object r4) {
            if ((r4 instanceof LocationListenerKey) == true) goto L5;
            return false;
        L5:
            LocationListenerKey r5 = (LocationListenerKey) r4;
            if (this.mProvider.equals(r5.mProvider) == true) goto L8;
            return false;
        L8:
            if (this.mListener.equals(r5.mListener) == false) goto L12;
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            return ObjectsCompat.hash(new Object[]{this.mProvider, this.mListener});
        }
    }

    private static class LocationListenerTransport implements LocationListener {
        final Executor mExecutor;
        volatile LocationListenerKey mKey;

        LocationListenerTransport(LocationListenerKey r1, Executor r2) {
            this.mKey = r1;
            this.mExecutor = r2;
        }

        public LocationListenerKey getKey() {
            return (LocationListenerKey) ObjectsCompat.requireNonNull(this.mKey);
        }

        public void unregister() {
            this.mKey = null;
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(final Location r3) {
            if (this.mKey != null) goto L5;
            return;
        L5:
            this.mExecutor.execute(new LocationManagerCompat$LocationListenerTransport$$ExternalSyntheticLambda4(this, r3));
        }

        /* JADX INFO: renamed from: lambda$onLocationChanged$0$androidx-core-location-LocationManagerCompat$LocationListenerTransport, reason: not valid java name */
        /* synthetic */ void m28xa8d50b3d(Location r1) {
            LocationListenerKey r0 = this.mKey;
            if (r0 != null) goto L5;
            return;
        L5:
            r0.mListener.onLocationChanged(r1);
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(final List<Location> r3) {
            if (this.mKey != null) goto L5;
            return;
        L5:
            this.mExecutor.execute(new LocationManagerCompat$LocationListenerTransport$$ExternalSyntheticLambda2(this, r3));
        }

        /* JADX INFO: renamed from: lambda$onLocationChanged$1$androidx-core-location-LocationManagerCompat$LocationListenerTransport, reason: not valid java name */
        /* synthetic */ void m29x2b1fc01c(List r1) {
            LocationListenerKey r0 = this.mKey;
            if (r0 != null) goto L5;
            return;
        L5:
            r0.mListener.onLocationChanged(r1);
        }

        @Override // android.location.LocationListener
        public void onFlushComplete(final int r3) {
            if (this.mKey != null) goto L5;
            return;
        L5:
            this.mExecutor.execute(new LocationManagerCompat$LocationListenerTransport$$ExternalSyntheticLambda1(this, r3));
        }

        /* JADX INFO: renamed from: lambda$onFlushComplete$2$androidx-core-location-LocationManagerCompat$LocationListenerTransport, reason: not valid java name */
        /* synthetic */ void m27xf04cfe9d(int r1) {
            LocationListenerKey r0 = this.mKey;
            if (r0 != null) goto L5;
            return;
        L5:
            r0.mListener.onFlushComplete(r1);
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(final String r3, final int r4, final Bundle r5) {
            if (this.mKey != null) goto L5;
            return;
        L5:
            this.mExecutor.execute(new LocationManagerCompat$LocationListenerTransport$$ExternalSyntheticLambda5(this, r3, r4, r5));
        }

        /* JADX INFO: renamed from: lambda$onStatusChanged$3$androidx-core-location-LocationManagerCompat$LocationListenerTransport, reason: not valid java name */
        /* synthetic */ void m32xdbe6a717(String r1, int r2, Bundle r3) {
            LocationListenerKey r0 = this.mKey;
            if (r0 != null) goto L5;
            return;
        L5:
            r0.mListener.onStatusChanged(r1, r2, r3);
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(final String r3) {
            if (this.mKey != null) goto L5;
            return;
        L5:
            this.mExecutor.execute(new LocationManagerCompat$LocationListenerTransport$$ExternalSyntheticLambda0(this, r3));
        }

        /* JADX INFO: renamed from: lambda$onProviderEnabled$4$androidx-core-location-LocationManagerCompat$LocationListenerTransport, reason: not valid java name */
        /* synthetic */ void m31x5a2a7b08(String r1) {
            LocationListenerKey r0 = this.mKey;
            if (r0 != null) goto L5;
            return;
        L5:
            r0.mListener.onProviderEnabled(r1);
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(final String r3) {
            if (this.mKey != null) goto L5;
            return;
        L5:
            this.mExecutor.execute(new LocationManagerCompat$LocationListenerTransport$$ExternalSyntheticLambda3(this, r3));
        }

        /* JADX INFO: renamed from: lambda$onProviderDisabled$5$androidx-core-location-LocationManagerCompat$LocationListenerTransport, reason: not valid java name */
        /* synthetic */ void m30x442abc92(String r1) {
            LocationListenerKey r0 = this.mKey;
            if (r0 != null) goto L5;
            return;
        L5:
            r0.mListener.onProviderDisabled(r1);
        }
    }

    private static class PreRGnssStatusTransport extends GnssStatus.Callback {
        final GnssStatusCompat.Callback mCallback;
        volatile Executor mExecutor;

        PreRGnssStatusTransport(GnssStatusCompat.Callback r3) {
            if (r3 == null) goto L5;
            boolean r0 = true;
        L6:
            Preconditions.checkArgument(r0, "invalid null callback");
            this.mCallback = r3;
            return;
        L5:
            r0 = false;
            goto L6
        }

        public void register(Executor r5) {
            boolean r0 = true;
            if (r5 == null) goto L5;
            boolean r2 = true;
        L6:
            Preconditions.checkArgument(r2, "invalid null executor");
            if (this.mExecutor == null) goto L10;
            r0 = false;
        L10:
            Preconditions.checkState(r0);
            this.mExecutor = r5;
            return;
        L5:
            r2 = false;
            goto L6
        }

        public void unregister() {
            this.mExecutor = null;
        }

        @Override // android.location.GnssStatus.Callback
        public void onStarted() {
            final Executor r0 = this.mExecutor;
            if (r0 != null) goto L5;
            return;
        L5:
            r0.execute(new LocationManagerCompat$PreRGnssStatusTransport$$ExternalSyntheticLambda0(this, r0));
        }

        /* JADX INFO: renamed from: lambda$onStarted$0$androidx-core-location-LocationManagerCompat$PreRGnssStatusTransport, reason: not valid java name */
        /* synthetic */ void m35x7ba12b9c(Executor r2) {
            if (this.mExecutor == r2) goto L5;
            return;
        L5:
            this.mCallback.onStarted();
        }

        @Override // android.location.GnssStatus.Callback
        public void onStopped() {
            final Executor r0 = this.mExecutor;
            if (r0 != null) goto L5;
            return;
        L5:
            r0.execute(new LocationManagerCompat$PreRGnssStatusTransport$$ExternalSyntheticLambda3(this, r0));
        }

        /* JADX INFO: renamed from: lambda$onStopped$1$androidx-core-location-LocationManagerCompat$PreRGnssStatusTransport, reason: not valid java name */
        /* synthetic */ void m36x80a5cd6f(Executor r2) {
            if (this.mExecutor == r2) goto L5;
            return;
        L5:
            this.mCallback.onStopped();
        }

        @Override // android.location.GnssStatus.Callback
        public void onFirstFix(final int r3) {
            final Executor r0 = this.mExecutor;
            if (r0 != null) goto L5;
            return;
        L5:
            r0.execute(new LocationManagerCompat$PreRGnssStatusTransport$$ExternalSyntheticLambda2(this, r0, r3));
        }

        /* JADX INFO: renamed from: lambda$onFirstFix$2$androidx-core-location-LocationManagerCompat$PreRGnssStatusTransport, reason: not valid java name */
        /* synthetic */ void m33x4191f1e(Executor r2, int r3) {
            if (this.mExecutor == r2) goto L5;
            return;
        L5:
            this.mCallback.onFirstFix(r3);
        }

        @Override // android.location.GnssStatus.Callback
        public void onSatelliteStatusChanged(final GnssStatus r3) {
            final Executor r0 = this.mExecutor;
            if (r0 != null) goto L5;
            return;
        L5:
            r0.execute(new LocationManagerCompat$PreRGnssStatusTransport$$ExternalSyntheticLambda1(this, r0, r3));
        }

        /* JADX INFO: renamed from: lambda$onSatelliteStatusChanged$3$androidx-core-location-LocationManagerCompat$PreRGnssStatusTransport, reason: not valid java name */
        /* synthetic */ void m34xdecf6cdb(Executor r2, GnssStatus r3) {
            if (this.mExecutor == r2) goto L5;
            return;
        L5:
            this.mCallback.onSatelliteStatusChanged(GnssStatusCompat.wrap(r3));
        }
    }

    public static boolean isLocationEnabled(LocationManager r0) {
        return Api28Impl.isLocationEnabled(r0);
    }

    public static boolean hasProvider(LocationManager r2, String r3) {
        if (Build.VERSION.SDK_INT < 31) goto L7;
        return Api31Impl.hasProvider(r2, r3);
    L7:
        if (r2.getAllProviders().contains(r3) == false) goto L16;
        return true;
    L16:
        if (r2.getProvider(r3) == null) goto L14;
        return true;
    L14:
        return false;
    L15:
        return false;
    }

    public static void getCurrentLocation(LocationManager r0, String r1, CancellationSignal r2, Executor r3, Consumer<Location> r4) {
        Api30Impl.getCurrentLocation(r0, r1, r2, r3, r4);
    }

    static /* synthetic */ void lambda$getCurrentLocation$0(Consumer r0, Location r1) {
        r0.accept(r1);
    }

    static {
        sLocationListeners = new WeakHashMap();
    }

    public static void requestLocationUpdates(LocationManager r8, String r9, LocationRequestCompat r10, Executor r11, LocationListenerCompat r12) {
        if (Build.VERSION.SDK_INT < 31) goto L7;
        Api31Impl.requestLocationUpdates(r8, r9, r10.toLocationRequest(), r11, r12);
        return;
    L7:
        if (Api30Impl.tryRequestLocationUpdates(r8, r9, r10, r11, r12) == false) goto L9;
        return;
    L9:
        LocationListenerTransport r0 = new LocationListenerTransport(new LocationListenerKey(r9, r12), r11);
        if (Api19Impl.tryRequestLocationUpdates(r8, r9, r10, r0) == false) goto L12;
        return;
    L12:
        WeakHashMap<LocationListenerKey, WeakReference<LocationListenerTransport>> r13 = sLocationListeners;
        monitor-enter(r13);
        r8.requestLocationUpdates(r9, r10.getIntervalMillis(), r10.getMinUpdateDistanceMeters(), r0, Looper.getMainLooper());     // Catch: Throwable -> L17
        registerLocationListenerTransport(r8, r0);     // Catch: Throwable -> L17
        monitor-exit(r13);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    }

    static void registerLocationListenerTransport(LocationManager r3, LocationListenerTransport r4) {
        WeakReference<LocationListenerTransport> r5 = sLocationListeners.put(r4.getKey(), new WeakReference(r4));
        if (r5 == null) goto L5;
        LocationListenerTransport r6 = r5.get();
    L6:
        if (r6 == null) goto L9;
        r6.unregister();
        r3.removeUpdates(r6);
        return;
    L9:
        return;
    L5:
        r6 = null;
        goto L6
    }

    public static void requestLocationUpdates(LocationManager r8, String r9, LocationRequestCompat r10, LocationListenerCompat r11, Looper r12) {
        if (Build.VERSION.SDK_INT < 31) goto L7;
        Api31Impl.requestLocationUpdates(r8, r9, r10.toLocationRequest(), ExecutorCompat.create(new Handler(r12)), r11);
        return;
    L7:
        if (Api19Impl.tryRequestLocationUpdates(r8, r9, r10, r11, r12) == false) goto L9;
        return;
    L9:
        r8.requestLocationUpdates(r9, r10.getIntervalMillis(), r10.getMinUpdateDistanceMeters(), r11, r12);
    }

    public static void removeUpdates(LocationManager r6, LocationListenerCompat r7) {
        WeakHashMap<LocationListenerKey, WeakReference<LocationListenerTransport>> r0 = sLocationListeners;
        monitor-enter(r0);
        Iterator<WeakReference<LocationListenerTransport>> r1 = r0.values().iterator();     // Catch: Throwable -> L23
        ArrayList r2 = null;
    L6:
        if (r1.hasNext() == false) goto L15;
        LocationListenerTransport r3 = r1.next().get();     // Catch: Throwable -> L23
        if (r3 == null) goto L6;
        LocationListenerKey r4 = r3.getKey();     // Catch: Throwable -> L23
        if (r4.mListener != r7) goto L6;
        if (r2 != null) goto L14;
        r2 = new ArrayList();     // Catch: Throwable -> L23
    L14:
        r2.add(r4);     // Catch: Throwable -> L23
        r3.unregister();     // Catch: Throwable -> L23
        r6.removeUpdates(r3);     // Catch: Throwable -> L23
        goto L6
    L15:
        if (r2 == null) goto L20;
        Iterator r5 = r2.iterator();     // Catch: Throwable -> L23
    L18:
        if (r5.hasNext() == false) goto L20;
        LocationListenerKey r8 = (LocationListenerKey) r5.next();     // Catch: Throwable -> L23
        sLocationListeners.remove(r8);     // Catch: Throwable -> L23
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L23
        r6.removeUpdates(r7);
        return;
    L23:
        th = move-exception;
        throw th;
    }

    public static String getGnssHardwareModelName(LocationManager r0) {
        return Api28Impl.getGnssHardwareModelName(r0);
    }

    public static int getGnssYearOfHardware(LocationManager r0) {
        return Api28Impl.getGnssYearOfHardware(r0);
    }

    public static boolean registerGnssMeasurementsCallback(LocationManager r2, GnssMeasurementsEvent.Callback r3, Handler r4) {
        if (Build.VERSION.SDK_INT == 30) goto L7;
        return Api24Impl.registerGnssMeasurementsCallback(r2, r3, r4);
    L7:
        return registerGnssMeasurementsCallbackOnR(r2, ExecutorCompat.create(r4), r3);
    }

    public static boolean registerGnssMeasurementsCallback(LocationManager r2, Executor r3, GnssMeasurementsEvent.Callback r4) {
        if (Build.VERSION.SDK_INT <= 30) goto L7;
        return Api31Impl.registerGnssMeasurementsCallback(r2, r3, r4);
    L7:
        return registerGnssMeasurementsCallbackOnR(r2, r3, r4);
    }

    public static void unregisterGnssMeasurementsCallback(LocationManager r0, GnssMeasurementsEvent.Callback r1) {
        Api24Impl.unregisterGnssMeasurementsCallback(r0, r1);
    }

    private static boolean registerGnssMeasurementsCallbackOnR(LocationManager r8, Executor r9, GnssMeasurementsEvent.Callback r10) {
        if (Build.VERSION.SDK_INT != 30) goto L21;
        if (sGnssRequestBuilderClass != null) goto L9;
        sGnssRequestBuilderClass = Class.forName("android.location.GnssRequest$Builder");     // Catch: Throwable -> L22
    L9:
        if (sGnssRequestBuilderBuildMethod != null) goto L12;
        Method r1 = sGnssRequestBuilderClass.getDeclaredMethod("build", new Class[0]);     // Catch: Throwable -> L22
        sGnssRequestBuilderBuildMethod = r1;     // Catch: Throwable -> L22
        r1.setAccessible(true);     // Catch: Throwable -> L22
    L12:
        if (sRegisterGnssMeasurementsCallbackMethod != null) goto L14;
        Method r2 = LocationManager.class.getDeclaredMethod("registerGnssMeasurementsCallback", new Class[]{Class.forName("android.location.GnssRequest"), Executor.class, GnssMeasurementsEvent.Callback.class});     // Catch: Throwable -> L22
        sRegisterGnssMeasurementsCallbackMethod = r2;     // Catch: Throwable -> L22
        r2.setAccessible(true);     // Catch: Throwable -> L22
    L14:
        Object r11 = sRegisterGnssMeasurementsCallbackMethod.invoke(r8, new Object[]{sGnssRequestBuilderBuildMethod.invoke(sGnssRequestBuilderClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]), new Object[0]), r9, r10});     // Catch: Throwable -> L22
        if (r11 == null) goto L25;
        if (((Boolean) r11).booleanValue() == true) goto L19;
        return false;
    L19:
        return true;
    L25:
        return false;
    L27:
        return false;
    L21:
        throw new IllegalStateException();
    }

    public static boolean registerGnssStatusCallback(LocationManager r0, GnssStatusCompat.Callback r1, Handler r2) {
        return registerGnssStatusCallback(r0, ExecutorCompat.create(r2), r1);
    }

    public static boolean registerGnssStatusCallback(LocationManager r1, Executor r2, GnssStatusCompat.Callback r3) {
        return registerGnssStatusCallback(r1, null, r2, r3);
    }

    private static boolean registerGnssStatusCallback(LocationManager r0, Handler r1, Executor r2, GnssStatusCompat.Callback r3) {
        return Api30Impl.registerGnssStatusCallback(r0, r1, r2, r3);
    }

    static /* synthetic */ Boolean lambda$registerGnssStatusCallback$1(LocationManager r0, GpsStatusTransport r1) throws Exception {
        return Boolean.valueOf(r0.addGpsStatusListener(r1));
    }

    public static void unregisterGnssStatusCallback(LocationManager r2, GnssStatusCompat.Callback r3) {
        SimpleArrayMap<Object, Object> r0 = GnssListenersHolder.sGnssStatusListeners;
        monitor-enter(r0);
        Object r4 = GnssListenersHolder.sGnssStatusListeners.remove(r3);     // Catch: Throwable -> L9
        if (r4 == null) goto L7;
        Api24Impl.unregisterGnssStatusCallback(r2, r4);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private LocationManagerCompat() {
    }
}
