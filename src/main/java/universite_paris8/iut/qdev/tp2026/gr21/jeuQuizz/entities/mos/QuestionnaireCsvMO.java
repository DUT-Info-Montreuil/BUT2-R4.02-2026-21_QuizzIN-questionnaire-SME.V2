package universite_paris8.iut.qdev.tp2026.gr21.jeuQuizz.entities.mos;

import java.util.Objects;

/**
 * Représente une ligne brute extraite du fichier CSV d'entrée.
 * Cette classe intermédiaire unifiée facilite le parsing et le chargement en mémoire.
 */
public class QuestionnaireCsvMO {

    private int idQuestionnaire;
    private String libelleQuestionnaire;
    private int numQuestion;
    private String langue;
    private String libelleQuestion;
    private String reponse;
    private int difficulte;
    private String explication;
    private String reference;

    // Constructeur par défaut
    public QuestionnaireCsvMO() {}

    // Constructeur complet
    public QuestionnaireCsvMO(int idQuestionnaire, String libelleQuestionnaire, int numQuestion,
                            String langue, String libelleQuestion, String reponse,
                            int difficulte, String explication, String reference) {
        this.idQuestionnaire = idQuestionnaire;
        this.libelleQuestionnaire = libelleQuestionnaire;
        this.numQuestion = numQuestion;
        this.langue = langue;
        this.libelleQuestion = libelleQuestion;
        this.reponse = reponse;
        this.difficulte = difficulte;
        this.explication = explication;
        this.reference = reference;
    }

    // --- GETTERS ET SETTERS ---

    public int getIdQuestionnaire() { return idQuestionnaire; }
    public void setIdQuestionnaire(int idQuestionnaire) { this.idQuestionnaire = idQuestionnaire; }

    public String getLibelleQuestionnaire() { return libelleQuestionnaire; }
    public void setLibelleQuestionnaire(String libelleQuestionnaire) { this.libelleQuestionnaire = libelleQuestionnaire; }

    public int getNumQuestion() { return numQuestion; }
    public void setNumQuestion(int numQuestion) { this.numQuestion = numQuestion; }

    public String getLangue() { return langue; }
    public void setLangue(String langue) { this.langue = langue; }

    public String getLibelleQuestion() { return libelleQuestion; }
    public void setLibelleQuestion(String libelleQuestion) { this.libelleQuestion = libelleQuestion; }

    public String getReponse() { return reponse; }
    public void setReponse(String reponse) { this.reponse = reponse; }

    public int getDifficulte() { return difficulte; }
    public void setDifficulte(int difficulte) { this.difficulte = difficulte; }

    public String getExplication() { return explication; }
    public void setExplication(String explication) { this.explication = explication; }

    public String getReference() { return reference; }
    public void setReference(String reference) { this.reference = reference; }

    // --- EQUALS & HASHCODE ---

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionnaireCsvMO that = (QuestionnaireCsvMO) o;
        return idQuestionnaire == that.idQuestionnaire &&
                numQuestion == that.numQuestion &&
                difficulte == that.difficulte &&
                Objects.equals(libelleQuestionnaire, that.libelleQuestionnaire) &&
                Objects.equals(langue, that.langue) &&
                Objects.equals(libelleQuestion, that.libelleQuestion) &&
                Objects.equals(reponse, that.reponse) &&
                Objects.equals(explication, that.explication) &&
                Objects.equals(reference, that.reference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idQuestionnaire, libelleQuestionnaire, numQuestion, langue,
                libelleQuestion, reponse, difficulte, explication, reference);
    }

    // --- TOSTRING ---

    @Override
    public String toString() {
        return "LigneQuestionCsv{" +
                "idQuestionnaire=" + idQuestionnaire +
                ", libelleQuestionnaire='" + libelleQuestionnaire + '\'' +
                ", numQuestion=" + numQuestion +
                ", langue='" + langue + '\'' +
                ", libelleQuestion='" + libelleQuestion + '\'' +
                ", reponse='" + reponse + '\'' +
                ", difficulte=" + difficulte +
                ", explication='" + explication + '\'' +
                ", reference='" + reference + '\'' +
                '}';
    }
}