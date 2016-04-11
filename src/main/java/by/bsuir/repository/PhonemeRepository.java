package by.bsuir.repository;


import by.bsuir.entity.ConsonantPhoneme;
import by.bsuir.entity.Phoneme;
import by.bsuir.entity.VowelPhoneme;

import java.util.*;
import java.util.stream.Collectors;

public class PhonemeRepository {
    private List<Phoneme> phonemes;

    public PhonemeRepository() {
        createList();
    }


    public List<Phoneme> getAll() {
        return new ArrayList<>(phonemes);
    }

    public List<Phoneme> getAllVowel() {
        return new ArrayList<>(phonemes.stream().filter(p -> p instanceof VowelPhoneme).collect(Collectors.toList()));
    }


    public Optional<Phoneme> getByLetter(String letter) {
        return phonemes.stream().filter(p -> p.getLetter().equals(letter)).findFirst();
    }

    public Set<String> getSofter() {
        return new HashSet<>(Arrays.asList("Ь", "Я", "Ю", "Е", "Ё", "І"));
    }

    public Set<String> getJat() {
        return new HashSet<>(Arrays.asList("#", "'", "А", "Ў", "А", "О", "У", "Э", "Ы", "Я", "Ю", "Е", "Ё", "І"));
    }


    private void createList() {
        List<Phoneme> unsortedPhonemes = new ArrayList<>();
        unsortedPhonemes.add(new VowelPhoneme("А", "A", false));
        unsortedPhonemes.add(new VowelPhoneme("І", "I", false));
        unsortedPhonemes.add(new VowelPhoneme("О", "O", false));
        unsortedPhonemes.add(new VowelPhoneme("У", "U", false));
        unsortedPhonemes.add(new VowelPhoneme("Э", "E", false));
        unsortedPhonemes.add(new VowelPhoneme("Ы", "Y", false));
        unsortedPhonemes.add(new VowelPhoneme("Е", "E", true));
        unsortedPhonemes.add(new VowelPhoneme("Ё", "O", true));
        unsortedPhonemes.add(new VowelPhoneme("Ю", "U", true));
        unsortedPhonemes.add(new VowelPhoneme("Я", "A", true));
        unsortedPhonemes.add(new ConsonantPhoneme("В", "V", ConsonantPhoneme.Soft.CAN_BE, Optional.empty()));
        unsortedPhonemes.add(new ConsonantPhoneme("ДДЗ", "DD'Z'", ConsonantPhoneme.Soft.SOFT, Optional.empty()));
        unsortedPhonemes.add(new ConsonantPhoneme("ЖЖ", "ZHZH", ConsonantPhoneme.Soft.HARD, Optional.empty()));
        unsortedPhonemes.add(new ConsonantPhoneme("ЗЗ", "ZZ", ConsonantPhoneme.Soft.CAN_BE, Optional.empty()));
        unsortedPhonemes.add(new ConsonantPhoneme("Й", "J'", ConsonantPhoneme.Soft.SOFT, Optional.empty()));
        unsortedPhonemes.add(new ConsonantPhoneme("К", "K", ConsonantPhoneme.Soft.CAN_BE, Optional.empty()));
        unsortedPhonemes.add(new ConsonantPhoneme("Л", "L", ConsonantPhoneme.Soft.CAN_BE, Optional.empty()));
        unsortedPhonemes.add(new ConsonantPhoneme("ЛЛ", "LL", ConsonantPhoneme.Soft.CAN_BE, Optional.empty()));
        unsortedPhonemes.add(new ConsonantPhoneme("М", "M", ConsonantPhoneme.Soft.CAN_BE, Optional.empty()));
        unsortedPhonemes.add(new ConsonantPhoneme("Н", "N", ConsonantPhoneme.Soft.CAN_BE, Optional.empty()));
        unsortedPhonemes.add(new ConsonantPhoneme("НН", "NN", ConsonantPhoneme.Soft.CAN_BE, Optional.empty()));
        unsortedPhonemes.add(new ConsonantPhoneme("П", "P", ConsonantPhoneme.Soft.CAN_BE, Optional.empty()));
        unsortedPhonemes.add(new ConsonantPhoneme("Р", "R", ConsonantPhoneme.Soft.HARD, Optional.empty()));
        unsortedPhonemes.add(new ConsonantPhoneme("СС", "SS", ConsonantPhoneme.Soft.CAN_BE, Optional.empty()));
        unsortedPhonemes.add(new ConsonantPhoneme("С", "S", ConsonantPhoneme.Soft.CAN_BE, Optional.empty()));
        unsortedPhonemes.add(new ConsonantPhoneme("Т", "T", ConsonantPhoneme.Soft.HARD, Optional.empty()));
        unsortedPhonemes.add(new ConsonantPhoneme("Ў", "W", ConsonantPhoneme.Soft.HARD, Optional.empty()));
        unsortedPhonemes.add(new ConsonantPhoneme("Ф", "F", ConsonantPhoneme.Soft.CAN_BE, Optional.empty()));
        unsortedPhonemes.add(new ConsonantPhoneme("Х", "H", ConsonantPhoneme.Soft.CAN_BE, Optional.empty()));
        unsortedPhonemes.add(new ConsonantPhoneme("Ц", "C", ConsonantPhoneme.Soft.CAN_BE, Optional.empty()));
        unsortedPhonemes.add(new ConsonantPhoneme("ЦЦ", "CC", ConsonantPhoneme.Soft.CAN_BE, Optional.empty()));
        unsortedPhonemes.add(new ConsonantPhoneme("Ч", "CH", ConsonantPhoneme.Soft.HARD, Optional.empty()));
        unsortedPhonemes.add(new ConsonantPhoneme("ЧЧ", "CHCH", ConsonantPhoneme.Soft.HARD, Optional.empty()));
        unsortedPhonemes.add(new ConsonantPhoneme("Ш", "SH", ConsonantPhoneme.Soft.HARD, Optional.empty()));
        unsortedPhonemes.add(new ConsonantPhoneme("ШЧ", "SH", ConsonantPhoneme.Soft.HARD, Optional.empty()));

        unsortedPhonemes.add(new ConsonantPhoneme("Б", "B", ConsonantPhoneme.Soft.CAN_BE, Optional.of("P")));
        unsortedPhonemes.add(new ConsonantPhoneme("Г", "G", ConsonantPhoneme.Soft.CAN_BE, Optional.of("H")));
        unsortedPhonemes.add(new ConsonantPhoneme("Д", "D", ConsonantPhoneme.Soft.HARD, Optional.of("Т")));
        unsortedPhonemes.add(new ConsonantPhoneme("ДЖ", "DZH", ConsonantPhoneme.Soft.SOFT, Optional.of("CH")));
        unsortedPhonemes.add(new ConsonantPhoneme("ДЗ", "DZ'", ConsonantPhoneme.Soft.HARD, Optional.of("C")));
        unsortedPhonemes.add(new ConsonantPhoneme("Ж", "ZH", ConsonantPhoneme.Soft.HARD, Optional.of("SH")));
        unsortedPhonemes.add(new ConsonantPhoneme("З", "Z", ConsonantPhoneme.Soft.CAN_BE, Optional.of("S")));
        unsortedPhonemes.add(new Phoneme("Ь", ""));
        unsortedPhonemes.add(new Phoneme("'", ""));

        phonemes = unsortedPhonemes.stream()
                .sorted((p1, p2) -> p2.getLetter().length() - p1.getLetter().length())
                .collect(Collectors.toList());
    }
}
        
        
        
        

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        