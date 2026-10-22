package com.android.settings.notification.zen;

import android.content.ComponentName;
import android.net.Uri;

/* JADX INFO: loaded from: classes2.dex */
public class ZenRuleInfo {
    public ComponentName configurationActivity;
    public Uri defaultConditionId;
    public String defaultTriggerDescription;
    public String id;
    boolean isChecked;
    public boolean isSystem;
    public CharSequence packageLabel;
    public String packageName;
    public int ruleInstanceLimit;
    public ComponentName serviceComponent;
    public String settingsAction;
    public String title;
    public int type;

    public ZenRuleInfo() {
        this.ruleInstanceLimit = -1;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L80:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L80;
        ZenRuleInfo r6 = (ZenRuleInfo) r5;
        if (this.isSystem == r6.isSystem) goto L14;
        return false;
    L14:
        if (this.ruleInstanceLimit == r6.ruleInstanceLimit) goto L16;
        return false;
    L16:
        String r2 = this.packageName;
        if (r2 == null) goto L22;
        if (r2.equals(r6.packageName) == false) goto L23;
    L24:
        String r3 = this.title;
        if (r3 == null) goto L30;
        if (r3.equals(r6.title) == false) goto L31;
    L32:
        String r4 = this.settingsAction;
        if (r4 == null) goto L38;
        if (r4.equals(r6.settingsAction) == false) goto L39;
    L40:
        ComponentName r7 = this.configurationActivity;
        if (r7 == null) goto L46;
        if (r7.equals(r6.configurationActivity) == false) goto L47;
    L48:
        Uri r8 = this.defaultConditionId;
        if (r8 == null) goto L54;
        if (r8.equals(r6.defaultConditionId) == false) goto L55;
    L56:
        ComponentName r9 = this.serviceComponent;
        if (r9 == null) goto L62;
        if (r9.equals(r6.serviceComponent) == false) goto L63;
    L64:
        String r10 = this.id;
        if (r10 == null) goto L70;
        if (r10.equals(r6.id) == false) goto L71;
    L72:
        CharSequence r11 = this.packageLabel;
        if (r11 == null) goto L76;
        return r11.equals(r6.packageLabel);
    L76:
        if (r6.packageLabel != null) goto L79;
        return true;
    L79:
        return false;
    L71:
        return false;
    L70:
        if (r6.id == null) goto L72;
    L63:
        return false;
    L62:
        if (r6.serviceComponent == null) goto L64;
    L55:
        return false;
    L54:
        if (r6.defaultConditionId == null) goto L56;
    L47:
        return false;
    L46:
        if (r6.configurationActivity == null) goto L48;
    L39:
        return false;
    L38:
        if (r6.settingsAction == null) goto L40;
    L31:
        return false;
    L30:
        if (r6.title == null) goto L32;
    L23:
        return false;
    L22:
        if (r6.packageName == null) goto L24;
        goto L23
    }
}
