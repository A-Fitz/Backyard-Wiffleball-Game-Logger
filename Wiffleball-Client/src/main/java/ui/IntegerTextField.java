package ui;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.TextField;

import java.util.regex.Pattern;

/**
 * @author Artem Labazin <xxlabaza@gmail.com>
 * @since 27.04.2016
 * https://github.com/xxlabaza/javafx-table/blob/master/src/main/java/ru/xxlabaza/javafx/table/IntegerTextField.java
 */
public class IntegerTextField extends TextField {

    private static final Pattern INTEGER_PATTERN;

    static {
        INTEGER_PATTERN = Pattern.compile("\\d+");
    }

    private final IntegerProperty valueProperty;
    {
        valueProperty = new SimpleIntegerProperty();
        textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == null || newValue.isEmpty())
                valueProperty.setValue(0);
            else
                valueProperty.setValue(Integer.parseInt(newValue));
        });
    }

    public IntegerTextField() {
    }

    public IntegerTextField(String text) {
        super(text);
        setValue(Integer.parseInt(text));
    }

    public void increment() {
        Integer currentValue = getValue();
        setValue(currentValue + 1);
    }

    public void decriment() {
        Integer currentValue = getValue();
        setValue(currentValue - 1);
    }

    public Integer getValue() {
        return valueProperty.getValue();
    }

    public void setValue(Integer value) {
        setText(value.toString());
        valueProperty.setValue(value);
    }

    public IntegerProperty valueProperty() {
        return valueProperty;
    }

    @Override
    public void replaceSelection(String replacement) {
        if (isValidValue(replacement)) {
            super.replaceSelection(replacement);
        }
    }

    @Override
    public void replaceText(int start, int end, String text) {
        if (isValidValue(text)) {
            super.replaceText(start, end, text);
        }
    }

    private boolean isValidValue(String text) {
        return text.isEmpty() || INTEGER_PATTERN.matcher(text).matches();
    }
}

