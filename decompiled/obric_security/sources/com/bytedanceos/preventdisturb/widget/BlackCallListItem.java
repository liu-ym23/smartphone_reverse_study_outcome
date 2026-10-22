package com.bytedanceos.preventdisturb.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import bytedanceos.util.LogTag;
import com.bytedanceos.preventdisturb.Contact;
import com.bytedanceos.preventdisturb.DisturbActivity;
import com.bytedanceos.preventdisturb.StringUtils;
import com.bytedanceos.preventdisturb.ToastUtils;
import com.bytedanceos.security.Utils;
import com.bytedanceos.utils.OCardListItemExtKt;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.security.R;

/* JADX INFO: loaded from: classes2.dex */
public class BlackCallListItem extends FrameLayout implements Contact.UpdateListener {
    private static final boolean DEBUG = false;
    public static final StyleSpan STYLE_BOLD = null;
    private static final String TAG = "BlackCallListItem";
    private int mBlacklistId;
    private Contact mContact;
    private Handler mHandler;
    private String mHighlight;
    private int mId;
    private OCardListItem mListItem;
    private String mNumber;
    public ImageView mScrollDelBtn;
    public ImageView mScrollUnBlockBtn;
    private int mWhitelistId;

    private void updateAvatarView() {
    }

    private void updateConversationStatus() {
    }

    static /* synthetic */ Contact access$000(BlackCallListItem r0) {
        return r0.mContact;
    }

    static /* synthetic */ void access$100(BlackCallListItem r0) {
        r0.updateFromView();
    }

    static /* synthetic */ void access$200(BlackCallListItem r0) {
        r0.updateScrollBtnsStatus();
    }

    static {
        STYLE_BOLD = new StyleSpan(1);
    }

    public BlackCallListItem(Context context) {
        super(context);
        this.mHandler = new Handler();
    }

    public BlackCallListItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mHandler = new Handler();
    }

    private CharSequence formatMessage() {
        SpannableStringBuilder r0 = new SpannableStringBuilder();
        Contact r1 = this.mContact;
        if (r1 == null) goto L29;
        String r2 = r1.getNumber();
        if (r2.length() <= 11) goto L10;
        if (r2.startsWith("12520") == false) goto L10;
        r0.append(getResources().getString(R.string.feixin_prefix));
    L10:
        if (TextUtils.isEmpty(this.mHighlight) == false) goto L12;
    L27:
        r0.append(this.mContact.getName(true));
        goto L29
    L12:
        if (this.mHighlight.length() == 1) goto L27;
        String r3 = this.mContact.getName();
        if (this.mContact.existsInDatabase() == false) goto L17;
    L26:
        r0.append(r3);
        goto L29
    L17:
        if (TextUtils.isEmpty(this.mContact.getNameNotNumber(false)) == false) goto L26;
        if (this.mContact.isEmail() == true) goto L26;
        if (r2.contains(" ") == false) goto L23;
    L25:
        r0.append(StringUtils.formatHighlightOnlyPhoneNumber(getContext(), r2, this.mHighlight));
        goto L29
    L23:
        if (r2.contains("-") == true) goto L25;
    L29:
        return StringUtils.formatHighlight(getContext(), r0, this.mHighlight);
    }

    private void updateFromView() {
        this.mListItem.setTitle(formatMessage());
        updateAvatarView();
    }

    @Override // com.bytedanceos.preventdisturb.Contact.UpdateListener
    public void onUpdate(final Contact updated) {
        this.mHandler.post(new AnonymousClass1(this, updated));
    }

    public final void bind(final Context context, final Cursor cursor, String highlight) {
        OCardListItem r0 = (OCardListItem) findViewById(R.id.convertion_list_item_oswipe);
        this.mListItem = r0;
        r0.setCardPosition(2);
        this.mListItem.setCardType(0);
        resetSwipeClick(this.mListItem);
        this.mHighlight = highlight;
        OCardListItemExtKt.setTailType(this.mListItem, 0);
        updateConversationStatus();
        this.mId = cursor.getInt(0);
        this.mWhitelistId = cursor.getInt(5);
        this.mBlacklistId = cursor.getInt(6);
        String r12 = cursor.getString(2);
        final String r7 = cursor.getString(1);
        this.mNumber = r7;
        this.mContact = Contact.get(r7, false);
        if (TextUtils.isEmpty(r12) == false) goto L5;
        this.mListItem.setTitle(formatMessage());
        this.mListItem.setSubTitle(null);
    L6:
        final long r5 = cursor.getInt(4);
        if (r5 <= 9999) goto L9;
        String r11 = getResources().getString(R.string.intercept_total_calllog_times_more_ten_thousand);
    L10:
        OCardListItemExtKt.setEndText(this.mListItem, r11);
        this.mListItem.setOnContentClickListener(new BlackCallListItem$$ExternalSyntheticLambda0(this, r5, r7, context));
        this.mListItem.setOnContentLongClickListener(new BlackCallListItem$$ExternalSyntheticLambda1());
        Contact.addListener(this);
        updateScrollBtnsStatus();
        updateAvatarView();
        return;
    L9:
        r11 = getResources().getString(R.string.intercept_total_calllog_times, new Object[]{Long.valueOf(r5)});
        goto L10
    L5:
        this.mListItem.setTitle(r12);
        this.mListItem.setSubTitle(r7);
        goto L6
    }

    /* JADX INFO: renamed from: lambda$bind$0$com-bytedanceos-preventdisturb-widget-BlackCallListItem, reason: not valid java name */
    /* synthetic */ void m123x12bb083(long r2, String r4, Context r5, View r6) {
        LogTag.d(TAG, "onCallListItemClick is called key " + getId());
        ComponentName r1 = new ComponentName("com.obric.security", "com.obric.securitycenter.nodisturb.InterceptDetailActivity");
        Intent r7 = new Intent();
        r7.setComponent(r1);
        r7.putExtra("call_intercept_count", r2);
        r7.putExtra(DisturbActivity.CALL_PHONE_NUMBER, r4);
        r7.putExtra(Utils.INTENT_KEY_FROM_CENTER, true);
        r5.startActivity(r7);
    }

    static /* synthetic */ boolean lambda$bind$1(View r0) {
        ToastUtils.show(R.string.toast_swipe_left);
        return true;
    }

    private void resetSwipeClick(OCardListItem card) {
        card.setSwipeView(R.layout.layout_intercept_swip);
        card.setEnableSwipe(true);
        card.swipeClose();
        this.mScrollUnBlockBtn = (ImageView) card.getSwipeView().findViewById(R.id.scroll_unblock_btn);
        this.mScrollDelBtn = (ImageView) card.getSwipeView().findViewById(R.id.scroll_del_btn);
    }

    private void updateScrollBtnsStatus() {
        this.mScrollDelBtn.setTag(this.mNumber);
        this.mScrollUnBlockBtn.setTag(this.mNumber);
        if (this.mWhitelistId < 0) goto L5;
        this.mScrollUnBlockBtn.setVisibility(8);
        return;
    L5:
        this.mScrollUnBlockBtn.setVisibility(0);
    }

    public final void unbind() {
        Contact.removeListener(this);
    }

    @Override // android.view.View
    public int getId() {
        return this.mId;
    }

    private Bitmap Bytes2Bimap(byte[] b) {
        if (b.length != 0) goto L5;
        return null;
    L5:
        return BitmapFactory.decodeByteArray(b, 0, b.length);
    }
}
