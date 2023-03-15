package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {

    public static double averageScore(List<Pupil> pupils) {
        double sum = 0D;
        int i = 0;
        for (Pupil p : pupils) {
            List<Subject> list = p.subjects();
            for (Subject s : list) {
                sum += s.score();
                i++;
            }
        }
        return sum / i;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> labelList = new ArrayList<>();
        for (Pupil p : pupils) {
            List<Subject> list = p.subjects();
            double sum = 0D;
            int i = 0;
            for (Subject s : list) {
                sum += s.score();
                i++;
            }
            labelList.add(new Label(p.name(), sum / i));
        }
        return labelList;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> labelList = new ArrayList<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil p : pupils) {
            List<Subject> list = p.subjects();
            for (Subject s : list) {
                map.put(s.name(), map.getOrDefault(s.name(), 0) + s.score());
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            labelList.add(new Label(entry.getKey(), entry.getValue() / pupils.size()));
        }
        return labelList;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        for (Pupil p : pupils) {
            List<Subject> list = p.subjects();
            int sum = 0;
            for (Subject s : list) {
                sum += s.score();
            }
            rsl.add(new Label(p.name(), sum));
        }
        rsl.sort(Comparator.naturalOrder());
        return rsl.get(rsl.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> labelList = new ArrayList<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil p : pupils) {
            List<Subject> list = p.subjects();
            for (Subject s : list) {
                if (!map.containsKey(s.name())) {
                    map.put(s.name(), s.score());
                } else {
                    map.put(s.name(), map.get(s.name()) + s.score());
                }
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            labelList.add(new Label(entry.getKey(), entry.getValue()));
        }
        labelList.sort(Comparator.naturalOrder());
        return labelList.get(labelList.size() - 1);
    }
}
