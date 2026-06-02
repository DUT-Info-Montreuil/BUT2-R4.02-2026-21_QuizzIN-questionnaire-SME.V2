package universite_paris8.iut.qdev.tp2026.gr21.jeuQuizz.entities.dtos;

import java.util.List;
import java.util.Objects;

public class BibliothequeDTO {
    private int idBibliotheque; // [cite: 30]
    private String nomBibliotheque; // [cite: 31]
    private List<QuestionnaireDTO> listeQuestionnaire; // [cite: 32]

    public BibliothequeDTO() {}

    public BibliothequeDTO(int idBibliotheque, String nomBibliotheque, List<QuestionnaireDTO> listeQuestionnaire) {
        this.idBibliotheque = idBibliotheque;
        this.nomBibliotheque = nomBibliotheque;
        this.listeQuestionnaire = listeQuestionnaire;
    }

    // Getters et Setters
    public int getIdBibliotheque() { return idBibliotheque; }
    public void setIdBibliotheque(int idBibliotheque) { this.idBibliotheque = idBibliotheque; }

    public String getNomBibliotheque() { return nomBibliotheque; }
    public void setNomBibliotheque(String nomBibliotheque) { this.nomBibliotheque = nomBibliotheque; }

    public List<QuestionnaireDTO> getListeQuestionnaire() { return listeQuestionnaire; }
    public void setListeQuestionnaire(List<QuestionnaireDTO> listeQuestionnaire) { this.listeQuestionnaire = listeQuestionnaire; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BibliothequeDTO honesty = (BibliothequeDTO) o;
        return idBibliotheque == honesty.idBibliotheque &&
                Objects.equals(nomBibliotheque, honesty.nomBibliotheque) &&
                Objects.equals(listeQuestionnaire, honesty.listeQuestionnaire);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBibliotheque, nomBibliotheque, listeQuestionnaire);
    }

    @Override
    public String toString() {
        return "BibliothequeDTO{" +
                "idBibliotheque=" + idBibliotheque +
                ", nomBibliotheque='" + nomBibliotheque + '\'' +
                ", listeQuestionnaire=" + listeQuestionnaire +
                '}';
    }
}