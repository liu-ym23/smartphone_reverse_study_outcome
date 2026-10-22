package androidx.media;

import android.media.VolumeProvider;

/* JADX INFO: loaded from: classes.dex */
class VolumeProviderCompatApi21 {

    public interface Delegate {
        void onAdjustVolume(int r1);

        void onSetVolumeTo(int r1);
    }

    public static Object createVolumeProvider(final int r1, final int r2, final int r3, final Delegate r4) {
        return new AnonymousClass1(r1, r2, r3, r4);
    }

    public static void setCurrentVolume(Object r0, int r1) {
        ((VolumeProvider) r0).setCurrentVolume(r1);
    }

    private VolumeProviderCompatApi21() {
    }
}
