package edu.school21.preprocessor;

public class PreProcessorToLower implements PreProcessor {
    @Override
    public String execute(String text) {
        return text.toLowerCase();
    }
}
