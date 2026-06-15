package universite_paris8.iut.qdev.tp2026.gr21.jeuQuizz.entities.dtos;


import universite_paris8.iut.qdev.tp2026.gr21.jeuQuizz.utils.enums.DifficulteEnum;
import universite_paris8.iut.qdev.tp2026.gr21.jeuQuizz.utils.enums.LangueEnum;

import java.util.Objects;

public class QuestionDTO {
    private int numQuestion;
    private String libelleQuestion;
    private String reponse;
    private int difficulte;
    private String explication;
    private String reference;
    private LangueEnum langue;
    private DifficulteEnum niveau;
    private int nbFoisPosees = 0;
    private int nbFoisReussiees = 0;

    public QuestionDTO() {}

    public QuestionDTO(int numQuestion, String libelleQuestion, String reponse, int difficulte,
                       String explication, String reference, LangueEnum langue, DifficulteEnum niveau) {
        this.numQuestion = numQuestion;
        this.libelleQuestion = libelleQuestion;
        this.reponse = reponse;
        this.difficulte = difficulte;
        this.explication = explication;
        this.reference = reference;
        this.langue = langue;
        this.niveau = niveau;
    }

    // Getters et Setters
    public int getNumQuestion() { return numQuestion; }
    public void setNumQuestion(int numQuestion) { this.numQuestion = numQuestion; }

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

    public LangueEnum getLangue() { return langue; }
    public void setLangue(LangueEnum langue) { this.langue = langue; }

    public DifficulteEnum getNiveau() { return niveau; }
    public void setNiveau(DifficulteEnum niveau) { this.niveau = niveau; }

    public int getNbFoisReussiees() {
        return nbFoisReussiees;
    }

    public int getNbFoisPosees() {
        return nbFoisPosees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionDTO that = (QuestionDTO) o;
        return numQuestion == that.numQuestion &&
                difficulte == that.difficulte &&
                Objects.equals(libelleQuestion, that.libelleQuestion) &&
                Objects.equals(reponse, that.reponse) &&
                Objects.equals(explication, that.explication) &&
                Objects.equals(reference, that.reference) &&
                langue == that.langue &&
                niveau == that.niveau;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numQuestion, libelleQuestion, reponse, difficulte, explication, reference, langue, niveau);
    }

    @Override
    public String toString() {
        return "QuestionDTO{" +
                "numQuestion=" + numQuestion +
                ", libelleQuestion='" + libelleQuestion + '\'' +
                ", reponse='" + reponse + '\'' +
                ", difficulte=" + difficulte +
                ", explication='" + explication + '\'' +
                ", reference='" + reference + '\'' +
                ", langue=" + langue +
                ", niveau=" + niveau +
                '}';
    }
}