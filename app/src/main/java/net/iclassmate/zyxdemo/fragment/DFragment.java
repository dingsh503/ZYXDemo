package net.iclassmate.zyxdemo.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.iclassmate.zyxdemo.R;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;

/**
 * Created by xydbj on 2016.11.10.
 */
public class DFragment extends LazyFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_d,container,false);
        return view;
    }

    @Override
    public String setFragmentTitle() {
        return "D";
    }

    interface ProgressListener{
        void update(long bytesRade, long contentLength, boolean done);
    }

    public class ProgressRequestBody extends RequestBody{

        RequestBody requestBody;
        ProgressListener progressListener;
        BufferedSink bufferedSink;

        public ProgressRequestBody(RequestBody requestBody,ProgressListener progressListener){
            this.requestBody = requestBody;
            this.progressListener = progressListener;
        }

        @Override
        public MediaType contentType() {
            return requestBody.contentType();
        }

        @Override
        public long contentLength() throws IOException {
            return requestBody.contentLength();
        }

        @Override
        public void writeTo(BufferedSink sink) throws IOException {
            if (bufferedSink == null){
//                bufferedSink = Okio.buffer(sink(sink));
            }
        }
    }
}
