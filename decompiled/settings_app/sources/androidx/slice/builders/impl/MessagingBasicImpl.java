package androidx.slice.builders.impl;

import android.graphics.drawable.Icon;
import androidx.core.graphics.drawable.IconCompat;
import androidx.slice.Slice;
import androidx.slice.SliceSpec;

/* JADX INFO: loaded from: classes.dex */
public class MessagingBasicImpl extends TemplateBuilderImpl implements MessagingBuilder {
    private MessageBuilder mLastMessage;

    public static final class MessageBuilder extends TemplateBuilderImpl implements MessagingBuilder.MessageBuilder {
        Slice mIcon;
        CharSequence mText;
        long mTimestamp;

        @Override // androidx.slice.builders.impl.TemplateBuilderImpl
        public void apply(Slice.Builder r1) {
        }

        public MessageBuilder(MessagingBasicImpl r1) {
            this(r1.createChildBuilder());
        }

        private MessageBuilder(Slice.Builder r2) {
            super(r2, null);
        }

        @Override // androidx.slice.builders.impl.MessagingBuilder.MessageBuilder
        public void addSource(Icon r4) {
            this.mIcon = getBuilder().addIcon(IconCompat.createFromIcon(r4), "source", new String[]{"no_tint"}).addHints(new String[]{"title"}).build();
        }

        @Override // androidx.slice.builders.impl.MessagingBuilder.MessageBuilder
        public void addText(CharSequence r1) {
            this.mText = r1;
        }

        @Override // androidx.slice.builders.impl.MessagingBuilder.MessageBuilder
        public void addTimestamp(long r1) {
            this.mTimestamp = r1;
        }
    }

    public MessagingBasicImpl(Slice.Builder r1, SliceSpec r2) {
        super(r1, r2);
    }

    @Override // androidx.slice.builders.impl.TemplateBuilderImpl
    public void apply(Slice.Builder r4) {
        if (this.mLastMessage == null) goto L12;
        Slice.Builder r0 = new Slice.Builder(getBuilder()).addHints(new String[]{"list_item"});
        if (this.mLastMessage.mIcon == null) goto L8;
        r0.addSubSlice(this.mLastMessage.mIcon);
    L8:
        if (this.mLastMessage.mText == null) goto L10;
        r0.addText(this.mLastMessage.mText, null, new String[0]);
    L10:
        r4.addSubSlice(r0.build());
        return;
    }

    @Override // androidx.slice.builders.impl.MessagingBuilder
    public void add(TemplateBuilderImpl r5) {
        MessageBuilder r6 = (MessageBuilder) r5;
        MessageBuilder r0 = this.mLastMessage;
        if (r0 != null) goto L5;
    L6:
        this.mLastMessage = r6;
        return;
    L5:
        if (r0.mTimestamp < r6.mTimestamp) goto L6;
    }

    @Override // androidx.slice.builders.impl.MessagingBuilder
    public TemplateBuilderImpl createMessageBuilder() {
        return new MessageBuilder(this);
    }
}
