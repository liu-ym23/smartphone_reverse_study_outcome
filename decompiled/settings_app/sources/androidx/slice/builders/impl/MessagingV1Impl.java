package androidx.slice.builders.impl;

import android.graphics.drawable.Icon;
import androidx.core.graphics.drawable.IconCompat;
import androidx.slice.Slice;
import androidx.slice.SliceSpec;

/* JADX INFO: loaded from: classes.dex */
public class MessagingV1Impl extends TemplateBuilderImpl implements MessagingBuilder {

    public static final class MessageBuilder extends TemplateBuilderImpl implements MessagingBuilder.MessageBuilder {
        @Override // androidx.slice.builders.impl.TemplateBuilderImpl
        public void apply(Slice.Builder r1) {
        }

        public MessageBuilder(MessagingV1Impl r2) {
            super(r2.createChildBuilder(), null);
        }

        @Override // androidx.slice.builders.impl.MessagingBuilder.MessageBuilder
        public void addSource(Icon r3) {
            getBuilder().addIcon(IconCompat.createFromIcon(r3), "source", new String[0]);
        }

        @Override // androidx.slice.builders.impl.MessagingBuilder.MessageBuilder
        public void addText(CharSequence r3) {
            getBuilder().addText(r3, null, new String[0]);
        }

        @Override // androidx.slice.builders.impl.MessagingBuilder.MessageBuilder
        public void addTimestamp(long r3) {
            getBuilder().addTimestamp(r3, null, new String[0]);
        }
    }

    @Override // androidx.slice.builders.impl.TemplateBuilderImpl
    public void apply(Slice.Builder r1) {
    }

    public MessagingV1Impl(Slice.Builder r1, SliceSpec r2) {
        super(r1, r2);
    }

    @Override // androidx.slice.builders.impl.MessagingBuilder
    public void add(TemplateBuilderImpl r2) {
        getBuilder().addSubSlice(r2.build(), "message");
    }

    @Override // androidx.slice.builders.impl.MessagingBuilder
    public TemplateBuilderImpl createMessageBuilder() {
        return new MessageBuilder(this);
    }
}
