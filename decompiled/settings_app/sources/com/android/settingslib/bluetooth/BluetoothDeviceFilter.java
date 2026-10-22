package com.android.settingslib.bluetooth;

import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothUuid;
import android.os.ParcelUuid;
import com.GlobalProxyLancet;
import com.android.internal.util.ArrayUtils;

/* JADX INFO: loaded from: classes.dex */
public final class BluetoothDeviceFilter {
    public static final Filter ALL_FILTER = null;
    public static final Filter BONDED_DEVICE_FILTER = null;
    private static final Filter[] FILTERS = null;
    private static final String TAG = "BluetoothDeviceFilter";
    public static final Filter UNBONDED_DEVICE_FILTER = null;

    /* JADX INFO: renamed from: com.android.settingslib.bluetooth.BluetoothDeviceFilter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class AllFilter implements Filter {
        @Override // com.android.settingslib.bluetooth.BluetoothDeviceFilter.Filter
        public boolean matches(BluetoothDevice r1) {
            return true;
        }

        private AllFilter() {
        }

        /* synthetic */ AllFilter(AnonymousClass1 r1) {
            this();
        }
    }

    private static final class AudioFilter extends ClassUuidFilter {
        private AudioFilter() {
            super(null);
        }

        /* synthetic */ AudioFilter(AnonymousClass1 r1) {
            this();
        }

        @Override // com.android.settingslib.bluetooth.BluetoothDeviceFilter.ClassUuidFilter
        boolean matches(ParcelUuid[] r2, BluetoothClass r3) {
            if (r2 != null) goto L5;
            if (r3 != null) goto L12;
        L16:
            return false;
        L12:
            if (BluetoothDeviceFilter.access$800(r3, 1) == false) goto L14;
        L15:
            return true;
        L14:
            if (BluetoothDeviceFilter.access$800(r3, 0) == false) goto L16;
        L5:
            if (BluetoothUuid.containsAnyUuid(r2, A2dpProfile.SINK_UUIDS) == false) goto L8;
            return true;
        L8:
            if (BluetoothUuid.containsAnyUuid(r2, HeadsetProfile.UUIDS) == false) goto L16;
            return true;
        }
    }

    private static final class BondedDeviceFilter implements Filter {
        private BondedDeviceFilter() {
        }

        /* synthetic */ BondedDeviceFilter(AnonymousClass1 r1) {
            this();
        }

        @Override // com.android.settingslib.bluetooth.BluetoothDeviceFilter.Filter
        public boolean matches(BluetoothDevice r1) {
            if (r1.getBondState() != 12) goto L5;
            return true;
        L5:
            return false;
        }
    }

    private static abstract class ClassUuidFilter implements Filter {
        abstract boolean matches(ParcelUuid[] r1, BluetoothClass r2);

        private ClassUuidFilter() {
        }

        /* synthetic */ ClassUuidFilter(AnonymousClass1 r1) {
            this();
        }

        @Override // com.android.settingslib.bluetooth.BluetoothDeviceFilter.Filter
        public boolean matches(BluetoothDevice r2) {
            return matches(r2.getUuids(), r2.getBluetoothClass());
        }
    }

    public interface Filter {
        boolean matches(BluetoothDevice r1);
    }

    private static final class NapFilter extends ClassUuidFilter {
        private NapFilter() {
            super(null);
        }

        /* synthetic */ NapFilter(AnonymousClass1 r1) {
            this();
        }

        @Override // com.android.settingslib.bluetooth.BluetoothDeviceFilter.ClassUuidFilter
        boolean matches(ParcelUuid[] r2, BluetoothClass r3) {
            if (r2 != null) goto L5;
        L7:
            if (r3 != null) goto L9;
        L11:
            return false;
        L9:
            if (BluetoothDeviceFilter.access$800(r3, 5) == false) goto L11;
            return true;
        L5:
            if (ArrayUtils.contains(r2, BluetoothUuid.NAP) == false) goto L7;
            return true;
        }
    }

    private static final class PanuFilter extends ClassUuidFilter {
        private PanuFilter() {
            super(null);
        }

        /* synthetic */ PanuFilter(AnonymousClass1 r1) {
            this();
        }

        @Override // com.android.settingslib.bluetooth.BluetoothDeviceFilter.ClassUuidFilter
        boolean matches(ParcelUuid[] r2, BluetoothClass r3) {
            if (r2 != null) goto L5;
        L7:
            if (r3 != null) goto L9;
        L11:
            return false;
        L9:
            if (BluetoothDeviceFilter.access$800(r3, 4) == false) goto L11;
            return true;
        L5:
            if (ArrayUtils.contains(r2, BluetoothUuid.PANU) == false) goto L7;
            return true;
        }
    }

    private static final class TransferFilter extends ClassUuidFilter {
        private TransferFilter() {
            super(null);
        }

        /* synthetic */ TransferFilter(AnonymousClass1 r1) {
            this();
        }

        @Override // com.android.settingslib.bluetooth.BluetoothDeviceFilter.ClassUuidFilter
        boolean matches(ParcelUuid[] r2, BluetoothClass r3) {
            if (r2 != null) goto L5;
        L7:
            if (r3 != null) goto L9;
        L11:
            return false;
        L9:
            if (BluetoothDeviceFilter.access$800(r3, 2) == false) goto L11;
            return true;
        L5:
            if (ArrayUtils.contains(r2, BluetoothUuid.OBEX_OBJECT_PUSH) == false) goto L7;
            return true;
        }
    }

    private static final class UnbondedDeviceFilter implements Filter {
        private UnbondedDeviceFilter() {
        }

        /* synthetic */ UnbondedDeviceFilter(AnonymousClass1 r1) {
            this();
        }

        @Override // com.android.settingslib.bluetooth.BluetoothDeviceFilter.Filter
        public boolean matches(BluetoothDevice r1) {
            if (r1.getBondState() == 12) goto L5;
            return true;
        L5:
            return false;
        }
    }

    static /* synthetic */ boolean access$800(BluetoothClass r0, int r1) {
        return doesClassMatch(r0, r1);
    }

    static {
        AnonymousClass1 r1 = null;
        AllFilter r0 = new AllFilter(r1);
        ALL_FILTER = r0;
        BONDED_DEVICE_FILTER = new BondedDeviceFilter(r1);
        UNBONDED_DEVICE_FILTER = new UnbondedDeviceFilter(r1);
        FILTERS = new Filter[]{r0, new AudioFilter(r1), new TransferFilter(r1), new PanuFilter(r1), new NapFilter(r1)};
    }

    private BluetoothDeviceFilter() {
    }

    public static Filter getFilter(int r2) {
        if (r2 < 0) goto L7;
        Filter[] r0 = FILTERS;
        if (r2 >= r0.length) goto L7;
        return r0[r2];
    L7:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Invalid filter type " + r2 + " for device picker");
        return ALL_FILTER;
    }

    private static boolean doesClassMatch(BluetoothClass r0, int r1) {
        return r0.doesClassMatch(r1);
    }
}
