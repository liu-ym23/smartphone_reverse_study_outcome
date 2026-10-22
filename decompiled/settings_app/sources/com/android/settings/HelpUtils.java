package com.android.settings;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import com.obric.olog.OLog;
import java.net.URISyntaxException;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class HelpUtils {
    private static final String EXTRA_BACKUP_URI = "EXTRA_BACKUP_URI";
    private static final String EXTRA_CONTEXT = "EXTRA_CONTEXT";
    private static final String EXTRA_PRIMARY_COLOR = "EXTRA_PRIMARY_COLOR";
    private static final String EXTRA_THEME = "EXTRA_THEME";
    private static final int MENU_HELP = 101;
    private static final String PARAM_LANGUAGE_CODE = "hl";
    private static final String PARAM_VERSION = "version";
    private static final String TAG = "HelpUtils";
    private static String sCachedVersionCode;

    static {
    }

    private HelpUtils() {
    }

    public static boolean prepareHelpMenuItem(Activity r3, Menu r4, String r5, String r6) {
        return prepareHelpMenuItem(r3, r4.add(0, 101, 0, R.string.help_label), r5, r6);
    }

    public static boolean prepareHelpMenuItem(Activity r3, Menu r4, int r5, String r6) {
        return prepareHelpMenuItem(r3, r4.add(0, 101, 0, R.string.help_label), r3.getString(r5), r6);
    }

    public static boolean prepareHelpMenuItem(final Activity r2, MenuItem r3, String r4, String r5) {
        if (TextUtils.isEmpty(r4) == false) goto L6;
        r3.setVisible(false);
        return false;
    L6:
        final Intent r6 = getHelpIntent(r2, r4, r5);
        if (r6 == null) goto L10;
        r3.setOnMenuItemClickListener(new AnonymousClass1(r2, r6));
        r3.setShowAsAction(0);
        r3.setVisible(true);
        return true;
    L10:
        r3.setVisible(false);
        return false;
    }

    public static Intent getHelpIntent(Context r3, String r4, String r5) {
        Intent r1 = Intent.parseUri(r4, 3);     // Catch: URISyntaxException -> L12
        addIntentParameters(r3, r1, r5);     // Catch: URISyntaxException -> L12
        if (r1.resolveActivity(r3.getPackageManager()) == null) goto L7;
        return r1;
    L7:
        if (r1.hasExtra(EXTRA_BACKUP_URI) == false) goto L10;
        return getHelpIntent(r3, r1.getStringExtra(EXTRA_BACKUP_URI), r5);
    L10:
        return null;
    L12:
        Intent r6 = new Intent("android.intent.action.VIEW", uriWithAddedParameters(r3, Uri.parse(r4)));
        r6.setFlags(276824064);
        return r6;
    }

    private static void addIntentParameters(Context r3, Intent r4, String r5) {
        if (r4.hasExtra(EXTRA_CONTEXT) == true) goto L5;
        r4.putExtra(EXTRA_CONTEXT, r5);
    L5:
        r4.putExtra(EXTRA_THEME, 1);
        Resources.Theme r6 = r3.getTheme();
        TypedValue r1 = new TypedValue();
        r6.resolveAttribute(android.R.attr.colorPrimary, r1, true);
        r4.putExtra(EXTRA_PRIMARY_COLOR, r3.getColor(r1.resourceId));
    }

    public static Uri uriWithAddedParameters(Context r3, Uri r4) {
        Uri.Builder r5 = r4.buildUpon();
        r5.appendQueryParameter(PARAM_LANGUAGE_CODE, Locale.getDefault().toString());
        String r0 = sCachedVersionCode;
        if (r0 == null) goto L17;
        r5.appendQueryParameter("version", r0);
    L16:
        return r5.build();
    L17:
        PackageManager r1 = r3.getPackageManager();     // Catch: PackageManager.NameNotFoundException -> L12
        if (r1 == null) goto L7;
        PackageInfo r6 = r1.getPackageInfo(r3.getPackageName(), 0);     // Catch: PackageManager.NameNotFoundException -> L12
        if (r6 == null) goto L16;
        String r7 = Integer.toString(r6.versionCode);     // Catch: PackageManager.NameNotFoundException -> L12
        sCachedVersionCode = r7;     // Catch: PackageManager.NameNotFoundException -> L12
        r5.appendQueryParameter("version", r7);     // Catch: PackageManager.NameNotFoundException -> L12
        goto L16
    L7:
        return r5.build();
    L12:
        e = move-exception;
        String r2 = TAG;
        OLog.e(r2, "Invalid package name for context", e);
        Log.wtf(r2, "Invalid package name for context", e);
        goto L16
    }
}
