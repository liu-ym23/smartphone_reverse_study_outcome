package com.android.settings.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import com.android.settings.SettingsApplication;
import com.android.settings.utils.ResourceUtils;
import com.android.settings.utils.SLog;
import com.bytedance.keva.Keva;
import com.obric.olog.OLog;
import cz.msebera.android.httpclient.message.TokenParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: BluetoothUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0004H\u0007J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0011H\u0007J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0011H\u0002J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0011H\u0007J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0013H\u0007J\u0012\u0010\u001c\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u000f0\u001dH\u0007J\u0012\u0010\u001e\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00110\u001dH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R#\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u001f"}, d2 = {"Lcom/android/settings/bluetooth/BluetoothUtils;", "", "()V", "REPO_NAME", "", "keva", "Lcom/bytedance/keva/Keva;", "kotlin.jvm.PlatformType", "getKeva", "()Lcom/bytedance/keva/Keva;", "keva$delegate", "Lkotlin/Lazy;", "canSetActive", "", "cachedDevice", "Lcom/android/settings/bluetooth/CachedBluetoothDevice;", "getA2dpActiveDevice", "Landroid/bluetooth/BluetoothDevice;", "getCodeType", "", "address", "isActiveDevice", "device", "isWatch", "setActiveDevice", "updateCodeType", "", "codeType", "logStr", "", "logString", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class BluetoothUtils {
    public static final BluetoothUtils INSTANCE = null;
    private static final String REPO_NAME = "bluetooth_utils";
    private static final Lazy keva$delegate = null;

    private BluetoothUtils() {
    }

    static {
        INSTANCE = new BluetoothUtils();
        keva$delegate = LazyKt.lazy(BluetoothUtils$keva$2.INSTANCE);
    }

    private final Keva getKeva() {
        return (Keva) keva$delegate.getValue();
    }

    @JvmStatic
    public static final void updateCodeType(String r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "address");
        INSTANCE.getKeva().storeInt(r1, r2);
    }

    @JvmStatic
    public static final int getCodeType(String r2) {
        Intrinsics.checkNotNullParameter(r2, "address");
        return INSTANCE.getKeva().getInt(r2, -1);
    }

    @JvmStatic
    public static final BluetoothDevice getA2dpActiveDevice() {
        BluetoothManager r0 = (BluetoothManager) SettingsApplication.getContext().getSystemService(BluetoothManager.class);
        if (r0 == null) goto L5;
        BluetoothAdapter r1 = r0.getAdapter();
    L6:
        if (r1 != null) goto L8;
        return null;
    L8:
        List r2 = r1.getActiveDevices(2);
        if (r2 != null) goto L11;
        return null;
    L11:
        return (BluetoothDevice) CollectionsKt.firstOrNull(r2);
    L5:
        r1 = null;
        goto L6
    }

    @JvmStatic
    public static final String logStr(Collection<CachedBluetoothDevice> r11) {
        Intrinsics.checkNotNullParameter(r11, "<this>");
        StringBuilder r0 = new StringBuilder("size: ").append(r11.size()).append(": ");
        ArrayList r1 = new ArrayList();
        Iterator<T> r12 = r11.iterator();
    L4:
        if (r12.hasNext() == false) goto L9;
        Object r2 = r12.next();
        CachedBluetoothDevice r3 = (CachedBluetoothDevice) r2;
        if ((!Intrinsics.areEqual(r3.getName(), r3.getDevice().getAddress())) == false) goto L4;
        r1.add(r2);
        goto L4
    L9:
        return r0.append(CollectionsKt.joinToString$default(r1, ",", null, null, 0, null, AnonymousClass2.INSTANCE, 30, null)).toString();
    }

    @JvmStatic
    public static final String logString(Collection<BluetoothDevice> r11) {
        Intrinsics.checkNotNullParameter(r11, "<this>");
        StringBuilder r0 = new StringBuilder("size: ").append(r11.size()).append(": ");
        ArrayList r1 = new ArrayList();
        Iterator<T> r12 = r11.iterator();
    L4:
        if (r12.hasNext() == false) goto L12;
        Object r2 = r12.next();
        if (((BluetoothDevice) r2).getName() == null) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L4;
        r1.add(r2);
        goto L4
    L8:
        r3 = false;
        goto L9
    L12:
        return r0.append(CollectionsKt.joinToString$default(r1, ",", null, null, 0, null, C01452.INSTANCE, 30, null)).toString();
    }

    @JvmStatic
    public static final boolean isActiveDevice(BluetoothDevice r9) {
        Intrinsics.checkNotNullParameter(r9, "device");
        BluetoothAdapter r0 = BluetoothAdapter.getDefaultAdapter();
        if (r0 != null) goto L5;
        return false;
    L5:
        List r2 = r0.getActiveDevices(2);
        if (r2 != null) goto L8;
        r2 = CollectionsKt.emptyList();
    L8:
        List r1 = r0.getActiveDevices(1);
        if (r1 != null) goto L11;
        r1 = CollectionsKt.emptyList();
    L11:
        StringBuilder r4 = new StringBuilder("isActiveDevice: a2dpActiveDevices ");
        List r5 = r2;
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator r7 = r5.iterator();
    L13:
        if (r7.hasNext() == false) goto L15;
        r6.add(((BluetoothDevice) r7.next()).getAddress());
        goto L13
    L15:
        SLog.d("BluetoothUtils", r4.append(r6).toString());
        StringBuilder r8 = new StringBuilder("isActiveDevice: headsetActiveDevices ");
        List r10 = r1;
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator r12 = r10.iterator();
    L17:
        if (r12.hasNext() == false) goto L19;
        r11.add(((BluetoothDevice) r12.next()).getAddress());
        goto L17
    L19:
        SLog.d("BluetoothUtils", r8.append(r11).toString());
        if (r2.contains(r9) == true) goto L22;
        return false;
    L22:
        if (r1.contains(r9) == true) goto L24;
        return false;
    L24:
        return true;
    }

    @JvmStatic
    public static final boolean setActiveDevice(BluetoothDevice r2) {
        Intrinsics.checkNotNullParameter(r2, "device");
        OLog.i("BluetoothUtils", "setActiveDevice: " + r2.getName() + TokenParser.SP + r2.getAddress());
        BluetoothAdapter r0 = BluetoothAdapter.getDefaultAdapter();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.setActiveDevice(r2, 2);
    }

    private final boolean isWatch(BluetoothDevice r2) {
        BluetoothClass r1 = r2.getBluetoothClass();
        if (r1 != null) goto L5;
    L8:
        byte[] r3 = r2.getMetadata(17);
        if (r3 != null) goto L13;
        return false;
    L13:
        return Intrinsics.areEqual(new String(r3, Charsets.UTF_8), "Watch");
    L5:
        if (r1.getDeviceClass() != 1796) goto L8;
        return true;
    }

    @JvmStatic
    public static final boolean canSetActive(CachedBluetoothDevice r7) {
        Intrinsics.checkNotNullParameter(r7, "cachedDevice");
        BluetoothDevice r0 = r7.getDevice();
        BluetoothUtils r1 = INSTANCE;
        Intrinsics.checkNotNull(r0);
        if (r1.isWatch(r0) == false) goto L6;
        OLog.i("BluetoothUtils", "canSetActive: " + r7.getName() + " isWatch");
        return false;
    L6:
        List<LocalBluetoothProfile> r2 = r7.getConnectableProfiles();
        StringBuilder r8 = new StringBuilder("canSetActive: ").append(r7.getName()).append(TokenParser.SP);
        Intrinsics.checkNotNull(r2);
        List<LocalBluetoothProfile> r3 = r2;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator<T> r5 = r3.iterator();
    L8:
        if (r5.hasNext() == false) goto L10;
        r4.add(ResourceUtils.getString(((LocalBluetoothProfile) r5.next()).getNameResource(r0)));
        goto L8
    L10:
        OLog.i("BluetoothUtils", r8.append(r4).toString());
        Iterator<T> r9 = r3.iterator();
    L11:
        Object r6 = null;
        if (r9.hasNext() == false) goto L16;
        Object r10 = r9.next();
        if ((((LocalBluetoothProfile) r10) instanceof A2dpProfile) == false) goto L11;
    L17:
        LocalBluetoothProfile r11 = (LocalBluetoothProfile) r10;
        if (r11 != null) goto L20;
        return false;
    L20:
        Iterator<T> r12 = r3.iterator();
    L22:
        if (r12.hasNext() == false) goto L26;
        Object r13 = r12.next();
        if ((((LocalBluetoothProfile) r13) instanceof HeadsetProfile) == false) goto L22;
        r6 = r13;
    L26:
        LocalBluetoothProfile r14 = (LocalBluetoothProfile) r6;
        if (r14 != null) goto L30;
        return false;
    L30:
        if (r11.isPreferred(r0) == true) goto L32;
        return false;
    L32:
        if (r11.getConnectionStatus(r0) == 2) goto L34;
        return false;
    L34:
        if (r14.isPreferred(r0) == true) goto L36;
        return false;
    L36:
        if (r14.getConnectionStatus(r0) != 2) goto L49;
        return true;
    L49:
        return false;
    L16:
        r10 = null;
        goto L17
    }
}
