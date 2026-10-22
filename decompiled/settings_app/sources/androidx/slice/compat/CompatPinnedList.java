package androidx.slice.compat;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.collection.ArraySet;
import androidx.core.util.ObjectsCompat;
import androidx.slice.SliceSpec;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class CompatPinnedList {
    private static final long BOOT_THRESHOLD = 2000;
    private static final String LAST_BOOT = "last_boot";
    private static final String PIN_PREFIX = "pinned_";
    private static final String SPEC_NAME_PREFIX = "spec_names_";
    private static final String SPEC_REV_PREFIX = "spec_revs_";
    private final Context mContext;
    private final String mPrefsName;

    public CompatPinnedList(Context r1, String r2) {
        this.mContext = r1;
        this.mPrefsName = r2;
    }

    private SharedPreferences getPrefs() {
        SharedPreferences r0 = this.mContext.getSharedPreferences(this.mPrefsName, 0);
        long r1 = r0.getLong(LAST_BOOT, 0);
        long r4 = getBootTime();
        if (Math.abs(r1 - r4) <= BOOT_THRESHOLD) goto L5;
        r0.edit().clear().putLong(LAST_BOOT, r4).apply();
    L5:
        return r0;
    }

    public List<Uri> getPinnedSlices() {
        ArrayList r0 = new ArrayList();
        Iterator<String> r1 = getPrefs().getAll().keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        String r2 = r1.next();
        if (r2.startsWith(PIN_PREFIX) == false) goto L4;
        Uri r3 = Uri.parse(r2.substring(7));
        if (getPins(r3).isEmpty() == true) goto L4;
        r0.add(r3);
        goto L4
    L10:
        return r0;
    }

    private Set<String> getPins(Uri r3) {
        return getPrefs().getStringSet(PIN_PREFIX + r3.toString(), new ArraySet());
    }

    public synchronized ArraySet<SliceSpec> getSpecs(Uri r7) {
        monitor-enter(this);
        ArraySet<SliceSpec> r2 = new ArraySet();     // Catch: Throwable -> L24
        SharedPreferences r3 = getPrefs();     // Catch: Throwable -> L24
        String r1 = r3.getString(SPEC_NAME_PREFIX + r7.toString(), null);     // Catch: Throwable -> L24
        String r8 = r3.getString(SPEC_REV_PREFIX + r7.toString(), null);     // Catch: Throwable -> L24
        if (TextUtils.isEmpty(r1) == false) goto L7;
    L21:
        ArraySet<SliceSpec> r9 = new ArraySet();     // Catch: Throwable -> L24
        monitor-exit(this);
        return r9;
    L7:
        if (TextUtils.isEmpty(r8) == true) goto L21;
        String[] r0 = r1.split(",", -1);     // Catch: Throwable -> L24
        String[] r10 = r8.split(",", -1);     // Catch: Throwable -> L24
        if (r0.length == r10.length) goto L14;
        ArraySet<SliceSpec> r11 = new ArraySet();     // Catch: Throwable -> L24
        monitor-exit(this);
        return r11;
    L14:
        int r4 = 0;
    L16:
        if (r4 >= r0.length) goto L19;
        r2.add(new SliceSpec(r0[r4], Integer.parseInt(r10[r4])));     // Catch: Throwable -> L24
        r4 = r4 + 1;
        goto L16
    L19:
        monitor-exit(this);
        return r2;
    L24:
        th = move-exception;
        throw th;
    }

    private void setPins(Uri r3, Set<String> r4) {
        getPrefs().edit().putStringSet(PIN_PREFIX + r3.toString(), r4).apply();
    }

    private void setSpecs(Uri r5, ArraySet<SliceSpec> r6) {
        String[] r0 = new String[r6.size()];
        String[] r1 = new String[r6.size()];
        int r2 = 0;
    L4:
        if (r2 >= r6.size()) goto L6;
        r0[r2] = r6.valueAt(r2).getType();
        r1[r2] = String.valueOf(r6.valueAt(r2).getRevision());
        r2 = r2 + 1;
        goto L4
    L6:
        getPrefs().edit().putString(SPEC_NAME_PREFIX + r5.toString(), TextUtils.join(",", r0)).putString(SPEC_REV_PREFIX + r5.toString(), TextUtils.join(",", r1)).apply();
    }

    protected long getBootTime() {
        return System.currentTimeMillis() - SystemClock.elapsedRealtime();
    }

    public synchronized boolean addPin(Uri r3, String r4, Set<SliceSpec> r5) {
        monitor-enter(this);
        Set<String> r0 = getPins(r3);     // Catch: Throwable -> L9
        boolean r1 = r0.isEmpty();     // Catch: Throwable -> L9
        r0.add(r4);     // Catch: Throwable -> L9
        setPins(r3, r0);     // Catch: Throwable -> L9
        if (r1 == false) goto L6;
        setSpecs(r3, new ArraySet(r5));     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return r1;
    L6:
        setSpecs(r3, mergeSpecs(getSpecs(r3), r5));     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public synchronized boolean removePin(Uri r4, String r5) {
        monitor-enter(this);
        Set<String> r0 = getPins(r4);     // Catch: Throwable -> L15
        boolean r2 = false;
        if (r0.isEmpty() == false) goto L6;
    L13:
        monitor-exit(this);
        return false;
    L6:
        if (r0.contains(r5) == false) goto L13;
        r0.remove(r5);     // Catch: Throwable -> L15
        setPins(r4, r0);     // Catch: Throwable -> L15
        setSpecs(r4, new ArraySet());     // Catch: Throwable -> L15
        if (r0.size() != 0) goto L11;
        r2 = true;
    L11:
        monitor-exit(this);
        return r2;
    L15:
        th = move-exception;
        throw th;
    }

    private static ArraySet<SliceSpec> mergeSpecs(ArraySet<SliceSpec> r4, Set<SliceSpec> r5) {
        int r0 = 0;
    L4:
        if (r0 >= r4.size()) goto L13;
        SliceSpec r1 = r4.valueAt(r0);
        SliceSpec r2 = findSpec(r5, r1.getType());
        if (r2 != null) goto L10;
        int r3 = r0 - 1;
        r4.removeAt(r0);
    L8:
        r0 = r3;
    L12:
        r0 = r0 + 1;
        goto L4
    L10:
        if (r2.getRevision() >= r1.getRevision()) goto L12;
        r3 = r0 - 1;
        r4.removeAt(r0);
        r4.add(r2);
        goto L8
    L13:
        return r4;
    }

    private static SliceSpec findSpec(Set<SliceSpec> r2, String r3) {
        Iterator<SliceSpec> r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        SliceSpec r0 = r4.next();
        if (ObjectsCompat.equals(r0.getType(), r3) == false) goto L4;
        return r0;
    L8:
        return null;
    }
}
