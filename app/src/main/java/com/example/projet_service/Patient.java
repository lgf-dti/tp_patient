package com.example.projet_service;

public class Patient {

    private String nom; // Nom du patient
    private String prenom; // Prénom du patient
    private float tailleCm; // Taille en centimètres
    private float poidsKg; // Poids en kilogrammes
    private String genre; // Genre du patient
    private String numeroChambre; // Numéro de chambre du patient

    /**
     * Constructeur de la classe Patient.
     *
     * @param nom            Le nom du patient.
     * @param prenom         Le prénom du patient.
     * @param taille         La taille en centimètres du patient.
     * @param poids          Le poids en kilogrammes du patient.
     * @param genre          Le genre du patient.
     * @param numeroChambre  Le numéro de chambre du patient.
     */
    public Patient(String nom, String prenom, float taille, float poids, String genre, String numeroChambre) {
        this.nom = nom;
        this.prenom = prenom;
        this.tailleCm = taille;
        this.poidsKg = poids;
        this.genre = genre;
        this.numeroChambre = numeroChambre;
    }

    /**
     * Calcule l'indice de masse corporelle (IMC) du patient.
     *
     * @return L'IMC du patient.
     */
    public float calculerImc() {
        float tailleM = tailleCm / 100; // Conversion de la taille en mètres
        float imc = poidsKg / (tailleM * tailleM); // Calcul de l'IMC
        // Arrondir à deux chiffres après la virgule
        float imcArrondi= Math.round(imc * 100) / 100f;
        return imcArrondi;
    }

    /**
     * Donne une indication sur la catégorie de l'IMC du patient.
     *
     * @return L'indication de l'IMC du patient.
     */
    public String indicationImc() {
        float imc = calculerImc(); // Calcul de l'IMC
        String indicationImc = "";

        // Évaluation de la catégorie d'IMC
        if (imc <= 18.5) {
            indicationImc = "Poids insuffisant (maigreur)";
        } else if (imc > 18.5 && imc <= 25) {
            indicationImc = "Corpulence normale";
        } else if (imc > 25 && imc <= 30) {
            indicationImc = "Surpoids";
        } else if (imc > 30 && imc <= 35) {
            indicationImc = "Obésité modérée";
        } else if (imc > 35 && imc <= 40) {
            indicationImc = "Obésité sévère";
        } else if (imc > 40) {
            indicationImc = "Obésité morbide";
        }
        return indicationImc; // Retourne l'indication de l'IMC
    }

    /**
     * Retourne une représentation sous forme de chaîne de caractères du patient.
     *
     * @return La représentation du patient.
     */
    @Override
    public String toString() {
        return nom + " " + prenom;
    }

    /**
     * Affiche les informations du patient.
     *
     * @return Les informations du patient.
     */
    public String afficherPatient()
    {
        return "Patient{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", taille=" + tailleCm +
                ", poids=" + poidsKg +
                ", imc=" + calculerImc() +
                ", indicationImc='" + indicationImc() + '\'' +
                ", genre='" + genre + '\'' +
                ", numeroChambre='" + numeroChambre + '\'' +
                '}';
    }

    public String getGenre() {
        return genre;
    }

}