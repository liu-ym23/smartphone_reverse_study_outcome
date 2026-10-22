package androidx.core.location;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface LocationListenerCompat extends LocationListener {
    @Override // android.location.LocationListener
    default void onFlushComplete(int r1) {
    }

    @Override // android.location.LocationListener
    default void onLocationChanged(@NonNull List<Location> r4) {
        int r0 = r4.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        onLocationChanged(r4.get(r1));
        r1 = r1 + 1;
        goto L3
    }

    @Override // android.location.LocationListener
    default void onProviderDisabled(@NonNull String r1) {
    }

    @Override // android.location.LocationListener
    default void onProviderEnabled(@NonNull String r1) {
    }

    @Override // android.location.LocationListener
    default void onStatusChanged(@NonNull String r1, int r2, @Nullable Bundle r3) {
    }
}
