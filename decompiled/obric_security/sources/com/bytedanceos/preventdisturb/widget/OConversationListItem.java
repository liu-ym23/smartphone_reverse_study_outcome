package com.bytedanceos.preventdisturb.widget;

import android.content.Context;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import bytedanceos.util.LogTag;
import com.bytedanceos.preventdisturb.Contact;
import com.bytedanceos.preventdisturb.Conversation;
import com.bytedanceos.preventdisturb.StringUtils;
import com.bytedanceos.preventdisturb.ToastUtils;
import com.bytedanceos.utils.OCardListItemExtKt;
import com.obric.olog.OLog;
import com.obric.oui.button.OIconButton;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.security.R;

/* JADX INFO: loaded from: classes2.dex */
public class OConversationListItem extends FrameLayout implements Contact.UpdateListener {
    private static final boolean DEBUG = false;
    public static final StyleSpan STYLE_BOLD = null;
    private static final String TAG = "ConversationListItem";
    private Conversation mConversation;
    private Handler mHandler;
    private String mHighlight;
    private OCardListItem mListItemSettings;
    public OIconButton mScrollDelBtn;
    public OIconButton mScrollUnBlockBtn;

    private void updateConversationStatus() {
    }

    static /* synthetic */ Conversation access$000(OConversationListItem r0) {
        return r0.mConversation;
    }

    static /* synthetic */ void access$100(OConversationListItem r0) {
        r0.updateFromView();
    }

    static /* synthetic */ void access$200(OConversationListItem r0) {
        r0.updateScrollBtnsStatus();
    }

    public Conversation getConversation() {
        return this.mConversation;
    }

    static {
        STYLE_BOLD = new StyleSpan(1);
    }

    public OConversationListItem(Context context) {
        this(context, null);
    }

    public OConversationListItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mHandler = new Handler();
    }

    private static void setTextTruncateAtEnd(TextView textView) {
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.END);
    }

    private CharSequence formatMessage() {
        Contact r0 = this.mConversation.getContact();
        SpannableStringBuilder r1 = new SpannableStringBuilder();
        if (r0 == null) goto L29;
        String r2 = r0.getNumber();
        if (r2.length() <= 11) goto L10;
        if (r2.startsWith("12520") == false) goto L10;
        r1.append(getResources().getString(R.string.feixin_prefix));
    L10:
        if (TextUtils.isEmpty(this.mHighlight) == false) goto L12;
    L27:
        r1.append(r0.getName(true));
        goto L29
    L12:
        if (this.mHighlight.length() == 1) goto L27;
        String r3 = r0.getName();
        if (r0.existsInDatabase() == false) goto L17;
    L26:
        r1.append(r3);
        goto L29
    L17:
        if (TextUtils.isEmpty(r0.getNameNotNumber(false)) == false) goto L26;
        if (r0.isEmail() == true) goto L26;
        if (r2.contains(" ") == false) goto L23;
    L25:
        r1.append(StringUtils.formatHighlightOnlyPhoneNumber(getContext(), r2, this.mHighlight));
        goto L29
    L23:
        if (r2.contains("-") == true) goto L25;
    L29:
        return StringUtils.formatHighlight(getContext(), r1, this.mHighlight);
    }

    private CharSequence formatSubject() {
        return StringUtils.formatHighlight(getContext(), this.mConversation.getSnippet(), this.mHighlight);
    }

    private void updateFromView() {
        this.mListItemSettings.setTitle(formatMessage());
    }

    @Override // com.bytedanceos.preventdisturb.Contact.UpdateListener
    public void onUpdate(final Contact updated) {
        if (LogTag.DBG == false) goto L5;
        OLog.v(TAG, "onUpdate: " + this + " contact: " + updated);
    L5:
        this.mHandler.post(new AnonymousClass1(this, updated));
    }

    public final void bind(final Context context, final Conversation conversation, boolean isEditMode, boolean isChecked, String highlight) {
        OCardListItem r2 = (OCardListItem) findViewById(R.id.convertion_list_item_oswipe);     // Catch: Exception -> L8
        this.mListItemSettings = r2;     // Catch: Exception -> L8
        r2.setCardPosition(2);     // Catch: Exception -> L8
        this.mListItemSettings.setCardType(0);     // Catch: Exception -> L8
        resetSwipeClick(this.mListItemSettings);     // Catch: Exception -> L8
        OCardListItemExtKt.setTailType(this.mListItemSettings, 0);     // Catch: Exception -> L8
        this.mConversation = conversation;     // Catch: Exception -> L8
        this.mHighlight = highlight;     // Catch: Exception -> L8
        updateConversationStatus();     // Catch: Exception -> L8
        updateScrollBtnsStatus();     // Catch: Exception -> L8
        this.mListItemSettings.setTitle(formatMessage());     // Catch: Exception -> L8
        this.mListItemSettings.setSubTitle(formatSubject());     // Catch: Exception -> L8
        OCardListItemExtKt.setEndText(this.mListItemSettings, context.getString(R.string.message_count, new Object[]{Integer.valueOf(conversation.getMessageCount())}));     // Catch: Exception -> L8
        this.mListItemSettings.setOnContentClickListener(new AnonymousClass2(this, context));     // Catch: Exception -> L8
        this.mListItemSettings.setOnContentLongClickListener(new OConversationListItem$$ExternalSyntheticLambda0());     // Catch: Exception -> L8
        if (LogTag.DBG == false) goto L6;
        OLog.v(TAG, "bind: contacts.addListeners " + this);     // Catch: Exception -> L8
    L6:
        Contact.addListener(this);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        Contact r9 = this.mConversation.getContact();
        if (r9 == null) goto L12;
        OLog.e(TAG, "contact" + r9.toString());
    L25:
        OLog.e(TAG, "formatMessage :" + formatMessage());     // Catch: Exception -> L15
    L21:
        OLog.e(TAG, "getMessageCount :" + conversation.getMessageCount());     // Catch: Exception -> L18
    L20:
        throw new RuntimeException(e);
    L18:
        OLog.e(TAG, "getMessageCount Exception");
    L15:
        OLog.e(TAG, "formatMessage Exception");
        goto L21
    L12:
        OLog.e(TAG, "contact == null");
        goto L25
    }

    static /* synthetic */ boolean lambda$bind$0(View r0) {
        ToastUtils.show(R.string.toast_swipe_left);
        return true;
    }

    private void resetSwipeClick(OCardListItem card) {
        card.setSwipeView(R.layout.layout_intercept_swip);
        card.setEnableSwipe(true);
        card.swipeClose();
        this.mScrollUnBlockBtn = (OIconButton) card.getSwipeView().findViewById(R.id.scroll_unblock_btn);
        this.mScrollDelBtn = (OIconButton) card.getSwipeView().findViewById(R.id.scroll_del_btn);
    }

    private void updateScrollBtnsStatus() {
        this.mScrollDelBtn.setTag(Long.valueOf(this.mConversation.getThreadId()));
        this.mScrollUnBlockBtn.setTag(Long.valueOf(this.mConversation.getThreadId()));
    }

    public final void unbind() {
        Contact.removeListener(this);
    }
}
