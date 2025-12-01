package com.greenvest.repo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.greenvest.model.Credit;
import com.greenvest.model.SustainabilityAction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class JsonRepository {

    private static final Path FILE_PATH = Path.of("greenvest_data.json");
    private final ObjectMapper mapper = new ObjectMapper();

    // SAME as InMemoryRepository
    private List<SustainabilityAction> actions = new ArrayList<>();
    private List<Credit> credits = new ArrayList<>();

    public JsonRepository() {
        load();
    }

    // ---------- ACTIONS ----------
    public void addAction(SustainabilityAction action) {
        actions.add(action);
        save();
    }

    public List<SustainabilityAction> getActions() {
        return actions;
    }

    public SustainabilityAction findActionById(String id) {
        for (SustainabilityAction a : actions) {
            if (a.getId().equals(id)) return a;
        }
        return null;
    }

    // ---------- CREDITS ----------
    public void addCredit(Credit credit) {
        credits.add(credit);
        save();
    }

    public List<Credit> getAllCredits() {
        return credits;
    }

    // ---------- JSON SAVE / LOAD ----------
    private void save() {
        try {
            DataWrapper wrapper = new DataWrapper(actions, credits);
            mapper.writerWithDefaultPrettyPrinter().writeValue(FILE_PATH.toFile(), wrapper);
        } catch (Exception e) {
            System.out.println("Error saving JSON: " + e.getMessage());
        }
    }

    private void load() {
        if (!Files.exists(FILE_PATH)) return;
        try {
            DataWrapper wrapper = mapper.readValue(FILE_PATH.toFile(), new TypeReference<DataWrapper>() {});
            if (wrapper.actions != null) actions = wrapper.actions;
            if (wrapper.credits != null) credits = wrapper.credits;
        } catch (IOException e) {
            System.out.println("Error loading JSON: " + e.getMessage());
        }
    }

    // wrapper class
    public static class DataWrapper {
        public List<SustainabilityAction> actions;
        public List<Credit> credits;

        public DataWrapper() {}
        public DataWrapper(List<SustainabilityAction> actions, List<Credit> credits) {
            this.actions = actions;
            this.credits = credits;
        }
    }
}

