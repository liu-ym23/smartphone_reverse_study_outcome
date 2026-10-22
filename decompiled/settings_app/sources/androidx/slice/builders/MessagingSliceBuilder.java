package androidx.slice.builders;

import android.content.Context;
import android.graphics.drawable.Icon;
import android.net.Uri;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.util.Consumer;
import androidx.slice.SliceSpecs;
import androidx.slice.builders.impl.MessagingBasicImpl;
import androidx.slice.builders.impl.MessagingBuilder;
import androidx.slice.builders.impl.MessagingListV1Impl;
import androidx.slice.builders.impl.MessagingV1Impl;
import androidx.slice.builders.impl.TemplateBuilderImpl;

/* JADX INFO: loaded from: classes.dex */
public class MessagingSliceBuilder extends TemplateSliceBuilder {
    public static final int MAXIMUM_RETAINED_MESSAGES = 50;
    MessagingBuilder mBuilder;

    public static final class MessageBuilder extends TemplateSliceBuilder {
        MessagingBuilder.MessageBuilder mImpl;

        public MessageBuilder(MessagingSliceBuilder r1) {
            super(r1.mBuilder.createMessageBuilder());
        }

        public MessageBuilder addSource(Icon r2) {
            this.mImpl.addSource(r2);
            return this;
        }

        public MessageBuilder addSource(IconCompat r2) {
            this.mImpl.addSource(r2.toIcon());
            return this;
        }

        public MessageBuilder addText(CharSequence r2) {
            this.mImpl.addText(r2);
            return this;
        }

        public MessageBuilder addTimestamp(long r2) {
            this.mImpl.addTimestamp(r2);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.slice.builders.TemplateSliceBuilder
        void setImpl(TemplateBuilderImpl r1) {
            this.mImpl = (MessagingBuilder.MessageBuilder) r1;
        }
    }

    public MessagingSliceBuilder(Context r1, Uri r2) {
        super(r1, r2);
    }

    public MessagingSliceBuilder add(MessageBuilder r2) {
        this.mBuilder.add((TemplateBuilderImpl) r2.mImpl);
        return this;
    }

    public MessagingSliceBuilder add(Consumer<MessageBuilder> r2) {
        MessageBuilder r0 = new MessageBuilder(this);
        r2.accept(r0);
        return add(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.slice.builders.TemplateSliceBuilder
    void setImpl(TemplateBuilderImpl r1) {
        this.mBuilder = (MessagingBuilder) r1;
    }

    @Override // androidx.slice.builders.TemplateSliceBuilder
    protected TemplateBuilderImpl selectImpl(Uri r2) {
        if (checkCompatible(SliceSpecs.MESSAGING, r2) == false) goto L7;
        return new MessagingV1Impl(getBuilder(), SliceSpecs.MESSAGING);
    L7:
        if (checkCompatible(SliceSpecs.LIST, r2) == false) goto L11;
        return new MessagingListV1Impl(getBuilder(), SliceSpecs.LIST);
    L11:
        if (checkCompatible(SliceSpecs.BASIC, r2) == true) goto L13;
        return null;
    L13:
        return new MessagingBasicImpl(getBuilder(), SliceSpecs.BASIC);
    }
}
