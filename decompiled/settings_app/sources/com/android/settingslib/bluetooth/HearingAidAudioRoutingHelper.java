package com.android.settingslib.bluetooth;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioDeviceAttributes;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.media.audiopolicy.AudioProductStrategy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes.dex */
public class HearingAidAudioRoutingHelper {
    private final AudioManager mAudioManager;

    public HearingAidAudioRoutingHelper(Context r2) {
        this.mAudioManager = (AudioManager) r2.getSystemService(AudioManager.class);
    }

    public List<AudioProductStrategy> getSupportedStrategies(int[] r6) {
        ArrayList r0 = new ArrayList(r6.length);
        int r1 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        int r3 = r6[r2];
        r0.add(new AudioAttributes.Builder().setUsage(r3).build());
        r2 = r2 + 1;
        goto L3
    L5:
        List<AudioProductStrategy> r5 = getAudioProductStrategies();
        ArrayList r7 = new ArrayList();
        Iterator<AudioProductStrategy> r8 = r5.iterator();
    L7:
        if (r8.hasNext() == false) goto L15;
        AudioProductStrategy r4 = r8.next();
        Iterator r9 = r0.iterator();
    L10:
        if (r9.hasNext() == false) goto L7;
        if (r4.supportsAudioAttributes((AudioAttributes) r9.next()) == false) goto L10;
        r7.add(r4);
        goto L10
    L15:
        return (List) r7.stream().distinct().collect(Collectors.toList());
    }

    public boolean setPreferredDeviceRoutingStrategies(List<AudioProductStrategy> r2, AudioDeviceAttributes r3, int r4) {
        if (r4 == 0) goto L14;
        if (r4 == 1) goto L12;
        if (r4 != 2) goto L10;
        return setPreferredDeviceForStrategies(r2, HearingAidAudioRoutingConstants.DEVICE_SPEAKER_OUT) & removePreferredDeviceForStrategies(r2);
    L10:
        throw new IllegalArgumentException("Unexpected routingValue: " + r4);
    L12:
        return setPreferredDeviceForStrategies(r2, r3) & removePreferredDeviceForStrategies(r2);
    L14:
        return removePreferredDeviceForStrategies(r2);
    }

    public AudioDeviceAttributes getMatchedHearingDeviceAttributes(CachedBluetoothDevice r8) {
        if (r8 != null) goto L5;
    L18:
        return null;
    L5:
        if (r8.isHearingAidDevice() == false) goto L18;
        AudioDeviceInfo[] r1 = this.mAudioManager.getDevices(2);
        int r2 = r1.length;
        int r3 = 0;
    L8:
        if (r3 >= r2) goto L18;
        AudioDeviceInfo r4 = r1[r3];
        if (r4.getType() == 23) goto L14;
        if (r4.getType() == 26) goto L14;
    L17:
        r3 = r3 + 1;
    L14:
        if (matchAddress(r8, r4) == false) goto L17;
        return new AudioDeviceAttributes(r4);
    }

    private boolean matchAddress(CachedBluetoothDevice r2, AudioDeviceInfo r3) {
        final String r1 = r3.getAddress();
        CachedBluetoothDevice r4 = r2.getSubDevice();
        Set<CachedBluetoothDevice> r0 = r2.getMemberDevice();
        if (r2.getAddress().equals(r1) == true) goto L13;
        if (r4 == null) goto L8;
        if (r4.getAddress().equals(r1) == true) goto L13;
    L8:
        if (r0.isEmpty() == false) goto L10;
    L12:
        return false;
    L10:
        if (r0.stream().anyMatch(new HearingAidAudioRoutingHelper$$ExternalSyntheticLambda0(r1)) == false) goto L12;
    L13:
        return true;
    }

    static /* synthetic */ boolean lambda$matchAddress$0(String r0, CachedBluetoothDevice r1) {
        return r1.getAddress().equals(r0);
    }

    private boolean setPreferredDeviceForStrategies(List<AudioProductStrategy> r4, AudioDeviceAttributes r5) {
        Iterator<AudioProductStrategy> r6 = r4.iterator();
        boolean r0 = true;
    L4:
        if (r6.hasNext() == false) goto L6;
        AudioProductStrategy r1 = r6.next();
        r0 = r0 & this.mAudioManager.setPreferredDeviceForStrategy(r1, r5);
        goto L4
    L6:
        return r0;
    }

    private boolean removePreferredDeviceForStrategies(List<AudioProductStrategy> r4) {
        Iterator<AudioProductStrategy> r5 = r4.iterator();
        boolean r0 = true;
    L4:
        if (r5.hasNext() == false) goto L8;
        AudioProductStrategy r1 = r5.next();
        if (this.mAudioManager.getPreferredDeviceForStrategy(r1) == null) goto L4;
        r0 = r0 & this.mAudioManager.removePreferredDeviceForStrategy(r1);
        goto L4
    L8:
        return r0;
    }

    public List<AudioProductStrategy> getAudioProductStrategies() {
        return AudioManager.getAudioProductStrategies();
    }
}
