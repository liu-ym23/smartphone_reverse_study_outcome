package androidx.slice;

import android.content.Context;
import android.net.Uri;
import android.os.Process;
import android.os.UserHandle;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
class SliceManagerWrapper extends SliceManager {
    private final Context mContext;
    private final android.app.slice.SliceManager mManager;

    SliceManagerWrapper(Context r2) {
        this(r2, (android.app.slice.SliceManager) r2.getSystemService(android.app.slice.SliceManager.class));
    }

    SliceManagerWrapper(Context r1, android.app.slice.SliceManager r2) {
        this.mContext = r1;
        this.mManager = r2;
    }

    @Override // androidx.slice.SliceManager
    public Set<SliceSpec> getPinnedSpecs(Uri r1) {
        return SliceConvert.wrap(this.mManager.getPinnedSpecs(r1));
    }

    @Override // androidx.slice.SliceManager
    public int checkSlicePermission(Uri r1, int r2, int r3) {
        return this.mManager.checkSlicePermission(r1, r2, r3);
    }

    @Override // androidx.slice.SliceManager
    public void grantSlicePermission(String r1, Uri r2) {
        this.mManager.grantSlicePermission(r1, r2);
    }

    @Override // androidx.slice.SliceManager
    public void revokeSlicePermission(String r1, Uri r2) {
        this.mManager.revokeSlicePermission(r1, r2);
    }

    @Override // androidx.slice.SliceManager
    public List<Uri> getPinnedSlices() {
        return this.mManager.getPinnedSlices();
    }

    private Uri maybeAddCurrentUserId(Uri r4) {
        if (r4 != null) goto L4;
    L8:
        return r4;
    L4:
        if (r4.getAuthority().contains("@") == true) goto L8;
        return r4.buildUpon().encodedAuthority(getCurrentUserId() + "@" + r4.getAuthority()).build();
    }

    private int getCurrentUserId() {
        UserHandle r4 = Process.myUserHandle();
        return ((Integer) r4.getClass().getDeclaredMethod("getIdentifier", new Class[0]).invoke(r4, new Object[0])).intValue();
    L5:
        return 0;
    }
}
