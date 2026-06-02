package universite_paris8.iut.qdev.tp2026.gr21.jeuQuizz.entities.mapppers;

import universite_paris8.iut.qdev.tp2026.gr21.jeuQuizz.entities.dtos.QuestionDTO;
import universite_paris8.iut.qdev.tp2026.gr21.jeuQuizz.entities.dtos.QuestionnaireDTO;
import universite_paris8.iut.qdev.tp2026.gr21.jeuQuizz.entities.mos.QuestionnaireCsvMO;
import universite_paris8.iut.qdev.tp2026.gr21.jeuQuizz.utils.enums.DifficulteEnum;
import universite_paris8.iut.qdev.tp2026.gr21.jeuQuizz.utils.enums.LangueEnum;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Mapper responsable de la conversion des données brutes du CSV (LigneQuestionCsv)
 * vers la structure d'objets de transfert de données (QuestionnaireDTO).
 */
public class CsvToQuestionnaireDTOMapper {

    /**
     * Transforme une liste de lignes brutes de CSV en une liste structurée de QuestionnaireDTO.
     * Les lignes appartenant au même questionnaire sont regroupées automatiquement.
     *
     * @param lignesCsv La liste de toutes les lignes extraites du fichier CSV
     * @return La liste des questionnaires DTO structurés
     */
    public static List<QuestionnaireDTO> mapToQuestionnaireDTOs(List<QuestionnaireCsvMO> lignesCsv) {
        if (lignesCsv == null || lignesCsv.isEmpty()) {
            return new ArrayList<>();
        }

        // Utilisation d'une LinkedHashMap pour regrouper par idQuestionnaire
        // tout en préservant l'ordre d'apparition des questionnaires du fichier
        Map<Integer, QuestionnaireDTO> mapQuestionnaires = new LinkedHashMap<>();

        for (QuestionnaireCsvMO question : lignesCsv) {
            // 1. On récupère ou on crée le QuestionnaireDTO correspondant à l'ID
            QuestionnaireDTO questionnaireDTO = mapQuestionnaires.get(question.getIdQuestionnaire());
            if (questionnaireDTO == null) {
                questionnaireDTO = new QuestionnaireDTO();
                questionnaireDTO.setIdQuestionnaire(question.getIdQuestionnaire());
                questionnaireDTO.setLibelleQuestionnaire(question.getLibelleQuestionnaire());
                questionnaireDTO.setListeQuestion(new ArrayList<>());

                mapQuestionnaires.put(question.getIdQuestionnaire(), questionnaireDTO);
            }

            // 2. On convertit la ligne courante en un QuestionDTO
            QuestionDTO questionDTO = new QuestionDTO();
            questionDTO.setNumQuestion(question.getNumQuestion());
            questionDTO.setLibelleQuestion(question.getLibelleQuestion());
            questionDTO.setReponse(question.getReponse());
            questionDTO.setDifficulte(question.getDifficulte());
            questionDTO.setExplication(question.getExplication());
            questionDTO.setReference(question.getReference());

            // 3. Mapping et conversion sécurisée des énumérations
            questionDTO.setLangue(mapToLangueEnum(question.getLangue()));
            questionDTO.setNiveau(mapToDifficulteEnum(question.getDifficulte()));

            // 4. On ajoute la question à la liste interne du questionnaire associé
            questionnaireDTO.getListeQuestion().add(questionDTO);
        }

        // On retourne la collection des questionnaires regroupés sous forme de List
        return new ArrayList<>(mapQuestionnaires.values());
    }

    /**
     * Convertit la chaîne de caractères du CSV (ex: "fr") en LangueEnum.
     */
    private static LangueEnum mapToLangueEnum(String langueStr) {
        if (langueStr == null) {
            return LangueEnum.fr; // Valeur par défaut de secours
        }
        try {
            return LangueEnum.valueOf(langueStr.trim().toLowerCase());
        } catch (IllegalArgumentException e) {
            return LangueEnum.fr; // En cas de valeur inattendue dans le CSV
        }
    }

    /**
     * Convertit l'entier de difficulté du CSV (1, 2 ou 3) en DifficulteEnum.
     */
    private static DifficulteEnum mapToDifficulteEnum(int difficulteInt) {
        switch (difficulteInt) {
            case 1:
                return DifficulteEnum.Simple;
            case 2:
                return DifficulteEnum.Intermediaire;
            case 3:
                return DifficulteEnum.Expert;
            default:
                return DifficulteEnum.Simple; // Valeur par défaut de secours
        }
    }
}