package com.bytedance.bdlocation.provider;

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
import android.os.Build;
import android.os.Looper;
import android.telephony.CellIdentityLte;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import com.bytedance.bdlocation.api.IBPEALocal;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.entity.bpea.BPEACertCheckResult;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.permission.PermissionManager;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class DefaultBpeaProvider implements IBPEALocal {
    public DefaultBpeaProvider() {
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public void addGpsStatusListener(LocationManager r1, GpsStatus.Listener r2, Object r3) {
        Logger.i("LocationPrivacy API addGpsStatusListener");
        r1.addGpsStatusListener(r2);
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    @RequiresApi(api = 21)
    public void bluetoothStartScan(BluetoothLeScanner r1, List<ScanFilter> r2, ScanSettings r3, ScanCallback r4, Object r5) {
        if (Build.VERSION.SDK_INT >= 31) goto L5;
    L7:
        Logger.i("LocationPrivacy API bluetooth StartScan");
        r1.startScan(r2, r3, r4);
        return;
    L5:
        if (PermissionManager.hasBluetoothPermissions(BDLocationConfig.getContext()) == true) goto L7;
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public BPEACertCheckResult checkAndTranslateCert(Object r1, String r2) {
        return new BPEACertCheckResult();
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public String getAddress(BluetoothDevice r1, Object r2) {
        Logger.i("LocationPrivacy API bluetooth getAddress");
        return r1.getAddress();
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    @RequiresApi(api = 17)
    public List<CellInfo> getAllCellInfo(TelephonyManager r1, Object r2) {
        Logger.i("LocationPrivacy API getAllCellInfo");
        return r1.getAllCellInfo();
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public String getBSSID(WifiInfo r1, Object r2) {
        Logger.i("LocationPrivacy API getBSSID");
        return r1.getBSSID();
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public int getBaseStationId(CdmaCellLocation r1, Object r2) {
        Logger.i("LocationPrivacy API getBaseStationId");
        return r1.getBaseStationId();
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public int getBaseStationLatitude(CdmaCellLocation r1, Object r2) {
        Logger.i("LocationPrivacy API getBaseStationLatitude");
        return r1.getBaseStationLatitude();
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public int getBaseStationLongitude(CdmaCellLocation r1, Object r2) {
        Logger.i("LocationPrivacy API getBaseStationLongitude");
        return r1.getBaseStationLongitude();
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public String getBpeaToken(Object r1) {
        return "DefaultBpeaProvider";
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public CellLocation getCellLocation(TelephonyManager r1, Object r2) {
        Logger.i("LocationPrivacy API getCellLocation");
        return r1.getCellLocation();
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public int getCid(GsmCellLocation r1, Object r2) {
        Logger.i("LocationPrivacy API getCid");
        return r1.getCid();
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public WifiInfo getConnectionInfo(WifiManager r1, Object r2) {
        Logger.i("LocationPrivacy API getConnectionInfo");
        return r1.getConnectionInfo();
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public Sensor getDefaultSensor(SensorManager r1, int r2, Object r3) {
        Logger.i("LocationPrivacy API sensor getDefaultSensor");
        return r1.getDefaultSensor(r2);
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public int getLac(GsmCellLocation r1, Object r2) {
        Logger.i("LocationPrivacy API getLac");
        return r1.getLac();
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public Location getLastKnownLocation(LocationManager r1, String r2, Object r3) {
        Logger.i("LocationPrivacy API getLastKnownLocation");
        return r1.getLastKnownLocation(r2);
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public int getNetworkId(CdmaCellLocation r1, Object r2) {
        Logger.i("LocationPrivacy API getNetworkId");
        return r1.getNetworkId();
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public int getPsc(GsmCellLocation r1, Object r2) {
        Logger.i("LocationPrivacy API getPsc");
        return r1.getPsc();
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public String getSSID(WifiInfo r1, Object r2) {
        Logger.i("LocationPrivacy API getSSID");
        return r1.getSSID();
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public List<ScanResult> getScanResults(WifiManager r1, Object r2) {
        Logger.i("LocationPrivacy API getScanResults");
        return r1.getScanResults();
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public int getSystemId(CdmaCellLocation r1, Object r2) {
        Logger.i("LocationPrivacy API getSystemId");
        return r1.getSystemId();
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    @RequiresApi(api = 17)
    public int getTac(CellIdentityLte r1, Object r2) {
        Logger.i("LocationPrivacy API getTac");
        return r1.getTac();
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public void requestCellInfoUpdate(TelephonyManager r1, Executor r2, TelephonyManager.CellInfoCallback r3, Object r4) {
        Logger.i("LocationPrivacy API requestCellInfoUpdate");
        r1.requestCellInfoUpdate(r2, r3);
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public void requestLocationUpdates(LocationManager r1, String r2, long r3, float r5, LocationListener r6, Looper r7, Object r8) {
        Logger.i("LocationPrivacy API requestLocationUpdates");
        r1.requestLocationUpdates(r2, r3, r5, r6, r7);
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public void requestSingleUpdate(LocationManager r1, String r2, LocationListener r3, Looper r4, Object r5) {
        Logger.i("LocationPrivacy API requestSingleUpdate");
        r1.requestSingleUpdate(r2, r3, r4);
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public boolean startDiscovery(BluetoothAdapter r1, Object r2) {
        if (Build.VERSION.SDK_INT >= 31) goto L5;
    L8:
        Logger.i("LocationPrivacy API bluetooth startDiscovery");
        return r1.startDiscovery();
    L5:
        if (PermissionManager.hasBluetoothPermissions(BDLocationConfig.getContext()) == true) goto L8;
        return false;
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    @RequiresApi(api = 18)
    public boolean startLeScan(BluetoothAdapter r1, BluetoothAdapter.LeScanCallback r2, Object r3) {
        if (Build.VERSION.SDK_INT >= 31) goto L5;
    L8:
        Logger.i("LocationPrivacy API bluetooth startLeScan");
        return r1.startLeScan(r2);
    L5:
        if (PermissionManager.hasBluetoothPermissions(BDLocationConfig.getContext()) == true) goto L8;
        return false;
    }

    @Override // com.bytedance.bdlocation.api.IBPEALocal
    public boolean wifiStartScan(WifiManager r1, Object r2) {
        Logger.i("LocationPrivacy API wifiStartScan");
        return r1.startScan();
    }
}
