package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.lisitem.OCardListItem;

/* JADX INFO: loaded from: classes2.dex */
public final class ItemConversationBinding implements ViewBinding {
    public final OCardListItem itemBubble;
    public final OCardListItem itemConversation;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ItemConversationBinding(LinearLayout r1, OCardListItem r2, OCardListItem r3) {
        this.rootView = r1;
        this.itemBubble = r2;
        this.itemConversation = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemConversationBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemConversationBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.item_conversation, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ItemConversationBinding bind(View r3) {
        int r0 = R.id.item_bubble;
        OCardListItem r1 = (OCardListItem) ViewBindings.findChildViewById(r3, R.id.item_bubble);
        if (r1 == null) goto L9;
        r0 = R.id.item_conversation;
        OCardListItem r2 = (OCardListItem) ViewBindings.findChildViewById(r3, R.id.item_conversation);
        if (r2 == null) goto L9;
        return new ItemConversationBinding((LinearLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
