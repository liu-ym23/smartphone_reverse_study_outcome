package com.android.settings.users;

import android.content.Context;
import android.content.RestrictionEntry;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.UserHandle;
import android.os.UserManager;
import com.android.settings.R;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class RestrictionUtils {
    public static final int[] sRestrictionDescriptions = null;
    public static final String[] sRestrictionKeys = null;
    public static final int[] sRestrictionTitles = null;

    public RestrictionUtils() {
    }

    static {
        sRestrictionKeys = new String[]{"no_share_location"};
        sRestrictionTitles = new int[]{R.string.restriction_location_enable_title};
        sRestrictionDescriptions = new int[]{R.string.restriction_location_enable_summary};
    }

    public static ArrayList<RestrictionEntry> getRestrictions(Context r7, UserHandle r8) {
        Resources r0 = r7.getResources();
        ArrayList<RestrictionEntry> r1 = new ArrayList();
        Bundle r9 = UserManager.get(r7).getUserRestrictions(r8);
        int r2 = 0;
    L3:
        String[] r3 = sRestrictionKeys;
        if (r2 >= r3.length) goto L6;
        String r4 = r3[r2];
        RestrictionEntry r5 = new RestrictionEntry(r4, !r9.getBoolean(r4, false));
        r5.setTitle(r0.getString(sRestrictionTitles[r2]));
        r5.setDescription(r0.getString(sRestrictionDescriptions[r2]));
        r5.setType(1);
        r1.add(r5);
        r2 = r2 + 1;
        goto L3
    L6:
        return r1;
    }

    public static void setRestrictions(Context r2, ArrayList<RestrictionEntry> r3, UserHandle r4) {
        UserManager r5 = UserManager.get(r2);
        Iterator<RestrictionEntry> r6 = r3.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        RestrictionEntry r0 = r6.next();
        r5.setUserRestriction(r0.getKey(), !r0.getSelectedState(), r4);
        goto L4
    }
}
