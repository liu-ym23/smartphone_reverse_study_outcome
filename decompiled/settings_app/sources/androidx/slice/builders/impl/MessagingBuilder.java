package androidx.slice.builders.impl;

import android.graphics.drawable.Icon;

/* JADX INFO: loaded from: classes.dex */
public interface MessagingBuilder {

    public interface MessageBuilder {
        void addSource(Icon r1);

        void addText(CharSequence r1);

        void addTimestamp(long r1);
    }

    void add(TemplateBuilderImpl r1);

    TemplateBuilderImpl createMessageBuilder();
}
