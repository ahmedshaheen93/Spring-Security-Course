package com.shaheen.exception;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditorSupport;

@ControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(BaseException.class)
    public String handleApplicationException(BaseException ex, Model model) {
        model.addAttribute("message", ex.getMessage());
        model.addAttribute("error", ex.getHttpStatus());
        return "error";
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
        dataBinder.registerCustomEditor(Number.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String str) {
                boolean check = str.matches("\\d+\\.?(\\d+)?");
                if (str.equals("") || !check)
                    setValue(0);
                else
                    setValue(Double.parseDouble(str));
            }
        });
    }
}
