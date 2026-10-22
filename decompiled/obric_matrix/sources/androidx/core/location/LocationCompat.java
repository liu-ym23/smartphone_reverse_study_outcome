package androidx.core.location;

import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.annotation.DoNotInline;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class LocationCompat {
    public static final String EXTRA_BEARING_ACCURACY = "bearingAccuracy";
    public static final String EXTRA_IS_MOCK = "mockLocation";
    public static final String EXTRA_MSL_ALTITUDE = "androidx.core.location.extra.MSL_ALTITUDE";
    public static final String EXTRA_MSL_ALTITUDE_ACCURACY = "androidx.core.location.extra.MSL_ALTITUDE_ACCURACY";
    public static final String EXTRA_SPEED_ACCURACY = "speedAccuracy";
    public static final String EXTRA_VERTICAL_ACCURACY = "verticalAccuracy";

    @Nullable
    private static Method sSetIsFromMockProviderMethod;

    @RequiresApi(17)
    private static class Api17Impl {
        private Api17Impl() {
        }

        @DoNotInline
        static long getElapsedRealtimeNanos(Location r2) {
            return r2.getElapsedRealtimeNanos();
        }
    }

    @RequiresApi(18)
    private static class Api18Impl {
        private Api18Impl() {
        }

        @DoNotInline
        static boolean isMock(Location r0) {
            return r0.isFromMockProvider();
        }
    }

    @RequiresApi(26)
    private static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        static float getBearingAccuracyDegrees(Location r0) {
            return r0.getBearingAccuracyDegrees();
        }

        @DoNotInline
        static float getSpeedAccuracyMetersPerSecond(Location r0) {
            return r0.getSpeedAccuracyMetersPerSecond();
        }

        @DoNotInline
        static float getVerticalAccuracyMeters(Location r0) {
            return r0.getVerticalAccuracyMeters();
        }

        @DoNotInline
        static boolean hasBearingAccuracy(Location r0) {
            return r0.hasBearingAccuracy();
        }

        @DoNotInline
        static boolean hasSpeedAccuracy(Location r0) {
            return r0.hasSpeedAccuracy();
        }

        @DoNotInline
        static boolean hasVerticalAccuracy(Location r0) {
            return r0.hasVerticalAccuracy();
        }

        @DoNotInline
        static void setBearingAccuracyDegrees(Location r0, float r1) {
            r0.setBearingAccuracyDegrees(r1);
        }

        @DoNotInline
        static void setSpeedAccuracyMetersPerSecond(Location r0, float r1) {
            r0.setSpeedAccuracyMetersPerSecond(r1);
        }

        @DoNotInline
        static void setVerticalAccuracyMeters(Location r0, float r1) {
            r0.setVerticalAccuracyMeters(r1);
        }
    }

    private LocationCompat() {
    }

    private static boolean containsExtra(@NonNull Location r0, String r1) {
        Bundle r2 = r0.getExtras();
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.containsKey(r1) == false) goto L7;
        return true;
    }

    public static float getBearingAccuracyDegrees(@NonNull Location r2) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        Bundle r3 = r2.getExtras();
        if (r3 != null) goto L10;
        return 0.0f;
    L10:
        return r3.getFloat(EXTRA_BEARING_ACCURACY, 0.0f);
    L5:
        return Api26Impl.getBearingAccuracyDegrees(r2);
    }

    public static long getElapsedRealtimeMillis(@NonNull Location r6) {
        if (Build.VERSION.SDK_INT >= 17) goto L5;
        long r0 = System.currentTimeMillis() - r6.getTime();
        long r2 = SystemClock.elapsedRealtime();
        if (r0 >= 0) goto L10;
        return r2;
    L10:
        if (r0 <= r2) goto L13;
        return 0;
    L13:
        return r2 - r0;
    L5:
        return TimeUnit.NANOSECONDS.toMillis(Api17Impl.getElapsedRealtimeNanos(r6));
    }

    public static long getElapsedRealtimeNanos(@NonNull Location r3) {
        if (Build.VERSION.SDK_INT < 17) goto L7;
        return Api17Impl.getElapsedRealtimeNanos(r3);
    L7:
        return TimeUnit.MILLISECONDS.toNanos(getElapsedRealtimeMillis(r3));
    }

    @FloatRange(from = 0.0d)
    public static float getMslAltitudeAccuracyMeters(@NonNull Location r2) {
        Preconditions.checkState(hasMslAltitudeAccuracy(r2), "The Mean Sea Level altitude accuracy of the location is not set.");
        return getOrCreateExtras(r2).getFloat(EXTRA_MSL_ALTITUDE_ACCURACY);
    }

    public static double getMslAltitudeMeters(@NonNull Location r2) {
        Preconditions.checkState(hasMslAltitude(r2), "The Mean Sea Level altitude of the location is not set.");
        return getOrCreateExtras(r2).getDouble(EXTRA_MSL_ALTITUDE);
    }

    private static Bundle getOrCreateExtras(@NonNull Location r1) {
        Bundle r0 = r1.getExtras();
        if (r0 != null) goto L6;
        r1.setExtras(new Bundle());
        return r1.getExtras();
    L6:
        return r0;
    }

    private static Method getSetIsFromMockProviderMethod() {
        if (sSetIsFromMockProviderMethod != null) goto L6;
        Method r0 = Location.class.getDeclaredMethod("setIsFromMockProvider", new Class[]{Boolean.TYPE});
        sSetIsFromMockProviderMethod = r0;
        r0.setAccessible(true);
    L6:
        return sSetIsFromMockProviderMethod;
    }

    public static float getSpeedAccuracyMetersPerSecond(@NonNull Location r2) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        Bundle r3 = r2.getExtras();
        if (r3 != null) goto L10;
        return 0.0f;
    L10:
        return r3.getFloat(EXTRA_SPEED_ACCURACY, 0.0f);
    L5:
        return Api26Impl.getSpeedAccuracyMetersPerSecond(r2);
    }

    public static float getVerticalAccuracyMeters(@NonNull Location r2) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        Bundle r3 = r2.getExtras();
        if (r3 != null) goto L10;
        return 0.0f;
    L10:
        return r3.getFloat(EXTRA_VERTICAL_ACCURACY, 0.0f);
    L5:
        return Api26Impl.getVerticalAccuracyMeters(r2);
    }

    public static boolean hasBearingAccuracy(@NonNull Location r2) {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return Api26Impl.hasBearingAccuracy(r2);
    L7:
        return containsExtra(r2, EXTRA_BEARING_ACCURACY);
    }

    public static boolean hasMslAltitude(@NonNull Location r1) {
        return containsExtra(r1, EXTRA_MSL_ALTITUDE);
    }

    public static boolean hasMslAltitudeAccuracy(@NonNull Location r1) {
        return containsExtra(r1, EXTRA_MSL_ALTITUDE_ACCURACY);
    }

    public static boolean hasSpeedAccuracy(@NonNull Location r2) {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return Api26Impl.hasSpeedAccuracy(r2);
    L7:
        return containsExtra(r2, EXTRA_SPEED_ACCURACY);
    }

    public static boolean hasVerticalAccuracy(@NonNull Location r2) {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return Api26Impl.hasVerticalAccuracy(r2);
    L7:
        return containsExtra(r2, EXTRA_VERTICAL_ACCURACY);
    }

    public static boolean isMock(@NonNull Location r2) {
        if (Build.VERSION.SDK_INT >= 18) goto L5;
        Bundle r3 = r2.getExtras();
        if (r3 != null) goto L10;
        return false;
    L10:
        return r3.getBoolean(EXTRA_IS_MOCK, false);
    L5:
        return Api18Impl.isMock(r2);
    }

    private static void removeExtra(@NonNull Location r1, String r2) {
        Bundle r0 = r1.getExtras();
        if (r0 == null) goto L8;
        r0.remove(r2);
        if (r0.isEmpty() == false) goto L9;
        r1.setExtras(null);
        return;
    L9:
        return;
    }

    public static void removeMslAltitude(@NonNull Location r1) {
        removeExtra(r1, EXTRA_MSL_ALTITUDE);
    }

    public static void removeMslAltitudeAccuracy(@NonNull Location r1) {
        removeExtra(r1, EXTRA_MSL_ALTITUDE_ACCURACY);
    }

    public static void setBearingAccuracyDegrees(@NonNull Location r2, float r3) {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        Api26Impl.setBearingAccuracyDegrees(r2, r3);
        return;
    L5:
        getOrCreateExtras(r2).putFloat(EXTRA_BEARING_ACCURACY, r3);
    }

    public static void setMock(@NonNull Location r3, boolean r4) {
        if (Build.VERSION.SDK_INT >= 18) goto L26;
        Bundle r0 = r3.getExtras();
        if (r0 != null) goto L20;
        if (r4 == false) goto L25;
        Bundle r5 = new Bundle();
        r5.putBoolean(EXTRA_IS_MOCK, true);
    L19:
        r3.setExtras(r5);
        return;
    L25:
        return;
    L20:
        if (r4 == false) goto L22;
        r0.putBoolean(EXTRA_IS_MOCK, true);
        return;
    L22:
        r0.remove(EXTRA_IS_MOCK);
        if (r0.isEmpty() == false) goto L30;
        r5 = null;
        goto L19
    L30:
        return;
    L26:
        getSetIsFromMockProviderMethod().invoke(r3, new Object[]{Boolean.valueOf(r4)});     // Catch: InvocationTargetException -> L6 IllegalAccessException -> L9 NoSuchMethodException -> L12
    L31:
        return;
    L9:
        e = move-exception;
        IllegalAccessError r6 = new IllegalAccessError();
        r6.initCause(e);
        throw r6;
    L12:
        e = move-exception;
        NoSuchMethodError r7 = new NoSuchMethodError();
        r7.initCause(e);
        throw r7;
    L6:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static void setMslAltitudeAccuracyMeters(@NonNull Location r1, @FloatRange(from = 0.0d) float r2) {
        getOrCreateExtras(r1).putFloat(EXTRA_MSL_ALTITUDE_ACCURACY, r2);
    }

    public static void setMslAltitudeMeters(@NonNull Location r1, double r2) {
        getOrCreateExtras(r1).putDouble(EXTRA_MSL_ALTITUDE, r2);
    }

    public static void setSpeedAccuracyMetersPerSecond(@NonNull Location r2, float r3) {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        Api26Impl.setSpeedAccuracyMetersPerSecond(r2, r3);
        return;
    L5:
        getOrCreateExtras(r2).putFloat(EXTRA_SPEED_ACCURACY, r3);
    }

    public static void setVerticalAccuracyMeters(@NonNull Location r2, float r3) {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        Api26Impl.setVerticalAccuracyMeters(r2, r3);
        return;
    L5:
        getOrCreateExtras(r2).putFloat(EXTRA_VERTICAL_ACCURACY, r3);
    }
}
