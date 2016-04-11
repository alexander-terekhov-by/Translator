package by.bsuir.entity;


import org.apache.commons.lang3.builder.ToStringBuilder;

public class VowelPhoneme extends Phoneme{

    private boolean jAddable;

    private Stress stress;

    public VowelPhoneme(String letter, String phoneme, boolean jAddable) {
        super(letter, phoneme);
        this.jAddable = jAddable;
    }

    public boolean isjAddable() {
        return jAddable;
    }

    public void setjAddable(boolean jAddable) {
        this.jAddable = jAddable;
    }

    public Stress getStress() {
        return stress;
    }

    public void setStress(Stress stress) {
        this.stress = stress;
    }

    public enum Stress {
        NOT("0"), STRESSED("2"), HALF_STRESSED("1");

        private String literal;

        private Stress(String literal) {
            this.literal = literal;
        }
    }

    @Override
    public String toString() {
        return getPhoneme() + stress.literal;
    }
}
