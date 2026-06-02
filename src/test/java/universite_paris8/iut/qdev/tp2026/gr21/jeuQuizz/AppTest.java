package universite_paris8.iut.qdev.tp2026.gr21.jeuQuizz;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import universite_paris8.iut.qdev.tp2026.gr21.jeuQuizz.entities.dtos.QuestionDTO;
import universite_paris8.iut.qdev.tp2026.gr21.jeuQuizz.entities.dtos.QuestionnaireDTO;
import universite_paris8.iut.qdev.tp2026.gr21.jeuQuizz.entities.mos.LigneCsvMO;
import universite_paris8.iut.qdev.tp2026.gr21.jeuQuizz.services.impls.QuestionnaireServiceImpl;
import universite_paris8.iut.qdev.tp2026.gr21.jeuQuizz.services.interfaces.IQuestionnaireService;
import universite_paris8.iut.qdev.tp2026.gr21.jeuQuizz.utils.enums.DifficulteEnum;
import universite_paris8.iut.qdev.tp2026.gr21.jeuQuizz.utils.enums.LangueEnum;
import universite_paris8.iut.qdev.tp2026.gr21.jeuQuizz.utils.exceptions.AbsenceFichierException;
import universite_paris8.iut.qdev.tp2026.gr21.jeuQuizz.utils.exceptions.ChargementImpossibleException;
import universite_paris8.iut.qdev.tp2026.gr21.jeuQuizz.utils.exceptions.FichierCorrompuException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for simple App.
 */
public class AppTest {
    IQuestionnaireService questService;
    /**
     * test pour fichier introuvable
     */
    @BeforeEach
    public void setup(){
        questService = new QuestionnaireServiceImpl();
    }
    @Test
    public void testChargerFichierQuandFichierIntrouvable() {
    //    IQuestionnaireService questService = new chargerFichierKOfichierIntrouvableMock();
        assertThrows(AbsenceFichierException.class, () -> {
            questService.chargerFichier("invalide.csv");
        });
    }

    /**
     * test pour fichier corrumpu sur les colonnes
     */
    @Test
    public void testChargerFichierQuandFichierCorrumpuColonne() {
      //  IQuestionnaireService questService = new chargerFichierCorrompuMock();
        assertThrows(FichierCorrompuException.class, () -> {
            questService.chargerFichier("src/test/resources/questionsQuizz_corrompu_colonnes.csv");
        });
    }

    /**
     * test pour fichier corrumpu sur les délimiteurs
     */
    @Test
    public void testChargerFichierQuandFichierCorrumpuDelimiteur() {
       // IQuestionnaireService questService = new chargerFichierCorrompuMock();
        assertThrows(FichierCorrompuException.class, () -> {
            questService.chargerFichier("src/test/resources/questionsQuizz_corrompu_delimiteur.csv");
        });
    }

    /**
     * test pour fichier corrumpu sur les difficultés
     */
    @Test
    public void testChargerFichierQuandFichierCorrumpuDifficultes() {
     //   IQuestionnaireService questService = new chargerFichierCorrompuMock();
        assertThrows(FichierCorrompuException.class, () -> {
            questService.chargerFichier("src/test/resources/questionsQuizz_corrompu_difficulte.csv");
        });
    }

    /**
     * test pour fichier corrumpu sur les id
     */
    @Test
    public void testChargerFichierQuandFichierCorrumpuID() {
      //  IQuestionnaireService questService = new chargerFichierCorrompuMock();
        assertThrows(FichierCorrompuException.class, () -> {
            questService.chargerFichier("src/test/resources/questionsQuizz_corrompu_id.csv");
        });
    }

    /**
     * test pour fichier corrumpu sur les langues
     */
    @Test
    public void testChargerFichierQuandFichierCorrumpuLangue() {
     //   IQuestionnaireService questService = new chargerFichierCorrompuMock();
        assertThrows(FichierCorrompuException.class, () -> {
            questService.chargerFichier("src/test/resources/questionsQuizz_corrompu_langue.csv");
        });
    }

    /**
     * test pour fichier corrumpu sur un élément manquant
     */
    @Test
    public void testChargerFichierQuandFichierCorrumpuElementManquant() {
     //   IQuestionnaireService questService = new chargerFichierCorrompuMock();
        assertThrows(FichierCorrompuException.class, () -> {
            questService.chargerFichier("src/test/resources/questionsQuizz_corrompu_manquant.csv");
        });
    }

    /**
     * test pour fichier corrumpu sur les questions
     */
    @Test
    public void testChargerFichierQuandFichierCorrumpuQuestion() {
     //   IQuestionnaireService questService = new chargerFichierCorrompuMock();
        assertThrows(FichierCorrompuException.class, () -> {
            questService.chargerFichier("src/test/resources/questionsQuizz_corrompu_question.csv");
        });
    }

    /**
     * test pour fichier vide
     */
    @Test
    public void testChargerFichierQuandFichierVide() {
     //   IQuestionnaireService questService = new chargerFichierCorrompuMock();
        assertThrows(FichierCorrompuException.class, () -> {
            questService.chargerFichier("src/test/resources/questionsQuizz_vide.csv");
        });
    }

    /**
     * test pour fichier OK
     */
    @Test
    public void testChargerFichierOK() throws AbsenceFichierException, FichierCorrompuException {
     //   IQuestionnaireService questService = new chargerFichierOKMock();
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
        List<LigneCsvMO> lignesOK = questService.chargerFichier("src/test/resources/questionsQuizz_2025_V1.csv");
        assertFalse(lignesOK.isEmpty());
        assertTrue(lignesOK.get(0).equals(ligne));
    }

    /**
     * test pour fichier chargement impossible
     */
    @Test
    public void testFournirListeQuestionnairesChargementImpossible()  {
    //    IQuestionnaireService questService = new fournirListeQuestionnairesChargementImpossibleMock();
        assertThrows(ChargementImpossibleException.class, questService::fournirListeQuestionnaires);
    }

    /**
     * test pour fichier OK
     */
    @Test
    public void testFournirListeQuestionnairesOK() throws ChargementImpossibleException {
    //    IQuestionnaireService questService = new fournirListeQuestionnairesOKMock();

        QuestionDTO q1Attendu = new QuestionDTO(
                1,
                "De quel petit objet se munit le golfeur pour surélever sa balle avant de la frapper ?",
                "Tee", 1,
                "Le joueur peut poser sa balle sur une cheville de bois ou de plastique qui ne peut pas être utilisée en dehors des départs.",
                "https://fr.wikipedia.org/wiki/Matériel_de_golf",
                LangueEnum.fr,
                DifficulteEnum.Simple
        );
        QuestionDTO q2Attendu = new QuestionDTO(
                2,
                "Quel sport de raquette porte le nom de la ville anglaise où il fut inventé ?",
                "Badminton", 1,
                "Le badminton est toujours pratiqué en intérieur car avec le vent, en extérieur, le volant peut brusquement changer de direction.",
                "https://fr.wikipedia.org/wiki/Badminton",
                LangueEnum.fr,
                DifficulteEnum.Simple
        );

        QuestionnaireDTO questionnaireAttendu = new QuestionnaireDTO(1, "Sport niv 1", List.of(q1Attendu, q2Attendu));
        List<QuestionnaireDTO> resultats = questService.fournirListeQuestionnaires();
        assertFalse(resultats.isEmpty(), "La liste des questionnaires ne doit pas être vide.");
        assertTrue(resultats.get(0).equals(questionnaireAttendu));
    }





}
