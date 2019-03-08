package automall.com.mautomall;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


public class CartFragment extends Fragment{
    private static final String ARG_SHOW_TEXT = "text";
    private String mContentText;
    //返回通过工厂方法获取BlankFragment
    public static CartFragment newInstance(){
        CartFragment fragment = new CartFragment();
        Bundle args = new Bundle();
        //args.putString(ARG_SHOW_TEXT,param1);
        //fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       /* if (getArguments()!=null){
            mContentText = getArguments().getString(ARG_SHOW_TEXT);
        }*/
    }
    private  View rootView;
    private Button btn1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_cart,container,false);
        //service1
        initCart_Jinxiaoshangchaxun(rootView);
        initCart_Jinjijiuyuan(rootView);
        return rootView;
    }
    //经销商查询
    public void initCart_Jinxiaoshangchaxun(View view){
        ImageView index_promotion_btn = rootView.findViewById(R.id.service1);
        index_promotion_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Toast.makeText(homeView.getContext(), "您点击的是" , Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getActivity(),Cart_Jinxiaoshangchaxun.class);
                startActivity(intent);
            }
        });
    }
    //紧急救援
    public void initCart_Jinjijiuyuan(View view){
        ImageView index_promotion_btn = rootView.findViewById(R.id.service2);
        index_promotion_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Toast.makeText(homeView.getContext(), "您点击的是" , Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getActivity(),Cart_Jinjijiuyuan.class);
                startActivity(intent);
            }
        });
    }




/*    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.v("11111","11111111");
                Intent intent = new Intent(getActivity(),LoginActivity.class);
                startActivity(intent);
            }
        });
    }*/
}
