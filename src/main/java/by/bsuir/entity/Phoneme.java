package by.bsuir.entity;


public class Phoneme implements Cloneable {
    private String letter;
    private String phoneme;

    public Phoneme(String letter, String phoneme) {
        this.letter = letter;
        this.phoneme = phoneme;
    }

    public Phoneme copy() {
        Phoneme copy = null;
        try {
            copy = this.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return copy;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public String getPhoneme() {
        return phoneme;
    }

    public void setPhoneme(String phoneme) {
        this.phoneme = phoneme;
    }

    @Override
    public String toString() {
        return phoneme;
    }

    @Override
    protected Phoneme clone() throws CloneNotSupportedException {
        return (Phoneme) super.clone();
    }

}
