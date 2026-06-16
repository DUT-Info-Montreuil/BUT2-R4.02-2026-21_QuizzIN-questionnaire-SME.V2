package universite_paris8.iut.qdev.tp2026.gr21.jeuQuizz;

import universite_paris8.iut.qdev.tp2026.gr21.jeuQuizz.entities.dtos.QuestionnaireDTO;
import universite_paris8.iut.qdev.tp2026.gr21.jeuQuizz.entities.mos.LigneCsvMO;
import universite_paris8.iut.qdev.tp2026.gr21.jeuQuizz.services.interfaces.IQuestionnaireService;
import universite_paris8.iut.qdev.tp2026.gr21.jeuQuizz.utils.exceptions.AbsenceFichierException;
import universite_paris8.iut.qdev.tp2026.gr21.jeuQuizz.utils.exceptions.ChargementImpossibleException;
import universite_paris8.iut.qdev.tp2026.gr21.jeuQuizz.utils.exceptions.FichierCorrompuException;
import universite_paris8.iut.qdev.tp2026.gr21.jeuQuizz.utils.exceptions.QuestionnaireInexistantException;

import java.util.List;

public class StatistiquesQuestionnaireInexistantMock implements IQuestionnaireService {
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
        throw new QuestionnaireInexistantException("TEST BOUCHONNE : Questionnaire inexistant en mémoire");
    }
}