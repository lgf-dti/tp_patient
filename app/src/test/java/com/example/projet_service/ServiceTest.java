package com.example.projet_service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class ServiceTest {
    private Service service;
    private ArrayList<Patient> patients;

    @Before
    public void setUp() {
        service = new Service("Service Test");

        // Création de patients pour effectuer les tests
        patients = new ArrayList<>();
        patients.add(new Patient("John", "Doe", 180, 75, "Masculin", "Chambre A"));
        patients.add(new Patient("Jane", "Smith", 165, 60, "Féminin", "Chambre B"));
        patients.add(new Patient("Michael", "Johnson", 190, 90, "Masculin", "Chambre C"));

        // Ajout des patients au service
        for (Patient patient : patients) {
            service.ajouterPatient(patient);
        }
    }


    @Test
    public void testNombrePatientsHommes() {
        // Test pour vérifier le nombre de patients hommes dans le service
        int expectedNombreHommes = 2;
        int actualNombreHommes = service.nombrePatientsHommes();
        Assert.assertEquals(expectedNombreHommes, actualNombreHommes);
    }

    @Test
    public void testNombrePatientsFemmes() {
        // Test pour vérifier le nombre de patients femmes dans le service
        int expectedNombreFemmes = 1;
        int actualNombreFemmes = service.nombrePatientsFemmes();
        Assert.assertEquals(expectedNombreFemmes, actualNombreFemmes);
    }

    @Test
    public void testImcMoyenTous() {
        // Test pour vérifier le calcul de l'IMC moyen pour tous les patients du service
        float expectedImcMoyen = 23.37f;
        float actualImcMoyen = service.imcMoyenTous();
        Assert.assertEquals(expectedImcMoyen, actualImcMoyen, 0.01);
    }
}
