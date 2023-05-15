package com.example.projet_service;

import org.junit.Assert;
import org.junit.Test;

public class PatientTest {

    @Test
    public void testCalculerImc() {
        // Création d'un patient avec une taille de 170 cm et un poids de 70 kg
        Patient patient = new Patient("John", "Doe", 170, 70, "Masculin", "123");

        // Calcul de l'IMC attendu (70 / (1.70 * 1.70)) = 24.22
        float expectedImc = 24.22f;

        // Appel de la méthode calculerImc()
        float calculatedImc = patient.calculerImc();

        // Vérification de l'IMC calculé
        Assert.assertEquals(expectedImc, calculatedImc, 0.01); // Utilisation d'une précision de 0.01 pour la comparaison
    }

    @Test
    public void testIndicationImc() {
        // Création d'un patient avec un IMC de 22.5 (correspondant à une corpulence normale)
        Patient patient = new Patient("Jane", "Smith", 160, 55, "Féminin", "456");

        // Indication IMC attendue pour un IMC de 22.5 : "Corpulence normale"
        String expectedIndication = "Corpulence normale";

        // Appel de la méthode indicationImc()
        String calculatedIndication = patient.indicationImc();

        // Vérification de l'indication IMC calculée
        Assert.assertEquals(expectedIndication, calculatedIndication);
    }
}
