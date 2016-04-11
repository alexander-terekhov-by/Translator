package by.bsuir;


import by.bsuir.entity.ConsonantPhoneme;
import by.bsuir.entity.Phoneme;
import by.bsuir.entity.VowelPhoneme;
import by.bsuir.repository.PhonemeRepository;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

public class Translator {

    private static PhonemeRepository phonemeRepository = new PhonemeRepository();


    public static void main(String[] args) {
        List<String> words = Arrays.asList("Зуб", "Сузор'е", "Яхант", "Шчаўе", "Каханне", "Дзьмухавец", "Суддзя", "Хата", "Бульба", "Каляды", "Кава", "Гаспадар", "Гаспадыня", "Журавіны", "Цыбуля", "Дзякуй", "Зорка", "Шлях", "Вавёрка", "Бусел", "Кумпяк", "Крывіч", "Настаўнік", "Мастацтва", "Мова");

        for (String word : words) {
            List<Phoneme> phonemes = splitToPhonemes(word);
            for (int i = phonemes.size() - 1; i >= 0; i--) {
                Phoneme computingPhoneme = phonemes.get(i);
                Set<String> softer = phonemeRepository.getSofter();
                if ((i != phonemes.size() - 1 && softer.contains(phonemes.get(i + 1).getLetter())) && canBeSoft(computingPhoneme)) {
                    makeSoft((ConsonantPhoneme) computingPhoneme);
                }
                Set<String> j = phonemeRepository.getJat();
                if (canBeJ(computingPhoneme) && (i == 0 || j.contains(phonemes.get(i - 1).getLetter()))) {
                    makeJ(computingPhoneme);
                }

                if (canBeLowVoice(computingPhoneme) && (i == phonemes.size() - 1)) {
                    makeLowVoice((ConsonantPhoneme) computingPhoneme);
                }
            }
            System.out.println(phonemes);

        }
    }

    public static List<Phoneme> splitToPhonemes(String word) {
        word = word.toUpperCase();
        List<Phoneme> phonemes = phonemeRepository.getAll();
        Map<Integer, Phoneme> res = new HashMap<>();
        for (Phoneme phoneme : phonemes) {
            String letter = phoneme.getLetter();
            while (word.contains(letter)) {
                Phoneme toPutting = phoneme.copy();
                if (phoneme instanceof VowelPhoneme) {
                    if (word.charAt(word.indexOf(letter) + 1) == '+') {
                        ((VowelPhoneme)toPutting).setStress(VowelPhoneme.Stress.STRESSED);
                    } else if (word.charAt(word.indexOf(letter) + 1) == '=') {
                        ((VowelPhoneme)toPutting).setStress(VowelPhoneme.Stress.HALF_STRESSED);
                    } else {
                        ((VowelPhoneme)toPutting).setStress(VowelPhoneme.Stress.NOT);
                    }
                }
                res.put(word.indexOf(letter), toPutting);
                word = word.replaceFirst(letter, StringUtils.repeat("*", letter.length()));
            }
        }
        return res.entrySet().stream()
                .sorted((e1, e2) -> e1.getKey() - e2.getKey())
                .map(Map.Entry::getValue).collect(Collectors.toList());
    }

    private static void makeSoft(ConsonantPhoneme phoneme) {
        phoneme.setPhoneme(phoneme.getPhoneme() + "'");
    }

    private static void makeJ(Phoneme phoneme) {
        phoneme.setPhoneme("J" + phoneme.getPhoneme());
    }

    private static void makeLowVoice(ConsonantPhoneme phoneme) {
        phoneme.setPhoneme(phoneme.getVoicelessVariant().get());
    }

    private static boolean canBeSoft(Phoneme phoneme) {
        return phoneme instanceof ConsonantPhoneme && ((ConsonantPhoneme) phoneme).getSoft() == ConsonantPhoneme.Soft.CAN_BE;
    }

    private static boolean canBeJ(Phoneme phoneme) {
        return phoneme instanceof VowelPhoneme && ((VowelPhoneme) phoneme).isjAddable();
    }

    private static boolean canBeLowVoice(Phoneme phoneme) {
        return phoneme instanceof ConsonantPhoneme && ((ConsonantPhoneme) phoneme).getVoicelessVariant().isPresent();
    }


}
