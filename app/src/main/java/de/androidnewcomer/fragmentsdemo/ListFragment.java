package de.androidnewcomer.fragmentsdemo;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ListFragment extends Fragment {

    public interface OnItemSelectedListener {
        void onItemSelected(String article);
    }

    private OnItemSelectedListener listener;

    private final static String[] ITEMS = { "Spaghetti", "Karotten", "Brot", "Saft", "Schokolade", "Milch", "Eier", "Mais", "Gurke", "Tomate" };

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list,container,false);
        ListView list = v.findViewById(R.id.list);
        list.setAdapter(new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1, Arrays.asList( ITEMS) ));
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listener.onItemSelected(ITEMS[position]);
            }
        });
        return v;
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (OnItemSelectedListener) context;
    }
}
