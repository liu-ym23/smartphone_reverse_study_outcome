package com.android.settingslib;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.system.Os;
import android.system.StructUtsname;
import android.telephony.PhoneNumberUtils;
import android.telephony.SubscriptionInfo;
import android.telephony.TelephonyManager;
import android.text.BidiFormatter;
import android.text.TextDirectionHeuristics;
import android.text.TextUtils;
import android.text.format.DateFormat;
import com.GlobalProxyLancet;
import com.android.settings.utils.HanziToPinyin;
import com.bytedance.android.standard.tools.date.DateUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class DeviceInfoUtils {
    private static final String FILENAME_MSV = "/sys/board_properties/soc/msv";
    private static final String TAG = "DeviceInfoUtils";

    public DeviceInfoUtils() {
    }

    private static String readLine(String r2) throws IOException {
        BufferedReader r0 = new BufferedReader(new FileReader(r2), 256);
        String r3 = r0.readLine();     // Catch: Throwable -> L6
        r0.close();
        return r3;
    L6:
        th = move-exception;
        r0.close();
        throw th;
    }

    public static String getFormattedKernelVersion(Context r1) {
        return formatKernelVersion(r1, Os.uname());
    }

    static String formatKernelVersion(Context r2, StructUtsname r3) {
        if (r3 == null) goto L4;
        Matcher r0 = Pattern.compile("(#\\d+) (?:.*?)?((Sun|Mon|Tue|Wed|Thu|Fri|Sat).+)").matcher(r3.version);
        if (r0.matches() == true) goto L10;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_e(TAG, "Regex did not match on uname version " + r3.version);
        return r2.getString(R.string.status_unavailable);
    L10:
        return r3.release + "\n" + r0.group(1) + HanziToPinyin.Token.SEPARATOR + r0.group(2);
    L4:
        return r2.getString(R.string.status_unavailable);
    }

    public static String getMsvSuffix() {
        if (Long.parseLong(readLine(FILENAME_MSV), 16) != 0) goto L6;
        return " (ENGINEERING)";
    L6:
        return "";
    L11:
        return "";
    }

    public static String getFeedbackReporterPackage(Context r5) {
        String r0 = r5.getResources().getString(R.string.oem_preferred_feedback_reporter);
        if (TextUtils.isEmpty(r0) == false) goto L5;
        return r0;
    L5:
        Intent r1 = new Intent("android.intent.action.BUG_REPORT");
        PackageManager r6 = r5.getPackageManager();
        Iterator<ResolveInfo> r2 = r6.queryIntentActivities(r1, 64).iterator();
    L7:
        if (r2.hasNext() == false) goto L17;
        ResolveInfo r3 = r2.next();
        if (r3.activityInfo == null) goto L7;
        if (TextUtils.isEmpty(r3.activityInfo.packageName) == true) goto L7;
        if ((r6.getApplicationInfo(r3.activityInfo.packageName, 0).flags & 1) == 0) goto L7;
        if (TextUtils.equals(r3.activityInfo.packageName, r0) == false) goto L7;
        return r0;
    L17:
        return null;
    }

    public static String getSecurityPatch() {
        String r0 = Build.VERSION.SECURITY_PATCH;
        if ("".equals(r0) == false) goto L9;
        return null;
    L9:
        Date r1 = new SimpleDateFormat(DateUtils.PATTERN_YEAR).parse(r0);     // Catch: ParseException -> L8
        return DateFormat.format(DateFormat.getBestDateTimePattern(Locale.getDefault(), "dMMMMyyyy"), r1).toString();
    L11:
        return r0;
    }

    public static String getFormattedPhoneNumber(Context r1, SubscriptionInfo r2) {
        if (r2 == null) goto L6;
        String r3 = ((TelephonyManager) r1.getSystemService(TelephonyManager.class)).createForSubscriptionId(r2.getSubscriptionId()).getLine1Number();
        if (TextUtils.isEmpty(r3) == true) goto L6;
        return PhoneNumberUtils.formatNumber(r3);
    L6:
        return null;
    }

    public static String getFormattedPhoneNumbers(Context r3, List<SubscriptionInfo> r4) {
        StringBuilder r0 = new StringBuilder();
        if (r4 == null) goto L11;
        TelephonyManager r5 = (TelephonyManager) r3.getSystemService(TelephonyManager.class);
        r4.size();
        Iterator<SubscriptionInfo> r6 = r4.iterator();
    L6:
        if (r6.hasNext() == false) goto L11;
        String r1 = r5.createForSubscriptionId(r6.next().getSubscriptionId()).getLine1Number();
        if (TextUtils.isEmpty(r1) == true) goto L6;
        r0.append(PhoneNumberUtils.formatNumber(r1)).append("\n");
    L11:
        return r0.toString();
    }

    public static String getBidiFormattedPhoneNumber(Context r1, SubscriptionInfo r2) {
        String r3 = getFormattedPhoneNumber(r1, r2);
        return BidiFormatter.getInstance().unicodeWrap(r3, TextDirectionHeuristics.LTR);
    }
}
