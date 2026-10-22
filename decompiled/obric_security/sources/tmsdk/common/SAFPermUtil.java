package tmsdk.common;

import android.app.Activity;
import android.content.Intent;
import android.content.UriPermission;
import android.net.Uri;
import android.os.Build;
import android.provider.saf.DocumentFile;
import com.bytedanceos.preventdisturb.Contact;
import java.util.Iterator;
import java.util.List;
import tmsdkobf.dc;
import tmsdkobf.q8;

/* JADX INFO: loaded from: classes5.dex */
public class SAFPermUtil {
    public static final int REQUEST_CODE = 1873;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f39a = null;
    private static final String b = null;

    static {
        if (dc.a() == false) goto L5;
        String r0 = "content://com.android.externalstorage.documents/tree/primary%3A/document/primary%3A";
    L6:
        f39a = r0;
        if (dc.a() == false) goto L9;
        String r1 = "content://com.android.externalstorage.documents/tree/primary%3A";
    L10:
        b = r1;
        return;
    L9:
        r1 = "content://com.android.externalstorage.documents/tree/primary%3Aandroid%2Fdata";
        goto L10
    L5:
        r0 = "content://com.android.externalstorage.documents/tree/primary%3Aandroid%2Fdata/document/primary%3Aandroid%2Fdata";
        goto L6
    }

    public SAFPermUtil() {
    }

    public static boolean hasAndroidDataPerm(Activity r4) {
        q8.c("xxq", "hasAndroidDataPerm ｜ Build.VERSION.SDK_INT = " + Build.VERSION.SDK_INT);
        List<UriPermission> r5 = r4.getContentResolver().getPersistedUriPermissions();
        if (r5 != null) goto L5;
        return false;
    L5:
        Iterator<UriPermission> r6 = r5.iterator();
    L7:
        if (r6.hasNext() == false) goto L19;
        UriPermission r1 = r6.next();
        if (r1.getUri() == null) goto L7;
        if (r1.getUri().toString().equals(b) == false) goto L7;
        if (r1.isReadPermission() == false) goto L7;
        if (r1.isWritePermission() == false) goto L7;
        return true;
    L19:
        return false;
    }

    public static void onActivityResult(Activity r0, int r1, int r2, Intent r3) {
        if (r1 == 1873) goto L5;
        return;
    L5:
        if (r3 == null) goto L8;
        persistPerm(r0, r3.getData());
        return;
    }

    public static void persistPerm(Activity r1, Uri r2) {
        if (r1 == null) goto L7;
        if (r2 == null) goto L8;
        r1.getContentResolver().takePersistableUriPermission(r2, 3);
        q8.c("xxq", "persistPerm success");
        return;
    L8:
        return;
    }

    public static Intent requestAndroidDataPerm(Activity r4) {
        Intent r0 = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
        r0.setFlags(195);
        DocumentFile r5 = DocumentFile.fromTreeUri(r4, new Uri.Builder().scheme(Contact.CONTENT_SCHEME).authority("com.android.externalstorage.documents").appendPath("tree").appendPath("primary:A\u200bndroid/data").appendPath("document").appendPath("primary:A\u200bndroid/data").build());
        if (r5 == null) goto L5;
        r0.putExtra("android.provider.extra.INITIAL_URI", r5.getUri());
    L5:
        return r0;
    }
}
