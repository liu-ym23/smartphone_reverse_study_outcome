package com.bytedance.bdinstall.storage;

import android.accounts.Account;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.Utils;
import com.bytedance.bdinstall.migrate.MigrateDetector;
import com.bytedance.bdinstall.service.IInstallParameters;
import com.bytedance.bdinstall.util.HardwareUtils;
import com.bytedance.bdinstall.util.LocalConstants;
import com.bytedance.bdinstall.util.RomUtils;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbsDeviceParamsProvider implements IInstallParameters {
    private static final String LOCAL_TEST_SUFFIX_STR = "_local";
    protected AccountCache mAccountCache;
    protected Cache mCache;
    protected final Context mContext;
    protected final String mLocalTestSuffix;
    protected final StorageSettings mSettings;
    private volatile String sDeviceId;
    protected String sOpenClientUdid;
    protected String sOpenUdid;

    private String createLocalTestSuffix(boolean r1) {
        if (r1 == false) goto L4;
        return LOCAL_TEST_SUFFIX_STR;
    L4:
        return "";
    }

    protected void buildFileCacher(StorageSettings r1, Cache r2) {
    }

    AbsDeviceParamsProvider(Context r4, StorageSettings r5) {
        this.mLocalTestSuffix = createLocalTestSuffix(r5.isLocalTest());
        Context r0 = r4.getApplicationContext();
        this.mContext = r0;
        this.mSettings = r5;
        this.mCache = new SPCache(r0, r5.getSp());
        if (MigrateDetector.isThisDeviceMigrate(r4) == true) goto L11;
        AccountCache r1 = new AccountCache(r4, r5.getSuffix());
        this.mAccountCache = r1;
        this.mCache.setSuccessor(r1);
        AccountCache r2 = this.mAccountCache;
        if (RomUtils.isAndroidROrHigher() == false) goto L9;
        if (RomUtils.isTargetROrHigher(r4) == true) goto L11;
    L9:
        if (r5.isNeedSharedStorage() == false) goto L11;
        buildFileCacher(r5, r2);
    L11:
        setAccount(r5.getAccount());
    }

    @Override // com.bytedance.bdinstall.service.IInstallParameters
    public String getOpenUdid(boolean r7) {
        if (TextUtils.isEmpty(this.sOpenUdid) == false) goto L5;
        String r8 = HardwareUtils.getSecureAndroidId(this.mContext);
        SharedPreferences r0 = LocalConstants.getCommonSp(this.mContext);
        String r1 = r0.getString(Api.KEY_OPEN_UDID, null);
        if (Utils.isValidUDID(r8) == false) goto L12;
        if (IInstallParameters.FAKE_ANDROID_ID.equals(r8) == false) goto L24;
    L12:
        if (Utils.isValidUDID(r1) == true) goto L23;
        r1 = new BigInteger(80, new SecureRandom()).toString(16);     // Catch: Exception -> L31
        if (r1.charAt(0) != '-') goto L16;
        r1 = r1.substring(1);     // Catch: Exception -> L31
    L16:
        int r3 = 13 - r1.length();     // Catch: Exception -> L31
        if (r3 <= 0) goto L23;
        StringBuilder r4 = new StringBuilder();     // Catch: Exception -> L31
    L19:
        if (r3 <= 0) goto L21;
        r4.append('F');     // Catch: Exception -> L31
        r3 = r3 - 1;     // Catch: Exception -> L31
        goto L19
    L21:
        r4.append(r1);     // Catch: Exception -> L31
        r8 = r4.toString();     // Catch: Exception -> L31
    L23:
        r8 = r1;
    L24:
        SharedPreferences.Editor r2 = r0.edit();
        r2.putString(Api.KEY_OPEN_UDID, r8);
        r2.apply();
        if (TextUtils.isEmpty(r8) == true) goto L28;
        r8 = r8 + this.mLocalTestSuffix;
    L28:
        if (TextUtils.isEmpty(r8) == true) goto L30;
        this.sOpenUdid = r8;
    L30:
        return r8;
    L5:
        return this.sOpenUdid;
    }

    @Override // com.bytedance.bdinstall.service.IInstallParameters
    public String getClientUDID() {
        if (TextUtils.isEmpty(this.sOpenClientUdid) == false) goto L5;
        SharedPreferences r1 = LocalConstants.getCommonSp(this.mContext);     // Catch: Exception -> L14
        String r2 = r1.getString(Api.KEY_C_UDID, null);     // Catch: Exception -> L14
        if (Utils.isValidUDID(r2) == true) goto L10;
        r2 = UUID.randomUUID().toString();     // Catch: Exception -> L14
        SharedPreferences.Editor r3 = r1.edit();     // Catch: Exception -> L14
        r3.putString(Api.KEY_C_UDID, r2);     // Catch: Exception -> L14
        r3.apply();     // Catch: Exception -> L14
    L10:
        if (TextUtils.isEmpty(r2) == true) goto L12;
        r2 = r2 + this.mLocalTestSuffix;     // Catch: Exception -> L14
    L12:
        this.sOpenClientUdid = r2;     // Catch: Exception -> L14
        return r2;
    L14:
        e = move-exception;
        e.printStackTrace();
        return "";
    L5:
        return this.sOpenClientUdid;
    }

    @Override // com.bytedance.bdinstall.service.IInstallParameters
    public String getDeviceId() {
        if (TextUtils.isEmpty(this.sDeviceId) == false) goto L5;
        this.sDeviceId = this.mCache.loadDeviceId("", "");
        return this.sDeviceId;
    L5:
        return this.sDeviceId;
    }

    @Override // com.bytedance.bdinstall.service.IInstallParameters
    public void updateDeviceId(String r3) {
        if (Utils.checkId(r3) == true) goto L5;
        return;
    L5:
        if (Utils.equal(r3, this.sDeviceId) == true) goto L10;
        this.sDeviceId = this.mCache.loadDeviceId(r3, this.sDeviceId);
        return;
    }

    @Override // com.bytedance.bdinstall.service.IInstallParameters
    public void setAccount(Account r1) {
        AccountCache r0 = this.mAccountCache;
        if (r0 == null) goto L6;
        r0.setAccount(r1);
        return;
    }

    public void clear(Context r3, String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return;
    L5:
        this.sDeviceId = null;
        String r5 = Api.KEY_CLEAR_KEY_PREFIX + r4;
        SharedPreferences r6 = this.mSettings.getSp();
        if (r6.getBoolean(r5, false) == true) goto L15;
        SharedPreferences.Editor r0 = r6.edit();
        r0.putBoolean(r5, true);
        if (r6.contains("device_id") == false) goto L11;
        r0.remove("device_id");
    L11:
        if (r6.contains(Api.KEY_INSTALL_ID) == false) goto L13;
        r0.remove(Api.KEY_INSTALL_ID);
    L13:
        r0.apply();
        this.mCache.clear(Collections.singletonList("device_id"));
        return;
    }

    public AccountCache getCache() {
        return this.mAccountCache;
    }
}
