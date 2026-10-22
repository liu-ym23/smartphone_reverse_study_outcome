package androidx.slice;

import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import androidx.collection.ArrayMap;
import androidx.slice.widget.SliceLiveData;
import java.util.Collection;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
class SliceViewManagerWrapper extends SliceViewManagerBase {
    private final ArrayMap<String, String> mCachedAuthorities;
    private final ArrayMap<String, Boolean> mCachedSuspendFlags;
    private final android.app.slice.SliceManager mManager;
    private final Set<android.app.slice.SliceSpec> mSpecs;

    SliceViewManagerWrapper(Context r2) {
        this(r2, (android.app.slice.SliceManager) r2.getSystemService(android.app.slice.SliceManager.class));
    }

    SliceViewManagerWrapper(Context r1, android.app.slice.SliceManager r2) {
        super(r1);
        this.mCachedSuspendFlags = new ArrayMap();
        this.mCachedAuthorities = new ArrayMap();
        this.mManager = r2;
        this.mSpecs = SliceConvert.unwrap(SliceLiveData.SUPPORTED_SPECS);
    }

    @Override // androidx.slice.SliceViewManager
    public void pinSlice(Uri r2) {
        this.mManager.pinSlice(r2, this.mSpecs);
    }

    @Override // androidx.slice.SliceViewManager
    public void unpinSlice(Uri r2) {
        if (this.mManager.getPinnedSlices().contains(r2) == false) goto L6;
        this.mManager.unpinSlice(r2);
        return;
    }

    @Override // androidx.slice.SliceViewManager
    public Slice bindSlice(Uri r3) {
        if (isAuthoritySuspended(r3.getAuthority()) == false) goto L7;
        return null;
    L7:
        return SliceConvert.wrap(this.mManager.bindSlice(r3, this.mSpecs), this.mContext);
    }

    @Override // androidx.slice.SliceViewManager
    public Slice bindSlice(Intent r3) {
        if (isPackageSuspended(r3) == false) goto L7;
        return null;
    L7:
        return SliceConvert.wrap(this.mManager.bindSlice(r3, this.mSpecs), this.mContext);
    }

    private boolean isPackageSuspended(Intent r2) {
        if (r2.getComponent() == null) goto L7;
        return isPackageSuspended(r2.getComponent().getPackageName());
    L7:
        if (r2.getPackage() == null) goto L11;
        return isPackageSuspended(r2.getPackage());
    L11:
        if (r2.getData() != null) goto L13;
        return false;
    L13:
        return isAuthoritySuspended(r2.getData().getAuthority());
    }

    private boolean isAuthoritySuspended(String r3) {
        String r0 = this.mCachedAuthorities.get(r3);
        if (r0 != null) goto L9;
        ProviderInfo r1 = this.mContext.getPackageManager().resolveContentProvider(r3, 0);
        if (r1 != null) goto L7;
        return false;
    L7:
        r0 = r1.packageName;
        this.mCachedAuthorities.put(r3, r0);
    L9:
        return isPackageSuspended(r0);
    }

    private boolean isPackageSuspended(String r4) {
        Boolean r0 = this.mCachedSuspendFlags.get(r4);
        if (r0 != null) goto L13;
    L11:
        return false;
    L6:
        if ((this.mContext.getPackageManager().getApplicationInfo(r4, 0).flags & 1073741824) == 0) goto L8;
        boolean r1 = true;
    L9:
        Boolean r2 = Boolean.valueOf(r1);     // Catch: PackageManager.NameNotFoundException -> L11
        this.mCachedSuspendFlags.put(r4, r2);     // Catch: PackageManager.NameNotFoundException -> L11
        r0 = r2;
        goto L13
    L8:
        r1 = false;
    L13:
        return r0.booleanValue();
    }

    @Override // androidx.slice.SliceViewManager
    public Collection<Uri> getSliceDescendants(Uri r3) {
        return this.mManager.getSliceDescendants(r3);
    L4:
        e = move-exception;
        ContentProviderClient r2 = this.mContext.getContentResolver().acquireContentProviderClient(r3);
        if (r2 == null) goto L8;
        r2.close();
        throw e;
    L8:
        throw new IllegalArgumentException("No provider found for " + r3);
    }

    @Override // androidx.slice.SliceViewManager
    public Uri mapIntentToUri(Intent r1) {
        return this.mManager.mapIntentToUri(r1);
    }
}
