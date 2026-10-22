package androidx.slice;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Process;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import androidx.core.app.CoreComponentFactory;
import androidx.core.graphics.drawable.IconCompat;
import androidx.slice.compat.CompatPermissionManager;
import androidx.slice.compat.SliceProviderCompat;
import androidx.slice.compat.SliceProviderWrapperContainer;
import androidx.slice.core.R;
import com.android.settings.inputmethod.UserDictionaryAddWordContents;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class SliceProvider extends ContentProvider implements CoreComponentFactory.CompatWrapped {
    private static final boolean DEBUG = false;
    private static final String TAG = "SliceProvider";
    private static Clock sClock;
    private static Set<SliceSpec> sSpecs;
    private final String[] mAutoGrantPermissions;
    private SliceProviderCompat mCompat;
    private List<Uri> mPinnedSliceUris;

    @Override // android.content.ContentProvider
    public final int bulkInsert(Uri r1, ContentValues[] r2) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public final Uri canonicalize(Uri r1) {
        return null;
    }

    @Override // android.content.ContentProvider
    public final int delete(Uri r1, String r2, String[] r3) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri r1) {
        return "vnd.android.slice";
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri r1, ContentValues r2) {
        return null;
    }

    public abstract Slice onBindSlice(Uri r1);

    public abstract boolean onCreateSliceProvider();

    public void onSlicePinned(Uri r1) {
    }

    public void onSliceUnpinned(Uri r1) {
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri r1, String[] r2, Bundle r3, CancellationSignal r4) {
        return null;
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri r1, String[] r2, String r3, String[] r4, String r5) {
        return null;
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri r1, String[] r2, String r3, String[] r4, String r5, CancellationSignal r6) {
        return null;
    }

    @Override // android.content.ContentProvider
    public final int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        return 0;
    }

    public SliceProvider(String... r1) {
        this.mAutoGrantPermissions = r1;
    }

    public SliceProvider() {
        this.mAutoGrantPermissions = new String[0];
    }

    @Override // androidx.core.app.CoreComponentFactory.CompatWrapped
    public Object getWrapper() {
        return new SliceProviderWrapperContainer.SliceProviderWrapper(this, this.mAutoGrantPermissions);
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        this.mPinnedSliceUris = new ArrayList(SliceManager.getInstance(getContext()).getPinnedSlices());
        return onCreateSliceProvider();
    }

    protected CompatPermissionManager onCreatePermissionManager(String[] r5) {
        return new CompatPermissionManager(getContext(), SliceProviderCompat.PERMS_PREFIX + getClass().getName(), Process.myUid(), r5);
    }

    @Override // android.content.ContentProvider
    public Bundle call(String r1, String r2, Bundle r3) {
        SliceProviderCompat r0 = this.mCompat;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.call(r1, r2, r3);
    }

    public static Slice createPermissionSlice(Context r8, Uri r9, String r10) {
        PendingIntent r0 = createPermissionIntent(r8, r9, r10);
        Slice.Builder r1 = new Slice.Builder(r9);
        Slice.Builder r2 = new Slice.Builder(r1).addIcon(IconCompat.createWithResource(r8, R.drawable.abc_ic_permission), null, new String[0]).addHints(Arrays.asList(new String[]{"title", UserDictionaryAddWordContents.EXTRA_SHORTCUT})).addAction(r0, new Slice.Builder(r1).build(), null);
        TypedValue r3 = new TypedValue();
        new ContextThemeWrapper(r8, android.R.style.Theme.DeviceDefault.Light).getTheme().resolveAttribute(android.R.attr.colorAccent, r3, true);
        int r4 = r3.data;
        r1.addSubSlice(new Slice.Builder(r9.buildUpon().appendPath(CloudControlInf.PERMISSION).build()).addIcon(IconCompat.createWithResource(r8, R.drawable.abc_ic_arrow_forward), null, new String[0]).addText(getPermissionString(r8, r10), null, new String[0]).addInt(r4, "color", new String[0]).addSubSlice(r2.build(), null).build(), null);
        return r1.addHints(Arrays.asList(new String[]{"permission_request"})).build();
    }

    public static PendingIntent createPermissionIntent(Context r4, Uri r5, String r6) {
        Intent r0 = new Intent();
        r0.setComponent(new ComponentName(r4.getPackageName(), "androidx.slice.compat.SlicePermissionActivity"));
        r0.putExtra("slice_uri", r5);
        r0.putExtra("pkg", r6);
        r0.putExtra(SliceProviderCompat.EXTRA_PROVIDER_PKG, r4.getPackageName());
        r0.setData(r5.buildUpon().appendQueryParameter("package", r6).build());
        return PendingIntent.getActivity(r4, 0, r0, 0);
    }

    public static CharSequence getPermissionString(Context r4, String r5) {
        PackageManager r0 = r4.getPackageManager();
        return r4.getString(R.string.abc_slices_permission_request, new Object[]{r0.getApplicationInfo(r5, 0).loadLabel(r0), r4.getApplicationInfo().loadLabel(r0)});
    L5:
        e = move-exception;
        throw new RuntimeException("Unknown calling app", e);
    }

    public void handleSlicePinned(Uri r2) {
        if (this.mPinnedSliceUris.contains(r2) == true) goto L6;
        this.mPinnedSliceUris.add(r2);
        return;
    }

    public void handleSliceUnpinned(Uri r2) {
        if (this.mPinnedSliceUris.contains(r2) == false) goto L6;
        this.mPinnedSliceUris.remove(r2);
        return;
    }

    public Uri onMapIntentToUri(Intent r1) {
        throw new UnsupportedOperationException("This provider has not implemented intent to uri mapping");
    }

    public Collection<Uri> onGetSliceDescendants(Uri r1) {
        return Collections.emptyList();
    }

    public List<Uri> getPinnedSlices() {
        return this.mPinnedSliceUris;
    }

    public static void setSpecs(Set<SliceSpec> r0) {
        sSpecs = r0;
    }

    public static Set<SliceSpec> getCurrentSpecs() {
        return sSpecs;
    }

    public static void setClock(Clock r0) {
        sClock = r0;
    }

    public static Clock getClock() {
        return sClock;
    }
}
