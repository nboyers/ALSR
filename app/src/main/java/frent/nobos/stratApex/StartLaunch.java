package frent.nobos.stratApex;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

/**
 * When the app starts
 * this is the GUI controller
 */
public class StartLaunch extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.strat_roulette_choice, container, false);
    }

    // Handles the buttons to send the user to roulette
    @Override
        public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);

            view.findViewById(R.id.kingsCanyon_button).setOnClickListener(view1 ->{
                //     Navigation.findNavController(StartLaunch.this)
                //     .navigate(R.id.strat_roulette_choices);
                //TODO - Pass the info that the user clicked this map
            });

        view.findViewById(R.id.Olympus_Button).setOnClickListener(view12 -> {
            //     Navigation.findNavController(StartLaunch.this)
            //     .navigate(R.id.strat_roulette_choices);
            //TODO - Pass the info that the user clicked this map
        });

        view.findViewById(R.id.Worlds_Edge_Button).setOnClickListener(view13 -> {
       //     Navigation.findNavController(StartLaunch.this)
            //     .navigate(R.id.strat_roulette_choices);
            //TODO - Pass the info that the user clicked this map
        });
    }
}
