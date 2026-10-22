package androidx.core.location;

import android.annotation.SuppressLint;
import android.content.Context;
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
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.DoNotInline;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import androidx.collection.SimpleArrayMap;
import androidx.core.os.CancellationSignal;
import androidx.core.os.ExecutorCompat;
import androidx.core.util.Consumer;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
public final class LocationManagerCompat {
    private static final long GET_CURRENT_LOCATION_TIMEOUT_MS = 30000;
    private static final long MAX_CURRENT_LOCATION_AGE_MS = 10000;
    private static final long PRE_N_LOOPER_TIMEOUT_S = 5;
    private static Field sContextField;
    private static Method sGnssRequestBuilderBuildMethod;
    private static Class<?> sGnssRequestBuilderClass;

    @GuardedBy("sLocationListeners")
    static final WeakHashMap<LocationListenerKey, WeakReference<LocationListenerTransport>> sLocationListeners = null;
    private static Method sRegisterGnssMeasurementsCallbackMethod;

    @RequiresApi(19)
    static class Api19Impl {
        private static Class<?> sLocationRequestClass;
        private static Method sRequestLocationUpdatesLooperMethod;

        private Api19Impl() {
        }

        @DoNotInline
        static boolean tryRequestLocationUpdates(LocationManager r8, String r9, LocationRequestCompat r10, LocationListenerCompat r11, Looper r12) {
            if (Build.VERSION.SDK_INT >= 19) goto L16;
        L14:
            return false;
        L16:
            if (sLocationRequestClass != null) goto L8;
            sLocationRequestClass = Class.forName("android.location.LocationRequest");     // Catch: Throwable -> L15
        L8:
            if (sRequestLocationUpdatesLooperMethod != null) goto L10;
            Method r0 = LocationManager.class.getDeclaredMethod("requestLocationUpdates", new Class[]{sLocationRequestClass, LocationListener.class, Looper.class});     // Catch: Throwable -> L15
            sRequestLocationUpdatesLooperMethod = r0;     // Catch: Throwable -> L15
            r0.setAccessible(true);     // Catch: Throwable -> L15
        L10:
            LocationRequest r13 = r10.toLocationRequest(r9);     // Catch: Throwable -> L15
            if (r13 == null) goto L14;
            sRequestLocationUpdatesLooperMethod.invoke(r8, new Object[]{r13, r11, r12});     // Catch: Throwable -> L15
            return true;
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        @DoNotInline
        static boolean tryRequestLocationUpdates(LocationManager r8, String r9, LocationRequestCompat r10, LocationListenerTransport r11) {
            if (Build.VERSION.SDK_INT >= 19) goto L22;
        L20:
            return false;
        L22:
            if (sLocationRequestClass != null) goto L8;
            sLocationRequestClass = Class.forName("android.location.LocationRequest");     // Catch: Throwable -> L21
        L8:
            if (sRequestLocationUpdatesLooperMethod != null) goto L10;
            Method r0 = LocationManager.class.getDeclaredMethod("requestLocationUpdates", new Class[]{sLocationRequestClass, LocationListener.class, Looper.class});     // Catch: Throwable -> L21
            sRequestLocationUpdatesLooperMethod = r0;     // Catch: Throwable -> L21
            r0.setAccessible(true);     // Catch: Throwable -> L21
        L10:
            LocationRequest r12 = r10.toLocationRequest(r9);     // Catch: Throwable -> L21
            if (r12 == null) goto L20;
            WeakHashMap<LocationListenerKey, WeakReference<LocationListenerTransport>> r13 = LocationManagerCompat.sLocationListeners;     // Catch: Throwable -> L21
            monitor-enter(r13);     // Catch: Throwable -> L21
            sRequestLocationUpdatesLooperMethod.invoke(r8, new Object[]{r12, r11, Looper.getMainLooper()});     // Catch: Throwable -> L17
            LocationManagerCompat.registerLocationListenerTransport(r8, r11);     // Catch: Throwable -> L17
            monitor-exit(r13);     // Catch: Throwable -> L17
            return true;
        L17:
            th = move-exception;
            throw th;     // Catch: Throwable -> L21 Throwable -> L21 Throwable -> L21 Throwable -> L21 Throwable -> L21
        }
    }

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
        @DoNotInline
        static boolean registerGnssMeasurementsCallback(@NonNull LocationManager r0, @NonNull GnssMeasurementsEvent.Callback r1, @NonNull Handler r2) {
            return r0.registerGnssMeasurementsCallback(r1, r2);
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        @DoNotInline
        static boolean registerGnssStatusCallback(LocationManager r4, Handler r5, Executor r6, GnssStatusCompat.Callback r7) {
            if (r5 == null) goto L5;
            boolean r2 = true;
        L6:
            Preconditions.checkArgument(r2);
            SimpleArrayMap<Object, Object> r3 = GnssListenersHolder.sGnssStatusListeners;
            monitor-enter(r3);
            PreRGnssStatusTransport r8 = (PreRGnssStatusTransport) r3.get(r7);     // Catch: Throwable -> L19
            if (r8 != null) goto L11;
            r8 = new PreRGnssStatusTransport(r7);     // Catch: Throwable -> L19
        L12:
            r8.register(r6);     // Catch: Throwable -> L19
            if (r4.registerGnssStatusCallback(r8, r5) == false) goto L17;
            r3.put(r7, r8);     // Catch: Throwable -> L19
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

        @DoNotInline
        static void unregisterGnssMeasurementsCallback(@NonNull LocationManager r0, @NonNull GnssMeasurementsEvent.Callback r1) {
            r0.unregisterGnssMeasurementsCallback(r1);
        }

        @DoNotInline
        static void unregisterGnssStatusCallback(LocationManager r1, Object r2) {
            if ((r2 instanceof PreRGnssStatusTransport) == false) goto L5;
            ((PreRGnssStatusTransport) r2).unregister();
        L5:
            r1.unregisterGnssStatusCallback((GnssStatus.Callback) r2);
        }
    }

    @RequiresApi(28)
    private static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static String getGnssHardwareModelName(LocationManager r0) {
            return r0.getGnssHardwareModelName();
        }

        @DoNotInline
        static int getGnssYearOfHardware(LocationManager r0) {
            return r0.getGnssYearOfHardware();
        }

        @DoNotInline
        static boolean isLocationEnabled(LocationManager r0) {
            return r0.isLocationEnabled();
        }
    }

    @RequiresApi(30)
    private static class Api30Impl {
        private static Class<?> sLocationRequestClass;
        private static Method sRequestLocationUpdatesExecutorMethod;

        private Api30Impl() {
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        @DoNotInline
        static void getCurrentLocation(LocationManager r1, @NonNull String r2, @Nullable CancellationSignal r3, @NonNull Executor r4, @NonNull final Consumer<Location> r5) {
            if (r3 == null) goto L4;
            android.os.CancellationSignal r6 = (android.os.CancellationSignal) r3.getCancellationSignalObject();
        L5:
            Objects.requireNonNull(r5);
            r1.getCurrentLocation(r2, r6, r4, new s(r5));
            return;
        L4:
            r6 = null;
            goto L5
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        @DoNotInline
        public static boolean registerGnssStatusCallback(LocationManager r1, Handler r2, Executor r3, GnssStatusCompat.Callback r4) {
            SimpleArrayMap<Object, Object> r5 = GnssListenersHolder.sGnssStatusListeners;
            monitor-enter(r5);
            GnssStatusTransport r0 = (GnssStatusTransport) r5.get(r4);     // Catch: Throwable -> L15
            if (r0 != null) goto L8;
            r0 = new GnssStatusTransport(r4);     // Catch: Throwable -> L15
        L8:
            if (r1.registerGnssStatusCallback(r3, r0) == false) goto L13;
            r5.put(r4, r0);     // Catch: Throwable -> L15
            monitor-exit(r5);     // Catch: Throwable -> L15
            return true;
        L13:
            monitor-exit(r5);     // Catch: Throwable -> L15
            return false;
        L15:
            th = move-exception;
            throw th;
        }

        @DoNotInline
        public static boolean tryRequestLocationUpdates(LocationManager r8, String r9, LocationRequestCompat r10, Executor r11, LocationListenerCompat r12) {
            if (Build.VERSION.SDK_INT >= 30) goto L16;
        L14:
            return false;
        L16:
            if (sLocationRequestClass != null) goto L8;
            sLocationRequestClass = Class.forName("android.location.LocationRequest");     // Catch: Throwable -> L15
        L8:
            if (sRequestLocationUpdatesExecutorMethod != null) goto L10;
            Method r0 = LocationManager.class.getDeclaredMethod("requestLocationUpdates", new Class[]{sLocationRequestClass, Executor.class, LocationListener.class});     // Catch: Throwable -> L15
            sRequestLocationUpdatesExecutorMethod = r0;     // Catch: Throwable -> L15
            r0.setAccessible(true);     // Catch: Throwable -> L15
        L10:
            LocationRequest r13 = r10.toLocationRequest(r9);     // Catch: Throwable -> L15
            if (r13 == null) goto L14;
            sRequestLocationUpdatesExecutorMethod.invoke(r8, new Object[]{r13, r11, r12});     // Catch: Throwable -> L15
            return true;
        }
    }

    @RequiresApi(31)
    private static class Api31Impl {
        private Api31Impl() {
        }

        @DoNotInline
        static boolean hasProvider(LocationManager r0, @NonNull String r1) {
            return r0.hasProvider(r1);
        }

        @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
        @DoNotInline
        static boolean registerGnssMeasurementsCallback(@NonNull LocationManager r0, @NonNull Executor r1, @NonNull GnssMeasurementsEvent.Callback r2) {
            return r0.registerGnssMeasurementsCallback(r1, r2);
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        @DoNotInline
        static void requestLocationUpdates(LocationManager r0, @NonNull String r1, @NonNull LocationRequest r2, @NonNull Executor r3, @NonNull LocationListener r4) {
            r0.requestLocationUpdates(r1, r2, r3, r4);
        }
    }

    private static final class CancellableLocationListener implements LocationListener {
        private Consumer<Location> mConsumer;
        private final Executor mExecutor;
        private final LocationManager mLocationManager;
        private final Handler mTimeoutHandler;

        @Nullable
        Runnable mTimeoutRunnable;

        @GuardedBy("this")
        private boolean mTriggered;

        CancellableLocationListener(LocationManager r1, Executor r2, Consumer<Location> r3) {
            this.mLocationManager = r1;
            this.mExecutor = r2;
            this.mTimeoutHandler = new Handler(Looper.getMainLooper());
            this.mConsumer = r3;
        }

        static /* synthetic */ void a(Consumer r0, Location r1) {
            r0.accept(r1);
        }

        private /* synthetic */ void b() {
            this.mTimeoutRunnable = null;
            onLocationChanged(null);
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        private void cleanup() {
            this.mConsumer = null;
            this.mLocationManager.removeUpdates(this);
            Runnable r1 = this.mTimeoutRunnable;
            if (r1 == null) goto L6;
            this.mTimeoutHandler.removeCallbacks(r1);
            this.mTimeoutRunnable = null;
            return;
        }

        public /* synthetic */ void c() {
            b();
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
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

        @Override // android.location.LocationListener
        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        public void onLocationChanged(@Nullable final Location r4) {
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
            this.mExecutor.execute(new b(r0, r4));
            cleanup();
        }

        @Override // android.location.LocationListener
        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        public void onProviderDisabled(@NonNull String r1) {
            onLocationChanged(null);
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(@NonNull String r1) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String r1, int r2, Bundle r3) {
        }

        @SuppressLint({"MissingPermission"})
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
            Runnable r0 = new c(this);     // Catch: Throwable -> L10
            this.mTimeoutRunnable = r0;     // Catch: Throwable -> L10
            this.mTimeoutHandler.postDelayed(r0, r3);     // Catch: Throwable -> L10
            monitor-exit(this);     // Catch: Throwable -> L10
        }
    }

    private static class GnssListenersHolder {

        @GuardedBy("sGnssStatusListeners")
        static final SimpleArrayMap<Object, Object> sGnssStatusListeners = null;

        static {
            sGnssStatusListeners = new SimpleArrayMap();
        }

        private GnssListenersHolder() {
        }
    }

    @RequiresApi(30)
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
        public void onFirstFix(int r1) {
            this.mCallback.onFirstFix(r1);
        }

        @Override // android.location.GnssStatus.Callback
        public void onSatelliteStatusChanged(GnssStatus r1) {
            this.mCallback.onSatelliteStatusChanged(GnssStatusCompat.wrap(r1));
        }

        @Override // android.location.GnssStatus.Callback
        public void onStarted() {
            this.mCallback.onStarted();
        }

        @Override // android.location.GnssStatus.Callback
        public void onStopped() {
            this.mCallback.onStopped();
        }
    }

    private static class GpsStatusTransport implements GpsStatus.Listener {
        final GnssStatusCompat.Callback mCallback;

        @Nullable
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

        private /* synthetic */ void a(Executor r2) {
            if (this.mExecutor == r2) goto L5;
            return;
        L5:
            this.mCallback.onStarted();
        }

        private /* synthetic */ void c(Executor r2) {
            if (this.mExecutor == r2) goto L5;
            return;
        L5:
            this.mCallback.onStopped();
        }

        private /* synthetic */ void e(Executor r2, int r3) {
            if (this.mExecutor == r2) goto L5;
            return;
        L5:
            this.mCallback.onFirstFix(r3);
        }

        private /* synthetic */ void g(Executor r2, GnssStatusCompat r3) {
            if (this.mExecutor == r2) goto L5;
            return;
        L5:
            this.mCallback.onSatelliteStatusChanged(r3);
        }

        public /* synthetic */ void b(Executor r1) {
            a(r1);
        }

        public /* synthetic */ void d(Executor r1) {
            c(r1);
        }

        public /* synthetic */ void f(Executor r1, int r2) {
            e(r1, r2);
        }

        public /* synthetic */ void h(Executor r1, GnssStatusCompat r2) {
            g(r1, r2);
        }

        @Override // android.location.GpsStatus.Listener
        @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
        public void onGpsStatusChanged(int r4) {
            final Executor r0 = this.mExecutor;
            if (r0 != null) goto L6;
            return;
        L6:
            if (r4 != 1) goto L8;
            Runnable r5 = new f(this, r0);
        L23:
            r0.execute(r5);
            return;
        L8:
            if (r4 != 2) goto L10;
            r5 = new g(this, r0);
            goto L23
        L10:
            if (r4 != 3) goto L12;
            GpsStatus r6 = this.mLocationManager.getGpsStatus(null);
            if (r6 == null) goto L26;
            final int r7 = r6.getTimeToFirstFix();
            Runnable r1 = new d(this, r0, r7);
        L20:
            r0.execute(r1);
            return;
        L26:
            return;
        L12:
            if (r4 != 4) goto L28;
            GpsStatus r8 = this.mLocationManager.getGpsStatus(null);
            if (r8 == null) goto L25;
            final GnssStatusCompat r9 = GnssStatusCompat.wrap(r8);
            r1 = new e(this, r0, r9);
            goto L20
        L25:
            return;
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
    }

    private static final class InlineHandlerExecutor implements Executor {
        private final Handler mHandler;

        InlineHandlerExecutor(@NonNull Handler r1) {
            this.mHandler = (Handler) Preconditions.checkNotNull(r1);
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable r3) {
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

        @Nullable
        volatile LocationListenerKey mKey;

        LocationListenerTransport(@Nullable LocationListenerKey r1, Executor r2) {
            this.mKey = r1;
            this.mExecutor = r2;
        }

        private /* synthetic */ void a(int r1) {
            LocationListenerKey r0 = this.mKey;
            if (r0 != null) goto L5;
            return;
        L5:
            r0.mListener.onFlushComplete(r1);
        }

        private /* synthetic */ void c(Location r1) {
            LocationListenerKey r0 = this.mKey;
            if (r0 != null) goto L5;
            return;
        L5:
            r0.mListener.onLocationChanged(r1);
        }

        private /* synthetic */ void e(List r1) {
            LocationListenerKey r0 = this.mKey;
            if (r0 != null) goto L5;
            return;
        L5:
            r0.mListener.onLocationChanged(r1);
        }

        private /* synthetic */ void g(String r1) {
            LocationListenerKey r0 = this.mKey;
            if (r0 != null) goto L5;
            return;
        L5:
            r0.mListener.onProviderDisabled(r1);
        }

        private /* synthetic */ void i(String r1) {
            LocationListenerKey r0 = this.mKey;
            if (r0 != null) goto L5;
            return;
        L5:
            r0.mListener.onProviderEnabled(r1);
        }

        private /* synthetic */ void k(String r1, int r2, Bundle r3) {
            LocationListenerKey r0 = this.mKey;
            if (r0 != null) goto L5;
            return;
        L5:
            r0.mListener.onStatusChanged(r1, r2, r3);
        }

        public /* synthetic */ void b(int r1) {
            a(r1);
        }

        public /* synthetic */ void d(Location r1) {
            c(r1);
        }

        public /* synthetic */ void f(List r1) {
            e(r1);
        }

        public LocationListenerKey getKey() {
            return (LocationListenerKey) ObjectsCompat.requireNonNull(this.mKey);
        }

        public /* synthetic */ void h(String r1) {
            g(r1);
        }

        public /* synthetic */ void j(String r1) {
            i(r1);
        }

        public /* synthetic */ void l(String r1, int r2, Bundle r3) {
            k(r1, r2, r3);
        }

        @Override // android.location.LocationListener
        public void onFlushComplete(final int r3) {
            if (this.mKey != null) goto L5;
            return;
        L5:
            this.mExecutor.execute(new l(this, r3));
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(@NonNull final Location r3) {
            if (this.mKey != null) goto L5;
            return;
        L5:
            this.mExecutor.execute(new n(this, r3));
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(@NonNull final List<Location> r3) {
            if (this.mKey != null) goto L5;
            return;
        L5:
            this.mExecutor.execute(new k(this, r3));
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(@NonNull final String r3) {
            if (this.mKey != null) goto L5;
            return;
        L5:
            this.mExecutor.execute(new m(this, r3));
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(@NonNull final String r3) {
            if (this.mKey != null) goto L5;
            return;
        L5:
            this.mExecutor.execute(new i(this, r3));
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(final String r3, final int r4, final Bundle r5) {
            if (this.mKey != null) goto L5;
            return;
        L5:
            this.mExecutor.execute(new j(this, r3, r4, r5));
        }

        public void unregister() {
            this.mKey = null;
        }
    }

    @RequiresApi(24)
    private static class PreRGnssStatusTransport extends GnssStatus.Callback {
        final GnssStatusCompat.Callback mCallback;

        @Nullable
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

        private /* synthetic */ void a(Executor r2, int r3) {
            if (this.mExecutor == r2) goto L5;
            return;
        L5:
            this.mCallback.onFirstFix(r3);
        }

        private /* synthetic */ void c(Executor r2, GnssStatus r3) {
            if (this.mExecutor == r2) goto L5;
            return;
        L5:
            this.mCallback.onSatelliteStatusChanged(GnssStatusCompat.wrap(r3));
        }

        private /* synthetic */ void e(Executor r2) {
            if (this.mExecutor == r2) goto L5;
            return;
        L5:
            this.mCallback.onStarted();
        }

        private /* synthetic */ void g(Executor r2) {
            if (this.mExecutor == r2) goto L5;
            return;
        L5:
            this.mCallback.onStopped();
        }

        public /* synthetic */ void b(Executor r1, int r2) {
            a(r1, r2);
        }

        public /* synthetic */ void d(Executor r1, GnssStatus r2) {
            c(r1, r2);
        }

        public /* synthetic */ void f(Executor r1) {
            e(r1);
        }

        public /* synthetic */ void h(Executor r1) {
            g(r1);
        }

        @Override // android.location.GnssStatus.Callback
        public void onFirstFix(final int r3) {
            final Executor r0 = this.mExecutor;
            if (r0 != null) goto L5;
            return;
        L5:
            r0.execute(new q(this, r0, r3));
        }

        @Override // android.location.GnssStatus.Callback
        public void onSatelliteStatusChanged(final GnssStatus r3) {
            final Executor r0 = this.mExecutor;
            if (r0 != null) goto L5;
            return;
        L5:
            r0.execute(new p(this, r0, r3));
        }

        @Override // android.location.GnssStatus.Callback
        public void onStarted() {
            final Executor r0 = this.mExecutor;
            if (r0 != null) goto L5;
            return;
        L5:
            r0.execute(new r(this, r0));
        }

        @Override // android.location.GnssStatus.Callback
        public void onStopped() {
            final Executor r0 = this.mExecutor;
            if (r0 != null) goto L5;
            return;
        L5:
            r0.execute(new o(this, r0));
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
    }

    static {
        sLocationListeners = new WeakHashMap();
    }

    private LocationManagerCompat() {
    }

    static /* synthetic */ void a(Consumer r0, Location r1) {
        r0.accept(r1);
    }

    static /* synthetic */ Boolean b(LocationManager r0, GpsStatusTransport r1) {
        return Boolean.valueOf(r0.addGpsStatusListener(r1));
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public static void getCurrentLocation(@NonNull LocationManager r8, @NonNull String r9, @Nullable CancellationSignal r10, @NonNull Executor r11, @NonNull final Consumer<Location> r12) {
        if (Build.VERSION.SDK_INT < 30) goto L6;
        Api30Impl.getCurrentLocation(r8, r9, r10, r11, r12);
        return;
    L6:
        if (r10 == null) goto L8;
        r10.throwIfCanceled();
    L8:
        final Location r0 = r8.getLastKnownLocation(r9);
        if (r0 != null) goto L11;
    L14:
        final CancellableLocationListener r1 = new CancellableLocationListener(r8, r11, r12);
        r8.requestLocationUpdates(r9, 0, 0.0f, r1, Looper.getMainLooper());
        if (r10 == null) goto L17;
        r10.setOnCancelListener(new t(r1));
    L17:
        r1.startTimeout(GET_CURRENT_LOCATION_TIMEOUT_MS);
        return;
    L11:
        if ((SystemClock.elapsedRealtime() - LocationCompat.getElapsedRealtimeMillis(r0)) >= 10000) goto L14;
        r11.execute(new a(r12, r0));
    }

    @Nullable
    public static String getGnssHardwareModelName(@NonNull LocationManager r2) {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        return null;
    L5:
        return Api28Impl.getGnssHardwareModelName(r2);
    }

    public static int getGnssYearOfHardware(@NonNull LocationManager r2) {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        return 0;
    L5:
        return Api28Impl.getGnssYearOfHardware(r2);
    }

    public static boolean hasProvider(@NonNull LocationManager r2, @NonNull String r3) {
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

    public static boolean isLocationEnabled(@NonNull LocationManager r6) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 28) goto L7;
        return Api28Impl.isLocationEnabled(r6);
    L7:
        if (r0 > 19) goto L22;
        if (sContextField != null) goto L11;
        Field r4 = LocationManager.class.getDeclaredField("mContext");     // Catch: Throwable -> L27
        sContextField = r4;     // Catch: Throwable -> L27
        r4.setAccessible(true);     // Catch: Throwable -> L27
    L11:
        Context r5 = (Context) sContextField.get(r6);     // Catch: Throwable -> L27
        if (r5 == null) goto L22;
        if (r0 != 19) goto L20;
        if (Settings.Secure.getInt(r5.getContentResolver(), LocationMonitorConst.LOCATION_MODE, 0) != 0) goto L17;
        return false;
    L17:
        return true;
    L20:
        return !TextUtils.isEmpty(Settings.Secure.getString(r5.getContentResolver(), "location_providers_allowed"));
    L22:
        if (r6.isProviderEnabled("network") == true) goto L26;
        if (r6.isProviderEnabled("gps") == true) goto L26;
        return false;
    L26:
        return true;
    }

    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    @RequiresApi(24)
    public static boolean registerGnssMeasurementsCallback(@NonNull LocationManager r2, @NonNull GnssMeasurementsEvent.Callback r3, @NonNull Handler r4) {
        if (Build.VERSION.SDK_INT == 30) goto L7;
        return Api24Impl.registerGnssMeasurementsCallback(r2, r3, r4);
    L7:
        return registerGnssMeasurementsCallbackOnR(r2, ExecutorCompat.create(r4), r3);
    }

    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    @RequiresApi(30)
    public static boolean registerGnssMeasurementsCallback(@NonNull LocationManager r2, @NonNull Executor r3, @NonNull GnssMeasurementsEvent.Callback r4) {
        if (Build.VERSION.SDK_INT <= 30) goto L7;
        return Api31Impl.registerGnssMeasurementsCallback(r2, r3, r4);
    L7:
        return registerGnssMeasurementsCallbackOnR(r2, r3, r4);
    }

    @RequiresApi(30)
    private static boolean registerGnssMeasurementsCallbackOnR(@NonNull LocationManager r8, @NonNull Executor r9, @NonNull GnssMeasurementsEvent.Callback r10) {
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

    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    private static boolean registerGnssStatusCallback(final LocationManager r9, Handler r10, Executor r11, GnssStatusCompat.Callback r12) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 30) goto L7;
        return Api30Impl.registerGnssStatusCallback(r9, r10, r11, r12);
    L7:
        if (r0 >= 24) goto L9;
        boolean r1 = true;
        if (r10 == null) goto L13;
        boolean r2 = true;
    L14:
        Preconditions.checkArgument(r2);
        SimpleArrayMap<Object, Object> r3 = GnssListenersHolder.sGnssStatusListeners;
        monitor-enter(r3);
        final GpsStatusTransport r4 = (GpsStatusTransport) r3.get(r12);     // Catch: Throwable -> L74
        if (r4 != null) goto L19;
        r4 = new GpsStatusTransport(r9, r12);     // Catch: Throwable -> L74
    L20:
        r4.register(r11);     // Catch: Throwable -> L74
        FutureTask r13 = new FutureTask(new h(r9, r4));     // Catch: Throwable -> L74
        if (Looper.myLooper() != r10.getLooper()) goto L24;
        r13.run();     // Catch: Throwable -> L74
    L77:
        long r5 = TimeUnit.SECONDS.toNanos(PRE_N_LOOPER_TIMEOUT_S);     // Catch: Throwable -> L50 TimeoutException -> L52 ExecutionException -> L56
        long r6 = System.nanoTime() + r5;
        boolean r14 = false;
    L80:
    L44:
        r5 = r6 - System.nanoTime();
        r14 = true;
        goto L80
    L42:
        e = e;
    L59:
        if ((e.getCause() instanceof RuntimeException) == true) goto L67;
        if ((e.getCause() instanceof Error) == false) goto L65;
        throw ((Error) e.getCause());     // Catch: Throwable -> L68
    L65:
        throw new IllegalStateException(e);     // Catch: Throwable -> L68
    L67:
        throw ((RuntimeException) e.getCause());     // Catch: Throwable -> L68
    L40:
        e = e;
    L55:
        throw new IllegalStateException(r10 + " appears to be blocked, please run registerGnssStatusCallback() directly on a Looper thread or ensure the main Looper is not blocked by this thread", e);     // Catch: Throwable -> L68
    L38:
        th = th;
        r1 = r14;
    L69:
        if (r1 == false) goto L71;
        Thread.currentThread().interrupt();     // Catch: Throwable -> L74
    L71:
        throw th;     // Catch: Throwable -> L74
    L48:
        e = e;
    L46:
        e = e;
        goto L55
    L28:
        if (((Boolean) r13.get(r5, TimeUnit.NANOSECONDS)).booleanValue() == false) goto L34;
        GnssListenersHolder.sGnssStatusListeners.put(r12, r4);     // Catch: Throwable -> L38 TimeoutException -> L40 ExecutionException -> L42 InterruptedException -> L44
    L30:
        if (r14 == false) goto L32;
        Thread.currentThread().interrupt();     // Catch: Throwable -> L74
    L32:
        monitor-exit(r3);     // Catch: Throwable -> L74
        return true;
    L34:
        if (r14 == false) goto L36;
        Thread.currentThread().interrupt();     // Catch: Throwable -> L74
    L36:
        monitor-exit(r3);     // Catch: Throwable -> L74
        return false;
    L68:
        th = th;
    L56:
        e = e;
    L52:
        e = e;
    L50:
        th = th;
        r1 = false;
        goto L69
    L24:
        if (r10.post(r13) == true) goto L77;
        throw new IllegalStateException(r10 + " is shutting down");     // Catch: Throwable -> L74
    L19:
        r4.unregister();     // Catch: Throwable -> L74
    L74:
        th = move-exception;
        throw th;
    L13:
        r2 = false;
        goto L14
    L9:
        return Api24Impl.registerGnssStatusCallback(r9, r10, r11, r12);
    }

    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    public static boolean registerGnssStatusCallback(@NonNull LocationManager r2, @NonNull GnssStatusCompat.Callback r3, @NonNull Handler r4) {
        if (Build.VERSION.SDK_INT < 30) goto L7;
        return registerGnssStatusCallback(r2, ExecutorCompat.create(r4), r3);
    L7:
        return registerGnssStatusCallback(r2, new InlineHandlerExecutor(r4), r3);
    }

    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    public static boolean registerGnssStatusCallback(@NonNull LocationManager r2, @NonNull Executor r3, @NonNull GnssStatusCompat.Callback r4) {
        if (Build.VERSION.SDK_INT >= 30) goto L5;
        Looper r0 = Looper.myLooper();
        if (r0 != null) goto L10;
        r0 = Looper.getMainLooper();
    L10:
        return registerGnssStatusCallback(r2, new Handler(r0), r3, r4);
    L5:
        return registerGnssStatusCallback(r2, null, r3, r4);
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    @GuardedBy("sLocationListeners")
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

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public static void removeUpdates(@NonNull LocationManager r6, @NonNull LocationListenerCompat r7) {
        WeakHashMap<LocationListenerKey, WeakReference<LocationListenerTransport>> r0 = sLocationListeners;
        monitor-enter(r0);
        ArrayList r1 = null;
        Iterator<WeakReference<LocationListenerTransport>> r2 = r0.values().iterator();     // Catch: Throwable -> L24
    L7:
        if (r2.hasNext() == false) goto L16;
        LocationListenerTransport r3 = r2.next().get();     // Catch: Throwable -> L24
        if (r3 == null) goto L7;
        LocationListenerKey r4 = r3.getKey();     // Catch: Throwable -> L24
        if (r4.mListener != r7) goto L7;
        if (r1 != null) goto L15;
        r1 = new ArrayList();     // Catch: Throwable -> L24
    L15:
        r1.add(r4);     // Catch: Throwable -> L24
        r3.unregister();     // Catch: Throwable -> L24
        r6.removeUpdates(r3);     // Catch: Throwable -> L24
        goto L7
    L16:
        if (r1 == null) goto L21;
        Iterator r5 = r1.iterator();     // Catch: Throwable -> L24
    L19:
        if (r5.hasNext() == false) goto L21;
        LocationListenerKey r8 = (LocationListenerKey) r5.next();     // Catch: Throwable -> L24
        sLocationListeners.remove(r8);     // Catch: Throwable -> L24
    L21:
        monitor-exit(r0);     // Catch: Throwable -> L24
        r6.removeUpdates(r7);
        return;
    L24:
        th = move-exception;
        throw th;
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public static void requestLocationUpdates(@NonNull LocationManager r8, @NonNull String r9, @NonNull LocationRequestCompat r10, @NonNull LocationListenerCompat r11, @NonNull Looper r12) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 31) goto L7;
        Api31Impl.requestLocationUpdates(r8, r9, r10.toLocationRequest(), ExecutorCompat.create(new Handler(r12)), r11);
        return;
    L7:
        if (r0 >= 19) goto L9;
    L11:
        r8.requestLocationUpdates(r9, r10.getIntervalMillis(), r10.getMinUpdateDistanceMeters(), r11, r12);
        return;
    L9:
        if (Api19Impl.tryRequestLocationUpdates(r8, r9, r10, r11, r12) == false) goto L11;
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public static void requestLocationUpdates(@NonNull LocationManager r9, @NonNull String r10, @NonNull LocationRequestCompat r11, @NonNull Executor r12, @NonNull LocationListenerCompat r13) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 31) goto L7;
        Api31Impl.requestLocationUpdates(r9, r10, r11.toLocationRequest(), r12, r13);
        return;
    L7:
        if (r0 >= 30) goto L9;
    L11:
        LocationListenerTransport r1 = new LocationListenerTransport(new LocationListenerKey(r10, r13), r12);
        if (r0 >= 19) goto L14;
    L16:
        WeakHashMap<LocationListenerKey, WeakReference<LocationListenerTransport>> r14 = sLocationListeners;
        monitor-enter(r14);
        r9.requestLocationUpdates(r10, r11.getIntervalMillis(), r11.getMinUpdateDistanceMeters(), r1, Looper.getMainLooper());     // Catch: Throwable -> L21
        registerLocationListenerTransport(r9, r1);     // Catch: Throwable -> L21
        monitor-exit(r14);     // Catch: Throwable -> L21
        return;
    L21:
        th = move-exception;
        throw th;
    L14:
        if (Api19Impl.tryRequestLocationUpdates(r9, r10, r11, r1) == false) goto L16;
        return;
    L9:
        if (Api30Impl.tryRequestLocationUpdates(r9, r10, r11, r12, r13) == false) goto L11;
    }

    @RequiresApi(24)
    public static void unregisterGnssMeasurementsCallback(@NonNull LocationManager r0, @NonNull GnssMeasurementsEvent.Callback r1) {
        Api24Impl.unregisterGnssMeasurementsCallback(r0, r1);
    }

    public static void unregisterGnssStatusCallback(@NonNull LocationManager r2, @NonNull GnssStatusCompat.Callback r3) {
        if (Build.VERSION.SDK_INT < 24) goto L14;
        SimpleArrayMap<Object, Object> r0 = GnssListenersHolder.sGnssStatusListeners;
        monitor-enter(r0);
        Object r4 = r0.remove(r3);     // Catch: Throwable -> L11
        if (r4 == null) goto L9;
        Api24Impl.unregisterGnssStatusCallback(r2, r4);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    L14:
        SimpleArrayMap<Object, Object> r1 = GnssListenersHolder.sGnssStatusListeners;
        monitor-enter(r1);
        GpsStatusTransport r5 = (GpsStatusTransport) r1.remove(r3);     // Catch: Throwable -> L21
        if (r5 == null) goto L19;
        r5.unregister();     // Catch: Throwable -> L21
        r2.removeGpsStatusListener(r5);     // Catch: Throwable -> L21
    L19:
        monitor-exit(r1);     // Catch: Throwable -> L21
        return;
    L21:
        th = move-exception;
        throw th;
    }
}
