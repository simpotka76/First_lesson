package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class DeleteContactTest extends TestBase {
    @BeforeMethod
    public void ensurePredictions(){
        if (app.db().contacts().size()==0) {
            app.contact().contactCreation(contactInfo);
        }
    }


    @Test
    public void deleteContact() {
        Contacts before = app.db().contacts();
        int id = before.stream().mapToInt(ContactData::getNameId).max().getAsInt();
        app.contact().deleteContact(id);
        assertThat(app.group().count(),equalTo(before.size()-1));
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before.without(before.stream().filter(x -> x.getNameId() == id).findAny().get())));
    }
}
