package tmsdkobf;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

/* JADX INFO: loaded from: classes5.dex */
public class r3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f466a;

    public r3(Context r1) {
        this.f466a = r1;
    }

    public String a(int r8, String r9) {
        String r0 = null;
        if (r8 != 0) goto L5;
        Uri r10 = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID");
    L15:
        Uri r2 = r10;
    L16:
        Cursor r7 = this.f466a.getContentResolver().query(r2, null, null, null, null);
        if (r7 != null) goto L19;
        Log.d("VMS_IDLG_SDK_DB", "return cursor is null,return");
    L23:
        return r0;
    L19:
        if (r7.moveToNext() == false) goto L21;
        r0 = r7.getString(r7.getColumnIndex("value"));
    L21:
        r7.close();
        goto L23
    L5:
        if (r8 != 1) goto L7;
        r10 = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + r9);
        goto L15
    L7:
        if (r8 != 2) goto L9;
        r10 = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + r9);
        goto L15
    L9:
        if (r8 == 4) goto L11;
        r2 = null;
        goto L16
    L11:
        r10 = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAIDSTATUS");
        goto L15
    }
}
