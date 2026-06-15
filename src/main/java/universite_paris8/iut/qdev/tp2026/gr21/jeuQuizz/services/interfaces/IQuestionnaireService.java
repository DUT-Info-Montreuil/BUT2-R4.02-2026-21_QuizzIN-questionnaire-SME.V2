package universite_paris8.iut.qdev.tp2026.gr21.jeuQuizz.services.interfaces;

import universite_paris8.iut.qdev.tp2026.gr21.jeuQuizz.entities.dtos.QuestionnaireDTO;
import universite_paris8.iut.qdev.tp2026.gr21.jeuQuizz.entities.mos.LigneCsvMO;
import universite_paris8.iut.qdev.tp2026.gr21.jeuQuizz.utils.exceptions.AbsenceFichierException;
import universite_paris8.iut.qdev.tp2026.gr21.jeuQuizz.utils.exceptions.ChargementImpossibleException;
import universite_paris8.iut.qdev.tp2026.gr21.jeuQuizz.utils.exceptions.FichierCorrompuException;
import universite_paris8.iut.qdev.tp2026.gr21.jeuQuizz.utils.exceptions.QuestionnaireInexistantException;

import java.util.List;

public interface IQuestionnaireService {

    /**
     * 1er cas d'utilisation : Charger fichier
     * Charge les fichiers afin de mettre en mémoire les questionnaires
     * * @param cheminFichier Le chemin vers le fichier CSV
     * @return La liste des questionnaires chargés
     * @throws AbsenceFichierException Si le fichier n'est pas trouvé
     * @throws FichierCorrompuException Si le fichier est corrompu
     */

    public List<LigneCsvMO> chargerFichier(String cheminFichier)
            throws AbsenceFichierException, FichierCorrompuException;

    /**
     * 2eme cas d'utilisation : Fournir la liste des questionnaires
     * Retourne les questionnaires disponibles en mémoire
     * * @return La liste des questionnaires
     * @throws ChargementImpossibleException Si absent de la mémoire et que le chargement échoue
     */

    public List<QuestionnaireDTO> fournirListeQuestionnaires()
            throws ChargementImpossibleException;

    public List<Object> StatistiquesQuestionnaire()
            throws QuestionnaireInexistantException, ChargementImpossibleException;
}
