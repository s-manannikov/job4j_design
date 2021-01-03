package ru.job4j.gc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SoftCache {
    Map<String, SoftReference<List<String>>> softCache = new HashMap<>();
    private final String folder;

    public SoftCache(final String folder) {
        this.folder = folder;
    }

    public List<String> read(String file) {
        List<String> rsl = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(this.folder + file))) {
            rsl = in.lines().collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }

    public List<String> add(String file) {
        List<String> rsl = read(file);
        if (rsl != null) {
            SoftReference<List<String>> softFile = new SoftReference<>(rsl);
            softCache.put(file, softFile);
        }
        return rsl;
    }

    public List<String> get(String key) {
        List<String> rsl;
        if (softCache.containsKey(key)) {
            rsl = softCache.get(key).get();
            if (rsl == null) {
                rsl = add(key);
            }
        } else {
            rsl = add(key);
        }
        return rsl;
    }
}