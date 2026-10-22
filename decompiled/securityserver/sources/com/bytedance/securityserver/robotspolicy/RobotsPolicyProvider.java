package com.bytedance.securityserver.robotspolicy;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class RobotsPolicyProvider extends ContentProvider {
    private static final int POLICY_DIR = 1;
    private static final String TAG = "RobotsPolicyProvider";
    private static final UriMatcher sUriMatcher = null;
    private RobotsPolicyDbHelper mDbHelper;

    static {
        UriMatcher r0 = new UriMatcher(-1);
        sUriMatcher = r0;
        r0.addURI(RobotsPolicyContract.AUTHORITY, "policy", 1);
    }

    public RobotsPolicyProvider() {
    }

    private void notifyChange(Uri r2, String r3) {
        if (TextUtils.isEmpty(r3) == true) goto L5;
        r2 = r2.buildUpon().appendQueryParameter("package_name", r3).build();
    L5:
        Context r1 = getContext();
        Objects.requireNonNull(r1);
        r1.getContentResolver().notifyChange(r2, null);
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri r3, String r4, String[] r5) {
        if (RobotsPolicyUtils.isRobotsEnbled(getContext()) == false) goto L20;
        RobotsAgentAuthUtils.checkInternalCallerOrThrow();
        SQLiteDatabase r2 = this.mDbHelper.getWritableDatabase();
        if (sUriMatcher.match(r3) != 1) goto L18;
        r2.beginTransaction();
        int r6 = r2.delete("policy", r4, r5);     // Catch: Throwable -> L11
        if (r6 <= 0) goto L13;
        r2.setTransactionSuccessful();     // Catch: Throwable -> L11
    L13:
        r2.endTransaction();
        return r6;
    L11:
        th = move-exception;
        r2.endTransaction();
        throw th;
    L18:
        throw new IllegalArgumentException("Unknown URI: " + r3);
    L20:
        throw new UnsupportedOperationException("Robots policy is disabled");
    }

    @Override // android.content.ContentProvider
    public String getType(@NonNull Uri r1) {
        if (RobotsPolicyUtils.isRobotsEnbled(getContext()) == false) goto L11;
        if (sUriMatcher.match(r1) != 1) goto L8;
        return RobotsPolicyContract.MIME_TYPE_DIR;
    L8:
        return null;
    L11:
        throw new UnsupportedOperationException("Robots policy is disabled");
    }

    @Override // android.content.ContentProvider
    public Uri insert(@NonNull Uri r7, ContentValues r8) {
        if (RobotsPolicyUtils.isRobotsEnbled(getContext()) == false) goto L27;
        RobotsAgentAuthUtils.checkInternalCallerOrThrow();
        if (sUriMatcher.match(r7) != 1) goto L25;
        SQLiteDatabase r0 = this.mDbHelper.getWritableDatabase();
        r0.beginTransaction();
        String r3 = null;
        long r1 = r0.insertWithOnConflict("policy", null, r8, 5);     // Catch: Throwable -> L11
        if (r1 == (-1)) goto L13;
        r0.setTransactionSuccessful();     // Catch: Throwable -> L11
    L13:
        r0.endTransaction();
        if (r1 == (-1)) goto L21;
        if (r8 != null) goto L17;
    L19:
        notifyChange(r7, r3);
        return ContentUris.withAppendedId(r7, r1);
    L17:
        if (r8.containsKey("package_name") == false) goto L19;
        r3 = r8.getAsString("package_name");
        goto L19
    L21:
        return null;
    L11:
        th = move-exception;
        r0.endTransaction();
        throw th;
    L25:
        throw new IllegalArgumentException("Invalid URI for insert: " + r7);
    L27:
        throw new UnsupportedOperationException("Robots policy is disabled");
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.mDbHelper = new RobotsPolicyDbHelper(getContext());
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(@NonNull Uri r10, String[] r11, String r12, String[] r13, String r14) {
        if (RobotsPolicyUtils.isRobotsEnbled(getContext()) == false) goto L23;
        if (RobotsAgentAuthUtils.isInternalCaller() == false) goto L24;
    L14:
        SQLiteDatabase r2 = this.mDbHelper.getReadableDatabase();
        if (sUriMatcher.match(r10) != 1) goto L21;
        SQLiteQueryBuilder r0 = new SQLiteQueryBuilder();
        r0.setTables("policy");
        r0.setStrict(true);
        Cursor r15 = r0.query(r2, r11, r12, r13, null, null, r14);
        if (r15 == null) goto L19;
        Context r9 = getContext();
        Objects.requireNonNull(r9);
        r15.setNotificationUri(r9.getContentResolver(), r10);
    L19:
        return r15;
    L21:
        throw new IllegalArgumentException("Unknown URI: " + r10);
    L24:
    L11:
        e = move-exception;
        throw new SecurityException("Unauthorized agent query: invalid calling package.", e);
    L7:
        if (RobotsAgentAuthUtils.checkAgentAuth(getContext(), getCallingPackage()) == true) goto L14;
        throw new SecurityException("Unauthorized agent query: package or signature mismatch.");     // Catch: PackageManager.NameNotFoundException -> L11
    L23:
        throw new UnsupportedOperationException("Robots policy is disabled");
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri r8, ContentValues r9, String r10, String[] r11) {
        if (RobotsPolicyUtils.isRobotsEnbled(getContext()) == false) goto L47;
        String r12 = getCallingPackage();
        if (r12 == null) goto L45;
        if (r9 != null) goto L9;
    L42:
        Log.w(TAG, "update missing policy JSON");
        throw new IllegalArgumentException("Missing policy JSON for update");
    L9:
        if (r9.containsKey("policy") == false) goto L42;
        String r2 = r9.getAsString("policy");
        if (TextUtils.isEmpty(r2) == false) goto L13;
    L40:
        Log.w(TAG, "update policy JSON is empty or too large");
        throw new IllegalArgumentException("Policy JSON is empty or too large");
    L13:
        if (r2.length() > RobotsPolicyValidator.MAX_POLICY_SIZE) goto L40;
        JSONObject r3 = new JSONObject(r2);     // Catch: Exception -> L34
        if (RobotsPolicyValidator.isInvalidPolicy(r3, r12) == true) goto L36;
        Log.d(TAG, "update policy JSON is valid");     // Catch: Exception -> L34
        int r4 = r3.getInt(RobotsPolicyValidator.KEY_POLICY_VERSION);     // Catch: Exception -> L34
        r9.clear();     // Catch: Exception -> L34
        r9.put("package_name", r12);     // Catch: Exception -> L34
        r9.put("policy", r2);     // Catch: Exception -> L34
        r9.put(RobotsPolicyContract.COL_VERSION, Integer.valueOf(r4));     // Catch: Exception -> L34
        String[] r0 = {r12};
        SQLiteDatabase r5 = this.mDbHelper.getWritableDatabase();
        if (sUriMatcher.match(r8) != 1) goto L33;
        r5.beginTransaction();
        int r13 = r5.update("policy", r9, "package_name=?", r0);     // Catch: Throwable -> L24
        if (r13 <= 0) goto L26;
        r5.setTransactionSuccessful();     // Catch: Throwable -> L24
    L26:
        r5.endTransaction();
        if (r13 <= 0) goto L29;
        notifyChange(r8, r12);
    L29:
        return r13;
    L24:
        th = move-exception;
        r5.endTransaction();
        throw th;
    L33:
        throw new IllegalArgumentException("Unknown URI: " + r8);
    L36:
        Log.w(TAG, "update policy JSON is invalid");     // Catch: Exception -> L34
        throw new SecurityException("Invalid policy format or package name mismatch");     // Catch: Exception -> L34
    L34:
        e = move-exception;
        Log.w(TAG, "update policy JSON is invalid", e);
        throw new IllegalArgumentException("Invalid policy JSON", e);
    L45:
        throw new SecurityException("Access denied: Cannot determine calling package.");
    L47:
        throw new UnsupportedOperationException("Robots policy is disabled");
    }
}
