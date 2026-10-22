package com.android.settingslib;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import java.net.URISyntaxException;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class HelpUtils {
    private static final String EXTRA_BACKUP_URI = "EXTRA_BACKUP_URI";
    private static final String EXTRA_CONTEXT = "EXTRA_CONTEXT";
    private static final String EXTRA_THEME = "EXTRA_THEME";
    static final int MENU_HELP = 101;
    private static final String PARAM_LANGUAGE_CODE = "hl";
    private static final String PARAM_VERSION = "version";
    private static final String TAG = "HelpUtils";
    private static String sCachedVersionCode;

    static {
    }

    static /* synthetic */ String access$000() {
        return TAG;
    }

    private HelpUtils() {
    }

    public static boolean prepareHelpMenuItem(Activity r3, Menu r4, String r5, String r6) {
        if (r4.findItem(101) == null) goto L5;
        return false;
    L5:
        MenuItem r7 = r4.add(0, 101, 0, R.string.help_feedback_label);
        r7.setIcon(R.drawable.ic_help_actionbar);
        return prepareHelpMenuItem(r3, r7, r5, r6);
    }

    public static boolean prepareHelpMenuItem(Activity r3, Menu r4, int r5, String r6) {
        if (r4.findItem(101) == null) goto L5;
        return false;
    L5:
        MenuItem r7 = r4.add(0, 101, 0, R.string.help_feedback_label);
        r7.setIcon(R.drawable.ic_help_actionbar);
        return prepareHelpMenuItem(r3, r7, r3.getString(r5), r6);
    }

    static boolean prepareHelpMenuItem(final Activity r3, MenuItem r4, String r5, String r6) {
        if (Settings.Global.getInt(r3.getContentResolver(), "device_provisioned", 0) != 0) goto L6;
        return false;
    L6:
        if (TextUtils.isEmpty(r5) == false) goto L9;
        r4.setVisible(false);
        return false;
    L9:
        final Intent r7 = getHelpIntent(r3, r5, r6);
        if (r7 == null) goto L13;
        r4.setOnMenuItemClickListener(new AnonymousClass1(r3, r7));
        r4.setShowAsAction(2);
        r4.setVisible(true);
        return true;
    L13:
        r4.setVisible(false);
        return false;
    }

    public static Intent getHelpIntent(Context r4, String r5, String r6) {
        if (Settings.Global.getInt(r4.getContentResolver(), "device_provisioned", 0) != 0) goto L16;
        return null;
    L16:
        Intent r1 = Intent.parseUri(r5, 3);     // Catch: URISyntaxException -> L14
        addIntentParameters(r4, r1, r6, true);     // Catch: URISyntaxException -> L14
        if (r1.resolveActivity(r4.getPackageManager()) == null) goto L10;
        return r1;
    L10:
        if (r1.hasExtra(EXTRA_BACKUP_URI) == false) goto L13;
        return getHelpIntent(r4, r1.getStringExtra(EXTRA_BACKUP_URI), r6);
    L13:
        return null;
    L14:
        Intent r7 = new Intent("android.intent.action.VIEW", uriWithAddedParameters(r4, Uri.parse(r5)));
        r7.setFlags(276824064);
        return r7;
    }

    public static void addIntentParameters(Context r4, Intent r5, String r6, boolean r7) {
        if (r5.hasExtra(EXTRA_CONTEXT) == true) goto L5;
        r5.putExtra(EXTRA_CONTEXT, r6);
    L5:
        Resources r8 = r4.getResources();
        boolean r9 = r8.getBoolean(android.R.bool.config_sendPackageName);
        if (r7 == false) goto L9;
        if (r9 == false) goto L9;
        String[] r10 = {r8.getString(android.R.string.config_helpPackageNameKey)};
        String[] r11 = {r8.getString(android.R.string.config_helpPackageNameValue)};
        String r0 = r8.getString(android.R.string.config_helpIntentExtraKey);
        String r1 = r8.getString(android.R.string.config_helpIntentNameKey);
        String r2 = r8.getString(android.R.string.config_feedbackIntentExtraKey);
        String r12 = r8.getString(android.R.string.config_feedbackIntentNameKey);
        r5.putExtra(r0, r10);
        r5.putExtra(r1, r11);
        r5.putExtra(r2, r10);
        r5.putExtra(r12, r11);
    L9:
        r5.putExtra(EXTRA_THEME, 3);
    }

    public static Uri uriWithAddedParameters(Context r4, Uri r5) {
        Uri.Builder r6 = r5.buildUpon();
        r6.appendQueryParameter(PARAM_LANGUAGE_CODE, Locale.getDefault().toString());
        String r0 = sCachedVersionCode;
        if (r0 == null) goto L11;
        r6.appendQueryParameter("version", r0);
    L10:
        return r6.build();
    L11:
        String r7 = Long.toString(r4.getPackageManager().getPackageInfo(r4.getPackageName(), 0).getLongVersionCode());     // Catch: PackageManager.NameNotFoundException -> L6
        sCachedVersionCode = r7;     // Catch: PackageManager.NameNotFoundException -> L6
        r6.appendQueryParameter("version", r7);     // Catch: PackageManager.NameNotFoundException -> L6
    L6:
        e = move-exception;
        Log.wtf(TAG, "Invalid package name for context", e);
        goto L10
    }
}
