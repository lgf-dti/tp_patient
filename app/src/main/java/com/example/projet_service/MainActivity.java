
package com.example.projet_service;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.projet_service.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding; // Binding pour accéder aux éléments de l'interface graphique

    private Service monService; // Instance du service
    private ArrayAdapter<Patient> adapter; // Adaptateur pour le spinner

    /**
     * Méthode appelée lors de la création de l'activité.
     *
     * @param savedInstanceState L'état précédemment enregistré de l'activité.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        monService = new Service("Service Test"); // Initialisation du service
        adapter = new ArrayAdapter<Patient>(getApplicationContext(),
                android.R.layout.simple_spinner_dropdown_item, monService.getPatients()); // Création de l'adaptateur
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinnerPatients.setAdapter(adapter); // Affectation de l'adaptateur au spinner

        binding.buttonCreerPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Récupération des valeurs saisies dans les champs de texte
                String nomPatient = binding.editTextNom.getText().toString();
                String prenomPatient = binding.editTextPrenom.getText().toString();
                float taillePatient = Float.parseFloat(binding.editTextTaille.getText().toString());
                float poidsPatient = Float.parseFloat(binding.editTextPoids.getText().toString());
                String chambrePatient = binding.editTextChambre.getText().toString();
                String genrePatient = "";

                // Vérification du genre sélectionné
                if (binding.radioButtonMasculin.isChecked()) {
                    genrePatient = "Masculin";
                } else if (binding.radioButtonFeminin.isChecked()) {
                    genrePatient = "Féminin";
                }
                // Création d'un nouveau patient
                Patient unPatient = new Patient(nomPatient, prenomPatient, taillePatient, poidsPatient, genrePatient, chambrePatient);
                // Ajout du patient au service
                monService.ajouterPatient(unPatient);
                // Notification de l'adaptateur pour mettre à jour le spinner
                adapter.notifyDataSetChanged();
            }
        });

        binding.buttonAfficherPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Récupération du patient sélectionné dans le spinner
                Patient patientSelectionne = (Patient) binding.spinnerPatients.getSelectedItem();
                // Affichage des informations du patient dans un toast
                Toast.makeText(MainActivity.this, patientSelectionne.afficherPatient(), Toast.LENGTH_LONG).show();
            }
        });

        binding.buttonAfficherStatistiques.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Affichage du nombre de patients hommes dans le textView correspondant
                binding.textViewNombreHommes.setText(String.valueOf(monService.nombrePatientsHommes()));
                // Affichage du nombre de patients femmes dans le textView correspondant
                binding.textViewNombreFemmes.setText(String.valueOf(monService.nombrePatientsFemmes()));
                // Affichage de l'IMC moyen de tous les patients dans le textView correspondant
                binding.textViewImcMoyen.setText(String.valueOf(monService.imcMoyenTous()));
                // Affichage de l'IMC moyen des patients hommes dans le textView correspondant
                binding.textViewImcMoyenHommes.setText(String.valueOf(monService.imcMoyenHommes()));
                // Affichage de l'IMC moyen des patients femmes dans le textView correspondant
                binding.textViewImcMoyenFemmes.setText(String.valueOf(monService.imcMoyenFemmes()));
            }
        });
    }
}