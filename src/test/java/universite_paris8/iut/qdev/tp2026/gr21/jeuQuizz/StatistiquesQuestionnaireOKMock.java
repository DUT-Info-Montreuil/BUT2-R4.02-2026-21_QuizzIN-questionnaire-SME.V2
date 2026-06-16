package universite_paris8.iut.qdev.tp2026.gr21.jeuQuizz;

import universite_paris8.iut.qdev.tp2026.gr21.jeuQuizz.entities.dtos.QuestionnaireDTO;
import universite_paris8.iut.qdev.tp2026.gr21.jeuQuizz.entities.mos.LigneCsvMO;
import universite_paris8.iut.qdev.tp2026.gr21.jeuQuizz.services.interfaces.IQuestionnaireService;
import universite_paris8.iut.qdev.tp2026.gr21.jeuQuizz.utils.exceptions.AbsenceFichierException;
import universite_paris8.iut.qdev.tp2026.gr21.jeuQuizz.utils.exceptions.ChargementImpossibleException;
import universite_paris8.iut.qdev.tp2026.gr21.jeuQuizz.utils.exceptions.FichierCorrompuException;
import universite_paris8.iut.qdev.tp2026.gr21.jeuQuizz.utils.exceptions.QuestionnaireInexistantException;

import java.util.List;

public class StatistiquesQuestionnaireOKMock implements IQuestionnaireService {
    @Override
    public List<LigneCsvMO> chargerFichier(String cheminFichier) throws AbsenceFichierException, FichierCorrompuException {
        return List.of();
    }

    @Override
    public List<QuestionnaireDTO> fournirListeQuestionnaires() throws ChargementImpossibleException {
        return List.of();
    }

    @Override
    public List<Object> StatistiquesQuestionnaire() throws QuestionnaireInexistantException, ChargementImpossibleException {
        return List.of(
                1, // ID questionnaire
                50, // nb fois posé
                "De quel petit objet se munit le golfeur pour surélever sa balle avant de la frapper ?", // libellé meilleure question
                45, // nb fois posée
                40, // nb fois réussie
                "Quel sport de raquette porte le nom de la ville anglaise où il fut inventé ?", // libellé pire question
                45, // nb fois posée
                10  // nb fois réussie
        );
    }
}