package com.bytedanceos.preventdisturb;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.LruCache;
import com.bytedanceos.numberassistant.xysdk.XySdkCallBack;
import com.bytedanceos.numberassistant.xysdk.XySdkParserItem;
import com.bytedanceos.preventdisturb.widget.MyURLSpan;
import com.obric.olog.OLog;
import com.obric.security.R;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes2.dex */
public class SmsXySdkManager {
    public static final String EXPRESS_QUERY_NUMBER_EXTRA = "EXPRESS_QUERY_NUMBER_EXTRA";
    public static final String EXPRESS_QUERY_URL = "http://android.bizport.cn:9998/AndroidWeb/H5Service?actionType=WEB_QUERY_EXPRESS_DELIVERY&channelId=BYTEDANCE&ex_num=";
    private static final String EXTRA_RECHARGE_NUMBER_KEY = "phone_number";
    private static final String EXTRA_RECHARGE_TYPE_KEY = "recharge_type";
    private static final String RECHARGE_ACTIVITY = "com.bytedanceos.recharge.activity.RechargeServiceActivity";
    private static final String RECHARGE_PACKAGE = "com.bytedanceos.recharge";
    private static final String TAG = "XiaoYuanManager";
    private static final String TEXT_ADDRESS = "[ADDRESS]";
    private static final String TEXT_EXPRESS = "[EXPRESS]";
    private static final String TEXT_WARNING = "[WARNING]";
    private Drawable mAddressDrawable;
    private Drawable mExpressDrawable;
    private Drawable mWarningDrawable;
    private int mWarningUrlSpanColor;
    private ExecutorService mXySdkExecutor;
    private LruCache<String, NumberParserItem> mXySdkNumberParserItems;
    private LruCache<CacheKey, XySdkParserItem> mXySdkParserItems;

    public static class CacheKey {
        String body;
        long date;
        long msgId;

        public CacheKey(long msgId, long date, String body) {
            this.msgId = msgId;
            this.date = date;
            this.body = body;
        }

        public boolean equals(Object obj) {
            if ((obj instanceof CacheKey) == true) goto L5;
            return false;
        L5:
            CacheKey r7 = (CacheKey) obj;
            if (this.msgId == r7.msgId) goto L8;
            return false;
        L8:
            if (this.date == r7.date) goto L10;
            return false;
        L10:
            if (TextUtils.equals(this.body, r7.body) == false) goto L15;
            return true;
        L15:
            return false;
        }

        public int hashCode() {
            if (this.body != null) goto L5;
            this.body = "";
        L5:
            int r0 = this.body.hashCode();
            long r1 = this.msgId;
            return r0 + ((int) (r1 ^ (r1 >>> 32)));
        }
    }

    private static class Hold {
        private static final SmsXySdkManager sInstance = null;

        private Hold() {
        }

        static /* synthetic */ SmsXySdkManager access$100() {
            return sInstance;
        }

        static {
            sInstance = new SmsXySdkManager(null);
        }
    }

    public static class NumberParserItem {
        public Bitmap logo;
        public String logoName;

        public NumberParserItem() {
        }

        public NumberParserItem(String logoName, Bitmap logo) {
            this.logoName = logoName;
            this.logo = logo;
        }
    }

    /* synthetic */ SmsXySdkManager(AnonymousClass1 r1) {
        this();
    }

    private SmsXySdkManager() {
        this.mXySdkExecutor = Executors.newSingleThreadExecutor();
        this.mXySdkParserItems = new LruCache(128);
        this.mXySdkNumberParserItems = new LruCache(128);
    }

    public static SmsXySdkManager getInstance() {
        return Hold.access$100();
    }

    public int getType(CacheKey key) {
        if (key == null) goto L6;
        XySdkParserItem r0 = this.mXySdkParserItems.get(key);
        if (r0 == null) goto L6;
        return r0.type;
    L6:
        return -2016;
    }

    public NumberParserItem getNumberParserItem(String number) {
        if (TextUtils.isEmpty(number) == false) goto L7;
        return null;
    L7:
        return this.mXySdkNumberParserItems.get(number);
    }

    public void putNumberParserItem(String number, NumberParserItem numberParserItem) {
        if (TextUtils.isEmpty(number) == true) goto L8;
        if (numberParserItem == null) goto L9;
        this.mXySdkNumberParserItems.put(number, numberParserItem);
        return;
    L9:
        return;
    }

    public boolean isRechargeType(CacheKey key) {
        if (getType(key) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isWebTrafficOrderType(CacheKey key) {
        if (getType(key) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean hasWarningUrl(CacheKey key) {
        if (key == null) goto L12;
        XySdkParserItem r0 = this.mXySdkParserItems.get(key);
        if (r0 == null) goto L17;
        Iterator<XySdkParserItem.UrlItem> r1 = r0.urlItems.iterator();
    L7:
        if (r1.hasNext() == false) goto L18;
        if (r1.next().isWarningUrl == false) goto L7;
        return true;
    L18:
        return false;
    L17:
        return false;
    L12:
        return false;
    }

    public synchronized XySdkParserItem getXySdkParserItem(CacheKey key) {
        monitor-enter(this);
        if (key != null) goto L13;
        monitor-exit(this);
        return null;
    L13:
        XySdkParserItem r2 = this.mXySdkParserItems.get(key);     // Catch: Throwable -> L10
        monitor-exit(this);
        return r2;
    L10:
        th = move-exception;
        throw th;
    }

    public synchronized void putXySdkParserItem(CacheKey key, XySdkParserItem item) {
        monitor-enter(this);
        if (key == null) goto L12;
        if (item == null) goto L12;
        this.mXySdkParserItems.put(key, item);     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    L12:
        monitor-exit(this);
    }

    public void parseMessageByXySdk(final long msgId, final String address, final String body, final long date, final XySdkCallBack xySdkCallBack, final boolean scrollFing, final boolean async) {
        Runnable r10 = new AnonymousClass1(this, msgId, address, body, date, xySdkCallBack, scrollFing);
        if (async == true) goto L5;
        r10.run();
        return;
    L5:
        this.mXySdkExecutor.execute(r10);
    }

    public SpannableStringBuilder formatSafely(Context context, CharSequence body, XySdkParserItem item, MyURLSpan.OnClickListener listener) {
        return format(context, body, item, listener);
    L4:
        e = move-exception;
        OLog.e(TAG, "format xy sdk Exception", e);
        return new SpannableStringBuilder(body);
    }

    private SpannableStringBuilder format(Context context, CharSequence body, XySdkParserItem item, MyURLSpan.OnClickListener listener) {
        SpannableStringBuilder r1 = new SpannableStringBuilder(body);
        PorterDuffColorFilter r2 = new PorterDuffColorFilter(context.getResources().getColor(R.color.bytedanceos_blue_light), PorterDuff.Mode.SRC_IN);
        Iterator<XySdkParserItem.UrlItem> r3 = item.urlItems.iterator();
    L4:
        if (r3.hasNext() == false) goto L60;
        XySdkParserItem.UrlItem r4 = r3.next();
        int r5 = r4.type;
        ImageSpan r7 = null;
        boolean r8 = true;
        int r9 = 0;
        if (r5 == 3) goto L31;
        if (r5 == 7) goto L22;
        if (r5 == 12) goto L13;
    L11:
        String r6 = null;
        r8 = false;
    L39:
        if (r8 == false) goto L4;
        int r10 = r1.length();
        if (r10 < 0) goto L52;
        MyURLSpan[] r11 = (MyURLSpan[]) r1.getSpans(0, r10, MyURLSpan.class);
        int r12 = r11.length;
        int r13 = 0;
    L44:
        if (r13 >= r12) goto L52;
        MyURLSpan r14 = r11[r13];
        int r15 = r1.getSpanStart(r14);
        if (r1.getSpanEnd(r14) <= r4.startIndex) goto L50;
        if (r15 > r4.endIndex) goto L50;
        r1.removeSpan(r14);
    L50:
        r13 = r13 + 1;
    L52:
        if (r4.isWarningUrl == true) goto L54;
    L57:
        MyURLSpan r16 = new MyURLSpan(r4.text, listener);
        r16.setLinkColor(r9);
        r16.setUrlItem(r4);
        r1.setSpan(r16, r4.startIndex, r4.endIndex, 34);
        r1.insert(r4.startIndex, r6);
        if (r7 == null) goto L4;
        r1.setSpan(r7, r4.startIndex, r4.startIndex + r6.length(), 34);
        goto L4
    L54:
        if (this.mWarningUrlSpanColor != 0) goto L56;
        this.mWarningUrlSpanColor = context.getResources().getColor(R.color.warning_url_span_color);
    L56:
        r9 = this.mWarningUrlSpanColor;
        goto L57
    L13:
        if (this.mExpressDrawable != null) goto L17;
        Drawable r17 = context.getResources().getDrawable(R.drawable.text_express);
        this.mExpressDrawable = r17;
        if (r17 == null) goto L17;
        r17.setBounds(0, 0, r17.getIntrinsicWidth(), this.mExpressDrawable.getIntrinsicHeight());
    L17:
        Drawable r18 = this.mExpressDrawable;
        if (r18 == null) goto L20;
        r18.setColorFilter(r2);
        r7 = new ImageSpan(this.mExpressDrawable, 1);
    L20:
        r6 = TEXT_EXPRESS;
        goto L39
    L22:
        if (this.mAddressDrawable != null) goto L26;
        Drawable r19 = context.getResources().getDrawable(R.drawable.text_address);
        this.mAddressDrawable = r19;
        if (r19 == null) goto L26;
        r19.setBounds(0, 0, r19.getIntrinsicWidth(), this.mAddressDrawable.getIntrinsicHeight());
    L26:
        Drawable r20 = this.mAddressDrawable;
        if (r20 == null) goto L29;
        r20.setColorFilter(r2);
        r7 = new ImageSpan(this.mAddressDrawable, 1);
    L29:
        r6 = TEXT_ADDRESS;
        goto L39
    L31:
        if (r4.isWarningUrl == false) goto L11;
        if (this.mWarningDrawable != null) goto L38;
        Drawable r21 = context.getResources().getDrawable(R.drawable.text_warning);
        this.mWarningDrawable = r21;
        if (r21 == null) goto L38;
        r21.setBounds(0, 0, r21.getIntrinsicWidth(), this.mWarningDrawable.getIntrinsicHeight());
    L38:
        r7 = new ImageSpan(this.mWarningDrawable, 1);
        r6 = TEXT_WARNING;
        goto L39
    L60:
        return r1;
    }

    public boolean onXiaoYuanSpanClick(Context context, MyURLSpan span) {
        String r4 = span.getSpanString();
        XySdkParserItem.UrlItem r6 = span.getUrlItem();
        if (TextUtils.isEmpty(r4) == true) goto L17;
        if (r6 == null) goto L18;
        int r0 = r6.type;
        if (r0 == 3) goto L12;
        if (r0 != 7) goto L19;
    L14:
        Uri r5 = Uri.parse("geo:0,0?q=" + r4);
        Intent r7 = new Intent("android.intent.action.VIEW");
        r7.setData(r5);
        context.startActivity(r7);
    L16:
        return true;
    L19:
        return false;
    L12:
        if (r6.isWarningUrl == false) goto L14;
    L18:
        return false;
    L17:
        return false;
    }

    public void launchRecharge(Context context, String number, int type) {
        Intent r3 = new Intent();
        r3.setComponent(new ComponentName("com.bytedanceos.recharge", RECHARGE_ACTIVITY));
        r3.setFlags(268435456);
        r3.putExtra(EXTRA_RECHARGE_NUMBER_KEY, number);
        r3.putExtra(EXTRA_RECHARGE_TYPE_KEY, type);
        context.startActivity(r3);
    }
}
