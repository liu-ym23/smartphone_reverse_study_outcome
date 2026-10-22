package com.bytedance.bdinstall.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.text.TextUtils;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.Utils;
import com.bytedance.bdinstall.loader.SstLoader;
import com.bytedance.bdinstall.service.IInstallParameters;
import com.bytedance.bdinstall.util.HardwareUtils;
import com.bytedance.bdinstall.util.LocalConstants;
import com.bytedance.bdinstall.util.SensitiveUtils;
import com.bytedance.bdinstall.util.StringEncryptUtils;
import com.bytedance.librarian.LibrarianImpl;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.UUID;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
public final class CNDeviceParamsProvider extends AbsDeviceParamsProvider {
    private volatile String[] sAccid;
    private volatile String sSerialNumber;
    private volatile String sUdid;
    private volatile JSONArray sUdidList;

    CNDeviceParamsProvider(Context r1, StorageSettings r2) {
        super(r1, r2);
    }

    @Override // com.bytedance.bdinstall.storage.AbsDeviceParamsProvider, com.bytedance.bdinstall.service.IInstallParameters
    public String getOpenUdid(boolean r9) {
        if (TextUtils.isEmpty(this.sOpenUdid) == false) goto L5;
        String r0 = HardwareUtils.getSecureAndroidId(this.mContext);
        SharedPreferences r1 = LocalConstants.getCommonSp(this.mContext);
        String r3 = null;
        String r4 = r1.getString(Api.KEY_OPEN_UDID, null);
        if (Utils.isValidUDID(r0) == false) goto L18;
        if (IInstallParameters.FAKE_ANDROID_ID.equals(r0) == true) goto L18;
        if (Utils.isValidUDID(r4) == false) goto L15;
        String r10 = this.mCache.loadOpenUdid(r0, r4);     // Catch: Exception -> L47
    L16:
        r0 = r10;
        goto L41
    L15:
        r10 = this.mCache.loadOpenUdid(null, r0);     // Catch: Exception -> L47
    L18:
        if (Utils.isValidUDID(r4) == true) goto L37;
        r4 = new BigInteger(80, new SecureRandom()).toString(16);     // Catch: Exception -> L47
        if (r4.charAt(0) != '-') goto L22;
        r4 = r4.substring(1);     // Catch: Exception -> L47
    L22:
        int r5 = 13 - r4.length();     // Catch: Exception -> L47
        if (r5 <= 0) goto L28;
        StringBuilder r6 = new StringBuilder();     // Catch: Exception -> L47
    L25:
        if (r5 <= 0) goto L27;
        r6.append('F');     // Catch: Exception -> L47
        r5 = r5 - 1;     // Catch: Exception -> L47
        goto L25
    L27:
        r6.append(r4);     // Catch: Exception -> L47
        r4 = r6.toString();     // Catch: Exception -> L47
    L28:
        if (r9 == true) goto L30;
    L35:
        SharedPreferences.Editor r11 = r1.edit();     // Catch: Exception -> L47
        r11.putString(Api.KEY_OPEN_UDID, r4);     // Catch: Exception -> L47
        r11.apply();     // Catch: Exception -> L47
    L39:
        r0 = r4;
        goto L41
    L30:
        if (this.mAccountCache == null) goto L33;
        r3 = this.mAccountCache.loadOpenUdid(null, r4);     // Catch: Exception -> L47
    L33:
        if (Utils.isValidUDID(r3) == false) goto L35;
        r4 = r3;
        goto L35
    L37:
        if (this.mAccountCache == null) goto L39;
        this.mAccountCache.loadOpenUdid(r4, null);     // Catch: Exception -> L47
    L41:
        if (TextUtils.isEmpty(r0) == true) goto L44;
        r0 = r0 + this.mLocalTestSuffix;
    L44:
        if (TextUtils.isEmpty(r0) == true) goto L46;
        this.sOpenUdid = r0;
    L46:
        return r0;
    L5:
        return this.sOpenUdid;
    }

    @Override // com.bytedance.bdinstall.storage.AbsDeviceParamsProvider, com.bytedance.bdinstall.service.IInstallParameters
    public String getClientUDID() {
        if (TextUtils.isEmpty(this.sOpenClientUdid) == false) goto L5;
        SharedPreferences r1 = LocalConstants.getCommonSp(this.mContext);     // Catch: Exception -> L23
        String r2 = null;
        String r3 = r1.getString(Api.KEY_C_UDID, null);     // Catch: Exception -> L23
        if (Utils.isValidUDID(r3) == true) goto L16;
        r3 = UUID.randomUUID().toString();     // Catch: Exception -> L23
        if (this.mAccountCache == null) goto L12;
        r2 = this.mAccountCache.loadClientUdid(null, r3);     // Catch: Exception -> L23
    L12:
        if (Utils.isValidUDID(r2) == false) goto L14;
        r3 = r2;
    L14:
        SharedPreferences.Editor r4 = r1.edit();     // Catch: Exception -> L23
        r4.putString(Api.KEY_C_UDID, r3);     // Catch: Exception -> L23
        r4.apply();     // Catch: Exception -> L23
    L19:
        if (TextUtils.isEmpty(r3) == true) goto L21;
        r3 = r3 + this.mLocalTestSuffix;     // Catch: Exception -> L23
    L21:
        this.sOpenClientUdid = r3;     // Catch: Exception -> L23
        return r3;
    L16:
        if (this.mAccountCache == null) goto L19;
        this.mAccountCache.loadClientUdid(r3, null);     // Catch: Exception -> L23
    L23:
        e = move-exception;
        e.printStackTrace();
        return "";
    L5:
        return this.sOpenClientUdid;
    }

    @Override // com.bytedance.bdinstall.service.IInstallParameters
    public void clearAll() {
        this.mCache.clear(Arrays.asList(new String[]{Api.KEY_OPEN_UDID, Api.KEY_C_UDID, SstLoader.KEY_SERIAL_NUMBER, SstLoader.KEY_SIM_SERIAL_NUMBER, SstLoader.KEY_UDID, "device_id", Api.KEY_INSTALL_ID}));
    }

    public String getSerialNumber() {
        if (TextUtils.isEmpty(this.sSerialNumber) == true) goto L15;
        return this.sSerialNumber;
    L15:
        String r1 = this.mCache.loadSerialNumber(null, SensitiveUtils.getSerialNumber(this.mContext, this.mSettings.getOptions()));     // Catch: Exception -> L12
        if (TextUtils.isEmpty(r1) == true) goto L10;
        r1 = r1 + this.mLocalTestSuffix;     // Catch: Exception -> L12
    L10:
        this.sSerialNumber = r1;     // Catch: Exception -> L12
        return r1;
    L12:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public String[] getSimSerialNumbers() {
        if (this.sAccid == null) goto L20;
        if (this.sAccid.length <= 0) goto L20;
        return this.sAccid;
    L20:
        String[] r1 = this.mCache.loadAccId(null, SensitiveUtils.getSimSerialNumbers(this.mContext, this.mSettings.getOptions()));     // Catch: Exception -> L17
        int r2 = 0;
        if (r1 != null) goto L13;
        r1 = new String[0];     // Catch: Exception -> L17
    L13:
        if (r2 >= r1.length) goto L15;
        r1[r2] = r1[r2] + this.mLocalTestSuffix;     // Catch: Exception -> L17
        r2 = r2 + 1;     // Catch: Exception -> L17
        goto L13
    L15:
        this.sAccid = r1;     // Catch: Exception -> L17
        return r1;
    L17:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public String getUdId() {
        if (TextUtils.isEmpty(this.sUdid) == true) goto L15;
        return this.sUdid;
    L15:
        String r1 = this.mCache.loadUdid(null, SensitiveUtils.getDeviceIdWithCache(this.mContext, this.mSettings.getOptions()));     // Catch: Exception -> L12
        if (TextUtils.isEmpty(r1) == true) goto L10;
        r1 = r1 + this.mLocalTestSuffix;     // Catch: Exception -> L12
    L10:
        this.sUdid = r1;     // Catch: Exception -> L12
        return r1;
    L12:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public JSONArray getUdIdList() {
        if (this.sUdidList != null) goto L5;
        this.sUdidList = SensitiveUtils.getMultiImei(this.mContext, this.mSettings.getOptions());     // Catch: Exception -> L8
        return this.sUdidList;
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    L5:
        return this.sUdidList;
    }

    @Override // com.bytedance.bdinstall.storage.AbsDeviceParamsProvider
    protected void buildFileCacher(StorageSettings r10, Cache r11) {
        String r6 = getKey();
        boolean r7 = !r10.isAnonymous();
        ExternalCache r8 = new ExternalCache(this.mContext, r7, Environment.getExternalStorageDirectory().getPath() + StringEncryptUtils.base64DecodeToString("L0FuZHJvaWQvZGF0YS9jb20uc25zc2RrLmFwaS9ieXRlZGFuY2U=") + this.mLocalTestSuffix, r10.getFileName(), r6);     // Catch: Exception -> L5
        r11.setSuccessor(r8);     // Catch: Exception -> L5
        r11 = r8;
    L14:
        r11.setSuccessor(new ExternalCache(this.mContext, r7, Environment.getExternalStorageDirectory().getPath() + LibrarianImpl.Constants.SEPARATOR + StringEncryptUtils.getBytedanceString() + this.mLocalTestSuffix, r10.getFileName(), r6));     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }

    private static String getKey() {
        String r1 = Api.KEY_EXTERNAL_DERECTORY_DEVICE_PARAMETER + StringEncryptUtils.getBytedanceString();
        return new String(new char[]{r1.charAt(1), r1.charAt(3), r1.charAt(1), r1.charAt(11), r1.charAt(15), r1.charAt(10), r1.charAt(8), r1.charAt(17), r1.charAt(9), r1.charAt(9), r1.charAt(12), r1.charAt(13), r1.charAt(13), r1.charAt(5), r1.charAt(18), r1.charAt(13), r1.charAt(14), r1.charAt(11), r1.charAt(4), r1.charAt(19), r1.charAt(7)}).substring(2, 18);
    }
}
