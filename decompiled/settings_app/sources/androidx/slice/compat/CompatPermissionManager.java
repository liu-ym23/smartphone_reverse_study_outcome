package androidx.slice.compat;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import androidx.collection.ArraySet;
import com.bytedance.librarian.LibrarianImpl;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class CompatPermissionManager {
    public static final String ALL_SUFFIX = "_all";
    private static final String TAG = "CompatPermissionManager";
    private final String[] mAutoGrantPermissions;
    private final Context mContext;
    private final int mMyUid;
    private final String mPrefsName;

    public static class PermissionState {
        private final String mKey;
        private final ArraySet<String[]> mPaths;

        PermissionState(Set<String> r2, String r3, boolean r4) {
            ArraySet<String[]> r0 = new ArraySet();
            this.mPaths = r0;
            if (r4 == false) goto L5;
            r0.add(new String[0]);
        L9:
            this.mKey = r3;
            return;
        L5:
            Iterator<String> r5 = r2.iterator();
        L7:
            if (r5.hasNext() == false) goto L9;
            String r6 = r5.next();
            this.mPaths.add(decodeSegments(r6));
            goto L7
        }

        public boolean hasAllPermissions() {
            return hasAccess(Collections.emptyList());
        }

        public String getKey() {
            return this.mKey;
        }

        public Set<String> toPersistable() {
            ArraySet r0 = new ArraySet();
            Iterator<String[]> r1 = this.mPaths.iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            r0.add(encodeSegments(r1.next()));
            goto L4
        L6:
            return r0;
        }

        public boolean hasAccess(List<String> r3) {
            String[] r4 = (String[]) r3.toArray(new String[r3.size()]);
            Iterator<String[]> r0 = this.mPaths.iterator();
        L4:
            if (r0.hasNext() == false) goto L9;
            if (isPathPrefixMatch(r0.next(), r4) == false) goto L4;
            return true;
        L9:
            return false;
        }

        boolean addPath(List<String> r5) {
            String[] r6 = (String[]) r5.toArray(new String[r5.size()]);
            int r0 = this.mPaths.size() - 1;
        L3:
            if (r0 < 0) goto L12;
            String[] r2 = this.mPaths.valueAt(r0);
            if (isPathPrefixMatch(r2, r6) == true) goto L6;
            if (isPathPrefixMatch(r6, r2) == false) goto L11;
            this.mPaths.removeAt(r0);
        L11:
            r0 = r0 - 1;
            goto L3
        L6:
            return false;
        L12:
            this.mPaths.add(r6);
            return true;
        }

        boolean removePath(List<String> r5) {
            String[] r6 = (String[]) r5.toArray(new String[r5.size()]);
            int r0 = this.mPaths.size() - 1;
            boolean r2 = false;
        L3:
            if (r0 < 0) goto L8;
            if (isPathPrefixMatch(r6, this.mPaths.valueAt(r0)) == false) goto L7;
            this.mPaths.removeAt(r0);
            r2 = true;
        L7:
            r0 = r0 - 1;
            goto L3
        L8:
            return r2;
        }

        private boolean isPathPrefixMatch(String[] r5, String[] r6) {
            int r4 = r5.length;
            if (r6.length >= r4) goto L5;
            return false;
        L5:
            int r0 = 0;
        L6:
            if (r0 >= r4) goto L11;
            if (Objects.equals(r6[r0], r5[r0]) == false) goto L9;
            r0 = r0 + 1;
            goto L6
        L9:
            return false;
        L11:
            return true;
        }

        private String encodeSegments(String[] r3) {
            String[] r2 = new String[r3.length];
            int r0 = 0;
        L4:
            if (r0 >= r3.length) goto L7;
            r2[r0] = Uri.encode(r3[r0]);
            r0 = r0 + 1;
            goto L4
        L7:
            return TextUtils.join(LibrarianImpl.Constants.SEPARATOR, r2);
        }

        private String[] decodeSegments(String r2) {
            String[] r1 = r2.split(LibrarianImpl.Constants.SEPARATOR, -1);
            int r3 = 0;
        L4:
            if (r3 >= r1.length) goto L6;
            r1[r3] = Uri.decode(r1[r3]);
            r3 = r3 + 1;
            goto L4
        L6:
            return r1;
        }
    }

    public CompatPermissionManager(Context r1, String r2, int r3, String[] r4) {
        this.mContext = r1;
        this.mPrefsName = r2;
        this.mMyUid = r3;
        this.mAutoGrantPermissions = r4;
    }

    private SharedPreferences getPrefs() {
        return this.mContext.getSharedPreferences(this.mPrefsName, 0);
    }

    public int checkSlicePermission(Uri r8, int r9, int r10) {
        if (r10 != this.mMyUid) goto L5;
        return 0;
    L5:
        String[] r0 = this.mContext.getPackageManager().getPackagesForUid(r10);
        int r2 = r0.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L11;
        if (checkSlicePermission(r8, r0[r3]) == 0) goto L9;
        r3 = r3 + 1;
        goto L6
    L9:
        return 0;
    L11:
        String[] r4 = this.mAutoGrantPermissions;
        int r5 = r4.length;
        int r6 = 0;
    L12:
        if (r6 >= r5) goto L21;
        if (this.mContext.checkPermission(r4[r6], r9, r10) == 0) goto L15;
        r6 = r6 + 1;
        goto L12
    L15:
        int r11 = r0.length;
        int r12 = 0;
    L16:
        if (r12 >= r11) goto L18;
        grantSlicePermission(r8, r0[r12]);
        r12 = r12 + 1;
        goto L16
    L18:
        return 0;
    L21:
        return this.mContext.checkUriPermission(r8, r9, r10, 2);
    }

    private int checkSlicePermission(Uri r2, String r3) {
        if (getPermissionState(r3, r2.getAuthority()).hasAccess(r2.getPathSegments()) == false) goto L5;
        return 0;
    L5:
        return -1;
    }

    public void grantSlicePermission(Uri r2, String r3) {
        PermissionState r4 = getPermissionState(r3, r2.getAuthority());
        if (r4.addPath(r2.getPathSegments()) == false) goto L6;
        persist(r4);
        return;
    }

    public void revokeSlicePermission(Uri r2, String r3) {
        PermissionState r4 = getPermissionState(r3, r2.getAuthority());
        if (r4.removePath(r2.getPathSegments()) == false) goto L6;
        persist(r4);
        return;
    }

    private synchronized void persist(PermissionState r4) {
        monitor-enter(this);
        getPrefs().edit().putStringSet(r4.getKey(), r4.toPersistable()).putBoolean(r4.getKey() + ALL_SUFFIX, r4.hasAllPermissions()).apply();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private PermissionState getPermissionState(String r3, String r4) {
        String r5 = r3 + "_" + r4;
        return new PermissionState(getPrefs().getStringSet(r5, Collections.emptySet()), r5, getPrefs().getBoolean(r5 + ALL_SUFFIX, false));
    }
}
