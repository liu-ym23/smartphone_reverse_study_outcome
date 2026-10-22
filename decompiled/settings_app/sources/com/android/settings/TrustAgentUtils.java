package com.android.settings;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Slog;
import android.util.Xml;
import com.android.settingslib.RestrictedLockUtils;
import com.bytedance.librarian.LibrarianImpl;
import com.obric.olog.OLog;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class TrustAgentUtils {
    private static final String PERMISSION_PROVIDE_AGENT = "android.permission.PROVIDE_TRUST_AGENT";
    static final String TAG = "TrustAgentUtils";
    private static final String TRUST_AGENT_META_DATA = "android.service.trust.trustagent";

    public static class TrustAgentComponentInfo {
        RestrictedLockUtils.EnforcedAdmin admin;
        ComponentName componentName;
        String summary;
        String title;

        public TrustAgentComponentInfo() {
            this.admin = null;
        }
    }

    public TrustAgentUtils() {
    }

    public static boolean checkProvidePermission(ResolveInfo r1, PackageManager r2) {
        String r3 = r1.serviceInfo.packageName;
        if (r2.checkPermission(PERMISSION_PROVIDE_AGENT, r3) == 0) goto L6;
        OLog.w(TAG, "Skipping agent because package " + r3 + " does not have permission android.permission.PROVIDE_TRUST_AGENT.");
        return false;
    L6:
        return true;
    }

    public static ComponentName getComponentName(ResolveInfo r2) {
        if (r2 != null) goto L4;
        return null;
    L4:
        if (r2.serviceInfo != null) goto L7;
        return null;
    L7:
        return new ComponentName(r2.serviceInfo.packageName, r2.serviceInfo.name);
    }

    public static boolean isDisabledByAdmin(DevicePolicyManager r0, RestrictedLockUtils.EnforcedAdmin r1, ComponentName r2) {
        if (r1 == null) goto L8;
        if (r0 == null) goto L8;
        if (r2 == null) goto L8;
        if (r0.getTrustAgentConfiguration(null, r2) != null) goto L8;
        return true;
    L8:
        return false;
    }

    public static TrustAgentComponentInfo getSettingsComponent(PackageManager r9, ResolveInfo r10) {
        XmlResourceParser r1 = null;
        ComponentName r2 = null;
        if (r10 != null) goto L5;
    L74:
        return null;
    L5:
        if (r10.serviceInfo == null) goto L74;
        if (r10.serviceInfo.metaData == null) goto L74;
        TrustAgentComponentInfo r3 = new TrustAgentComponentInfo();
        XmlResourceParser r4 = r10.serviceInfo.loadXmlMetaData(r9, TRUST_AGENT_META_DATA);     // Catch: Throwable -> L46 XmlPullParserException -> L50 IOException -> L54 PackageManager.NameNotFoundException -> L58
        if (r4 != null) goto L16;
        Slog.w(TAG, "Can't find android.service.trust.trustagent meta-data");     // Catch: Throwable -> L38 XmlPullParserException -> L40 IOException -> L42 PackageManager.NameNotFoundException -> L44
        if (r4 == null) goto L15;
        r4.close();
    L15:
        return null;
    L16:
        Resources r11 = r9.getResourcesForApplication(r10.serviceInfo.applicationInfo);     // Catch: Throwable -> L38 XmlPullParserException -> L40 IOException -> L42 PackageManager.NameNotFoundException -> L44
        AttributeSet r5 = Xml.asAttributeSet(r4);     // Catch: Throwable -> L38 XmlPullParserException -> L40 IOException -> L42 PackageManager.NameNotFoundException -> L44
    L17:
        int r6 = r4.next();     // Catch: Throwable -> L38 XmlPullParserException -> L40 IOException -> L42 PackageManager.NameNotFoundException -> L44
        if (r6 == 1) goto L22;
        if (r6 != 2) goto L17;
    L22:
        if ("trust-agent".equals(r4.getName()) == true) goto L27;
        Slog.w(TAG, "Meta-data does not start with trust-agent tag");     // Catch: Throwable -> L38 XmlPullParserException -> L40 IOException -> L42 PackageManager.NameNotFoundException -> L44
        if (r4 == null) goto L26;
        r4.close();
    L26:
        return null;
    L27:
        TypedArray r12 = r11.obtainAttributes(r5, com.android.internal.R.styleable.TrustAgent);     // Catch: Throwable -> L38 XmlPullParserException -> L40 IOException -> L42 PackageManager.NameNotFoundException -> L44
        r3.summary = r12.getString(1);     // Catch: Throwable -> L38 XmlPullParserException -> L40 IOException -> L42 PackageManager.NameNotFoundException -> L44
        r3.title = r12.getString(0);     // Catch: Throwable -> L38 XmlPullParserException -> L40 IOException -> L42 PackageManager.NameNotFoundException -> L44
        String r7 = r12.getString(2);     // Catch: Throwable -> L38 XmlPullParserException -> L40 IOException -> L42 PackageManager.NameNotFoundException -> L44
        r12.recycle();     // Catch: XmlPullParserException -> L32 IOException -> L34 PackageManager.NameNotFoundException -> L36 Throwable -> L38
        if (r4 == null) goto L31;
        r4.close();
    L31:
        e = null;
    L62:
        if (e == null) goto L65;
        Slog.w(TAG, "Error parsing : " + r10.serviceInfo.packageName, e);
        return null;
    L65:
        if (r7 != null) goto L67;
    L69:
        if (r7 == null) goto L72;
        r2 = ComponentName.unflattenFromString(r7);
    L72:
        r3.componentName = r2;
        return r3;
    L67:
        if (r7.indexOf(47) >= 0) goto L69;
        r7 = r10.serviceInfo.packageName + LibrarianImpl.Constants.SEPARATOR + r7;
        goto L69
    L36:
        e = e;
    L60:
        if (r4 == null) goto L62;
    L53:
        r4.close();
    L34:
        e = e;
    L56:
        if (r4 == null) goto L62;
    L32:
        e = e;
    L52:
        if (r4 == null) goto L62;
    L38:
        th = th;
        r1 = r4;
    L47:
        if (r1 == null) goto L49;
        r1.close();
    L49:
        throw th;
    L44:
        e = e;
        r7 = null;
    L42:
        e = e;
        r7 = null;
    L40:
        e = e;
        r7 = null;
        goto L52
    L58:
        e = e;
        r4 = null;
        r7 = null;
    L54:
        e = e;
        r4 = null;
        r7 = null;
    L50:
        e = e;
        r4 = null;
        r7 = null;
    L46:
        th = th;
        goto L47
    }
}
