package com.bytedanceos.securitycenter.dynamicResolution;

import android.app.IntentService;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Xml;
import com.bytedance.platform.godzilla.common.Constant;
import com.bytedanceos.securitycenter.Utils;
import com.obric.olog.OLog;
import java.io.ByteArrayInputStream;
import java.util.HashSet;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicResolutionDataService extends IntentService {
    private static final String ACTION_FEED_BACK = "com.android.providers.downloads.ACTION_SYNC_DATA_FINISH_FEEDBACK";
    private static final String TAG = "DynamicResolution";
    private static final String TASK_NAME = "pow_display";
    private static final String URI = "content://com.bytedanceos.datasync/sync_datas";
    private String mReceivedMD5;

    public DynamicResolutionDataService() {
        super(TAG);
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        OLog.i(TAG, "onHandleIntent: start, name=" + intent.getStringExtra("name"));
        if (TextUtils.equals(intent.getStringExtra("name"), TASK_NAME) == false) goto L29;
        Cursor r11 = getBaseContext().getContentResolver().query(Uri.parse(URI), null, null, new String[]{TASK_NAME}, null);
        if (r11 != null) goto L7;
        return;
    L7:
        byte[] r1 = null;
        int r2 = r11.getColumnIndex("md5");     // Catch: Throwable -> L18 Exception -> L20
        int r4 = r11.getColumnIndex("data");     // Catch: Throwable -> L18 Exception -> L20
        if (r11.moveToFirst() == false) goto L15;
    L10:
        this.mReceivedMD5 = r11.getString(r2);     // Catch: Throwable -> L18 Exception -> L20
        r1 = r11.getBlob(r4);     // Catch: Throwable -> L18 Exception -> L20
        if (Build.IS_DEBUGGABLE == false) goto L14;
        OLog.i(TAG, new String(r1));     // Catch: Throwable -> L18 Exception -> L20
    L14:
        if (r11.moveToNext() == true) goto L10;
    L15:
        r11.close();
        if (r1 == null) goto L35;
        OLog.i(TAG, "onHandleIntent: updateDataFromRemote triggered");
        updateDataFromRemote(r1);
        return;
    L35:
        return;
    L20:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L18
        r11.close();
        if (r1 == null) goto L37;
        OLog.i(TAG, "onHandleIntent: updateDataFromRemote triggered");
        updateDataFromRemote(r1);
        return;
    L37:
        return;
    L18:
        th = move-exception;
        r11.close();
        if (r1 == null) goto L28;
        OLog.i(TAG, "onHandleIntent: updateDataFromRemote triggered");
        updateDataFromRemote(r1);
    L28:
        throw th;
    }

    private void updateDataFromRemote(byte[] data) {
        ByteArrayInputStream r0 = new ByteArrayInputStream(data);
        XmlPullParser r4 = Xml.newPullParser();
        List<ApplicationConfig> r1 = null;
        r4.setInput(r0, Constant.CHARSET_UTF_8);     // Catch: XmlPullParserException -> L6
        r1 = DynamicResolutionParser.parser(r4);     // Catch: XmlPullParserException -> L6
        if (r1.size() != 0) goto L8;
        return;
    L8:
        StringBuilder r5 = new StringBuilder("updateDataFromRemote: parsed count=");
        if (r1 == null) goto L11;
        int r2 = r1.size();
    L12:
        OLog.i(TAG, r5.append(r2).toString());
        updateDynamicResolutionDB(r1, this);
        Utils.sendCloudFeedBack(this, TASK_NAME, this.mReceivedMD5);
        return;
    L11:
        r2 = 0;
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    private static void updateDynamicResolutionDB(List<ApplicationConfig> result, Context context) {
        if (result != null) goto L4;
        return;
    L4:
        ContentResolver r2 = context.getContentResolver();
        Uri r3 = DynamicResolutionDataHelp.CONTENT_URI;
        Cursor r0 = r2.query(r3, new String[]{"_id", "packageName"}, "installed=? and enable=?", new String[]{"1", "0"}, null);
        HashSet r4 = new HashSet();
        if (r0 == null) goto L11;
        int r1 = r0.getColumnIndex("packageName");
    L8:
        if (r0.moveToNext() == false) goto L10;
        r4.add(r0.getString(r1));
        goto L8
    L10:
        r0.close();
    L11:
        context.getContentResolver().delete(DynamicResolutionDataHelp.CONTENT_URI, null, null);
        DynamicResolutionDataHelp.initData(result, context, null, r4);
    }
}
