package com.bertmorris.event_management.event.function.type.util;

import org.springframework.test.util.ReflectionTestUtils;

import com.bertmorris.event_management.event.function.type.FunctionType;

public class FunctionTypeTestBuilder {
    
    private Long id;
    private String title;

    public static FunctionTypeTestBuilder aFunctionType() {
        return new FunctionTypeTestBuilder()
            .withId(1L)
            .withTitle("type");
    }

    public FunctionType build() {
        FunctionType functionType = new FunctionType();
        ReflectionTestUtils.setField(functionType, "id", this.id);
        functionType.setTitle(this.title);
        
        return functionType;
    }

    public FunctionTypeTestBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public FunctionTypeTestBuilder withTitle(String title) {
        this.title = title;
        return this;
    }
}
