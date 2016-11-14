package com.xiaohongshu.richmodule.bean;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;

import com.xiaohongshu.richmodule.R;
import com.xiaohongshu.richmodule.view.CenteredImageSpan;

/**
 * Created by wupengjian on 16/11/14.
 */
public class NewTopicRichParser extends AbstractRichParser {

    @Override
    public String getRichPattern() {
        return "#[^#]+[$#]";
    }

    @Override
    public String getRichText(String richStr) {
        return String.format("#%s#", richStr);
    }

    @Override
    public SpannableString getRichSpannable(Context context, String richStr) {

        if (TextUtils.isEmpty(richStr)) {
            return new SpannableString("");
        }
        String str = richStr;
        SpannableString spannableString = new SpannableString(str);
        //color spannable
//        int color = Color.rgb((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
        ForegroundColorSpan highLightSpan = new ForegroundColorSpan(Color.parseColor("#0099FF"));
        spannableString.setSpan(highLightSpan, 0, str.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        ImageSpan imageSpan = new CenteredImageSpan(context, R.mipmap.transparent);
        spannableString.setSpan(imageSpan, 0, 1, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        imageSpan = new CenteredImageSpan(context, R.mipmap.transparent);
        spannableString.setSpan(imageSpan, str.length() - 1, str.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        return spannableString;
    }
}
