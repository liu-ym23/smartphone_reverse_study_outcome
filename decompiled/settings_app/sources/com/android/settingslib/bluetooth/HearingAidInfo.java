package com.android.settingslib.bluetooth;

import android.util.SparseIntArray;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class HearingAidInfo {
    private static final SparseIntArray ASHA_DEVICE_MODE_TO_INTERNAL_MODE_MAPPING = null;
    private static final SparseIntArray ASHA_DEVICE_SIDE_TO_INTERNAL_SIDE_MAPPING = null;
    private static final SparseIntArray HAP_DEVICE_TYPE_TO_INTERNAL_MODE_MAPPING = null;
    private static final int LE_AUDIO_LOCATION_LEFT = 88413265;
    private static final int LE_AUDIO_LOCATION_RIGHT = 176826530;
    private final long mHiSyncId;
    private final int mMode;
    private final int mSide;

    /* JADX INFO: renamed from: com.android.settingslib.bluetooth.HearingAidInfo$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {
        private long mHiSyncId;
        private int mMode;
        private int mSide;

        public Builder() {
            this.mSide = -1;
            this.mMode = -1;
            this.mHiSyncId = 0;
        }

        public Builder setAshaDeviceMode(int r1) {
            this.mMode = HearingAidInfo.access$000(r1);
            return this;
        }

        public Builder setHapDeviceType(int r1) {
            this.mMode = HearingAidInfo.access$100(r1);
            return this;
        }

        public Builder setAshaDeviceSide(int r1) {
            this.mSide = HearingAidInfo.access$200(r1);
            return this;
        }

        public Builder setLeAudioLocation(int r1) {
            this.mSide = HearingAidInfo.access$300(r1);
            return this;
        }

        public Builder setHiSyncId(long r1) {
            this.mHiSyncId = r1;
            return this;
        }

        public HearingAidInfo build() {
            return new HearingAidInfo(this.mSide, this.mMode, this.mHiSyncId, null);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface DeviceMode {
        public static final int MODE_BANDED = 2;
        public static final int MODE_BINAURAL = 1;
        public static final int MODE_INVALID = -1;
        public static final int MODE_MONAURAL = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface DeviceSide {
        public static final int SIDE_INVALID = -1;
        public static final int SIDE_LEFT = 0;
        public static final int SIDE_LEFT_AND_RIGHT = 2;
        public static final int SIDE_RIGHT = 1;
    }

    private static int convertLeAudioLocationToInternalSide(int r4) {
        if ((LE_AUDIO_LOCATION_LEFT & r4) == 0) goto L5;
        boolean r0 = true;
    L7:
        if ((r4 & LE_AUDIO_LOCATION_RIGHT) == 0) goto L9;
        boolean r5 = true;
    L10:
        if (r0 == false) goto L14;
        if (r5 == false) goto L14;
        return 2;
    L14:
        if (r0 == false) goto L16;
        return 0;
    L16:
        if (r5 == false) goto L18;
        return 1;
    L18:
        return -1;
    L9:
        r5 = false;
        goto L10
    L5:
        r0 = false;
        goto L7
    }

    /* synthetic */ HearingAidInfo(int r1, int r2, long r3, AnonymousClass1 r5) {
        this(r1, r2, r3);
    }

    static /* synthetic */ int access$000(int r0) {
        return convertAshaDeviceModeToInternalMode(r0);
    }

    static /* synthetic */ int access$100(int r0) {
        return convertHapDeviceTypeToInternalMode(r0);
    }

    static /* synthetic */ int access$200(int r0) {
        return convertAshaDeviceSideToInternalSide(r0);
    }

    static /* synthetic */ int access$300(int r0) {
        return convertLeAudioLocationToInternalSide(r0);
    }

    private HearingAidInfo(int r1, int r2, long r3) {
        this.mSide = r1;
        this.mMode = r2;
        this.mHiSyncId = r3;
    }

    public int getSide() {
        return this.mSide;
    }

    public int getMode() {
        return this.mMode;
    }

    public long getHiSyncId() {
        return this.mHiSyncId;
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L6;
        return true;
    L6:
        if ((r6 instanceof HearingAidInfo) == true) goto L8;
        return false;
    L8:
        HearingAidInfo r7 = (HearingAidInfo) r6;
        if (this.mSide != r7.mSide) goto L16;
        if (this.mMode != r7.mMode) goto L16;
        if (this.mHiSyncId != r7.mHiSyncId) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.mSide), Integer.valueOf(this.mMode), Long.valueOf(this.mHiSyncId)});
    }

    public String toString() {
        return "HearingAidInfo{mSide=" + this.mSide + ", mMode=" + this.mMode + ", mHiSyncId=" + this.mHiSyncId + '}';
    }

    private static int convertAshaDeviceSideToInternalSide(int r2) {
        return ASHA_DEVICE_SIDE_TO_INTERNAL_SIDE_MAPPING.get(r2, -1);
    }

    private static int convertAshaDeviceModeToInternalMode(int r2) {
        return ASHA_DEVICE_MODE_TO_INTERNAL_MODE_MAPPING.get(r2, -1);
    }

    private static int convertHapDeviceTypeToInternalMode(int r2) {
        return HAP_DEVICE_TYPE_TO_INTERNAL_MODE_MAPPING.get(r2, -1);
    }

    static {
        SparseIntArray r0 = new SparseIntArray();
        ASHA_DEVICE_SIDE_TO_INTERNAL_SIDE_MAPPING = r0;
        r0.put(-1, -1);
        r0.put(0, 0);
        r0.put(1, 1);
        SparseIntArray r1 = new SparseIntArray();
        ASHA_DEVICE_MODE_TO_INTERNAL_MODE_MAPPING = r1;
        r1.put(-1, -1);
        r1.put(0, 0);
        r1.put(1, 1);
        SparseIntArray r2 = new SparseIntArray();
        HAP_DEVICE_TYPE_TO_INTERNAL_MODE_MAPPING = r2;
        r2.put(-1, -1);
        r2.put(0, 1);
        r2.put(1, 0);
        r2.put(2, 2);
        r2.put(3, -1);
    }
}
