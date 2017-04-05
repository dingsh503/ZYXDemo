package net.iclassmate.zyxdemo.utils;

/**
 * Created by xydbj on 2016.11.15.
 */
public class HttpManager {

    private CallBackData callBackData;

    public HttpManager(CallBackData callBackData) {
        this.callBackData = callBackData;
    }

//    public void getUserInformation(String userId) {
//        OkHttpClient client = new OkHttpClient();
//        Request request = new Request.Builder()
//                .get()
//                .url("http://space.iclassmate.cn:10000/space/api/v1/user/findUserInfoByID/" + userId + "?needIcon=true")
//                .build();
//        client.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Request request, IOException e) {
//                callBackData.callBackData("404");
//            }
//
//            @Override
//            public void onResponse(Response response) throws IOException {
////                if (response.isSuccessful() && response.code() == 200) {
////                    String result = response.body().string();
////                    callBackData.callBackData(result);
////                }
//                int code = response.code();
//                String result = response.body().string();
//                Log.i("info", "请求数据返回的code:" + code);
//                Log.i("info", "请求数据返回" + result);
//            }
//        });
//    }
}
