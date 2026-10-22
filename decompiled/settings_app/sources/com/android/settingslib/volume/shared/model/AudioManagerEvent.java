package com.android.settingslib.volume.shared.model;

import android.icu.text.PluralRules;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: AudioManagerEvent.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0005\u0002\u0003\u0004\u0005\u0006\u0082\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lcom/android/settingslib/volume/shared/model/AudioManagerEvent;", "", "InternalRingerModeChanged", "StreamDevicesChanged", "StreamMasterMuteChanged", "StreamMuteChanged", "StreamVolumeChanged", "Lcom/android/settingslib/volume/shared/model/AudioManagerEvent$InternalRingerModeChanged;", "Lcom/android/settingslib/volume/shared/model/AudioManagerEvent$StreamDevicesChanged;", "Lcom/android/settingslib/volume/shared/model/AudioManagerEvent$StreamMasterMuteChanged;", "Lcom/android/settingslib/volume/shared/model/StreamAudioManagerEvent;", "app_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface AudioManagerEvent {

    /* JADX INFO: compiled from: AudioManagerEvent.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/android/settingslib/volume/shared/model/AudioManagerEvent$InternalRingerModeChanged;", "Lcom/android/settingslib/volume/shared/model/AudioManagerEvent;", "()V", "app_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class InternalRingerModeChanged implements AudioManagerEvent {
        public static final InternalRingerModeChanged INSTANCE = null;

        static {
            INSTANCE = new InternalRingerModeChanged();
        }

        private InternalRingerModeChanged() {
        }
    }

    /* JADX INFO: compiled from: AudioManagerEvent.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/android/settingslib/volume/shared/model/AudioManagerEvent$StreamDevicesChanged;", "Lcom/android/settingslib/volume/shared/model/AudioManagerEvent;", "()V", "app_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class StreamDevicesChanged implements AudioManagerEvent {
        public static final StreamDevicesChanged INSTANCE = null;

        static {
            INSTANCE = new StreamDevicesChanged();
        }

        private StreamDevicesChanged() {
        }
    }

    /* JADX INFO: compiled from: AudioManagerEvent.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/android/settingslib/volume/shared/model/AudioManagerEvent$StreamMasterMuteChanged;", "Lcom/android/settingslib/volume/shared/model/AudioManagerEvent;", "()V", "app_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class StreamMasterMuteChanged implements AudioManagerEvent {
        public static final StreamMasterMuteChanged INSTANCE = null;

        static {
            INSTANCE = new StreamMasterMuteChanged();
        }

        private StreamMasterMuteChanged() {
        }
    }

    /* JADX INFO: compiled from: AudioManagerEvent.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0004J\u0019\u0010\b\u001a\u00020\u0003HÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\t\u0010\u0006J \u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u001f\u0010\u0002\u001a\u00020\u0003X\u0096\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0015"}, d2 = {"Lcom/android/settingslib/volume/shared/model/AudioManagerEvent$StreamMuteChanged;", "Lcom/android/settingslib/volume/shared/model/StreamAudioManagerEvent;", "audioStream", "Lcom/android/settingslib/volume/shared/model/AudioStream;", "(ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAudioStream-2ffMKO0", "()I", "I", "component1", "component1-2ffMKO0", "copy", "copy-tLTdkI8", "(I)Lcom/android/settingslib/volume/shared/model/AudioManagerEvent$StreamMuteChanged;", "equals", "", PluralRules.KEYWORD_OTHER, "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class StreamMuteChanged implements StreamAudioManagerEvent {
        private final int audioStream;

        public /* synthetic */ StreamMuteChanged(int r1, DefaultConstructorMarker r2) {
            this(r1);
        }

        /* JADX INFO: renamed from: copy-tLTdkI8$default, reason: not valid java name */
        public static /* synthetic */ StreamMuteChanged m811copytLTdkI8$default(StreamMuteChanged r0, int r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.mo814getAudioStream2ffMKO0();
        L6:
            return r0.m813copytLTdkI8(r1);
        }

        /* JADX INFO: renamed from: component1-2ffMKO0, reason: not valid java name */
        public final int m812component12ffMKO0() {
            return mo814getAudioStream2ffMKO0();
        }

        /* JADX INFO: renamed from: copy-tLTdkI8, reason: not valid java name */
        public final StreamMuteChanged m813copytLTdkI8(int r2) {
            return new StreamMuteChanged(r2, null);
        }

        public boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof StreamMuteChanged) == true) goto L9;
            return false;
        L9:
            if (AudioStream.m821equalsimpl0(mo814getAudioStream2ffMKO0(), ((StreamMuteChanged) r4).mo814getAudioStream2ffMKO0()) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return AudioStream.m822hashCodeimpl(mo814getAudioStream2ffMKO0());
        }

        public String toString() {
            return "StreamMuteChanged(audioStream=" + AudioStream.m823toStringimpl(mo814getAudioStream2ffMKO0()) + ')';
        }

        private StreamMuteChanged(int r1) {
            this.audioStream = r1;
        }

        @Override // com.android.settingslib.volume.shared.model.StreamAudioManagerEvent
        /* JADX INFO: renamed from: getAudioStream-2ffMKO0, reason: not valid java name */
        public int mo814getAudioStream2ffMKO0() {
            return this.audioStream;
        }
    }

    /* JADX INFO: compiled from: AudioManagerEvent.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0004J\u0019\u0010\b\u001a\u00020\u0003HÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\t\u0010\u0006J \u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u001f\u0010\u0002\u001a\u00020\u0003X\u0096\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0015"}, d2 = {"Lcom/android/settingslib/volume/shared/model/AudioManagerEvent$StreamVolumeChanged;", "Lcom/android/settingslib/volume/shared/model/StreamAudioManagerEvent;", "audioStream", "Lcom/android/settingslib/volume/shared/model/AudioStream;", "(ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAudioStream-2ffMKO0", "()I", "I", "component1", "component1-2ffMKO0", "copy", "copy-tLTdkI8", "(I)Lcom/android/settingslib/volume/shared/model/AudioManagerEvent$StreamVolumeChanged;", "equals", "", PluralRules.KEYWORD_OTHER, "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class StreamVolumeChanged implements StreamAudioManagerEvent {
        private final int audioStream;

        public /* synthetic */ StreamVolumeChanged(int r1, DefaultConstructorMarker r2) {
            this(r1);
        }

        /* JADX INFO: renamed from: copy-tLTdkI8$default, reason: not valid java name */
        public static /* synthetic */ StreamVolumeChanged m815copytLTdkI8$default(StreamVolumeChanged r0, int r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.mo814getAudioStream2ffMKO0();
        L6:
            return r0.m817copytLTdkI8(r1);
        }

        /* JADX INFO: renamed from: component1-2ffMKO0, reason: not valid java name */
        public final int m816component12ffMKO0() {
            return mo814getAudioStream2ffMKO0();
        }

        /* JADX INFO: renamed from: copy-tLTdkI8, reason: not valid java name */
        public final StreamVolumeChanged m817copytLTdkI8(int r2) {
            return new StreamVolumeChanged(r2, null);
        }

        public boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof StreamVolumeChanged) == true) goto L9;
            return false;
        L9:
            if (AudioStream.m821equalsimpl0(mo814getAudioStream2ffMKO0(), ((StreamVolumeChanged) r4).mo814getAudioStream2ffMKO0()) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return AudioStream.m822hashCodeimpl(mo814getAudioStream2ffMKO0());
        }

        public String toString() {
            return "StreamVolumeChanged(audioStream=" + AudioStream.m823toStringimpl(mo814getAudioStream2ffMKO0()) + ')';
        }

        private StreamVolumeChanged(int r1) {
            this.audioStream = r1;
        }

        @Override // com.android.settingslib.volume.shared.model.StreamAudioManagerEvent
        /* JADX INFO: renamed from: getAudioStream-2ffMKO0 */
        public int mo814getAudioStream2ffMKO0() {
            return this.audioStream;
        }
    }
}
