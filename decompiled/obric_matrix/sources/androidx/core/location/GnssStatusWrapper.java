package androidx.core.location;

import android.location.GnssStatus;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(24)
@RestrictTo({RestrictTo.Scope.LIBRARY})
class GnssStatusWrapper extends GnssStatusCompat {
    private final GnssStatus mWrapped;

    @RequiresApi(26)
    static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        static float getCarrierFrequencyHz(GnssStatus r0, int r1) {
            return r0.getCarrierFrequencyHz(r1);
        }

        @DoNotInline
        static boolean hasCarrierFrequencyHz(GnssStatus r0, int r1) {
            return r0.hasCarrierFrequencyHz(r1);
        }
    }

    @RequiresApi(30)
    static class Api30Impl {
        private Api30Impl() {
        }

        @DoNotInline
        static float getBasebandCn0DbHz(GnssStatus r0, int r1) {
            return r0.getBasebandCn0DbHz(r1);
        }

        @DoNotInline
        static boolean hasBasebandCn0DbHz(GnssStatus r0, int r1) {
            return r0.hasBasebandCn0DbHz(r1);
        }
    }

    GnssStatusWrapper(Object r1) {
        this.mWrapped = (GnssStatus) Preconditions.checkNotNull((GnssStatus) r1);
    }

    public boolean equals(Object r2) {
        if (this != r2) goto L6;
        return true;
    L6:
        if ((r2 instanceof GnssStatusWrapper) == true) goto L10;
        return false;
    L10:
        return this.mWrapped.equals(((GnssStatusWrapper) r2).mWrapped);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getAzimuthDegrees(int r1) {
        return this.mWrapped.getAzimuthDegrees(r1);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getBasebandCn0DbHz(int r3) {
        if (Build.VERSION.SDK_INT < 30) goto L7;
        return Api30Impl.getBasebandCn0DbHz(this.mWrapped, r3);
    L7:
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getCarrierFrequencyHz(int r3) {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return Api26Impl.getCarrierFrequencyHz(this.mWrapped, r3);
    L7:
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getCn0DbHz(int r1) {
        return this.mWrapped.getCn0DbHz(r1);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public int getConstellationType(int r1) {
        return this.mWrapped.getConstellationType(r1);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getElevationDegrees(int r1) {
        return this.mWrapped.getElevationDegrees(r1);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public int getSatelliteCount() {
        return this.mWrapped.getSatelliteCount();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public int getSvid(int r1) {
        return this.mWrapped.getSvid(r1);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasAlmanacData(int r1) {
        return this.mWrapped.hasAlmanacData(r1);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasBasebandCn0DbHz(int r3) {
        if (Build.VERSION.SDK_INT >= 30) goto L5;
        return false;
    L5:
        return Api30Impl.hasBasebandCn0DbHz(this.mWrapped, r3);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasCarrierFrequencyHz(int r3) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return false;
    L5:
        return Api26Impl.hasCarrierFrequencyHz(this.mWrapped, r3);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasEphemerisData(int r1) {
        return this.mWrapped.hasEphemerisData(r1);
    }

    public int hashCode() {
        return this.mWrapped.hashCode();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean usedInFix(int r1) {
        return this.mWrapped.usedInFix(r1);
    }
}
