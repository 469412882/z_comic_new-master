package com.android.zhhr.ui.webview;

import android.content.Context;
import android.content.Intent;


/**
 * webview调用类
 *
 * Created by hch on 2017/8/4.
 */

public class WebKit {

    public static class Builder {
        private String title;
        private String url;
        private Context context;
        private boolean showclose;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder showclose(boolean showclose) {
            this.showclose = showclose;
            return this;
        }

        public void openWebPage() {
            /*Intent intent = new Intent(context, BaseWebActivity.class);
            intent.putExtra(BaseWebActivity.WEB_TITLE, title);
            intent.putExtra(BaseWebActivity.WEB_URL, url);
            intent.putExtra(BaseWebActivity.SHOW_CLOSE, showclose);
            context.startActivity(intent);*/
        }
    }
}
