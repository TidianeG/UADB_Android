package com.enginer.myfisrtapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FormationFragment extends Fragment {
     private ListView listFormation;
     private String [] tabFormation, tabDetails;
     private  String formation, details;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_formation, container, false);
        listFormation = view.findViewById(R.id.listFormation);
        tabFormation = getActivity().getResources().getStringArray(R.array.tab_formation);
        tabDetails = getActivity().getResources().getStringArray(R.array.tab_details);
        ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, tabFormation);
        listFormation.setAdapter(adapter);
        listFormation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                formation= tabFormation[position];
                details = tabDetails[position];
                AlertDialog.Builder dialog =new AlertDialog.Builder(getActivity());
                dialog.setIcon(R.mipmap.ic_launcher);
                dialog.setTitle(formation);
                dialog.setTitle(details);
                dialog.setNegativeButton(getString(R.string.back), null);
                dialog.setPositiveButton(getString(R.string.inscription), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       /* Intent intent= new Intent(getActivity(), InscriptionFragment.class);
                        intent.putExtra("FORMATION", formation);
                        startActivity(intent);*/
                       InscriptionFragment.formation=formation;
                       getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new InscriptionFragment()).addToBackStack(null).commit();
                    }
                });
                dialog.show(); //Affichage de la boite de dialog
            }
        });

        return view;
    }
}