package androidx.media;

import android.annotation.TargetApi;
import android.media.AudioAttributes;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(21)
class AudioAttributesImplApi21 implements AudioAttributesImpl {
    private static final String TAG = "AudioAttributesCompat21";
    static Method sAudioAttributesToLegacyStreamType;
    AudioAttributes mAudioAttributes;
    int mLegacyStreamType;

    public AudioAttributesImplApi21() {
        this.mLegacyStreamType = -1;
    }

    public static AudioAttributesImpl fromBundle(Bundle r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        AudioAttributes r1 = (AudioAttributes) r3.getParcelable("androidx.media.audio_attrs.FRAMEWORKS");
        if (r1 != null) goto L9;
        return null;
    L9:
        return new AudioAttributesImplApi21(r1, r3.getInt("androidx.media.audio_attrs.LEGACY_STREAM_TYPE", -1));
    }

    public static Method getAudioAttributesToLegacyStreamTypeMethod() {
    L8:
        return null;
    L4:
        if (sAudioAttributesToLegacyStreamType != null) goto L7;
        sAudioAttributesToLegacyStreamType = AudioAttributes.class.getMethod("toLegacyStreamType", new Class[]{AudioAttributes.class});     // Catch: NoSuchMethodException -> L8
    L7:
        return sAudioAttributesToLegacyStreamType;
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof AudioAttributesImplApi21) == true) goto L7;
        return false;
    L7:
        return this.mAudioAttributes.equals(((AudioAttributesImplApi21) r2).mAudioAttributes);
    }

    @Override // androidx.media.AudioAttributesImpl
    public Object getAudioAttributes() {
        return this.mAudioAttributes;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getContentType() {
        return this.mAudioAttributes.getContentType();
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getFlags() {
        return this.mAudioAttributes.getFlags();
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getLegacyStreamType() {
        int r0 = this.mLegacyStreamType;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        Method r1 = getAudioAttributesToLegacyStreamTypeMethod();
        if (r1 != null) goto L14;
        Log.w(TAG, "No AudioAttributes#toLegacyStreamType() on API: " + Build.VERSION.SDK_INT);
        return -1;
    L14:
        return ((Integer) r1.invoke(null, new Object[]{this.mAudioAttributes})).intValue();
    L11:
        e = move-exception;
        Log.w(TAG, "getLegacyStreamType() failed on API: " + Build.VERSION.SDK_INT, e);
        return -1;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getRawLegacyStreamType() {
        return this.mLegacyStreamType;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getUsage() {
        return this.mAudioAttributes.getUsage();
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getVolumeControlStream() {
        return this.mAudioAttributes.getVolumeControlStream();
    }

    public int hashCode() {
        return this.mAudioAttributes.hashCode();
    }

    @Override // androidx.media.AudioAttributesImpl
    @NonNull
    public Bundle toBundle() {
        Bundle r0 = new Bundle();
        r0.putParcelable("androidx.media.audio_attrs.FRAMEWORKS", this.mAudioAttributes);
        int r3 = this.mLegacyStreamType;
        if (r3 == (-1)) goto L5;
        r0.putInt("androidx.media.audio_attrs.LEGACY_STREAM_TYPE", r3);
    L5:
        return r0;
    }

    public String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.mAudioAttributes;
    }

    public AudioAttributesImplApi21(AudioAttributes r2) {
        this(r2, -1);
    }

    public AudioAttributesImplApi21(AudioAttributes r1, int r2) {
        this.mAudioAttributes = r1;
        this.mLegacyStreamType = r2;
    }
}
