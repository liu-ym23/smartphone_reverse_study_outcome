package com.android.settings.homepage;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.android.settings.core.PreferenceXmlParserUtils;
import com.obric.olog.OLog;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class HighlightableMenu {
    private static final Map<String, Integer> MENU_KEY_COMPAT_MAP = null;
    private static final Map<String, String> MENU_TO_PREFERENCE_KEY_MAP = null;
    private static final String TAG = "HighlightableMenu";
    private static boolean sXmlParsed;

    public HighlightableMenu() {
    }

    static {
        MENU_TO_PREFERENCE_KEY_MAP = new ArrayMap();
        MENU_KEY_COMPAT_MAP = new ArrayMap();
    }

    public static synchronized void fromXml(final Context r5, int r6) {
        monitor-enter(HighlightableMenu.class);
    L33:
        th = move-exception;
        throw th;
    L5:
        if (sXmlParsed == false) goto L8;
        monitor-exit(HighlightableMenu.class);
        return;
    L8:
        OLog.d(TAG, "parsing highlightable menu from xml");     // Catch: Throwable -> L33
        Iterator<Bundle> r7 = PreferenceXmlParserUtils.extractMetadata(r5, r6, 8194).iterator();     // Catch: Throwable -> L33
    L13:
        if (r7.hasNext() == false) goto L22;
        Bundle r1 = r7.next();     // Catch: Throwable -> L33
        String r2 = r1.getString(PreferenceXmlParserUtils.METADATA_HIGHLIGHTABLE_MENU_KEY);     // Catch: Throwable -> L33
        if (TextUtils.isEmpty(r2) == true) goto L13;
        String r3 = r1.getString("key");     // Catch: Throwable -> L33
        if (TextUtils.isEmpty(r3) == true) goto L19;
        MENU_TO_PREFERENCE_KEY_MAP.put(r2, r3);     // Catch: Throwable -> L33
        goto L13
    L19:
        OLog.w(TAG, "Highlightable menu requires android:key but it's missing in xml: " + r2);     // Catch: Throwable -> L33
        goto L13
    L22:
        if (MENU_TO_PREFERENCE_KEY_MAP.isEmpty() == false) goto L26;
        monitor-exit(HighlightableMenu.class);
        return;
    L26:
        sXmlParsed = true;     // Catch: Throwable -> L33
        MENU_KEY_COMPAT_MAP.forEach(new HighlightableMenu$$ExternalSyntheticLambda0(r5));     // Catch: Throwable -> L33
        monitor-exit(HighlightableMenu.class);
        return;
    L29:
        e = move-exception;
        OLog.e(TAG, "Failed to parse preference xml for getting highlightable menu keys", e);     // Catch: Throwable -> L33
    }

    static /* synthetic */ void lambda$fromXml$0(Context r0, String r1, Integer r2) {
        String r3 = lookupPreferenceKey(r0.getString(r2.intValue()));
        if (r3 == null) goto L6;
        MENU_TO_PREFERENCE_KEY_MAP.put(r1, r3);
        return;
    }

    public static synchronized void addMenuKey(String r4) {
        monitor-enter(HighlightableMenu.class);
        OLog.d(TAG, "add menu key: " + r4);     // Catch: Throwable -> L7
        MENU_TO_PREFERENCE_KEY_MAP.put(r4, r4);     // Catch: Throwable -> L7
        monitor-exit(HighlightableMenu.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static String lookupPreferenceKey(String r1) {
        return MENU_TO_PREFERENCE_KEY_MAP.get(r1);
    }
}
