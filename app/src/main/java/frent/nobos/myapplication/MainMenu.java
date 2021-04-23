package frent.nobos.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class MainMenu extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.strat_roulette_choice, container, false);
    }

    @Override
        public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);

            view.findViewById(R.id.kingsCanyon_button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        view.findViewById(R.id.Olympus_Button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        view.findViewById(R.id.Worlds_Edge_Button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Navigation.findNavController(MainMenu.this) .navigate(R.id.strat_roulette_choices);
            }
        });
    }
}
