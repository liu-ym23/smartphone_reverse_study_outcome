package androidx.slice.compat;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import androidx.collection.ArraySet;
import androidx.core.util.Preconditions;
import androidx.slice.Slice;
import androidx.slice.SliceProvider;
import androidx.slice.SliceSpec;
import androidx.slice.core.SliceHints;
import androidx.versionedparcelable.ParcelUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class SliceProviderCompat {
    private static final String ALL_FILES = "slice_data_all_slice_files";
    public static final String ARG_SUPPORTS_VERSIONED_PARCELABLE = "supports_versioned_parcelable";
    private static final String DATA_PREFIX = "slice_data_";
    public static final String EXTRA_BIND_URI = "slice_uri";
    public static final String EXTRA_INTENT = "slice_intent";
    public static final String EXTRA_PID = "pid";
    public static final String EXTRA_PKG = "pkg";
    public static final String EXTRA_PROVIDER_PKG = "provider_pkg";
    public static final String EXTRA_RESULT = "result";
    public static final String EXTRA_SLICE = "slice";
    public static final String EXTRA_SLICE_DESCENDANTS = "slice_descendants";
    public static final String EXTRA_SUPPORTED_SPECS = "specs";
    public static final String EXTRA_SUPPORTED_SPECS_REVS = "revs";
    public static final String EXTRA_UID = "uid";
    public static final String METHOD_CHECK_PERMISSION = "check_perms";
    public static final String METHOD_GET_DESCENDANTS = "get_descendants";
    public static final String METHOD_GET_PINNED_SPECS = "get_specs";
    public static final String METHOD_GRANT_PERMISSION = "grant_perms";
    public static final String METHOD_MAP_INTENT = "map_slice";
    public static final String METHOD_MAP_ONLY_INTENT = "map_only";
    public static final String METHOD_PIN = "pin_slice";
    public static final String METHOD_REVOKE_PERMISSION = "revoke_perms";
    public static final String METHOD_SLICE = "bind_slice";
    public static final String METHOD_UNPIN = "unpin_slice";
    public static final String PERMS_PREFIX = "slice_perms_";
    private static final long SLICE_BIND_ANR = 2000;
    private static final String TAG = "SliceProviderCompat";
    private final Runnable mAnr;
    String mCallback;
    private final Context mContext;
    private final Handler mHandler;
    private CompatPermissionManager mPermissionManager;
    private CompatPinnedList mPinnedList;
    private final SliceProvider mProvider;

    private static class ProviderHolder implements AutoCloseable {
        final ContentProviderClient mProvider;

        ProviderHolder(ContentProviderClient r1) {
            this.mProvider = r1;
        }

        @Override // java.lang.AutoCloseable
        public void close() {
            if (this.mProvider != null) goto L5;
            return;
        L5:
            this.mProvider.close();
        }
    }

    public SliceProviderCompat(SliceProvider r5, CompatPermissionManager r6, Context r7) {
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mAnr = new AnonymousClass1(this);
        this.mProvider = r5;
        this.mContext = r7;
        String r8 = DATA_PREFIX + getClass().getName();
        SharedPreferences r0 = r7.getSharedPreferences(ALL_FILES, 0);
        Set<String> r2 = r0.getStringSet(ALL_FILES, Collections.emptySet());
        if (r2.contains(r8) == true) goto L5;
        ArraySet r3 = new ArraySet(r2);
        r3.add(r8);
        r0.edit().putStringSet(ALL_FILES, r3).commit();
    L5:
        this.mPinnedList = new CompatPinnedList(r7, r8);
        this.mPermissionManager = r6;
    }

    private Context getContext() {
        return this.mContext;
    }

    public String getCallingPackage() {
        return this.mProvider.getCallingPackage();
    }

    public Bundle call(String r7, String r8, Bundle r9) {
        Parcelable r3 = null;
        if (r7.equals(METHOD_SLICE) == false) goto L14;
        Slice r6 = handleBindSlice((Uri) r9.getParcelable("slice_uri"), getSpecs(r9), getCallingPackage());
        Bundle r10 = new Bundle();
        if (ARG_SUPPORTS_VERSIONED_PARCELABLE.equals(r8) == false) goto L9;
        if (r6 == null) goto L8;
        r3 = ParcelUtils.toParcelable(r6);
    L8:
        r10.putParcelable("slice", r3);
    L12:
        return r10;
    L9:
        if (r6 == null) goto L11;
        r3 = r6.toBundle();
    L11:
        r10.putParcelable("slice", r3);
        goto L12
    L14:
        if (r7.equals(METHOD_MAP_INTENT) == false) goto L28;
        Uri r11 = this.mProvider.onMapIntentToUri((Intent) r9.getParcelable(EXTRA_INTENT));
        Bundle r0 = new Bundle();
        if (r11 == null) goto L25;
        Slice r12 = handleBindSlice(r11, getSpecs(r9), getCallingPackage());
        if (ARG_SUPPORTS_VERSIONED_PARCELABLE.equals(r8) == false) goto L22;
        if (r12 == null) goto L21;
        r3 = ParcelUtils.toParcelable(r12);
    L21:
        r0.putParcelable("slice", r3);
    L26:
        return r0;
    L22:
        if (r12 == null) goto L24;
        r3 = r12.toBundle();
    L24:
        r0.putParcelable("slice", r3);
        goto L26
    L25:
        r0.putParcelable("slice", null);
        goto L26
    L28:
        if (r7.equals(METHOD_MAP_ONLY_INTENT) == false) goto L32;
        Uri r13 = this.mProvider.onMapIntentToUri((Intent) r9.getParcelable(EXTRA_INTENT));
        Bundle r14 = new Bundle();
        r14.putParcelable("slice", r13);
        return r14;
    L32:
        if (r7.equals(METHOD_PIN) == false) goto L38;
        Uri r15 = (Uri) r9.getParcelable("slice_uri");
        Set<SliceSpec> r16 = getSpecs(r9);
        if (this.mPinnedList.addPin(r15, r9.getString("pkg"), r16) == false) goto L36;
        handleSlicePinned(r15);
    L36:
        return null;
    L38:
        if (r7.equals(METHOD_UNPIN) == false) goto L44;
        Uri r17 = (Uri) r9.getParcelable("slice_uri");
        if (this.mPinnedList.removePin(r17, r9.getString("pkg")) == false) goto L42;
        handleSliceUnpinned(r17);
    L42:
        return null;
    L44:
        if (r7.equals(METHOD_GET_PINNED_SPECS) == false) goto L52;
        Uri r18 = (Uri) r9.getParcelable("slice_uri");
        Bundle r19 = new Bundle();
        ArraySet<SliceSpec> r20 = this.mPinnedList.getSpecs(r18);
        if (r20.size() == 0) goto L50;
        addSpecs(r19, r20);
        return r19;
    L50:
        throw new IllegalStateException(r18 + " is not pinned");
    L52:
        if (r7.equals(METHOD_GET_DESCENDANTS) == false) goto L56;
        Uri r21 = (Uri) r9.getParcelable("slice_uri");
        Bundle r22 = new Bundle();
        r22.putParcelableArrayList(EXTRA_SLICE_DESCENDANTS, new ArrayList(handleGetDescendants(r21)));
        return r22;
    L56:
        if (r7.equals(METHOD_CHECK_PERMISSION) == false) goto L60;
        Uri r23 = (Uri) r9.getParcelable("slice_uri");
        r9.getString("pkg");
        int r24 = r9.getInt(EXTRA_PID);
        int r25 = r9.getInt("uid");
        Bundle r1 = new Bundle();
        r1.putInt("result", this.mPermissionManager.checkSlicePermission(r23, r24, r25));
        return r1;
    L60:
        if (r7.equals(METHOD_GRANT_PERMISSION) == false) goto L67;
        Uri r26 = (Uri) r9.getParcelable("slice_uri");
        String r27 = r9.getString("pkg");
        if (Binder.getCallingUid() != Process.myUid()) goto L65;
        this.mPermissionManager.grantSlicePermission(r26, r27);
    L73:
        return null;
    L65:
        throw new SecurityException("Only the owning process can manage slice permissions");
    L67:
        if (r7.equals(METHOD_REVOKE_PERMISSION) == false) goto L73;
        Uri r28 = (Uri) r9.getParcelable("slice_uri");
        String r29 = r9.getString("pkg");
        if (Binder.getCallingUid() != Process.myUid()) goto L72;
        this.mPermissionManager.revokeSlicePermission(r28, r29);
        goto L73
    L72:
        throw new SecurityException("Only the owning process can manage slice permissions");
    }

    private Collection<Uri> handleGetDescendants(Uri r2) {
        this.mCallback = "onGetSliceDescendants";
        return this.mProvider.onGetSliceDescendants(r2);
    }

    private void handleSlicePinned(Uri r5) {
        this.mCallback = "onSlicePinned";
        this.mHandler.postDelayed(this.mAnr, SLICE_BIND_ANR);
        this.mProvider.onSlicePinned(r5);     // Catch: Throwable -> L6
        this.mProvider.handleSlicePinned(r5);     // Catch: Throwable -> L6
        this.mHandler.removeCallbacks(this.mAnr);
        return;
    L6:
        th = move-exception;
        this.mHandler.removeCallbacks(this.mAnr);
        throw th;
    }

    private void handleSliceUnpinned(Uri r5) {
        this.mCallback = "onSliceUnpinned";
        this.mHandler.postDelayed(this.mAnr, SLICE_BIND_ANR);
        this.mProvider.onSliceUnpinned(r5);     // Catch: Throwable -> L6
        this.mProvider.handleSliceUnpinned(r5);     // Catch: Throwable -> L6
        this.mHandler.removeCallbacks(this.mAnr);
        return;
    L6:
        th = move-exception;
        this.mHandler.removeCallbacks(this.mAnr);
        throw th;
    }

    private Slice handleBindSlice(Uri r4, Set<SliceSpec> r5, String r6) {
        if (r6 != null) goto L6;
        r6 = getContext().getPackageManager().getNameForUid(Binder.getCallingUid());
    L6:
        if (this.mPermissionManager.checkSlicePermission(r4, Binder.getCallingPid(), Binder.getCallingUid()) == 0) goto L10;
        return SliceProvider.createPermissionSlice(getContext(), r4, r6);
    L10:
        return onBindSliceStrict(r4, r5);
    }

    private Slice onBindSliceStrict(Uri r7, Set<SliceSpec> r8) {
        StrictMode.ThreadPolicy r1 = StrictMode.getThreadPolicy();
        this.mCallback = "onBindSlice";
        this.mHandler.postDelayed(this.mAnr, SLICE_BIND_ANR);
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectAll().penaltyDeath().build());     // Catch: Throwable -> L18
        SliceProvider.setSpecs(r8);     // Catch: Throwable -> L18
        Slice r9 = this.mProvider.onBindSlice(r7);     // Catch: Throwable -> L9 Exception -> L11
        SliceProvider.setSpecs(null);     // Catch: Throwable -> L18
        this.mHandler.removeCallbacks(this.mAnr);     // Catch: Throwable -> L18
        StrictMode.setThreadPolicy(r1);
        return r9;
    L11:
        e = move-exception;
        Log.wtf(TAG, "Slice with URI " + r7.toString() + " is invalid.", e);     // Catch: Throwable -> L9
        SliceProvider.setSpecs(null);     // Catch: Throwable -> L18
        this.mHandler.removeCallbacks(this.mAnr);     // Catch: Throwable -> L18
        StrictMode.setThreadPolicy(r1);
        return null;
    L9:
        th = move-exception;
        SliceProvider.setSpecs(null);     // Catch: Throwable -> L18
        this.mHandler.removeCallbacks(this.mAnr);     // Catch: Throwable -> L18
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        StrictMode.setThreadPolicy(r1);
        throw th;
    }

    public static Slice bindSlice(Context r3, Uri r4, Set<SliceSpec> r5) {
        ProviderHolder r6 = acquireClient(r3.getContentResolver(), r4);
        if (r6.mProvider == null) goto L24;
        Bundle r1 = new Bundle();     // Catch: Throwable -> L17 RemoteException -> L19
        r1.putParcelable("slice_uri", r4);     // Catch: Throwable -> L17 RemoteException -> L19
        addSpecs(r1, r5);     // Catch: Throwable -> L17 RemoteException -> L19
        Bundle r7 = r6.mProvider.call(METHOD_SLICE, ARG_SUPPORTS_VERSIONED_PARCELABLE, r1);     // Catch: Throwable -> L17 RemoteException -> L19
        if (r7 != null) goto L8;
        return null;
    L8:
        r7.setClassLoader(SliceProviderCompat.class.getClassLoader());     // Catch: Throwable -> L17 RemoteException -> L19
        Parcelable r8 = r7.getParcelable("slice");     // Catch: Throwable -> L17 RemoteException -> L19
        if (r8 != null) goto L12;
        return null;
    L12:
        if ((r8 instanceof Bundle) == false) goto L16;
        return new Slice((Bundle) r8);
    L16:
        return (Slice) ParcelUtils.fromParcelable(r8);
    L19:
        e = move-exception;
        Log.e(TAG, "Unable to bind slice", e);     // Catch: Throwable -> L17
        return null;
    L17:
        th = move-exception;
        throw th;
    L24:
        throw new IllegalArgumentException("Unknown URI " + r4);
    }

    public static void addSpecs(Bundle r4, Set<SliceSpec> r5) {
        ArrayList<String> r0 = new ArrayList();
        ArrayList<Integer> r1 = new ArrayList();
        Iterator<SliceSpec> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        SliceSpec r2 = r6.next();
        r0.add(r2.getType());
        r1.add(Integer.valueOf(r2.getRevision()));
        goto L4
    L6:
        r4.putStringArrayList(EXTRA_SUPPORTED_SPECS, r0);
        r4.putIntegerArrayList(EXTRA_SUPPORTED_SPECS_REVS, r1);
    }

    public static Set<SliceSpec> getSpecs(Bundle r6) {
        ArraySet r0 = new ArraySet();
        ArrayList<String> r1 = r6.getStringArrayList(EXTRA_SUPPORTED_SPECS);
        ArrayList<Integer> r7 = r6.getIntegerArrayList(EXTRA_SUPPORTED_SPECS_REVS);
        if (r1 == null) goto L9;
        if (r7 == null) goto L9;
        int r2 = 0;
    L7:
        if (r2 >= r1.size()) goto L9;
        r0.add(new SliceSpec(r1.get(r2), r7.get(r2).intValue()));
        r2 = r2 + 1;
    L9:
        return r0;
    }

    public static Slice bindSlice(Context r5, Intent r6, Set<SliceSpec> r7) {
        Preconditions.checkNotNull(r6, "intent");
        if (r6.getComponent() == null) goto L5;
    L10:
        boolean r0 = true;
    L11:
        Preconditions.checkArgument(r0, String.format("Slice intent must be explicit %s", new Object[]{r6}));
        ContentResolver r1 = r5.getContentResolver();
        Uri r2 = r6.getData();
        if (r2 != null) goto L14;
    L17:
        Intent r3 = new Intent(r6);
        if (r3.hasCategory("android.app.slice.category.SLICE") == true) goto L20;
        r3.addCategory("android.app.slice.category.SLICE");
    L20:
        List<ResolveInfo> r4 = r5.getPackageManager().queryIntentContentProviders(r3, 0);
        if (r4 != null) goto L23;
    L44:
        ResolveInfo r8 = r5.getPackageManager().resolveActivity(r6, 128);
        if (r8 != null) goto L47;
    L54:
        return null;
    L47:
        if (r8.activityInfo == null) goto L54;
        if (r8.activityInfo.metaData == null) goto L54;
        if (r8.activityInfo.metaData.containsKey(SliceHints.SLICE_METADATA_KEY) == false) goto L54;
        return bindSlice(r5, Uri.parse(r8.activityInfo.metaData.getString(SliceHints.SLICE_METADATA_KEY)), r7);
    L23:
        if (r4.isEmpty() == true) goto L44;
        Uri r9 = new Uri.Builder().scheme("content").authority(r4.get(0).providerInfo.authority).build();
        ProviderHolder r10 = acquireClient(r1, r9);
        if (r10.mProvider == null) goto L43;
        Bundle r11 = new Bundle();     // Catch: RemoteException -> L39
        r11.putParcelable(EXTRA_INTENT, r6);     // Catch: RemoteException -> L39
        addSpecs(r11, r7);     // Catch: RemoteException -> L39
        Bundle r12 = r10.mProvider.call(METHOD_MAP_INTENT, ARG_SUPPORTS_VERSIONED_PARCELABLE, r11);     // Catch: RemoteException -> L39
        if (r12 != null) goto L30;
        return null;
    L30:
        r12.setClassLoader(SliceProviderCompat.class.getClassLoader());     // Catch: RemoteException -> L39
        Parcelable r13 = r12.getParcelable("slice");     // Catch: RemoteException -> L39
        if (r13 != null) goto L34;
        return null;
    L34:
        if ((r13 instanceof Bundle) == false) goto L38;
        return new Slice((Bundle) r13);
    L38:
        return (Slice) ParcelUtils.fromParcelable(r13);
    L39:
        e = move-exception;
        Log.e(TAG, "Unable to bind slice", e);
        return null;
    L43:
        throw new IllegalArgumentException("Unknown URI " + r9);
    L14:
        if ("vnd.android.slice".equals(r1.getType(r2)) == false) goto L17;
        return bindSlice(r5, r2, r7);
    L5:
        if (r6.getPackage() != null) goto L10;
        if (r6.getData() != null) goto L10;
        r0 = false;
        goto L11
    }

    public static void pinSlice(Context r3, Uri r4, Set<SliceSpec> r5) {
        ProviderHolder r0 = acquireClient(r3.getContentResolver(), r4);
        if (r0.mProvider == null) goto L10;
        Bundle r1 = new Bundle();     // Catch: RemoteException -> L6
        r1.putParcelable("slice_uri", r4);     // Catch: RemoteException -> L6
        r1.putString("pkg", r3.getPackageName());     // Catch: RemoteException -> L6
        addSpecs(r1, r5);     // Catch: RemoteException -> L6
        r0.mProvider.call(METHOD_PIN, ARG_SUPPORTS_VERSIONED_PARCELABLE, r1);     // Catch: RemoteException -> L6
        return;
    L6:
        e = move-exception;
        Log.e(TAG, "Unable to pin slice", e);
        return;
    L10:
        throw new IllegalArgumentException("Unknown URI " + r4);
    }

    public static void unpinSlice(Context r3, Uri r4, Set<SliceSpec> r5) {
        if (getPinnedSlices(r3).contains(r4) == false) goto L12;
        ProviderHolder r0 = acquireClient(r3.getContentResolver(), r4);
        if (r0.mProvider == null) goto L11;
        Bundle r1 = new Bundle();     // Catch: RemoteException -> L8
        r1.putParcelable("slice_uri", r4);     // Catch: RemoteException -> L8
        r1.putString("pkg", r3.getPackageName());     // Catch: RemoteException -> L8
        addSpecs(r1, r5);     // Catch: RemoteException -> L8
        r0.mProvider.call(METHOD_UNPIN, ARG_SUPPORTS_VERSIONED_PARCELABLE, r1);     // Catch: RemoteException -> L8
        return;
    L8:
        e = move-exception;
        Log.e(TAG, "Unable to unpin slice", e);
        return;
    L11:
        throw new IllegalArgumentException("Unknown URI " + r4);
    }

    public static Set<SliceSpec> getPinnedSpecs(Context r2, Uri r3) {
        ProviderHolder r4 = acquireClient(r2.getContentResolver(), r3);
        if (r4.mProvider == null) goto L13;
        Bundle r0 = new Bundle();     // Catch: RemoteException -> L8
        r0.putParcelable("slice_uri", r3);     // Catch: RemoteException -> L8
        Bundle r5 = r4.mProvider.call(METHOD_GET_PINNED_SPECS, ARG_SUPPORTS_VERSIONED_PARCELABLE, r0);     // Catch: RemoteException -> L8
        if (r5 == null) goto L16;
        return getSpecs(r5);
    L16:
        return null;
    L8:
        e = move-exception;
        Log.e(TAG, "Unable to get pinned specs", e);
        return null;
    L13:
        throw new IllegalArgumentException("Unknown URI " + r3);
    }

    public static Uri mapIntentToUri(Context r6, Intent r7) {
        Preconditions.checkNotNull(r7, "intent");
        if (r7.getComponent() == null) goto L5;
    L10:
        boolean r1 = true;
    L11:
        Preconditions.checkArgument(r1, String.format("Slice intent must be explicit %s", new Object[]{r7}));
        ContentResolver r2 = r6.getContentResolver();
        Uri r3 = r7.getData();
        if (r3 != null) goto L14;
    L16:
        Intent r4 = new Intent(r7);
        if (r4.hasCategory("android.app.slice.category.SLICE") == true) goto L19;
        r4.addCategory("android.app.slice.category.SLICE");
    L19:
        List<ResolveInfo> r5 = r6.getPackageManager().queryIntentContentProviders(r4, 0);
        if (r5 != null) goto L22;
    L51:
        ResolveInfo r8 = r6.getPackageManager().resolveActivity(r7, 128);
        if (r8 != null) goto L54;
    L61:
        return null;
    L54:
        if (r8.activityInfo == null) goto L61;
        if (r8.activityInfo.metaData == null) goto L61;
        if (r8.activityInfo.metaData.containsKey(SliceHints.SLICE_METADATA_KEY) == false) goto L61;
        return Uri.parse(r8.activityInfo.metaData.getString(SliceHints.SLICE_METADATA_KEY));
    L22:
        if (r5.isEmpty() == true) goto L51;
        Uri r9 = new Uri.Builder().scheme("content").authority(r5.get(0).providerInfo.authority).build();
        ProviderHolder r10 = acquireClient(r2, r9);     // Catch: RemoteException -> L48
    L39:
        th = move-exception;
        throw th;     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        if (r10 != null) goto L62;
    L47:
        throw th;     // Catch: RemoteException -> L48
    L62:
        r10.close();     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        th.addSuppressed(th);     // Catch: RemoteException -> L48
        goto L47
    L27:
        if (r10.mProvider == null) goto L38;
        Bundle r11 = new Bundle();     // Catch: Throwable -> L39
        r11.putParcelable(EXTRA_INTENT, r7);     // Catch: Throwable -> L39
        Bundle r12 = r10.mProvider.call(METHOD_MAP_ONLY_INTENT, ARG_SUPPORTS_VERSIONED_PARCELABLE, r11);     // Catch: Throwable -> L39
        if (r12 == null) goto L34;
        Uri r13 = (Uri) r12.getParcelable("slice");     // Catch: Throwable -> L39
        if (r10 == null) goto L33;
        r10.close();     // Catch: RemoteException -> L48
    L33:
        return r13;
    L34:
        if (r10 == null) goto L50;
        r10.close();     // Catch: RemoteException -> L48
    L50:
        return null;
    L38:
        throw new IllegalArgumentException("Unknown URI " + r9);     // Catch: Throwable -> L39
    L48:
        e = move-exception;
        Log.e(TAG, "Unable to map slice", e);
        goto L50
    L14:
        if ("vnd.android.slice".equals(r2.getType(r3)) == false) goto L16;
        return r3;
    L5:
        if (r7.getPackage() != null) goto L10;
        if (r7.getData() != null) goto L10;
        r1 = false;
        goto L11
    }

    public static Collection<Uri> getSliceDescendants(Context r3, Uri r4) {
        ProviderHolder r5 = acquireClient(r3.getContentResolver(), r4);     // Catch: RemoteException -> L22
        Bundle r0 = new Bundle();     // Catch: Throwable -> L13
        r0.putParcelable("slice_uri", r4);     // Catch: Throwable -> L13
        Bundle r6 = r5.mProvider.call(METHOD_GET_DESCENDANTS, ARG_SUPPORTS_VERSIONED_PARCELABLE, r0);     // Catch: Throwable -> L13
        if (r6 == null) goto L10;
        ArrayList r7 = r6.getParcelableArrayList(EXTRA_SLICE_DESCENDANTS);     // Catch: Throwable -> L13
        if (r5 == null) goto L9;
        r5.close();     // Catch: RemoteException -> L22
    L9:
        return r7;
    L10:
        if (r5 == null) goto L25;
        r5.close();     // Catch: RemoteException -> L22
    L25:
        return Collections.emptyList();
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        if (r5 != null) goto L31;
    L21:
        throw th;     // Catch: RemoteException -> L22
    L31:
        r5.close();     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        th.addSuppressed(th);     // Catch: RemoteException -> L22
    L22:
        e = move-exception;
        Log.e(TAG, "Unable to get slice descendants", e);
        goto L25
    }

    public static int checkSlicePermission(Context r2, String r3, Uri r4, int r5, int r6) {
        ProviderHolder r7 = acquireClient(r2.getContentResolver(), r4);     // Catch: RemoteException -> L22
        Bundle r0 = new Bundle();     // Catch: Throwable -> L13
        r0.putParcelable("slice_uri", r4);     // Catch: Throwable -> L13
        r0.putString("pkg", r3);     // Catch: Throwable -> L13
        r0.putInt(EXTRA_PID, r5);     // Catch: Throwable -> L13
        r0.putInt("uid", r6);     // Catch: Throwable -> L13
        Bundle r8 = r7.mProvider.call(METHOD_CHECK_PERMISSION, ARG_SUPPORTS_VERSIONED_PARCELABLE, r0);     // Catch: Throwable -> L13
        if (r8 == null) goto L10;
        int r9 = r8.getInt("result");     // Catch: Throwable -> L13
        if (r7 == null) goto L9;
        r7.close();     // Catch: RemoteException -> L22
    L9:
        return r9;
    L10:
        if (r7 == null) goto L33;
        r7.close();     // Catch: RemoteException -> L22
        return -1;
    L33:
        return -1;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        if (r7 != null) goto L31;
    L21:
        throw th;     // Catch: RemoteException -> L22
    L31:
        r7.close();     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        th.addSuppressed(th);     // Catch: RemoteException -> L22
    L22:
        e = move-exception;
        Log.e(TAG, "Unable to check slice permission", e);
        return -1;
    }

    public static void grantSlicePermission(Context r2, String r3, String r4, Uri r5) {
        ProviderHolder r6 = acquireClient(r2.getContentResolver(), r5);     // Catch: RemoteException -> L17
        Bundle r0 = new Bundle();     // Catch: Throwable -> L8
        r0.putParcelable("slice_uri", r5);     // Catch: Throwable -> L8
        r0.putString(EXTRA_PROVIDER_PKG, r3);     // Catch: Throwable -> L8
        r0.putString("pkg", r4);     // Catch: Throwable -> L8
        r6.mProvider.call(METHOD_GRANT_PERMISSION, ARG_SUPPORTS_VERSIONED_PARCELABLE, r0);     // Catch: Throwable -> L8
        if (r6 == null) goto L27;
        r6.close();     // Catch: RemoteException -> L17
        return;
    L27:
        return;
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        if (r6 != null) goto L20;
    L16:
        throw th;     // Catch: RemoteException -> L17
    L20:
        r6.close();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        th.addSuppressed(th);     // Catch: RemoteException -> L17
    L17:
        e = move-exception;
        Log.e(TAG, "Unable to get slice descendants", e);
    }

    public static void revokeSlicePermission(Context r2, String r3, String r4, Uri r5) {
        ProviderHolder r6 = acquireClient(r2.getContentResolver(), r5);     // Catch: RemoteException -> L17
        Bundle r0 = new Bundle();     // Catch: Throwable -> L8
        r0.putParcelable("slice_uri", r5);     // Catch: Throwable -> L8
        r0.putString(EXTRA_PROVIDER_PKG, r3);     // Catch: Throwable -> L8
        r0.putString("pkg", r4);     // Catch: Throwable -> L8
        r6.mProvider.call(METHOD_REVOKE_PERMISSION, ARG_SUPPORTS_VERSIONED_PARCELABLE, r0);     // Catch: Throwable -> L8
        if (r6 == null) goto L27;
        r6.close();     // Catch: RemoteException -> L17
        return;
    L27:
        return;
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        if (r6 != null) goto L20;
    L16:
        throw th;     // Catch: RemoteException -> L17
    L20:
        r6.close();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        th.addSuppressed(th);     // Catch: RemoteException -> L17
    L17:
        e = move-exception;
        Log.e(TAG, "Unable to get slice descendants", e);
    }

    public static List<Uri> getPinnedSlices(Context r4) {
        ArrayList r0 = new ArrayList();
        Iterator<String> r1 = r4.getSharedPreferences(ALL_FILES, 0).getStringSet(ALL_FILES, Collections.emptySet()).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.addAll(new CompatPinnedList(r4, r1.next()).getPinnedSlices());
        goto L4
    L6:
        return r0;
    }

    private static ProviderHolder acquireClient(ContentResolver r2, Uri r3) {
        ContentProviderClient r4 = r2.acquireUnstableContentProviderClient(r3);
        if (r4 == null) goto L7;
        return new ProviderHolder(r4);
    L7:
        throw new IllegalArgumentException("No provider found for " + r3);
    }
}
