package by.bsuir.entity;


import java.util.Optional;

public class ConsonantPhoneme extends Phoneme {

    private Soft soft;

    private Optional<String> voicelessVariant;

    public ConsonantPhoneme(String letter, String phoneme, Soft soft, Optional<String> voicelessVariant) {
        super(letter, phoneme);
        this.soft = soft;
        this.voicelessVariant = voicelessVariant;
    }

    public Soft getSoft() {
        return soft;
    }

    public void setSoft(Soft soft) {
        this.soft = soft;
    }

    public Optional<String> getVoicelessVariant() {
        return voicelessVariant;
    }

    public void setVoicelessVariant(Optional<String> voicelessVariant) {
        this.voicelessVariant = voicelessVariant;
    }

    public enum Soft {
        SOFT, HARD, CAN_BE
    }
}

