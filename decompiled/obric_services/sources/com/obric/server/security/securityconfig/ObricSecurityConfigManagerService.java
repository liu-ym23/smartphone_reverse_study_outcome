package com.obric.server.security.securityconfig;

import android.content.Context;
import android.os.Binder;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Slog;
import com.obric.security.securityconfig.IObricSecurityConfigManager;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class ObricSecurityConfigManagerService extends IObricSecurityConfigManager.Stub {
    private static final Set<String> ALLOWED_INT_KEYS = null;
    private static final Set<String> ALLOWED_STRING_KEYS = null;
    private static final String KEY_ROBOTS_ENABLED = "robots_protocol_enabled";
    private static final String KEY_SECURITY_LOG_ENABLED = "security_log_enabled";
    private static final int STATUS_DISABLED = 0;
    private static final int STATUS_ENABLED = 1;
    private static final String TAG = "ObricSecurityConfigService";
    private static final int VALUE_TYPE_INT = 1;
    private static final int VALUE_TYPE_STRING = 0;
    private final Context mContext;

    static {
        ALLOWED_STRING_KEYS = new HashSet();
        ALLOWED_INT_KEYS = new HashSet(Arrays.asList(new String[]{KEY_ROBOTS_ENABLED, KEY_SECURITY_LOG_ENABLED}));
    }

    public ObricSecurityConfigManagerService(Context context) {
        this.mContext = context;
    }

    public int updateConfig(String key, String value) {
        if (TextUtils.isEmpty(key) == true) goto L14;
        if (value == null) goto L14;
        if (value.isEmpty() == true) goto L14;
        if (ALLOWED_STRING_KEYS.contains(key) == true) goto L13;
        Slog.w(TAG, "updateConfig: key not allowed, key=" + key);
        return -5;
    L13:
        return writeToSecureLocked(STATUS_DISABLED, key, value);
    L14:
        Slog.w(TAG, "updateConfig: invalid param, key=" + key);
        return -1;
    }

    public int updateConfigInt(String key, int value) {
        if (TextUtils.isEmpty(key) == false) goto L7;
        Slog.w(TAG, "updateConfigInt: invalid param, key=" + key);
        return -1;
    L7:
        if (ALLOWED_INT_KEYS.contains(key) == true) goto L11;
        Slog.w(TAG, "updateConfigInt: key not allowed, key=" + key);
        return -5;
    L11:
        if (KEY_ROBOTS_ENABLED.equals(key) == false) goto L13;
    L14:
        if (value == 1) goto L19;
        if (value == 0) goto L19;
        Slog.w(TAG, "updateConfigInt: invalid int value, key=" + key + ", value=" + value);
        return -1;
    L19:
        return writeToSecureLocked(1, key, Integer.valueOf(value));
    L13:
        if (KEY_SECURITY_LOG_ENABLED.equals(key) == false) goto L19;
        goto L14
    }

    private int writeToSecureLocked(int valueType, String key, Object value) {
        if (valueType == 1) goto L6;
        if (valueType == 0) goto L6;
        return -1;
    L6:
        long token = Binder.clearCallingIdentity();
        if (valueType != 1) goto L14;
        if ((value instanceof Integer) == true) goto L12;
        Binder.restoreCallingIdentity(token);
        return -1;
    L12:
        boolean success = Settings.Secure.putInt(this.mContext.getContentResolver(), key, ((Integer) value).intValue());     // Catch: Throwable -> L26
    L19:
        if (success == true) goto L23;
        Slog.e(TAG, "write failed, type=" + valueType + ", key=" + key);     // Catch: Throwable -> L26
        Binder.restoreCallingIdentity(token);
        return -3;
    L23:
        Slog.d(TAG, "write success, type=" + valueType + ", key=" + key + ", value=" + value);     // Catch: Throwable -> L26
        Binder.restoreCallingIdentity(token);
        return STATUS_DISABLED;
    L14:
        if ((value instanceof String) == true) goto L17;
        Binder.restoreCallingIdentity(token);
        return -1;
    L17:
        success = Settings.Secure.putString(this.mContext.getContentResolver(), key, (String) value);     // Catch: Throwable -> L26
    L26:
        t = move-exception;
        Slog.e(TAG, "unexpected error, type=" + valueType, t);     // Catch: Throwable -> L30
        Binder.restoreCallingIdentity(token);
        return -100;
    L30:
        t = move-exception;
        Binder.restoreCallingIdentity(token);
        throw t;
    }
}
