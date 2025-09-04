package com.bertmorris.event_management.contact.util;

import org.springframework.test.util.ReflectionTestUtils;

import com.bertmorris.event_management.contact.Contact;

public class ContactTestBuilder {
   
    private Long id;
    private String name;
    private String emailAddress;
    private String company;

    public static ContactTestBuilder aContact() {
        return new ContactTestBuilder()
            .withId(1L)
            .withName("name")
            .withEmailAddress("contact@email.com")
            .withCompany("company");
    }

    public Contact build() {
        Contact contact = new Contact();
        ReflectionTestUtils.setField(contact, "id", this.id);
        contact.setName(this.name);
        contact.setEmailAddress(this.emailAddress);
        contact.setCompany(this.company);
        
        return contact;
    }

    public ContactTestBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public ContactTestBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public ContactTestBuilder withEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public ContactTestBuilder withCompany(String company) {
        this.company = company;
        return this;
    }
}
