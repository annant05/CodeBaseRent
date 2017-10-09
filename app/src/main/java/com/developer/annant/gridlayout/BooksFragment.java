package com.developer.annant.gridlayout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BooksFragment extends Fragment {

    //private GridView gridView;

    public BooksFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_view_viewpager, container,false);
        final List<ProductDataVariable> productDataVariable = new ArrayList<>();
        /** @{@link ArrayList}
         * Enter Data in Array List
         *
         */
        productDataVariable.add(new ProductDataVariable("Black Wendoser",1200,500,R.mipmap.ic_launcher));
        productDataVariable.add(new ProductDataVariable("Swimsuit",2000,500,R.mipmap.ic_launcher));
        productDataVariable.add(new ProductDataVariable("Le Copper Branded Shirt",1000,500,R.mipmap.ic_launcher));
        productDataVariable.add(new ProductDataVariable("Arrow Formal Shirts",5000,1000,R.mipmap.ic_launcher));


        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.my_recycler_view);
       // RecyclerView rvbelow = (RecyclerView) rootView.findViewById(R.id.my_recycler_view_below);
        RecyclerCardAdapter adapter = new RecyclerCardAdapter(getContext(),productDataVariable);
        rv.setAdapter(adapter);
       //rvbelow.setAdapter(adapter);

        //GridLayoutManager glm = new GridLayoutManager(getContext(),2);
        //glm.setOrientation(GridLayoutManager.VERTICAL);


      /*  GridView gridView = (GridView) rootView.findViewById(R.id.common_gridview_layout);
        gridView.setAdapter((ListAdapter)adapter);
*/
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.HORIZONTAL);

        rv.setLayoutManager(llm);
        //rvbelow.setLayoutManager(glm);

        GridAdapter ga = new GridAdapter(getContext(),productDataVariable);

        GridView gv = (GridView) rootView.findViewById(R.id.gridview_layout);
        gv.setAdapter(ga);

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(),"Grid Item Clicked ",Toast.LENGTH_LONG).show();
            }
        });






    /*rv.addOnItemTouchListener(new RecyclerItemListener(getContext(), rv ,new RecyclerItemListener.RecyclerTouchListener(){

        @Override
        public void onClickItem(View v, int position) {

        }

        @Override
        public void onLongClickItem(View v, int position) {

        }
    }) );


*/



        return rootView;
    }

}