package com.bytedanceos.preventdisturb.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedanceos.preventdisturb.Contact;
import com.bytedanceos.preventdisturb.Conversation;
import com.bytedanceos.preventdisturb.ConversationAdapterAnimHelper;
import com.bytedanceos.preventdisturb.StringUtils;
import com.obric.security.R;

/* JADX INFO: loaded from: classes2.dex */
public class ConversationListItem extends RelativeLayout implements Contact.UpdateListener {
    private static final boolean DEBUG = false;
    public static final StyleSpan STYLE_BOLD = null;
    private static final String TAG = "ConversationListItem";
    private ConversationAdapterAnimHelper mAnimHelper;
    private ImageView mArrow;
    private View mAvatarLayout;
    private AvatarImageView mAvatarView;
    private ImageView mCheckView;
    private Conversation mConversation;
    private TextView mDateView;
    private TextView mFromView;
    private ImageView mGuardrailView;
    private Handler mHandler;
    private String mHighlight;
    private ImageView mScrollDelBtn;
    private ImageView mScrollUnBlockBtn;
    private ImageView mStatusLight;
    private TextView mSubjectView;

    static /* synthetic */ Conversation access$000(ConversationListItem r0) {
        return r0.mConversation;
    }

    static /* synthetic */ void access$100(ConversationListItem r0) {
        r0.updateFromView();
    }

    static /* synthetic */ void access$200(ConversationListItem r0) {
        r0.updateScrollBtnsStatus();
    }

    public Conversation getConversation() {
        return this.mConversation;
    }

    static {
        STYLE_BOLD = new StyleSpan(1);
    }

    public ConversationListItem(Context context) {
        super(context);
        this.mHandler = new Handler();
    }

    public ConversationListItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mHandler = new Handler();
    }

    public View getAvatarLayout() {
        return this.mAvatarLayout;
    }

    public AvatarImageView getAvatar() {
        return this.mAvatarView;
    }

    public ImageView getGuardrailView() {
        return this.mGuardrailView;
    }

    public ImageView getArrow() {
        return this.mArrow;
    }

    public ImageView getStatusView() {
        return this.mStatusLight;
    }

    public View getCheckView() {
        return this.mCheckView;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mFromView = (TextView) findViewById(R.id.from);
        this.mSubjectView = (TextView) findViewById(R.id.subject);
        this.mDateView = (TextView) findViewById(R.id.date);
        this.mAvatarLayout = findViewById(R.id.avatar_layout);
        this.mAvatarView = (AvatarImageView) findViewById(R.id.avatar);
        this.mGuardrailView = (ImageView) findViewById(R.id.guardrail);
        this.mCheckView = (ImageView) findViewById(R.id.conversation_choice);
        this.mScrollDelBtn = (ImageView) findViewById(R.id.scroll_del_btn);
        this.mScrollUnBlockBtn = (ImageView) findViewById(R.id.scroll_unblock_btn);
        this.mStatusLight = (ImageView) findViewById(R.id.status_light);
        this.mArrow = (ImageView) findViewById(R.id.arrow);
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

    private void updateAvatarView() {
        Contact r0 = this.mConversation.getContact();
        if (r0 != null) goto L5;
        return;
    L5:
        Drawable r1 = r0.getAvatar(getContext(), null);
        this.mAvatarView.setImageDrawable(r1);
        this.mAvatarView.setName(r0.getNameNotNumber(true));
        this.mAvatarView.setClassify(r0.getClassify());
        this.mAvatarView.setIsSpam(true);
        this.mAvatarView.setIsGroup(false);
        this.mAvatarView.setIsInDatabase(r0.existsInDatabase());
        if (this.mAvatarView.getLogo() == r0.getLogo()) goto L9;
        this.mAvatarView.setLogo(r0.getLogo());
    L9:
        if (this.mAnimHelper.isBlacklistAnimPlaying() == true) goto L12;
        this.mGuardrailView.setAlpha(1.0f);
        return;
    }

    private void updateFromView() {
        this.mFromView.setText(formatMessage());
        updateAvatarView();
    }

    @Override // com.bytedanceos.preventdisturb.Contact.UpdateListener
    public void onUpdate(final Contact updated) {
        this.mHandler.post(new AnonymousClass1(this, updated));
    }

    public final void bind(Context context, final Conversation conversation, boolean isEditMode, boolean isChecked, String highlight, ConversationAdapterAnimHelper animHelper) {
        this.mConversation = conversation;
        this.mAnimHelper = animHelper;
        this.mHighlight = highlight;
        updateConversationStatus();
        updateScrollBtnsStatus();
        this.mDateView.setText(context.getString(R.string.message_count, new Object[]{Integer.valueOf(conversation.getMessageCount())}));
        this.mFromView.setText(formatMessage());
        this.mSubjectView.setText(formatSubject());
        Contact.addListener(this);
        this.mCheckView.setActivated(isChecked);
        updateAvatarView();
    }

    private void updateConversationStatus() {
        if (this.mAnimHelper.isMarkReadAnimPlaying() == false) goto L5;
        return;
    L5:
        if (this.mConversation.hasError() == false) goto L8;
        int r0 = 1;
    L11:
        if (r0 <= (-1)) goto L13;
        this.mStatusLight.getDrawable().setLevel(r0);
        this.mStatusLight.setVisibility(0);
        return;
    L13:
        this.mStatusLight.setVisibility(8);
        return;
    L8:
        if (this.mConversation.isUnread() == false) goto L10;
        r0 = 0;
        goto L11
    L10:
        r0 = -1;
        goto L11
    }

    private void updateScrollBtnsStatus() {
        this.mScrollDelBtn.setTag(Long.valueOf(this.mConversation.getThreadId()));
        this.mScrollUnBlockBtn.setTag(Long.valueOf(this.mConversation.getThreadId()));
        if (this.mConversation.isSpamCon() == false) goto L5;
        this.mScrollDelBtn.setImageResource(R.drawable.spam_delete_selector);
    L5:
        Contact r0 = this.mConversation.getContact();
        ImageView r3 = this.mScrollUnBlockBtn;
        if (r0.isInBlacklist() == false) goto L8;
        int r1 = R.drawable.block_selector;
    L9:
        r3.setImageResource(r1);
        return;
    L8:
        r1 = R.drawable.unblock_selector;
        goto L9
    }

    public final void unbind() {
        Contact.removeListener(this);
    }
}
