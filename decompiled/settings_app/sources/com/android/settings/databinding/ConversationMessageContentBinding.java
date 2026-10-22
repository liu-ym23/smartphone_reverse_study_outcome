package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.display.MessageBubbleBackground;

/* JADX INFO: loaded from: classes2.dex */
public final class ConversationMessageContentBinding implements ViewBinding {
    public final LinearLayout messageContent;
    public final TextView messageStatus;
    public final TextView messageText;
    public final MessageBubbleBackground messageTextAndInfo;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ConversationMessageContentBinding(LinearLayout r1, LinearLayout r2, TextView r3, TextView r4, MessageBubbleBackground r5) {
        this.rootView = r1;
        this.messageContent = r2;
        this.messageStatus = r3;
        this.messageText = r4;
        this.messageTextAndInfo = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ConversationMessageContentBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ConversationMessageContentBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.conversation_message_content, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ConversationMessageContentBinding bind(View r6) {
        LinearLayout r2 = (LinearLayout) r6;
        int r0 = R.id.message_status;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r6, R.id.message_status);
        if (r3 == null) goto L11;
        r0 = R.id.message_text;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r6, R.id.message_text);
        if (r4 == null) goto L11;
        r0 = R.id.message_text_and_info;
        MessageBubbleBackground r5 = (MessageBubbleBackground) ViewBindings.findChildViewById(r6, R.id.message_text_and_info);
        if (r5 == null) goto L11;
        return new ConversationMessageContentBinding(r2, r2, r3, r4, r5);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r0)));
    }
}
