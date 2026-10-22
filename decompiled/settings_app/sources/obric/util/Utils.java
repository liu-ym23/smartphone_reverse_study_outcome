package obric.util;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Layout;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;

/* JADX INFO: loaded from: classes5.dex */
public class Utils {
    private static final Uri APP_BASE_LAYER_URI = null;
    public static final String BUNDLE_TAG_OPERATOR = "operator";
    private static final String BUNDLE_TAG_SID = "sid";
    public static final String BUNDLE_TAG_SUBID = "subid";
    public static final String KEY_DEVICE_ID = "key_device_info";
    public static final String KEY_OA_ID = "oaid";
    public static final String METHOD_GET_DEVICE_ID = "getDeviceId";
    public static final String METHOD_GET_OA_ID = "request_oaid";
    private static final Uri OA_ID_PROVIDER_URI = null;
    private static final Uri OS_TEA_TRACKER_URI = null;
    public static final String REQUEST_OPERATOR_ID = "request_operator_name";
    private static final String REQUEST_SMARTISAN_ID = "request_smartisan_id";
    public static final String REQUEST_SUBSCRIBER_ID = "request_subscriber_id";
    private static final String TAG = "Utils";

    static {
        APP_BASE_LAYER_URI = Uri.parse("content://com.smartisanos.appbaselayer");
        OS_TEA_TRACKER_URI = Uri.parse("content://os.teatracker");
        OA_ID_PROVIDER_URI = Uri.parse("content://com.obric.idprovider");
    }

    public Utils() {
    }

    public static void resetTextViewFontSizeAttr(Context context, TextView textView, int dimenResId) {
        textView.setTextSize(0, context.getResources().getDimensionPixelSize(dimenResId));
    }

    public static float calculateTextWidth(TextView tv) {
        if (tv != null) goto L5;
        return 0.0f;
    L5:
        Paint r1 = new Paint();
        r1.setTextSize(tv.getTextSize());
        if (tv.getText() != null) goto L9;
        return 0.0f;
    L9:
        return r1.measureText(tv.getText().toString());
    }

    public static boolean isTextEllipsized(TextView textView) {
        Layout r2 = textView.getLayout();
        if (r2 == null) goto L9;
        int r0 = r2.getLineCount();
        if (r0 > 0) goto L7;
        return false;
    L7:
        if (r2.getEllipsisCount(r0 - 1) <= 0) goto L12;
        return true;
    L12:
        return false;
    L9:
        return false;
    }

    public static int dipToPx(Context context, double dipValue) {
        return (int) ((dipValue * ((double) context.getResources().getDisplayMetrics().density)) + 0.5d);
    }

    public static int getDrawableWidth(Drawable drawable) {
        if (drawable != null) goto L5;
        return 0;
    L5:
        return drawable.getIntrinsicWidth();
    }

    public static int getDrawableHeight(Drawable drawable) {
        if (drawable != null) goto L5;
        return 0;
    L5:
        return drawable.getIntrinsicHeight();
    }

    public static void checkArgument(boolean expression) {
        if (expression == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException();
    }

    public static int getTextHeight(Paint paint, String text) {
        if (TextUtils.isEmpty(text) == true) goto L7;
        if (paint == null) goto L7;
        Rect r0 = new Rect();
        paint.getTextBounds(text, 0, text.length(), r0);
        return r0.height();
    L7:
        return 0;
    }

    public static String getObricID(Context context) {
        String r3 = (String) null;     // Catch: Exception -> L5
        Bundle r4 = (Bundle) null;     // Catch: Exception -> L5
        Bundle r5 = context.getContentResolver().call(APP_BASE_LAYER_URI, REQUEST_SMARTISAN_ID, null, null);     // Catch: Exception -> L5
    L7:
        if (r5 == null) goto L12;
        String r1 = (String) null;
        return r5.getString("sid", null);
    L12:
        return null;
    L5:
        e = move-exception;
        Log.w(TAG, e.getMessage());
        r5 = null;
        goto L7
    }

    public static String getSubscriberID(Context context) {
        String r3 = (String) null;     // Catch: Exception -> L5
        Bundle r4 = (Bundle) null;     // Catch: Exception -> L5
        Bundle r5 = context.getContentResolver().call(APP_BASE_LAYER_URI, REQUEST_SUBSCRIBER_ID, null, null);     // Catch: Exception -> L5
    L7:
        if (r5 == null) goto L12;
        String r1 = (String) null;
        return r5.getString(BUNDLE_TAG_SUBID, null);
    L12:
        return null;
    L5:
        e = move-exception;
        Log.w(TAG, e.getMessage());
        r5 = null;
        goto L7
    }

    public static String getOperatorName(Context context) {
        String r3 = (String) null;     // Catch: Exception -> L5
        Bundle r4 = (Bundle) null;     // Catch: Exception -> L5
        Bundle r5 = context.getContentResolver().call(APP_BASE_LAYER_URI, REQUEST_OPERATOR_ID, null, null);     // Catch: Exception -> L5
    L7:
        if (r5 == null) goto L12;
        String r1 = (String) null;
        return r5.getString("operator", null);
    L12:
        return null;
    L5:
        e = move-exception;
        Log.w(TAG, e.getMessage());
        r5 = null;
        goto L7
    }

    public static String getDeviceID(Context context) {
        String r3 = (String) null;     // Catch: Exception -> L5
        Bundle r4 = (Bundle) null;     // Catch: Exception -> L5
        Bundle r5 = context.getContentResolver().call(OS_TEA_TRACKER_URI, "getDeviceId", null, null);     // Catch: Exception -> L5
    L7:
        if (r5 == null) goto L12;
        String r1 = (String) null;
        return r5.getString("key_device_info", null);
    L12:
        return null;
    L5:
        e = move-exception;
        Log.w(TAG, e.getMessage());
        r5 = null;
        goto L7
    }

    public static String getOaID(Context context) {
        String r3 = (String) null;     // Catch: Exception -> L5
        Bundle r4 = (Bundle) null;     // Catch: Exception -> L5
        Bundle r5 = context.getContentResolver().call(OA_ID_PROVIDER_URI, "request_oaid", null, null);     // Catch: Exception -> L5
    L7:
        if (r5 == null) goto L12;
        String r1 = (String) null;
        return r5.getString("oaid", null);
    L12:
        return null;
    L5:
        e = move-exception;
        Log.w(TAG, e.getMessage());
        r5 = null;
        goto L7
    }
}
