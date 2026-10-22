package com.obric.security.secretdata;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.text.TextUtils;
import android.util.Log;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import system.bytedance.hardware.secretdata.ISecretDataService;
import system.bytedance.hardware.secretdata.SecretDataAddResult;
import system.bytedance.hardware.secretdata.SecretDataDeleteParams;
import system.bytedance.hardware.secretdata.SecretDataParcel;
import system.bytedance.hardware.secretdata.SecretDataQueryParams;
import system.bytedance.hardware.secretdata.SecretDataQueryResult;

/* JADX INFO: loaded from: classes.dex */
public class SecretDataManager {
    private static final String KEY_SERVICE_NAME = "system.bytedance.hardware.secretdata.ISecretDataService/default";
    private static final int KM_CA_ERROR_CODE_BASE = -3000;
    private static final int KM_NATIVE_ERROR_CODE_BASE = -2000;
    private static final int SECRET_DATA_BATCH_MAX_COUNT = 50;
    private static final String TAG = null;
    private static volatile SecretDataManager mSecretDataManager;
    private ISecretDataService mBinder;

    static {
        TAG = SecretDataManager.class.getSimpleName();
    }

    private SecretDataManager() {
    }

    public static SecretDataManager getInstance() {
        if (mSecretDataManager != null) goto L15;
        monitor-enter(SecretDataManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mSecretDataManager != null) goto L9;
        mSecretDataManager = new SecretDataManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(SecretDataManager.class);     // Catch: Throwable -> L11
    L15:
        return mSecretDataManager;
    }

    private synchronized ISecretDataService getService() {
        monitor-enter(this);
        this.mBinder = ISecretDataService.Stub.asInterface(ServiceManager.getService(KEY_SERVICE_NAME));     // Catch: Throwable -> L6
        ISecretDataService r0 = this.mBinder;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    private byte[] getContextSignature(Context context) {
        byte[] signature = new byte[0];
        PackageManager pm = context.getPackageManager();     // Catch: Exception -> L9
        if (pm != null) goto L7;
        Log.e(TAG, "Get PackageManager failed!!");     // Catch: Exception -> L9
        return signature;
    L7:
        PackageInfo packageInfo = pm.getPackageInfo(context.getPackageName(), 64);     // Catch: Exception -> L9
        return packageInfo.signatures[0].toByteArray();
    L9:
        e = move-exception;
        Log.e(TAG, "Get signature failed, error:" + e.getMessage());
        return signature;
    }

    private static String getSHA256(byte[] input) {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");     // Catch: NoSuchAlgorithmException -> L5
        messageDigest.update(input);     // Catch: NoSuchAlgorithmException -> L5
        String encoder = Base64.getEncoder().encodeToString(messageDigest.digest());     // Catch: NoSuchAlgorithmException -> L5
        return encoder;
    L5:
        e = move-exception;
        Log.e(TAG, "Get message digest failed, error:" + e.getMessage());
        return "";
    }

    private boolean dataIsEmpty(String data) {
        if (data != null) goto L4;
        return true;
    L4:
        if (data.isEmpty() == true) goto L10;
        return false;
    L10:
        return true;
    }

    private void putSecretData2Parcel(SecretData data, SecretDataParcel dataParcel) {
        if (dataIsEmpty(data.alias) == true) goto L6;
        dataParcel.alias = data.alias;
    L6:
        if (dataIsEmpty(data.dataType) == true) goto L9;
        dataParcel.dataType = data.dataType;
    L9:
        if (dataIsEmpty(data.associate) == true) goto L12;
        dataParcel.associate = data.associate;
    L12:
        if (dataIsEmpty(data.publicData) == true) goto L15;
        dataParcel.publicData = data.publicData;
    L15:
        if (dataIsEmpty(data.privateData) == true) goto L18;
        dataParcel.privateData = data.privateData;
    L18:
        if (dataIsEmpty(data.secretData) == true) goto L21;
        dataParcel.secretData = data.secretData;
    L21:
        if (dataIsEmpty(data.extInfo) == true) goto L24;
        dataParcel.extInfo = data.extInfo;
    L24:
        if (dataIsEmpty(data.searchInfo) == true) goto L27;
        dataParcel.searchInfo = data.searchInfo;
    L27:
        if (dataIsEmpty(data.accessLimit) == true) goto L30;
        dataParcel.accessLimit = data.accessLimit;
    L30:
        if (dataIsEmpty(data.authLimit) == true) goto L32;
        dataParcel.authLimit = data.authLimit;
    L32:
        dataParcel.syncLimit = data.syncLimit;
    }

    public AddResult addData(Context context, SecretData data, Bundle extra) {
        if (extra == null) goto L28;
        if (data == null) goto L28;
        if (context == null) goto L28;
        SecretDataParcel dataParcel = new SecretDataParcel();
        putSecretData2Parcel(data, dataParcel);
        byte[] signature = getContextSignature(context);
        if (signature != null) goto L10;
    L26:
        Log.e(TAG, "Get signature failed!!");
        return new AddResult(-100, "");
    L10:
        if (signature.length == 0) goto L26;
        if (getService() != null) goto L16;
        Log.e(TAG, "Service not ready!!");
        return new AddResult(-3, "");
    L16:
        SecretDataAddResult result = null;
        result = this.mBinder.addSecretData(dataParcel, getSHA256(signature), context.getPackageName());     // Catch: RemoteException -> L19
    L21:
        if (result != null) goto L25;
        Log.e(TAG, "Add data failed, result is null!!");
        return new AddResult(-100, "");
    L25:
        return new AddResult(transferErrorCode(result.status), result.alias);
    L19:
        re = move-exception;
        Log.e(TAG, "Add data binder failed, error:" + re.getMessage());
    L28:
        Log.e(TAG, "Input param error!!");
        return new AddResult(-2, "");
    }

    public int deleteData(Context context, String alias, Bundle extra) {
        if (context == null) goto L38;
        if (extra == null) goto L38;
        if (extra.containsKey(SecretConst.BUNDLE_KEY_DELETE_ALL_DATA) == true) goto L15;
        if (alias != null) goto L10;
    L13:
        Log.e(TAG, "Alias is empty!!");
        return -2;
    L10:
        if (alias.isEmpty() == true) goto L13;
        SecretDataDeleteParams deleteParams = SecretDataDeleteParams.alias(alias);
    L20:
        byte[] signature = getContextSignature(context);
        if (signature != null) goto L23;
    L36:
        Log.e(TAG, "Get signature failed!!");
        return -100;
    L23:
        if (signature.length == 0) goto L36;
        if (getService() != null) goto L29;
        Log.e(TAG, "Service not ready!!");
        return -3;
    L29:
        int result = -1000;
        result = this.mBinder.deleteSecretData(deleteParams, getSHA256(signature), context.getPackageName());     // Catch: RemoteException -> L32
    L35:
        return transferErrorCode(result);
    L32:
        re = move-exception;
        Log.e(TAG, "Delete data binder failed, error:" + re.getMessage());
        goto L35
    L15:
        int deleteFlag = extra.getInt(SecretConst.BUNDLE_KEY_DELETE_ALL_DATA);
        if (deleteFlag == 1) goto L19;
        Log.e(TAG, "Delete flag exist, but value is invalid!!");
        return -2;
    L19:
        deleteParams = SecretDataDeleteParams.deleteFlag(deleteFlag);
    L38:
        Log.e(TAG, "Input param error!!");
        return -2;
    }

    public int clearData(Context context, String alias, Bundle extra) {
        return deleteData(context, alias, extra);
    }

    public int updateData(Context context, SecretData newData, Bundle extra) {
        if (context == null) goto L31;
        if (extra == null) goto L31;
        if (newData.alias != null) goto L9;
    L29:
        Log.e(TAG, "Alias is empty!!");
        return -2;
    L9:
        if (newData.alias.isEmpty() == true) goto L29;
        SecretDataParcel newDataParcel = new SecretDataParcel();
        putSecretData2Parcel(newData, newDataParcel);
        byte[] signature = getContextSignature(context);
        if (signature != null) goto L14;
    L27:
        Log.e(TAG, "Get signature failed!!");
        return -100;
    L14:
        if (signature.length == 0) goto L27;
        if (getService() != null) goto L20;
        Log.e(TAG, "Service not ready!!");
        return -3;
    L20:
        int result = -1000;
        result = this.mBinder.updateSecretData(newDataParcel, getSHA256(signature), context.getPackageName());     // Catch: RemoteException -> L23
    L26:
        return transferErrorCode(result);
    L23:
        re = move-exception;
        Log.e(TAG, "Update data binder failed, error:" + re.getMessage());
    L31:
        Log.e(TAG, "Input param error!!");
        return -2;
    }

    private List<SecretData> getResultList(List<SecretDataParcel> queryData) {
        List<SecretData> dataList = new ArrayList();
        if (queryData != null) goto L5;
    L52:
        return dataList;
    L5:
        if (queryData.size() == 0) goto L52;
        int i = 0;
    L9:
        if (i >= queryData.size()) goto L51;
        SecretDataParcel dataParcel = queryData.get(i);
        if (dataParcel == null) goto L50;
        SecretData secretData = new SecretData();
        if (dataIsEmpty(dataParcel.alias) == true) goto L17;
        secretData.alias = dataParcel.alias;
    L17:
        if (dataIsEmpty(dataParcel.dataType) == true) goto L20;
        secretData.dataType = dataParcel.dataType;
    L20:
        if (dataIsEmpty(dataParcel.associate) == true) goto L23;
        secretData.associate = dataParcel.associate;
    L23:
        if (dataIsEmpty(dataParcel.publicData) == true) goto L26;
        secretData.publicData = dataParcel.publicData;
    L26:
        if (dataIsEmpty(dataParcel.privateData) == true) goto L29;
        secretData.privateData = dataParcel.privateData;
    L29:
        if (dataIsEmpty(dataParcel.secretData) == true) goto L32;
        secretData.secretData = dataParcel.secretData;
    L32:
        if (dataIsEmpty(dataParcel.extInfo) == true) goto L35;
        secretData.extInfo = dataParcel.extInfo;
    L35:
        if (dataIsEmpty(dataParcel.searchInfo) == true) goto L38;
        secretData.searchInfo = dataParcel.searchInfo;
    L38:
        if (dataIsEmpty(dataParcel.accessLimit) == true) goto L41;
        secretData.accessLimit = dataParcel.accessLimit;
    L41:
        if (dataIsEmpty(dataParcel.authLimit) == true) goto L43;
        secretData.authLimit = dataParcel.authLimit;
    L43:
        secretData.syncLimit = dataParcel.syncLimit;
        if (dataIsEmpty(dataParcel.createTime) == true) goto L47;
        secretData.createTime = dataParcel.createTime;
    L47:
        if (dataIsEmpty(dataParcel.latestTime) == true) goto L49;
        secretData.latestTime = dataParcel.latestTime;
    L49:
        dataList.add(secretData);
    L50:
        i = i + 1;
        goto L9
    L51:
        return dataList;
    }

    private void putBundle2Parcel(Bundle extra, SecretDataParcel data) {
        if (extra.containsKey(SecretConst.BUNDLE_KEY_DATA_TYPE) == false) goto L6;
        data.dataType = extra.getString(SecretConst.BUNDLE_KEY_DATA_TYPE);
    L6:
        if (extra.containsKey(SecretConst.BUNDLE_KEY_ASSOCIATE) == false) goto L9;
        data.associate = extra.getString(SecretConst.BUNDLE_KEY_ASSOCIATE);
    L9:
        if (extra.containsKey(SecretConst.BUNDLE_KEY_SEARCH_INFO) == false) goto L12;
        data.searchInfo = extra.getString(SecretConst.BUNDLE_KEY_SEARCH_INFO);
        return;
    }

    public QueryResult queryData(Context context, String alias, Bundle extra) {
        if (context == null) goto L68;
        if (extra == null) goto L68;
        int queryMode = extra.getInt(SecretConst.BUNDLE_KEY_QUERY_MODE, -1);
        if (queryMode != (-1)) goto L10;
        Log.e(TAG, "Query mode must be specified!!");
        return new QueryResult(-2, new ArrayList());
    L10:
        SecretDataParcel dataParcel = new SecretDataParcel();
        if (queryMode != 0) goto L13;
    L25:
        if (alias != null) goto L27;
    L66:
        Log.e(TAG, "Alias must be specified!!");
        return new QueryResult(-2, new ArrayList());
    L27:
        if (alias.isEmpty() == true) goto L66;
        dataParcel.alias = alias;
    L30:
        SecretDataQueryParams queryParams = new SecretDataQueryParams();
        queryParams.queryMode = queryMode;
        queryParams.queryInfo = dataParcel;
        if (getService() != null) goto L34;
        Log.e(TAG, "Service not ready!!");
        return new QueryResult(-3, new ArrayList());
    L34:
        byte[] signature = getContextSignature(context);
        if (signature != null) goto L37;
    L64:
        Log.e(TAG, "Get signature failed!!");
        return new QueryResult(-100, new ArrayList());
    L37:
        if (signature.length == 0) goto L64;
        List<SecretData> resultList = new ArrayList();
        boolean needContinue = true;
        int resultCode = -1000;
        int resultCode2 = 0;
        int startIndex = 0;
    L40:
        if (needContinue == false) goto L58;
        SecretDataQueryResult queryResult = this.mBinder.querySecretData(queryParams, startIndex, getSHA256(signature), context.getPackageName());     // Catch: RemoteException -> L55
        if (queryResult == null) goto L44;
        startIndex = queryResult.startIndex;
        resultCode = transferErrorCode(queryResult.status);
        if (resultCode != 0) goto L47;
        if (queryResult.queryData == null) goto L50;
        List<SecretData> tmpList = getResultList(Arrays.asList(queryResult.queryData));
        resultCode2 = resultCode2 + tmpList.size();
        resultList.addAll(tmpList);
        if (tmpList.size() == SECRET_DATA_BATCH_MAX_COUNT) goto L54;
        needContinue = false;
    L54:
        Log.i(TAG, "Query result list size:" + tmpList.size());
        goto L40
    L50:
        Log.e(TAG, "Query data list is null!!");
        goto L58
    L47:
        Log.e(TAG, "Query data failed, error code:" + resultCode);
        goto L58
    L44:
        Log.e(TAG, "Query data failed, queryResult is null!!");
    L55:
        re = move-exception;
        Log.e(TAG, "Query data binder failed, error:" + re.getMessage());
        return new QueryResult(resultCode, resultList);
    L58:
        if (resultCode2 <= 0) goto L63;
        if (resultCode != (-5)) goto L63;
        resultCode = 0;
    L63:
        return new QueryResult(resultCode, resultList);
    L13:
        if (queryMode == 1) goto L25;
        if (queryMode == 2) goto L25;
        if (queryMode != 3) goto L20;
    L24:
        putBundle2Parcel(extra, dataParcel);
        goto L30
    L20:
        if (queryMode == 4) goto L24;
        Log.e(TAG, "Unsupported Query Mode!!");
        return new QueryResult(-2, new ArrayList());
    L68:
        Log.e(TAG, "Input param error!!");
        return new QueryResult(-2, new ArrayList());
    }

    public int clearAppData(String packageName, int uid, Bundle extra) {
        if (TextUtils.isEmpty(packageName) == false) goto L6;
        Log.e(TAG, "Input package is invalid!!");
        return -2;
    L6:
        if (uid > 0) goto L10;
        Log.e(TAG, "Input uid is invalid!!");
        return -2;
    L10:
        if (getService() != null) goto L13;
        Log.e(TAG, "Service not ready!!");
        return -3;
    L13:
        int result = -1000;
        result = this.mBinder.clearAppData(packageName, uid);     // Catch: RemoteException -> L16
    L19:
        return transferErrorCode(result);
    L16:
        re = move-exception;
        Log.e(TAG, "Clear app data failed, error:" + re.getMessage());
        goto L19
    }

    private int transferErrorCode(int nativeCode) {
        if (nativeCode != 0) goto L6;
        return 0;
    L6:
        if (nativeCode != (-2000)) goto L9;
        return -1000;
    L9:
        if (nativeCode < (-2000)) goto L11;
    L14:
        return nativeCode;
    L11:
        if (nativeCode <= (-3000)) goto L14;
        return nativeCode + 2000;
    }
}
