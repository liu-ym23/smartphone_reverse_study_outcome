package androidx.media;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public abstract class VolumeProviderCompat {
    public static final int VOLUME_CONTROL_ABSOLUTE = 2;
    public static final int VOLUME_CONTROL_FIXED = 0;
    public static final int VOLUME_CONTROL_RELATIVE = 1;
    private Callback mCallback;
    private final int mControlType;
    private int mCurrentVolume;
    private final int mMaxVolume;
    private Object mVolumeProviderObj;

    public static abstract class Callback {
        public abstract void onVolumeChanged(VolumeProviderCompat r1);

        public Callback() {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ControlType {
    }

    public void onAdjustVolume(int r1) {
    }

    public void onSetVolumeTo(int r1) {
    }

    public VolumeProviderCompat(int r1, int r2, int r3) {
        this.mControlType = r1;
        this.mMaxVolume = r2;
        this.mCurrentVolume = r3;
    }

    public final int getCurrentVolume() {
        return this.mCurrentVolume;
    }

    public final int getVolumeControl() {
        return this.mControlType;
    }

    public final int getMaxVolume() {
        return this.mMaxVolume;
    }

    public final void setCurrentVolume(int r2) {
        this.mCurrentVolume = r2;
        Object r0 = getVolumeProvider();
        if (r0 == null) goto L5;
        VolumeProviderCompatApi21.setCurrentVolume(r0, r2);
    L5:
        Callback r3 = this.mCallback;
        if (r3 == null) goto L9;
        r3.onVolumeChanged(this);
        return;
    }

    public void setCallback(Callback r1) {
        this.mCallback = r1;
    }

    public Object getVolumeProvider() {
        if (this.mVolumeProviderObj != null) goto L6;
        this.mVolumeProviderObj = VolumeProviderCompatApi21.createVolumeProvider(this.mControlType, this.mMaxVolume, this.mCurrentVolume, new AnonymousClass1(this));
    L6:
        return this.mVolumeProviderObj;
    }
}
