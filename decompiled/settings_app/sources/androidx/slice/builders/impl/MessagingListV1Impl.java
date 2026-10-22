package androidx.slice.builders.impl;

import android.graphics.drawable.Icon;
import androidx.core.graphics.drawable.IconCompat;
import androidx.slice.Slice;
import androidx.slice.SliceSpec;

/* JADX INFO: loaded from: classes.dex */
public class MessagingListV1Impl extends TemplateBuilderImpl implements MessagingBuilder {
    private final ListBuilderV1Impl mListBuilder;

    public static final class MessageBuilder extends TemplateBuilderImpl implements MessagingBuilder.MessageBuilder {
        final ListBuilderV1Impl.RowBuilderImpl mListBuilder;

        public MessageBuilder(MessagingListV1Impl r1) {
            this(r1.createChildBuilder());
        }

        private MessageBuilder(Slice.Builder r2) {
            super(r2, null);
            this.mListBuilder = new ListBuilderV1Impl.RowBuilderImpl(r2);
        }

        @Override // androidx.slice.builders.impl.MessagingBuilder.MessageBuilder
        public void addSource(Icon r2) {
            this.mListBuilder.setTitleItem(IconCompat.createFromIcon(r2), 1);
        }

        @Override // androidx.slice.builders.impl.MessagingBuilder.MessageBuilder
        public void addText(CharSequence r1) {
            this.mListBuilder.setSubtitle(r1);
        }

        @Override // androidx.slice.builders.impl.MessagingBuilder.MessageBuilder
        public void addTimestamp(long r1) {
            this.mListBuilder.addEndItem(r1);
        }

        @Override // androidx.slice.builders.impl.TemplateBuilderImpl
        public void apply(Slice.Builder r1) {
            this.mListBuilder.apply(r1);
        }
    }

    public MessagingListV1Impl(Slice.Builder r2, SliceSpec r3) {
        super(r2, r3);
        ListBuilderV1Impl r0 = new ListBuilderV1Impl(r2, r3);
        this.mListBuilder = r0;
        r0.setTtl(-1);
    }

    @Override // androidx.slice.builders.impl.MessagingBuilder
    public void add(TemplateBuilderImpl r1) {
        this.mListBuilder.addRow(((MessageBuilder) r1).mListBuilder);
    }

    @Override // androidx.slice.builders.impl.MessagingBuilder
    public TemplateBuilderImpl createMessageBuilder() {
        return new MessageBuilder(this);
    }

    @Override // androidx.slice.builders.impl.TemplateBuilderImpl
    public void apply(Slice.Builder r1) {
        this.mListBuilder.apply(r1);
    }
}
