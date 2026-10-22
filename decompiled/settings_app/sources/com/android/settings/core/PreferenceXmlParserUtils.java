package com.android.settings.core;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Xml;
import com.android.settings.R;
import com.obric.olog.OLog;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class PreferenceXmlParserUtils {
    public static final int APPEND_VALUE = 1;
    public static final String METADATA_APPEND = "staticPreferenceLocation";
    public static final String METADATA_CONTROLLER = "controller";
    public static final String METADATA_FOR_WORK = "for_work";
    public static final String METADATA_HIGHLIGHTABLE_MENU_KEY = "highlightable_menu_key";
    public static final String METADATA_ICON = "icon";
    public static final String METADATA_KEY = "key";
    public static final String METADATA_KEYWORDS = "keywords";
    public static final String METADATA_PREF_TYPE = "type";
    public static final String METADATA_SEARCHABLE = "searchable";
    public static final String METADATA_SUMMARY = "summary";
    public static final String METADATA_TITLE = "title";
    public static final String METADATA_UNAVAILABLE_SLICE_SUBTITLE = "unavailable_slice_subtitle";
    public static final String METADATA_USER_RESTRICTION = "userRestriction";
    public static final String PREF_SCREEN_TAG = "PreferenceScreen";
    public static final int PREPEND_VALUE = 0;
    private static final List<String> SUPPORTED_PREF_TYPES = null;
    private static final String TAG = "PreferenceXmlParserUtil";

    @Retention(RetentionPolicy.SOURCE)
    public @interface MetadataFlag {
        public static final int FLAG_FOR_WORK = 4096;
        public static final int FLAG_INCLUDE_PREF_SCREEN = 1;
        public static final int FLAG_NEED_HIGHLIGHTABLE_MENU_KEY = 8192;
        public static final int FLAG_NEED_KEY = 2;
        public static final int FLAG_NEED_KEYWORDS = 256;
        public static final int FLAG_NEED_PREF_APPEND = 1024;
        public static final int FLAG_NEED_PREF_CONTROLLER = 8;
        public static final int FLAG_NEED_PREF_ICON = 64;
        public static final int FLAG_NEED_PREF_SUMMARY = 32;
        public static final int FLAG_NEED_PREF_TITLE = 16;
        public static final int FLAG_NEED_PREF_TYPE = 4;
        public static final int FLAG_NEED_SEARCHABLE = 512;
        public static final int FLAG_NEED_USER_RESTRICTION = 16384;
        public static final int FLAG_UNAVAILABLE_SLICE_SUBTITLE = 2048;
    }

    private static boolean hasFlag(int r0, int r1) {
        if ((r0 & r1) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public PreferenceXmlParserUtils() {
    }

    static {
        SUPPORTED_PREF_TYPES = Arrays.asList(new String[]{"Preference", "PreferenceCategory", PREF_SCREEN_TAG, "SwitchPreferenceCompat", "com.android.settings.widget.WorkOnlyCategory"});
    }

    public static List<Bundle> extractMetadata(Context r11, int r12, int r13) throws IOException, XmlPullParserException {
        ArrayList r0 = new ArrayList();
        if (r12 > 0) goto L6;
        OLog.d(TAG, r12 + " is invalid.");
        return r0;
    L6:
        XmlResourceParser r14 = r11.getResources().getXml(r12);
    L7:
        int r1 = r14.next();
        if (r1 == 1) goto L11;
        if (r1 != 2) goto L7;
    L11:
        int r4 = r14.getDepth();
        boolean r5 = hasFlag(r13, 1);
    L12:
        if (r1 != 2) goto L52;
        String r2 = r14.getName();
        if (r5 == true) goto L20;
        if (TextUtils.equals(PREF_SCREEN_TAG, r2) == true) goto L52;
    L20:
        if (SUPPORTED_PREF_TYPES.contains(r2) == false) goto L22;
    L24:
        Bundle r6 = new Bundle();
        AttributeSet r7 = Xml.asAttributeSet(r14);
        TypedArray r8 = r11.obtainStyledAttributes(r7, R.styleable.Preference);
        if (r5 == false) goto L27;
        TypedArray r9 = r11.obtainStyledAttributes(r7, R.styleable.PreferenceScreen);
    L29:
        if (hasFlag(r13, 4) == false) goto L32;
        r6.putString("type", r2);
    L32:
        if (hasFlag(r13, 2) == false) goto L35;
        r6.putString("key", getKey(r8));
    L35:
        if (hasFlag(r13, 16) == false) goto L38;
        r6.putString("title", getTitle(r8));
    L38:
        if (hasFlag(r13, 32) == false) goto L41;
        r6.putString("summary", getSummary(r8));
    L41:
        if (hasFlag(r13, 64) == false) goto L44;
        r6.putInt("icon", getIcon(r8));
    L44:
        if (hasFlag(r13, 256) == false) goto L47;
        r6.putString("keywords", getKeywords(r8));
    L47:
        if (hasFlag(r13, 16384) == false) goto L49;
        r6.putString(METADATA_USER_RESTRICTION, getUserRestriction(r11, r7));
    L49:
        r0.add(r6);
        r8.recycle();
        if (r9 == null) goto L52;
        r9.recycle();
        goto L52
    L27:
        r9 = null;
        goto L29
    L22:
        if (r2.endsWith("Preference") == true) goto L24;
    L52:
        r1 = r14.next();
        if (r1 == 1) goto L58;
        if (r1 != 3) goto L12;
        if (r14.getDepth() > r4) goto L12;
    L58:
        r14.close();
        return r0;
    }

    private static String getKey(TypedArray r1) {
        return r1.getString(6);
    }

    private static String getTitle(TypedArray r1) {
        return r1.getString(4);
    }

    private static String getSummary(TypedArray r1) {
        return r1.getString(7);
    }

    private static int getIcon(TypedArray r1) {
        return r1.getResourceId(0, 0);
    }

    private static String getKeywords(TypedArray r1) {
        return r1.getString(27);
    }

    private static String getUserRestriction(Context r1, AttributeSet r2) {
        TypedArray r3 = r1.obtainStyledAttributes(r2, com.android.settingslib.R.styleable.RestrictedPreference);
        String r4 = r3.getString(1);
        r3.recycle();
        return r4;
    }
}
