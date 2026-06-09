package universite_paris8.iut.qdev.tp2026.gr21.jeuQuizz.services.impls;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import universite_paris8.iut.qdev.tp2026.gr21.jeuQuizz.entities.dtos.QuestionnaireDTO;
import universite_paris8.iut.qdev.tp2026.gr21.jeuQuizz.entities.mapppers.CsvToQuestionnaireDTOMapper;
import universite_paris8.iut.qdev.tp2026.gr21.jeuQuizz.entities.mos.LigneCsvMO;
import universite_paris8.iut.qdev.tp2026.gr21.jeuQuizz.services.interfaces.IQuestionnaireService;
import universite_paris8.iut.qdev.tp2026.gr21.jeuQuizz.utils.enums.LangueEnum;
import universite_paris8.iut.qdev.tp2026.gr21.jeuQuizz.utils.exceptions.AbsenceFichierException;
import universite_paris8.iut.qdev.tp2026.gr21.jeuQuizz.utils.exceptions.ChargementImpossibleException;
import universite_paris8.iut.qdev.tp2026.gr21.jeuQuizz.utils.exceptions.FichierCorrompuException;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class QuestionnaireServiceImpl implements IQuestionnaireService {

    // Notre espace mémoire pour stocker les lignes brutes extraites du CSV
    private List<LigneCsvMO> lignesEnMemoire = new ArrayList<>();

    @Override
    public List<LigneCsvMO> chargerFichier(String cheminFichier) throws AbsenceFichierException, FichierCorrompuException {
        Path path = Paths.get(cheminFichier);

        // 1. Vérification de l'existence du fichier
        if (!Files.exists(path)) {
            throw new AbsenceFichierException("Le fichier est introuvable au chemin spécifié : " + cheminFichier);
        }

        List<LigneCsvMO> nouvellesLignes = new ArrayList<>();

        // Création du parser OpenCSV pour définir le point-virgule comme séparateur
        CSVParser parser = new CSVParserBuilder()
                .withSeparator(';')
                .build();

        // 2. Lecture et traitement du fichier via OpenCSV (Avec encodage UTF-8)
        try (Reader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
             CSVReader csvReader = new CSVReaderBuilder(reader)
                     .withCSVParser(parser)
                     .build()) {

            String[] parts;
            // readNext() lit la ligne suivante et la découpe automatiquement selon le séparateur (ici ';')
            while ((parts = csvReader.readNext()) != null) {
                // On ignore les lignes vides
                if (parts.length == 0 || (parts.length == 1 && parts[0].trim().isEmpty())) {
                    continue;
                }

                // Vérification du nombre de colonnes minimum (8 ou 9 selon le format attendu)
                if (parts.length < 8) {
                    throw new FichierCorrompuException("Nombre de colonnes insuffisant dans le fichier CSV.");
                }

                try {
                    // Nettoyage de l'ID avec le BOM
                    int idQuestionnaire = Integer.parseInt(parts[0].replace("\uFEFF", "").trim());
                    String libelleQuestionnaire = parts[1].trim();
                    int numQuestion = Integer.parseInt(parts[2].trim());

                    // Lecture ET Validation de la langue
                    String langue = parts[3].trim();
                    try {
                        LangueEnum.valueOf(langue);
                    } catch (IllegalArgumentException e) {
                        throw new FichierCorrompuException("Langue non reconnue dans le fichier CSV : " + langue);
                    }

                    String libelleQuestion = parts[4].trim();
                    String reponse = parts[5].trim();
                    int difficulte = Integer.parseInt(parts[6].trim());
                    String explication = parts[7].trim();

                    // La 9ème colonne (référence) avec nettoyage des sauts de ligne invisibles
                    String reference = parts.length > 8 ? parts[8].replace("\r", "").replace("\n", "").trim() : "";

                    // Création de l'objet LigneCsvMO
                    LigneCsvMO ligneMO = new LigneCsvMO(
                            idQuestionnaire, libelleQuestionnaire, numQuestion,
                            langue, libelleQuestion, reponse, difficulte,
                            explication, reference
                    );

                    // On ajoute la ligne UNE SEULE FOIS
                    nouvellesLignes.add(ligneMO);

                } catch (NumberFormatException e) {
                    throw new FichierCorrompuException("Erreur de type de donnée dans le fichier (nombre entier attendu).");
                }
            }
        } catch (IOException | CsvValidationException e) {
            // Intercepte les erreurs d'entrée/sortie ou les erreurs de validation spécifiques à OpenCSV
            throw new FichierCorrompuException("Erreur inattendue lors de la lecture du fichier CSV : " + e.getMessage());
        }

        // Vérification du fichier vide
        if (nouvellesLignes.isEmpty()) {
            throw new FichierCorrompuException("Le fichier CSV est vide ou ne contient aucune question valide.");
        }

        // Si tout s'est bien passé, on met à jour la mémoire du système
        this.lignesEnMemoire = nouvellesLignes;

        return this.lignesEnMemoire;
    }

    @Override
    public List<QuestionnaireDTO> fournirListeQuestionnaires() throws ChargementImpossibleException {
        // 1. Vérifier si les données sont bien en mémoire
        if (this.lignesEnMemoire == null || this.lignesEnMemoire.isEmpty()) {
            throw new ChargementImpossibleException("Aucun questionnaire en mémoire. Veuillez charger le fichier CSV au préalable.");
        }

        // 2. Faire appel au Mapper pour transformer la liste de LigneCsvMO en QuestionnaireDTO
        List<QuestionnaireDTO> listeDto = CsvToQuestionnaireDTOMapper.mapToQuestionnaireDTOs(this.lignesEnMemoire);

        // 3. Vérifier si le mapping a retourné un résultat valide
        if (listeDto == null || listeDto.isEmpty()) {
            throw new ChargementImpossibleException("Le mapping des données en mémoire a échoué ou n'a produit aucun questionnaire.");
        }

        return listeDto;
    }
}