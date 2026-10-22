package com.obric.cae.libs.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes4.dex */
public class BtDeviceInfoExtEvent implements Parcelable {
    public static final Parcelable.Creator<BtDeviceInfoExtEvent> CREATOR = null;
    public static final int INVALID_PRODUCT_ID = 0;
    public static final int TYPE_BAND = 5;
    public static final int TYPE_CAMERA = 20;
    public static final int TYPE_CARKIT = 2;
    public static final int TYPE_COMPUTER = 6;
    public static final int TYPE_EBIKE = 11;
    public static final int TYPE_EVEHICLE = 23;
    public static final int TYPE_GAMEPAD = 18;
    public static final int TYPE_GIMBAL = 24;
    public static final int TYPE_GLASS = 12;
    public static final int TYPE_HEADPHONES = 17;
    public static final int TYPE_HEADSET = 1;
    public static final int TYPE_KEYBOARD = 8;
    public static final int TYPE_LAPTOP = 14;
    public static final int TYPE_LOUDSPEAKER = 3;
    public static final int TYPE_MICROPHONE = 15;
    public static final int TYPE_MOUSE = 9;
    public static final int TYPE_PAD = 13;
    public static final int TYPE_PERIPHERAL = 10;
    public static final int TYPE_PRINTER = 21;
    public static final int TYPE_SELFIESTICK = 22;
    public static final int TYPE_SMART_PHONE = 7;
    public static final int TYPE_TV = 16;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_VR = 19;
    public static final int TYPE_WATCH = 4;
    private final BluetoothDevice mDevice;
    private final int mDeviceType;
    private final int mProductId;

    public class a implements Parcelable.Creator<BtDeviceInfoExtEvent> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BtDeviceInfoExtEvent createFromParcel(Parcel r1) {
            return new BtDeviceInfoExtEvent(r1);
        }

        @Override // android.os.Parcelable.Creator
        public final BtDeviceInfoExtEvent[] newArray(int r1) {
            return new BtDeviceInfoExtEvent[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public BtDeviceInfoExtEvent(BluetoothDevice r1, int r2) {
        this.mDevice = r1;
        this.mProductId = r2;
        this.mDeviceType = 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public BluetoothDevice getDevice() {
        return this.mDevice;
    }

    public int getDeviceType() {
        return this.mDeviceType;
    }

    public int getProductId() {
        return this.mProductId;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        r2.writeParcelable(this.mDevice, r3);
        r2.writeInt(this.mProductId);
        r2.writeInt(this.mDeviceType);
    }

    public BtDeviceInfoExtEvent(BluetoothDevice r1, int r2, int r3) {
        this.mDevice = r1;
        this.mProductId = r2;
        this.mDeviceType = r3;
    }

    public BtDeviceInfoExtEvent(Parcel r2) {
        this.mDevice = (BluetoothDevice) r2.readParcelable(BluetoothDevice.class.getClassLoader());
        this.mProductId = r2.readInt();
        this.mDeviceType = r2.readInt();
    }
}
