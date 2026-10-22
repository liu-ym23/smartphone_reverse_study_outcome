package com.bytedance.bdlocation.api;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanSettings;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Looper;
import android.telephony.CellIdentityLte;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.bytedance.bdlocation.entity.bpea.BPEACertCheckResult;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public interface IBPEALocal extends IManager {
    void addGpsStatusListener(LocationManager r1, GpsStatus.Listener r2, Object r3);

    void bluetoothStartScan(BluetoothLeScanner r1, List<ScanFilter> r2, ScanSettings r3, ScanCallback r4, Object r5);

    BPEACertCheckResult checkAndTranslateCert(Object r1, String r2);

    String getAddress(BluetoothDevice r1, Object r2);

    List<CellInfo> getAllCellInfo(TelephonyManager r1, Object r2);

    String getBSSID(WifiInfo r1, Object r2);

    int getBaseStationId(CdmaCellLocation r1, Object r2);

    int getBaseStationLatitude(CdmaCellLocation r1, Object r2);

    int getBaseStationLongitude(CdmaCellLocation r1, Object r2);

    String getBpeaToken(Object r1);

    CellLocation getCellLocation(TelephonyManager r1, Object r2);

    int getCid(GsmCellLocation r1, Object r2);

    WifiInfo getConnectionInfo(WifiManager r1, Object r2);

    Sensor getDefaultSensor(SensorManager r1, int r2, Object r3);

    int getLac(GsmCellLocation r1, Object r2);

    Location getLastKnownLocation(LocationManager r1, String r2, Object r3);

    int getNetworkId(CdmaCellLocation r1, Object r2);

    int getPsc(GsmCellLocation r1, Object r2);

    String getSSID(WifiInfo r1, Object r2);

    List<ScanResult> getScanResults(WifiManager r1, Object r2);

    int getSystemId(CdmaCellLocation r1, Object r2);

    int getTac(CellIdentityLte r1, Object r2);

    void requestCellInfoUpdate(TelephonyManager r1, Executor r2, TelephonyManager.CellInfoCallback r3, Object r4);

    void requestLocationUpdates(LocationManager r1, String r2, long r3, float r5, LocationListener r6, Looper r7, Object r8);

    void requestSingleUpdate(LocationManager r1, String r2, LocationListener r3, Looper r4, Object r5);

    boolean startDiscovery(BluetoothAdapter r1, Object r2);

    boolean startLeScan(BluetoothAdapter r1, BluetoothAdapter.LeScanCallback r2, Object r3);

    boolean wifiStartScan(WifiManager r1, Object r2);
}
