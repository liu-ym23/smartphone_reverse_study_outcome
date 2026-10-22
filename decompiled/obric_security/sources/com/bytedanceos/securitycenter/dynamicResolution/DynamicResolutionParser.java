package com.bytedanceos.securitycenter.dynamicResolution;

import android.os.Build;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicResolutionParser {
    private static final String ITEM = "item";
    private static final String LIST = "list";
    private static final int OREO = 26;
    private static final String SDK = "sdk";
    private static final String SM_VERSION = "sm_version";
    private static final String SUPPORT_DEVICES = "devices";

    public DynamicResolutionParser() {
    }

    public static List<ApplicationConfig> parser(XmlPullParser parser) {
        ArrayList r0 = new ArrayList();
        int r1 = parser.getEventType();     // Catch: Exception -> L24
        int r2 = 0;
    L5:
        if (r1 == 1) goto L26;
        if (r1 != 2) goto L22;
        if (parser.getName().equals("list") == false) goto L11;
        r2 = Integer.parseInt(parser.getAttributeValue(null, "sdk"));     // Catch: Exception -> L24
    L11:
        if (r2 == 0) goto L12;
        if (Build.VERSION.SDK_INT < r2) goto L15;
        if (r2 < 26) goto L18;
        if (parser.getName().equals(ITEM) == false) goto L22;
        String r3 = parser.getAttributeValue(null, SM_VERSION);     // Catch: Exception -> L24
        String r4 = parser.getAttributeValue(null, SUPPORT_DEVICES);     // Catch: Exception -> L24
        r0.add(new ApplicationConfig(parser.nextText(), r3, r4));     // Catch: Exception -> L24
        goto L22
    L18:
        r1 = parser.next();     // Catch: Exception -> L24
        goto L5
    L15:
        r1 = parser.next();     // Catch: Exception -> L24
        goto L5
    L12:
        r1 = parser.next();     // Catch: Exception -> L24
    L22:
        r1 = parser.next();     // Catch: Exception -> L24
    L26:
        return r0;
    L24:
        e = move-exception;
        e.printStackTrace();
        goto L26
    }
}
