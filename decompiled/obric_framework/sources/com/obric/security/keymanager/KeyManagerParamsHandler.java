package com.obric.security.keymanager;

import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import system.bytedance.hardware.keymanager.CloudSyncKeyParams;
import system.bytedance.hardware.keymanager.CloudSyncKeyParamsLegacy;
import vendor.bytedance.hardware.keymanager.KeyParameter;
import vendor.bytedance.hardware.keymanager.KeyParameterValue;
import vendor.bytedance.hardware.keymanager.Tag;

/* JADX INFO: loaded from: classes.dex */
public class KeyManagerParamsHandler {
    private static final int ECC_INVALID_PURPOSE_MASK = 0;
    private static final List<Integer> SUPPORTED_ALGORITHM = null;
    private static final Map<Integer, List<Integer>> SUPPORTED_ALGORITHM_TO_SIZE = null;
    private static final int SUPPORTED_PURPOSE_MASK = 236;
    private static final String TAG = null;
    private static final Map<String, Pair<Integer, Integer>> attestationIdsWithLimit = null;

    public KeyManagerParamsHandler() {
    }

    static {
        TAG = KeyManagerParamsHandler.class.getSimpleName();
        SUPPORTED_ALGORITHM = List.of(2);
        SUPPORTED_ALGORITHM_TO_SIZE = Map.of(2, List.of(256));
        attestationIdsWithLimit = new HashMap();
        attestationIdsWithLimit.put(KeyManagerConst.ATTEST_UDID, new Pair(Integer.valueOf(Tag.ATTESTATION_UDID), 128));
        attestationIdsWithLimit.put(KeyManagerConst.ATTEST_PRDID, new Pair(Integer.valueOf(Tag.ATTESTATION_RPDID), 128));
        attestationIdsWithLimit.put(KeyManagerConst.ATTEST_PRUID, new Pair(Integer.valueOf(Tag.ATTESTATION_RPUID), 128));
        attestationIdsWithLimit.put(KeyManagerConst.ATTEST_APPID, new Pair(Integer.valueOf(Tag.ATTESTATION_APPID), 128));
        attestationIdsWithLimit.put(KeyManagerConst.ATTEST_CUSTOM_INFO, new Pair(Integer.valueOf(Tag.ATTESTATION_CUSTOM_INFO), 1024));
    }

    public static KeyParameter makeEnum(int tag, int v) {
        int type = getTagType(tag);
        if (type == 256) goto L6;
        Log.e(TAG, "Not a Enum tag: " + tag);
        return null;
    L6:
        KeyParameter kp = new KeyParameter();
        kp.tag = tag;
        switch(tag) {
            case 257: goto L11;
            case 259: goto L10;
            case 264: goto L9;
            default: goto L8;
        };
    L8:
        Log.e(TAG, "Not a Enum tag: " + tag);
    L12:
        return kp;
    L9:
        kp.value = KeyParameterValue.digest(v);
        goto L12
    L10:
        kp.value = KeyParameterValue.purpose(v);
        goto L12
    L11:
        kp.value = KeyParameterValue.algorithm(v);
        goto L12
    }

    public static KeyParameter makeBool(int tag, boolean v) {
        int type = getTagType(tag);
        if (type == 768) goto L6;
        Log.e(TAG, "Not an bool tag: " + tag);
        return null;
    L6:
        KeyParameter kp = new KeyParameter();
        kp.tag = tag;
        kp.value = KeyParameterValue.boolValue(v);
        return kp;
    }

    public static KeyParameter makeUInt(int tag, int v) {
        int type = getTagType(tag);
        if (type == 512) goto L6;
        Log.e(TAG, "Not an int tag: " + tag);
        return null;
    L6:
        KeyParameter kp = new KeyParameter();
        kp.tag = tag;
        kp.value = KeyParameterValue.length(v);
        return kp;
    }

    public static KeyParameter makeString(int tag, String v) {
        int type = getTagType(tag);
        if (type == 1024) goto L6;
        Log.e(TAG, "Not an string tag: " + tag);
        return null;
    L6:
        KeyParameter kp = new KeyParameter();
        kp.tag = tag;
        switch(tag) {
            case 1028: goto L10;
            case 1125: goto L9;
            case 1126: goto L9;
            case 1127: goto L9;
            case 1128: goto L9;
            case 1223: goto L9;
            default: goto L8;
        };
    L8:
        Log.e(TAG, "Unkown String tag: " + tag);
    L11:
        return kp;
    L9:
        kp.value = KeyParameterValue.attestInfo(v);
        goto L11
    L10:
        kp.value = KeyParameterValue.expiryDate(v);
        goto L11
    }

    public static int toInnerPurpose(int purpose) {
        switch(purpose) {
            case 4: goto L13;
            case 8: goto L11;
            case 32: goto L9;
            case 64: goto L7;
            case 128: goto L5;
            default: goto L3;
        };
    L3:
        Log.e(TAG, "Unknown purpose: " + purpose);
        return KeyManagerErrorCode.KM_INVALID_PURPOSE;
    L5:
        return 8;
    L7:
        return 7;
    L9:
        return 6;
    L11:
        return 4;
    L13:
        return 3;
    }

    public static int[] parsePurpose(int purposes) {
        if (purposes > 0) goto L5;
        Log.e(TAG, "Input purposes is invalid: " + purposes);
        return new int[0];
    L5:
        int bitCount = 0;
        int temp = purposes;
    L6:
        if (temp == 0) goto L11;
        if ((temp & 1) == 0) goto L10;
        bitCount = bitCount + 1;
    L10:
        temp = temp >> 1;
        goto L6
    L11:
        int[] result = new int[bitCount];
        int index = 0;
        int flagValue = 1;
    L12:
        if (purposes == 0) goto L17;
        if ((purposes & 1) == 0) goto L16;
        result[index] = toInnerPurpose(flagValue);
        index = index + 1;
    L16:
        purposes = purposes >> 1;
        flagValue = flagValue << 1;
        goto L12
    L17:
        return result;
    }

    public static int getTagType(int tag) {
        return tag & 3840;
    }

    public static KeyParameter[] parseKeyParameter(Bundle bundle) {
        List<KeyParameter> params = new ArrayList();
        int keyAlgo = 0;
        if (bundle.containsKey(KeyManagerConst.KEY_ALGO) == false) goto L13;
        keyAlgo = bundle.getInt(KeyManagerConst.KEY_ALGO, 0);
        if (keyAlgo != 0) goto L7;
    L10:
        Log.e(TAG, "Unsupported algorithm or missing KEY_ALGO  field!");
        return null;
    L7:
        if (checkValidAlgorithm(keyAlgo) != 0) goto L10;
        params.add(makeEnum(Tag.ALGORITHM, keyAlgo));
    L13:
        if (bundle.containsKey(KeyManagerConst.KEY_LEN) == false) goto L23;
        int keySize = bundle.getInt(KeyManagerConst.KEY_LEN, -1);
        if (keySize != (-1)) goto L17;
    L20:
        Log.e(TAG, "Unsupported key size or missing KEY_LEN  field!");
        return null;
    L17:
        if (checkValidKeySize(keyAlgo, keySize) != 0) goto L20;
        params.add(makeUInt(Tag.KEY_SIZE, keySize));
    L23:
        if (bundle.containsKey(KeyManagerConst.KEY_PURPOSE) == false) goto L39;
        int keyPurpose = bundle.getInt(KeyManagerConst.KEY_PURPOSE, 0);
        if (keyPurpose != 0) goto L27;
    L36:
        Log.e(TAG, "Unsupported purpose or missing KEY_PURPOSE field!");
        return null;
    L27:
        if (checkValidPurpose(keyAlgo, keyPurpose) != 0) goto L36;
        int[] purposes = parsePurpose(keyPurpose);
        if (purposes.length != 0) goto L33;
        Log.e(TAG, "Failed to parse purposes!");
        return null;
    L33:
        int r6 = purposes.length;
        int r7 = 0;
    L34:
        if (r7 >= r6) goto L39;
        int purpose = purposes[r7];
        params.add(makeEnum(Tag.PURPOSE, purpose));
        r7 = r7 + 1;
    L39:
        if (bundle.containsKey(KeyManagerConst.KEY_EXPIRY_DATE) == false) goto L48;
        String expiryDate = bundle.getString(KeyManagerConst.KEY_EXPIRY_DATE, null);
        if (expiryDate == null) goto L48;
        if (isValidDateTime(expiryDate) == true) goto L46;
        Log.e(TAG, "Invalid expiry date format!");
        return null;
    L46:
        params.add(makeString(Tag.EXPIRE_DATE, expiryDate));
    L48:
        if (bundle.containsKey(KeyManagerConst.DEVICE_HEALTH_STATUS_REQUIRED) == false) goto L53;
        boolean devHealthStatusRequired = bundle.getBoolean(KeyManagerConst.DEVICE_HEALTH_STATUS_REQUIRED, false);
        Log.d(TAG, "devHealthStatusRequired: " + devHealthStatusRequired);
        if (devHealthStatusRequired == false) goto L53;
        params.add(makeBool(Tag.DEVICE_HEALTH_STATUS_REQUIRED, devHealthStatusRequired));
    L53:
        if (parseAttestationFields(bundle, params) == true) goto L57;
        Log.e(TAG, "Failed to parse attestation fields");
        return null;
    L57:
        return (KeyParameter[]) params.toArray(new KeyParameter[params.size()]);
    }

    private static boolean parseAttestationFields(Bundle bundle, List<KeyParameter> params) {
        Iterator<Map.Entry<String, Pair<Integer, Integer>>> r0 = attestationIdsWithLimit.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L20;
        Map.Entry<String, Pair<Integer, Integer>> entry = r0.next();
        String key = entry.getKey();
        Pair<Integer, Integer> tagAndLimit = entry.getValue();
        int tag = ((Integer) tagAndLimit.first).intValue();
        int maxLen = ((Integer) tagAndLimit.second).intValue();
        if (bundle.containsKey(key) == false) goto L4;
        String attestIdValue = bundle.getString(key, null);
        if (attestIdValue == null) goto L17;
        if (attestIdValue.isEmpty() == true) goto L17;
        if (attestIdValue.length() > maxLen) goto L14;
        params.add(makeString(tag, attestIdValue));
        goto L4
    L14:
        Log.e(TAG, "Field " + key + " exceeds max length of " + maxLen);
        return false;
    L17:
        Log.e(TAG, "Missing or empty field: " + key);
        return false;
    L20:
        return true;
    }

    public static int checkValidAlgorithm(int algorithm) {
        if (SUPPORTED_ALGORITHM.contains(Integer.valueOf(algorithm)) == true) goto L6;
        Log.e(TAG, "Unsupported algorithm: " + algorithm);
        return -1005;
    L6:
        return 0;
    }

    public static int checkValidKeySize(int algorithm, int keySize) {
        List<Integer> keySizeList = SUPPORTED_ALGORITHM_TO_SIZE.get(Integer.valueOf(algorithm));
        if (keySizeList != null) goto L5;
    L9:
        Log.e(TAG, "Unsupported key size: " + keySize + " bits for algorithm: " + algorithm);
        return KeyManagerErrorCode.KM_INVALID_KEY_SIZE;
    L5:
        if (keySizeList.contains(Integer.valueOf(keySize)) == false) goto L9;
        return 0;
    }

    public static boolean isPurposeSupported(int purpose) {
        if (purpose > 0) goto L6;
        return false;
    L6:
        if ((purpose & SUPPORTED_PURPOSE_MASK) != purpose) goto L9;
        return true;
    L9:
        return false;
    }

    public static int checkValidPurpose(int algorithm, int purpose) {
        if (isPurposeSupported(purpose) == true) goto L6;
        Log.e(TAG, "Input Invalid purpose.");
        return KeyManagerErrorCode.KM_INVALID_PURPOSE;
    L6:
        switch(algorithm) {
            case 2: goto L10;
            default: goto L7;
        };
    L7:
        Log.e(TAG, "Unsupported algorithm: " + algorithm);
        return -1005;
    L10:
        if ((purpose & 0) == 0) goto L13;
        Log.e(TAG, "Unsupported purpose for algorithm " + algorithm);
        return KeyManagerErrorCode.KM_INVALID_PURPOSE;
    L13:
        return 0;
    }

    public static boolean isValidDateTime(String dateTimeStr) {
        if (dateTimeStr != null) goto L5;
        return false;
    L5:
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime.parse(dateTimeStr, formatter);     // Catch: DateTimeParseException -> L9
        return true;
    L9:
        e = move-exception;
        Log.e(TAG, "input Expiry Time is invalid, error:" + e.getMessage());
        return false;
    }

    public static boolean isValidKeyAlias(String keyAlias) {
        if (keyAlias != null) goto L4;
        return false;
    L4:
        if (keyAlias.isEmpty() == false) goto L6;
        return false;
    L6:
        if (keyAlias.length() > 128) goto L13;
        return true;
    L13:
        return false;
    }

    public static boolean isValidChallenge(String challenge) {
        if (challenge != null) goto L4;
        return false;
    L4:
        if (challenge.isEmpty() == false) goto L6;
        return false;
    L6:
        if (challenge.length() > 256) goto L13;
        return true;
    L13:
        return false;
    }

    public static boolean isValidData(byte[] data) {
        if (data != null) goto L4;
    L10:
        Log.e(TAG, "Input data is null or length is invalid!!");
        return false;
    L4:
        if (data.length == 0) goto L10;
        if (data.length > 4096) goto L10;
        return true;
    }

    public static boolean isValidSignature(byte[] signature) {
        if (signature != null) goto L4;
    L10:
        Log.e(TAG, "Input signature is null or length is invalid!!");
        return false;
    L4:
        if (signature.length == 0) goto L10;
        if (signature.length > 512) goto L10;
        return true;
    }

    public static CloudSyncKeyParamsLegacy parseImportSyncKeyParameterLegacy(Bundle bundle) {
        if (bundle != null) goto L5;
        return null;
    L5:
        String alias = bundle.getString(KeyManagerConst.KEY_ALIAS, null);
        String localPriKey = bundle.getString(KeyManagerConst.ECC_PRIVATE_KEY, null);
        String serverPubKey = bundle.getString(KeyManagerConst.ECC_PUBLIC_KEY, null);
        String wrappedSyncKey = bundle.getString(KeyManagerConst.WRAPPED_KEY_DATA, null);
        String additionalData = bundle.getString("aad", null);
        if (isNullOrEmpty(alias) == false) goto L8;
    L18:
        return null;
    L8:
        if (isNullOrEmpty(localPriKey) == true) goto L18;
        if (isNullOrEmpty(serverPubKey) == true) goto L18;
        if (isNullOrEmpty(wrappedSyncKey) == true) goto L18;
        if (isNullOrEmpty(additionalData) == true) goto L18;
        CloudSyncKeyParamsLegacy cloudSyncKeyParams = new CloudSyncKeyParamsLegacy();
        cloudSyncKeyParams.alias = alias;
        cloudSyncKeyParams.localPriKey = localPriKey;
        cloudSyncKeyParams.serverPubKey = serverPubKey;
        cloudSyncKeyParams.wrappedSyncKey = wrappedSyncKey;
        cloudSyncKeyParams.additionalData = additionalData;
        return cloudSyncKeyParams;
    }

    public static CloudSyncKeyParams parseImportSyncKeyParameter(Bundle bundle) {
        if (bundle != null) goto L5;
        return null;
    L5:
        String syncKeyAlias = bundle.getString(KeyManagerConst.KEY_ALIAS, null);
        String serverPubKey = bundle.getString(KeyManagerConst.ECC_PUBLIC_KEY, null);
        String wrappedSyncKey = bundle.getString(KeyManagerConst.WRAPPED_KEY_DATA, null);
        String additionalData = bundle.getString("aad", null);
        String attestKeyAlias = bundle.getString(KeyManagerConst.ATTEST_KEY_ALIAS, null);
        if (isNullOrEmpty(syncKeyAlias) == false) goto L8;
    L18:
        return null;
    L8:
        if (isNullOrEmpty(serverPubKey) == true) goto L18;
        if (isNullOrEmpty(wrappedSyncKey) == true) goto L18;
        if (isNullOrEmpty(additionalData) == true) goto L18;
        if (isNullOrEmpty(attestKeyAlias) == true) goto L18;
        CloudSyncKeyParams cloudSyncKeyParams = new CloudSyncKeyParams();
        cloudSyncKeyParams.syncKeyAlias = syncKeyAlias;
        cloudSyncKeyParams.serverPubKey = serverPubKey;
        cloudSyncKeyParams.wrappedSyncKey = wrappedSyncKey;
        cloudSyncKeyParams.additionalData = additionalData;
        cloudSyncKeyParams.attestKeyAlias = attestKeyAlias;
        return cloudSyncKeyParams;
    }

    public static boolean isNullOrEmpty(String str) {
        if (str != null) goto L4;
    L7:
        return true;
    L4:
        if (str.length() == 0) goto L7;
        return false;
    }

    public static boolean checkBundleForRequiredFields(List<String> requiredFileds, Bundle bundle) {
        Iterator<String> r0 = requiredFileds.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        String filed = r0.next();
        if (bundle.containsKey(filed) == true) goto L4;
        return false;
    L10:
        return true;
    }
}
