package androidx.core.location;

import android.location.LocationManager;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public final class LocationManagerCompat {
    private LocationManagerCompat() {
    }

    public static boolean isLocationEnabled(@NonNull LocationManager r0) {
        return r0.isLocationEnabled();
    }
}
