package universite_paris8.iut.qdev.tp2026.gr21.jeuQuizz;

import universite_paris8.iut.qdev.tp2026.gr21.jeuQuizz.entities.dtos.QuestionnaireDTO;
import universite_paris8.iut.qdev.tp2026.gr21.jeuQuizz.entities.mos.LigneCsvMO;
import universite_paris8.iut.qdev.tp2026.gr21.jeuQuizz.services.interfaces.IQuestionnaireService;
import universite_paris8.iut.qdev.tp2026.gr21.jeuQuizz.utils.exceptions.AbsenceFichierException;
import universite_paris8.iut.qdev.tp2026.gr21.jeuQuizz.utils.exceptions.ChargementImpossibleException;
import universite_paris8.iut.qdev.tp2026.gr21.jeuQuizz.utils.exceptions.FichierCorrompuException;
import universite_paris8.iut.qdev.tp2026.gr21.jeuQuizz.utils.exceptions.QuestionnaireInexistantException;

import java.util.List;

public class chargerFichierOKMock implements IQuestionnaireService {

    @Override
    public List<LigneCsvMO> chargerFichier(String cheminFichier) throws AbsenceFichierException, FichierCorrompuException {
        LigneCsvMO ligne = new LigneCsvMO(
                1,
                "Sport niv 1",
                1,
                "fr",
                "De quel petit objet se munit le golfeur pour surélever sa balle avant de la frapper ?",
                "Tee",
                1,
                "Le joueur peut poser sa balle sur une cheville de bois ou de plastique qui ne peut pas être utilisée en dehors des départs.",
                "https://fr.wikipedia.org/wiki/Matériel_de_golf"
        );

        // AMÉLIORATION : On crée la liste directement avec l'objet dedans
        return List.of(ligne);
    }

    @Override
    public List<QuestionnaireDTO> fournirListeQuestionnaires() throws ChargementImpossibleException {
        return List.of();
    }

    @Override
    public List<Object> StatistiquesQuestionnaire() throws QuestionnaireInexistantException, ChargementImpossibleException {
        return List.of();
    }
}
