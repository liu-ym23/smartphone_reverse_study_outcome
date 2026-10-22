package com.android.settings.applications;

import android.content.Intent;
import android.net.Uri;
import com.android.vcard.VCardConstants;

/* JADX INFO: loaded from: classes2.dex */
public final enum EnterpriseDefaultApps extends Enum<EnterpriseDefaultApps> {
    private static final /* synthetic */ EnterpriseDefaultApps[] $VALUES = null;
    public static final EnterpriseDefaultApps BROWSER = null;
    public static final EnterpriseDefaultApps CALENDAR = null;
    public static final EnterpriseDefaultApps CAMERA = null;
    public static final EnterpriseDefaultApps CONTACTS = null;
    public static final EnterpriseDefaultApps EMAIL = null;
    public static final EnterpriseDefaultApps MAP = null;
    public static final EnterpriseDefaultApps PHONE = null;
    private final Intent[] mIntents;

    private static /* synthetic */ EnterpriseDefaultApps[] $values() {
        return new EnterpriseDefaultApps[]{BROWSER, CALENDAR, CAMERA, CONTACTS, EMAIL, MAP, PHONE};
    }

    public static EnterpriseDefaultApps valueOf(String r1) {
        return (EnterpriseDefaultApps) Enum.valueOf(EnterpriseDefaultApps.class, r1);
    }

    public static EnterpriseDefaultApps[] values() {
        return (EnterpriseDefaultApps[]) $VALUES.clone();
    }

    static {
        BROWSER = new EnterpriseDefaultApps("BROWSER", 0, new Intent[]{buildIntent("android.intent.action.VIEW", "android.intent.category.BROWSABLE", "http:", null)});
        CALENDAR = new EnterpriseDefaultApps("CALENDAR", 1, new Intent[]{buildIntent("android.intent.action.INSERT", null, null, "vnd.android.cursor.dir/event")});
        CAMERA = new EnterpriseDefaultApps("CAMERA", 2, new Intent[]{new Intent("android.media.action.IMAGE_CAPTURE"), new Intent("android.media.action.VIDEO_CAPTURE")});
        CONTACTS = new EnterpriseDefaultApps("CONTACTS", 3, new Intent[]{buildIntent("android.intent.action.PICK", null, null, "vnd.android.cursor.dir/contact")});
        EMAIL = new EnterpriseDefaultApps(VCardConstants.PROPERTY_EMAIL, 4, new Intent[]{new Intent("android.intent.action.SENDTO"), new Intent("android.intent.action.SEND"), new Intent("android.intent.action.SEND_MULTIPLE")});
        MAP = new EnterpriseDefaultApps("MAP", 5, new Intent[]{buildIntent("android.intent.action.VIEW", null, "geo:", null)});
        PHONE = new EnterpriseDefaultApps("PHONE", 6, new Intent[]{new Intent("android.intent.action.DIAL"), new Intent("android.intent.action.CALL")});
        $VALUES = $values();
    }

    private EnterpriseDefaultApps(String r1, int r2, Intent[] r3) {
        super(r1, r2);
        this.mIntents = r3;
    }

    public Intent[] getIntents() {
        return this.mIntents;
    }

    private static Intent buildIntent(String r1, String r2, String r3, String r4) {
        Intent r0 = new Intent(r1);
        if (r2 == null) goto L5;
        r0.addCategory(r2);
    L5:
        if (r3 == null) goto L7;
        r0.setData(Uri.parse(r3));
    L7:
        if (r4 == null) goto L9;
        r0.setType(r4);
    L9:
        return r0;
    }
}
