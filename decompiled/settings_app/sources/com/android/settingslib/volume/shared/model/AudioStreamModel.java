package com.android.settingslib.volume.shared.model;

import android.icu.text.PluralRules;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: AudioStreamModel.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B@\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\tø\u0001\u0000¢\u0006\u0002\u0010\fJ\u0019\u0010\u0014\u001a\u00020\u0003HÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u000eJ\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\\\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\tHÆ\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0010R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000e\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006$"}, d2 = {"Lcom/android/settingslib/volume/shared/model/AudioStreamModel;", "", "audioStream", "Lcom/android/settingslib/volume/shared/model/AudioStream;", "volume", "", "minVolume", "maxVolume", "isAffectedByMute", "", "isAffectedByRingerMode", "isMuted", "(IIIIZZZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAudioStream-2ffMKO0", "()I", "I", "()Z", "getMaxVolume", "getMinVolume", "getVolume", "component1", "component1-2ffMKO0", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "copy-gJrEJJU", "(IIIIZZZ)Lcom/android/settingslib/volume/shared/model/AudioStreamModel;", "equals", PluralRules.KEYWORD_OTHER, "hashCode", "toString", "", "app_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AudioStreamModel {
    private final int audioStream;
    private final boolean isAffectedByMute;
    private final boolean isAffectedByRingerMode;
    private final boolean isMuted;
    private final int maxVolume;
    private final int minVolume;
    private final int volume;

    public /* synthetic */ AudioStreamModel(int r1, int r2, int r3, int r4, boolean r5, boolean r6, boolean r7, DefaultConstructorMarker r8) {
        this(r1, r2, r3, r4, r5, r6, r7);
    }

    /* JADX INFO: renamed from: copy-gJrEJJU$default, reason: not valid java name */
    public static /* synthetic */ AudioStreamModel m825copygJrEJJU$default(AudioStreamModel r5, int r6, int r7, int r8, int r9, boolean r10, boolean r11, boolean r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.audioStream;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.volume;
    L8:
        int r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.minVolume;
    L11:
        int r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.maxVolume;
    L14:
        int r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.isAffectedByMute;
    L17:
        boolean r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.isAffectedByRingerMode;
    L20:
        boolean r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.isMuted;
    L23:
        int r16 = r6;
        return r5.m827copygJrEJJU(r16, r15, r0, r1, r2, r3, r12);
    }

    /* JADX INFO: renamed from: component1-2ffMKO0, reason: not valid java name */
    public final int m826component12ffMKO0() {
        return this.audioStream;
    }

    public final int component2() {
        return this.volume;
    }

    public final int component3() {
        return this.minVolume;
    }

    public final int component4() {
        return this.maxVolume;
    }

    public final boolean component5() {
        return this.isAffectedByMute;
    }

    public final boolean component6() {
        return this.isAffectedByRingerMode;
    }

    public final boolean component7() {
        return this.isMuted;
    }

    /* JADX INFO: renamed from: copy-gJrEJJU, reason: not valid java name */
    public final AudioStreamModel m827copygJrEJJU(int r11, int r12, int r13, int r14, boolean r15, boolean r16, boolean r17) {
        return new AudioStreamModel(r11, r12, r13, r14, r15, r16, r17, null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AudioStreamModel) == true) goto L8;
        return false;
    L8:
        AudioStreamModel r6 = (AudioStreamModel) r5;
        if (AudioStream.m821equalsimpl0(this.audioStream, r6.audioStream) == true) goto L12;
        return false;
    L12:
        if (this.volume == r6.volume) goto L15;
        return false;
    L15:
        if (this.minVolume == r6.minVolume) goto L18;
        return false;
    L18:
        if (this.maxVolume == r6.maxVolume) goto L21;
        return false;
    L21:
        if (this.isAffectedByMute == r6.isAffectedByMute) goto L24;
        return false;
    L24:
        if (this.isAffectedByRingerMode == r6.isAffectedByRingerMode) goto L27;
        return false;
    L27:
        if (this.isMuted == r6.isMuted) goto L29;
        return false;
    L29:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int r0 = ((((((AudioStream.m822hashCodeimpl(this.audioStream) * 31) + Integer.hashCode(this.volume)) * 31) + Integer.hashCode(this.minVolume)) * 31) + Integer.hashCode(this.maxVolume)) * 31;
        boolean r1 = this.isAffectedByMute;
        ?? r2 = 1;
        ?? r3 = r1;
        if (r1 == false) goto L5;
        r3 = 1;
    L5:
        int r4 = (r0 + r3) * 31;
        boolean r5 = this.isAffectedByRingerMode;
        ?? r6 = r5;
        if (r5 == false) goto L8;
        r6 = 1;
    L8:
        int r7 = (r4 + r6) * 31;
        boolean r8 = this.isMuted;
        if (r8 == true) goto L13;
        r2 = r8;
    L13:
        return r7 + r2;
    }

    public String toString() {
        return "AudioStreamModel(audioStream=" + AudioStream.m823toStringimpl(this.audioStream) + ", volume=" + this.volume + ", minVolume=" + this.minVolume + ", maxVolume=" + this.maxVolume + ", isAffectedByMute=" + this.isAffectedByMute + ", isAffectedByRingerMode=" + this.isAffectedByRingerMode + ", isMuted=" + this.isMuted + ')';
    }

    private AudioStreamModel(int r1, int r2, int r3, int r4, boolean r5, boolean r6, boolean r7) {
        this.audioStream = r1;
        this.volume = r2;
        this.minVolume = r3;
        this.maxVolume = r4;
        this.isAffectedByMute = r5;
        this.isAffectedByRingerMode = r6;
        this.isMuted = r7;
    }

    /* JADX INFO: renamed from: getAudioStream-2ffMKO0, reason: not valid java name */
    public final int m828getAudioStream2ffMKO0() {
        return this.audioStream;
    }

    public final int getVolume() {
        return this.volume;
    }

    public final int getMinVolume() {
        return this.minVolume;
    }

    public final int getMaxVolume() {
        return this.maxVolume;
    }

    public final boolean isAffectedByMute() {
        return this.isAffectedByMute;
    }

    public final boolean isAffectedByRingerMode() {
        return this.isAffectedByRingerMode;
    }

    public final boolean isMuted() {
        return this.isMuted;
    }
}
