package automall.com.mautomall;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MoreFragment extends Fragment{
    private static final String ARG_SHOW_TEXT = "text";
    private String mContentText;
    //返回通过工厂方法获取BlankFragment
    public static MoreFragment newInstance(){
        MoreFragment fragment = new MoreFragment();
        Bundle args = new Bundle();
        //args.putString(ARG_SHOW_TEXT,param1);
       // fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        /*if (getArguments()!=null){
            mContentText = getArguments().getString(ARG_SHOW_TEXT);
        }*/

    }
    private ListView lv;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //FOR fragment
        View rootView = inflater.inflate(R.layout.fragment_more,container,false);
        //TextView contentTv = rootView.findViewById(R.id.content_tv);
        //contentTv.setText(mContentText);
        lv = rootView.findViewById(R.id.more_list);
        MoreAdapter moreAdapter = new MoreAdapter();
        lv.setAdapter(moreAdapter);
        return rootView;
    }

    private class MoreAdapter extends BaseAdapter{
        int[] images = {R.drawable.index_gallery_01,R.drawable.index_gallery_01,R.drawable.index_gallery_02,R.drawable.index_gallery_03,R.drawable.index_gallery_04,R.drawable.index_gallery_01,R.drawable.index_gallery_02,R.drawable.index_gallery_03};
        String[] titles = {"卡罗拉","普拉多","亚洲龙","RAV4荣放","皇冠","威驰","伊泽IZOA","威驰fs"};
        String[] names = {"10.78-17.58万","44.38-61.58万","23.98-28.98万","17.98-26.98万","25.48-38.18万","6.98-11.38万","14.98-17.98万","6.98-10.98万"};
        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = null;
            if(convertView == null){
                view = LayoutInflater.from(getContext()).inflate(R.layout.morelist,null);
                ImageView imageView = view.findViewById(R.id.more_list_iv);
                imageView.setImageResource(images[position]);
                //设置标题
                TextView tv1 = view.findViewById(R.id.tv_1);
                tv1.setText(titles[position]);
                //设置副标题
                TextView tv2 = view.findViewById(R.id.tv_2);
                tv2.setText(names[position]);
            }else{
                view = convertView;
            }
            return view;
        }
    }
}
