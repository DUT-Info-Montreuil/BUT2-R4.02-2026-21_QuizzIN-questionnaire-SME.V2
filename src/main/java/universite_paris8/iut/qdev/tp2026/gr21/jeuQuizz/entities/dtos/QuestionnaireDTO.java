package universite_paris8.iut.qdev.tp2026.gr21.jeuQuizz.entities.dtos;

import java.util.List;
import java.util.Objects;

public class QuestionnaireDTO {
    private int idQuestionnaire;
    private String libelleQuestionnaire;
    private List<QuestionDTO> listeQuestion;
    private int nbFoisPose = 0;

    public QuestionnaireDTO() {}

    public QuestionnaireDTO(int idQuestionnaire, String libelleQuestionnaire, List<QuestionDTO> listeQuestion) {
        this.idQuestionnaire = idQuestionnaire;
        this.libelleQuestionnaire = libelleQuestionnaire;
        this.listeQuestion = listeQuestion;
    }

    // Getters et Setters
    public int getIdQuestionnaire() { return idQuestionnaire; }
    public void setIdQuestionnaire(int idQuestionnaire) { this.idQuestionnaire = idQuestionnaire; }

    public String getLibelleQuestionnaire() { return libelleQuestionnaire; }
    public void setLibelleQuestionnaire(String libelleQuestionnaire) { this.libelleQuestionnaire = libelleQuestionnaire; }

    public List<QuestionDTO> getListeQuestion() { return listeQuestion; }
    public void setListeQuestion(List<QuestionDTO> listeQuestion) { this.listeQuestion = listeQuestion; }

    public int getNbFoisPose() {
        return nbFoisPose;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionnaireDTO that = (QuestionnaireDTO) o;
        return idQuestionnaire == that.idQuestionnaire &&
                Objects.equals(libelleQuestionnaire, that.libelleQuestionnaire) &&
                Objects.equals(listeQuestion, that.listeQuestion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idQuestionnaire, libelleQuestionnaire, listeQuestion);
    }

    @Override
    public String toString() {
        return "QuestionnaireDTO{" +
                "idQuestionnaire=" + idQuestionnaire +
                ", libelleQuestionnaire='" + libelleQuestionnaire + '\'' +
                ", listeQuestion=" + listeQuestion +
                '}';
    }
}