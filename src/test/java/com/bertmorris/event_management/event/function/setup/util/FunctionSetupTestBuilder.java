package com.bertmorris.event_management.event.function.setup.util;

import org.springframework.test.util.ReflectionTestUtils;

import com.bertmorris.event_management.event.function.setup.FunctionSetup;

public class FunctionSetupTestBuilder {
    
    private Long id;
    private String title;

    public static FunctionSetupTestBuilder aFunctionSetup() {
        return new FunctionSetupTestBuilder()
            .withId(1L)
            .withTitle("setup");
    }

    public FunctionSetup build() {
        FunctionSetup functionSetup = new FunctionSetup();
        ReflectionTestUtils.setField(functionSetup, "id", this.id);
        functionSetup.setTitle(this.title);
        
        return functionSetup;
    }

    public FunctionSetupTestBuilder withId(Long id) {
        this.id = id;
        return this;
    }
    
    public FunctionSetupTestBuilder withTitle(String title) {
        this.title = title;
        return this;
    }
}
