package com.example.projet_service;

import java.util.ArrayList;

public class Service {

    private String nom; // Nom du service
    private ArrayList<Patient> patients; // Liste des patients du service

    /**
     * Constructeur de la classe Service.
     *
     * @param nom Le nom du service.
     */
    public Service(String nom) {
        this.nom = nom;
        patients = new ArrayList<Patient>(); // Initialisation de la liste des patients
    }

    /**
     * Ajoute un patient à la liste des patients du service.
     *
     * @param patient Le patient à ajouter.
     */
    public void ajouterPatient(Patient patient) {
        patients.add(patient);
    }

    /**
     * Retourne la liste des patients du service.
     *
     * @return La liste des patients.
     */
    public ArrayList<Patient> getPatients() {
        return patients;
    }

    /**
     * Calcule le nombre de patients hommes dans le service.
     *
     * @return Le nombre de patients hommes.
     */
    public int nombrePatientsHommes() {
        int nombreHommes = 0;

        // Parcours de la liste des patients
        for (Patient unPatient : patients) {
            if (unPatient.getGenre().equals("Masculin")) {
                nombreHommes++;
            }
        }
        return nombreHommes;
    }

    /**
     * Calcule le nombre de patients femmes dans le service.
     *
     * @return Le nombre de patients femmes.
     */
    public int nombrePatientsFemmes() {
        int nombreFemmes = 0;

        // Parcours de la liste des patients
        for (Patient unPatient : patients) {
            if (unPatient.getGenre().equals("Féminin")) {
                nombreFemmes++;
            }
        }
        return nombreFemmes;
    }
    /**
     * Calcule l'IMC moyen de tous les patients du service.
     *
     * @return L'IMC moyen de tous les patients.
     */
    public float imcMoyenTous() {
        float ImcMoyen = 0;
        // Parcours de la liste des patients
        for (Patient unPatient : patients) {
            ImcMoyen += unPatient.calculerImc();
        }
        // Arrondir à deux chiffres après la virgule
        float ImcMoyenArrondi = Math.round((ImcMoyen / patients.size()) * 100) / 100f;
        return ImcMoyenArrondi;
    }

    /**
     * Calcule l'IMC moyen des patients hommes du service.
     *
     * @return L'IMC moyen des patients hommes.
     */
    public float imcMoyenHommes() {
        float ImcMoyenHommes = 0;
        float ImcMoyenHommesArrondi =0;

        // Parcours de la liste des patients
        for (Patient unPatient : patients) {
            if (unPatient.getGenre().equals("Masculin")) {
                ImcMoyenHommes += unPatient.calculerImc();
            }
        }
        if (nombrePatientsHommes() > 0) {
            ImcMoyenHommes = ImcMoyenHommes / nombrePatientsHommes();
            // Arrondir à deux chiffres après la virgule
            ImcMoyenHommesArrondi= Math.round(ImcMoyenHommes * 100) / 100f;
        }
        return ImcMoyenHommesArrondi;
    }

    /**
     * Calcule l'IMC moyen des patients femmes du service.
     *
     * @return L'IMC moyen des patients femmes.
     */
    public float imcMoyenFemmes() {
        float ImcMoyenFemmes = 0;
        float ImcMoyenFemmesArrondi =0;
        // Parcours de la liste des patients
        for(Patient unPatient : patients){
            if(unPatient.getGenre().equals("Féminin"))
                ImcMoyenFemmes += unPatient.calculerImc();
        }
        if(nombrePatientsFemmes()>0){
            ImcMoyenFemmes = ImcMoyenFemmes / nombrePatientsFemmes();
            // Arrondir à deux chiffres après la virgule
            ImcMoyenFemmesArrondi= Math.round(ImcMoyenFemmes * 100) / 100f;
        }
        return ImcMoyenFemmesArrondi;
    }
}

